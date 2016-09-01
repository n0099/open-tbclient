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
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class f extends BaseFragment {
    private NoNetworkView Hi;
    private RelativeLayout bMY;
    private ShutDownValidateTipView dnB;
    private c.b dnD;
    private int dnE;
    private com.baidu.tbadk.core.view.q mNoDataView;
    private ImMessageCenterModel dnv = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> dnw = null;
    private ImMessageCenterShowItemData dnx = null;
    private BdListView dny = null;
    private ImMessageCenterListAdapter dnz = null;
    private t dnA = null;
    com.baidu.tbadk.core.dialog.c dnC = null;
    private boolean dnF = true;
    private final CustomMessageListener aTj = new g(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener dnG = new i(this);
    private final AdapterView.OnItemLongClickListener dnH = new k(this);
    private final t.b aUp = new l(this);
    private final CustomMessageListener cWe = new m(this, 0);
    private com.baidu.tieba.im.chat.notify.a cWg = new n(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dnE = 3;
        this.dnw = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(t.h.chat_list_activity, viewGroup, false);
        Z(inflate);
        TiebaStatic.eventStat(this.dnw.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cWe);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cWe);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cWe);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cWe);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cWe);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cWe);
        registerListener(this.aTj);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dnz != null) {
            this.dnz.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.dnw.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.cWe);
    }

    private void initData() {
        this.dnv = new ImMessageCenterModel();
        gl(com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void Z(View view) {
        this.bMY = (RelativeLayout) view.findViewById(t.g.chat_list);
        this.dnB = (ShutDownValidateTipView) view.findViewById(t.g.view_no_validate);
        this.dnB.setVisibility(8);
        this.dnB.setShutDownClickListener(new o(this));
        this.dny = (BdListView) view.findViewById(t.g.chat_list_content);
        this.dny.setDividerHeight(0);
        this.dnA = new t(getPageContext());
        this.dnA.a(this.aUp);
        this.dnA.setTag(getUniqueId());
        this.dny.setPullRefresh(this.dnA);
        this.dnz = new ImMessageCenterListAdapter(this.dnw.getPageContext().getPageActivity());
        this.dny.setAdapter((ListAdapter) this.dnz);
        this.dny.setOnItemClickListener(this.dnG);
        this.dny.setOnItemLongClickListener(this.dnH);
        this.dny.kv();
        this.Hi = (NoNetworkView) this.bMY.findViewById(t.g.view_no_network);
        if (!this.mIsLogin) {
            gk(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.dnE != i) {
            this.dnE = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.dnw.getPageContext(), i);
            }
            if (this.dnB != null) {
                this.dnB.onChangeSkinType(i);
            }
            if (this.dnA != null) {
                this.dnA.dh(i);
            }
            if (this.dnz != null) {
                this.dnz.notifyDataSetChanged();
            }
            if (this.dnw != null && (this.dnw instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.dnw).getLayoutMode().ah(i == 1);
                ((BaseFragmentActivity) this.dnw).getLayoutMode().x(this.bMY);
            }
            if (this.Hi != null) {
                this.Hi.onChangeSkinType(this.dnw.getPageContext(), i);
            }
        }
    }

    private void awT() {
        if (isAdded()) {
            if (this.mIsLogin) {
                awU();
            } else {
                awV();
            }
        }
    }

    private void awU() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(t.j.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dnw.getPageContext().getPageActivity(), this.bMY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(t.e.ds80)), NoDataViewFactory.d.de(t.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void awV() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(t.j.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(t.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(t.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(t.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dnw.getPageContext().getPageActivity(), this.bMY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, t.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.w(t.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(t.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        awT();
        if (!z) {
            gk(true);
        } else {
            gk(false);
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
        this.dnD = new h(this, imMessageCenterShowItemData);
        String string = this.dnw.getPageContext().getPageActivity().getString(t.j.delete_user_chat);
        this.dnC = new com.baidu.tbadk.core.dialog.c(this.dnw.getPageContext().getPageActivity());
        this.dnC.cc(t.j.operation);
        this.dnC.a(new String[]{string}, this.dnD);
        this.dnC.d(this.dnw.getPageContext());
    }

    public void gj(boolean z) {
        if (z) {
            if (awW() && this.dnB.getVisibility() != 0) {
                this.dnB.setVisibility(0);
            }
        } else if (this.dnB.getVisibility() != 8) {
            this.dnB.setVisibility(8);
        }
    }

    public void gk(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                awT();
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

    public boolean awW() {
        return this.dnF;
    }

    public void gl(boolean z) {
        this.dnF = z;
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
                if (this.dnv != null) {
                    this.dnv.insertOrUpdate(data, this.cWg);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dnv != null) {
                this.dnv.remove(data, this.cWg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dnv != null) {
                this.dnv.setData(data, this.cWg);
            }
        }
    }
}
