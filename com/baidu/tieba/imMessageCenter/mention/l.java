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
    private final CustomMessageListener aWO;
    private View alM;
    private View bHv;
    private NavigationBar bWn;
    private RelativeLayout bZb;
    private NoNetworkView bbO;
    private final CustomMessageListener cZR;
    private com.baidu.tieba.im.chat.a.a cZT;
    private final CustomMessageListener cdh;
    private ImMessageCenterModel drm;
    private ImMessageCenterShowItemData dro;
    private BdListView drp;
    private ShutDownValidateTipView drs;
    com.baidu.tbadk.core.dialog.c drt;
    private c.b dru;
    private int drv;
    private boolean drw;
    private final AdapterView.OnItemClickListener drx;
    private final AdapterView.OnItemLongClickListener dry;
    private final ad dui;
    private MessageAggregationListAdapter duj;
    private boolean duk;
    private boolean dul;
    private boolean dum;
    private int dun;
    private TextView duo;
    private CustomMessageListener dup;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private View rootView;

    public l(ad adVar) {
        super(com.baidu.adp.base.k.Z(adVar.getPageContext().getPageActivity()));
        this.drm = null;
        this.dro = null;
        this.drp = null;
        this.duj = null;
        this.drt = null;
        this.drw = true;
        this.duk = false;
        this.dul = false;
        this.dum = true;
        this.dun = 16;
        this.aWO = new m(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
        this.dup = new t(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
        this.drx = new u(this);
        this.dry = new w(this);
        this.cZR = new x(this, 0);
        this.cZT = new y(this);
        this.cdh = new z(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.dui = adVar;
    }

    public void h(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.dun = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.dun = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.dun);
        }
    }

    public void afN() {
        if (this.duj != null) {
            this.duj.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cZR);
    }

    public View Xe() {
        this.drv = 3;
        this.rootView = LayoutInflater.from(this.dui.getPageContext().getPageActivity()).inflate(w.j.chat_list_activity, (ViewGroup) null, false);
        initData();
        ac(this.rootView);
        TiebaStatic.eventStat(this.dui.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        Xf();
        return this.rootView;
    }

    protected void Xf() {
        this.drp.startPullRefresh();
        this.duk = isLogin();
        if (!this.duk) {
            v(this.duk, true);
        }
    }

    private void registerListener() {
        this.dui.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cZR);
        this.dui.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cZR);
        this.dui.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cZR);
        this.dui.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cZR);
        this.dui.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cZR);
        this.dui.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cZR);
        this.dui.registerListener(this.aWO);
        this.dui.registerListener(this.dup);
    }

    public void gI(boolean z) {
        this.dul = z;
    }

    public void gJ(boolean z) {
        this.dum = z;
    }

    public void onPrimary() {
        if (this.duj != null && this.duj.getCount() == 0) {
            gI(true);
        }
        if (this.dum || this.dul) {
            this.dum = false;
            this.dul = false;
            dE(false);
        }
        boolean isLogin = isLogin();
        if (this.duk != isLogin) {
            this.duk = isLogin;
            onUserChanged(this.duk);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dui.getPageContext());
        }
    }

    private void initData() {
        this.drm = new ImMessageCenterModel();
        gC(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
        this.dui.registerListener(this.cdh);
    }

    private void ac(View view) {
        this.bZb = (RelativeLayout) view.findViewById(w.h.chat_list);
        this.drs = (ShutDownValidateTipView) view.findViewById(w.h.view_no_validate);
        this.drs.setVisibility(8);
        this.drs.setShutDownClickListener(new aa(this));
        this.bWn = (NavigationBar) this.bZb.findViewById(w.h.view_navigation_bar);
        this.duo = (TextView) this.bWn.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.maintab_title_layout, (View.OnClickListener) null).findViewById(w.h.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.dui.getResources().getDimension(w.f.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.duo.setLayoutParams(layoutParams);
        this.duo.setText(w.l.my_message);
        this.bWn.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.bWn.setRegisterClickListener(new ab(this));
            this.bWn.setLoginClickListener(new n(this));
        }
        this.alM = new TextView(this.dui.getPageContext().getPageActivity());
        this.alM.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dui.getPageContext().getPageActivity(), w.f.ds98)));
        BdListViewHelper.a(this.alM, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hj());
        this.bbO = (NoNetworkView) this.bZb.findViewById(w.h.view_no_network);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bbO.getLayoutParams();
        layoutParams2.setMargins(0, com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 44.0f) + UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
        this.bbO.setLayoutParams(layoutParams2);
        this.bbO.a(new o(this));
        this.drp = (BdListView) view.findViewById(w.h.chat_list_content);
        this.drp.addHeaderView(this.alM);
        this.drp.setDividerHeight(0);
        this.duj = new MessageAggregationListAdapter(this.dui.getPageContext().getPageActivity());
        this.duj.a(this);
        this.drp.setAdapter((ListAdapter) this.duj);
        this.drp.setOnItemClickListener(this.drx);
        this.drp.setOnItemLongClickListener(this.dry);
        this.bHv = new View(this.dui.getFragmentActivity());
        this.bHv.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.dui.getFragmentActivity(), w.f.ds150)));
        this.drp.addFooterView(this.bHv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dui.getPageContext(), i);
        }
        this.bbO.onChangeSkinType(getPageContext(), i);
        this.bWn.onChangeSkinType(tbPageContext, i);
        if (this.drs != null) {
            this.drs.onChangeSkinType(i);
        }
        com.baidu.tbadk.core.util.as.a(this.duo, w.e.cp_cont_b, w.e.s_navbar_title_color, i);
        if (this.duj != null) {
            this.duj.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().t(this.bZb);
            return true;
        }
        return true;
    }

    private void gK(boolean z) {
        if (z) {
            awN();
        } else {
            MA();
        }
    }

    private void awN() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dui.getResources().getString(w.l.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dui.getPageContext().getPageActivity(), this.bZb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dui.getResources().getDimension(w.f.ds320)), NoDataViewFactory.d.dg(w.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void MA() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.dui.getResources().getString(w.l.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = this.dui.getResources().getDimensionPixelSize(w.f.ds320);
        int dimensionPixelSize2 = this.dui.getResources().getDimensionPixelSize(w.f.ds480);
        int dimensionPixelSize3 = this.dui.getResources().getDimensionPixelSize(w.f.ds360);
        int dimensionPixelSize4 = this.dui.getResources().getDimensionPixelSize(w.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dui.getPageContext().getPageActivity(), this.bZb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, w.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.A(w.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.dui.getResources().getDimensionPixelSize(w.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        v(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dru = new r(this, imMessageCenterShowItemData);
        String string = this.dui.getPageContext().getPageActivity().getString(w.l.delete_user_chat);
        this.drt = new com.baidu.tbadk.core.dialog.c(this.dui.getPageContext().getPageActivity());
        this.drt.cb(w.l.operation);
        this.drt.a(new String[]{string}, this.dru);
        this.drt.d(this.dui.getPageContext());
    }

    protected boolean dE(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.drp.completePullRefreshPostDelayed(2000L);
        }
        return true;
    }

    public void gA(boolean z) {
        if (z) {
            if (awO() && this.drs.getVisibility() != 0) {
                this.drs.setVisibility(0);
            }
        } else if (this.drs.getVisibility() != 8) {
            this.drs.setVisibility(8);
        }
    }

    public void v(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.drp.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.bZb.removeView(this.mNoDataView);
        }
        gK(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.drp.setVisibility(8);
    }

    public boolean awO() {
        return this.drw;
    }

    public void gC(boolean z) {
        this.drw = z;
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
                if (this.drm != null) {
                    this.drm.insertOrUpdate(data, this.cZT);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.drm != null) {
                this.drm.remove(data, this.cZT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.drm != null) {
                this.drm.setData(data, this.cZT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.dun = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.dun != -1) {
                gI(true);
                onPrimary();
            }
        }
    }

    public void gH(boolean z) {
        BdListViewHelper.a(this.alM, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hj());
        if (z && this.drp != null && this.drp.getWrappedAdapter() != null && this.drp.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.fR().post(new s(this));
        }
    }

    @Override // com.baidu.tbadk.core.view.ae.b
    public void onListPullRefresh(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
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
        this.duj.mA(i);
        this.duj.mB(i2);
        this.duj.notifyDataSetChanged();
    }

    public void gL(boolean z) {
        this.bWn.setVisibility(z ? 0 : 8);
    }
}
