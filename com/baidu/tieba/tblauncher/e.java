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
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.c.f;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e {
    private ImageView cPP;
    private f dAB;
    private com.baidu.tieba.video.e dlK;
    private boolean fjp;
    private ImageView gSA;
    private TextView gSB;
    private PopupWindow gSD;
    private Runnable gSG;
    private MainTabActivity gSt;
    private TextView gSy;
    private ImageView gSz;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean gSC = false;
    private int fjl = -1;
    private boolean gSE = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.a gSF = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.e.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b cA = e.this.mTabHost.cA(i);
            if (cA.mType == 8) {
                TiebaStatic.log(new an("c10605"));
            } else if (cA.mType == 3) {
                TiebaStatic.log(new an("c12044").r("obj_locate", 1));
                TiebaStatic.log(new an("c12924").r("obj_locate", 1));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b cA = e.this.mTabHost.cA(i);
            if (cA.mType == 9) {
                if (bb.aU(e.this.gSt.getPageContext().getPageActivity())) {
                    e.this.gSt.ayl();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (cA.mType == 8 && !bb.aU(e.this.gSt.getActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else {
                if (cA.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        az.zV().a(e.this.gSt.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (cA.mType == 3 && !bb.aU(e.this.gSt.getActivity())) {
                    return false;
                } else {
                    if (cA.mType == 1) {
                        TiebaStatic.log(new an("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private Runnable fJJ = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.3
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (e.this.mTabHost != null && e.this.gSD != null) {
                FragmentTabWidget fragmentTabWidget = e.this.mTabHost.getFragmentTabWidget();
                l.ah(e.this.gSt.getActivity());
                int e = l.e(e.this.gSt.getActivity(), d.e.ds178);
                View contentView = e.this.gSD.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b cB = e.this.mTabHost.cB(3);
                    if (cB != null && (tbFragmentTabIndicator = cB.aom) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.e(e.this.gSt.getActivity(), d.e.tbds570);
                        }
                        g.showPopupWindowAsDropDown(e.this.gSD, fragmentTabWidget, measuredWidth2, -e);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_message_tips", true);
                        e.this.gSE = true;
                        e.this.mHandler.postDelayed(e.this.fJK, TbConfig.NOTIFY_SOUND_INTERVAL);
                    }
                }
            }
        }
    };
    private Runnable fJK = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.4
        @Override // java.lang.Runnable
        public void run() {
            e.this.bzH();
        }
    };
    private View.OnClickListener fJL = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.bzH();
        }
    };

    public e(MainTabActivity mainTabActivity) {
        this.gSt = mainTabActivity;
    }

    public void mQ(boolean z) {
        this.mTabHost = (FragmentTabHost) this.gSt.findViewById(d.g.tab_host);
        this.mTabHost.setup(this.gSt.getSupportFragmentManager());
        this.mTabHost.setOnTabSelectionListener(this.gSF);
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
                e.this.bzG();
                if (e.this.mTabHost.getCurrentTabType() != e.this.mTabHost.cA(i).mType) {
                    e.this.mTabHost.setCurrentTab(i);
                }
                if (e.this.mTabHost.getCurrentTabType() != 1) {
                    e.this.cPP.setVisibility(8);
                    e.this.mSearchButton.setVisibility(0);
                }
                e.this.fjl = e.this.mTabHost.getCurrentTabType();
                e.this.bzF();
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
                    TiebaStatic.log(new an("view_msg").ah("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.gSC = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        arI();
        this.gSB = (TextView) this.gSt.findViewById(d.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.gSt.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void uj(final String str) {
        if (StringUtils.isNull(str)) {
            this.gSB.setVisibility(8);
            return;
        }
        FragmentTabHost.b cB = this.mTabHost.cB(8);
        if (cB != null) {
            if (!this.gSE || (this.gSD != null && this.gSD.isShowing())) {
                if (this.gSG == null) {
                    this.gSG = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.uj(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.gSG);
                TbadkCoreApplication.getInst().handler.postDelayed(this.gSG, TbConfig.NOTIFY_SOUND_INTERVAL);
                return;
            }
            a(str, cB);
            return;
        }
        this.gSB.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.aom.getLocationInWindow(iArr);
        int width = l.p(this.gSt).widthPixels - (iArr[0] + (bVar.aom.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gSB.getLayoutParams();
        layoutParams.rightMargin = width - l.e(this.gSt.getPageContext().getPageActivity(), d.e.ds26);
        this.gSB.setLayoutParams(layoutParams);
        this.gSB.setVisibility(0);
        this.gSB.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void bzD() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.gSC);
    }

    public boolean bzE() {
        return this.gSz != null && this.gSz.getVisibility() == 0;
    }

    public void mR(boolean z) {
        if (this.gSz != null) {
            if (z) {
                this.gSz.setVisibility(0);
            } else {
                this.gSz.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.mTabHost.setShouldDrawTopLine(false);
            } else {
                this.mTabHost.aH(true);
            }
        }
        if (this.mTabHost.getFragmentTabWidget() != null) {
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.mTabHost.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.gSt.getPageContext(), i);
        am.a(this.gSy, d.C0142d.cp_cont_b, d.C0142d.s_navbar_title_color, i);
        am.c(this.gSA, d.f.icon_news_down_bar_one);
        am.a(this.gSz, d.f.icon_game_bg_s, d.f.icon_game_bg);
        am.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
        am.a(this.cPP, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.yi();
            } else {
                this.mTabHost.yh();
            }
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.gSt.getPageContext().getPageActivity()).inflate(d.i.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            am.c(textView, d.C0142d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.GY())) {
                textView.setText(payMemberInfoData.GY());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                am.c(tbImageView, d.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gSt.getPageContext().getPageActivity());
            aVar.w(inflate);
            aVar.ce(d.C0142d.cp_link_tip_d);
            aVar.b(d.k.know, new a.b() { // from class: com.baidu.tieba.tblauncher.e.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(e.this.gSt.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(e.this.gSt.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.gSt.getPageContext().getString(d.k.member_continue_pay);
            if (i == 0) {
                string = this.gSt.getPageContext().getString(d.k.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.e.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(e.this.gSt.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(e.this.gSt.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(e.this.gSt.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.ax(false);
            aVar.b(this.gSt.getPageContext()).xn();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void bzF() {
        FragmentTabHost.b cB;
        if (this.mTabHost != null && (cB = this.mTabHost.cB(this.mTabHost.getCurrentTabType())) != null && cB.aoo != null && cB.aoo.Jt() != null) {
            String string = this.gSt.getPageContext().getString(cB.aoo.Jt().aRM);
            if (this.gSy != null) {
                this.gSy.setText(string);
            }
        }
    }

    public void arI() {
        this.mNavigationBar = (NavigationBar) this.gSt.findViewById(d.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.gSy = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.gSt.getResources().getDimension(d.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.gSy.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.game_tip_view, (View.OnClickListener) null);
            this.gSz = (ImageView) addCustomView.findViewById(d.g.game_button_iv);
            this.gSA = (ImageView) addCustomView.findViewById(d.g.game_tip_msg_iv);
            this.gSz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.mU(false);
                    e.this.gSA.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, e.this.gSt.getPageContext()));
                    TiebaStatic.eventStat(e.this.gSt.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.e(this.gSt.getPageContext().getPageActivity(), d.e.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    e.this.gSt.sendMessage(new CustomMessage(2015003, new IntentConfig(e.this.gSt.getPageContext().getPageActivity())));
                    if (e.this.mTabHost.getCurrentTabType() != 3) {
                        if (e.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new an("c10378").r("obj_type", i));
                }
            });
            this.cPP = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_signall, (View.OnClickListener) null);
            this.cPP.setLayoutParams(layoutParams2);
            this.cPP.setVisibility(8);
            this.cPP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        e.this.gSt.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(e.this.gSt.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.gSt.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bb.aT(e.this.gSt.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.gSt.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (e.this.fjl) {
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
                    TiebaStatic.log(new an("c10517").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
                    bb.aS(e.this.gSt.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void mS(boolean z) {
        if (z) {
            this.cPP.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.cPP.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void mT(boolean z) {
        if (bzE()) {
            if (z) {
                if (this.gSA.getVisibility() != 0) {
                    this.gSA.setVisibility(0);
                    mU(true);
                    am.c(this.gSA, d.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            mU(false);
            this.gSA.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mU(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gSz.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.e(this.gSt.getPageContext().getPageActivity(), d.e.ds32);
            } else {
                layoutParams.rightMargin = l.e(this.gSt.getPageContext().getPageActivity(), d.e.ds20);
            }
            this.gSz.setLayoutParams(layoutParams);
        }
    }

    public void al(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Jt(), next.bd(this.gSt.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.mTabHost.cy(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.cy(1);
        } else {
            this.mTabHost.cy(0);
        }
        this.mTabHost.setViewPagerScrollable(false);
    }

    public void je(boolean z) {
        this.fjp = z;
        if (!this.fjp) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aYf() {
        return this.fjp;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.aon = cVar.aRL;
            bVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.aRS);
            if (cVar.aRS == com.baidu.tbadk.mainTab.c.aRP) {
                maintabBottomIndicator.setWriteIconView(cVar.aRN, cVar.aRO);
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.aRN);
                maintabBottomIndicator.setText(cVar.aRM);
                maintabBottomIndicator.setAnimationResId(cVar.kc);
            }
            tbFragmentTabIndicator.dD(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.aom = maintabBottomIndicator;
            bVar2.aoo = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    public FragmentTabHost ayo() {
        return this.mTabHost;
    }

    public void bzG() {
        if (this.mTabHost != null) {
            if ((this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.mTabHost.getCurrentTabType() != 1) {
                if (this.cPP != null) {
                    this.cPP.setVisibility(8);
                }
                if (this.mSearchButton != null && this.mTabHost.getCurrentTabType() != 3) {
                    this.mSearchButton.setVisibility(0);
                }
            }
        }
    }

    public void bzH() {
        this.mHandler.removeCallbacks(this.fJJ);
        this.mHandler.removeCallbacks(this.fJK);
        g.a(this.gSD);
    }

    public void uk(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gSt.getActivity());
        aVar.dE(str);
        aVar.a(d.k.close, new a.b() { // from class: com.baidu.tieba.tblauncher.e.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                an anVar = new an("c12137");
                anVar.ah("obj_locate", "1");
                TiebaStatic.log(anVar);
                aVar2.dismiss();
            }
        });
        aVar.b(d.k.check, new a.b() { // from class: com.baidu.tieba.tblauncher.e.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                an anVar = new an("c12137");
                anVar.ah("obj_locate", "2");
                TiebaStatic.log(anVar);
                aVar2.dismiss();
                com.baidu.tieba.i.a.aCg();
            }
        });
        aVar.b(this.gSt.getPageContext()).xn();
    }

    public void onDestroy() {
        bzD();
        if (ayo() != null) {
            ayo().reset();
        }
        bzH();
        if (this.dAB != null) {
            this.dAB.onDestroy();
        }
        if (this.dlK != null) {
            this.dlK.avN();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ap.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.gSt).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dAB == null) {
            this.dAB = new f(this.gSt.getPageContext(), (NavigationBarCoverTip) this.gSt.findViewById(d.g.navigation_cover_tip));
        }
        this.dAB.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.dlK == null) {
                this.dlK = new com.baidu.tieba.video.e(this.gSt, this.gSt.getActivityRootView());
            }
            this.dlK.h(postWriteCallBackData);
        }
    }
}
