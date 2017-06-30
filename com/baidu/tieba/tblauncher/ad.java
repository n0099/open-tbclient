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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ad {
    private ImageView aYa;
    private FragmentTabHost aZL;
    private ImageView bSX;
    private TextView duo;
    private boolean edF;
    private MainTabActivity fQI;
    private ImageView fQJ;
    private ImageView fQK;
    private PopupWindow fQM;
    private NavigationBar mNavigationBar;
    private boolean fQL = false;
    private int edB = -1;
    private boolean fQN = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.b fQO = new ae(this);
    private Runnable fQP = new ak(this);
    private Runnable fQQ = new al(this);
    private View.OnClickListener fQR = new am(this);

    public ad(MainTabActivity mainTabActivity) {
        this.fQI = mainTabActivity;
    }

    public void lY(boolean z) {
        this.aZL = (FragmentTabHost) this.fQI.findViewById(w.h.tab_host);
        this.aZL.setup(this.fQI.getSupportFragmentManager());
        this.aZL.setOnTabSelectionListener(this.fQO);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aZL.setShouldDrawIndicatorLine(false);
            this.aZL.setShouldDrawTopLine(true);
            this.aZL.e(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds10), 0, 0);
            this.aZL.aC(true);
        }
        this.aZL.setTabWidgetViewHeight(TbadkCoreApplication.m9getInst().getMainTabBottomBarHeight());
        this.aZL.setOnPageChangeListener(new an(this));
        this.fQL = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_show_message_tab_tips", false);
        Vk();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.fQI.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void boj() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_show_message_tab_tips", this.fQL);
    }

    public boolean bok() {
        return this.fQJ != null && this.fQJ.getVisibility() == 0;
    }

    public void lZ(boolean z) {
        if (this.fQJ != null) {
            if (z) {
                this.fQJ.setVisibility(0);
            } else {
                this.fQJ.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.aZL.setShouldDrawTopLine(false);
            } else {
                this.aZL.aB(true);
            }
        }
        if (this.aZL.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aZL.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.aZL.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.fQI.getPageContext(), i);
        as.a(this.duo, w.e.cp_cont_b, w.e.s_navbar_title_color, i);
        as.c(this.fQK, w.g.icon_news_down_bar_one);
        as.b(this.fQJ, w.g.icon_game_bg_s, w.g.icon_game_bg);
        as.b(this.aYa, w.g.icon_search_bg_s, w.g.icon_search_bg);
        as.b(this.bSX, w.g.icon_sign_bg_s, w.g.icon_sign_bg);
    }

    public void a(com.baidu.tbadk.data.h hVar, int i) {
        if (hVar != null) {
            View inflate = LayoutInflater.from(this.fQI.getPageContext().getPageActivity()).inflate(w.j.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(w.h.member_icon);
            TextView textView = (TextView) inflate.findViewById(w.h.member_died_line_tip);
            boolean z = TbadkCoreApplication.m9getInst().getSkinType() == 1;
            as.c(textView, w.e.cp_cont_b, 1);
            if (!StringUtils.isNull(hVar.Cc())) {
                textView.setText(hVar.Cc());
            }
            if (!StringUtils.isNull(hVar.getUrl())) {
                tbImageView.c(hVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                as.c(tbImageView, w.g.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fQI.getPageContext().getPageActivity());
            aVar.v(inflate);
            aVar.bZ(w.e.cp_link_tip_d);
            aVar.b(w.l.member_i_know, new ao(this, aVar, i));
            String string = this.fQI.getPageContext().getString(w.l.member_continue_pay);
            if (i == 0) {
                string = this.fQI.getPageContext().getString(w.l.open_member);
            }
            aVar.a(string, new ap(this, aVar, i));
            aVar.at(false);
            aVar.b(this.fQI.getPageContext()).ta();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_member_deid_line", false);
        }
    }

    public void bol() {
        FragmentTabHost.c cA;
        if (this.aZL != null && (cA = this.aZL.cA(this.aZL.getCurrentTabType())) != null && cA.adG != null && cA.adG.Ez() != null) {
            String string = this.fQI.getPageContext().getString(cA.adG.Ez().aFk);
            if (this.duo != null) {
                this.duo.setText(string);
            }
        }
    }

    public void Vk() {
        this.mNavigationBar = (NavigationBar) this.fQI.findViewById(w.h.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.duo = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.maintab_title_layout, (View.OnClickListener) null).findViewById(w.h.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.fQI.getResources().getDimension(w.f.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.duo.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.game_tip_view, (View.OnClickListener) null);
            this.fQJ = (ImageView) addCustomView.findViewById(w.h.game_button_iv);
            this.fQK = (ImageView) addCustomView.findViewById(w.h.game_tip_msg_iv);
            this.fQJ.setOnClickListener(new aq(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.fQI.getPageContext().getPageActivity(), w.f.ds16), 0);
            this.aYa = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_search, (View.OnClickListener) null);
            this.aYa.setLayoutParams(layoutParams2);
            this.aYa.setVisibility(8);
            this.aYa.setOnClickListener(new ar(this));
            this.bSX = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_signall, (View.OnClickListener) null);
            this.bSX.setLayoutParams(layoutParams2);
            this.bSX.setVisibility(8);
            this.bSX.setOnClickListener(new af(this));
            this.mNavigationBar.setLoginClickListener(new ag(this));
            this.mNavigationBar.setRegisterClickListener(new ah(this));
        }
    }

    public void ma(boolean z) {
        if (z) {
            this.bSX.setVisibility(0);
            this.aYa.setVisibility(8);
            return;
        }
        this.bSX.setVisibility(8);
        this.aYa.setVisibility(0);
    }

    public void mb(boolean z) {
        if (bok()) {
            if (z) {
                if (this.fQK.getVisibility() != 0) {
                    this.fQK.setVisibility(0);
                    mc(true);
                    as.c(this.fQK, w.g.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            mc(false);
            this.fQK.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mc(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fQJ.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.fQI.getPageContext().getPageActivity(), w.f.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.fQI.getPageContext().getPageActivity(), w.f.ds20);
            }
            this.fQJ.setLayoutParams(layoutParams);
        }
    }

    public void af(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.aZL.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Ez(), next.aS(this.fQI.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2 && TbadkCoreApplication.m9getInst().isThemeIconCover()) {
            this.aZL.cx(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aZL.cx(1);
        } else {
            this.aZL.cx(0);
        }
        this.aZL.setViewPagerScrollable(false);
    }

    public void hT(boolean z) {
        this.edF = z;
        if (!this.edF) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aIl() {
        return this.edF;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.adF = cVar.aFj;
            cVar2.mType = cVar.type;
            if (cVar.aFp == com.baidu.tbadk.mainTab.c.aFm) {
                fragmentTabIndicator.M(cVar2.mType, -((int) this.fQI.getResources().getDimension(w.f.ds12)));
            } else {
                fragmentTabIndicator.setText(cVar.aFk);
            }
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.fQI.getResources().getDimension(w.f.ds24));
                fragmentTabIndicator.setTextColorResId(w.e.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.aFl);
                fragmentTabIndicator.setContentTvTopMargin(this.fQI.getResources().getDimensionPixelSize(w.f.ds2));
            } else {
                fragmentTabIndicator.setTextSize(0, this.fQI.getResources().getDimension(w.f.fontsize32));
                fragmentTabIndicator.setTextColorResId(w.e.s_tabbar_text_color);
            }
            fragmentTabIndicator.dp(TbadkCoreApplication.m9getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.adE = fragmentTabIndicator;
            cVar2.adG = bVar;
            this.aZL.a(cVar2);
        }
    }

    public FragmentTabHost bom() {
        return this.aZL;
    }

    public void bon() {
        if (this.aZL != null) {
            if ((this.aZL.getCurrentTabType() == 8 || this.aZL.getCurrentTabType() == 3 || this.aZL.getCurrentTabType() == 2 || this.aZL.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.aZL.getCurrentTabType() != 1) {
                if (this.bSX != null) {
                    this.bSX.setVisibility(8);
                }
                if (this.aYa != null && this.aZL.getCurrentTabType() != 3) {
                    this.aYa.setVisibility(0);
                }
            }
        }
    }

    public void boo() {
        if (!this.fQN) {
            this.fQN = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_maintab_last_new_write_tips", false);
            if (!this.fQN) {
                View inflate = LayoutInflater.from(this.fQI.getActivity()).inflate(w.j.tips_blue_center_down, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(w.h.tips);
                textView.setText(w.l.maintab_write_tips);
                textView.setOnClickListener(this.fQR);
                this.fQM = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.fQP, 100L);
            }
        }
    }

    public void bop() {
        this.mHandler.removeCallbacks(this.fQP);
        this.mHandler.removeCallbacks(this.fQQ);
        boq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boq() {
        com.baidu.adp.lib.g.j.a(this.fQM);
    }

    public void rD(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fQI.getActivity());
        aVar.cI(str);
        aVar.a(w.l.close, new ai(this));
        aVar.b(w.l.check, new aj(this));
        aVar.b(this.fQI.getPageContext()).ta();
    }
}
