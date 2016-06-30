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
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class f extends BaseFragment {
    private NoNetworkView Ev;
    private RelativeLayout bzi;
    private ShutDownValidateTipView cYW;
    private c.b cYY;
    private int cYZ;
    private com.baidu.tbadk.core.view.q mNoDataView;
    private ImMessageCenterModel cYQ = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> cYR = null;
    private ImMessageCenterShowItemData cYS = null;
    private BdListView cYT = null;
    private ImMessageCenterListAdapter cYU = null;
    private t cYV = null;
    com.baidu.tbadk.core.dialog.c cYX = null;
    private boolean cZa = true;
    private final CustomMessageListener aMV = new g(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener cZb = new i(this);
    private final AdapterView.OnItemLongClickListener cZc = new k(this);
    private final t.b aOb = new l(this);
    private final CustomMessageListener cHK = new m(this, 0);
    private com.baidu.tieba.im.chat.notify.a cHM = new n(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cYZ = 3;
        this.cYR = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(u.h.chat_list_activity, viewGroup, false);
        Z(inflate);
        TiebaStatic.eventStat(this.cYR.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cHK);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cHK);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cHK);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cHK);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cHK);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cHK);
        registerListener(this.aMV);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cYU != null) {
            this.cYU.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.cYR.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.cHK);
    }

    private void initData() {
        this.cYQ = new ImMessageCenterModel();
        fM(com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void Z(View view) {
        this.bzi = (RelativeLayout) view.findViewById(u.g.chat_list);
        this.cYW = (ShutDownValidateTipView) view.findViewById(u.g.view_no_validate);
        this.cYW.setVisibility(8);
        this.cYW.setShutDownClickListener(new o(this));
        this.cYT = (BdListView) view.findViewById(u.g.chat_list_content);
        this.cYT.setDividerHeight(0);
        this.cYV = new t(getPageContext());
        this.cYV.a(this.aOb);
        this.cYV.setTag(getUniqueId());
        this.cYT.setPullRefresh(this.cYV);
        this.cYU = new ImMessageCenterListAdapter(this.cYR.getPageContext().getPageActivity());
        this.cYT.setAdapter((ListAdapter) this.cYU);
        this.cYT.setOnItemClickListener(this.cZb);
        this.cYT.setOnItemLongClickListener(this.cZc);
        this.cYT.jB();
        this.Ev = (NoNetworkView) this.bzi.findViewById(u.g.view_no_network);
        if (!this.mIsLogin) {
            fL(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.cYZ != i) {
            this.cYZ = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.cYR.getPageContext(), i);
            }
            if (this.cYW != null) {
                this.cYW.onChangeSkinType(i);
            }
            if (this.cYV != null) {
                this.cYV.cT(i);
            }
            if (this.cYU != null) {
                this.cYU.notifyDataSetChanged();
            }
            if (this.cYR != null && (this.cYR instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.cYR).getLayoutMode().ad(i == 1);
                ((BaseFragmentActivity) this.cYR).getLayoutMode().w(this.bzi);
            }
            if (this.Ev != null) {
                this.Ev.onChangeSkinType(this.cYR.getPageContext(), i);
            }
        }
    }

    private void art() {
        if (isAdded()) {
            if (this.mIsLogin) {
                aru();
            } else {
                arv();
            }
        }
    }

    private void aru() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(u.j.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.cYR.getPageContext().getPageActivity(), this.bzi, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(u.e.ds80)), NoDataViewFactory.d.cQ(u.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void arv() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(u.j.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(u.e.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(u.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(u.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(u.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.cYR.getPageContext().getPageActivity(), this.bzi, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, u.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.u(u.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(u.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        art();
        if (!z) {
            fL(true);
        } else {
            fL(false);
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
        this.cYY = new h(this, imMessageCenterShowItemData);
        String string = this.cYR.getPageContext().getPageActivity().getString(u.j.delete_user_chat);
        this.cYX = new com.baidu.tbadk.core.dialog.c(this.cYR.getPageContext().getPageActivity());
        this.cYX.bP(u.j.operation);
        this.cYX.a(new String[]{string}, this.cYY);
        this.cYX.d(this.cYR.getPageContext());
    }

    public void fK(boolean z) {
        if (z) {
            if (arw() && this.cYW.getVisibility() != 0) {
                this.cYW.setVisibility(0);
            }
        } else if (this.cYW.getVisibility() != 8) {
            this.cYW.setVisibility(8);
        }
    }

    public void fL(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                art();
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

    public boolean arw() {
        return this.cZa;
    }

    public void fM(boolean z) {
        this.cZa = z;
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
                if (this.cYQ != null) {
                    this.cYQ.insertOrUpdate(data, this.cHM);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.cYQ != null) {
                this.cYQ.remove(data, this.cHM);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.cYQ != null) {
                this.cYQ.setData(data, this.cHM);
            }
        }
    }
}
