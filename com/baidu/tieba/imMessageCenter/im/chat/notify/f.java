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
import com.baidu.tbadk.core.view.w;
import com.baidu.tbadk.core.view.z;
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
    private NoNetworkView Hj;
    private RelativeLayout bvS;
    private ShutDownValidateTipView cZC;
    private c.b cZE;
    private int cZF;
    private w mNoDataView;
    private ImMessageCenterModel cZw = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> cZx = null;
    private ImMessageCenterShowItemData cZy = null;
    private BdListView cZz = null;
    private ImMessageCenterListAdapter cZA = null;
    private t cZB = null;
    com.baidu.tbadk.core.dialog.c cZD = null;
    private boolean cZG = true;
    private final CustomMessageListener aVv = new g(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener cZH = new i(this);
    private final AdapterView.OnItemLongClickListener cZI = new k(this);
    private final z.b aWB = new l(this);
    private final CustomMessageListener cIj = new m(this, 0);
    private com.baidu.tieba.im.chat.a.a cIl = new n(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cZF = 3;
        this.cZx = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(r.h.chat_list_activity, viewGroup, false);
        aa(inflate);
        TiebaStatic.eventStat(this.cZx.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cIj);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cIj);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cIj);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cIj);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cIj);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cIj);
        registerListener(this.aVv);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cZA != null) {
            this.cZA.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.cZx.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.cIj);
    }

    private void initData() {
        this.cZw = new ImMessageCenterModel();
        gs(com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void aa(View view) {
        this.bvS = (RelativeLayout) view.findViewById(r.g.chat_list);
        this.cZC = (ShutDownValidateTipView) view.findViewById(r.g.view_no_validate);
        this.cZC.setVisibility(8);
        this.cZC.setShutDownClickListener(new o(this));
        this.cZz = (BdListView) view.findViewById(r.g.chat_list_content);
        this.cZz.setDividerHeight(0);
        this.cZB = new t(getPageContext());
        this.cZB.a(this.aWB);
        this.cZB.setTag(getUniqueId());
        this.cZz.setPullRefresh(this.cZB);
        this.cZA = new ImMessageCenterListAdapter(this.cZx.getPageContext().getPageActivity());
        this.cZz.setAdapter((ListAdapter) this.cZA);
        this.cZz.setOnItemClickListener(this.cZH);
        this.cZz.setOnItemLongClickListener(this.cZI);
        this.cZz.kv();
        this.Hj = (NoNetworkView) this.bvS.findViewById(r.g.view_no_network);
        if (!this.mIsLogin) {
            gr(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.cZF != i) {
            this.cZF = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.cZx.getPageContext(), i);
            }
            if (this.cZC != null) {
                this.cZC.onChangeSkinType(i);
            }
            if (this.cZB != null) {
                this.cZB.dk(i);
            }
            if (this.cZA != null) {
                this.cZA.notifyDataSetChanged();
            }
            if (this.cZx != null && (this.cZx instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.cZx).getLayoutMode().ai(i == 1);
                ((BaseFragmentActivity) this.cZx).getLayoutMode().x(this.bvS);
            }
            if (this.Hj != null) {
                this.Hj.onChangeSkinType(this.cZx.getPageContext(), i);
            }
        }
    }

    private void atO() {
        if (isAdded()) {
            if (this.mIsLogin) {
                atP();
            } else {
                atQ();
            }
        }
    }

    private void atP() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(r.j.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.cZx.getPageContext().getPageActivity(), this.bvS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(r.e.ds80)), NoDataViewFactory.d.dh(r.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void atQ() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(r.j.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(r.e.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(r.e.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(r.e.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(r.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.cZx.getPageContext().getPageActivity(), this.bvS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, r.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.w(r.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(r.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        atO();
        if (!z) {
            gr(true);
        } else {
            gr(false);
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
        this.cZE = new h(this, imMessageCenterShowItemData);
        String string = this.cZx.getPageContext().getPageActivity().getString(r.j.delete_user_chat);
        this.cZD = new com.baidu.tbadk.core.dialog.c(this.cZx.getPageContext().getPageActivity());
        this.cZD.ce(r.j.operation);
        this.cZD.a(new String[]{string}, this.cZE);
        this.cZD.d(this.cZx.getPageContext());
    }

    public void gq(boolean z) {
        if (z) {
            if (atR() && this.cZC.getVisibility() != 0) {
                this.cZC.setVisibility(0);
            }
        } else if (this.cZC.getVisibility() != 8) {
            this.cZC.setVisibility(8);
        }
    }

    public void gr(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                atO();
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

    public boolean atR() {
        return this.cZG;
    }

    public void gs(boolean z) {
        this.cZG = z;
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
                if (this.cZw != null) {
                    this.cZw.insertOrUpdate(data, this.cIl);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.cZw != null) {
                this.cZw.remove(data, this.cIl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.cZw != null) {
                this.cZw.setData(data, this.cIl);
            }
        }
    }
}
