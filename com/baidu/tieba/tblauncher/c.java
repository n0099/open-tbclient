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
    private ImageView Ue;
    private FragmentTabHost bUS;
    private e dDx;
    private d dPC;
    private ImageView dmG;
    private TextView eOs;
    private boolean fuG;
    private MainTabActivity hdq;
    private ImageView hdr;
    private ImageView hds;
    private TextView hdt;
    private PopupWindow hdv;
    private Runnable hdy;
    private NavigationBar mNavigationBar;
    private boolean hdu = false;
    private int fuC = -1;
    private boolean hdw = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.b hdx = new FragmentTabHost.b() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public void p(int i, boolean z) {
            if (c.this.bUS.fy(i).mType == 8) {
                TiebaStatic.log(new ak("c10605"));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public boolean q(int i, boolean z) {
            FragmentTabHost.c fy = c.this.bUS.fy(i);
            if (fy.mType == 9) {
                if (ax.bb(c.this.hdq.getPageContext().getPageActivity())) {
                    c.this.hdq.axI();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (fy.mType == 8 && !ax.bb(c.this.hdq.getActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                return true;
            }
        }
    };
    private Runnable fVR = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bUS != null && c.this.hdv != null) {
                FragmentTabWidget fragmentTabWidget = c.this.bUS.getFragmentTabWidget();
                int ao = l.ao(c.this.hdq.getActivity());
                int s = l.s(c.this.hdq.getActivity(), d.e.ds200);
                View contentView = c.this.hdv.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    g.showPopupWindowAsDropDown(c.this.hdv, fragmentTabWidget, (ao - contentView.getMeasuredWidth()) / 2, -s);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_new_write_tips", true);
                    c.this.hdw = true;
                    c.this.mHandler.postDelayed(c.this.fVS, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fVS = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.beP();
        }
    };
    private View.OnClickListener fVT = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bxI();
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.hdq = mainTabActivity;
    }

    public void mJ(boolean z) {
        this.bUS = (FragmentTabHost) this.hdq.findViewById(d.g.tab_host);
        this.bUS.setup(this.hdq.getSupportFragmentManager());
        this.bUS.setOnTabSelectionListener(this.hdx);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bUS.setShouldDrawIndicatorLine(false);
            this.bUS.setShouldDrawTopLine(true);
        }
        this.bUS.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bUS.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.c.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.bUS.getCurrentTabType() != 2) {
                    if (c.this.bUS.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                c.this.bxG();
                if (c.this.bUS.getCurrentTabType() != c.this.bUS.fy(i).mType) {
                    c.this.bUS.setCurrentTab(i);
                }
                if (c.this.bUS.getCurrentTabType() != 1) {
                    c.this.dmG.setVisibility(8);
                    c.this.Ue.setVisibility(0);
                }
                c.this.fuC = c.this.bUS.getCurrentTabType();
                c.this.bxE();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (c.this.bUS.getCurrentTabType() != 3) {
                        if (c.this.bUS.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (c.this.bUS.getCurrentTabType() == 3) {
                    TiebaStatic.log(new ak("view_msg").aa("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.hdu = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        avQ();
        this.hdt = (TextView) this.hdq.findViewById(d.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.hdq.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void sX(final String str) {
        if (StringUtils.isNull(str)) {
            this.hdt.setVisibility(8);
            return;
        }
        FragmentTabHost.c fz = this.bUS.fz(8);
        if (fz != null) {
            if (!this.hdw || (this.hdv != null && this.hdv.isShowing())) {
                if (this.hdy == null) {
                    this.hdy = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.9
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.sX(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.hdy);
                TbadkCoreApplication.getInst().handler.postDelayed(this.hdy, TbConfig.NOTIFY_SOUND_INTERVAL);
                return;
            }
            a(str, fz);
            return;
        }
        this.hdt.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.c cVar) {
        int[] iArr = new int[2];
        cVar.aST.getLocationInWindow(iArr);
        int width = l.o(this.hdq).widthPixels - (iArr[0] + (cVar.aST.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hdt.getLayoutParams();
        layoutParams.rightMargin = width - l.s(this.hdq.getPageContext().getPageActivity(), d.e.ds26);
        this.hdt.setLayoutParams(layoutParams);
        this.hdt.setVisibility(0);
        this.hdt.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void bxC() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.hdu);
    }

    public boolean bxD() {
        return this.hdr != null && this.hdr.getVisibility() == 0;
    }

    public void mK(boolean z) {
        if (this.hdr != null) {
            if (z) {
                this.hdr.setVisibility(0);
            } else {
                this.hdr.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bUS.setShouldDrawTopLine(false);
            } else {
                this.bUS.bg(true);
            }
        }
        if (this.bUS.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bUS.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bUS.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.hdq.getPageContext(), i);
        aj.a(this.eOs, d.C0108d.cp_cont_b, d.C0108d.s_navbar_title_color, i);
        aj.c(this.hds, d.f.icon_news_down_bar_one);
        aj.a(this.hdr, d.f.icon_game_bg_s, d.f.icon_game_bg);
        aj.a(this.Ue, d.f.icon_search_bg_s, d.f.icon_search_bg);
        aj.a(this.dmG, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.hdq.getPageContext().getPageActivity()).inflate(d.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            aj.e(textView, d.C0108d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.JT())) {
                textView.setText(payMemberInfoData.JT());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                aj.c(tbImageView, d.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hdq.getPageContext().getPageActivity());
            aVar.aO(inflate);
            aVar.fc(d.C0108d.cp_link_tip_d);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.tblauncher.c.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(c.this.hdq.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(c.this.hdq.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.hdq.getPageContext().getString(d.j.member_continue_pay);
            if (i == 0) {
                string = this.hdq.getPageContext().getString(d.j.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.c.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(c.this.hdq.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(c.this.hdq.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.hdq.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.aX(false);
            aVar.b(this.hdq.getPageContext()).AB();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void bxE() {
        FragmentTabHost.c fz;
        if (this.bUS != null && (fz = this.bUS.fz(this.bUS.getCurrentTabType())) != null && fz.aSV != null && fz.aSV.Mp() != null) {
            String string = this.hdq.getPageContext().getString(fz.aSV.Mp().bvQ);
            if (this.eOs != null) {
                this.eOs.setText(string);
            }
        }
    }

    public void avQ() {
        this.mNavigationBar = (NavigationBar) this.hdq.findViewById(d.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.eOs = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.hdq.getResources().getDimension(d.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.eOs.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.game_tip_view, (View.OnClickListener) null);
            this.hdr = (ImageView) addCustomView.findViewById(d.g.game_button_iv);
            this.hds = (ImageView) addCustomView.findViewById(d.g.game_tip_msg_iv);
            this.hdr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mN(false);
                    c.this.hds.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, c.this.hdq.getPageContext()));
                    TiebaStatic.eventStat(c.this.hdq.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.s(this.hdq.getPageContext().getPageActivity(), d.e.ds16), 0);
            this.Ue = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.Ue.setLayoutParams(layoutParams2);
            this.Ue.setVisibility(8);
            this.Ue.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    c.this.hdq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(c.this.hdq.getPageContext().getPageActivity())));
                    if (c.this.bUS.getCurrentTabType() != 3) {
                        if (c.this.bUS.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new ak("c10378").s("obj_type", i));
                }
            });
            this.dmG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.dmG.setLayoutParams(layoutParams2);
            this.dmG.setVisibility(8);
            this.dmG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        c.this.hdq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.hdq.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.hdq.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.ba(c.this.hdq.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.hdq.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (c.this.fuC) {
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
                            str = "profile";
                            break;
                    }
                    TiebaStatic.log(new ak("c10517").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
                    ax.aZ(c.this.hdq.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void mL(boolean z) {
        if (z) {
            this.dmG.setVisibility(0);
            this.Ue.setVisibility(8);
            return;
        }
        this.dmG.setVisibility(8);
        this.Ue.setVisibility(0);
    }

    public void mM(boolean z) {
        if (bxD()) {
            if (z) {
                if (this.hds.getVisibility() != 0) {
                    this.hds.setVisibility(0);
                    mN(true);
                    aj.c(this.hds, d.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            mN(false);
            this.hds.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mN(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hdr.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.s(this.hdq.getPageContext().getPageActivity(), d.e.ds32);
            } else {
                layoutParams.rightMargin = l.s(this.hdq.getPageContext().getPageActivity(), d.e.ds20);
            }
            this.hdr.setLayoutParams(layoutParams);
        }
    }

    public void af(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bUS.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Mp(), next.bj(this.hdq.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.bUS.fw(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bUS.fw(1);
        } else {
            this.bUS.fw(0);
        }
        this.bUS.setViewPagerScrollable(false);
    }

    public void jd(boolean z) {
        this.fuG = z;
        if (!this.fuG) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aVY() {
        return this.fuG;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, com.baidu.tbadk.mainTab.e eVar) {
        if (cVar != null && (eVar instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) eVar;
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aSU = cVar.bvP;
            cVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.bvX);
            if (cVar.bvX == com.baidu.tbadk.mainTab.c.bvU) {
                maintabBottomIndicator.aK(cVar.bvR, cVar.bvS);
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.bvR);
                maintabBottomIndicator.setText(cVar.bvQ);
                maintabBottomIndicator.setAnimationResId(cVar.bvT);
            }
            eVar.gz(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            cVar2.aST = maintabBottomIndicator;
            cVar2.aSV = bVar;
            this.bUS.a(cVar2);
        }
    }

    public FragmentTabHost bxF() {
        return this.bUS;
    }

    public void bxG() {
        if (this.bUS != null) {
            if ((this.bUS.getCurrentTabType() == 8 || this.bUS.getCurrentTabType() == 3 || this.bUS.getCurrentTabType() == 2 || this.bUS.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.bUS.getCurrentTabType() != 1) {
                if (this.dmG != null) {
                    this.dmG.setVisibility(8);
                }
                if (this.Ue != null && this.bUS.getCurrentTabType() != 3) {
                    this.Ue.setVisibility(0);
                }
            }
        }
    }

    public void bxH() {
        if (!this.hdw) {
            this.hdw = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_last_new_write_tips", false);
            if (!this.hdw) {
                View inflate = LayoutInflater.from(this.hdq.getActivity()).inflate(d.h.tips_blue_center_down, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                textView.setText(d.j.maintab_write_tips);
                textView.setOnClickListener(this.fVT);
                this.hdv = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.fVR, 100L);
            }
        }
    }

    public void bxI() {
        this.mHandler.removeCallbacks(this.fVR);
        this.mHandler.removeCallbacks(this.fVS);
        beP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beP() {
        g.b(this.hdv);
    }

    public void sY(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hdq.getActivity());
        aVar.cZ(str);
        aVar.a(d.j.close, new a.b() { // from class: com.baidu.tieba.tblauncher.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ak akVar = new ak("c12137");
                akVar.aa("obj_locate", "1");
                TiebaStatic.log(akVar);
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.check, new a.b() { // from class: com.baidu.tieba.tblauncher.c.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ak akVar = new ak("c12137");
                akVar.aa("obj_locate", "2");
                TiebaStatic.log(akVar);
                aVar2.dismiss();
                com.baidu.tieba.h.a.aAt();
            }
        });
        aVar.b(this.hdq.getPageContext()).AB();
    }

    public void onDestroy() {
        bxC();
        if (bxF() != null) {
            bxF().reset();
        }
        bxI();
        if (this.dPC != null) {
            this.dPC.onDestroy();
        }
        if (this.dDx != null) {
            this.dDx.avS();
        }
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dPC == null) {
            this.dPC = new com.baidu.tieba.d.d(this.hdq.getPageContext(), (NavigationBarCoverTip) this.hdq.findViewById(d.g.navigation_cover_tip));
        }
        this.dPC.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.dDx == null) {
                this.dDx = new e(this.hdq, this.hdq.wy());
            }
            this.dDx.g(postWriteCallBackData);
        }
    }
}
