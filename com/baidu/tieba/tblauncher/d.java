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
    private ImageView eDo;
    private f fbp;
    private com.baidu.tieba.c.f fqJ;
    private boolean haI;
    private PopupWindow iMB;
    private MaintabBottomIndicator iMD;
    private MaintabBottomIndicator iME;
    private Runnable iMK;
    private MainTabActivity iMs;
    private TextView iMw;
    private ImageView iMx;
    private ImageView iMy;
    private TextView iMz;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean iMA = false;
    private int haE = -1;
    private boolean iMC = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean iMF = true;
    private int iMG = 1;
    private boolean iMH = false;
    private FragmentTabHost.a iMI = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b ha = d.this.mTabHost.ha(i);
            if (ha.mType == 8) {
                if (d.this.iMD != null && d.this.iMD.getAnimationView() != null && d.this.iMD.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new am("c10605").T("obj_type", 1));
                } else {
                    TiebaStatic.log(new am("c10605").T("obj_type", 0));
                }
                if (d.this.iMD != null) {
                    d.this.iMD.akh();
                }
            } else if (ha.mType == 3) {
                TiebaStatic.log(new am("c12044").T("obj_locate", 1));
                TiebaStatic.log(new am("c12924").T("obj_locate", 1));
            }
            if (ha.mType == 2) {
                d.this.iMF = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.iMG != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.iMG == 1) {
                        d.this.iME.eU(d.this.iMF);
                    }
                } else {
                    d.this.iME.anR();
                }
                d.this.iMH = false;
            } else {
                d.this.iMH = true;
                d.this.iMF = false;
                d.this.iME.eU(d.this.iMF);
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
                if (bc.cZ(d.this.iMs.getPageContext().getPageActivity())) {
                    d.this.iMs.bed();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (ha.mType == 8 && !bc.cZ(d.this.iMs.getActivity())) {
                if (d.this.iMD != null) {
                    d.this.iMD.akh();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else {
                if (ha.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ba.adD().a(d.this.iMs.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (ha.mType == 3 && !bc.cZ(d.this.iMs.getActivity())) {
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
    private CustomMessageListener iMJ = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.cgL() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.iMH = true;
                        d.this.iMF = true;
                        if (d.this.iMG != 2) {
                            if (d.this.iME.isAnimating()) {
                                d.this.iME.eU(d.this.iMF);
                                return;
                            }
                            return;
                        }
                        d.this.cgL().anT();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.iMH = false;
                        if (d.this.iMG == 1) {
                            return;
                        }
                    } else {
                        d.this.iMG = intValue;
                    }
                    if (d.this.iMG == 1) {
                        d.this.cgL().eU(d.this.iMF);
                    } else if (d.this.iMG == 2) {
                        d.this.cgL().anR();
                    } else if (intValue == 5) {
                        d.this.iMG = 1;
                        d.this.iMF = true;
                        if (!d.this.iMH) {
                            d.this.cgL().anT();
                        }
                    } else {
                        d.this.cgL().anS();
                    }
                }
            }
        }
    };
    private Runnable fwL = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.4
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.iMB != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.aO(d.this.iMs.getActivity());
                int h = l.h(d.this.iMs.getActivity(), d.e.ds178);
                View contentView = d.this.iMB.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b hb = d.this.mTabHost.hb(3);
                    if (hb != null && (tbFragmentTabIndicator = hb.bHV) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.h(d.this.iMs.getActivity(), d.e.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.iMB, fragmentTabWidget, measuredWidth2, -h);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_message_tips", true);
                        d.this.iMC = true;
                        d.this.mHandler.postDelayed(d.this.fwM, 5000L);
                    }
                }
            }
        }
    };
    private Runnable fwM = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.cgN();
        }
    };
    private View.OnClickListener fwN = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.cgN();
        }
    };

    public d(MainTabActivity mainTabActivity) {
        this.iMs = mainTabActivity;
    }

    public void qj(boolean z) {
        this.mTabHost = (FragmentTabHost) this.iMs.findViewById(d.g.tab_host);
        this.mTabHost.setUIType(1);
        this.mTabHost.setup(this.iMs.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.iMI);
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
                d.this.cgM();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.ha(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.eDo.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                d.this.haE = d.this.mTabHost.getCurrentTabType();
                d.this.cgJ();
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
        this.iMA = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        aBB();
        this.iMz = (TextView) this.iMs.findViewById(d.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.iMs.getPageContext()));
        switchNaviBarStatus(z);
        this.iMs.registerListener(this.iMJ);
    }

    public void CY(final String str) {
        if (StringUtils.isNull(str)) {
            this.iMz.setVisibility(8);
            return;
        }
        FragmentTabHost.b hb = this.mTabHost.hb(8);
        if (hb != null) {
            if (!this.iMC || (this.iMB != null && this.iMB.isShowing())) {
                if (this.iMK == null) {
                    this.iMK = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.11
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.CY(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.iMK);
                TbadkCoreApplication.getInst().handler.postDelayed(this.iMK, 5000L);
                return;
            }
            a(str, hb);
            return;
        }
        this.iMz.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.bHV.getLocationInWindow(iArr);
        int width = l.s(this.iMs).widthPixels - (iArr[0] + (bVar.bHV.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iMz.getLayoutParams();
        layoutParams.rightMargin = width - l.h(this.iMs.getPageContext().getPageActivity(), d.e.ds26);
        this.iMz.setLayoutParams(layoutParams);
        this.iMz.setVisibility(0);
        this.iMz.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void cgH() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.iMA);
    }

    public boolean cgI() {
        return this.iMx != null && this.iMx.getVisibility() == 0;
    }

    public void qk(boolean z) {
        if (this.iMx != null) {
            if (z) {
                this.iMx.setVisibility(0);
            } else {
                this.iMx.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.iMs.getPageContext(), i);
        al.b(this.iMw, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color, i);
        al.c(this.iMy, d.f.icon_news_down_bar_one);
        al.a(this.iMx, d.f.icon_game_bg_s, d.f.icon_game_bg);
        al.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
        aq.ado().d(this.eDo, d.f.ic_icon_ba_sign_n, d.C0277d.select_topbar_icon_color_tint);
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
            View inflate = LayoutInflater.from(this.iMs.getPageContext().getPageActivity()).inflate(d.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            al.d(textView, d.C0277d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.alq())) {
                textView.setText(payMemberInfoData.alq());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                al.c(tbImageView, d.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iMs.getPageContext().getPageActivity());
            aVar.az(inflate);
            aVar.gE(d.C0277d.cp_link_tip_d);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.iMs.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.iMs.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.iMs.getPageContext().getString(d.j.member_continue_pay);
            if (i == 0) {
                string = this.iMs.getPageContext().getString(d.j.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.iMs.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.iMs.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.iMs.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.dr(false);
            aVar.b(this.iMs.getPageContext()).aaZ();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void cgJ() {
        FragmentTabHost.b hb;
        if (this.mTabHost != null && (hb = this.mTabHost.hb(this.mTabHost.getCurrentTabType())) != null && hb.bHX != null && hb.bHX.anK() != null) {
            String string = this.iMs.getPageContext().getString(hb.bHX.anK().bOe);
            if (this.iMw != null) {
                this.iMw.setText(string);
            }
        }
    }

    public void aBB() {
        this.mNavigationBar = (NavigationBar) this.iMs.findViewById(d.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.iMw = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.iMs.getResources().getDimension(d.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.iMw.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.game_tip_view, (View.OnClickListener) null);
            this.iMx = (ImageView) addCustomView.findViewById(d.g.game_button_iv);
            this.iMy = (ImageView) addCustomView.findViewById(d.g.game_tip_msg_iv);
            this.iMx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.qn(false);
                    d.this.iMy.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, d.this.iMs.getPageContext()));
                    TiebaStatic.eventStat(d.this.iMs.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.h(this.iMs.getPageContext().getPageActivity(), d.e.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.iMs.sendMessage(new CustomMessage(2015003, new IntentConfig(d.this.iMs.getPageContext().getPageActivity())));
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
            this.eDo = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.eDo.setLayoutParams(layoutParams2);
            this.eDo.setVisibility(8);
            this.eDo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.iMs.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(d.this.iMs.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.iMs.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bc.cY(d.this.iMs.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.iMs.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.haE) {
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
                    bc.cX(d.this.iMs.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void ql(boolean z) {
        if (z) {
            this.eDo.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.eDo.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void qm(boolean z) {
        if (cgI()) {
            if (z) {
                if (this.iMy.getVisibility() != 0) {
                    this.iMy.setVisibility(0);
                    qn(true);
                    al.c(this.iMy, d.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            qn(false);
            this.iMy.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qn(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iMx.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.h(this.iMs.getPageContext().getPageActivity(), d.e.ds32);
            } else {
                layoutParams.rightMargin = l.h(this.iMs.getPageContext().getPageActivity(), d.e.ds20);
            }
            this.iMx.setLayoutParams(layoutParams);
        }
    }

    public void am(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.anK(), next.di(this.iMs.getPageContext().getPageActivity()));
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
        this.haI = z;
        if (!this.haI) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean bFc() {
        return this.haI;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            boolean z = false;
            bVar2.bHW = cVar.cod;
            bVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.coj);
            if (cVar.coj == com.baidu.tbadk.mainTab.c.cof) {
                maintabBottomIndicator.setWriteIconView();
                z = true;
            } else if (cVar.coj == com.baidu.tbadk.mainTab.c.coi) {
                maintabBottomIndicator.setText(cVar.bOe);
                maintabBottomIndicator.setAnimationResId(cVar.nf);
                this.iMD = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.bOe);
                maintabBottomIndicator.setAnimationResId(cVar.nf);
            }
            if (bVar2.mType == 2) {
                this.iME = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.ij(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.bHV = maintabBottomIndicator;
            bVar2.bHX = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost bef() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator cgK() {
        return this.iMD;
    }

    public MaintabBottomIndicator cgL() {
        return this.iME;
    }

    public void cgM() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void cgN() {
        this.mHandler.removeCallbacks(this.fwL);
        this.mHandler.removeCallbacks(this.fwM);
        g.a(this.iMB);
    }

    public void CZ(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iMs.getActivity());
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
                com.baidu.tieba.i.a.bla();
            }
        });
        aVar.b(this.iMs.getPageContext()).aaZ();
    }

    public void onDestroy() {
        cgH();
        if (bef() != null) {
            bef().reset();
        }
        cgN();
        if (this.fqJ != null) {
            this.fqJ.onDestroy();
        }
        if (this.fbp != null) {
            this.fbp.beY();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ap.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.iMs).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fqJ == null) {
            this.fqJ = new com.baidu.tieba.c.f(this.iMs.getPageContext(), (NavigationBarCoverTip) this.iMs.findViewById(d.g.navigation_cover_tip));
        }
        this.fqJ.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.fbp == null) {
                this.fbp = new f(this.iMs, this.iMs.getActivityRootView());
            }
            this.fbp.h(postWriteCallBackData);
        }
    }

    public void cgO() {
        this.iMG = 1;
    }
}
