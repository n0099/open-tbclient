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
    private NoNetworkView aRN;
    private RelativeLayout bMO;
    private ShutDownValidateTipView djZ;
    private c.b dkb;
    private int dkc;
    private y mNoDataView;
    private ImMessageCenterModel djT = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> djU = null;
    private ImMessageCenterShowItemData djV = null;
    private BdListView djW = null;
    private ImMessageCenterListAdapter djX = null;
    private t djY = null;
    com.baidu.tbadk.core.dialog.c dka = null;
    private boolean dkd = true;
    private final CustomMessageListener aXx = new g(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener dke = new i(this);
    private final AdapterView.OnItemLongClickListener dkf = new k(this);
    private final ab.b aYD = new l(this);
    private final CustomMessageListener cSv = new m(this, 0);
    private com.baidu.tieba.im.chat.a.a cSx = new n(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dkc = 3;
        this.djU = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(w.j.chat_list_activity, viewGroup, false);
        ad(inflate);
        TiebaStatic.eventStat(this.djU.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cSv);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cSv);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cSv);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cSv);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cSv);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cSv);
        registerListener(this.aXx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.djX != null) {
            this.djX.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.djU.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.cSv);
    }

    private void initData() {
        this.djT = new ImMessageCenterModel();
        gw(com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void ad(View view) {
        this.bMO = (RelativeLayout) view.findViewById(w.h.chat_list);
        this.djZ = (ShutDownValidateTipView) view.findViewById(w.h.view_no_validate);
        this.djZ.setVisibility(8);
        this.djZ.setShutDownClickListener(new o(this));
        this.djW = (BdListView) view.findViewById(w.h.chat_list_content);
        this.djW.setDividerHeight(0);
        this.djY = new t(getPageContext());
        this.djY.a(this.aYD);
        this.djY.setTag(getUniqueId());
        this.djW.setPullRefresh(this.djY);
        this.djX = new ImMessageCenterListAdapter(this.djU.getPageContext().getPageActivity());
        this.djW.setAdapter((ListAdapter) this.djX);
        this.djW.setOnItemClickListener(this.dke);
        this.djW.setOnItemLongClickListener(this.dkf);
        this.djW.startPullRefresh();
        this.aRN = (NoNetworkView) this.bMO.findViewById(w.h.view_no_network);
        if (!this.mIsLogin) {
            gv(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.dkc != i) {
            this.dkc = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.djU.getPageContext(), i);
            }
            if (this.djZ != null) {
                this.djZ.onChangeSkinType(i);
            }
            if (this.djY != null) {
                this.djY.dk(i);
            }
            if (this.djX != null) {
                this.djX.notifyDataSetChanged();
            }
            if (this.djU != null && (this.djU instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.djU).getLayoutMode().aj(i == 1);
                ((BaseFragmentActivity) this.djU).getLayoutMode().t(this.bMO);
            }
            if (this.aRN != null) {
                this.aRN.onChangeSkinType(this.djU.getPageContext(), i);
            }
        }
    }

    private void avj() {
        if (isAdded()) {
            if (this.mIsLogin) {
                avk();
            } else {
                avl();
            }
        }
    }

    private void avk() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(w.l.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.djU.getPageContext().getPageActivity(), this.bMO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(w.f.ds80)), NoDataViewFactory.d.dh(w.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void avl() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(w.l.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(w.f.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(w.f.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(w.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.djU.getPageContext().getPageActivity(), this.bMO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, w.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.D(w.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(w.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        avj();
        if (!z) {
            gv(true);
        } else {
            gv(false);
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
        this.dkb = new h(this, imMessageCenterShowItemData);
        String string = this.djU.getPageContext().getPageActivity().getString(w.l.delete_user_chat);
        this.dka = new com.baidu.tbadk.core.dialog.c(this.djU.getPageContext().getPageActivity());
        this.dka.cc(w.l.operation);
        this.dka.a(new String[]{string}, this.dkb);
        this.dka.d(this.djU.getPageContext());
    }

    public void gu(boolean z) {
        if (z) {
            if (avm() && this.djZ.getVisibility() != 0) {
                this.djZ.setVisibility(0);
            }
        } else if (this.djZ.getVisibility() != 8) {
            this.djZ.setVisibility(8);
        }
    }

    public void gv(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                avj();
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

    public boolean avm() {
        return this.dkd;
    }

    public void gw(boolean z) {
        this.dkd = z;
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
                if (this.djT != null) {
                    this.djT.insertOrUpdate(data, this.cSx);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.djT != null) {
                this.djT.remove(data, this.cSx);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.djT != null) {
                this.djT.setData(data, this.cSx);
            }
        }
    }
}
