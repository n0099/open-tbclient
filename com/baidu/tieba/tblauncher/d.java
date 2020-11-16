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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.data.j;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.d.h;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes21.dex */
public class d {
    private com.baidu.tieba.video.f iLd;
    private ImageView ilk;
    private h jdy;
    private boolean laj;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private TextView neB;
    private ImageView neC;
    private ImageView neD;
    private TextView neE;
    private ImageView neF;
    private TextView neG;
    private PopupWindow neI;
    private MaintabBottomIndicator neK;
    private MaintabBottomIndicator neL;
    private Runnable neS;
    private MainTabActivity nex;
    private boolean neH = false;
    private int laf = -1;
    private boolean neJ = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean fso = true;
    private int neM = 1;
    private boolean isInterrupt = false;
    private boolean neN = false;
    private FragmentTabHost.a neO = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b pk = d.this.mTabHost.pk(i);
            if (pk.mType == 8) {
                if (d.this.neK != null && d.this.neK.getAnimationView() != null && d.this.neK.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new ar("c10605").ak("obj_type", 1));
                } else {
                    TiebaStatic.log(new ar("c10605").ak("obj_type", 0));
                }
                if (d.this.neK != null) {
                    d.this.neK.bAB();
                }
                TiebaStatic.log("c13841");
            } else if (pk.mType == 3) {
                TiebaStatic.log(new ar(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).ak("obj_locate", 1));
                TiebaStatic.log(new ar(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ak("obj_locate", 1));
            }
            if (pk.mType == 2) {
                if (d.this.fso) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.fso = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.neM != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.neM == 1) {
                        d.this.neL.kq(d.this.fso);
                    }
                } else {
                    d.this.neL.bAF();
                }
                d.this.isInterrupt = false;
            } else {
                d.this.isInterrupt = true;
                if (d.this.fso) {
                    d.this.neL.kq(d.this.fso);
                }
                d.this.fso = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.dMo() != null) {
                d.this.dMo().fso = d.this.fso;
            }
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b pk = d.this.mTabHost.pk(i);
            if (pk.mType == 9) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new j(0)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (pk.mType == 8 && !bh.checkUpIsLogin(d.this.nex.getActivity())) {
                if (d.this.neK != null) {
                    d.this.neK.bAB();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (pk.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        bf.bqF().a(d.this.nex.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (pk.mType == 3 && !bh.checkUpIsLogin(d.this.nex.getActivity())) {
                    return false;
                } else {
                    if (pk.mType == 1) {
                        TiebaStatic.log(new ar("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener neP = new CustomMessageListener(2921492) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.mainTab.c cVar;
            if (customResponsedMessage != null && d.this.mTabHost != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.c) && (cVar = (com.baidu.tbadk.mainTab.c) customResponsedMessage.getData()) != null && d.this.mTabHost.pl(cVar.type) != null && d.this.mTabHost.getCurrentTabType() != 21) {
                FragmentTabHost.b pl2 = d.this.mTabHost.pl(cVar.type);
                if (pl2.eKr instanceof MaintabBottomIndicator) {
                    ((MaintabBottomIndicator) pl2.eKr).setImageIconUrl(cVar.fsd, cVar.text);
                }
            }
        }
    };
    private CustomMessageListener neQ = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dMo() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.isInterrupt = true;
                        d.this.fso = true;
                        if (d.this.neM != 2) {
                            if (d.this.neL.isAnimating()) {
                                d.this.neL.kq(d.this.fso);
                                return;
                            }
                            return;
                        }
                        d.this.dMo().bAH();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.isInterrupt = false;
                        if (d.this.neM == 1) {
                            return;
                        }
                    } else {
                        d.this.neM = intValue;
                    }
                    if (d.this.neM == 1) {
                        d.this.dMo().kq(d.this.fso);
                    } else if (d.this.neM == 2) {
                        d.this.dMo().bAF();
                    } else if (intValue == 5) {
                        d.this.neM = 1;
                        d.this.fso = true;
                        if (!d.this.isInterrupt) {
                            d.this.dMo().bAH();
                        }
                    } else {
                        d.this.dMo().bAG();
                    }
                    d.this.dMo().fsn = true;
                    d.this.dMo().fsp = d.this.neM;
                    d.this.dMo().fso = d.this.fso;
                }
            }
        }
    };
    private CustomMessageListener neR = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.fso = true;
            if (d.this.dMo() != null) {
                d.this.dMo().fso = d.this.fso;
            }
        }
    };
    private Runnable jla = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.neI != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.nex.getActivity());
                int dimens = l.getDimens(d.this.nex.getActivity(), R.dimen.ds178);
                View contentView = d.this.neI.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b pl2 = d.this.mTabHost.pl(3);
                    if (pl2 != null && (tbFragmentTabIndicator = pl2.eKr) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.nex.getActivity(), R.dimen.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.neI, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.neJ = true;
                        d.this.mHandler.postDelayed(d.this.jlb, 5000L);
                    }
                }
            }
        }
    };
    private Runnable jlb = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // java.lang.Runnable
        public void run() {
            d.this.dMq();
        }
    };
    private View.OnClickListener jlc = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dMq();
        }
    };

    public void setCurrentTabByType(int i) {
        czO().setCurrentTabByType(i);
        if (i != 2) {
            this.isInterrupt = true;
            if (this.fso) {
                this.neL.kq(false);
            }
            this.fso = false;
            if (dMo() != null) {
                dMo().fso = this.fso;
            }
        }
    }

    public d(MainTabActivity mainTabActivity) {
        this.nex = mainTabActivity;
    }

    public void xJ(boolean z) {
        this.mTabHost = (FragmentTabHost) this.nex.findViewById(R.id.tab_host);
        this.mTabHost.setup(this.nex.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.neO);
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
                d.this.dMp();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.pk(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.ilk.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                if (d.this.mTabHost.getCurrentTabType() == 1 && !com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                d.this.laf = d.this.mTabHost.getCurrentTabType();
                d.this.dMm();
                if (com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
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

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.neH = com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        bCo();
        this.neF = (ImageView) this.nex.findViewById(R.id.home_page_new_write_icon);
        this.neG = (TextView) this.nex.findViewById(R.id.view_bottom_text);
        this.neE = (TextView) this.nex.findViewById(R.id.activity_prize_my_tip);
        this.mTabHost.setUIType(0);
        this.mTabHost.setTabContainerShadowShow(false);
        this.mTabHost.setBackGroundStyle(0);
        this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        dMl();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.nex.getPageContext()));
        switchNaviBarStatus(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.nex.registerListener(this.neQ);
        }
        this.nex.registerListener(this.neR);
        this.nex.registerListener(this.neP);
    }

    public void SW(final String str) {
        if (StringUtils.isNull(str)) {
            this.neE.setVisibility(8);
            return;
        }
        FragmentTabHost.b pl2 = this.mTabHost.pl(8);
        if (pl2 != null) {
            if (!this.neJ || (this.neI != null && this.neI.isShowing())) {
                if (this.neS == null) {
                    this.neS = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.15
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.SW(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.neS);
                TbadkCoreApplication.getInst().handler.postDelayed(this.neS, 5000L);
                return;
            }
            a(str, pl2);
            return;
        }
        this.neE.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.eKr.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.nex).widthPixels - (iArr[0] + (bVar.eKr.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.neE.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.nex.getPageContext().getPageActivity(), R.dimen.ds26);
        this.neE.setLayoutParams(layoutParams);
        this.neE.setVisibility(0);
        this.neE.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void dMj() {
        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.neH);
    }

    public boolean dMk() {
        return this.neC != null && this.neC.getVisibility() == 0;
    }

    public void xK(boolean z) {
        if (this.neC != null) {
            if (z) {
                this.neC.setVisibility(0);
            } else {
                this.neC.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.nex.getPageContext(), i);
        ap.setNavbarTitleColor(this.neB, R.color.CAM_X0105, R.color.s_navbar_title_color, i);
        ap.setImageResource(this.neD, R.drawable.icon_news_down_bar_one);
        ap.setNavbarIconSrc(this.neC, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        ap.setViewTextColor(this.neG, R.color.CAM_X0106);
        SvgManager.bqB().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bqB().a(this.ilk, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
                dMl();
                return;
            }
            this.mTabHost.showTabWidget();
        }
    }

    public void dMl() {
        if (this.neF != null) {
            this.neF.setVisibility(8);
        }
        if (this.neG != null) {
            this.neG.setVisibility(8);
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.nex.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            ap.setViewTextColor(textView, R.color.CAM_X0105, 1);
            if (!StringUtils.isNull(payMemberInfoData.byg())) {
                textView.setText(payMemberInfoData.byg());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ap.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nex.getPageContext().getPageActivity());
            aVar.bg(inflate);
            aVar.ot(R.color.CAM_X0305);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.nex.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.nex.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.nex.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.nex.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.nex.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.nex.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.nex.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.iX(false);
            aVar.b(this.nex.getPageContext()).bog();
            com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void dMm() {
        FragmentTabHost.b pl2;
        if (this.mTabHost != null && (pl2 = this.mTabHost.pl(this.mTabHost.getCurrentTabType())) != null && pl2.eKs != null && pl2.eKs.getFragmentTabStructure() != null) {
            String string = this.nex.getPageContext().getString(pl2.eKs.getFragmentTabStructure().textResId);
            if (this.neB != null) {
                this.neB.setText(string);
            }
        }
    }

    public void bCo() {
        this.mNavigationBar = (NavigationBar) this.nex.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.neB = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.nex.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.neB.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.neC = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.neD = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.neC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.xN(false);
                    d.this.neD.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.nex.getPageContext()));
                    TiebaStatic.eventStat(d.this.nex.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.nex.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.nex.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.nex.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new ar(CommonStatisticKey.SEARCH_BAR_CLICK).ak("obj_type", i));
                }
            });
            this.ilk = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.ilk.setLayoutParams(layoutParams2);
            this.ilk.setVisibility(8);
            this.ilk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.nex.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.nex.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.nex.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bh.skipToLoginActivity(d.this.nex.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.nex.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.laf) {
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
                    bh.skipToRegisterActivity(d.this.nex.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void xL(boolean z) {
        if (z) {
            this.ilk.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.ilk.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void xM(boolean z) {
        if (dMk()) {
            if (z) {
                if (this.neD.getVisibility() != 0) {
                    this.neD.setVisibility(0);
                    xN(true);
                    ap.setImageResource(this.neD, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            xN(false);
            this.neD.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xN(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.neC.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.nex.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.nex.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.neC.setLayoutParams(layoutParams);
        }
    }

    public void aV(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.nex.getPageContext().getPageActivity()));
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

    public void tq(boolean z) {
        this.laj = z;
        if (!this.laj) {
            com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean def() {
        return this.laj;
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
                this.neN = true;
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.fse) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.neK = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (!au.isEmpty(cVar.fsd)) {
                maintabBottomIndicator.setImageIconUrl(cVar.fsd, cVar.text);
            }
            if (bVar2.mType == 2) {
                this.neL = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.eKr = maintabBottomIndicator;
            bVar2.eKs = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost czO() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator dMn() {
        return this.neK;
    }

    public MaintabBottomIndicator dMo() {
        return this.neL;
    }

    public void dMp() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void dMq() {
        this.mHandler.removeCallbacks(this.jla);
        this.mHandler.removeCallbacks(this.jlb);
        g.dismissPopupWindow(this.neI);
    }

    public void SX(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nex.getActivity());
        aVar.AJ(str);
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
                com.baidu.tieba.k.a.cHK();
            }
        });
        aVar.b(this.nex.getPageContext()).bog();
    }

    public void onDestroy() {
        dMj();
        if (czO() != null) {
            czO().reset();
        }
        dMq();
        if (this.jdy != null) {
            this.jdy.onDestroy();
        }
        if (this.iLd != null) {
            this.iLd.cAQ();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || au.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.nex).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.jdy == null) {
            this.jdy = new h(this.nex.getPageContext(), (NavigationBarCoverTip) this.nex.findViewById(R.id.navigation_cover_tip));
        }
        this.jdy.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.iLd == null) {
                this.iLd = new com.baidu.tieba.video.f(this.nex, this.nex.getActivityRootView());
            }
            this.iLd.j(postWriteCallBackData);
        }
    }

    public void dMr() {
        this.isInterrupt = false;
        this.neM = 1;
        if (dMo() != null) {
            dMo().fsp = this.neM;
        }
    }
}
