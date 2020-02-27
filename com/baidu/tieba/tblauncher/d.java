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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.c.g;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.f;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class d {
    private ImageView fVJ;
    private g gGu;
    private f gqE;
    private boolean ism;
    private MainTabActivity kmK;
    private TextView kmO;
    private ImageView kmP;
    private ImageView kmQ;
    private TextView kmR;
    private TBLottieAnimationView kmS;
    private PopupWindow kmU;
    private MaintabBottomIndicator kmW;
    private MaintabBottomIndicator kmX;
    private Runnable knd;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean kmT = false;
    private int isi = -1;
    private boolean kmV = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean dBu = true;
    private int kmY = 1;
    private boolean isInterrupt = false;
    private boolean kmZ = false;
    private FragmentTabHost.a kna = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b ko = d.this.mTabHost.ko(i);
            if (ko.mType == 8) {
                if (d.this.kmW != null && d.this.kmW.getAnimationView() != null && d.this.kmW.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new an("c10605").X("obj_type", 1));
                } else {
                    TiebaStatic.log(new an("c10605").X("obj_type", 0));
                }
                if (d.this.kmW != null) {
                    d.this.kmW.aMG();
                }
            } else if (ko.mType == 3) {
                TiebaStatic.log(new an(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).X("obj_locate", 1));
                TiebaStatic.log(new an(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).X("obj_locate", 1));
            }
            if (ko.mType == 2) {
                if (d.this.dBu) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.dBu = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.kmY != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.kmY == 1) {
                        d.this.kmX.gL(d.this.dBu);
                    }
                } else {
                    d.this.kmX.aPZ();
                }
                d.this.isInterrupt = false;
            } else {
                d.this.isInterrupt = true;
                if (d.this.dBu) {
                    d.this.kmX.gL(d.this.dBu);
                }
                d.this.dBu = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.cNe() != null) {
                d.this.cNe().dBu = d.this.dBu;
            }
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b ko = d.this.mTabHost.ko(i);
            if (ko.mType == 9) {
                if (bc.checkUpIsLogin(d.this.kmK.getPageContext().getPageActivity())) {
                    d.this.kmK.bFw();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (ko.mType == 8 && !bc.checkUpIsLogin(d.this.kmK.getActivity())) {
                if (d.this.kmW != null) {
                    d.this.kmW.aMG();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (ko.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ba.aGE().a(d.this.kmK.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (ko.mType == 3 && !bc.checkUpIsLogin(d.this.kmK.getActivity())) {
                    return false;
                } else {
                    if (ko.mType == 1) {
                        TiebaStatic.log(new an("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener knb = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.cNe() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.isInterrupt = true;
                        d.this.dBu = true;
                        if (d.this.kmY != 2) {
                            if (d.this.kmX.isAnimating()) {
                                d.this.kmX.gL(d.this.dBu);
                                return;
                            }
                            return;
                        }
                        d.this.cNe().aQb();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.isInterrupt = false;
                        if (d.this.kmY == 1) {
                            return;
                        }
                    } else {
                        d.this.kmY = intValue;
                    }
                    if (d.this.kmY == 1) {
                        d.this.cNe().gL(d.this.dBu);
                    } else if (d.this.kmY == 2) {
                        d.this.cNe().aPZ();
                    } else if (intValue == 5) {
                        d.this.kmY = 1;
                        d.this.dBu = true;
                        if (!d.this.isInterrupt) {
                            d.this.cNe().aQb();
                        }
                    } else {
                        d.this.cNe().aQa();
                    }
                    d.this.cNe().dBt = true;
                    d.this.cNe().dBv = d.this.kmY;
                    d.this.cNe().dBu = d.this.dBu;
                }
            }
        }
    };
    private CustomMessageListener knc = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.dBu = true;
            if (d.this.cNe() != null) {
                d.this.cNe().dBu = d.this.dBu;
            }
        }
    };
    private Runnable gNj = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.kmU != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.kmK.getActivity());
                int dimens = l.getDimens(d.this.kmK.getActivity(), R.dimen.ds178);
                View contentView = d.this.kmU.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b kp = d.this.mTabHost.kp(3);
                    if (kp != null && (tbFragmentTabIndicator = kp.cYg) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.kmK.getActivity(), R.dimen.tbds570);
                        }
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(d.this.kmU, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.kmV = true;
                        d.this.mHandler.postDelayed(d.this.gNk, 5000L);
                    }
                }
            }
        }
    };
    private Runnable gNk = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            d.this.cNg();
        }
    };
    private View.OnClickListener gNl = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.cNg();
        }
    };

    public d(MainTabActivity mainTabActivity) {
        this.kmK = mainTabActivity;
    }

    public void sW(boolean z) {
        this.mTabHost = (FragmentTabHost) this.kmK.findViewById(R.id.tab_host);
        this.mTabHost.setUIType(1);
        this.mTabHost.setup(this.kmK.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setTabContainerShadowShow(false);
        this.mTabHost.setBackGroundStyle(1);
        this.mTabHost.setOnTabSelectionListener(this.kna);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.setShouldDrawIndicatorLine(false);
            this.mTabHost.setShouldDrawTopLine(true);
        }
        this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight() + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds73));
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
                d.this.cNf();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.ko(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.fVJ.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                d.this.isi = d.this.mTabHost.getCurrentTabType();
                d.this.cNc();
                if (com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (d.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).cy("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.kmT = com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        bcH();
        this.kmS = (TBLottieAnimationView) this.kmK.findViewById(R.id.home_page_new_write_icon);
        if (this.kmS != null) {
            am.a(this.kmS, R.raw.lottie_use_publish_n);
        }
        this.kmR = (TextView) this.kmK.findViewById(R.id.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.kmK.getPageContext()));
        switchNaviBarStatus(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.kmK.registerListener(this.knb);
        }
        this.kmK.registerListener(this.knc);
    }

    public void Jy(final String str) {
        if (StringUtils.isNull(str)) {
            this.kmR.setVisibility(8);
            return;
        }
        FragmentTabHost.b kp = this.mTabHost.kp(8);
        if (kp != null) {
            if (!this.kmV || (this.kmU != null && this.kmU.isShowing())) {
                if (this.knd == null) {
                    this.knd = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.13
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.Jy(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.knd);
                TbadkCoreApplication.getInst().handler.postDelayed(this.knd, 5000L);
                return;
            }
            a(str, kp);
            return;
        }
        this.kmR.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.cYg.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.kmK).widthPixels - (iArr[0] + (bVar.cYg.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kmR.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.kmK.getPageContext().getPageActivity(), R.dimen.ds26);
        this.kmR.setLayoutParams(layoutParams);
        this.kmR.setVisibility(0);
        this.kmR.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void cMY() {
        com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.kmT);
    }

    public boolean cMZ() {
        return this.kmP != null && this.kmP.getVisibility() == 0;
    }

    public void sX(boolean z) {
        if (this.kmP != null) {
            if (z) {
                this.kmP.setVisibility(0);
            } else {
                this.kmP.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.kmK.getPageContext(), i);
        am.setNavbarTitleColor(this.kmO, R.color.cp_cont_b, R.color.s_navbar_title_color, i);
        am.setImageResource(this.kmQ, R.drawable.icon_news_down_bar_one);
        am.setNavbarIconSrc(this.kmP, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        SvgManager.aGA().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGA().a(this.fVJ, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.a(this.kmS, R.raw.lottie_use_publish_n);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
                cNb();
                return;
            }
            this.mTabHost.showTabWidget();
            cNa();
        }
    }

    public void cNa() {
        if (this.kmS != null) {
            this.kmS.setVisibility(0);
        }
    }

    public void cNb() {
        if (this.kmS != null) {
            this.kmS.setVisibility(8);
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.kmK.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            am.setViewTextColor(textView, R.color.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.aNL())) {
                textView.setText(payMemberInfoData.aNL());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                am.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kmK.getPageContext().getPageActivity());
            aVar.aO(inflate);
            aVar.jX(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.kmK.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.kmK.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.kmK.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.kmK.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.kmK.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.kmK.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.kmK.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.fH(false);
            aVar.b(this.kmK.getPageContext()).aEA();
            com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void cNc() {
        FragmentTabHost.b kp;
        if (this.mTabHost != null && (kp = this.mTabHost.kp(this.mTabHost.getCurrentTabType())) != null && kp.cYh != null && kp.cYh.getFragmentTabStructure() != null) {
            String string = this.kmK.getPageContext().getString(kp.cYh.getFragmentTabStructure().textResId);
            if (this.kmO != null) {
                this.kmO.setText(string);
            }
        }
    }

    public void bcH() {
        this.mNavigationBar = (NavigationBar) this.kmK.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.kmO = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.kmK.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.kmO.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.kmP = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.kmQ = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.kmP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.ta(false);
                    d.this.kmQ.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.kmK.getPageContext()));
                    TiebaStatic.eventStat(d.this.kmK.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.kmK.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.kmK.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.kmK.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new an(CommonStatisticKey.SEARCH_BAR_CLICK).X("obj_type", i));
                }
            });
            this.fVJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.fVJ.setLayoutParams(layoutParams2);
            this.fVJ.setVisibility(8);
            this.fVJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.kmK.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.kmK.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.kmK.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bc.skipToLoginActivity(d.this.kmK.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.kmK.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.isi) {
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
                            str = ConstantData.VideoLocationType.PERSON_PROFILE;
                            break;
                    }
                    TiebaStatic.log(new an("c10517").cy("obj_source", str));
                    bc.skipToRegisterActivity(d.this.kmK.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void sY(boolean z) {
        if (z) {
            this.fVJ.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.fVJ.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void sZ(boolean z) {
        if (cMZ()) {
            if (z) {
                if (this.kmQ.getVisibility() != 0) {
                    this.kmQ.setVisibility(0);
                    ta(true);
                    am.setImageResource(this.kmQ, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            ta(false);
            this.kmQ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ta(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kmP.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.kmK.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.kmK.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.kmP.setLayoutParams(layoutParams);
        }
    }

    public void aF(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.kmK.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.mTabHost.initViewPager(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.initViewPager(1);
        } else {
            this.mTabHost.initViewPager(0);
        }
        this.mTabHost.setViewPagerScrollable(false);
    }

    public void oU(boolean z) {
        this.ism = z;
        if (!this.ism) {
            com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean chs() {
        return this.ism;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            boolean z = false;
            bVar2.mContentFragment = cVar.frag;
            bVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.showIconType);
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON) {
                maintabBottomIndicator.setWriteIconView();
                cNa();
                this.kmZ = true;
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.dBm) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.kmW = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (bVar2.mType == 2) {
                this.kmX = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.cYg = maintabBottomIndicator;
            bVar2.cYh = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost bFy() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator cNd() {
        return this.kmW;
    }

    public MaintabBottomIndicator cNe() {
        return this.kmX;
    }

    public void cNf() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void cNg() {
        this.mHandler.removeCallbacks(this.gNj);
        this.mHandler.removeCallbacks(this.gNk);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.kmU);
    }

    public void Jz(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kmK.getActivity());
        aVar.sS(str);
        aVar.a(R.string.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                an anVar = new an("c12137");
                anVar.cy("obj_locate", "1");
                TiebaStatic.log(anVar);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                an anVar = new an("c12137");
                anVar.cy("obj_locate", "2");
                TiebaStatic.log(anVar);
                aVar2.dismiss();
                com.baidu.tieba.j.a.bMC();
            }
        });
        aVar.b(this.kmK.getPageContext()).aEA();
    }

    public void onDestroy() {
        cMY();
        if (bFy() != null) {
            bFy().reset();
        }
        cNg();
        if (this.gGu != null) {
            this.gGu.onDestroy();
        }
        if (this.gqE != null) {
            this.gqE.bGt();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.kmK).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.gGu == null) {
            this.gGu = new g(this.kmK.getPageContext(), (NavigationBarCoverTip) this.kmK.findViewById(R.id.navigation_cover_tip));
        }
        this.gGu.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.gqE == null) {
                this.gqE = new f(this.kmK, this.kmK.getActivityRootView());
            }
            this.gqE.h(postWriteCallBackData);
        }
    }

    public void cNh() {
        this.isInterrupt = false;
        this.kmY = 1;
        if (cNe() != null) {
            cNe().dBv = this.kmY;
        }
    }
}
