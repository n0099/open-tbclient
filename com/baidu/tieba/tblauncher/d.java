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
import com.baidu.tieba.R;
import com.baidu.tieba.c.g;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.f;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class d {
    private ImageView fWG;
    private g gHG;
    private f grD;
    private boolean iua;
    private MainTabActivity koB;
    private TextView koF;
    private ImageView koG;
    private ImageView koH;
    private TextView koI;
    private ImageView koJ;
    private TextView koK;
    private PopupWindow koM;
    private MaintabBottomIndicator koO;
    private MaintabBottomIndicator koP;
    private Runnable koV;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean koL = false;
    private int itW = -1;
    private boolean koN = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean dBV = true;
    private int koQ = 1;
    private boolean isInterrupt = false;
    private boolean koR = false;
    private FragmentTabHost.a koS = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b ko = d.this.mTabHost.ko(i);
            if (ko.mType == 8) {
                if (d.this.koO != null && d.this.koO.getAnimationView() != null && d.this.koO.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new an("c10605").X("obj_type", 1));
                } else {
                    TiebaStatic.log(new an("c10605").X("obj_type", 0));
                }
                if (d.this.koO != null) {
                    d.this.koO.aMN();
                }
            } else if (ko.mType == 3) {
                TiebaStatic.log(new an(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).X("obj_locate", 1));
                TiebaStatic.log(new an(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).X("obj_locate", 1));
            }
            if (ko.mType == 2) {
                if (d.this.dBV) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.dBV = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.koQ != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.koQ == 1) {
                        d.this.koP.gM(d.this.dBV);
                    }
                } else {
                    d.this.koP.aQg();
                }
                d.this.isInterrupt = false;
            } else {
                d.this.isInterrupt = true;
                if (d.this.dBV) {
                    d.this.koP.gM(d.this.dBV);
                }
                d.this.dBV = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.cNB() != null) {
                d.this.cNB().dBV = d.this.dBV;
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
                if (bc.checkUpIsLogin(d.this.koB.getPageContext().getPageActivity())) {
                    d.this.koB.bFJ();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (ko.mType == 8 && !bc.checkUpIsLogin(d.this.koB.getActivity())) {
                if (d.this.koO != null) {
                    d.this.koO.aMN();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (ko.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ba.aGK().a(d.this.koB.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (ko.mType == 3 && !bc.checkUpIsLogin(d.this.koB.getActivity())) {
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
    private CustomMessageListener koT = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.cNB() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.isInterrupt = true;
                        d.this.dBV = true;
                        if (d.this.koQ != 2) {
                            if (d.this.koP.isAnimating()) {
                                d.this.koP.gM(d.this.dBV);
                                return;
                            }
                            return;
                        }
                        d.this.cNB().aQi();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.isInterrupt = false;
                        if (d.this.koQ == 1) {
                            return;
                        }
                    } else {
                        d.this.koQ = intValue;
                    }
                    if (d.this.koQ == 1) {
                        d.this.cNB().gM(d.this.dBV);
                    } else if (d.this.koQ == 2) {
                        d.this.cNB().aQg();
                    } else if (intValue == 5) {
                        d.this.koQ = 1;
                        d.this.dBV = true;
                        if (!d.this.isInterrupt) {
                            d.this.cNB().aQi();
                        }
                    } else {
                        d.this.cNB().aQh();
                    }
                    d.this.cNB().dBU = true;
                    d.this.cNB().dBW = d.this.koQ;
                    d.this.cNB().dBV = d.this.dBV;
                }
            }
        }
    };
    private CustomMessageListener koU = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.dBV = true;
            if (d.this.cNB() != null) {
                d.this.cNB().dBV = d.this.dBV;
            }
        }
    };
    private Runnable gOE = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.koM != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.koB.getActivity());
                int dimens = l.getDimens(d.this.koB.getActivity(), R.dimen.ds178);
                View contentView = d.this.koM.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b kp = d.this.mTabHost.kp(3);
                    if (kp != null && (tbFragmentTabIndicator = kp.cYv) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.koB.getActivity(), R.dimen.tbds570);
                        }
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(d.this.koM, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.koN = true;
                        d.this.mHandler.postDelayed(d.this.gOF, 5000L);
                    }
                }
            }
        }
    };
    private Runnable gOF = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            d.this.cND();
        }
    };
    private View.OnClickListener gOG = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.cND();
        }
    };

    public d(MainTabActivity mainTabActivity) {
        this.koB = mainTabActivity;
    }

    public void tc(boolean z) {
        this.mTabHost = (FragmentTabHost) this.koB.findViewById(R.id.tab_host);
        this.mTabHost.setUIType(1);
        this.mTabHost.setup(this.koB.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setTabContainerShadowShow(false);
        this.mTabHost.setBackGroundStyle(1);
        this.mTabHost.setOnTabSelectionListener(this.koS);
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
                d.this.cNC();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.ko(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.fWG.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                d.this.itW = d.this.mTabHost.getCurrentTabType();
                d.this.cNz();
                if (com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (d.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).cx("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.koL = com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        bcO();
        this.koJ = (ImageView) this.koB.findViewById(R.id.home_page_new_write_icon);
        this.koK = (TextView) this.koB.findViewById(R.id.view_bottom_text);
        this.koI = (TextView) this.koB.findViewById(R.id.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.koB.getPageContext()));
        switchNaviBarStatus(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.koB.registerListener(this.koT);
        }
        this.koB.registerListener(this.koU);
    }

    public void Jz(final String str) {
        if (StringUtils.isNull(str)) {
            this.koI.setVisibility(8);
            return;
        }
        FragmentTabHost.b kp = this.mTabHost.kp(8);
        if (kp != null) {
            if (!this.koN || (this.koM != null && this.koM.isShowing())) {
                if (this.koV == null) {
                    this.koV = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.13
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.Jz(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.koV);
                TbadkCoreApplication.getInst().handler.postDelayed(this.koV, 5000L);
                return;
            }
            a(str, kp);
            return;
        }
        this.koI.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.cYv.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.koB).widthPixels - (iArr[0] + (bVar.cYv.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.koI.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.koB.getPageContext().getPageActivity(), R.dimen.ds26);
        this.koI.setLayoutParams(layoutParams);
        this.koI.setVisibility(0);
        this.koI.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void cNv() {
        com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.koL);
    }

    public boolean cNw() {
        return this.koG != null && this.koG.getVisibility() == 0;
    }

    public void td(boolean z) {
        if (this.koG != null) {
            if (z) {
                this.koG.setVisibility(0);
            } else {
                this.koG.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.koB.getPageContext(), i);
        am.setNavbarTitleColor(this.koF, R.color.cp_cont_b, R.color.s_navbar_title_color, i);
        am.setImageResource(this.koH, R.drawable.icon_news_down_bar_one);
        am.setNavbarIconSrc(this.koG, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        am.setViewTextColor(this.koK, (int) R.color.cp_cont_f);
        SvgManager.aGG().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGG().a(this.fWG, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
                cNy();
                return;
            }
            this.mTabHost.showTabWidget();
            cNx();
        }
    }

    public void cNx() {
        if (this.koJ != null) {
            this.koJ.setVisibility(0);
        }
        if (this.koK != null) {
            this.koK.setVisibility(0);
        }
    }

    public void cNy() {
        if (this.koJ != null) {
            this.koJ.setVisibility(8);
        }
        if (this.koK != null) {
            this.koK.setVisibility(8);
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.koB.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            am.setViewTextColor(textView, R.color.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.aNS())) {
                textView.setText(payMemberInfoData.aNS());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                am.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.koB.getPageContext().getPageActivity());
            aVar.aO(inflate);
            aVar.jX(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.koB.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.koB.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.koB.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.koB.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.koB.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.koB.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.koB.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.fI(false);
            aVar.b(this.koB.getPageContext()).aEG();
            com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void cNz() {
        FragmentTabHost.b kp;
        if (this.mTabHost != null && (kp = this.mTabHost.kp(this.mTabHost.getCurrentTabType())) != null && kp.cYw != null && kp.cYw.getFragmentTabStructure() != null) {
            String string = this.koB.getPageContext().getString(kp.cYw.getFragmentTabStructure().textResId);
            if (this.koF != null) {
                this.koF.setText(string);
            }
        }
    }

    public void bcO() {
        this.mNavigationBar = (NavigationBar) this.koB.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.koF = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.koB.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.koF.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.koG = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.koH = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.koG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.tg(false);
                    d.this.koH.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.koB.getPageContext()));
                    TiebaStatic.eventStat(d.this.koB.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.koB.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.koB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.koB.getPageContext().getPageActivity())));
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
            this.fWG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.fWG.setLayoutParams(layoutParams2);
            this.fWG.setVisibility(8);
            this.fWG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.koB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.koB.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.koB.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bc.skipToLoginActivity(d.this.koB.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.koB.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.itW) {
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
                    TiebaStatic.log(new an("c10517").cx("obj_source", str));
                    bc.skipToRegisterActivity(d.this.koB.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void te(boolean z) {
        if (z) {
            this.fWG.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.fWG.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void tf(boolean z) {
        if (cNw()) {
            if (z) {
                if (this.koH.getVisibility() != 0) {
                    this.koH.setVisibility(0);
                    tg(true);
                    am.setImageResource(this.koH, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            tg(false);
            this.koH.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tg(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.koG.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.koB.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.koB.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.koG.setLayoutParams(layoutParams);
        }
    }

    public void aF(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.koB.getPageContext().getPageActivity()));
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

    public void pa(boolean z) {
        this.iua = z;
        if (!this.iua) {
            com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean chP() {
        return this.iua;
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
                cNx();
                this.koR = true;
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.dBN) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.koO = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (bVar2.mType == 2) {
                this.koP = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.cYv = maintabBottomIndicator;
            bVar2.cYw = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost bFL() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator cNA() {
        return this.koO;
    }

    public MaintabBottomIndicator cNB() {
        return this.koP;
    }

    public void cNC() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void cND() {
        this.mHandler.removeCallbacks(this.gOE);
        this.mHandler.removeCallbacks(this.gOF);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.koM);
    }

    public void JA(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.koB.getActivity());
        aVar.sS(str);
        aVar.a(R.string.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                an anVar = new an("c12137");
                anVar.cx("obj_locate", "1");
                TiebaStatic.log(anVar);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                an anVar = new an("c12137");
                anVar.cx("obj_locate", "2");
                TiebaStatic.log(anVar);
                aVar2.dismiss();
                com.baidu.tieba.j.a.bMT();
            }
        });
        aVar.b(this.koB.getPageContext()).aEG();
    }

    public void onDestroy() {
        cNv();
        if (bFL() != null) {
            bFL().reset();
        }
        cND();
        if (this.gHG != null) {
            this.gHG.onDestroy();
        }
        if (this.grD != null) {
            this.grD.bGI();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.koB).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.gHG == null) {
            this.gHG = new g(this.koB.getPageContext(), (NavigationBarCoverTip) this.koB.findViewById(R.id.navigation_cover_tip));
        }
        this.gHG.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.grD == null) {
                this.grD = new f(this.koB, this.koB.getActivityRootView());
            }
            this.grD.h(postWriteCallBackData);
        }
    }

    public void cNE() {
        this.isInterrupt = false;
        this.koQ = 1;
        if (cNB() != null) {
            cNB().dBW = this.koQ;
        }
    }
}
