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
import com.baidu.adp.lib.f.g;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.data.i;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.c.h;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes16.dex */
public class d {
    private com.baidu.tieba.video.f hVQ;
    private ImageView hvS;
    private h iod;
    private boolean kjF;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private PopupWindow mlB;
    private MaintabBottomIndicator mlD;
    private MaintabBottomIndicator mlE;
    private Runnable mlL;
    private MainTabActivity mlq;
    private TextView mlu;
    private ImageView mlv;
    private ImageView mlw;
    private TextView mlx;
    private ImageView mly;
    private TextView mlz;
    private boolean mlA = false;
    private int kjB = -1;
    private boolean mlC = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean ePI = true;
    private int mlF = 1;
    private boolean isInterrupt = false;
    private boolean mlG = false;
    private FragmentTabHost.a mlH = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b nL = d.this.mTabHost.nL(i);
            if (nL.mType == 8) {
                if (d.this.mlD != null && d.this.mlD.getAnimationView() != null && d.this.mlD.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new aq("c10605").ai("obj_type", 1));
                } else {
                    TiebaStatic.log(new aq("c10605").ai("obj_type", 0));
                }
                if (d.this.mlD != null) {
                    d.this.mlD.bte();
                }
                TiebaStatic.log("c13841");
            } else if (nL.mType == 3) {
                TiebaStatic.log(new aq(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).ai("obj_locate", 1));
                TiebaStatic.log(new aq(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ai("obj_locate", 1));
            }
            if (nL.mType == 2) {
                if (d.this.ePI) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.ePI = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.mlF != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.mlF == 1) {
                        d.this.mlE.js(d.this.ePI);
                    }
                } else {
                    d.this.mlE.bti();
                }
                d.this.isInterrupt = false;
            } else {
                d.this.isInterrupt = true;
                if (d.this.ePI) {
                    d.this.mlE.js(d.this.ePI);
                }
                d.this.ePI = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.dyQ() != null) {
                d.this.dyQ().ePI = d.this.ePI;
            }
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b nL = d.this.mTabHost.nL(i);
            if (nL.mType == 9) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new i(0)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (nL.mType == 8 && !bg.checkUpIsLogin(d.this.mlq.getActivity())) {
                if (d.this.mlD != null) {
                    d.this.mlD.bte();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (nL.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        be.bju().a(d.this.mlq.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (nL.mType == 3 && !bg.checkUpIsLogin(d.this.mlq.getActivity())) {
                    return false;
                } else {
                    if (nL.mType == 1) {
                        TiebaStatic.log(new aq("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener mlI = new CustomMessageListener(2921492) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.mainTab.c cVar;
            if (customResponsedMessage != null && d.this.mTabHost != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.c) && (cVar = (com.baidu.tbadk.mainTab.c) customResponsedMessage.getData()) != null && d.this.mTabHost.nM(cVar.type) != null) {
                FragmentTabHost.b nM = d.this.mTabHost.nM(cVar.type);
                if (nM.eiD instanceof MaintabBottomIndicator) {
                    ((MaintabBottomIndicator) nM.eiD).setImageIconUrl(cVar.ePy, cVar.text);
                }
            }
        }
    };
    private CustomMessageListener mlJ = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dyQ() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.isInterrupt = true;
                        d.this.ePI = true;
                        if (d.this.mlF != 2) {
                            if (d.this.mlE.isAnimating()) {
                                d.this.mlE.js(d.this.ePI);
                                return;
                            }
                            return;
                        }
                        d.this.dyQ().btk();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.isInterrupt = false;
                        if (d.this.mlF == 1) {
                            return;
                        }
                    } else {
                        d.this.mlF = intValue;
                    }
                    if (d.this.mlF == 1) {
                        d.this.dyQ().js(d.this.ePI);
                    } else if (d.this.mlF == 2) {
                        d.this.dyQ().bti();
                    } else if (intValue == 5) {
                        d.this.mlF = 1;
                        d.this.ePI = true;
                        if (!d.this.isInterrupt) {
                            d.this.dyQ().btk();
                        }
                    } else {
                        d.this.dyQ().btj();
                    }
                    d.this.dyQ().ePH = true;
                    d.this.dyQ().ePJ = d.this.mlF;
                    d.this.dyQ().ePI = d.this.ePI;
                }
            }
        }
    };
    private CustomMessageListener mlK = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.ePI = true;
            if (d.this.dyQ() != null) {
                d.this.dyQ().ePI = d.this.ePI;
            }
        }
    };
    private Runnable ivE = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.mlB != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.mlq.getActivity());
                int dimens = l.getDimens(d.this.mlq.getActivity(), R.dimen.ds178);
                View contentView = d.this.mlB.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b nM = d.this.mTabHost.nM(3);
                    if (nM != null && (tbFragmentTabIndicator = nM.eiD) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.mlq.getActivity(), R.dimen.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.mlB, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.mlC = true;
                        d.this.mHandler.postDelayed(d.this.ivF, 5000L);
                    }
                }
            }
        }
    };
    private Runnable ivF = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // java.lang.Runnable
        public void run() {
            d.this.dyS();
        }
    };
    private View.OnClickListener ivG = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dyS();
        }
    };

    public void setCurrentTabByType(int i) {
        cnR().setCurrentTabByType(i);
        if (i != 2) {
            this.isInterrupt = true;
            if (this.ePI) {
                this.mlE.js(false);
            }
            this.ePI = false;
            if (dyQ() != null) {
                dyQ().ePI = this.ePI;
            }
        }
    }

    public d(MainTabActivity mainTabActivity) {
        this.mlq = mainTabActivity;
    }

    public void wk(boolean z) {
        this.mTabHost = (FragmentTabHost) this.mlq.findViewById(R.id.tab_host);
        this.mTabHost.setup(this.mlq.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.mlH);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.setShouldDrawIndicatorLine(false);
            this.mTabHost.setShouldDrawTopLine(true);
        }
        this.mTabHost.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.d.14
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (d.this.mTabHost.getCurrentTabType() != 2) {
                    if (d.this.mTabHost.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                d.this.dyR();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.nL(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.hvS.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                if (d.this.mTabHost.getCurrentTabType() == 1 && !com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                d.this.kjB = d.this.mTabHost.getCurrentTabType();
                d.this.dyO();
                if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (d.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).dD("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.mlA = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        buO();
        this.mly = (ImageView) this.mlq.findViewById(R.id.home_page_new_write_icon);
        this.mlz = (TextView) this.mlq.findViewById(R.id.view_bottom_text);
        this.mlx = (TextView) this.mlq.findViewById(R.id.activity_prize_my_tip);
        this.mTabHost.setUIType(0);
        this.mTabHost.setTabContainerShadowShow(true);
        this.mTabHost.setBackGroundStyle(0);
        this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        dyN();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.mlq.getPageContext()));
        switchNaviBarStatus(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.mlq.registerListener(this.mlJ);
        }
        this.mlq.registerListener(this.mlK);
        this.mlq.registerListener(this.mlI);
    }

    public void Rh(final String str) {
        if (StringUtils.isNull(str)) {
            this.mlx.setVisibility(8);
            return;
        }
        FragmentTabHost.b nM = this.mTabHost.nM(8);
        if (nM != null) {
            if (!this.mlC || (this.mlB != null && this.mlB.isShowing())) {
                if (this.mlL == null) {
                    this.mlL = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.15
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.Rh(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.mlL);
                TbadkCoreApplication.getInst().handler.postDelayed(this.mlL, 5000L);
                return;
            }
            a(str, nM);
            return;
        }
        this.mlx.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.eiD.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.mlq).widthPixels - (iArr[0] + (bVar.eiD.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mlx.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.mlq.getPageContext().getPageActivity(), R.dimen.ds26);
        this.mlx.setLayoutParams(layoutParams);
        this.mlx.setVisibility(0);
        this.mlx.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void dyL() {
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.mlA);
    }

    public boolean dyM() {
        return this.mlv != null && this.mlv.getVisibility() == 0;
    }

    public void wl(boolean z) {
        if (this.mlv != null) {
            if (z) {
                this.mlv.setVisibility(0);
            } else {
                this.mlv.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.setShouldDrawTopLine(false);
        }
        if (this.mTabHost.getFragmentTabWidget() != null) {
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_h);
        }
        this.mTabHost.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.mlq.getPageContext(), i);
        ap.setNavbarTitleColor(this.mlu, R.color.cp_cont_b, R.color.s_navbar_title_color, i);
        ap.setImageResource(this.mlw, R.drawable.icon_news_down_bar_one);
        ap.setNavbarIconSrc(this.mlv, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        ap.setViewTextColor(this.mlz, R.color.cp_cont_f);
        SvgManager.bjq().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bjq().a(this.hvS, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
                dyN();
                return;
            }
            this.mTabHost.showTabWidget();
        }
    }

    public void dyN() {
        if (this.mly != null) {
            this.mly.setVisibility(8);
        }
        if (this.mlz != null) {
            this.mlz.setVisibility(8);
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.mlq.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            ap.setViewTextColor(textView, R.color.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.bqT())) {
                textView.setText(payMemberInfoData.bqT());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ap.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mlq.getPageContext().getPageActivity());
            aVar.aX(inflate);
            aVar.nu(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.mlq.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.mlq.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.mlq.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.mlq.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.mlq.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.mlq.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.mlq.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.ig(false);
            aVar.b(this.mlq.getPageContext()).bhg();
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void dyO() {
        FragmentTabHost.b nM;
        if (this.mTabHost != null && (nM = this.mTabHost.nM(this.mTabHost.getCurrentTabType())) != null && nM.eiE != null && nM.eiE.getFragmentTabStructure() != null) {
            String string = this.mlq.getPageContext().getString(nM.eiE.getFragmentTabStructure().textResId);
            if (this.mlu != null) {
                this.mlu.setText(string);
            }
        }
    }

    public void buO() {
        this.mNavigationBar = (NavigationBar) this.mlq.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.mlu = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.mlq.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.mlu.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.mlv = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.mlw = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.mlv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.wo(false);
                    d.this.mlw.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.mlq.getPageContext()));
                    TiebaStatic.eventStat(d.this.mlq.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.mlq.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.mlq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.mlq.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new aq(CommonStatisticKey.SEARCH_BAR_CLICK).ai("obj_type", i));
                }
            });
            this.hvS = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.hvS.setLayoutParams(layoutParams2);
            this.hvS.setVisibility(8);
            this.hvS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.mlq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.mlq.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mlq.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bg.skipToLoginActivity(d.this.mlq.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mlq.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.kjB) {
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
                    TiebaStatic.log(new aq("c10517").dD("obj_source", str));
                    bg.skipToRegisterActivity(d.this.mlq.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void wm(boolean z) {
        if (z) {
            this.hvS.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.hvS.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void wn(boolean z) {
        if (dyM()) {
            if (z) {
                if (this.mlw.getVisibility() != 0) {
                    this.mlw.setVisibility(0);
                    wo(true);
                    ap.setImageResource(this.mlw, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            wo(false);
            this.mlw.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wo(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mlv.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.mlq.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.mlq.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.mlv.setLayoutParams(layoutParams);
        }
    }

    public void aP(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.mlq.getPageContext().getPageActivity()));
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

    public void rW(boolean z) {
        this.kjF = z;
        if (!this.kjF) {
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean cRI() {
        return this.kjF;
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
                this.mlG = true;
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.ePz) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.mlD = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (!at.isEmpty(cVar.ePy)) {
                maintabBottomIndicator.setImageIconUrl(cVar.ePy, cVar.text);
            }
            if (bVar2.mType == 2) {
                this.mlE = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.eiD = maintabBottomIndicator;
            bVar2.eiE = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost cnR() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator dyP() {
        return this.mlD;
    }

    public MaintabBottomIndicator dyQ() {
        return this.mlE;
    }

    public void dyR() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void dyS() {
        this.mHandler.removeCallbacks(this.ivE);
        this.mHandler.removeCallbacks(this.ivF);
        g.dismissPopupWindow(this.mlB);
    }

    public void Ri(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mlq.getActivity());
        aVar.zz(str);
        aVar.a(R.string.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aq aqVar = new aq("c12137");
                aqVar.dD("obj_locate", "1");
                TiebaStatic.log(aqVar);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aq aqVar = new aq("c12137");
                aqVar.dD("obj_locate", "2");
                TiebaStatic.log(aqVar);
                aVar2.dismiss();
                com.baidu.tieba.j.a.cvF();
            }
        });
        aVar.b(this.mlq.getPageContext()).bhg();
    }

    public void onDestroy() {
        dyL();
        if (cnR() != null) {
            cnR().reset();
        }
        dyS();
        if (this.iod != null) {
            this.iod.onDestroy();
        }
        if (this.hVQ != null) {
            this.hVQ.coU();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.mlq).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.iod == null) {
            this.iod = new h(this.mlq.getPageContext(), (NavigationBarCoverTip) this.mlq.findViewById(R.id.navigation_cover_tip));
        }
        this.iod.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.hVQ == null) {
                this.hVQ = new com.baidu.tieba.video.f(this.mlq, this.mlq.getActivityRootView());
            }
            this.hVQ.i(postWriteCallBackData);
        }
    }

    public void dyT() {
        this.isInterrupt = false;
        this.mlF = 1;
        if (dyQ() != null) {
            dyQ().ePJ = this.mlF;
        }
    }
}
