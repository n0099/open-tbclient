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
/* loaded from: classes7.dex */
public class d {
    private ImageView fTq;
    private g gEv;
    private f goD;
    private boolean iqr;
    private MainTabActivity klO;
    private TextView klS;
    private ImageView klT;
    private ImageView klU;
    private TextView klV;
    private TBLottieAnimationView klW;
    private PopupWindow klY;
    private MaintabBottomIndicator kma;
    private MaintabBottomIndicator kmb;
    private Runnable kmh;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean klX = false;
    private int iqn = -1;
    private boolean klZ = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean dxr = true;
    private int kmc = 1;
    private boolean isInterrupt = false;
    private boolean kmd = false;
    private FragmentTabHost.a kme = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b jX = d.this.mTabHost.jX(i);
            if (jX.mType == 8) {
                if (d.this.kma != null && d.this.kma.getAnimationView() != null && d.this.kma.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new an("c10605").Z("obj_type", 1));
                } else {
                    TiebaStatic.log(new an("c10605").Z("obj_type", 0));
                }
                if (d.this.kma != null) {
                    d.this.kma.aKk();
                }
            } else if (jX.mType == 3) {
                TiebaStatic.log(new an(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).Z("obj_locate", 1));
                TiebaStatic.log(new an(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).Z("obj_locate", 1));
            }
            if (jX.mType == 2) {
                if (d.this.dxr) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.dxr = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.kmc != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.kmc == 1) {
                        d.this.kmb.gE(d.this.dxr);
                    }
                } else {
                    d.this.kmb.aNF();
                }
                d.this.isInterrupt = false;
            } else {
                d.this.isInterrupt = true;
                if (d.this.dxr) {
                    d.this.kmb.gE(d.this.dxr);
                }
                d.this.dxr = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.cLJ() != null) {
                d.this.cLJ().dxr = d.this.dxr;
            }
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b jX = d.this.mTabHost.jX(i);
            if (jX.mType == 9) {
                if (bc.checkUpIsLogin(d.this.klO.getPageContext().getPageActivity())) {
                    d.this.klO.bDT();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (jX.mType == 8 && !bc.checkUpIsLogin(d.this.klO.getActivity())) {
                if (d.this.kma != null) {
                    d.this.kma.aKk();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (jX.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ba.aEt().a(d.this.klO.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (jX.mType == 3 && !bc.checkUpIsLogin(d.this.klO.getActivity())) {
                    return false;
                } else {
                    if (jX.mType == 1) {
                        TiebaStatic.log(new an("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener kmf = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.cLJ() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.isInterrupt = true;
                        d.this.dxr = true;
                        if (d.this.kmc != 2) {
                            if (d.this.kmb.isAnimating()) {
                                d.this.kmb.gE(d.this.dxr);
                                return;
                            }
                            return;
                        }
                        d.this.cLJ().aNH();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.isInterrupt = false;
                        if (d.this.kmc == 1) {
                            return;
                        }
                    } else {
                        d.this.kmc = intValue;
                    }
                    if (d.this.kmc == 1) {
                        d.this.cLJ().gE(d.this.dxr);
                    } else if (d.this.kmc == 2) {
                        d.this.cLJ().aNF();
                    } else if (intValue == 5) {
                        d.this.kmc = 1;
                        d.this.dxr = true;
                        if (!d.this.isInterrupt) {
                            d.this.cLJ().aNH();
                        }
                    } else {
                        d.this.cLJ().aNG();
                    }
                    d.this.cLJ().dxq = true;
                    d.this.cLJ().dxs = d.this.kmc;
                    d.this.cLJ().dxr = d.this.dxr;
                }
            }
        }
    };
    private CustomMessageListener kmg = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.dxr = true;
            if (d.this.cLJ() != null) {
                d.this.cLJ().dxr = d.this.dxr;
            }
        }
    };
    private Runnable gLk = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.klY != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.klO.getActivity());
                int dimens = l.getDimens(d.this.klO.getActivity(), R.dimen.ds178);
                View contentView = d.this.klY.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b jY = d.this.mTabHost.jY(3);
                    if (jY != null && (tbFragmentTabIndicator = jY.cUe) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.klO.getActivity(), R.dimen.tbds570);
                        }
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(d.this.klY, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.klZ = true;
                        d.this.mHandler.postDelayed(d.this.gLl, 5000L);
                    }
                }
            }
        }
    };
    private Runnable gLl = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            d.this.cLL();
        }
    };
    private View.OnClickListener gLm = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.cLL();
        }
    };

    public d(MainTabActivity mainTabActivity) {
        this.klO = mainTabActivity;
    }

    public void sS(boolean z) {
        this.mTabHost = (FragmentTabHost) this.klO.findViewById(R.id.tab_host);
        this.mTabHost.setUIType(1);
        this.mTabHost.setup(this.klO.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setTabContainerShadowShow(false);
        this.mTabHost.setBackGroundStyle(1);
        this.mTabHost.setOnTabSelectionListener(this.kme);
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
                d.this.cLK();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.jX(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.fTq.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                d.this.iqn = d.this.mTabHost.getCurrentTabType();
                d.this.cLH();
                if (com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (d.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).cp("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.klX = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        bas();
        this.klW = (TBLottieAnimationView) this.klO.findViewById(R.id.home_page_new_write_icon);
        if (TbSingleton.getInstance().isShowNewYearSkin()) {
            am.a(this.klW, R.raw.lottie_use_publish_cj_n);
        } else {
            am.a(this.klW, R.raw.lottie_use_publish_n);
        }
        this.klV = (TextView) this.klO.findViewById(R.id.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.klO.getPageContext()));
        switchNaviBarStatus(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.klO.registerListener(this.kmf);
        }
        this.klO.registerListener(this.kmg);
    }

    public void Jl(final String str) {
        if (StringUtils.isNull(str)) {
            this.klV.setVisibility(8);
            return;
        }
        FragmentTabHost.b jY = this.mTabHost.jY(8);
        if (jY != null) {
            if (!this.klZ || (this.klY != null && this.klY.isShowing())) {
                if (this.kmh == null) {
                    this.kmh = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.13
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.Jl(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.kmh);
                TbadkCoreApplication.getInst().handler.postDelayed(this.kmh, 5000L);
                return;
            }
            a(str, jY);
            return;
        }
        this.klV.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.cUe.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.klO).widthPixels - (iArr[0] + (bVar.cUe.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.klV.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.klO.getPageContext().getPageActivity(), R.dimen.ds26);
        this.klV.setLayoutParams(layoutParams);
        this.klV.setVisibility(0);
        this.klV.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void cLD() {
        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.klX);
    }

    public boolean cLE() {
        return this.klT != null && this.klT.getVisibility() == 0;
    }

    public void sT(boolean z) {
        if (this.klT != null) {
            if (z) {
                this.klT.setVisibility(0);
            } else {
                this.klT.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.klO.getPageContext(), i);
        am.setNavbarTitleColor(this.klS, R.color.cp_cont_b, R.color.s_navbar_title_color, i);
        am.setImageResource(this.klU, R.drawable.icon_news_down_bar_one);
        am.setNavbarIconSrc(this.klT, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        SvgManager.aEp().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aEp().a(this.fTq, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (TbSingleton.getInstance().isShowNewYearSkin()) {
            am.a(this.klW, R.raw.lottie_use_publish_cj_n);
        } else {
            am.a(this.klW, R.raw.lottie_use_publish_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
                cLG();
                return;
            }
            this.mTabHost.showTabWidget();
            cLF();
        }
    }

    public void cLF() {
        if (this.klW != null) {
            this.klW.setVisibility(0);
        }
    }

    public void cLG() {
        if (this.klW != null) {
            this.klW.setVisibility(8);
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.klO.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            am.setViewTextColor(textView, R.color.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.aLp())) {
                textView.setText(payMemberInfoData.aLp());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                am.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.klO.getPageContext().getPageActivity());
            aVar.aO(inflate);
            aVar.jG(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.klO.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.klO.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.klO.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.klO.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.klO.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.klO.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.klO.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.fA(false);
            aVar.b(this.klO.getPageContext()).aCp();
            com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void cLH() {
        FragmentTabHost.b jY;
        if (this.mTabHost != null && (jY = this.mTabHost.jY(this.mTabHost.getCurrentTabType())) != null && jY.cUf != null && jY.cUf.aNy() != null) {
            String string = this.klO.getPageContext().getString(jY.cUf.aNy().textResId);
            if (this.klS != null) {
                this.klS.setText(string);
            }
        }
    }

    public void bas() {
        this.mNavigationBar = (NavigationBar) this.klO.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.klS = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.klO.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.klS.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.klT = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.klU = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.klT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.sW(false);
                    d.this.klU.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.klO.getPageContext()));
                    TiebaStatic.eventStat(d.this.klO.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.klO.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.klO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.klO.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new an(CommonStatisticKey.SEARCH_BAR_CLICK).Z("obj_type", i));
                }
            });
            this.fTq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.fTq.setLayoutParams(layoutParams2);
            this.fTq.setVisibility(8);
            this.fTq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.klO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.klO.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.klO.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bc.skipToLoginActivity(d.this.klO.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.klO.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.iqn) {
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
                    TiebaStatic.log(new an("c10517").cp("obj_source", str));
                    bc.skipToRegisterActivity(d.this.klO.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void sU(boolean z) {
        if (z) {
            this.fTq.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.fTq.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void sV(boolean z) {
        if (cLE()) {
            if (z) {
                if (this.klU.getVisibility() != 0) {
                    this.klU.setVisibility(0);
                    sW(true);
                    am.setImageResource(this.klU, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            sW(false);
            this.klU.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sW(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.klT.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.klO.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.klO.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.klT.setLayoutParams(layoutParams);
        }
    }

    public void aF(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.aNy(), next.dW(this.klO.getPageContext().getPageActivity()));
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

    public void oR(boolean z) {
        this.iqr = z;
        if (!this.iqr) {
            com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean cfN() {
        return this.iqr;
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
                cLF();
                this.kmd = true;
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.dxj) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.kma = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (bVar2.mType == 2) {
                this.kmb = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.cUe = maintabBottomIndicator;
            bVar2.cUf = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost bDV() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator cLI() {
        return this.kma;
    }

    public MaintabBottomIndicator cLJ() {
        return this.kmb;
    }

    public void cLK() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void cLL() {
        this.mHandler.removeCallbacks(this.gLk);
        this.mHandler.removeCallbacks(this.gLl);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.klY);
    }

    public void Jm(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.klO.getActivity());
        aVar.sC(str);
        aVar.a(R.string.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                an anVar = new an("c12137");
                anVar.cp("obj_locate", "1");
                TiebaStatic.log(anVar);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                an anVar = new an("c12137");
                anVar.cp("obj_locate", "2");
                TiebaStatic.log(anVar);
                aVar2.dismiss();
                com.baidu.tieba.i.a.bKZ();
            }
        });
        aVar.b(this.klO.getPageContext()).aCp();
    }

    public void onDestroy() {
        cLD();
        if (bDV() != null) {
            bDV().reset();
        }
        cLL();
        if (this.gEv != null) {
            this.gEv.onDestroy();
        }
        if (this.goD != null) {
            this.goD.bER();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.klO).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.gEv == null) {
            this.gEv = new g(this.klO.getPageContext(), (NavigationBarCoverTip) this.klO.findViewById(R.id.navigation_cover_tip));
        }
        this.gEv.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.goD == null) {
                this.goD = new f(this.klO, this.klO.getActivityRootView());
            }
            this.goD.h(postWriteCallBackData);
        }
    }

    public void cLM() {
        this.isInterrupt = false;
        this.kmc = 1;
        if (cLJ() != null) {
            cLJ().dxs = this.kmc;
        }
    }
}
