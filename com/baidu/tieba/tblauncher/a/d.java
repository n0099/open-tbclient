package com.baidu.tieba.tblauncher.a;

import android.app.AlertDialog;
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
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.MyLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class d implements View.OnClickListener, AdapterView.OnItemClickListener {
    private c ccq;
    private com.baidu.tbadk.mvc.j.c<a, com.baidu.tbadk.mvc.e.c, b> ccr;
    private j ccs;
    private final CustomMessageListener cbf = new e(this, 2001274);
    private View.OnClickListener cct = new f(this);

    public d() {
        aiB();
    }

    private void aiB() {
        MessageManager.getInstance().registerListener(this.cbf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiC() {
        this.ccr.w(k.ajq().getData());
        this.ccr.notifyDataSetChanged();
    }

    private void f(TbPageContext tbPageContext) {
        this.ccr = new com.baidu.tbadk.mvc.j.c<>(tbPageContext, b.class, x.left_navi_item, null);
        this.ccr.aV(false);
        this.ccr.w(k.ajq().getData());
    }

    public c g(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        this.ccq = new c(tbPageContext.getPageActivity());
        f(tbPageContext);
        this.ccq.setListAdapter(this.ccr);
        this.ccq.setOnPersonInfoViewClicked(this.cct);
        this.ccq.setOnListItemClicked(this);
        this.ccq.setOnSettingViewClicked(this);
        this.ccq.setOnDayNightModeViewClicked(this);
        this.ccq.setOnVipIconLoadListener(new g(this));
        b(tbPageContext);
        return this.ccq;
    }

    public void ajl() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null && this.ccq != null) {
            this.ccq.is(currentAccountObj.getPortrait());
            this.ccq.setUserName(currentAccountObj.getAccount());
            this.ccq.it(currentAccountObj.getMemberIconUrl());
            this.ccq.setUserSexIcon(currentAccountObj.getSex());
        }
    }

    public void ajm() {
        ag(3, com.baidu.tbadk.core.sharedPref.b.og().getBoolean(new StringBuilder("show_member_new_icon_").append(TbadkCoreApplication.m255getInst().getVersionCode()).append(TbadkCoreApplication.getCurrentAccount()).toString(), true) ? 1 : 0);
    }

    public void ag(int i, int i2) {
        int size = k.ajq().getData().size();
        a aVar = null;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            aVar = k.ajq().getData().get(i3);
            if (aVar.getType() != i) {
                i3++;
            } else {
                aVar.ij(i2);
                break;
            }
        }
        if (this.ccr != null && aVar != null) {
            this.ccr.x((com.baidu.tbadk.mvc.j.c<a, com.baidu.tbadk.mvc.e.c, b>) aVar);
        }
    }

    public void eH(boolean z) {
        if (this.ccq != null) {
            this.ccq.eH(z);
        }
    }

    public void eI(boolean z) {
        if (this.ccq != null) {
            this.ccq.eI(z);
        }
    }

    public TbImageView getUserHeadView() {
        if (this.ccq == null) {
            return null;
        }
        return this.ccq.getUserHeadView();
    }

    public void a(j jVar) {
        this.ccs = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a item = this.ccr.getItem(i);
        if (item != null) {
            switch (item.getType()) {
                case 0:
                    ag(0, 0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new com.baidu.tbadk.core.frameworkData.a(view.getContext())));
                    return;
                case 1:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(view.getContext())));
                    return;
                case 2:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyLiveActivityConfig(view.getContext())));
                    return;
                case 3:
                    com.baidu.tbadk.core.sharedPref.b.og().putBoolean("show_member_new_icon_" + TbadkCoreApplication.m255getInst().getVersionCode() + TbadkCoreApplication.getCurrentAccount(), false);
                    ag(3, 0);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPrivilegeActivityConfig(view.getContext())));
                    return;
                case 4:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015006, new com.baidu.tbadk.core.frameworkData.a(view.getContext())));
                    return;
                case 5:
                    aB(view.getContext()).show();
                    return;
                default:
                    return;
            }
        }
    }

    private AlertDialog aB(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(z.del_post_tip);
        builder.setMessage(z.exit_tip);
        builder.setPositiveButton(z.alert_yes_button, new h(this));
        builder.setNegativeButton(z.alert_no_button, new i(this));
        return builder.create();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ccq.getSettingView()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001271));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new com.baidu.tbadk.core.frameworkData.a(view.getContext())));
        } else if (view == this.ccq.getDayNightView()) {
            ajp();
        }
    }

    private void ajn() {
        if (this.ccq != null) {
            if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
                this.ccq.setDayNightViewText(TbadkCoreApplication.m255getInst().getString(z.skin_mode_day));
            } else {
                this.ccq.setDayNightViewText(TbadkCoreApplication.m255getInst().getString(z.skin_mode_night));
            }
        }
    }

    public c ajo() {
        return this.ccq;
    }

    public void ajp() {
        int i = 1;
        if (TbadkCoreApplication.m255getInst().getSkinType() == 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
        } else {
            i = 0;
        }
        TbadkCoreApplication.m255getInst().setSkinType(i);
        if (this.ccs != null) {
            this.ccs.ii(i);
        }
        com.baidu.tbadk.core.util.d.eT();
    }

    public void b(TbPageContext tbPageContext) {
        if (this.ccq != null) {
            this.ccq.b(tbPageContext);
            ajn();
        }
        if (this.ccr != null) {
            this.ccr.a(tbPageContext, TbadkCoreApplication.m255getInst().getSkinType());
            this.ccr.notifyDataSetChanged();
        }
    }
}
