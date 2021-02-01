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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
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
    private ImageView iJw;
    private com.baidu.tieba.video.e jjk;
    private boolean lww;
    private h mAm;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private MainTabActivity nDF;
    private TextView nDJ;
    private ImageView nDK;
    private ImageView nDL;
    private TextView nDM;
    private ImageView nDN;
    private TextView nDO;
    private PopupWindow nDQ;
    private MaintabBottomIndicator nDS;
    private MaintabBottomIndicator nDT;
    private Runnable nEa;
    private boolean nDP = false;
    private int lws = -1;
    private boolean nDR = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean fHn = true;
    private int nDU = 1;
    private boolean isInterrupt = false;
    private boolean nDV = false;
    private FragmentTabHost.a nDW = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b ot = d.this.mTabHost.ot(i);
            if (ot.mType == 8) {
                if (d.this.nDS != null && d.this.nDS.getAnimationView() != null && d.this.nDS.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new ar("c10605").ap("obj_type", 1));
                } else {
                    TiebaStatic.log(new ar("c10605").ap("obj_type", 0));
                }
                if (d.this.nDS != null) {
                    d.this.nDS.bCX();
                }
                TiebaStatic.log("c13841");
            } else if (ot.mType == 3) {
                TiebaStatic.log(new ar(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).ap("obj_locate", 1));
                TiebaStatic.log(new ar(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ap("obj_locate", 1));
            }
            if (ot.mType == 2) {
                if (d.this.fHn) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.fHn = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.nDU != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.nDU == 1) {
                        d.this.nDT.le(d.this.fHn);
                    }
                } else {
                    d.this.nDT.bDb();
                }
                d.this.isInterrupt = false;
            } else {
                d.this.isInterrupt = true;
                if (d.this.fHn) {
                    d.this.nDT.le(d.this.fHn);
                }
                d.this.fHn = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.dQm() != null) {
                d.this.dQm().fHn = d.this.fHn;
            }
            JZ(d.this.lastIndex);
            Ka(d.this.lastIndex);
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        private void JZ(int i) {
            FragmentTabHost.b ot = d.this.mTabHost.ot(i);
            if (ot.mType == 8) {
                com.baidu.tbadk.pageExtra.d.Dp(PageStayDurationConstants.PageName.PERSON);
            } else if (ot.mType == 2) {
                com.baidu.tbadk.pageExtra.d.Dp(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            } else if (ot.mType == 3) {
                com.baidu.tbadk.pageExtra.d.Dp("a079");
            } else if (ot.mType == 1) {
                com.baidu.tbadk.pageExtra.d.Dp(PageStayDurationConstants.PageName.ENTER_FORUM);
            } else if (ot.mType == 21) {
                com.baidu.tbadk.pageExtra.d.Dp("a075");
            }
        }

        private void Ka(int i) {
            String bDM;
            if (d.this.mTabHost.ot(i).mType == 2) {
                bDM = com.baidu.tbadk.pageExtra.d.fp(d.this.nDF.getPageContext().getContext());
            } else {
                bDM = com.baidu.tbadk.pageExtra.d.bDM();
            }
            final CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921520, bDM);
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.d.1.1
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
            FragmentTabHost.b ot = d.this.mTabHost.ot(i);
            if (ot.mType == 9) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new k(0)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (ot.mType == 8 && !bh.checkUpIsLogin(d.this.nDF.getActivity())) {
                if (d.this.nDS != null) {
                    d.this.nDS.bCX();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (ot.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        bf.bsV().a(d.this.nDF.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (ot.mType == 3 && !bh.checkUpIsLogin(d.this.nDF.getActivity())) {
                    return false;
                } else {
                    if (ot.mType == 1) {
                        TiebaStatic.log(new ar("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener nDX = new CustomMessageListener(2921492) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.mainTab.c cVar;
            if (customResponsedMessage != null && d.this.mTabHost != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.c) && (cVar = (com.baidu.tbadk.mainTab.c) customResponsedMessage.getData()) != null && d.this.mTabHost.ou(cVar.type) != null && d.this.mTabHost.getCurrentTabType() != 21) {
                FragmentTabHost.b ou = d.this.mTabHost.ou(cVar.type);
                if (ou.eZk instanceof MaintabBottomIndicator) {
                    ((MaintabBottomIndicator) ou.eZk).setImageIconUrl(cVar.fHc, cVar.text);
                }
            }
        }
    };
    private CustomMessageListener nDY = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dQm() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.isInterrupt = true;
                        d.this.fHn = true;
                        if (d.this.nDU != 2) {
                            if (d.this.nDT.isAnimating()) {
                                d.this.nDT.le(d.this.fHn);
                                return;
                            }
                            return;
                        }
                        d.this.dQm().bDd();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.isInterrupt = false;
                        if (d.this.nDU == 1) {
                            return;
                        }
                    } else {
                        d.this.nDU = intValue;
                    }
                    if (d.this.nDU == 1) {
                        d.this.dQm().le(d.this.fHn);
                    } else if (d.this.nDU == 2) {
                        d.this.dQm().bDb();
                    } else if (intValue == 5) {
                        d.this.nDU = 1;
                        d.this.fHn = true;
                        if (!d.this.isInterrupt) {
                            d.this.dQm().bDd();
                        }
                    } else {
                        d.this.dQm().bDc();
                    }
                    d.this.dQm().fHm = true;
                    d.this.dQm().fHo = d.this.nDU;
                    d.this.dQm().fHn = d.this.fHn;
                }
            }
        }
    };
    private CustomMessageListener nDZ = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.fHn = true;
            if (d.this.dQm() != null) {
                d.this.dQm().fHn = d.this.fHn;
            }
        }
    };
    private Runnable jMc = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.nDQ != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.nDF.getActivity());
                int dimens = l.getDimens(d.this.nDF.getActivity(), R.dimen.ds178);
                View contentView = d.this.nDQ.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b ou = d.this.mTabHost.ou(3);
                    if (ou != null && (tbFragmentTabIndicator = ou.eZk) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.nDF.getActivity(), R.dimen.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.nDQ, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.nDR = true;
                        d.this.mHandler.postDelayed(d.this.jMd, 5000L);
                    }
                }
            }
        }
    };
    private Runnable jMd = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // java.lang.Runnable
        public void run() {
            d.this.dQo();
        }
    };
    private View.OnClickListener jMe = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dQo();
        }
    };

    public void setCurrentTabByType(int i) {
        cEv().setCurrentTabByType(i);
        if (i != 2) {
            this.isInterrupt = true;
            if (this.fHn) {
                this.nDT.le(false);
            }
            this.fHn = false;
            if (dQm() != null) {
                dQm().fHn = this.fHn;
            }
        }
    }

    public d(MainTabActivity mainTabActivity) {
        this.nDF = mainTabActivity;
    }

    public void yI(boolean z) {
        this.mTabHost = (FragmentTabHost) this.nDF.findViewById(R.id.tab_host);
        this.mTabHost.setup(this.nDF.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.nDW);
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
                d.this.dQn();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.ot(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.iJw.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                if (d.this.mTabHost.getCurrentTabType() == 1 && !com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                d.this.lws = d.this.mTabHost.getCurrentTabType();
                d.this.dQk();
                if (com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (d.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).dR("nobatch", "1"));
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.nDP = com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        bEL();
        this.nDN = (ImageView) this.nDF.findViewById(R.id.home_page_new_write_icon);
        this.nDO = (TextView) this.nDF.findViewById(R.id.view_bottom_text);
        this.nDM = (TextView) this.nDF.findViewById(R.id.activity_prize_my_tip);
        this.mTabHost.setUIType(0);
        this.mTabHost.setTabContainerShadowShow(false);
        this.mTabHost.setBackGroundStyle(0);
        this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        dQj();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.nDF.getPageContext()));
        switchNaviBarStatus(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.nDF.registerListener(this.nDY);
        }
        this.nDF.registerListener(this.nDZ);
        this.nDF.registerListener(this.nDX);
    }

    public void TN(final String str) {
        if (StringUtils.isNull(str)) {
            this.nDM.setVisibility(8);
            return;
        }
        FragmentTabHost.b ou = this.mTabHost.ou(8);
        if (ou != null) {
            if (!this.nDR || (this.nDQ != null && this.nDQ.isShowing())) {
                if (this.nEa == null) {
                    this.nEa = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.15
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.TN(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.nEa);
                TbadkCoreApplication.getInst().handler.postDelayed(this.nEa, 5000L);
                return;
            }
            a(str, ou);
            return;
        }
        this.nDM.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.eZk.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.nDF).widthPixels - (iArr[0] + (bVar.eZk.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nDM.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.nDF.getPageContext().getPageActivity(), R.dimen.ds26);
        this.nDM.setLayoutParams(layoutParams);
        this.nDM.setVisibility(0);
        this.nDM.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void dQh() {
        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.nDP);
    }

    public boolean dQi() {
        return this.nDK != null && this.nDK.getVisibility() == 0;
    }

    public void yJ(boolean z) {
        if (this.nDK != null) {
            if (z) {
                this.nDK.setVisibility(0);
            } else {
                this.nDK.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.nDF.getPageContext(), i);
        ap.setNavbarTitleColor(this.nDJ, R.color.CAM_X0105, R.color.s_navbar_title_color, i);
        ap.setImageResource(this.nDL, R.drawable.icon_news_down_bar_one);
        ap.setNavbarIconSrc(this.nDK, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        ap.setViewTextColor(this.nDO, R.color.CAM_X0106);
        SvgManager.bsR().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bsR().a(this.iJw, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
                dQj();
                return;
            }
            this.mTabHost.showTabWidget();
        }
    }

    public void dQj() {
        if (this.nDN != null) {
            this.nDN.setVisibility(8);
        }
        if (this.nDO != null) {
            this.nDO.setVisibility(8);
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.nDF.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            ap.setViewTextColor(textView, R.color.CAM_X0105, 1);
            if (!StringUtils.isNull(payMemberInfoData.bAA())) {
                textView.setText(payMemberInfoData.bAA());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ap.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nDF.getPageContext().getPageActivity());
            aVar.bn(inflate);
            aVar.ny(R.color.CAM_X0305);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.nDF.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.nDF.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.nDF.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.nDF.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.nDF.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.nDF.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.nDF.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.jG(false);
            aVar.b(this.nDF.getPageContext()).bqx();
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void dQk() {
        FragmentTabHost.b ou;
        if (this.mTabHost != null && (ou = this.mTabHost.ou(this.mTabHost.getCurrentTabType())) != null && ou.eZl != null && ou.eZl.getFragmentTabStructure() != null) {
            String string = this.nDF.getPageContext().getString(ou.eZl.getFragmentTabStructure().textResId);
            if (this.nDJ != null) {
                this.nDJ.setText(string);
            }
        }
    }

    public void bEL() {
        this.mNavigationBar = (NavigationBar) this.nDF.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.nDJ = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.nDF.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.nDJ.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.nDK = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.nDL = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.nDK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.yM(false);
                    d.this.nDL.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.nDF.getPageContext()));
                    TiebaStatic.eventStat(d.this.nDF.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.nDF.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.nDF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.nDF.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new ar(CommonStatisticKey.SEARCH_BAR_CLICK).ap("obj_type", i));
                }
            });
            this.iJw = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.iJw.setLayoutParams(layoutParams2);
            this.iJw.setVisibility(8);
            this.iJw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.nDF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.nDF.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.nDF.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bh.skipToLoginActivity(d.this.nDF.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.nDF.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.lws) {
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
                    TiebaStatic.log(new ar("c10517").dR("obj_source", str));
                    bh.skipToRegisterActivity(d.this.nDF.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void yK(boolean z) {
        if (z) {
            this.iJw.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.iJw.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void yL(boolean z) {
        if (dQi()) {
            if (z) {
                if (this.nDL.getVisibility() != 0) {
                    this.nDL.setVisibility(0);
                    yM(true);
                    ap.setImageResource(this.nDL, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            yM(false);
            this.nDL.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yM(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nDK.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.nDF.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.nDF.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.nDK.setLayoutParams(layoutParams);
        }
    }

    public void aR(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.nDF.getPageContext().getPageActivity()));
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

    public void uc(boolean z) {
        this.lww = z;
        if (!this.lww) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean dho() {
        return this.lww;
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
                this.nDV = true;
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.fHd) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.nDS = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (!au.isEmpty(cVar.fHc)) {
                maintabBottomIndicator.setImageIconUrl(cVar.fHc, cVar.text);
            }
            if (bVar2.mType == 2) {
                this.nDT = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.eZk = maintabBottomIndicator;
            bVar2.eZl = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost cEv() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator dQl() {
        return this.nDS;
    }

    public MaintabBottomIndicator dQm() {
        return this.nDT;
    }

    public void dQn() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void dQo() {
        this.mHandler.removeCallbacks(this.jMc);
        this.mHandler.removeCallbacks(this.jMd);
        g.dismissPopupWindow(this.nDQ);
    }

    public void TO(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nDF.getActivity());
        aVar.Au(str);
        aVar.a(R.string.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ar arVar = new ar("c12137");
                arVar.dR("obj_locate", "1");
                TiebaStatic.log(arVar);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ar arVar = new ar("c12137");
                arVar.dR("obj_locate", "2");
                TiebaStatic.log(arVar);
                aVar2.dismiss();
                com.baidu.tieba.k.a.cOs();
            }
        });
        aVar.b(this.nDF.getPageContext()).bqx();
    }

    public void onDestroy() {
        dQh();
        if (cEv() != null) {
            cEv().reset();
        }
        dQo();
        if (this.mAm != null) {
            this.mAm.onDestroy();
        }
        if (this.jjk != null) {
            this.jjk.cFx();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || au.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.nDF).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.mAm == null) {
            this.mAm = new h(this.nDF.getPageContext(), (NavigationBarCoverTip) this.nDF.findViewById(R.id.navigation_cover_tip));
        }
        this.mAm.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.jjk == null) {
                this.jjk = new com.baidu.tieba.video.e(this.nDF, this.nDF.getActivityRootView());
            }
            this.jjk.l(postWriteCallBackData);
        }
    }

    public void dQp() {
        this.isInterrupt = false;
        this.nDU = 1;
        if (dQm() != null) {
            dQm().fHo = this.nDU;
        }
    }
}
