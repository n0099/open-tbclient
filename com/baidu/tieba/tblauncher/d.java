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
import com.baidu.tieba.R;
import com.baidu.tieba.c.f;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class d {
    private ImageView eSR;
    private f fGR;
    private com.baidu.tieba.video.f frr;
    private boolean hrQ;
    private MainTabActivity jfc;
    private TextView jfg;
    private ImageView jfh;
    private ImageView jfi;
    private TextView jfj;
    private PopupWindow jfl;
    private MaintabBottomIndicator jfn;
    private MaintabBottomIndicator jfo;
    private Runnable jfu;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean jfk = false;
    private int hrM = -1;
    private boolean jfm = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean jfp = true;
    private int jfq = 1;
    private boolean jfr = false;
    private FragmentTabHost.a jfs = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b hN = d.this.mTabHost.hN(i);
            if (hN.mType == 8) {
                if (d.this.jfn != null && d.this.jfn.getAnimationView() != null && d.this.jfn.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new am("c10605").P("obj_type", 1));
                } else {
                    TiebaStatic.log(new am("c10605").P("obj_type", 0));
                }
                if (d.this.jfn != null) {
                    d.this.jfn.apg();
                }
            } else if (hN.mType == 3) {
                TiebaStatic.log(new am("c12044").P("obj_locate", 1));
                TiebaStatic.log(new am("c12924").P("obj_locate", 1));
            }
            if (hN.mType == 2) {
                if (d.this.jfp) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.jfp = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.jfq != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.jfq == 1) {
                        d.this.jfo.fq(d.this.jfp);
                    }
                } else {
                    d.this.jfo.asR();
                }
                d.this.jfr = false;
            } else {
                d.this.jfr = true;
                d.this.jfp = false;
                d.this.jfo.fq(d.this.jfp);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b hN = d.this.mTabHost.hN(i);
            if (hN.mType == 9) {
                if (bc.cE(d.this.jfc.getPageContext().getPageActivity())) {
                    d.this.jfc.blw();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (hN.mType == 8 && !bc.cE(d.this.jfc.getActivity())) {
                if (d.this.jfn != null) {
                    d.this.jfn.apg();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else {
                if (hN.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ba.aiz().a(d.this.jfc.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (hN.mType == 3 && !bc.cE(d.this.jfc.getActivity())) {
                    return false;
                } else {
                    if (hN.mType == 1) {
                        TiebaStatic.log(new am("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener jft = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.coP() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.jfr = true;
                        d.this.jfp = true;
                        if (d.this.jfq != 2) {
                            if (d.this.jfo.isAnimating()) {
                                d.this.jfo.fq(d.this.jfp);
                                return;
                            }
                            return;
                        }
                        d.this.coP().asT();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.jfr = false;
                        if (d.this.jfq == 1) {
                            return;
                        }
                    } else {
                        d.this.jfq = intValue;
                    }
                    if (d.this.jfq == 1) {
                        d.this.coP().fq(d.this.jfp);
                    } else if (d.this.jfq == 2) {
                        d.this.coP().asR();
                    } else if (intValue == 5) {
                        d.this.jfq = 1;
                        d.this.jfp = true;
                        if (!d.this.jfr) {
                            d.this.coP().asT();
                        }
                    } else {
                        d.this.coP().asS();
                    }
                }
            }
        }
    };
    private CustomMessageListener dCQ = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.jfp = true;
        }
    };
    private Runnable fNp = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.jfl != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.af(d.this.jfc.getActivity());
                int g = l.g(d.this.jfc.getActivity(), R.dimen.ds178);
                View contentView = d.this.jfl.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b hO = d.this.mTabHost.hO(3);
                    if (hO != null && (tbFragmentTabIndicator = hO.bPI) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.g(d.this.jfc.getActivity(), R.dimen.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.jfl, fragmentTabWidget, measuredWidth2, -g);
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_maintab_last_message_tips", true);
                        d.this.jfm = true;
                        d.this.mHandler.postDelayed(d.this.fNq, 5000L);
                    }
                }
            }
        }
    };
    private Runnable fNq = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            d.this.coR();
        }
    };
    private View.OnClickListener fNr = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.coR();
        }
    };

    public d(MainTabActivity mainTabActivity) {
        this.jfc = mainTabActivity;
    }

    public void qY(boolean z) {
        this.mTabHost = (FragmentTabHost) this.jfc.findViewById(R.id.tab_host);
        this.mTabHost.setUIType(1);
        this.mTabHost.setup(this.jfc.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.jfs);
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
                d.this.coQ();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.hN(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.eSR.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                d.this.hrM = d.this.mTabHost.getCurrentTabType();
                d.this.coN();
                if (com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("enter_forum_edit_mode", false)) {
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (d.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new am("view_msg").bT("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.jfk = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("has_show_message_tab_tips", false);
        aHR();
        this.jfj = (TextView) this.jfc.findViewById(R.id.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.jfc.getPageContext()));
        switchNaviBarStatus(z);
        this.jfc.registerListener(this.jft);
        this.jfc.registerListener(this.dCQ);
    }

    public void Et(final String str) {
        if (StringUtils.isNull(str)) {
            this.jfj.setVisibility(8);
            return;
        }
        FragmentTabHost.b hO = this.mTabHost.hO(8);
        if (hO != null) {
            if (!this.jfm || (this.jfl != null && this.jfl.isShowing())) {
                if (this.jfu == null) {
                    this.jfu = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.13
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.Et(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.jfu);
                TbadkCoreApplication.getInst().handler.postDelayed(this.jfu, 5000L);
                return;
            }
            a(str, hO);
            return;
        }
        this.jfj.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.bPI.getLocationInWindow(iArr);
        int width = l.s(this.jfc).widthPixels - (iArr[0] + (bVar.bPI.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jfj.getLayoutParams();
        layoutParams.rightMargin = width - l.g(this.jfc.getPageContext().getPageActivity(), R.dimen.ds26);
        this.jfj.setLayoutParams(layoutParams);
        this.jfj.setVisibility(0);
        this.jfj.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void coL() {
        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("has_show_message_tab_tips", this.jfk);
    }

    public boolean coM() {
        return this.jfh != null && this.jfh.getVisibility() == 0;
    }

    public void qZ(boolean z) {
        if (this.jfh != null) {
            if (z) {
                this.jfh.setVisibility(0);
            } else {
                this.jfh.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.jfc.getPageContext(), i);
        al.b(this.jfg, (int) R.color.cp_cont_b, (int) R.color.s_navbar_title_color, i);
        al.c(this.jfi, (int) R.drawable.icon_news_down_bar_one);
        al.a(this.jfh, (int) R.drawable.icon_game_bg_s, (int) R.drawable.icon_game_bg);
        al.a(this.mSearchButton, (int) R.drawable.icon_search_bg_s, (int) R.drawable.icon_search_bg);
        aq.aik().d(this.eSR, R.drawable.ic_icon_ba_sign_n, R.color.select_topbar_icon_color_tint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.agQ();
            } else {
                this.mTabHost.agP();
            }
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.jfc.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            al.f(textView, R.color.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.aqq())) {
                textView.setText(payMemberInfoData.aqq());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                al.c(tbImageView, (int) R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jfc.getPageContext().getPageActivity());
            aVar.aF(inflate);
            aVar.hp(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.jfc.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.jfc.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.jfc.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.jfc.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.jfc.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.jfc.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.jfc.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.dN(false);
            aVar.b(this.jfc.getPageContext()).afG();
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_member_deid_line", false);
        }
    }

    public void coN() {
        FragmentTabHost.b hO;
        if (this.mTabHost != null && (hO = this.mTabHost.hO(this.mTabHost.getCurrentTabType())) != null && hO.bPK != null && hO.bPK.asK() != null) {
            String string = this.jfc.getPageContext().getString(hO.bPK.asK().bVV);
            if (this.jfg != null) {
                this.jfg.setText(string);
            }
        }
    }

    public void aHR() {
        this.mNavigationBar = (NavigationBar) this.jfc.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.jfg = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.jfc.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.jfg.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.jfh = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.jfi = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.jfh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.rc(false);
                    d.this.jfi.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, d.this.jfc.getPageContext()));
                    TiebaStatic.eventStat(d.this.jfc.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.g(this.jfc.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.jfc.sendMessage(new CustomMessage(2015003, new IntentConfig(d.this.jfc.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new am("c10378").P("obj_type", i));
                }
            });
            this.eSR = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.eSR.setLayoutParams(layoutParams2);
            this.eSR.setVisibility(8);
            this.eSR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.jfc.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(d.this.jfc.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.jfc.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bc.cD(d.this.jfc.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.jfc.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.hrM) {
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
                    TiebaStatic.log(new am("c10517").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
                    bc.cC(d.this.jfc.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void ra(boolean z) {
        if (z) {
            this.eSR.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.eSR.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void rb(boolean z) {
        if (coM()) {
            if (z) {
                if (this.jfi.getVisibility() != 0) {
                    this.jfi.setVisibility(0);
                    rc(true);
                    al.c(this.jfi, (int) R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            rc(false);
            this.jfi.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rc(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jfh.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.g(this.jfc.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.g(this.jfc.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.jfh.setLayoutParams(layoutParams);
        }
    }

    public void aq(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.asK(), next.cO(this.jfc.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.mTabHost.hL(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.hL(1);
        } else {
            this.mTabHost.hL(0);
        }
        this.mTabHost.setViewPagerScrollable(false);
    }

    public void nm(boolean z) {
        this.hrQ = z;
        if (!this.hrQ) {
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean bMN() {
        return this.hrQ;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            boolean z = false;
            bVar2.bPJ = cVar.cwn;
            bVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.cwt);
            if (cVar.cwt == com.baidu.tbadk.mainTab.c.cwp) {
                maintabBottomIndicator.setWriteIconView();
                z = true;
            } else if (cVar.cwt == com.baidu.tbadk.mainTab.c.cws) {
                maintabBottomIndicator.setText(cVar.bVV);
                maintabBottomIndicator.setAnimationResId(cVar.kF);
                this.jfn = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.bVV);
                maintabBottomIndicator.setAnimationResId(cVar.kF);
            }
            if (bVar2.mType == 2) {
                this.jfo = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.iW(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.bPI = maintabBottomIndicator;
            bVar2.bPK = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost bly() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator coO() {
        return this.jfn;
    }

    public MaintabBottomIndicator coP() {
        return this.jfo;
    }

    public void coQ() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void coR() {
        this.mHandler.removeCallbacks(this.fNp);
        this.mHandler.removeCallbacks(this.fNq);
        g.a(this.jfl);
    }

    public void Eu(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jfc.getActivity());
        aVar.mE(str);
        aVar.a(R.string.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                am amVar = new am("c12137");
                amVar.bT("obj_locate", "1");
                TiebaStatic.log(amVar);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                am amVar = new am("c12137");
                amVar.bT("obj_locate", "2");
                TiebaStatic.log(amVar);
                aVar2.dismiss();
                com.baidu.tieba.i.a.bss();
            }
        });
        aVar.b(this.jfc.getPageContext()).afG();
    }

    public void onDestroy() {
        coL();
        if (bly() != null) {
            bly().reset();
        }
        coR();
        if (this.fGR != null) {
            this.fGR.onDestroy();
        }
        if (this.frr != null) {
            this.frr.bmr();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ap.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.agM().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.jfc).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fGR == null) {
            this.fGR = new f(this.jfc.getPageContext(), (NavigationBarCoverTip) this.jfc.findViewById(R.id.navigation_cover_tip));
        }
        this.fGR.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.frr == null) {
                this.frr = new com.baidu.tieba.video.f(this.jfc, this.jfc.getActivityRootView());
            }
            this.frr.h(postWriteCallBackData);
        }
    }

    public void coS() {
        this.jfq = 1;
    }
}
