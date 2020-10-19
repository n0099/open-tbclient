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
    private ImageView hRY;
    private h iKs;
    private com.baidu.tieba.video.f irX;
    private boolean kHx;
    private MainTabActivity mKR;
    private TextView mKV;
    private ImageView mKW;
    private ImageView mKX;
    private TextView mKY;
    private ImageView mKZ;
    private TextView mLa;
    private PopupWindow mLc;
    private MaintabBottomIndicator mLe;
    private MaintabBottomIndicator mLf;
    private Runnable mLm;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean mLb = false;
    private int kHt = -1;
    private boolean mLd = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean feL = true;
    private int mLg = 1;
    private boolean isInterrupt = false;
    private boolean mLh = false;
    private FragmentTabHost.a mLi = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b ou = d.this.mTabHost.ou(i);
            if (ou.mType == 8) {
                if (d.this.mLe != null && d.this.mLe.getAnimationView() != null && d.this.mLe.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new aq("c10605").aj("obj_type", 1));
                } else {
                    TiebaStatic.log(new aq("c10605").aj("obj_type", 0));
                }
                if (d.this.mLe != null) {
                    d.this.mLe.bwT();
                }
                TiebaStatic.log("c13841");
            } else if (ou.mType == 3) {
                TiebaStatic.log(new aq(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).aj("obj_locate", 1));
                TiebaStatic.log(new aq(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).aj("obj_locate", 1));
            }
            if (ou.mType == 2) {
                if (d.this.feL) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.feL = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.mLg != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.mLg == 1) {
                        d.this.mLf.jT(d.this.feL);
                    }
                } else {
                    d.this.mLf.bwX();
                }
                d.this.isInterrupt = false;
            } else {
                d.this.isInterrupt = true;
                if (d.this.feL) {
                    d.this.mLf.jT(d.this.feL);
                }
                d.this.feL = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.dGF() != null) {
                d.this.dGF().feL = d.this.feL;
            }
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b ou = d.this.mTabHost.ou(i);
            if (ou.mType == 9) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new j(0)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (ou.mType == 8 && !bg.checkUpIsLogin(d.this.mKR.getActivity())) {
                if (d.this.mLe != null) {
                    d.this.mLe.bwT();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (ou.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        be.bmY().a(d.this.mKR.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (ou.mType == 3 && !bg.checkUpIsLogin(d.this.mKR.getActivity())) {
                    return false;
                } else {
                    if (ou.mType == 1) {
                        TiebaStatic.log(new aq("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener mLj = new CustomMessageListener(2921492) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.mainTab.c cVar;
            if (customResponsedMessage != null && d.this.mTabHost != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.c) && (cVar = (com.baidu.tbadk.mainTab.c) customResponsedMessage.getData()) != null && d.this.mTabHost.ov(cVar.type) != null && d.this.mTabHost.getCurrentTabType() != 21) {
                FragmentTabHost.b ov = d.this.mTabHost.ov(cVar.type);
                if (ov.exe instanceof MaintabBottomIndicator) {
                    ((MaintabBottomIndicator) ov.exe).setImageIconUrl(cVar.feB, cVar.text);
                }
            }
        }
    };
    private CustomMessageListener mLk = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dGF() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.isInterrupt = true;
                        d.this.feL = true;
                        if (d.this.mLg != 2) {
                            if (d.this.mLf.isAnimating()) {
                                d.this.mLf.jT(d.this.feL);
                                return;
                            }
                            return;
                        }
                        d.this.dGF().bwZ();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.isInterrupt = false;
                        if (d.this.mLg == 1) {
                            return;
                        }
                    } else {
                        d.this.mLg = intValue;
                    }
                    if (d.this.mLg == 1) {
                        d.this.dGF().jT(d.this.feL);
                    } else if (d.this.mLg == 2) {
                        d.this.dGF().bwX();
                    } else if (intValue == 5) {
                        d.this.mLg = 1;
                        d.this.feL = true;
                        if (!d.this.isInterrupt) {
                            d.this.dGF().bwZ();
                        }
                    } else {
                        d.this.dGF().bwY();
                    }
                    d.this.dGF().feK = true;
                    d.this.dGF().feM = d.this.mLg;
                    d.this.dGF().feL = d.this.feL;
                }
            }
        }
    };
    private CustomMessageListener mLl = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.feL = true;
            if (d.this.dGF() != null) {
                d.this.dGF().feL = d.this.feL;
            }
        }
    };
    private Runnable iRW = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.mLc != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.mKR.getActivity());
                int dimens = l.getDimens(d.this.mKR.getActivity(), R.dimen.ds178);
                View contentView = d.this.mLc.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b ov = d.this.mTabHost.ov(3);
                    if (ov != null && (tbFragmentTabIndicator = ov.exe) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.mKR.getActivity(), R.dimen.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.mLc, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.mLd = true;
                        d.this.mHandler.postDelayed(d.this.iRX, 5000L);
                    }
                }
            }
        }
    };
    private Runnable iRX = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // java.lang.Runnable
        public void run() {
            d.this.dGH();
        }
    };
    private View.OnClickListener iRY = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dGH();
        }
    };

    public void setCurrentTabByType(int i) {
        cuD().setCurrentTabByType(i);
        if (i != 2) {
            this.isInterrupt = true;
            if (this.feL) {
                this.mLf.jT(false);
            }
            this.feL = false;
            if (dGF() != null) {
                dGF().feL = this.feL;
            }
        }
    }

    public d(MainTabActivity mainTabActivity) {
        this.mKR = mainTabActivity;
    }

    public void xc(boolean z) {
        this.mTabHost = (FragmentTabHost) this.mKR.findViewById(R.id.tab_host);
        this.mTabHost.setup(this.mKR.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.mLi);
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
                d.this.dGG();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.ou(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.hRY.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                if (d.this.mTabHost.getCurrentTabType() == 1 && !com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                d.this.kHt = d.this.mTabHost.getCurrentTabType();
                d.this.dGD();
                if (com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (d.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).dK("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.mLb = com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        byD();
        this.mKZ = (ImageView) this.mKR.findViewById(R.id.home_page_new_write_icon);
        this.mLa = (TextView) this.mKR.findViewById(R.id.view_bottom_text);
        this.mKY = (TextView) this.mKR.findViewById(R.id.activity_prize_my_tip);
        this.mTabHost.setUIType(0);
        this.mTabHost.setTabContainerShadowShow(true);
        this.mTabHost.setBackGroundStyle(0);
        this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        dGC();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.mKR.getPageContext()));
        switchNaviBarStatus(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.mKR.registerListener(this.mLk);
        }
        this.mKR.registerListener(this.mLl);
        this.mKR.registerListener(this.mLj);
    }

    public void Sv(final String str) {
        if (StringUtils.isNull(str)) {
            this.mKY.setVisibility(8);
            return;
        }
        FragmentTabHost.b ov = this.mTabHost.ov(8);
        if (ov != null) {
            if (!this.mLd || (this.mLc != null && this.mLc.isShowing())) {
                if (this.mLm == null) {
                    this.mLm = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.15
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.Sv(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.mLm);
                TbadkCoreApplication.getInst().handler.postDelayed(this.mLm, 5000L);
                return;
            }
            a(str, ov);
            return;
        }
        this.mKY.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.exe.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.mKR).widthPixels - (iArr[0] + (bVar.exe.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mKY.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.mKR.getPageContext().getPageActivity(), R.dimen.ds26);
        this.mKY.setLayoutParams(layoutParams);
        this.mKY.setVisibility(0);
        this.mKY.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void dGA() {
        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.mLb);
    }

    public boolean dGB() {
        return this.mKW != null && this.mKW.getVisibility() == 0;
    }

    public void xd(boolean z) {
        if (this.mKW != null) {
            if (z) {
                this.mKW.setVisibility(0);
            } else {
                this.mKW.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.mKR.getPageContext(), i);
        ap.setNavbarTitleColor(this.mKV, R.color.cp_cont_b, R.color.s_navbar_title_color, i);
        ap.setImageResource(this.mKX, R.drawable.icon_news_down_bar_one);
        ap.setNavbarIconSrc(this.mKW, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        ap.setViewTextColor(this.mLa, R.color.cp_cont_f);
        SvgManager.bmU().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bmU().a(this.hRY, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
                dGC();
                return;
            }
            this.mTabHost.showTabWidget();
        }
    }

    public void dGC() {
        if (this.mKZ != null) {
            this.mKZ.setVisibility(8);
        }
        if (this.mLa != null) {
            this.mLa.setVisibility(8);
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.mKR.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            ap.setViewTextColor(textView, R.color.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.buy())) {
                textView.setText(payMemberInfoData.buy());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ap.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mKR.getPageContext().getPageActivity());
            aVar.ba(inflate);
            aVar.oc(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.mKR.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.mKR.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.mKR.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.mKR.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.mKR.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.mKR.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.mKR.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.iA(false);
            aVar.b(this.mKR.getPageContext()).bkJ();
            com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void dGD() {
        FragmentTabHost.b ov;
        if (this.mTabHost != null && (ov = this.mTabHost.ov(this.mTabHost.getCurrentTabType())) != null && ov.exf != null && ov.exf.getFragmentTabStructure() != null) {
            String string = this.mKR.getPageContext().getString(ov.exf.getFragmentTabStructure().textResId);
            if (this.mKV != null) {
                this.mKV.setText(string);
            }
        }
    }

    public void byD() {
        this.mNavigationBar = (NavigationBar) this.mKR.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.mKV = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.mKR.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.mKV.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.mKW = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.mKX = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.mKW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.xg(false);
                    d.this.mKX.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.mKR.getPageContext()));
                    TiebaStatic.eventStat(d.this.mKR.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.mKR.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.mKR.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.mKR.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new aq(CommonStatisticKey.SEARCH_BAR_CLICK).aj("obj_type", i));
                }
            });
            this.hRY = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.hRY.setLayoutParams(layoutParams2);
            this.hRY.setVisibility(8);
            this.hRY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.mKR.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.mKR.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mKR.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bg.skipToLoginActivity(d.this.mKR.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mKR.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.kHt) {
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
                    TiebaStatic.log(new aq("c10517").dK("obj_source", str));
                    bg.skipToRegisterActivity(d.this.mKR.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void xe(boolean z) {
        if (z) {
            this.hRY.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.hRY.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void xf(boolean z) {
        if (dGB()) {
            if (z) {
                if (this.mKX.getVisibility() != 0) {
                    this.mKX.setVisibility(0);
                    xg(true);
                    ap.setImageResource(this.mKX, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            xg(false);
            this.mKX.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xg(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mKW.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.mKR.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.mKR.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.mKW.setLayoutParams(layoutParams);
        }
    }

    public void aR(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.mKR.getPageContext().getPageActivity()));
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

    public void sN(boolean z) {
        this.kHx = z;
        if (!this.kHx) {
            com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean cYY() {
        return this.kHx;
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
                this.mLh = true;
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.feC) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.mLe = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (!at.isEmpty(cVar.feB)) {
                maintabBottomIndicator.setImageIconUrl(cVar.feB, cVar.text);
            }
            if (bVar2.mType == 2) {
                this.mLf = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.exe = maintabBottomIndicator;
            bVar2.exf = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost cuD() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator dGE() {
        return this.mLe;
    }

    public MaintabBottomIndicator dGF() {
        return this.mLf;
    }

    public void dGG() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void dGH() {
        this.mHandler.removeCallbacks(this.iRW);
        this.mHandler.removeCallbacks(this.iRX);
        g.dismissPopupWindow(this.mLc);
    }

    public void Sw(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mKR.getActivity());
        aVar.AH(str);
        aVar.a(R.string.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aq aqVar = new aq("c12137");
                aqVar.dK("obj_locate", "1");
                TiebaStatic.log(aqVar);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aq aqVar = new aq("c12137");
                aqVar.dK("obj_locate", "2");
                TiebaStatic.log(aqVar);
                aVar2.dismiss();
                com.baidu.tieba.j.a.cCx();
            }
        });
        aVar.b(this.mKR.getPageContext()).bkJ();
    }

    public void onDestroy() {
        dGA();
        if (cuD() != null) {
            cuD().reset();
        }
        dGH();
        if (this.iKs != null) {
            this.iKs.onDestroy();
        }
        if (this.irX != null) {
            this.irX.cvF();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.mKR).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.iKs == null) {
            this.iKs = new h(this.mKR.getPageContext(), (NavigationBarCoverTip) this.mKR.findViewById(R.id.navigation_cover_tip));
        }
        this.iKs.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.irX == null) {
                this.irX = new com.baidu.tieba.video.f(this.mKR, this.mKR.getActivityRootView());
            }
            this.irX.j(postWriteCallBackData);
        }
    }

    public void dGI() {
        this.isInterrupt = false;
        this.mLg = 1;
        if (dGF() != null) {
            dGF().feM = this.mLg;
        }
    }
}
