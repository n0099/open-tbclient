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
    private c.b bKB;
    private int bKC;
    private RelativeLayout bKE;
    private ShutDownValidateTipView bKz;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ImMessageCenterModel bKt = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> bKu = null;
    private ImMessageCenterShowItemData bKv = null;
    private BdListView bKw = null;
    private ImMessageCenterListAdapter bKx = null;
    private r bKy = null;
    com.baidu.tbadk.core.dialog.c bKA = null;
    private boolean bKD = true;
    private final CustomMessageListener aEP = new f(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener mItemClickListener = new h(this);
    private final AdapterView.OnItemLongClickListener bKF = new j(this);
    private final p.a aFW = new k(this);
    private final CustomMessageListener buE = new l(this, 0);
    private com.baidu.tieba.im.chat.notify.a buF = new m(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bKC = 3;
        this.bKu = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(i.g.chat_list_activity, viewGroup, false);
        y(inflate);
        TiebaStatic.eventStat(this.bKu.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.buE);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.buE);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.buE);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.buE);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.buE);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.buE);
        registerListener(this.aEP);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bKx != null) {
            this.bKx.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.bKu.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.buE);
    }

    private void initData() {
        this.bKt = new ImMessageCenterModel();
        dy(com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void y(View view) {
        this.bKE = (RelativeLayout) view.findViewById(i.f.chat_list);
        this.bKz = (ShutDownValidateTipView) view.findViewById(i.f.view_no_validate);
        this.bKz.setVisibility(8);
        this.bKz.setShutDownClickListener(new n(this));
        this.bKw = (BdListView) view.findViewById(i.f.chat_list_content);
        this.bKw.setDividerHeight(0);
        this.bKy = new r(getPageContext());
        this.bKy.a(this.aFW);
        this.bKy.setTag(getUniqueId());
        this.bKw.setPullRefresh(this.bKy);
        this.bKx = new ImMessageCenterListAdapter(this.bKu.getPageContext().getPageActivity());
        this.bKx.g(this);
        this.bKw.setAdapter((ListAdapter) this.bKx);
        this.bKw.setOnItemClickListener(this.mItemClickListener);
        this.bKw.setOnItemLongClickListener(this.bKF);
        this.bKw.nx();
        this.mNoNetworkView = (NoNetworkView) this.bKE.findViewById(i.f.view_no_network);
        if (!this.mIsLogin) {
            dx(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.bKC != i) {
            this.bKC = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.bKu.getPageContext(), i);
            }
            if (this.bKz != null) {
                this.bKz.onChangeSkinType(i);
            }
            if (this.bKy != null) {
                this.bKy.cN(i);
            }
            if (this.bKx != null) {
                this.bKx.notifyDataSetChanged();
            }
            if (this.bKu != null && (this.bKu instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.bKu).getLayoutMode().ad(i == 1);
                ((BaseFragmentActivity) this.bKu).getLayoutMode().k(this.bKE);
            }
            if (this.mNoNetworkView != null) {
                this.mNoNetworkView.onChangeSkinType(this.bKu.getPageContext(), i);
            }
        }
    }

    private void Yf() {
        if (isAdded()) {
            if (this.mIsLogin) {
                Yg();
            } else {
                Yh();
            }
        }
    }

    private void Yg() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(i.h.maintab_imcenter_button_text), new o(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.bKu.getPageContext().getPageActivity(), this.bKE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(i.d.ds80)), NoDataViewFactory.d.cK(i.h.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void Yh() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(i.h.maintab_imcenter_unlogin_button_text), new p(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(i.d.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(i.d.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(i.d.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.bKu.getPageContext().getPageActivity(), this.bKE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, i.e.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(i.h.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(i.d.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        Yf();
        if (!z) {
            dx(true);
        } else {
            dx(false);
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
        this.bKB = new g(this, imMessageCenterShowItemData);
        String string = this.bKu.getPageContext().getPageActivity().getString(i.h.delete_user_chat);
        this.bKA = new com.baidu.tbadk.core.dialog.c(this.bKu.getPageContext().getPageActivity());
        this.bKA.bI(i.h.operation);
        this.bKA.a(new String[]{string}, this.bKB);
        this.bKA.d(this.bKu.getPageContext());
    }

    public void dw(boolean z) {
        if (z) {
            if (Yi() && this.bKz.getVisibility() != 0) {
                this.bKz.setVisibility(0);
            }
        } else if (this.bKz.getVisibility() != 8) {
            this.bKz.setVisibility(8);
        }
    }

    public void dx(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                Yf();
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

    public boolean Yi() {
        return this.bKD;
    }

    public void dy(boolean z) {
        this.bKD = z;
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
                if (this.bKt != null) {
                    this.bKt.insertOrUpdate(data, this.buF);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.bKt != null) {
                this.bKt.remove(data, this.buF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.bKt != null) {
                this.bKt.setData(data, this.buF);
            }
        }
    }
}
