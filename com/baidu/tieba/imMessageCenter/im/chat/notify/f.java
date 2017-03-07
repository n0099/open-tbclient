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
    private NoNetworkView aRv;
    private RelativeLayout bKE;
    private ShutDownValidateTipView djj;
    private c.b djl;
    private int djm;
    private y mNoDataView;
    private ImMessageCenterModel djd = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> dje = null;
    private ImMessageCenterShowItemData djf = null;
    private BdListView djg = null;
    private ImMessageCenterListAdapter djh = null;
    private t dji = null;
    com.baidu.tbadk.core.dialog.c djk = null;
    private boolean djn = true;
    private final CustomMessageListener aXg = new g(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener djo = new i(this);
    private final AdapterView.OnItemLongClickListener djp = new k(this);
    private final ab.b aYm = new l(this);
    private final CustomMessageListener cRH = new m(this, 0);
    private com.baidu.tieba.im.chat.a.a cRJ = new n(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.djm = 3;
        this.dje = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(w.j.chat_list_activity, viewGroup, false);
        ad(inflate);
        TiebaStatic.eventStat(this.dje.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cRH);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cRH);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cRH);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cRH);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cRH);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cRH);
        registerListener(this.aXg);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.djh != null) {
            this.djh.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.dje.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.cRH);
    }

    private void initData() {
        this.djd = new ImMessageCenterModel();
        gm(com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void ad(View view) {
        this.bKE = (RelativeLayout) view.findViewById(w.h.chat_list);
        this.djj = (ShutDownValidateTipView) view.findViewById(w.h.view_no_validate);
        this.djj.setVisibility(8);
        this.djj.setShutDownClickListener(new o(this));
        this.djg = (BdListView) view.findViewById(w.h.chat_list_content);
        this.djg.setDividerHeight(0);
        this.dji = new t(getPageContext());
        this.dji.a(this.aYm);
        this.dji.setTag(getUniqueId());
        this.djg.setPullRefresh(this.dji);
        this.djh = new ImMessageCenterListAdapter(this.dje.getPageContext().getPageActivity());
        this.djg.setAdapter((ListAdapter) this.djh);
        this.djg.setOnItemClickListener(this.djo);
        this.djg.setOnItemLongClickListener(this.djp);
        this.djg.startPullRefresh();
        this.aRv = (NoNetworkView) this.bKE.findViewById(w.h.view_no_network);
        if (!this.mIsLogin) {
            gl(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.djm != i) {
            this.djm = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.dje.getPageContext(), i);
            }
            if (this.djj != null) {
                this.djj.onChangeSkinType(i);
            }
            if (this.dji != null) {
                this.dji.dh(i);
            }
            if (this.djh != null) {
                this.djh.notifyDataSetChanged();
            }
            if (this.dje != null && (this.dje instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.dje).getLayoutMode().ah(i == 1);
                ((BaseFragmentActivity) this.dje).getLayoutMode().t(this.bKE);
            }
            if (this.aRv != null) {
                this.aRv.onChangeSkinType(this.dje.getPageContext(), i);
            }
        }
    }

    private void aup() {
        if (isAdded()) {
            if (this.mIsLogin) {
                auq();
            } else {
                aur();
            }
        }
    }

    private void auq() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(w.l.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dje.getPageContext().getPageActivity(), this.bKE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(w.f.ds80)), NoDataViewFactory.d.de(w.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void aur() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(w.l.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(w.f.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(w.f.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(w.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dje.getPageContext().getPageActivity(), this.bKE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, w.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.D(w.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(w.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        aup();
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
        this.djl = new h(this, imMessageCenterShowItemData);
        String string = this.dje.getPageContext().getPageActivity().getString(w.l.delete_user_chat);
        this.djk = new com.baidu.tbadk.core.dialog.c(this.dje.getPageContext().getPageActivity());
        this.djk.bZ(w.l.operation);
        this.djk.a(new String[]{string}, this.djl);
        this.djk.d(this.dje.getPageContext());
    }

    public void gk(boolean z) {
        if (z) {
            if (aus() && this.djj.getVisibility() != 0) {
                this.djj.setVisibility(0);
            }
        } else if (this.djj.getVisibility() != 8) {
            this.djj.setVisibility(8);
        }
    }

    public void gl(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                aup();
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

    public boolean aus() {
        return this.djn;
    }

    public void gm(boolean z) {
        this.djn = z;
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
                if (this.djd != null) {
                    this.djd.insertOrUpdate(data, this.cRJ);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.djd != null) {
                this.djd.remove(data, this.cRJ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.djd != null) {
                this.djd.setData(data, this.cRJ);
            }
        }
    }
}
