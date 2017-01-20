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
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.x;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class f extends BaseFragment {
    private NoNetworkView Gt;
    private RelativeLayout bDx;
    private ShutDownValidateTipView dgR;
    private c.b dgT;
    private int dgU;
    private x mNoDataView;
    private ImMessageCenterModel dgL = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> dgM = null;
    private ImMessageCenterShowItemData dgN = null;
    private BdListView dgO = null;
    private ImMessageCenterListAdapter dgP = null;
    private t dgQ = null;
    com.baidu.tbadk.core.dialog.c dgS = null;
    private boolean dgV = true;
    private final CustomMessageListener aQV = new g(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener dgW = new i(this);
    private final AdapterView.OnItemLongClickListener dgX = new k(this);
    private final aa.b aSb = new l(this);
    private final CustomMessageListener cPq = new m(this, 0);
    private com.baidu.tieba.im.chat.a.a cPs = new n(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dgU = 3;
        this.dgM = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(r.j.chat_list_activity, viewGroup, false);
        af(inflate);
        TiebaStatic.eventStat(this.dgM.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cPq);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cPq);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cPq);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cPq);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cPq);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cPq);
        registerListener(this.aQV);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dgP != null) {
            this.dgP.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.dgM.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.cPq);
    }

    private void initData() {
        this.dgL = new ImMessageCenterModel();
        gv(com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void af(View view) {
        this.bDx = (RelativeLayout) view.findViewById(r.h.chat_list);
        this.dgR = (ShutDownValidateTipView) view.findViewById(r.h.view_no_validate);
        this.dgR.setVisibility(8);
        this.dgR.setShutDownClickListener(new o(this));
        this.dgO = (BdListView) view.findViewById(r.h.chat_list_content);
        this.dgO.setDividerHeight(0);
        this.dgQ = new t(getPageContext());
        this.dgQ.a(this.aSb);
        this.dgQ.setTag(getUniqueId());
        this.dgO.setPullRefresh(this.dgQ);
        this.dgP = new ImMessageCenterListAdapter(this.dgM.getPageContext().getPageActivity());
        this.dgO.setAdapter((ListAdapter) this.dgP);
        this.dgO.setOnItemClickListener(this.dgW);
        this.dgO.setOnItemLongClickListener(this.dgX);
        this.dgO.startPullRefresh();
        this.Gt = (NoNetworkView) this.bDx.findViewById(r.h.view_no_network);
        if (!this.mIsLogin) {
            gu(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.dgU != i) {
            this.dgU = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.dgM.getPageContext(), i);
            }
            if (this.dgR != null) {
                this.dgR.onChangeSkinType(i);
            }
            if (this.dgQ != null) {
                this.dgQ.dl(i);
            }
            if (this.dgP != null) {
                this.dgP.notifyDataSetChanged();
            }
            if (this.dgM != null && (this.dgM instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.dgM).getLayoutMode().ai(i == 1);
                ((BaseFragmentActivity) this.dgM).getLayoutMode().v(this.bDx);
            }
            if (this.Gt != null) {
                this.Gt.onChangeSkinType(this.dgM.getPageContext(), i);
            }
        }
    }

    private void auU() {
        if (isAdded()) {
            if (this.mIsLogin) {
                auV();
            } else {
                auW();
            }
        }
    }

    private void auV() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(r.l.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dgM.getPageContext().getPageActivity(), this.bDx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(r.f.ds80)), NoDataViewFactory.d.di(r.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void auW() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(r.l.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(r.f.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(r.f.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(r.f.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(r.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dgM.getPageContext().getPageActivity(), this.bDx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, r.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.x(r.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(r.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        auU();
        if (!z) {
            gu(true);
        } else {
            gu(false);
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
        this.dgT = new h(this, imMessageCenterShowItemData);
        String string = this.dgM.getPageContext().getPageActivity().getString(r.l.delete_user_chat);
        this.dgS = new com.baidu.tbadk.core.dialog.c(this.dgM.getPageContext().getPageActivity());
        this.dgS.cd(r.l.operation);
        this.dgS.a(new String[]{string}, this.dgT);
        this.dgS.d(this.dgM.getPageContext());
    }

    public void gt(boolean z) {
        if (z) {
            if (auX() && this.dgR.getVisibility() != 0) {
                this.dgR.setVisibility(0);
            }
        } else if (this.dgR.getVisibility() != 8) {
            this.dgR.setVisibility(8);
        }
    }

    public void gu(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                auU();
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

    public boolean auX() {
        return this.dgV;
    }

    public void gv(boolean z) {
        this.dgV = z;
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
                if (this.dgL != null) {
                    this.dgL.insertOrUpdate(data, this.cPs);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dgL != null) {
                this.dgL.remove(data, this.cPs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dgL != null) {
                this.dgL.setData(data, this.cPs);
            }
        }
    }
}
