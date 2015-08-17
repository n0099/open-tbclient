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
    private ShutDownValidateTipView bGh;
    private c.b bGj;
    private int bGk;
    private RelativeLayout bGm;
    private u mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ImMessageCenterModel bGb = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> bGc = null;
    private ImMessageCenterShowItemData bGd = null;
    private BdListView bGe = null;
    private ImMessageCenterListAdapter bGf = null;
    private r bGg = null;
    com.baidu.tbadk.core.dialog.c bGi = null;
    private boolean bGl = true;
    private final CustomMessageListener aGE = new f(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener mItemClickListener = new h(this);
    private final AdapterView.OnItemLongClickListener bGn = new j(this);
    private final x.a aHL = new k(this);
    private final CustomMessageListener bqu = new l(this, 0);
    private com.baidu.tieba.im.chat.notify.a bqv = new m(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bGk = -1;
        this.bGc = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(i.g.chat_list_activity, viewGroup, false);
        x(inflate);
        TiebaStatic.eventStat(this.bGc.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.bqu);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.bqu);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.bqu);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.bqu);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.bqu);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.bqu);
        registerListener(this.aGE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bGf != null) {
            this.bGf.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.bGc.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.bqu);
    }

    private void initData() {
        this.bGb = new ImMessageCenterModel();
        dr(com.baidu.tbadk.core.sharedPref.b.ts().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void x(View view) {
        this.bGm = (RelativeLayout) view.findViewById(i.f.chat_list);
        this.bGh = (ShutDownValidateTipView) view.findViewById(i.f.view_no_validate);
        this.bGh.setVisibility(8);
        this.bGh.setShutDownClickListener(new n(this));
        this.bGe = (BdListView) view.findViewById(i.f.chat_list_content);
        this.bGe.setDividerHeight(0);
        this.bGg = new r(getPageContext());
        this.bGg.a(this.aHL);
        this.bGg.setTag(getUniqueId());
        this.bGe.setPullRefresh(this.bGg);
        this.bGf = new ImMessageCenterListAdapter(this.bGc.getPageContext().getPageActivity());
        this.bGf.g(this);
        this.bGe.setAdapter((ListAdapter) this.bGf);
        this.bGe.setOnItemClickListener(this.mItemClickListener);
        this.bGe.setOnItemLongClickListener(this.bGn);
        this.bGe.ny();
        this.mNoNetworkView = (NoNetworkView) this.bGm.findViewById(i.f.view_no_network);
        if (!this.mIsLogin) {
            dq(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.bGk != i) {
            this.bGk = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.bGc.getPageContext(), i);
            }
            if (this.bGh != null) {
                this.bGh.onChangeSkinType(i);
            }
            if (this.bGg != null) {
                this.bGg.cG(i);
            }
            if (this.bGf != null) {
                this.bGf.notifyDataSetChanged();
            }
            if (this.bGc != null && (this.bGc instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.bGc).getLayoutMode().ad(i == 1);
                ((BaseFragmentActivity) this.bGc).getLayoutMode().k(this.bGm);
            }
            if (this.mNoNetworkView != null) {
                this.mNoNetworkView.onChangeSkinType(this.bGc.getPageContext(), i);
            }
        }
    }

    private void Xe() {
        if (isAdded()) {
            if (this.mIsLogin) {
                Xf();
            } else {
                Xg();
            }
        }
    }

    private void Xf() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(i.C0057i.maintab_imcenter_button_text), new o(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.bGc.getPageContext().getPageActivity(), this.bGm, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(i.d.ds80)), NoDataViewFactory.d.cD(i.C0057i.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void Xg() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(i.C0057i.maintab_imcenter_unlogin_button_text), new p(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(i.d.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(i.d.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(i.d.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.bGc.getPageContext().getPageActivity(), this.bGm, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, i.e.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(i.C0057i.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(i.d.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        Xe();
        if (!z) {
            dq(true);
        } else {
            dq(false);
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
        this.bGj = new g(this, imMessageCenterShowItemData);
        String string = this.bGc.getPageContext().getPageActivity().getString(i.C0057i.delete_user_chat);
        this.bGi = new com.baidu.tbadk.core.dialog.c(this.bGc.getPageContext().getPageActivity());
        this.bGi.bF(i.C0057i.operation);
        this.bGi.a(new String[]{string}, this.bGj);
        this.bGi.d(this.bGc.getPageContext());
    }

    public void dp(boolean z) {
        if (z) {
            if (Xh() && this.bGh.getVisibility() != 0) {
                this.bGh.setVisibility(0);
            }
        } else if (this.bGh.getVisibility() != 8) {
            this.bGh.setVisibility(8);
        }
    }

    public void dq(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                Xe();
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

    public boolean Xh() {
        return this.bGl;
    }

    public void dr(boolean z) {
        this.bGl = z;
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
                if (this.bGb != null) {
                    this.bGb.insertOrUpdate(data, this.bqv);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.bGb != null) {
                this.bGb.remove(data, this.bqv);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.bGb != null) {
                this.bGb.setData(data, this.bqv);
            }
        }
    }
}
