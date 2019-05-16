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
    private ImageView eSQ;
    private f fGQ;
    private com.baidu.tieba.video.f frq;
    private boolean hrN;
    private MainTabActivity jfa;
    private TextView jfe;
    private ImageView jff;
    private ImageView jfg;
    private TextView jfh;
    private PopupWindow jfj;
    private MaintabBottomIndicator jfl;
    private MaintabBottomIndicator jfm;
    private Runnable jfs;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean jfi = false;
    private int hrJ = -1;
    private boolean jfk = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean jfn = true;
    private int jfo = 1;
    private boolean jfp = false;
    private FragmentTabHost.a jfq = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b hN = d.this.mTabHost.hN(i);
            if (hN.mType == 8) {
                if (d.this.jfl != null && d.this.jfl.getAnimationView() != null && d.this.jfl.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new am("c10605").P("obj_type", 1));
                } else {
                    TiebaStatic.log(new am("c10605").P("obj_type", 0));
                }
                if (d.this.jfl != null) {
                    d.this.jfl.apg();
                }
            } else if (hN.mType == 3) {
                TiebaStatic.log(new am("c12044").P("obj_locate", 1));
                TiebaStatic.log(new am("c12924").P("obj_locate", 1));
            }
            if (hN.mType == 2) {
                if (d.this.jfn) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.jfn = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.jfo != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.jfo == 1) {
                        d.this.jfm.fq(d.this.jfn);
                    }
                } else {
                    d.this.jfm.asR();
                }
                d.this.jfp = false;
            } else {
                d.this.jfp = true;
                d.this.jfn = false;
                d.this.jfm.fq(d.this.jfn);
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
                if (bc.cE(d.this.jfa.getPageContext().getPageActivity())) {
                    d.this.jfa.blt();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (hN.mType == 8 && !bc.cE(d.this.jfa.getActivity())) {
                if (d.this.jfl != null) {
                    d.this.jfl.apg();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else {
                if (hN.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ba.aiz().a(d.this.jfa.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (hN.mType == 3 && !bc.cE(d.this.jfa.getActivity())) {
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
    private CustomMessageListener jfr = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.coN() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.jfp = true;
                        d.this.jfn = true;
                        if (d.this.jfo != 2) {
                            if (d.this.jfm.isAnimating()) {
                                d.this.jfm.fq(d.this.jfn);
                                return;
                            }
                            return;
                        }
                        d.this.coN().asT();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.jfp = false;
                        if (d.this.jfo == 1) {
                            return;
                        }
                    } else {
                        d.this.jfo = intValue;
                    }
                    if (d.this.jfo == 1) {
                        d.this.coN().fq(d.this.jfn);
                    } else if (d.this.jfo == 2) {
                        d.this.coN().asR();
                    } else if (intValue == 5) {
                        d.this.jfo = 1;
                        d.this.jfn = true;
                        if (!d.this.jfp) {
                            d.this.coN().asT();
                        }
                    } else {
                        d.this.coN().asS();
                    }
                }
            }
        }
    };
    private CustomMessageListener dCP = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.jfn = true;
        }
    };
    private Runnable fNo = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.jfj != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.af(d.this.jfa.getActivity());
                int g = l.g(d.this.jfa.getActivity(), R.dimen.ds178);
                View contentView = d.this.jfj.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b hO = d.this.mTabHost.hO(3);
                    if (hO != null && (tbFragmentTabIndicator = hO.bPI) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.g(d.this.jfa.getActivity(), R.dimen.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.jfj, fragmentTabWidget, measuredWidth2, -g);
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_maintab_last_message_tips", true);
                        d.this.jfk = true;
                        d.this.mHandler.postDelayed(d.this.fNp, 5000L);
                    }
                }
            }
        }
    };
    private Runnable fNp = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            d.this.coP();
        }
    };
    private View.OnClickListener fNq = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.coP();
        }
    };

    public d(MainTabActivity mainTabActivity) {
        this.jfa = mainTabActivity;
    }

    public void qY(boolean z) {
        this.mTabHost = (FragmentTabHost) this.jfa.findViewById(R.id.tab_host);
        this.mTabHost.setUIType(1);
        this.mTabHost.setup(this.jfa.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.jfq);
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
                d.this.coO();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.hN(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.eSQ.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                d.this.hrJ = d.this.mTabHost.getCurrentTabType();
                d.this.coL();
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
        this.jfi = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("has_show_message_tab_tips", false);
        aHO();
        this.jfh = (TextView) this.jfa.findViewById(R.id.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.jfa.getPageContext()));
        switchNaviBarStatus(z);
        this.jfa.registerListener(this.jfr);
        this.jfa.registerListener(this.dCP);
    }

    public void Et(final String str) {
        if (StringUtils.isNull(str)) {
            this.jfh.setVisibility(8);
            return;
        }
        FragmentTabHost.b hO = this.mTabHost.hO(8);
        if (hO != null) {
            if (!this.jfk || (this.jfj != null && this.jfj.isShowing())) {
                if (this.jfs == null) {
                    this.jfs = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.13
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.Et(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.jfs);
                TbadkCoreApplication.getInst().handler.postDelayed(this.jfs, 5000L);
                return;
            }
            a(str, hO);
            return;
        }
        this.jfh.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.bPI.getLocationInWindow(iArr);
        int width = l.s(this.jfa).widthPixels - (iArr[0] + (bVar.bPI.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jfh.getLayoutParams();
        layoutParams.rightMargin = width - l.g(this.jfa.getPageContext().getPageActivity(), R.dimen.ds26);
        this.jfh.setLayoutParams(layoutParams);
        this.jfh.setVisibility(0);
        this.jfh.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void coJ() {
        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("has_show_message_tab_tips", this.jfi);
    }

    public boolean coK() {
        return this.jff != null && this.jff.getVisibility() == 0;
    }

    public void qZ(boolean z) {
        if (this.jff != null) {
            if (z) {
                this.jff.setVisibility(0);
            } else {
                this.jff.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.jfa.getPageContext(), i);
        al.b(this.jfe, (int) R.color.cp_cont_b, (int) R.color.s_navbar_title_color, i);
        al.c(this.jfg, (int) R.drawable.icon_news_down_bar_one);
        al.a(this.jff, (int) R.drawable.icon_game_bg_s, (int) R.drawable.icon_game_bg);
        al.a(this.mSearchButton, (int) R.drawable.icon_search_bg_s, (int) R.drawable.icon_search_bg);
        aq.aik().d(this.eSQ, R.drawable.ic_icon_ba_sign_n, R.color.select_topbar_icon_color_tint);
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
            View inflate = LayoutInflater.from(this.jfa.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
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
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jfa.getPageContext().getPageActivity());
            aVar.aF(inflate);
            aVar.hp(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.jfa.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.jfa.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.jfa.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.jfa.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.jfa.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.jfa.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.jfa.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.dN(false);
            aVar.b(this.jfa.getPageContext()).afG();
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_member_deid_line", false);
        }
    }

    public void coL() {
        FragmentTabHost.b hO;
        if (this.mTabHost != null && (hO = this.mTabHost.hO(this.mTabHost.getCurrentTabType())) != null && hO.bPK != null && hO.bPK.asK() != null) {
            String string = this.jfa.getPageContext().getString(hO.bPK.asK().bVV);
            if (this.jfe != null) {
                this.jfe.setText(string);
            }
        }
    }

    public void aHO() {
        this.mNavigationBar = (NavigationBar) this.jfa.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.jfe = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.jfa.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.jfe.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.jff = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.jfg = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.jff.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.rc(false);
                    d.this.jfg.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, d.this.jfa.getPageContext()));
                    TiebaStatic.eventStat(d.this.jfa.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.g(this.jfa.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.jfa.sendMessage(new CustomMessage(2015003, new IntentConfig(d.this.jfa.getPageContext().getPageActivity())));
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
            this.eSQ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.eSQ.setLayoutParams(layoutParams2);
            this.eSQ.setVisibility(8);
            this.eSQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.jfa.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(d.this.jfa.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.jfa.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bc.cD(d.this.jfa.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.jfa.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.hrJ) {
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
                    bc.cC(d.this.jfa.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void ra(boolean z) {
        if (z) {
            this.eSQ.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.eSQ.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void rb(boolean z) {
        if (coK()) {
            if (z) {
                if (this.jfg.getVisibility() != 0) {
                    this.jfg.setVisibility(0);
                    rc(true);
                    al.c(this.jfg, (int) R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            rc(false);
            this.jfg.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rc(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jff.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.g(this.jfa.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.g(this.jfa.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.jff.setLayoutParams(layoutParams);
        }
    }

    public void aq(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.asK(), next.cO(this.jfa.getPageContext().getPageActivity()));
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
        this.hrN = z;
        if (!this.hrN) {
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean bMK() {
        return this.hrN;
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
                this.jfl = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.bVV);
                maintabBottomIndicator.setAnimationResId(cVar.kF);
            }
            if (bVar2.mType == 2) {
                this.jfm = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.iW(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.bPI = maintabBottomIndicator;
            bVar2.bPK = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost blv() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator coM() {
        return this.jfl;
    }

    public MaintabBottomIndicator coN() {
        return this.jfm;
    }

    public void coO() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void coP() {
        this.mHandler.removeCallbacks(this.fNo);
        this.mHandler.removeCallbacks(this.fNp);
        g.a(this.jfj);
    }

    public void Eu(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jfa.getActivity());
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
                com.baidu.tieba.i.a.bsp();
            }
        });
        aVar.b(this.jfa.getPageContext()).afG();
    }

    public void onDestroy() {
        coJ();
        if (blv() != null) {
            blv().reset();
        }
        coP();
        if (this.fGQ != null) {
            this.fGQ.onDestroy();
        }
        if (this.frq != null) {
            this.frq.bmo();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ap.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.agM().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.jfa).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fGQ == null) {
            this.fGQ = new f(this.jfa.getPageContext(), (NavigationBarCoverTip) this.jfa.findViewById(R.id.navigation_cover_tip));
        }
        this.fGQ.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.frq == null) {
                this.frq = new com.baidu.tieba.video.f(this.jfa, this.jfa.getActivityRootView());
            }
            this.frq.h(postWriteCallBackData);
        }
    }

    public void coQ() {
        this.jfo = 1;
    }
}
