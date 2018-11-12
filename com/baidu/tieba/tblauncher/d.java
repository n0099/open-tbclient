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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.f;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class d {
    private f dDO;
    private com.baidu.tieba.c.f dTd;
    private ImageView dhK;
    private boolean fzU;
    private MainTabActivity hkh;
    private TextView hkm;
    private ImageView hkn;
    private ImageView hko;
    private TextView hkp;
    private PopupWindow hkr;
    private MaintabBottomIndicator hkt;
    private Runnable hkv;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean hkq = false;
    private int fzQ = -1;
    private boolean hks = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.a hku = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b dk = d.this.mTabHost.dk(i);
            if (dk.mType == 8) {
                if (d.this.hkt != null && d.this.hkt.getAnimationView() != null && d.this.hkt.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new am("c10605").x("obj_type", 1));
                } else {
                    TiebaStatic.log(new am("c10605").x("obj_type", 0));
                }
                if (d.this.hkt != null) {
                    d.this.hkt.MP();
                }
            } else if (dk.mType == 3) {
                TiebaStatic.log(new am("c12044").x("obj_locate", 1));
                TiebaStatic.log(new am("c12924").x("obj_locate", 1));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b dk = d.this.mTabHost.dk(i);
            if (dk.mType == 9) {
                if (ba.bG(d.this.hkh.getPageContext().getPageActivity())) {
                    d.this.hkh.aAA();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (dk.mType == 8 && !ba.bG(d.this.hkh.getActivity())) {
                if (d.this.hkt != null) {
                    d.this.hkt.MP();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else {
                if (dk.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ay.Db().a(d.this.hkh.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (dk.mType == 3 && !ba.bG(d.this.hkh.getActivity())) {
                    return false;
                } else {
                    if (dk.mType == 1) {
                        TiebaStatic.log(new am("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private Runnable dXC = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.3
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.hkr != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.aO(d.this.hkh.getActivity());
                int h = l.h(d.this.hkh.getActivity(), e.C0200e.ds178);
                View contentView = d.this.hkr.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b dl = d.this.mTabHost.dl(3);
                    if (dl != null && (tbFragmentTabIndicator = dl.avY) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.h(d.this.hkh.getActivity(), e.C0200e.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.hkr, fragmentTabWidget, measuredWidth2, -h);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_message_tips", true);
                        d.this.hks = true;
                        d.this.mHandler.postDelayed(d.this.dXD, 5000L);
                    }
                }
            }
        }
    };
    private Runnable dXD = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.4
        @Override // java.lang.Runnable
        public void run() {
            d.this.bDH();
        }
    };
    private View.OnClickListener dXE = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bDH();
        }
    };

    public d(MainTabActivity mainTabActivity) {
        this.hkh = mainTabActivity;
    }

    public void nD(boolean z) {
        this.mTabHost = (FragmentTabHost) this.hkh.findViewById(e.g.tab_host);
        this.mTabHost.setup(this.hkh.getSupportFragmentManager());
        this.mTabHost.setOnTabSelectionListener(this.hku);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.setShouldDrawIndicatorLine(false);
            this.mTabHost.setShouldDrawTopLine(true);
        }
        this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mTabHost.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.d.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (d.this.mTabHost.getCurrentTabType() != 2) {
                    if (d.this.mTabHost.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                d.this.bDG();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.dk(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.dhK.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                d.this.fzQ = d.this.mTabHost.getCurrentTabType();
                d.this.bDE();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (d.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new am("view_msg").ax("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.hkq = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        awU();
        this.hkp = (TextView) this.hkh.findViewById(e.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.hkh.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void vB(final String str) {
        if (StringUtils.isNull(str)) {
            this.hkp.setVisibility(8);
            return;
        }
        FragmentTabHost.b dl = this.mTabHost.dl(8);
        if (dl != null) {
            if (!this.hks || (this.hkr != null && this.hkr.isShowing())) {
                if (this.hkv == null) {
                    this.hkv = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.9
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.vB(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.hkv);
                TbadkCoreApplication.getInst().handler.postDelayed(this.hkv, 5000L);
                return;
            }
            a(str, dl);
            return;
        }
        this.hkp.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.avY.getLocationInWindow(iArr);
        int width = l.s(this.hkh).widthPixels - (iArr[0] + (bVar.avY.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hkp.getLayoutParams();
        layoutParams.rightMargin = width - l.h(this.hkh.getPageContext().getPageActivity(), e.C0200e.ds26);
        this.hkp.setLayoutParams(layoutParams);
        this.hkp.setVisibility(0);
        this.hkp.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void bDC() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.hkq);
    }

    public boolean bDD() {
        return this.hkn != null && this.hkn.getVisibility() == 0;
    }

    public void nE(boolean z) {
        if (this.hkn != null) {
            if (z) {
                this.hkn.setVisibility(0);
            } else {
                this.hkn.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.mTabHost.setShouldDrawTopLine(false);
            } else {
                this.mTabHost.bp(true);
            }
        }
        if (this.mTabHost.getFragmentTabWidget() != null) {
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.mTabHost.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.hkh.getPageContext(), i);
        al.a(this.hkm, e.d.cp_cont_b, e.d.s_navbar_title_color, i);
        al.c(this.hko, e.f.icon_news_down_bar_one);
        al.a(this.hkn, e.f.icon_game_bg_s, e.f.icon_game_bg);
        al.a(this.mSearchButton, e.f.icon_search_bg_s, e.f.icon_search_bg);
        al.a(this.dhK, e.f.icon_sign_bg_s, e.f.icon_sign_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.Bv();
            } else {
                this.mTabHost.Bu();
            }
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.hkh.getPageContext().getPageActivity()).inflate(e.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(e.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(e.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            al.c(textView, e.d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.Kv())) {
                textView.setText(payMemberInfoData.Kv());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                al.c(tbImageView, e.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hkh.getPageContext().getPageActivity());
            aVar.G(inflate);
            aVar.cO(e.d.cp_link_tip_d);
            aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.hkh.getPageContext().getPageActivity(), "user_overdue_know", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.hkh.getPageContext().getPageActivity(), "user_expire_know", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    }
                }
            });
            String string = this.hkh.getPageContext().getString(e.j.member_continue_pay);
            if (i == 0) {
                string = this.hkh.getPageContext().getString(e.j.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.hkh.getPageContext().getPageActivity(), "user_overdue_pay", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.hkh.getPageContext().getPageActivity(), "user_expire_pay", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.hkh.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.bf(false);
            aVar.b(this.hkh.getPageContext()).AB();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void bDE() {
        FragmentTabHost.b dl;
        if (this.mTabHost != null && (dl = this.mTabHost.dl(this.mTabHost.getCurrentTabType())) != null && dl.awa != null && dl.awa.ML() != null) {
            String string = this.hkh.getPageContext().getString(dl.awa.ML().aBR);
            if (this.hkm != null) {
                this.hkm.setText(string);
            }
        }
    }

    public void awU() {
        this.mNavigationBar = (NavigationBar) this.hkh.findViewById(e.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.hkm = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.maintab_title_layout, (View.OnClickListener) null).findViewById(e.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.hkh.getResources().getDimension(e.C0200e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.hkm.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.game_tip_view, (View.OnClickListener) null);
            this.hkn = (ImageView) addCustomView.findViewById(e.g.game_button_iv);
            this.hko = (ImageView) addCustomView.findViewById(e.g.game_tip_msg_iv);
            this.hkn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.nH(false);
                    d.this.hko.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, d.this.hkh.getPageContext()));
                    TiebaStatic.eventStat(d.this.hkh.getPageContext().getPageActivity(), "tb_gamecenter", AiAppsUBCStatistic.TYPE_CLICK, 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.h(this.hkh.getPageContext().getPageActivity(), e.C0200e.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.hkh.sendMessage(new CustomMessage(2015003, new IntentConfig(d.this.hkh.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new am("c10378").x("obj_type", i));
                }
            });
            this.dhK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.dhK.setLayoutParams(layoutParams2);
            this.dhK.setVisibility(8);
            this.dhK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.hkh.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(d.this.hkh.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.hkh.getPageContext().getPageActivity(), "notlogin_4", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    ba.bF(d.this.hkh.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.hkh.getPageContext().getPageActivity(), "notlogin_3", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    String str = "";
                    switch (d.this.fzQ) {
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
                    TiebaStatic.log(new am("c10517").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
                    ba.bE(d.this.hkh.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void nF(boolean z) {
        if (z) {
            this.dhK.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.dhK.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void nG(boolean z) {
        if (bDD()) {
            if (z) {
                if (this.hko.getVisibility() != 0) {
                    this.hko.setVisibility(0);
                    nH(true);
                    al.c(this.hko, e.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            nH(false);
            this.hko.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nH(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hkn.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.h(this.hkh.getPageContext().getPageActivity(), e.C0200e.ds32);
            } else {
                layoutParams.rightMargin = l.h(this.hkh.getPageContext().getPageActivity(), e.C0200e.ds20);
            }
            this.hkn.setLayoutParams(layoutParams);
        }
    }

    public void ai(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.ML(), next.bO(this.hkh.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.mTabHost.di(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.di(1);
        } else {
            this.mTabHost.di(0);
        }
        this.mTabHost.setViewPagerScrollable(false);
    }

    public void jQ(boolean z) {
        this.fzU = z;
        if (!this.fzU) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean bbv() {
        return this.fzU;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.avZ = cVar.bam;
            bVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.bat);
            if (cVar.bat == com.baidu.tbadk.mainTab.c.bao) {
                maintabBottomIndicator.setWriteIconView(cVar.aBS, cVar.ban);
            } else if (cVar.bat == com.baidu.tbadk.mainTab.c.bas) {
                maintabBottomIndicator.setIconResourceId(cVar.aBS);
                maintabBottomIndicator.setText(cVar.aBR);
                maintabBottomIndicator.setAnimationResId(cVar.nk);
                this.hkt = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.aBS);
                maintabBottomIndicator.setText(cVar.aBR);
                maintabBottomIndicator.setAnimationResId(cVar.nk);
            }
            tbFragmentTabIndicator.eo(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.avY = maintabBottomIndicator;
            bVar2.awa = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    public FragmentTabHost aAE() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator bDF() {
        return this.hkt;
    }

    public void bDG() {
        if (this.mTabHost != null) {
            if ((this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.mTabHost.getCurrentTabType() != 1) {
                if (this.dhK != null) {
                    this.dhK.setVisibility(8);
                }
                if (this.mSearchButton != null && this.mTabHost.getCurrentTabType() != 3) {
                    this.mSearchButton.setVisibility(0);
                }
            }
        }
    }

    public void bDH() {
        this.mHandler.removeCallbacks(this.dXC);
        this.mHandler.removeCallbacks(this.dXD);
        g.a(this.hkr);
    }

    public void vC(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hkh.getActivity());
        aVar.ej(str);
        aVar.a(e.j.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                am amVar = new am("c12137");
                amVar.ax("obj_locate", "1");
                TiebaStatic.log(amVar);
                aVar2.dismiss();
            }
        });
        aVar.b(e.j.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                am amVar = new am("c12137");
                amVar.ax("obj_locate", "2");
                TiebaStatic.log(amVar);
                aVar2.dismiss();
                com.baidu.tieba.i.a.aHP();
            }
        });
        aVar.b(this.hkh.getPageContext()).AB();
    }

    public void onDestroy() {
        bDC();
        if (aAE() != null) {
            aAE().reset();
        }
        bDH();
        if (this.dTd != null) {
            this.dTd.onDestroy();
        }
        if (this.dDO != null) {
            this.dDO.aBt();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ao.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.hkh).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dTd == null) {
            this.dTd = new com.baidu.tieba.c.f(this.hkh.getPageContext(), (NavigationBarCoverTip) this.hkh.findViewById(e.g.navigation_cover_tip));
        }
        this.dTd.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.dDO == null) {
                this.dDO = new f(this.hkh, this.hkh.getActivityRootView());
            }
            this.dDO.h(postWriteCallBackData);
        }
    }
}
