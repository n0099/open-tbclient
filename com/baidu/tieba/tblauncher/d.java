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
/* loaded from: classes21.dex */
public class d {
    private ImageView hDc;
    private com.baidu.tieba.video.f icW;
    private h ivz;
    private boolean ksl;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private Runnable mvC;
    private MainTabActivity mvh;
    private TextView mvl;
    private ImageView mvm;
    private ImageView mvn;
    private TextView mvo;
    private ImageView mvp;
    private TextView mvq;
    private PopupWindow mvs;
    private MaintabBottomIndicator mvu;
    private MaintabBottomIndicator mvv;
    private boolean mvr = false;
    private int ksh = -1;
    private boolean mvt = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean eSD = true;
    private int mvw = 1;
    private boolean isInterrupt = false;
    private boolean mvx = false;
    private FragmentTabHost.a mvy = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b nX = d.this.mTabHost.nX(i);
            if (nX.mType == 8) {
                if (d.this.mvu != null && d.this.mvu.getAnimationView() != null && d.this.mvu.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new aq("c10605").ai("obj_type", 1));
                } else {
                    TiebaStatic.log(new aq("c10605").ai("obj_type", 0));
                }
                if (d.this.mvu != null) {
                    d.this.mvu.buj();
                }
                TiebaStatic.log("c13841");
            } else if (nX.mType == 3) {
                TiebaStatic.log(new aq(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).ai("obj_locate", 1));
                TiebaStatic.log(new aq(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ai("obj_locate", 1));
            }
            if (nX.mType == 2) {
                if (d.this.eSD) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.eSD = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.mvw != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.mvw == 1) {
                        d.this.mvv.jv(d.this.eSD);
                    }
                } else {
                    d.this.mvv.bun();
                }
                d.this.isInterrupt = false;
            } else {
                d.this.isInterrupt = true;
                if (d.this.eSD) {
                    d.this.mvv.jv(d.this.eSD);
                }
                d.this.eSD = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.dCT() != null) {
                d.this.dCT().eSD = d.this.eSD;
            }
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b nX = d.this.mTabHost.nX(i);
            if (nX.mType == 9) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new j(0)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (nX.mType == 8 && !bg.checkUpIsLogin(d.this.mvh.getActivity())) {
                if (d.this.mvu != null) {
                    d.this.mvu.buj();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (nX.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        be.bkp().a(d.this.mvh.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (nX.mType == 3 && !bg.checkUpIsLogin(d.this.mvh.getActivity())) {
                    return false;
                } else {
                    if (nX.mType == 1) {
                        TiebaStatic.log(new aq("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener mvz = new CustomMessageListener(2921492) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.mainTab.c cVar;
            if (customResponsedMessage != null && d.this.mTabHost != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.c) && (cVar = (com.baidu.tbadk.mainTab.c) customResponsedMessage.getData()) != null && d.this.mTabHost.nY(cVar.type) != null && d.this.mTabHost.getCurrentTabType() != 21) {
                FragmentTabHost.b nY = d.this.mTabHost.nY(cVar.type);
                if (nY.ekW instanceof MaintabBottomIndicator) {
                    ((MaintabBottomIndicator) nY.ekW).setImageIconUrl(cVar.eSt, cVar.text);
                }
            }
        }
    };
    private CustomMessageListener mvA = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dCT() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.isInterrupt = true;
                        d.this.eSD = true;
                        if (d.this.mvw != 2) {
                            if (d.this.mvv.isAnimating()) {
                                d.this.mvv.jv(d.this.eSD);
                                return;
                            }
                            return;
                        }
                        d.this.dCT().bup();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.isInterrupt = false;
                        if (d.this.mvw == 1) {
                            return;
                        }
                    } else {
                        d.this.mvw = intValue;
                    }
                    if (d.this.mvw == 1) {
                        d.this.dCT().jv(d.this.eSD);
                    } else if (d.this.mvw == 2) {
                        d.this.dCT().bun();
                    } else if (intValue == 5) {
                        d.this.mvw = 1;
                        d.this.eSD = true;
                        if (!d.this.isInterrupt) {
                            d.this.dCT().bup();
                        }
                    } else {
                        d.this.dCT().buo();
                    }
                    d.this.dCT().eSC = true;
                    d.this.dCT().eSE = d.this.mvw;
                    d.this.dCT().eSD = d.this.eSD;
                }
            }
        }
    };
    private CustomMessageListener mvB = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.eSD = true;
            if (d.this.dCT() != null) {
                d.this.dCT().eSD = d.this.eSD;
            }
        }
    };
    private Runnable iDg = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.mvs != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.mvh.getActivity());
                int dimens = l.getDimens(d.this.mvh.getActivity(), R.dimen.ds178);
                View contentView = d.this.mvs.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b nY = d.this.mTabHost.nY(3);
                    if (nY != null && (tbFragmentTabIndicator = nY.ekW) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.mvh.getActivity(), R.dimen.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.mvs, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.mvt = true;
                        d.this.mHandler.postDelayed(d.this.iDh, 5000L);
                    }
                }
            }
        }
    };
    private Runnable iDh = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // java.lang.Runnable
        public void run() {
            d.this.dCV();
        }
    };
    private View.OnClickListener iDi = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dCV();
        }
    };

    public void setCurrentTabByType(int i) {
        crf().setCurrentTabByType(i);
        if (i != 2) {
            this.isInterrupt = true;
            if (this.eSD) {
                this.mvv.jv(false);
            }
            this.eSD = false;
            if (dCT() != null) {
                dCT().eSD = this.eSD;
            }
        }
    }

    public d(MainTabActivity mainTabActivity) {
        this.mvh = mainTabActivity;
    }

    public void wv(boolean z) {
        this.mTabHost = (FragmentTabHost) this.mvh.findViewById(R.id.tab_host);
        this.mTabHost.setup(this.mvh.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.mvy);
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
                d.this.dCU();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.nX(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.hDc.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                if (d.this.mTabHost.getCurrentTabType() == 1 && !com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                d.this.ksh = d.this.mTabHost.getCurrentTabType();
                d.this.dCR();
                if (com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (d.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).dF("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.mvr = com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        bvT();
        this.mvp = (ImageView) this.mvh.findViewById(R.id.home_page_new_write_icon);
        this.mvq = (TextView) this.mvh.findViewById(R.id.view_bottom_text);
        this.mvo = (TextView) this.mvh.findViewById(R.id.activity_prize_my_tip);
        this.mTabHost.setUIType(0);
        this.mTabHost.setTabContainerShadowShow(true);
        this.mTabHost.setBackGroundStyle(0);
        this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        dCQ();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.mvh.getPageContext()));
        switchNaviBarStatus(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.mvh.registerListener(this.mvA);
        }
        this.mvh.registerListener(this.mvB);
        this.mvh.registerListener(this.mvz);
    }

    public void RH(final String str) {
        if (StringUtils.isNull(str)) {
            this.mvo.setVisibility(8);
            return;
        }
        FragmentTabHost.b nY = this.mTabHost.nY(8);
        if (nY != null) {
            if (!this.mvt || (this.mvs != null && this.mvs.isShowing())) {
                if (this.mvC == null) {
                    this.mvC = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.15
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.RH(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.mvC);
                TbadkCoreApplication.getInst().handler.postDelayed(this.mvC, 5000L);
                return;
            }
            a(str, nY);
            return;
        }
        this.mvo.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.ekW.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.mvh).widthPixels - (iArr[0] + (bVar.ekW.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mvo.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.mvh.getPageContext().getPageActivity(), R.dimen.ds26);
        this.mvo.setLayoutParams(layoutParams);
        this.mvo.setVisibility(0);
        this.mvo.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void dCO() {
        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.mvr);
    }

    public boolean dCP() {
        return this.mvm != null && this.mvm.getVisibility() == 0;
    }

    public void ww(boolean z) {
        if (this.mvm != null) {
            if (z) {
                this.mvm.setVisibility(0);
            } else {
                this.mvm.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.mvh.getPageContext(), i);
        ap.setNavbarTitleColor(this.mvl, R.color.cp_cont_b, R.color.s_navbar_title_color, i);
        ap.setImageResource(this.mvn, R.drawable.icon_news_down_bar_one);
        ap.setNavbarIconSrc(this.mvm, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        ap.setViewTextColor(this.mvq, R.color.cp_cont_f);
        SvgManager.bkl().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bkl().a(this.hDc, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
                dCQ();
                return;
            }
            this.mTabHost.showTabWidget();
        }
    }

    public void dCQ() {
        if (this.mvp != null) {
            this.mvp.setVisibility(8);
        }
        if (this.mvq != null) {
            this.mvq.setVisibility(8);
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.mvh.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            ap.setViewTextColor(textView, R.color.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.brO())) {
                textView.setText(payMemberInfoData.brO());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ap.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mvh.getPageContext().getPageActivity());
            aVar.aZ(inflate);
            aVar.nF(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.mvh.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.mvh.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.mvh.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.mvh.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.mvh.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.mvh.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.mvh.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.ie(false);
            aVar.b(this.mvh.getPageContext()).bia();
            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void dCR() {
        FragmentTabHost.b nY;
        if (this.mTabHost != null && (nY = this.mTabHost.nY(this.mTabHost.getCurrentTabType())) != null && nY.ekX != null && nY.ekX.getFragmentTabStructure() != null) {
            String string = this.mvh.getPageContext().getString(nY.ekX.getFragmentTabStructure().textResId);
            if (this.mvl != null) {
                this.mvl.setText(string);
            }
        }
    }

    public void bvT() {
        this.mNavigationBar = (NavigationBar) this.mvh.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.mvl = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.mvh.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.mvl.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.mvm = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.mvn = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.mvm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.wz(false);
                    d.this.mvn.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.mvh.getPageContext()));
                    TiebaStatic.eventStat(d.this.mvh.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.mvh.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.mvh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.mvh.getPageContext().getPageActivity())));
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
            this.hDc = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.hDc.setLayoutParams(layoutParams2);
            this.hDc.setVisibility(8);
            this.hDc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.mvh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.mvh.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mvh.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bg.skipToLoginActivity(d.this.mvh.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mvh.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.ksh) {
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
                    TiebaStatic.log(new aq("c10517").dF("obj_source", str));
                    bg.skipToRegisterActivity(d.this.mvh.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void wx(boolean z) {
        if (z) {
            this.hDc.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.hDc.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void wy(boolean z) {
        if (dCP()) {
            if (z) {
                if (this.mvn.getVisibility() != 0) {
                    this.mvn.setVisibility(0);
                    wz(true);
                    ap.setImageResource(this.mvn, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            wz(false);
            this.mvn.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wz(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mvm.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.mvh.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.mvh.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.mvm.setLayoutParams(layoutParams);
        }
    }

    public void aR(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.mvh.getPageContext().getPageActivity()));
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

    public void sg(boolean z) {
        this.ksl = z;
        if (!this.ksl) {
            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean cVp() {
        return this.ksl;
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
                this.mvx = true;
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.eSu) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.mvu = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (!at.isEmpty(cVar.eSt)) {
                maintabBottomIndicator.setImageIconUrl(cVar.eSt, cVar.text);
            }
            if (bVar2.mType == 2) {
                this.mvv = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.ekW = maintabBottomIndicator;
            bVar2.ekX = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost crf() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator dCS() {
        return this.mvu;
    }

    public MaintabBottomIndicator dCT() {
        return this.mvv;
    }

    public void dCU() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void dCV() {
        this.mHandler.removeCallbacks(this.iDg);
        this.mHandler.removeCallbacks(this.iDh);
        g.dismissPopupWindow(this.mvs);
    }

    public void RI(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mvh.getActivity());
        aVar.zV(str);
        aVar.a(R.string.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aq aqVar = new aq("c12137");
                aqVar.dF("obj_locate", "1");
                TiebaStatic.log(aqVar);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aq aqVar = new aq("c12137");
                aqVar.dF("obj_locate", "2");
                TiebaStatic.log(aqVar);
                aVar2.dismiss();
                com.baidu.tieba.j.a.cyZ();
            }
        });
        aVar.b(this.mvh.getPageContext()).bia();
    }

    public void onDestroy() {
        dCO();
        if (crf() != null) {
            crf().reset();
        }
        dCV();
        if (this.ivz != null) {
            this.ivz.onDestroy();
        }
        if (this.icW != null) {
            this.icW.csi();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.mvh).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.ivz == null) {
            this.ivz = new h(this.mvh.getPageContext(), (NavigationBarCoverTip) this.mvh.findViewById(R.id.navigation_cover_tip));
        }
        this.ivz.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.icW == null) {
                this.icW = new com.baidu.tieba.video.f(this.mvh, this.mvh.getActivityRootView());
            }
            this.icW.j(postWriteCallBackData);
        }
    }

    public void dCW() {
        this.isInterrupt = false;
        this.mvw = 1;
        if (dCT() != null) {
            dCT().eSE = this.mvw;
        }
    }
}
