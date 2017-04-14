package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.e<ad> implements ab.b {
    private NoNetworkView aRL;
    private final CustomMessageListener aXu;
    private View alm;
    private NavigationBar bIh;
    private RelativeLayout bKx;
    private final CustomMessageListener bNF;
    private View byr;
    private final CustomMessageListener cQe;
    private com.baidu.tieba.im.chat.a.a cQg;
    private ImMessageCenterModel dhC;
    private ImMessageCenterShowItemData dhE;
    private BdListView dhF;
    private ShutDownValidateTipView dhI;
    com.baidu.tbadk.core.dialog.c dhJ;
    private c.b dhK;
    private int dhL;
    private boolean dhM;
    private final AdapterView.OnItemClickListener dhN;
    private final AdapterView.OnItemLongClickListener dhO;
    private int dkA;
    private TextView dkB;
    private CustomMessageListener dkC;
    private final ad dkv;
    private MessageAggregationListAdapter dkw;
    private boolean dkx;
    private boolean dky;
    private boolean dkz;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private View rootView;

    public l(ad adVar) {
        super(com.baidu.adp.base.k.Z(adVar.getPageContext().getPageActivity()));
        this.dhC = null;
        this.dhE = null;
        this.dhF = null;
        this.dkw = null;
        this.dhJ = null;
        this.dhM = true;
        this.dkx = false;
        this.dky = false;
        this.dkz = true;
        this.dkA = 16;
        this.aXu = new m(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
        this.dkC = new t(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
        this.dhN = new u(this);
        this.dhO = new w(this);
        this.cQe = new x(this, 0);
        this.cQg = new y(this);
        this.bNF = new z(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.dkv = adVar;
    }

    public void h(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.dkA = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.dkA = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.dkA);
        }
    }

    public void abE() {
        if (this.dkw != null) {
            this.dkw.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cQe);
    }

    public View Uq() {
        this.dhL = 3;
        this.rootView = LayoutInflater.from(this.dkv.getPageContext().getPageActivity()).inflate(w.j.chat_list_activity, (ViewGroup) null, false);
        initData();
        ad(this.rootView);
        TiebaStatic.eventStat(this.dkv.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        Ur();
        return this.rootView;
    }

    protected void Ur() {
        this.dhF.startPullRefresh();
        this.dkx = isLogin();
        if (!this.dkx) {
            r(this.dkx, true);
        }
    }

    private void registerListener() {
        this.dkv.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cQe);
        this.dkv.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cQe);
        this.dkv.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cQe);
        this.dkv.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cQe);
        this.dkv.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cQe);
        this.dkv.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cQe);
        this.dkv.registerListener(this.aXu);
        this.dkv.registerListener(this.dkC);
    }

    public void gs(boolean z) {
        this.dky = z;
    }

    public void gt(boolean z) {
        this.dkz = z;
    }

    public void onPrimary() {
        if (this.dkw != null && this.dkw.getCount() == 0) {
            gs(true);
        }
        if (this.dkz || this.dky) {
            this.dkz = false;
            this.dky = false;
            cZ(false);
        }
        boolean isLogin = isLogin();
        if (this.dkx != isLogin) {
            this.dkx = isLogin;
            onUserChanged(this.dkx);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dkv.getPageContext());
        }
    }

    private void initData() {
        this.dhC = new ImMessageCenterModel();
        gm(com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("is_shut_down_validate", false) ? false : true);
        this.dkv.registerListener(this.bNF);
    }

    private void ad(View view) {
        this.bKx = (RelativeLayout) view.findViewById(w.h.chat_list);
        this.dhI = (ShutDownValidateTipView) view.findViewById(w.h.view_no_validate);
        this.dhI.setVisibility(8);
        this.dhI.setShutDownClickListener(new aa(this));
        this.bIh = (NavigationBar) this.bKx.findViewById(w.h.view_navigation_bar);
        this.dkB = (TextView) this.bIh.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.maintab_title_layout, (View.OnClickListener) null).findViewById(w.h.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.dkv.getResources().getDimension(w.f.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.dkB.setLayoutParams(layoutParams);
        this.dkB.setText(w.l.my_message);
        this.bIh.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.bIh.setRegisterClickListener(new ab(this));
            this.bIh.setLoginClickListener(new n(this));
        }
        this.alm = new TextView(this.dkv.getPageContext().getPageActivity());
        this.alm.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dkv.getPageContext().getPageActivity(), w.f.ds98)));
        BdListViewHelper.a(this.alm, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hj());
        this.aRL = (NoNetworkView) this.bKx.findViewById(w.h.view_no_network);
        this.aRL.a(new o(this));
        this.dhF = (BdListView) view.findViewById(w.h.chat_list_content);
        this.dhF.addHeaderView(this.alm);
        this.dhF.setDividerHeight(0);
        this.dkw = new MessageAggregationListAdapter(this.dkv.getPageContext().getPageActivity());
        this.dkw.a(this);
        this.dhF.setAdapter((ListAdapter) this.dkw);
        this.dhF.setOnItemClickListener(this.dhN);
        this.dhF.setOnItemLongClickListener(this.dhO);
        this.byr = new View(this.dkv.getFragmentActivity());
        this.byr.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.dkv.getFragmentActivity(), w.f.ds150)));
        this.dhF.addFooterView(this.byr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dkv.getPageContext(), i);
        }
        this.aRL.onChangeSkinType(getPageContext(), i);
        this.bIh.onChangeSkinType(tbPageContext, i);
        if (this.dhI != null) {
            this.dhI.onChangeSkinType(i);
        }
        com.baidu.tbadk.core.util.aq.a(this.dkB, w.e.cp_cont_b, w.e.s_navbar_title_color, i);
        if (this.dkw != null) {
            this.dkw.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().t(this.bKx);
            return true;
        }
        return true;
    }

    private void gu(boolean z) {
        if (z) {
            auj();
        } else {
            auk();
        }
    }

    private void auj() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dkv.getResources().getString(w.l.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dkv.getPageContext().getPageActivity(), this.bKx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dkv.getResources().getDimension(w.f.ds320)), NoDataViewFactory.d.dh(w.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void auk() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.dkv.getResources().getString(w.l.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = this.dkv.getResources().getDimensionPixelSize(w.f.ds320);
        int dimensionPixelSize2 = this.dkv.getResources().getDimensionPixelSize(w.f.ds480);
        int dimensionPixelSize3 = this.dkv.getResources().getDimensionPixelSize(w.f.ds360);
        int dimensionPixelSize4 = this.dkv.getResources().getDimensionPixelSize(w.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dkv.getPageContext().getPageActivity(), this.bKx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, w.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.D(w.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.dkv.getResources().getDimensionPixelSize(w.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        r(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dhK = new r(this, imMessageCenterShowItemData);
        String string = this.dkv.getPageContext().getPageActivity().getString(w.l.delete_user_chat);
        this.dhJ = new com.baidu.tbadk.core.dialog.c(this.dkv.getPageContext().getPageActivity());
        this.dhJ.cc(w.l.operation);
        this.dhJ.a(new String[]{string}, this.dhK);
        this.dhJ.d(this.dkv.getPageContext());
    }

    protected boolean cZ(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.dhF.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void gk(boolean z) {
        if (z) {
            if (aul() && this.dhI.getVisibility() != 0) {
                this.dhI.setVisibility(0);
            }
        } else if (this.dhI.getVisibility() != 8) {
            this.dhI.setVisibility(8);
        }
    }

    public void r(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.dhF.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.bKx.removeView(this.mNoDataView);
        }
        gu(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.dhF.setVisibility(8);
    }

    public boolean aul() {
        return this.dhM;
    }

    public void gm(boolean z) {
        this.dhM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                if (this.dhC != null) {
                    this.dhC.insertOrUpdate(data, this.cQg);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dhC != null) {
                this.dhC.remove(data, this.cQg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dhC != null) {
                this.dhC.setData(data, this.cQg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.dkA = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.dkA != -1) {
                gs(true);
                onPrimary();
            }
        }
    }

    public void gr(boolean z) {
        BdListViewHelper.a(this.alm, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hj());
        if (z && this.dhF != null && this.dhF.getWrappedAdapter() != null && this.dhF.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.fR().post(new s(this));
        }
    }

    @Override // com.baidu.tbadk.core.view.ab.b
    public void aN(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            aU(newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme());
        }
    }

    private void aU(int i, int i2) {
        this.dkw.mc(i);
        this.dkw.md(i2);
        this.dkw.notifyDataSetChanged();
    }

    public void gv(boolean z) {
        this.bIh.setVisibility(z ? 0 : 8);
    }
}
