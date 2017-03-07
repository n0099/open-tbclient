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
    private NoNetworkView aRv;
    private final CustomMessageListener aXg;
    private View akX;
    private NavigationBar bIo;
    private RelativeLayout bKE;
    private final CustomMessageListener bNQ;
    private View byy;
    private final CustomMessageListener cRH;
    private com.baidu.tieba.im.chat.a.a cRJ;
    private ImMessageCenterModel djd;
    private ImMessageCenterShowItemData djf;
    private BdListView djg;
    private ShutDownValidateTipView djj;
    com.baidu.tbadk.core.dialog.c djk;
    private c.b djl;
    private int djm;
    private boolean djn;
    private final AdapterView.OnItemClickListener djo;
    private final AdapterView.OnItemLongClickListener djp;
    private final ad dlW;
    private MessageAggregationListAdapter dlX;
    private boolean dlY;
    private boolean dlZ;
    private boolean dma;
    private int dmb;
    private TextView dmc;
    private CustomMessageListener dmd;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private View rootView;

    public l(ad adVar) {
        super(com.baidu.adp.base.k.aa(adVar.getPageContext().getPageActivity()));
        this.djd = null;
        this.djf = null;
        this.djg = null;
        this.dlX = null;
        this.djk = null;
        this.djn = true;
        this.dlY = false;
        this.dlZ = false;
        this.dma = true;
        this.dmb = 16;
        this.aXg = new m(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
        this.dmd = new t(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
        this.djo = new u(this);
        this.djp = new w(this);
        this.cRH = new x(this, 0);
        this.cRJ = new y(this);
        this.bNQ = new z(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.dlW = adVar;
    }

    public void g(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.dmb = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.dmb = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.dmb);
        }
    }

    public void abh() {
        if (this.dlX != null) {
            this.dlX.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cRH);
    }

    public View TS() {
        this.djm = 3;
        this.rootView = LayoutInflater.from(this.dlW.getPageContext().getPageActivity()).inflate(w.j.chat_list_activity, (ViewGroup) null, false);
        initData();
        ad(this.rootView);
        TiebaStatic.eventStat(this.dlW.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        TT();
        return this.rootView;
    }

    protected void TT() {
        this.djg.startPullRefresh();
        this.dlY = isLogin();
        if (!this.dlY) {
            r(this.dlY, true);
        }
    }

    private void registerListener() {
        this.dlW.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cRH);
        this.dlW.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cRH);
        this.dlW.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cRH);
        this.dlW.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cRH);
        this.dlW.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cRH);
        this.dlW.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cRH);
        this.dlW.registerListener(this.aXg);
        this.dlW.registerListener(this.dmd);
    }

    public void gs(boolean z) {
        this.dlZ = z;
    }

    public void gt(boolean z) {
        this.dma = z;
    }

    public void onPrimary() {
        if (this.dlX != null && this.dlX.getCount() == 0) {
            gs(true);
        }
        if (this.dma || this.dlZ) {
            this.dma = false;
            this.dlZ = false;
            cX(false);
        }
        boolean isLogin = isLogin();
        if (this.dlY != isLogin) {
            this.dlY = isLogin;
            onUserChanged(this.dlY);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dlW.getPageContext());
        }
    }

    private void initData() {
        this.djd = new ImMessageCenterModel();
        gm(com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("is_shut_down_validate", false) ? false : true);
        this.dlW.registerListener(this.bNQ);
    }

    private void ad(View view) {
        this.bKE = (RelativeLayout) view.findViewById(w.h.chat_list);
        this.djj = (ShutDownValidateTipView) view.findViewById(w.h.view_no_validate);
        this.djj.setVisibility(8);
        this.djj.setShutDownClickListener(new aa(this));
        this.bIo = (NavigationBar) this.bKE.findViewById(w.h.view_navigation_bar);
        this.dmc = (TextView) this.bIo.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.maintab_title_layout, (View.OnClickListener) null).findViewById(w.h.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.dlW.getResources().getDimension(w.f.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.dmc.setLayoutParams(layoutParams);
        this.dmc.setText(w.l.my_message);
        this.bIo.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.bIo.setRegisterClickListener(new ab(this));
            this.bIo.setLoginClickListener(new n(this));
        }
        this.akX = new TextView(this.dlW.getPageContext().getPageActivity());
        this.akX.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dlW.getPageContext().getPageActivity(), w.f.ds98)));
        BdListViewHelper.a(this.akX, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.he());
        this.aRv = (NoNetworkView) this.bKE.findViewById(w.h.view_no_network);
        this.aRv.a(new o(this));
        this.djg = (BdListView) view.findViewById(w.h.chat_list_content);
        this.djg.addHeaderView(this.akX);
        this.djg.setDividerHeight(0);
        this.dlX = new MessageAggregationListAdapter(this.dlW.getPageContext().getPageActivity());
        this.dlX.a(this);
        this.djg.setAdapter((ListAdapter) this.dlX);
        this.djg.setOnItemClickListener(this.djo);
        this.djg.setOnItemLongClickListener(this.djp);
        this.byy = new View(this.dlW.getFragmentActivity());
        this.byy.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.dlW.getFragmentActivity(), w.f.ds150)));
        this.djg.addFooterView(this.byy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dlW.getPageContext(), i);
        }
        this.aRv.onChangeSkinType(getPageContext(), i);
        this.bIo.onChangeSkinType(tbPageContext, i);
        if (this.djj != null) {
            this.djj.onChangeSkinType(i);
        }
        com.baidu.tbadk.core.util.aq.a(this.dmc, w.e.cp_cont_b, w.e.s_navbar_title_color, i);
        if (this.dlX != null) {
            this.dlX.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().t(this.bKE);
            return true;
        }
        return true;
    }

    private void gu(boolean z) {
        if (z) {
            auq();
        } else {
            aur();
        }
    }

    private void auq() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dlW.getResources().getString(w.l.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dlW.getPageContext().getPageActivity(), this.bKE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dlW.getResources().getDimension(w.f.ds320)), NoDataViewFactory.d.de(w.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void aur() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.dlW.getResources().getString(w.l.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = this.dlW.getResources().getDimensionPixelSize(w.f.ds320);
        int dimensionPixelSize2 = this.dlW.getResources().getDimensionPixelSize(w.f.ds480);
        int dimensionPixelSize3 = this.dlW.getResources().getDimensionPixelSize(w.f.ds360);
        int dimensionPixelSize4 = this.dlW.getResources().getDimensionPixelSize(w.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dlW.getPageContext().getPageActivity(), this.bKE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, w.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.D(w.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.dlW.getResources().getDimensionPixelSize(w.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        r(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.djl = new r(this, imMessageCenterShowItemData);
        String string = this.dlW.getPageContext().getPageActivity().getString(w.l.delete_user_chat);
        this.djk = new com.baidu.tbadk.core.dialog.c(this.dlW.getPageContext().getPageActivity());
        this.djk.bZ(w.l.operation);
        this.djk.a(new String[]{string}, this.djl);
        this.djk.d(this.dlW.getPageContext());
    }

    protected boolean cX(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.djg.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void gk(boolean z) {
        if (z) {
            if (aus() && this.djj.getVisibility() != 0) {
                this.djj.setVisibility(0);
            }
        } else if (this.djj.getVisibility() != 8) {
            this.djj.setVisibility(8);
        }
    }

    public void r(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.djg.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.bKE.removeView(this.mNoDataView);
        }
        gu(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.djg.setVisibility(8);
    }

    public boolean aus() {
        return this.djn;
    }

    public void gm(boolean z) {
        this.djn = z;
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
                if (this.djd != null) {
                    this.djd.insertOrUpdate(data, this.cRJ);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.djd != null) {
                this.djd.remove(data, this.cRJ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.djd != null) {
                this.djd.setData(data, this.cRJ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.dmb = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.dmb != -1) {
                gs(true);
                onPrimary();
            }
        }
    }

    public void gr(boolean z) {
        BdListViewHelper.a(this.akX, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.he());
        if (z && this.djg != null && this.djg.getWrappedAdapter() != null && this.djg.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.fM().post(new s(this));
        }
    }

    @Override // com.baidu.tbadk.core.view.ab.b
    public void aL(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            aW(newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme());
        }
    }

    private void aW(int i, int i2) {
        this.dlX.mb(i);
        this.dlX.mc(i2);
        this.dlX.notifyDataSetChanged();
    }

    public void gv(boolean z) {
        this.bIo.setVisibility(z ? 0 : 8);
    }
}
