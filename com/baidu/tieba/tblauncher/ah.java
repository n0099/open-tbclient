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
public class ah {
    private ImageView aZf;
    private FragmentTabHost bCH;
    private ImageView bGI;
    private boolean dPL;
    private TextView dgW;
    private MainTabActivity fyW;
    private ImageView fyX;
    private ImageView fyY;
    private PopupWindow fza;
    private NavigationBar mNavigationBar;
    private boolean fyZ = false;
    private int dPH = -1;
    private boolean fzb = false;
    private Handler mHandler = new Handler();
    private FragmentTabHost.b fzc = new ai(this);
    private Runnable fzd = new am(this);
    private Runnable fze = new an(this);
    private View.OnClickListener fzf = new ao(this);

    public ah(MainTabActivity mainTabActivity) {
        this.fyW = mainTabActivity;
    }

    public void le(boolean z) {
        this.bCH = (FragmentTabHost) this.fyW.findViewById(w.h.tab_host);
        this.bCH.setup(this.fyW.getSupportFragmentManager());
        this.bCH.setOnTabSelectionListener(this.fzc);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bCH.setShouldDrawIndicatorLine(false);
            this.bCH.setShouldDrawTopLine(true);
            this.bCH.e(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds10), 0, 0);
            this.bCH.aC(true);
        }
        this.bCH.setTabWidgetViewHeight(TbadkCoreApplication.m9getInst().getMainTabBottomBarHeight());
        this.bCH.setOnPageChangeListener(new ap(this));
        this.fyZ = com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("has_show_message_tab_tips", false);
        asC();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.fyW.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void biz() {
        com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("has_show_message_tab_tips", this.fyZ);
    }

    public boolean biA() {
        return this.fyX != null && this.fyX.getVisibility() == 0;
    }

    public void lf(boolean z) {
        if (this.fyX != null) {
            if (z) {
                this.fyX.setVisibility(0);
            } else {
                this.fyX.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bCH.setShouldDrawTopLine(false);
            } else {
                this.bCH.aB(true);
            }
        }
        if (this.bCH.getFragmentTabWidget() != null && !MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bCH.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bCH.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.fyW.getPageContext(), i);
        com.baidu.tbadk.core.util.aq.a(this.dgW, w.e.cp_cont_b, w.e.s_navbar_title_color, i);
        com.baidu.tbadk.core.util.aq.c(this.fyY, w.g.icon_news_down_bar_one);
        com.baidu.tbadk.core.util.aq.b(this.fyX, w.g.icon_game_bg_s, w.g.icon_game_bg);
        com.baidu.tbadk.core.util.aq.b(this.aZf, w.g.icon_search_bg_s, w.g.icon_search_bg);
        com.baidu.tbadk.core.util.aq.b(this.bGI, w.g.icon_sign_bg_s, w.g.icon_sign_bg);
    }

    public void a(com.baidu.tbadk.data.g gVar, int i) {
        if (gVar != null) {
            View inflate = LayoutInflater.from(this.fyW.getPageContext().getPageActivity()).inflate(w.j.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(w.h.member_icon);
            TextView textView = (TextView) inflate.findViewById(w.h.member_died_line_tip);
            boolean z = TbadkCoreApplication.m9getInst().getSkinType() == 1;
            com.baidu.tbadk.core.util.aq.c(textView, w.e.cp_cont_b, 1);
            if (!StringUtils.isNull(gVar.BO())) {
                textView.setText(gVar.BO());
            }
            if (!StringUtils.isNull(gVar.getUrl())) {
                tbImageView.c(gVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                com.baidu.tbadk.core.util.aq.c(tbImageView, w.g.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fyW.getPageContext().getPageActivity());
            aVar.v(inflate);
            aVar.bY(w.e.cp_link_tip_d);
            aVar.b(w.l.member_i_know, new aq(this, aVar, i));
            String string = this.fyW.getPageContext().getString(w.l.member_continue_pay);
            if (i == 0) {
                string = this.fyW.getPageContext().getString(w.l.open_member);
            }
            aVar.a(string, new ar(this, aVar, i));
            aVar.at(false);
            aVar.b(this.fyW.getPageContext()).td();
            com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("show_member_deid_line", false);
        }
    }

    public void biB() {
        FragmentTabHost.c cx;
        if (this.bCH != null && (cx = this.bCH.cx(this.bCH.getCurrentTabType())) != null && cx.adf != null && cx.adf.Ei() != null) {
            String string = this.fyW.getPageContext().getString(cx.adf.Ei().aEj);
            if (this.dgW != null) {
                this.dgW.setText(string);
            }
        }
    }

    public void asC() {
        this.mNavigationBar = (NavigationBar) this.fyW.findViewById(w.h.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.dgW = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.maintab_title_layout, (View.OnClickListener) null).findViewById(w.h.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.fyW.getResources().getDimension(w.f.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.dgW.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.game_tip_view, (View.OnClickListener) null);
            this.fyX = (ImageView) addCustomView.findViewById(w.h.game_button_iv);
            this.fyY = (ImageView) addCustomView.findViewById(w.h.game_tip_msg_iv);
            this.fyX.setOnClickListener(new as(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.fyW.getPageContext().getPageActivity(), w.f.ds16), 0);
            this.aZf = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_search, (View.OnClickListener) null);
            this.aZf.setLayoutParams(layoutParams2);
            this.aZf.setVisibility(8);
            this.aZf.setOnClickListener(new at(this));
            this.bGI = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_signall, (View.OnClickListener) null);
            this.bGI.setLayoutParams(layoutParams2);
            this.bGI.setVisibility(8);
            this.bGI.setOnClickListener(new aj(this));
            this.mNavigationBar.setLoginClickListener(new ak(this));
            this.mNavigationBar.setRegisterClickListener(new al(this));
        }
    }

    public void lg(boolean z) {
        if (z) {
            this.bGI.setVisibility(0);
            this.aZf.setVisibility(8);
            return;
        }
        this.bGI.setVisibility(8);
        this.aZf.setVisibility(0);
    }

    public void lh(boolean z) {
        if (biA()) {
            if (z) {
                if (this.fyY.getVisibility() != 0) {
                    this.fyY.setVisibility(0);
                    li(true);
                    com.baidu.tbadk.core.util.aq.c(this.fyY, w.g.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            li(false);
            this.fyY.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void li(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fyX.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.fyW.getPageContext().getPageActivity(), w.f.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.fyW.getPageContext().getPageActivity(), w.f.ds20);
            }
            this.fyX.setLayoutParams(layoutParams);
        }
    }

    public void ad(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bCH.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Ei(), next.aS(this.fyW.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2 && TbadkCoreApplication.m9getInst().isThemeIconCover()) {
            this.bCH.cu(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bCH.cu(1);
        } else {
            this.bCH.cu(0);
        }
        this.bCH.setViewPagerScrollable(false);
    }

    public void hk(boolean z) {
        this.dPL = z;
        if (!this.dPL) {
            com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("enter_forum_edit_mode", false);
        }
    }

    public boolean aDw() {
        return this.dPL;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.ade = cVar.aEi;
            cVar2.mType = cVar.type;
            if (cVar.aEo == com.baidu.tbadk.mainTab.c.aEl) {
                fragmentTabIndicator.N(cVar2.mType, -((int) this.fyW.getResources().getDimension(w.f.ds12)));
            } else {
                fragmentTabIndicator.setText(cVar.aEj);
            }
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.fyW.getResources().getDimension(w.f.ds24));
                fragmentTabIndicator.setTextColorResId(w.e.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.aEk);
                fragmentTabIndicator.setContentTvTopMargin(this.fyW.getResources().getDimensionPixelSize(w.f.ds2));
            } else {
                fragmentTabIndicator.setTextSize(0, this.fyW.getResources().getDimension(w.f.fontsize32));
                fragmentTabIndicator.setTextColorResId(w.e.s_tabbar_text_color);
            }
            fragmentTabIndicator.dm(TbadkCoreApplication.m9getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.adc = fragmentTabIndicator;
            cVar2.adf = bVar;
            this.bCH.a(cVar2);
        }
    }

    public FragmentTabHost biC() {
        return this.bCH;
    }

    public void biD() {
        if (this.bCH != null) {
            if ((this.bCH.getCurrentTabType() == 8 || this.bCH.getCurrentTabType() == 3 || this.bCH.getCurrentTabType() == 2 || this.bCH.getCurrentTabType() == 15) && this.mNavigationBar != null) {
                this.mNavigationBar.setVisibility(8);
            }
            if (this.bCH.getCurrentTabType() != 1) {
                if (this.bGI != null) {
                    this.bGI.setVisibility(8);
                }
                if (this.aZf != null && this.bCH.getCurrentTabType() != 3) {
                    this.aZf.setVisibility(0);
                }
            }
        }
    }

    public void qr(String str) {
        if (!this.fzb && TbadkCoreApplication.isLogin()) {
            this.fzb = com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("show_maintab_write_tips", false);
            if (!this.fzb) {
                View inflate = LayoutInflater.from(this.fyW.getActivity()).inflate(w.j.tips_blue_center_down, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(w.h.tips);
                textView.setText(this.fyW.getResources().getString(w.l.maintab_write_tips, str));
                textView.setOnClickListener(this.fzf);
                this.fza = new PopupWindow(inflate, -2, -2);
                this.mHandler.postDelayed(this.fzd, 1000L);
            }
        }
    }

    public void biE() {
        this.mHandler.removeCallbacks(this.fzd);
        this.mHandler.removeCallbacks(this.fze);
        biF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biF() {
        com.baidu.adp.lib.g.j.a(this.fza);
    }
}
