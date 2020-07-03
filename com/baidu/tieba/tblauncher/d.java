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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.data.i;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.c.h;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.g;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class d {
    private g hCC;
    private h hTU;
    private ImageView hdk;
    private boolean jLJ;
    private MaintabBottomIndicator lMA;
    private Runnable lMG;
    private MainTabActivity lMm;
    private TextView lMq;
    private ImageView lMr;
    private ImageView lMs;
    private TextView lMt;
    private ImageView lMu;
    private TextView lMv;
    private PopupWindow lMx;
    private MaintabBottomIndicator lMz;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean lMw = false;
    private int jLF = -1;
    private boolean lMy = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean eyP = true;
    private int lMB = 1;
    private boolean isInterrupt = false;
    private boolean lMC = false;
    private FragmentTabHost.a lMD = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b ll = d.this.mTabHost.ll(i);
            if (ll.mType == 8) {
                if (d.this.lMz != null && d.this.lMz.getAnimationView() != null && d.this.lMz.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new ao("c10605").ag("obj_type", 1));
                } else {
                    TiebaStatic.log(new ao("c10605").ag("obj_type", 0));
                }
                if (d.this.lMz != null) {
                    d.this.lMz.bgH();
                }
            } else if (ll.mType == 3) {
                TiebaStatic.log(new ao(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).ag("obj_locate", 1));
                TiebaStatic.log(new ao(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ag("obj_locate", 1));
            }
            if (ll.mType == 2) {
                if (d.this.eyP) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.eyP = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.lMB != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.lMB == 1) {
                        d.this.lMA.ip(d.this.eyP);
                    }
                } else {
                    d.this.lMA.bgL();
                }
                d.this.isInterrupt = false;
            } else {
                d.this.isInterrupt = true;
                if (d.this.eyP) {
                    d.this.lMA.ip(d.this.eyP);
                }
                d.this.eyP = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.dkh() != null) {
                d.this.dkh().eyP = d.this.eyP;
            }
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b ll = d.this.mTabHost.ll(i);
            if (ll.mType == 9) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new i(0)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (ll.mType == 8 && !be.checkUpIsLogin(d.this.lMm.getActivity())) {
                if (d.this.lMz != null) {
                    d.this.lMz.bgH();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (ll.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        bc.aWU().a(d.this.lMm.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (ll.mType == 3 && !be.checkUpIsLogin(d.this.lMm.getActivity())) {
                    return false;
                } else {
                    if (ll.mType == 1) {
                        TiebaStatic.log(new ao("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener lME = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dkh() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.isInterrupt = true;
                        d.this.eyP = true;
                        if (d.this.lMB != 2) {
                            if (d.this.lMA.isAnimating()) {
                                d.this.lMA.ip(d.this.eyP);
                                return;
                            }
                            return;
                        }
                        d.this.dkh().bgN();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.isInterrupt = false;
                        if (d.this.lMB == 1) {
                            return;
                        }
                    } else {
                        d.this.lMB = intValue;
                    }
                    if (d.this.lMB == 1) {
                        d.this.dkh().ip(d.this.eyP);
                    } else if (d.this.lMB == 2) {
                        d.this.dkh().bgL();
                    } else if (intValue == 5) {
                        d.this.lMB = 1;
                        d.this.eyP = true;
                        if (!d.this.isInterrupt) {
                            d.this.dkh().bgN();
                        }
                    } else {
                        d.this.dkh().bgM();
                    }
                    d.this.dkh().eyO = true;
                    d.this.dkh().eyQ = d.this.lMB;
                    d.this.dkh().eyP = d.this.eyP;
                }
            }
        }
    };
    private CustomMessageListener lMF = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.eyP = true;
            if (d.this.dkh() != null) {
                d.this.dkh().eyP = d.this.eyP;
            }
        }
    };
    private Runnable ibv = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.lMx != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.lMm.getActivity());
                int dimens = l.getDimens(d.this.lMm.getActivity(), R.dimen.ds178);
                View contentView = d.this.lMx.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b lm = d.this.mTabHost.lm(3);
                    if (lm != null && (tbFragmentTabIndicator = lm.dSF) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.lMm.getActivity(), R.dimen.tbds570);
                        }
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(d.this.lMx, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.lMy = true;
                        d.this.mHandler.postDelayed(d.this.ibw, 5000L);
                    }
                }
            }
        }
    };
    private Runnable ibw = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            d.this.dkj();
        }
    };
    private View.OnClickListener ibx = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dkj();
        }
    };

    public void setCurrentTabByType(int i) {
        bZU().setCurrentTabByType(i);
        if (i != 2) {
            this.isInterrupt = true;
            if (this.eyP) {
                this.lMA.ip(false);
            }
            this.eyP = false;
            if (dkh() != null) {
                dkh().eyP = this.eyP;
            }
        }
    }

    public d(MainTabActivity mainTabActivity) {
        this.lMm = mainTabActivity;
    }

    public void uR(boolean z) {
        this.mTabHost = (FragmentTabHost) this.lMm.findViewById(R.id.tab_host);
        this.mTabHost.setup(this.lMm.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.lMD);
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
                d.this.dki();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.ll(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.hdk.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                d.this.jLF = d.this.mTabHost.getCurrentTabType();
                d.this.dkf();
                if (com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (d.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).dk("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.lMw = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        biq();
        this.lMu = (ImageView) this.lMm.findViewById(R.id.home_page_new_write_icon);
        this.lMv = (TextView) this.lMm.findViewById(R.id.view_bottom_text);
        this.lMt = (TextView) this.lMm.findViewById(R.id.activity_prize_my_tip);
        if (com.baidu.tbadk.a.d.aNV()) {
            this.mTabHost.setUIType(0);
            this.mTabHost.setTabContainerShadowShow(true);
            this.mTabHost.setBackGroundStyle(0);
            this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            dke();
        } else {
            this.mTabHost.setUIType(1);
            this.mTabHost.setTabContainerShadowShow(false);
            this.mTabHost.setBackGroundStyle(1);
            this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight() + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds73));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.lMm.getPageContext()));
        switchNaviBarStatus(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.lMm.registerListener(this.lME);
        }
        this.lMm.registerListener(this.lMF);
    }

    public void NA(final String str) {
        if (StringUtils.isNull(str)) {
            this.lMt.setVisibility(8);
            return;
        }
        FragmentTabHost.b lm = this.mTabHost.lm(8);
        if (lm != null) {
            if (!this.lMy || (this.lMx != null && this.lMx.isShowing())) {
                if (this.lMG == null) {
                    this.lMG = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.13
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.NA(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.lMG);
                TbadkCoreApplication.getInst().handler.postDelayed(this.lMG, 5000L);
                return;
            }
            a(str, lm);
            return;
        }
        this.lMt.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.dSF.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.lMm).widthPixels - (iArr[0] + (bVar.dSF.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lMt.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.lMm.getPageContext().getPageActivity(), R.dimen.ds26);
        this.lMt.setLayoutParams(layoutParams);
        this.lMt.setVisibility(0);
        this.lMt.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void dkb() {
        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.lMw);
    }

    public boolean dkc() {
        return this.lMr != null && this.lMr.getVisibility() == 0;
    }

    public void uS(boolean z) {
        if (this.lMr != null) {
            if (z) {
                this.lMr.setVisibility(0);
            } else {
                this.lMr.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.setShouldDrawTopLine(false);
        }
        if (com.baidu.tbadk.a.d.aNV()) {
            if (this.mTabHost.getFragmentTabWidget() != null) {
                this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.cp_bg_line_h);
            }
        } else if (this.mTabHost.getFragmentTabWidget() != null) {
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.mTabHost.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.lMm.getPageContext(), i);
        an.setNavbarTitleColor(this.lMq, R.color.cp_cont_b, R.color.s_navbar_title_color, i);
        an.setImageResource(this.lMs, R.drawable.icon_news_down_bar_one);
        an.setNavbarIconSrc(this.lMr, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        an.setViewTextColor(this.lMv, (int) R.color.cp_cont_f);
        SvgManager.aWQ().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aWQ().a(this.hdk, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
                dke();
                return;
            }
            this.mTabHost.showTabWidget();
            dkd();
        }
    }

    public void dkd() {
        if (!com.baidu.tbadk.a.d.aNV()) {
            if (this.lMu != null) {
                this.lMu.setVisibility(0);
            }
            if (this.lMv != null) {
                this.lMv.setVisibility(0);
            }
        }
    }

    public void dke() {
        if (this.lMu != null) {
            this.lMu.setVisibility(8);
        }
        if (this.lMv != null) {
            this.lMv.setVisibility(8);
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.lMm.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            an.setViewTextColor(textView, R.color.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.bey())) {
                textView.setText(payMemberInfoData.bey());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                an.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lMm.getPageContext().getPageActivity());
            aVar.aP(inflate);
            aVar.kU(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.lMm.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.lMm.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.lMm.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.lMm.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.lMm.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.lMm.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.lMm.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.hg(false);
            aVar.b(this.lMm.getPageContext()).aUN();
            com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void dkf() {
        FragmentTabHost.b lm;
        if (this.mTabHost != null && (lm = this.mTabHost.lm(this.mTabHost.getCurrentTabType())) != null && lm.dSG != null && lm.dSG.getFragmentTabStructure() != null) {
            String string = this.lMm.getPageContext().getString(lm.dSG.getFragmentTabStructure().textResId);
            if (this.lMq != null) {
                this.lMq.setText(string);
            }
        }
    }

    public void biq() {
        this.mNavigationBar = (NavigationBar) this.lMm.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.lMq = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.lMm.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.lMq.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.lMr = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.lMs = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.lMr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.uV(false);
                    d.this.lMs.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.lMm.getPageContext()));
                    TiebaStatic.eventStat(d.this.lMm.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.lMm.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.lMm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.lMm.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new ao(CommonStatisticKey.SEARCH_BAR_CLICK).ag("obj_type", i));
                }
            });
            this.hdk = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.hdk.setLayoutParams(layoutParams2);
            this.hdk.setVisibility(8);
            this.hdk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.lMm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.lMm.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.lMm.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    be.skipToLoginActivity(d.this.lMm.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.lMm.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.jLF) {
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
                    TiebaStatic.log(new ao("c10517").dk("obj_source", str));
                    be.skipToRegisterActivity(d.this.lMm.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void uT(boolean z) {
        if (z) {
            this.hdk.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.hdk.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void uU(boolean z) {
        if (dkc()) {
            if (z) {
                if (this.lMs.getVisibility() != 0) {
                    this.lMs.setVisibility(0);
                    uV(true);
                    an.setImageResource(this.lMs, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            uV(false);
            this.lMs.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uV(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lMr.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.lMm.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.lMm.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.lMr.setLayoutParams(layoutParams);
        }
    }

    public void aI(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.lMm.getPageContext().getPageActivity()));
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

    public void qL(boolean z) {
        this.jLJ = z;
        if (!this.jLJ) {
            com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean cDk() {
        return this.jLJ;
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
                dkd();
                this.lMC = true;
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.eyH) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.lMz = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (bVar2.mType == 2) {
                this.lMA = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.dSF = maintabBottomIndicator;
            bVar2.dSG = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost bZU() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator dkg() {
        return this.lMz;
    }

    public MaintabBottomIndicator dkh() {
        return this.lMA;
    }

    public void dki() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void dkj() {
        this.mHandler.removeCallbacks(this.ibv);
        this.mHandler.removeCallbacks(this.ibw);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lMx);
    }

    public void NB(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lMm.getActivity());
        aVar.we(str);
        aVar.a(R.string.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ao aoVar = new ao("c12137");
                aoVar.dk("obj_locate", "1");
                TiebaStatic.log(aoVar);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ao aoVar = new ao("c12137");
                aoVar.dk("obj_locate", "2");
                TiebaStatic.log(aoVar);
                aVar2.dismiss();
                com.baidu.tieba.j.a.chw();
            }
        });
        aVar.b(this.lMm.getPageContext()).aUN();
    }

    public void onDestroy() {
        dkb();
        if (bZU() != null) {
            bZU().reset();
        }
        dkj();
        if (this.hTU != null) {
            this.hTU.onDestroy();
        }
        if (this.hCC != null) {
            this.hCC.caR();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ar.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.lMm).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.hTU == null) {
            this.hTU = new h(this.lMm.getPageContext(), (NavigationBarCoverTip) this.lMm.findViewById(R.id.navigation_cover_tip));
        }
        this.hTU.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.hCC == null) {
                this.hCC = new g(this.lMm, this.lMm.getActivityRootView());
            }
            this.hCC.h(postWriteCallBackData);
        }
    }

    public void dkk() {
        this.isInterrupt = false;
        this.lMB = 1;
        if (dkh() != null) {
            dkh().eyQ = this.lMB;
        }
    }
}
