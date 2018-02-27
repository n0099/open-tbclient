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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.e;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private ImageView TX;
    private FragmentTabHost bWN;
    private e dGj;
    private com.baidu.tieba.d.e dSB;
    private ImageView dpl;
    private boolean fxU;
    private Runnable hfA;
    private MainTabActivity hfr;
    private TextView hfs;
    private ImageView hft;
    private ImageView hfu;
    private TextView hfv;
    private PopupWindow hfx;
    private NavigationBar mNavigationBar;
    private boolean hfw = false;
    private int fxQ = -1;
    private boolean hfy = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.b hfz = new FragmentTabHost.b() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public void u(int i, boolean z) {
            if (c.this.bWN.fy(i).mType == 8) {
                TiebaStatic.log(new ak("c10605"));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public boolean v(int i, boolean z) {
            CustomResponsedMessage runTask;
            FragmentTabHost.c fy = c.this.bWN.fy(i);
            if (fy.mType == 9) {
                if (ay.ba(c.this.hfr.getPageContext().getPageActivity())) {
                    c.this.hfr.ayF();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (fy.mType == 8 && !ay.ba(c.this.hfr.getActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (fy.mType != 15 || (runTask = MessageManager.getInstance().runTask(2911006, String.class)) == null || StringUtils.isNull((String) runTask.getData())) {
                return true;
            } else {
                aw.Dt().a(c.this.hfr.getPageContext(), new String[]{(String) runTask.getData()}, true);
                return false;
            }
        }
    };
    private Runnable fYR = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bWN != null && c.this.hfx != null) {
                FragmentTabWidget fragmentTabWidget = c.this.bWN.getFragmentTabWidget();
                int ao = l.ao(c.this.hfr.getActivity());
                int t = l.t(c.this.hfr.getActivity(), d.e.ds200);
                View contentView = c.this.hfx.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    g.showPopupWindowAsDropDown(c.this.hfx, fragmentTabWidget, (ao - contentView.getMeasuredWidth()) / 2, -t);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_new_write_tips", true);
                    c.this.hfy = true;
                    c.this.mHandler.postDelayed(c.this.fYS, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fYS = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.bgo();
        }
    };
    private View.OnClickListener fYT = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.byR();
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.hfr = mainTabActivity;
    }

    public void mR(boolean z) {
        this.bWN = (FragmentTabHost) this.hfr.findViewById(d.g.tab_host);
        this.bWN.setup(this.hfr.getSupportFragmentManager());
        this.bWN.setOnTabSelectionListener(this.hfz);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bWN.setShouldDrawIndicatorLine(false);
            this.bWN.setShouldDrawTopLine(true);
        }
        this.bWN.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bWN.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.c.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.bWN.getCurrentTabType() != 2) {
                    if (c.this.bWN.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                c.this.byP();
                if (c.this.bWN.getCurrentTabType() != c.this.bWN.fy(i).mType) {
                    c.this.bWN.setCurrentTab(i);
                }
                if (c.this.bWN.getCurrentTabType() != 1) {
                    c.this.dpl.setVisibility(8);
                    c.this.TX.setVisibility(0);
                }
                c.this.fxQ = c.this.bWN.getCurrentTabType();
                c.this.byN();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (c.this.bWN.getCurrentTabType() != 3) {
                        if (c.this.bWN.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (c.this.bWN.getCurrentTabType() == 3) {
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
        this.hfw = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        awM();
        this.hfv = (TextView) this.hfr.findViewById(d.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.hfr.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void tf(final String str) {
        if (StringUtils.isNull(str)) {
            this.hfv.setVisibility(8);
            return;
        }
        FragmentTabHost.c fz = this.bWN.fz(8);
        if (fz != null) {
            if (!this.hfy || (this.hfx != null && this.hfx.isShowing())) {
                if (this.hfA == null) {
                    this.hfA = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.9
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.tf(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.hfA);
                TbadkCoreApplication.getInst().handler.postDelayed(this.hfA, TbConfig.NOTIFY_SOUND_INTERVAL);
                return;
            }
            a(str, fz);
            return;
        }
        this.hfv.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.c cVar) {
        int[] iArr = new int[2];
        cVar.aUm.getLocationInWindow(iArr);
        int width = l.q(this.hfr).widthPixels - (iArr[0] + (cVar.aUm.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hfv.getLayoutParams();
        layoutParams.rightMargin = width - l.t(this.hfr.getPageContext().getPageActivity(), d.e.ds26);
        this.hfv.setLayoutParams(layoutParams);
        this.hfv.setVisibility(0);
        this.hfv.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void byL() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.hfw);
    }

    public boolean byM() {
        return this.hft != null && this.hft.getVisibility() == 0;
    }

    public void mS(boolean z) {
        if (this.hft != null) {
            if (z) {
                this.hft.setVisibility(0);
            } else {
                this.hft.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bWN.setShouldDrawTopLine(false);
            } else {
                this.bWN.bj(true);
            }
        }
        if (this.bWN.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bWN.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bWN.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.hfr.getPageContext(), i);
        aj.a(this.hfs, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color, i);
        aj.c(this.hfu, d.f.icon_news_down_bar_one);
        aj.a(this.hft, d.f.icon_game_bg_s, d.f.icon_game_bg);
        aj.a(this.TX, d.f.icon_search_bg_s, d.f.icon_search_bg);
        aj.a(this.dpl, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.hfr.getPageContext().getPageActivity()).inflate(d.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            aj.e(textView, d.C0141d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.Ky())) {
                textView.setText(payMemberInfoData.Ky());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                aj.c(tbImageView, d.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hfr.getPageContext().getPageActivity());
            aVar.aO(inflate);
            aVar.fc(d.C0141d.cp_link_tip_d);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.tblauncher.c.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(c.this.hfr.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(c.this.hfr.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.hfr.getPageContext().getString(d.j.member_continue_pay);
            if (i == 0) {
                string = this.hfr.getPageContext().getString(d.j.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.c.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(c.this.hfr.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(c.this.hfr.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.hfr.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.ba(false);
            aVar.b(this.hfr.getPageContext()).AU();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void byN() {
        FragmentTabHost.c fz;
        if (this.bWN != null && (fz = this.bWN.fz(this.bWN.getCurrentTabType())) != null && fz.aUo != null && fz.aUo.MU() != null) {
            String string = this.hfr.getPageContext().getString(fz.aUo.MU().bxN);
            if (this.hfs != null) {
                this.hfs.setText(string);
            }
        }
    }

    public void awM() {
        this.mNavigationBar = (NavigationBar) this.hfr.findViewById(d.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.hfs = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.hfr.getResources().getDimension(d.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.hfs.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.game_tip_view, (View.OnClickListener) null);
            this.hft = (ImageView) addCustomView.findViewById(d.g.game_button_iv);
            this.hfu = (ImageView) addCustomView.findViewById(d.g.game_tip_msg_iv);
            this.hft.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mV(false);
                    c.this.hfu.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, c.this.hfr.getPageContext()));
                    TiebaStatic.eventStat(c.this.hfr.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.t(this.hfr.getPageContext().getPageActivity(), d.e.ds16), 0);
            this.TX = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.TX.setLayoutParams(layoutParams2);
            this.TX.setVisibility(8);
            this.TX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    c.this.hfr.sendMessage(new CustomMessage(2015003, new IntentConfig(c.this.hfr.getPageContext().getPageActivity())));
                    if (c.this.bWN.getCurrentTabType() != 3) {
                        if (c.this.bWN.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new ak("c10378").s("obj_type", i));
                }
            });
            this.dpl = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.dpl.setLayoutParams(layoutParams2);
            this.dpl.setVisibility(8);
            this.dpl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        c.this.hfr.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(c.this.hfr.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.hfr.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ay.aZ(c.this.hfr.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.hfr.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (c.this.fxQ) {
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
                    ay.aY(c.this.hfr.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void mT(boolean z) {
        if (z) {
            this.dpl.setVisibility(0);
            this.TX.setVisibility(8);
            return;
        }
        this.dpl.setVisibility(8);
        this.TX.setVisibility(0);
    }

    public void mU(boolean z) {
        if (byM()) {
            if (z) {
                if (this.hfu.getVisibility() != 0) {
                    this.hfu.setVisibility(0);
                    mV(true);
                    aj.c(this.hfu, d.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            mV(false);
            this.hfu.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mV(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hft.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.t(this.hfr.getPageContext().getPageActivity(), d.e.ds32);
            } else {
                layoutParams.rightMargin = l.t(this.hfr.getPageContext().getPageActivity(), d.e.ds20);
            }
            this.hft.setLayoutParams(layoutParams);
        }
    }

    public void ag(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bWN.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.MU(), next.bi(this.hfr.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.bWN.fw(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bWN.fw(1);
        } else {
            this.bWN.fw(0);
        }
        this.bWN.setViewPagerScrollable(false);
    }

    public void jn(boolean z) {
        this.fxU = z;
        if (!this.fxU) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aXG() {
        return this.fxU;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, com.baidu.tbadk.mainTab.e eVar) {
        if (cVar != null && (eVar instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) eVar;
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aUn = cVar.bxM;
            cVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.bxU);
            if (cVar.bxU == com.baidu.tbadk.mainTab.c.bxR) {
                maintabBottomIndicator.aK(cVar.bxO, cVar.bxP);
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.bxO);
                maintabBottomIndicator.setText(cVar.bxN);
                maintabBottomIndicator.setAnimationResId(cVar.bxQ);
            }
            eVar.gB(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            cVar2.aUm = maintabBottomIndicator;
            cVar2.aUo = bVar;
            this.bWN.a(cVar2);
        }
    }

    public FragmentTabHost byO() {
        return this.bWN;
    }

    public void byP() {
        if (this.bWN != null) {
            if ((this.bWN.getCurrentTabType() == 8 || this.bWN.getCurrentTabType() == 3 || this.bWN.getCurrentTabType() == 2 || this.bWN.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.bWN.getCurrentTabType() != 1) {
                if (this.dpl != null) {
                    this.dpl.setVisibility(8);
                }
                if (this.TX != null && this.bWN.getCurrentTabType() != 3) {
                    this.TX.setVisibility(0);
                }
            }
        }
    }

    public void byQ() {
        if (!this.hfy) {
            this.hfy = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_last_new_write_tips", false);
            if (!this.hfy) {
                View inflate = LayoutInflater.from(this.hfr.getActivity()).inflate(d.h.tips_blue_center_down, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                textView.setText(d.j.maintab_write_tips);
                textView.setOnClickListener(this.fYT);
                this.hfx = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.fYR, 100L);
            }
        }
    }

    public void byR() {
        this.mHandler.removeCallbacks(this.fYR);
        this.mHandler.removeCallbacks(this.fYS);
        bgo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgo() {
        g.b(this.hfx);
    }

    public void tg(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hfr.getActivity());
        aVar.dk(str);
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
                com.baidu.tieba.h.a.aBM();
            }
        });
        aVar.b(this.hfr.getPageContext()).AU();
    }

    public void onDestroy() {
        byL();
        if (byO() != null) {
            byO().reset();
        }
        byR();
        if (this.dSB != null) {
            this.dSB.onDestroy();
        }
        if (this.dGj != null) {
            this.dGj.awO();
        }
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dSB == null) {
            this.dSB = new com.baidu.tieba.d.e(this.hfr.getPageContext(), (NavigationBarCoverTip) this.hfr.findViewById(d.g.navigation_cover_tip));
        }
        this.dSB.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.dGj == null) {
                this.dGj = new e(this.hfr, this.hfr.xl());
            }
            this.dGj.g(postWriteCallBackData);
        }
    }
}
