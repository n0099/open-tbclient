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
    private TbPageContext LN;
    private c crZ;
    private com.baidu.tbadk.mvc.j.d<com.baidu.tieba.tbadkCore.f.a, com.baidu.tbadk.mvc.e.c, b> csa;
    private o csb;
    private View mView;
    private final CustomMessageListener cci = new e(this, 2001274);
    private View.OnClickListener csc = new g(this);

    public d() {
        anT();
    }

    private void anT() {
        MessageManager.getInstance().registerListener(this.cci);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alU() {
        if (this.LN != null) {
            p.aoB().l(this.LN);
            p.aoB().b(new h(this));
        }
    }

    private void j(TbPageContext tbPageContext) {
        this.LN = tbPageContext;
        this.csa = new com.baidu.tbadk.mvc.j.d<>(tbPageContext, b.class, w.left_navi_item, null);
        this.csa.bb(false);
        p.aoB().l(tbPageContext);
        p.aoB().b(new i(this));
    }

    public c k(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        this.crZ = new c(tbPageContext.getPageActivity());
        j(tbPageContext);
        this.crZ.setListAdapter(this.csa);
        this.crZ.setOnPersonInfoViewClicked(this.csc);
        this.crZ.setOnListItemClicked(this);
        this.crZ.setOnSettingViewClicked(this);
        this.crZ.setOnDayNightModeViewClicked(this);
        this.crZ.setOnVipIconLoadListener(new j(this));
        f(tbPageContext);
        return this.crZ;
    }

    public void aov() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null && this.crZ != null) {
            this.crZ.iQ(currentAccountObj.getPortrait());
            this.crZ.setUserName(currentAccountObj.getAccount());
            this.crZ.iR(currentAccountObj.getMemberIconUrl());
            this.crZ.setUserSexIcon(currentAccountObj.getSex());
        }
    }

    public void aow() {
        al(4, com.baidu.tbadk.core.sharedPref.b.rB().getBoolean(new StringBuilder("show_member_new_icon_").append(TbadkCoreApplication.m411getInst().getVersionCode()).append(TbadkCoreApplication.getCurrentAccount()).toString(), true) ? 1 : 0);
    }

    public void al(int i, int i2) {
        p.aoB().b(new k(this, i, i2));
    }

    public void fa(boolean z) {
        if (this.crZ != null) {
            this.crZ.fa(z);
        }
    }

    public void fb(boolean z) {
        if (this.crZ != null) {
            this.crZ.fb(z);
        }
    }

    public View aox() {
        p.aoB().b(new l(this));
        return this.mView;
    }

    public void a(o oVar) {
        this.csb = oVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.tbadkCore.f.a item = this.csa.getItem(i);
        if (item != null) {
            switch (item.getType()) {
                case 0:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001189));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddressListActivityConfig(view.getContext())));
                    return;
                case 1:
                    TiebaStatic.eventStat(TbadkCoreApplication.m411getInst(), "my_favorite_entry", "is_redpoint", item.amW() == 0 ? 0 : 1, new Object[0]);
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
                    p.aoB().b(new m(this));
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
        if (view == this.crZ.getSettingView()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001271));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new com.baidu.tbadk.core.frameworkData.a(view.getContext())));
        } else if (view == this.crZ.getDayNightView()) {
            aoA();
        }
    }

    private void aoy() {
        if (this.crZ != null) {
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                this.crZ.setDayNightViewText(TbadkCoreApplication.m411getInst().getString(y.skin_mode_day));
            } else {
                this.crZ.setDayNightViewText(TbadkCoreApplication.m411getInst().getString(y.skin_mode_night));
            }
        }
    }

    public c aoz() {
        return this.crZ;
    }

    public void aoA() {
        int i = 1;
        if (TbadkCoreApplication.m411getInst().getSkinType() == 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
        } else {
            i = 0;
        }
        TbadkCoreApplication.m411getInst().setSkinType(i);
        if (this.csb != null) {
            this.csb.iF(i);
        }
        com.baidu.tbadk.core.util.c.iu();
    }

    public void f(TbPageContext tbPageContext) {
        if (this.crZ != null) {
            this.crZ.f(tbPageContext);
            aoy();
        }
        if (this.csa != null) {
            this.csa.a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
            this.csa.notifyDataSetChanged();
        }
    }
}
