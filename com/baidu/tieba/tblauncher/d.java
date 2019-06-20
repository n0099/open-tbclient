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
    private f fGU;
    private com.baidu.tieba.video.f frr;
    private boolean hrR;
    private MainTabActivity jfg;
    private TextView jfk;
    private ImageView jfl;
    private ImageView jfm;
    private TextView jfn;
    private PopupWindow jfp;
    private MaintabBottomIndicator jfr;
    private MaintabBottomIndicator jfs;
    private Runnable jfy;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean jfo = false;
    private int hrN = -1;
    private boolean jfq = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean jft = true;
    private int jfu = 1;
    private boolean jfv = false;
    private FragmentTabHost.a jfw = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b hN = d.this.mTabHost.hN(i);
            if (hN.mType == 8) {
                if (d.this.jfr != null && d.this.jfr.getAnimationView() != null && d.this.jfr.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new am("c10605").P("obj_type", 1));
                } else {
                    TiebaStatic.log(new am("c10605").P("obj_type", 0));
                }
                if (d.this.jfr != null) {
                    d.this.jfr.apg();
                }
            } else if (hN.mType == 3) {
                TiebaStatic.log(new am("c12044").P("obj_locate", 1));
                TiebaStatic.log(new am("c12924").P("obj_locate", 1));
            }
            if (hN.mType == 2) {
                if (d.this.jft) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.jft = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.jfu != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.jfu == 1) {
                        d.this.jfs.fq(d.this.jft);
                    }
                } else {
                    d.this.jfs.asR();
                }
                d.this.jfv = false;
            } else {
                d.this.jfv = true;
                d.this.jft = false;
                d.this.jfs.fq(d.this.jft);
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
                if (bc.cE(d.this.jfg.getPageContext().getPageActivity())) {
                    d.this.jfg.blw();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (hN.mType == 8 && !bc.cE(d.this.jfg.getActivity())) {
                if (d.this.jfr != null) {
                    d.this.jfr.apg();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else {
                if (hN.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ba.aiz().a(d.this.jfg.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (hN.mType == 3 && !bc.cE(d.this.jfg.getActivity())) {
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
    private CustomMessageListener jfx = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.coQ() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.jfv = true;
                        d.this.jft = true;
                        if (d.this.jfu != 2) {
                            if (d.this.jfs.isAnimating()) {
                                d.this.jfs.fq(d.this.jft);
                                return;
                            }
                            return;
                        }
                        d.this.coQ().asT();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.jfv = false;
                        if (d.this.jfu == 1) {
                            return;
                        }
                    } else {
                        d.this.jfu = intValue;
                    }
                    if (d.this.jfu == 1) {
                        d.this.coQ().fq(d.this.jft);
                    } else if (d.this.jfu == 2) {
                        d.this.coQ().asR();
                    } else if (intValue == 5) {
                        d.this.jfu = 1;
                        d.this.jft = true;
                        if (!d.this.jfv) {
                            d.this.coQ().asT();
                        }
                    } else {
                        d.this.coQ().asS();
                    }
                }
            }
        }
    };
    private CustomMessageListener dCQ = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.jft = true;
        }
    };
    private Runnable fNr = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.jfp != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.af(d.this.jfg.getActivity());
                int g = l.g(d.this.jfg.getActivity(), R.dimen.ds178);
                View contentView = d.this.jfp.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b hO = d.this.mTabHost.hO(3);
                    if (hO != null && (tbFragmentTabIndicator = hO.bPJ) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.g(d.this.jfg.getActivity(), R.dimen.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.jfp, fragmentTabWidget, measuredWidth2, -g);
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_maintab_last_message_tips", true);
                        d.this.jfq = true;
                        d.this.mHandler.postDelayed(d.this.fNs, 5000L);
                    }
                }
            }
        }
    };
    private Runnable fNs = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            d.this.coS();
        }
    };
    private View.OnClickListener fNt = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.coS();
        }
    };

    public d(MainTabActivity mainTabActivity) {
        this.jfg = mainTabActivity;
    }

    public void qZ(boolean z) {
        this.mTabHost = (FragmentTabHost) this.jfg.findViewById(R.id.tab_host);
        this.mTabHost.setUIType(1);
        this.mTabHost.setup(this.jfg.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.jfw);
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
                d.this.coR();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.hN(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.eSR.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                d.this.hrN = d.this.mTabHost.getCurrentTabType();
                d.this.coO();
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
        this.jfo = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("has_show_message_tab_tips", false);
        aHR();
        this.jfn = (TextView) this.jfg.findViewById(R.id.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.jfg.getPageContext()));
        switchNaviBarStatus(z);
        this.jfg.registerListener(this.jfx);
        this.jfg.registerListener(this.dCQ);
    }

    public void Ev(final String str) {
        if (StringUtils.isNull(str)) {
            this.jfn.setVisibility(8);
            return;
        }
        FragmentTabHost.b hO = this.mTabHost.hO(8);
        if (hO != null) {
            if (!this.jfq || (this.jfp != null && this.jfp.isShowing())) {
                if (this.jfy == null) {
                    this.jfy = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.13
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.Ev(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.jfy);
                TbadkCoreApplication.getInst().handler.postDelayed(this.jfy, 5000L);
                return;
            }
            a(str, hO);
            return;
        }
        this.jfn.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.bPJ.getLocationInWindow(iArr);
        int width = l.s(this.jfg).widthPixels - (iArr[0] + (bVar.bPJ.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jfn.getLayoutParams();
        layoutParams.rightMargin = width - l.g(this.jfg.getPageContext().getPageActivity(), R.dimen.ds26);
        this.jfn.setLayoutParams(layoutParams);
        this.jfn.setVisibility(0);
        this.jfn.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void coM() {
        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("has_show_message_tab_tips", this.jfo);
    }

    public boolean coN() {
        return this.jfl != null && this.jfl.getVisibility() == 0;
    }

    public void ra(boolean z) {
        if (this.jfl != null) {
            if (z) {
                this.jfl.setVisibility(0);
            } else {
                this.jfl.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.jfg.getPageContext(), i);
        al.b(this.jfk, (int) R.color.cp_cont_b, (int) R.color.s_navbar_title_color, i);
        al.c(this.jfm, (int) R.drawable.icon_news_down_bar_one);
        al.a(this.jfl, (int) R.drawable.icon_game_bg_s, (int) R.drawable.icon_game_bg);
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
            View inflate = LayoutInflater.from(this.jfg.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
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
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jfg.getPageContext().getPageActivity());
            aVar.aF(inflate);
            aVar.hp(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.jfg.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.jfg.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.jfg.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.jfg.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.jfg.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.jfg.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.jfg.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.dN(false);
            aVar.b(this.jfg.getPageContext()).afG();
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_member_deid_line", false);
        }
    }

    public void coO() {
        FragmentTabHost.b hO;
        if (this.mTabHost != null && (hO = this.mTabHost.hO(this.mTabHost.getCurrentTabType())) != null && hO.bPL != null && hO.bPL.asK() != null) {
            String string = this.jfg.getPageContext().getString(hO.bPL.asK().bVW);
            if (this.jfk != null) {
                this.jfk.setText(string);
            }
        }
    }

    public void aHR() {
        this.mNavigationBar = (NavigationBar) this.jfg.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.jfk = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.jfg.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.jfk.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.jfl = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.jfm = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.jfl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.rd(false);
                    d.this.jfm.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, d.this.jfg.getPageContext()));
                    TiebaStatic.eventStat(d.this.jfg.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.g(this.jfg.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.jfg.sendMessage(new CustomMessage(2015003, new IntentConfig(d.this.jfg.getPageContext().getPageActivity())));
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
                        d.this.jfg.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(d.this.jfg.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.jfg.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bc.cD(d.this.jfg.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.jfg.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.hrN) {
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
                    bc.cC(d.this.jfg.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void rb(boolean z) {
        if (z) {
            this.eSR.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.eSR.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void rc(boolean z) {
        if (coN()) {
            if (z) {
                if (this.jfm.getVisibility() != 0) {
                    this.jfm.setVisibility(0);
                    rd(true);
                    al.c(this.jfm, (int) R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            rd(false);
            this.jfm.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rd(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jfl.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.g(this.jfg.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.g(this.jfg.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.jfl.setLayoutParams(layoutParams);
        }
    }

    public void aq(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.asK(), next.cO(this.jfg.getPageContext().getPageActivity()));
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

    public void nn(boolean z) {
        this.hrR = z;
        if (!this.hrR) {
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean bMO() {
        return this.hrR;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            boolean z = false;
            bVar2.bPK = cVar.cwo;
            bVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.cwu);
            if (cVar.cwu == com.baidu.tbadk.mainTab.c.cwq) {
                maintabBottomIndicator.setWriteIconView();
                z = true;
            } else if (cVar.cwu == com.baidu.tbadk.mainTab.c.cwt) {
                maintabBottomIndicator.setText(cVar.bVW);
                maintabBottomIndicator.setAnimationResId(cVar.kF);
                this.jfr = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.bVW);
                maintabBottomIndicator.setAnimationResId(cVar.kF);
            }
            if (bVar2.mType == 2) {
                this.jfs = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.iW(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.bPJ = maintabBottomIndicator;
            bVar2.bPL = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost bly() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator coP() {
        return this.jfr;
    }

    public MaintabBottomIndicator coQ() {
        return this.jfs;
    }

    public void coR() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void coS() {
        this.mHandler.removeCallbacks(this.fNr);
        this.mHandler.removeCallbacks(this.fNs);
        g.a(this.jfp);
    }

    public void Ew(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jfg.getActivity());
        aVar.mD(str);
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
                com.baidu.tieba.i.a.bsu();
            }
        });
        aVar.b(this.jfg.getPageContext()).afG();
    }

    public void onDestroy() {
        coM();
        if (bly() != null) {
            bly().reset();
        }
        coS();
        if (this.fGU != null) {
            this.fGU.onDestroy();
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.jfg).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fGU == null) {
            this.fGU = new f(this.jfg.getPageContext(), (NavigationBarCoverTip) this.jfg.findViewById(R.id.navigation_cover_tip));
        }
        this.fGU.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.frr == null) {
                this.frr = new com.baidu.tieba.video.f(this.jfg, this.jfg.getActivityRootView());
            }
            this.frr.h(postWriteCallBackData);
        }
    }

    public void coT() {
        this.jfu = 1;
    }
}
