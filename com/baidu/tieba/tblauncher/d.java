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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.c.f;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class d {
    private ImageView eYd;
    private f fMG;
    private com.baidu.tieba.video.f fwO;
    private boolean hyV;
    private TextView jmB;
    private ImageView jmC;
    private ImageView jmD;
    private TextView jmE;
    private PopupWindow jmG;
    private MaintabBottomIndicator jmI;
    private MaintabBottomIndicator jmJ;
    private Runnable jmP;
    private MainTabActivity jmx;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean jmF = false;
    private int hyR = -1;
    private boolean jmH = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean jmK = true;
    private int jmL = 1;
    private boolean jmM = false;
    private FragmentTabHost.a jmN = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b hT = d.this.mTabHost.hT(i);
            if (hT.mType == 8) {
                if (d.this.jmI != null && d.this.jmI.getAnimationView() != null && d.this.jmI.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new an("c10605").P("obj_type", 1));
                } else {
                    TiebaStatic.log(new an("c10605").P("obj_type", 0));
                }
                if (d.this.jmI != null) {
                    d.this.jmI.aqo();
                }
            } else if (hT.mType == 3) {
                TiebaStatic.log(new an("c12044").P("obj_locate", 1));
                TiebaStatic.log(new an("c12924").P("obj_locate", 1));
            }
            if (hT.mType == 2) {
                if (d.this.jmK) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.jmK = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.jmL != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.jmL == 1) {
                        d.this.jmJ.fu(d.this.jmK);
                    }
                } else {
                    d.this.jmJ.aub();
                }
                d.this.jmM = false;
            } else {
                d.this.jmM = true;
                d.this.jmK = false;
                d.this.jmJ.fu(d.this.jmK);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b hT = d.this.mTabHost.hT(i);
            if (hT.mType == 9) {
                if (bd.cF(d.this.jmx.getPageContext().getPageActivity())) {
                    d.this.jmx.bnH();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (hT.mType == 8 && !bd.cF(d.this.jmx.getActivity())) {
                if (d.this.jmI != null) {
                    d.this.jmI.aqo();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else {
                if (hT.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        bb.ajE().a(d.this.jmx.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (hT.mType == 3 && !bd.cF(d.this.jmx.getActivity())) {
                    return false;
                } else {
                    if (hT.mType == 1) {
                        TiebaStatic.log(new an("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener jmO = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.crV() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.jmM = true;
                        d.this.jmK = true;
                        if (d.this.jmL != 2) {
                            if (d.this.jmJ.isAnimating()) {
                                d.this.jmJ.fu(d.this.jmK);
                                return;
                            }
                            return;
                        }
                        d.this.crV().aud();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.jmM = false;
                        if (d.this.jmL == 1) {
                            return;
                        }
                    } else {
                        d.this.jmL = intValue;
                    }
                    if (d.this.jmL == 1) {
                        d.this.crV().fu(d.this.jmK);
                    } else if (d.this.jmL == 2) {
                        d.this.crV().aub();
                    } else if (intValue == 5) {
                        d.this.jmL = 1;
                        d.this.jmK = true;
                        if (!d.this.jmM) {
                            d.this.crV().aud();
                        }
                    } else {
                        d.this.crV().auc();
                    }
                }
            }
        }
    };
    private CustomMessageListener dGt = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.jmK = true;
        }
    };
    private Runnable fTe = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.jmG != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.af(d.this.jmx.getActivity());
                int g = l.g(d.this.jmx.getActivity(), R.dimen.ds178);
                View contentView = d.this.jmG.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b hU = d.this.mTabHost.hU(3);
                    if (hU != null && (tbFragmentTabIndicator = hU.bQP) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.g(d.this.jmx.getActivity(), R.dimen.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.jmG, fragmentTabWidget, measuredWidth2, -g);
                        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("show_maintab_last_message_tips", true);
                        d.this.jmH = true;
                        d.this.mHandler.postDelayed(d.this.fTf, 5000L);
                    }
                }
            }
        }
    };
    private Runnable fTf = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            d.this.crX();
        }
    };
    private View.OnClickListener fTg = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.crX();
        }
    };

    public d(MainTabActivity mainTabActivity) {
        this.jmx = mainTabActivity;
    }

    public void rn(boolean z) {
        this.mTabHost = (FragmentTabHost) this.jmx.findViewById(R.id.tab_host);
        this.mTabHost.setUIType(1);
        this.mTabHost.setup(this.jmx.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.jmN);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.setShouldDrawIndicatorLine(false);
            this.mTabHost.setShouldDrawTopLine(true);
        }
        this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight() + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds73));
        this.mTabHost.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.d.12
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (d.this.mTabHost.getCurrentTabType() != 2) {
                    if (d.this.mTabHost.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                d.this.crW();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.hT(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.eYd.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                d.this.hyR = d.this.mTabHost.getCurrentTabType();
                d.this.crT();
                if (com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("enter_forum_edit_mode", false)) {
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (d.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new an("view_msg").bT("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.jmF = com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("has_show_message_tab_tips", false);
        aJt();
        this.jmE = (TextView) this.jmx.findViewById(R.id.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.jmx.getPageContext()));
        switchNaviBarStatus(z);
        this.jmx.registerListener(this.jmO);
        this.jmx.registerListener(this.dGt);
    }

    public void Fk(final String str) {
        if (StringUtils.isNull(str)) {
            this.jmE.setVisibility(8);
            return;
        }
        FragmentTabHost.b hU = this.mTabHost.hU(8);
        if (hU != null) {
            if (!this.jmH || (this.jmG != null && this.jmG.isShowing())) {
                if (this.jmP == null) {
                    this.jmP = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.13
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.Fk(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.jmP);
                TbadkCoreApplication.getInst().handler.postDelayed(this.jmP, 5000L);
                return;
            }
            a(str, hU);
            return;
        }
        this.jmE.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.bQP.getLocationInWindow(iArr);
        int width = l.v(this.jmx).widthPixels - (iArr[0] + (bVar.bQP.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jmE.getLayoutParams();
        layoutParams.rightMargin = width - l.g(this.jmx.getPageContext().getPageActivity(), R.dimen.ds26);
        this.jmE.setLayoutParams(layoutParams);
        this.jmE.setVisibility(0);
        this.jmE.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void crR() {
        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("has_show_message_tab_tips", this.jmF);
    }

    public boolean crS() {
        return this.jmC != null && this.jmC.getVisibility() == 0;
    }

    public void ro(boolean z) {
        if (this.jmC != null) {
            if (z) {
                this.jmC.setVisibility(0);
            } else {
                this.jmC.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.jmx.getPageContext(), i);
        am.c(this.jmB, R.color.cp_cont_b, R.color.s_navbar_title_color, i);
        am.c(this.jmD, (int) R.drawable.icon_news_down_bar_one);
        am.a(this.jmC, (int) R.drawable.icon_game_bg_s, (int) R.drawable.icon_game_bg);
        am.a(this.mSearchButton, (int) R.drawable.icon_search_bg_s, (int) R.drawable.icon_search_bg);
        ar.ajp().d(this.eYd, R.drawable.ic_icon_ba_sign_n, R.color.select_topbar_icon_color_tint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.ahU();
            } else {
                this.mTabHost.ahT();
            }
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.jmx.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            am.f(textView, R.color.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.arx())) {
                textView.setText(payMemberInfoData.arx());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                am.c(tbImageView, (int) R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jmx.getPageContext().getPageActivity());
            aVar.aH(inflate);
            aVar.hv(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.jmx.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.jmx.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.jmx.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.jmx.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.jmx.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.jmx.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.jmx.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.dR(false);
            aVar.b(this.jmx.getPageContext()).agK();
            com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("show_member_deid_line", false);
        }
    }

    public void crT() {
        FragmentTabHost.b hU;
        if (this.mTabHost != null && (hU = this.mTabHost.hU(this.mTabHost.getCurrentTabType())) != null && hU.bQR != null && hU.bQR.atU() != null) {
            String string = this.jmx.getPageContext().getString(hU.bQR.atU().bXe);
            if (this.jmB != null) {
                this.jmB.setText(string);
            }
        }
    }

    public void aJt() {
        this.mNavigationBar = (NavigationBar) this.jmx.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.jmB = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.jmx.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.jmB.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.jmC = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.jmD = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.jmC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.rr(false);
                    d.this.jmD.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, d.this.jmx.getPageContext()));
                    TiebaStatic.eventStat(d.this.jmx.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.g(this.jmx.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.jmx.sendMessage(new CustomMessage(2015003, new IntentConfig(d.this.jmx.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new an("c10378").P("obj_type", i));
                }
            });
            this.eYd = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.eYd.setLayoutParams(layoutParams2);
            this.eYd.setVisibility(8);
            this.eYd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.jmx.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(d.this.jmx.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.jmx.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bd.cE(d.this.jmx.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.jmx.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.hyR) {
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
                    TiebaStatic.log(new an("c10517").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
                    bd.cD(d.this.jmx.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void rp(boolean z) {
        if (z) {
            this.eYd.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.eYd.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void rq(boolean z) {
        if (crS()) {
            if (z) {
                if (this.jmD.getVisibility() != 0) {
                    this.jmD.setVisibility(0);
                    rr(true);
                    am.c(this.jmD, (int) R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            rr(false);
            this.jmD.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rr(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jmC.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.g(this.jmx.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.g(this.jmx.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.jmC.setLayoutParams(layoutParams);
        }
    }

    public void aq(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.atU(), next.cP(this.jmx.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.mTabHost.hR(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.hR(1);
        } else {
            this.mTabHost.hR(0);
        }
        this.mTabHost.setViewPagerScrollable(false);
    }

    public void nB(boolean z) {
        this.hyV = z;
        if (!this.hyV) {
            com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean bPK() {
        return this.hyV;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            boolean z = false;
            bVar2.bQQ = cVar.cxK;
            bVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.cxQ);
            if (cVar.cxQ == com.baidu.tbadk.mainTab.c.cxM) {
                maintabBottomIndicator.setWriteIconView();
                z = true;
            } else if (cVar.cxQ == com.baidu.tbadk.mainTab.c.cxP) {
                maintabBottomIndicator.setText(cVar.bXe);
                maintabBottomIndicator.setAnimationResId(cVar.kE);
                this.jmI = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.bXe);
                maintabBottomIndicator.setAnimationResId(cVar.kE);
            }
            if (bVar2.mType == 2) {
                this.jmJ = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.jd(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.bQP = maintabBottomIndicator;
            bVar2.bQR = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost bnJ() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator crU() {
        return this.jmI;
    }

    public MaintabBottomIndicator crV() {
        return this.jmJ;
    }

    public void crW() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void crX() {
        this.mHandler.removeCallbacks(this.fTe);
        this.mHandler.removeCallbacks(this.fTf);
        g.a(this.jmG);
    }

    public void Fl(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jmx.getActivity());
        aVar.mO(str);
        aVar.a(R.string.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                an anVar = new an("c12137");
                anVar.bT("obj_locate", "1");
                TiebaStatic.log(anVar);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                an anVar = new an("c12137");
                anVar.bT("obj_locate", "2");
                TiebaStatic.log(anVar);
                aVar2.dismiss();
                com.baidu.tieba.i.a.buI();
            }
        });
        aVar.b(this.jmx.getPageContext()).agK();
    }

    public void onDestroy() {
        crR();
        if (bnJ() != null) {
            bnJ().reset();
        }
        crX();
        if (this.fMG != null) {
            this.fMG.onDestroy();
        }
        if (this.fwO != null) {
            this.fwO.boF();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.jmx).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fMG == null) {
            this.fMG = new f(this.jmx.getPageContext(), (NavigationBarCoverTip) this.jmx.findViewById(R.id.navigation_cover_tip));
        }
        this.fMG.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.fwO == null) {
                this.fwO = new com.baidu.tieba.video.f(this.jmx, this.jmx.getActivityRootView());
            }
            this.fwO.h(postWriteCallBackData);
        }
    }

    public void crY() {
        this.jmL = 1;
    }
}
