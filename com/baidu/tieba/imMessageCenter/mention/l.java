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
import com.baidu.tbadk.core.view.ae;
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
/* loaded from: classes2.dex */
public class l extends com.baidu.adp.base.e<ad> implements ae.b {
    private NoNetworkView aSi;
    private final CustomMessageListener aXT;
    private View ali;
    private View bAJ;
    private NavigationBar bJC;
    private RelativeLayout bLS;
    private final CustomMessageListener bPk;
    private final CustomMessageListener cMx;
    private com.baidu.tieba.im.chat.a.a cMz;
    private ImMessageCenterModel ddV;
    private ImMessageCenterShowItemData ddX;
    private BdListView ddY;
    private ShutDownValidateTipView deb;
    com.baidu.tbadk.core.dialog.c dec;
    private c.b ded;
    private int dee;
    private boolean def;
    private final AdapterView.OnItemClickListener deg;
    private final AdapterView.OnItemLongClickListener deh;
    private final ad dgQ;
    private MessageAggregationListAdapter dgR;
    private boolean dgS;
    private boolean dgT;
    private boolean dgU;
    private int dgV;
    private TextView dgW;
    private CustomMessageListener dgX;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private View rootView;

    public l(ad adVar) {
        super(com.baidu.adp.base.k.Z(adVar.getPageContext().getPageActivity()));
        this.ddV = null;
        this.ddX = null;
        this.ddY = null;
        this.dgR = null;
        this.dec = null;
        this.def = true;
        this.dgS = false;
        this.dgT = false;
        this.dgU = true;
        this.dgV = 16;
        this.aXT = new m(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
        this.dgX = new t(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
        this.deg = new u(this);
        this.deh = new w(this);
        this.cMx = new x(this, 0);
        this.cMz = new y(this);
        this.bPk = new z(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.dgQ = adVar;
    }

    public void h(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.dgV = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.dgV = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.dgV);
        }
    }

    public void aaS() {
        if (this.dgR != null) {
            this.dgR.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cMx);
    }

    public View UK() {
        this.dee = 3;
        this.rootView = LayoutInflater.from(this.dgQ.getPageContext().getPageActivity()).inflate(w.j.chat_list_activity, (ViewGroup) null, false);
        initData();
        ab(this.rootView);
        TiebaStatic.eventStat(this.dgQ.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        UL();
        return this.rootView;
    }

    protected void UL() {
        this.ddY.startPullRefresh();
        this.dgS = isLogin();
        if (!this.dgS) {
            r(this.dgS, true);
        }
    }

    private void registerListener() {
        this.dgQ.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cMx);
        this.dgQ.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cMx);
        this.dgQ.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cMx);
        this.dgQ.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cMx);
        this.dgQ.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cMx);
        this.dgQ.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cMx);
        this.dgQ.registerListener(this.aXT);
        this.dgQ.registerListener(this.dgX);
    }

    public void gd(boolean z) {
        this.dgT = z;
    }

    public void ge(boolean z) {
        this.dgU = z;
    }

    public void onPrimary() {
        if (this.dgR != null && this.dgR.getCount() == 0) {
            gd(true);
        }
        if (this.dgU || this.dgT) {
            this.dgU = false;
            this.dgT = false;
            dl(false);
        }
        boolean isLogin = isLogin();
        if (this.dgS != isLogin) {
            this.dgS = isLogin;
            onUserChanged(this.dgS);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dgQ.getPageContext());
        }
    }

    private void initData() {
        this.ddV = new ImMessageCenterModel();
        fX(com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("is_shut_down_validate", false) ? false : true);
        this.dgQ.registerListener(this.bPk);
    }

    private void ab(View view) {
        this.bLS = (RelativeLayout) view.findViewById(w.h.chat_list);
        this.deb = (ShutDownValidateTipView) view.findViewById(w.h.view_no_validate);
        this.deb.setVisibility(8);
        this.deb.setShutDownClickListener(new aa(this));
        this.bJC = (NavigationBar) this.bLS.findViewById(w.h.view_navigation_bar);
        this.dgW = (TextView) this.bJC.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.maintab_title_layout, (View.OnClickListener) null).findViewById(w.h.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.dgQ.getResources().getDimension(w.f.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.dgW.setLayoutParams(layoutParams);
        this.dgW.setText(w.l.my_message);
        this.bJC.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.bJC.setRegisterClickListener(new ab(this));
            this.bJC.setLoginClickListener(new n(this));
        }
        this.ali = new TextView(this.dgQ.getPageContext().getPageActivity());
        this.ali.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dgQ.getPageContext().getPageActivity(), w.f.ds98)));
        BdListViewHelper.a(this.ali, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hk());
        this.aSi = (NoNetworkView) this.bLS.findViewById(w.h.view_no_network);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aSi.getLayoutParams();
        layoutParams2.setMargins(0, com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 44.0f) + UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
        this.aSi.setLayoutParams(layoutParams2);
        this.aSi.a(new o(this));
        this.ddY = (BdListView) view.findViewById(w.h.chat_list_content);
        this.ddY.addHeaderView(this.ali);
        this.ddY.setDividerHeight(0);
        this.dgR = new MessageAggregationListAdapter(this.dgQ.getPageContext().getPageActivity());
        this.dgR.a(this);
        this.ddY.setAdapter((ListAdapter) this.dgR);
        this.ddY.setOnItemClickListener(this.deg);
        this.ddY.setOnItemLongClickListener(this.deh);
        this.bAJ = new View(this.dgQ.getFragmentActivity());
        this.bAJ.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.dgQ.getFragmentActivity(), w.f.ds150)));
        this.ddY.addFooterView(this.bAJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dgQ.getPageContext(), i);
        }
        this.aSi.onChangeSkinType(getPageContext(), i);
        this.bJC.onChangeSkinType(tbPageContext, i);
        if (this.deb != null) {
            this.deb.onChangeSkinType(i);
        }
        com.baidu.tbadk.core.util.aq.a(this.dgW, w.e.cp_cont_b, w.e.s_navbar_title_color, i);
        if (this.dgR != null) {
            this.dgR.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().t(this.bLS);
            return true;
        }
        return true;
    }

    private void gf(boolean z) {
        if (z) {
            asf();
        } else {
            asg();
        }
    }

    private void asf() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dgQ.getResources().getString(w.l.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dgQ.getPageContext().getPageActivity(), this.bLS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dgQ.getResources().getDimension(w.f.ds320)), NoDataViewFactory.d.dd(w.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void asg() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.dgQ.getResources().getString(w.l.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = this.dgQ.getResources().getDimensionPixelSize(w.f.ds320);
        int dimensionPixelSize2 = this.dgQ.getResources().getDimensionPixelSize(w.f.ds480);
        int dimensionPixelSize3 = this.dgQ.getResources().getDimensionPixelSize(w.f.ds360);
        int dimensionPixelSize4 = this.dgQ.getResources().getDimensionPixelSize(w.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dgQ.getPageContext().getPageActivity(), this.bLS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, w.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(w.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.dgQ.getResources().getDimensionPixelSize(w.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        r(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.ded = new r(this, imMessageCenterShowItemData);
        String string = this.dgQ.getPageContext().getPageActivity().getString(w.l.delete_user_chat);
        this.dec = new com.baidu.tbadk.core.dialog.c(this.dgQ.getPageContext().getPageActivity());
        this.dec.ca(w.l.operation);
        this.dec.a(new String[]{string}, this.ded);
        this.dec.d(this.dgQ.getPageContext());
    }

    protected boolean dl(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.ddY.completePullRefreshPostDelayed(2000L);
        }
        return true;
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

    public void r(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.ddY.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.bLS.removeView(this.mNoDataView);
        }
        gf(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.ddY.setVisibility(8);
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
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.dgV = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.dgV != -1) {
                gd(true);
                onPrimary();
            }
        }
    }

    public void gc(boolean z) {
        BdListViewHelper.a(this.ali, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hk());
        if (z && this.ddY != null && this.ddY.getWrappedAdapter() != null && this.ddY.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.fS().post(new s(this));
        }
    }

    @Override // com.baidu.tbadk.core.view.ae.b
    public void aM(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            aR(newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme());
        }
    }

    private void aR(int i, int i2) {
        this.dgR.lV(i);
        this.dgR.lW(i2);
        this.dgR.notifyDataSetChanged();
    }

    public void gg(boolean z) {
        this.bJC.setVisibility(z ? 0 : 8);
    }
}
