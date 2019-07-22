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
    private ImageView eXR;
    private f fLS;
    private com.baidu.tieba.video.f fwp;
    private boolean hyd;
    private MaintabBottomIndicator jlA;
    private MaintabBottomIndicator jlB;
    private Runnable jlH;
    private MainTabActivity jlp;
    private TextView jlt;
    private ImageView jlu;
    private ImageView jlv;
    private TextView jlw;
    private PopupWindow jly;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean jlx = false;
    private int hxZ = -1;
    private boolean jlz = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean jlC = true;
    private int jlD = 1;
    private boolean jlE = false;
    private FragmentTabHost.a jlF = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b hT = d.this.mTabHost.hT(i);
            if (hT.mType == 8) {
                if (d.this.jlA != null && d.this.jlA.getAnimationView() != null && d.this.jlA.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new an("c10605").P("obj_type", 1));
                } else {
                    TiebaStatic.log(new an("c10605").P("obj_type", 0));
                }
                if (d.this.jlA != null) {
                    d.this.jlA.aqm();
                }
            } else if (hT.mType == 3) {
                TiebaStatic.log(new an("c12044").P("obj_locate", 1));
                TiebaStatic.log(new an("c12924").P("obj_locate", 1));
            }
            if (hT.mType == 2) {
                if (d.this.jlC) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.jlC = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.jlD != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.jlD == 1) {
                        d.this.jlB.fu(d.this.jlC);
                    }
                } else {
                    d.this.jlB.atZ();
                }
                d.this.jlE = false;
            } else {
                d.this.jlE = true;
                d.this.jlC = false;
                d.this.jlB.fu(d.this.jlC);
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
                if (bd.cF(d.this.jlp.getPageContext().getPageActivity())) {
                    d.this.jlp.bnx();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (hT.mType == 8 && !bd.cF(d.this.jlp.getActivity())) {
                if (d.this.jlA != null) {
                    d.this.jlA.aqm();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else {
                if (hT.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        bb.ajC().a(d.this.jlp.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (hT.mType == 3 && !bd.cF(d.this.jlp.getActivity())) {
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
    private CustomMessageListener jlG = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.crz() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.jlE = true;
                        d.this.jlC = true;
                        if (d.this.jlD != 2) {
                            if (d.this.jlB.isAnimating()) {
                                d.this.jlB.fu(d.this.jlC);
                                return;
                            }
                            return;
                        }
                        d.this.crz().aub();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.jlE = false;
                        if (d.this.jlD == 1) {
                            return;
                        }
                    } else {
                        d.this.jlD = intValue;
                    }
                    if (d.this.jlD == 1) {
                        d.this.crz().fu(d.this.jlC);
                    } else if (d.this.jlD == 2) {
                        d.this.crz().atZ();
                    } else if (intValue == 5) {
                        d.this.jlD = 1;
                        d.this.jlC = true;
                        if (!d.this.jlE) {
                            d.this.crz().aub();
                        }
                    } else {
                        d.this.crz().aua();
                    }
                }
            }
        }
    };
    private CustomMessageListener dGm = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.jlC = true;
        }
    };
    private Runnable fSo = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.jly != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.af(d.this.jlp.getActivity());
                int g = l.g(d.this.jlp.getActivity(), R.dimen.ds178);
                View contentView = d.this.jly.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b hU = d.this.mTabHost.hU(3);
                    if (hU != null && (tbFragmentTabIndicator = hU.bQJ) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.g(d.this.jlp.getActivity(), R.dimen.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.jly, fragmentTabWidget, measuredWidth2, -g);
                        com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("show_maintab_last_message_tips", true);
                        d.this.jlz = true;
                        d.this.mHandler.postDelayed(d.this.fSp, 5000L);
                    }
                }
            }
        }
    };
    private Runnable fSp = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            d.this.crB();
        }
    };
    private View.OnClickListener fSq = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.crB();
        }
    };

    public d(MainTabActivity mainTabActivity) {
        this.jlp = mainTabActivity;
    }

    public void rm(boolean z) {
        this.mTabHost = (FragmentTabHost) this.jlp.findViewById(R.id.tab_host);
        this.mTabHost.setUIType(1);
        this.mTabHost.setup(this.jlp.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.jlF);
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
                d.this.crA();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.hT(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.eXR.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                d.this.hxZ = d.this.mTabHost.getCurrentTabType();
                d.this.crx();
                if (com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("enter_forum_edit_mode", false)) {
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
        this.jlx = com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("has_show_message_tab_tips", false);
        aJr();
        this.jlw = (TextView) this.jlp.findViewById(R.id.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.jlp.getPageContext()));
        switchNaviBarStatus(z);
        this.jlp.registerListener(this.jlG);
        this.jlp.registerListener(this.dGm);
    }

    public void Fj(final String str) {
        if (StringUtils.isNull(str)) {
            this.jlw.setVisibility(8);
            return;
        }
        FragmentTabHost.b hU = this.mTabHost.hU(8);
        if (hU != null) {
            if (!this.jlz || (this.jly != null && this.jly.isShowing())) {
                if (this.jlH == null) {
                    this.jlH = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.13
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.Fj(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.jlH);
                TbadkCoreApplication.getInst().handler.postDelayed(this.jlH, 5000L);
                return;
            }
            a(str, hU);
            return;
        }
        this.jlw.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.bQJ.getLocationInWindow(iArr);
        int width = l.v(this.jlp).widthPixels - (iArr[0] + (bVar.bQJ.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jlw.getLayoutParams();
        layoutParams.rightMargin = width - l.g(this.jlp.getPageContext().getPageActivity(), R.dimen.ds26);
        this.jlw.setLayoutParams(layoutParams);
        this.jlw.setVisibility(0);
        this.jlw.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void crv() {
        com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("has_show_message_tab_tips", this.jlx);
    }

    public boolean crw() {
        return this.jlu != null && this.jlu.getVisibility() == 0;
    }

    public void rn(boolean z) {
        if (this.jlu != null) {
            if (z) {
                this.jlu.setVisibility(0);
            } else {
                this.jlu.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.jlp.getPageContext(), i);
        am.c(this.jlt, R.color.cp_cont_b, R.color.s_navbar_title_color, i);
        am.c(this.jlv, (int) R.drawable.icon_news_down_bar_one);
        am.a(this.jlu, (int) R.drawable.icon_game_bg_s, (int) R.drawable.icon_game_bg);
        am.a(this.mSearchButton, (int) R.drawable.icon_search_bg_s, (int) R.drawable.icon_search_bg);
        ar.ajn().d(this.eXR, R.drawable.ic_icon_ba_sign_n, R.color.select_topbar_icon_color_tint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.ahS();
            } else {
                this.mTabHost.ahR();
            }
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.jlp.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            am.f(textView, R.color.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.arv())) {
                textView.setText(payMemberInfoData.arv());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                am.c(tbImageView, (int) R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jlp.getPageContext().getPageActivity());
            aVar.aH(inflate);
            aVar.hv(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.jlp.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.jlp.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.jlp.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.jlp.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.jlp.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.jlp.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.jlp.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.dR(false);
            aVar.b(this.jlp.getPageContext()).agI();
            com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("show_member_deid_line", false);
        }
    }

    public void crx() {
        FragmentTabHost.b hU;
        if (this.mTabHost != null && (hU = this.mTabHost.hU(this.mTabHost.getCurrentTabType())) != null && hU.bQL != null && hU.bQL.atS() != null) {
            String string = this.jlp.getPageContext().getString(hU.bQL.atS().bWY);
            if (this.jlt != null) {
                this.jlt.setText(string);
            }
        }
    }

    public void aJr() {
        this.mNavigationBar = (NavigationBar) this.jlp.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.jlt = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.jlp.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.jlt.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.jlu = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.jlv = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.jlu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.rq(false);
                    d.this.jlv.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, d.this.jlp.getPageContext()));
                    TiebaStatic.eventStat(d.this.jlp.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.g(this.jlp.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.jlp.sendMessage(new CustomMessage(2015003, new IntentConfig(d.this.jlp.getPageContext().getPageActivity())));
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
            this.eXR = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.eXR.setLayoutParams(layoutParams2);
            this.eXR.setVisibility(8);
            this.eXR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.jlp.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(d.this.jlp.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.jlp.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bd.cE(d.this.jlp.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.jlp.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.hxZ) {
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
                    bd.cD(d.this.jlp.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void ro(boolean z) {
        if (z) {
            this.eXR.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.eXR.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void rp(boolean z) {
        if (crw()) {
            if (z) {
                if (this.jlv.getVisibility() != 0) {
                    this.jlv.setVisibility(0);
                    rq(true);
                    am.c(this.jlv, (int) R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            rq(false);
            this.jlv.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jlu.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.g(this.jlp.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.g(this.jlp.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.jlu.setLayoutParams(layoutParams);
        }
    }

    public void aq(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.atS(), next.cP(this.jlp.getPageContext().getPageActivity()));
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
        this.hyd = z;
        if (!this.hyd) {
            com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean bPw() {
        return this.hyd;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            boolean z = false;
            bVar2.bQK = cVar.cxD;
            bVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.cxJ);
            if (cVar.cxJ == com.baidu.tbadk.mainTab.c.cxF) {
                maintabBottomIndicator.setWriteIconView();
                z = true;
            } else if (cVar.cxJ == com.baidu.tbadk.mainTab.c.cxI) {
                maintabBottomIndicator.setText(cVar.bWY);
                maintabBottomIndicator.setAnimationResId(cVar.kE);
                this.jlA = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.bWY);
                maintabBottomIndicator.setAnimationResId(cVar.kE);
            }
            if (bVar2.mType == 2) {
                this.jlB = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.jc(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.bQJ = maintabBottomIndicator;
            bVar2.bQL = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost bnz() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator cry() {
        return this.jlA;
    }

    public MaintabBottomIndicator crz() {
        return this.jlB;
    }

    public void crA() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void crB() {
        this.mHandler.removeCallbacks(this.fSo);
        this.mHandler.removeCallbacks(this.fSp);
        g.a(this.jly);
    }

    public void Fk(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jlp.getActivity());
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
                com.baidu.tieba.i.a.buv();
            }
        });
        aVar.b(this.jlp.getPageContext()).agI();
    }

    public void onDestroy() {
        crv();
        if (bnz() != null) {
            bnz().reset();
        }
        crB();
        if (this.fLS != null) {
            this.fLS.onDestroy();
        }
        if (this.fwp != null) {
            this.fwp.bos();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.jlp).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fLS == null) {
            this.fLS = new f(this.jlp.getPageContext(), (NavigationBarCoverTip) this.jlp.findViewById(R.id.navigation_cover_tip));
        }
        this.fLS.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.fwp == null) {
                this.fwp = new com.baidu.tieba.video.f(this.jlp, this.jlp.getActivityRootView());
            }
            this.fwp.h(postWriteCallBackData);
        }
    }

    public void crC() {
        this.jlD = 1;
    }
}
