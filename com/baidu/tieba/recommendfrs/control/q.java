package com.baidu.tieba.recommendfrs.control;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.c.c;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class q {
    private ObservedChangeLinearLayout aXc;
    private m dYj;
    private ImageView dZc;
    private ImageView dZd;
    private ImageView dZe;
    private com.baidu.tieba.c.c dZf;
    private ImageView mCenterIcon;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private final CustomMessageListener dZg = new r(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private final CustomMessageListener dZh = new s(this, CmdConfigCustom.CMD_SHOW_GAME_ICON);
    private View.OnTouchListener aFz = new t(this);
    private c.InterfaceC0053c aVi = new u(this);

    public m aMk() {
        return this.dYj;
    }

    public View.OnTouchListener aMl() {
        return this.aFz;
    }

    public ObservedChangeLinearLayout Mr() {
        return this.aXc;
    }

    public q(Context context, View view, ObservedChangeLinearLayout observedChangeLinearLayout, View view2) {
        this.mContext = context;
        this.aXc = observedChangeLinearLayout;
        bd(view);
        this.dYj = new m(context, observedChangeLinearLayout, view2);
        this.dZf = new com.baidu.tieba.c.c(context);
        this.dZf.a(this.aVi);
        aMm();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dZh.setTag(bdUniqueId);
        this.dZg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dZh);
        MessageManager.getInstance().registerListener(this.dZg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMm() {
        boolean z = true;
        if (com.baidu.tbadk.mainTab.d.getGame() != null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.m11getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
            if (com.baidu.tbadk.mainTab.d.getGame().hasGameCenter != null && com.baidu.tbadk.mainTab.d.getGame().hasGameCenter.intValue() == 1 && appResponseToIntentClass) {
                iP(true);
                long j = com.baidu.tbadk.core.sharedPref.b.sQ().getLong("game_last_time", 0L);
                if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() > j) {
                    com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("game_is_show_tip", true);
                    com.baidu.tbadk.core.sharedPref.b.sQ().putLong("game_last_time", com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue());
                } else if (com.baidu.tbadk.mainTab.d.getGame().gameLastLaunchtime.longValue() == j) {
                    z = com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("game_is_show_tip", true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("game_is_show_tip", false);
                    z = false;
                }
                iO(z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, Boolean.valueOf(z)));
                return;
            }
            iP(false);
            iO(false);
            com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("game_is_show_tip", false);
        }
    }

    public boolean aMn() {
        return this.dZc != null && this.dZc.getVisibility() == 0;
    }

    public void iO(boolean z) {
        if (z) {
            if (this.dZd.getVisibility() != 0) {
                this.dZd.setVisibility(0);
                iQ(true);
                at.c(this.dZd, t.f.icon_news_down_bar_one);
                return;
            }
            return;
        }
        iQ(false);
        this.dZd.setVisibility(8);
    }

    public void iP(boolean z) {
        if (this.dZc != null) {
            if (z) {
                this.dZc.setVisibility(0);
            } else {
                this.dZc.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iQ(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dZc.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds20);
            }
            this.dZc.setLayoutParams(layoutParams);
        }
    }

    private void bd(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(t.g.fragment_navigation_bar);
        this.mCenterIcon = (ImageView) this.mNavigationBar.getCenterImgBox();
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.game_tip_view, (View.OnClickListener) null);
        this.dZc = (ImageView) addCustomView.findViewById(t.g.game_button_iv);
        this.dZd = (ImageView) addCustomView.findViewById(t.g.game_tip_msg_iv);
        this.dZc.setOnClickListener(new v(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds16), 0);
        this.dZe = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_search, (View.OnClickListener) null);
        this.dZe.setLayoutParams(layoutParams);
        this.dZe.setOnClickListener(new w(this));
        this.mNavigationBar.setLoginClickListener(new x(this));
        this.mNavigationBar.setRegisterClickListener(new y(this));
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(this.mContext);
        if (s != null && this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(s, i);
        }
        at.c(this.dZd, t.f.icon_news_down_bar_one);
        at.a(this.dZc, t.f.icon_game_bg_s, t.f.icon_game_bg);
        at.a(this.dZe, t.f.icon_search_bg_s, t.f.icon_search_bg);
        at.a(this.mCenterIcon, t.f.icon_home_logo, t.f.s_icon_home_logo, t.f.icon_home_logo, TbadkCoreApplication.m11getInst().getSkinType());
    }

    public void onDestroy() {
        if (this.dYj != null) {
            this.dYj.RP();
        }
    }
}
