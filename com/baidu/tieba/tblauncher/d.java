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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.c.g;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.f;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class d {
    private ImageView gBB;
    private f haP;
    private g hqZ;
    private boolean jef;
    private MainTabActivity kYH;
    private TextView kYL;
    private ImageView kYM;
    private ImageView kYN;
    private TextView kYO;
    private ImageView kYP;
    private TextView kYQ;
    private PopupWindow kYS;
    private MaintabBottomIndicator kYU;
    private MaintabBottomIndicator kYV;
    private Runnable kZb;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean kYR = false;
    private int jeb = -1;
    private boolean kYT = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean ebG = true;
    private int kYW = 1;
    private boolean isInterrupt = false;
    private boolean kYX = false;
    private FragmentTabHost.a kYY = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b kv = d.this.mTabHost.kv(i);
            if (kv.mType == 8) {
                if (d.this.kYU != null && d.this.kYU.getAnimationView() != null && d.this.kYU.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new an("c10605").af("obj_type", 1));
                } else {
                    TiebaStatic.log(new an("c10605").af("obj_type", 0));
                }
                if (d.this.kYU != null) {
                    d.this.kYU.aVk();
                }
            } else if (kv.mType == 3) {
                TiebaStatic.log(new an(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).af("obj_locate", 1));
                TiebaStatic.log(new an(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).af("obj_locate", 1));
            }
            if (kv.mType == 2) {
                if (d.this.ebG) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.ebG = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.kYW != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.kYW == 1) {
                        d.this.kYV.hK(d.this.ebG);
                    }
                } else {
                    d.this.kYV.aYx();
                }
                d.this.isInterrupt = false;
            } else {
                d.this.isInterrupt = true;
                if (d.this.ebG) {
                    d.this.kYV.hK(d.this.ebG);
                }
                d.this.ebG = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.cYy() != null) {
                d.this.cYy().ebG = d.this.ebG;
            }
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b kv = d.this.mTabHost.kv(i);
            if (kv.mType == 9) {
                if (bc.checkUpIsLogin(d.this.kYH.getPageContext().getPageActivity())) {
                    d.this.kYH.bQl();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (kv.mType == 8 && !bc.checkUpIsLogin(d.this.kYH.getActivity())) {
                if (d.this.kYU != null) {
                    d.this.kYU.aVk();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (kv.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ba.aOY().a(d.this.kYH.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (kv.mType == 3 && !bc.checkUpIsLogin(d.this.kYH.getActivity())) {
                    return false;
                } else {
                    if (kv.mType == 1) {
                        TiebaStatic.log(new an("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener kYZ = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.cYy() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.isInterrupt = true;
                        d.this.ebG = true;
                        if (d.this.kYW != 2) {
                            if (d.this.kYV.isAnimating()) {
                                d.this.kYV.hK(d.this.ebG);
                                return;
                            }
                            return;
                        }
                        d.this.cYy().aYz();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.isInterrupt = false;
                        if (d.this.kYW == 1) {
                            return;
                        }
                    } else {
                        d.this.kYW = intValue;
                    }
                    if (d.this.kYW == 1) {
                        d.this.cYy().hK(d.this.ebG);
                    } else if (d.this.kYW == 2) {
                        d.this.cYy().aYx();
                    } else if (intValue == 5) {
                        d.this.kYW = 1;
                        d.this.ebG = true;
                        if (!d.this.isInterrupt) {
                            d.this.cYy().aYz();
                        }
                    } else {
                        d.this.cYy().aYy();
                    }
                    d.this.cYy().ebF = true;
                    d.this.cYy().ebH = d.this.kYW;
                    d.this.cYy().ebG = d.this.ebG;
                }
            }
        }
    };
    private CustomMessageListener kZa = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.ebG = true;
            if (d.this.cYy() != null) {
                d.this.cYy().ebG = d.this.ebG;
            }
        }
    };
    private Runnable hyD = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.kYS != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.kYH.getActivity());
                int dimens = l.getDimens(d.this.kYH.getActivity(), R.dimen.ds178);
                View contentView = d.this.kYS.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b kw = d.this.mTabHost.kw(3);
                    if (kw != null && (tbFragmentTabIndicator = kw.dxF) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.kYH.getActivity(), R.dimen.tbds570);
                        }
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(d.this.kYS, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.kYT = true;
                        d.this.mHandler.postDelayed(d.this.hyE, 5000L);
                    }
                }
            }
        }
    };
    private Runnable hyE = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            d.this.cYA();
        }
    };
    private View.OnClickListener hyF = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.cYA();
        }
    };

    public d(MainTabActivity mainTabActivity) {
        this.kYH = mainTabActivity;
    }

    public void ue(boolean z) {
        this.mTabHost = (FragmentTabHost) this.kYH.findViewById(R.id.tab_host);
        this.mTabHost.setUIType(1);
        this.mTabHost.setup(this.kYH.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setTabContainerShadowShow(false);
        this.mTabHost.setBackGroundStyle(1);
        this.mTabHost.setOnTabSelectionListener(this.kYY);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.setShouldDrawIndicatorLine(false);
            this.mTabHost.setShouldDrawTopLine(true);
        }
        this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight() + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds73));
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
                d.this.cYz();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.kv(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.gBB.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                d.this.jeb = d.this.mTabHost.getCurrentTabType();
                d.this.cYw();
                if (com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (d.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).cI("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.kYR = com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        blF();
        this.kYP = (ImageView) this.kYH.findViewById(R.id.home_page_new_write_icon);
        this.kYQ = (TextView) this.kYH.findViewById(R.id.view_bottom_text);
        this.kYO = (TextView) this.kYH.findViewById(R.id.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.kYH.getPageContext()));
        switchNaviBarStatus(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.kYH.registerListener(this.kYZ);
        }
        this.kYH.registerListener(this.kZa);
    }

    public void Li(final String str) {
        if (StringUtils.isNull(str)) {
            this.kYO.setVisibility(8);
            return;
        }
        FragmentTabHost.b kw = this.mTabHost.kw(8);
        if (kw != null) {
            if (!this.kYT || (this.kYS != null && this.kYS.isShowing())) {
                if (this.kZb == null) {
                    this.kZb = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.13
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.Li(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.kZb);
                TbadkCoreApplication.getInst().handler.postDelayed(this.kZb, 5000L);
                return;
            }
            a(str, kw);
            return;
        }
        this.kYO.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.dxF.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.kYH).widthPixels - (iArr[0] + (bVar.dxF.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kYO.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.kYH.getPageContext().getPageActivity(), R.dimen.ds26);
        this.kYO.setLayoutParams(layoutParams);
        this.kYO.setVisibility(0);
        this.kYO.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void cYs() {
        com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.kYR);
    }

    public boolean cYt() {
        return this.kYM != null && this.kYM.getVisibility() == 0;
    }

    public void uf(boolean z) {
        if (this.kYM != null) {
            if (z) {
                this.kYM.setVisibility(0);
            } else {
                this.kYM.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.setShouldDrawTopLine(false);
        }
        if (this.mTabHost.getFragmentTabWidget() != null) {
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.mTabHost.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.kYH.getPageContext(), i);
        am.setNavbarTitleColor(this.kYL, R.color.cp_cont_b, R.color.s_navbar_title_color, i);
        am.setImageResource(this.kYN, R.drawable.icon_news_down_bar_one);
        am.setNavbarIconSrc(this.kYM, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        am.setViewTextColor(this.kYQ, (int) R.color.cp_cont_f);
        SvgManager.aOU().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aOU().a(this.gBB, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
                cYv();
                return;
            }
            this.mTabHost.showTabWidget();
            cYu();
        }
    }

    public void cYu() {
        if (this.kYP != null) {
            this.kYP.setVisibility(0);
        }
        if (this.kYQ != null) {
            this.kYQ.setVisibility(0);
        }
    }

    public void cYv() {
        if (this.kYP != null) {
            this.kYP.setVisibility(8);
        }
        if (this.kYQ != null) {
            this.kYQ.setVisibility(8);
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.kYH.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            am.setViewTextColor(textView, R.color.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.aWo())) {
                textView.setText(payMemberInfoData.aWo());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                am.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kYH.getPageContext().getPageActivity());
            aVar.aP(inflate);
            aVar.ke(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.kYH.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.kYH.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.kYH.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.kYH.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.kYH.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.kYH.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.kYH.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.gF(false);
            aVar.b(this.kYH.getPageContext()).aMU();
            com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void cYw() {
        FragmentTabHost.b kw;
        if (this.mTabHost != null && (kw = this.mTabHost.kw(this.mTabHost.getCurrentTabType())) != null && kw.dxG != null && kw.dxG.getFragmentTabStructure() != null) {
            String string = this.kYH.getPageContext().getString(kw.dxG.getFragmentTabStructure().textResId);
            if (this.kYL != null) {
                this.kYL.setText(string);
            }
        }
    }

    public void blF() {
        this.mNavigationBar = (NavigationBar) this.kYH.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.kYL = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.kYH.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.kYL.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.kYM = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.kYN = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.kYM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.ui(false);
                    d.this.kYN.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.kYH.getPageContext()));
                    TiebaStatic.eventStat(d.this.kYH.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.kYH.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.kYH.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.kYH.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new an(CommonStatisticKey.SEARCH_BAR_CLICK).af("obj_type", i));
                }
            });
            this.gBB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.gBB.setLayoutParams(layoutParams2);
            this.gBB.setVisibility(8);
            this.gBB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.kYH.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.kYH.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.kYH.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bc.skipToLoginActivity(d.this.kYH.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.kYH.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.jeb) {
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
                    TiebaStatic.log(new an("c10517").cI("obj_source", str));
                    bc.skipToRegisterActivity(d.this.kYH.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void ug(boolean z) {
        if (z) {
            this.gBB.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.gBB.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void uh(boolean z) {
        if (cYt()) {
            if (z) {
                if (this.kYN.getVisibility() != 0) {
                    this.kYN.setVisibility(0);
                    ui(true);
                    am.setImageResource(this.kYN, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            ui(false);
            this.kYN.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kYM.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.kYH.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.kYH.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.kYM.setLayoutParams(layoutParams);
        }
    }

    public void aH(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.kYH.getPageContext().getPageActivity()));
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

    public void qe(boolean z) {
        this.jef = z;
        if (!this.jef) {
            com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean csw() {
        return this.jef;
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
                cYu();
                this.kYX = true;
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.eby) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.kYU = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (bVar2.mType == 2) {
                this.kYV = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.dxF = maintabBottomIndicator;
            bVar2.dxG = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost bQn() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator cYx() {
        return this.kYU;
    }

    public MaintabBottomIndicator cYy() {
        return this.kYV;
    }

    public void cYz() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void cYA() {
        this.mHandler.removeCallbacks(this.hyD);
        this.mHandler.removeCallbacks(this.hyE);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.kYS);
    }

    public void Lj(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kYH.getActivity());
        aVar.uf(str);
        aVar.a(R.string.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                an anVar = new an("c12137");
                anVar.cI("obj_locate", "1");
                TiebaStatic.log(anVar);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                an anVar = new an("c12137");
                anVar.cI("obj_locate", "2");
                TiebaStatic.log(anVar);
                aVar2.dismiss();
                com.baidu.tieba.j.a.bXu();
            }
        });
        aVar.b(this.kYH.getPageContext()).aMU();
    }

    public void onDestroy() {
        cYs();
        if (bQn() != null) {
            bQn().reset();
        }
        cYA();
        if (this.hqZ != null) {
            this.hqZ.onDestroy();
        }
        if (this.haP != null) {
            this.haP.bRj();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.kYH).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.hqZ == null) {
            this.hqZ = new g(this.kYH.getPageContext(), (NavigationBarCoverTip) this.kYH.findViewById(R.id.navigation_cover_tip));
        }
        this.hqZ.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.haP == null) {
                this.haP = new f(this.kYH, this.kYH.getActivityRootView());
            }
            this.haP.h(postWriteCallBackData);
        }
    }

    public void cYB() {
        this.isInterrupt = false;
        this.kYW = 1;
        if (cYy() != null) {
            cYy().ebH = this.kYW;
        }
    }
}
