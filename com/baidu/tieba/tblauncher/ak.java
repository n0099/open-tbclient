package com.baidu.tieba.tblauncher;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ak {
    private ImageView aWH;
    private FragmentTabHost aYf;
    private ImageView bMw;
    private boolean dVh;
    private TextView dms;
    private MainTabActivity fGR;
    private ImageView fGS;
    private ImageView fGT;
    private PopupWindow fGV;
    private NavigationBar mNavigationBar;
    private boolean fGU = false;
    private int dVd = -1;
    private boolean fGW = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.b fGX = new al(this);
    private Runnable fGY = new ar(this);
    private Runnable fGZ = new as(this);
    private View.OnClickListener fHa = new at(this);

    public ak(MainTabActivity mainTabActivity) {
        this.fGR = mainTabActivity;
    }

    public void lz(boolean z) {
        this.aYf = (FragmentTabHost) this.fGR.findViewById(w.h.tab_host);
        this.aYf.setup(this.fGR.getSupportFragmentManager());
        this.aYf.setOnTabSelectionListener(this.fGX);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aYf.setShouldDrawIndicatorLine(false);
            this.aYf.setShouldDrawTopLine(true);
            this.aYf.e(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds10), 0, 0);
            this.aYf.aB(true);
        }
        this.aYf.setTabWidgetViewHeight(TbadkCoreApplication.m9getInst().getMainTabBottomBarHeight());
        this.aYf.setOnPageChangeListener(new au(this));
        this.fGU = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        TV();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.fGR.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void bjX() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.fGU);
    }

    public boolean bjY() {
        return this.fGS != null && this.fGS.getVisibility() == 0;
    }

    public void lA(boolean z) {
        if (this.fGS != null) {
            if (z) {
                this.fGS.setVisibility(0);
            } else {
                this.fGS.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.aYf.setShouldDrawTopLine(false);
            } else {
                this.aYf.aA(true);
            }
        }
        if (this.aYf.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aYf.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.aYf.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.fGR.getPageContext(), i);
        com.baidu.tbadk.core.util.aq.a(this.dms, w.e.cp_cont_b, w.e.s_navbar_title_color, i);
        com.baidu.tbadk.core.util.aq.c(this.fGT, w.g.icon_news_down_bar_one);
        com.baidu.tbadk.core.util.aq.b(this.fGS, w.g.icon_game_bg_s, w.g.icon_game_bg);
        com.baidu.tbadk.core.util.aq.b(this.aWH, w.g.icon_search_bg_s, w.g.icon_search_bg);
        com.baidu.tbadk.core.util.aq.b(this.bMw, w.g.icon_sign_bg_s, w.g.icon_sign_bg);
    }

    public void a(com.baidu.tbadk.data.h hVar, int i) {
        if (hVar != null) {
            View inflate = LayoutInflater.from(this.fGR.getPageContext().getPageActivity()).inflate(w.j.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(w.h.member_icon);
            TextView textView = (TextView) inflate.findViewById(w.h.member_died_line_tip);
            boolean z = TbadkCoreApplication.m9getInst().getSkinType() == 1;
            com.baidu.tbadk.core.util.aq.c(textView, w.e.cp_cont_b, 1);
            if (!StringUtils.isNull(hVar.BH())) {
                textView.setText(hVar.BH());
            }
            if (!StringUtils.isNull(hVar.getUrl())) {
                tbImageView.c(hVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                com.baidu.tbadk.core.util.aq.c(tbImageView, w.g.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fGR.getPageContext().getPageActivity());
            aVar.v(inflate);
            aVar.bZ(w.e.cp_link_tip_d);
            aVar.b(w.l.member_i_know, new av(this, aVar, i));
            String string = this.fGR.getPageContext().getString(w.l.member_continue_pay);
            if (i == 0) {
                string = this.fGR.getPageContext().getString(w.l.open_member);
            }
            aVar.a(string, new aw(this, aVar, i));
            aVar.as(false);
            aVar.b(this.fGR.getPageContext()).tc();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void bjZ() {
        FragmentTabHost.c cy;
        if (this.aYf != null && (cy = this.aYf.cy(this.aYf.getCurrentTabType())) != null && cy.acW != null && cy.acW.Ec() != null) {
            String string = this.fGR.getPageContext().getString(cy.acW.Ec().aDW);
            if (this.dms != null) {
                this.dms.setText(string);
            }
        }
    }

    public void TV() {
        this.mNavigationBar = (NavigationBar) this.fGR.findViewById(w.h.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.dms = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.maintab_title_layout, (View.OnClickListener) null).findViewById(w.h.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.fGR.getResources().getDimension(w.f.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.dms.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.game_tip_view, (View.OnClickListener) null);
            this.fGS = (ImageView) addCustomView.findViewById(w.h.game_button_iv);
            this.fGT = (ImageView) addCustomView.findViewById(w.h.game_tip_msg_iv);
            this.fGS.setOnClickListener(new ax(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.fGR.getPageContext().getPageActivity(), w.f.ds16), 0);
            this.aWH = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_search, (View.OnClickListener) null);
            this.aWH.setLayoutParams(layoutParams2);
            this.aWH.setVisibility(8);
            this.aWH.setOnClickListener(new ay(this));
            this.bMw = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_signall, (View.OnClickListener) null);
            this.bMw.setLayoutParams(layoutParams2);
            this.bMw.setVisibility(8);
            this.bMw.setOnClickListener(new am(this));
            this.mNavigationBar.setLoginClickListener(new an(this));
            this.mNavigationBar.setRegisterClickListener(new ao(this));
        }
    }

    public void lB(boolean z) {
        if (z) {
            this.bMw.setVisibility(0);
            this.aWH.setVisibility(8);
            return;
        }
        this.bMw.setVisibility(8);
        this.aWH.setVisibility(0);
    }

    public void lC(boolean z) {
        if (bjY()) {
            if (z) {
                if (this.fGT.getVisibility() != 0) {
                    this.fGT.setVisibility(0);
                    lD(true);
                    com.baidu.tbadk.core.util.aq.c(this.fGT, w.g.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            lD(false);
            this.fGT.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lD(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fGS.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.fGR.getPageContext().getPageActivity(), w.f.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.fGR.getPageContext().getPageActivity(), w.f.ds20);
            }
            this.fGS.setLayoutParams(layoutParams);
        }
    }

    public void ad(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.aYf.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Ec(), next.aS(this.fGR.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2 && TbadkCoreApplication.m9getInst().isThemeIconCover()) {
            this.aYf.cv(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aYf.cv(1);
        } else {
            this.aYf.cv(0);
        }
        this.aYf.setViewPagerScrollable(false);
    }

    public void hx(boolean z) {
        this.dVh = z;
        if (!this.dVh) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aEt() {
        return this.dVh;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.acV = cVar.aDV;
            cVar2.mType = cVar.type;
            if (cVar.aEb == com.baidu.tbadk.mainTab.c.aDY) {
                fragmentTabIndicator.M(cVar2.mType, -((int) this.fGR.getResources().getDimension(w.f.ds12)));
            } else {
                fragmentTabIndicator.setText(cVar.aDW);
            }
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.fGR.getResources().getDimension(w.f.ds24));
                fragmentTabIndicator.setTextColorResId(w.e.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.aDX);
                fragmentTabIndicator.setContentTvTopMargin(this.fGR.getResources().getDimensionPixelSize(w.f.ds2));
            } else {
                fragmentTabIndicator.setTextSize(0, this.fGR.getResources().getDimension(w.f.fontsize32));
                fragmentTabIndicator.setTextColorResId(w.e.s_tabbar_text_color);
            }
            fragmentTabIndicator.dn(TbadkCoreApplication.m9getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.acU = fragmentTabIndicator;
            cVar2.acW = bVar;
            this.aYf.a(cVar2);
        }
    }

    public FragmentTabHost bka() {
        return this.aYf;
    }

    public void bkb() {
        if (this.aYf != null) {
            if ((this.aYf.getCurrentTabType() == 8 || this.aYf.getCurrentTabType() == 3 || this.aYf.getCurrentTabType() == 2 || this.aYf.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.aYf.getCurrentTabType() != 1) {
                if (this.bMw != null) {
                    this.bMw.setVisibility(8);
                }
                if (this.aWH != null && this.aYf.getCurrentTabType() != 3) {
                    this.aWH.setVisibility(0);
                }
            }
        }
    }

    public void qF(String str) {
        if (!this.fGW && TbadkCoreApplication.isLogin()) {
            this.fGW = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_write_tips", false);
            if (!this.fGW) {
                View inflate = LayoutInflater.from(this.fGR.getActivity()).inflate(w.j.tips_blue_center_down, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(w.h.tips);
                textView.setText(this.fGR.getResources().getString(w.l.maintab_write_tips, str));
                textView.setOnClickListener(this.fHa);
                this.fGV = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.fGY, 1000L);
            }
        }
    }

    public void bkc() {
        this.mHandler.removeCallbacks(this.fGY);
        this.mHandler.removeCallbacks(this.fGZ);
        bkd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkd() {
        com.baidu.adp.lib.g.j.a(this.fGV);
    }

    public void qG(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fGR.getActivity());
        aVar.cB(str);
        aVar.a(w.l.close, new ap(this));
        aVar.b(w.l.check, new aq(this));
        aVar.b(this.fGR.getPageContext()).tc();
    }
}
