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
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e {
    private ImageView cSy;
    private f dDk;
    private com.baidu.tieba.video.f doA;
    private boolean fjv;
    private TextView gTA;
    private PopupWindow gTC;
    private MaintabBottomIndicator gTE;
    private Runnable gTG;
    private MainTabActivity gTs;
    private TextView gTx;
    private ImageView gTy;
    private ImageView gTz;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean gTB = false;
    private int fjr = -1;
    private boolean gTD = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.a gTF = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.e.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b cC = e.this.mTabHost.cC(i);
            if (cC.mType == 8) {
                if (e.this.gTE != null && e.this.gTE.getAnimationView() != null && e.this.gTE.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new an("c10605").r("obj_type", 1));
                } else {
                    TiebaStatic.log(new an("c10605").r("obj_type", 0));
                }
                if (e.this.gTE != null) {
                    e.this.gTE.Js();
                }
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
                if (bb.aU(e.this.gTs.getPageContext().getPageActivity())) {
                    e.this.gTs.ayO();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (cC.mType == 8 && !bb.aU(e.this.gTs.getActivity())) {
                if (e.this.gTE != null) {
                    e.this.gTE.Js();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else {
                if (cC.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        az.zI().a(e.this.gTs.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (cC.mType == 3 && !bb.aU(e.this.gTs.getActivity())) {
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
    private Runnable fJQ = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.3
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (e.this.mTabHost != null && e.this.gTC != null) {
                FragmentTabWidget fragmentTabWidget = e.this.mTabHost.getFragmentTabWidget();
                l.ah(e.this.gTs.getActivity());
                int f = l.f(e.this.gTs.getActivity(), f.e.ds178);
                View contentView = e.this.gTC.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b cD = e.this.mTabHost.cD(3);
                    if (cD != null && (tbFragmentTabIndicator = cD.anO) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.f(e.this.gTs.getActivity(), f.e.tbds570);
                        }
                        g.showPopupWindowAsDropDown(e.this.gTC, fragmentTabWidget, measuredWidth2, -f);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_message_tips", true);
                        e.this.gTD = true;
                        e.this.mHandler.postDelayed(e.this.fJR, TbConfig.NOTIFY_SOUND_INTERVAL);
                    }
                }
            }
        }
    };
    private Runnable fJR = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.4
        @Override // java.lang.Runnable
        public void run() {
            e.this.bym();
        }
    };
    private View.OnClickListener fJS = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.bym();
        }
    };

    public e(MainTabActivity mainTabActivity) {
        this.gTs = mainTabActivity;
    }

    public void mB(boolean z) {
        this.mTabHost = (FragmentTabHost) this.gTs.findViewById(f.g.tab_host);
        this.mTabHost.setup(this.gTs.getSupportFragmentManager());
        this.mTabHost.setOnTabSelectionListener(this.gTF);
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
                e.this.byl();
                if (e.this.mTabHost.getCurrentTabType() != e.this.mTabHost.cC(i).mType) {
                    e.this.mTabHost.setCurrentTab(i);
                }
                if (e.this.mTabHost.getCurrentTabType() != 1) {
                    e.this.cSy.setVisibility(8);
                    e.this.mSearchButton.setVisibility(0);
                }
                e.this.fjr = e.this.mTabHost.getCurrentTabType();
                e.this.byj();
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
                    TiebaStatic.log(new an("view_msg").ae("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.gTB = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        asl();
        this.gTA = (TextView) this.gTs.findViewById(f.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.gTs.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void ul(final String str) {
        if (StringUtils.isNull(str)) {
            this.gTA.setVisibility(8);
            return;
        }
        FragmentTabHost.b cD = this.mTabHost.cD(8);
        if (cD != null) {
            if (!this.gTD || (this.gTC != null && this.gTC.isShowing())) {
                if (this.gTG == null) {
                    this.gTG = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.ul(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.gTG);
                TbadkCoreApplication.getInst().handler.postDelayed(this.gTG, TbConfig.NOTIFY_SOUND_INTERVAL);
                return;
            }
            a(str, cD);
            return;
        }
        this.gTA.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.anO.getLocationInWindow(iArr);
        int width = l.o(this.gTs).widthPixels - (iArr[0] + (bVar.anO.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gTA.getLayoutParams();
        layoutParams.rightMargin = width - l.f(this.gTs.getPageContext().getPageActivity(), f.e.ds26);
        this.gTA.setLayoutParams(layoutParams);
        this.gTA.setVisibility(0);
        this.gTA.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void byh() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.gTB);
    }

    public boolean byi() {
        return this.gTy != null && this.gTy.getVisibility() == 0;
    }

    public void mC(boolean z) {
        if (this.gTy != null) {
            if (z) {
                this.gTy.setVisibility(0);
            } else {
                this.gTy.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.mTabHost.setShouldDrawTopLine(false);
            } else {
                this.mTabHost.aG(true);
            }
        }
        if (this.mTabHost.getFragmentTabWidget() != null) {
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.mTabHost.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.gTs.getPageContext(), i);
        am.a(this.gTx, f.d.cp_cont_b, f.d.s_navbar_title_color, i);
        am.c(this.gTz, f.C0146f.icon_news_down_bar_one);
        am.a(this.gTy, f.C0146f.icon_game_bg_s, f.C0146f.icon_game_bg);
        am.a(this.mSearchButton, f.C0146f.icon_search_bg_s, f.C0146f.icon_search_bg);
        am.a(this.cSy, f.C0146f.icon_sign_bg_s, f.C0146f.icon_sign_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.xZ();
            } else {
                this.mTabHost.xY();
            }
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.gTs.getPageContext().getPageActivity()).inflate(f.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(f.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(f.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            am.c(textView, f.d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.GU())) {
                textView.setText(payMemberInfoData.GU());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                am.c(tbImageView, f.C0146f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gTs.getPageContext().getPageActivity());
            aVar.w(inflate);
            aVar.cg(f.d.cp_link_tip_d);
            aVar.b(f.j.know, new a.b() { // from class: com.baidu.tieba.tblauncher.e.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(e.this.gTs.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(e.this.gTs.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.gTs.getPageContext().getString(f.j.member_continue_pay);
            if (i == 0) {
                string = this.gTs.getPageContext().getString(f.j.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.e.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(e.this.gTs.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(e.this.gTs.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(e.this.gTs.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.aw(false);
            aVar.b(this.gTs.getPageContext()).xe();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void byj() {
        FragmentTabHost.b cD;
        if (this.mTabHost != null && (cD = this.mTabHost.cD(this.mTabHost.getCurrentTabType())) != null && cD.anQ != null && cD.anQ.Jo() != null) {
            String string = this.gTs.getPageContext().getString(cD.anQ.Jo().aRJ);
            if (this.gTx != null) {
                this.gTx.setText(string);
            }
        }
    }

    public void asl() {
        this.mNavigationBar = (NavigationBar) this.gTs.findViewById(f.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.gTx = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, f.h.maintab_title_layout, (View.OnClickListener) null).findViewById(f.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.gTs.getResources().getDimension(f.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.gTx.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.game_tip_view, (View.OnClickListener) null);
            this.gTy = (ImageView) addCustomView.findViewById(f.g.game_button_iv);
            this.gTz = (ImageView) addCustomView.findViewById(f.g.game_tip_msg_iv);
            this.gTy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.mF(false);
                    e.this.gTz.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, e.this.gTs.getPageContext()));
                    TiebaStatic.eventStat(e.this.gTs.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.f(this.gTs.getPageContext().getPageActivity(), f.e.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    e.this.gTs.sendMessage(new CustomMessage(2015003, new IntentConfig(e.this.gTs.getPageContext().getPageActivity())));
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
            this.cSy = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.cSy.setLayoutParams(layoutParams2);
            this.cSy.setVisibility(8);
            this.cSy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        e.this.gTs.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(e.this.gTs.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.gTs.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bb.aT(e.this.gTs.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.gTs.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (e.this.fjr) {
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
                    TiebaStatic.log(new an("c10517").ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
                    bb.aS(e.this.gTs.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void mD(boolean z) {
        if (z) {
            this.cSy.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.cSy.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void mE(boolean z) {
        if (byi()) {
            if (z) {
                if (this.gTz.getVisibility() != 0) {
                    this.gTz.setVisibility(0);
                    mF(true);
                    am.c(this.gTz, f.C0146f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            mF(false);
            this.gTz.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mF(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gTy.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.f(this.gTs.getPageContext().getPageActivity(), f.e.ds32);
            } else {
                layoutParams.rightMargin = l.f(this.gTs.getPageContext().getPageActivity(), f.e.ds20);
            }
            this.gTy.setLayoutParams(layoutParams);
        }
    }

    public void aj(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Jo(), next.bd(this.gTs.getPageContext().getPageActivity()));
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
        this.fjv = z;
        if (!this.fjv) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aWx() {
        return this.fjv;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.anP = cVar.aRI;
            bVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.aRQ);
            if (cVar.aRQ == com.baidu.tbadk.mainTab.c.aRM) {
                maintabBottomIndicator.setWriteIconView(cVar.aRK, cVar.aRL);
            } else if (cVar.aRQ == com.baidu.tbadk.mainTab.c.aRP) {
                maintabBottomIndicator.setIconResourceId(cVar.aRK);
                maintabBottomIndicator.setText(cVar.aRJ);
                maintabBottomIndicator.setAnimationResId(cVar.jU);
                this.gTE = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.aRK);
                maintabBottomIndicator.setText(cVar.aRJ);
                maintabBottomIndicator.setAnimationResId(cVar.jU);
            }
            tbFragmentTabIndicator.dF(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.anO = maintabBottomIndicator;
            bVar2.anQ = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    public FragmentTabHost ayR() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator byk() {
        return this.gTE;
    }

    public void byl() {
        if (this.mTabHost != null) {
            if ((this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.mTabHost.getCurrentTabType() != 1) {
                if (this.cSy != null) {
                    this.cSy.setVisibility(8);
                }
                if (this.mSearchButton != null && this.mTabHost.getCurrentTabType() != 3) {
                    this.mSearchButton.setVisibility(0);
                }
            }
        }
    }

    public void bym() {
        this.mHandler.removeCallbacks(this.fJQ);
        this.mHandler.removeCallbacks(this.fJR);
        g.a(this.gTC);
    }

    public void um(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gTs.getActivity());
        aVar.dB(str);
        aVar.a(f.j.close, new a.b() { // from class: com.baidu.tieba.tblauncher.e.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                an anVar = new an("c12137");
                anVar.ae("obj_locate", "1");
                TiebaStatic.log(anVar);
                aVar2.dismiss();
            }
        });
        aVar.b(f.j.check, new a.b() { // from class: com.baidu.tieba.tblauncher.e.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                an anVar = new an("c12137");
                anVar.ae("obj_locate", "2");
                TiebaStatic.log(anVar);
                aVar2.dismiss();
                com.baidu.tieba.i.a.aCM();
            }
        });
        aVar.b(this.gTs.getPageContext()).xe();
    }

    public void onDestroy() {
        byh();
        if (ayR() != null) {
            ayR().reset();
        }
        bym();
        if (this.dDk != null) {
            this.dDk.onDestroy();
        }
        if (this.doA != null) {
            this.doA.awr();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ap.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.gTs).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dDk == null) {
            this.dDk = new com.baidu.tieba.c.f(this.gTs.getPageContext(), (NavigationBarCoverTip) this.gTs.findViewById(f.g.navigation_cover_tip));
        }
        this.dDk.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.doA == null) {
                this.doA = new com.baidu.tieba.video.f(this.gTs, this.gTs.getActivityRootView());
            }
            this.doA.h(postWriteCallBackData);
        }
    }
}
