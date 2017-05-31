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
    private final CustomMessageListener aVv;
    private NoNetworkView aZX;
    private View akY;
    private View bGC;
    private NavigationBar bPq;
    private RelativeLayout bRF;
    private final CustomMessageListener bUY;
    private final CustomMessageListener cRV;
    private com.baidu.tieba.im.chat.a.a cRX;
    private boolean djA;
    private final AdapterView.OnItemClickListener djB;
    private final AdapterView.OnItemLongClickListener djC;
    private ImMessageCenterModel djq;
    private ImMessageCenterShowItemData djs;
    private BdListView djt;
    private ShutDownValidateTipView djw;
    com.baidu.tbadk.core.dialog.c djx;
    private c.b djy;
    private int djz;
    private final ad dmm;
    private MessageAggregationListAdapter dmn;
    private boolean dmo;
    private boolean dmp;
    private boolean dmq;
    private int dmr;
    private TextView dms;
    private CustomMessageListener dmt;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private View rootView;

    public l(ad adVar) {
        super(com.baidu.adp.base.k.Z(adVar.getPageContext().getPageActivity()));
        this.djq = null;
        this.djs = null;
        this.djt = null;
        this.dmn = null;
        this.djx = null;
        this.djA = true;
        this.dmo = false;
        this.dmp = false;
        this.dmq = true;
        this.dmr = 16;
        this.aVv = new m(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
        this.dmt = new t(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
        this.djB = new u(this);
        this.djC = new w(this);
        this.cRV = new x(this, 0);
        this.cRX = new y(this);
        this.bUY = new z(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.dmm = adVar;
    }

    public void h(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.dmr = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.dmr = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.dmr);
        }
    }

    public void abW() {
        if (this.dmn != null) {
            this.dmn.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cRV);
    }

    public View VN() {
        this.djz = 3;
        this.rootView = LayoutInflater.from(this.dmm.getPageContext().getPageActivity()).inflate(w.j.chat_list_activity, (ViewGroup) null, false);
        initData();
        ab(this.rootView);
        TiebaStatic.eventStat(this.dmm.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        VO();
        return this.rootView;
    }

    protected void VO() {
        this.djt.startPullRefresh();
        this.dmo = isLogin();
        if (!this.dmo) {
            u(this.dmo, true);
        }
    }

    private void registerListener() {
        this.dmm.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cRV);
        this.dmm.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cRV);
        this.dmm.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cRV);
        this.dmm.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cRV);
        this.dmm.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cRV);
        this.dmm.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cRV);
        this.dmm.registerListener(this.aVv);
        this.dmm.registerListener(this.dmt);
    }

    public void gq(boolean z) {
        this.dmp = z;
    }

    public void gr(boolean z) {
        this.dmq = z;
    }

    public void onPrimary() {
        if (this.dmn != null && this.dmn.getCount() == 0) {
            gq(true);
        }
        if (this.dmq || this.dmp) {
            this.dmq = false;
            this.dmp = false;
            dC(false);
        }
        boolean isLogin = isLogin();
        if (this.dmo != isLogin) {
            this.dmo = isLogin;
            onUserChanged(this.dmo);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dmm.getPageContext());
        }
    }

    private void initData() {
        this.djq = new ImMessageCenterModel();
        gk(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_shut_down_validate", false) ? false : true);
        this.dmm.registerListener(this.bUY);
    }

    private void ab(View view) {
        this.bRF = (RelativeLayout) view.findViewById(w.h.chat_list);
        this.djw = (ShutDownValidateTipView) view.findViewById(w.h.view_no_validate);
        this.djw.setVisibility(8);
        this.djw.setShutDownClickListener(new aa(this));
        this.bPq = (NavigationBar) this.bRF.findViewById(w.h.view_navigation_bar);
        this.dms = (TextView) this.bPq.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.maintab_title_layout, (View.OnClickListener) null).findViewById(w.h.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.dmm.getResources().getDimension(w.f.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.dms.setLayoutParams(layoutParams);
        this.dms.setText(w.l.my_message);
        this.bPq.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.bPq.setRegisterClickListener(new ab(this));
            this.bPq.setLoginClickListener(new n(this));
        }
        this.akY = new TextView(this.dmm.getPageContext().getPageActivity());
        this.akY.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dmm.getPageContext().getPageActivity(), w.f.ds98)));
        BdListViewHelper.a(this.akY, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hk());
        this.aZX = (NoNetworkView) this.bRF.findViewById(w.h.view_no_network);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aZX.getLayoutParams();
        layoutParams2.setMargins(0, com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 44.0f) + UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
        this.aZX.setLayoutParams(layoutParams2);
        this.aZX.a(new o(this));
        this.djt = (BdListView) view.findViewById(w.h.chat_list_content);
        this.djt.addHeaderView(this.akY);
        this.djt.setDividerHeight(0);
        this.dmn = new MessageAggregationListAdapter(this.dmm.getPageContext().getPageActivity());
        this.dmn.a(this);
        this.djt.setAdapter((ListAdapter) this.dmn);
        this.djt.setOnItemClickListener(this.djB);
        this.djt.setOnItemLongClickListener(this.djC);
        this.bGC = new View(this.dmm.getFragmentActivity());
        this.bGC.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.dmm.getFragmentActivity(), w.f.ds150)));
        this.djt.addFooterView(this.bGC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dmm.getPageContext(), i);
        }
        this.aZX.onChangeSkinType(getPageContext(), i);
        this.bPq.onChangeSkinType(tbPageContext, i);
        if (this.djw != null) {
            this.djw.onChangeSkinType(i);
        }
        com.baidu.tbadk.core.util.aq.a(this.dms, w.e.cp_cont_b, w.e.s_navbar_title_color, i);
        if (this.dmn != null) {
            this.dmn.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().t(this.bRF);
            return true;
        }
        return true;
    }

    private void gs(boolean z) {
        if (z) {
            atd();
        } else {
            LM();
        }
    }

    private void atd() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dmm.getResources().getString(w.l.maintab_imcenter_button_text), new p(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dmm.getPageContext().getPageActivity(), this.bRF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dmm.getResources().getDimension(w.f.ds320)), NoDataViewFactory.d.de(w.l.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void LM() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.dmm.getResources().getString(w.l.maintab_imcenter_unlogin_button_text), new q(this));
        int dimensionPixelSize = this.dmm.getResources().getDimensionPixelSize(w.f.ds320);
        int dimensionPixelSize2 = this.dmm.getResources().getDimensionPixelSize(w.f.ds480);
        int dimensionPixelSize3 = this.dmm.getResources().getDimensionPixelSize(w.f.ds360);
        int dimensionPixelSize4 = this.dmm.getResources().getDimensionPixelSize(w.f.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dmm.getPageContext().getPageActivity(), this.bRF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, w.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.A(w.l.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.dmm.getResources().getDimensionPixelSize(w.f.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        u(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.djy = new r(this, imMessageCenterShowItemData);
        String string = this.dmm.getPageContext().getPageActivity().getString(w.l.delete_user_chat);
        this.djx = new com.baidu.tbadk.core.dialog.c(this.dmm.getPageContext().getPageActivity());
        this.djx.cb(w.l.operation);
        this.djx.a(new String[]{string}, this.djy);
        this.djx.d(this.dmm.getPageContext());
    }

    protected boolean dC(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.djt.completePullRefreshPostDelayed(2000L);
        }
        return true;
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

    public void u(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.djt.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.bRF.removeView(this.mNoDataView);
        }
        gs(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.djt.setVisibility(8);
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
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.dmr = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.dmr != -1) {
                gq(true);
                onPrimary();
            }
        }
    }

    public void gp(boolean z) {
        BdListViewHelper.a(this.akY, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hk());
        if (z && this.djt != null && this.djt.getWrappedAdapter() != null && this.djt.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.fS().post(new s(this));
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
            aP(newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgAtme());
        }
    }

    private void aP(int i, int i2) {
        this.dmn.mp(i);
        this.dmn.mq(i2);
        this.dmn.notifyDataSetChanged();
    }

    public void gt(boolean z) {
        this.bPq.setVisibility(z ? 0 : 8);
    }
}
