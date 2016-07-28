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
    private NoNetworkView EV;
    private RelativeLayout bBw;
    private ShutDownValidateTipView dbT;
    private c.b dbV;
    private int dbW;
    private com.baidu.tbadk.core.view.q mNoDataView;
    private ImMessageCenterModel dbN = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> dbO = null;
    private ImMessageCenterShowItemData dbP = null;
    private BdListView dbQ = null;
    private ImMessageCenterListAdapter dbR = null;
    private t dbS = null;
    com.baidu.tbadk.core.dialog.c dbU = null;
    private boolean dbX = true;
    private final CustomMessageListener aNP = new g(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener dbY = new i(this);
    private final AdapterView.OnItemLongClickListener dbZ = new k(this);
    private final t.b aOV = new l(this);
    private final CustomMessageListener cKz = new m(this, 0);
    private com.baidu.tieba.im.chat.notify.a cKB = new n(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dbW = 3;
        this.dbO = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(u.h.chat_list_activity, viewGroup, false);
        Z(inflate);
        TiebaStatic.eventStat(this.dbO.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cKz);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cKz);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cKz);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cKz);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cKz);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cKz);
        registerListener(this.aNP);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dbR != null) {
            this.dbR.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.dbO.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.cKz);
    }

    private void initData() {
        this.dbN = new ImMessageCenterModel();
        fP(com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void Z(View view) {
        this.bBw = (RelativeLayout) view.findViewById(u.g.chat_list);
        this.dbT = (ShutDownValidateTipView) view.findViewById(u.g.view_no_validate);
        this.dbT.setVisibility(8);
        this.dbT.setShutDownClickListener(new o(this));
        this.dbQ = (BdListView) view.findViewById(u.g.chat_list_content);
        this.dbQ.setDividerHeight(0);
        this.dbS = new t(getPageContext());
        this.dbS.a(this.aOV);
        this.dbS.setTag(getUniqueId());
        this.dbQ.setPullRefresh(this.dbS);
        this.dbR = new ImMessageCenterListAdapter(this.dbO.getPageContext().getPageActivity());
        this.dbQ.setAdapter((ListAdapter) this.dbR);
        this.dbQ.setOnItemClickListener(this.dbY);
        this.dbQ.setOnItemLongClickListener(this.dbZ);
        this.dbQ.jA();
        this.EV = (NoNetworkView) this.bBw.findViewById(u.g.view_no_network);
        if (!this.mIsLogin) {
            fO(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.dbW != i) {
            this.dbW = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.dbO.getPageContext(), i);
            }
            if (this.dbT != null) {
                this.dbT.onChangeSkinType(i);
            }
            if (this.dbS != null) {
                this.dbS.cT(i);
            }
            if (this.dbR != null) {
                this.dbR.notifyDataSetChanged();
            }
            if (this.dbO != null && (this.dbO instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.dbO).getLayoutMode().af(i == 1);
                ((BaseFragmentActivity) this.dbO).getLayoutMode().w(this.bBw);
            }
            if (this.EV != null) {
                this.EV.onChangeSkinType(this.dbO.getPageContext(), i);
            }
        }
    }

    private void asf() {
        if (isAdded()) {
            if (this.mIsLogin) {
                asg();
            } else {
                ash();
            }
        }
    }

    private void asg() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m10getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(u.j.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dbO.getPageContext().getPageActivity(), this.bBw, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(u.e.ds80)), NoDataViewFactory.d.cQ(u.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m10getInst().getSkinType());
    }

    private void ash() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(u.j.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(u.e.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(u.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(u.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(u.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dbO.getPageContext().getPageActivity(), this.bBw, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, u.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.u(u.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(u.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m10getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        asf();
        if (!z) {
            fO(true);
        } else {
            fO(false);
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
        this.dbV = new h(this, imMessageCenterShowItemData);
        String string = this.dbO.getPageContext().getPageActivity().getString(u.j.delete_user_chat);
        this.dbU = new com.baidu.tbadk.core.dialog.c(this.dbO.getPageContext().getPageActivity());
        this.dbU.bP(u.j.operation);
        this.dbU.a(new String[]{string}, this.dbV);
        this.dbU.d(this.dbO.getPageContext());
    }

    public void fN(boolean z) {
        if (z) {
            if (asi() && this.dbT.getVisibility() != 0) {
                this.dbT.setVisibility(0);
            }
        } else if (this.dbT.getVisibility() != 8) {
            this.dbT.setVisibility(8);
        }
    }

    public void fO(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                asf();
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

    public boolean asi() {
        return this.dbX;
    }

    public void fP(boolean z) {
        this.dbX = z;
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
                if (this.dbN != null) {
                    this.dbN.insertOrUpdate(data, this.cKB);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dbN != null) {
                this.dbN.remove(data, this.cKB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dbN != null) {
                this.dbN.setData(data, this.cKB);
            }
        }
    }
}
