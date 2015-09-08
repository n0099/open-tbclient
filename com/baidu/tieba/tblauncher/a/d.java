package com.baidu.tieba.tblauncher.a;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.MyLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class d implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final String cVN = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private c cVK;
    private com.baidu.tbadk.mvc.g.d<com.baidu.tieba.tbadkCore.f.a, com.baidu.tbadk.mvc.d.b, b> cVL;
    private a cVM;
    private TbPageContext<?> mContext;
    private final CustomMessageListener cHw = new e(this, CmdConfigCustom.LEFT_NAV_NEED_ADD_ITEM);
    private final CustomMessageListener cVO = new h(this, CmdConfigCustom.CMD_NIGHT_PLUGIN_INSATLLED);
    private View.OnClickListener cVP = new i(this);

    /* loaded from: classes.dex */
    public interface a {
        void fj(int i);
    }

    private void avN() {
        if (this.mContext != null) {
            this.mContext.registerListener(this.cHw);
            this.mContext.registerListener(this.cVO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avO() {
        if (this.mContext != null) {
            o.awz().n(this.mContext);
            o.awz().b(new j(this));
        }
    }

    private void l(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.cVL = new com.baidu.tbadk.mvc.g.d<>(tbPageContext, b.class, i.g.left_navi_item, null);
        this.cVL.bq(false);
        o.awz().n(tbPageContext);
        o.awz().b(new k(this));
    }

    public c m(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        this.cVK = new c(tbPageContext.getPageActivity());
        avN();
        l(tbPageContext);
        avN();
        this.cVK.setListAdapter(this.cVL);
        this.cVK.setOnPersonInfoViewClicked(this.cVP);
        this.cVK.setOnListItemClicked(this);
        this.cVK.setOnSettingViewClicked(this);
        this.cVK.setUserIconOnClickListener(this);
        this.cVK.setOnDayNightModeViewClicked(this);
        this.cVK.setOnVipIconLoadListener(new l(this));
        e(tbPageContext);
        return this.cVK;
    }

    public void awt() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null && this.cVK != null) {
            this.cVK.ln(currentAccountObj.getPortrait());
            this.cVK.setUserName(currentAccountObj.getAccount());
            this.cVK.lo(currentAccountObj.getMemberIconUrl());
            this.cVK.setUserSexIcon(currentAccountObj.getSex());
            this.cVK.bt(currentAccountObj.getUserIcons());
        }
    }

    public void awu() {
        aL(4, com.baidu.tbadk.core.sharedPref.b.tx().getBoolean(new StringBuilder("show_member_new_icon_").append(TbadkCoreApplication.m411getInst().getVersionCode()).append(TbadkCoreApplication.getCurrentAccount()).toString(), true) ? 1 : 0);
    }

    public void awv() {
        aL(3, com.baidu.tbadk.core.sharedPref.b.tx().getBoolean(new StringBuilder("show_my_new_icon").append(TbadkCoreApplication.getCurrentAccount()).toString(), true) ? 1 : 0);
    }

    public void aL(int i, int i2) {
        o.awz().b(new m(this, i, i2));
    }

    public void gx(boolean z) {
        if (this.cVK != null) {
            this.cVK.gx(z);
        }
    }

    public void gy(boolean z) {
        if (this.cVK != null) {
            this.cVK.gy(z);
        }
    }

    public void a(a aVar) {
        this.cVM = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.tbadkCore.f.a item = this.cVL.getItem(i);
        if (item != null) {
            switch (item.getType()) {
                case 0:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddressListActivityConfig(view.getContext())));
                    return;
                case 1:
                    TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_entry", "is_redpoint", item.auL() == 0 ? 0 : 1, new Object[0]);
                    aL(1, 0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(view.getContext())));
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(view.getContext())));
                    return;
                case 3:
                    TiebaStatic.eventStat(view.getContext(), "myself_broadcast", "click", 1, new Object[0]);
                    com.baidu.tbadk.core.sharedPref.b.tx().putBoolean("show_my_new_icon" + TbadkCoreApplication.getCurrentAccount(), false);
                    aL(3, 0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_LIVE_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyLiveActivityConfig(view.getContext())));
                    return;
                case 4:
                    com.baidu.tbadk.core.sharedPref.b.tx().putBoolean("show_member_new_icon_" + TbadkCoreApplication.m411getInst().getVersionCode() + TbadkCoreApplication.getCurrentAccount(), false);
                    aL(4, 0);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPrivilegeActivityConfig(view.getContext())));
                    return;
                case 5:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_ACCOUNT, new IntentConfig(view.getContext())));
                    return;
                case 6:
                default:
                    item.onClick();
                    o.awz().b(new n(this));
                    return;
                case 7:
                    TiebaStatic.log("c10072");
                    aV(view.getContext()).sU();
                    TiebaStatic.eventStat(view.getContext(), "sidebar_quit", "click", 1, new Object[0]);
                    return;
            }
        }
    }

    private com.baidu.tbadk.core.dialog.a aV(Context context) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.C(context).getPageActivity());
        aVar.bF(i.h.exit_tip);
        aVar.a(i.h.alert_yes_button, new f(this));
        aVar.b(i.h.alert_no_button, new g(this));
        return aVar.b(com.baidu.adp.base.l.C(context));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cVK.getSettingView()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_SETTING_CLICK));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
        } else if (view == this.cVK.getDayNightView()) {
            awy();
        } else if (view == this.cVK.getUserIconView()) {
            ax(view);
        }
    }

    private void ax(View view) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            com.baidu.tbadk.browser.g.a(this.mContext.getPageActivity().getApplicationContext(), TbadkCoreApplication.m411getInst().getString(i.h.user_icon_web_view_title), String.valueOf(cVN) + "?user_id=" + TbadkCoreApplication.getCurrentAccount(), true, true, false);
            TiebaStatic.log(new ao("c10134").r("obj_type", 4));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aww() {
        if (this.cVK != null) {
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                this.cVK.setDayNightViewText(TbadkCoreApplication.m411getInst().getString(i.h.skin_mode_day));
            } else {
                this.cVK.setDayNightViewText(TbadkCoreApplication.m411getInst().getString(i.h.skin_mode_night));
            }
        }
    }

    public c awx() {
        return this.cVK;
    }

    public void awy() {
        int i = 1;
        if (TbadkCoreApplication.m411getInst().getSkinType() == 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
        } else {
            i = 0;
        }
        TbadkCoreApplication.m411getInst().setSkinType(i);
        if (this.cVM != null) {
            this.cVM.fj(i);
        }
        com.baidu.tbadk.core.util.c.iu();
    }

    public void e(TbPageContext tbPageContext) {
        if (this.cVK != null) {
            this.cVK.e(tbPageContext);
            aww();
        }
        if (this.cVL != null) {
            this.cVL.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            this.cVL.notifyDataSetChanged();
        }
    }
}
