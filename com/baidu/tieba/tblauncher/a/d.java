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
    private static final String cNg = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private TbPageContext<?> LS;
    private c cNd;
    private com.baidu.tbadk.mvc.g.d<com.baidu.tieba.tbadkCore.f.a, com.baidu.tbadk.mvc.d.b, b> cNe;
    private a cNf;
    private final CustomMessageListener cyY = new e(this, CmdConfigCustom.LEFT_NAV_NEED_ADD_ITEM);
    private final CustomMessageListener cNh = new h(this, CmdConfigCustom.CMD_NIGHT_PLUGIN_INSATLLED);
    private View.OnClickListener cNi = new i(this);

    /* loaded from: classes.dex */
    public interface a {
        void fc(int i);
    }

    private void arz() {
        if (this.LS != null) {
            this.LS.registerListener(this.cyY);
            this.LS.registerListener(this.cNh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arB() {
        if (this.LS != null) {
            o.asg().n(this.LS);
            o.asg().b(new j(this));
        }
    }

    private void l(TbPageContext tbPageContext) {
        this.LS = tbPageContext;
        this.cNe = new com.baidu.tbadk.mvc.g.d<>(tbPageContext, b.class, i.g.left_navi_item, null);
        this.cNe.bj(false);
        o.asg().n(tbPageContext);
        o.asg().b(new k(this));
    }

    public c m(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        this.cNd = new c(tbPageContext.getPageActivity());
        l(tbPageContext);
        arz();
        this.cNd.setListAdapter(this.cNe);
        this.cNd.setOnPersonInfoViewClicked(this.cNi);
        this.cNd.setOnListItemClicked(this);
        this.cNd.setOnSettingViewClicked(this);
        this.cNd.setUserIconOnClickListener(this);
        this.cNd.setOnDayNightModeViewClicked(this);
        this.cNd.setOnVipIconLoadListener(new l(this));
        e(tbPageContext);
        return this.cNd;
    }

    public void asb() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null && this.cNd != null) {
            this.cNd.kG(currentAccountObj.getPortrait());
            this.cNd.setUserName(currentAccountObj.getAccount());
            this.cNd.kH(currentAccountObj.getMemberIconUrl());
            this.cNd.setUserSexIcon(currentAccountObj.getSex());
            this.cNd.bk(currentAccountObj.getUserIcons());
        }
    }

    public void asc() {
        aC(4, com.baidu.tbadk.core.sharedPref.b.ts().getBoolean(new StringBuilder("show_member_new_icon_").append(TbadkCoreApplication.m411getInst().getVersionCode()).append(TbadkCoreApplication.getCurrentAccount()).toString(), true) ? 1 : 0);
    }

    public void aC(int i, int i2) {
        o.asg().b(new m(this, i, i2));
    }

    public void fM(boolean z) {
        if (this.cNd != null) {
            this.cNd.fM(z);
        }
    }

    public void fN(boolean z) {
        if (this.cNd != null) {
            this.cNd.fN(z);
        }
    }

    public void a(a aVar) {
        this.cNf = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.tbadkCore.f.a item = this.cNe.getItem(i);
        if (item != null) {
            switch (item.getType()) {
                case 0:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddressListActivityConfig(view.getContext())));
                    return;
                case 1:
                    TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_entry", "is_redpoint", item.aqx() == 0 ? 0 : 1, new Object[0]);
                    aC(1, 0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(view.getContext())));
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(view.getContext())));
                    return;
                case 3:
                    TiebaStatic.eventStat(view.getContext(), "myself_broadcast", "click", 1, new Object[0]);
                    aC(3, 0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_LIVE_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyLiveActivityConfig(view.getContext())));
                    return;
                case 4:
                    com.baidu.tbadk.core.sharedPref.b.ts().putBoolean("show_member_new_icon_" + TbadkCoreApplication.m411getInst().getVersionCode() + TbadkCoreApplication.getCurrentAccount(), false);
                    aC(4, 0);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPrivilegeActivityConfig(view.getContext())));
                    return;
                case 5:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_ACCOUNT, new IntentConfig(view.getContext())));
                    return;
                case 6:
                default:
                    item.onClick();
                    o.asg().b(new n(this));
                    return;
                case 7:
                    TiebaStatic.log("c10072");
                    aS(view.getContext()).sP();
                    TiebaStatic.eventStat(view.getContext(), "sidebar_quit", "click", 1, new Object[0]);
                    return;
            }
        }
    }

    private com.baidu.tbadk.core.dialog.a aS(Context context) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.C(context).getPageActivity());
        aVar.bC(i.C0057i.exit_tip);
        aVar.a(i.C0057i.alert_yes_button, new f(this));
        aVar.b(i.C0057i.alert_no_button, new g(this));
        return aVar.b(com.baidu.adp.base.l.C(context));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cNd.getSettingView()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_SETTING_CLICK));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
        } else if (view == this.cNd.getDayNightView()) {
            asf();
        } else if (view == this.cNd.getUserIconView()) {
            ao(view);
        }
    }

    private void ao(View view) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            com.baidu.tbadk.browser.f.a(this.LS.getPageActivity().getApplicationContext(), TbadkCoreApplication.m411getInst().getString(i.C0057i.user_icon_web_view_title), String.valueOf(cNg) + "?user_id=" + TbadkCoreApplication.getCurrentAccount(), true, true, false);
            TiebaStatic.log(new ao("c10134").r("obj_type", 4));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asd() {
        if (this.cNd != null) {
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                this.cNd.setDayNightViewText(TbadkCoreApplication.m411getInst().getString(i.C0057i.skin_mode_day));
            } else {
                this.cNd.setDayNightViewText(TbadkCoreApplication.m411getInst().getString(i.C0057i.skin_mode_night));
            }
        }
    }

    public c ase() {
        return this.cNd;
    }

    public void asf() {
        int i = 1;
        if (TbadkCoreApplication.m411getInst().getSkinType() == 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
        } else {
            i = 0;
        }
        TbadkCoreApplication.m411getInst().setSkinType(i);
        if (this.cNf != null) {
            this.cNf.fc(i);
        }
        com.baidu.tbadk.core.util.c.ix();
    }

    public void e(TbPageContext tbPageContext) {
        if (this.cNd != null) {
            this.cNd.e(tbPageContext);
            asd();
        }
        if (this.cNe != null) {
            this.cNe.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            this.cNe.notifyDataSetChanged();
        }
    }
}
