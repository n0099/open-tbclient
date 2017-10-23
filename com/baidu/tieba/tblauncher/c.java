package com.baidu.tieba.tblauncher;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
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
import com.baidu.tbadk.mainTab.e;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private ImageView bbL;
    private FragmentTabHost bdg;
    private com.baidu.tieba.d.b cEu;
    private ImageView ccI;
    private TextView dJG;
    private boolean eqv;
    private MainTabActivity glc;
    private ImageView gld;
    private ImageView gle;
    private PopupWindow glg;
    private NavigationBar mNavigationBar;
    private boolean glf = false;
    private int eqr = -1;
    private boolean glh = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.b gli = new FragmentTabHost.b() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public void e(int i, boolean z) {
            if (c.this.bdg.cA(i).mType == 8) {
                TiebaStatic.log(new ak("c10605"));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public boolean f(int i, boolean z) {
            FragmentTabHost.c cA = c.this.bdg.cA(i);
            if (cA.mType == 9) {
                if (ax.aT(c.this.glc.getPageContext().getPageActivity())) {
                    c.this.glc.akx();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (cA.mType == 8 && !ax.aT(c.this.glc.getActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                return true;
            }
        }
    };
    private Runnable ePS = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bdg != null && c.this.glg != null) {
                FragmentTabWidget fragmentTabWidget = c.this.bdg.getFragmentTabWidget();
                int ad = l.ad(c.this.glc.getActivity());
                int f = l.f(c.this.glc.getActivity(), d.f.ds200);
                View contentView = c.this.glg.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    g.showPopupWindowAsDropDown(c.this.glg, fragmentTabWidget, (ad - contentView.getMeasuredWidth()) / 2, -f);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_new_write_tips", true);
                    c.this.glh = true;
                    c.this.mHandler.postDelayed(c.this.ePT, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable ePT = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.aSN();
        }
    };
    private View.OnClickListener ePU = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.btj();
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.glc = mainTabActivity;
    }

    public void mH(boolean z) {
        this.bdg = (FragmentTabHost) this.glc.findViewById(d.h.tab_host);
        this.bdg.setup(this.glc.getSupportFragmentManager());
        this.bdg.setOnTabSelectionListener(this.gli);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bdg.setShouldDrawIndicatorLine(false);
            this.bdg.setShouldDrawTopLine(true);
        }
        this.bdg.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bdg.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.c.7
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.bdg.getCurrentTabType() != 2) {
                    if (c.this.bdg.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                c.this.bth();
                if (c.this.bdg.getCurrentTabType() != c.this.bdg.cA(i).mType) {
                    c.this.bdg.setCurrentTab(i);
                }
                if (c.this.bdg.getCurrentTabType() != 1) {
                    c.this.ccI.setVisibility(8);
                    c.this.bbL.setVisibility(0);
                }
                c.this.eqr = c.this.bdg.getCurrentTabType();
                c.this.btf();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (c.this.bdg.getCurrentTabType() != 3) {
                        if (c.this.bdg.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (c.this.bdg.getCurrentTabType() == 3) {
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
        this.glf = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        aiw();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.glc.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void btd() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.glf);
    }

    public boolean bte() {
        return this.gld != null && this.gld.getVisibility() == 0;
    }

    public void mI(boolean z) {
        if (this.gld != null) {
            if (z) {
                this.gld.setVisibility(0);
            } else {
                this.gld.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bdg.setShouldDrawTopLine(false);
            } else {
                this.bdg.az(true);
            }
        }
        if (this.bdg.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bdg.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bdg.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.glc.getPageContext(), i);
        aj.a(this.dJG, d.e.cp_cont_b, d.e.s_navbar_title_color, i);
        aj.c(this.gle, d.g.icon_news_down_bar_one);
        aj.a(this.gld, d.g.icon_game_bg_s, d.g.icon_game_bg);
        aj.a(this.bbL, d.g.icon_search_bg_s, d.g.icon_search_bg);
        aj.a(this.ccI, d.g.icon_sign_bg_s, d.g.icon_sign_bg);
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.glc.getPageContext().getPageActivity()).inflate(d.j.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.h.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.h.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            aj.c(textView, d.e.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.BO())) {
                textView.setText(payMemberInfoData.BO());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.c(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                aj.c(tbImageView, d.g.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.glc.getPageContext().getPageActivity());
            aVar.v(inflate);
            aVar.cd(d.e.cp_link_tip_d);
            aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.tblauncher.c.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(c.this.glc.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(c.this.glc.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.glc.getPageContext().getString(d.l.member_continue_pay);
            if (i == 0) {
                string = this.glc.getPageContext().getString(d.l.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.c.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(c.this.glc.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(c.this.glc.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.glc.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.ar(false);
            aVar.b(this.glc.getPageContext()).tb();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void btf() {
        FragmentTabHost.c cB;
        if (this.bdg != null && (cB = this.bdg.cB(this.bdg.getCurrentTabType())) != null && cB.adT != null && cB.adT.Eu() != null) {
            String string = this.glc.getPageContext().getString(cB.adT.Eu().aGj);
            if (this.dJG != null) {
                this.dJG.setText(string);
            }
        }
    }

    public void aiw() {
        this.mNavigationBar = (NavigationBar) this.glc.findViewById(d.h.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.dJG = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.maintab_title_layout, (View.OnClickListener) null).findViewById(d.h.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.glc.getResources().getDimension(d.f.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.dJG.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.game_tip_view, (View.OnClickListener) null);
            this.gld = (ImageView) addCustomView.findViewById(d.h.game_button_iv);
            this.gle = (ImageView) addCustomView.findViewById(d.h.game_tip_msg_iv);
            this.gld.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mL(false);
                    c.this.gle.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, c.this.glc.getPageContext()));
                    TiebaStatic.eventStat(c.this.glc.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.f(this.glc.getPageContext().getPageActivity(), d.f.ds16), 0);
            this.bbL = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_search, (View.OnClickListener) null);
            this.bbL.setLayoutParams(layoutParams2);
            this.bbL.setVisibility(8);
            this.bbL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    c.this.glc.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(c.this.glc.getPageContext().getPageActivity())));
                    if (c.this.bdg.getCurrentTabType() != 3) {
                        if (c.this.bdg.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new ak("c10378").r("obj_type", i));
                }
            });
            this.ccI = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_signall, (View.OnClickListener) null);
            this.ccI.setLayoutParams(layoutParams2);
            this.ccI.setVisibility(8);
            this.ccI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        c.this.glc.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.glc.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.glc.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aS(c.this.glc.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.glc.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (c.this.eqr) {
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
                    ax.aR(c.this.glc.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void mJ(boolean z) {
        if (z) {
            this.ccI.setVisibility(0);
            this.bbL.setVisibility(8);
            return;
        }
        this.ccI.setVisibility(8);
        this.bbL.setVisibility(0);
    }

    public void mK(boolean z) {
        if (bte()) {
            if (z) {
                if (this.gle.getVisibility() != 0) {
                    this.gle.setVisibility(0);
                    mL(true);
                    aj.c(this.gle, d.g.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            mL(false);
            this.gle.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mL(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gld.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.f(this.glc.getPageContext().getPageActivity(), d.f.ds32);
            } else {
                layoutParams.rightMargin = l.f(this.glc.getPageContext().getPageActivity(), d.f.ds20);
            }
            this.gld.setLayoutParams(layoutParams);
        }
    }

    public void ad(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bdg.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Eu(), next.aY(this.glc.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.bdg.cy(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bdg.cy(1);
        } else {
            this.bdg.cy(0);
        }
        this.bdg.setViewPagerScrollable(false);
    }

    public void ie(boolean z) {
        this.eqv = z;
        if (!this.eqv) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aKK() {
        return this.eqv;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, e eVar) {
        if (cVar != null && (eVar instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) eVar;
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.adS = cVar.aGi;
            cVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.aGq);
            if (cVar.aGq == com.baidu.tbadk.mainTab.c.aGn) {
                maintabBottomIndicator.M(cVar.aGk, cVar.aGl);
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.aGk);
                maintabBottomIndicator.setText(cVar.aGj);
                maintabBottomIndicator.setAnimationResId(cVar.aGm);
            }
            eVar.dD(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            cVar2.adR = maintabBottomIndicator;
            cVar2.adT = bVar;
            this.bdg.a(cVar2);
        }
    }

    public FragmentTabHost btg() {
        return this.bdg;
    }

    public void bth() {
        if (this.bdg != null) {
            if ((this.bdg.getCurrentTabType() == 8 || this.bdg.getCurrentTabType() == 3 || this.bdg.getCurrentTabType() == 2 || this.bdg.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.bdg.getCurrentTabType() != 1) {
                if (this.ccI != null) {
                    this.ccI.setVisibility(8);
                }
                if (this.bbL != null && this.bdg.getCurrentTabType() != 3) {
                    this.bbL.setVisibility(0);
                }
            }
        }
    }

    public void bti() {
        if (!this.glh) {
            this.glh = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_last_new_write_tips", false);
            if (!this.glh) {
                View inflate = LayoutInflater.from(this.glc.getActivity()).inflate(d.j.tips_blue_center_down, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(d.h.tips);
                textView.setText(d.l.maintab_write_tips);
                textView.setOnClickListener(this.ePU);
                this.glg = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.ePS, 100L);
            }
        }
    }

    public void btj() {
        this.mHandler.removeCallbacks(this.ePS);
        this.mHandler.removeCallbacks(this.ePT);
        aSN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSN() {
        g.a(this.glg);
    }

    public void sh(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.glc.getActivity());
        aVar.cL(str);
        aVar.a(d.l.close, new a.b() { // from class: com.baidu.tieba.tblauncher.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ak akVar = new ak("c12137");
                akVar.ac("obj_locate", "1");
                TiebaStatic.log(akVar);
                aVar2.dismiss();
            }
        });
        aVar.b(d.l.check, new a.b() { // from class: com.baidu.tieba.tblauncher.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ak akVar = new ak("c12137");
                akVar.ac("obj_locate", "2");
                TiebaStatic.log(akVar);
                aVar2.dismiss();
                com.baidu.tieba.h.a.aom();
            }
        });
        aVar.b(this.glc.getPageContext()).tb();
    }

    public void onDestroy() {
        btd();
        if (btg() != null) {
            btg().reset();
        }
        btj();
        if (this.cEu != null) {
            this.cEu.onDestroy();
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        if (this.cEu == null) {
            this.cEu = new com.baidu.tieba.d.b(this.glc.getPageContext(), (ViewStub) this.glc.findViewById(d.h.write_share_viewStub));
        }
        this.cEu.a(postWriteCallBackData);
    }
}
