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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.d.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.e;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private ImageView Ue;
    private FragmentTabHost bUD;
    private d dKF;
    private ImageView dhK;
    private e dyB;
    private TextView eMy;
    private boolean fsK;
    private Runnable hnC;
    private MainTabActivity hnu;
    private ImageView hnv;
    private ImageView hnw;
    private TextView hnx;
    private PopupWindow hnz;
    private NavigationBar mNavigationBar;
    private boolean hny = false;
    private int fsG = -1;
    private boolean hnA = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.b hnB = new FragmentTabHost.b() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public void p(int i, boolean z) {
            if (c.this.bUD.fA(i).mType == 8) {
                TiebaStatic.log(new ak("c10605"));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public boolean q(int i, boolean z) {
            FragmentTabHost.c fA = c.this.bUD.fA(i);
            if (fA.mType == 9) {
                if (ax.be(c.this.hnu.getPageContext().getPageActivity())) {
                    c.this.hnu.awA();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (fA.mType == 8 && !ax.be(c.this.hnu.getActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                return true;
            }
        }
    };
    private Runnable fTW = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bUD != null && c.this.hnz != null) {
                FragmentTabWidget fragmentTabWidget = c.this.bUD.getFragmentTabWidget();
                int ao = l.ao(c.this.hnu.getActivity());
                int s = l.s(c.this.hnu.getActivity(), d.e.ds200);
                View contentView = c.this.hnz.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    g.showPopupWindowAsDropDown(c.this.hnz, fragmentTabWidget, (ao - contentView.getMeasuredWidth()) / 2, -s);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_new_write_tips", true);
                    c.this.hnA = true;
                    c.this.mHandler.postDelayed(c.this.fTX, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fTX = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.beG();
        }
    };
    private View.OnClickListener fTY = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bEj();
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.hnu = mainTabActivity;
    }

    public void nF(boolean z) {
        this.bUD = (FragmentTabHost) this.hnu.findViewById(d.g.tab_host);
        this.bUD.setup(this.hnu.getSupportFragmentManager());
        this.bUD.setOnTabSelectionListener(this.hnB);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bUD.setShouldDrawIndicatorLine(false);
            this.bUD.setShouldDrawTopLine(true);
        }
        this.bUD.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bUD.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.c.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.bUD.getCurrentTabType() != 2) {
                    if (c.this.bUD.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                c.this.bEh();
                if (c.this.bUD.getCurrentTabType() != c.this.bUD.fA(i).mType) {
                    c.this.bUD.setCurrentTab(i);
                }
                if (c.this.bUD.getCurrentTabType() != 1) {
                    c.this.dhK.setVisibility(8);
                    c.this.Ue.setVisibility(0);
                }
                c.this.fsG = c.this.bUD.getCurrentTabType();
                c.this.bEf();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (c.this.bUD.getCurrentTabType() != 3) {
                        if (c.this.bUD.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (c.this.bUD.getCurrentTabType() == 3) {
                    TiebaStatic.log(new ak("view_msg").ab("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.hny = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        auI();
        this.hnx = (TextView) this.hnu.findViewById(d.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.hnu.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void tw(final String str) {
        if (StringUtils.isNull(str)) {
            this.hnx.setVisibility(8);
            return;
        }
        FragmentTabHost.c fB = this.bUD.fB(8);
        if (fB != null) {
            if (!this.hnA || (this.hnz != null && this.hnz.isShowing())) {
                if (this.hnC == null) {
                    this.hnC = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.9
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.tw(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.hnC);
                TbadkCoreApplication.getInst().handler.postDelayed(this.hnC, TbConfig.NOTIFY_SOUND_INTERVAL);
                return;
            }
            a(str, fB);
            return;
        }
        this.hnx.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.c cVar) {
        int[] iArr = new int[2];
        cVar.aSR.getLocationInWindow(iArr);
        int width = l.o(this.hnu).widthPixels - (iArr[0] + (cVar.aSR.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hnx.getLayoutParams();
        layoutParams.rightMargin = width - l.s(this.hnu.getPageContext().getPageActivity(), d.e.ds26);
        this.hnx.setLayoutParams(layoutParams);
        this.hnx.setVisibility(0);
        this.hnx.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void bEd() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.hny);
    }

    public boolean bEe() {
        return this.hnv != null && this.hnv.getVisibility() == 0;
    }

    public void nG(boolean z) {
        if (this.hnv != null) {
            if (z) {
                this.hnv.setVisibility(0);
            } else {
                this.hnv.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bUD.setShouldDrawTopLine(false);
            } else {
                this.bUD.bf(true);
            }
        }
        if (this.bUD.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bUD.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bUD.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.hnu.getPageContext(), i);
        aj.a(this.eMy, d.C0108d.cp_cont_b, d.C0108d.s_navbar_title_color, i);
        aj.c(this.hnw, d.f.icon_news_down_bar_one);
        aj.a(this.hnv, d.f.icon_game_bg_s, d.f.icon_game_bg);
        aj.a(this.Ue, d.f.icon_search_bg_s, d.f.icon_search_bg);
        aj.a(this.dhK, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.hnu.getPageContext().getPageActivity()).inflate(d.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            aj.e(textView, d.C0108d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.Kc())) {
                textView.setText(payMemberInfoData.Kc());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                aj.c(tbImageView, d.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hnu.getPageContext().getPageActivity());
            aVar.aO(inflate);
            aVar.fe(d.C0108d.cp_link_tip_d);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.tblauncher.c.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(c.this.hnu.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(c.this.hnu.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.hnu.getPageContext().getString(d.j.member_continue_pay);
            if (i == 0) {
                string = this.hnu.getPageContext().getString(d.j.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.c.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(c.this.hnu.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(c.this.hnu.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.hnu.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.aW(false);
            aVar.b(this.hnu.getPageContext()).AI();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void bEf() {
        FragmentTabHost.c fB;
        if (this.bUD != null && (fB = this.bUD.fB(this.bUD.getCurrentTabType())) != null && fB.aST != null && fB.aST.Mz() != null) {
            String string = this.hnu.getPageContext().getString(fB.aST.Mz().bvy);
            if (this.eMy != null) {
                this.eMy.setText(string);
            }
        }
    }

    public void auI() {
        this.mNavigationBar = (NavigationBar) this.hnu.findViewById(d.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.eMy = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.hnu.getResources().getDimension(d.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.eMy.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.game_tip_view, (View.OnClickListener) null);
            this.hnv = (ImageView) addCustomView.findViewById(d.g.game_button_iv);
            this.hnw = (ImageView) addCustomView.findViewById(d.g.game_tip_msg_iv);
            this.hnv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.nJ(false);
                    c.this.hnw.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, c.this.hnu.getPageContext()));
                    TiebaStatic.eventStat(c.this.hnu.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.s(this.hnu.getPageContext().getPageActivity(), d.e.ds16), 0);
            this.Ue = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.Ue.setLayoutParams(layoutParams2);
            this.Ue.setVisibility(8);
            this.Ue.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    c.this.hnu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(c.this.hnu.getPageContext().getPageActivity())));
                    if (c.this.bUD.getCurrentTabType() != 3) {
                        if (c.this.bUD.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new ak("c10378").s("obj_type", i));
                }
            });
            this.dhK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.dhK.setLayoutParams(layoutParams2);
            this.dhK.setVisibility(8);
            this.dhK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        c.this.hnu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.hnu.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.hnu.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.bd(c.this.hnu.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.hnu.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (c.this.fsG) {
                        case 1:
                            str = "forum";
                            break;
                        case 2:
                            str = "kantie";
                            break;
                        case 3:
                            str = "message";
                            break;
                        case 8:
                            str = "profile";
                            break;
                    }
                    TiebaStatic.log(new ak("c10517").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
                    ax.bc(c.this.hnu.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void nH(boolean z) {
        if (z) {
            this.dhK.setVisibility(0);
            this.Ue.setVisibility(8);
            return;
        }
        this.dhK.setVisibility(8);
        this.Ue.setVisibility(0);
    }

    public void nI(boolean z) {
        if (bEe()) {
            if (z) {
                if (this.hnw.getVisibility() != 0) {
                    this.hnw.setVisibility(0);
                    nJ(true);
                    aj.c(this.hnw, d.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            nJ(false);
            this.hnw.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nJ(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hnv.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.s(this.hnu.getPageContext().getPageActivity(), d.e.ds32);
            } else {
                layoutParams.rightMargin = l.s(this.hnu.getPageContext().getPageActivity(), d.e.ds20);
            }
            this.hnv.setLayoutParams(layoutParams);
        }
    }

    public void af(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bUD.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Mz(), next.bm(this.hnu.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.bUD.fy(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bUD.fy(1);
        } else {
            this.bUD.fy(0);
        }
        this.bUD.setViewPagerScrollable(false);
    }

    public void iY(boolean z) {
        this.fsK = z;
        if (!this.fsK) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aVO() {
        return this.fsK;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, com.baidu.tbadk.mainTab.e eVar) {
        if (cVar != null && (eVar instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) eVar;
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aSS = cVar.bvx;
            cVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.bvF);
            if (cVar.bvF == com.baidu.tbadk.mainTab.c.bvC) {
                maintabBottomIndicator.aK(cVar.bvz, cVar.bvA);
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.bvz);
                maintabBottomIndicator.setText(cVar.bvy);
                maintabBottomIndicator.setAnimationResId(cVar.bvB);
            }
            eVar.gC(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            cVar2.aSR = maintabBottomIndicator;
            cVar2.aST = bVar;
            this.bUD.a(cVar2);
        }
    }

    public FragmentTabHost bEg() {
        return this.bUD;
    }

    public void bEh() {
        if (this.bUD != null) {
            if ((this.bUD.getCurrentTabType() == 8 || this.bUD.getCurrentTabType() == 3 || this.bUD.getCurrentTabType() == 2 || this.bUD.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.bUD.getCurrentTabType() != 1) {
                if (this.dhK != null) {
                    this.dhK.setVisibility(8);
                }
                if (this.Ue != null && this.bUD.getCurrentTabType() != 3) {
                    this.Ue.setVisibility(0);
                }
            }
        }
    }

    public void bEi() {
        if (!this.hnA) {
            this.hnA = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_last_new_write_tips", false);
            if (!this.hnA) {
                View inflate = LayoutInflater.from(this.hnu.getActivity()).inflate(d.h.tips_blue_center_down, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                textView.setText(d.j.maintab_write_tips);
                textView.setOnClickListener(this.fTY);
                this.hnz = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.fTW, 100L);
            }
        }
    }

    public void bEj() {
        this.mHandler.removeCallbacks(this.fTW);
        this.mHandler.removeCallbacks(this.fTX);
        beG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beG() {
        g.b(this.hnz);
    }

    public void tx(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hnu.getActivity());
        aVar.cZ(str);
        aVar.a(d.j.close, new a.b() { // from class: com.baidu.tieba.tblauncher.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ak akVar = new ak("c12137");
                akVar.ab("obj_locate", "1");
                TiebaStatic.log(akVar);
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.check, new a.b() { // from class: com.baidu.tieba.tblauncher.c.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ak akVar = new ak("c12137");
                akVar.ab("obj_locate", "2");
                TiebaStatic.log(akVar);
                aVar2.dismiss();
                com.baidu.tieba.h.a.aAm();
            }
        });
        aVar.b(this.hnu.getPageContext()).AI();
    }

    public void onDestroy() {
        bEd();
        if (bEg() != null) {
            bEg().reset();
        }
        bEj();
        if (this.dKF != null) {
            this.dKF.onDestroy();
        }
        if (this.dyB != null) {
            this.dyB.auK();
        }
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dKF == null) {
            this.dKF = new com.baidu.tieba.d.d(this.hnu.getPageContext(), (NavigationBarCoverTip) this.hnu.findViewById(d.g.navigation_cover_tip));
        }
        this.dKF.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.dyB == null) {
                this.dyB = new e(this.hnu, this.hnu.wy());
            }
            this.dyB.g(postWriteCallBackData);
        }
    }
}
