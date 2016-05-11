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
import com.baidu.tbadk.core.view.t;
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
    private NoNetworkView Ep;
    private ShutDownValidateTipView ctG;
    private c.b ctI;
    private int ctJ;
    private RelativeLayout ctL;
    private com.baidu.tbadk.core.view.q mNoDataView;
    private ImMessageCenterModel ctA = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> ctB = null;
    private ImMessageCenterShowItemData ctC = null;
    private BdListView ctD = null;
    private ImMessageCenterListAdapter ctE = null;
    private t ctF = null;
    com.baidu.tbadk.core.dialog.c ctH = null;
    private boolean ctK = true;
    private final CustomMessageListener aJx = new g(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener ctM = new i(this);
    private final AdapterView.OnItemLongClickListener ctN = new k(this);
    private final t.b aKD = new l(this);
    private final CustomMessageListener cco = new m(this, 0);
    private com.baidu.tieba.im.chat.notify.a ccq = new n(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ctJ = 3;
        this.ctB = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(t.h.chat_list_activity, viewGroup, false);
        X(inflate);
        TiebaStatic.eventStat(this.ctB.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cco);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cco);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cco);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cco);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cco);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cco);
        registerListener(this.aJx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ctE != null) {
            this.ctE.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.ctB.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.cco);
    }

    private void initData() {
        this.ctA = new ImMessageCenterModel();
        eY(com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void X(View view) {
        this.ctL = (RelativeLayout) view.findViewById(t.g.chat_list);
        this.ctG = (ShutDownValidateTipView) view.findViewById(t.g.view_no_validate);
        this.ctG.setVisibility(8);
        this.ctG.setShutDownClickListener(new o(this));
        this.ctD = (BdListView) view.findViewById(t.g.chat_list_content);
        this.ctD.setDividerHeight(0);
        this.ctF = new t(getPageContext());
        this.ctF.a(this.aKD);
        this.ctF.setTag(getUniqueId());
        this.ctD.setPullRefresh(this.ctF);
        this.ctE = new ImMessageCenterListAdapter(this.ctB.getPageContext().getPageActivity());
        this.ctD.setAdapter((ListAdapter) this.ctE);
        this.ctD.setOnItemClickListener(this.ctM);
        this.ctD.setOnItemLongClickListener(this.ctN);
        this.ctD.jy();
        this.Ep = (NoNetworkView) this.ctL.findViewById(t.g.view_no_network);
        if (!this.mIsLogin) {
            eX(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.ctJ != i) {
            this.ctJ = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.ctB.getPageContext(), i);
            }
            if (this.ctG != null) {
                this.ctG.onChangeSkinType(i);
            }
            if (this.ctF != null) {
                this.ctF.cS(i);
            }
            if (this.ctE != null) {
                this.ctE.notifyDataSetChanged();
            }
            if (this.ctB != null && (this.ctB instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.ctB).getLayoutMode().ae(i == 1);
                ((BaseFragmentActivity) this.ctB).getLayoutMode().x(this.ctL);
            }
            if (this.Ep != null) {
                this.Ep.onChangeSkinType(this.ctB.getPageContext(), i);
            }
        }
    }

    private void ajd() {
        if (isAdded()) {
            if (this.mIsLogin) {
                aje();
            } else {
                ajf();
            }
        }
    }

    private void aje() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m11getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(t.j.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.ctB.getPageContext().getPageActivity(), this.ctL, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(t.e.ds80)), NoDataViewFactory.d.cP(t.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m11getInst().getSkinType());
    }

    private void ajf() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(t.j.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(t.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(t.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(t.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.ctB.getPageContext().getPageActivity(), this.ctL, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, t.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.u(t.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(t.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m11getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        ajd();
        if (!z) {
            eX(true);
        } else {
            eX(false);
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
        this.ctI = new h(this, imMessageCenterShowItemData);
        String string = this.ctB.getPageContext().getPageActivity().getString(t.j.delete_user_chat);
        this.ctH = new com.baidu.tbadk.core.dialog.c(this.ctB.getPageContext().getPageActivity());
        this.ctH.bP(t.j.operation);
        this.ctH.a(new String[]{string}, this.ctI);
        this.ctH.d(this.ctB.getPageContext());
    }

    public void eW(boolean z) {
        if (z) {
            if (ajg() && this.ctG.getVisibility() != 0) {
                this.ctG.setVisibility(0);
            }
        } else if (this.ctG.getVisibility() != 8) {
            this.ctG.setVisibility(8);
        }
    }

    public void eX(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                ajd();
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

    public boolean ajg() {
        return this.ctK;
    }

    public void eY(boolean z) {
        this.ctK = z;
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
                if (this.ctA != null) {
                    this.ctA.insertOrUpdate(data, this.ccq);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.ctA != null) {
                this.ctA.remove(data, this.ccq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.ctA != null) {
                this.ctA.setData(data, this.ccq);
            }
        }
    }
}
