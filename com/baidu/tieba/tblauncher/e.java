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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
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
    private ImageView cSB;
    private f dDn;
    private com.baidu.tieba.video.f doC;
    private boolean fjB;
    private PopupWindow gTB;
    private Runnable gTE;
    private MainTabActivity gTr;
    private TextView gTw;
    private ImageView gTx;
    private ImageView gTy;
    private TextView gTz;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean gTA = false;
    private int fjx = -1;
    private boolean gTC = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.a gTD = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.e.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b cC = e.this.mTabHost.cC(i);
            if (cC.mType == 8) {
                TiebaStatic.log(new an("c10605"));
            } else if (cC.mType == 3) {
                TiebaStatic.log(new an("c12044").r("obj_locate", 1));
                TiebaStatic.log(new an("c12924").r("obj_locate", 1));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b cC = e.this.mTabHost.cC(i);
            if (cC.mType == 9) {
                if (ba.aV(e.this.gTr.getPageContext().getPageActivity())) {
                    e.this.gTr.ayQ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (cC.mType == 8 && !ba.aV(e.this.gTr.getActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else {
                if (cC.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ay.zK().a(e.this.gTr.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (cC.mType == 3 && !ba.aV(e.this.gTr.getActivity())) {
                    return false;
                } else {
                    if (cC.mType == 1) {
                        TiebaStatic.log(new an("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private Runnable fJX = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.3
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (e.this.mTabHost != null && e.this.gTB != null) {
                FragmentTabWidget fragmentTabWidget = e.this.mTabHost.getFragmentTabWidget();
                l.ah(e.this.gTr.getActivity());
                int f = l.f(e.this.gTr.getActivity(), d.e.ds178);
                View contentView = e.this.gTB.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b cD = e.this.mTabHost.cD(3);
                    if (cD != null && (tbFragmentTabIndicator = cD.anN) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.f(e.this.gTr.getActivity(), d.e.tbds570);
                        }
                        g.showPopupWindowAsDropDown(e.this.gTB, fragmentTabWidget, measuredWidth2, -f);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_message_tips", true);
                        e.this.gTC = true;
                        e.this.mHandler.postDelayed(e.this.fJY, TbConfig.NOTIFY_SOUND_INTERVAL);
                    }
                }
            }
        }
    };
    private Runnable fJY = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.4
        @Override // java.lang.Runnable
        public void run() {
            e.this.byk();
        }
    };
    private View.OnClickListener fJZ = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.byk();
        }
    };

    public e(MainTabActivity mainTabActivity) {
        this.gTr = mainTabActivity;
    }

    public void mB(boolean z) {
        this.mTabHost = (FragmentTabHost) this.gTr.findViewById(d.g.tab_host);
        this.mTabHost.setup(this.gTr.getSupportFragmentManager());
        this.mTabHost.setOnTabSelectionListener(this.gTD);
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
                e.this.byj();
                if (e.this.mTabHost.getCurrentTabType() != e.this.mTabHost.cC(i).mType) {
                    e.this.mTabHost.setCurrentTab(i);
                }
                if (e.this.mTabHost.getCurrentTabType() != 1) {
                    e.this.cSB.setVisibility(8);
                    e.this.mSearchButton.setVisibility(0);
                }
                e.this.fjx = e.this.mTabHost.getCurrentTabType();
                e.this.byi();
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
                    TiebaStatic.log(new an("view_msg").af("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.gTA = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        asl();
        this.gTz = (TextView) this.gTr.findViewById(d.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.gTr.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void uh(final String str) {
        if (StringUtils.isNull(str)) {
            this.gTz.setVisibility(8);
            return;
        }
        FragmentTabHost.b cD = this.mTabHost.cD(8);
        if (cD != null) {
            if (!this.gTC || (this.gTB != null && this.gTB.isShowing())) {
                if (this.gTE == null) {
                    this.gTE = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.uh(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.gTE);
                TbadkCoreApplication.getInst().handler.postDelayed(this.gTE, TbConfig.NOTIFY_SOUND_INTERVAL);
                return;
            }
            a(str, cD);
            return;
        }
        this.gTz.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.anN.getLocationInWindow(iArr);
        int width = l.p(this.gTr).widthPixels - (iArr[0] + (bVar.anN.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gTz.getLayoutParams();
        layoutParams.rightMargin = width - l.f(this.gTr.getPageContext().getPageActivity(), d.e.ds26);
        this.gTz.setLayoutParams(layoutParams);
        this.gTz.setVisibility(0);
        this.gTz.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void byg() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.gTA);
    }

    public boolean byh() {
        return this.gTx != null && this.gTx.getVisibility() == 0;
    }

    public void mC(boolean z) {
        if (this.gTx != null) {
            if (z) {
                this.gTx.setVisibility(0);
            } else {
                this.gTx.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.mTabHost.setShouldDrawTopLine(false);
            } else {
                this.mTabHost.aF(true);
            }
        }
        if (this.mTabHost.getFragmentTabWidget() != null) {
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.mTabHost.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.gTr.getPageContext(), i);
        am.a(this.gTw, d.C0140d.cp_cont_b, d.C0140d.s_navbar_title_color, i);
        am.c(this.gTy, d.f.icon_news_down_bar_one);
        am.a(this.gTx, d.f.icon_game_bg_s, d.f.icon_game_bg);
        am.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
        am.a(this.cSB, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.ya();
            } else {
                this.mTabHost.xZ();
            }
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.gTr.getPageContext().getPageActivity()).inflate(d.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            am.c(textView, d.C0140d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.GU())) {
                textView.setText(payMemberInfoData.GU());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                am.c(tbImageView, d.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gTr.getPageContext().getPageActivity());
            aVar.w(inflate);
            aVar.cg(d.C0140d.cp_link_tip_d);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.tblauncher.e.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(e.this.gTr.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(e.this.gTr.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.gTr.getPageContext().getString(d.j.member_continue_pay);
            if (i == 0) {
                string = this.gTr.getPageContext().getString(d.j.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.e.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(e.this.gTr.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(e.this.gTr.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(e.this.gTr.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.av(false);
            aVar.b(this.gTr.getPageContext()).xf();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void byi() {
        FragmentTabHost.b cD;
        if (this.mTabHost != null && (cD = this.mTabHost.cD(this.mTabHost.getCurrentTabType())) != null && cD.anP != null && cD.anP.Jo() != null) {
            String string = this.gTr.getPageContext().getString(cD.anP.Jo().aRM);
            if (this.gTw != null) {
                this.gTw.setText(string);
            }
        }
    }

    public void asl() {
        this.mNavigationBar = (NavigationBar) this.gTr.findViewById(d.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.gTw = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.gTr.getResources().getDimension(d.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.gTw.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.game_tip_view, (View.OnClickListener) null);
            this.gTx = (ImageView) addCustomView.findViewById(d.g.game_button_iv);
            this.gTy = (ImageView) addCustomView.findViewById(d.g.game_tip_msg_iv);
            this.gTx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.mF(false);
                    e.this.gTy.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, e.this.gTr.getPageContext()));
                    TiebaStatic.eventStat(e.this.gTr.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.f(this.gTr.getPageContext().getPageActivity(), d.e.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    e.this.gTr.sendMessage(new CustomMessage(2015003, new IntentConfig(e.this.gTr.getPageContext().getPageActivity())));
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
            this.cSB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.cSB.setLayoutParams(layoutParams2);
            this.cSB.setVisibility(8);
            this.cSB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        e.this.gTr.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(e.this.gTr.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.gTr.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ba.aU(e.this.gTr.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.gTr.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (e.this.fjx) {
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
                    TiebaStatic.log(new an("c10517").af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
                    ba.aT(e.this.gTr.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void mD(boolean z) {
        if (z) {
            this.cSB.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.cSB.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void mE(boolean z) {
        if (byh()) {
            if (z) {
                if (this.gTy.getVisibility() != 0) {
                    this.gTy.setVisibility(0);
                    mF(true);
                    am.c(this.gTy, d.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            mF(false);
            this.gTy.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mF(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gTx.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.f(this.gTr.getPageContext().getPageActivity(), d.e.ds32);
            } else {
                layoutParams.rightMargin = l.f(this.gTr.getPageContext().getPageActivity(), d.e.ds20);
            }
            this.gTx.setLayoutParams(layoutParams);
        }
    }

    public void aj(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Jo(), next.be(this.gTr.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.mTabHost.cA(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.cA(1);
        } else {
            this.mTabHost.cA(0);
        }
        this.mTabHost.setViewPagerScrollable(false);
    }

    public void iQ(boolean z) {
        this.fjB = z;
        if (!this.fjB) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aWB() {
        return this.fjB;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.anO = cVar.aRL;
            bVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.aRS);
            if (cVar.aRS == com.baidu.tbadk.mainTab.c.aRP) {
                maintabBottomIndicator.setWriteIconView(cVar.aRN, cVar.aRO);
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.aRN);
                maintabBottomIndicator.setText(cVar.aRM);
                maintabBottomIndicator.setAnimationResId(cVar.jT);
            }
            tbFragmentTabIndicator.dG(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.anN = maintabBottomIndicator;
            bVar2.anP = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    public FragmentTabHost ayT() {
        return this.mTabHost;
    }

    public void byj() {
        if (this.mTabHost != null) {
            if ((this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.mTabHost.getCurrentTabType() != 1) {
                if (this.cSB != null) {
                    this.cSB.setVisibility(8);
                }
                if (this.mSearchButton != null && this.mTabHost.getCurrentTabType() != 3) {
                    this.mSearchButton.setVisibility(0);
                }
            }
        }
    }

    public void byk() {
        this.mHandler.removeCallbacks(this.fJX);
        this.mHandler.removeCallbacks(this.fJY);
        g.a(this.gTB);
    }

    public void ui(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gTr.getActivity());
        aVar.dB(str);
        aVar.a(d.j.close, new a.b() { // from class: com.baidu.tieba.tblauncher.e.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                an anVar = new an("c12137");
                anVar.af("obj_locate", "1");
                TiebaStatic.log(anVar);
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.check, new a.b() { // from class: com.baidu.tieba.tblauncher.e.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                an anVar = new an("c12137");
                anVar.af("obj_locate", "2");
                TiebaStatic.log(anVar);
                aVar2.dismiss();
                com.baidu.tieba.i.a.aCP();
            }
        });
        aVar.b(this.gTr.getPageContext()).xf();
    }

    public void onDestroy() {
        byg();
        if (ayT() != null) {
            ayT().reset();
        }
        byk();
        if (this.dDn != null) {
            this.dDn.onDestroy();
        }
        if (this.doC != null) {
            this.doC.aws();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ap.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.gTr).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dDn == null) {
            this.dDn = new f(this.gTr.getPageContext(), (NavigationBarCoverTip) this.gTr.findViewById(d.g.navigation_cover_tip));
        }
        this.dDn.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.doC == null) {
                this.doC = new com.baidu.tieba.video.f(this.gTr, this.gTr.getActivityRootView());
            }
            this.doC.h(postWriteCallBackData);
        }
    }
}
