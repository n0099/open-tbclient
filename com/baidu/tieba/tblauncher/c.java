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
    private FragmentTabHost bUK;
    private e dDc;
    private d dPh;
    private ImageView dml;
    private TextView eNX;
    private boolean fuk;
    private MainTabActivity hcW;
    private ImageView hcX;
    private ImageView hcY;
    private TextView hcZ;
    private PopupWindow hdb;
    private Runnable hde;
    private NavigationBar mNavigationBar;
    private boolean hda = false;
    private int fug = -1;
    private boolean hdc = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.b hdd = new FragmentTabHost.b() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public void p(int i, boolean z) {
            if (c.this.bUK.fy(i).mType == 8) {
                TiebaStatic.log(new ak("c10605"));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public boolean q(int i, boolean z) {
            FragmentTabHost.c fy = c.this.bUK.fy(i);
            if (fy.mType == 9) {
                if (ax.be(c.this.hcW.getPageContext().getPageActivity())) {
                    c.this.hcW.axD();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (fy.mType == 8 && !ax.be(c.this.hcW.getActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                return true;
            }
        }
    };
    private Runnable fVw = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bUK != null && c.this.hdb != null) {
                FragmentTabWidget fragmentTabWidget = c.this.bUK.getFragmentTabWidget();
                int ao = l.ao(c.this.hcW.getActivity());
                int s = l.s(c.this.hcW.getActivity(), d.e.ds200);
                View contentView = c.this.hdb.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    g.showPopupWindowAsDropDown(c.this.hdb, fragmentTabWidget, (ao - contentView.getMeasuredWidth()) / 2, -s);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_new_write_tips", true);
                    c.this.hdc = true;
                    c.this.mHandler.postDelayed(c.this.fVx, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fVx = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.beK();
        }
    };
    private View.OnClickListener fVy = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bxG();
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.hcW = mainTabActivity;
    }

    public void mH(boolean z) {
        this.bUK = (FragmentTabHost) this.hcW.findViewById(d.g.tab_host);
        this.bUK.setup(this.hcW.getSupportFragmentManager());
        this.bUK.setOnTabSelectionListener(this.hdd);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bUK.setShouldDrawIndicatorLine(false);
            this.bUK.setShouldDrawTopLine(true);
        }
        this.bUK.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bUK.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.c.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.bUK.getCurrentTabType() != 2) {
                    if (c.this.bUK.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                c.this.bxE();
                if (c.this.bUK.getCurrentTabType() != c.this.bUK.fy(i).mType) {
                    c.this.bUK.setCurrentTab(i);
                }
                if (c.this.bUK.getCurrentTabType() != 1) {
                    c.this.dml.setVisibility(8);
                    c.this.Ue.setVisibility(0);
                }
                c.this.fug = c.this.bUK.getCurrentTabType();
                c.this.bxC();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (c.this.bUK.getCurrentTabType() != 3) {
                        if (c.this.bUK.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (c.this.bUK.getCurrentTabType() == 3) {
                    TiebaStatic.log(new ak("view_msg").ab("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.hda = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        avL();
        this.hcZ = (TextView) this.hcW.findViewById(d.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.hcW.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void sQ(final String str) {
        if (StringUtils.isNull(str)) {
            this.hcZ.setVisibility(8);
            return;
        }
        FragmentTabHost.c fz = this.bUK.fz(8);
        if (fz != null) {
            if (!this.hdc || (this.hdb != null && this.hdb.isShowing())) {
                if (this.hde == null) {
                    this.hde = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.9
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.sQ(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.hde);
                TbadkCoreApplication.getInst().handler.postDelayed(this.hde, TbConfig.NOTIFY_SOUND_INTERVAL);
                return;
            }
            a(str, fz);
            return;
        }
        this.hcZ.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.c cVar) {
        int[] iArr = new int[2];
        cVar.aSQ.getLocationInWindow(iArr);
        int width = l.o(this.hcW).widthPixels - (iArr[0] + (cVar.aSQ.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hcZ.getLayoutParams();
        layoutParams.rightMargin = width - l.s(this.hcW.getPageContext().getPageActivity(), d.e.ds26);
        this.hcZ.setLayoutParams(layoutParams);
        this.hcZ.setVisibility(0);
        this.hcZ.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void bxA() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.hda);
    }

    public boolean bxB() {
        return this.hcX != null && this.hcX.getVisibility() == 0;
    }

    public void mI(boolean z) {
        if (this.hcX != null) {
            if (z) {
                this.hcX.setVisibility(0);
            } else {
                this.hcX.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bUK.setShouldDrawTopLine(false);
            } else {
                this.bUK.bf(true);
            }
        }
        if (this.bUK.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bUK.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bUK.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.hcW.getPageContext(), i);
        aj.a(this.eNX, d.C0107d.cp_cont_b, d.C0107d.s_navbar_title_color, i);
        aj.c(this.hcY, d.f.icon_news_down_bar_one);
        aj.a(this.hcX, d.f.icon_game_bg_s, d.f.icon_game_bg);
        aj.a(this.Ue, d.f.icon_search_bg_s, d.f.icon_search_bg);
        aj.a(this.dml, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.hcW.getPageContext().getPageActivity()).inflate(d.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            aj.e(textView, d.C0107d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.JR())) {
                textView.setText(payMemberInfoData.JR());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                aj.c(tbImageView, d.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hcW.getPageContext().getPageActivity());
            aVar.aO(inflate);
            aVar.fc(d.C0107d.cp_link_tip_d);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.tblauncher.c.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(c.this.hcW.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(c.this.hcW.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.hcW.getPageContext().getString(d.j.member_continue_pay);
            if (i == 0) {
                string = this.hcW.getPageContext().getString(d.j.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.c.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(c.this.hcW.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(c.this.hcW.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.hcW.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.aW(false);
            aVar.b(this.hcW.getPageContext()).AA();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void bxC() {
        FragmentTabHost.c fz;
        if (this.bUK != null && (fz = this.bUK.fz(this.bUK.getCurrentTabType())) != null && fz.aSS != null && fz.aSS.Mn() != null) {
            String string = this.hcW.getPageContext().getString(fz.aSS.Mn().bvH);
            if (this.eNX != null) {
                this.eNX.setText(string);
            }
        }
    }

    public void avL() {
        this.mNavigationBar = (NavigationBar) this.hcW.findViewById(d.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.eNX = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.hcW.getResources().getDimension(d.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.eNX.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.game_tip_view, (View.OnClickListener) null);
            this.hcX = (ImageView) addCustomView.findViewById(d.g.game_button_iv);
            this.hcY = (ImageView) addCustomView.findViewById(d.g.game_tip_msg_iv);
            this.hcX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mL(false);
                    c.this.hcY.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, c.this.hcW.getPageContext()));
                    TiebaStatic.eventStat(c.this.hcW.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.s(this.hcW.getPageContext().getPageActivity(), d.e.ds16), 0);
            this.Ue = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.Ue.setLayoutParams(layoutParams2);
            this.Ue.setVisibility(8);
            this.Ue.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    c.this.hcW.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(c.this.hcW.getPageContext().getPageActivity())));
                    if (c.this.bUK.getCurrentTabType() != 3) {
                        if (c.this.bUK.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new ak("c10378").s("obj_type", i));
                }
            });
            this.dml = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.dml.setLayoutParams(layoutParams2);
            this.dml.setVisibility(8);
            this.dml.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        c.this.hcW.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.hcW.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.hcW.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.bd(c.this.hcW.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.hcW.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (c.this.fug) {
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
                    TiebaStatic.log(new ak("c10517").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
                    ax.bc(c.this.hcW.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void mJ(boolean z) {
        if (z) {
            this.dml.setVisibility(0);
            this.Ue.setVisibility(8);
            return;
        }
        this.dml.setVisibility(8);
        this.Ue.setVisibility(0);
    }

    public void mK(boolean z) {
        if (bxB()) {
            if (z) {
                if (this.hcY.getVisibility() != 0) {
                    this.hcY.setVisibility(0);
                    mL(true);
                    aj.c(this.hcY, d.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            mL(false);
            this.hcY.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mL(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hcX.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.s(this.hcW.getPageContext().getPageActivity(), d.e.ds32);
            } else {
                layoutParams.rightMargin = l.s(this.hcW.getPageContext().getPageActivity(), d.e.ds20);
            }
            this.hcX.setLayoutParams(layoutParams);
        }
    }

    public void af(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bUK.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Mn(), next.bm(this.hcW.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.bUK.fw(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bUK.fw(1);
        } else {
            this.bUK.fw(0);
        }
        this.bUK.setViewPagerScrollable(false);
    }

    public void jb(boolean z) {
        this.fuk = z;
        if (!this.fuk) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aVT() {
        return this.fuk;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, com.baidu.tbadk.mainTab.e eVar) {
        if (cVar != null && (eVar instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) eVar;
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aSR = cVar.bvG;
            cVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.bvO);
            if (cVar.bvO == com.baidu.tbadk.mainTab.c.bvL) {
                maintabBottomIndicator.aK(cVar.bvI, cVar.bvJ);
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.bvI);
                maintabBottomIndicator.setText(cVar.bvH);
                maintabBottomIndicator.setAnimationResId(cVar.bvK);
            }
            eVar.gz(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            cVar2.aSQ = maintabBottomIndicator;
            cVar2.aSS = bVar;
            this.bUK.a(cVar2);
        }
    }

    public FragmentTabHost bxD() {
        return this.bUK;
    }

    public void bxE() {
        if (this.bUK != null) {
            if ((this.bUK.getCurrentTabType() == 8 || this.bUK.getCurrentTabType() == 3 || this.bUK.getCurrentTabType() == 2 || this.bUK.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.bUK.getCurrentTabType() != 1) {
                if (this.dml != null) {
                    this.dml.setVisibility(8);
                }
                if (this.Ue != null && this.bUK.getCurrentTabType() != 3) {
                    this.Ue.setVisibility(0);
                }
            }
        }
    }

    public void bxF() {
        if (!this.hdc) {
            this.hdc = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_last_new_write_tips", false);
            if (!this.hdc) {
                View inflate = LayoutInflater.from(this.hcW.getActivity()).inflate(d.h.tips_blue_center_down, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                textView.setText(d.j.maintab_write_tips);
                textView.setOnClickListener(this.fVy);
                this.hdb = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.fVw, 100L);
            }
        }
    }

    public void bxG() {
        this.mHandler.removeCallbacks(this.fVw);
        this.mHandler.removeCallbacks(this.fVx);
        beK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beK() {
        g.b(this.hdb);
    }

    public void sR(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hcW.getActivity());
        aVar.cZ(str);
        aVar.a(d.j.close, new a.b() { // from class: com.baidu.tieba.tblauncher.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ak akVar = new ak("c12137");
                akVar.ab("obj_locate", "1");
                TiebaStatic.log(akVar);
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.check, new a.b() { // from class: com.baidu.tieba.tblauncher.c.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ak akVar = new ak("c12137");
                akVar.ab("obj_locate", "2");
                TiebaStatic.log(akVar);
                aVar2.dismiss();
                com.baidu.tieba.h.a.aAo();
            }
        });
        aVar.b(this.hcW.getPageContext()).AA();
    }

    public void onDestroy() {
        bxA();
        if (bxD() != null) {
            bxD().reset();
        }
        bxG();
        if (this.dPh != null) {
            this.dPh.onDestroy();
        }
        if (this.dDc != null) {
            this.dDc.avN();
        }
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dPh == null) {
            this.dPh = new com.baidu.tieba.d.d(this.hcW.getPageContext(), (NavigationBarCoverTip) this.hcW.findViewById(d.g.navigation_cover_tip));
        }
        this.dPh.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.dDc == null) {
                this.dDc = new e(this.hcW, this.hcW.wx());
            }
            this.dDc.g(postWriteCallBackData);
        }
    }
}
