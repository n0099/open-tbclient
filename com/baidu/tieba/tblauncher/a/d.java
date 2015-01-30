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
    private c cdJ;
    private com.baidu.tbadk.mvc.j.c<a, com.baidu.tbadk.mvc.e.c, b> cdK;
    private j cdL;
    private final CustomMessageListener ccW = new e(this, 2001274);
    private View.OnClickListener cdM = new f(this);

    public d() {
        ajg();
    }

    private void ajg() {
        MessageManager.getInstance().registerListener(this.ccW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajh() {
        this.cdK.w(k.ajM().getData());
        this.cdK.notifyDataSetChanged();
    }

    private void g(TbPageContext tbPageContext) {
        this.cdK = new com.baidu.tbadk.mvc.j.c<>(tbPageContext, b.class, x.left_navi_item, null);
        this.cdK.aX(false);
        this.cdK.w(k.ajM().getData());
    }

    public c h(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        this.cdJ = new c(tbPageContext.getPageActivity());
        g(tbPageContext);
        this.cdJ.setListAdapter(this.cdK);
        this.cdJ.setOnPersonInfoViewClicked(this.cdM);
        this.cdJ.setOnListItemClicked(this);
        this.cdJ.setOnSettingViewClicked(this);
        this.cdJ.setOnDayNightModeViewClicked(this);
        this.cdJ.setOnVipIconLoadListener(new g(this));
        c(tbPageContext);
        return this.cdJ;
    }

    public void ajH() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null && this.cdJ != null) {
            this.cdJ.iA(currentAccountObj.getPortrait());
            this.cdJ.setUserName(currentAccountObj.getAccount());
            this.cdJ.iB(currentAccountObj.getMemberIconUrl());
            this.cdJ.setUserSexIcon(currentAccountObj.getSex());
        }
    }

    public void ajI() {
        ah(3, com.baidu.tbadk.core.sharedPref.b.oj().getBoolean(new StringBuilder("show_member_new_icon_").append(TbadkCoreApplication.m255getInst().getVersionCode()).append(TbadkCoreApplication.getCurrentAccount()).toString(), true) ? 1 : 0);
    }

    public void ah(int i, int i2) {
        int size = k.ajM().getData().size();
        a aVar = null;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            aVar = k.ajM().getData().get(i3);
            if (aVar.getType() != i) {
                i3++;
            } else {
                aVar.io(i2);
                break;
            }
        }
        if (this.cdK != null && aVar != null) {
            this.cdK.x((com.baidu.tbadk.mvc.j.c<a, com.baidu.tbadk.mvc.e.c, b>) aVar);
        }
    }

    public void eM(boolean z) {
        if (this.cdJ != null) {
            this.cdJ.eM(z);
        }
    }

    public void eN(boolean z) {
        if (this.cdJ != null) {
            this.cdJ.eN(z);
        }
    }

    public TbImageView getUserHeadView() {
        if (this.cdJ == null) {
            return null;
        }
        return this.cdJ.getUserHeadView();
    }

    public void a(j jVar) {
        this.cdL = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a item = this.cdK.getItem(i);
        if (item != null) {
            switch (item.getType()) {
                case 0:
                    TiebaStatic.eventStat(TbadkCoreApplication.m255getInst(), "my_favorite_entry", "is_redpoint", item.ajF() == 0 ? 0 : 1, new Object[0]);
                    ah(0, 0);
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
                    com.baidu.tbadk.core.sharedPref.b.oj().putBoolean("show_member_new_icon_" + TbadkCoreApplication.m255getInst().getVersionCode() + TbadkCoreApplication.getCurrentAccount(), false);
                    ah(3, 0);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPrivilegeActivityConfig(view.getContext())));
                    return;
                case 4:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015006, new com.baidu.tbadk.core.frameworkData.a(view.getContext())));
                    return;
                case 5:
                    aC(view.getContext()).show();
                    return;
                default:
                    return;
            }
        }
    }

    private AlertDialog aC(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(z.del_post_tip);
        builder.setMessage(z.exit_tip);
        builder.setPositiveButton(z.alert_yes_button, new h(this));
        builder.setNegativeButton(z.alert_no_button, new i(this));
        return builder.create();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cdJ.getSettingView()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001271));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new com.baidu.tbadk.core.frameworkData.a(view.getContext())));
        } else if (view == this.cdJ.getDayNightView()) {
            ajL();
        }
    }

    private void ajJ() {
        if (this.cdJ != null) {
            if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
                this.cdJ.setDayNightViewText(TbadkCoreApplication.m255getInst().getString(z.skin_mode_day));
            } else {
                this.cdJ.setDayNightViewText(TbadkCoreApplication.m255getInst().getString(z.skin_mode_night));
            }
        }
    }

    public c ajK() {
        return this.cdJ;
    }

    public void ajL() {
        int i = 1;
        if (TbadkCoreApplication.m255getInst().getSkinType() == 0) {
            TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
        } else {
            i = 0;
        }
        TbadkCoreApplication.m255getInst().setSkinType(i);
        if (this.cdL != null) {
            this.cdL.in(i);
        }
        com.baidu.tbadk.core.util.d.eS();
    }

    public void c(TbPageContext tbPageContext) {
        if (this.cdJ != null) {
            this.cdJ.c(tbPageContext);
            ajJ();
        }
        if (this.cdK != null) {
            this.cdK.a(tbPageContext, TbadkCoreApplication.m255getInst().getSkinType());
            this.cdK.notifyDataSetChanged();
        }
    }
}
