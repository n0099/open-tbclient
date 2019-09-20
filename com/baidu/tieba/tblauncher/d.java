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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
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
    private ImageView eZJ;
    private f fOv;
    private com.baidu.tieba.video.f fyB;
    private boolean hAR;
    private MainTabActivity joS;
    private TextView joW;
    private ImageView joX;
    private ImageView joY;
    private TextView joZ;
    private PopupWindow jpb;
    private MaintabBottomIndicator jpd;
    private MaintabBottomIndicator jpe;
    private Runnable jpk;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean jpa = false;
    private int hAN = -1;
    private boolean jpc = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean jpf = true;
    private int jpg = 1;
    private boolean jph = false;
    private FragmentTabHost.a jpi = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b hT = d.this.mTabHost.hT(i);
            if (hT.mType == 8) {
                if (d.this.jpd != null && d.this.jpd.getAnimationView() != null && d.this.jpd.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new an("c10605").P("obj_type", 1));
                } else {
                    TiebaStatic.log(new an("c10605").P("obj_type", 0));
                }
                if (d.this.jpd != null) {
                    d.this.jpd.aqA();
                }
            } else if (hT.mType == 3) {
                TiebaStatic.log(new an("c12044").P("obj_locate", 1));
                TiebaStatic.log(new an("c12924").P("obj_locate", 1));
            }
            if (hT.mType == 2) {
                if (d.this.jpf) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.jpf = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.jpg != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.jpg == 1) {
                        d.this.jpe.fx(d.this.jpf);
                    }
                } else {
                    d.this.jpe.aun();
                }
                d.this.jph = false;
            } else {
                d.this.jph = true;
                d.this.jpf = false;
                d.this.jpe.fx(d.this.jpf);
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
                if (bc.cF(d.this.joS.getPageContext().getPageActivity())) {
                    d.this.joS.bos();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (hT.mType == 8 && !bc.cF(d.this.joS.getActivity())) {
                if (d.this.jpd != null) {
                    d.this.jpd.aqA();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else {
                if (hT.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ba.ajK().a(d.this.joS.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (hT.mType == 3 && !bc.cF(d.this.joS.getActivity())) {
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
    private CustomMessageListener jpj = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.csJ() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.jph = true;
                        d.this.jpf = true;
                        if (d.this.jpg != 2) {
                            if (d.this.jpe.isAnimating()) {
                                d.this.jpe.fx(d.this.jpf);
                                return;
                            }
                            return;
                        }
                        d.this.csJ().aup();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.jph = false;
                        if (d.this.jpg == 1) {
                            return;
                        }
                    } else {
                        d.this.jpg = intValue;
                    }
                    if (d.this.jpg == 1) {
                        d.this.csJ().fx(d.this.jpf);
                    } else if (d.this.jpg == 2) {
                        d.this.csJ().aun();
                    } else if (intValue == 5) {
                        d.this.jpg = 1;
                        d.this.jpf = true;
                        if (!d.this.jph) {
                            d.this.csJ().aup();
                        }
                    } else {
                        d.this.csJ().auo();
                    }
                }
            }
        }
    };
    private CustomMessageListener dIe = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.jpf = true;
        }
    };
    private Runnable fUV = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.jpb != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.af(d.this.joS.getActivity());
                int g = l.g(d.this.joS.getActivity(), R.dimen.ds178);
                View contentView = d.this.jpb.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b hU = d.this.mTabHost.hU(3);
                    if (hU != null && (tbFragmentTabIndicator = hU.bRq) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.g(d.this.joS.getActivity(), R.dimen.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.jpb, fragmentTabWidget, measuredWidth2, -g);
                        com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("show_maintab_last_message_tips", true);
                        d.this.jpc = true;
                        d.this.mHandler.postDelayed(d.this.fUW, 5000L);
                    }
                }
            }
        }
    };
    private Runnable fUW = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            d.this.csL();
        }
    };
    private View.OnClickListener fUX = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.csL();
        }
    };

    public d(MainTabActivity mainTabActivity) {
        this.joS = mainTabActivity;
    }

    public void rq(boolean z) {
        this.mTabHost = (FragmentTabHost) this.joS.findViewById(R.id.tab_host);
        this.mTabHost.setUIType(1);
        this.mTabHost.setup(this.joS.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.jpi);
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
                d.this.csK();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.hT(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.eZJ.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                d.this.hAN = d.this.mTabHost.getCurrentTabType();
                d.this.csH();
                if (com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("enter_forum_edit_mode", false)) {
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
        this.jpa = com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("has_show_message_tab_tips", false);
        aJX();
        this.joZ = (TextView) this.joS.findViewById(R.id.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.joS.getPageContext()));
        switchNaviBarStatus(z);
        this.joS.registerListener(this.jpj);
        this.joS.registerListener(this.dIe);
    }

    public void FK(final String str) {
        if (StringUtils.isNull(str)) {
            this.joZ.setVisibility(8);
            return;
        }
        FragmentTabHost.b hU = this.mTabHost.hU(8);
        if (hU != null) {
            if (!this.jpc || (this.jpb != null && this.jpb.isShowing())) {
                if (this.jpk == null) {
                    this.jpk = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.13
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.FK(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.jpk);
                TbadkCoreApplication.getInst().handler.postDelayed(this.jpk, 5000L);
                return;
            }
            a(str, hU);
            return;
        }
        this.joZ.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.bRq.getLocationInWindow(iArr);
        int width = l.v(this.joS).widthPixels - (iArr[0] + (bVar.bRq.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.joZ.getLayoutParams();
        layoutParams.rightMargin = width - l.g(this.joS.getPageContext().getPageActivity(), R.dimen.ds26);
        this.joZ.setLayoutParams(layoutParams);
        this.joZ.setVisibility(0);
        this.joZ.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void csF() {
        com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("has_show_message_tab_tips", this.jpa);
    }

    public boolean csG() {
        return this.joX != null && this.joX.getVisibility() == 0;
    }

    public void rr(boolean z) {
        if (this.joX != null) {
            if (z) {
                this.joX.setVisibility(0);
            } else {
                this.joX.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.joS.getPageContext(), i);
        am.c(this.joW, R.color.cp_cont_b, R.color.s_navbar_title_color, i);
        am.c(this.joY, (int) R.drawable.icon_news_down_bar_one);
        am.a(this.joX, (int) R.drawable.icon_game_bg_s, (int) R.drawable.icon_game_bg);
        SvgManager.ajv().a(this.mSearchButton, R.drawable.icon_pure_topbar_search_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.ajv().a(this.eZJ, R.drawable.icon_pure_topbar_sign_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.ahY();
            } else {
                this.mTabHost.ahX();
            }
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.joS.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            am.f(textView, R.color.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.arJ())) {
                textView.setText(payMemberInfoData.arJ());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                am.c(tbImageView, (int) R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.joS.getPageContext().getPageActivity());
            aVar.aH(inflate);
            aVar.hw(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.joS.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.joS.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.joS.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.joS.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.joS.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.joS.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.joS.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.dR(false);
            aVar.b(this.joS.getPageContext()).agO();
            com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("show_member_deid_line", false);
        }
    }

    public void csH() {
        FragmentTabHost.b hU;
        if (this.mTabHost != null && (hU = this.mTabHost.hU(this.mTabHost.getCurrentTabType())) != null && hU.bRs != null && hU.bRs.aug() != null) {
            String string = this.joS.getPageContext().getString(hU.bRs.aug().bXX);
            if (this.joW != null) {
                this.joW.setText(string);
            }
        }
    }

    public void aJX() {
        this.mNavigationBar = (NavigationBar) this.joS.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.joW = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.joS.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.joW.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.joX = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.joY = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.joX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.ru(false);
                    d.this.joY.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, d.this.joS.getPageContext()));
                    TiebaStatic.eventStat(d.this.joS.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.g(this.joS.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.joS.sendMessage(new CustomMessage(2015003, new IntentConfig(d.this.joS.getPageContext().getPageActivity())));
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
            this.eZJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.eZJ.setLayoutParams(layoutParams2);
            this.eZJ.setVisibility(8);
            this.eZJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.joS.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(d.this.joS.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.joS.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bc.cE(d.this.joS.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.joS.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.hAN) {
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
                    bc.cD(d.this.joS.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void rs(boolean z) {
        if (z) {
            this.eZJ.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.eZJ.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void rt(boolean z) {
        if (csG()) {
            if (z) {
                if (this.joY.getVisibility() != 0) {
                    this.joY.setVisibility(0);
                    ru(true);
                    am.c(this.joY, (int) R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            ru(false);
            this.joY.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ru(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.joX.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.g(this.joS.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.g(this.joS.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.joX.setLayoutParams(layoutParams);
        }
    }

    public void aq(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.aug(), next.cP(this.joS.getPageContext().getPageActivity()));
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

    public void nF(boolean z) {
        this.hAR = z;
        if (!this.hAR) {
            com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean bQy() {
        return this.hAR;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            boolean z = false;
            bVar2.bRr = cVar.cyG;
            bVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.cyM);
            if (cVar.cyM == com.baidu.tbadk.mainTab.c.cyI) {
                maintabBottomIndicator.setWriteIconView();
                z = true;
            } else if (cVar.cyM == com.baidu.tbadk.mainTab.c.cyL) {
                maintabBottomIndicator.setText(cVar.bXX);
                maintabBottomIndicator.setAnimationResId(cVar.kE);
                this.jpd = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.bXX);
                maintabBottomIndicator.setAnimationResId(cVar.kE);
            }
            if (bVar2.mType == 2) {
                this.jpe = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.jg(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.bRq = maintabBottomIndicator;
            bVar2.bRs = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost bou() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator csI() {
        return this.jpd;
    }

    public MaintabBottomIndicator csJ() {
        return this.jpe;
    }

    public void csK() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void csL() {
        this.mHandler.removeCallbacks(this.fUV);
        this.mHandler.removeCallbacks(this.fUW);
        g.a(this.jpb);
    }

    public void FL(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.joS.getActivity());
        aVar.mQ(str);
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
                com.baidu.tieba.i.a.bvw();
            }
        });
        aVar.b(this.joS.getPageContext()).agO();
    }

    public void onDestroy() {
        csF();
        if (bou() != null) {
            bou().reset();
        }
        csL();
        if (this.fOv != null) {
            this.fOv.onDestroy();
        }
        if (this.fyB != null) {
            this.fyB.bpq();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.joS).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fOv == null) {
            this.fOv = new f(this.joS.getPageContext(), (NavigationBarCoverTip) this.joS.findViewById(R.id.navigation_cover_tip));
        }
        this.fOv.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.fyB == null) {
                this.fyB = new com.baidu.tieba.video.f(this.joS, this.joS.getActivityRootView());
            }
            this.fyB.h(postWriteCallBackData);
        }
    }

    public void csM() {
        this.jpg = 1;
    }
}
