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
    private ImageView bbZ;
    private FragmentTabHost bdu;
    private com.baidu.tieba.d.b cEG;
    private ImageView ccU;
    private TextView dJU;
    private boolean eqJ;
    private MainTabActivity glq;
    private ImageView glr;
    private ImageView gls;
    private PopupWindow glu;
    private NavigationBar mNavigationBar;
    private boolean glt = false;
    private int eqF = -1;
    private boolean glv = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.b glw = new FragmentTabHost.b() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public void e(int i, boolean z) {
            if (c.this.bdu.cB(i).mType == 8) {
                TiebaStatic.log(new ak("c10605"));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public boolean f(int i, boolean z) {
            FragmentTabHost.c cB = c.this.bdu.cB(i);
            if (cB.mType == 9) {
                if (ax.aU(c.this.glq.getPageContext().getPageActivity())) {
                    c.this.glq.akC();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (cB.mType == 8 && !ax.aU(c.this.glq.getActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                return true;
            }
        }
    };
    private Runnable eQg = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bdu != null && c.this.glu != null) {
                FragmentTabWidget fragmentTabWidget = c.this.bdu.getFragmentTabWidget();
                int ad = l.ad(c.this.glq.getActivity());
                int f = l.f(c.this.glq.getActivity(), d.f.ds200);
                View contentView = c.this.glu.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    g.showPopupWindowAsDropDown(c.this.glu, fragmentTabWidget, (ad - contentView.getMeasuredWidth()) / 2, -f);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_new_write_tips", true);
                    c.this.glv = true;
                    c.this.mHandler.postDelayed(c.this.eQh, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable eQh = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.aSS();
        }
    };
    private View.OnClickListener eQi = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.btr();
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.glq = mainTabActivity;
    }

    public void mI(boolean z) {
        this.bdu = (FragmentTabHost) this.glq.findViewById(d.h.tab_host);
        this.bdu.setup(this.glq.getSupportFragmentManager());
        this.bdu.setOnTabSelectionListener(this.glw);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bdu.setShouldDrawIndicatorLine(false);
            this.bdu.setShouldDrawTopLine(true);
        }
        this.bdu.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bdu.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.c.7
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.bdu.getCurrentTabType() != 2) {
                    if (c.this.bdu.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                c.this.btp();
                if (c.this.bdu.getCurrentTabType() != c.this.bdu.cB(i).mType) {
                    c.this.bdu.setCurrentTab(i);
                }
                if (c.this.bdu.getCurrentTabType() != 1) {
                    c.this.ccU.setVisibility(8);
                    c.this.bbZ.setVisibility(0);
                }
                c.this.eqF = c.this.bdu.getCurrentTabType();
                c.this.btn();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (c.this.bdu.getCurrentTabType() != 3) {
                        if (c.this.bdu.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (c.this.bdu.getCurrentTabType() == 3) {
                    TiebaStatic.log(new ak("view_msg").ad("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.glt = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        aiB();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.glq.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void btl() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.glt);
    }

    public boolean btm() {
        return this.glr != null && this.glr.getVisibility() == 0;
    }

    public void mJ(boolean z) {
        if (this.glr != null) {
            if (z) {
                this.glr.setVisibility(0);
            } else {
                this.glr.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bdu.setShouldDrawTopLine(false);
            } else {
                this.bdu.aA(true);
            }
        }
        if (this.bdu.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bdu.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bdu.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.glq.getPageContext(), i);
        aj.a(this.dJU, d.e.cp_cont_b, d.e.s_navbar_title_color, i);
        aj.c(this.gls, d.g.icon_news_down_bar_one);
        aj.a(this.glr, d.g.icon_game_bg_s, d.g.icon_game_bg);
        aj.a(this.bbZ, d.g.icon_search_bg_s, d.g.icon_search_bg);
        aj.a(this.ccU, d.g.icon_sign_bg_s, d.g.icon_sign_bg);
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.glq.getPageContext().getPageActivity()).inflate(d.j.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.h.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.h.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            aj.c(textView, d.e.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.BU())) {
                textView.setText(payMemberInfoData.BU());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.c(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                aj.c(tbImageView, d.g.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.glq.getPageContext().getPageActivity());
            aVar.v(inflate);
            aVar.ce(d.e.cp_link_tip_d);
            aVar.b(d.l.know, new a.b() { // from class: com.baidu.tieba.tblauncher.c.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(c.this.glq.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(c.this.glq.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.glq.getPageContext().getString(d.l.member_continue_pay);
            if (i == 0) {
                string = this.glq.getPageContext().getString(d.l.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.c.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(c.this.glq.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(c.this.glq.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.glq.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.as(false);
            aVar.b(this.glq.getPageContext()).ti();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void btn() {
        FragmentTabHost.c cC;
        if (this.bdu != null && (cC = this.bdu.cC(this.bdu.getCurrentTabType())) != null && cC.aef != null && cC.aef.EA() != null) {
            String string = this.glq.getPageContext().getString(cC.aef.EA().aGw);
            if (this.dJU != null) {
                this.dJU.setText(string);
            }
        }
    }

    public void aiB() {
        this.mNavigationBar = (NavigationBar) this.glq.findViewById(d.h.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.dJU = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.maintab_title_layout, (View.OnClickListener) null).findViewById(d.h.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.glq.getResources().getDimension(d.f.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.dJU.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.game_tip_view, (View.OnClickListener) null);
            this.glr = (ImageView) addCustomView.findViewById(d.h.game_button_iv);
            this.gls = (ImageView) addCustomView.findViewById(d.h.game_tip_msg_iv);
            this.glr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mM(false);
                    c.this.gls.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, c.this.glq.getPageContext()));
                    TiebaStatic.eventStat(c.this.glq.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.f(this.glq.getPageContext().getPageActivity(), d.f.ds16), 0);
            this.bbZ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_search, (View.OnClickListener) null);
            this.bbZ.setLayoutParams(layoutParams2);
            this.bbZ.setVisibility(8);
            this.bbZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    c.this.glq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(c.this.glq.getPageContext().getPageActivity())));
                    if (c.this.bdu.getCurrentTabType() != 3) {
                        if (c.this.bdu.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new ak("c10378").r("obj_type", i));
                }
            });
            this.ccU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.widget_nb_item_signall, (View.OnClickListener) null);
            this.ccU.setLayoutParams(layoutParams2);
            this.ccU.setVisibility(8);
            this.ccU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        c.this.glq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.glq.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.glq.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aT(c.this.glq.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.glq.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (c.this.eqF) {
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
                    TiebaStatic.log(new ak("c10517").ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
                    ax.aS(c.this.glq.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void mK(boolean z) {
        if (z) {
            this.ccU.setVisibility(0);
            this.bbZ.setVisibility(8);
            return;
        }
        this.ccU.setVisibility(8);
        this.bbZ.setVisibility(0);
    }

    public void mL(boolean z) {
        if (btm()) {
            if (z) {
                if (this.gls.getVisibility() != 0) {
                    this.gls.setVisibility(0);
                    mM(true);
                    aj.c(this.gls, d.g.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            mM(false);
            this.gls.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mM(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.glr.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.f(this.glq.getPageContext().getPageActivity(), d.f.ds32);
            } else {
                layoutParams.rightMargin = l.f(this.glq.getPageContext().getPageActivity(), d.f.ds20);
            }
            this.glr.setLayoutParams(layoutParams);
        }
    }

    public void ad(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bdu.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.EA(), next.aZ(this.glq.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.bdu.cz(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bdu.cz(1);
        } else {
            this.bdu.cz(0);
        }
        this.bdu.setViewPagerScrollable(false);
    }

    /* renamed from: if  reason: not valid java name */
    public void m13if(boolean z) {
        this.eqJ = z;
        if (!this.eqJ) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aKP() {
        return this.eqJ;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, e eVar) {
        if (cVar != null && (eVar instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) eVar;
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aee = cVar.aGv;
            cVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.aGD);
            if (cVar.aGD == com.baidu.tbadk.mainTab.c.aGA) {
                maintabBottomIndicator.M(cVar.aGx, cVar.aGy);
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.aGx);
                maintabBottomIndicator.setText(cVar.aGw);
                maintabBottomIndicator.setAnimationResId(cVar.aGz);
            }
            eVar.dE(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            cVar2.aed = maintabBottomIndicator;
            cVar2.aef = bVar;
            this.bdu.a(cVar2);
        }
    }

    public FragmentTabHost bto() {
        return this.bdu;
    }

    public void btp() {
        if (this.bdu != null) {
            if ((this.bdu.getCurrentTabType() == 8 || this.bdu.getCurrentTabType() == 3 || this.bdu.getCurrentTabType() == 2 || this.bdu.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.bdu.getCurrentTabType() != 1) {
                if (this.ccU != null) {
                    this.ccU.setVisibility(8);
                }
                if (this.bbZ != null && this.bdu.getCurrentTabType() != 3) {
                    this.bbZ.setVisibility(0);
                }
            }
        }
    }

    public void btq() {
        if (!this.glv) {
            this.glv = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_last_new_write_tips", false);
            if (!this.glv) {
                View inflate = LayoutInflater.from(this.glq.getActivity()).inflate(d.j.tips_blue_center_down, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(d.h.tips);
                textView.setText(d.l.maintab_write_tips);
                textView.setOnClickListener(this.eQi);
                this.glu = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.eQg, 100L);
            }
        }
    }

    public void btr() {
        this.mHandler.removeCallbacks(this.eQg);
        this.mHandler.removeCallbacks(this.eQh);
        aSS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSS() {
        g.a(this.glu);
    }

    public void si(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.glq.getActivity());
        aVar.cM(str);
        aVar.a(d.l.close, new a.b() { // from class: com.baidu.tieba.tblauncher.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ak akVar = new ak("c12137");
                akVar.ad("obj_locate", "1");
                TiebaStatic.log(akVar);
                aVar2.dismiss();
            }
        });
        aVar.b(d.l.check, new a.b() { // from class: com.baidu.tieba.tblauncher.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ak akVar = new ak("c12137");
                akVar.ad("obj_locate", "2");
                TiebaStatic.log(akVar);
                aVar2.dismiss();
                com.baidu.tieba.h.a.aor();
            }
        });
        aVar.b(this.glq.getPageContext()).ti();
    }

    public void onDestroy() {
        btl();
        if (bto() != null) {
            bto().reset();
        }
        btr();
        if (this.cEG != null) {
            this.cEG.onDestroy();
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        if (this.cEG == null) {
            this.cEG = new com.baidu.tieba.d.b(this.glq.getPageContext(), (ViewStub) this.glq.findViewById(d.h.write_share_viewStub));
        }
        this.cEG.a(postWriteCallBackData);
    }
}
