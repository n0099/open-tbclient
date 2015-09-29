package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.p;
import com.baidu.tieba.i;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView;
import java.util.List;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private ShutDownValidateTipView bJT;
    private c.b bJV;
    private int bJW;
    private RelativeLayout bJY;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ImMessageCenterModel bJN = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> bJO = null;
    private ImMessageCenterShowItemData bJP = null;
    private BdListView bJQ = null;
    private ImMessageCenterListAdapter bJR = null;
    private r bJS = null;
    com.baidu.tbadk.core.dialog.c bJU = null;
    private boolean bJX = true;
    private final CustomMessageListener aFK = new f(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener mItemClickListener = new h(this);
    private final AdapterView.OnItemLongClickListener bJZ = new j(this);
    private final p.a aGR = new k(this);
    private final CustomMessageListener btT = new l(this, 0);
    private com.baidu.tieba.im.chat.notify.a btU = new m(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bJW = 3;
        this.bJO = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(i.g.chat_list_activity, viewGroup, false);
        x(inflate);
        TiebaStatic.eventStat(this.bJO.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.btT);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.btT);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.btT);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.btT);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.btT);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.btT);
        registerListener(this.aFK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bJR != null) {
            this.bJR.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.bJO.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.btT);
    }

    private void initData() {
        this.bJN = new ImMessageCenterModel();
        dw(com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void x(View view) {
        this.bJY = (RelativeLayout) view.findViewById(i.f.chat_list);
        this.bJT = (ShutDownValidateTipView) view.findViewById(i.f.view_no_validate);
        this.bJT.setVisibility(8);
        this.bJT.setShutDownClickListener(new n(this));
        this.bJQ = (BdListView) view.findViewById(i.f.chat_list_content);
        this.bJQ.setDividerHeight(0);
        this.bJS = new r(getPageContext());
        this.bJS.a(this.aGR);
        this.bJS.setTag(getUniqueId());
        this.bJQ.setPullRefresh(this.bJS);
        this.bJR = new ImMessageCenterListAdapter(this.bJO.getPageContext().getPageActivity());
        this.bJR.g(this);
        this.bJQ.setAdapter((ListAdapter) this.bJR);
        this.bJQ.setOnItemClickListener(this.mItemClickListener);
        this.bJQ.setOnItemLongClickListener(this.bJZ);
        this.bJQ.nw();
        this.mNoNetworkView = (NoNetworkView) this.bJY.findViewById(i.f.view_no_network);
        if (!this.mIsLogin) {
            dv(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.bJW != i) {
            this.bJW = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.bJO.getPageContext(), i);
            }
            if (this.bJT != null) {
                this.bJT.onChangeSkinType(i);
            }
            if (this.bJS != null) {
                this.bJS.cN(i);
            }
            if (this.bJR != null) {
                this.bJR.notifyDataSetChanged();
            }
            if (this.bJO != null && (this.bJO instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.bJO).getLayoutMode().ad(i == 1);
                ((BaseFragmentActivity) this.bJO).getLayoutMode().k(this.bJY);
            }
            if (this.mNoNetworkView != null) {
                this.mNoNetworkView.onChangeSkinType(this.bJO.getPageContext(), i);
            }
        }
    }

    private void XO() {
        if (isAdded()) {
            if (this.mIsLogin) {
                XP();
            } else {
                XQ();
            }
        }
    }

    private void XP() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(i.h.maintab_imcenter_button_text), new o(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.bJO.getPageContext().getPageActivity(), this.bJY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(i.d.ds80)), NoDataViewFactory.d.cK(i.h.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void XQ() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(i.h.maintab_imcenter_unlogin_button_text), new p(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(i.d.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(i.d.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(i.d.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.bJO.getPageContext().getPageActivity(), this.bJY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, i.e.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(i.h.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(i.d.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        XO();
        if (!z) {
            dv(true);
        } else {
            dv(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bJV = new g(this, imMessageCenterShowItemData);
        String string = this.bJO.getPageContext().getPageActivity().getString(i.h.delete_user_chat);
        this.bJU = new com.baidu.tbadk.core.dialog.c(this.bJO.getPageContext().getPageActivity());
        this.bJU.bI(i.h.operation);
        this.bJU.a(new String[]{string}, this.bJV);
        this.bJU.d(this.bJO.getPageContext());
    }

    public void du(boolean z) {
        if (z) {
            if (XR() && this.bJT.getVisibility() != 0) {
                this.bJT.setVisibility(0);
            }
        } else if (this.bJT.getVisibility() != 8) {
            this.bJT.setVisibility(8);
        }
    }

    public void dv(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                XO();
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(0);
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        if (!isAdded()) {
        }
    }

    public boolean XR() {
        return this.bJX;
    }

    public void dw(boolean z) {
        this.bJX = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                if (this.bJN != null) {
                    this.bJN.insertOrUpdate(data, this.btU);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.bJN != null) {
                this.bJN.remove(data, this.btU);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.bJN != null) {
                this.bJN.setData(data, this.btU);
            }
        }
    }
}
