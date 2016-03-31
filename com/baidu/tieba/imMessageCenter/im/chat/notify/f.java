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
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class f extends BaseFragment {
    private NoNetworkView NZ;
    private ShutDownValidateTipView csI;
    private c.b csK;
    private int csL;
    private RelativeLayout csN;
    private com.baidu.tbadk.core.view.p mNoDataView;
    private ImMessageCenterModel csC = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> csD = null;
    private ImMessageCenterShowItemData csE = null;
    private BdListView csF = null;
    private ImMessageCenterListAdapter csG = null;
    private t csH = null;
    com.baidu.tbadk.core.dialog.c csJ = null;
    private boolean csM = true;
    private final CustomMessageListener aNn = new g(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener csO = new i(this);
    private final AdapterView.OnItemLongClickListener csP = new k(this);
    private final s.a aOt = new l(this);
    private final CustomMessageListener cbJ = new m(this, 0);
    private com.baidu.tieba.im.chat.notify.a cbL = new n(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.csL = 3;
        this.csD = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(t.h.chat_list_activity, viewGroup, false);
        V(inflate);
        TiebaStatic.eventStat(this.csD.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cbJ);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cbJ);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cbJ);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cbJ);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cbJ);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cbJ);
        registerListener(this.aNn);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.csG != null) {
            this.csG.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.csD.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.cbJ);
    }

    private void initData() {
        this.csC = new ImMessageCenterModel();
        ew(com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void V(View view) {
        this.csN = (RelativeLayout) view.findViewById(t.g.chat_list);
        this.csI = (ShutDownValidateTipView) view.findViewById(t.g.view_no_validate);
        this.csI.setVisibility(8);
        this.csI.setShutDownClickListener(new o(this));
        this.csF = (BdListView) view.findViewById(t.g.chat_list_content);
        this.csF.setDividerHeight(0);
        this.csH = new t(getPageContext());
        this.csH.a(this.aOt);
        this.csH.setTag(getUniqueId());
        this.csF.setPullRefresh(this.csH);
        this.csG = new ImMessageCenterListAdapter(this.csD.getPageContext().getPageActivity());
        this.csF.setAdapter((ListAdapter) this.csG);
        this.csF.setOnItemClickListener(this.csO);
        this.csF.setOnItemLongClickListener(this.csP);
        this.csF.nk();
        this.NZ = (NoNetworkView) this.csN.findViewById(t.g.view_no_network);
        if (!this.mIsLogin) {
            ev(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.csL != i) {
            this.csL = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.csD.getPageContext(), i);
            }
            if (this.csI != null) {
                this.csI.onChangeSkinType(i);
            }
            if (this.csH != null) {
                this.csH.dj(i);
            }
            if (this.csG != null) {
                this.csG.notifyDataSetChanged();
            }
            if (this.csD != null && (this.csD instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.csD).getLayoutMode().ab(i == 1);
                ((BaseFragmentActivity) this.csD).getLayoutMode().x(this.csN);
            }
            if (this.NZ != null) {
                this.NZ.onChangeSkinType(this.csD.getPageContext(), i);
            }
        }
    }

    private void aiW() {
        if (isAdded()) {
            if (this.mIsLogin) {
                aiX();
            } else {
                aiY();
            }
        }
    }

    private void aiX() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(t.j.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.csD.getPageContext().getPageActivity(), this.csN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(t.e.ds80)), NoDataViewFactory.d.dg(t.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void aiY() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(t.j.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(t.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(t.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(t.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.csD.getPageContext().getPageActivity(), this.csN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, t.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.u(t.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(t.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        aiW();
        if (!z) {
            ev(true);
        } else {
            ev(false);
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
        this.csK = new h(this, imMessageCenterShowItemData);
        String string = this.csD.getPageContext().getPageActivity().getString(t.j.delete_user_chat);
        this.csJ = new com.baidu.tbadk.core.dialog.c(this.csD.getPageContext().getPageActivity());
        this.csJ.cd(t.j.operation);
        this.csJ.a(new String[]{string}, this.csK);
        this.csJ.d(this.csD.getPageContext());
    }

    public void eu(boolean z) {
        if (z) {
            if (aiZ() && this.csI.getVisibility() != 0) {
                this.csI.setVisibility(0);
            }
        } else if (this.csI.getVisibility() != 8) {
            this.csI.setVisibility(8);
        }
    }

    public void ev(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                aiW();
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

    public boolean aiZ() {
        return this.csM;
    }

    public void ew(boolean z) {
        this.csM = z;
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
                if (this.csC != null) {
                    this.csC.insertOrUpdate(data, this.cbL);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.csC != null) {
                this.csC.remove(data, this.cbL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.csC != null) {
                this.csC.setData(data, this.cbL);
            }
        }
    }
}
