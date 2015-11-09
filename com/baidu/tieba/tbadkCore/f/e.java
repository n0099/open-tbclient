package com.baidu.tieba.tbadkCore.f;

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
    private static final String dcI = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private d dcF;
    private com.baidu.tbadk.mvc.g.d<com.baidu.tieba.tbadkCore.f.a, com.baidu.tbadk.mvc.d.b, c> dcG;
    private a dcH;
    private TbPageContext<?> mContext;
    private final CustomMessageListener cQs = new f(this, CmdConfigCustom.LEFT_NAV_NEED_ADD_ITEM);
    private final CustomMessageListener dcJ = new i(this, CmdConfigCustom.CMD_NIGHT_PLUGIN_INSATLLED);
    private View.OnClickListener dcK = new j(this);

    /* loaded from: classes.dex */
    public interface a {
        void fw(int i);
    }

    private void axY() {
        if (this.mContext != null) {
            this.mContext.registerListener(this.cQs);
            this.mContext.registerListener(this.dcJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axZ() {
        if (this.mContext != null) {
            p.ayg().n(this.mContext);
            p.ayg().b(new k(this));
        }
    }

    private void l(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.dcG = new com.baidu.tbadk.mvc.g.d<>(tbPageContext, c.class, i.g.left_navi_item, null);
        this.dcG.br(false);
        p.ayg().n(tbPageContext);
        p.ayg().b(new l(this));
    }

    public d m(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        this.dcF = new d(tbPageContext.getPageActivity());
        axY();
        l(tbPageContext);
        axY();
        this.dcF.setListAdapter(this.dcG);
        this.dcF.setOnPersonInfoViewClicked(this.dcK);
        this.dcF.setOnListItemClicked(this);
        this.dcF.setOnSettingViewClicked(this);
        this.dcF.setUserIconOnClickListener(this);
        this.dcF.setOnDayNightModeViewClicked(this);
        this.dcF.setOnVipIconLoadListener(new m(this));
        e(tbPageContext);
        return this.dcF;
    }

    public void aya() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null && this.dcF != null) {
            this.dcF.lH(currentAccountObj.getPortrait());
            this.dcF.setUserName(currentAccountObj.getAccount());
            this.dcF.lI(currentAccountObj.getMemberIconUrl());
            this.dcF.setUserSexIcon(currentAccountObj.getSex());
            this.dcF.bA(currentAccountObj.getUserIcons());
        }
    }

    public void ayb() {
        aK(4, com.baidu.tbadk.core.sharedPref.b.tu().getBoolean(new StringBuilder("show_member_new_icon_").append(TbadkCoreApplication.m411getInst().getVersionCode()).append(TbadkCoreApplication.getCurrentAccount()).toString(), true) ? 1 : 0);
    }

    public void ayc() {
        aK(3, com.baidu.tbadk.core.sharedPref.b.tu().getBoolean(new StringBuilder("show_my_new_icon").append(TbadkCoreApplication.getCurrentAccount()).toString(), true) ? 1 : 0);
    }

    public void aK(int i, int i2) {
        p.ayg().b(new n(this, i, i2));
    }

    public void gy(boolean z) {
        if (this.dcF != null) {
            this.dcF.gy(z);
        }
    }

    public void gz(boolean z) {
        if (this.dcF != null) {
            this.dcF.gz(z);
        }
    }

    public void a(a aVar) {
        this.dcH = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.tbadkCore.f.a item = this.dcG.getItem(i);
        if (item != null) {
            switch (item.getType()) {
                case 0:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddressListActivityConfig(view.getContext())));
                    return;
                case 1:
                    TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_entry", "is_redpoint", item.axW() == 0 ? 0 : 1, new Object[0]);
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
                    p.ayg().b(new o(this));
                    return;
                case 8:
                    TiebaStatic.log("c10072");
                    aT(view.getContext()).sR();
                    TiebaStatic.eventStat(view.getContext(), "sidebar_quit", "click", 1, new Object[0]);
                    return;
            }
        }
    }

    private com.baidu.tbadk.core.dialog.a aT(Context context) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.C(context).getPageActivity());
        aVar.bF(i.h.exit_tip);
        aVar.a(i.h.alert_yes_button, new g(this));
        aVar.b(i.h.alert_no_button, new h(this));
        return aVar.b(com.baidu.adp.base.l.C(context));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dcF.getSettingView()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_SETTING_CLICK));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
        } else if (view == this.dcF.getDayNightView()) {
            ayf();
        } else if (view == this.dcF.getUserIconView()) {
            ax(view);
        }
    }

    private void ax(View view) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            com.baidu.tbadk.browser.g.a(this.mContext.getPageActivity().getApplicationContext(), TbadkCoreApplication.m411getInst().getString(i.h.user_icon_web_view_title), String.valueOf(dcI) + "?user_id=" + TbadkCoreApplication.getCurrentAccount(), true, true, false);
            TiebaStatic.log(new aq("c10134").r("obj_type", 4));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayd() {
        if (this.dcF != null) {
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                this.dcF.setDayNightViewText(TbadkCoreApplication.m411getInst().getString(i.h.skin_mode_day));
            } else {
                this.dcF.setDayNightViewText(TbadkCoreApplication.m411getInst().getString(i.h.skin_mode_night));
            }
        }
    }

    public d aye() {
        return this.dcF;
    }

    public void ayf() {
        int i = 0;
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType == 0 || skinType == 2) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
            i = 1;
        }
        TbadkCoreApplication.m411getInst().setSkinType(i);
        if (this.dcH != null) {
            this.dcH.fw(i);
        }
        com.baidu.tbadk.core.util.c.iw();
    }

    public void e(TbPageContext tbPageContext) {
        if (this.dcF != null) {
            this.dcF.e(tbPageContext);
            ayd();
        }
        if (this.dcG != null) {
            this.dcG.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            this.dcG.notifyDataSetChanged();
        }
    }
}
