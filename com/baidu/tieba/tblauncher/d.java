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
    private ImageView gBH;
    private f haV;
    private g hrf;
    private boolean jej;
    private MainTabActivity kYL;
    private TextView kYP;
    private ImageView kYQ;
    private ImageView kYR;
    private TextView kYS;
    private ImageView kYT;
    private TextView kYU;
    private PopupWindow kYW;
    private MaintabBottomIndicator kYY;
    private MaintabBottomIndicator kYZ;
    private Runnable kZf;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean kYV = false;
    private int jef = -1;
    private boolean kYX = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean ebL = true;
    private int kZa = 1;
    private boolean isInterrupt = false;
    private boolean kZb = false;
    private FragmentTabHost.a kZc = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b kv = d.this.mTabHost.kv(i);
            if (kv.mType == 8) {
                if (d.this.kYY != null && d.this.kYY.getAnimationView() != null && d.this.kYY.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new an("c10605").af("obj_type", 1));
                } else {
                    TiebaStatic.log(new an("c10605").af("obj_type", 0));
                }
                if (d.this.kYY != null) {
                    d.this.kYY.aVi();
                }
            } else if (kv.mType == 3) {
                TiebaStatic.log(new an(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).af("obj_locate", 1));
                TiebaStatic.log(new an(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).af("obj_locate", 1));
            }
            if (kv.mType == 2) {
                if (d.this.ebL) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.ebL = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.kZa != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.kZa == 1) {
                        d.this.kYZ.hK(d.this.ebL);
                    }
                } else {
                    d.this.kYZ.aYv();
                }
                d.this.isInterrupt = false;
            } else {
                d.this.isInterrupt = true;
                if (d.this.ebL) {
                    d.this.kYZ.hK(d.this.ebL);
                }
                d.this.ebL = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.cYv() != null) {
                d.this.cYv().ebL = d.this.ebL;
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
                if (bc.checkUpIsLogin(d.this.kYL.getPageContext().getPageActivity())) {
                    d.this.kYL.bQj();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (kv.mType == 8 && !bc.checkUpIsLogin(d.this.kYL.getActivity())) {
                if (d.this.kYY != null) {
                    d.this.kYY.aVi();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (kv.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ba.aOV().a(d.this.kYL.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (kv.mType == 3 && !bc.checkUpIsLogin(d.this.kYL.getActivity())) {
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
    private CustomMessageListener kZd = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.cYv() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.isInterrupt = true;
                        d.this.ebL = true;
                        if (d.this.kZa != 2) {
                            if (d.this.kYZ.isAnimating()) {
                                d.this.kYZ.hK(d.this.ebL);
                                return;
                            }
                            return;
                        }
                        d.this.cYv().aYx();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.isInterrupt = false;
                        if (d.this.kZa == 1) {
                            return;
                        }
                    } else {
                        d.this.kZa = intValue;
                    }
                    if (d.this.kZa == 1) {
                        d.this.cYv().hK(d.this.ebL);
                    } else if (d.this.kZa == 2) {
                        d.this.cYv().aYv();
                    } else if (intValue == 5) {
                        d.this.kZa = 1;
                        d.this.ebL = true;
                        if (!d.this.isInterrupt) {
                            d.this.cYv().aYx();
                        }
                    } else {
                        d.this.cYv().aYw();
                    }
                    d.this.cYv().ebK = true;
                    d.this.cYv().ebM = d.this.kZa;
                    d.this.cYv().ebL = d.this.ebL;
                }
            }
        }
    };
    private CustomMessageListener kZe = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.ebL = true;
            if (d.this.cYv() != null) {
                d.this.cYv().ebL = d.this.ebL;
            }
        }
    };
    private Runnable hyJ = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.kYW != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.kYL.getActivity());
                int dimens = l.getDimens(d.this.kYL.getActivity(), R.dimen.ds178);
                View contentView = d.this.kYW.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b kw = d.this.mTabHost.kw(3);
                    if (kw != null && (tbFragmentTabIndicator = kw.dxJ) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.kYL.getActivity(), R.dimen.tbds570);
                        }
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(d.this.kYW, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.kYX = true;
                        d.this.mHandler.postDelayed(d.this.hyK, 5000L);
                    }
                }
            }
        }
    };
    private Runnable hyK = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            d.this.cYx();
        }
    };
    private View.OnClickListener hyL = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.cYx();
        }
    };

    public d(MainTabActivity mainTabActivity) {
        this.kYL = mainTabActivity;
    }

    public void ue(boolean z) {
        this.mTabHost = (FragmentTabHost) this.kYL.findViewById(R.id.tab_host);
        this.mTabHost.setUIType(1);
        this.mTabHost.setup(this.kYL.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setTabContainerShadowShow(false);
        this.mTabHost.setBackGroundStyle(1);
        this.mTabHost.setOnTabSelectionListener(this.kZc);
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
                d.this.cYw();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.kv(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.gBH.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                d.this.jef = d.this.mTabHost.getCurrentTabType();
                d.this.cYt();
                if (com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
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
        this.kYV = com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        blD();
        this.kYT = (ImageView) this.kYL.findViewById(R.id.home_page_new_write_icon);
        this.kYU = (TextView) this.kYL.findViewById(R.id.view_bottom_text);
        this.kYS = (TextView) this.kYL.findViewById(R.id.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.kYL.getPageContext()));
        switchNaviBarStatus(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.kYL.registerListener(this.kZd);
        }
        this.kYL.registerListener(this.kZe);
    }

    public void Ll(final String str) {
        if (StringUtils.isNull(str)) {
            this.kYS.setVisibility(8);
            return;
        }
        FragmentTabHost.b kw = this.mTabHost.kw(8);
        if (kw != null) {
            if (!this.kYX || (this.kYW != null && this.kYW.isShowing())) {
                if (this.kZf == null) {
                    this.kZf = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.13
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.Ll(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.kZf);
                TbadkCoreApplication.getInst().handler.postDelayed(this.kZf, 5000L);
                return;
            }
            a(str, kw);
            return;
        }
        this.kYS.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.dxJ.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.kYL).widthPixels - (iArr[0] + (bVar.dxJ.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kYS.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.kYL.getPageContext().getPageActivity(), R.dimen.ds26);
        this.kYS.setLayoutParams(layoutParams);
        this.kYS.setVisibility(0);
        this.kYS.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void cYp() {
        com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.kYV);
    }

    public boolean cYq() {
        return this.kYQ != null && this.kYQ.getVisibility() == 0;
    }

    public void uf(boolean z) {
        if (this.kYQ != null) {
            if (z) {
                this.kYQ.setVisibility(0);
            } else {
                this.kYQ.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.kYL.getPageContext(), i);
        am.setNavbarTitleColor(this.kYP, R.color.cp_cont_b, R.color.s_navbar_title_color, i);
        am.setImageResource(this.kYR, R.drawable.icon_news_down_bar_one);
        am.setNavbarIconSrc(this.kYQ, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        am.setViewTextColor(this.kYU, (int) R.color.cp_cont_f);
        SvgManager.aOR().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aOR().a(this.gBH, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
                cYs();
                return;
            }
            this.mTabHost.showTabWidget();
            cYr();
        }
    }

    public void cYr() {
        if (this.kYT != null) {
            this.kYT.setVisibility(0);
        }
        if (this.kYU != null) {
            this.kYU.setVisibility(0);
        }
    }

    public void cYs() {
        if (this.kYT != null) {
            this.kYT.setVisibility(8);
        }
        if (this.kYU != null) {
            this.kYU.setVisibility(8);
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.kYL.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            am.setViewTextColor(textView, R.color.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.aWm())) {
                textView.setText(payMemberInfoData.aWm());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                am.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kYL.getPageContext().getPageActivity());
            aVar.aP(inflate);
            aVar.ke(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.kYL.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.kYL.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.kYL.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.kYL.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.kYL.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.kYL.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.kYL.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.gF(false);
            aVar.b(this.kYL.getPageContext()).aMS();
            com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void cYt() {
        FragmentTabHost.b kw;
        if (this.mTabHost != null && (kw = this.mTabHost.kw(this.mTabHost.getCurrentTabType())) != null && kw.dxK != null && kw.dxK.getFragmentTabStructure() != null) {
            String string = this.kYL.getPageContext().getString(kw.dxK.getFragmentTabStructure().textResId);
            if (this.kYP != null) {
                this.kYP.setText(string);
            }
        }
    }

    public void blD() {
        this.mNavigationBar = (NavigationBar) this.kYL.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.kYP = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.kYL.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.kYP.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.kYQ = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.kYR = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.kYQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.ui(false);
                    d.this.kYR.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.kYL.getPageContext()));
                    TiebaStatic.eventStat(d.this.kYL.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.kYL.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.kYL.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.kYL.getPageContext().getPageActivity())));
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
            this.gBH = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.gBH.setLayoutParams(layoutParams2);
            this.gBH.setVisibility(8);
            this.gBH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.kYL.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.kYL.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.kYL.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bc.skipToLoginActivity(d.this.kYL.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.kYL.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.jef) {
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
                    bc.skipToRegisterActivity(d.this.kYL.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void ug(boolean z) {
        if (z) {
            this.gBH.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.gBH.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void uh(boolean z) {
        if (cYq()) {
            if (z) {
                if (this.kYR.getVisibility() != 0) {
                    this.kYR.setVisibility(0);
                    ui(true);
                    am.setImageResource(this.kYR, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            ui(false);
            this.kYR.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kYQ.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.kYL.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.kYL.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.kYQ.setLayoutParams(layoutParams);
        }
    }

    public void aH(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.kYL.getPageContext().getPageActivity()));
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
        this.jej = z;
        if (!this.jej) {
            com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean cst() {
        return this.jej;
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
                cYr();
                this.kZb = true;
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.ebD) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.kYY = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (bVar2.mType == 2) {
                this.kYZ = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.dxJ = maintabBottomIndicator;
            bVar2.dxK = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost bQl() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator cYu() {
        return this.kYY;
    }

    public MaintabBottomIndicator cYv() {
        return this.kYZ;
    }

    public void cYw() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void cYx() {
        this.mHandler.removeCallbacks(this.hyJ);
        this.mHandler.removeCallbacks(this.hyK);
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.kYW);
    }

    public void Lm(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kYL.getActivity());
        aVar.ui(str);
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
                com.baidu.tieba.j.a.bXs();
            }
        });
        aVar.b(this.kYL.getPageContext()).aMS();
    }

    public void onDestroy() {
        cYp();
        if (bQl() != null) {
            bQl().reset();
        }
        cYx();
        if (this.hrf != null) {
            this.hrf.onDestroy();
        }
        if (this.haV != null) {
            this.haV.bRh();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.kYL).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.hrf == null) {
            this.hrf = new g(this.kYL.getPageContext(), (NavigationBarCoverTip) this.kYL.findViewById(R.id.navigation_cover_tip));
        }
        this.hrf.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.haV == null) {
                this.haV = new f(this.kYL, this.kYL.getActivityRootView());
            }
            this.haV.h(postWriteCallBackData);
        }
    }

    public void cYy() {
        this.isInterrupt = false;
        this.kZa = 1;
        if (cYv() != null) {
            cYv().ebM = this.kZa;
        }
    }
}
