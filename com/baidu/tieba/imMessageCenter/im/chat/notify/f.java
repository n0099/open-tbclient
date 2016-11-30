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
import com.baidu.tbadk.core.view.w;
import com.baidu.tbadk.core.view.z;
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
    private NoNetworkView Hk;
    private RelativeLayout bPO;
    private ShutDownValidateTipView duH;
    private c.b duJ;
    private int duK;
    private w mNoDataView;
    private ImMessageCenterModel duB = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> duC = null;
    private ImMessageCenterShowItemData duD = null;
    private BdListView duE = null;
    private ImMessageCenterListAdapter duF = null;
    private t duG = null;
    com.baidu.tbadk.core.dialog.c duI = null;
    private boolean duL = true;
    private final CustomMessageListener aWe = new g(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener duM = new i(this);
    private final AdapterView.OnItemLongClickListener duN = new k(this);
    private final z.b aXk = new l(this);
    private final CustomMessageListener ddn = new m(this, 0);
    private com.baidu.tieba.im.chat.notify.a ddp = new n(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.duK = 3;
        this.duC = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(r.h.chat_list_activity, viewGroup, false);
        aa(inflate);
        TiebaStatic.eventStat(this.duC.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.ddn);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.ddn);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.ddn);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.ddn);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.ddn);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.ddn);
        registerListener(this.aWe);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.duF != null) {
            this.duF.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.duC.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.ddn);
    }

    private void initData() {
        this.duB = new ImMessageCenterModel();
        gI(com.baidu.tbadk.core.sharedPref.b.um().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void aa(View view) {
        this.bPO = (RelativeLayout) view.findViewById(r.g.chat_list);
        this.duH = (ShutDownValidateTipView) view.findViewById(r.g.view_no_validate);
        this.duH.setVisibility(8);
        this.duH.setShutDownClickListener(new o(this));
        this.duE = (BdListView) view.findViewById(r.g.chat_list_content);
        this.duE.setDividerHeight(0);
        this.duG = new t(getPageContext());
        this.duG.a(this.aXk);
        this.duG.setTag(getUniqueId());
        this.duE.setPullRefresh(this.duG);
        this.duF = new ImMessageCenterListAdapter(this.duC.getPageContext().getPageActivity());
        this.duE.setAdapter((ListAdapter) this.duF);
        this.duE.setOnItemClickListener(this.duM);
        this.duE.setOnItemLongClickListener(this.duN);
        this.duE.kv();
        this.Hk = (NoNetworkView) this.bPO.findViewById(r.g.view_no_network);
        if (!this.mIsLogin) {
            gH(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.duK != i) {
            this.duK = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.duC.getPageContext(), i);
            }
            if (this.duH != null) {
                this.duH.onChangeSkinType(i);
            }
            if (this.duG != null) {
                this.duG.di(i);
            }
            if (this.duF != null) {
                this.duF.notifyDataSetChanged();
            }
            if (this.duC != null && (this.duC instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.duC).getLayoutMode().ai(i == 1);
                ((BaseFragmentActivity) this.duC).getLayoutMode().x(this.bPO);
            }
            if (this.Hk != null) {
                this.Hk.onChangeSkinType(this.duC.getPageContext(), i);
            }
        }
    }

    private void azp() {
        if (isAdded()) {
            if (this.mIsLogin) {
                azq();
            } else {
                azr();
            }
        }
    }

    private void azq() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(r.j.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.duC.getPageContext().getPageActivity(), this.bPO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(r.e.ds80)), NoDataViewFactory.d.df(r.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void azr() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(r.j.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(r.e.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(r.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(r.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(r.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.duC.getPageContext().getPageActivity(), this.bPO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, r.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.w(r.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(r.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        azp();
        if (!z) {
            gH(true);
        } else {
            gH(false);
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
        this.duJ = new h(this, imMessageCenterShowItemData);
        String string = this.duC.getPageContext().getPageActivity().getString(r.j.delete_user_chat);
        this.duI = new com.baidu.tbadk.core.dialog.c(this.duC.getPageContext().getPageActivity());
        this.duI.cd(r.j.operation);
        this.duI.a(new String[]{string}, this.duJ);
        this.duI.d(this.duC.getPageContext());
    }

    public void gG(boolean z) {
        if (z) {
            if (azs() && this.duH.getVisibility() != 0) {
                this.duH.setVisibility(0);
            }
        } else if (this.duH.getVisibility() != 8) {
            this.duH.setVisibility(8);
        }
    }

    public void gH(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                azp();
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

    public boolean azs() {
        return this.duL;
    }

    public void gI(boolean z) {
        this.duL = z;
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
                if (this.duB != null) {
                    this.duB.insertOrUpdate(data, this.ddp);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.duB != null) {
                this.duB.remove(data, this.ddp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.duB != null) {
                this.duB.setData(data, this.ddp);
            }
        }
    }
}
