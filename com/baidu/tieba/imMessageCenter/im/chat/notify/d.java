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
    private ShutDownValidateTipView bsp;
    private com.baidu.tbadk.core.dialog.h bsr;
    private int bss;
    private RelativeLayout bsu;
    private x mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ImMessageCenterModel bsj = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> bsk = null;
    private ImMessageCenterShowItemData bsl = null;
    private BdListView bsm = null;
    private ImMessageCenterListAdapter bsn = null;
    private p bso = null;
    com.baidu.tbadk.core.dialog.e bsq = null;
    private boolean bst = true;
    private final AdapterView.OnItemClickListener mItemClickListener = new e(this);
    private final AdapterView.OnItemLongClickListener bsv = new g(this);
    private final aj aAq = new h(this);
    private final CustomMessageListener bcz = new i(this, 0);
    private com.baidu.tieba.im.chat.notify.a bcA = new j(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bss = -1;
        this.bsk = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(r.chat_list_activity, viewGroup, false);
        v(inflate);
        TiebaStatic.eventStat(this.bsk.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(2016004, this.bcz);
        registerListener(2016001, this.bcz);
        registerListener(2016010, this.bcz);
        registerListener(2016007, this.bcz);
        registerListener(2016011, this.bcz);
        registerListener(2016002, this.bcz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bsn != null) {
            this.bsn.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.bcz);
    }

    private void initData() {
        this.bsj = new ImMessageCenterModel();
        dn(com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void v(View view) {
        this.bsu = (RelativeLayout) view.findViewById(q.chat_list);
        this.bsp = (ShutDownValidateTipView) view.findViewById(q.view_no_validate);
        this.bsp.setVisibility(8);
        this.bsp.setShutDownClickListener(new k(this));
        this.bsm = (BdListView) view.findViewById(q.chat_list_content);
        this.bsm.setDividerHeight(0);
        this.bso = new p(getPageContext());
        this.bso.a(this.aAq);
        this.bso.setTag(getUniqueId());
        this.bsm.setPullRefresh(this.bso);
        this.bsn = new ImMessageCenterListAdapter(this.bsk.getPageContext().getPageActivity());
        this.bsn.g(this);
        this.bsm.setAdapter((ListAdapter) this.bsn);
        this.bsm.setOnItemClickListener(this.mItemClickListener);
        this.bsm.setOnItemLongClickListener(this.bsv);
        this.bsm.no();
        this.mNoNetworkView = (NoNetworkView) this.bsu.findViewById(q.view_no_network);
        if (!this.mIsLogin) {
            dm(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.bss != i) {
            this.bss = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.bsk.getPageContext(), i);
            }
            if (this.bsp != null) {
                this.bsp.onChangeSkinType(i);
            }
            if (this.bso != null) {
                this.bso.cy(i);
            }
            if (this.bsn != null) {
                this.bsn.notifyDataSetChanged();
            }
            if (this.bsk != null && (this.bsk instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.bsk).getLayoutMode().ab(i == 1);
                ((BaseFragmentActivity) this.bsk).getLayoutMode().j(this.bsu);
            }
            if (this.mNoNetworkView != null) {
                this.mNoNetworkView.onChangeSkinType(this.bsk.getPageContext(), i);
            }
        }
    }

    private void Vw() {
        if (isAdded()) {
            if (this.mIsLogin) {
                Vx();
            } else {
                Vy();
            }
        }
    }

    private void Vx() {
        z a = z.a(new y(getString(t.maintab_imcenter_button_text), new l(this)));
        this.mNoDataView = NoDataViewFactory.a(this.bsk.getPageContext().getPageActivity(), this.bsu, aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.o.ds80)), ab.cv(t.no_recent_chat), a);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void Vy() {
        y yVar = new y(getString(t.maintab_imcenter_unlogin_button_text), new m(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.baidu.tieba.o.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(com.baidu.tieba.o.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(com.baidu.tieba.o.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(com.baidu.tieba.o.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.bsk.getPageContext().getPageActivity(), this.bsu, aa.a(NoDataViewFactory.ImgType.LOCAL, com.baidu.tieba.p.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), ab.r(t.msg_center_unlogin_tip, dimensionPixelSize4), z.a(yVar, getResources().getDimensionPixelSize(com.baidu.tieba.o.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onUserChanged(boolean z) {
        super.onUserChanged(z);
        Vw();
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
            this.mNoDataView.e(this.bsk.getPageContext());
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
        this.bsr = new n(this, imMessageCenterShowItemData);
        String string = this.bsk.getPageContext().getPageActivity().getString(t.delete_user_chat);
        this.bsq = new com.baidu.tbadk.core.dialog.e(this.bsk.getPageContext().getPageActivity());
        this.bsq.bx(t.operation);
        this.bsq.a(new String[]{string}, this.bsr);
        this.bsq.d(this.bsk.getPageContext());
    }

    public void dl(boolean z) {
        if (z) {
            if (Vz() && this.bsp.getVisibility() != 0) {
                this.bsp.setVisibility(0);
            }
        } else if (this.bsp.getVisibility() != 8) {
            this.bsp.setVisibility(8);
        }
    }

    public void dm(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                Vw();
            }
            this.mNoDataView.setVisibility(0);
        } else if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        if (!isAdded()) {
        }
    }

    public boolean Vz() {
        return this.bst;
    }

    public void dn(boolean z) {
        this.bst = z;
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
                if (this.bsj != null) {
                    this.bsj.insertOrUpdate(data, this.bcA);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.bsj != null) {
                this.bsj.remove(data, this.bcA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.bsj != null) {
                this.bsj.setData(data, this.bcA);
            }
        }
    }
}
