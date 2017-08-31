package com.baidu.tieba.tblauncher;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private ImageView bap;
    private FragmentTabHost bbL;
    private ImageView ccb;
    private TextView dMI;
    private boolean ewK;
    private MainTabActivity gmL;
    private ImageView gmM;
    private ImageView gmN;
    private PopupWindow gmP;
    private NavigationBar mNavigationBar;
    private boolean gmO = false;
    private int ewG = -1;
    private boolean gmQ = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.b gmR = new FragmentTabHost.b() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public void e(int i, boolean z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public boolean f(int i, boolean z) {
            FragmentTabHost.c cD = c.this.bbL.cD(i);
            if (cD.mType != 9) {
                return cD.mType != 8 || ax.aT(c.this.gmL.getActivity());
            } else if (ax.aT(c.this.gmL.getPageContext().getPageActivity())) {
                c.this.gmL.akn();
                return false;
            } else {
                return false;
            }
        }
    };
    private Runnable eVb = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bbL != null && c.this.gmP != null) {
                FragmentTabWidget fragmentTabWidget = c.this.bbL.getFragmentTabWidget();
                int ad = k.ad(c.this.gmL.getActivity());
                int g = k.g(c.this.gmL.getActivity(), d.f.ds200);
                View contentView = c.this.gmP.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    g.showPopupWindowAsDropDown(c.this.gmP, fragmentTabWidget, (ad - contentView.getMeasuredWidth()) / 2, -g);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_new_write_tips", true);
                    c.this.gmQ = true;
                    c.this.mHandler.postDelayed(c.this.eVc, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable eVc = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.aUy();
        }
    };
    private View.OnClickListener eVd = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bui();
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.gmL = mainTabActivity;
    }

    public void mN(boolean z) {
        this.bbL = (FragmentTabHost) this.gmL.findViewById(d.h.tab_host);
        this.bbL.setup(this.gmL.getSupportFragmentManager());
        this.bbL.setOnTabSelectionListener(this.gmR);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bbL.setShouldDrawIndicatorLine(false);
            this.bbL.setShouldDrawTopLine(true);
        }
        this.bbL.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bbL.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.c.7
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.bbL.getCurrentTabType() != 2) {
                    if (c.this.bbL.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                c.this.bug();
                if (c.this.bbL.getCurrentTabType() != c.this.bbL.cD(i).mType) {
                    c.this.bbL.setCurrentTab(i);
                }
                if (c.this.bbL.getCurrentTabType() != 1) {
                    c.this.ccb.setVisibility(8);
                    c.this.bap.setVisibility(0);
                }
                c.this.ewG = c.this.bbL.getCurrentTabType();
                c.this.bue();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (c.this.bbL.getCurrentTabType() != 3) {
                        if (c.this.bbL.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (c.this.bbL.getCurrentTabType() == 3) {
                    TiebaStatic.log(new ak("view_msg").ad("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.gmO = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        Xs();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.gmL.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void buc() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.gmO);
    }

    public boolean bud() {
        return this.gmM != null && this.gmM.getVisibility() == 0;
    }

    public void mO(boolean z) {
        if (this.gmM != null) {
            if (z) {
                this.gmM.setVisibility(0);
            } else {
                this.gmM.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bbL.setShouldDrawTopLine(false);
            } else {
                this.bbL.aA(true);
            }
        }
        if (this.bbL.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bbL.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bbL.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.gmL.getPageContext(), i);
        aj.a(this.dMI, d.e.cp_cont_b, d.e.s_navbar_title_color, i);
        aj.c(this.gmN, d.g.icon_news_down_bar_one);
        aj.a(this.gmM, d.g.icon_game_bg_s, d.g.icon_game_bg);
        aj.a(this.bap, d.g.icon_search_bg_s, d.g.icon_search_bg);
        aj.a(this.ccb, d.g.icon_sign_bg_s, d.g.icon_sign_bg);
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.gmL.getPageContext().getPageActivity()).inflate(d.j.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.h.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.h.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            aj.c(textView, d.e.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.Cr())) {
                textView.setText(payMemberInfoData.Cr());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.c(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                aj.c(tbImageView, d.g.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gmL.getPageContext().getPageActivity());
            aVar.v(inflate);
            aVar.cd(d.e.cp_link_tip_d);
            aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.tblauncher.c.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(c.this.gmL.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(c.this.gmL.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.gmL.getPageContext().getString(d.l.member_continue_pay);
            if (i == 0) {
                string = this.gmL.getPageContext().getString(d.l.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.c.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(c.this.gmL.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(c.this.gmL.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.gmL.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.as(false);
            aVar.b(this.gmL.getPageContext()).to();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void bue() {
        FragmentTabHost.c cE;
        if (this.bbL != null && (cE = this.bbL.cE(this.bbL.getCurrentTabType())) != null && cE.aeI != null && cE.aeI.EV() != null) {
            String string = this.gmL.getPageContext().getString(cE.aeI.EV().aGY);
            if (this.dMI != null) {
                this.dMI.setText(string);
            }
        }
    }

    public void Xs() {
        this.mNavigationBar = (NavigationBar) this.gmL.findViewById(d.h.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.dMI = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.maintab_title_layout, (View.OnClickListener) null).findViewById(d.h.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.gmL.getResources().getDimension(d.f.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.dMI.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.game_tip_view, (View.OnClickListener) null);
            this.gmM = (ImageView) addCustomView.findViewById(d.h.game_button_iv);
            this.gmN = (ImageView) addCustomView.findViewById(d.h.game_tip_msg_iv);
            this.gmM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mR(false);
                    c.this.gmN.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, c.this.gmL.getPageContext()));
                    TiebaStatic.eventStat(c.this.gmL.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, k.g(this.gmL.getPageContext().getPageActivity(), d.f.ds16), 0);
            this.bap = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_search, (View.OnClickListener) null);
            this.bap.setLayoutParams(layoutParams2);
            this.bap.setVisibility(8);
            this.bap.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    c.this.gmL.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(c.this.gmL.getPageContext().getPageActivity())));
                    if (c.this.bbL.getCurrentTabType() != 3) {
                        if (c.this.bbL.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new ak("c10378").r("obj_type", i));
                }
            });
            this.ccb = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_signall, (View.OnClickListener) null);
            this.ccb.setLayoutParams(layoutParams2);
            this.ccb.setVisibility(8);
            this.ccb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        c.this.gmL.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.gmL.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.gmL.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aS(c.this.gmL.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.gmL.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (c.this.ewG) {
                        case 1:
                            str = "forum";
                            break;
                        case 2:
                            str = "kantie";
                            break;
                        case 3:
                            str = PushConstants.EXTRA_PUSH_MESSAGE;
                            break;
                        case 8:
                            str = "profile";
                            break;
                    }
                    TiebaStatic.log(new ak("c10517").ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
                    ax.aR(c.this.gmL.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void mP(boolean z) {
        if (z) {
            this.ccb.setVisibility(0);
            this.bap.setVisibility(8);
            return;
        }
        this.ccb.setVisibility(8);
        this.bap.setVisibility(0);
    }

    public void mQ(boolean z) {
        if (bud()) {
            if (z) {
                if (this.gmN.getVisibility() != 0) {
                    this.gmN.setVisibility(0);
                    mR(true);
                    aj.c(this.gmN, d.g.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            mR(false);
            this.gmN.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mR(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gmM.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = k.g(this.gmL.getPageContext().getPageActivity(), d.f.ds32);
            } else {
                layoutParams.rightMargin = k.g(this.gmL.getPageContext().getPageActivity(), d.f.ds20);
            }
            this.gmM.setLayoutParams(layoutParams);
        }
    }

    public void af(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bbL.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.EV(), next.aY(this.gmL.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.bbL.cB(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bbL.cB(1);
        } else {
            this.bbL.cB(0);
        }
        this.bbL.setViewPagerScrollable(false);
    }

    public void iu(boolean z) {
        this.ewK = z;
        if (!this.ewK) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aMJ() {
        return this.ewK;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, e eVar) {
        if (cVar != null && (eVar instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) eVar;
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aeH = cVar.aGX;
            cVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.aHf);
            if (cVar.aHf == com.baidu.tbadk.mainTab.c.aHc) {
                maintabBottomIndicator.L(cVar.aGZ, cVar.aHa);
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.aGZ);
                maintabBottomIndicator.setText(cVar.aGY);
                maintabBottomIndicator.setAnimationResId(cVar.aHb);
            }
            eVar.du(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            cVar2.aeG = maintabBottomIndicator;
            cVar2.aeI = bVar;
            this.bbL.a(cVar2);
        }
    }

    public FragmentTabHost buf() {
        return this.bbL;
    }

    public void bug() {
        if (this.bbL != null) {
            if ((this.bbL.getCurrentTabType() == 8 || this.bbL.getCurrentTabType() == 3 || this.bbL.getCurrentTabType() == 2 || this.bbL.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.bbL.getCurrentTabType() != 1) {
                if (this.ccb != null) {
                    this.ccb.setVisibility(8);
                }
                if (this.bap != null && this.bbL.getCurrentTabType() != 3) {
                    this.bap.setVisibility(0);
                }
            }
        }
    }

    public void buh() {
        if (!this.gmQ) {
            this.gmQ = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_last_new_write_tips", false);
            if (!this.gmQ) {
                View inflate = LayoutInflater.from(this.gmL.getActivity()).inflate(d.j.tips_blue_center_down, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(d.h.tips);
                textView.setText(d.l.maintab_write_tips);
                textView.setOnClickListener(this.eVd);
                this.gmP = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.eVb, 100L);
            }
        }
    }

    public void bui() {
        this.mHandler.removeCallbacks(this.eVb);
        this.mHandler.removeCallbacks(this.eVc);
        aUy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUy() {
        g.a(this.gmP);
    }

    public void sw(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gmL.getActivity());
        aVar.cM(str);
        aVar.a(d.l.close, new a.b() { // from class: com.baidu.tieba.tblauncher.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ak akVar = new ak("c12137");
                akVar.ad("obj_locate", "1");
                TiebaStatic.log(akVar);
                aVar2.dismiss();
            }
        });
        aVar.b(d.l.check, new a.b() { // from class: com.baidu.tieba.tblauncher.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ak akVar = new ak("c12137");
                akVar.ad("obj_locate", "2");
                TiebaStatic.log(akVar);
                aVar2.dismiss();
                com.baidu.tieba.h.a.aoe();
            }
        });
        aVar.b(this.gmL.getPageContext()).to();
    }
}
