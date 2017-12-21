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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.d.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.e;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private ImageView bfR;
    private FragmentTabHost bht;
    private e cJe;
    private d cXF;
    private ImageView ctm;
    private boolean eGq;
    private TextView eav;
    private MainTabActivity gGH;
    private ImageView gGI;
    private ImageView gGJ;
    private TextView gGK;
    private PopupWindow gGM;
    private Runnable gGP;
    private NavigationBar mNavigationBar;
    private boolean gGL = false;
    private int eGm = -1;
    private boolean gGN = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.b gGO = new FragmentTabHost.b() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public void e(int i, boolean z) {
            if (c.this.bht.cB(i).mType == 8) {
                TiebaStatic.log(new ak("c10605"));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public boolean f(int i, boolean z) {
            FragmentTabHost.c cB = c.this.bht.cB(i);
            if (cB.mType == 9) {
                if (ax.aS(c.this.gGH.getPageContext().getPageActivity())) {
                    c.this.gGH.apA();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (cB.mType == 8 && !ax.aS(c.this.gGH.getActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                return true;
            }
        }
    };
    private Runnable fgX = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bht != null && c.this.gGM != null) {
                FragmentTabWidget fragmentTabWidget = c.this.bht.getFragmentTabWidget();
                int ac = l.ac(c.this.gGH.getActivity());
                int f = l.f(c.this.gGH.getActivity(), d.e.ds200);
                View contentView = c.this.gGM.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    g.showPopupWindowAsDropDown(c.this.gGM, fragmentTabWidget, (ac - contentView.getMeasuredWidth()) / 2, -f);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_new_write_tips", true);
                    c.this.gGN = true;
                    c.this.mHandler.postDelayed(c.this.fgY, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fgY = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.aXq();
        }
    };
    private View.OnClickListener fgZ = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.byR();
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.gGH = mainTabActivity;
    }

    public void nl(boolean z) {
        this.bht = (FragmentTabHost) this.gGH.findViewById(d.g.tab_host);
        this.bht.setup(this.gGH.getSupportFragmentManager());
        this.bht.setOnTabSelectionListener(this.gGO);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bht.setShouldDrawIndicatorLine(false);
            this.bht.setShouldDrawTopLine(true);
        }
        this.bht.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bht.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.c.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.bht.getCurrentTabType() != 2) {
                    if (c.this.bht.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                c.this.byP();
                if (c.this.bht.getCurrentTabType() != c.this.bht.cB(i).mType) {
                    c.this.bht.setCurrentTab(i);
                }
                if (c.this.bht.getCurrentTabType() != 1) {
                    c.this.ctm.setVisibility(8);
                    c.this.bfR.setVisibility(0);
                }
                c.this.eGm = c.this.bht.getCurrentTabType();
                c.this.byN();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (c.this.bht.getCurrentTabType() != 3) {
                        if (c.this.bht.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (c.this.bht.getCurrentTabType() == 3) {
                    TiebaStatic.log(new ak("view_msg").ac("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.gGL = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        anb();
        this.gGK = (TextView) this.gGH.findViewById(d.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.gGH.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void tx(final String str) {
        if (StringUtils.isNull(str)) {
            this.gGK.setVisibility(8);
            return;
        }
        FragmentTabHost.c cC = this.bht.cC(8);
        if (cC != null) {
            if (!this.gGN || (this.gGM != null && this.gGM.isShowing())) {
                if (this.gGP == null) {
                    this.gGP = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.9
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.tx(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.gGP);
                TbadkCoreApplication.getInst().handler.postDelayed(this.gGP, TbConfig.NOTIFY_SOUND_INTERVAL);
                return;
            }
            a(str, cC);
            return;
        }
        this.gGK.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.c cVar) {
        int[] iArr = new int[2];
        cVar.aeF.getLocationInWindow(iArr);
        int width = l.o(this.gGH).widthPixels - (iArr[0] + (cVar.aeF.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gGK.getLayoutParams();
        layoutParams.rightMargin = width - l.f(this.gGH.getPageContext().getPageActivity(), d.e.ds26);
        this.gGK.setLayoutParams(layoutParams);
        this.gGK.setVisibility(0);
        this.gGK.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void byL() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.gGL);
    }

    public boolean byM() {
        return this.gGI != null && this.gGI.getVisibility() == 0;
    }

    public void nm(boolean z) {
        if (this.gGI != null) {
            if (z) {
                this.gGI.setVisibility(0);
            } else {
                this.gGI.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bht.setShouldDrawTopLine(false);
            } else {
                this.bht.ax(true);
            }
        }
        if (this.bht.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bht.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bht.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.gGH.getPageContext(), i);
        aj.a(this.eav, d.C0095d.cp_cont_b, d.C0095d.s_navbar_title_color, i);
        aj.c(this.gGJ, d.f.icon_news_down_bar_one);
        aj.a(this.gGI, d.f.icon_game_bg_s, d.f.icon_game_bg);
        aj.a(this.bfR, d.f.icon_search_bg_s, d.f.icon_search_bg);
        aj.a(this.ctm, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.gGH.getPageContext().getPageActivity()).inflate(d.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            aj.c(textView, d.C0095d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.CA())) {
                textView.setText(payMemberInfoData.CA());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                aj.c(tbImageView, d.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gGH.getPageContext().getPageActivity());
            aVar.v(inflate);
            aVar.ce(d.C0095d.cp_link_tip_d);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.tblauncher.c.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(c.this.gGH.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(c.this.gGH.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.gGH.getPageContext().getString(d.j.member_continue_pay);
            if (i == 0) {
                string = this.gGH.getPageContext().getString(d.j.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.c.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(c.this.gGH.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(c.this.gGH.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.gGH.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.ap(false);
            aVar.b(this.gGH.getPageContext()).th();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void byN() {
        FragmentTabHost.c cC;
        if (this.bht != null && (cC = this.bht.cC(this.bht.getCurrentTabType())) != null && cC.aeH != null && cC.aeH.Fa() != null) {
            String string = this.gGH.getPageContext().getString(cC.aeH.Fa().aHK);
            if (this.eav != null) {
                this.eav.setText(string);
            }
        }
    }

    public void anb() {
        this.mNavigationBar = (NavigationBar) this.gGH.findViewById(d.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.eav = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.gGH.getResources().getDimension(d.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.eav.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.game_tip_view, (View.OnClickListener) null);
            this.gGI = (ImageView) addCustomView.findViewById(d.g.game_button_iv);
            this.gGJ = (ImageView) addCustomView.findViewById(d.g.game_tip_msg_iv);
            this.gGI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.np(false);
                    c.this.gGJ.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, c.this.gGH.getPageContext()));
                    TiebaStatic.eventStat(c.this.gGH.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.f(this.gGH.getPageContext().getPageActivity(), d.e.ds16), 0);
            this.bfR = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.bfR.setLayoutParams(layoutParams2);
            this.bfR.setVisibility(8);
            this.bfR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    c.this.gGH.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(c.this.gGH.getPageContext().getPageActivity())));
                    if (c.this.bht.getCurrentTabType() != 3) {
                        if (c.this.bht.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new ak("c10378").r("obj_type", i));
                }
            });
            this.ctm = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.ctm.setLayoutParams(layoutParams2);
            this.ctm.setVisibility(8);
            this.ctm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        c.this.gGH.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.gGH.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.gGH.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aR(c.this.gGH.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.gGH.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (c.this.eGm) {
                        case 1:
                            str = "forum";
                            break;
                        case 2:
                            str = "kantie";
                            break;
                        case 3:
                            str = PushConstants.EXTRA_PUSH_MESSAGE;
                            break;
                        case 8:
                            str = "profile";
                            break;
                    }
                    TiebaStatic.log(new ak("c10517").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
                    ax.aQ(c.this.gGH.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void nn(boolean z) {
        if (z) {
            this.ctm.setVisibility(0);
            this.bfR.setVisibility(8);
            return;
        }
        this.ctm.setVisibility(8);
        this.bfR.setVisibility(0);
    }

    public void no(boolean z) {
        if (byM()) {
            if (z) {
                if (this.gGJ.getVisibility() != 0) {
                    this.gGJ.setVisibility(0);
                    np(true);
                    aj.c(this.gGJ, d.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            np(false);
            this.gGJ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void np(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gGI.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.f(this.gGH.getPageContext().getPageActivity(), d.e.ds32);
            } else {
                layoutParams.rightMargin = l.f(this.gGH.getPageContext().getPageActivity(), d.e.ds20);
            }
            this.gGI.setLayoutParams(layoutParams);
        }
    }

    public void ae(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bht.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Fa(), next.ba(this.gGH.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.bht.cz(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bht.cz(1);
        } else {
            this.bht.cz(0);
        }
        this.bht.setViewPagerScrollable(false);
    }

    public void iw(boolean z) {
        this.eGq = z;
        if (!this.eGq) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aOE() {
        return this.eGq;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, com.baidu.tbadk.mainTab.e eVar) {
        if (cVar != null && (eVar instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) eVar;
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aeG = cVar.aHJ;
            cVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.aHR);
            if (cVar.aHR == com.baidu.tbadk.mainTab.c.aHO) {
                maintabBottomIndicator.L(cVar.aHL, cVar.aHM);
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.aHL);
                maintabBottomIndicator.setText(cVar.aHK);
                maintabBottomIndicator.setAnimationResId(cVar.aHN);
            }
            eVar.dE(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            cVar2.aeF = maintabBottomIndicator;
            cVar2.aeH = bVar;
            this.bht.a(cVar2);
        }
    }

    public FragmentTabHost byO() {
        return this.bht;
    }

    public void byP() {
        if (this.bht != null) {
            if ((this.bht.getCurrentTabType() == 8 || this.bht.getCurrentTabType() == 3 || this.bht.getCurrentTabType() == 2 || this.bht.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.bht.getCurrentTabType() != 1) {
                if (this.ctm != null) {
                    this.ctm.setVisibility(8);
                }
                if (this.bfR != null && this.bht.getCurrentTabType() != 3) {
                    this.bfR.setVisibility(0);
                }
            }
        }
    }

    public void byQ() {
        if (!this.gGN) {
            this.gGN = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_last_new_write_tips", false);
            if (!this.gGN) {
                View inflate = LayoutInflater.from(this.gGH.getActivity()).inflate(d.h.tips_blue_center_down, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                textView.setText(d.j.maintab_write_tips);
                textView.setOnClickListener(this.fgZ);
                this.gGM = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.fgX, 100L);
            }
        }
    }

    public void byR() {
        this.mHandler.removeCallbacks(this.fgX);
        this.mHandler.removeCallbacks(this.fgY);
        aXq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXq() {
        g.a(this.gGM);
    }

    public void ty(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gGH.getActivity());
        aVar.cS(str);
        aVar.a(d.j.close, new a.b() { // from class: com.baidu.tieba.tblauncher.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ak akVar = new ak("c12137");
                akVar.ac("obj_locate", "1");
                TiebaStatic.log(akVar);
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.check, new a.b() { // from class: com.baidu.tieba.tblauncher.c.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ak akVar = new ak("c12137");
                akVar.ac("obj_locate", "2");
                TiebaStatic.log(akVar);
                aVar2.dismiss();
                com.baidu.tieba.h.a.atg();
            }
        });
        aVar.b(this.gGH.getPageContext()).th();
    }

    public void onDestroy() {
        byL();
        if (byO() != null) {
            byO().reset();
        }
        byR();
        if (this.cXF != null) {
            this.cXF.onDestroy();
        }
        if (this.cJe != null) {
            this.cJe.and();
        }
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.cXF == null) {
            this.cXF = new com.baidu.tieba.d.d(this.gGH.getPageContext(), (NavigationBarCoverTip) this.gGH.findViewById(d.g.navigation_cover_tip));
        }
        this.cXF.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.cJe == null) {
                this.cJe = new e(this.gGH, this.gGH.oV());
            }
            this.cJe.g(postWriteCallBackData);
        }
    }
}
