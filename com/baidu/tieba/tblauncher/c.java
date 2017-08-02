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
    private ImageView aZq;
    private ImageView bXl;
    private FragmentTabHost bbc;
    private TextView dCQ;
    private boolean emJ;
    private MainTabActivity glf;
    private ImageView glg;
    private ImageView glh;
    private PopupWindow glj;
    private NavigationBar mNavigationBar;
    private boolean gli = false;
    private int emF = -1;
    private boolean glk = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.b gll = new FragmentTabHost.b() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public void f(int i, boolean z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public boolean g(int i, boolean z) {
            FragmentTabHost.c cB = c.this.bbc.cB(i);
            if (cB.mType != 9) {
                return cB.mType != 8 || aw.aN(c.this.glf.getActivity());
            } else if (aw.aN(c.this.glf.getPageContext().getPageActivity())) {
                c.this.glf.ahR();
                return false;
            } else {
                return false;
            }
        }
    };
    private Runnable glm = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bbc != null && c.this.glj != null) {
                FragmentTabWidget fragmentTabWidget = c.this.bbc.getFragmentTabWidget();
                int af = k.af(c.this.glf.getActivity());
                int g = k.g(c.this.glf.getActivity(), d.f.ds200);
                View contentView = c.this.glj.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    g.showPopupWindowAsDropDown(c.this.glj, fragmentTabWidget, (af - contentView.getMeasuredWidth()) / 2, -g);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_new_write_tips", true);
                    c.this.glk = true;
                    c.this.mHandler.postDelayed(c.this.gln, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable gln = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.bum();
        }
    };
    private View.OnClickListener glo = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bul();
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.glf = mainTabActivity;
    }

    public void mE(boolean z) {
        this.bbc = (FragmentTabHost) this.glf.findViewById(d.h.tab_host);
        this.bbc.setup(this.glf.getSupportFragmentManager());
        this.bbc.setOnTabSelectionListener(this.gll);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bbc.setShouldDrawIndicatorLine(false);
            this.bbc.setShouldDrawTopLine(true);
            this.bbc.g(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0, 0);
            this.bbc.aB(true);
        }
        this.bbc.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bbc.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.c.7
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.bbc.getCurrentTabType() != 2) {
                    if (c.this.bbc.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                c.this.buj();
                if (c.this.bbc.getCurrentTabType() != c.this.bbc.cB(i).mType) {
                    c.this.bbc.setCurrentTab(i);
                }
                if (c.this.bbc.getCurrentTabType() != 1) {
                    c.this.bXl.setVisibility(8);
                    c.this.aZq.setVisibility(0);
                }
                c.this.emF = c.this.bbc.getCurrentTabType();
                c.this.buh();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (c.this.bbc.getCurrentTabType() != 3) {
                        if (c.this.bbc.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (c.this.bbc.getCurrentTabType() == 3) {
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
        this.gli = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        VR();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.glf.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void buf() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.gli);
    }

    public boolean bug() {
        return this.glg != null && this.glg.getVisibility() == 0;
    }

    public void mF(boolean z) {
        if (this.glg != null) {
            if (z) {
                this.glg.setVisibility(0);
            } else {
                this.glg.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bbc.setShouldDrawTopLine(false);
            } else {
                this.bbc.aA(true);
            }
        }
        if (this.bbc.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bbc.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bbc.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.glf.getPageContext(), i);
        ai.a(this.dCQ, d.e.cp_cont_b, d.e.s_navbar_title_color, i);
        ai.c(this.glh, d.g.icon_news_down_bar_one);
        ai.b(this.glg, d.g.icon_game_bg_s, d.g.icon_game_bg);
        ai.b(this.aZq, d.g.icon_search_bg_s, d.g.icon_search_bg);
        ai.b(this.bXl, d.g.icon_sign_bg_s, d.g.icon_sign_bg);
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.glf.getPageContext().getPageActivity()).inflate(d.j.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.h.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.h.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            ai.c(textView, d.e.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.Co())) {
                textView.setText(payMemberInfoData.Co());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.c(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ai.c(tbImageView, d.g.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.glf.getPageContext().getPageActivity());
            aVar.v(inflate);
            aVar.cb(d.e.cp_link_tip_d);
            aVar.b(d.l.member_i_know, new a.b() { // from class: com.baidu.tieba.tblauncher.c.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(c.this.glf.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(c.this.glf.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.glf.getPageContext().getString(d.l.member_continue_pay);
            if (i == 0) {
                string = this.glf.getPageContext().getString(d.l.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.c.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(c.this.glf.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(c.this.glf.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.glf.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.as(false);
            aVar.b(this.glf.getPageContext()).th();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void buh() {
        FragmentTabHost.c cC;
        if (this.bbc != null && (cC = this.bbc.cC(this.bbc.getCurrentTabType())) != null && cC.aec != null && cC.aec.EP() != null) {
            String string = this.glf.getPageContext().getString(cC.aec.EP().aGs);
            if (this.dCQ != null) {
                this.dCQ.setText(string);
            }
        }
    }

    public void VR() {
        this.mNavigationBar = (NavigationBar) this.glf.findViewById(d.h.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.dCQ = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.maintab_title_layout, (View.OnClickListener) null).findViewById(d.h.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.glf.getResources().getDimension(d.f.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.dCQ.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.game_tip_view, (View.OnClickListener) null);
            this.glg = (ImageView) addCustomView.findViewById(d.h.game_button_iv);
            this.glh = (ImageView) addCustomView.findViewById(d.h.game_tip_msg_iv);
            this.glg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mI(false);
                    c.this.glh.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, c.this.glf.getPageContext()));
                    TiebaStatic.eventStat(c.this.glf.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, k.g(this.glf.getPageContext().getPageActivity(), d.f.ds16), 0);
            this.aZq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_search, (View.OnClickListener) null);
            this.aZq.setLayoutParams(layoutParams2);
            this.aZq.setVisibility(8);
            this.aZq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    c.this.glf.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(c.this.glf.getPageContext().getPageActivity())));
                    if (c.this.bbc.getCurrentTabType() != 3) {
                        if (c.this.bbc.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new aj("c10378").r("obj_type", i));
                }
            });
            this.bXl = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_signall, (View.OnClickListener) null);
            this.bXl.setLayoutParams(layoutParams2);
            this.bXl.setVisibility(8);
            this.bXl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        c.this.glf.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.glf.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.glf.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    aw.aM(c.this.glf.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.glf.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (c.this.emF) {
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
                    aw.aL(c.this.glf.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void mG(boolean z) {
        if (z) {
            this.bXl.setVisibility(0);
            this.aZq.setVisibility(8);
            return;
        }
        this.bXl.setVisibility(8);
        this.aZq.setVisibility(0);
    }

    public void mH(boolean z) {
        if (bug()) {
            if (z) {
                if (this.glh.getVisibility() != 0) {
                    this.glh.setVisibility(0);
                    mI(true);
                    ai.c(this.glh, d.g.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            mI(false);
            this.glh.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mI(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.glg.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = k.g(this.glf.getPageContext().getPageActivity(), d.f.ds32);
            } else {
                layoutParams.rightMargin = k.g(this.glf.getPageContext().getPageActivity(), d.f.ds20);
            }
            this.glg.setLayoutParams(layoutParams);
        }
    }

    public void af(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bbc.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.EP(), next.aS(this.glf.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.bbc.cz(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bbc.cz(1);
        } else {
            this.bbc.cz(0);
        }
        this.bbc.setViewPagerScrollable(false);
    }

    public void ij(boolean z) {
        this.emJ = z;
        if (!this.emJ) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aKi() {
        return this.emJ;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aeb = cVar.aGr;
            cVar2.mType = cVar.type;
            if (cVar.aGx == com.baidu.tbadk.mainTab.c.aGu) {
                fragmentTabIndicator.M(cVar2.mType, -((int) this.glf.getResources().getDimension(d.f.ds12)));
            } else {
                fragmentTabIndicator.setText(cVar.aGs);
            }
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.glf.getResources().getDimension(d.f.ds24));
                fragmentTabIndicator.setTextColorResId(d.e.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.aGt);
                fragmentTabIndicator.setContentTvTopMargin(this.glf.getResources().getDimensionPixelSize(d.f.ds2));
            } else {
                fragmentTabIndicator.setTextSize(0, this.glf.getResources().getDimension(d.f.fontsize32));
                fragmentTabIndicator.setTextColorResId(d.e.s_tabbar_text_color);
            }
            fragmentTabIndicator.dr(TbadkCoreApplication.getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.aea = fragmentTabIndicator;
            cVar2.aec = bVar;
            this.bbc.a(cVar2);
        }
    }

    public FragmentTabHost bui() {
        return this.bbc;
    }

    public void buj() {
        if (this.bbc != null) {
            if ((this.bbc.getCurrentTabType() == 8 || this.bbc.getCurrentTabType() == 3 || this.bbc.getCurrentTabType() == 2 || this.bbc.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.bbc.getCurrentTabType() != 1) {
                if (this.bXl != null) {
                    this.bXl.setVisibility(8);
                }
                if (this.aZq != null && this.bbc.getCurrentTabType() != 3) {
                    this.aZq.setVisibility(0);
                }
            }
        }
    }

    public void buk() {
        if (!this.glk) {
            this.glk = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_last_new_write_tips", false);
            if (!this.glk) {
                View inflate = LayoutInflater.from(this.glf.getActivity()).inflate(d.j.tips_blue_center_down, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(d.h.tips);
                textView.setText(d.l.maintab_write_tips);
                textView.setOnClickListener(this.glo);
                this.glj = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.glm, 100L);
            }
        }
    }

    public void bul() {
        this.mHandler.removeCallbacks(this.glm);
        this.mHandler.removeCallbacks(this.gln);
        bum();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bum() {
        g.a(this.glj);
    }

    public void sp(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.glf.getActivity());
        aVar.cN(str);
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
                com.baidu.tieba.h.a.alJ();
            }
        });
        aVar.b(this.glf.getPageContext()).th();
    }
}
