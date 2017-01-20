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
import com.baidu.tbadk.core.view.aa;
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
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.e<ad> implements aa.b {
    private NoNetworkView Gt;
    private final CustomMessageListener aQV;
    private View afF;
    private NavigationBar bBi;
    private RelativeLayout bDx;
    private final CustomMessageListener bGH;
    private View brw;
    private final CustomMessageListener cPq;
    private com.baidu.tieba.im.chat.a.a cPs;
    private ImMessageCenterModel dgL;
    private ImMessageCenterShowItemData dgN;
    private BdListView dgO;
    private ShutDownValidateTipView dgR;
    com.baidu.tbadk.core.dialog.c dgS;
    private c.b dgT;
    private int dgU;
    private boolean dgV;
    private final AdapterView.OnItemClickListener dgW;
    private final AdapterView.OnItemLongClickListener dgX;
    private final ad djC;
    private MessageAggregationListAdapter djD;
    private boolean djE;
    private boolean djF;
    private boolean djG;
    private int djH;
    private TextView djI;
    private CustomMessageListener djJ;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private View rootView;

    public l(ad adVar) {
        super(com.baidu.adp.base.k.C(adVar.getPageContext().getPageActivity()));
        this.dgL = null;
        this.dgN = null;
        this.dgO = null;
        this.djD = null;
        this.dgS = null;
        this.dgV = true;
        this.djE = false;
        this.djF = false;
        this.djG = true;
        this.djH = 16;
        this.aQV = new m(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
        this.djJ = new t(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
        this.dgW = new u(this);
        this.dgX = new w(this);
        this.cPq = new x(this, 0);
        this.cPs = new y(this);
        this.bGH = new z(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.djC = adVar;
    }

    public void g(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.djH = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.djH = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.djH);
        }
    }

    public void aak() {
        if (this.djD != null) {
            this.djD.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cPq);
    }

    public View lW() {
        this.dgU = 3;
        this.rootView = LayoutInflater.from(this.djC.getPageContext().getPageActivity()).inflate(r.j.chat_list_activity, (ViewGroup) null, false);
        initData();
        af(this.rootView);
        TiebaStatic.eventStat(this.djC.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        lL();
        return this.rootView;
    }

    protected void lL() {
        this.dgO.startPullRefresh();
        this.djE = isLogin();
        if (!this.djE) {
            s(this.djE, true);
        }
    }

    private void registerListener() {
        this.djC.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cPq);
        this.djC.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cPq);
        this.djC.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cPq);
        this.djC.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cPq);
        this.djC.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cPq);
        this.djC.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cPq);
        this.djC.registerListener(this.aQV);
        this.djC.registerListener(this.djJ);
    }

    public void gB(boolean z) {
        this.djF = z;
    }

    public void gC(boolean z) {
        this.djG = z;
    }

    public void onPrimary() {
        if (this.djD != null && this.djD.getCount() == 0) {
            gB(true);
        }
        if (this.djG || this.djF) {
            this.djG = false;
            this.djF = false;
            cX(false);
        }
        boolean isLogin = isLogin();
        if (this.djE != isLogin) {
            this.djE = isLogin;
            onUserChanged(this.djE);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.djC.getPageContext());
        }
    }

    private void initData() {
        this.dgL = new ImMessageCenterModel();
        gv(com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("is_shut_down_validate", false) ? false : true);
        this.djC.registerListener(this.bGH);
    }

    private void af(View view) {
        this.bDx = (RelativeLayout) view.findViewById(r.h.chat_list);
        this.dgR = (ShutDownValidateTipView) view.findViewById(r.h.view_no_validate);
        this.dgR.setVisibility(8);
        this.dgR.setShutDownClickListener(new aa(this));
        this.bBi = (NavigationBar) this.bDx.findViewById(r.h.view_navigation_bar);
        this.djI = (TextView) this.bBi.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.j.maintab_title_layout, (View.OnClickListener) null).findViewById(r.h.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.djC.getResources().getDimension(r.f.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.djI.setLayoutParams(layoutParams);
        this.djI.setText(r.l.my_message);
        this.bBi.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.bBi.setRegisterClickListener(new ab(this));
            this.bBi.setLoginClickListener(new n(this));
        }
        this.afF = new TextView(this.djC.getPageContext().getPageActivity());
        this.afF.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(this.djC.getPageContext().getPageActivity(), r.f.ds98)));
        BdListViewHelper.a(this.afF, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.gk());
        this.Gt = (NoNetworkView) this.bDx.findViewById(r.h.view_no_network);
        this.Gt.a(new o(this));
        this.dgO = (BdListView) view.findViewById(r.h.chat_list_content);
        this.dgO.addHeaderView(this.afF);
        this.dgO.setDividerHeight(0);
        this.djD = new MessageAggregationListAdapter(this.djC.getPageContext().getPageActivity());
        this.djD.a(this);
        this.dgO.setAdapter((ListAdapter) this.djD);
        this.dgO.setOnItemClickListener(this.dgW);
        this.dgO.setOnItemLongClickListener(this.dgX);
        this.brw = new View(this.djC.getFragmentActivity());
        this.brw.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.djC.getFragmentActivity(), r.f.ds150)));
        this.dgO.addFooterView(this.brw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.djC.getPageContext(), i);
        }
        this.Gt.onChangeSkinType(getPageContext(), i);
        this.bBi.onChangeSkinType(tbPageContext, i);
        if (this.dgR != null) {
            this.dgR.onChangeSkinType(i);
        }
        com.baidu.tbadk.core.util.ap.a(this.djI, r.e.cp_cont_b, r.e.s_navbar_title_color, i);
        if (this.djD != null) {
            this.djD.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().v(this.bDx);
            return true;
        }
        return true;
    }

    private void gD(boolean z) {
        if (z) {
            auV();
        } else {
            auW();
        }
    }

    private void auV() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.djC.getResources().getString(r.l.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.djC.getPageContext().getPageActivity(), this.bDx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.djC.getResources().getDimension(r.f.ds320)), NoDataViewFactory.d.di(r.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void auW() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.djC.getResources().getString(r.l.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = this.djC.getResources().getDimensionPixelSize(r.f.ds320);
        int dimensionPixelSize2 = this.djC.getResources().getDimensionPixelSize(r.f.ds480);
        int dimensionPixelSize3 = this.djC.getResources().getDimensionPixelSize(r.f.ds360);
        int dimensionPixelSize4 = this.djC.getResources().getDimensionPixelSize(r.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.djC.getPageContext().getPageActivity(), this.bDx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, r.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.x(r.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.djC.getResources().getDimensionPixelSize(r.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        s(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dgT = new r(this, imMessageCenterShowItemData);
        String string = this.djC.getPageContext().getPageActivity().getString(r.l.delete_user_chat);
        this.dgS = new com.baidu.tbadk.core.dialog.c(this.djC.getPageContext().getPageActivity());
        this.dgS.cd(r.l.operation);
        this.dgS.a(new String[]{string}, this.dgT);
        this.dgS.d(this.djC.getPageContext());
    }

    protected boolean cX(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.dgO.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void gt(boolean z) {
        if (z) {
            if (auX() && this.dgR.getVisibility() != 0) {
                this.dgR.setVisibility(0);
            }
        } else if (this.dgR.getVisibility() != 8) {
            this.dgR.setVisibility(8);
        }
    }

    public void s(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.dgO.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.bDx.removeView(this.mNoDataView);
        }
        gD(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.dgO.setVisibility(8);
    }

    public boolean auX() {
        return this.dgV;
    }

    public void gv(boolean z) {
        this.dgV = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                if (this.dgL != null) {
                    this.dgL.insertOrUpdate(data, this.cPs);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dgL != null) {
                this.dgL.remove(data, this.cPs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dgL != null) {
                this.dgL.setData(data, this.cPs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.djH = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.djH != -1) {
                gB(true);
                onPrimary();
            }
        }
    }

    public void gA(boolean z) {
        BdListViewHelper.a(this.afF, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.gk());
        if (z && this.dgO != null && this.dgO.getWrappedAdapter() != null && this.dgO.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.eE().post(new s(this));
        }
    }

    @Override // com.baidu.tbadk.core.view.aa.b
    public void aM(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            aS(newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme());
        }
    }

    private void aS(int i, int i2) {
        this.djD.ml(i);
        this.djD.mm(i2);
        this.djD.notifyDataSetChanged();
    }

    public void gE(boolean z) {
        this.bBi.setVisibility(z ? 0 : 8);
    }
}
