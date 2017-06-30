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
import com.baidu.tbadk.core.view.ae;
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
/* loaded from: classes2.dex */
public class f extends BaseFragment {
    private RelativeLayout bZb;
    private NoNetworkView bbO;
    private ShutDownValidateTipView drs;
    private c.b dru;
    private int drv;
    private y mNoDataView;
    private ImMessageCenterModel drm = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> drn = null;
    private ImMessageCenterShowItemData dro = null;
    private BdListView drp = null;
    private ImMessageCenterListAdapter drq = null;
    private t drr = null;
    com.baidu.tbadk.core.dialog.c drt = null;
    private boolean drw = true;
    private final CustomMessageListener aWO = new g(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener drx = new i(this);
    private final AdapterView.OnItemLongClickListener dry = new k(this);
    private final ae.b aXU = new l(this);
    private final CustomMessageListener cZR = new m(this, 0);
    private com.baidu.tieba.im.chat.a.a cZT = new n(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.drv = 3;
        this.drn = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(w.j.chat_list_activity, viewGroup, false);
        ac(inflate);
        TiebaStatic.eventStat(this.drn.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cZR);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cZR);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cZR);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cZR);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cZR);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cZR);
        registerListener(this.aWO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.drq != null) {
            this.drq.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.drn.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.cZR);
    }

    private void initData() {
        this.drm = new ImMessageCenterModel();
        gC(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void ac(View view) {
        this.bZb = (RelativeLayout) view.findViewById(w.h.chat_list);
        this.drs = (ShutDownValidateTipView) view.findViewById(w.h.view_no_validate);
        this.drs.setVisibility(8);
        this.drs.setShutDownClickListener(new o(this));
        this.drp = (BdListView) view.findViewById(w.h.chat_list_content);
        this.drp.setDividerHeight(0);
        this.drr = new t(getPageContext());
        this.drr.a(this.aXU);
        this.drr.setTag(getUniqueId());
        this.drp.setPullRefresh(this.drr);
        this.drq = new ImMessageCenterListAdapter(this.drn.getPageContext().getPageActivity());
        this.drp.setAdapter((ListAdapter) this.drq);
        this.drp.setOnItemClickListener(this.drx);
        this.drp.setOnItemLongClickListener(this.dry);
        this.drp.startPullRefresh();
        this.bbO = (NoNetworkView) this.bZb.findViewById(w.h.view_no_network);
        if (!this.mIsLogin) {
            gB(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.drv != i) {
            this.drv = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.drn.getPageContext(), i);
            }
            if (this.drs != null) {
                this.drs.onChangeSkinType(i);
            }
            if (this.drr != null) {
                this.drr.dl(i);
            }
            if (this.drq != null) {
                this.drq.notifyDataSetChanged();
            }
            if (this.drn != null && (this.drn instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.drn).getLayoutMode().ah(i == 1);
                ((BaseFragmentActivity) this.drn).getLayoutMode().t(this.bZb);
            }
            if (this.bbO != null) {
                this.bbO.onChangeSkinType(this.drn.getPageContext(), i);
            }
        }
    }

    private void awM() {
        if (isAdded()) {
            if (this.mIsLogin) {
                awN();
            } else {
                MA();
            }
        }
    }

    private void awN() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(w.l.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.drn.getPageContext().getPageActivity(), this.bZb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(w.f.ds80)), NoDataViewFactory.d.dg(w.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void MA() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(w.l.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(w.f.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(w.f.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(w.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.drn.getPageContext().getPageActivity(), this.bZb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, w.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.A(w.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(w.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        awM();
        if (!z) {
            gB(true);
        } else {
            gB(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dru = new h(this, imMessageCenterShowItemData);
        String string = this.drn.getPageContext().getPageActivity().getString(w.l.delete_user_chat);
        this.drt = new com.baidu.tbadk.core.dialog.c(this.drn.getPageContext().getPageActivity());
        this.drt.cb(w.l.operation);
        this.drt.a(new String[]{string}, this.dru);
        this.drt.d(this.drn.getPageContext());
    }

    public void gA(boolean z) {
        if (z) {
            if (awO() && this.drs.getVisibility() != 0) {
                this.drs.setVisibility(0);
            }
        } else if (this.drs.getVisibility() != 8) {
            this.drs.setVisibility(8);
        }
    }

    public void gB(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                awM();
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

    public boolean awO() {
        return this.drw;
    }

    public void gC(boolean z) {
        this.drw = z;
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
                if (this.drm != null) {
                    this.drm.insertOrUpdate(data, this.cZT);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.drm != null) {
                this.drm.remove(data, this.cZT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.drm != null) {
                this.drm.setData(data, this.cZT);
            }
        }
    }
}
