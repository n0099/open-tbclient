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
    private ImageView iLt;
    private com.baidu.tieba.video.e jlh;
    private boolean lyN;
    private h mCF;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private Runnable nGG;
    private MainTabActivity nGl;
    private TextView nGp;
    private ImageView nGq;
    private ImageView nGr;
    private TextView nGs;
    private ImageView nGt;
    private TextView nGu;
    private PopupWindow nGw;
    private MaintabBottomIndicator nGy;
    private MaintabBottomIndicator nGz;
    private boolean nGv = false;
    private int lyJ = -1;
    private boolean nGx = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean fIM = true;
    private int nGA = 1;
    private boolean isInterrupt = false;
    private boolean nGB = false;
    private FragmentTabHost.a nGC = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b ou = d.this.mTabHost.ou(i);
            if (ou.mType == 8) {
                if (d.this.nGy != null && d.this.nGy.getAnimationView() != null && d.this.nGy.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new ar("c10605").aq("obj_type", 1));
                } else {
                    TiebaStatic.log(new ar("c10605").aq("obj_type", 0));
                }
                if (d.this.nGy != null) {
                    d.this.nGy.bDa();
                }
                TiebaStatic.log("c13841");
            } else if (ou.mType == 3) {
                TiebaStatic.log(new ar(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).aq("obj_locate", 1));
                TiebaStatic.log(new ar(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).aq("obj_locate", 1));
            }
            if (ou.mType == 2) {
                if (d.this.fIM) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.fIM = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.nGA != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.nGA == 1) {
                        d.this.nGz.le(d.this.fIM);
                    }
                } else {
                    d.this.nGz.bDe();
                }
                d.this.isInterrupt = false;
            } else {
                d.this.isInterrupt = true;
                if (d.this.fIM) {
                    d.this.nGz.le(d.this.fIM);
                }
                d.this.fIM = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.dQD() != null) {
                d.this.dQD().fIM = d.this.fIM;
            }
            Ke(d.this.lastIndex);
            Kf(d.this.lastIndex);
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        private void Ke(int i) {
            FragmentTabHost.b ou = d.this.mTabHost.ou(i);
            if (ou.mType == 8) {
                com.baidu.tbadk.pageExtra.d.Du(PageStayDurationConstants.PageName.PERSON);
            } else if (ou.mType == 2) {
                com.baidu.tbadk.pageExtra.d.Du(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            } else if (ou.mType == 3) {
                com.baidu.tbadk.pageExtra.d.Du("a079");
            } else if (ou.mType == 1) {
                com.baidu.tbadk.pageExtra.d.Du(PageStayDurationConstants.PageName.ENTER_FORUM);
            } else if (ou.mType == 21) {
                com.baidu.tbadk.pageExtra.d.Du("a075");
            }
        }

        private void Kf(int i) {
            String bDP;
            if (d.this.mTabHost.ou(i).mType == 2) {
                bDP = com.baidu.tbadk.pageExtra.d.fo(d.this.nGl.getPageContext().getContext());
            } else {
                bDP = com.baidu.tbadk.pageExtra.d.bDP();
            }
            final CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921520, bDP);
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
            FragmentTabHost.b ou = d.this.mTabHost.ou(i);
            if (ou.mType == 9) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new k(0)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (ou.mType == 8 && !bh.checkUpIsLogin(d.this.nGl.getActivity())) {
                if (d.this.nGy != null) {
                    d.this.nGy.bDa();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (ou.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        bf.bsY().a(d.this.nGl.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (ou.mType == 3 && !bh.checkUpIsLogin(d.this.nGl.getActivity())) {
                    return false;
                } else {
                    if (ou.mType == 1) {
                        TiebaStatic.log(new ar("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener nGD = new CustomMessageListener(2921492) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.mainTab.c cVar;
            if (customResponsedMessage != null && d.this.mTabHost != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.c) && (cVar = (com.baidu.tbadk.mainTab.c) customResponsedMessage.getData()) != null && d.this.mTabHost.ov(cVar.type) != null && d.this.mTabHost.getCurrentTabType() != 21) {
                FragmentTabHost.b ov = d.this.mTabHost.ov(cVar.type);
                if (ov.faJ instanceof MaintabBottomIndicator) {
                    ((MaintabBottomIndicator) ov.faJ).setImageIconUrl(cVar.fIB, cVar.text);
                }
            }
        }
    };
    private CustomMessageListener nGE = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dQD() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.isInterrupt = true;
                        d.this.fIM = true;
                        if (d.this.nGA != 2) {
                            if (d.this.nGz.isAnimating()) {
                                d.this.nGz.le(d.this.fIM);
                                return;
                            }
                            return;
                        }
                        d.this.dQD().bDg();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.isInterrupt = false;
                        if (d.this.nGA == 1) {
                            return;
                        }
                    } else {
                        d.this.nGA = intValue;
                    }
                    if (d.this.nGA == 1) {
                        d.this.dQD().le(d.this.fIM);
                    } else if (d.this.nGA == 2) {
                        d.this.dQD().bDe();
                    } else if (intValue == 5) {
                        d.this.nGA = 1;
                        d.this.fIM = true;
                        if (!d.this.isInterrupt) {
                            d.this.dQD().bDg();
                        }
                    } else {
                        d.this.dQD().bDf();
                    }
                    d.this.dQD().fIL = true;
                    d.this.dQD().fIN = d.this.nGA;
                    d.this.dQD().fIM = d.this.fIM;
                }
            }
        }
    };
    private CustomMessageListener nGF = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.fIM = true;
            if (d.this.dQD() != null) {
                d.this.dQD().fIM = d.this.fIM;
            }
        }
    };
    private Runnable jNZ = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.nGw != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.nGl.getActivity());
                int dimens = l.getDimens(d.this.nGl.getActivity(), R.dimen.ds178);
                View contentView = d.this.nGw.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b ov = d.this.mTabHost.ov(3);
                    if (ov != null && (tbFragmentTabIndicator = ov.faJ) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.nGl.getActivity(), R.dimen.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.nGw, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.nGx = true;
                        d.this.mHandler.postDelayed(d.this.jOa, 5000L);
                    }
                }
            }
        }
    };
    private Runnable jOa = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // java.lang.Runnable
        public void run() {
            d.this.dQF();
        }
    };
    private View.OnClickListener jOb = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dQF();
        }
    };

    public void setCurrentTabByType(int i) {
        cEI().setCurrentTabByType(i);
        if (i != 2) {
            this.isInterrupt = true;
            if (this.fIM) {
                this.nGz.le(false);
            }
            this.fIM = false;
            if (dQD() != null) {
                dQD().fIM = this.fIM;
            }
        }
    }

    public d(MainTabActivity mainTabActivity) {
        this.nGl = mainTabActivity;
    }

    public void yH(boolean z) {
        this.mTabHost = (FragmentTabHost) this.nGl.findViewById(R.id.tab_host);
        this.mTabHost.setup(this.nGl.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.nGC);
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
                d.this.dQE();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.ou(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.iLt.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                if (d.this.mTabHost.getCurrentTabType() == 1 && !com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                d.this.lyJ = d.this.mTabHost.getCurrentTabType();
                d.this.dQB();
                if (com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
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
        this.nGv = com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        bEP();
        this.nGt = (ImageView) this.nGl.findViewById(R.id.home_page_new_write_icon);
        this.nGu = (TextView) this.nGl.findViewById(R.id.view_bottom_text);
        this.nGs = (TextView) this.nGl.findViewById(R.id.activity_prize_my_tip);
        this.mTabHost.setUIType(0);
        this.mTabHost.setTabContainerShadowShow(false);
        this.mTabHost.setBackGroundStyle(0);
        this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        dQA();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.nGl.getPageContext()));
        switchNaviBarStatus(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.nGl.registerListener(this.nGE);
        }
        this.nGl.registerListener(this.nGF);
        this.nGl.registerListener(this.nGD);
    }

    public void Ug(final String str) {
        if (StringUtils.isNull(str)) {
            this.nGs.setVisibility(8);
            return;
        }
        FragmentTabHost.b ov = this.mTabHost.ov(8);
        if (ov != null) {
            if (!this.nGx || (this.nGw != null && this.nGw.isShowing())) {
                if (this.nGG == null) {
                    this.nGG = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.15
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.Ug(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.nGG);
                TbadkCoreApplication.getInst().handler.postDelayed(this.nGG, 5000L);
                return;
            }
            a(str, ov);
            return;
        }
        this.nGs.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.faJ.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.nGl).widthPixels - (iArr[0] + (bVar.faJ.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nGs.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.nGl.getPageContext().getPageActivity(), R.dimen.ds26);
        this.nGs.setLayoutParams(layoutParams);
        this.nGs.setVisibility(0);
        this.nGs.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void dQy() {
        com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.nGv);
    }

    public boolean dQz() {
        return this.nGq != null && this.nGq.getVisibility() == 0;
    }

    public void yI(boolean z) {
        if (this.nGq != null) {
            if (z) {
                this.nGq.setVisibility(0);
            } else {
                this.nGq.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.nGl.getPageContext(), i);
        ap.setNavbarTitleColor(this.nGp, R.color.CAM_X0105, R.color.s_navbar_title_color, i);
        ap.setImageResource(this.nGr, R.drawable.icon_news_down_bar_one);
        ap.setNavbarIconSrc(this.nGq, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        ap.setViewTextColor(this.nGu, R.color.CAM_X0106);
        SvgManager.bsU().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bsU().a(this.iLt, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
                dQA();
                return;
            }
            this.mTabHost.showTabWidget();
        }
    }

    public void dQA() {
        if (this.nGt != null) {
            this.nGt.setVisibility(8);
        }
        if (this.nGu != null) {
            this.nGu.setVisibility(8);
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.nGl.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            ap.setViewTextColor(textView, R.color.CAM_X0105, 1);
            if (!StringUtils.isNull(payMemberInfoData.bAD())) {
                textView.setText(payMemberInfoData.bAD());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ap.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nGl.getPageContext().getPageActivity());
            aVar.bn(inflate);
            aVar.nz(R.color.CAM_X0305);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.nGl.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.nGl.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.nGl.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.nGl.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.nGl.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.nGl.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.nGl.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.jG(false);
            aVar.b(this.nGl.getPageContext()).bqz();
            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void dQB() {
        FragmentTabHost.b ov;
        if (this.mTabHost != null && (ov = this.mTabHost.ov(this.mTabHost.getCurrentTabType())) != null && ov.faK != null && ov.faK.getFragmentTabStructure() != null) {
            String string = this.nGl.getPageContext().getString(ov.faK.getFragmentTabStructure().textResId);
            if (this.nGp != null) {
                this.nGp.setText(string);
            }
        }
    }

    public void bEP() {
        this.mNavigationBar = (NavigationBar) this.nGl.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.nGp = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.nGl.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.nGp.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.nGq = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.nGr = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.nGq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.yL(false);
                    d.this.nGr.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.nGl.getPageContext()));
                    TiebaStatic.eventStat(d.this.nGl.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.nGl.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.nGl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.nGl.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new ar(CommonStatisticKey.SEARCH_BAR_CLICK).aq("obj_type", i));
                }
            });
            this.iLt = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.iLt.setLayoutParams(layoutParams2);
            this.iLt.setVisibility(8);
            this.iLt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.nGl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.nGl.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.nGl.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bh.skipToLoginActivity(d.this.nGl.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.nGl.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.lyJ) {
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
                    bh.skipToRegisterActivity(d.this.nGl.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void yJ(boolean z) {
        if (z) {
            this.iLt.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.iLt.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void yK(boolean z) {
        if (dQz()) {
            if (z) {
                if (this.nGr.getVisibility() != 0) {
                    this.nGr.setVisibility(0);
                    yL(true);
                    ap.setImageResource(this.nGr, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            yL(false);
            this.nGr.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yL(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nGq.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.nGl.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.nGl.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.nGq.setLayoutParams(layoutParams);
        }
    }

    public void aR(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.nGl.getPageContext().getPageActivity()));
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
        this.lyN = z;
        if (!this.lyN) {
            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean dhE() {
        return this.lyN;
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
                this.nGB = true;
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.fIC) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.nGy = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (!au.isEmpty(cVar.fIB)) {
                maintabBottomIndicator.setImageIconUrl(cVar.fIB, cVar.text);
            }
            if (bVar2.mType == 2) {
                this.nGz = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.faJ = maintabBottomIndicator;
            bVar2.faK = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost cEI() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator dQC() {
        return this.nGy;
    }

    public MaintabBottomIndicator dQD() {
        return this.nGz;
    }

    public void dQE() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void dQF() {
        this.mHandler.removeCallbacks(this.jNZ);
        this.mHandler.removeCallbacks(this.jOa);
        g.dismissPopupWindow(this.nGw);
    }

    public void Uh(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nGl.getActivity());
        aVar.AB(str);
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
                com.baidu.tieba.k.a.cOG();
            }
        });
        aVar.b(this.nGl.getPageContext()).bqz();
    }

    public void onDestroy() {
        dQy();
        if (cEI() != null) {
            cEI().reset();
        }
        dQF();
        if (this.mCF != null) {
            this.mCF.onDestroy();
        }
        if (this.jlh != null) {
            this.jlh.cFK();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || au.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.nGl).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.mCF == null) {
            this.mCF = new h(this.nGl.getPageContext(), (NavigationBarCoverTip) this.nGl.findViewById(R.id.navigation_cover_tip));
        }
        this.mCF.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.jlh == null) {
                this.jlh = new com.baidu.tieba.video.e(this.nGl, this.nGl.getActivityRootView());
            }
            this.jlh.l(postWriteCallBackData);
        }
    }

    public void dQG() {
        this.isInterrupt = false;
        this.nGA = 1;
        if (dQD() != null) {
            dQD().fIN = this.nGA;
        }
    }
}
