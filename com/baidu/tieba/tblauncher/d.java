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
import com.baidu.tbadk.data.j;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.c.h;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes22.dex */
public class d {
    private com.baidu.tieba.video.f iKq;
    private ImageView ikw;
    private h jcL;
    private boolean kZQ;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private ImageView ndA;
    private ImageView ndB;
    private TextView ndC;
    private ImageView ndD;
    private TextView ndE;
    private PopupWindow ndG;
    private MaintabBottomIndicator ndI;
    private MaintabBottomIndicator ndJ;
    private Runnable ndQ;
    private MainTabActivity ndv;
    private TextView ndz;
    private boolean ndF = false;
    private int kZM = -1;
    private boolean ndH = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean ftd = true;
    private int ndK = 1;
    private boolean isInterrupt = false;
    private boolean ndL = false;
    private FragmentTabHost.a ndM = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b oP = d.this.mTabHost.oP(i);
            if (oP.mType == 8) {
                if (d.this.ndI != null && d.this.ndI.getAnimationView() != null && d.this.ndI.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new aq("c10605").al("obj_type", 1));
                } else {
                    TiebaStatic.log(new aq("c10605").al("obj_type", 0));
                }
                if (d.this.ndI != null) {
                    d.this.ndI.bBl();
                }
                TiebaStatic.log("c13841");
            } else if (oP.mType == 3) {
                TiebaStatic.log(new aq(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).al("obj_locate", 1));
                TiebaStatic.log(new aq(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).al("obj_locate", 1));
            }
            if (oP.mType == 2) {
                if (d.this.ftd) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.ftd = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.ndK != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.ndK == 1) {
                        d.this.ndJ.kp(d.this.ftd);
                    }
                } else {
                    d.this.ndJ.bBp();
                }
                d.this.isInterrupt = false;
            } else {
                d.this.isInterrupt = true;
                if (d.this.ftd) {
                    d.this.ndJ.kp(d.this.ftd);
                }
                d.this.ftd = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.dMp() != null) {
                d.this.dMp().ftd = d.this.ftd;
            }
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b oP = d.this.mTabHost.oP(i);
            if (oP.mType == 9) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new j(0)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (oP.mType == 8 && !bg.checkUpIsLogin(d.this.ndv.getActivity())) {
                if (d.this.ndI != null) {
                    d.this.ndI.bBl();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (oP.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        be.brr().a(d.this.ndv.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (oP.mType == 3 && !bg.checkUpIsLogin(d.this.ndv.getActivity())) {
                    return false;
                } else {
                    if (oP.mType == 1) {
                        TiebaStatic.log(new aq("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener ndN = new CustomMessageListener(2921492) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.mainTab.c cVar;
            if (customResponsedMessage != null && d.this.mTabHost != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.c) && (cVar = (com.baidu.tbadk.mainTab.c) customResponsedMessage.getData()) != null && d.this.mTabHost.oQ(cVar.type) != null && d.this.mTabHost.getCurrentTabType() != 21) {
                FragmentTabHost.b oQ = d.this.mTabHost.oQ(cVar.type);
                if (oQ.eLs instanceof MaintabBottomIndicator) {
                    ((MaintabBottomIndicator) oQ.eLs).setImageIconUrl(cVar.fsT, cVar.text);
                }
            }
        }
    };
    private CustomMessageListener ndO = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dMp() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.isInterrupt = true;
                        d.this.ftd = true;
                        if (d.this.ndK != 2) {
                            if (d.this.ndJ.isAnimating()) {
                                d.this.ndJ.kp(d.this.ftd);
                                return;
                            }
                            return;
                        }
                        d.this.dMp().bBr();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.isInterrupt = false;
                        if (d.this.ndK == 1) {
                            return;
                        }
                    } else {
                        d.this.ndK = intValue;
                    }
                    if (d.this.ndK == 1) {
                        d.this.dMp().kp(d.this.ftd);
                    } else if (d.this.ndK == 2) {
                        d.this.dMp().bBp();
                    } else if (intValue == 5) {
                        d.this.ndK = 1;
                        d.this.ftd = true;
                        if (!d.this.isInterrupt) {
                            d.this.dMp().bBr();
                        }
                    } else {
                        d.this.dMp().bBq();
                    }
                    d.this.dMp().ftc = true;
                    d.this.dMp().fte = d.this.ndK;
                    d.this.dMp().ftd = d.this.ftd;
                }
            }
        }
    };
    private CustomMessageListener ndP = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.ftd = true;
            if (d.this.dMp() != null) {
                d.this.dMp().ftd = d.this.ftd;
            }
        }
    };
    private Runnable jkq = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.ndG != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.ndv.getActivity());
                int dimens = l.getDimens(d.this.ndv.getActivity(), R.dimen.ds178);
                View contentView = d.this.ndG.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b oQ = d.this.mTabHost.oQ(3);
                    if (oQ != null && (tbFragmentTabIndicator = oQ.eLs) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.ndv.getActivity(), R.dimen.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.ndG, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.ndH = true;
                        d.this.mHandler.postDelayed(d.this.jkr, 5000L);
                    }
                }
            }
        }
    };
    private Runnable jkr = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // java.lang.Runnable
        public void run() {
            d.this.dMr();
        }
    };
    private View.OnClickListener jks = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dMr();
        }
    };

    public void setCurrentTabByType(int i) {
        cAl().setCurrentTabByType(i);
        if (i != 2) {
            this.isInterrupt = true;
            if (this.ftd) {
                this.ndJ.kp(false);
            }
            this.ftd = false;
            if (dMp() != null) {
                dMp().ftd = this.ftd;
            }
        }
    }

    public d(MainTabActivity mainTabActivity) {
        this.ndv = mainTabActivity;
    }

    public void xC(boolean z) {
        this.mTabHost = (FragmentTabHost) this.ndv.findViewById(R.id.tab_host);
        this.mTabHost.setup(this.ndv.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.ndM);
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
                d.this.dMq();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.oP(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.ikw.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                if (d.this.mTabHost.getCurrentTabType() == 1 && !com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                d.this.kZM = d.this.mTabHost.getCurrentTabType();
                d.this.dMn();
                if (com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (d.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).dR("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.ndF = com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        bCV();
        this.ndD = (ImageView) this.ndv.findViewById(R.id.home_page_new_write_icon);
        this.ndE = (TextView) this.ndv.findViewById(R.id.view_bottom_text);
        this.ndC = (TextView) this.ndv.findViewById(R.id.activity_prize_my_tip);
        this.mTabHost.setUIType(0);
        this.mTabHost.setTabContainerShadowShow(true);
        this.mTabHost.setBackGroundStyle(0);
        this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        dMm();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.ndv.getPageContext()));
        switchNaviBarStatus(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.ndv.registerListener(this.ndO);
        }
        this.ndv.registerListener(this.ndP);
        this.ndv.registerListener(this.ndN);
    }

    public void Tl(final String str) {
        if (StringUtils.isNull(str)) {
            this.ndC.setVisibility(8);
            return;
        }
        FragmentTabHost.b oQ = this.mTabHost.oQ(8);
        if (oQ != null) {
            if (!this.ndH || (this.ndG != null && this.ndG.isShowing())) {
                if (this.ndQ == null) {
                    this.ndQ = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.15
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.Tl(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.ndQ);
                TbadkCoreApplication.getInst().handler.postDelayed(this.ndQ, 5000L);
                return;
            }
            a(str, oQ);
            return;
        }
        this.ndC.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.eLs.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.ndv).widthPixels - (iArr[0] + (bVar.eLs.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ndC.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.ndv.getPageContext().getPageActivity(), R.dimen.ds26);
        this.ndC.setLayoutParams(layoutParams);
        this.ndC.setVisibility(0);
        this.ndC.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void dMk() {
        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.ndF);
    }

    public boolean dMl() {
        return this.ndA != null && this.ndA.getVisibility() == 0;
    }

    public void xD(boolean z) {
        if (this.ndA != null) {
            if (z) {
                this.ndA.setVisibility(0);
            } else {
                this.ndA.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.ndv.getPageContext(), i);
        ap.setNavbarTitleColor(this.ndz, R.color.cp_cont_b, R.color.s_navbar_title_color, i);
        ap.setImageResource(this.ndB, R.drawable.icon_news_down_bar_one);
        ap.setNavbarIconSrc(this.ndA, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        ap.setViewTextColor(this.ndE, R.color.cp_cont_f);
        SvgManager.brn().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.brn().a(this.ikw, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
                dMm();
                return;
            }
            this.mTabHost.showTabWidget();
        }
    }

    public void dMm() {
        if (this.ndD != null) {
            this.ndD.setVisibility(8);
        }
        if (this.ndE != null) {
            this.ndE.setVisibility(8);
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.ndv.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            ap.setViewTextColor(textView, R.color.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.byQ())) {
                textView.setText(payMemberInfoData.byQ());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ap.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ndv.getPageContext().getPageActivity());
            aVar.bf(inflate);
            aVar.ox(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.ndv.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.ndv.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.ndv.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.ndv.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.ndv.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.ndv.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.ndv.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.iW(false);
            aVar.b(this.ndv.getPageContext()).bpc();
            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void dMn() {
        FragmentTabHost.b oQ;
        if (this.mTabHost != null && (oQ = this.mTabHost.oQ(this.mTabHost.getCurrentTabType())) != null && oQ.eLt != null && oQ.eLt.getFragmentTabStructure() != null) {
            String string = this.ndv.getPageContext().getString(oQ.eLt.getFragmentTabStructure().textResId);
            if (this.ndz != null) {
                this.ndz.setText(string);
            }
        }
    }

    public void bCV() {
        this.mNavigationBar = (NavigationBar) this.ndv.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.ndz = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.ndv.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.ndz.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.ndA = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.ndB = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.ndA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.xG(false);
                    d.this.ndB.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.ndv.getPageContext()));
                    TiebaStatic.eventStat(d.this.ndv.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.ndv.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.ndv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.ndv.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new aq(CommonStatisticKey.SEARCH_BAR_CLICK).al("obj_type", i));
                }
            });
            this.ikw = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.ikw.setLayoutParams(layoutParams2);
            this.ikw.setVisibility(8);
            this.ikw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.ndv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.ndv.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.ndv.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bg.skipToLoginActivity(d.this.ndv.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.ndv.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.kZM) {
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
                    TiebaStatic.log(new aq("c10517").dR("obj_source", str));
                    bg.skipToRegisterActivity(d.this.ndv.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void xE(boolean z) {
        if (z) {
            this.ikw.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.ikw.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void xF(boolean z) {
        if (dMl()) {
            if (z) {
                if (this.ndB.getVisibility() != 0) {
                    this.ndB.setVisibility(0);
                    xG(true);
                    ap.setImageResource(this.ndB, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            xG(false);
            this.ndB.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xG(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ndA.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.ndv.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.ndv.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.ndA.setLayoutParams(layoutParams);
        }
    }

    public void aU(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.ndv.getPageContext().getPageActivity()));
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

    public void tn(boolean z) {
        this.kZQ = z;
        if (!this.kZQ) {
            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean deI() {
        return this.kZQ;
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
                this.ndL = true;
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.fsU) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.ndI = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (!at.isEmpty(cVar.fsT)) {
                maintabBottomIndicator.setImageIconUrl(cVar.fsT, cVar.text);
            }
            if (bVar2.mType == 2) {
                this.ndJ = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.eLs = maintabBottomIndicator;
            bVar2.eLt = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost cAl() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator dMo() {
        return this.ndI;
    }

    public MaintabBottomIndicator dMp() {
        return this.ndJ;
    }

    public void dMq() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void dMr() {
        this.mHandler.removeCallbacks(this.jkq);
        this.mHandler.removeCallbacks(this.jkr);
        g.dismissPopupWindow(this.ndG);
    }

    public void Tm(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ndv.getActivity());
        aVar.Bo(str);
        aVar.a(R.string.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aq aqVar = new aq("c12137");
                aqVar.dR("obj_locate", "1");
                TiebaStatic.log(aqVar);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aq aqVar = new aq("c12137");
                aqVar.dR("obj_locate", "2");
                TiebaStatic.log(aqVar);
                aVar2.dismiss();
                com.baidu.tieba.j.a.cIf();
            }
        });
        aVar.b(this.ndv.getPageContext()).bpc();
    }

    public void onDestroy() {
        dMk();
        if (cAl() != null) {
            cAl().reset();
        }
        dMr();
        if (this.jcL != null) {
            this.jcL.onDestroy();
        }
        if (this.iKq != null) {
            this.iKq.cBn();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.ndv).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.jcL == null) {
            this.jcL = new h(this.ndv.getPageContext(), (NavigationBarCoverTip) this.ndv.findViewById(R.id.navigation_cover_tip));
        }
        this.jcL.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.iKq == null) {
                this.iKq = new com.baidu.tieba.video.f(this.ndv, this.ndv.getActivityRootView());
            }
            this.iKq.j(postWriteCallBackData);
        }
    }

    public void dMs() {
        this.isInterrupt = false;
        this.ndK = 1;
        if (dMp() != null) {
            dMp().fte = this.ndK;
        }
    }
}
