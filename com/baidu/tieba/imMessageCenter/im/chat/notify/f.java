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
import com.baidu.tbadk.core.view.v;
import com.baidu.tbadk.core.view.y;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class f extends BaseFragment {
    private NoNetworkView Hi;
    private RelativeLayout bMV;
    private ShutDownValidateTipView doZ;
    private c.b dpb;
    private int dpc;
    private v mNoDataView;
    private ImMessageCenterModel doT = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> doU = null;
    private ImMessageCenterShowItemData doV = null;
    private BdListView doW = null;
    private ImMessageCenterListAdapter doX = null;
    private t doY = null;
    com.baidu.tbadk.core.dialog.c dpa = null;
    private boolean dpd = true;
    private final CustomMessageListener aTT = new g(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener dpe = new i(this);
    private final AdapterView.OnItemLongClickListener dpf = new k(this);
    private final y.b aUZ = new l(this);
    private final CustomMessageListener cXB = new m(this, 0);
    private com.baidu.tieba.im.chat.notify.a cXD = new n(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dpc = 3;
        this.doU = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(r.h.chat_list_activity, viewGroup, false);
        Z(inflate);
        TiebaStatic.eventStat(this.doU.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cXB);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cXB);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cXB);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cXB);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cXB);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cXB);
        registerListener(this.aTT);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.doX != null) {
            this.doX.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.doU.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.cXB);
    }

    private void initData() {
        this.doT = new ImMessageCenterModel();
        go(com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void Z(View view) {
        this.bMV = (RelativeLayout) view.findViewById(r.g.chat_list);
        this.doZ = (ShutDownValidateTipView) view.findViewById(r.g.view_no_validate);
        this.doZ.setVisibility(8);
        this.doZ.setShutDownClickListener(new o(this));
        this.doW = (BdListView) view.findViewById(r.g.chat_list_content);
        this.doW.setDividerHeight(0);
        this.doY = new t(getPageContext());
        this.doY.a(this.aUZ);
        this.doY.setTag(getUniqueId());
        this.doW.setPullRefresh(this.doY);
        this.doX = new ImMessageCenterListAdapter(this.doU.getPageContext().getPageActivity());
        this.doW.setAdapter((ListAdapter) this.doX);
        this.doW.setOnItemClickListener(this.dpe);
        this.doW.setOnItemLongClickListener(this.dpf);
        this.doW.kv();
        this.Hi = (NoNetworkView) this.bMV.findViewById(r.g.view_no_network);
        if (!this.mIsLogin) {
            gn(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.dpc != i) {
            this.dpc = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.doU.getPageContext(), i);
            }
            if (this.doZ != null) {
                this.doZ.onChangeSkinType(i);
            }
            if (this.doY != null) {
                this.doY.dh(i);
            }
            if (this.doX != null) {
                this.doX.notifyDataSetChanged();
            }
            if (this.doU != null && (this.doU instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.doU).getLayoutMode().ah(i == 1);
                ((BaseFragmentActivity) this.doU).getLayoutMode().x(this.bMV);
            }
            if (this.Hi != null) {
                this.Hi.onChangeSkinType(this.doU.getPageContext(), i);
            }
        }
    }

    private void axs() {
        if (isAdded()) {
            if (this.mIsLogin) {
                axt();
            } else {
                axu();
            }
        }
    }

    private void axt() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(r.j.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.doU.getPageContext().getPageActivity(), this.bMV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(r.e.ds80)), NoDataViewFactory.d.de(r.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void axu() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(r.j.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(r.e.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(r.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(r.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(r.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.doU.getPageContext().getPageActivity(), this.bMV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, r.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.w(r.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(r.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        axs();
        if (!z) {
            gn(true);
        } else {
            gn(false);
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
        this.dpb = new h(this, imMessageCenterShowItemData);
        String string = this.doU.getPageContext().getPageActivity().getString(r.j.delete_user_chat);
        this.dpa = new com.baidu.tbadk.core.dialog.c(this.doU.getPageContext().getPageActivity());
        this.dpa.cc(r.j.operation);
        this.dpa.a(new String[]{string}, this.dpb);
        this.dpa.d(this.doU.getPageContext());
    }

    public void gm(boolean z) {
        if (z) {
            if (axv() && this.doZ.getVisibility() != 0) {
                this.doZ.setVisibility(0);
            }
        } else if (this.doZ.getVisibility() != 8) {
            this.doZ.setVisibility(8);
        }
    }

    public void gn(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                axs();
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

    public boolean axv() {
        return this.dpd;
    }

    public void go(boolean z) {
        this.dpd = z;
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
                if (this.doT != null) {
                    this.doT.insertOrUpdate(data, this.cXD);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.doT != null) {
                this.doT.remove(data, this.cXD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.doT != null) {
                this.doT.setData(data, this.cXD);
            }
        }
    }
}
