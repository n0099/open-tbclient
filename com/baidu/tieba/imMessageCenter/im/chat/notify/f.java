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
import com.baidu.tbadk.core.view.ae;
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
/* loaded from: classes2.dex */
public class f extends BaseFragment {
    private NoNetworkView aZX;
    private RelativeLayout bRF;
    private ShutDownValidateTipView djw;
    private c.b djy;
    private int djz;
    private y mNoDataView;
    private ImMessageCenterModel djq = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> djr = null;
    private ImMessageCenterShowItemData djs = null;
    private BdListView djt = null;
    private ImMessageCenterListAdapter dju = null;
    private t djv = null;
    com.baidu.tbadk.core.dialog.c djx = null;
    private boolean djA = true;
    private final CustomMessageListener aVv = new g(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener djB = new i(this);
    private final AdapterView.OnItemLongClickListener djC = new k(this);
    private final ae.b aWB = new l(this);
    private final CustomMessageListener cRV = new m(this, 0);
    private com.baidu.tieba.im.chat.a.a cRX = new n(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.djz = 3;
        this.djr = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(w.j.chat_list_activity, viewGroup, false);
        ab(inflate);
        TiebaStatic.eventStat(this.djr.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cRV);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cRV);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cRV);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cRV);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cRV);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cRV);
        registerListener(this.aVv);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dju != null) {
            this.dju.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.djr.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.cRV);
    }

    private void initData() {
        this.djq = new ImMessageCenterModel();
        gk(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void ab(View view) {
        this.bRF = (RelativeLayout) view.findViewById(w.h.chat_list);
        this.djw = (ShutDownValidateTipView) view.findViewById(w.h.view_no_validate);
        this.djw.setVisibility(8);
        this.djw.setShutDownClickListener(new o(this));
        this.djt = (BdListView) view.findViewById(w.h.chat_list_content);
        this.djt.setDividerHeight(0);
        this.djv = new t(getPageContext());
        this.djv.a(this.aWB);
        this.djv.setTag(getUniqueId());
        this.djt.setPullRefresh(this.djv);
        this.dju = new ImMessageCenterListAdapter(this.djr.getPageContext().getPageActivity());
        this.djt.setAdapter((ListAdapter) this.dju);
        this.djt.setOnItemClickListener(this.djB);
        this.djt.setOnItemLongClickListener(this.djC);
        this.djt.startPullRefresh();
        this.aZX = (NoNetworkView) this.bRF.findViewById(w.h.view_no_network);
        if (!this.mIsLogin) {
            gj(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.djz != i) {
            this.djz = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.djr.getPageContext(), i);
            }
            if (this.djw != null) {
                this.djw.onChangeSkinType(i);
            }
            if (this.djv != null) {
                this.djv.dj(i);
            }
            if (this.dju != null) {
                this.dju.notifyDataSetChanged();
            }
            if (this.djr != null && (this.djr instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.djr).getLayoutMode().ah(i == 1);
                ((BaseFragmentActivity) this.djr).getLayoutMode().t(this.bRF);
            }
            if (this.aZX != null) {
                this.aZX.onChangeSkinType(this.djr.getPageContext(), i);
            }
        }
    }

    private void atc() {
        if (isAdded()) {
            if (this.mIsLogin) {
                atd();
            } else {
                LM();
            }
        }
    }

    private void atd() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(w.l.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.djr.getPageContext().getPageActivity(), this.bRF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(w.f.ds80)), NoDataViewFactory.d.de(w.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void LM() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(w.l.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(w.f.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(w.f.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(w.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.djr.getPageContext().getPageActivity(), this.bRF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, w.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.A(w.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(w.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        atc();
        if (!z) {
            gj(true);
        } else {
            gj(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.djy = new h(this, imMessageCenterShowItemData);
        String string = this.djr.getPageContext().getPageActivity().getString(w.l.delete_user_chat);
        this.djx = new com.baidu.tbadk.core.dialog.c(this.djr.getPageContext().getPageActivity());
        this.djx.cb(w.l.operation);
        this.djx.a(new String[]{string}, this.djy);
        this.djx.d(this.djr.getPageContext());
    }

    public void gi(boolean z) {
        if (z) {
            if (ate() && this.djw.getVisibility() != 0) {
                this.djw.setVisibility(0);
            }
        } else if (this.djw.getVisibility() != 8) {
            this.djw.setVisibility(8);
        }
    }

    public void gj(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                atc();
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

    public boolean ate() {
        return this.djA;
    }

    public void gk(boolean z) {
        this.djA = z;
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
                if (this.djq != null) {
                    this.djq.insertOrUpdate(data, this.cRX);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.djq != null) {
                this.djq.remove(data, this.cRX);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.djq != null) {
                this.djq.setData(data, this.cRX);
            }
        }
    }
}
