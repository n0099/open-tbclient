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
    private ImageView bcr;
    private FragmentTabHost bdS;
    private com.baidu.tieba.d.b cNH;
    private ImageView cke;
    private d czs;
    private TextView dRt;
    private boolean eyH;
    private MainTabActivity gtP;
    private ImageView gtQ;
    private ImageView gtR;
    private PopupWindow gtT;
    private NavigationBar mNavigationBar;
    private boolean gtS = false;
    private int eyD = -1;
    private boolean gtU = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.b gtV = new FragmentTabHost.b() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public void e(int i, boolean z) {
            if (c.this.bdS.cB(i).mType == 8) {
                TiebaStatic.log(new ak("c10605"));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public boolean f(int i, boolean z) {
            FragmentTabHost.c cB = c.this.bdS.cB(i);
            if (cB.mType == 9) {
                if (ax.aT(c.this.gtP.getPageContext().getPageActivity())) {
                    c.this.gtP.ang();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (cB.mType == 8 && !ax.aT(c.this.gtP.getActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                return true;
            }
        }
    };
    private Runnable eYH = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bdS != null && c.this.gtT != null) {
                FragmentTabWidget fragmentTabWidget = c.this.bdS.getFragmentTabWidget();
                int ac = l.ac(c.this.gtP.getActivity());
                int f = l.f(c.this.gtP.getActivity(), d.e.ds200);
                View contentView = c.this.gtT.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    g.showPopupWindowAsDropDown(c.this.gtT, fragmentTabWidget, (ac - contentView.getMeasuredWidth()) / 2, -f);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_new_write_tips", true);
                    c.this.gtU = true;
                    c.this.mHandler.postDelayed(c.this.eYI, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable eYI = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.aWb();
        }
    };
    private View.OnClickListener eYJ = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bwm();
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.gtP = mainTabActivity;
    }

    public void mD(boolean z) {
        this.bdS = (FragmentTabHost) this.gtP.findViewById(d.g.tab_host);
        this.bdS.setup(this.gtP.getSupportFragmentManager());
        this.bdS.setOnTabSelectionListener(this.gtV);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bdS.setShouldDrawIndicatorLine(false);
            this.bdS.setShouldDrawTopLine(true);
        }
        this.bdS.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bdS.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.c.7
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.bdS.getCurrentTabType() != 2) {
                    if (c.this.bdS.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                c.this.bwk();
                if (c.this.bdS.getCurrentTabType() != c.this.bdS.cB(i).mType) {
                    c.this.bdS.setCurrentTab(i);
                }
                if (c.this.bdS.getCurrentTabType() != 1) {
                    c.this.cke.setVisibility(8);
                    c.this.bcr.setVisibility(0);
                }
                c.this.eyD = c.this.bdS.getCurrentTabType();
                c.this.bwi();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (c.this.bdS.getCurrentTabType() != 3) {
                        if (c.this.bdS.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (c.this.bdS.getCurrentTabType() == 3) {
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
        this.gtS = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        akI();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.gtP.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void bwg() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.gtS);
    }

    public boolean bwh() {
        return this.gtQ != null && this.gtQ.getVisibility() == 0;
    }

    public void mE(boolean z) {
        if (this.gtQ != null) {
            if (z) {
                this.gtQ.setVisibility(0);
            } else {
                this.gtQ.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bdS.setShouldDrawTopLine(false);
            } else {
                this.bdS.ax(true);
            }
        }
        if (this.bdS.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bdS.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bdS.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.gtP.getPageContext(), i);
        aj.a(this.dRt, d.C0080d.cp_cont_b, d.C0080d.s_navbar_title_color, i);
        aj.c(this.gtR, d.f.icon_news_down_bar_one);
        aj.a(this.gtQ, d.f.icon_game_bg_s, d.f.icon_game_bg);
        aj.a(this.bcr, d.f.icon_search_bg_s, d.f.icon_search_bg);
        aj.a(this.cke, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.gtP.getPageContext().getPageActivity()).inflate(d.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            aj.c(textView, d.C0080d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.Cd())) {
                textView.setText(payMemberInfoData.Cd());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                aj.c(tbImageView, d.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gtP.getPageContext().getPageActivity());
            aVar.v(inflate);
            aVar.cd(d.C0080d.cp_link_tip_d);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.tblauncher.c.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(c.this.gtP.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(c.this.gtP.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.gtP.getPageContext().getString(d.j.member_continue_pay);
            if (i == 0) {
                string = this.gtP.getPageContext().getString(d.j.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.c.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(c.this.gtP.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(c.this.gtP.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.gtP.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.ap(false);
            aVar.b(this.gtP.getPageContext()).th();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void bwi() {
        FragmentTabHost.c cC;
        if (this.bdS != null && (cC = this.bdS.cC(this.bdS.getCurrentTabType())) != null && cC.aep != null && cC.aep.EG() != null) {
            String string = this.gtP.getPageContext().getString(cC.aep.EG().aGT);
            if (this.dRt != null) {
                this.dRt.setText(string);
            }
        }
    }

    public void akI() {
        this.mNavigationBar = (NavigationBar) this.gtP.findViewById(d.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.dRt = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.gtP.getResources().getDimension(d.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.dRt.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.game_tip_view, (View.OnClickListener) null);
            this.gtQ = (ImageView) addCustomView.findViewById(d.g.game_button_iv);
            this.gtR = (ImageView) addCustomView.findViewById(d.g.game_tip_msg_iv);
            this.gtQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mH(false);
                    c.this.gtR.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, c.this.gtP.getPageContext()));
                    TiebaStatic.eventStat(c.this.gtP.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.f(this.gtP.getPageContext().getPageActivity(), d.e.ds16), 0);
            this.bcr = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.bcr.setLayoutParams(layoutParams2);
            this.bcr.setVisibility(8);
            this.bcr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    c.this.gtP.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(c.this.gtP.getPageContext().getPageActivity())));
                    if (c.this.bdS.getCurrentTabType() != 3) {
                        if (c.this.bdS.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new ak("c10378").r("obj_type", i));
                }
            });
            this.cke = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.cke.setLayoutParams(layoutParams2);
            this.cke.setVisibility(8);
            this.cke.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        c.this.gtP.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.gtP.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.gtP.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aS(c.this.gtP.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.gtP.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (c.this.eyD) {
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
                    ax.aR(c.this.gtP.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void mF(boolean z) {
        if (z) {
            this.cke.setVisibility(0);
            this.bcr.setVisibility(8);
            return;
        }
        this.cke.setVisibility(8);
        this.bcr.setVisibility(0);
    }

    public void mG(boolean z) {
        if (bwh()) {
            if (z) {
                if (this.gtR.getVisibility() != 0) {
                    this.gtR.setVisibility(0);
                    mH(true);
                    aj.c(this.gtR, d.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            mH(false);
            this.gtR.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mH(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gtQ.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.f(this.gtP.getPageContext().getPageActivity(), d.e.ds32);
            } else {
                layoutParams.rightMargin = l.f(this.gtP.getPageContext().getPageActivity(), d.e.ds20);
            }
            this.gtQ.setLayoutParams(layoutParams);
        }
    }

    public void ad(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bdS.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.EG(), next.aY(this.gtP.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.bdS.cz(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bdS.cz(1);
        } else {
            this.bdS.cz(0);
        }
        this.bdS.setViewPagerScrollable(false);
    }

    public void ia(boolean z) {
        this.eyH = z;
        if (!this.eyH) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aNC() {
        return this.eyH;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, e eVar) {
        if (cVar != null && (eVar instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) eVar;
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aeo = cVar.aGS;
            cVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.aHa);
            if (cVar.aHa == com.baidu.tbadk.mainTab.c.aGX) {
                maintabBottomIndicator.M(cVar.aGU, cVar.aGV);
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.aGU);
                maintabBottomIndicator.setText(cVar.aGT);
                maintabBottomIndicator.setAnimationResId(cVar.aGW);
            }
            eVar.dE(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            cVar2.aen = maintabBottomIndicator;
            cVar2.aep = bVar;
            this.bdS.a(cVar2);
        }
    }

    public FragmentTabHost bwj() {
        return this.bdS;
    }

    public void bwk() {
        if (this.bdS != null) {
            if ((this.bdS.getCurrentTabType() == 8 || this.bdS.getCurrentTabType() == 3 || this.bdS.getCurrentTabType() == 2 || this.bdS.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.bdS.getCurrentTabType() != 1) {
                if (this.cke != null) {
                    this.cke.setVisibility(8);
                }
                if (this.bcr != null && this.bdS.getCurrentTabType() != 3) {
                    this.bcr.setVisibility(0);
                }
            }
        }
    }

    public void bwl() {
        if (!this.gtU) {
            this.gtU = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_last_new_write_tips", false);
            if (!this.gtU) {
                View inflate = LayoutInflater.from(this.gtP.getActivity()).inflate(d.h.tips_blue_center_down, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                textView.setText(d.j.maintab_write_tips);
                textView.setOnClickListener(this.eYJ);
                this.gtT = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.eYH, 100L);
            }
        }
    }

    public void bwm() {
        this.mHandler.removeCallbacks(this.eYH);
        this.mHandler.removeCallbacks(this.eYI);
        aWb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWb() {
        g.a(this.gtT);
    }

    public void sP(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gtP.getActivity());
        aVar.cS(str);
        aVar.a(d.j.close, new a.b() { // from class: com.baidu.tieba.tblauncher.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ak akVar = new ak("c12137");
                akVar.ac("obj_locate", "1");
                TiebaStatic.log(akVar);
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.check, new a.b() { // from class: com.baidu.tieba.tblauncher.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ak akVar = new ak("c12137");
                akVar.ac("obj_locate", "2");
                TiebaStatic.log(akVar);
                aVar2.dismiss();
                com.baidu.tieba.h.a.aqO();
            }
        });
        aVar.b(this.gtP.getPageContext()).th();
    }

    public void onDestroy() {
        bwg();
        if (bwj() != null) {
            bwj().reset();
        }
        bwm();
        if (this.cNH != null) {
            this.cNH.onDestroy();
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        if (this.cNH == null) {
            this.cNH = new com.baidu.tieba.d.b(this.gtP.getPageContext(), (ViewStub) this.gtP.findViewById(d.g.write_share_viewStub));
        }
        this.cNH.a(postWriteCallBackData);
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.czs == null) {
                this.czs = new com.baidu.tieba.video.d(this.gtP, this.gtP.oQ());
            }
            this.czs.f(postWriteCallBackData);
        }
    }
}
