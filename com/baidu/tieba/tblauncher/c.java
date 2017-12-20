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
    private ImageView bfN;
    private FragmentTabHost bhp;
    private e cJa;
    private d cXB;
    private ImageView cti;
    private boolean eGm;
    private TextView ear;
    private MainTabActivity gGC;
    private ImageView gGD;
    private ImageView gGE;
    private TextView gGF;
    private PopupWindow gGH;
    private Runnable gGK;
    private NavigationBar mNavigationBar;
    private boolean gGG = false;
    private int eGi = -1;
    private boolean gGI = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.b gGJ = new FragmentTabHost.b() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public void e(int i, boolean z) {
            if (c.this.bhp.cB(i).mType == 8) {
                TiebaStatic.log(new ak("c10605"));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public boolean f(int i, boolean z) {
            FragmentTabHost.c cB = c.this.bhp.cB(i);
            if (cB.mType == 9) {
                if (ax.aS(c.this.gGC.getPageContext().getPageActivity())) {
                    c.this.gGC.apz();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (cB.mType == 8 && !ax.aS(c.this.gGC.getActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                return true;
            }
        }
    };
    private Runnable fgS = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bhp != null && c.this.gGH != null) {
                FragmentTabWidget fragmentTabWidget = c.this.bhp.getFragmentTabWidget();
                int ac = l.ac(c.this.gGC.getActivity());
                int f = l.f(c.this.gGC.getActivity(), d.e.ds200);
                View contentView = c.this.gGH.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    g.showPopupWindowAsDropDown(c.this.gGH, fragmentTabWidget, (ac - contentView.getMeasuredWidth()) / 2, -f);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_new_write_tips", true);
                    c.this.gGI = true;
                    c.this.mHandler.postDelayed(c.this.fgT, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fgT = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.aXp();
        }
    };
    private View.OnClickListener fgU = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.byQ();
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.gGC = mainTabActivity;
    }

    public void nl(boolean z) {
        this.bhp = (FragmentTabHost) this.gGC.findViewById(d.g.tab_host);
        this.bhp.setup(this.gGC.getSupportFragmentManager());
        this.bhp.setOnTabSelectionListener(this.gGJ);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bhp.setShouldDrawIndicatorLine(false);
            this.bhp.setShouldDrawTopLine(true);
        }
        this.bhp.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bhp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.c.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.bhp.getCurrentTabType() != 2) {
                    if (c.this.bhp.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                c.this.byO();
                if (c.this.bhp.getCurrentTabType() != c.this.bhp.cB(i).mType) {
                    c.this.bhp.setCurrentTab(i);
                }
                if (c.this.bhp.getCurrentTabType() != 1) {
                    c.this.cti.setVisibility(8);
                    c.this.bfN.setVisibility(0);
                }
                c.this.eGi = c.this.bhp.getCurrentTabType();
                c.this.byM();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (c.this.bhp.getCurrentTabType() != 3) {
                        if (c.this.bhp.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (c.this.bhp.getCurrentTabType() == 3) {
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
        this.gGG = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        ana();
        this.gGF = (TextView) this.gGC.findViewById(d.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.gGC.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void tx(final String str) {
        if (StringUtils.isNull(str)) {
            this.gGF.setVisibility(8);
            return;
        }
        FragmentTabHost.c cC = this.bhp.cC(8);
        if (cC != null) {
            if (!this.gGI || (this.gGH != null && this.gGH.isShowing())) {
                if (this.gGK == null) {
                    this.gGK = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.9
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.tx(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.gGK);
                TbadkCoreApplication.getInst().handler.postDelayed(this.gGK, TbConfig.NOTIFY_SOUND_INTERVAL);
                return;
            }
            a(str, cC);
            return;
        }
        this.gGF.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.c cVar) {
        int[] iArr = new int[2];
        cVar.aeC.getLocationInWindow(iArr);
        int width = l.o(this.gGC).widthPixels - (iArr[0] + (cVar.aeC.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gGF.getLayoutParams();
        layoutParams.rightMargin = width - l.f(this.gGC.getPageContext().getPageActivity(), d.e.ds26);
        this.gGF.setLayoutParams(layoutParams);
        this.gGF.setVisibility(0);
        this.gGF.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void byK() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.gGG);
    }

    public boolean byL() {
        return this.gGD != null && this.gGD.getVisibility() == 0;
    }

    public void nm(boolean z) {
        if (this.gGD != null) {
            if (z) {
                this.gGD.setVisibility(0);
            } else {
                this.gGD.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bhp.setShouldDrawTopLine(false);
            } else {
                this.bhp.ax(true);
            }
        }
        if (this.bhp.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bhp.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bhp.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.gGC.getPageContext(), i);
        aj.a(this.ear, d.C0096d.cp_cont_b, d.C0096d.s_navbar_title_color, i);
        aj.c(this.gGE, d.f.icon_news_down_bar_one);
        aj.a(this.gGD, d.f.icon_game_bg_s, d.f.icon_game_bg);
        aj.a(this.bfN, d.f.icon_search_bg_s, d.f.icon_search_bg);
        aj.a(this.cti, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.gGC.getPageContext().getPageActivity()).inflate(d.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            aj.c(textView, d.C0096d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.CA())) {
                textView.setText(payMemberInfoData.CA());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                aj.c(tbImageView, d.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gGC.getPageContext().getPageActivity());
            aVar.v(inflate);
            aVar.ce(d.C0096d.cp_link_tip_d);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.tblauncher.c.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(c.this.gGC.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(c.this.gGC.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.gGC.getPageContext().getString(d.j.member_continue_pay);
            if (i == 0) {
                string = this.gGC.getPageContext().getString(d.j.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.c.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(c.this.gGC.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(c.this.gGC.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.gGC.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.ap(false);
            aVar.b(this.gGC.getPageContext()).th();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void byM() {
        FragmentTabHost.c cC;
        if (this.bhp != null && (cC = this.bhp.cC(this.bhp.getCurrentTabType())) != null && cC.aeE != null && cC.aeE.Fa() != null) {
            String string = this.gGC.getPageContext().getString(cC.aeE.Fa().aHH);
            if (this.ear != null) {
                this.ear.setText(string);
            }
        }
    }

    public void ana() {
        this.mNavigationBar = (NavigationBar) this.gGC.findViewById(d.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.ear = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.gGC.getResources().getDimension(d.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.ear.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.game_tip_view, (View.OnClickListener) null);
            this.gGD = (ImageView) addCustomView.findViewById(d.g.game_button_iv);
            this.gGE = (ImageView) addCustomView.findViewById(d.g.game_tip_msg_iv);
            this.gGD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.np(false);
                    c.this.gGE.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, c.this.gGC.getPageContext()));
                    TiebaStatic.eventStat(c.this.gGC.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.f(this.gGC.getPageContext().getPageActivity(), d.e.ds16), 0);
            this.bfN = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.bfN.setLayoutParams(layoutParams2);
            this.bfN.setVisibility(8);
            this.bfN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    c.this.gGC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(c.this.gGC.getPageContext().getPageActivity())));
                    if (c.this.bhp.getCurrentTabType() != 3) {
                        if (c.this.bhp.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new ak("c10378").r("obj_type", i));
                }
            });
            this.cti = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.cti.setLayoutParams(layoutParams2);
            this.cti.setVisibility(8);
            this.cti.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        c.this.gGC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.gGC.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.gGC.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aR(c.this.gGC.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.gGC.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (c.this.eGi) {
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
                    ax.aQ(c.this.gGC.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void nn(boolean z) {
        if (z) {
            this.cti.setVisibility(0);
            this.bfN.setVisibility(8);
            return;
        }
        this.cti.setVisibility(8);
        this.bfN.setVisibility(0);
    }

    public void no(boolean z) {
        if (byL()) {
            if (z) {
                if (this.gGE.getVisibility() != 0) {
                    this.gGE.setVisibility(0);
                    np(true);
                    aj.c(this.gGE, d.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            np(false);
            this.gGE.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void np(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gGD.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.f(this.gGC.getPageContext().getPageActivity(), d.e.ds32);
            } else {
                layoutParams.rightMargin = l.f(this.gGC.getPageContext().getPageActivity(), d.e.ds20);
            }
            this.gGD.setLayoutParams(layoutParams);
        }
    }

    public void ae(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bhp.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Fa(), next.ba(this.gGC.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.bhp.cz(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bhp.cz(1);
        } else {
            this.bhp.cz(0);
        }
        this.bhp.setViewPagerScrollable(false);
    }

    public void iw(boolean z) {
        this.eGm = z;
        if (!this.eGm) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aOD() {
        return this.eGm;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, com.baidu.tbadk.mainTab.e eVar) {
        if (cVar != null && (eVar instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) eVar;
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aeD = cVar.aHG;
            cVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.aHO);
            if (cVar.aHO == com.baidu.tbadk.mainTab.c.aHL) {
                maintabBottomIndicator.L(cVar.aHI, cVar.aHJ);
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.aHI);
                maintabBottomIndicator.setText(cVar.aHH);
                maintabBottomIndicator.setAnimationResId(cVar.aHK);
            }
            eVar.dE(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            cVar2.aeC = maintabBottomIndicator;
            cVar2.aeE = bVar;
            this.bhp.a(cVar2);
        }
    }

    public FragmentTabHost byN() {
        return this.bhp;
    }

    public void byO() {
        if (this.bhp != null) {
            if ((this.bhp.getCurrentTabType() == 8 || this.bhp.getCurrentTabType() == 3 || this.bhp.getCurrentTabType() == 2 || this.bhp.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.bhp.getCurrentTabType() != 1) {
                if (this.cti != null) {
                    this.cti.setVisibility(8);
                }
                if (this.bfN != null && this.bhp.getCurrentTabType() != 3) {
                    this.bfN.setVisibility(0);
                }
            }
        }
    }

    public void byP() {
        if (!this.gGI) {
            this.gGI = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_last_new_write_tips", false);
            if (!this.gGI) {
                View inflate = LayoutInflater.from(this.gGC.getActivity()).inflate(d.h.tips_blue_center_down, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                textView.setText(d.j.maintab_write_tips);
                textView.setOnClickListener(this.fgU);
                this.gGH = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.fgS, 100L);
            }
        }
    }

    public void byQ() {
        this.mHandler.removeCallbacks(this.fgS);
        this.mHandler.removeCallbacks(this.fgT);
        aXp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXp() {
        g.a(this.gGH);
    }

    public void ty(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gGC.getActivity());
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
                com.baidu.tieba.h.a.atf();
            }
        });
        aVar.b(this.gGC.getPageContext()).th();
    }

    public void onDestroy() {
        byK();
        if (byN() != null) {
            byN().reset();
        }
        byQ();
        if (this.cXB != null) {
            this.cXB.onDestroy();
        }
        if (this.cJa != null) {
            this.cJa.anc();
        }
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.cXB == null) {
            this.cXB = new com.baidu.tieba.d.d(this.gGC.getPageContext(), (NavigationBarCoverTip) this.gGC.findViewById(d.g.navigation_cover_tip));
        }
        this.cXB.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.cJa == null) {
                this.cJa = new e(this.gGC, this.gGC.oV());
            }
            this.cJa.g(postWriteCallBackData);
        }
    }
}
