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
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.aj;
import com.baidu.tbadk.core.view.x;
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class d extends BaseFragment {
    private ShutDownValidateTipView bsq;
    private com.baidu.tbadk.core.dialog.h bss;
    private int bst;
    private RelativeLayout bsv;
    private x mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ImMessageCenterModel bsk = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> bsl = null;
    private ImMessageCenterShowItemData bsm = null;
    private BdListView bsn = null;
    private ImMessageCenterListAdapter bso = null;
    private p bsp = null;
    com.baidu.tbadk.core.dialog.e bsr = null;
    private boolean bsu = true;
    private final AdapterView.OnItemClickListener mItemClickListener = new e(this);
    private final AdapterView.OnItemLongClickListener bsw = new g(this);
    private final aj aAr = new h(this);
    private final CustomMessageListener bcA = new i(this, 0);
    private com.baidu.tieba.im.chat.notify.a bcB = new j(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bst = -1;
        this.bsl = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(r.chat_list_activity, viewGroup, false);
        v(inflate);
        TiebaStatic.eventStat(this.bsl.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(2016004, this.bcA);
        registerListener(2016001, this.bcA);
        registerListener(2016010, this.bcA);
        registerListener(2016007, this.bcA);
        registerListener(2016011, this.bcA);
        registerListener(2016002, this.bcA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bso != null) {
            this.bso.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.bcA);
    }

    private void initData() {
        this.bsk = new ImMessageCenterModel();
        dn(com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void v(View view) {
        this.bsv = (RelativeLayout) view.findViewById(q.chat_list);
        this.bsq = (ShutDownValidateTipView) view.findViewById(q.view_no_validate);
        this.bsq.setVisibility(8);
        this.bsq.setShutDownClickListener(new k(this));
        this.bsn = (BdListView) view.findViewById(q.chat_list_content);
        this.bsn.setDividerHeight(0);
        this.bsp = new p(getPageContext());
        this.bsp.a(this.aAr);
        this.bsp.setTag(getUniqueId());
        this.bsn.setPullRefresh(this.bsp);
        this.bso = new ImMessageCenterListAdapter(this.bsl.getPageContext().getPageActivity());
        this.bso.g(this);
        this.bsn.setAdapter((ListAdapter) this.bso);
        this.bsn.setOnItemClickListener(this.mItemClickListener);
        this.bsn.setOnItemLongClickListener(this.bsw);
        this.bsn.no();
        this.mNoNetworkView = (NoNetworkView) this.bsv.findViewById(q.view_no_network);
        if (!this.mIsLogin) {
            dm(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.bst != i) {
            this.bst = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.bsl.getPageContext(), i);
            }
            if (this.bsq != null) {
                this.bsq.onChangeSkinType(i);
            }
            if (this.bsp != null) {
                this.bsp.cy(i);
            }
            if (this.bso != null) {
                this.bso.notifyDataSetChanged();
            }
            if (this.bsl != null && (this.bsl instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.bsl).getLayoutMode().ab(i == 1);
                ((BaseFragmentActivity) this.bsl).getLayoutMode().j(this.bsv);
            }
            if (this.mNoNetworkView != null) {
                this.mNoNetworkView.onChangeSkinType(this.bsl.getPageContext(), i);
            }
        }
    }

    private void Vx() {
        if (isAdded()) {
            if (this.mIsLogin) {
                Vy();
            } else {
                Vz();
            }
        }
    }

    private void Vy() {
        z a = z.a(new y(getString(t.maintab_imcenter_button_text), new l(this)));
        this.mNoDataView = NoDataViewFactory.a(this.bsl.getPageContext().getPageActivity(), this.bsv, aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.o.ds80)), ab.cv(t.no_recent_chat), a);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void Vz() {
        y yVar = new y(getString(t.maintab_imcenter_unlogin_button_text), new m(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.baidu.tieba.o.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(com.baidu.tieba.o.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(com.baidu.tieba.o.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(com.baidu.tieba.o.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.bsl.getPageContext().getPageActivity(), this.bsv, aa.a(NoDataViewFactory.ImgType.LOCAL, com.baidu.tieba.p.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), ab.r(t.msg_center_unlogin_tip, dimensionPixelSize4), z.a(yVar, getResources().getDimensionPixelSize(com.baidu.tieba.o.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onUserChanged(boolean z) {
        super.onUserChanged(z);
        Vx();
        if (!z) {
            dm(true);
        } else {
            dm(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.bsl.getPageContext());
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
        this.bss = new n(this, imMessageCenterShowItemData);
        String string = this.bsl.getPageContext().getPageActivity().getString(t.delete_user_chat);
        this.bsr = new com.baidu.tbadk.core.dialog.e(this.bsl.getPageContext().getPageActivity());
        this.bsr.bx(t.operation);
        this.bsr.a(new String[]{string}, this.bss);
        this.bsr.d(this.bsl.getPageContext());
    }

    public void dl(boolean z) {
        if (z) {
            if (VA() && this.bsq.getVisibility() != 0) {
                this.bsq.setVisibility(0);
            }
        } else if (this.bsq.getVisibility() != 8) {
            this.bsq.setVisibility(8);
        }
    }

    public void dm(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                Vx();
            }
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(0);
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public boolean VA() {
        return this.bsu;
    }

    public void dn(boolean z) {
        this.bsu = z;
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
                if (this.bsk != null) {
                    this.bsk.insertOrUpdate(data, this.bcB);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.bsk != null) {
                this.bsk.remove(data, this.bcB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.bsk != null) {
                this.bsk.setData(data, this.bcB);
            }
        }
    }
}
