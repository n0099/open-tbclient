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
    private ImageView gQq;
    private g hFU;
    private com.baidu.tieba.video.f hpJ;
    private boolean jtm;
    private ImageView lrA;
    private ImageView lrB;
    private TextView lrC;
    private ImageView lrD;
    private TextView lrE;
    private PopupWindow lrG;
    private MaintabBottomIndicator lrI;
    private MaintabBottomIndicator lrJ;
    private Runnable lrP;
    private MainTabActivity lrv;
    private TextView lrz;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean lrF = false;
    private int jti = -1;
    private boolean lrH = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean epX = true;
    private int lrK = 1;
    private boolean isInterrupt = false;
    private boolean lrL = false;
    private FragmentTabHost.a lrM = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b kV = d.this.mTabHost.kV(i);
            if (kV.mType == 8) {
                if (d.this.lrI != null && d.this.lrI.getAnimationView() != null && d.this.lrI.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new an("c10605").ag("obj_type", 1));
                } else {
                    TiebaStatic.log(new an("c10605").ag("obj_type", 0));
                }
                if (d.this.lrI != null) {
                    d.this.lrI.beB();
                }
            } else if (kV.mType == 3) {
                TiebaStatic.log(new an(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).ag("obj_locate", 1));
                TiebaStatic.log(new an(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ag("obj_locate", 1));
            }
            if (kV.mType == 2) {
                if (d.this.epX) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.epX = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.lrK != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.lrK == 1) {
                        d.this.lrJ.ig(d.this.epX);
                    }
                } else {
                    d.this.lrJ.beF();
                }
                d.this.isInterrupt = false;
            } else {
                d.this.isInterrupt = true;
                if (d.this.epX) {
                    d.this.lrJ.ig(d.this.epX);
                }
                d.this.epX = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.dfK() != null) {
                d.this.dfK().epX = d.this.epX;
            }
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b kV = d.this.mTabHost.kV(i);
            if (kV.mType == 9) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new i(0)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (kV.mType == 8 && !bc.checkUpIsLogin(d.this.lrv.getActivity())) {
                if (d.this.lrI != null) {
                    d.this.lrI.beB();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (kV.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ba.aUZ().a(d.this.lrv.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (kV.mType == 3 && !bc.checkUpIsLogin(d.this.lrv.getActivity())) {
                    return false;
                } else {
                    if (kV.mType == 1) {
                        TiebaStatic.log(new an("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener lrN = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dfK() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.isInterrupt = true;
                        d.this.epX = true;
                        if (d.this.lrK != 2) {
                            if (d.this.lrJ.isAnimating()) {
                                d.this.lrJ.ig(d.this.epX);
                                return;
                            }
                            return;
                        }
                        d.this.dfK().beH();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.isInterrupt = false;
                        if (d.this.lrK == 1) {
                            return;
                        }
                    } else {
                        d.this.lrK = intValue;
                    }
                    if (d.this.lrK == 1) {
                        d.this.dfK().ig(d.this.epX);
                    } else if (d.this.lrK == 2) {
                        d.this.dfK().beF();
                    } else if (intValue == 5) {
                        d.this.lrK = 1;
                        d.this.epX = true;
                        if (!d.this.isInterrupt) {
                            d.this.dfK().beH();
                        }
                    } else {
                        d.this.dfK().beG();
                    }
                    d.this.dfK().epW = true;
                    d.this.dfK().epY = d.this.lrK;
                    d.this.dfK().epX = d.this.epX;
                }
            }
        }
    };
    private CustomMessageListener lrO = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.epX = true;
            if (d.this.dfK() != null) {
                d.this.dfK().epX = d.this.epX;
            }
        }
    };
    private Runnable hNw = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.lrG != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.lrv.getActivity());
                int dimens = l.getDimens(d.this.lrv.getActivity(), R.dimen.ds178);
                View contentView = d.this.lrG.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b kW = d.this.mTabHost.kW(3);
                    if (kW != null && (tbFragmentTabIndicator = kW.dLP) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.lrv.getActivity(), R.dimen.tbds570);
                        }
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(d.this.lrG, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.lrH = true;
                        d.this.mHandler.postDelayed(d.this.hNx, 5000L);
                    }
                }
            }
        }
    };
    private Runnable hNx = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            d.this.dfM();
        }
    };
    private View.OnClickListener hNy = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dfM();
        }
    };

    public void setCurrentTabByType(int i) {
        bWI().setCurrentTabByType(i);
        if (i != 2) {
            this.isInterrupt = true;
            if (this.epX) {
                this.lrJ.ig(false);
            }
            this.epX = false;
            if (dfK() != null) {
                dfK().epX = this.epX;
            }
        }
    }

    public d(MainTabActivity mainTabActivity) {
        this.lrv = mainTabActivity;
    }

    public void uC(boolean z) {
        this.mTabHost = (FragmentTabHost) this.lrv.findViewById(R.id.tab_host);
        this.mTabHost.setup(this.lrv.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.lrM);
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
                d.this.dfL();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.kV(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.gQq.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                d.this.jti = d.this.mTabHost.getCurrentTabType();
                d.this.dfI();
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
        this.lrF = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        brb();
        this.lrD = (ImageView) this.lrv.findViewById(R.id.home_page_new_write_icon);
        this.lrE = (TextView) this.lrv.findViewById(R.id.view_bottom_text);
        this.lrC = (TextView) this.lrv.findViewById(R.id.activity_prize_my_tip);
        if (com.baidu.tbadk.a.d.aMs()) {
            this.mTabHost.setUIType(0);
            this.mTabHost.setTabContainerShadowShow(true);
            this.mTabHost.setBackGroundStyle(0);
            this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            dfH();
        } else {
            this.mTabHost.setUIType(1);
            this.mTabHost.setTabContainerShadowShow(false);
            this.mTabHost.setBackGroundStyle(1);
            this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight() + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds73));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.lrv.getPageContext()));
        switchNaviBarStatus(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.lrv.registerListener(this.lrN);
        }
        this.lrv.registerListener(this.lrO);
    }

    public void MY(final String str) {
        if (StringUtils.isNull(str)) {
            this.lrC.setVisibility(8);
            return;
        }
        FragmentTabHost.b kW = this.mTabHost.kW(8);
        if (kW != null) {
            if (!this.lrH || (this.lrG != null && this.lrG.isShowing())) {
                if (this.lrP == null) {
                    this.lrP = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.13
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.MY(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.lrP);
                TbadkCoreApplication.getInst().handler.postDelayed(this.lrP, 5000L);
                return;
            }
            a(str, kW);
            return;
        }
        this.lrC.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.dLP.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.lrv).widthPixels - (iArr[0] + (bVar.dLP.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lrC.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.lrv.getPageContext().getPageActivity(), R.dimen.ds26);
        this.lrC.setLayoutParams(layoutParams);
        this.lrC.setVisibility(0);
        this.lrC.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void dfE() {
        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.lrF);
    }

    public boolean dfF() {
        return this.lrA != null && this.lrA.getVisibility() == 0;
    }

    public void uD(boolean z) {
        if (this.lrA != null) {
            if (z) {
                this.lrA.setVisibility(0);
            } else {
                this.lrA.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.lrv.getPageContext(), i);
        am.setNavbarTitleColor(this.lrz, R.color.cp_cont_b, R.color.s_navbar_title_color, i);
        am.setImageResource(this.lrB, R.drawable.icon_news_down_bar_one);
        am.setNavbarIconSrc(this.lrA, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        am.setViewTextColor(this.lrE, (int) R.color.cp_cont_f);
        SvgManager.aUV().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aUV().a(this.gQq, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
                dfH();
                return;
            }
            this.mTabHost.showTabWidget();
            dfG();
        }
    }

    public void dfG() {
        if (!com.baidu.tbadk.a.d.aMs()) {
            if (this.lrD != null) {
                this.lrD.setVisibility(0);
            }
            if (this.lrE != null) {
                this.lrE.setVisibility(0);
            }
        }
    }

    public void dfH() {
        if (this.lrD != null) {
            this.lrD.setVisibility(8);
        }
        if (this.lrE != null) {
            this.lrE.setVisibility(8);
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.lrv.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            am.setViewTextColor(textView, R.color.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.bcv())) {
                textView.setText(payMemberInfoData.bcv());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                am.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lrv.getPageContext().getPageActivity());
            aVar.aP(inflate);
            aVar.kE(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.lrv.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.lrv.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.lrv.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.lrv.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.lrv.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.lrv.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.lrv.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.gX(false);
            aVar.b(this.lrv.getPageContext()).aST();
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void dfI() {
        FragmentTabHost.b kW;
        if (this.mTabHost != null && (kW = this.mTabHost.kW(this.mTabHost.getCurrentTabType())) != null && kW.dLQ != null && kW.dLQ.getFragmentTabStructure() != null) {
            String string = this.lrv.getPageContext().getString(kW.dLQ.getFragmentTabStructure().textResId);
            if (this.lrz != null) {
                this.lrz.setText(string);
            }
        }
    }

    public void brb() {
        this.mNavigationBar = (NavigationBar) this.lrv.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.lrz = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.lrv.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.lrz.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.lrA = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.lrB = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.lrA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.uG(false);
                    d.this.lrB.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.lrv.getPageContext()));
                    TiebaStatic.eventStat(d.this.lrv.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.lrv.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.lrv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.lrv.getPageContext().getPageActivity())));
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
            this.gQq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.gQq.setLayoutParams(layoutParams2);
            this.gQq.setVisibility(8);
            this.gQq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.lrv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.lrv.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.lrv.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bc.skipToLoginActivity(d.this.lrv.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.lrv.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.jti) {
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
                    bc.skipToRegisterActivity(d.this.lrv.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void uE(boolean z) {
        if (z) {
            this.gQq.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.gQq.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void uF(boolean z) {
        if (dfF()) {
            if (z) {
                if (this.lrB.getVisibility() != 0) {
                    this.lrB.setVisibility(0);
                    uG(true);
                    am.setImageResource(this.lrB, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            uG(false);
            this.lrB.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uG(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lrA.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.lrv.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.lrv.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.lrA.setLayoutParams(layoutParams);
        }
    }

    public void aH(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.lrv.getPageContext().getPageActivity()));
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
        this.jtm = z;
        if (!this.jtm) {
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean cyW() {
        return this.jtm;
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
                dfG();
                this.lrL = true;
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.epP) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.lrI = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (bVar2.mType == 2) {
                this.lrJ = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.dLP = maintabBottomIndicator;
            bVar2.dLQ = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost bWI() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator dfJ() {
        return this.lrI;
    }

    public MaintabBottomIndicator dfK() {
        return this.lrJ;
    }

    public void dfL() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void dfM() {
        this.mHandler.removeCallbacks(this.hNw);
        this.mHandler.removeCallbacks(this.hNx);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lrG);
    }

    public void MZ(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lrv.getActivity());
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
                com.baidu.tieba.j.a.cdR();
            }
        });
        aVar.b(this.lrv.getPageContext()).aST();
    }

    public void onDestroy() {
        dfE();
        if (bWI() != null) {
            bWI().reset();
        }
        dfM();
        if (this.hFU != null) {
            this.hFU.onDestroy();
        }
        if (this.hpJ != null) {
            this.hpJ.bXE();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.lrv).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.hFU == null) {
            this.hFU = new g(this.lrv.getPageContext(), (NavigationBarCoverTip) this.lrv.findViewById(R.id.navigation_cover_tip));
        }
        this.hFU.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.hpJ == null) {
                this.hpJ = new com.baidu.tieba.video.f(this.lrv, this.lrv.getActivityRootView());
            }
            this.hpJ.h(postWriteCallBackData);
        }
    }

    public void dfN() {
        this.isInterrupt = false;
        this.lrK = 1;
        if (dfK() != null) {
            dfK().epY = this.lrK;
        }
    }
}
