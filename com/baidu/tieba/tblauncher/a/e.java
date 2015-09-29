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
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.MyLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class e implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final String ddv = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private d dds;
    private com.baidu.tbadk.mvc.g.d<com.baidu.tieba.tblauncher.a.a, com.baidu.tbadk.mvc.d.b, c> ddt;
    private a ddu;
    private TbPageContext<?> mContext;
    private final CustomMessageListener cOx = new f(this, CmdConfigCustom.LEFT_NAV_NEED_ADD_ITEM);
    private final CustomMessageListener ddw = new i(this, CmdConfigCustom.CMD_NIGHT_PLUGIN_INSATLLED);
    private View.OnClickListener ddx = new j(this);

    /* loaded from: classes.dex */
    public interface a {
        void fo(int i);
    }

    private void ayb() {
        if (this.mContext != null) {
            this.mContext.registerListener(this.cOx);
            this.mContext.registerListener(this.ddw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayc() {
        if (this.mContext != null) {
            p.ayR().n(this.mContext);
            p.ayR().b(new k(this));
        }
    }

    private void l(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.ddt = new com.baidu.tbadk.mvc.g.d<>(tbPageContext, c.class, i.g.left_navi_item, null);
        this.ddt.bo(false);
        p.ayR().n(tbPageContext);
        p.ayR().b(new l(this));
    }

    public d m(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        this.dds = new d(tbPageContext.getPageActivity());
        ayb();
        l(tbPageContext);
        ayb();
        this.dds.setListAdapter(this.ddt);
        this.dds.setOnPersonInfoViewClicked(this.ddx);
        this.dds.setOnListItemClicked(this);
        this.dds.setOnSettingViewClicked(this);
        this.dds.setUserIconOnClickListener(this);
        this.dds.setOnDayNightModeViewClicked(this);
        this.dds.setOnVipIconLoadListener(new m(this));
        e(tbPageContext);
        return this.dds;
    }

    public void ayL() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null && this.dds != null) {
            this.dds.lN(currentAccountObj.getPortrait());
            this.dds.setUserName(currentAccountObj.getAccount());
            this.dds.lO(currentAccountObj.getMemberIconUrl());
            this.dds.setUserSexIcon(currentAccountObj.getSex());
            this.dds.bw(currentAccountObj.getUserIcons());
        }
    }

    public void ayM() {
        aK(4, com.baidu.tbadk.core.sharedPref.b.tu().getBoolean(new StringBuilder("show_member_new_icon_").append(TbadkCoreApplication.m411getInst().getVersionCode()).append(TbadkCoreApplication.getCurrentAccount()).toString(), true) ? 1 : 0);
    }

    public void ayN() {
        aK(3, com.baidu.tbadk.core.sharedPref.b.tu().getBoolean(new StringBuilder("show_my_new_icon").append(TbadkCoreApplication.getCurrentAccount()).toString(), true) ? 1 : 0);
    }

    public void aK(int i, int i2) {
        p.ayR().b(new n(this, i, i2));
    }

    public void gH(boolean z) {
        if (this.dds != null) {
            this.dds.gH(z);
        }
    }

    public void gI(boolean z) {
        if (this.dds != null) {
            this.dds.gI(z);
        }
    }

    public void a(a aVar) {
        this.ddu = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.tblauncher.a.a item = this.ddt.getItem(i);
        if (item != null) {
            switch (item.getType()) {
                case 0:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddressListActivityConfig(view.getContext())));
                    return;
                case 1:
                    TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_entry", "is_redpoint", item.ayJ() == 0 ? 0 : 1, new Object[0]);
                    aK(1, 0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(view.getContext())));
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(view.getContext())));
                    return;
                case 3:
                    TiebaStatic.eventStat(view.getContext(), "myself_broadcast", "click", 1, new Object[0]);
                    com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("show_my_new_icon" + TbadkCoreApplication.getCurrentAccount(), false);
                    aK(3, 0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_LIVE_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyLiveActivityConfig(view.getContext())));
                    return;
                case 4:
                    com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("show_member_new_icon_" + TbadkCoreApplication.m411getInst().getVersionCode() + TbadkCoreApplication.getCurrentAccount(), false);
                    aK(4, 0);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPrivilegeActivityConfig(view.getContext())));
                    return;
                case 5:
                    aK(5, 0);
                    com.baidu.tbadk.core.sharedPref.b.tu().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(view.getContext())));
                    return;
                case 6:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_ACCOUNT, new IntentConfig(view.getContext())));
                    return;
                case 7:
                default:
                    item.onClick();
                    p.ayR().b(new o(this));
                    return;
                case 8:
                    TiebaStatic.log("c10072");
                    aU(view.getContext()).sR();
                    TiebaStatic.eventStat(view.getContext(), "sidebar_quit", "click", 1, new Object[0]);
                    return;
            }
        }
    }

    private com.baidu.tbadk.core.dialog.a aU(Context context) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.C(context).getPageActivity());
        aVar.bF(i.h.exit_tip);
        aVar.a(i.h.alert_yes_button, new g(this));
        aVar.b(i.h.alert_no_button, new h(this));
        return aVar.b(com.baidu.adp.base.l.C(context));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dds.getSettingView()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_SETTING_CLICK));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
        } else if (view == this.dds.getDayNightView()) {
            ayQ();
        } else if (view == this.dds.getUserIconView()) {
            ay(view);
        }
    }

    private void ay(View view) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            com.baidu.tbadk.browser.g.a(this.mContext.getPageActivity().getApplicationContext(), TbadkCoreApplication.m411getInst().getString(i.h.user_icon_web_view_title), String.valueOf(ddv) + "?user_id=" + TbadkCoreApplication.getCurrentAccount(), true, true, false);
            TiebaStatic.log(new ap("c10134").r("obj_type", 4));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayO() {
        if (this.dds != null) {
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                this.dds.setDayNightViewText(TbadkCoreApplication.m411getInst().getString(i.h.skin_mode_day));
            } else {
                this.dds.setDayNightViewText(TbadkCoreApplication.m411getInst().getString(i.h.skin_mode_night));
            }
        }
    }

    public d ayP() {
        return this.dds;
    }

    public void ayQ() {
        int i = 0;
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType == 0 || skinType == 2) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
            i = 1;
        }
        TbadkCoreApplication.m411getInst().setSkinType(i);
        if (this.ddu != null) {
            this.ddu.fo(i);
        }
        com.baidu.tbadk.core.util.c.iv();
    }

    public void e(TbPageContext tbPageContext) {
        if (this.dds != null) {
            this.dds.e(tbPageContext);
            ayO();
        }
        if (this.ddt != null) {
            this.ddt.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            this.ddt.notifyDataSetChanged();
        }
    }
}
