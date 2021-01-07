package com.baidu.tieba.tblauncher;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
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
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.c.h;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ImageView iIt;
    private com.baidu.tieba.video.e jil;
    private boolean lsZ;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private h mvR;
    private TextView nyD;
    private ImageView nyE;
    private ImageView nyF;
    private TextView nyG;
    private ImageView nyH;
    private TextView nyI;
    private PopupWindow nyK;
    private MaintabBottomIndicator nyM;
    private MaintabBottomIndicator nyN;
    private Runnable nyU;
    private MainTabActivity nyz;
    private boolean nyJ = false;
    private int lsV = -1;
    private boolean nyL = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean fJI = true;
    private int nyO = 1;
    private boolean isInterrupt = false;
    private boolean nyP = false;
    private FragmentTabHost.a nyQ = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b pV = d.this.mTabHost.pV(i);
            if (pV.mType == 8) {
                if (d.this.nyM != null && d.this.nyM.getAnimationView() != null && d.this.nyM.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new aq("c10605").an("obj_type", 1));
                } else {
                    TiebaStatic.log(new aq("c10605").an("obj_type", 0));
                }
                if (d.this.nyM != null) {
                    d.this.nyM.bGy();
                }
                TiebaStatic.log("c13841");
            } else if (pV.mType == 3) {
                TiebaStatic.log(new aq(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).an("obj_locate", 1));
                TiebaStatic.log(new aq(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).an("obj_locate", 1));
            }
            if (pV.mType == 2) {
                if (d.this.fJI) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.fJI = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.nyO != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.nyO == 1) {
                        d.this.nyN.lf(d.this.fJI);
                    }
                } else {
                    d.this.nyN.bGC();
                }
                d.this.isInterrupt = false;
            } else {
                d.this.isInterrupt = true;
                if (d.this.fJI) {
                    d.this.nyN.lf(d.this.fJI);
                }
                d.this.fJI = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.dRT() != null) {
                d.this.dRT().fJI = d.this.fJI;
            }
            Lm(d.this.lastIndex);
            Ln(d.this.lastIndex);
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        private void Lm(int i) {
            FragmentTabHost.b pV = d.this.mTabHost.pV(i);
            if (pV.mType == 8) {
                com.baidu.tbadk.pageExtra.d.Ej(PageStayDurationConstants.PageName.PERSON);
            } else if (pV.mType == 2) {
                com.baidu.tbadk.pageExtra.d.Ej(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            } else if (pV.mType == 3) {
                com.baidu.tbadk.pageExtra.d.Ej("a079");
            } else if (pV.mType == 1) {
                com.baidu.tbadk.pageExtra.d.Ej(PageStayDurationConstants.PageName.ENTER_FORUM);
            } else if (pV.mType == 21) {
                com.baidu.tbadk.pageExtra.d.Ej("a075");
            }
        }

        private void Ln(int i) {
            String bHn;
            if (d.this.mTabHost.pV(i).mType == 2) {
                bHn = com.baidu.tbadk.pageExtra.d.fs(d.this.nyz.getPageContext().getContext());
            } else {
                bHn = com.baidu.tbadk.pageExtra.d.bHn();
            }
            final CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921520, bHn);
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.d.1.1
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            }, 100L);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b pV = d.this.mTabHost.pV(i);
            if (pV.mType == 9) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new k(0)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (pV.mType == 8 && !bg.checkUpIsLogin(d.this.nyz.getActivity())) {
                if (d.this.nyM != null) {
                    d.this.nyM.bGy();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (pV.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        be.bwv().a(d.this.nyz.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (pV.mType == 3 && !bg.checkUpIsLogin(d.this.nyz.getActivity())) {
                    return false;
                } else {
                    if (pV.mType == 1) {
                        TiebaStatic.log(new aq("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener nyR = new CustomMessageListener(2921492) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.mainTab.c cVar;
            if (customResponsedMessage != null && d.this.mTabHost != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.c) && (cVar = (com.baidu.tbadk.mainTab.c) customResponsedMessage.getData()) != null && d.this.mTabHost.pW(cVar.type) != null && d.this.mTabHost.getCurrentTabType() != 21) {
                FragmentTabHost.b pW = d.this.mTabHost.pW(cVar.type);
                if (pW.fbC instanceof MaintabBottomIndicator) {
                    ((MaintabBottomIndicator) pW.fbC).setImageIconUrl(cVar.fJx, cVar.text);
                }
            }
        }
    };
    private CustomMessageListener nyS = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dRT() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.isInterrupt = true;
                        d.this.fJI = true;
                        if (d.this.nyO != 2) {
                            if (d.this.nyN.isAnimating()) {
                                d.this.nyN.lf(d.this.fJI);
                                return;
                            }
                            return;
                        }
                        d.this.dRT().bGE();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.isInterrupt = false;
                        if (d.this.nyO == 1) {
                            return;
                        }
                    } else {
                        d.this.nyO = intValue;
                    }
                    if (d.this.nyO == 1) {
                        d.this.dRT().lf(d.this.fJI);
                    } else if (d.this.nyO == 2) {
                        d.this.dRT().bGC();
                    } else if (intValue == 5) {
                        d.this.nyO = 1;
                        d.this.fJI = true;
                        if (!d.this.isInterrupt) {
                            d.this.dRT().bGE();
                        }
                    } else {
                        d.this.dRT().bGD();
                    }
                    d.this.dRT().fJH = true;
                    d.this.dRT().fJJ = d.this.nyO;
                    d.this.dRT().fJI = d.this.fJI;
                }
            }
        }
    };
    private CustomMessageListener nyT = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.fJI = true;
            if (d.this.dRT() != null) {
                d.this.dRT().fJI = d.this.fJI;
            }
        }
    };
    private Runnable jLe = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.nyK != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.nyz.getActivity());
                int dimens = l.getDimens(d.this.nyz.getActivity(), R.dimen.ds178);
                View contentView = d.this.nyK.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b pW = d.this.mTabHost.pW(3);
                    if (pW != null && (tbFragmentTabIndicator = pW.fbC) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.nyz.getActivity(), R.dimen.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.nyK, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.nyL = true;
                        d.this.mHandler.postDelayed(d.this.jLf, 5000L);
                    }
                }
            }
        }
    };
    private Runnable jLf = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // java.lang.Runnable
        public void run() {
            d.this.dRV();
        }
    };
    private View.OnClickListener jLg = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dRV();
        }
    };

    public void setCurrentTabByType(int i) {
        cHb().setCurrentTabByType(i);
        if (i != 2) {
            this.isInterrupt = true;
            if (this.fJI) {
                this.nyN.lf(false);
            }
            this.fJI = false;
            if (dRT() != null) {
                dRT().fJI = this.fJI;
            }
        }
    }

    public d(MainTabActivity mainTabActivity) {
        this.nyz = mainTabActivity;
    }

    public void yt(boolean z) {
        this.mTabHost = (FragmentTabHost) this.nyz.findViewById(R.id.tab_host);
        this.mTabHost.setup(this.nyz.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.nyQ);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.setShouldDrawIndicatorLine(false);
            this.mTabHost.setShouldDrawTopLine(true);
        }
        this.mTabHost.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.d.14
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (d.this.mTabHost.getCurrentTabType() != 2) {
                    if (d.this.mTabHost.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                d.this.dRU();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.pV(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.iIt.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                if (d.this.mTabHost.getCurrentTabType() == 1 && !com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                d.this.lsV = d.this.mTabHost.getCurrentTabType();
                d.this.dRR();
                if (com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (d.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).dX("nobatch", "1"));
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.nyJ = com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        bIl();
        this.nyH = (ImageView) this.nyz.findViewById(R.id.home_page_new_write_icon);
        this.nyI = (TextView) this.nyz.findViewById(R.id.view_bottom_text);
        this.nyG = (TextView) this.nyz.findViewById(R.id.activity_prize_my_tip);
        this.mTabHost.setUIType(0);
        this.mTabHost.setTabContainerShadowShow(false);
        this.mTabHost.setBackGroundStyle(0);
        this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        dRQ();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.nyz.getPageContext()));
        switchNaviBarStatus(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.nyz.registerListener(this.nyS);
        }
        this.nyz.registerListener(this.nyT);
        this.nyz.registerListener(this.nyR);
    }

    public void TX(final String str) {
        if (StringUtils.isNull(str)) {
            this.nyG.setVisibility(8);
            return;
        }
        FragmentTabHost.b pW = this.mTabHost.pW(8);
        if (pW != null) {
            if (!this.nyL || (this.nyK != null && this.nyK.isShowing())) {
                if (this.nyU == null) {
                    this.nyU = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.15
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.TX(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.nyU);
                TbadkCoreApplication.getInst().handler.postDelayed(this.nyU, 5000L);
                return;
            }
            a(str, pW);
            return;
        }
        this.nyG.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.fbC.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.nyz).widthPixels - (iArr[0] + (bVar.fbC.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nyG.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.nyz.getPageContext().getPageActivity(), R.dimen.ds26);
        this.nyG.setLayoutParams(layoutParams);
        this.nyG.setVisibility(0);
        this.nyG.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void dRO() {
        com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.nyJ);
    }

    public boolean dRP() {
        return this.nyE != null && this.nyE.getVisibility() == 0;
    }

    public void yu(boolean z) {
        if (this.nyE != null) {
            if (z) {
                this.nyE.setVisibility(0);
            } else {
                this.nyE.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.setShouldDrawTopLine(false);
        }
        if (this.mTabHost.getFragmentTabWidget() != null) {
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0207);
        }
        this.mTabHost.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.nyz.getPageContext(), i);
        ao.setNavbarTitleColor(this.nyD, R.color.CAM_X0105, R.color.s_navbar_title_color, i);
        ao.setImageResource(this.nyF, R.drawable.icon_news_down_bar_one);
        ao.setNavbarIconSrc(this.nyE, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        ao.setViewTextColor(this.nyI, R.color.CAM_X0106);
        SvgManager.bwr().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bwr().a(this.iIt, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
                dRQ();
                return;
            }
            this.mTabHost.showTabWidget();
        }
    }

    public void dRQ() {
        if (this.nyH != null) {
            this.nyH.setVisibility(8);
        }
        if (this.nyI != null) {
            this.nyI.setVisibility(8);
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.nyz.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            ao.setViewTextColor(textView, R.color.CAM_X0105, 1);
            if (!StringUtils.isNull(payMemberInfoData.bEc())) {
                textView.setText(payMemberInfoData.bEc());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ao.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nyz.getPageContext().getPageActivity());
            aVar.br(inflate);
            aVar.pb(R.color.CAM_X0305);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.nyz.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.nyz.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.nyz.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.nyz.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.nyz.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.nyz.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.nyz.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.jI(false);
            aVar.b(this.nyz.getPageContext()).btY();
            com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void dRR() {
        FragmentTabHost.b pW;
        if (this.mTabHost != null && (pW = this.mTabHost.pW(this.mTabHost.getCurrentTabType())) != null && pW.fbD != null && pW.fbD.getFragmentTabStructure() != null) {
            String string = this.nyz.getPageContext().getString(pW.fbD.getFragmentTabStructure().textResId);
            if (this.nyD != null) {
                this.nyD.setText(string);
            }
        }
    }

    public void bIl() {
        this.mNavigationBar = (NavigationBar) this.nyz.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.nyD = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.nyz.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.nyD.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.nyE = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.nyF = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.nyE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.yx(false);
                    d.this.nyF.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.nyz.getPageContext()));
                    TiebaStatic.eventStat(d.this.nyz.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.nyz.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.nyz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.nyz.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new aq(CommonStatisticKey.SEARCH_BAR_CLICK).an("obj_type", i));
                }
            });
            this.iIt = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.iIt.setLayoutParams(layoutParams2);
            this.iIt.setVisibility(8);
            this.iIt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.nyz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.nyz.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.nyz.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bg.skipToLoginActivity(d.this.nyz.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.nyz.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.lsV) {
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
                    TiebaStatic.log(new aq("c10517").dX("obj_source", str));
                    bg.skipToRegisterActivity(d.this.nyz.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void yv(boolean z) {
        if (z) {
            this.iIt.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.iIt.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void yw(boolean z) {
        if (dRP()) {
            if (z) {
                if (this.nyF.getVisibility() != 0) {
                    this.nyF.setVisibility(0);
                    yx(true);
                    ao.setImageResource(this.nyF, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            yx(false);
            this.nyF.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yx(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nyE.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.nyz.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.nyz.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.nyE.setLayoutParams(layoutParams);
        }
    }

    public void aX(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.nyz.getPageContext().getPageActivity()));
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

    public void tT(boolean z) {
        this.lsZ = z;
        if (!this.lsZ) {
            com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean djg() {
        return this.lsZ;
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
                this.nyP = true;
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.fJy) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.nyM = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (!at.isEmpty(cVar.fJx)) {
                maintabBottomIndicator.setImageIconUrl(cVar.fJx, cVar.text);
            }
            if (bVar2.mType == 2) {
                this.nyN = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.fbC = maintabBottomIndicator;
            bVar2.fbD = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost cHb() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator dRS() {
        return this.nyM;
    }

    public MaintabBottomIndicator dRT() {
        return this.nyN;
    }

    public void dRU() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void dRV() {
        this.mHandler.removeCallbacks(this.jLe);
        this.mHandler.removeCallbacks(this.jLf);
        g.dismissPopupWindow(this.nyK);
    }

    public void TY(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nyz.getActivity());
        aVar.Bo(str);
        aVar.a(R.string.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aq aqVar = new aq("c12137");
                aqVar.dX("obj_locate", "1");
                TiebaStatic.log(aqVar);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aq aqVar = new aq("c12137");
                aqVar.dX("obj_locate", "2");
                TiebaStatic.log(aqVar);
                aVar2.dismiss();
                com.baidu.tieba.k.a.cQn();
            }
        });
        aVar.b(this.nyz.getPageContext()).btY();
    }

    public void onDestroy() {
        dRO();
        if (cHb() != null) {
            cHb().reset();
        }
        dRV();
        if (this.mvR != null) {
            this.mvR.onDestroy();
        }
        if (this.jil != null) {
            this.jil.cIc();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.nyz).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.mvR == null) {
            this.mvR = new h(this.nyz.getPageContext(), (NavigationBarCoverTip) this.nyz.findViewById(R.id.navigation_cover_tip));
        }
        this.mvR.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.jil == null) {
                this.jil = new com.baidu.tieba.video.e(this.nyz, this.nyz.getActivityRootView());
            }
            this.jil.l(postWriteCallBackData);
        }
    }

    public void dRW() {
        this.isInterrupt = false;
        this.nyO = 1;
        if (dRT() != null) {
            dRT().fJJ = this.nyO;
        }
    }
}
