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
import com.baidu.adp.framework.listener.CustomMessageListener;
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
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.f;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class d {
    private ImageView eDs;
    private f fbq;
    private com.baidu.tieba.c.f fqK;
    private boolean haJ;
    private MainTabActivity iMA;
    private TextView iME;
    private ImageView iMF;
    private ImageView iMG;
    private TextView iMH;
    private PopupWindow iMJ;
    private MaintabBottomIndicator iML;
    private MaintabBottomIndicator iMM;
    private Runnable iMS;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean iMI = false;
    private int haF = -1;
    private boolean iMK = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean iMN = true;
    private int iMO = 1;
    private boolean iMP = false;
    private FragmentTabHost.a iMQ = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b ha = d.this.mTabHost.ha(i);
            if (ha.mType == 8) {
                if (d.this.iML != null && d.this.iML.getAnimationView() != null && d.this.iML.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new am("c10605").T("obj_type", 1));
                } else {
                    TiebaStatic.log(new am("c10605").T("obj_type", 0));
                }
                if (d.this.iML != null) {
                    d.this.iML.aki();
                }
            } else if (ha.mType == 3) {
                TiebaStatic.log(new am("c12044").T("obj_locate", 1));
                TiebaStatic.log(new am("c12924").T("obj_locate", 1));
            }
            if (ha.mType == 2) {
                d.this.iMN = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.iMO != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.iMO == 1) {
                        d.this.iMM.eU(d.this.iMN);
                    }
                } else {
                    d.this.iMM.anS();
                }
                d.this.iMP = false;
            } else {
                d.this.iMP = true;
                d.this.iMN = false;
                d.this.iMM.eU(d.this.iMN);
            }
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b ha = d.this.mTabHost.ha(i);
            if (ha.mType == 9) {
                if (bc.cZ(d.this.iMA.getPageContext().getPageActivity())) {
                    d.this.iMA.bee();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (ha.mType == 8 && !bc.cZ(d.this.iMA.getActivity())) {
                if (d.this.iML != null) {
                    d.this.iML.aki();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else {
                if (ha.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ba.adD().a(d.this.iMA.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (ha.mType == 3 && !bc.cZ(d.this.iMA.getActivity())) {
                    return false;
                } else {
                    if (ha.mType == 1) {
                        TiebaStatic.log(new am("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener iMR = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.cgJ() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.iMP = true;
                        d.this.iMN = true;
                        if (d.this.iMO != 2) {
                            if (d.this.iMM.isAnimating()) {
                                d.this.iMM.eU(d.this.iMN);
                                return;
                            }
                            return;
                        }
                        d.this.cgJ().anU();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.iMP = false;
                        if (d.this.iMO == 1) {
                            return;
                        }
                    } else {
                        d.this.iMO = intValue;
                    }
                    if (d.this.iMO == 1) {
                        d.this.cgJ().eU(d.this.iMN);
                    } else if (d.this.iMO == 2) {
                        d.this.cgJ().anS();
                    } else if (intValue == 5) {
                        d.this.iMO = 1;
                        d.this.iMN = true;
                        if (!d.this.iMP) {
                            d.this.cgJ().anU();
                        }
                    } else {
                        d.this.cgJ().anT();
                    }
                }
            }
        }
    };
    private Runnable fwM = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.4
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.iMJ != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.aO(d.this.iMA.getActivity());
                int h = l.h(d.this.iMA.getActivity(), d.e.ds178);
                View contentView = d.this.iMJ.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b hb = d.this.mTabHost.hb(3);
                    if (hb != null && (tbFragmentTabIndicator = hb.bHU) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.h(d.this.iMA.getActivity(), d.e.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.iMJ, fragmentTabWidget, measuredWidth2, -h);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_message_tips", true);
                        d.this.iMK = true;
                        d.this.mHandler.postDelayed(d.this.fwN, TbConfig.NOTIFY_SOUND_INTERVAL);
                    }
                }
            }
        }
    };
    private Runnable fwN = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.cgL();
        }
    };
    private View.OnClickListener fwO = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.cgL();
        }
    };

    public d(MainTabActivity mainTabActivity) {
        this.iMA = mainTabActivity;
    }

    public void qj(boolean z) {
        this.mTabHost = (FragmentTabHost) this.iMA.findViewById(d.g.tab_host);
        this.mTabHost.setUIType(1);
        this.mTabHost.setup(this.iMA.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.iMQ);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.setShouldDrawIndicatorLine(false);
            this.mTabHost.setShouldDrawTopLine(true);
        }
        this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight() + l.h(TbadkCoreApplication.getInst(), d.e.tbds73));
        this.mTabHost.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.d.10
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (d.this.mTabHost.getCurrentTabType() != 2) {
                    if (d.this.mTabHost.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                d.this.cgK();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.ha(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.eDs.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                d.this.haF = d.this.mTabHost.getCurrentTabType();
                d.this.cgH();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (d.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new am("view_msg").bJ("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.iMI = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        aBC();
        this.iMH = (TextView) this.iMA.findViewById(d.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.iMA.getPageContext()));
        switchNaviBarStatus(z);
        this.iMA.registerListener(this.iMR);
    }

    public void Da(final String str) {
        if (StringUtils.isNull(str)) {
            this.iMH.setVisibility(8);
            return;
        }
        FragmentTabHost.b hb = this.mTabHost.hb(8);
        if (hb != null) {
            if (!this.iMK || (this.iMJ != null && this.iMJ.isShowing())) {
                if (this.iMS == null) {
                    this.iMS = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.11
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.Da(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.iMS);
                TbadkCoreApplication.getInst().handler.postDelayed(this.iMS, TbConfig.NOTIFY_SOUND_INTERVAL);
                return;
            }
            a(str, hb);
            return;
        }
        this.iMH.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.bHU.getLocationInWindow(iArr);
        int width = l.s(this.iMA).widthPixels - (iArr[0] + (bVar.bHU.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iMH.getLayoutParams();
        layoutParams.rightMargin = width - l.h(this.iMA.getPageContext().getPageActivity(), d.e.ds26);
        this.iMH.setLayoutParams(layoutParams);
        this.iMH.setVisibility(0);
        this.iMH.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void cgF() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.iMI);
    }

    public boolean cgG() {
        return this.iMF != null && this.iMF.getVisibility() == 0;
    }

    public void qk(boolean z) {
        if (this.iMF != null) {
            if (z) {
                this.iMF.setVisibility(0);
            } else {
                this.iMF.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.setShouldDrawTopLine(false);
        }
        if (this.mTabHost.getFragmentTabWidget() != null) {
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.mTabHost.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.iMA.getPageContext(), i);
        al.b(this.iME, d.C0236d.cp_cont_b, d.C0236d.s_navbar_title_color, i);
        al.c(this.iMG, d.f.icon_news_down_bar_one);
        al.a(this.iMF, d.f.icon_game_bg_s, d.f.icon_game_bg);
        al.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
        aq.ado().d(this.eDs, d.f.ic_icon_ba_sign_n, d.C0236d.select_topbar_icon_color_tint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.abW();
            } else {
                this.mTabHost.abV();
            }
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.iMA.getPageContext().getPageActivity()).inflate(d.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            al.d(textView, d.C0236d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.alr())) {
                textView.setText(payMemberInfoData.alr());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                al.c(tbImageView, d.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iMA.getPageContext().getPageActivity());
            aVar.az(inflate);
            aVar.gE(d.C0236d.cp_link_tip_d);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.iMA.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.iMA.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.iMA.getPageContext().getString(d.j.member_continue_pay);
            if (i == 0) {
                string = this.iMA.getPageContext().getString(d.j.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.iMA.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.iMA.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.iMA.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.dr(false);
            aVar.b(this.iMA.getPageContext()).aaZ();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void cgH() {
        FragmentTabHost.b hb;
        if (this.mTabHost != null && (hb = this.mTabHost.hb(this.mTabHost.getCurrentTabType())) != null && hb.bHW != null && hb.bHW.anL() != null) {
            String string = this.iMA.getPageContext().getString(hb.bHW.anL().bOd);
            if (this.iME != null) {
                this.iME.setText(string);
            }
        }
    }

    public void aBC() {
        this.mNavigationBar = (NavigationBar) this.iMA.findViewById(d.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.iME = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.iMA.getResources().getDimension(d.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.iME.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.game_tip_view, (View.OnClickListener) null);
            this.iMF = (ImageView) addCustomView.findViewById(d.g.game_button_iv);
            this.iMG = (ImageView) addCustomView.findViewById(d.g.game_tip_msg_iv);
            this.iMF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.qn(false);
                    d.this.iMG.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, d.this.iMA.getPageContext()));
                    TiebaStatic.eventStat(d.this.iMA.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.h(this.iMA.getPageContext().getPageActivity(), d.e.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.iMA.sendMessage(new CustomMessage(2015003, new IntentConfig(d.this.iMA.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new am("c10378").T("obj_type", i));
                }
            });
            this.eDs = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.eDs.setLayoutParams(layoutParams2);
            this.eDs.setVisibility(8);
            this.eDs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.iMA.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(d.this.iMA.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.iMA.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bc.cY(d.this.iMA.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.iMA.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.haF) {
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
                    TiebaStatic.log(new am("c10517").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
                    bc.cX(d.this.iMA.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void ql(boolean z) {
        if (z) {
            this.eDs.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.eDs.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void qm(boolean z) {
        if (cgG()) {
            if (z) {
                if (this.iMG.getVisibility() != 0) {
                    this.iMG.setVisibility(0);
                    qn(true);
                    al.c(this.iMG, d.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            qn(false);
            this.iMG.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qn(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iMF.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.h(this.iMA.getPageContext().getPageActivity(), d.e.ds32);
            } else {
                layoutParams.rightMargin = l.h(this.iMA.getPageContext().getPageActivity(), d.e.ds20);
            }
            this.iMF.setLayoutParams(layoutParams);
        }
    }

    public void am(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.anL(), next.di(this.iMA.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.mTabHost.gY(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.gY(1);
        } else {
            this.mTabHost.gY(0);
        }
        this.mTabHost.setViewPagerScrollable(false);
    }

    public void mx(boolean z) {
        this.haJ = z;
        if (!this.haJ) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean bFd() {
        return this.haJ;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            boolean z = false;
            bVar2.bHV = cVar.cod;
            bVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.coj);
            if (cVar.coj == com.baidu.tbadk.mainTab.c.cof) {
                maintabBottomIndicator.setWriteIconView();
                z = true;
            } else if (cVar.coj == com.baidu.tbadk.mainTab.c.coi) {
                maintabBottomIndicator.setText(cVar.bOd);
                maintabBottomIndicator.setAnimationResId(cVar.nf);
                this.iML = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.bOd);
                maintabBottomIndicator.setAnimationResId(cVar.nf);
            }
            if (bVar2.mType == 2) {
                this.iMM = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.ij(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.bHU = maintabBottomIndicator;
            bVar2.bHW = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost beg() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator cgI() {
        return this.iML;
    }

    public MaintabBottomIndicator cgJ() {
        return this.iMM;
    }

    public void cgK() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void cgL() {
        this.mHandler.removeCallbacks(this.fwM);
        this.mHandler.removeCallbacks(this.fwN);
        g.a(this.iMJ);
    }

    public void Db(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iMA.getActivity());
        aVar.ly(str);
        aVar.a(d.j.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                am amVar = new am("c12137");
                amVar.bJ("obj_locate", "1");
                TiebaStatic.log(amVar);
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                am amVar = new am("c12137");
                amVar.bJ("obj_locate", "2");
                TiebaStatic.log(amVar);
                aVar2.dismiss();
                com.baidu.tieba.i.a.blb();
            }
        });
        aVar.b(this.iMA.getPageContext()).aaZ();
    }

    public void onDestroy() {
        cgF();
        if (beg() != null) {
            beg().reset();
        }
        cgL();
        if (this.fqK != null) {
            this.fqK.onDestroy();
        }
        if (this.fbq != null) {
            this.fbq.beZ();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ap.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.iMA).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fqK == null) {
            this.fqK = new com.baidu.tieba.c.f(this.iMA.getPageContext(), (NavigationBarCoverTip) this.iMA.findViewById(d.g.navigation_cover_tip));
        }
        this.fqK.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.fbq == null) {
                this.fbq = new f(this.iMA, this.iMA.getActivityRootView());
            }
            this.fbq.h(postWriteCallBackData);
        }
    }
}
