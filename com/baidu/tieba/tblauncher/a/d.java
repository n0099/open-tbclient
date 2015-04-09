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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class d implements View.OnClickListener, AdapterView.OnItemClickListener {
    private TbPageContext LP;
    private c csp;
    private com.baidu.tbadk.mvc.j.d<com.baidu.tieba.tbadkCore.f.a, com.baidu.tbadk.mvc.e.c, b> csq;
    private o csr;
    private View mView;
    private final CustomMessageListener ccx = new e(this, 2001274);
    private View.OnClickListener css = new g(this);

    public d() {
        aoi();
    }

    private void aoi() {
        MessageManager.getInstance().registerListener(this.ccx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amj() {
        if (this.LP != null) {
            p.aoQ().l(this.LP);
            p.aoQ().b(new h(this));
        }
    }

    private void j(TbPageContext tbPageContext) {
        this.LP = tbPageContext;
        this.csq = new com.baidu.tbadk.mvc.j.d<>(tbPageContext, b.class, w.left_navi_item, null);
        this.csq.bb(false);
        p.aoQ().l(tbPageContext);
        p.aoQ().b(new i(this));
    }

    public c k(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        this.csp = new c(tbPageContext.getPageActivity());
        j(tbPageContext);
        this.csp.setListAdapter(this.csq);
        this.csp.setOnPersonInfoViewClicked(this.css);
        this.csp.setOnListItemClicked(this);
        this.csp.setOnSettingViewClicked(this);
        this.csp.setOnDayNightModeViewClicked(this);
        this.csp.setOnVipIconLoadListener(new j(this));
        f(tbPageContext);
        return this.csp;
    }

    public void aoK() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null && this.csp != null) {
            this.csp.iT(currentAccountObj.getPortrait());
            this.csp.setUserName(currentAccountObj.getAccount());
            this.csp.iU(currentAccountObj.getMemberIconUrl());
            this.csp.setUserSexIcon(currentAccountObj.getSex());
        }
    }

    public void aoL() {
        al(4, com.baidu.tbadk.core.sharedPref.b.rB().getBoolean(new StringBuilder("show_member_new_icon_").append(TbadkCoreApplication.m411getInst().getVersionCode()).append(TbadkCoreApplication.getCurrentAccount()).toString(), true) ? 1 : 0);
    }

    public void al(int i, int i2) {
        p.aoQ().b(new k(this, i, i2));
    }

    public void eY(boolean z) {
        if (this.csp != null) {
            this.csp.eY(z);
        }
    }

    public void eZ(boolean z) {
        if (this.csp != null) {
            this.csp.eZ(z);
        }
    }

    public View aoM() {
        p.aoQ().b(new l(this));
        return this.mView;
    }

    public void a(o oVar) {
        this.csr = oVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.tbadkCore.f.a item = this.csq.getItem(i);
        if (item != null) {
            switch (item.getType()) {
                case 0:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001189));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddressListActivityConfig(view.getContext())));
                    return;
                case 1:
                    TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_entry", "is_redpoint", item.anl() == 0 ? 0 : 1, new Object[0]);
                    al(1, 0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new com.baidu.tbadk.core.frameworkData.a(view.getContext())));
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(view.getContext())));
                    return;
                case 3:
                    TiebaStatic.eventStat(view.getContext(), "myself_broadcast", "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyLiveActivityConfig(view.getContext())));
                    return;
                case 4:
                    com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("show_member_new_icon_" + TbadkCoreApplication.m411getInst().getVersionCode() + TbadkCoreApplication.getCurrentAccount(), false);
                    al(4, 0);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPrivilegeActivityConfig(view.getContext())));
                    return;
                case 5:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015006, new com.baidu.tbadk.core.frameworkData.a(view.getContext())));
                    return;
                case 6:
                default:
                    item.onClick();
                    p.aoQ().b(new m(this));
                    return;
                case 7:
                    aG(view.getContext()).re();
                    return;
            }
        }
    }

    private com.baidu.tbadk.core.dialog.a aG(Context context) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.m.D(context).getPageActivity());
        aVar.bw(y.del_post_tip);
        aVar.bx(y.exit_tip);
        aVar.a(y.alert_yes_button, new n(this));
        aVar.b(y.alert_no_button, new f(this));
        return aVar.b(com.baidu.adp.base.m.D(context));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.csp.getSettingView()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001271));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new com.baidu.tbadk.core.frameworkData.a(view.getContext())));
        } else if (view == this.csp.getDayNightView()) {
            aoP();
        }
    }

    private void aoN() {
        if (this.csp != null) {
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                this.csp.setDayNightViewText(TbadkCoreApplication.m411getInst().getString(y.skin_mode_day));
            } else {
                this.csp.setDayNightViewText(TbadkCoreApplication.m411getInst().getString(y.skin_mode_night));
            }
        }
    }

    public c aoO() {
        return this.csp;
    }

    public void aoP() {
        int i = 1;
        if (TbadkCoreApplication.m411getInst().getSkinType() == 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
        } else {
            i = 0;
        }
        TbadkCoreApplication.m411getInst().setSkinType(i);
        if (this.csr != null) {
            this.csr.iI(i);
        }
        com.baidu.tbadk.core.util.c.iu();
    }

    public void f(TbPageContext tbPageContext) {
        if (this.csp != null) {
            this.csp.f(tbPageContext);
            aoN();
        }
        if (this.csq != null) {
            this.csq.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            this.csq.notifyDataSetChanged();
        }
    }
}
