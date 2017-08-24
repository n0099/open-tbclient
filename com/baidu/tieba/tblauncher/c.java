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
    private ImageView bZe;
    private ImageView baE;
    private FragmentTabHost bco;
    private TextView dGe;
    private boolean epY;
    private MainTabActivity goj;
    private ImageView gok;
    private ImageView gol;
    private PopupWindow gon;
    private NavigationBar mNavigationBar;
    private boolean gom = false;
    private int epU = -1;
    private boolean goo = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.b gop = new FragmentTabHost.b() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public void f(int i, boolean z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public boolean g(int i, boolean z) {
            FragmentTabHost.c cD = c.this.bco.cD(i);
            if (cD.mType != 9) {
                return cD.mType != 8 || aw.aO(c.this.goj.getActivity());
            } else if (aw.aO(c.this.goj.getPageContext().getPageActivity())) {
                c.this.goj.aiA();
                return false;
            } else {
                return false;
            }
        }
    };
    private Runnable goq = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bco != null && c.this.gon != null) {
                FragmentTabWidget fragmentTabWidget = c.this.bco.getFragmentTabWidget();
                int ag = k.ag(c.this.goj.getActivity());
                int g = k.g(c.this.goj.getActivity(), d.f.ds200);
                View contentView = c.this.gon.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    g.showPopupWindowAsDropDown(c.this.gon, fragmentTabWidget, (ag - contentView.getMeasuredWidth()) / 2, -g);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_new_write_tips", true);
                    c.this.goo = true;
                    c.this.mHandler.postDelayed(c.this.gor, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable gor = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.buU();
        }
    };
    private View.OnClickListener gos = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.buT();
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.goj = mainTabActivity;
    }

    public void mH(boolean z) {
        this.bco = (FragmentTabHost) this.goj.findViewById(d.h.tab_host);
        this.bco.setup(this.goj.getSupportFragmentManager());
        this.bco.setOnTabSelectionListener(this.gop);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bco.setShouldDrawIndicatorLine(false);
            this.bco.setShouldDrawTopLine(true);
            this.bco.h(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0, 0);
            this.bco.aB(true);
        }
        this.bco.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bco.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.c.7
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.bco.getCurrentTabType() != 2) {
                    if (c.this.bco.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                c.this.buR();
                if (c.this.bco.getCurrentTabType() != c.this.bco.cD(i).mType) {
                    c.this.bco.setCurrentTab(i);
                }
                if (c.this.bco.getCurrentTabType() != 1) {
                    c.this.bZe.setVisibility(8);
                    c.this.baE.setVisibility(0);
                }
                c.this.epU = c.this.bco.getCurrentTabType();
                c.this.buP();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (c.this.bco.getCurrentTabType() != 3) {
                        if (c.this.bco.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (c.this.bco.getCurrentTabType() == 3) {
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
        this.gom = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        Wp();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.goj.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void buN() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.gom);
    }

    public boolean buO() {
        return this.gok != null && this.gok.getVisibility() == 0;
    }

    public void mI(boolean z) {
        if (this.gok != null) {
            if (z) {
                this.gok.setVisibility(0);
            } else {
                this.gok.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bco.setShouldDrawTopLine(false);
            } else {
                this.bco.aA(true);
            }
        }
        if (this.bco.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bco.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bco.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.goj.getPageContext(), i);
        ai.a(this.dGe, d.e.cp_cont_b, d.e.s_navbar_title_color, i);
        ai.c(this.gol, d.g.icon_news_down_bar_one);
        ai.b(this.gok, d.g.icon_game_bg_s, d.g.icon_game_bg);
        ai.b(this.baE, d.g.icon_search_bg_s, d.g.icon_search_bg);
        ai.b(this.bZe, d.g.icon_sign_bg_s, d.g.icon_sign_bg);
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.goj.getPageContext().getPageActivity()).inflate(d.j.show_member_died_line_layout, (ViewGroup) null);
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
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.goj.getPageContext().getPageActivity());
            aVar.v(inflate);
            aVar.cd(d.e.cp_link_tip_d);
            aVar.b(d.l.member_i_know, new a.b() { // from class: com.baidu.tieba.tblauncher.c.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(c.this.goj.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(c.this.goj.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.goj.getPageContext().getString(d.l.member_continue_pay);
            if (i == 0) {
                string = this.goj.getPageContext().getString(d.l.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.c.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(c.this.goj.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(c.this.goj.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.goj.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.as(false);
            aVar.b(this.goj.getPageContext()).ts();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void buP() {
        FragmentTabHost.c cE;
        if (this.bco != null && (cE = this.bco.cE(this.bco.getCurrentTabType())) != null && cE.afz != null && cE.afz.EX() != null) {
            String string = this.goj.getPageContext().getString(cE.afz.EX().aHJ);
            if (this.dGe != null) {
                this.dGe.setText(string);
            }
        }
    }

    public void Wp() {
        this.mNavigationBar = (NavigationBar) this.goj.findViewById(d.h.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.dGe = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.maintab_title_layout, (View.OnClickListener) null).findViewById(d.h.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.goj.getResources().getDimension(d.f.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.dGe.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.game_tip_view, (View.OnClickListener) null);
            this.gok = (ImageView) addCustomView.findViewById(d.h.game_button_iv);
            this.gol = (ImageView) addCustomView.findViewById(d.h.game_tip_msg_iv);
            this.gok.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mL(false);
                    c.this.gol.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, c.this.goj.getPageContext()));
                    TiebaStatic.eventStat(c.this.goj.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, k.g(this.goj.getPageContext().getPageActivity(), d.f.ds16), 0);
            this.baE = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_search, (View.OnClickListener) null);
            this.baE.setLayoutParams(layoutParams2);
            this.baE.setVisibility(8);
            this.baE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    c.this.goj.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(c.this.goj.getPageContext().getPageActivity())));
                    if (c.this.bco.getCurrentTabType() != 3) {
                        if (c.this.bco.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new aj("c10378").r("obj_type", i));
                }
            });
            this.bZe = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_signall, (View.OnClickListener) null);
            this.bZe.setLayoutParams(layoutParams2);
            this.bZe.setVisibility(8);
            this.bZe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        c.this.goj.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.goj.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.goj.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    aw.aN(c.this.goj.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.goj.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (c.this.epU) {
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
                    aw.aM(c.this.goj.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void mJ(boolean z) {
        if (z) {
            this.bZe.setVisibility(0);
            this.baE.setVisibility(8);
            return;
        }
        this.bZe.setVisibility(8);
        this.baE.setVisibility(0);
    }

    public void mK(boolean z) {
        if (buO()) {
            if (z) {
                if (this.gol.getVisibility() != 0) {
                    this.gol.setVisibility(0);
                    mL(true);
                    ai.c(this.gol, d.g.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            mL(false);
            this.gol.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mL(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gok.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = k.g(this.goj.getPageContext().getPageActivity(), d.f.ds32);
            } else {
                layoutParams.rightMargin = k.g(this.goj.getPageContext().getPageActivity(), d.f.ds20);
            }
            this.gok.setLayoutParams(layoutParams);
        }
    }

    public void af(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bco.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.EX(), next.aT(this.goj.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.bco.cB(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bco.cB(1);
        } else {
            this.bco.cB(0);
        }
        this.bco.setViewPagerScrollable(false);
    }

    public void im(boolean z) {
        this.epY = z;
        if (!this.epY) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aKV() {
        return this.epY;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.afy = cVar.aHI;
            cVar2.mType = cVar.type;
            if (cVar.aHO == com.baidu.tbadk.mainTab.c.aHL) {
                fragmentTabIndicator.N(cVar2.mType, -((int) this.goj.getResources().getDimension(d.f.ds12)));
            } else {
                fragmentTabIndicator.setText(cVar.aHJ);
            }
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.goj.getResources().getDimension(d.f.ds24));
                fragmentTabIndicator.setTextColorResId(d.e.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.aHK);
                fragmentTabIndicator.setContentTvTopMargin(this.goj.getResources().getDimensionPixelSize(d.f.ds2));
            } else {
                fragmentTabIndicator.setTextSize(0, this.goj.getResources().getDimension(d.f.fontsize32));
                fragmentTabIndicator.setTextColorResId(d.e.s_tabbar_text_color);
            }
            fragmentTabIndicator.dt(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.afx = fragmentTabIndicator;
            cVar2.afz = bVar;
            this.bco.a(cVar2);
        }
    }

    public FragmentTabHost buQ() {
        return this.bco;
    }

    public void buR() {
        if (this.bco != null) {
            if ((this.bco.getCurrentTabType() == 8 || this.bco.getCurrentTabType() == 3 || this.bco.getCurrentTabType() == 2 || this.bco.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.bco.getCurrentTabType() != 1) {
                if (this.bZe != null) {
                    this.bZe.setVisibility(8);
                }
                if (this.baE != null && this.bco.getCurrentTabType() != 3) {
                    this.baE.setVisibility(0);
                }
            }
        }
    }

    public void buS() {
        if (!this.goo) {
            this.goo = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_last_new_write_tips", false);
            if (!this.goo) {
                View inflate = LayoutInflater.from(this.goj.getActivity()).inflate(d.j.tips_blue_center_down, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(d.h.tips);
                textView.setText(d.l.maintab_write_tips);
                textView.setOnClickListener(this.gos);
                this.gon = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.goq, 100L);
            }
        }
    }

    public void buT() {
        this.mHandler.removeCallbacks(this.goq);
        this.mHandler.removeCallbacks(this.gor);
        buU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buU() {
        g.a(this.gon);
    }

    public void sB(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.goj.getActivity());
        aVar.cW(str);
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
                com.baidu.tieba.h.a.amw();
            }
        });
        aVar.b(this.goj.getPageContext()).ts();
    }
}
