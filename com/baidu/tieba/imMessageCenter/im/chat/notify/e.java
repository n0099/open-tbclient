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
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class e extends BaseFragment {
    private ShutDownValidateTipView cdE;
    private c.b cdG;
    private int cdH;
    private RelativeLayout cdJ;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ImMessageCenterModel cdy = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> cdz = null;
    private ImMessageCenterShowItemData cdA = null;
    private BdListView cdB = null;
    private ImMessageCenterListAdapter cdC = null;
    private r cdD = null;
    com.baidu.tbadk.core.dialog.c cdF = null;
    private boolean cdI = true;
    private final CustomMessageListener aJm = new f(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener mItemClickListener = new h(this);
    private final AdapterView.OnItemLongClickListener cdK = new j(this);
    private final r.a aKt = new k(this);
    private final CustomMessageListener bNr = new l(this, 0);
    private com.baidu.tieba.im.chat.notify.a bNs = new m(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cdH = 3;
        this.cdz = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(n.h.chat_list_activity, viewGroup, false);
        B(inflate);
        TiebaStatic.eventStat(this.cdz.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.bNr);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.bNr);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.bNr);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.bNr);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.bNr);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.bNr);
        registerListener(this.aJm);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cdC != null) {
            this.cdC.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.cdz.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.bNr);
    }

    private void initData() {
        this.cdy = new ImMessageCenterModel();
        dT(com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void B(View view) {
        this.cdJ = (RelativeLayout) view.findViewById(n.g.chat_list);
        this.cdE = (ShutDownValidateTipView) view.findViewById(n.g.view_no_validate);
        this.cdE.setVisibility(8);
        this.cdE.setShutDownClickListener(new n(this));
        this.cdB = (BdListView) view.findViewById(n.g.chat_list_content);
        this.cdB.setDividerHeight(0);
        this.cdD = new r(getPageContext());
        this.cdD.a(this.aKt);
        this.cdD.setTag(getUniqueId());
        this.cdB.setPullRefresh(this.cdD);
        this.cdC = new ImMessageCenterListAdapter(this.cdz.getPageContext().getPageActivity());
        this.cdB.setAdapter((ListAdapter) this.cdC);
        this.cdB.setOnItemClickListener(this.mItemClickListener);
        this.cdB.setOnItemLongClickListener(this.cdK);
        this.cdB.nb();
        this.mNoNetworkView = (NoNetworkView) this.cdJ.findViewById(n.g.view_no_network);
        if (!this.mIsLogin) {
            dS(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.cdH != i) {
            this.cdH = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.cdz.getPageContext(), i);
            }
            if (this.cdE != null) {
                this.cdE.onChangeSkinType(i);
            }
            if (this.cdD != null) {
                this.cdD.cP(i);
            }
            if (this.cdC != null) {
                this.cdC.notifyDataSetChanged();
            }
            if (this.cdz != null && (this.cdz instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.cdz).getLayoutMode().ac(i == 1);
                ((BaseFragmentActivity) this.cdz).getLayoutMode().k(this.cdJ);
            }
            if (this.mNoNetworkView != null) {
                this.mNoNetworkView.onChangeSkinType(this.cdz.getPageContext(), i);
            }
        }
    }

    private void acu() {
        if (isAdded()) {
            if (this.mIsLogin) {
                acv();
            } else {
                acw();
            }
        }
    }

    private void acv() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(n.j.maintab_imcenter_button_text), new o(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.cdz.getPageContext().getPageActivity(), this.cdJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(n.e.ds80)), NoDataViewFactory.d.cM(n.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void acw() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(n.j.maintab_imcenter_unlogin_button_text), new p(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(n.e.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(n.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(n.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(n.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.cdz.getPageContext().getPageActivity(), this.cdJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, n.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(n.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(n.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        acu();
        if (!z) {
            dS(true);
        } else {
            dS(false);
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
        this.cdG = new g(this, imMessageCenterShowItemData);
        String string = this.cdz.getPageContext().getPageActivity().getString(n.j.delete_user_chat);
        this.cdF = new com.baidu.tbadk.core.dialog.c(this.cdz.getPageContext().getPageActivity());
        this.cdF.bJ(n.j.operation);
        this.cdF.a(new String[]{string}, this.cdG);
        this.cdF.d(this.cdz.getPageContext());
    }

    public void dR(boolean z) {
        if (z) {
            if (acx() && this.cdE.getVisibility() != 0) {
                this.cdE.setVisibility(0);
            }
        } else if (this.cdE.getVisibility() != 8) {
            this.cdE.setVisibility(8);
        }
    }

    public void dS(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                acu();
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

    public boolean acx() {
        return this.cdI;
    }

    public void dT(boolean z) {
        this.cdI = z;
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
                if (this.cdy != null) {
                    this.cdy.insertOrUpdate(data, this.bNs);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.cdy != null) {
                this.cdy.remove(data, this.bNs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.cdy != null) {
                this.cdy.setData(data, this.bNs);
            }
        }
    }
}
