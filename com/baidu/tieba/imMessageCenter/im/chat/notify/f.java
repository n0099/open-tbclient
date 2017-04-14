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
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.y;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class f extends BaseFragment {
    private NoNetworkView aRL;
    private RelativeLayout bKx;
    private ShutDownValidateTipView dhI;
    private c.b dhK;
    private int dhL;
    private y mNoDataView;
    private ImMessageCenterModel dhC = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> dhD = null;
    private ImMessageCenterShowItemData dhE = null;
    private BdListView dhF = null;
    private ImMessageCenterListAdapter dhG = null;
    private t dhH = null;
    com.baidu.tbadk.core.dialog.c dhJ = null;
    private boolean dhM = true;
    private final CustomMessageListener aXu = new g(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener dhN = new i(this);
    private final AdapterView.OnItemLongClickListener dhO = new k(this);
    private final ab.b aYA = new l(this);
    private final CustomMessageListener cQe = new m(this, 0);
    private com.baidu.tieba.im.chat.a.a cQg = new n(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dhL = 3;
        this.dhD = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(w.j.chat_list_activity, viewGroup, false);
        ad(inflate);
        TiebaStatic.eventStat(this.dhD.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cQe);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cQe);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cQe);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cQe);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cQe);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cQe);
        registerListener(this.aXu);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dhG != null) {
            this.dhG.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.dhD.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.cQe);
    }

    private void initData() {
        this.dhC = new ImMessageCenterModel();
        gm(com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void ad(View view) {
        this.bKx = (RelativeLayout) view.findViewById(w.h.chat_list);
        this.dhI = (ShutDownValidateTipView) view.findViewById(w.h.view_no_validate);
        this.dhI.setVisibility(8);
        this.dhI.setShutDownClickListener(new o(this));
        this.dhF = (BdListView) view.findViewById(w.h.chat_list_content);
        this.dhF.setDividerHeight(0);
        this.dhH = new t(getPageContext());
        this.dhH.a(this.aYA);
        this.dhH.setTag(getUniqueId());
        this.dhF.setPullRefresh(this.dhH);
        this.dhG = new ImMessageCenterListAdapter(this.dhD.getPageContext().getPageActivity());
        this.dhF.setAdapter((ListAdapter) this.dhG);
        this.dhF.setOnItemClickListener(this.dhN);
        this.dhF.setOnItemLongClickListener(this.dhO);
        this.dhF.startPullRefresh();
        this.aRL = (NoNetworkView) this.bKx.findViewById(w.h.view_no_network);
        if (!this.mIsLogin) {
            gl(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.dhL != i) {
            this.dhL = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.dhD.getPageContext(), i);
            }
            if (this.dhI != null) {
                this.dhI.onChangeSkinType(i);
            }
            if (this.dhH != null) {
                this.dhH.dk(i);
            }
            if (this.dhG != null) {
                this.dhG.notifyDataSetChanged();
            }
            if (this.dhD != null && (this.dhD instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.dhD).getLayoutMode().aj(i == 1);
                ((BaseFragmentActivity) this.dhD).getLayoutMode().t(this.bKx);
            }
            if (this.aRL != null) {
                this.aRL.onChangeSkinType(this.dhD.getPageContext(), i);
            }
        }
    }

    private void aui() {
        if (isAdded()) {
            if (this.mIsLogin) {
                auj();
            } else {
                auk();
            }
        }
    }

    private void auj() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(w.l.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dhD.getPageContext().getPageActivity(), this.bKx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(w.f.ds80)), NoDataViewFactory.d.dh(w.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void auk() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(w.l.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(w.f.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(w.f.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(w.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dhD.getPageContext().getPageActivity(), this.bKx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, w.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.D(w.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(w.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        aui();
        if (!z) {
            gl(true);
        } else {
            gl(false);
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
        this.dhK = new h(this, imMessageCenterShowItemData);
        String string = this.dhD.getPageContext().getPageActivity().getString(w.l.delete_user_chat);
        this.dhJ = new com.baidu.tbadk.core.dialog.c(this.dhD.getPageContext().getPageActivity());
        this.dhJ.cc(w.l.operation);
        this.dhJ.a(new String[]{string}, this.dhK);
        this.dhJ.d(this.dhD.getPageContext());
    }

    public void gk(boolean z) {
        if (z) {
            if (aul() && this.dhI.getVisibility() != 0) {
                this.dhI.setVisibility(0);
            }
        } else if (this.dhI.getVisibility() != 8) {
            this.dhI.setVisibility(8);
        }
    }

    public void gl(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                aui();
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

    public boolean aul() {
        return this.dhM;
    }

    public void gm(boolean z) {
        this.dhM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                if (this.dhC != null) {
                    this.dhC.insertOrUpdate(data, this.cQg);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dhC != null) {
                this.dhC.remove(data, this.cQg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dhC != null) {
                this.dhC.setData(data, this.cQg);
            }
        }
    }
}
