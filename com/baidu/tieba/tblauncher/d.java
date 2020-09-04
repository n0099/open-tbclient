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
    private com.baidu.tieba.video.f hVW;
    private ImageView hvY;
    private h ioj;
    private boolean kjM;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private MainTabActivity mlI;
    private TextView mlM;
    private ImageView mlN;
    private ImageView mlO;
    private TextView mlP;
    private ImageView mlQ;
    private TextView mlR;
    private PopupWindow mlT;
    private MaintabBottomIndicator mlV;
    private MaintabBottomIndicator mlW;
    private Runnable mmd;
    private boolean mlS = false;
    private int kjI = -1;
    private boolean mlU = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean ePM = true;
    private int mlX = 1;
    private boolean isInterrupt = false;
    private boolean mlY = false;
    private FragmentTabHost.a mlZ = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b nL = d.this.mTabHost.nL(i);
            if (nL.mType == 8) {
                if (d.this.mlV != null && d.this.mlV.getAnimationView() != null && d.this.mlV.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new aq("c10605").ai("obj_type", 1));
                } else {
                    TiebaStatic.log(new aq("c10605").ai("obj_type", 0));
                }
                if (d.this.mlV != null) {
                    d.this.mlV.btf();
                }
                TiebaStatic.log("c13841");
            } else if (nL.mType == 3) {
                TiebaStatic.log(new aq(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).ai("obj_locate", 1));
                TiebaStatic.log(new aq(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ai("obj_locate", 1));
            }
            if (nL.mType == 2) {
                if (d.this.ePM) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.ePM = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.mlX != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.mlX == 1) {
                        d.this.mlW.ju(d.this.ePM);
                    }
                } else {
                    d.this.mlW.btj();
                }
                d.this.isInterrupt = false;
            } else {
                d.this.isInterrupt = true;
                if (d.this.ePM) {
                    d.this.mlW.ju(d.this.ePM);
                }
                d.this.ePM = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.dyZ() != null) {
                d.this.dyZ().ePM = d.this.ePM;
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
            } else if (nL.mType == 8 && !bg.checkUpIsLogin(d.this.mlI.getActivity())) {
                if (d.this.mlV != null) {
                    d.this.mlV.btf();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (nL.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        be.bju().a(d.this.mlI.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (nL.mType == 3 && !bg.checkUpIsLogin(d.this.mlI.getActivity())) {
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
    private CustomMessageListener mma = new CustomMessageListener(2921492) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.mainTab.c cVar;
            if (customResponsedMessage != null && d.this.mTabHost != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.c) && (cVar = (com.baidu.tbadk.mainTab.c) customResponsedMessage.getData()) != null && d.this.mTabHost.nM(cVar.type) != null) {
                FragmentTabHost.b nM = d.this.mTabHost.nM(cVar.type);
                if (nM.eiH instanceof MaintabBottomIndicator) {
                    ((MaintabBottomIndicator) nM.eiH).setImageIconUrl(cVar.ePC, cVar.text);
                }
            }
        }
    };
    private CustomMessageListener mmb = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dyZ() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.isInterrupt = true;
                        d.this.ePM = true;
                        if (d.this.mlX != 2) {
                            if (d.this.mlW.isAnimating()) {
                                d.this.mlW.ju(d.this.ePM);
                                return;
                            }
                            return;
                        }
                        d.this.dyZ().btl();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.isInterrupt = false;
                        if (d.this.mlX == 1) {
                            return;
                        }
                    } else {
                        d.this.mlX = intValue;
                    }
                    if (d.this.mlX == 1) {
                        d.this.dyZ().ju(d.this.ePM);
                    } else if (d.this.mlX == 2) {
                        d.this.dyZ().btj();
                    } else if (intValue == 5) {
                        d.this.mlX = 1;
                        d.this.ePM = true;
                        if (!d.this.isInterrupt) {
                            d.this.dyZ().btl();
                        }
                    } else {
                        d.this.dyZ().btk();
                    }
                    d.this.dyZ().ePL = true;
                    d.this.dyZ().ePN = d.this.mlX;
                    d.this.dyZ().ePM = d.this.ePM;
                }
            }
        }
    };
    private CustomMessageListener mmc = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.ePM = true;
            if (d.this.dyZ() != null) {
                d.this.dyZ().ePM = d.this.ePM;
            }
        }
    };
    private Runnable ivK = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.mlT != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.mlI.getActivity());
                int dimens = l.getDimens(d.this.mlI.getActivity(), R.dimen.ds178);
                View contentView = d.this.mlT.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b nM = d.this.mTabHost.nM(3);
                    if (nM != null && (tbFragmentTabIndicator = nM.eiH) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.mlI.getActivity(), R.dimen.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.mlT, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.mlU = true;
                        d.this.mHandler.postDelayed(d.this.ivL, 5000L);
                    }
                }
            }
        }
    };
    private Runnable ivL = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // java.lang.Runnable
        public void run() {
            d.this.dzb();
        }
    };
    private View.OnClickListener ivM = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dzb();
        }
    };

    public void setCurrentTabByType(int i) {
        cnS().setCurrentTabByType(i);
        if (i != 2) {
            this.isInterrupt = true;
            if (this.ePM) {
                this.mlW.ju(false);
            }
            this.ePM = false;
            if (dyZ() != null) {
                dyZ().ePM = this.ePM;
            }
        }
    }

    public d(MainTabActivity mainTabActivity) {
        this.mlI = mainTabActivity;
    }

    public void wm(boolean z) {
        this.mTabHost = (FragmentTabHost) this.mlI.findViewById(R.id.tab_host);
        this.mTabHost.setup(this.mlI.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.mlZ);
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
                d.this.dza();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.nL(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.hvY.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                if (d.this.mTabHost.getCurrentTabType() == 1 && !com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                d.this.kjI = d.this.mTabHost.getCurrentTabType();
                d.this.dyX();
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
        this.mlS = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        buP();
        this.mlQ = (ImageView) this.mlI.findViewById(R.id.home_page_new_write_icon);
        this.mlR = (TextView) this.mlI.findViewById(R.id.view_bottom_text);
        this.mlP = (TextView) this.mlI.findViewById(R.id.activity_prize_my_tip);
        this.mTabHost.setUIType(0);
        this.mTabHost.setTabContainerShadowShow(true);
        this.mTabHost.setBackGroundStyle(0);
        this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        dyW();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.mlI.getPageContext()));
        switchNaviBarStatus(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.mlI.registerListener(this.mmb);
        }
        this.mlI.registerListener(this.mmc);
        this.mlI.registerListener(this.mma);
    }

    public void Rh(final String str) {
        if (StringUtils.isNull(str)) {
            this.mlP.setVisibility(8);
            return;
        }
        FragmentTabHost.b nM = this.mTabHost.nM(8);
        if (nM != null) {
            if (!this.mlU || (this.mlT != null && this.mlT.isShowing())) {
                if (this.mmd == null) {
                    this.mmd = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.15
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.Rh(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.mmd);
                TbadkCoreApplication.getInst().handler.postDelayed(this.mmd, 5000L);
                return;
            }
            a(str, nM);
            return;
        }
        this.mlP.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.eiH.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.mlI).widthPixels - (iArr[0] + (bVar.eiH.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mlP.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.mlI.getPageContext().getPageActivity(), R.dimen.ds26);
        this.mlP.setLayoutParams(layoutParams);
        this.mlP.setVisibility(0);
        this.mlP.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void dyU() {
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.mlS);
    }

    public boolean dyV() {
        return this.mlN != null && this.mlN.getVisibility() == 0;
    }

    public void wn(boolean z) {
        if (this.mlN != null) {
            if (z) {
                this.mlN.setVisibility(0);
            } else {
                this.mlN.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.mlI.getPageContext(), i);
        ap.setNavbarTitleColor(this.mlM, R.color.cp_cont_b, R.color.s_navbar_title_color, i);
        ap.setImageResource(this.mlO, R.drawable.icon_news_down_bar_one);
        ap.setNavbarIconSrc(this.mlN, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        ap.setViewTextColor(this.mlR, R.color.cp_cont_f);
        SvgManager.bjq().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bjq().a(this.hvY, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
                dyW();
                return;
            }
            this.mTabHost.showTabWidget();
        }
    }

    public void dyW() {
        if (this.mlQ != null) {
            this.mlQ.setVisibility(8);
        }
        if (this.mlR != null) {
            this.mlR.setVisibility(8);
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.mlI.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            ap.setViewTextColor(textView, R.color.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.bqU())) {
                textView.setText(payMemberInfoData.bqU());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ap.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mlI.getPageContext().getPageActivity());
            aVar.aX(inflate);
            aVar.nu(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.mlI.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.mlI.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.mlI.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.mlI.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.mlI.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.mlI.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.mlI.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.ih(false);
            aVar.b(this.mlI.getPageContext()).bhg();
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void dyX() {
        FragmentTabHost.b nM;
        if (this.mTabHost != null && (nM = this.mTabHost.nM(this.mTabHost.getCurrentTabType())) != null && nM.eiI != null && nM.eiI.getFragmentTabStructure() != null) {
            String string = this.mlI.getPageContext().getString(nM.eiI.getFragmentTabStructure().textResId);
            if (this.mlM != null) {
                this.mlM.setText(string);
            }
        }
    }

    public void buP() {
        this.mNavigationBar = (NavigationBar) this.mlI.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.mlM = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.mlI.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.mlM.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.mlN = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.mlO = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.mlN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.wq(false);
                    d.this.mlO.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.mlI.getPageContext()));
                    TiebaStatic.eventStat(d.this.mlI.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.mlI.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.mlI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.mlI.getPageContext().getPageActivity())));
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
            this.hvY = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.hvY.setLayoutParams(layoutParams2);
            this.hvY.setVisibility(8);
            this.hvY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.mlI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.mlI.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mlI.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bg.skipToLoginActivity(d.this.mlI.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mlI.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.kjI) {
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
                    bg.skipToRegisterActivity(d.this.mlI.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void wo(boolean z) {
        if (z) {
            this.hvY.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.hvY.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void wp(boolean z) {
        if (dyV()) {
            if (z) {
                if (this.mlO.getVisibility() != 0) {
                    this.mlO.setVisibility(0);
                    wq(true);
                    ap.setImageResource(this.mlO, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            wq(false);
            this.mlO.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wq(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mlN.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.mlI.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.mlI.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.mlN.setLayoutParams(layoutParams);
        }
    }

    public void aP(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.mlI.getPageContext().getPageActivity()));
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

    public void rY(boolean z) {
        this.kjM = z;
        if (!this.kjM) {
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean cRJ() {
        return this.kjM;
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
                this.mlY = true;
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.ePD) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.mlV = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (!at.isEmpty(cVar.ePC)) {
                maintabBottomIndicator.setImageIconUrl(cVar.ePC, cVar.text);
            }
            if (bVar2.mType == 2) {
                this.mlW = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.eiH = maintabBottomIndicator;
            bVar2.eiI = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost cnS() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator dyY() {
        return this.mlV;
    }

    public MaintabBottomIndicator dyZ() {
        return this.mlW;
    }

    public void dza() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void dzb() {
        this.mHandler.removeCallbacks(this.ivK);
        this.mHandler.removeCallbacks(this.ivL);
        g.dismissPopupWindow(this.mlT);
    }

    public void Ri(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mlI.getActivity());
        aVar.zA(str);
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
                com.baidu.tieba.j.a.cvG();
            }
        });
        aVar.b(this.mlI.getPageContext()).bhg();
    }

    public void onDestroy() {
        dyU();
        if (cnS() != null) {
            cnS().reset();
        }
        dzb();
        if (this.ioj != null) {
            this.ioj.onDestroy();
        }
        if (this.hVW != null) {
            this.hVW.coV();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.mlI).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.ioj == null) {
            this.ioj = new h(this.mlI.getPageContext(), (NavigationBarCoverTip) this.mlI.findViewById(R.id.navigation_cover_tip));
        }
        this.ioj.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.hVW == null) {
                this.hVW = new com.baidu.tieba.video.f(this.mlI, this.mlI.getActivityRootView());
            }
            this.hVW.i(postWriteCallBackData);
        }
    }

    public void dzc() {
        this.isInterrupt = false;
        this.mlX = 1;
        if (dyZ() != null) {
            dyZ().ePN = this.mlX;
        }
    }
}
