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
    private ShutDownValidateTipView bKe;
    private c.b bKg;
    private int bKh;
    private RelativeLayout bKj;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ImMessageCenterModel bJY = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> bJZ = null;
    private ImMessageCenterShowItemData bKa = null;
    private BdListView bKb = null;
    private ImMessageCenterListAdapter bKc = null;
    private r bKd = null;
    com.baidu.tbadk.core.dialog.c bKf = null;
    private boolean bKi = true;
    private final CustomMessageListener aFV = new f(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener mItemClickListener = new h(this);
    private final AdapterView.OnItemLongClickListener bKk = new j(this);
    private final p.a aHc = new k(this);
    private final CustomMessageListener bue = new l(this, 0);
    private com.baidu.tieba.im.chat.notify.a buf = new m(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bKh = 3;
        this.bJZ = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(i.g.chat_list_activity, viewGroup, false);
        x(inflate);
        TiebaStatic.eventStat(this.bJZ.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.bue);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.bue);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.bue);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.bue);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.bue);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.bue);
        registerListener(this.aFV);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bKc != null) {
            this.bKc.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.bJZ.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.bue);
    }

    private void initData() {
        this.bJY = new ImMessageCenterModel();
        dw(com.baidu.tbadk.core.sharedPref.b.tr().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void x(View view) {
        this.bKj = (RelativeLayout) view.findViewById(i.f.chat_list);
        this.bKe = (ShutDownValidateTipView) view.findViewById(i.f.view_no_validate);
        this.bKe.setVisibility(8);
        this.bKe.setShutDownClickListener(new n(this));
        this.bKb = (BdListView) view.findViewById(i.f.chat_list_content);
        this.bKb.setDividerHeight(0);
        this.bKd = new r(getPageContext());
        this.bKd.a(this.aHc);
        this.bKd.setTag(getUniqueId());
        this.bKb.setPullRefresh(this.bKd);
        this.bKc = new ImMessageCenterListAdapter(this.bJZ.getPageContext().getPageActivity());
        this.bKc.g(this);
        this.bKb.setAdapter((ListAdapter) this.bKc);
        this.bKb.setOnItemClickListener(this.mItemClickListener);
        this.bKb.setOnItemLongClickListener(this.bKk);
        this.bKb.nw();
        this.mNoNetworkView = (NoNetworkView) this.bKj.findViewById(i.f.view_no_network);
        if (!this.mIsLogin) {
            dv(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.bKh != i) {
            this.bKh = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.bJZ.getPageContext(), i);
            }
            if (this.bKe != null) {
                this.bKe.onChangeSkinType(i);
            }
            if (this.bKd != null) {
                this.bKd.cN(i);
            }
            if (this.bKc != null) {
                this.bKc.notifyDataSetChanged();
            }
            if (this.bJZ != null && (this.bJZ instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.bJZ).getLayoutMode().ad(i == 1);
                ((BaseFragmentActivity) this.bJZ).getLayoutMode().k(this.bKj);
            }
            if (this.mNoNetworkView != null) {
                this.mNoNetworkView.onChangeSkinType(this.bJZ.getPageContext(), i);
            }
        }
    }

    private void XK() {
        if (isAdded()) {
            if (this.mIsLogin) {
                XL();
            } else {
                XM();
            }
        }
    }

    private void XL() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(i.h.maintab_imcenter_button_text), new o(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.bJZ.getPageContext().getPageActivity(), this.bKj, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(i.d.ds80)), NoDataViewFactory.d.cK(i.h.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void XM() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(i.h.maintab_imcenter_unlogin_button_text), new p(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(i.d.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(i.d.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(i.d.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.bJZ.getPageContext().getPageActivity(), this.bKj, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, i.e.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(i.h.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(i.d.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        XK();
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
        this.bKg = new g(this, imMessageCenterShowItemData);
        String string = this.bJZ.getPageContext().getPageActivity().getString(i.h.delete_user_chat);
        this.bKf = new com.baidu.tbadk.core.dialog.c(this.bJZ.getPageContext().getPageActivity());
        this.bKf.bI(i.h.operation);
        this.bKf.a(new String[]{string}, this.bKg);
        this.bKf.d(this.bJZ.getPageContext());
    }

    public void du(boolean z) {
        if (z) {
            if (XN() && this.bKe.getVisibility() != 0) {
                this.bKe.setVisibility(0);
            }
        } else if (this.bKe.getVisibility() != 8) {
            this.bKe.setVisibility(8);
        }
    }

    public void dv(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                XK();
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

    public boolean XN() {
        return this.bKi;
    }

    public void dw(boolean z) {
        this.bKi = z;
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
                if (this.bJY != null) {
                    this.bJY.insertOrUpdate(data, this.buf);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.bJY != null) {
                this.bJY.remove(data, this.buf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.bJY != null) {
                this.bJY.setData(data, this.buf);
            }
        }
    }
}
