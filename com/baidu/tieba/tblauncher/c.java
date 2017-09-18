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
    private ImageView bam;
    private FragmentTabHost bbI;
    private ImageView ccT;
    private TextView dNC;
    private boolean exF;
    private MainTabActivity gnF;
    private ImageView gnG;
    private ImageView gnH;
    private PopupWindow gnJ;
    private NavigationBar mNavigationBar;
    private boolean gnI = false;
    private int exB = -1;
    private boolean gnK = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.b gnL = new FragmentTabHost.b() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public void e(int i, boolean z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public boolean f(int i, boolean z) {
            FragmentTabHost.c cD = c.this.bbI.cD(i);
            if (cD.mType != 9) {
                return cD.mType != 8 || ax.aU(c.this.gnF.getActivity());
            } else if (ax.aU(c.this.gnF.getPageContext().getPageActivity())) {
                c.this.gnF.aky();
                return false;
            } else {
                return false;
            }
        }
    };
    private Runnable eVV = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bbI != null && c.this.gnJ != null) {
                FragmentTabWidget fragmentTabWidget = c.this.bbI.getFragmentTabWidget();
                int ae = k.ae(c.this.gnF.getActivity());
                int f = k.f(c.this.gnF.getActivity(), d.f.ds200);
                View contentView = c.this.gnJ.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    g.showPopupWindowAsDropDown(c.this.gnJ, fragmentTabWidget, (ae - contentView.getMeasuredWidth()) / 2, -f);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_new_write_tips", true);
                    c.this.gnK = true;
                    c.this.mHandler.postDelayed(c.this.eVW, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable eVW = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.aUJ();
        }
    };
    private View.OnClickListener eVX = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.but();
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.gnF = mainTabActivity;
    }

    public void mO(boolean z) {
        this.bbI = (FragmentTabHost) this.gnF.findViewById(d.h.tab_host);
        this.bbI.setup(this.gnF.getSupportFragmentManager());
        this.bbI.setOnTabSelectionListener(this.gnL);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bbI.setShouldDrawIndicatorLine(false);
            this.bbI.setShouldDrawTopLine(true);
        }
        this.bbI.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bbI.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.c.7
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.bbI.getCurrentTabType() != 2) {
                    if (c.this.bbI.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                c.this.bur();
                if (c.this.bbI.getCurrentTabType() != c.this.bbI.cD(i).mType) {
                    c.this.bbI.setCurrentTab(i);
                }
                if (c.this.bbI.getCurrentTabType() != 1) {
                    c.this.ccT.setVisibility(8);
                    c.this.bam.setVisibility(0);
                }
                c.this.exB = c.this.bbI.getCurrentTabType();
                c.this.bup();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (c.this.bbI.getCurrentTabType() != 3) {
                        if (c.this.bbI.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (c.this.bbI.getCurrentTabType() == 3) {
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
        this.gnI = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        XD();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.gnF.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void bun() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.gnI);
    }

    public boolean buo() {
        return this.gnG != null && this.gnG.getVisibility() == 0;
    }

    public void mP(boolean z) {
        if (this.gnG != null) {
            if (z) {
                this.gnG.setVisibility(0);
            } else {
                this.gnG.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bbI.setShouldDrawTopLine(false);
            } else {
                this.bbI.aA(true);
            }
        }
        if (this.bbI.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bbI.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bbI.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.gnF.getPageContext(), i);
        aj.a(this.dNC, d.e.cp_cont_b, d.e.s_navbar_title_color, i);
        aj.c(this.gnH, d.g.icon_news_down_bar_one);
        aj.a(this.gnG, d.g.icon_game_bg_s, d.g.icon_game_bg);
        aj.a(this.bam, d.g.icon_search_bg_s, d.g.icon_search_bg);
        aj.a(this.ccT, d.g.icon_sign_bg_s, d.g.icon_sign_bg);
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.gnF.getPageContext().getPageActivity()).inflate(d.j.show_member_died_line_layout, (ViewGroup) null);
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
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gnF.getPageContext().getPageActivity());
            aVar.v(inflate);
            aVar.cd(d.e.cp_link_tip_d);
            aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.tblauncher.c.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(c.this.gnF.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(c.this.gnF.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.gnF.getPageContext().getString(d.l.member_continue_pay);
            if (i == 0) {
                string = this.gnF.getPageContext().getString(d.l.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.c.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(c.this.gnF.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(c.this.gnF.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.gnF.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.as(false);
            aVar.b(this.gnF.getPageContext()).to();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void bup() {
        FragmentTabHost.c cE;
        if (this.bbI != null && (cE = this.bbI.cE(this.bbI.getCurrentTabType())) != null && cE.aeI != null && cE.aeI.EV() != null) {
            String string = this.gnF.getPageContext().getString(cE.aeI.EV().aGV);
            if (this.dNC != null) {
                this.dNC.setText(string);
            }
        }
    }

    public void XD() {
        this.mNavigationBar = (NavigationBar) this.gnF.findViewById(d.h.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.dNC = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.maintab_title_layout, (View.OnClickListener) null).findViewById(d.h.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.gnF.getResources().getDimension(d.f.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.dNC.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.game_tip_view, (View.OnClickListener) null);
            this.gnG = (ImageView) addCustomView.findViewById(d.h.game_button_iv);
            this.gnH = (ImageView) addCustomView.findViewById(d.h.game_tip_msg_iv);
            this.gnG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mS(false);
                    c.this.gnH.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, c.this.gnF.getPageContext()));
                    TiebaStatic.eventStat(c.this.gnF.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, k.f(this.gnF.getPageContext().getPageActivity(), d.f.ds16), 0);
            this.bam = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_search, (View.OnClickListener) null);
            this.bam.setLayoutParams(layoutParams2);
            this.bam.setVisibility(8);
            this.bam.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    c.this.gnF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(c.this.gnF.getPageContext().getPageActivity())));
                    if (c.this.bbI.getCurrentTabType() != 3) {
                        if (c.this.bbI.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new ak("c10378").r("obj_type", i));
                }
            });
            this.ccT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_signall, (View.OnClickListener) null);
            this.ccT.setLayoutParams(layoutParams2);
            this.ccT.setVisibility(8);
            this.ccT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        c.this.gnF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.gnF.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.gnF.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aT(c.this.gnF.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.gnF.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (c.this.exB) {
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
                    ax.aS(c.this.gnF.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void mQ(boolean z) {
        if (z) {
            this.ccT.setVisibility(0);
            this.bam.setVisibility(8);
            return;
        }
        this.ccT.setVisibility(8);
        this.bam.setVisibility(0);
    }

    public void mR(boolean z) {
        if (buo()) {
            if (z) {
                if (this.gnH.getVisibility() != 0) {
                    this.gnH.setVisibility(0);
                    mS(true);
                    aj.c(this.gnH, d.g.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            mS(false);
            this.gnH.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mS(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gnG.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = k.f(this.gnF.getPageContext().getPageActivity(), d.f.ds32);
            } else {
                layoutParams.rightMargin = k.f(this.gnF.getPageContext().getPageActivity(), d.f.ds20);
            }
            this.gnG.setLayoutParams(layoutParams);
        }
    }

    public void af(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bbI.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.EV(), next.aZ(this.gnF.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.bbI.cB(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bbI.cB(1);
        } else {
            this.bbI.cB(0);
        }
        this.bbI.setViewPagerScrollable(false);
    }

    public void iv(boolean z) {
        this.exF = z;
        if (!this.exF) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aMU() {
        return this.exF;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, e eVar) {
        if (cVar != null && (eVar instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) eVar;
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aeH = cVar.aGU;
            cVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.aHc);
            if (cVar.aHc == com.baidu.tbadk.mainTab.c.aGZ) {
                maintabBottomIndicator.L(cVar.aGW, cVar.aGX);
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.aGW);
                maintabBottomIndicator.setText(cVar.aGV);
                maintabBottomIndicator.setAnimationResId(cVar.aGY);
            }
            eVar.du(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            cVar2.aeG = maintabBottomIndicator;
            cVar2.aeI = bVar;
            this.bbI.a(cVar2);
        }
    }

    public FragmentTabHost buq() {
        return this.bbI;
    }

    public void bur() {
        if (this.bbI != null) {
            if ((this.bbI.getCurrentTabType() == 8 || this.bbI.getCurrentTabType() == 3 || this.bbI.getCurrentTabType() == 2 || this.bbI.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.bbI.getCurrentTabType() != 1) {
                if (this.ccT != null) {
                    this.ccT.setVisibility(8);
                }
                if (this.bam != null && this.bbI.getCurrentTabType() != 3) {
                    this.bam.setVisibility(0);
                }
            }
        }
    }

    public void bus() {
        if (!this.gnK) {
            this.gnK = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_last_new_write_tips", false);
            if (!this.gnK) {
                View inflate = LayoutInflater.from(this.gnF.getActivity()).inflate(d.j.tips_blue_center_down, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(d.h.tips);
                textView.setText(d.l.maintab_write_tips);
                textView.setOnClickListener(this.eVX);
                this.gnJ = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.eVV, 100L);
            }
        }
    }

    public void but() {
        this.mHandler.removeCallbacks(this.eVV);
        this.mHandler.removeCallbacks(this.eVW);
        aUJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUJ() {
        g.a(this.gnJ);
    }

    public void sy(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gnF.getActivity());
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
                com.baidu.tieba.h.a.aop();
            }
        });
        aVar.b(this.gnF.getPageContext()).to();
    }
}
