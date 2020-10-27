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
    private com.baidu.tieba.video.f iEt;
    private h iWO;
    private ImageView iez;
    private boolean kTU;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private MainTabActivity mXA;
    private TextView mXE;
    private ImageView mXF;
    private ImageView mXG;
    private TextView mXH;
    private ImageView mXI;
    private TextView mXJ;
    private PopupWindow mXL;
    private MaintabBottomIndicator mXN;
    private MaintabBottomIndicator mXO;
    private Runnable mXV;
    private boolean mXK = false;
    private int kTQ = -1;
    private boolean mXM = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean fnk = true;
    private int mXP = 1;
    private boolean isInterrupt = false;
    private boolean mXQ = false;
    private FragmentTabHost.a mXR = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b oF = d.this.mTabHost.oF(i);
            if (oF.mType == 8) {
                if (d.this.mXN != null && d.this.mXN.getAnimationView() != null && d.this.mXN.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new aq("c10605").aj("obj_type", 1));
                } else {
                    TiebaStatic.log(new aq("c10605").aj("obj_type", 0));
                }
                if (d.this.mXN != null) {
                    d.this.mXN.byM();
                }
                TiebaStatic.log("c13841");
            } else if (oF.mType == 3) {
                TiebaStatic.log(new aq(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).aj("obj_locate", 1));
                TiebaStatic.log(new aq(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).aj("obj_locate", 1));
            }
            if (oF.mType == 2) {
                if (d.this.fnk) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.fnk = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.mXP != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.mXP == 1) {
                        d.this.mXO.kg(d.this.fnk);
                    }
                } else {
                    d.this.mXO.byQ();
                }
                d.this.isInterrupt = false;
            } else {
                d.this.isInterrupt = true;
                if (d.this.fnk) {
                    d.this.mXO.kg(d.this.fnk);
                }
                d.this.fnk = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.dJN() != null) {
                d.this.dJN().fnk = d.this.fnk;
            }
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b oF = d.this.mTabHost.oF(i);
            if (oF.mType == 9) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new j(0)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (oF.mType == 8 && !bg.checkUpIsLogin(d.this.mXA.getActivity())) {
                if (d.this.mXN != null) {
                    d.this.mXN.byM();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (oF.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        be.boR().a(d.this.mXA.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (oF.mType == 3 && !bg.checkUpIsLogin(d.this.mXA.getActivity())) {
                    return false;
                } else {
                    if (oF.mType == 1) {
                        TiebaStatic.log(new aq("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener mXS = new CustomMessageListener(2921492) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.mainTab.c cVar;
            if (customResponsedMessage != null && d.this.mTabHost != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.c) && (cVar = (com.baidu.tbadk.mainTab.c) customResponsedMessage.getData()) != null && d.this.mTabHost.oG(cVar.type) != null && d.this.mTabHost.getCurrentTabType() != 21) {
                FragmentTabHost.b oG = d.this.mTabHost.oG(cVar.type);
                if (oG.eFD instanceof MaintabBottomIndicator) {
                    ((MaintabBottomIndicator) oG.eFD).setImageIconUrl(cVar.fna, cVar.text);
                }
            }
        }
    };
    private CustomMessageListener mXT = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dJN() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.isInterrupt = true;
                        d.this.fnk = true;
                        if (d.this.mXP != 2) {
                            if (d.this.mXO.isAnimating()) {
                                d.this.mXO.kg(d.this.fnk);
                                return;
                            }
                            return;
                        }
                        d.this.dJN().byS();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.isInterrupt = false;
                        if (d.this.mXP == 1) {
                            return;
                        }
                    } else {
                        d.this.mXP = intValue;
                    }
                    if (d.this.mXP == 1) {
                        d.this.dJN().kg(d.this.fnk);
                    } else if (d.this.mXP == 2) {
                        d.this.dJN().byQ();
                    } else if (intValue == 5) {
                        d.this.mXP = 1;
                        d.this.fnk = true;
                        if (!d.this.isInterrupt) {
                            d.this.dJN().byS();
                        }
                    } else {
                        d.this.dJN().byR();
                    }
                    d.this.dJN().fnj = true;
                    d.this.dJN().fnl = d.this.mXP;
                    d.this.dJN().fnk = d.this.fnk;
                }
            }
        }
    };
    private CustomMessageListener mXU = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.fnk = true;
            if (d.this.dJN() != null) {
                d.this.dJN().fnk = d.this.fnk;
            }
        }
    };
    private Runnable jes = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.mXL != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.mXA.getActivity());
                int dimens = l.getDimens(d.this.mXA.getActivity(), R.dimen.ds178);
                View contentView = d.this.mXL.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b oG = d.this.mTabHost.oG(3);
                    if (oG != null && (tbFragmentTabIndicator = oG.eFD) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.mXA.getActivity(), R.dimen.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.mXL, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.mXM = true;
                        d.this.mHandler.postDelayed(d.this.jet, 5000L);
                    }
                }
            }
        }
    };
    private Runnable jet = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // java.lang.Runnable
        public void run() {
            d.this.dJP();
        }
    };
    private View.OnClickListener jeu = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dJP();
        }
    };

    public void setCurrentTabByType(int i) {
        cxK().setCurrentTabByType(i);
        if (i != 2) {
            this.isInterrupt = true;
            if (this.fnk) {
                this.mXO.kg(false);
            }
            this.fnk = false;
            if (dJN() != null) {
                dJN().fnk = this.fnk;
            }
        }
    }

    public d(MainTabActivity mainTabActivity) {
        this.mXA = mainTabActivity;
    }

    public void xt(boolean z) {
        this.mTabHost = (FragmentTabHost) this.mXA.findViewById(R.id.tab_host);
        this.mTabHost.setup(this.mXA.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.mXR);
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
                d.this.dJO();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.oF(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.iez.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                if (d.this.mTabHost.getCurrentTabType() == 1 && !com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                d.this.kTQ = d.this.mTabHost.getCurrentTabType();
                d.this.dJL();
                if (com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
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
        this.mXK = com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        bAw();
        this.mXI = (ImageView) this.mXA.findViewById(R.id.home_page_new_write_icon);
        this.mXJ = (TextView) this.mXA.findViewById(R.id.view_bottom_text);
        this.mXH = (TextView) this.mXA.findViewById(R.id.activity_prize_my_tip);
        this.mTabHost.setUIType(0);
        this.mTabHost.setTabContainerShadowShow(true);
        this.mTabHost.setBackGroundStyle(0);
        this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        dJK();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.mXA.getPageContext()));
        switchNaviBarStatus(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.mXA.registerListener(this.mXT);
        }
        this.mXA.registerListener(this.mXU);
        this.mXA.registerListener(this.mXS);
    }

    public void SU(final String str) {
        if (StringUtils.isNull(str)) {
            this.mXH.setVisibility(8);
            return;
        }
        FragmentTabHost.b oG = this.mTabHost.oG(8);
        if (oG != null) {
            if (!this.mXM || (this.mXL != null && this.mXL.isShowing())) {
                if (this.mXV == null) {
                    this.mXV = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.15
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.SU(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.mXV);
                TbadkCoreApplication.getInst().handler.postDelayed(this.mXV, 5000L);
                return;
            }
            a(str, oG);
            return;
        }
        this.mXH.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.eFD.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.mXA).widthPixels - (iArr[0] + (bVar.eFD.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mXH.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.mXA.getPageContext().getPageActivity(), R.dimen.ds26);
        this.mXH.setLayoutParams(layoutParams);
        this.mXH.setVisibility(0);
        this.mXH.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void dJI() {
        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.mXK);
    }

    public boolean dJJ() {
        return this.mXF != null && this.mXF.getVisibility() == 0;
    }

    public void xu(boolean z) {
        if (this.mXF != null) {
            if (z) {
                this.mXF.setVisibility(0);
            } else {
                this.mXF.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.mXA.getPageContext(), i);
        ap.setNavbarTitleColor(this.mXE, R.color.cp_cont_b, R.color.s_navbar_title_color, i);
        ap.setImageResource(this.mXG, R.drawable.icon_news_down_bar_one);
        ap.setNavbarIconSrc(this.mXF, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        ap.setViewTextColor(this.mXJ, R.color.cp_cont_f);
        SvgManager.boN().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.boN().a(this.iez, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
                dJK();
                return;
            }
            this.mTabHost.showTabWidget();
        }
    }

    public void dJK() {
        if (this.mXI != null) {
            this.mXI.setVisibility(8);
        }
        if (this.mXJ != null) {
            this.mXJ.setVisibility(8);
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.mXA.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            ap.setViewTextColor(textView, R.color.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.bwr())) {
                textView.setText(payMemberInfoData.bwr());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ap.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mXA.getPageContext().getPageActivity());
            aVar.bb(inflate);
            aVar.on(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.mXA.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.mXA.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.mXA.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.mXA.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.mXA.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.mXA.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.mXA.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.iN(false);
            aVar.b(this.mXA.getPageContext()).bmC();
            com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void dJL() {
        FragmentTabHost.b oG;
        if (this.mTabHost != null && (oG = this.mTabHost.oG(this.mTabHost.getCurrentTabType())) != null && oG.eFE != null && oG.eFE.getFragmentTabStructure() != null) {
            String string = this.mXA.getPageContext().getString(oG.eFE.getFragmentTabStructure().textResId);
            if (this.mXE != null) {
                this.mXE.setText(string);
            }
        }
    }

    public void bAw() {
        this.mNavigationBar = (NavigationBar) this.mXA.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.mXE = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.mXA.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.mXE.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.mXF = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.mXG = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.mXF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.xx(false);
                    d.this.mXG.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.mXA.getPageContext()));
                    TiebaStatic.eventStat(d.this.mXA.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.mXA.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.mXA.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.mXA.getPageContext().getPageActivity())));
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
            this.iez = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.iez.setLayoutParams(layoutParams2);
            this.iez.setVisibility(8);
            this.iez.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.mXA.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.mXA.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mXA.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bg.skipToLoginActivity(d.this.mXA.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mXA.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.kTQ) {
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
                    bg.skipToRegisterActivity(d.this.mXA.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void xv(boolean z) {
        if (z) {
            this.iez.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.iez.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void xw(boolean z) {
        if (dJJ()) {
            if (z) {
                if (this.mXG.getVisibility() != 0) {
                    this.mXG.setVisibility(0);
                    xx(true);
                    ap.setImageResource(this.mXG, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            xx(false);
            this.mXG.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xx(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mXF.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.mXA.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.mXA.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.mXF.setLayoutParams(layoutParams);
        }
    }

    public void aU(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.mXA.getPageContext().getPageActivity()));
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

    public void te(boolean z) {
        this.kTU = z;
        if (!this.kTU) {
            com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean dcg() {
        return this.kTU;
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
                this.mXQ = true;
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.fnb) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.mXN = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (!at.isEmpty(cVar.fna)) {
                maintabBottomIndicator.setImageIconUrl(cVar.fna, cVar.text);
            }
            if (bVar2.mType == 2) {
                this.mXO = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.eFD = maintabBottomIndicator;
            bVar2.eFE = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost cxK() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator dJM() {
        return this.mXN;
    }

    public MaintabBottomIndicator dJN() {
        return this.mXO;
    }

    public void dJO() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void dJP() {
        this.mHandler.removeCallbacks(this.jes);
        this.mHandler.removeCallbacks(this.jet);
        g.dismissPopupWindow(this.mXL);
    }

    public void SV(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mXA.getActivity());
        aVar.Ba(str);
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
                com.baidu.tieba.j.a.cFE();
            }
        });
        aVar.b(this.mXA.getPageContext()).bmC();
    }

    public void onDestroy() {
        dJI();
        if (cxK() != null) {
            cxK().reset();
        }
        dJP();
        if (this.iWO != null) {
            this.iWO.onDestroy();
        }
        if (this.iEt != null) {
            this.iEt.cyM();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.mXA).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.iWO == null) {
            this.iWO = new h(this.mXA.getPageContext(), (NavigationBarCoverTip) this.mXA.findViewById(R.id.navigation_cover_tip));
        }
        this.iWO.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.iEt == null) {
                this.iEt = new com.baidu.tieba.video.f(this.mXA, this.mXA.getActivityRootView());
            }
            this.iEt.j(postWriteCallBackData);
        }
    }

    public void dJQ() {
        this.isInterrupt = false;
        this.mXP = 1;
        if (dJN() != null) {
            dJN().fnl = this.mXP;
        }
    }
}
