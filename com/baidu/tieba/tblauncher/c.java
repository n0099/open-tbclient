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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private ImageView bYr;
    private ImageView baC;
    private FragmentTabHost bcm;
    private TextView dEh;
    private boolean eob;
    private MainTabActivity gmq;
    private ImageView gmr;
    private ImageView gms;
    private PopupWindow gmu;
    private NavigationBar mNavigationBar;
    private boolean gmt = false;
    private int enX = -1;
    private boolean gmv = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.b gmw = new FragmentTabHost.b() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public void f(int i, boolean z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public boolean g(int i, boolean z) {
            FragmentTabHost.c cD = c.this.bcm.cD(i);
            if (cD.mType != 9) {
                return cD.mType != 8 || aw.aO(c.this.gmq.getActivity());
            } else if (aw.aO(c.this.gmq.getPageContext().getPageActivity())) {
                c.this.gmq.ahZ();
                return false;
            } else {
                return false;
            }
        }
    };
    private Runnable gmx = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bcm != null && c.this.gmu != null) {
                FragmentTabWidget fragmentTabWidget = c.this.bcm.getFragmentTabWidget();
                int ag = k.ag(c.this.gmq.getActivity());
                int g = k.g(c.this.gmq.getActivity(), d.f.ds200);
                View contentView = c.this.gmu.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    g.showPopupWindowAsDropDown(c.this.gmu, fragmentTabWidget, (ag - contentView.getMeasuredWidth()) / 2, -g);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_new_write_tips", true);
                    c.this.gmv = true;
                    c.this.mHandler.postDelayed(c.this.gmy, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable gmy = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.but();
        }
    };
    private View.OnClickListener gmz = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bus();
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.gmq = mainTabActivity;
    }

    public void mE(boolean z) {
        this.bcm = (FragmentTabHost) this.gmq.findViewById(d.h.tab_host);
        this.bcm.setup(this.gmq.getSupportFragmentManager());
        this.bcm.setOnTabSelectionListener(this.gmw);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bcm.setShouldDrawIndicatorLine(false);
            this.bcm.setShouldDrawTopLine(true);
            this.bcm.h(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0, 0);
            this.bcm.aB(true);
        }
        this.bcm.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bcm.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.c.7
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.bcm.getCurrentTabType() != 2) {
                    if (c.this.bcm.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                c.this.buq();
                if (c.this.bcm.getCurrentTabType() != c.this.bcm.cD(i).mType) {
                    c.this.bcm.setCurrentTab(i);
                }
                if (c.this.bcm.getCurrentTabType() != 1) {
                    c.this.bYr.setVisibility(8);
                    c.this.baC.setVisibility(0);
                }
                c.this.enX = c.this.bcm.getCurrentTabType();
                c.this.buo();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (c.this.bcm.getCurrentTabType() != 3) {
                        if (c.this.bcm.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (c.this.bcm.getCurrentTabType() == 3) {
                    TiebaStatic.log(new aj("view_msg").aa("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.gmt = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        VW();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.gmq.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void bum() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.gmt);
    }

    public boolean bun() {
        return this.gmr != null && this.gmr.getVisibility() == 0;
    }

    public void mF(boolean z) {
        if (this.gmr != null) {
            if (z) {
                this.gmr.setVisibility(0);
            } else {
                this.gmr.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bcm.setShouldDrawTopLine(false);
            } else {
                this.bcm.aA(true);
            }
        }
        if (this.bcm.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bcm.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bcm.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.gmq.getPageContext(), i);
        ai.a(this.dEh, d.e.cp_cont_b, d.e.s_navbar_title_color, i);
        ai.c(this.gms, d.g.icon_news_down_bar_one);
        ai.b(this.gmr, d.g.icon_game_bg_s, d.g.icon_game_bg);
        ai.b(this.baC, d.g.icon_search_bg_s, d.g.icon_search_bg);
        ai.b(this.bYr, d.g.icon_sign_bg_s, d.g.icon_sign_bg);
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.gmq.getPageContext().getPageActivity()).inflate(d.j.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.h.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.h.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            ai.c(textView, d.e.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.Cw())) {
                textView.setText(payMemberInfoData.Cw());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.c(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ai.c(tbImageView, d.g.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gmq.getPageContext().getPageActivity());
            aVar.v(inflate);
            aVar.cd(d.e.cp_link_tip_d);
            aVar.b(d.l.member_i_know, new a.b() { // from class: com.baidu.tieba.tblauncher.c.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(c.this.gmq.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(c.this.gmq.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.gmq.getPageContext().getString(d.l.member_continue_pay);
            if (i == 0) {
                string = this.gmq.getPageContext().getString(d.l.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.c.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(c.this.gmq.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(c.this.gmq.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.gmq.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.as(false);
            aVar.b(this.gmq.getPageContext()).tr();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void buo() {
        FragmentTabHost.c cE;
        if (this.bcm != null && (cE = this.bcm.cE(this.bcm.getCurrentTabType())) != null && cE.afx != null && cE.afx.EX() != null) {
            String string = this.gmq.getPageContext().getString(cE.afx.EX().aHH);
            if (this.dEh != null) {
                this.dEh.setText(string);
            }
        }
    }

    public void VW() {
        this.mNavigationBar = (NavigationBar) this.gmq.findViewById(d.h.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.dEh = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.maintab_title_layout, (View.OnClickListener) null).findViewById(d.h.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.gmq.getResources().getDimension(d.f.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.dEh.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.game_tip_view, (View.OnClickListener) null);
            this.gmr = (ImageView) addCustomView.findViewById(d.h.game_button_iv);
            this.gms = (ImageView) addCustomView.findViewById(d.h.game_tip_msg_iv);
            this.gmr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mI(false);
                    c.this.gms.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, c.this.gmq.getPageContext()));
                    TiebaStatic.eventStat(c.this.gmq.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, k.g(this.gmq.getPageContext().getPageActivity(), d.f.ds16), 0);
            this.baC = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_search, (View.OnClickListener) null);
            this.baC.setLayoutParams(layoutParams2);
            this.baC.setVisibility(8);
            this.baC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    c.this.gmq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(c.this.gmq.getPageContext().getPageActivity())));
                    if (c.this.bcm.getCurrentTabType() != 3) {
                        if (c.this.bcm.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new aj("c10378").r("obj_type", i));
                }
            });
            this.bYr = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_signall, (View.OnClickListener) null);
            this.bYr.setLayoutParams(layoutParams2);
            this.bYr.setVisibility(8);
            this.bYr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        c.this.gmq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.gmq.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.gmq.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    aw.aN(c.this.gmq.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.gmq.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (c.this.enX) {
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
                    TiebaStatic.log(new aj("c10517").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
                    aw.aM(c.this.gmq.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void mG(boolean z) {
        if (z) {
            this.bYr.setVisibility(0);
            this.baC.setVisibility(8);
            return;
        }
        this.bYr.setVisibility(8);
        this.baC.setVisibility(0);
    }

    public void mH(boolean z) {
        if (bun()) {
            if (z) {
                if (this.gms.getVisibility() != 0) {
                    this.gms.setVisibility(0);
                    mI(true);
                    ai.c(this.gms, d.g.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            mI(false);
            this.gms.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mI(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gmr.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = k.g(this.gmq.getPageContext().getPageActivity(), d.f.ds32);
            } else {
                layoutParams.rightMargin = k.g(this.gmq.getPageContext().getPageActivity(), d.f.ds20);
            }
            this.gmr.setLayoutParams(layoutParams);
        }
    }

    public void af(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bcm.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.EX(), next.aT(this.gmq.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.bcm.cB(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bcm.cB(1);
        } else {
            this.bcm.cB(0);
        }
        this.bcm.setViewPagerScrollable(false);
    }

    public void ij(boolean z) {
        this.eob = z;
        if (!this.eob) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aKt() {
        return this.eob;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.afw = cVar.aHG;
            cVar2.mType = cVar.type;
            if (cVar.aHM == com.baidu.tbadk.mainTab.c.aHJ) {
                fragmentTabIndicator.N(cVar2.mType, -((int) this.gmq.getResources().getDimension(d.f.ds12)));
            } else {
                fragmentTabIndicator.setText(cVar.aHH);
            }
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.gmq.getResources().getDimension(d.f.ds24));
                fragmentTabIndicator.setTextColorResId(d.e.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.aHI);
                fragmentTabIndicator.setContentTvTopMargin(this.gmq.getResources().getDimensionPixelSize(d.f.ds2));
            } else {
                fragmentTabIndicator.setTextSize(0, this.gmq.getResources().getDimension(d.f.fontsize32));
                fragmentTabIndicator.setTextColorResId(d.e.s_tabbar_text_color);
            }
            fragmentTabIndicator.dt(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.afv = fragmentTabIndicator;
            cVar2.afx = bVar;
            this.bcm.a(cVar2);
        }
    }

    public FragmentTabHost bup() {
        return this.bcm;
    }

    public void buq() {
        if (this.bcm != null) {
            if ((this.bcm.getCurrentTabType() == 8 || this.bcm.getCurrentTabType() == 3 || this.bcm.getCurrentTabType() == 2 || this.bcm.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.bcm.getCurrentTabType() != 1) {
                if (this.bYr != null) {
                    this.bYr.setVisibility(8);
                }
                if (this.baC != null && this.bcm.getCurrentTabType() != 3) {
                    this.baC.setVisibility(0);
                }
            }
        }
    }

    public void bur() {
        if (!this.gmv) {
            this.gmv = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_last_new_write_tips", false);
            if (!this.gmv) {
                View inflate = LayoutInflater.from(this.gmq.getActivity()).inflate(d.j.tips_blue_center_down, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(d.h.tips);
                textView.setText(d.l.maintab_write_tips);
                textView.setOnClickListener(this.gmz);
                this.gmu = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.gmx, 100L);
            }
        }
    }

    public void bus() {
        this.mHandler.removeCallbacks(this.gmx);
        this.mHandler.removeCallbacks(this.gmy);
        but();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void but() {
        g.a(this.gmu);
    }

    public void su(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gmq.getActivity());
        aVar.cT(str);
        aVar.a(d.l.close, new a.b() { // from class: com.baidu.tieba.tblauncher.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aj ajVar = new aj("c12137");
                ajVar.aa("obj_locate", "1");
                TiebaStatic.log(ajVar);
                aVar2.dismiss();
            }
        });
        aVar.b(d.l.check, new a.b() { // from class: com.baidu.tieba.tblauncher.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aj ajVar = new aj("c12137");
                ajVar.aa("obj_locate", "2");
                TiebaStatic.log(ajVar);
                aVar2.dismiss();
                com.baidu.tieba.h.a.alW();
            }
        });
        aVar.b(this.gmq.getPageContext()).tr();
    }
}
