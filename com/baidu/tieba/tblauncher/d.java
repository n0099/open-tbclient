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
import com.baidu.tbadk.data.i;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.c.g;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class d {
    private ImageView gQB;
    private g hGH;
    private com.baidu.tieba.video.f hpU;
    private boolean jus;
    private MainTabActivity lsE;
    private TextView lsI;
    private ImageView lsJ;
    private ImageView lsK;
    private TextView lsL;
    private ImageView lsM;
    private TextView lsN;
    private PopupWindow lsP;
    private MaintabBottomIndicator lsR;
    private MaintabBottomIndicator lsS;
    private Runnable lsY;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean lsO = false;
    private int juo = -1;
    private boolean lsQ = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean epX = true;
    private int lsT = 1;
    private boolean isInterrupt = false;
    private boolean lsU = false;
    private FragmentTabHost.a lsV = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b kX = d.this.mTabHost.kX(i);
            if (kX.mType == 8) {
                if (d.this.lsR != null && d.this.lsR.getAnimationView() != null && d.this.lsR.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new an("c10605").ag("obj_type", 1));
                } else {
                    TiebaStatic.log(new an("c10605").ag("obj_type", 0));
                }
                if (d.this.lsR != null) {
                    d.this.lsR.beC();
                }
            } else if (kX.mType == 3) {
                TiebaStatic.log(new an(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).ag("obj_locate", 1));
                TiebaStatic.log(new an(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ag("obj_locate", 1));
            }
            if (kX.mType == 2) {
                if (d.this.epX) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.epX = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.lsT != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.lsT == 1) {
                        d.this.lsS.ig(d.this.epX);
                    }
                } else {
                    d.this.lsS.beG();
                }
                d.this.isInterrupt = false;
            } else {
                d.this.isInterrupt = true;
                if (d.this.epX) {
                    d.this.lsS.ig(d.this.epX);
                }
                d.this.epX = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.dfZ() != null) {
                d.this.dfZ().epX = d.this.epX;
            }
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b kX = d.this.mTabHost.kX(i);
            if (kX.mType == 9) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new i(0)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (kX.mType == 8 && !bc.checkUpIsLogin(d.this.lsE.getActivity())) {
                if (d.this.lsR != null) {
                    d.this.lsR.beC();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (kX.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ba.aVa().a(d.this.lsE.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (kX.mType == 3 && !bc.checkUpIsLogin(d.this.lsE.getActivity())) {
                    return false;
                } else {
                    if (kX.mType == 1) {
                        TiebaStatic.log(new an("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener lsW = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dfZ() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.isInterrupt = true;
                        d.this.epX = true;
                        if (d.this.lsT != 2) {
                            if (d.this.lsS.isAnimating()) {
                                d.this.lsS.ig(d.this.epX);
                                return;
                            }
                            return;
                        }
                        d.this.dfZ().beI();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.isInterrupt = false;
                        if (d.this.lsT == 1) {
                            return;
                        }
                    } else {
                        d.this.lsT = intValue;
                    }
                    if (d.this.lsT == 1) {
                        d.this.dfZ().ig(d.this.epX);
                    } else if (d.this.lsT == 2) {
                        d.this.dfZ().beG();
                    } else if (intValue == 5) {
                        d.this.lsT = 1;
                        d.this.epX = true;
                        if (!d.this.isInterrupt) {
                            d.this.dfZ().beI();
                        }
                    } else {
                        d.this.dfZ().beH();
                    }
                    d.this.dfZ().epW = true;
                    d.this.dfZ().epY = d.this.lsT;
                    d.this.dfZ().epX = d.this.epX;
                }
            }
        }
    };
    private CustomMessageListener lsX = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.epX = true;
            if (d.this.dfZ() != null) {
                d.this.dfZ().epX = d.this.epX;
            }
        }
    };
    private Runnable hOj = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.lsP != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.lsE.getActivity());
                int dimens = l.getDimens(d.this.lsE.getActivity(), R.dimen.ds178);
                View contentView = d.this.lsP.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b kY = d.this.mTabHost.kY(3);
                    if (kY != null && (tbFragmentTabIndicator = kY.dLP) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.lsE.getActivity(), R.dimen.tbds570);
                        }
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(d.this.lsP, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.lsQ = true;
                        d.this.mHandler.postDelayed(d.this.hOk, 5000L);
                    }
                }
            }
        }
    };
    private Runnable hOk = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            d.this.dgb();
        }
    };
    private View.OnClickListener hOl = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dgb();
        }
    };

    public void setCurrentTabByType(int i) {
        bWK().setCurrentTabByType(i);
        if (i != 2) {
            this.isInterrupt = true;
            if (this.epX) {
                this.lsS.ig(false);
            }
            this.epX = false;
            if (dfZ() != null) {
                dfZ().epX = this.epX;
            }
        }
    }

    public d(MainTabActivity mainTabActivity) {
        this.lsE = mainTabActivity;
    }

    public void uC(boolean z) {
        this.mTabHost = (FragmentTabHost) this.lsE.findViewById(R.id.tab_host);
        this.mTabHost.setup(this.lsE.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.lsV);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.setShouldDrawIndicatorLine(false);
            this.mTabHost.setShouldDrawTopLine(true);
        }
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
                d.this.dga();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.kX(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.gQB.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                d.this.juo = d.this.mTabHost.getCurrentTabType();
                d.this.dfX();
                if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (d.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).dh("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.lsO = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        brd();
        this.lsM = (ImageView) this.lsE.findViewById(R.id.home_page_new_write_icon);
        this.lsN = (TextView) this.lsE.findViewById(R.id.view_bottom_text);
        this.lsL = (TextView) this.lsE.findViewById(R.id.activity_prize_my_tip);
        if (com.baidu.tbadk.a.d.aMs()) {
            this.mTabHost.setUIType(0);
            this.mTabHost.setTabContainerShadowShow(true);
            this.mTabHost.setBackGroundStyle(0);
            this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            dfW();
        } else {
            this.mTabHost.setUIType(1);
            this.mTabHost.setTabContainerShadowShow(false);
            this.mTabHost.setBackGroundStyle(1);
            this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight() + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds73));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.lsE.getPageContext()));
        switchNaviBarStatus(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.lsE.registerListener(this.lsW);
        }
        this.lsE.registerListener(this.lsX);
    }

    public void MZ(final String str) {
        if (StringUtils.isNull(str)) {
            this.lsL.setVisibility(8);
            return;
        }
        FragmentTabHost.b kY = this.mTabHost.kY(8);
        if (kY != null) {
            if (!this.lsQ || (this.lsP != null && this.lsP.isShowing())) {
                if (this.lsY == null) {
                    this.lsY = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.13
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.MZ(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.lsY);
                TbadkCoreApplication.getInst().handler.postDelayed(this.lsY, 5000L);
                return;
            }
            a(str, kY);
            return;
        }
        this.lsL.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.dLP.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.lsE).widthPixels - (iArr[0] + (bVar.dLP.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lsL.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.lsE.getPageContext().getPageActivity(), R.dimen.ds26);
        this.lsL.setLayoutParams(layoutParams);
        this.lsL.setVisibility(0);
        this.lsL.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void dfT() {
        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.lsO);
    }

    public boolean dfU() {
        return this.lsJ != null && this.lsJ.getVisibility() == 0;
    }

    public void uD(boolean z) {
        if (this.lsJ != null) {
            if (z) {
                this.lsJ.setVisibility(0);
            } else {
                this.lsJ.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.setShouldDrawTopLine(false);
        }
        if (com.baidu.tbadk.a.d.aMs()) {
            if (this.mTabHost.getFragmentTabWidget() != null) {
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_h);
            }
        } else if (this.mTabHost.getFragmentTabWidget() != null) {
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.mTabHost.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.lsE.getPageContext(), i);
        am.setNavbarTitleColor(this.lsI, R.color.cp_cont_b, R.color.s_navbar_title_color, i);
        am.setImageResource(this.lsK, R.drawable.icon_news_down_bar_one);
        am.setNavbarIconSrc(this.lsJ, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        am.setViewTextColor(this.lsN, (int) R.color.cp_cont_f);
        SvgManager.aUW().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aUW().a(this.gQB, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
                dfW();
                return;
            }
            this.mTabHost.showTabWidget();
            dfV();
        }
    }

    public void dfV() {
        if (!com.baidu.tbadk.a.d.aMs()) {
            if (this.lsM != null) {
                this.lsM.setVisibility(0);
            }
            if (this.lsN != null) {
                this.lsN.setVisibility(0);
            }
        }
    }

    public void dfW() {
        if (this.lsM != null) {
            this.lsM.setVisibility(8);
        }
        if (this.lsN != null) {
            this.lsN.setVisibility(8);
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.lsE.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            am.setViewTextColor(textView, R.color.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.bcw())) {
                textView.setText(payMemberInfoData.bcw());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                am.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lsE.getPageContext().getPageActivity());
            aVar.aP(inflate);
            aVar.kG(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.lsE.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.lsE.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.lsE.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.lsE.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.lsE.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.lsE.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.lsE.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.gX(false);
            aVar.b(this.lsE.getPageContext()).aST();
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void dfX() {
        FragmentTabHost.b kY;
        if (this.mTabHost != null && (kY = this.mTabHost.kY(this.mTabHost.getCurrentTabType())) != null && kY.dLQ != null && kY.dLQ.getFragmentTabStructure() != null) {
            String string = this.lsE.getPageContext().getString(kY.dLQ.getFragmentTabStructure().textResId);
            if (this.lsI != null) {
                this.lsI.setText(string);
            }
        }
    }

    public void brd() {
        this.mNavigationBar = (NavigationBar) this.lsE.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.lsI = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.lsE.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.lsI.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.lsJ = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.lsK = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.lsJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.uG(false);
                    d.this.lsK.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.lsE.getPageContext()));
                    TiebaStatic.eventStat(d.this.lsE.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.lsE.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.lsE.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.lsE.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new an(CommonStatisticKey.SEARCH_BAR_CLICK).ag("obj_type", i));
                }
            });
            this.gQB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.gQB.setLayoutParams(layoutParams2);
            this.gQB.setVisibility(8);
            this.gQB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.lsE.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.lsE.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.lsE.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bc.skipToLoginActivity(d.this.lsE.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.lsE.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.juo) {
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
                    TiebaStatic.log(new an("c10517").dh("obj_source", str));
                    bc.skipToRegisterActivity(d.this.lsE.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void uE(boolean z) {
        if (z) {
            this.gQB.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.gQB.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void uF(boolean z) {
        if (dfU()) {
            if (z) {
                if (this.lsK.getVisibility() != 0) {
                    this.lsK.setVisibility(0);
                    uG(true);
                    am.setImageResource(this.lsK, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            uG(false);
            this.lsK.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uG(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lsJ.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.lsE.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.lsE.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.lsJ.setLayoutParams(layoutParams);
        }
    }

    public void aH(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.lsE.getPageContext().getPageActivity()));
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

    public void qB(boolean z) {
        this.jus = z;
        if (!this.jus) {
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean czn() {
        return this.jus;
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
                dfV();
                this.lsU = true;
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.epP) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.lsR = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (bVar2.mType == 2) {
                this.lsS = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.dLP = maintabBottomIndicator;
            bVar2.dLQ = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost bWK() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator dfY() {
        return this.lsR;
    }

    public MaintabBottomIndicator dfZ() {
        return this.lsS;
    }

    public void dga() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void dgb() {
        this.mHandler.removeCallbacks(this.hOj);
        this.mHandler.removeCallbacks(this.hOk);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lsP);
    }

    public void Na(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lsE.getActivity());
        aVar.vO(str);
        aVar.a(R.string.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                an anVar = new an("c12137");
                anVar.dh("obj_locate", "1");
                TiebaStatic.log(anVar);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                an anVar = new an("c12137");
                anVar.dh("obj_locate", "2");
                TiebaStatic.log(anVar);
                aVar2.dismiss();
                com.baidu.tieba.j.a.cdZ();
            }
        });
        aVar.b(this.lsE.getPageContext()).aST();
    }

    public void onDestroy() {
        dfT();
        if (bWK() != null) {
            bWK().reset();
        }
        dgb();
        if (this.hGH != null) {
            this.hGH.onDestroy();
        }
        if (this.hpU != null) {
            this.hpU.bXG();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.lsE).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.hGH == null) {
            this.hGH = new g(this.lsE.getPageContext(), (NavigationBarCoverTip) this.lsE.findViewById(R.id.navigation_cover_tip));
        }
        this.hGH.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.hpU == null) {
                this.hpU = new com.baidu.tieba.video.f(this.lsE, this.lsE.getActivityRootView());
            }
            this.hpU.h(postWriteCallBackData);
        }
    }

    public void dgc() {
        this.isInterrupt = false;
        this.lsT = 1;
        if (dfZ() != null) {
            dfZ().epY = this.lsT;
        }
    }
}
