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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class e implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final String ddV = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private d ddS;
    private com.baidu.tbadk.mvc.g.d<com.baidu.tieba.tblauncher.a.a, com.baidu.tbadk.mvc.d.b, c> ddT;
    private a ddU;
    private TbPageContext<?> mContext;
    private final CustomMessageListener cOW = new f(this, CmdConfigCustom.LEFT_NAV_NEED_ADD_ITEM);
    private final CustomMessageListener ddW = new i(this, CmdConfigCustom.CMD_NIGHT_PLUGIN_INSATLLED);
    private View.OnClickListener ddX = new j(this);

    /* loaded from: classes.dex */
    public interface a {
        void fo(int i);
    }

    private void ayh() {
        if (this.mContext != null) {
            this.mContext.registerListener(this.cOW);
            this.mContext.registerListener(this.ddW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayi() {
        if (this.mContext != null) {
            p.ayX().n(this.mContext);
            p.ayX().b(new k(this));
        }
    }

    private void l(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.ddT = new com.baidu.tbadk.mvc.g.d<>(tbPageContext, c.class, i.g.left_navi_item, null);
        this.ddT.bo(false);
        p.ayX().n(tbPageContext);
        p.ayX().b(new l(this));
    }

    public d m(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        this.ddS = new d(tbPageContext.getPageActivity());
        ayh();
        l(tbPageContext);
        ayh();
        this.ddS.setListAdapter(this.ddT);
        this.ddS.setOnPersonInfoViewClicked(this.ddX);
        this.ddS.setOnListItemClicked(this);
        this.ddS.setOnSettingViewClicked(this);
        this.ddS.setUserIconOnClickListener(this);
        this.ddS.setOnDayNightModeViewClicked(this);
        this.ddS.setOnVipIconLoadListener(new m(this));
        e(tbPageContext);
        return this.ddS;
    }

    public void ayR() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null && this.ddS != null) {
            this.ddS.lQ(currentAccountObj.getPortrait());
            this.ddS.setUserName(currentAccountObj.getAccount());
            this.ddS.lR(currentAccountObj.getMemberIconUrl());
            this.ddS.setUserSexIcon(currentAccountObj.getSex());
            this.ddS.bx(currentAccountObj.getUserIcons());
        }
    }

    public void ayS() {
        aK(4, com.baidu.tbadk.core.sharedPref.b.tr().getBoolean(new StringBuilder("show_member_new_icon_").append(TbadkCoreApplication.m411getInst().getVersionCode()).append(TbadkCoreApplication.getCurrentAccount()).toString(), true) ? 1 : 0);
    }

    public void ayT() {
        aK(3, com.baidu.tbadk.core.sharedPref.b.tr().getBoolean(new StringBuilder("show_my_new_icon").append(TbadkCoreApplication.getCurrentAccount()).toString(), true) ? 1 : 0);
    }

    public void aK(int i, int i2) {
        p.ayX().b(new n(this, i, i2));
    }

    public void gH(boolean z) {
        if (this.ddS != null) {
            this.ddS.gH(z);
        }
    }

    public void gI(boolean z) {
        if (this.ddS != null) {
            this.ddS.gI(z);
        }
    }

    public void a(a aVar) {
        this.ddU = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.tblauncher.a.a item = this.ddT.getItem(i);
        if (item != null) {
            switch (item.getType()) {
                case 0:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddressListActivityConfig(view.getContext())));
                    return;
                case 1:
                    TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_entry", "is_redpoint", item.ayP() == 0 ? 0 : 1, new Object[0]);
                    aK(1, 0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(view.getContext())));
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(view.getContext())));
                    return;
                case 3:
                    TiebaStatic.eventStat(view.getContext(), "myself_broadcast", "click", 1, new Object[0]);
                    com.baidu.tbadk.core.sharedPref.b.tr().putBoolean("show_my_new_icon" + TbadkCoreApplication.getCurrentAccount(), false);
                    aK(3, 0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_LIVE_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyLiveActivityConfig(view.getContext())));
                    return;
                case 4:
                    com.baidu.tbadk.core.sharedPref.b.tr().putBoolean("show_member_new_icon_" + TbadkCoreApplication.m411getInst().getVersionCode() + TbadkCoreApplication.getCurrentAccount(), false);
                    aK(4, 0);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPrivilegeActivityConfig(view.getContext())));
                    return;
                case 5:
                    aK(5, 0);
                    com.baidu.tbadk.core.sharedPref.b.tr().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(view.getContext())));
                    return;
                case 6:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_ACCOUNT, new IntentConfig(view.getContext())));
                    return;
                case 7:
                default:
                    item.onClick();
                    p.ayX().b(new o(this));
                    return;
                case 8:
                    TiebaStatic.log("c10072");
                    aU(view.getContext()).sO();
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
        if (view == this.ddS.getSettingView()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_SETTING_CLICK));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
        } else if (view == this.ddS.getDayNightView()) {
            ayW();
        } else if (view == this.ddS.getUserIconView()) {
            ay(view);
        }
    }

    private void ay(View view) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            com.baidu.tbadk.browser.g.a(this.mContext.getPageActivity().getApplicationContext(), TbadkCoreApplication.m411getInst().getString(i.h.user_icon_web_view_title), String.valueOf(ddV) + "?user_id=" + TbadkCoreApplication.getCurrentAccount(), true, true, false);
            TiebaStatic.log(new aq("c10134").r("obj_type", 4));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayU() {
        if (this.ddS != null) {
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                this.ddS.setDayNightViewText(TbadkCoreApplication.m411getInst().getString(i.h.skin_mode_day));
            } else {
                this.ddS.setDayNightViewText(TbadkCoreApplication.m411getInst().getString(i.h.skin_mode_night));
            }
        }
    }

    public d ayV() {
        return this.ddS;
    }

    public void ayW() {
        int i = 0;
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType == 0 || skinType == 2) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
            i = 1;
        }
        TbadkCoreApplication.m411getInst().setSkinType(i);
        if (this.ddU != null) {
            this.ddU.fo(i);
        }
        com.baidu.tbadk.core.util.c.iv();
    }

    public void e(TbPageContext tbPageContext) {
        if (this.ddS != null) {
            this.ddS.e(tbPageContext);
            ayU();
        }
        if (this.ddT != null) {
            this.ddT.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            this.ddT.notifyDataSetChanged();
        }
    }
}
