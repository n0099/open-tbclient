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
    private NoNetworkView aSi;
    private RelativeLayout bLS;
    private ShutDownValidateTipView deb;
    private c.b ded;
    private int dee;
    private y mNoDataView;
    private ImMessageCenterModel ddV = null;
    private BdBaseFragmentActivity<BaseFragmentActivity> ddW = null;
    private ImMessageCenterShowItemData ddX = null;
    private BdListView ddY = null;
    private ImMessageCenterListAdapter ddZ = null;
    private t dea = null;
    com.baidu.tbadk.core.dialog.c dec = null;
    private boolean def = true;
    private final CustomMessageListener aXT = new g(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final AdapterView.OnItemClickListener deg = new i(this);
    private final AdapterView.OnItemLongClickListener deh = new k(this);
    private final ae.b aYZ = new l(this);
    private final CustomMessageListener cMx = new m(this, 0);
    private com.baidu.tieba.im.chat.a.a cMz = new n(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dee = 3;
        this.ddW = getBaseFragmentActivity();
        View inflate = layoutInflater.inflate(w.j.chat_list_activity, viewGroup, false);
        ab(inflate);
        TiebaStatic.eventStat(this.ddW.getPageContext().getContext(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        return inflate;
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cMx);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cMx);
        registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cMx);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cMx);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cMx);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cMx);
        registerListener(this.aXT);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ddZ != null) {
            this.ddZ.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.mNoDataView != null) {
                this.mNoDataView.e(this.ddW.getPageContext());
            }
        } else if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.cMx);
    }

    private void initData() {
        this.ddV = new ImMessageCenterModel();
        fX(com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void ab(View view) {
        this.bLS = (RelativeLayout) view.findViewById(w.h.chat_list);
        this.deb = (ShutDownValidateTipView) view.findViewById(w.h.view_no_validate);
        this.deb.setVisibility(8);
        this.deb.setShutDownClickListener(new o(this));
        this.ddY = (BdListView) view.findViewById(w.h.chat_list_content);
        this.ddY.setDividerHeight(0);
        this.dea = new t(getPageContext());
        this.dea.a(this.aYZ);
        this.dea.setTag(getUniqueId());
        this.ddY.setPullRefresh(this.dea);
        this.ddZ = new ImMessageCenterListAdapter(this.ddW.getPageContext().getPageActivity());
        this.ddY.setAdapter((ListAdapter) this.ddZ);
        this.ddY.setOnItemClickListener(this.deg);
        this.ddY.setOnItemLongClickListener(this.deh);
        this.ddY.startPullRefresh();
        this.aSi = (NoNetworkView) this.bLS.findViewById(w.h.view_no_network);
        if (!this.mIsLogin) {
            fW(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (isAdded() && this.dee != i) {
            this.dee = i;
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.ddW.getPageContext(), i);
            }
            if (this.deb != null) {
                this.deb.onChangeSkinType(i);
            }
            if (this.dea != null) {
                this.dea.di(i);
            }
            if (this.ddZ != null) {
                this.ddZ.notifyDataSetChanged();
            }
            if (this.ddW != null && (this.ddW instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.ddW).getLayoutMode().ai(i == 1);
                ((BaseFragmentActivity) this.ddW).getLayoutMode().t(this.bLS);
            }
            if (this.aSi != null) {
                this.aSi.onChangeSkinType(this.ddW.getPageContext(), i);
            }
        }
    }

    private void ase() {
        if (isAdded()) {
            if (this.mIsLogin) {
                asf();
            } else {
                asg();
            }
        }
    }

    private void asf() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(getString(w.l.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.ddW.getPageContext().getPageActivity(), this.bLS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(w.f.ds80)), NoDataViewFactory.d.dd(w.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void asg() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(getString(w.l.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds100);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(w.f.ds480);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(w.f.ds360);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(w.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.ddW.getPageContext().getPageActivity(), this.bLS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, w.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(w.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, getResources().getDimensionPixelSize(w.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        ase();
        if (!z) {
            fW(true);
        } else {
            fW(false);
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
        this.ded = new h(this, imMessageCenterShowItemData);
        String string = this.ddW.getPageContext().getPageActivity().getString(w.l.delete_user_chat);
        this.dec = new com.baidu.tbadk.core.dialog.c(this.ddW.getPageContext().getPageActivity());
        this.dec.ca(w.l.operation);
        this.dec.a(new String[]{string}, this.ded);
        this.dec.d(this.ddW.getPageContext());
    }

    public void fV(boolean z) {
        if (z) {
            if (ash() && this.deb.getVisibility() != 0) {
                this.deb.setVisibility(0);
            }
        } else if (this.deb.getVisibility() != 8) {
            this.deb.setVisibility(8);
        }
    }

    public void fW(boolean z) {
        if (z) {
            if (this.mNoDataView == null) {
                ase();
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

    public boolean ash() {
        return this.def;
    }

    public void fX(boolean z) {
        this.def = z;
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
                if (this.ddV != null) {
                    this.ddV.insertOrUpdate(data, this.cMz);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.ddV != null) {
                this.ddV.remove(data, this.cMz);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.ddV != null) {
                this.ddV.setData(data, this.cMz);
            }
        }
    }
}
