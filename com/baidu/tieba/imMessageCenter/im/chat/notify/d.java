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
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.core.view.u;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
public class d extends BaseFragment {
    private ShutDownValidateTipView bpt;
    private com.baidu.tbadk.core.dialog.h bpv;
    private int bpw;
    private RelativeLayout bpy;
    private s mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ImMessageCenterModel bpn = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> bpo = null;
    private ImMessageCenterShowItemData bpp = null;
    private BdListView bpq = null;
    private ImMessageCenterListAdapter bpr = null;
    private o bps = null;
    com.baidu.tbadk.core.dialog.e bpu = null;
    private boolean bpx = true;
    private final AdapterView.OnItemClickListener bpz = new e(this);
    private final AdapterView.OnItemLongClickListener bpA = new g(this);
    private final ae ayx = new h(this);
    private final CustomMessageListener aZC = new i(this, 0);
    private com.baidu.tieba.im.chat.notify.a aZD = new j(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bpw = -1;
        this.bpo = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(w.chat_list_activity, viewGroup, false);
        s(inflate);
        TiebaStatic.eventStat(this.bpo.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(2016003, this.aZC);
        registerListener(2016000, this.aZC);
        registerListener(2016010, this.aZC);
        registerListener(2016006, this.aZC);
        registerListener(2016011, this.aZC);
        registerListener(2016001, this.aZC);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bpr != null) {
            this.bpr.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.aZC);
    }

    private void initData() {
        this.bpn = new ImMessageCenterModel();
        de(com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void s(View view) {
        this.bpy = (RelativeLayout) view.findViewById(v.chat_list);
        this.bpt = (ShutDownValidateTipView) view.findViewById(v.view_no_validate);
        this.bpt.setVisibility(8);
        this.bpt.setShutDownClickListener(new k(this));
        this.bpq = (BdListView) view.findViewById(v.chat_list_content);
        this.bpq.setDividerHeight(0);
        this.bps = new o(getPageContext());
        this.bps.a(this.ayx);
        this.bpq.setPullRefresh(this.bps);
        this.bpr = new ImMessageCenterListAdapter(this.bpo.getPageContext().getPageActivity());
        this.bpr.g(this);
        this.bpq.setAdapter((ListAdapter) this.bpr);
        this.bpq.setOnItemClickListener(this.bpz);
        this.bpq.setOnItemLongClickListener(this.bpA);
        this.bpq.mX();
        this.mNoNetworkView = (NoNetworkView) this.bpy.findViewById(v.view_no_network);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.bpw != i) {
            this.bpw = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.bpo.getPageContext(), i);
            }
            if (this.bpt != null) {
                this.bpt.onChangeSkinType(i);
            }
            if (this.bps != null) {
                this.bps.ct(i);
            }
            if (this.bpr != null) {
                this.bpr.notifyDataSetChanged();
            }
            if (this.bpo != null && (this.bpo instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.bpo).getLayoutMode().X(i == 1);
                ((BaseFragmentActivity) this.bpo).getLayoutMode().h(this.bpy);
            }
            if (this.mNoNetworkView != null) {
                this.mNoNetworkView.onChangeSkinType(this.bpo.getPageContext(), i);
            }
        }
    }

    private void TU() {
        u a = u.a(new t(getString(y.maintab_imcenter_button_text), new l(this)));
        this.mNoDataView = NoDataViewFactory.a(this.bpo.getPageContext().getPageActivity(), this.bpy, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), com.baidu.tbadk.core.view.w.cq(y.no_recent_chat), a);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.bpo.getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bpv = new m(this, imMessageCenterShowItemData);
        String string = this.bpo.getPageContext().getPageActivity().getString(y.delete_user_chat);
        this.bpu = new com.baidu.tbadk.core.dialog.e(this.bpo.getPageContext().getPageActivity());
        this.bpu.by(y.operation);
        this.bpu.a(new String[]{string}, this.bpv);
        this.bpu.d(this.bpo.getPageContext());
    }

    public void dc(boolean z) {
        if (z) {
            if (TV() && this.bpt.getVisibility() != 0) {
                this.bpt.setVisibility(0);
            }
        } else if (this.bpt.getVisibility() != 8) {
            this.bpt.setVisibility(8);
        }
    }

    public void dd(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                TU();
            }
            this.mNoDataView.setVisibility(0);
        } else if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        if (!isAdded()) {
        }
    }

    public boolean TV() {
        return this.bpx;
    }

    public void de(boolean z) {
        this.bpx = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                if (this.bpn != null) {
                    this.bpn.insertOrUpdate(data, this.aZD);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.bpn != null) {
                this.bpn.remove(data, this.aZD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.bpn != null) {
                this.bpn.setData(data, this.aZD);
            }
        }
    }
}
