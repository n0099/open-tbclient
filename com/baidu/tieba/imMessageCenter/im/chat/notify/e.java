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
import com.baidu.tbadk.core.view.u;
import com.baidu.tbadk.core.view.x;
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
    private ShutDownValidateTipView bGO;
    private c.b bGQ;
    private int bGR;
    private RelativeLayout bGT;
    private u mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ImMessageCenterModel bGI = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> bGJ = null;
    private ImMessageCenterShowItemData bGK = null;
    private BdListView bGL = null;
    private ImMessageCenterListAdapter bGM = null;
    private r bGN = null;
    com.baidu.tbadk.core.dialog.c bGP = null;
    private boolean bGS = true;
    private final CustomMessageListener aGR = new f(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener mItemClickListener = new h(this);
    private final AdapterView.OnItemLongClickListener bGU = new j(this);
    private final x.a aHY = new k(this);
    private final CustomMessageListener bqS = new l(this, 0);
    private com.baidu.tieba.im.chat.notify.a bqT = new m(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bGR = -1;
        this.bGJ = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(i.g.chat_list_activity, viewGroup, false);
        x(inflate);
        TiebaStatic.eventStat(this.bGJ.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.bqS);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.bqS);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.bqS);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.bqS);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.bqS);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.bqS);
        registerListener(this.aGR);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bGM != null) {
            this.bGM.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.bGJ.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.bqS);
    }

    private void initData() {
        this.bGI = new ImMessageCenterModel();
        dw(com.baidu.tbadk.core.sharedPref.b.tx().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void x(View view) {
        this.bGT = (RelativeLayout) view.findViewById(i.f.chat_list);
        this.bGO = (ShutDownValidateTipView) view.findViewById(i.f.view_no_validate);
        this.bGO.setVisibility(8);
        this.bGO.setShutDownClickListener(new n(this));
        this.bGL = (BdListView) view.findViewById(i.f.chat_list_content);
        this.bGL.setDividerHeight(0);
        this.bGN = new r(getPageContext());
        this.bGN.a(this.aHY);
        this.bGN.setTag(getUniqueId());
        this.bGL.setPullRefresh(this.bGN);
        this.bGM = new ImMessageCenterListAdapter(this.bGJ.getPageContext().getPageActivity());
        this.bGM.g(this);
        this.bGL.setAdapter((ListAdapter) this.bGM);
        this.bGL.setOnItemClickListener(this.mItemClickListener);
        this.bGL.setOnItemLongClickListener(this.bGU);
        this.bGL.nv();
        this.mNoNetworkView = (NoNetworkView) this.bGT.findViewById(i.f.view_no_network);
        if (!this.mIsLogin) {
            dv(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.bGR != i) {
            this.bGR = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.bGJ.getPageContext(), i);
            }
            if (this.bGO != null) {
                this.bGO.onChangeSkinType(i);
            }
            if (this.bGN != null) {
                this.bGN.cM(i);
            }
            if (this.bGM != null) {
                this.bGM.notifyDataSetChanged();
            }
            if (this.bGJ != null && (this.bGJ instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.bGJ).getLayoutMode().ad(i == 1);
                ((BaseFragmentActivity) this.bGJ).getLayoutMode().k(this.bGT);
            }
            if (this.mNoNetworkView != null) {
                this.mNoNetworkView.onChangeSkinType(this.bGJ.getPageContext(), i);
            }
        }
    }

    private void Xg() {
        if (isAdded()) {
            if (this.mIsLogin) {
                Xh();
            } else {
                Xi();
            }
        }
    }

    private void Xh() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(i.h.maintab_imcenter_button_text), new o(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.bGJ.getPageContext().getPageActivity(), this.bGT, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(i.d.ds80)), NoDataViewFactory.d.cJ(i.h.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void Xi() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(i.h.maintab_imcenter_unlogin_button_text), new p(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(i.d.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(i.d.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(i.d.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.bGJ.getPageContext().getPageActivity(), this.bGT, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, i.e.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(i.h.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(i.d.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        Xg();
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
        this.bGQ = new g(this, imMessageCenterShowItemData);
        String string = this.bGJ.getPageContext().getPageActivity().getString(i.h.delete_user_chat);
        this.bGP = new com.baidu.tbadk.core.dialog.c(this.bGJ.getPageContext().getPageActivity());
        this.bGP.bI(i.h.operation);
        this.bGP.a(new String[]{string}, this.bGQ);
        this.bGP.d(this.bGJ.getPageContext());
    }

    public void du(boolean z) {
        if (z) {
            if (Xj() && this.bGO.getVisibility() != 0) {
                this.bGO.setVisibility(0);
            }
        } else if (this.bGO.getVisibility() != 8) {
            this.bGO.setVisibility(8);
        }
    }

    public void dv(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                Xg();
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

    public boolean Xj() {
        return this.bGS;
    }

    public void dw(boolean z) {
        this.bGS = z;
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
                if (this.bGI != null) {
                    this.bGI.insertOrUpdate(data, this.bqT);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.bGI != null) {
                this.bGI.remove(data, this.bqT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.bGI != null) {
                this.bGI.setData(data, this.bqT);
            }
        }
    }
}
