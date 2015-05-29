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
    private com.baidu.tbadk.mvc.j.d<com.baidu.tieba.tbadkCore.f.a, com.baidu.tbadk.mvc.e.c, b> cwA;
    private n cwB;
    private c cwz;
    private final CustomMessageListener cgZ = new e(this, 2001274);
    private View.OnClickListener cwC = new g(this);

    public d() {
        apZ();
    }

    private void apZ() {
        MessageManager.getInstance().registerListener(this.cgZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anV() {
        if (this.LH != null) {
            o.aqE().l(this.LH);
            o.aqE().b(new h(this));
        }
    }

    private void j(TbPageContext tbPageContext) {
        this.LH = tbPageContext;
        this.cwA = new com.baidu.tbadk.mvc.j.d<>(tbPageContext, b.class, r.left_navi_item, null);
        this.cwA.bi(false);
        o.aqE().l(tbPageContext);
        o.aqE().b(new i(this));
    }

    public c k(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        this.cwz = new c(tbPageContext.getPageActivity());
        j(tbPageContext);
        this.cwz.setListAdapter(this.cwA);
        this.cwz.setOnPersonInfoViewClicked(this.cwC);
        this.cwz.setOnListItemClicked(this);
        this.cwz.setOnSettingViewClicked(this);
        this.cwz.setOnDayNightModeViewClicked(this);
        this.cwz.setOnVipIconLoadListener(new j(this));
        d(tbPageContext);
        return this.cwz;
    }

    public void aqz() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null && this.cwz != null) {
            this.cwz.jN(currentAccountObj.getPortrait());
            this.cwz.setUserName(currentAccountObj.getAccount());
            this.cwz.jO(currentAccountObj.getMemberIconUrl());
            this.cwz.setUserSexIcon(currentAccountObj.getSex());
        }
    }

    public void aqA() {
        am(4, com.baidu.tbadk.core.sharedPref.b.sl().getBoolean(new StringBuilder("show_member_new_icon_").append(TbadkCoreApplication.m411getInst().getVersionCode()).append(TbadkCoreApplication.getCurrentAccount()).toString(), true) ? 1 : 0);
    }

    public void am(int i, int i2) {
        o.aqE().b(new k(this, i, i2));
    }

    public void fu(boolean z) {
        if (this.cwz != null) {
            this.cwz.fu(z);
        }
    }

    public void fv(boolean z) {
        if (this.cwz != null) {
            this.cwz.fv(z);
        }
    }

    public void a(n nVar) {
        this.cwB = nVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.tbadkCore.f.a item = this.cwA.getItem(i);
        if (item != null) {
            switch (item.getType()) {
                case 0:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001189));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddressListActivityConfig(view.getContext())));
                    return;
                case 1:
                    TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_entry", "is_redpoint", item.apc() == 0 ? 0 : 1, new Object[0]);
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
                    o.aqE().b(new l(this));
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
        if (view == this.cwz.getSettingView()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001271));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new com.baidu.tbadk.core.frameworkData.c(view.getContext())));
        } else if (view == this.cwz.getDayNightView()) {
            aqD();
        }
    }

    private void aqB() {
        if (this.cwz != null) {
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                this.cwz.setDayNightViewText(TbadkCoreApplication.m411getInst().getString(t.skin_mode_day));
            } else {
                this.cwz.setDayNightViewText(TbadkCoreApplication.m411getInst().getString(t.skin_mode_night));
            }
        }
    }

    public c aqC() {
        return this.cwz;
    }

    public void aqD() {
        int i = 1;
        if (TbadkCoreApplication.m411getInst().getSkinType() == 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
        } else {
            i = 0;
        }
        TbadkCoreApplication.m411getInst().setSkinType(i);
        if (this.cwB != null) {
            this.cwB.je(i);
        }
        com.baidu.tbadk.core.util.c.iL();
    }

    public void d(TbPageContext tbPageContext) {
        if (this.cwz != null) {
            this.cwz.d(tbPageContext);
            aqB();
        }
        if (this.cwA != null) {
            this.cwA.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            this.cwA.notifyDataSetChanged();
        }
    }
}
