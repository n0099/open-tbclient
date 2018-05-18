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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e {
    private FragmentTabHost bgO;
    private ImageView cIK;
    private com.baidu.tieba.video.e dap;
    private com.baidu.tieba.d.e dnW;
    private boolean eTZ;
    private PopupWindow gCA;
    private Runnable gCD;
    private MainTabActivity gCq;
    private TextView gCv;
    private ImageView gCw;
    private ImageView gCx;
    private TextView gCy;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private boolean gCz = false;
    private int eTV = -1;
    private boolean gCB = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.a gCC = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.e.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void i(int i, boolean z) {
            FragmentTabHost.b cx = e.this.bgO.cx(i);
            if (cx.mType == 8) {
                TiebaStatic.log(new al("c10605"));
            } else if (cx.mType == 3) {
                TiebaStatic.log(new al("c12044").r("obj_locate", 1));
                TiebaStatic.log(new al("c12924").r("obj_locate", 1));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean j(int i, boolean z) {
            FragmentTabHost.b cx = e.this.bgO.cx(i);
            if (cx.mType == 9) {
                if (az.aK(e.this.gCq.getPageContext().getPageActivity())) {
                    e.this.gCq.atw();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (cx.mType == 8 && !az.aK(e.this.gCq.getActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else {
                if (cx.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ax.wf().a(e.this.gCq.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (cx.mType == 3 && !az.aK(e.this.gCq.getActivity())) {
                    return false;
                } else {
                    if (cx.mType == 1) {
                        TiebaStatic.log(new al("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private Runnable fur = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.3
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (e.this.bgO != null && e.this.gCA != null) {
                FragmentTabWidget fragmentTabWidget = e.this.bgO.getFragmentTabWidget();
                l.af(e.this.gCq.getActivity());
                int e = l.e(e.this.gCq.getActivity(), d.e.ds178);
                View contentView = e.this.gCA.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b cy = e.this.bgO.cy(3);
                    if (cy != null && (tbFragmentTabIndicator = cy.afI) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.e(e.this.gCq.getActivity(), d.e.tbds570);
                        }
                        g.showPopupWindowAsDropDown(e.this.gCA, fragmentTabWidget, measuredWidth2, -e);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_message_tips", true);
                        e.this.gCB = true;
                        e.this.mHandler.postDelayed(e.this.fus, TbConfig.NOTIFY_SOUND_INTERVAL);
                    }
                }
            }
        }
    };
    private Runnable fus = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.4
        @Override // java.lang.Runnable
        public void run() {
            e.this.btW();
        }
    };
    private View.OnClickListener fut = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            e.this.btW();
        }
    };

    public e(MainTabActivity mainTabActivity) {
        this.gCq = mainTabActivity;
    }

    public void mz(boolean z) {
        this.bgO = (FragmentTabHost) this.gCq.findViewById(d.g.tab_host);
        this.bgO.setup(this.gCq.getSupportFragmentManager());
        this.bgO.setOnTabSelectionListener(this.gCC);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bgO.setShouldDrawIndicatorLine(false);
            this.bgO.setShouldDrawTopLine(true);
        }
        this.bgO.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bgO.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.e.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (e.this.bgO.getCurrentTabType() != 2) {
                    if (e.this.bgO.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                e.this.btU();
                if (e.this.bgO.getCurrentTabType() != e.this.bgO.cx(i).mType) {
                    e.this.bgO.setCurrentTab(i);
                }
                if (e.this.bgO.getCurrentTabType() != 1) {
                    e.this.cIK.setVisibility(8);
                    e.this.mSearchButton.setVisibility(0);
                }
                e.this.eTV = e.this.bgO.getCurrentTabType();
                e.this.btS();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (e.this.bgO.getCurrentTabType() != 3) {
                        if (e.this.bgO.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (e.this.bgO.getCurrentTabType() == 3) {
                    TiebaStatic.log(new al("view_msg").ac("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.gCz = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        ard();
        this.gCy = (TextView) this.gCq.findViewById(d.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.gCq.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void tp(final String str) {
        if (StringUtils.isNull(str)) {
            this.gCy.setVisibility(8);
            return;
        }
        FragmentTabHost.b cy = this.bgO.cy(8);
        if (cy != null) {
            if (!this.gCB || (this.gCA != null && this.gCA.isShowing())) {
                if (this.gCD == null) {
                    this.gCD = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.tp(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.gCD);
                TbadkCoreApplication.getInst().handler.postDelayed(this.gCD, TbConfig.NOTIFY_SOUND_INTERVAL);
                return;
            }
            a(str, cy);
            return;
        }
        this.gCy.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.afI.getLocationInWindow(iArr);
        int width = l.q(this.gCq).widthPixels - (iArr[0] + (bVar.afI.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gCy.getLayoutParams();
        layoutParams.rightMargin = width - l.e(this.gCq.getPageContext().getPageActivity(), d.e.ds26);
        this.gCy.setLayoutParams(layoutParams);
        this.gCy.setVisibility(0);
        this.gCy.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void btQ() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.gCz);
    }

    public boolean btR() {
        return this.gCw != null && this.gCw.getVisibility() == 0;
    }

    public void mA(boolean z) {
        if (this.gCw != null) {
            if (z) {
                this.gCw.setVisibility(0);
            } else {
                this.gCw.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bgO.setShouldDrawTopLine(false);
            } else {
                this.bgO.aB(true);
            }
        }
        if (this.bgO.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bgO.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bgO.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.gCq.getPageContext(), i);
        ak.a(this.gCv, d.C0126d.cp_cont_b, d.C0126d.s_navbar_title_color, i);
        ak.c(this.gCx, d.f.icon_news_down_bar_one);
        ak.a(this.gCw, d.f.icon_game_bg_s, d.f.icon_game_bg);
        ak.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
        ak.a(this.cIK, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.bgO != null) {
            if (z) {
                this.bgO.ux();
            } else {
                this.bgO.uw();
            }
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.gCq.getPageContext().getPageActivity()).inflate(d.i.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            ak.c(textView, d.C0126d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.Dd())) {
                textView.setText(payMemberInfoData.Dd());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ak.c(tbImageView, d.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gCq.getPageContext().getPageActivity());
            aVar.w(inflate);
            aVar.cb(d.C0126d.cp_link_tip_d);
            aVar.b(d.k.know, new a.b() { // from class: com.baidu.tieba.tblauncher.e.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(e.this.gCq.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(e.this.gCq.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.gCq.getPageContext().getString(d.k.member_continue_pay);
            if (i == 0) {
                string = this.gCq.getPageContext().getString(d.k.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.e.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(e.this.gCq.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(e.this.gCq.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(e.this.gCq.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.as(false);
            aVar.b(this.gCq.getPageContext()).tC();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void btS() {
        FragmentTabHost.b cy;
        if (this.bgO != null && (cy = this.bgO.cy(this.bgO.getCurrentTabType())) != null && cy.afK != null && cy.afK.Fw() != null) {
            String string = this.gCq.getPageContext().getString(cy.afK.Fw().aIo);
            if (this.gCv != null) {
                this.gCv.setText(string);
            }
        }
    }

    public void ard() {
        this.mNavigationBar = (NavigationBar) this.gCq.findViewById(d.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.gCv = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.gCq.getResources().getDimension(d.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.gCv.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.game_tip_view, (View.OnClickListener) null);
            this.gCw = (ImageView) addCustomView.findViewById(d.g.game_button_iv);
            this.gCx = (ImageView) addCustomView.findViewById(d.g.game_tip_msg_iv);
            this.gCw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.mD(false);
                    e.this.gCx.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, e.this.gCq.getPageContext()));
                    TiebaStatic.eventStat(e.this.gCq.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.e(this.gCq.getPageContext().getPageActivity(), d.e.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    int i = 3;
                    e.this.gCq.sendMessage(new CustomMessage(2015003, new IntentConfig(e.this.gCq.getPageContext().getPageActivity())));
                    if (e.this.bgO.getCurrentTabType() != 3) {
                        if (e.this.bgO.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new al("c10378").r("obj_type", i));
                }
            });
            this.cIK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_signall, (View.OnClickListener) null);
            this.cIK.setLayoutParams(layoutParams2);
            this.cIK.setVisibility(8);
            this.cIK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        e.this.gCq.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(e.this.gCq.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.gCq.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    az.aJ(e.this.gCq.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.gCq.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (e.this.eTV) {
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
                    TiebaStatic.log(new al("c10517").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
                    az.aI(e.this.gCq.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void mB(boolean z) {
        if (z) {
            this.cIK.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.cIK.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void mC(boolean z) {
        if (btR()) {
            if (z) {
                if (this.gCx.getVisibility() != 0) {
                    this.gCx.setVisibility(0);
                    mD(true);
                    ak.c(this.gCx, d.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            mD(false);
            this.gCx.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gCw.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.e(this.gCq.getPageContext().getPageActivity(), d.e.ds32);
            } else {
                layoutParams.rightMargin = l.e(this.gCq.getPageContext().getPageActivity(), d.e.ds20);
            }
            this.gCw.setLayoutParams(layoutParams);
        }
    }

    public void ah(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bgO.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Fw(), next.aT(this.gCq.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.bgO.cv(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bgO.cv(1);
        } else {
            this.bgO.cv(0);
        }
        this.bgO.setViewPagerScrollable(false);
    }

    public void iP(boolean z) {
        this.eTZ = z;
        if (!this.eTZ) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aSC() {
        return this.eTZ;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.afJ = cVar.aIn;
            bVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.aIv);
            if (cVar.aIv == com.baidu.tbadk.mainTab.c.aIs) {
                maintabBottomIndicator.setWriteIconView(cVar.aIp, cVar.aIq);
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.aIp);
                maintabBottomIndicator.setText(cVar.aIo);
                maintabBottomIndicator.setAnimationResId(cVar.aIr);
            }
            tbFragmentTabIndicator.dA(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.afI = maintabBottomIndicator;
            bVar2.afK = bVar;
            this.bgO.a(bVar2);
        }
    }

    public FragmentTabHost btT() {
        return this.bgO;
    }

    public void btU() {
        if (this.bgO != null) {
            if ((this.bgO.getCurrentTabType() == 8 || this.bgO.getCurrentTabType() == 3 || this.bgO.getCurrentTabType() == 2 || this.bgO.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.bgO.getCurrentTabType() != 1) {
                if (this.cIK != null) {
                    this.cIK.setVisibility(8);
                }
                if (this.mSearchButton != null && this.bgO.getCurrentTabType() != 3) {
                    this.mSearchButton.setVisibility(0);
                }
            }
        }
    }

    public boolean btV() {
        if (this.gCB) {
            return false;
        }
        this.gCB = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_last_message_tips", false);
        if (this.gCB) {
            return false;
        }
        View inflate = LayoutInflater.from(this.gCq.getActivity()).inflate(d.i.tips_blue_center_down, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.tips);
        textView.setText(d.k.maintab_message_tips);
        textView.setOnClickListener(this.fut);
        this.gCA = new PopupWindow(inflate, -2, -2);
        this.mHandler.postDelayed(this.fur, 1000L);
        return true;
    }

    public void btW() {
        this.mHandler.removeCallbacks(this.fur);
        this.mHandler.removeCallbacks(this.fus);
        g.a(this.gCA);
    }

    public void tq(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gCq.getActivity());
        aVar.dc(str);
        aVar.a(d.k.close, new a.b() { // from class: com.baidu.tieba.tblauncher.e.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                al alVar = new al("c12137");
                alVar.ac("obj_locate", "1");
                TiebaStatic.log(alVar);
                aVar2.dismiss();
            }
        });
        aVar.b(d.k.check, new a.b() { // from class: com.baidu.tieba.tblauncher.e.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                al alVar = new al("c12137");
                alVar.ac("obj_locate", "2");
                TiebaStatic.log(alVar);
                aVar2.dismiss();
                com.baidu.tieba.i.a.awI();
            }
        });
        aVar.b(this.gCq.getPageContext()).tC();
    }

    public void onDestroy() {
        btQ();
        if (btT() != null) {
            btT().reset();
        }
        btW();
        if (this.dnW != null) {
            this.dnW.onDestroy();
        }
        if (this.dap != null) {
            this.dap.arf();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || an.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.gCq).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dnW == null) {
            this.dnW = new com.baidu.tieba.d.e(this.gCq.getPageContext(), (NavigationBarCoverTip) this.gCq.findViewById(d.g.navigation_cover_tip));
        }
        this.dnW.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.dap == null) {
                this.dap = new com.baidu.tieba.video.e(this.gCq, this.gCq.pU());
            }
            this.dap.h(postWriteCallBackData);
        }
    }
}
