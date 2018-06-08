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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e {
    private FragmentTabHost aoi;
    private ImageView cRR;
    private com.baidu.tieba.video.e djH;
    private f dxn;
    private boolean ffr;
    private MainTabActivity gNS;
    private TextView gNX;
    private ImageView gNY;
    private ImageView gNZ;
    private TextView gOa;
    private PopupWindow gOc;
    private Runnable gOf;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private boolean gOb = false;
    private int ffn = -1;
    private boolean gOd = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.a gOe = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.e.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void i(int i, boolean z) {
            FragmentTabHost.b cz = e.this.aoi.cz(i);
            if (cz.mType == 8) {
                TiebaStatic.log(new am("c10605"));
            } else if (cz.mType == 3) {
                TiebaStatic.log(new am("c12044").r("obj_locate", 1));
                TiebaStatic.log(new am("c12924").r("obj_locate", 1));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean j(int i, boolean z) {
            FragmentTabHost.b cz = e.this.aoi.cz(i);
            if (cz.mType == 9) {
                if (ba.aU(e.this.gNS.getPageContext().getPageActivity())) {
                    e.this.gNS.axH();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else if (cz.mType == 8 && !ba.aU(e.this.gNS.getActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                return false;
            } else {
                if (cz.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        ay.zG().a(e.this.gNS.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (cz.mType == 3 && !ba.aU(e.this.gNS.getActivity())) {
                    return false;
                } else {
                    if (cz.mType == 1) {
                        TiebaStatic.log(new am("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private Runnable fFI = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.3
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (e.this.aoi != null && e.this.gOc != null) {
                FragmentTabWidget fragmentTabWidget = e.this.aoi.getFragmentTabWidget();
                l.ah(e.this.gNS.getActivity());
                int e = l.e(e.this.gNS.getActivity(), d.e.ds178);
                View contentView = e.this.gOc.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b cA = e.this.aoi.cA(3);
                    if (cA != null && (tbFragmentTabIndicator = cA.anM) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.e(e.this.gNS.getActivity(), d.e.tbds570);
                        }
                        g.showPopupWindowAsDropDown(e.this.gOc, fragmentTabWidget, measuredWidth2, -e);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_message_tips", true);
                        e.this.gOd = true;
                        e.this.mHandler.postDelayed(e.this.fFJ, TbConfig.NOTIFY_SOUND_INTERVAL);
                    }
                }
            }
        }
    };
    private Runnable fFJ = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.4
        @Override // java.lang.Runnable
        public void run() {
            e.this.byZ();
        }
    };
    private View.OnClickListener fFK = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.byZ();
        }
    };

    public e(MainTabActivity mainTabActivity) {
        this.gNS = mainTabActivity;
    }

    public void mF(boolean z) {
        this.aoi = (FragmentTabHost) this.gNS.findViewById(d.g.tab_host);
        this.aoi.setup(this.gNS.getSupportFragmentManager());
        this.aoi.setOnTabSelectionListener(this.gOe);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aoi.setShouldDrawIndicatorLine(false);
            this.aoi.setShouldDrawTopLine(true);
        }
        this.aoi.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.aoi.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.e.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (e.this.aoi.getCurrentTabType() != 2) {
                    if (e.this.aoi.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                e.this.byY();
                if (e.this.aoi.getCurrentTabType() != e.this.aoi.cz(i).mType) {
                    e.this.aoi.setCurrentTab(i);
                }
                if (e.this.aoi.getCurrentTabType() != 1) {
                    e.this.cRR.setVisibility(8);
                    e.this.mSearchButton.setVisibility(0);
                }
                e.this.ffn = e.this.aoi.getCurrentTabType();
                e.this.byW();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (e.this.aoi.getCurrentTabType() != 3) {
                        if (e.this.aoi.getCurrentTabType() == 2) {
                            TiebaStatic.log("c10098");
                        }
                    } else {
                        TiebaStatic.log("c10149");
                    }
                }
                if (e.this.aoi.getCurrentTabType() == 3) {
                    TiebaStatic.log(new am("view_msg").ah("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.gOb = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        avi();
        this.gOa = (TextView) this.gNS.findViewById(d.g.activity_prize_my_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.gNS.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void uj(final String str) {
        if (StringUtils.isNull(str)) {
            this.gOa.setVisibility(8);
            return;
        }
        FragmentTabHost.b cA = this.aoi.cA(8);
        if (cA != null) {
            if (!this.gOd || (this.gOc != null && this.gOc.isShowing())) {
                if (this.gOf == null) {
                    this.gOf = new Runnable() { // from class: com.baidu.tieba.tblauncher.e.9
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.uj(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.gOf);
                TbadkCoreApplication.getInst().handler.postDelayed(this.gOf, TbConfig.NOTIFY_SOUND_INTERVAL);
                return;
            }
            a(str, cA);
            return;
        }
        this.gOa.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.anM.getLocationInWindow(iArr);
        int width = l.p(this.gNS).widthPixels - (iArr[0] + (bVar.anM.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gOa.getLayoutParams();
        layoutParams.rightMargin = width - l.e(this.gNS.getPageContext().getPageActivity(), d.e.ds26);
        this.gOa.setLayoutParams(layoutParams);
        this.gOa.setVisibility(0);
        this.gOa.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void byU() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.gOb);
    }

    public boolean byV() {
        return this.gNY != null && this.gNY.getVisibility() == 0;
    }

    public void mG(boolean z) {
        if (this.gNY != null) {
            if (z) {
                this.gNY.setVisibility(0);
            } else {
                this.gNY.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.aoi.setShouldDrawTopLine(false);
            } else {
                this.aoi.aF(true);
            }
        }
        if (this.aoi.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aoi.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.aoi.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.gNS.getPageContext(), i);
        al.a(this.gNX, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color, i);
        al.c(this.gNZ, d.f.icon_news_down_bar_one);
        al.a(this.gNY, d.f.icon_game_bg_s, d.f.icon_game_bg);
        al.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
        al.a(this.cRR, d.f.icon_sign_bg_s, d.f.icon_sign_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.aoi != null) {
            if (z) {
                this.aoi.xV();
            } else {
                this.aoi.xU();
            }
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.gNS.getPageContext().getPageActivity()).inflate(d.i.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(d.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            al.c(textView, d.C0141d.cp_cont_b, 1);
            if (!StringUtils.isNull(payMemberInfoData.GG())) {
                textView.setText(payMemberInfoData.GG());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                al.c(tbImageView, d.f.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gNS.getPageContext().getPageActivity());
            aVar.w(inflate);
            aVar.cd(d.C0141d.cp_link_tip_d);
            aVar.b(d.k.know, new a.b() { // from class: com.baidu.tieba.tblauncher.e.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(e.this.gNS.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(e.this.gNS.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.gNS.getPageContext().getString(d.k.member_continue_pay);
            if (i == 0) {
                string = this.gNS.getPageContext().getString(d.k.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.e.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(e.this.gNS.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(e.this.gNS.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(e.this.gNS.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            });
            aVar.av(false);
            aVar.b(this.gNS.getPageContext()).xa();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void byW() {
        FragmentTabHost.b cA;
        if (this.aoi != null && (cA = this.aoi.cA(this.aoi.getCurrentTabType())) != null && cA.anO != null && cA.anO.Jb() != null) {
            String string = this.gNS.getPageContext().getString(cA.anO.Jb().aQQ);
            if (this.gNX != null) {
                this.gNX.setText(string);
            }
        }
    }

    public void avi() {
        this.mNavigationBar = (NavigationBar) this.gNS.findViewById(d.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.gNX = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.maintab_title_layout, (View.OnClickListener) null).findViewById(d.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.gNS.getResources().getDimension(d.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.gNX.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.game_tip_view, (View.OnClickListener) null);
            this.gNY = (ImageView) addCustomView.findViewById(d.g.game_button_iv);
            this.gNZ = (ImageView) addCustomView.findViewById(d.g.game_tip_msg_iv);
            this.gNY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.mJ(false);
                    e.this.gNZ.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, e.this.gNS.getPageContext()));
                    TiebaStatic.eventStat(e.this.gNS.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.e(this.gNS.getPageContext().getPageActivity(), d.e.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    e.this.gNS.sendMessage(new CustomMessage(2015003, new IntentConfig(e.this.gNS.getPageContext().getPageActivity())));
                    if (e.this.aoi.getCurrentTabType() != 3) {
                        if (e.this.aoi.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new am("c10378").r("obj_type", i));
                }
            });
            this.cRR = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_signall, (View.OnClickListener) null);
            this.cRR.setLayoutParams(layoutParams2);
            this.cRR.setVisibility(8);
            this.cRR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        e.this.gNS.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(e.this.gNS.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.gNS.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ba.aT(e.this.gNS.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.gNS.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (e.this.ffn) {
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
                    TiebaStatic.log(new am("c10517").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
                    ba.aS(e.this.gNS.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void mH(boolean z) {
        if (z) {
            this.cRR.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.cRR.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void mI(boolean z) {
        if (byV()) {
            if (z) {
                if (this.gNZ.getVisibility() != 0) {
                    this.gNZ.setVisibility(0);
                    mJ(true);
                    al.c(this.gNZ, d.f.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            mJ(false);
            this.gNZ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mJ(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gNY.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.e(this.gNS.getPageContext().getPageActivity(), d.e.ds32);
            } else {
                layoutParams.rightMargin = l.e(this.gNS.getPageContext().getPageActivity(), d.e.ds20);
            }
            this.gNY.setLayoutParams(layoutParams);
        }
    }

    public void ah(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.aoi.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Jb(), next.bd(this.gNS.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.aoi.cx(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aoi.cx(1);
        } else {
            this.aoi.cx(0);
        }
        this.aoi.setViewPagerScrollable(false);
    }

    public void iV(boolean z) {
        this.ffr = z;
        if (!this.ffr) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aXy() {
        return this.ffr;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.anN = cVar.aQP;
            bVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.aQW);
            if (cVar.aQW == com.baidu.tbadk.mainTab.c.aQT) {
                maintabBottomIndicator.setWriteIconView(cVar.aQR, cVar.aQS);
            } else {
                maintabBottomIndicator.setIconResourceId(cVar.aQR);
                maintabBottomIndicator.setText(cVar.aQQ);
                maintabBottomIndicator.setAnimationResId(cVar.kc);
            }
            tbFragmentTabIndicator.dC(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.anM = maintabBottomIndicator;
            bVar2.anO = bVar;
            this.aoi.a(bVar2);
        }
    }

    public FragmentTabHost byX() {
        return this.aoi;
    }

    public void byY() {
        if (this.aoi != null) {
            if ((this.aoi.getCurrentTabType() == 8 || this.aoi.getCurrentTabType() == 3 || this.aoi.getCurrentTabType() == 2 || this.aoi.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.aoi.getCurrentTabType() != 1) {
                if (this.cRR != null) {
                    this.cRR.setVisibility(8);
                }
                if (this.mSearchButton != null && this.aoi.getCurrentTabType() != 3) {
                    this.mSearchButton.setVisibility(0);
                }
            }
        }
    }

    public void byZ() {
        this.mHandler.removeCallbacks(this.fFI);
        this.mHandler.removeCallbacks(this.fFJ);
        g.a(this.gOc);
    }

    public void uk(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gNS.getActivity());
        aVar.dB(str);
        aVar.a(d.k.close, new a.b() { // from class: com.baidu.tieba.tblauncher.e.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                am amVar = new am("c12137");
                amVar.ah("obj_locate", "1");
                TiebaStatic.log(amVar);
                aVar2.dismiss();
            }
        });
        aVar.b(d.k.check, new a.b() { // from class: com.baidu.tieba.tblauncher.e.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                am amVar = new am("c12137");
                amVar.ah("obj_locate", "2");
                TiebaStatic.log(amVar);
                aVar2.dismiss();
                com.baidu.tieba.i.a.aBA();
            }
        });
        aVar.b(this.gNS.getPageContext()).xa();
    }

    public void onDestroy() {
        byU();
        if (byX() != null) {
            byX().reset();
        }
        byZ();
        if (this.dxn != null) {
            this.dxn.onDestroy();
        }
        if (this.djH != null) {
            this.djH.avk();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ao.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.gNS).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dxn == null) {
            this.dxn = new f(this.gNS.getPageContext(), (NavigationBarCoverTip) this.gNS.findViewById(d.g.navigation_cover_tip));
        }
        this.dxn.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.djH == null) {
                this.djH = new com.baidu.tieba.video.e(this.gNS, this.gNS.tq());
            }
            this.djH.h(postWriteCallBackData);
        }
    }
}
