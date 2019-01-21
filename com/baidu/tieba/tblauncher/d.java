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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.f;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class d {
    private f dNL;
    private ImageView drS;
    private com.baidu.tieba.c.f ede;
    private boolean fKx;
    private MainTabActivity hvO;
    private TextView hvT;
    private ImageView hvU;
    private ImageView hvV;
    private TextView hvW;
    private PopupWindow hvY;
    private MaintabBottomIndicator hwa;
    private Runnable hwc;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean hvX = false;
    private int fKt = -1;
    private boolean hvZ = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.a hwb = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b dy = d.this.mTabHost.dy(i);
            if (dy.mType == 8) {
                if (d.this.hwa != null && d.this.hwa.getAnimationView() != null && d.this.hwa.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new am("c10605").y("obj_type", 1));
                } else {
                    TiebaStatic.log(new am("c10605").y("obj_type", 0));
                }
                if (d.this.hwa != null) {
                    d.this.hwa.Ol();
                }
            } else if (dy.mType == 3) {
                TiebaStatic.log(new am("c12044").y("obj_locate", 1));
                TiebaStatic.log(new am("c12924").y("obj_locate", 1));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b dy = d.this.mTabHost.dy(i);
            if (dy.mType == 9) {
                if (ba.bJ(d.this.hvO.getPageContext().getPageActivity())) {
                    d.this.hvO.aDw();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (dy.mType == 8 && !ba.bJ(d.this.hvO.getActivity())) {
                if (d.this.hwa != null) {
                    d.this.hwa.Ol();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else {
                if (dy.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ay.Es().a(d.this.hvO.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (dy.mType == 3 && !ba.bJ(d.this.hvO.getActivity())) {
                    return false;
                } else {
                    if (dy.mType == 1) {
                        TiebaStatic.log(new am("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private Runnable ehE = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.3
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.hvY != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.aO(d.this.hvO.getActivity());
                int h = l.h(d.this.hvO.getActivity(), e.C0210e.ds178);
                View contentView = d.this.hvY.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b dz = d.this.mTabHost.dz(3);
                    if (dz != null && (tbFragmentTabIndicator = dz.aAb) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.h(d.this.hvO.getActivity(), e.C0210e.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.hvY, fragmentTabWidget, measuredWidth2, -h);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_message_tips", true);
                        d.this.hvZ = true;
                        d.this.mHandler.postDelayed(d.this.ehF, 5000L);
                    }
                }
            }
        }
    };
    private Runnable ehF = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.4
        @Override // java.lang.Runnable
        public void run() {
            d.this.bHj();
        }
    };
    private View.OnClickListener ehG = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bHj();
        }
    };

    public d(MainTabActivity mainTabActivity) {
        this.hvO = mainTabActivity;
    }

    public void nJ(boolean z) {
        this.mTabHost = (FragmentTabHost) this.hvO.findViewById(e.g.tab_host);
        this.mTabHost.setup(this.hvO.getSupportFragmentManager());
        this.mTabHost.setOnTabSelectionListener(this.hwb);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.setShouldDrawIndicatorLine(false);
            this.mTabHost.setShouldDrawTopLine(true);
        }
        this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mTabHost.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.d.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (d.this.mTabHost.getCurrentTabType() != 2) {
                    if (d.this.mTabHost.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                d.this.bHi();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.dy(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.drS.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                d.this.fKt = d.this.mTabHost.getCurrentTabType();
                d.this.bHg();
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
                    TiebaStatic.log(new am("view_msg").aB("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.hvX = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        azR();
        this.hvW = (TextView) this.hvO.findViewById(e.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.hvO.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void wx(final String str) {
        if (StringUtils.isNull(str)) {
            this.hvW.setVisibility(8);
            return;
        }
        FragmentTabHost.b dz = this.mTabHost.dz(8);
        if (dz != null) {
            if (!this.hvZ || (this.hvY != null && this.hvY.isShowing())) {
                if (this.hwc == null) {
                    this.hwc = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.9
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.wx(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.hwc);
                TbadkCoreApplication.getInst().handler.postDelayed(this.hwc, 5000L);
                return;
            }
            a(str, dz);
            return;
        }
        this.hvW.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.aAb.getLocationInWindow(iArr);
        int width = l.s(this.hvO).widthPixels - (iArr[0] + (bVar.aAb.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hvW.getLayoutParams();
        layoutParams.rightMargin = width - l.h(this.hvO.getPageContext().getPageActivity(), e.C0210e.ds26);
        this.hvW.setLayoutParams(layoutParams);
        this.hvW.setVisibility(0);
        this.hvW.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void bHe() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.hvX);
    }

    public boolean bHf() {
        return this.hvU != null && this.hvU.getVisibility() == 0;
    }

    public void nK(boolean z) {
        if (this.hvU != null) {
            if (z) {
                this.hvU.setVisibility(0);
            } else {
                this.hvU.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.mTabHost.setShouldDrawTopLine(false);
            } else {
                this.mTabHost.br(true);
            }
        }
        if (this.mTabHost.getFragmentTabWidget() != null) {
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.mTabHost.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.hvO.getPageContext(), i);
        al.a(this.hvT, e.d.cp_cont_b, e.d.s_navbar_title_color, i);
        al.c(this.hvV, e.f.icon_news_down_bar_one);
        al.a(this.hvU, e.f.icon_game_bg_s, e.f.icon_game_bg);
        al.a(this.mSearchButton, e.f.icon_search_bg_s, e.f.icon_search_bg);
        al.a(this.drS, e.f.icon_sign_bg_s, e.f.icon_sign_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.CM();
            } else {
                this.mTabHost.CL();
            }
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.hvO.getPageContext().getPageActivity()).inflate(e.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(e.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(e.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            al.c(textView, e.d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.LP())) {
                textView.setText(payMemberInfoData.LP());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                al.c(tbImageView, e.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hvO.getPageContext().getPageActivity());
            aVar.G(inflate);
            aVar.dc(e.d.cp_link_tip_d);
            aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.hvO.getPageContext().getPageActivity(), "user_overdue_know", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.hvO.getPageContext().getPageActivity(), "user_expire_know", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    }
                }
            });
            String string = this.hvO.getPageContext().getString(e.j.member_continue_pay);
            if (i == 0) {
                string = this.hvO.getPageContext().getString(e.j.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.hvO.getPageContext().getPageActivity(), "user_overdue_pay", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.hvO.getPageContext().getPageActivity(), "user_expire_pay", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.hvO.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.bh(false);
            aVar.b(this.hvO.getPageContext()).BS();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void bHg() {
        FragmentTabHost.b dz;
        if (this.mTabHost != null && (dz = this.mTabHost.dz(this.mTabHost.getCurrentTabType())) != null && dz.aAd != null && dz.aAd.Oh() != null) {
            String string = this.hvO.getPageContext().getString(dz.aAd.Oh().aFV);
            if (this.hvT != null) {
                this.hvT.setText(string);
            }
        }
    }

    public void azR() {
        this.mNavigationBar = (NavigationBar) this.hvO.findViewById(e.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.hvT = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.maintab_title_layout, (View.OnClickListener) null).findViewById(e.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.hvO.getResources().getDimension(e.C0210e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.hvT.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.game_tip_view, (View.OnClickListener) null);
            this.hvU = (ImageView) addCustomView.findViewById(e.g.game_button_iv);
            this.hvV = (ImageView) addCustomView.findViewById(e.g.game_tip_msg_iv);
            this.hvU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.nN(false);
                    d.this.hvV.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, d.this.hvO.getPageContext()));
                    TiebaStatic.eventStat(d.this.hvO.getPageContext().getPageActivity(), "tb_gamecenter", AiAppsUBCStatistic.TYPE_CLICK, 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.h(this.hvO.getPageContext().getPageActivity(), e.C0210e.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.hvO.sendMessage(new CustomMessage(2015003, new IntentConfig(d.this.hvO.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new am("c10378").y("obj_type", i));
                }
            });
            this.drS = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.drS.setLayoutParams(layoutParams2);
            this.drS.setVisibility(8);
            this.drS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.hvO.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(d.this.hvO.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.hvO.getPageContext().getPageActivity(), "notlogin_4", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    ba.bI(d.this.hvO.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.hvO.getPageContext().getPageActivity(), "notlogin_3", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    String str = "";
                    switch (d.this.fKt) {
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
                    TiebaStatic.log(new am("c10517").aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
                    ba.bH(d.this.hvO.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void nL(boolean z) {
        if (z) {
            this.drS.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.drS.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void nM(boolean z) {
        if (bHf()) {
            if (z) {
                if (this.hvV.getVisibility() != 0) {
                    this.hvV.setVisibility(0);
                    nN(true);
                    al.c(this.hvV, e.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            nN(false);
            this.hvV.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nN(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hvU.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.h(this.hvO.getPageContext().getPageActivity(), e.C0210e.ds32);
            } else {
                layoutParams.rightMargin = l.h(this.hvO.getPageContext().getPageActivity(), e.C0210e.ds20);
            }
            this.hvU.setLayoutParams(layoutParams);
        }
    }

    public void ai(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Oh(), next.bR(this.hvO.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.mTabHost.dw(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.dw(1);
        } else {
            this.mTabHost.dw(0);
        }
        this.mTabHost.setViewPagerScrollable(false);
    }

    public void jW(boolean z) {
        this.fKx = z;
        if (!this.fKx) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean bez() {
        return this.fKx;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.aAc = cVar.beA;
            bVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.beG);
            if (cVar.beG == com.baidu.tbadk.mainTab.c.beC) {
                maintabBottomIndicator.setWriteIconView(cVar.aFW, cVar.beB);
            } else if (cVar.beG == com.baidu.tbadk.mainTab.c.beF) {
                maintabBottomIndicator.setIconResourceId(cVar.aFW);
                maintabBottomIndicator.setText(cVar.aFV);
                maintabBottomIndicator.setAnimationResId(cVar.nk);
                this.hwa = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.aFW);
                maintabBottomIndicator.setText(cVar.aFV);
                maintabBottomIndicator.setAnimationResId(cVar.nk);
            }
            tbFragmentTabIndicator.eD(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.aAb = maintabBottomIndicator;
            bVar2.aAd = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    public FragmentTabHost aDA() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator bHh() {
        return this.hwa;
    }

    public void bHi() {
        if (this.mTabHost != null) {
            if ((this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.mTabHost.getCurrentTabType() != 1) {
                if (this.drS != null) {
                    this.drS.setVisibility(8);
                }
                if (this.mSearchButton != null && this.mTabHost.getCurrentTabType() != 3) {
                    this.mSearchButton.setVisibility(0);
                }
            }
        }
    }

    public void bHj() {
        this.mHandler.removeCallbacks(this.ehE);
        this.mHandler.removeCallbacks(this.ehF);
        g.a(this.hvY);
    }

    public void wy(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hvO.getActivity());
        aVar.eK(str);
        aVar.a(e.j.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                am amVar = new am("c12137");
                amVar.aB("obj_locate", "1");
                TiebaStatic.log(amVar);
                aVar2.dismiss();
            }
        });
        aVar.b(e.j.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                am amVar = new am("c12137");
                amVar.aB("obj_locate", "2");
                TiebaStatic.log(amVar);
                aVar2.dismiss();
                com.baidu.tieba.i.a.aKT();
            }
        });
        aVar.b(this.hvO.getPageContext()).BS();
    }

    public void onDestroy() {
        bHe();
        if (aDA() != null) {
            aDA().reset();
        }
        bHj();
        if (this.ede != null) {
            this.ede.onDestroy();
        }
        if (this.dNL != null) {
            this.dNL.aEp();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ao.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.hvO).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.ede == null) {
            this.ede = new com.baidu.tieba.c.f(this.hvO.getPageContext(), (NavigationBarCoverTip) this.hvO.findViewById(e.g.navigation_cover_tip));
        }
        this.ede.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.dNL == null) {
                this.dNL = new f(this.hvO, this.hvO.getActivityRootView());
            }
            this.dNL.h(postWriteCallBackData);
        }
    }
}
