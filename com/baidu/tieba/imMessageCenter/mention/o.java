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
import com.baidu.tbadk.core.view.z;
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
public class o extends com.baidu.adp.base.f<ag> implements z.b {
    private NoNetworkView Hj;
    private View aAK;
    private final CustomMessageListener aVv;
    private View agt;
    private View brd;
    private NavigationBar bty;
    private RelativeLayout bvS;
    private final CustomMessageListener bzh;
    private final CustomMessageListener cIj;
    private com.baidu.tieba.im.chat.a.a cIl;
    private ShutDownValidateTipView cZC;
    com.baidu.tbadk.core.dialog.c cZD;
    private c.b cZE;
    private int cZF;
    private boolean cZG;
    private final AdapterView.OnItemClickListener cZH;
    private final AdapterView.OnItemLongClickListener cZI;
    private ImMessageCenterModel cZw;
    private ImMessageCenterShowItemData cZy;
    private BdListView cZz;
    private final ag dcq;
    private MessageAggregationListAdapter dcr;
    private boolean dcs;
    private boolean dct;
    private boolean dcv;
    private int dcw;
    private TextView dcx;
    private CustomMessageListener dcy;
    private com.baidu.tbadk.core.view.w mNoDataView;

    public o(ag agVar) {
        super(com.baidu.adp.base.l.C(agVar.getPageContext().getPageActivity()));
        this.cZw = null;
        this.cZy = null;
        this.cZz = null;
        this.dcr = null;
        this.cZD = null;
        this.cZG = true;
        this.dcs = false;
        this.dct = false;
        this.dcv = true;
        this.dcw = 16;
        this.aVv = new p(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
        this.dcy = new w(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
        this.cZH = new x(this);
        this.cZI = new z(this);
        this.cIj = new aa(this, 0);
        this.cIl = new ab(this);
        this.bzh = new ac(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.dcq = agVar;
    }

    public void f(Bundle bundle) {
        if (MentionActivityConfig.jumpInTab != -1) {
            this.dcw = MentionActivityConfig.jumpInTab;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.dcw = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.dcw);
        }
    }

    public void Zi() {
        if (this.dcr != null) {
            this.dcr.notifyDataSetChanged();
        }
    }

    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cIj);
    }

    public View me() {
        this.cZF = 3;
        this.aAK = LayoutInflater.from(this.dcq.getPageContext().getPageActivity()).inflate(r.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        aa(this.aAK);
        TiebaStatic.eventStat(this.dcq.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        lT();
        return this.aAK;
    }

    protected void lT() {
        this.cZz.kv();
        this.dcs = isLogin();
        if (!this.dcs) {
            u(this.dcs, true);
        }
    }

    private void registerListener() {
        this.dcq.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cIj);
        this.dcq.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cIj);
        this.dcq.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cIj);
        this.dcq.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cIj);
        this.dcq.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cIj);
        this.dcq.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cIj);
        this.dcq.registerListener(this.aVv);
        this.dcq.registerListener(this.dcy);
    }

    public void gy(boolean z) {
        this.dct = z;
    }

    public void gz(boolean z) {
        this.dcv = z;
    }

    public void onPrimary() {
        if (this.dcr != null && this.dcr.getCount() == 0) {
            gy(true);
        }
        if (this.dcv || this.dct) {
            this.dcv = false;
            this.dct = false;
            cC(false);
        }
        boolean isLogin = isLogin();
        if (this.dcs != isLogin) {
            this.dcs = isLogin;
            onUserChanged(this.dcs);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dcq.getPageContext());
        }
    }

    private void initData() {
        this.cZw = new ImMessageCenterModel();
        gs(com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("is_shut_down_validate", false) ? false : true);
        this.dcq.registerListener(this.bzh);
    }

    private void aa(View view) {
        this.bvS = (RelativeLayout) view.findViewById(r.g.chat_list);
        this.cZC = (ShutDownValidateTipView) view.findViewById(r.g.view_no_validate);
        this.cZC.setVisibility(8);
        this.cZC.setShutDownClickListener(new ad(this));
        this.bty = (NavigationBar) this.bvS.findViewById(r.g.view_navigation_bar);
        this.dcx = (TextView) this.bty.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.maintab_title_layout, (View.OnClickListener) null).findViewById(r.g.title_textview);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int dimension = (int) this.dcq.getResources().getDimension(r.e.ds16);
        layoutParams.setMargins(dimension, dimension, 0, dimension);
        this.dcx.setLayoutParams(layoutParams);
        this.dcx.setText(r.j.enter_message);
        this.bty.switchNaviBarStatus(isLogin());
        if (!isLogin()) {
            this.bty.setRegisterClickListener(new ae(this));
            this.bty.setLoginClickListener(new q(this));
        }
        this.agt = new TextView(this.dcq.getPageContext().getPageActivity());
        this.agt.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(this.dcq.getPageContext().getPageActivity(), r.e.ds98)));
        BdListViewHelper.a(this.agt, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.gm());
        this.Hj = (NoNetworkView) this.bvS.findViewById(r.g.view_no_network);
        this.Hj.a(new r(this));
        this.cZz = (BdListView) view.findViewById(r.g.chat_list_content);
        this.cZz.addHeaderView(this.agt);
        this.cZz.setDividerHeight(0);
        this.dcr = new MessageAggregationListAdapter(this.dcq.getPageContext().getPageActivity());
        this.dcr.a(this);
        this.cZz.setAdapter((ListAdapter) this.dcr);
        this.cZz.setOnItemClickListener(this.cZH);
        this.cZz.setOnItemLongClickListener(this.cZI);
        this.brd = new View(this.dcq.getFragmentActivity());
        this.brd.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.dcq.getFragmentActivity(), r.e.ds150)));
        this.cZz.addFooterView(this.brd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLogin() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.cZF == i) {
            return false;
        }
        this.cZF = i;
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dcq.getPageContext(), i);
        }
        this.Hj.onChangeSkinType(getPageContext(), i);
        this.bty.onChangeSkinType(tbPageContext, i);
        if (this.cZC != null) {
            this.cZC.onChangeSkinType(i);
        }
        com.baidu.tbadk.core.util.ar.a(this.dcx, r.d.cp_cont_b, r.d.s_navbar_title_color, i);
        if (this.dcr != null) {
            this.dcr.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().x(this.bvS);
        }
        return true;
    }

    private void gA(boolean z) {
        if (z) {
            atP();
        } else {
            atQ();
        }
    }

    private void atP() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dcq.getResources().getString(r.j.maintab_imcenter_button_text), new s(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dcq.getPageContext().getPageActivity(), this.bvS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dcq.getResources().getDimension(r.e.ds320)), NoDataViewFactory.d.dh(r.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void atQ() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.dcq.getResources().getString(r.j.maintab_imcenter_unlogin_button_text), new t(this));
        int dimensionPixelSize = this.dcq.getResources().getDimensionPixelSize(r.e.ds320);
        int dimensionPixelSize2 = this.dcq.getResources().getDimensionPixelSize(r.e.ds480);
        int dimensionPixelSize3 = this.dcq.getResources().getDimensionPixelSize(r.e.ds360);
        int dimensionPixelSize4 = this.dcq.getResources().getDimensionPixelSize(r.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dcq.getPageContext().getPageActivity(), this.bvS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, r.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.w(r.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.dcq.getResources().getDimensionPixelSize(r.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        u(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.cZE = new u(this, imMessageCenterShowItemData);
        String string = this.dcq.getPageContext().getPageActivity().getString(r.j.delete_user_chat);
        this.cZD = new com.baidu.tbadk.core.dialog.c(this.dcq.getPageContext().getPageActivity());
        this.cZD.ce(r.j.operation);
        this.cZD.a(new String[]{string}, this.cZE);
        this.cZD.d(this.dcq.getPageContext());
    }

    protected boolean cC(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.cZz.l(2000L);
        }
        return true;
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

    public void u(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.cZz.setVisibility(0);
            return;
        }
        if (this.mNoDataView != null) {
            this.bvS.removeView(this.mNoDataView);
        }
        gA(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
        this.cZz.setVisibility(8);
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
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            this.dcw = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            if (this.dcw != -1) {
                gy(true);
                onPrimary();
            }
        }
    }

    public void gx(boolean z) {
        BdListViewHelper.a(this.agt, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.gm());
        if (z && this.cZz != null && this.cZz.getWrappedAdapter() != null && this.cZz.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.h.h.eG().post(new v(this));
        }
    }

    @Override // com.baidu.tbadk.core.view.z.b
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
        this.dcr.ly(i);
        this.dcr.lz(i2);
        this.dcr.notifyDataSetChanged();
    }

    public void gB(boolean z) {
        this.bty.setVisibility(z ? 0 : 8);
    }
}
