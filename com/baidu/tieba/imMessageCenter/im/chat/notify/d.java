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
    private ShutDownValidateTipView bpJ;
    private com.baidu.tbadk.core.dialog.h bpL;
    private int bpM;
    private RelativeLayout bpO;
    private s mNoDataView;
    private NoNetworkView mNoNetworkView;
    private ImMessageCenterModel bpD = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> bpE = null;
    private ImMessageCenterShowItemData bpF = null;
    private BdListView bpG = null;
    private ImMessageCenterListAdapter bpH = null;
    private o bpI = null;
    com.baidu.tbadk.core.dialog.e bpK = null;
    private boolean bpN = true;
    private final AdapterView.OnItemClickListener bpP = new e(this);
    private final AdapterView.OnItemLongClickListener bpQ = new g(this);
    private final ae ayF = new h(this);
    private final CustomMessageListener aZS = new i(this, 0);
    private com.baidu.tieba.im.chat.notify.a aZT = new j(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bpM = -1;
        this.bpE = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(w.chat_list_activity, viewGroup, false);
        s(inflate);
        TiebaStatic.eventStat(this.bpE.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(2016003, this.aZS);
        registerListener(2016000, this.aZS);
        registerListener(2016010, this.aZS);
        registerListener(2016006, this.aZS);
        registerListener(2016011, this.aZS);
        registerListener(2016001, this.aZS);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bpH != null) {
            this.bpH.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.aZS);
    }

    private void initData() {
        this.bpD = new ImMessageCenterModel();
        dc(com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void s(View view) {
        this.bpO = (RelativeLayout) view.findViewById(v.chat_list);
        this.bpJ = (ShutDownValidateTipView) view.findViewById(v.view_no_validate);
        this.bpJ.setVisibility(8);
        this.bpJ.setShutDownClickListener(new k(this));
        this.bpG = (BdListView) view.findViewById(v.chat_list_content);
        this.bpG.setDividerHeight(0);
        this.bpI = new o(getPageContext());
        this.bpI.a(this.ayF);
        this.bpG.setPullRefresh(this.bpI);
        this.bpH = new ImMessageCenterListAdapter(this.bpE.getPageContext().getPageActivity());
        this.bpH.g(this);
        this.bpG.setAdapter((ListAdapter) this.bpH);
        this.bpG.setOnItemClickListener(this.bpP);
        this.bpG.setOnItemLongClickListener(this.bpQ);
        this.bpG.mX();
        this.mNoNetworkView = (NoNetworkView) this.bpO.findViewById(v.view_no_network);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.bpM != i) {
            this.bpM = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.bpE.getPageContext(), i);
            }
            if (this.bpJ != null) {
                this.bpJ.onChangeSkinType(i);
            }
            if (this.bpI != null) {
                this.bpI.ct(i);
            }
            if (this.bpH != null) {
                this.bpH.notifyDataSetChanged();
            }
            if (this.bpE != null && (this.bpE instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.bpE).getLayoutMode().X(i == 1);
                ((BaseFragmentActivity) this.bpE).getLayoutMode().h(this.bpO);
            }
            if (this.mNoNetworkView != null) {
                this.mNoNetworkView.onChangeSkinType(this.bpE.getPageContext(), i);
            }
        }
    }

    private void Uh() {
        u a = u.a(new t(getString(y.maintab_imcenter_button_text), new l(this)));
        this.mNoDataView = NoDataViewFactory.a(this.bpE.getPageContext().getPageActivity(), this.bpO, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), com.baidu.tbadk.core.view.w.cq(y.no_recent_chat), a);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.bpE.getPageContext());
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
        this.bpL = new m(this, imMessageCenterShowItemData);
        String string = this.bpE.getPageContext().getPageActivity().getString(y.delete_user_chat);
        this.bpK = new com.baidu.tbadk.core.dialog.e(this.bpE.getPageContext().getPageActivity());
        this.bpK.by(y.operation);
        this.bpK.a(new String[]{string}, this.bpL);
        this.bpK.d(this.bpE.getPageContext());
    }

    public void da(boolean z) {
        if (z) {
            if (Ui() && this.bpJ.getVisibility() != 0) {
                this.bpJ.setVisibility(0);
            }
        } else if (this.bpJ.getVisibility() != 8) {
            this.bpJ.setVisibility(8);
        }
    }

    public void db(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                Uh();
            }
            this.mNoDataView.setVisibility(0);
        } else if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        if (!isAdded()) {
        }
    }

    public boolean Ui() {
        return this.bpN;
    }

    public void dc(boolean z) {
        this.bpN = z;
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
                if (this.bpD != null) {
                    this.bpD.insertOrUpdate(data, this.aZT);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.bpD != null) {
                this.bpD.remove(data, this.aZT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.bpD != null) {
                this.bpD.setData(data, this.aZT);
            }
        }
    }
}
