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
    private FragmentTabHost bWQ;
    private e dGo;
    private com.baidu.tieba.d.e dSG;
    private ImageView dpo;
    private boolean fyk;
    private MainTabActivity hfP;
    private TextView hfQ;
    private ImageView hfR;
    private ImageView hfS;
    private TextView hfT;
    private PopupWindow hfV;
    private Runnable hfY;
    private NavigationBar mNavigationBar;
    private boolean hfU = false;
    private int fyg = -1;
    private boolean hfW = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.b hfX = new FragmentTabHost.b() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public void u(int i, boolean z) {
            if (c.this.bWQ.fy(i).mType == 8) {
                TiebaStatic.log(new ak("c10605"));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public boolean v(int i, boolean z) {
            CustomResponsedMessage runTask;
            FragmentTabHost.c fy = c.this.bWQ.fy(i);
            if (fy.mType == 9) {
                if (ay.ba(c.this.hfP.getPageContext().getPageActivity())) {
                    c.this.hfP.ayH();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (fy.mType == 8 && !ay.ba(c.this.hfP.getActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (fy.mType != 15 || (runTask = MessageManager.getInstance().runTask(2911006, String.class)) == null || StringUtils.isNull((String) runTask.getData())) {
                return true;
            } else {
                aw.Du().a(c.this.hfP.getPageContext(), new String[]{(String) runTask.getData()}, true);
                return false;
            }
        }
    };
    private Runnable fZh = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bWQ != null && c.this.hfV != null) {
                FragmentTabWidget fragmentTabWidget = c.this.bWQ.getFragmentTabWidget();
                int ao = l.ao(c.this.hfP.getActivity());
                int t = l.t(c.this.hfP.getActivity(), d.e.ds200);
                View contentView = c.this.hfV.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    g.showPopupWindowAsDropDown(c.this.hfV, fragmentTabWidget, (ao - contentView.getMeasuredWidth()) / 2, -t);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_new_write_tips", true);
                    c.this.hfW = true;
                    c.this.mHandler.postDelayed(c.this.fZi, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    };
    private Runnable fZi = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.bgp();
        }
    };
    private View.OnClickListener fZj = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.byW();
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.hfP = mainTabActivity;
    }

    public void mW(boolean z) {
        this.bWQ = (FragmentTabHost) this.hfP.findViewById(d.g.tab_host);
        this.bWQ.setup(this.hfP.getSupportFragmentManager());
        this.bWQ.setOnTabSelectionListener(this.hfX);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bWQ.setShouldDrawIndicatorLine(false);
            this.bWQ.setShouldDrawTopLine(true);
        }
        this.bWQ.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bWQ.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.c.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.bWQ.getCurrentTabType() != 2) {
                    if (c.this.bWQ.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                c.this.byU();
                if (c.this.bWQ.getCurrentTabType() != c.this.bWQ.fy(i).mType) {
                    c.this.bWQ.setCurrentTab(i);
                }
                if (c.this.bWQ.getCurrentTabType() != 1) {
                    c.this.dpo.setVisibility(8);
                    c.this.TX.setVisibility(0);
                }
                c.this.fyg = c.this.bWQ.getCurrentTabType();
                c.this.byS();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (c.this.bWQ.getCurrentTabType() != 3) {
                        if (c.this.bWQ.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (c.this.bWQ.getCurrentTabType() == 3) {
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
        this.hfU = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        awO();
        this.hfT = (TextView) this.hfP.findViewById(d.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.hfP.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void tf(final String str) {
        if (StringUtils.isNull(str)) {
            this.hfT.setVisibility(8);
            return;
        }
        FragmentTabHost.c fz = this.bWQ.fz(8);
        if (fz != null) {
            if (!this.hfW || (this.hfV != null && this.hfV.isShowing())) {
                if (this.hfY == null) {
                    this.hfY = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.9
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.tf(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.hfY);
                TbadkCoreApplication.getInst().handler.postDelayed(this.hfY, TbConfig.NOTIFY_SOUND_INTERVAL);
                return;
            }
            a(str, fz);
            return;
        }
        this.hfT.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.c cVar) {
        int[] iArr = new int[2];
        cVar.aUo.getLocationInWindow(iArr);
        int width = l.q(this.hfP).widthPixels - (iArr[0] + (cVar.aUo.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hfT.getLayoutParams();
        layoutParams.rightMargin = width - l.t(this.hfP.getPageContext().getPageActivity(), d.e.ds26);
        this.hfT.setLayoutParams(layoutParams);
        this.hfT.setVisibility(0);
        this.hfT.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void byQ() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.hfU);
    }

    public boolean byR() {
        return this.hfR != null && this.hfR.getVisibility() == 0;
    }

    public void mX(boolean z) {
        if (this.hfR != null) {
            if (z) {
                this.hfR.setVisibility(0);
            } else {
                this.hfR.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bWQ.setShouldDrawTopLine(false);
            } else {
                this.bWQ.bj(true);
            }
        }
        if (this.bWQ.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bWQ.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bWQ.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.hfP.getPageContext(), i);
        aj.a(this.hfQ, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color, i);
        aj.c(this.hfS, d.f.icon_news_down_bar_one);
        aj.a(this.hfR, d.f.icon_game_bg_s, d.f.icon_game_bg);
        aj.a(this.TX, d.f.icon_search_bg_s, d.f.icon_search_bg);
        aj.a(this.dpo, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.hfP.getPageContext().getPageActivity()).inflate(d.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            aj.e(textView, d.C0141d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.Kz())) {
                textView.setText(payMemberInfoData.Kz());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                aj.c(tbImageView, d.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hfP.getPageContext().getPageActivity());
            aVar.aO(inflate);
            aVar.fc(d.C0141d.cp_link_tip_d);
            aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.tblauncher.c.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(c.this.hfP.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(c.this.hfP.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.hfP.getPageContext().getString(d.j.member_continue_pay);
            if (i == 0) {
                string = this.hfP.getPageContext().getString(d.j.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.c.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(c.this.hfP.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(c.this.hfP.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.hfP.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.ba(false);
            aVar.b(this.hfP.getPageContext()).AV();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void byS() {
        FragmentTabHost.c fz;
        if (this.bWQ != null && (fz = this.bWQ.fz(this.bWQ.getCurrentTabType())) != null && fz.aUq != null && fz.aUq.MV() != null) {
            String string = this.hfP.getPageContext().getString(fz.aUq.MV().bxQ);
            if (this.hfQ != null) {
                this.hfQ.setText(string);
            }
        }
    }

    public void awO() {
        this.mNavigationBar = (NavigationBar) this.hfP.findViewById(d.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.hfQ = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.hfP.getResources().getDimension(d.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.hfQ.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.game_tip_view, (View.OnClickListener) null);
            this.hfR = (ImageView) addCustomView.findViewById(d.g.game_button_iv);
            this.hfS = (ImageView) addCustomView.findViewById(d.g.game_tip_msg_iv);
            this.hfR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.na(false);
                    c.this.hfS.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, c.this.hfP.getPageContext()));
                    TiebaStatic.eventStat(c.this.hfP.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.t(this.hfP.getPageContext().getPageActivity(), d.e.ds16), 0);
            this.TX = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.TX.setLayoutParams(layoutParams2);
            this.TX.setVisibility(8);
            this.TX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    c.this.hfP.sendMessage(new CustomMessage(2015003, new IntentConfig(c.this.hfP.getPageContext().getPageActivity())));
                    if (c.this.bWQ.getCurrentTabType() != 3) {
                        if (c.this.bWQ.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new ak("c10378").s("obj_type", i));
                }
            });
            this.dpo = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.dpo.setLayoutParams(layoutParams2);
            this.dpo.setVisibility(8);
            this.dpo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        c.this.hfP.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(c.this.hfP.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.hfP.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ay.aZ(c.this.hfP.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.hfP.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (c.this.fyg) {
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
                    ay.aY(c.this.hfP.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void mY(boolean z) {
        if (z) {
            this.dpo.setVisibility(0);
            this.TX.setVisibility(8);
            return;
        }
        this.dpo.setVisibility(8);
        this.TX.setVisibility(0);
    }

    public void mZ(boolean z) {
        if (byR()) {
            if (z) {
                if (this.hfS.getVisibility() != 0) {
                    this.hfS.setVisibility(0);
                    na(true);
                    aj.c(this.hfS, d.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            na(false);
            this.hfS.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hfR.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.t(this.hfP.getPageContext().getPageActivity(), d.e.ds32);
            } else {
                layoutParams.rightMargin = l.t(this.hfP.getPageContext().getPageActivity(), d.e.ds20);
            }
            this.hfR.setLayoutParams(layoutParams);
        }
    }

    public void ag(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bWQ.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.MV(), next.bi(this.hfP.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.bWQ.fw(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bWQ.fw(1);
        } else {
            this.bWQ.fw(0);
        }
        this.bWQ.setViewPagerScrollable(false);
    }

    public void js(boolean z) {
        this.fyk = z;
        if (!this.fyk) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aXH() {
        return this.fyk;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, com.baidu.tbadk.mainTab.e eVar) {
        if (cVar != null && (eVar instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) eVar;
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aUp = cVar.bxP;
            cVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.bxX);
            if (cVar.bxX == com.baidu.tbadk.mainTab.c.bxU) {
                maintabBottomIndicator.aK(cVar.bxR, cVar.bxS);
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.bxR);
                maintabBottomIndicator.setText(cVar.bxQ);
                maintabBottomIndicator.setAnimationResId(cVar.bxT);
            }
            eVar.gB(TbadkCoreApplication.getInst().getSkinType());
            eVar.setTipPosType(1);
            cVar2.aUo = maintabBottomIndicator;
            cVar2.aUq = bVar;
            this.bWQ.a(cVar2);
        }
    }

    public FragmentTabHost byT() {
        return this.bWQ;
    }

    public void byU() {
        if (this.bWQ != null) {
            if ((this.bWQ.getCurrentTabType() == 8 || this.bWQ.getCurrentTabType() == 3 || this.bWQ.getCurrentTabType() == 2 || this.bWQ.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.bWQ.getCurrentTabType() != 1) {
                if (this.dpo != null) {
                    this.dpo.setVisibility(8);
                }
                if (this.TX != null && this.bWQ.getCurrentTabType() != 3) {
                    this.TX.setVisibility(0);
                }
            }
        }
    }

    public void byV() {
        if (!this.hfW) {
            this.hfW = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_last_new_write_tips", false);
            if (!this.hfW) {
                View inflate = LayoutInflater.from(this.hfP.getActivity()).inflate(d.h.tips_blue_center_down, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(d.g.tips);
                textView.setText(d.j.maintab_write_tips);
                textView.setOnClickListener(this.fZj);
                this.hfV = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.fZh, 100L);
            }
        }
    }

    public void byW() {
        this.mHandler.removeCallbacks(this.fZh);
        this.mHandler.removeCallbacks(this.fZi);
        bgp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgp() {
        g.b(this.hfV);
    }

    public void tg(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hfP.getActivity());
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
        aVar.b(this.hfP.getPageContext()).AV();
    }

    public void onDestroy() {
        byQ();
        if (byT() != null) {
            byT().reset();
        }
        byW();
        if (this.dSG != null) {
            this.dSG.onDestroy();
        }
        if (this.dGo != null) {
            this.dGo.awQ();
        }
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dSG == null) {
            this.dSG = new com.baidu.tieba.d.e(this.hfP.getPageContext(), (NavigationBarCoverTip) this.hfP.findViewById(d.g.navigation_cover_tip));
        }
        this.dSG.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.dGo == null) {
                this.dGo = new e(this.hfP, this.hfP.xl());
            }
            this.dGo.g(postWriteCallBackData);
        }
    }
}
