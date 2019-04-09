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
    private ImageView eDa;
    private f fbc;
    private com.baidu.tieba.c.f fqv;
    private boolean haw;
    private MainTabActivity iMh;
    private TextView iMl;
    private ImageView iMm;
    private ImageView iMn;
    private TextView iMo;
    private PopupWindow iMq;
    private MaintabBottomIndicator iMs;
    private MaintabBottomIndicator iMt;
    private Runnable iMz;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean iMp = false;
    private int has = -1;
    private boolean iMr = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean iMu = true;
    private int iMv = 1;
    private boolean iMw = false;
    private FragmentTabHost.a iMx = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b gZ = d.this.mTabHost.gZ(i);
            if (gZ.mType == 8) {
                if (d.this.iMs != null && d.this.iMs.getAnimationView() != null && d.this.iMs.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new am("c10605").T("obj_type", 1));
                } else {
                    TiebaStatic.log(new am("c10605").T("obj_type", 0));
                }
                if (d.this.iMs != null) {
                    d.this.iMs.ake();
                }
            } else if (gZ.mType == 3) {
                TiebaStatic.log(new am("c12044").T("obj_locate", 1));
                TiebaStatic.log(new am("c12924").T("obj_locate", 1));
            }
            if (gZ.mType == 2) {
                d.this.iMu = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.iMv != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.iMv == 1) {
                        d.this.iMt.eU(d.this.iMu);
                    }
                } else {
                    d.this.iMt.anO();
                }
                d.this.iMw = false;
            } else {
                d.this.iMw = true;
                d.this.iMu = false;
                d.this.iMt.eU(d.this.iMu);
            }
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b gZ = d.this.mTabHost.gZ(i);
            if (gZ.mType == 9) {
                if (bc.cZ(d.this.iMh.getPageContext().getPageActivity())) {
                    d.this.iMh.beb();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (gZ.mType == 8 && !bc.cZ(d.this.iMh.getActivity())) {
                if (d.this.iMs != null) {
                    d.this.iMs.ake();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else {
                if (gZ.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ba.adA().a(d.this.iMh.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (gZ.mType == 3 && !bc.cZ(d.this.iMh.getActivity())) {
                    return false;
                } else {
                    if (gZ.mType == 1) {
                        TiebaStatic.log(new am("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener iMy = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.cgJ() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.iMw = true;
                        d.this.iMu = true;
                        if (d.this.iMv != 2) {
                            if (d.this.iMt.isAnimating()) {
                                d.this.iMt.eU(d.this.iMu);
                                return;
                            }
                            return;
                        }
                        d.this.cgJ().anQ();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.iMw = false;
                        if (d.this.iMv == 1) {
                            return;
                        }
                    } else {
                        d.this.iMv = intValue;
                    }
                    if (d.this.iMv == 1) {
                        d.this.cgJ().eU(d.this.iMu);
                    } else if (d.this.iMv == 2) {
                        d.this.cgJ().anO();
                    } else if (intValue == 5) {
                        d.this.iMv = 1;
                        d.this.iMu = true;
                        if (!d.this.iMw) {
                            d.this.cgJ().anQ();
                        }
                    } else {
                        d.this.cgJ().anP();
                    }
                }
            }
        }
    };
    private Runnable fwy = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.4
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.iMq != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.aO(d.this.iMh.getActivity());
                int h = l.h(d.this.iMh.getActivity(), d.e.ds178);
                View contentView = d.this.iMq.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b ha = d.this.mTabHost.ha(3);
                    if (ha != null && (tbFragmentTabIndicator = ha.bHY) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.h(d.this.iMh.getActivity(), d.e.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.iMq, fragmentTabWidget, measuredWidth2, -h);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_message_tips", true);
                        d.this.iMr = true;
                        d.this.mHandler.postDelayed(d.this.fwz, 5000L);
                    }
                }
            }
        }
    };
    private Runnable fwz = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.cgL();
        }
    };
    private View.OnClickListener fwA = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.cgL();
        }
    };

    public d(MainTabActivity mainTabActivity) {
        this.iMh = mainTabActivity;
    }

    public void qj(boolean z) {
        this.mTabHost = (FragmentTabHost) this.iMh.findViewById(d.g.tab_host);
        this.mTabHost.setUIType(1);
        this.mTabHost.setup(this.iMh.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.iMx);
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
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.gZ(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.eDa.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                d.this.has = d.this.mTabHost.getCurrentTabType();
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
        this.iMp = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        aBy();
        this.iMo = (TextView) this.iMh.findViewById(d.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.iMh.getPageContext()));
        switchNaviBarStatus(z);
        this.iMh.registerListener(this.iMy);
    }

    public void CX(final String str) {
        if (StringUtils.isNull(str)) {
            this.iMo.setVisibility(8);
            return;
        }
        FragmentTabHost.b ha = this.mTabHost.ha(8);
        if (ha != null) {
            if (!this.iMr || (this.iMq != null && this.iMq.isShowing())) {
                if (this.iMz == null) {
                    this.iMz = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.11
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.CX(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.iMz);
                TbadkCoreApplication.getInst().handler.postDelayed(this.iMz, 5000L);
                return;
            }
            a(str, ha);
            return;
        }
        this.iMo.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.bHY.getLocationInWindow(iArr);
        int width = l.s(this.iMh).widthPixels - (iArr[0] + (bVar.bHY.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iMo.getLayoutParams();
        layoutParams.rightMargin = width - l.h(this.iMh.getPageContext().getPageActivity(), d.e.ds26);
        this.iMo.setLayoutParams(layoutParams);
        this.iMo.setVisibility(0);
        this.iMo.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void cgF() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.iMp);
    }

    public boolean cgG() {
        return this.iMm != null && this.iMm.getVisibility() == 0;
    }

    public void qk(boolean z) {
        if (this.iMm != null) {
            if (z) {
                this.iMm.setVisibility(0);
            } else {
                this.iMm.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.iMh.getPageContext(), i);
        al.b(this.iMl, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color, i);
        al.c(this.iMn, d.f.icon_news_down_bar_one);
        al.a(this.iMm, d.f.icon_game_bg_s, d.f.icon_game_bg);
        al.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
        aq.adl().d(this.eDa, d.f.ic_icon_ba_sign_n, d.C0277d.select_topbar_icon_color_tint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.abT();
            } else {
                this.mTabHost.abS();
            }
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.iMh.getPageContext().getPageActivity()).inflate(d.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            al.d(textView, d.C0277d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.aln())) {
                textView.setText(payMemberInfoData.aln());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                al.c(tbImageView, d.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iMh.getPageContext().getPageActivity());
            aVar.az(inflate);
            aVar.gD(d.C0277d.cp_link_tip_d);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.iMh.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.iMh.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.iMh.getPageContext().getString(d.j.member_continue_pay);
            if (i == 0) {
                string = this.iMh.getPageContext().getString(d.j.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.iMh.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.iMh.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.iMh.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.dr(false);
            aVar.b(this.iMh.getPageContext()).aaW();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void cgH() {
        FragmentTabHost.b ha;
        if (this.mTabHost != null && (ha = this.mTabHost.ha(this.mTabHost.getCurrentTabType())) != null && ha.bIa != null && ha.bIa.anH() != null) {
            String string = this.iMh.getPageContext().getString(ha.bIa.anH().bOh);
            if (this.iMl != null) {
                this.iMl.setText(string);
            }
        }
    }

    public void aBy() {
        this.mNavigationBar = (NavigationBar) this.iMh.findViewById(d.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.iMl = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.iMh.getResources().getDimension(d.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.iMl.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.game_tip_view, (View.OnClickListener) null);
            this.iMm = (ImageView) addCustomView.findViewById(d.g.game_button_iv);
            this.iMn = (ImageView) addCustomView.findViewById(d.g.game_tip_msg_iv);
            this.iMm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.qn(false);
                    d.this.iMn.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, d.this.iMh.getPageContext()));
                    TiebaStatic.eventStat(d.this.iMh.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.h(this.iMh.getPageContext().getPageActivity(), d.e.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.iMh.sendMessage(new CustomMessage(2015003, new IntentConfig(d.this.iMh.getPageContext().getPageActivity())));
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
            this.eDa = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.eDa.setLayoutParams(layoutParams2);
            this.eDa.setVisibility(8);
            this.eDa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.iMh.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(d.this.iMh.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.iMh.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bc.cY(d.this.iMh.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.iMh.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.has) {
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
                    bc.cX(d.this.iMh.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void ql(boolean z) {
        if (z) {
            this.eDa.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.eDa.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void qm(boolean z) {
        if (cgG()) {
            if (z) {
                if (this.iMn.getVisibility() != 0) {
                    this.iMn.setVisibility(0);
                    qn(true);
                    al.c(this.iMn, d.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            qn(false);
            this.iMn.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qn(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iMm.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.h(this.iMh.getPageContext().getPageActivity(), d.e.ds32);
            } else {
                layoutParams.rightMargin = l.h(this.iMh.getPageContext().getPageActivity(), d.e.ds20);
            }
            this.iMm.setLayoutParams(layoutParams);
        }
    }

    public void am(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.anH(), next.di(this.iMh.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.mTabHost.gX(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.gX(1);
        } else {
            this.mTabHost.gX(0);
        }
        this.mTabHost.setViewPagerScrollable(false);
    }

    public void mx(boolean z) {
        this.haw = z;
        if (!this.haw) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean bEZ() {
        return this.haw;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            boolean z = false;
            bVar2.bHZ = cVar.cog;
            bVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.f5com);
            if (cVar.f5com == com.baidu.tbadk.mainTab.c.coi) {
                maintabBottomIndicator.setWriteIconView();
                z = true;
            } else if (cVar.f5com == com.baidu.tbadk.mainTab.c.col) {
                maintabBottomIndicator.setText(cVar.bOh);
                maintabBottomIndicator.setAnimationResId(cVar.nf);
                this.iMs = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.bOh);
                maintabBottomIndicator.setAnimationResId(cVar.nf);
            }
            if (bVar2.mType == 2) {
                this.iMt = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.ii(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.bHY = maintabBottomIndicator;
            bVar2.bIa = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost bed() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator cgI() {
        return this.iMs;
    }

    public MaintabBottomIndicator cgJ() {
        return this.iMt;
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
        this.mHandler.removeCallbacks(this.fwy);
        this.mHandler.removeCallbacks(this.fwz);
        g.a(this.iMq);
    }

    public void CY(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iMh.getActivity());
        aVar.lz(str);
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
                com.baidu.tieba.i.a.bkX();
            }
        });
        aVar.b(this.iMh.getPageContext()).aaW();
    }

    public void onDestroy() {
        cgF();
        if (bed() != null) {
            bed().reset();
        }
        cgL();
        if (this.fqv != null) {
            this.fqv.onDestroy();
        }
        if (this.fbc != null) {
            this.fbc.beW();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ap.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.iMh).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fqv == null) {
            this.fqv = new com.baidu.tieba.c.f(this.iMh.getPageContext(), (NavigationBarCoverTip) this.iMh.findViewById(d.g.navigation_cover_tip));
        }
        this.fqv.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.fbc == null) {
                this.fbc = new f(this.iMh, this.iMh.getActivityRootView());
            }
            this.fbc.h(postWriteCallBackData);
        }
    }

    public void cgM() {
        this.iMv = 1;
    }
}
