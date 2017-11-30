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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.d.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.e;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private ImageView bfM;
    private FragmentTabHost bho;
    private e cIQ;
    private d cXq;
    private ImageView csZ;
    private TextView dZm;
    private boolean eFi;
    private MainTabActivity gDT;
    private ImageView gDU;
    private ImageView gDV;
    private TextView gDW;
    private PopupWindow gDY;
    private Runnable gEb;
    private NavigationBar mNavigationBar;
    private boolean gDX = false;
    private int eFe = -1;
    private boolean gDZ = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.b gEa = new FragmentTabHost.b() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public void e(int i, boolean z) {
            if (c.this.bho.cB(i).mType == 8) {
                TiebaStatic.log(new ak("c10605"));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public boolean f(int i, boolean z) {
            FragmentTabHost.c cB = c.this.bho.cB(i);
            if (cB.mType == 9) {
                if (ax.aV(c.this.gDT.getPageContext().getPageActivity())) {
                    c.this.gDT.apr();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (cB.mType == 8 && !ax.aV(c.this.gDT.getActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                return true;
            }
        }
    };
    private Runnable ffU = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bho != null && c.this.gDY != null) {
                FragmentTabWidget fragmentTabWidget = c.this.bho.getFragmentTabWidget();
                int ac = l.ac(c.this.gDT.getActivity());
                int f = l.f(c.this.gDT.getActivity(), d.e.ds200);
                View contentView = c.this.gDY.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    g.showPopupWindowAsDropDown(c.this.gDY, fragmentTabWidget, (ac - contentView.getMeasuredWidth()) / 2, -f);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_new_write_tips", true);
                    c.this.gDZ = true;
                    c.this.mHandler.postDelayed(c.this.ffV, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable ffV = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.aXi();
        }
    };
    private View.OnClickListener ffW = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.byk();
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.gDT = mainTabActivity;
    }

    public void nj(boolean z) {
        this.bho = (FragmentTabHost) this.gDT.findViewById(d.g.tab_host);
        this.bho.setup(this.gDT.getSupportFragmentManager());
        this.bho.setOnTabSelectionListener(this.gEa);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bho.setShouldDrawIndicatorLine(false);
            this.bho.setShouldDrawTopLine(true);
        }
        this.bho.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bho.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.c.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.bho.getCurrentTabType() != 2) {
                    if (c.this.bho.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                c.this.byi();
                if (c.this.bho.getCurrentTabType() != c.this.bho.cB(i).mType) {
                    c.this.bho.setCurrentTab(i);
                }
                if (c.this.bho.getCurrentTabType() != 1) {
                    c.this.csZ.setVisibility(8);
                    c.this.bfM.setVisibility(0);
                }
                c.this.eFe = c.this.bho.getCurrentTabType();
                c.this.byg();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (c.this.bho.getCurrentTabType() != 3) {
                        if (c.this.bho.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (c.this.bho.getCurrentTabType() == 3) {
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
        this.gDX = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        amS();
        this.gDW = (TextView) this.gDT.findViewById(d.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.gDT.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void ts(final String str) {
        if (StringUtils.isNull(str)) {
            this.gDW.setVisibility(8);
            return;
        }
        FragmentTabHost.c cC = this.bho.cC(8);
        if (cC != null) {
            if (!this.gDZ || (this.gDY != null && this.gDY.isShowing())) {
                if (this.gEb == null) {
                    this.gEb = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.9
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.ts(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.gEb);
                TbadkCoreApplication.getInst().handler.postDelayed(this.gEb, TbConfig.NOTIFY_SOUND_INTERVAL);
                return;
            }
            a(str, cC);
            return;
        }
        this.gDW.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.c cVar) {
        int[] iArr = new int[2];
        cVar.aeI.getLocationInWindow(iArr);
        int width = l.o(this.gDT).widthPixels - (iArr[0] + (cVar.aeI.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gDW.getLayoutParams();
        layoutParams.rightMargin = width - l.f(this.gDT.getPageContext().getPageActivity(), d.e.ds26);
        this.gDW.setLayoutParams(layoutParams);
        this.gDW.setVisibility(0);
        this.gDW.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void bye() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.gDX);
    }

    public boolean byf() {
        return this.gDU != null && this.gDU.getVisibility() == 0;
    }

    public void nk(boolean z) {
        if (this.gDU != null) {
            if (z) {
                this.gDU.setVisibility(0);
            } else {
                this.gDU.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bho.setShouldDrawTopLine(false);
            } else {
                this.bho.ax(true);
            }
        }
        if (this.bho.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bho.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bho.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.gDT.getPageContext(), i);
        aj.a(this.dZm, d.C0082d.cp_cont_b, d.C0082d.s_navbar_title_color, i);
        aj.c(this.gDV, d.f.icon_news_down_bar_one);
        aj.a(this.gDU, d.f.icon_game_bg_s, d.f.icon_game_bg);
        aj.a(this.bfM, d.f.icon_search_bg_s, d.f.icon_search_bg);
        aj.a(this.csZ, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.gDT.getPageContext().getPageActivity()).inflate(d.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            aj.c(textView, d.C0082d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.Cz())) {
                textView.setText(payMemberInfoData.Cz());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                aj.c(tbImageView, d.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gDT.getPageContext().getPageActivity());
            aVar.v(inflate);
            aVar.ce(d.C0082d.cp_link_tip_d);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.tblauncher.c.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(c.this.gDT.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(c.this.gDT.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.gDT.getPageContext().getString(d.j.member_continue_pay);
            if (i == 0) {
                string = this.gDT.getPageContext().getString(d.j.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.c.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(c.this.gDT.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(c.this.gDT.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.gDT.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.ap(false);
            aVar.b(this.gDT.getPageContext()).tk();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void byg() {
        FragmentTabHost.c cC;
        if (this.bho != null && (cC = this.bho.cC(this.bho.getCurrentTabType())) != null && cC.aeK != null && cC.aeK.EZ() != null) {
            String string = this.gDT.getPageContext().getString(cC.aeK.EZ().aHD);
            if (this.dZm != null) {
                this.dZm.setText(string);
            }
        }
    }

    public void amS() {
        this.mNavigationBar = (NavigationBar) this.gDT.findViewById(d.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.dZm = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.gDT.getResources().getDimension(d.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.dZm.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.game_tip_view, (View.OnClickListener) null);
            this.gDU = (ImageView) addCustomView.findViewById(d.g.game_button_iv);
            this.gDV = (ImageView) addCustomView.findViewById(d.g.game_tip_msg_iv);
            this.gDU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.nn(false);
                    c.this.gDV.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, c.this.gDT.getPageContext()));
                    TiebaStatic.eventStat(c.this.gDT.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.f(this.gDT.getPageContext().getPageActivity(), d.e.ds16), 0);
            this.bfM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.bfM.setLayoutParams(layoutParams2);
            this.bfM.setVisibility(8);
            this.bfM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    c.this.gDT.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(c.this.gDT.getPageContext().getPageActivity())));
                    if (c.this.bho.getCurrentTabType() != 3) {
                        if (c.this.bho.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new ak("c10378").r("obj_type", i));
                }
            });
            this.csZ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.csZ.setLayoutParams(layoutParams2);
            this.csZ.setVisibility(8);
            this.csZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        c.this.gDT.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.gDT.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.gDT.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aU(c.this.gDT.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.gDT.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (c.this.eFe) {
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
                    ax.aT(c.this.gDT.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void nl(boolean z) {
        if (z) {
            this.csZ.setVisibility(0);
            this.bfM.setVisibility(8);
            return;
        }
        this.csZ.setVisibility(8);
        this.bfM.setVisibility(0);
    }

    public void nm(boolean z) {
        if (byf()) {
            if (z) {
                if (this.gDV.getVisibility() != 0) {
                    this.gDV.setVisibility(0);
                    nn(true);
                    aj.c(this.gDV, d.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            nn(false);
            this.gDV.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nn(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gDU.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.f(this.gDT.getPageContext().getPageActivity(), d.e.ds32);
            } else {
                layoutParams.rightMargin = l.f(this.gDT.getPageContext().getPageActivity(), d.e.ds20);
            }
            this.gDU.setLayoutParams(layoutParams);
        }
    }

    public void ad(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bho.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.EZ(), next.bd(this.gDT.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.bho.cz(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bho.cz(1);
        } else {
            this.bho.cz(0);
        }
        this.bho.setViewPagerScrollable(false);
    }

    public void iv(boolean z) {
        this.eFi = z;
        if (!this.eFi) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aOv() {
        return this.eFi;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, com.baidu.tbadk.mainTab.e eVar) {
        if (cVar != null && (eVar instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) eVar;
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aeJ = cVar.aHC;
            cVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.aHK);
            if (cVar.aHK == com.baidu.tbadk.mainTab.c.aHH) {
                maintabBottomIndicator.K(cVar.aHE, cVar.aHF);
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.aHE);
                maintabBottomIndicator.setText(cVar.aHD);
                maintabBottomIndicator.setAnimationResId(cVar.aHG);
            }
            eVar.dE(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            cVar2.aeI = maintabBottomIndicator;
            cVar2.aeK = bVar;
            this.bho.a(cVar2);
        }
    }

    public FragmentTabHost byh() {
        return this.bho;
    }

    public void byi() {
        if (this.bho != null) {
            if ((this.bho.getCurrentTabType() == 8 || this.bho.getCurrentTabType() == 3 || this.bho.getCurrentTabType() == 2 || this.bho.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.bho.getCurrentTabType() != 1) {
                if (this.csZ != null) {
                    this.csZ.setVisibility(8);
                }
                if (this.bfM != null && this.bho.getCurrentTabType() != 3) {
                    this.bfM.setVisibility(0);
                }
            }
        }
    }

    public void byj() {
        if (!this.gDZ) {
            this.gDZ = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_last_new_write_tips", false);
            if (!this.gDZ) {
                View inflate = LayoutInflater.from(this.gDT.getActivity()).inflate(d.h.tips_blue_center_down, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                textView.setText(d.j.maintab_write_tips);
                textView.setOnClickListener(this.ffW);
                this.gDY = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.ffU, 100L);
            }
        }
    }

    public void byk() {
        this.mHandler.removeCallbacks(this.ffU);
        this.mHandler.removeCallbacks(this.ffV);
        aXi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXi() {
        g.a(this.gDY);
    }

    public void tt(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gDT.getActivity());
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
                com.baidu.tieba.h.a.asX();
            }
        });
        aVar.b(this.gDT.getPageContext()).tk();
    }

    public void onDestroy() {
        bye();
        if (byh() != null) {
            byh().reset();
        }
        byk();
        if (this.cXq != null) {
            this.cXq.onDestroy();
        }
        if (this.cIQ != null) {
            this.cIQ.amU();
        }
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.cXq == null) {
            this.cXq = new com.baidu.tieba.d.d(this.gDT.getPageContext(), (ViewStub) this.gDT.findViewById(d.g.write_share_viewStub));
        }
        this.cXq.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.cIQ == null) {
                this.cIQ = new e(this.gDT, this.gDT.oX());
            }
            this.cIQ.g(postWriteCallBackData);
        }
    }
}
