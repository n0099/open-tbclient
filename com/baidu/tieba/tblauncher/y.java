package com.baidu.tieba.tblauncher;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class y {
    private FragmentTabHost aTI;
    private boolean cEC;
    private MainTabActivity eaS;
    private TextView eaT;
    private ImageView eaU;
    private ViewGroup eaV;
    private ImageView eaW;
    private ImageView eaX;
    private ImageView eaY;
    private ImageView eaZ;
    private PluginErrorTipView eba;
    private NavigationBar ebb;
    private View ebc;
    private NavigationBar mNavigationBar;
    private int cEz = -1;
    private FragmentTabHost.b ebd = new z(this);

    public y(MainTabActivity mainTabActivity) {
        this.eaS = mainTabActivity;
    }

    public void hZ(boolean z) {
        this.aTI = (FragmentTabHost) this.eaS.findViewById(t.g.tab_host);
        this.aTI.setup(this.eaS.getSupportFragmentManager());
        this.aTI.setOnTabSelectionListener(this.ebd);
        this.aTI.setFrameLayerClickListener(new ae(this));
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aTI.setShouldDrawIndicatorLine(false);
            int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds10);
            this.aTI.f(0, dimensionPixelSize, 0, dimensionPixelSize);
        }
        this.aTI.setTabWidgetBackgroundRes(t.f.s_tabbar_bg);
        this.aTI.setOnPageChangeListener(new af(this));
        SG();
        this.eba = (PluginErrorTipView) this.eaS.findViewById(t.g.view_plugin_error_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.eaS.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void ia(boolean z) {
        if (this.eba != null && (this.eba.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            if (z && UtilHelper.canUseStyleImmersiveSticky()) {
                ((ViewGroup.MarginLayoutParams) this.eba.getLayoutParams()).setMargins(0, UtilHelper.getStatusBarHeight(), 0, 0);
                this.eba.requestLayout();
                return;
            }
            ((ViewGroup.MarginLayoutParams) this.eba.getLayoutParams()).setMargins(0, 0, 0, 0);
            this.eba.requestLayout();
        }
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public boolean aOk() {
        return this.eaX != null && this.eaX.getVisibility() == 0;
    }

    public void ib(boolean z) {
        if (this.eaX != null) {
            if (z) {
                this.eaX.setVisibility(0);
            } else {
                this.eaX.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.aTI.onChangeSkinType(i);
        this.aTI.getFragmentTabWidget().setBackgroundDrawable(new BitmapDrawable(ar.cQ(t.f.s_tabbar_bg)));
        this.mNavigationBar.onChangeSkinType(this.eaS.getPageContext(), i);
        this.eba.onChangeSkinType(this.eaS.getPageContext(), i);
        if (this.ebb != null) {
            this.ebb.onChangeSkinType(this.eaS.getPageContext(), i);
        }
        ar.j((View) this.eaT, t.d.s_navbar_title_color);
        ar.c(this.eaY, t.f.icon_news_down_bar_one);
        ar.a(this.eaX, t.f.icon_game_bg_s, t.f.icon_game_bg);
        ar.a(this.eaZ, t.f.icon_search_bg_s, t.f.icon_search_bg);
        ar.a(this.eaU, t.f.icon_sign_bg_s, t.f.icon_sign_bg);
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            this.eaW.setImageResource(t.f.s_icon_guanggao);
        } else {
            ar.c(this.eaW, t.f.icon_guanggao_off);
        }
    }

    public void a(com.baidu.tbadk.data.e eVar, int i) {
        if (eVar != null) {
            View inflate = LayoutInflater.from(this.eaS.getPageContext().getPageActivity()).inflate(t.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(t.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(t.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
            ar.b(textView, t.d.cp_cont_b, 1);
            if (!StringUtils.isNull(eVar.Cb())) {
                textView.setText(eVar.Cb());
            }
            if (!StringUtils.isNull(eVar.getUrl())) {
                tbImageView.d(eVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ar.c(tbImageView, t.f.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eaS.getPageContext().getPageActivity());
            aVar.z(inflate);
            aVar.bZ(t.d.cp_link_tip_d);
            aVar.b(t.j.member_i_know, new ag(this, aVar, i));
            String string = this.eaS.getPageContext().getString(t.j.member_continue_pay);
            if (i == 0) {
                string = this.eaS.getPageContext().getString(t.j.open_member);
            }
            aVar.a(string, new ah(this, aVar, i));
            aVar.ak(false);
            aVar.b(this.eaS.getPageContext()).uj();
            com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("show_member_deid_line", false);
        }
    }

    public void aOl() {
        FragmentTabHost.c cA;
        if (this.aTI != null && (cA = this.aTI.cA(this.aTI.getCurrentTabType())) != null && cA.aaz != null && cA.aaz.Ey() != null) {
            String string = this.eaS.getPageContext().getString(cA.aaz.Ey().ayp);
            if (this.eaT != null) {
                this.eaT.setText(string);
            }
        }
    }

    public void SG() {
        this.mNavigationBar = (NavigationBar) this.eaS.findViewById(t.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.eaT = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.maintab_title_layout, (View.OnClickListener) null).findViewById(t.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.eaS.getResources().getDimension(t.e.navi_btn_margin_right);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.eaT.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.game_tip_view, (View.OnClickListener) null);
            this.eaX = (ImageView) addCustomView.findViewById(t.g.game_button_iv);
            this.eaY = (ImageView) addCustomView.findViewById(t.g.game_tip_msg_iv);
            this.eaX.setOnClickListener(new ai(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.k.c(this.eaS.getPageContext().getPageActivity(), t.e.ds16), 0);
            this.eaV = (ViewGroup) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_adkiller, (View.OnClickListener) null);
            this.eaW = (ImageView) this.eaV.findViewById(t.g.navigationBarGoAdKiller);
            this.eaV.setLayoutParams(layoutParams2);
            this.eaV.setVisibility(8);
            this.eaW.setOnClickListener(new aj(this));
            this.eaZ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_search, (View.OnClickListener) null);
            this.eaZ.setLayoutParams(layoutParams2);
            this.eaZ.setVisibility(8);
            this.eaZ.setOnClickListener(new ak(this));
            this.eaU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.eaU.setLayoutParams(layoutParams2);
            this.eaU.setVisibility(8);
            this.eaU.setOnClickListener(new al(this));
            this.mNavigationBar.setLoginClickListener(new aa(this));
            this.mNavigationBar.setRegisterClickListener(new ab(this));
        }
    }

    public void ic(boolean z) {
        if (z) {
            this.eaU.setVisibility(0);
            this.eaZ.setVisibility(8);
            return;
        }
        this.eaU.setVisibility(8);
        this.eaZ.setVisibility(0);
    }

    public void id(boolean z) {
        if (z) {
            if (TbadkCoreApplication.m411getInst().isShowAdKiller()) {
                this.eaV.setVisibility(0);
                return;
            } else {
                this.eaV.setVisibility(8);
                return;
            }
        }
        this.eaV.setVisibility(8);
    }

    public void eK(boolean z) {
        this.cEC = z;
        if (z) {
            if (this.ebb == null) {
                aOm();
            }
            this.ebb.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.ebb != null) {
            this.ebb.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
    }

    public boolean amZ() {
        return this.cEC;
    }

    private void aOm() {
        this.ebb = (NavigationBar) ((ViewStub) this.eaS.findViewById(t.g.viewstub_navigation_bar_in_edit)).inflate();
        this.ebb.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.enter_forum_edit_cancel, new ac(this));
        this.ebc = this.ebb.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.enter_forum_edit_confirm, new ad(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(this.eaS.getPageContext().getPageActivity(), t.e.ds16), 0);
        this.ebc.setLayoutParams(layoutParams);
        this.ebb.onChangeSkinType(this.eaS.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void ie(boolean z) {
        if (z) {
            if (this.eaY.getVisibility() != 0) {
                this.eaY.setVisibility(0);
                ig(true);
                ar.c(this.eaY, t.f.icon_news_down_bar_one);
                return;
            }
            return;
        }
        ig(false);
        this.eaY.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ig(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eaX.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(this.eaS.getPageContext().getPageActivity(), t.e.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(this.eaS.getPageContext().getPageActivity(), t.e.ds20);
            }
            this.eaX.setLayoutParams(layoutParams);
        }
    }

    public void R(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.aTI.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Ey(), next.am(this.eaS.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2 && TbadkCoreApplication.m411getInst().isThemeIconCover()) {
            this.aTI.cu(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aTI.cu(1);
        } else {
            this.aTI.cu(0);
        }
        this.aTI.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aay = cVar.ayo;
            cVar2.mType = cVar.type;
            fragmentTabIndicator.setText(cVar.ayp);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.eaS.getResources().getDimension(t.e.ds24));
                fragmentTabIndicator.setTextColorResId(t.d.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.ayq);
                fragmentTabIndicator.setContentTvTopMargin(this.eaS.getResources().getDimensionPixelSize(t.e.ds2));
            } else {
                fragmentTabIndicator.setTextSize(0, this.eaS.getResources().getDimension(t.e.fontsize32));
                fragmentTabIndicator.setTextColorResId(t.d.s_tabbar_text_color);
            }
            fragmentTabIndicator.dk(TbadkCoreApplication.m411getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.aax = fragmentTabIndicator;
            cVar2.aaz = bVar;
            this.aTI.a(cVar2);
        }
    }

    public FragmentTabHost aOn() {
        return this.aTI;
    }

    public void aOo() {
        if (this.aTI != null) {
            if (this.aTI.getCurrentTabType() == 8) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                if (this.ebb != null) {
                    this.ebb.setVisibility(8);
                }
                ia(true);
            } else {
                eK(amZ());
                ia(false);
            }
            if (this.aTI.getCurrentTabType() == 6 || this.cEz == 6) {
                TbadkCoreApplication.m411getInst().setFriendFeedNew(false);
            }
            if (this.aTI.getCurrentTabType() != 1) {
                if (this.eaU != null) {
                    this.eaU.setVisibility(8);
                }
                if (this.eaZ != null) {
                    this.eaZ.setVisibility(0);
                }
            }
        }
    }
}
