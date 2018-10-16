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
public class e {
    private f dCy;
    private com.baidu.tieba.c.f dRW;
    private ImageView dgF;
    private boolean fyw;
    private TextView hiB;
    private ImageView hiC;
    private ImageView hiD;
    private TextView hiE;
    private PopupWindow hiG;
    private MaintabBottomIndicator hiI;
    private Runnable hiK;
    private MainTabActivity hiw;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean hiF = false;
    private int fys = -1;
    private boolean hiH = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.a hiJ = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.e.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b cW = e.this.mTabHost.cW(i);
            if (cW.mType == 8) {
                if (e.this.hiI != null && e.this.hiI.getAnimationView() != null && e.this.hiI.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new am("c10605").x("obj_type", 1));
                } else {
                    TiebaStatic.log(new am("c10605").x("obj_type", 0));
                }
                if (e.this.hiI != null) {
                    e.this.hiI.MG();
                }
            } else if (cW.mType == 3) {
                TiebaStatic.log(new am("c12044").x("obj_locate", 1));
                TiebaStatic.log(new am("c12924").x("obj_locate", 1));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b cW = e.this.mTabHost.cW(i);
            if (cW.mType == 9) {
                if (ba.bI(e.this.hiw.getPageContext().getPageActivity())) {
                    e.this.hiw.aBc();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (cW.mType == 8 && !ba.bI(e.this.hiw.getActivity())) {
                if (e.this.hiI != null) {
                    e.this.hiI.MG();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else {
                if (cW.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ay.CU().a(e.this.hiw.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (cW.mType == 3 && !ba.bI(e.this.hiw.getActivity())) {
                    return false;
                } else {
                    if (cW.mType == 1) {
                        TiebaStatic.log(new am("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private Runnable fYV = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.3
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (e.this.mTabHost != null && e.this.hiG != null) {
                FragmentTabWidget fragmentTabWidget = e.this.mTabHost.getFragmentTabWidget();
                l.aO(e.this.hiw.getActivity());
                int h = l.h(e.this.hiw.getActivity(), e.C0175e.ds178);
                View contentView = e.this.hiG.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b cX = e.this.mTabHost.cX(3);
                    if (cX != null && (tbFragmentTabIndicator = cX.avl) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.h(e.this.hiw.getActivity(), e.C0175e.tbds570);
                        }
                        g.showPopupWindowAsDropDown(e.this.hiG, fragmentTabWidget, measuredWidth2, -h);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_message_tips", true);
                        e.this.hiH = true;
                        e.this.mHandler.postDelayed(e.this.fYW, 5000L);
                    }
                }
            }
        }
    };
    private Runnable fYW = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.4
        @Override // java.lang.Runnable
        public void run() {
            e.this.bEi();
        }
    };
    private View.OnClickListener fYX = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.bEi();
        }
    };

    public e(MainTabActivity mainTabActivity) {
        this.hiw = mainTabActivity;
    }

    public void np(boolean z) {
        this.mTabHost = (FragmentTabHost) this.hiw.findViewById(e.g.tab_host);
        this.mTabHost.setup(this.hiw.getSupportFragmentManager());
        this.mTabHost.setOnTabSelectionListener(this.hiJ);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.setShouldDrawIndicatorLine(false);
            this.mTabHost.setShouldDrawTopLine(true);
        }
        this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mTabHost.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.e.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (e.this.mTabHost.getCurrentTabType() != 2) {
                    if (e.this.mTabHost.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                e.this.bEh();
                if (e.this.mTabHost.getCurrentTabType() != e.this.mTabHost.cW(i).mType) {
                    e.this.mTabHost.setCurrentTab(i);
                }
                if (e.this.mTabHost.getCurrentTabType() != 1) {
                    e.this.dgF.setVisibility(8);
                    e.this.mSearchButton.setVisibility(0);
                }
                e.this.fys = e.this.mTabHost.getCurrentTabType();
                e.this.bEf();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (e.this.mTabHost.getCurrentTabType() != 3) {
                        if (e.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (e.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new am("view_msg").ax("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.hiF = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        axv();
        this.hiE = (TextView) this.hiw.findViewById(e.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.hiw.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void vw(final String str) {
        if (StringUtils.isNull(str)) {
            this.hiE.setVisibility(8);
            return;
        }
        FragmentTabHost.b cX = this.mTabHost.cX(8);
        if (cX != null) {
            if (!this.hiH || (this.hiG != null && this.hiG.isShowing())) {
                if (this.hiK == null) {
                    this.hiK = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.vw(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.hiK);
                TbadkCoreApplication.getInst().handler.postDelayed(this.hiK, 5000L);
                return;
            }
            a(str, cX);
            return;
        }
        this.hiE.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.avl.getLocationInWindow(iArr);
        int width = l.s(this.hiw).widthPixels - (iArr[0] + (bVar.avl.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hiE.getLayoutParams();
        layoutParams.rightMargin = width - l.h(this.hiw.getPageContext().getPageActivity(), e.C0175e.ds26);
        this.hiE.setLayoutParams(layoutParams);
        this.hiE.setVisibility(0);
        this.hiE.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void bEd() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.hiF);
    }

    public boolean bEe() {
        return this.hiC != null && this.hiC.getVisibility() == 0;
    }

    public void nq(boolean z) {
        if (this.hiC != null) {
            if (z) {
                this.hiC.setVisibility(0);
            } else {
                this.hiC.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.mTabHost.setShouldDrawTopLine(false);
            } else {
                this.mTabHost.aZ(true);
            }
        }
        if (this.mTabHost.getFragmentTabWidget() != null) {
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.mTabHost.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.hiw.getPageContext(), i);
        al.a(this.hiB, e.d.cp_cont_b, e.d.s_navbar_title_color, i);
        al.c(this.hiD, e.f.icon_news_down_bar_one);
        al.a(this.hiC, e.f.icon_game_bg_s, e.f.icon_game_bg);
        al.a(this.mSearchButton, e.f.icon_search_bg_s, e.f.icon_search_bg);
        al.a(this.dgF, e.f.icon_sign_bg_s, e.f.icon_sign_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.Bo();
            } else {
                this.mTabHost.Bn();
            }
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.hiw.getPageContext().getPageActivity()).inflate(e.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(e.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(e.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            al.c(textView, e.d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.Kj())) {
                textView.setText(payMemberInfoData.Kj());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                al.c(tbImageView, e.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hiw.getPageContext().getPageActivity());
            aVar.G(inflate);
            aVar.cA(e.d.cp_link_tip_d);
            aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.tblauncher.e.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(e.this.hiw.getPageContext().getPageActivity(), "user_overdue_know", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(e.this.hiw.getPageContext().getPageActivity(), "user_expire_know", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    }
                }
            });
            String string = this.hiw.getPageContext().getString(e.j.member_continue_pay);
            if (i == 0) {
                string = this.hiw.getPageContext().getString(e.j.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.e.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(e.this.hiw.getPageContext().getPageActivity(), "user_overdue_pay", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(e.this.hiw.getPageContext().getPageActivity(), "user_expire_pay", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(e.this.hiw.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.aP(false);
            aVar.b(this.hiw.getPageContext()).Au();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void bEf() {
        FragmentTabHost.b cX;
        if (this.mTabHost != null && (cX = this.mTabHost.cX(this.mTabHost.getCurrentTabType())) != null && cX.avn != null && cX.avn.MC() != null) {
            String string = this.hiw.getPageContext().getString(cX.avn.MC().aBc);
            if (this.hiB != null) {
                this.hiB.setText(string);
            }
        }
    }

    public void axv() {
        this.mNavigationBar = (NavigationBar) this.hiw.findViewById(e.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.hiB = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.maintab_title_layout, (View.OnClickListener) null).findViewById(e.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.hiw.getResources().getDimension(e.C0175e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.hiB.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.game_tip_view, (View.OnClickListener) null);
            this.hiC = (ImageView) addCustomView.findViewById(e.g.game_button_iv);
            this.hiD = (ImageView) addCustomView.findViewById(e.g.game_tip_msg_iv);
            this.hiC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.nt(false);
                    e.this.hiD.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, e.this.hiw.getPageContext()));
                    TiebaStatic.eventStat(e.this.hiw.getPageContext().getPageActivity(), "tb_gamecenter", AiAppsUBCStatistic.TYPE_CLICK, 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.h(this.hiw.getPageContext().getPageActivity(), e.C0175e.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    e.this.hiw.sendMessage(new CustomMessage(2015003, new IntentConfig(e.this.hiw.getPageContext().getPageActivity())));
                    if (e.this.mTabHost.getCurrentTabType() != 3) {
                        if (e.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new am("c10378").x("obj_type", i));
                }
            });
            this.dgF = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.dgF.setLayoutParams(layoutParams2);
            this.dgF.setVisibility(8);
            this.dgF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        e.this.hiw.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(e.this.hiw.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.hiw.getPageContext().getPageActivity(), "notlogin_4", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    ba.bH(e.this.hiw.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.hiw.getPageContext().getPageActivity(), "notlogin_3", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    String str = "";
                    switch (e.this.fys) {
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
                    TiebaStatic.log(new am("c10517").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
                    ba.bG(e.this.hiw.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void nr(boolean z) {
        if (z) {
            this.dgF.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.dgF.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void ns(boolean z) {
        if (bEe()) {
            if (z) {
                if (this.hiD.getVisibility() != 0) {
                    this.hiD.setVisibility(0);
                    nt(true);
                    al.c(this.hiD, e.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            nt(false);
            this.hiD.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nt(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hiC.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.h(this.hiw.getPageContext().getPageActivity(), e.C0175e.ds32);
            } else {
                layoutParams.rightMargin = l.h(this.hiw.getPageContext().getPageActivity(), e.C0175e.ds20);
            }
            this.hiC.setLayoutParams(layoutParams);
        }
    }

    public void aj(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.MC(), next.bR(this.hiw.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.mTabHost.cU(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.cU(1);
        } else {
            this.mTabHost.cU(0);
        }
        this.mTabHost.setViewPagerScrollable(false);
    }

    public void jG(boolean z) {
        this.fyw = z;
        if (!this.fyw) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean bbW() {
        return this.fyw;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.avm = cVar.aZz;
            bVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.aZF);
            if (cVar.aZF == com.baidu.tbadk.mainTab.c.aZB) {
                maintabBottomIndicator.setWriteIconView(cVar.aBd, cVar.aZA);
            } else if (cVar.aZF == com.baidu.tbadk.mainTab.c.aZE) {
                maintabBottomIndicator.setIconResourceId(cVar.aBd);
                maintabBottomIndicator.setText(cVar.aBc);
                maintabBottomIndicator.setAnimationResId(cVar.nk);
                this.hiI = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.aBd);
                maintabBottomIndicator.setText(cVar.aBc);
                maintabBottomIndicator.setAnimationResId(cVar.nk);
            }
            tbFragmentTabIndicator.ea(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.avl = maintabBottomIndicator;
            bVar2.avn = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    public FragmentTabHost aBg() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator bEg() {
        return this.hiI;
    }

    public void bEh() {
        if (this.mTabHost != null) {
            if ((this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.mTabHost.getCurrentTabType() != 1) {
                if (this.dgF != null) {
                    this.dgF.setVisibility(8);
                }
                if (this.mSearchButton != null && this.mTabHost.getCurrentTabType() != 3) {
                    this.mSearchButton.setVisibility(0);
                }
            }
        }
    }

    public void bEi() {
        this.mHandler.removeCallbacks(this.fYV);
        this.mHandler.removeCallbacks(this.fYW);
        g.a(this.hiG);
    }

    public void vx(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hiw.getActivity());
        aVar.ej(str);
        aVar.a(e.j.close, new a.b() { // from class: com.baidu.tieba.tblauncher.e.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                am amVar = new am("c12137");
                amVar.ax("obj_locate", "1");
                TiebaStatic.log(amVar);
                aVar2.dismiss();
            }
        });
        aVar.b(e.j.check, new a.b() { // from class: com.baidu.tieba.tblauncher.e.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                am amVar = new am("c12137");
                amVar.ax("obj_locate", "2");
                TiebaStatic.log(amVar);
                aVar2.dismiss();
                com.baidu.tieba.i.a.aIr();
            }
        });
        aVar.b(this.hiw.getPageContext()).Au();
    }

    public void onDestroy() {
        bEd();
        if (aBg() != null) {
            aBg().reset();
        }
        bEi();
        if (this.dRW != null) {
            this.dRW.onDestroy();
        }
        if (this.dCy != null) {
            this.dCy.aBV();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ao.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.hiw).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dRW == null) {
            this.dRW = new com.baidu.tieba.c.f(this.hiw.getPageContext(), (NavigationBarCoverTip) this.hiw.findViewById(e.g.navigation_cover_tip));
        }
        this.dRW.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.dCy == null) {
                this.dCy = new f(this.hiw, this.hiw.getActivityRootView());
            }
            this.dCy.h(postWriteCallBackData);
        }
    }
}
