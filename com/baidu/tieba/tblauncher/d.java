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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
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
import com.baidu.tieba.c.f;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class d {
    private f fMY;
    private ImageView fbD;
    private com.baidu.tieba.video.f fwX;
    private boolean hyJ;
    private MainTabActivity jnU;
    private TextView jnY;
    private ImageView jnZ;
    private ImageView joa;
    private TextView job;
    private PopupWindow jod;
    private MaintabBottomIndicator jof;
    private MaintabBottomIndicator jog;
    private Runnable jon;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean joc = false;
    private int hyF = -1;
    private boolean joe = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean joh = true;
    private int joi = 1;
    private boolean joj = false;
    private FragmentTabHost.a jok = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b il = d.this.mTabHost.il(i);
            if (il.mType == 8) {
                if (d.this.jof != null && d.this.jof.getAnimationView() != null && d.this.jof.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new an("c10605").O("obj_type", 1));
                } else {
                    TiebaStatic.log(new an("c10605").O("obj_type", 0));
                }
                if (d.this.jof != null) {
                    d.this.jof.ass();
                }
            } else if (il.mType == 3) {
                TiebaStatic.log(new an(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).O("obj_locate", 1));
                TiebaStatic.log(new an(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).O("obj_locate", 1));
            }
            if (il.mType == 2) {
                if (d.this.joh) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.joh = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.joi != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.joi == 1) {
                        d.this.jog.fo(d.this.joh);
                    }
                } else {
                    d.this.jog.avE();
                }
                d.this.joj = false;
            } else {
                d.this.joj = true;
                d.this.joh = false;
                d.this.jog.fo(d.this.joh);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b il = d.this.mTabHost.il(i);
            if (il.mType == 9) {
                if (bc.checkUpIsLogin(d.this.jnU.getPageContext().getPageActivity())) {
                    d.this.jnU.blu();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (il.mType == 8 && !bc.checkUpIsLogin(d.this.jnU.getActivity())) {
                if (d.this.jof != null) {
                    d.this.jof.ass();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (il.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ba.amO().a(d.this.jnU.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (il.mType == 3 && !bc.checkUpIsLogin(d.this.jnU.getActivity())) {
                    return false;
                } else {
                    if (il.mType == 1) {
                        TiebaStatic.log(new an("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener jol = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.cqx() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.joj = true;
                        d.this.joh = true;
                        if (d.this.joi != 2) {
                            if (d.this.jog.isAnimating()) {
                                d.this.jog.fo(d.this.joh);
                                return;
                            }
                            return;
                        }
                        d.this.cqx().avG();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.joj = false;
                        if (d.this.joi == 1) {
                            return;
                        }
                    } else {
                        d.this.joi = intValue;
                    }
                    if (d.this.joi == 1) {
                        d.this.cqx().fo(d.this.joh);
                    } else if (d.this.joi == 2) {
                        d.this.cqx().avE();
                    } else if (intValue == 5) {
                        d.this.joi = 1;
                        d.this.joh = true;
                        if (!d.this.joj) {
                            d.this.cqx().avG();
                        }
                    } else {
                        d.this.cqx().avF();
                    }
                }
            }
        }
    };
    private CustomMessageListener jom = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.joh = true;
        }
    };
    private Runnable fTy = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.jod != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.jnU.getActivity());
                int dimens = l.getDimens(d.this.jnU.getActivity(), R.dimen.ds178);
                View contentView = d.this.jod.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b im = d.this.mTabHost.im(3);
                    if (im != null && (tbFragmentTabIndicator = im.chu) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.jnU.getActivity(), R.dimen.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.jod, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.joe = true;
                        d.this.mHandler.postDelayed(d.this.fTz, 5000L);
                    }
                }
            }
        }
    };
    private Runnable fTz = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            d.this.cqz();
        }
    };
    private View.OnClickListener fTA = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.cqz();
        }
    };

    public d(MainTabActivity mainTabActivity) {
        this.jnU = mainTabActivity;
    }

    public void qZ(boolean z) {
        this.mTabHost = (FragmentTabHost) this.jnU.findViewById(R.id.tab_host);
        this.mTabHost.setUIType(1);
        this.mTabHost.setup(this.jnU.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.jok);
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
                d.this.cqy();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.il(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.fbD.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                d.this.hyF = d.this.mTabHost.getCurrentTabType();
                d.this.cqv();
                if (com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (d.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).bS("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.joc = com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        aJv();
        this.job = (TextView) this.jnU.findViewById(R.id.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.jnU.getPageContext()));
        switchNaviBarStatus(z);
        this.jnU.registerListener(this.jol);
        this.jnU.registerListener(this.jom);
    }

    public void Em(final String str) {
        if (StringUtils.isNull(str)) {
            this.job.setVisibility(8);
            return;
        }
        FragmentTabHost.b im = this.mTabHost.im(8);
        if (im != null) {
            if (!this.joe || (this.jod != null && this.jod.isShowing())) {
                if (this.jon == null) {
                    this.jon = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.13
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.Em(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.jon);
                TbadkCoreApplication.getInst().handler.postDelayed(this.jon, 5000L);
                return;
            }
            a(str, im);
            return;
        }
        this.job.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.chu.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.jnU).widthPixels - (iArr[0] + (bVar.chu.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.job.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.jnU.getPageContext().getPageActivity(), R.dimen.ds26);
        this.job.setLayoutParams(layoutParams);
        this.job.setVisibility(0);
        this.job.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void cqt() {
        com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.joc);
    }

    public boolean cqu() {
        return this.jnZ != null && this.jnZ.getVisibility() == 0;
    }

    public void ra(boolean z) {
        if (this.jnZ != null) {
            if (z) {
                this.jnZ.setVisibility(0);
            } else {
                this.jnZ.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.jnU.getPageContext(), i);
        am.setNavbarTitleColor(this.jnY, R.color.cp_cont_b, R.color.s_navbar_title_color, i);
        am.setImageResource(this.joa, R.drawable.icon_news_down_bar_one);
        am.setNavbarIconSrc(this.jnZ, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        SvgManager.amL().a(this.mSearchButton, R.drawable.icon_pure_topbar_search_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.amL().a(this.fbD, R.drawable.icon_pure_topbar_sign_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
            } else {
                this.mTabHost.showTabWidget();
            }
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.jnU.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            am.setViewTextColor(textView, R.color.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.atv())) {
                textView.setText(payMemberInfoData.atv());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                am.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jnU.getPageContext().getPageActivity());
            aVar.aM(inflate);
            aVar.hU(R.color.cp_link_tip_d);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.jnU.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.jnU.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.jnU.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.jnU.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.jnU.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.jnU.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.jnU.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.eh(false);
            aVar.b(this.jnU.getPageContext()).akM();
            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void cqv() {
        FragmentTabHost.b im;
        if (this.mTabHost != null && (im = this.mTabHost.im(this.mTabHost.getCurrentTabType())) != null && im.chv != null && im.chv.avx() != null) {
            String string = this.jnU.getPageContext().getString(im.chv.avx().textResId);
            if (this.jnY != null) {
                this.jnY.setText(string);
            }
        }
    }

    public void aJv() {
        this.mNavigationBar = (NavigationBar) this.jnU.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.jnY = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.jnU.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.jnY.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.jnZ = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.joa = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.jnZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.rd(false);
                    d.this.joa.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.jnU.getPageContext()));
                    TiebaStatic.eventStat(d.this.jnU.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.jnU.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.jnU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.jnU.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new an(CommonStatisticKey.SEARCH_BAR_CLICK).O("obj_type", i));
                }
            });
            this.fbD = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.fbD.setLayoutParams(layoutParams2);
            this.fbD.setVisibility(8);
            this.fbD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.jnU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.jnU.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.jnU.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bc.skipToLoginActivity(d.this.jnU.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.jnU.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.hyF) {
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
                    TiebaStatic.log(new an("c10517").bS("obj_source", str));
                    bc.skipToRegisterActivity(d.this.jnU.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void rb(boolean z) {
        if (z) {
            this.fbD.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.fbD.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void rc(boolean z) {
        if (cqu()) {
            if (z) {
                if (this.joa.getVisibility() != 0) {
                    this.joa.setVisibility(0);
                    rd(true);
                    am.setImageResource(this.joa, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            rd(false);
            this.joa.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rd(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jnZ.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.jnU.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.jnU.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.jnZ.setLayoutParams(layoutParams);
        }
    }

    public void au(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.avx(), next.cB(this.jnU.getPageContext().getPageActivity()));
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

    public void nq(boolean z) {
        this.hyJ = z;
        if (!this.hyJ) {
            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean bNt() {
        return this.hyJ;
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
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.cJr) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.jof = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (bVar2.mType == 2) {
                this.jog = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.chu = maintabBottomIndicator;
            bVar2.chv = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost blw() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator cqw() {
        return this.jof;
    }

    public MaintabBottomIndicator cqx() {
        return this.jog;
    }

    public void cqy() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void cqz() {
        this.mHandler.removeCallbacks(this.fTy);
        this.mHandler.removeCallbacks(this.fTz);
        g.dismissPopupWindow(this.jod);
    }

    public void En(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jnU.getActivity());
        aVar.nn(str);
        aVar.a(R.string.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                an anVar = new an("c12137");
                anVar.bS("obj_locate", "1");
                TiebaStatic.log(anVar);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                an anVar = new an("c12137");
                anVar.bS("obj_locate", "2");
                TiebaStatic.log(anVar);
                aVar2.dismiss();
                com.baidu.tieba.i.a.bsz();
            }
        });
        aVar.b(this.jnU.getPageContext()).akM();
    }

    public void onDestroy() {
        cqt();
        if (blw() != null) {
            blw().reset();
        }
        cqz();
        if (this.fMY != null) {
            this.fMY.onDestroy();
        }
        if (this.fwX != null) {
            this.fwX.bmt();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.jnU).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fMY == null) {
            this.fMY = new f(this.jnU.getPageContext(), (NavigationBarCoverTip) this.jnU.findViewById(R.id.navigation_cover_tip));
        }
        this.fMY.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.fwX == null) {
                this.fwX = new com.baidu.tieba.video.f(this.jnU, this.jnU.getActivityRootView());
            }
            this.fwX.h(postWriteCallBackData);
        }
    }

    public void cqA() {
        this.joi = 1;
    }
}
