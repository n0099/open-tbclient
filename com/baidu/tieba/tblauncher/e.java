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
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e {
    private FragmentTabHost bgN;
    private ImageView cHB;
    private com.baidu.tieba.video.e cZi;
    private com.baidu.tieba.d.e dmO;
    private boolean eSS;
    private Runnable gBA;
    private MainTabActivity gBn;
    private TextView gBs;
    private ImageView gBt;
    private ImageView gBu;
    private TextView gBv;
    private PopupWindow gBx;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private boolean gBw = false;
    private int eSO = -1;
    private boolean gBy = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.a gBz = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.e.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void i(int i, boolean z) {
            FragmentTabHost.b cw = e.this.bgN.cw(i);
            if (cw.mType == 8) {
                TiebaStatic.log(new al("c10605"));
            } else if (cw.mType == 3) {
                TiebaStatic.log(new al("c12044").r("obj_locate", 1));
                TiebaStatic.log(new al("c12924").r("obj_locate", 1));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean j(int i, boolean z) {
            FragmentTabHost.b cw = e.this.bgN.cw(i);
            if (cw.mType == 9) {
                if (az.aK(e.this.gBn.getPageContext().getPageActivity())) {
                    e.this.gBn.atx();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (cw.mType == 8 && !az.aK(e.this.gBn.getActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else {
                if (cw.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ax.wg().a(e.this.gBn.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (cw.mType == 3 && !az.aK(e.this.gBn.getActivity())) {
                    return false;
                } else {
                    if (cw.mType == 1) {
                        TiebaStatic.log(new al("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private Runnable ftk = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.3
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (e.this.bgN != null && e.this.gBx != null) {
                FragmentTabWidget fragmentTabWidget = e.this.bgN.getFragmentTabWidget();
                l.af(e.this.gBn.getActivity());
                int e = l.e(e.this.gBn.getActivity(), d.e.ds178);
                View contentView = e.this.gBx.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b cx = e.this.bgN.cx(3);
                    if (cx != null && (tbFragmentTabIndicator = cx.afI) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.e(e.this.gBn.getActivity(), d.e.tbds570);
                        }
                        g.showPopupWindowAsDropDown(e.this.gBx, fragmentTabWidget, measuredWidth2, -e);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_message_tips", true);
                        e.this.gBy = true;
                        e.this.mHandler.postDelayed(e.this.ftl, TbConfig.NOTIFY_SOUND_INTERVAL);
                    }
                }
            }
        }
    };
    private Runnable ftl = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.4
        @Override // java.lang.Runnable
        public void run() {
            e.this.btY();
        }
    };
    private View.OnClickListener ftm = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            e.this.btY();
        }
    };

    public e(MainTabActivity mainTabActivity) {
        this.gBn = mainTabActivity;
    }

    public void my(boolean z) {
        this.bgN = (FragmentTabHost) this.gBn.findViewById(d.g.tab_host);
        this.bgN.setup(this.gBn.getSupportFragmentManager());
        this.bgN.setOnTabSelectionListener(this.gBz);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bgN.setShouldDrawIndicatorLine(false);
            this.bgN.setShouldDrawTopLine(true);
        }
        this.bgN.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bgN.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.e.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (e.this.bgN.getCurrentTabType() != 2) {
                    if (e.this.bgN.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                e.this.btW();
                if (e.this.bgN.getCurrentTabType() != e.this.bgN.cw(i).mType) {
                    e.this.bgN.setCurrentTab(i);
                }
                if (e.this.bgN.getCurrentTabType() != 1) {
                    e.this.cHB.setVisibility(8);
                    e.this.mSearchButton.setVisibility(0);
                }
                e.this.eSO = e.this.bgN.getCurrentTabType();
                e.this.btU();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (e.this.bgN.getCurrentTabType() != 3) {
                        if (e.this.bgN.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (e.this.bgN.getCurrentTabType() == 3) {
                    TiebaStatic.log(new al("view_msg").ac("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.gBw = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        are();
        this.gBv = (TextView) this.gBn.findViewById(d.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.gBn.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void tm(final String str) {
        if (StringUtils.isNull(str)) {
            this.gBv.setVisibility(8);
            return;
        }
        FragmentTabHost.b cx = this.bgN.cx(8);
        if (cx != null) {
            if (!this.gBy || (this.gBx != null && this.gBx.isShowing())) {
                if (this.gBA == null) {
                    this.gBA = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.tm(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.gBA);
                TbadkCoreApplication.getInst().handler.postDelayed(this.gBA, TbConfig.NOTIFY_SOUND_INTERVAL);
                return;
            }
            a(str, cx);
            return;
        }
        this.gBv.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.afI.getLocationInWindow(iArr);
        int width = l.q(this.gBn).widthPixels - (iArr[0] + (bVar.afI.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gBv.getLayoutParams();
        layoutParams.rightMargin = width - l.e(this.gBn.getPageContext().getPageActivity(), d.e.ds26);
        this.gBv.setLayoutParams(layoutParams);
        this.gBv.setVisibility(0);
        this.gBv.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void btS() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.gBw);
    }

    public boolean btT() {
        return this.gBt != null && this.gBt.getVisibility() == 0;
    }

    public void mz(boolean z) {
        if (this.gBt != null) {
            if (z) {
                this.gBt.setVisibility(0);
            } else {
                this.gBt.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bgN.setShouldDrawTopLine(false);
            } else {
                this.bgN.aB(true);
            }
        }
        if (this.bgN.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bgN.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bgN.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.gBn.getPageContext(), i);
        ak.a(this.gBs, d.C0126d.cp_cont_b, d.C0126d.s_navbar_title_color, i);
        ak.c(this.gBu, d.f.icon_news_down_bar_one);
        ak.a(this.gBt, d.f.icon_game_bg_s, d.f.icon_game_bg);
        ak.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
        ak.a(this.cHB, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.bgN != null) {
            if (z) {
                this.bgN.uy();
            } else {
                this.bgN.ux();
            }
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.gBn.getPageContext().getPageActivity()).inflate(d.i.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            ak.c(textView, d.C0126d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.Df())) {
                textView.setText(payMemberInfoData.Df());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ak.c(tbImageView, d.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gBn.getPageContext().getPageActivity());
            aVar.w(inflate);
            aVar.ca(d.C0126d.cp_link_tip_d);
            aVar.b(d.k.know, new a.b() { // from class: com.baidu.tieba.tblauncher.e.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(e.this.gBn.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(e.this.gBn.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.gBn.getPageContext().getString(d.k.member_continue_pay);
            if (i == 0) {
                string = this.gBn.getPageContext().getString(d.k.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.e.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(e.this.gBn.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(e.this.gBn.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(e.this.gBn.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.as(false);
            aVar.b(this.gBn.getPageContext()).tD();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void btU() {
        FragmentTabHost.b cx;
        if (this.bgN != null && (cx = this.bgN.cx(this.bgN.getCurrentTabType())) != null && cx.afK != null && cx.afK.Fy() != null) {
            String string = this.gBn.getPageContext().getString(cx.afK.Fy().aIn);
            if (this.gBs != null) {
                this.gBs.setText(string);
            }
        }
    }

    public void are() {
        this.mNavigationBar = (NavigationBar) this.gBn.findViewById(d.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.gBs = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.gBn.getResources().getDimension(d.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.gBs.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.game_tip_view, (View.OnClickListener) null);
            this.gBt = (ImageView) addCustomView.findViewById(d.g.game_button_iv);
            this.gBu = (ImageView) addCustomView.findViewById(d.g.game_tip_msg_iv);
            this.gBt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.mC(false);
                    e.this.gBu.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, e.this.gBn.getPageContext()));
                    TiebaStatic.eventStat(e.this.gBn.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.e(this.gBn.getPageContext().getPageActivity(), d.e.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    int i = 3;
                    e.this.gBn.sendMessage(new CustomMessage(2015003, new IntentConfig(e.this.gBn.getPageContext().getPageActivity())));
                    if (e.this.bgN.getCurrentTabType() != 3) {
                        if (e.this.bgN.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new al("c10378").r("obj_type", i));
                }
            });
            this.cHB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_signall, (View.OnClickListener) null);
            this.cHB.setLayoutParams(layoutParams2);
            this.cHB.setVisibility(8);
            this.cHB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        e.this.gBn.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(e.this.gBn.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.gBn.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    az.aJ(e.this.gBn.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(e.this.gBn.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (e.this.eSO) {
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
                    TiebaStatic.log(new al("c10517").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
                    az.aI(e.this.gBn.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void mA(boolean z) {
        if (z) {
            this.cHB.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.cHB.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void mB(boolean z) {
        if (btT()) {
            if (z) {
                if (this.gBu.getVisibility() != 0) {
                    this.gBu.setVisibility(0);
                    mC(true);
                    ak.c(this.gBu, d.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            mC(false);
            this.gBu.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mC(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gBt.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.e(this.gBn.getPageContext().getPageActivity(), d.e.ds32);
            } else {
                layoutParams.rightMargin = l.e(this.gBn.getPageContext().getPageActivity(), d.e.ds20);
            }
            this.gBt.setLayoutParams(layoutParams);
        }
    }

    public void ah(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bgN.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Fy(), next.aT(this.gBn.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.bgN.cu(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bgN.cu(1);
        } else {
            this.bgN.cu(0);
        }
        this.bgN.setViewPagerScrollable(false);
    }

    public void iO(boolean z) {
        this.eSS = z;
        if (!this.eSS) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aSC() {
        return this.eSS;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.afJ = cVar.aIm;
            bVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.aIu);
            if (cVar.aIu == com.baidu.tbadk.mainTab.c.aIr) {
                maintabBottomIndicator.setWriteIconView(cVar.aIo, cVar.aIp);
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.aIo);
                maintabBottomIndicator.setText(cVar.aIn);
                maintabBottomIndicator.setAnimationResId(cVar.aIq);
            }
            tbFragmentTabIndicator.dz(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.afI = maintabBottomIndicator;
            bVar2.afK = bVar;
            this.bgN.a(bVar2);
        }
    }

    public FragmentTabHost btV() {
        return this.bgN;
    }

    public void btW() {
        if (this.bgN != null) {
            if ((this.bgN.getCurrentTabType() == 8 || this.bgN.getCurrentTabType() == 3 || this.bgN.getCurrentTabType() == 2 || this.bgN.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.bgN.getCurrentTabType() != 1) {
                if (this.cHB != null) {
                    this.cHB.setVisibility(8);
                }
                if (this.mSearchButton != null && this.bgN.getCurrentTabType() != 3) {
                    this.mSearchButton.setVisibility(0);
                }
            }
        }
    }

    public boolean btX() {
        if (this.gBy) {
            return false;
        }
        this.gBy = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_last_message_tips", false);
        if (this.gBy) {
            return false;
        }
        View inflate = LayoutInflater.from(this.gBn.getActivity()).inflate(d.i.tips_blue_center_down, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.tips);
        textView.setText(d.k.maintab_message_tips);
        textView.setOnClickListener(this.ftm);
        this.gBx = new PopupWindow(inflate, -2, -2);
        this.mHandler.postDelayed(this.ftk, 1000L);
        return true;
    }

    public void btY() {
        this.mHandler.removeCallbacks(this.ftk);
        this.mHandler.removeCallbacks(this.ftl);
        g.a(this.gBx);
    }

    public void tn(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gBn.getActivity());
        aVar.dc(str);
        aVar.a(d.k.close, new a.b() { // from class: com.baidu.tieba.tblauncher.e.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                al alVar = new al("c12137");
                alVar.ac("obj_locate", "1");
                TiebaStatic.log(alVar);
                aVar2.dismiss();
            }
        });
        aVar.b(d.k.check, new a.b() { // from class: com.baidu.tieba.tblauncher.e.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                al alVar = new al("c12137");
                alVar.ac("obj_locate", "2");
                TiebaStatic.log(alVar);
                aVar2.dismiss();
                com.baidu.tieba.i.a.awJ();
            }
        });
        aVar.b(this.gBn.getPageContext()).tD();
    }

    public void onDestroy() {
        btS();
        if (btV() != null) {
            btV().reset();
        }
        btY();
        if (this.dmO != null) {
            this.dmO.onDestroy();
        }
        if (this.cZi != null) {
            this.cZi.arg();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || an.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.gBn).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dmO == null) {
            this.dmO = new com.baidu.tieba.d.e(this.gBn.getPageContext(), (NavigationBarCoverTip) this.gBn.findViewById(d.g.navigation_cover_tip));
        }
        this.dmO.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.cZi == null) {
                this.cZi = new com.baidu.tieba.video.e(this.gBn, this.gBn.pV());
            }
            this.cZi.h(postWriteCallBackData);
        }
    }
}
