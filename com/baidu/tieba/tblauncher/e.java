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
import com.baidu.tieba.c.f;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e {
    private ImageView cYp;
    private f dKa;
    private com.baidu.tieba.video.f dux;
    private boolean fqR;
    private MainTabActivity hbf;
    private TextView hbk;
    private ImageView hbl;
    private ImageView hbm;
    private TextView hbn;
    private PopupWindow hbp;
    private MaintabBottomIndicator hbr;
    private Runnable hbt;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private boolean hbo = false;
    private int fqN = -1;
    private boolean hbq = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.a hbs = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.e.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b cM = e.this.mTabHost.cM(i);
            if (cM.mType == 8) {
                if (e.this.hbr != null && e.this.hbr.getAnimationView() != null && e.this.hbr.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new am("c10605").w("obj_type", 1));
                } else {
                    TiebaStatic.log(new am("c10605").w("obj_type", 0));
                }
                if (e.this.hbr != null) {
                    e.this.hbr.KI();
                }
            } else if (cM.mType == 3) {
                TiebaStatic.log(new am("c12044").w("obj_locate", 1));
                TiebaStatic.log(new am("c12924").w("obj_locate", 1));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b cM = e.this.mTabHost.cM(i);
            if (cM.mType == 9) {
                if (ba.bA(e.this.hbf.getPageContext().getPageActivity())) {
                    e.this.hbf.axH();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (cM.mType == 8 && !ba.bA(e.this.hbf.getActivity())) {
                if (e.this.hbr != null) {
                    e.this.hbr.KI();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else {
                if (cM.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ay.AN().a(e.this.hbf.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (cM.mType == 3 && !ba.bA(e.this.hbf.getActivity())) {
                    return false;
                } else {
                    if (cM.mType == 1) {
                        TiebaStatic.log(new am("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private Runnable fRv = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.3
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (e.this.mTabHost != null && e.this.hbp != null) {
                FragmentTabWidget fragmentTabWidget = e.this.mTabHost.getFragmentTabWidget();
                l.aO(e.this.hbf.getActivity());
                int h = l.h(e.this.hbf.getActivity(), e.C0141e.ds178);
                View contentView = e.this.hbp.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b cN = e.this.mTabHost.cN(3);
                    if (cN != null && (tbFragmentTabIndicator = cN.aqu) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.h(e.this.hbf.getActivity(), e.C0141e.tbds570);
                        }
                        g.showPopupWindowAsDropDown(e.this.hbp, fragmentTabWidget, measuredWidth2, -h);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_message_tips", true);
                        e.this.hbq = true;
                        e.this.mHandler.postDelayed(e.this.fRw, 5000L);
                    }
                }
            }
        }
    };
    private Runnable fRw = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.4
        @Override // java.lang.Runnable
        public void run() {
            e.this.bAU();
        }
    };
    private View.OnClickListener fRx = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.bAU();
        }
    };

    public e(MainTabActivity mainTabActivity) {
        this.hbf = mainTabActivity;
    }

    public void mY(boolean z) {
        this.mTabHost = (FragmentTabHost) this.hbf.findViewById(e.g.tab_host);
        this.mTabHost.setup(this.hbf.getSupportFragmentManager());
        this.mTabHost.setOnTabSelectionListener(this.hbs);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.setShouldDrawIndicatorLine(false);
            this.mTabHost.setShouldDrawTopLine(true);
        }
        this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mTabHost.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.e.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (e.this.mTabHost.getCurrentTabType() != 2) {
                    if (e.this.mTabHost.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                e.this.bAT();
                if (e.this.mTabHost.getCurrentTabType() != e.this.mTabHost.cM(i).mType) {
                    e.this.mTabHost.setCurrentTab(i);
                }
                if (e.this.mTabHost.getCurrentTabType() != 1) {
                    e.this.cYp.setVisibility(8);
                    e.this.mSearchButton.setVisibility(0);
                }
                e.this.fqN = e.this.mTabHost.getCurrentTabType();
                e.this.bAR();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (e.this.mTabHost.getCurrentTabType() != 3) {
                        if (e.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (e.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new am("view_msg").al("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.hbo = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        atZ();
        this.hbn = (TextView) this.hbf.findViewById(e.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.hbf.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void uU(final String str) {
        if (StringUtils.isNull(str)) {
            this.hbn.setVisibility(8);
            return;
        }
        FragmentTabHost.b cN = this.mTabHost.cN(8);
        if (cN != null) {
            if (!this.hbq || (this.hbp != null && this.hbp.isShowing())) {
                if (this.hbt == null) {
                    this.hbt = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.uU(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.hbt);
                TbadkCoreApplication.getInst().handler.postDelayed(this.hbt, 5000L);
                return;
            }
            a(str, cN);
            return;
        }
        this.hbn.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.aqu.getLocationInWindow(iArr);
        int width = l.s(this.hbf).widthPixels - (iArr[0] + (bVar.aqu.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hbn.getLayoutParams();
        layoutParams.rightMargin = width - l.h(this.hbf.getPageContext().getPageActivity(), e.C0141e.ds26);
        this.hbn.setLayoutParams(layoutParams);
        this.hbn.setVisibility(0);
        this.hbn.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void bAP() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.hbo);
    }

    public boolean bAQ() {
        return this.hbl != null && this.hbl.getVisibility() == 0;
    }

    public void mZ(boolean z) {
        if (this.hbl != null) {
            if (z) {
                this.hbl.setVisibility(0);
            } else {
                this.hbl.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.mTabHost.setShouldDrawTopLine(false);
            } else {
                this.mTabHost.aP(true);
            }
        }
        if (this.mTabHost.getFragmentTabWidget() != null) {
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.mTabHost.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.hbf.getPageContext(), i);
        al.a(this.hbk, e.d.cp_cont_b, e.d.s_navbar_title_color, i);
        al.c(this.hbm, e.f.icon_news_down_bar_one);
        al.a(this.hbl, e.f.icon_game_bg_s, e.f.icon_game_bg);
        al.a(this.mSearchButton, e.f.icon_search_bg_s, e.f.icon_search_bg);
        al.a(this.cYp, e.f.icon_sign_bg_s, e.f.icon_sign_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.zg();
            } else {
                this.mTabHost.zf();
            }
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.hbf.getPageContext().getPageActivity()).inflate(e.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(e.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(e.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            al.c(textView, e.d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.Ik())) {
                textView.setText(payMemberInfoData.Ik());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                al.c(tbImageView, e.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hbf.getPageContext().getPageActivity());
            aVar.G(inflate);
            aVar.cq(e.d.cp_link_tip_d);
            aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.tblauncher.e.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(e.this.hbf.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(e.this.hbf.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.hbf.getPageContext().getString(e.j.member_continue_pay);
            if (i == 0) {
                string = this.hbf.getPageContext().getString(e.j.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.e.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(e.this.hbf.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(e.this.hbf.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(e.this.hbf.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.aF(false);
            aVar.b(this.hbf.getPageContext()).yl();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void bAR() {
        FragmentTabHost.b cN;
        if (this.mTabHost != null && (cN = this.mTabHost.cN(this.mTabHost.getCurrentTabType())) != null && cN.aqw != null && cN.aqw.KE() != null) {
            String string = this.hbf.getPageContext().getString(cN.aqw.KE().awr);
            if (this.hbk != null) {
                this.hbk.setText(string);
            }
        }
    }

    public void atZ() {
        this.mNavigationBar = (NavigationBar) this.hbf.findViewById(e.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.hbk = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.maintab_title_layout, (View.OnClickListener) null).findViewById(e.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.hbf.getResources().getDimension(e.C0141e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.hbk.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.game_tip_view, (View.OnClickListener) null);
            this.hbl = (ImageView) addCustomView.findViewById(e.g.game_button_iv);
            this.hbm = (ImageView) addCustomView.findViewById(e.g.game_tip_msg_iv);
            this.hbl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.nc(false);
                    e.this.hbm.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, e.this.hbf.getPageContext()));
                    TiebaStatic.eventStat(e.this.hbf.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.h(this.hbf.getPageContext().getPageActivity(), e.C0141e.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    e.this.hbf.sendMessage(new CustomMessage(2015003, new IntentConfig(e.this.hbf.getPageContext().getPageActivity())));
                    if (e.this.mTabHost.getCurrentTabType() != 3) {
                        if (e.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new am("c10378").w("obj_type", i));
                }
            });
            this.cYp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.cYp.setLayoutParams(layoutParams2);
            this.cYp.setVisibility(8);
            this.cYp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        e.this.hbf.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(e.this.hbf.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.hbf.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ba.bz(e.this.hbf.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.hbf.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (e.this.fqN) {
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
                    TiebaStatic.log(new am("c10517").al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
                    ba.by(e.this.hbf.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void na(boolean z) {
        if (z) {
            this.cYp.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.cYp.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void nb(boolean z) {
        if (bAQ()) {
            if (z) {
                if (this.hbm.getVisibility() != 0) {
                    this.hbm.setVisibility(0);
                    nc(true);
                    al.c(this.hbm, e.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            nc(false);
            this.hbm.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nc(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hbl.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.h(this.hbf.getPageContext().getPageActivity(), e.C0141e.ds32);
            } else {
                layoutParams.rightMargin = l.h(this.hbf.getPageContext().getPageActivity(), e.C0141e.ds20);
            }
            this.hbl.setLayoutParams(layoutParams);
        }
    }

    public void aj(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.KE(), next.bJ(this.hbf.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.mTabHost.cK(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.cK(1);
        } else {
            this.mTabHost.cK(0);
        }
        this.mTabHost.setViewPagerScrollable(false);
    }

    public void jo(boolean z) {
        this.fqR = z;
        if (!this.fqR) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aYK() {
        return this.fqR;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.aqv = cVar.aVa;
            bVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.aVg);
            if (cVar.aVg == com.baidu.tbadk.mainTab.c.aVc) {
                maintabBottomIndicator.setWriteIconView(cVar.aws, cVar.aVb);
            } else if (cVar.aVg == com.baidu.tbadk.mainTab.c.aVf) {
                maintabBottomIndicator.setIconResourceId(cVar.aws);
                maintabBottomIndicator.setText(cVar.awr);
                maintabBottomIndicator.setAnimationResId(cVar.mt);
                this.hbr = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.aws);
                maintabBottomIndicator.setText(cVar.awr);
                maintabBottomIndicator.setAnimationResId(cVar.mt);
            }
            tbFragmentTabIndicator.dQ(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.aqu = maintabBottomIndicator;
            bVar2.aqw = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    public FragmentTabHost axL() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator bAS() {
        return this.hbr;
    }

    public void bAT() {
        if (this.mTabHost != null) {
            if ((this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.mTabHost.getCurrentTabType() != 1) {
                if (this.cYp != null) {
                    this.cYp.setVisibility(8);
                }
                if (this.mSearchButton != null && this.mTabHost.getCurrentTabType() != 3) {
                    this.mSearchButton.setVisibility(0);
                }
            }
        }
    }

    public void bAU() {
        this.mHandler.removeCallbacks(this.fRv);
        this.mHandler.removeCallbacks(this.fRw);
        g.a(this.hbp);
    }

    public void uV(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hbf.getActivity());
        aVar.dT(str);
        aVar.a(e.j.close, new a.b() { // from class: com.baidu.tieba.tblauncher.e.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                am amVar = new am("c12137");
                amVar.al("obj_locate", "1");
                TiebaStatic.log(amVar);
                aVar2.dismiss();
            }
        });
        aVar.b(e.j.check, new a.b() { // from class: com.baidu.tieba.tblauncher.e.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                am amVar = new am("c12137");
                amVar.al("obj_locate", "2");
                TiebaStatic.log(amVar);
                aVar2.dismiss();
                com.baidu.tieba.i.a.aEZ();
            }
        });
        aVar.b(this.hbf.getPageContext()).yl();
    }

    public void onDestroy() {
        bAP();
        if (axL() != null) {
            axL().reset();
        }
        bAU();
        if (this.dKa != null) {
            this.dKa.onDestroy();
        }
        if (this.dux != null) {
            this.dux.ayC();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ao.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.hbf).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dKa == null) {
            this.dKa = new f(this.hbf.getPageContext(), (NavigationBarCoverTip) this.hbf.findViewById(e.g.navigation_cover_tip));
        }
        this.dKa.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.dux == null) {
                this.dux = new com.baidu.tieba.video.f(this.hbf, this.hbf.getActivityRootView());
            }
            this.dux.h(postWriteCallBackData);
        }
    }
}
