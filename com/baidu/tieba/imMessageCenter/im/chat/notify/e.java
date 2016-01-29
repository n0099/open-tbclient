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
import com.baidu.tbadk.core.view.r;
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
public class e extends BaseFragment {
    private NoNetworkView NR;
    private ShutDownValidateTipView cic;
    private c.b cif;
    private int cig;
    private RelativeLayout cii;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private ImMessageCenterModel chW = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> chX = null;
    private ImMessageCenterShowItemData chY = null;
    private BdListView chZ = null;
    private ImMessageCenterListAdapter cia = null;
    private s cib = null;
    com.baidu.tbadk.core.dialog.c cie = null;
    private boolean cih = true;
    private final CustomMessageListener aKr = new f(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener cij = new h(this);
    private final AdapterView.OnItemLongClickListener cik = new j(this);
    private final r.a aLy = new k(this);
    private final CustomMessageListener bRp = new l(this, 0);
    private com.baidu.tieba.im.chat.notify.a bRq = new m(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cig = 3;
        this.chX = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(t.h.chat_list_activity, viewGroup, false);
        R(inflate);
        TiebaStatic.eventStat(this.chX.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.bRp);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.bRp);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.bRp);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.bRp);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.bRp);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.bRp);
        registerListener(this.aKr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cia != null) {
            this.cia.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.chX.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.bRp);
    }

    private void initData() {
        this.chW = new ImMessageCenterModel();
        ea(com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void R(View view) {
        this.cii = (RelativeLayout) view.findViewById(t.g.chat_list);
        this.cic = (ShutDownValidateTipView) view.findViewById(t.g.view_no_validate);
        this.cic.setVisibility(8);
        this.cic.setShutDownClickListener(new n(this));
        this.chZ = (BdListView) view.findViewById(t.g.chat_list_content);
        this.chZ.setDividerHeight(0);
        this.cib = new s(getPageContext());
        this.cib.a(this.aLy);
        this.cib.setTag(getUniqueId());
        this.chZ.setPullRefresh(this.cib);
        this.cia = new ImMessageCenterListAdapter(this.chX.getPageContext().getPageActivity());
        this.chZ.setAdapter((ListAdapter) this.cia);
        this.chZ.setOnItemClickListener(this.cij);
        this.chZ.setOnItemLongClickListener(this.cik);
        this.chZ.ns();
        this.NR = (NoNetworkView) this.cii.findViewById(t.g.view_no_network);
        if (!this.mIsLogin) {
            dZ(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.cig != i) {
            this.cig = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.chX.getPageContext(), i);
            }
            if (this.cic != null) {
                this.cic.onChangeSkinType(i);
            }
            if (this.cib != null) {
                this.cib.dg(i);
            }
            if (this.cia != null) {
                this.cia.notifyDataSetChanged();
            }
            if (this.chX != null && (this.chX instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.chX).getLayoutMode().ac(i == 1);
                ((BaseFragmentActivity) this.chX).getLayoutMode().x(this.cii);
            }
            if (this.NR != null) {
                this.NR.onChangeSkinType(this.chX.getPageContext(), i);
            }
        }
    }

    private void afC() {
        if (isAdded()) {
            if (this.mIsLogin) {
                afD();
            } else {
                afE();
            }
        }
    }

    private void afD() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(t.j.maintab_imcenter_button_text), new o(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.chX.getPageContext().getPageActivity(), this.cii, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(t.e.ds80)), NoDataViewFactory.d.dd(t.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void afE() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(t.j.maintab_imcenter_unlogin_button_text), new p(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(t.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(t.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(t.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.chX.getPageContext().getPageActivity(), this.cii, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, t.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.x(t.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(t.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        afC();
        if (!z) {
            dZ(true);
        } else {
            dZ(false);
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
        this.cif = new g(this, imMessageCenterShowItemData);
        String string = this.chX.getPageContext().getPageActivity().getString(t.j.delete_user_chat);
        this.cie = new com.baidu.tbadk.core.dialog.c(this.chX.getPageContext().getPageActivity());
        this.cie.cb(t.j.operation);
        this.cie.a(new String[]{string}, this.cif);
        this.cie.d(this.chX.getPageContext());
    }

    public void dY(boolean z) {
        if (z) {
            if (afF() && this.cic.getVisibility() != 0) {
                this.cic.setVisibility(0);
            }
        } else if (this.cic.getVisibility() != 8) {
            this.cic.setVisibility(8);
        }
    }

    public void dZ(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                afC();
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

    public boolean afF() {
        return this.cih;
    }

    public void ea(boolean z) {
        this.cih = z;
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
                if (this.chW != null) {
                    this.chW.insertOrUpdate(data, this.bRq);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.chW != null) {
                this.chW.remove(data, this.bRq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.chW != null) {
                this.chW.setData(data, this.bRq);
            }
        }
    }
}
