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
    private ImageView Ud;
    private FragmentTabHost bWZ;
    private e dGv;
    private com.baidu.tieba.d.e dSN;
    private ImageView dpx;
    private boolean fyg;
    private MainTabActivity hfG;
    private TextView hfH;
    private ImageView hfI;
    private ImageView hfJ;
    private TextView hfK;
    private PopupWindow hfM;
    private Runnable hfP;
    private NavigationBar mNavigationBar;
    private boolean hfL = false;
    private int fyc = -1;
    private boolean hfN = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.b hfO = new FragmentTabHost.b() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public void u(int i, boolean z) {
            if (c.this.bWZ.fy(i).mType == 8) {
                TiebaStatic.log(new ak("c10605"));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public boolean v(int i, boolean z) {
            CustomResponsedMessage runTask;
            FragmentTabHost.c fy = c.this.bWZ.fy(i);
            if (fy.mType == 9) {
                if (ay.ba(c.this.hfG.getPageContext().getPageActivity())) {
                    c.this.hfG.ayG();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (fy.mType == 8 && !ay.ba(c.this.hfG.getActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (fy.mType != 15 || (runTask = MessageManager.getInstance().runTask(2911006, String.class)) == null || StringUtils.isNull((String) runTask.getData())) {
                return true;
            } else {
                aw.Du().a(c.this.hfG.getPageContext(), new String[]{(String) runTask.getData()}, true);
                return false;
            }
        }
    };
    private Runnable fZc = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bWZ != null && c.this.hfM != null) {
                FragmentTabWidget fragmentTabWidget = c.this.bWZ.getFragmentTabWidget();
                int ao = l.ao(c.this.hfG.getActivity());
                int t = l.t(c.this.hfG.getActivity(), d.e.ds200);
                View contentView = c.this.hfM.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    g.showPopupWindowAsDropDown(c.this.hfM, fragmentTabWidget, (ao - contentView.getMeasuredWidth()) / 2, -t);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_new_write_tips", true);
                    c.this.hfN = true;
                    c.this.mHandler.postDelayed(c.this.fZd, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fZd = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.bgp();
        }
    };
    private View.OnClickListener fZe = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.byS();
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.hfG = mainTabActivity;
    }

    public void mR(boolean z) {
        this.bWZ = (FragmentTabHost) this.hfG.findViewById(d.g.tab_host);
        this.bWZ.setup(this.hfG.getSupportFragmentManager());
        this.bWZ.setOnTabSelectionListener(this.hfO);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bWZ.setShouldDrawIndicatorLine(false);
            this.bWZ.setShouldDrawTopLine(true);
        }
        this.bWZ.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bWZ.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.c.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.bWZ.getCurrentTabType() != 2) {
                    if (c.this.bWZ.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                c.this.byQ();
                if (c.this.bWZ.getCurrentTabType() != c.this.bWZ.fy(i).mType) {
                    c.this.bWZ.setCurrentTab(i);
                }
                if (c.this.bWZ.getCurrentTabType() != 1) {
                    c.this.dpx.setVisibility(8);
                    c.this.Ud.setVisibility(0);
                }
                c.this.fyc = c.this.bWZ.getCurrentTabType();
                c.this.byO();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (c.this.bWZ.getCurrentTabType() != 3) {
                        if (c.this.bWZ.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (c.this.bWZ.getCurrentTabType() == 3) {
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
        this.hfL = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        awN();
        this.hfK = (TextView) this.hfG.findViewById(d.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.hfG.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void tf(final String str) {
        if (StringUtils.isNull(str)) {
            this.hfK.setVisibility(8);
            return;
        }
        FragmentTabHost.c fz = this.bWZ.fz(8);
        if (fz != null) {
            if (!this.hfN || (this.hfM != null && this.hfM.isShowing())) {
                if (this.hfP == null) {
                    this.hfP = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.9
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.tf(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.hfP);
                TbadkCoreApplication.getInst().handler.postDelayed(this.hfP, TbConfig.NOTIFY_SOUND_INTERVAL);
                return;
            }
            a(str, fz);
            return;
        }
        this.hfK.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.c cVar) {
        int[] iArr = new int[2];
        cVar.aUy.getLocationInWindow(iArr);
        int width = l.q(this.hfG).widthPixels - (iArr[0] + (cVar.aUy.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hfK.getLayoutParams();
        layoutParams.rightMargin = width - l.t(this.hfG.getPageContext().getPageActivity(), d.e.ds26);
        this.hfK.setLayoutParams(layoutParams);
        this.hfK.setVisibility(0);
        this.hfK.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void byM() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.hfL);
    }

    public boolean byN() {
        return this.hfI != null && this.hfI.getVisibility() == 0;
    }

    public void mS(boolean z) {
        if (this.hfI != null) {
            if (z) {
                this.hfI.setVisibility(0);
            } else {
                this.hfI.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bWZ.setShouldDrawTopLine(false);
            } else {
                this.bWZ.bj(true);
            }
        }
        if (this.bWZ.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bWZ.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bWZ.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.hfG.getPageContext(), i);
        aj.a(this.hfH, d.C0140d.cp_cont_b, d.C0140d.s_navbar_title_color, i);
        aj.c(this.hfJ, d.f.icon_news_down_bar_one);
        aj.a(this.hfI, d.f.icon_game_bg_s, d.f.icon_game_bg);
        aj.a(this.Ud, d.f.icon_search_bg_s, d.f.icon_search_bg);
        aj.a(this.dpx, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.hfG.getPageContext().getPageActivity()).inflate(d.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            aj.e(textView, d.C0140d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.Kz())) {
                textView.setText(payMemberInfoData.Kz());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                aj.c(tbImageView, d.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hfG.getPageContext().getPageActivity());
            aVar.aO(inflate);
            aVar.fc(d.C0140d.cp_link_tip_d);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.tblauncher.c.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(c.this.hfG.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(c.this.hfG.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.hfG.getPageContext().getString(d.j.member_continue_pay);
            if (i == 0) {
                string = this.hfG.getPageContext().getString(d.j.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.c.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(c.this.hfG.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(c.this.hfG.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.hfG.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.ba(false);
            aVar.b(this.hfG.getPageContext()).AU();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void byO() {
        FragmentTabHost.c fz;
        if (this.bWZ != null && (fz = this.bWZ.fz(this.bWZ.getCurrentTabType())) != null && fz.aUA != null && fz.aUA.MV() != null) {
            String string = this.hfG.getPageContext().getString(fz.aUA.MV().bya);
            if (this.hfH != null) {
                this.hfH.setText(string);
            }
        }
    }

    public void awN() {
        this.mNavigationBar = (NavigationBar) this.hfG.findViewById(d.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.hfH = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.hfG.getResources().getDimension(d.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.hfH.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.game_tip_view, (View.OnClickListener) null);
            this.hfI = (ImageView) addCustomView.findViewById(d.g.game_button_iv);
            this.hfJ = (ImageView) addCustomView.findViewById(d.g.game_tip_msg_iv);
            this.hfI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.mV(false);
                    c.this.hfJ.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, c.this.hfG.getPageContext()));
                    TiebaStatic.eventStat(c.this.hfG.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.t(this.hfG.getPageContext().getPageActivity(), d.e.ds16), 0);
            this.Ud = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.Ud.setLayoutParams(layoutParams2);
            this.Ud.setVisibility(8);
            this.Ud.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    c.this.hfG.sendMessage(new CustomMessage(2015003, new IntentConfig(c.this.hfG.getPageContext().getPageActivity())));
                    if (c.this.bWZ.getCurrentTabType() != 3) {
                        if (c.this.bWZ.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new ak("c10378").s("obj_type", i));
                }
            });
            this.dpx = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.dpx.setLayoutParams(layoutParams2);
            this.dpx.setVisibility(8);
            this.dpx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        c.this.hfG.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(c.this.hfG.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.hfG.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ay.aZ(c.this.hfG.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.hfG.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (c.this.fyc) {
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
                    ay.aY(c.this.hfG.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void mT(boolean z) {
        if (z) {
            this.dpx.setVisibility(0);
            this.Ud.setVisibility(8);
            return;
        }
        this.dpx.setVisibility(8);
        this.Ud.setVisibility(0);
    }

    public void mU(boolean z) {
        if (byN()) {
            if (z) {
                if (this.hfJ.getVisibility() != 0) {
                    this.hfJ.setVisibility(0);
                    mV(true);
                    aj.c(this.hfJ, d.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            mV(false);
            this.hfJ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mV(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hfI.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.t(this.hfG.getPageContext().getPageActivity(), d.e.ds32);
            } else {
                layoutParams.rightMargin = l.t(this.hfG.getPageContext().getPageActivity(), d.e.ds20);
            }
            this.hfI.setLayoutParams(layoutParams);
        }
    }

    public void ag(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bWZ.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.MV(), next.bi(this.hfG.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.bWZ.fw(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bWZ.fw(1);
        } else {
            this.bWZ.fw(0);
        }
        this.bWZ.setViewPagerScrollable(false);
    }

    public void jn(boolean z) {
        this.fyg = z;
        if (!this.fyg) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aXH() {
        return this.fyg;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, com.baidu.tbadk.mainTab.e eVar) {
        if (cVar != null && (eVar instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) eVar;
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aUz = cVar.bxZ;
            cVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.byh);
            if (cVar.byh == com.baidu.tbadk.mainTab.c.bye) {
                maintabBottomIndicator.aK(cVar.byb, cVar.byc);
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.byb);
                maintabBottomIndicator.setText(cVar.bya);
                maintabBottomIndicator.setAnimationResId(cVar.byd);
            }
            eVar.gB(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            cVar2.aUy = maintabBottomIndicator;
            cVar2.aUA = bVar;
            this.bWZ.a(cVar2);
        }
    }

    public FragmentTabHost byP() {
        return this.bWZ;
    }

    public void byQ() {
        if (this.bWZ != null) {
            if ((this.bWZ.getCurrentTabType() == 8 || this.bWZ.getCurrentTabType() == 3 || this.bWZ.getCurrentTabType() == 2 || this.bWZ.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.bWZ.getCurrentTabType() != 1) {
                if (this.dpx != null) {
                    this.dpx.setVisibility(8);
                }
                if (this.Ud != null && this.bWZ.getCurrentTabType() != 3) {
                    this.Ud.setVisibility(0);
                }
            }
        }
    }

    public void byR() {
        if (!this.hfN) {
            this.hfN = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_last_new_write_tips", false);
            if (!this.hfN) {
                View inflate = LayoutInflater.from(this.hfG.getActivity()).inflate(d.h.tips_blue_center_down, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                textView.setText(d.j.maintab_write_tips);
                textView.setOnClickListener(this.fZe);
                this.hfM = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.fZc, 100L);
            }
        }
    }

    public void byS() {
        this.mHandler.removeCallbacks(this.fZc);
        this.mHandler.removeCallbacks(this.fZd);
        bgp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgp() {
        g.b(this.hfM);
    }

    public void tg(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hfG.getActivity());
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
                com.baidu.tieba.h.a.aBN();
            }
        });
        aVar.b(this.hfG.getPageContext()).AU();
    }

    public void onDestroy() {
        byM();
        if (byP() != null) {
            byP().reset();
        }
        byS();
        if (this.dSN != null) {
            this.dSN.onDestroy();
        }
        if (this.dGv != null) {
            this.dGv.awP();
        }
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dSN == null) {
            this.dSN = new com.baidu.tieba.d.e(this.hfG.getPageContext(), (NavigationBarCoverTip) this.hfG.findViewById(d.g.navigation_cover_tip));
        }
        this.dSN.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.dGv == null) {
                this.dGv = new e(this.hfG, this.hfG.xl());
            }
            this.dGv.g(postWriteCallBackData);
        }
    }
}
