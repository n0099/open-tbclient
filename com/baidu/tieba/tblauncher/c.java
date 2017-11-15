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
import com.baidu.tieba.video.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private ImageView bcA;
    private FragmentTabHost beb;
    private com.baidu.tieba.d.b cOb;
    private ImageView ckv;
    private d czL;
    private TextView dRy;
    private boolean ezb;
    private MainTabActivity guV;
    private ImageView guW;
    private ImageView guX;
    private TextView guY;
    private PopupWindow gva;
    private Runnable gvd;
    private NavigationBar mNavigationBar;
    private boolean guZ = false;
    private int eyX = -1;
    private boolean gvb = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.b gvc = new FragmentTabHost.b() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public void e(int i, boolean z) {
            if (c.this.beb.cA(i).mType == 8) {
                TiebaStatic.log(new ak("c10605"));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public boolean f(int i, boolean z) {
            FragmentTabHost.c cA = c.this.beb.cA(i);
            if (cA.mType == 9) {
                if (ax.aT(c.this.guV.getPageContext().getPageActivity())) {
                    c.this.guV.anx();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (cA.mType == 8 && !ax.aT(c.this.guV.getActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                return true;
            }
        }
    };
    private Runnable eZc = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.beb != null && c.this.gva != null) {
                FragmentTabWidget fragmentTabWidget = c.this.beb.getFragmentTabWidget();
                int ac = l.ac(c.this.guV.getActivity());
                int f = l.f(c.this.guV.getActivity(), d.e.ds200);
                View contentView = c.this.gva.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    g.showPopupWindowAsDropDown(c.this.gva, fragmentTabWidget, (ac - contentView.getMeasuredWidth()) / 2, -f);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_new_write_tips", true);
                    c.this.gvb = true;
                    c.this.mHandler.postDelayed(c.this.eZd, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable eZd = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.aWj();
        }
    };
    private View.OnClickListener eZe = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bwy();
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.guV = mainTabActivity;
    }

    public void mL(boolean z) {
        this.beb = (FragmentTabHost) this.guV.findViewById(d.g.tab_host);
        this.beb.setup(this.guV.getSupportFragmentManager());
        this.beb.setOnTabSelectionListener(this.gvc);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.beb.setShouldDrawIndicatorLine(false);
            this.beb.setShouldDrawTopLine(true);
        }
        this.beb.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.beb.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.c.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.beb.getCurrentTabType() != 2) {
                    if (c.this.beb.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                c.this.bww();
                if (c.this.beb.getCurrentTabType() != c.this.beb.cA(i).mType) {
                    c.this.beb.setCurrentTab(i);
                }
                if (c.this.beb.getCurrentTabType() != 1) {
                    c.this.ckv.setVisibility(8);
                    c.this.bcA.setVisibility(0);
                }
                c.this.eyX = c.this.beb.getCurrentTabType();
                c.this.bwu();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (c.this.beb.getCurrentTabType() != 3) {
                        if (c.this.beb.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (c.this.beb.getCurrentTabType() == 3) {
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
        this.guZ = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        akW();
        this.guY = (TextView) this.guV.findViewById(d.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.guV.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void sU(final String str) {
        if (StringUtils.isNull(str)) {
            this.guY.setVisibility(8);
            return;
        }
        FragmentTabHost.c cB = this.beb.cB(8);
        if (cB != null) {
            if (!this.gvb || (this.gva != null && this.gva.isShowing())) {
                if (this.gvd == null) {
                    this.gvd = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.9
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.sU(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.gvd);
                TbadkCoreApplication.getInst().handler.postDelayed(this.gvd, TbConfig.NOTIFY_SOUND_INTERVAL);
                return;
            }
            a(str, cB);
            return;
        }
        this.guY.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.c cVar) {
        int[] iArr = new int[2];
        cVar.aen.getLocationInWindow(iArr);
        int width = l.o(this.guV).widthPixels - (iArr[0] + (cVar.aen.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.guY.getLayoutParams();
        layoutParams.rightMargin = width - l.f(this.guV.getPageContext().getPageActivity(), d.e.ds26);
        this.guY.setLayoutParams(layoutParams);
        this.guY.setVisibility(0);
        this.guY.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void bws() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.guZ);
    }

    public boolean bwt() {
        return this.guW != null && this.guW.getVisibility() == 0;
    }

    public void mM(boolean z) {
        if (this.guW != null) {
            if (z) {
                this.guW.setVisibility(0);
            } else {
                this.guW.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.beb.setShouldDrawTopLine(false);
            } else {
                this.beb.ax(true);
            }
        }
        if (this.beb.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.beb.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.beb.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.guV.getPageContext(), i);
        aj.a(this.dRy, d.C0080d.cp_cont_b, d.C0080d.s_navbar_title_color, i);
        aj.c(this.guX, d.f.icon_news_down_bar_one);
        aj.a(this.guW, d.f.icon_game_bg_s, d.f.icon_game_bg);
        aj.a(this.bcA, d.f.icon_search_bg_s, d.f.icon_search_bg);
        aj.a(this.ckv, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.guV.getPageContext().getPageActivity()).inflate(d.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            aj.c(textView, d.C0080d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.Cp())) {
                textView.setText(payMemberInfoData.Cp());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                aj.c(tbImageView, d.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.guV.getPageContext().getPageActivity());
            aVar.v(inflate);
            aVar.cd(d.C0080d.cp_link_tip_d);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.tblauncher.c.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(c.this.guV.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(c.this.guV.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.guV.getPageContext().getString(d.j.member_continue_pay);
            if (i == 0) {
                string = this.guV.getPageContext().getString(d.j.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.c.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(c.this.guV.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(c.this.guV.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.guV.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.ap(false);
            aVar.b(this.guV.getPageContext()).th();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void bwu() {
        FragmentTabHost.c cB;
        if (this.beb != null && (cB = this.beb.cB(this.beb.getCurrentTabType())) != null && cB.aep != null && cB.aep.ES() != null) {
            String string = this.guV.getPageContext().getString(cB.aep.ES().aHb);
            if (this.dRy != null) {
                this.dRy.setText(string);
            }
        }
    }

    public void akW() {
        this.mNavigationBar = (NavigationBar) this.guV.findViewById(d.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.dRy = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.guV.getResources().getDimension(d.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.dRy.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.game_tip_view, (View.OnClickListener) null);
            this.guW = (ImageView) addCustomView.findViewById(d.g.game_button_iv);
            this.guX = (ImageView) addCustomView.findViewById(d.g.game_tip_msg_iv);
            this.guW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mP(false);
                    c.this.guX.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, c.this.guV.getPageContext()));
                    TiebaStatic.eventStat(c.this.guV.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.f(this.guV.getPageContext().getPageActivity(), d.e.ds16), 0);
            this.bcA = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.bcA.setLayoutParams(layoutParams2);
            this.bcA.setVisibility(8);
            this.bcA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    c.this.guV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(c.this.guV.getPageContext().getPageActivity())));
                    if (c.this.beb.getCurrentTabType() != 3) {
                        if (c.this.beb.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new ak("c10378").r("obj_type", i));
                }
            });
            this.ckv = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.ckv.setLayoutParams(layoutParams2);
            this.ckv.setVisibility(8);
            this.ckv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        c.this.guV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.guV.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.guV.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aS(c.this.guV.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.guV.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (c.this.eyX) {
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
                    ax.aR(c.this.guV.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void mN(boolean z) {
        if (z) {
            this.ckv.setVisibility(0);
            this.bcA.setVisibility(8);
            return;
        }
        this.ckv.setVisibility(8);
        this.bcA.setVisibility(0);
    }

    public void mO(boolean z) {
        if (bwt()) {
            if (z) {
                if (this.guX.getVisibility() != 0) {
                    this.guX.setVisibility(0);
                    mP(true);
                    aj.c(this.guX, d.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            mP(false);
            this.guX.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mP(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.guW.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.f(this.guV.getPageContext().getPageActivity(), d.e.ds32);
            } else {
                layoutParams.rightMargin = l.f(this.guV.getPageContext().getPageActivity(), d.e.ds20);
            }
            this.guW.setLayoutParams(layoutParams);
        }
    }

    public void ad(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.beb.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.ES(), next.aY(this.guV.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.beb.cy(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.beb.cy(1);
        } else {
            this.beb.cy(0);
        }
        this.beb.setViewPagerScrollable(false);
    }

    public void ig(boolean z) {
        this.ezb = z;
        if (!this.ezb) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aNK() {
        return this.ezb;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, e eVar) {
        if (cVar != null && (eVar instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) eVar;
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aeo = cVar.aHa;
            cVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.aHi);
            if (cVar.aHi == com.baidu.tbadk.mainTab.c.aHf) {
                maintabBottomIndicator.M(cVar.aHc, cVar.aHd);
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.aHc);
                maintabBottomIndicator.setText(cVar.aHb);
                maintabBottomIndicator.setAnimationResId(cVar.aHe);
            }
            eVar.dD(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            cVar2.aen = maintabBottomIndicator;
            cVar2.aep = bVar;
            this.beb.a(cVar2);
        }
    }

    public FragmentTabHost bwv() {
        return this.beb;
    }

    public void bww() {
        if (this.beb != null) {
            if ((this.beb.getCurrentTabType() == 8 || this.beb.getCurrentTabType() == 3 || this.beb.getCurrentTabType() == 2 || this.beb.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.beb.getCurrentTabType() != 1) {
                if (this.ckv != null) {
                    this.ckv.setVisibility(8);
                }
                if (this.bcA != null && this.beb.getCurrentTabType() != 3) {
                    this.bcA.setVisibility(0);
                }
            }
        }
    }

    public void bwx() {
        if (!this.gvb) {
            this.gvb = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_last_new_write_tips", false);
            if (!this.gvb) {
                View inflate = LayoutInflater.from(this.guV.getActivity()).inflate(d.h.tips_blue_center_down, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                textView.setText(d.j.maintab_write_tips);
                textView.setOnClickListener(this.eZe);
                this.gva = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.eZc, 100L);
            }
        }
    }

    public void bwy() {
        this.mHandler.removeCallbacks(this.eZc);
        this.mHandler.removeCallbacks(this.eZd);
        aWj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWj() {
        g.a(this.gva);
    }

    public void sV(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.guV.getActivity());
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
                com.baidu.tieba.h.a.are();
            }
        });
        aVar.b(this.guV.getPageContext()).th();
    }

    public void onDestroy() {
        bws();
        if (bwv() != null) {
            bwv().reset();
        }
        bwy();
        if (this.cOb != null) {
            this.cOb.onDestroy();
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        if (this.cOb == null) {
            this.cOb = new com.baidu.tieba.d.b(this.guV.getPageContext(), (ViewStub) this.guV.findViewById(d.g.write_share_viewStub));
        }
        this.cOb.a(postWriteCallBackData);
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.czL == null) {
                this.czL = new com.baidu.tieba.video.d(this.guV, this.guV.oQ());
            }
            this.czL.f(postWriteCallBackData);
        }
    }
}
