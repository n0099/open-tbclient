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
import com.baidu.tieba.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class d implements View.OnClickListener, AdapterView.OnItemClickListener {
    private TbPageContext LH;
    private c cwA;
    private com.baidu.tbadk.mvc.j.d<com.baidu.tieba.tbadkCore.f.a, com.baidu.tbadk.mvc.e.c, b> cwB;
    private n cwC;
    private final CustomMessageListener cha = new e(this, 2001274);
    private View.OnClickListener cwD = new g(this);

    public d() {
        aqa();
    }

    private void aqa() {
        MessageManager.getInstance().registerListener(this.cha);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anW() {
        if (this.LH != null) {
            o.aqF().l(this.LH);
            o.aqF().b(new h(this));
        }
    }

    private void j(TbPageContext tbPageContext) {
        this.LH = tbPageContext;
        this.cwB = new com.baidu.tbadk.mvc.j.d<>(tbPageContext, b.class, r.left_navi_item, null);
        this.cwB.bi(false);
        o.aqF().l(tbPageContext);
        o.aqF().b(new i(this));
    }

    public c k(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        this.cwA = new c(tbPageContext.getPageActivity());
        j(tbPageContext);
        this.cwA.setListAdapter(this.cwB);
        this.cwA.setOnPersonInfoViewClicked(this.cwD);
        this.cwA.setOnListItemClicked(this);
        this.cwA.setOnSettingViewClicked(this);
        this.cwA.setOnDayNightModeViewClicked(this);
        this.cwA.setOnVipIconLoadListener(new j(this));
        d(tbPageContext);
        return this.cwA;
    }

    public void aqA() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null && this.cwA != null) {
            this.cwA.jN(currentAccountObj.getPortrait());
            this.cwA.setUserName(currentAccountObj.getAccount());
            this.cwA.jO(currentAccountObj.getMemberIconUrl());
            this.cwA.setUserSexIcon(currentAccountObj.getSex());
        }
    }

    public void aqB() {
        am(4, com.baidu.tbadk.core.sharedPref.b.sl().getBoolean(new StringBuilder("show_member_new_icon_").append(TbadkCoreApplication.m411getInst().getVersionCode()).append(TbadkCoreApplication.getCurrentAccount()).toString(), true) ? 1 : 0);
    }

    public void am(int i, int i2) {
        o.aqF().b(new k(this, i, i2));
    }

    public void fu(boolean z) {
        if (this.cwA != null) {
            this.cwA.fu(z);
        }
    }

    public void fv(boolean z) {
        if (this.cwA != null) {
            this.cwA.fv(z);
        }
    }

    public void a(n nVar) {
        this.cwC = nVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.tbadkCore.f.a item = this.cwB.getItem(i);
        if (item != null) {
            switch (item.getType()) {
                case 0:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001189));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddressListActivityConfig(view.getContext())));
                    return;
                case 1:
                    TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_entry", "is_redpoint", item.apd() == 0 ? 0 : 1, new Object[0]);
                    am(1, 0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new com.baidu.tbadk.core.frameworkData.c(view.getContext())));
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(view.getContext())));
                    return;
                case 3:
                    TiebaStatic.eventStat(view.getContext(), "myself_broadcast", "click", 1, new Object[0]);
                    am(3, 0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001324));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyLiveActivityConfig(view.getContext())));
                    return;
                case 4:
                    com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("show_member_new_icon_" + TbadkCoreApplication.m411getInst().getVersionCode() + TbadkCoreApplication.getCurrentAccount(), false);
                    am(4, 0);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPrivilegeActivityConfig(view.getContext())));
                    return;
                case 5:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015006, new com.baidu.tbadk.core.frameworkData.c(view.getContext())));
                    return;
                case 6:
                default:
                    item.onClick();
                    o.aqF().b(new l(this));
                    return;
                case 7:
                    aL(view.getContext()).rL();
                    TiebaStatic.eventStat(view.getContext(), "sidebar_quit", "click", 1, new Object[0]);
                    return;
            }
        }
    }

    private com.baidu.tbadk.core.dialog.a aL(Context context) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.n.D(context).getPageActivity());
        aVar.bu(t.exit_tip);
        aVar.a(t.alert_yes_button, new m(this));
        aVar.b(t.alert_no_button, new f(this));
        return aVar.b(com.baidu.adp.base.n.D(context));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cwA.getSettingView()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001271));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new com.baidu.tbadk.core.frameworkData.c(view.getContext())));
        } else if (view == this.cwA.getDayNightView()) {
            aqE();
        }
    }

    private void aqC() {
        if (this.cwA != null) {
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                this.cwA.setDayNightViewText(TbadkCoreApplication.m411getInst().getString(t.skin_mode_day));
            } else {
                this.cwA.setDayNightViewText(TbadkCoreApplication.m411getInst().getString(t.skin_mode_night));
            }
        }
    }

    public c aqD() {
        return this.cwA;
    }

    public void aqE() {
        int i = 1;
        if (TbadkCoreApplication.m411getInst().getSkinType() == 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
        } else {
            i = 0;
        }
        TbadkCoreApplication.m411getInst().setSkinType(i);
        if (this.cwC != null) {
            this.cwC.je(i);
        }
        com.baidu.tbadk.core.util.c.iL();
    }

    public void d(TbPageContext tbPageContext) {
        if (this.cwA != null) {
            this.cwA.d(tbPageContext);
            aqC();
        }
        if (this.cwB != null) {
            this.cwB.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            this.cwB.notifyDataSetChanged();
        }
    }
}
