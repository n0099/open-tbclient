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
    private NoNetworkView aRN;
    private final CustomMessageListener aXx;
    private View aln;
    private View bAI;
    private NavigationBar bKy;
    private RelativeLayout bMO;
    private final CustomMessageListener bPW;
    private final CustomMessageListener cSv;
    private com.baidu.tieba.im.chat.a.a cSx;
    private ImMessageCenterModel djT;
    private ImMessageCenterShowItemData djV;
    private BdListView djW;
    private ShutDownValidateTipView djZ;
    com.baidu.tbadk.core.dialog.c dka;
    private c.b dkb;
    private int dkc;
    private boolean dkd;
    private final AdapterView.OnItemClickListener dke;
    private final AdapterView.OnItemLongClickListener dkf;
    private final ad dmM;
    private MessageAggregationListAdapter dmN;
    private boolean dmO;
    private boolean dmP;
    private boolean dmQ;
    private int dmR;
    private TextView dmS;
    private CustomMessageListener dmT;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private View rootView;

    public l(ad adVar) {
        super(com.baidu.adp.base.k.Z(adVar.getPageContext().getPageActivity()));
        this.djT = null;
        this.djV = null;
        this.djW = null;
        this.dmN = null;
        this.dka = null;
        this.dkd = true;
        this.dmO = false;
        this.dmP = false;
        this.dmQ = true;
        this.dmR = 16;
        this.aXx = new m(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
        this.dmT = new t(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
        this.dke = new u(this);
        this.dkf = new w(this);
        this.cSv = new x(this, 0);
        this.cSx = new y(this);
        this.bPW = new z(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.dmM = adVar;
    }

    public void h(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.dmR = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.dmR = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.dmR);
        }
    }

    public void acF() {
        if (this.dmN != null) {
            this.dmN.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cSv);
    }

    public View Vr() {
        this.dkc = 3;
        this.rootView = LayoutInflater.from(this.dmM.getPageContext().getPageActivity()).inflate(w.j.chat_list_activity, (ViewGroup) null, false);
        initData();
        ad(this.rootView);
        TiebaStatic.eventStat(this.dmM.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        Vs();
        return this.rootView;
    }

    protected void Vs() {
        this.djW.startPullRefresh();
        this.dmO = isLogin();
        if (!this.dmO) {
            r(this.dmO, true);
        }
    }

    private void registerListener() {
        this.dmM.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cSv);
        this.dmM.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cSv);
        this.dmM.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cSv);
        this.dmM.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cSv);
        this.dmM.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cSv);
        this.dmM.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cSv);
        this.dmM.registerListener(this.aXx);
        this.dmM.registerListener(this.dmT);
    }

    public void gC(boolean z) {
        this.dmP = z;
    }

    public void gD(boolean z) {
        this.dmQ = z;
    }

    public void onPrimary() {
        if (this.dmN != null && this.dmN.getCount() == 0) {
            gC(true);
        }
        if (this.dmQ || this.dmP) {
            this.dmQ = false;
            this.dmP = false;
            dj(false);
        }
        boolean isLogin = isLogin();
        if (this.dmO != isLogin) {
            this.dmO = isLogin;
            onUserChanged(this.dmO);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dmM.getPageContext());
        }
    }

    private void initData() {
        this.djT = new ImMessageCenterModel();
        gw(com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("is_shut_down_validate", false) ? false : true);
        this.dmM.registerListener(this.bPW);
    }

    private void ad(View view) {
        this.bMO = (RelativeLayout) view.findViewById(w.h.chat_list);
        this.djZ = (ShutDownValidateTipView) view.findViewById(w.h.view_no_validate);
        this.djZ.setVisibility(8);
        this.djZ.setShutDownClickListener(new aa(this));
        this.bKy = (NavigationBar) this.bMO.findViewById(w.h.view_navigation_bar);
        this.dmS = (TextView) this.bKy.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.maintab_title_layout, (View.OnClickListener) null).findViewById(w.h.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.dmM.getResources().getDimension(w.f.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.dmS.setLayoutParams(layoutParams);
        this.dmS.setText(w.l.my_message);
        this.bKy.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.bKy.setRegisterClickListener(new ab(this));
            this.bKy.setLoginClickListener(new n(this));
        }
        this.aln = new TextView(this.dmM.getPageContext().getPageActivity());
        this.aln.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dmM.getPageContext().getPageActivity(), w.f.ds98)));
        BdListViewHelper.a(this.aln, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hk());
        this.aRN = (NoNetworkView) this.bMO.findViewById(w.h.view_no_network);
        this.aRN.a(new o(this));
        this.djW = (BdListView) view.findViewById(w.h.chat_list_content);
        this.djW.addHeaderView(this.aln);
        this.djW.setDividerHeight(0);
        this.dmN = new MessageAggregationListAdapter(this.dmM.getPageContext().getPageActivity());
        this.dmN.a(this);
        this.djW.setAdapter((ListAdapter) this.dmN);
        this.djW.setOnItemClickListener(this.dke);
        this.djW.setOnItemLongClickListener(this.dkf);
        this.bAI = new View(this.dmM.getFragmentActivity());
        this.bAI.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.dmM.getFragmentActivity(), w.f.ds150)));
        this.djW.addFooterView(this.bAI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dmM.getPageContext(), i);
        }
        this.aRN.onChangeSkinType(getPageContext(), i);
        this.bKy.onChangeSkinType(tbPageContext, i);
        if (this.djZ != null) {
            this.djZ.onChangeSkinType(i);
        }
        com.baidu.tbadk.core.util.aq.a(this.dmS, w.e.cp_cont_b, w.e.s_navbar_title_color, i);
        if (this.dmN != null) {
            this.dmN.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().t(this.bMO);
            return true;
        }
        return true;
    }

    private void gE(boolean z) {
        if (z) {
            avk();
        } else {
            avl();
        }
    }

    private void avk() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dmM.getResources().getString(w.l.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dmM.getPageContext().getPageActivity(), this.bMO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dmM.getResources().getDimension(w.f.ds320)), NoDataViewFactory.d.dh(w.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void avl() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.dmM.getResources().getString(w.l.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = this.dmM.getResources().getDimensionPixelSize(w.f.ds320);
        int dimensionPixelSize2 = this.dmM.getResources().getDimensionPixelSize(w.f.ds480);
        int dimensionPixelSize3 = this.dmM.getResources().getDimensionPixelSize(w.f.ds360);
        int dimensionPixelSize4 = this.dmM.getResources().getDimensionPixelSize(w.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dmM.getPageContext().getPageActivity(), this.bMO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, w.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.D(w.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.dmM.getResources().getDimensionPixelSize(w.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        r(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dkb = new r(this, imMessageCenterShowItemData);
        String string = this.dmM.getPageContext().getPageActivity().getString(w.l.delete_user_chat);
        this.dka = new com.baidu.tbadk.core.dialog.c(this.dmM.getPageContext().getPageActivity());
        this.dka.cc(w.l.operation);
        this.dka.a(new String[]{string}, this.dkb);
        this.dka.d(this.dmM.getPageContext());
    }

    protected boolean dj(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.djW.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void gu(boolean z) {
        if (z) {
            if (avm() && this.djZ.getVisibility() != 0) {
                this.djZ.setVisibility(0);
            }
        } else if (this.djZ.getVisibility() != 8) {
            this.djZ.setVisibility(8);
        }
    }

    public void r(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.djW.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.bMO.removeView(this.mNoDataView);
        }
        gE(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.djW.setVisibility(8);
    }

    public boolean avm() {
        return this.dkd;
    }

    public void gw(boolean z) {
        this.dkd = z;
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
                if (this.djT != null) {
                    this.djT.insertOrUpdate(data, this.cSx);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.djT != null) {
                this.djT.remove(data, this.cSx);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.djT != null) {
                this.djT.setData(data, this.cSx);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.dmR = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.dmR != -1) {
                gC(true);
                onPrimary();
            }
        }
    }

    public void gB(boolean z) {
        BdListViewHelper.a(this.aln, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hk());
        if (z && this.djW != null && this.djW.getWrappedAdapter() != null && this.djW.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.fS().post(new s(this));
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
        this.dmN.mi(i);
        this.dmN.mj(i2);
        this.dmN.notifyDataSetChanged();
    }

    public void gF(boolean z) {
        this.bKy.setVisibility(z ? 0 : 8);
    }
}
