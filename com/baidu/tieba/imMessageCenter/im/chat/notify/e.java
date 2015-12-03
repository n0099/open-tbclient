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
import com.baidu.tbadk.core.view.q;
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
    private ShutDownValidateTipView bZE;
    private c.b bZG;
    private RelativeLayout bZI;
    private int bxU;
    private com.baidu.tbadk.core.view.n mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ImMessageCenterModel bZy = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> bZz = null;
    private ImMessageCenterShowItemData bZA = null;
    private BdListView bZB = null;
    private ImMessageCenterListAdapter bZC = null;
    private r bZD = null;
    com.baidu.tbadk.core.dialog.c bZF = null;
    private boolean bZH = true;
    private final CustomMessageListener aHO = new f(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener mItemClickListener = new h(this);
    private final AdapterView.OnItemLongClickListener bZJ = new j(this);
    private final q.a aIV = new k(this);
    private final CustomMessageListener bJJ = new l(this, 0);
    private com.baidu.tieba.im.chat.notify.a bJK = new m(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bxU = 3;
        this.bZz = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(n.g.chat_list_activity, viewGroup, false);
        A(inflate);
        TiebaStatic.eventStat(this.bZz.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.bJJ);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.bJJ);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.bJJ);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.bJJ);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.bJJ);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.bJJ);
        registerListener(this.aHO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bZC != null) {
            this.bZC.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.bZz.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.bJJ);
    }

    private void initData() {
        this.bZy = new ImMessageCenterModel();
        dT(com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void A(View view) {
        this.bZI = (RelativeLayout) view.findViewById(n.f.chat_list);
        this.bZE = (ShutDownValidateTipView) view.findViewById(n.f.view_no_validate);
        this.bZE.setVisibility(8);
        this.bZE.setShutDownClickListener(new n(this));
        this.bZB = (BdListView) view.findViewById(n.f.chat_list_content);
        this.bZB.setDividerHeight(0);
        this.bZD = new r(getPageContext());
        this.bZD.a(this.aIV);
        this.bZD.setTag(getUniqueId());
        this.bZB.setPullRefresh(this.bZD);
        this.bZC = new ImMessageCenterListAdapter(this.bZz.getPageContext().getPageActivity());
        this.bZB.setAdapter((ListAdapter) this.bZC);
        this.bZB.setOnItemClickListener(this.mItemClickListener);
        this.bZB.setOnItemLongClickListener(this.bZJ);
        this.bZB.nD();
        this.mNoNetworkView = (NoNetworkView) this.bZI.findViewById(n.f.view_no_network);
        if (!this.mIsLogin) {
            dS(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.bxU != i) {
            this.bxU = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.bZz.getPageContext(), i);
            }
            if (this.bZE != null) {
                this.bZE.onChangeSkinType(i);
            }
            if (this.bZD != null) {
                this.bZD.cV(i);
            }
            if (this.bZC != null) {
                this.bZC.notifyDataSetChanged();
            }
            if (this.bZz != null && (this.bZz instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.bZz).getLayoutMode().af(i == 1);
                ((BaseFragmentActivity) this.bZz).getLayoutMode().k(this.bZI);
            }
            if (this.mNoNetworkView != null) {
                this.mNoNetworkView.onChangeSkinType(this.bZz.getPageContext(), i);
            }
        }
    }

    private void abl() {
        if (isAdded()) {
            if (this.mIsLogin) {
                abm();
            } else {
                abn();
            }
        }
    }

    private void abm() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(n.i.maintab_imcenter_button_text), new o(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.bZz.getPageContext().getPageActivity(), this.bZI, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(n.d.ds80)), NoDataViewFactory.d.cS(n.i.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void abn() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(n.i.maintab_imcenter_unlogin_button_text), new p(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(n.d.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(n.d.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(n.d.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(n.d.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.bZz.getPageContext().getPageActivity(), this.bZI, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, n.e.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.C(n.i.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(n.d.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        abl();
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
        this.bZG = new g(this, imMessageCenterShowItemData);
        String string = this.bZz.getPageContext().getPageActivity().getString(n.i.delete_user_chat);
        this.bZF = new com.baidu.tbadk.core.dialog.c(this.bZz.getPageContext().getPageActivity());
        this.bZF.bQ(n.i.operation);
        this.bZF.a(new String[]{string}, this.bZG);
        this.bZF.d(this.bZz.getPageContext());
    }

    public void dR(boolean z) {
        if (z) {
            if (abo() && this.bZE.getVisibility() != 0) {
                this.bZE.setVisibility(0);
            }
        } else if (this.bZE.getVisibility() != 8) {
            this.bZE.setVisibility(8);
        }
    }

    public void dS(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                abl();
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

    public boolean abo() {
        return this.bZH;
    }

    public void dT(boolean z) {
        this.bZH = z;
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
                if (this.bZy != null) {
                    this.bZy.insertOrUpdate(data, this.bJK);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.bZy != null) {
                this.bZy.remove(data, this.bJK);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.bZy != null) {
                this.bZy.setData(data, this.bJK);
            }
        }
    }
}
