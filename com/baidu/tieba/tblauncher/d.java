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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
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
    private com.baidu.tieba.video.f hIA;
    private h hZT;
    private ImageView hiU;
    private boolean jUh;
    private MainTabActivity lTC;
    private TextView lTG;
    private ImageView lTH;
    private ImageView lTI;
    private TextView lTJ;
    private ImageView lTK;
    private TextView lTL;
    private PopupWindow lTN;
    private MaintabBottomIndicator lTP;
    private MaintabBottomIndicator lTQ;
    private Runnable lTW;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean lTM = false;
    private int jUd = -1;
    private boolean lTO = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean eFf = true;
    private int lTR = 1;
    private boolean isInterrupt = false;
    private boolean lTS = false;
    private FragmentTabHost.a lTT = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b lF = d.this.mTabHost.lF(i);
            if (lF.mType == 8) {
                if (d.this.lTP != null && d.this.lTP.getAnimationView() != null && d.this.lTP.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new ap("c10605").ah("obj_type", 1));
                } else {
                    TiebaStatic.log(new ap("c10605").ah("obj_type", 0));
                }
                if (d.this.lTP != null) {
                    d.this.lTP.bks();
                }
                TiebaStatic.log("c13841");
            } else if (lF.mType == 3) {
                TiebaStatic.log(new ap(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).ah("obj_locate", 1));
                TiebaStatic.log(new ap(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ah("obj_locate", 1));
            }
            if (lF.mType == 2) {
                if (d.this.eFf) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.eFf = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.lTR != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.lTR == 1) {
                        d.this.lTQ.iU(d.this.eFf);
                    }
                } else {
                    d.this.lTQ.bkw();
                }
                d.this.isInterrupt = false;
            } else {
                d.this.isInterrupt = true;
                if (d.this.eFf) {
                    d.this.lTQ.iU(d.this.eFf);
                }
                d.this.eFf = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.dnu() != null) {
                d.this.dnu().eFf = d.this.eFf;
            }
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b lF = d.this.mTabHost.lF(i);
            if (lF.mType == 9) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new i(0)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (lF.mType == 8 && !bf.checkUpIsLogin(d.this.lTC.getActivity())) {
                if (d.this.lTP != null) {
                    d.this.lTP.bks();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (lF.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        bd.baV().a(d.this.lTC.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (lF.mType == 3 && !bf.checkUpIsLogin(d.this.lTC.getActivity())) {
                    return false;
                } else {
                    if (lF.mType == 1) {
                        TiebaStatic.log(new ap("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener lTU = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dnu() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.isInterrupt = true;
                        d.this.eFf = true;
                        if (d.this.lTR != 2) {
                            if (d.this.lTQ.isAnimating()) {
                                d.this.lTQ.iU(d.this.eFf);
                                return;
                            }
                            return;
                        }
                        d.this.dnu().bky();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.isInterrupt = false;
                        if (d.this.lTR == 1) {
                            return;
                        }
                    } else {
                        d.this.lTR = intValue;
                    }
                    if (d.this.lTR == 1) {
                        d.this.dnu().iU(d.this.eFf);
                    } else if (d.this.lTR == 2) {
                        d.this.dnu().bkw();
                    } else if (intValue == 5) {
                        d.this.lTR = 1;
                        d.this.eFf = true;
                        if (!d.this.isInterrupt) {
                            d.this.dnu().bky();
                        }
                    } else {
                        d.this.dnu().bkx();
                    }
                    d.this.dnu().eFe = true;
                    d.this.dnu().eFg = d.this.lTR;
                    d.this.dnu().eFf = d.this.eFf;
                }
            }
        }
    };
    private CustomMessageListener lTV = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.eFf = true;
            if (d.this.dnu() != null) {
                d.this.dnu().eFf = d.this.eFf;
            }
        }
    };
    private Runnable ihx = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.lTN != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.lTC.getActivity());
                int dimens = l.getDimens(d.this.lTC.getActivity(), R.dimen.ds178);
                View contentView = d.this.lTN.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b lG = d.this.mTabHost.lG(3);
                    if (lG != null && (tbFragmentTabIndicator = lG.dYX) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.lTC.getActivity(), R.dimen.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.lTN, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.lTO = true;
                        d.this.mHandler.postDelayed(d.this.ihy, 5000L);
                    }
                }
            }
        }
    };
    private Runnable ihy = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            d.this.dnw();
        }
    };
    private View.OnClickListener ihz = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dnw();
        }
    };

    public void setCurrentTabByType(int i) {
        cds().setCurrentTabByType(i);
        if (i != 2) {
            this.isInterrupt = true;
            if (this.eFf) {
                this.lTQ.iU(false);
            }
            this.eFf = false;
            if (dnu() != null) {
                dnu().eFf = this.eFf;
            }
        }
    }

    public d(MainTabActivity mainTabActivity) {
        this.lTC = mainTabActivity;
    }

    public void vv(boolean z) {
        this.mTabHost = (FragmentTabHost) this.lTC.findViewById(R.id.tab_host);
        this.mTabHost.setup(this.lTC.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.lTT);
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
                d.this.dnv();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.lF(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.hiU.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                if (d.this.mTabHost.getCurrentTabType() == 1 && !com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                d.this.jUd = d.this.mTabHost.getCurrentTabType();
                d.this.dnr();
                if (com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (d.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).dn("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.lTM = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        bmb();
        this.lTK = (ImageView) this.lTC.findViewById(R.id.home_page_new_write_icon);
        this.lTL = (TextView) this.lTC.findViewById(R.id.view_bottom_text);
        this.lTJ = (TextView) this.lTC.findViewById(R.id.activity_prize_my_tip);
        if (com.baidu.tbadk.a.d.aRN()) {
            this.mTabHost.setUIType(0);
            this.mTabHost.setTabContainerShadowShow(true);
            this.mTabHost.setBackGroundStyle(0);
            this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            dnq();
        } else {
            this.mTabHost.setUIType(1);
            this.mTabHost.setTabContainerShadowShow(false);
            this.mTabHost.setBackGroundStyle(1);
            this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight() + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds73));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.lTC.getPageContext()));
        switchNaviBarStatus(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.lTC.registerListener(this.lTU);
        }
        this.lTC.registerListener(this.lTV);
    }

    public void Oj(final String str) {
        if (StringUtils.isNull(str)) {
            this.lTJ.setVisibility(8);
            return;
        }
        FragmentTabHost.b lG = this.mTabHost.lG(8);
        if (lG != null) {
            if (!this.lTO || (this.lTN != null && this.lTN.isShowing())) {
                if (this.lTW == null) {
                    this.lTW = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.13
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.Oj(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.lTW);
                TbadkCoreApplication.getInst().handler.postDelayed(this.lTW, 5000L);
                return;
            }
            a(str, lG);
            return;
        }
        this.lTJ.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.dYX.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.lTC).widthPixels - (iArr[0] + (bVar.dYX.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lTJ.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.lTC.getPageContext().getPageActivity(), R.dimen.ds26);
        this.lTJ.setLayoutParams(layoutParams);
        this.lTJ.setVisibility(0);
        this.lTJ.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void dnn() {
        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.lTM);
    }

    public boolean dno() {
        return this.lTH != null && this.lTH.getVisibility() == 0;
    }

    public void vw(boolean z) {
        if (this.lTH != null) {
            if (z) {
                this.lTH.setVisibility(0);
            } else {
                this.lTH.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.setShouldDrawTopLine(false);
        }
        if (com.baidu.tbadk.a.d.aRN()) {
            if (this.mTabHost.getFragmentTabWidget() != null) {
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_h);
            }
        } else if (this.mTabHost.getFragmentTabWidget() != null) {
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.mTabHost.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.lTC.getPageContext(), i);
        ao.setNavbarTitleColor(this.lTG, R.color.cp_cont_b, R.color.s_navbar_title_color, i);
        ao.setImageResource(this.lTI, R.drawable.icon_news_down_bar_one);
        ao.setNavbarIconSrc(this.lTH, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        ao.setViewTextColor(this.lTL, R.color.cp_cont_f);
        SvgManager.baR().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.baR().a(this.hiU, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
                dnq();
                return;
            }
            this.mTabHost.showTabWidget();
            dnp();
        }
    }

    public void dnp() {
        if (!com.baidu.tbadk.a.d.aRN()) {
            if (this.lTK != null) {
                this.lTK.setVisibility(0);
            }
            if (this.lTL != null) {
                this.lTL.setVisibility(0);
            }
        }
    }

    public void dnq() {
        if (this.lTK != null) {
            this.lTK.setVisibility(8);
        }
        if (this.lTL != null) {
            this.lTL.setVisibility(8);
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.lTC.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            ao.setViewTextColor(textView, R.color.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.bih())) {
                textView.setText(payMemberInfoData.bih());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ao.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lTC.getPageContext().getPageActivity());
            aVar.aV(inflate);
            aVar.lo(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.lTC.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.lTC.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.lTC.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.lTC.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.lTC.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.lTC.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.lTC.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.hK(false);
            aVar.b(this.lTC.getPageContext()).aYL();
            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void dnr() {
        FragmentTabHost.b lG;
        if (this.mTabHost != null && (lG = this.mTabHost.lG(this.mTabHost.getCurrentTabType())) != null && lG.dYY != null && lG.dYY.getFragmentTabStructure() != null) {
            String string = this.lTC.getPageContext().getString(lG.dYY.getFragmentTabStructure().textResId);
            if (this.lTG != null) {
                this.lTG.setText(string);
            }
        }
    }

    public void bmb() {
        this.mNavigationBar = (NavigationBar) this.lTC.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.lTG = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.lTC.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.lTG.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.lTH = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.lTI = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.lTH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.vz(false);
                    d.this.lTI.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.lTC.getPageContext()));
                    TiebaStatic.eventStat(d.this.lTC.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.lTC.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.lTC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.lTC.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new ap(CommonStatisticKey.SEARCH_BAR_CLICK).ah("obj_type", i));
                }
            });
            this.hiU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.hiU.setLayoutParams(layoutParams2);
            this.hiU.setVisibility(8);
            this.hiU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.lTC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.lTC.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.lTC.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bf.skipToLoginActivity(d.this.lTC.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.lTC.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.jUd) {
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
                    TiebaStatic.log(new ap("c10517").dn("obj_source", str));
                    bf.skipToRegisterActivity(d.this.lTC.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void vx(boolean z) {
        if (z) {
            this.hiU.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.hiU.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void vy(boolean z) {
        if (dno()) {
            if (z) {
                if (this.lTI.getVisibility() != 0) {
                    this.lTI.setVisibility(0);
                    vz(true);
                    ao.setImageResource(this.lTI, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            vz(false);
            this.lTI.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vz(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lTH.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.lTC.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.lTC.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.lTH.setLayoutParams(layoutParams);
        }
    }

    public void aJ(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.lTC.getPageContext().getPageActivity()));
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

    public void rq(boolean z) {
        this.jUh = z;
        if (!this.jUh) {
            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean cGT() {
        return this.jUh;
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
                dnp();
                this.lTS = true;
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.eEX) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.lTP = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (bVar2.mType == 2) {
                this.lTQ = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.dYX = maintabBottomIndicator;
            bVar2.dYY = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost cds() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator dnt() {
        return this.lTP;
    }

    public MaintabBottomIndicator dnu() {
        return this.lTQ;
    }

    public void dnv() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void dnw() {
        this.mHandler.removeCallbacks(this.ihx);
        this.mHandler.removeCallbacks(this.ihy);
        g.dismissPopupWindow(this.lTN);
    }

    public void Ok(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lTC.getActivity());
        aVar.xl(str);
        aVar.a(R.string.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ap apVar = new ap("c12137");
                apVar.dn("obj_locate", "1");
                TiebaStatic.log(apVar);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ap apVar = new ap("c12137");
                apVar.dn("obj_locate", "2");
                TiebaStatic.log(apVar);
                aVar2.dismiss();
                com.baidu.tieba.j.a.ckW();
            }
        });
        aVar.b(this.lTC.getPageContext()).aYL();
    }

    public void onDestroy() {
        dnn();
        if (cds() != null) {
            cds().reset();
        }
        dnw();
        if (this.hZT != null) {
            this.hZT.onDestroy();
        }
        if (this.hIA != null) {
            this.hIA.ceq();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || as.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.lTC).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.hZT == null) {
            this.hZT = new h(this.lTC.getPageContext(), (NavigationBarCoverTip) this.lTC.findViewById(R.id.navigation_cover_tip));
        }
        this.hZT.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.hIA == null) {
                this.hIA = new com.baidu.tieba.video.f(this.lTC, this.lTC.getActivityRootView());
            }
            this.hIA.h(postWriteCallBackData);
        }
    }

    public void dnx() {
        this.isInterrupt = false;
        this.lTR = 1;
        if (dnu() != null) {
            dnu().eFg = this.lTR;
        }
    }
}
