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
    private f dKn;
    private com.baidu.tieba.c.f dZG;
    private ImageView dos;
    private boolean fGK;
    private ImageView hrA;
    private TextView hrB;
    private PopupWindow hrD;
    private MaintabBottomIndicator hrF;
    private Runnable hrH;
    private MainTabActivity hrt;
    private TextView hry;
    private ImageView hrz;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean hrC = false;
    private int fGG = -1;
    private boolean hrE = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.a hrG = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b dy = d.this.mTabHost.dy(i);
            if (dy.mType == 8) {
                if (d.this.hrF != null && d.this.hrF.getAnimationView() != null && d.this.hrF.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new am("c10605").x("obj_type", 1));
                } else {
                    TiebaStatic.log(new am("c10605").x("obj_type", 0));
                }
                if (d.this.hrF != null) {
                    d.this.hrF.NT();
                }
            } else if (dy.mType == 3) {
                TiebaStatic.log(new am("c12044").x("obj_locate", 1));
                TiebaStatic.log(new am("c12924").x("obj_locate", 1));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b dy = d.this.mTabHost.dy(i);
            if (dy.mType == 9) {
                if (ba.bJ(d.this.hrt.getPageContext().getPageActivity())) {
                    d.this.hrt.aCk();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (dy.mType == 8 && !ba.bJ(d.this.hrt.getActivity())) {
                if (d.this.hrF != null) {
                    d.this.hrF.NT();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else {
                if (dy.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ay.Ef().a(d.this.hrt.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (dy.mType == 3 && !ba.bJ(d.this.hrt.getActivity())) {
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
    private Runnable eeg = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.3
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.hrD != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.aO(d.this.hrt.getActivity());
                int h = l.h(d.this.hrt.getActivity(), e.C0210e.ds178);
                View contentView = d.this.hrD.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b dz = d.this.mTabHost.dz(3);
                    if (dz != null && (tbFragmentTabIndicator = dz.azy) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.h(d.this.hrt.getActivity(), e.C0210e.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.hrD, fragmentTabWidget, measuredWidth2, -h);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_message_tips", true);
                        d.this.hrE = true;
                        d.this.mHandler.postDelayed(d.this.eeh, 5000L);
                    }
                }
            }
        }
    };
    private Runnable eeh = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.4
        @Override // java.lang.Runnable
        public void run() {
            d.this.bFK();
        }
    };
    private View.OnClickListener eei = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bFK();
        }
    };

    public d(MainTabActivity mainTabActivity) {
        this.hrt = mainTabActivity;
    }

    public void nF(boolean z) {
        this.mTabHost = (FragmentTabHost) this.hrt.findViewById(e.g.tab_host);
        this.mTabHost.setup(this.hrt.getSupportFragmentManager());
        this.mTabHost.setOnTabSelectionListener(this.hrG);
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
                d.this.bFJ();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.dy(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.dos.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                d.this.fGG = d.this.mTabHost.getCurrentTabType();
                d.this.bFH();
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
                    TiebaStatic.log(new am("view_msg").aA("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.hrC = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        ayF();
        this.hrB = (TextView) this.hrt.findViewById(e.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.hrt.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void we(final String str) {
        if (StringUtils.isNull(str)) {
            this.hrB.setVisibility(8);
            return;
        }
        FragmentTabHost.b dz = this.mTabHost.dz(8);
        if (dz != null) {
            if (!this.hrE || (this.hrD != null && this.hrD.isShowing())) {
                if (this.hrH == null) {
                    this.hrH = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.9
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.we(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.hrH);
                TbadkCoreApplication.getInst().handler.postDelayed(this.hrH, 5000L);
                return;
            }
            a(str, dz);
            return;
        }
        this.hrB.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.azy.getLocationInWindow(iArr);
        int width = l.s(this.hrt).widthPixels - (iArr[0] + (bVar.azy.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hrB.getLayoutParams();
        layoutParams.rightMargin = width - l.h(this.hrt.getPageContext().getPageActivity(), e.C0210e.ds26);
        this.hrB.setLayoutParams(layoutParams);
        this.hrB.setVisibility(0);
        this.hrB.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void bFF() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.hrC);
    }

    public boolean bFG() {
        return this.hrz != null && this.hrz.getVisibility() == 0;
    }

    public void nG(boolean z) {
        if (this.hrz != null) {
            if (z) {
                this.hrz.setVisibility(0);
            } else {
                this.hrz.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.mTabHost.setShouldDrawTopLine(false);
            } else {
                this.mTabHost.bq(true);
            }
        }
        if (this.mTabHost.getFragmentTabWidget() != null) {
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.mTabHost.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.hrt.getPageContext(), i);
        al.a(this.hry, e.d.cp_cont_b, e.d.s_navbar_title_color, i);
        al.c(this.hrA, e.f.icon_news_down_bar_one);
        al.a(this.hrz, e.f.icon_game_bg_s, e.f.icon_game_bg);
        al.a(this.mSearchButton, e.f.icon_search_bg_s, e.f.icon_search_bg);
        al.a(this.dos, e.f.icon_sign_bg_s, e.f.icon_sign_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.Cz();
            } else {
                this.mTabHost.Cy();
            }
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.hrt.getPageContext().getPageActivity()).inflate(e.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(e.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(e.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            al.c(textView, e.d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.Lz())) {
                textView.setText(payMemberInfoData.Lz());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                al.c(tbImageView, e.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hrt.getPageContext().getPageActivity());
            aVar.G(inflate);
            aVar.dc(e.d.cp_link_tip_d);
            aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.hrt.getPageContext().getPageActivity(), "user_overdue_know", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.hrt.getPageContext().getPageActivity(), "user_expire_know", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    }
                }
            });
            String string = this.hrt.getPageContext().getString(e.j.member_continue_pay);
            if (i == 0) {
                string = this.hrt.getPageContext().getString(e.j.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.hrt.getPageContext().getPageActivity(), "user_overdue_pay", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.hrt.getPageContext().getPageActivity(), "user_expire_pay", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.hrt.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.bg(false);
            aVar.b(this.hrt.getPageContext()).BF();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void bFH() {
        FragmentTabHost.b dz;
        if (this.mTabHost != null && (dz = this.mTabHost.dz(this.mTabHost.getCurrentTabType())) != null && dz.azA != null && dz.azA.NP() != null) {
            String string = this.hrt.getPageContext().getString(dz.azA.NP().aFr);
            if (this.hry != null) {
                this.hry.setText(string);
            }
        }
    }

    public void ayF() {
        this.mNavigationBar = (NavigationBar) this.hrt.findViewById(e.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.hry = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.maintab_title_layout, (View.OnClickListener) null).findViewById(e.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.hrt.getResources().getDimension(e.C0210e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.hry.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.game_tip_view, (View.OnClickListener) null);
            this.hrz = (ImageView) addCustomView.findViewById(e.g.game_button_iv);
            this.hrA = (ImageView) addCustomView.findViewById(e.g.game_tip_msg_iv);
            this.hrz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.nJ(false);
                    d.this.hrA.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, d.this.hrt.getPageContext()));
                    TiebaStatic.eventStat(d.this.hrt.getPageContext().getPageActivity(), "tb_gamecenter", AiAppsUBCStatistic.TYPE_CLICK, 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.h(this.hrt.getPageContext().getPageActivity(), e.C0210e.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.hrt.sendMessage(new CustomMessage(2015003, new IntentConfig(d.this.hrt.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new am("c10378").x("obj_type", i));
                }
            });
            this.dos = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.dos.setLayoutParams(layoutParams2);
            this.dos.setVisibility(8);
            this.dos.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.hrt.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(d.this.hrt.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.hrt.getPageContext().getPageActivity(), "notlogin_4", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    ba.bI(d.this.hrt.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.hrt.getPageContext().getPageActivity(), "notlogin_3", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    String str = "";
                    switch (d.this.fGG) {
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
                    TiebaStatic.log(new am("c10517").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
                    ba.bH(d.this.hrt.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void nH(boolean z) {
        if (z) {
            this.dos.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.dos.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void nI(boolean z) {
        if (bFG()) {
            if (z) {
                if (this.hrA.getVisibility() != 0) {
                    this.hrA.setVisibility(0);
                    nJ(true);
                    al.c(this.hrA, e.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            nJ(false);
            this.hrA.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nJ(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hrz.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.h(this.hrt.getPageContext().getPageActivity(), e.C0210e.ds32);
            } else {
                layoutParams.rightMargin = l.h(this.hrt.getPageContext().getPageActivity(), e.C0210e.ds20);
            }
            this.hrz.setLayoutParams(layoutParams);
        }
    }

    public void ai(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.NP(), next.bR(this.hrt.getPageContext().getPageActivity()));
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

    public void jT(boolean z) {
        this.fGK = z;
        if (!this.fGK) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean bdl() {
        return this.fGK;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.azz = cVar.bdK;
            bVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.bdQ);
            if (cVar.bdQ == com.baidu.tbadk.mainTab.c.bdM) {
                maintabBottomIndicator.setWriteIconView(cVar.aFs, cVar.bdL);
            } else if (cVar.bdQ == com.baidu.tbadk.mainTab.c.bdP) {
                maintabBottomIndicator.setIconResourceId(cVar.aFs);
                maintabBottomIndicator.setText(cVar.aFr);
                maintabBottomIndicator.setAnimationResId(cVar.nk);
                this.hrF = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.aFs);
                maintabBottomIndicator.setText(cVar.aFr);
                maintabBottomIndicator.setAnimationResId(cVar.nk);
            }
            tbFragmentTabIndicator.eC(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.azy = maintabBottomIndicator;
            bVar2.azA = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    public FragmentTabHost aCo() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator bFI() {
        return this.hrF;
    }

    public void bFJ() {
        if (this.mTabHost != null) {
            if ((this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.mTabHost.getCurrentTabType() != 1) {
                if (this.dos != null) {
                    this.dos.setVisibility(8);
                }
                if (this.mSearchButton != null && this.mTabHost.getCurrentTabType() != 3) {
                    this.mSearchButton.setVisibility(0);
                }
            }
        }
    }

    public void bFK() {
        this.mHandler.removeCallbacks(this.eeg);
        this.mHandler.removeCallbacks(this.eeh);
        g.a(this.hrD);
    }

    public void wf(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hrt.getActivity());
        aVar.eB(str);
        aVar.a(e.j.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                am amVar = new am("c12137");
                amVar.aA("obj_locate", "1");
                TiebaStatic.log(amVar);
                aVar2.dismiss();
            }
        });
        aVar.b(e.j.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                am amVar = new am("c12137");
                amVar.aA("obj_locate", "2");
                TiebaStatic.log(amVar);
                aVar2.dismiss();
                com.baidu.tieba.i.a.aJG();
            }
        });
        aVar.b(this.hrt.getPageContext()).BF();
    }

    public void onDestroy() {
        bFF();
        if (aCo() != null) {
            aCo().reset();
        }
        bFK();
        if (this.dZG != null) {
            this.dZG.onDestroy();
        }
        if (this.dKn != null) {
            this.dKn.aDd();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ao.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.hrt).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dZG == null) {
            this.dZG = new com.baidu.tieba.c.f(this.hrt.getPageContext(), (NavigationBarCoverTip) this.hrt.findViewById(e.g.navigation_cover_tip));
        }
        this.dZG.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.dKn == null) {
                this.dKn = new f(this.hrt, this.hrt.getActivityRootView());
            }
            this.dKn.h(postWriteCallBackData);
        }
    }
}
