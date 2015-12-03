package com.baidu.tieba.tblauncher;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class w {
    private FragmentTabHost blo;
    private int ctQ = -1;
    private boolean ctT;
    private MainTabActivity dDj;
    private TextView dDk;
    private ImageView dDl;
    private ImageView dDm;
    private ImageView dDn;
    private ImageView dDo;
    private PluginErrorTipView dDp;
    private NavigationBar dDq;
    private View dDr;
    private NavigationBar mNavigationBar;

    public w(MainTabActivity mainTabActivity) {
        this.dDj = mainTabActivity;
    }

    public void hp(boolean z) {
        this.blo = (FragmentTabHost) this.dDj.findViewById(n.f.tab_host);
        this.blo.setup(this.dDj.getSupportFragmentManager());
        this.blo.setFrameLayerClickListener(new x(this));
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.blo.setShouldDrawIndicatorLine(false);
            int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds10);
            this.blo.g(0, dimensionPixelSize, 0, dimensionPixelSize);
        }
        this.blo.setTabWidgetBackgroundRes(n.e.s_tabbar_bg);
        this.blo.setOnPageChangeListener(new aa(this));
        Qh();
        this.dDp = (PluginErrorTipView) this.dDj.findViewById(n.f.view_plugin_error_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.dDj.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public boolean aER() {
        return this.dDm != null && this.dDm.getVisibility() == 0;
    }

    public void hq(boolean z) {
        if (this.dDm != null) {
            if (z) {
                this.dDm.setVisibility(0);
            } else {
                this.dDm.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.blo.onChangeSkinType(i);
        this.blo.getFragmentTabWidget().setBackgroundDrawable(new BitmapDrawable(as.cG(n.e.s_tabbar_bg)));
        this.mNavigationBar.onChangeSkinType(this.dDj.getPageContext(), i);
        this.dDp.onChangeSkinType(this.dDj.getPageContext(), i);
        if (this.dDq != null) {
            this.dDq.onChangeSkinType(this.dDj.getPageContext(), i);
        }
        as.h((View) this.dDk, n.c.s_navbar_title_color);
        as.c(this.dDn, n.e.icon_news_down_bar_one);
        as.a(this.dDm, n.e.icon_game_bg_s, n.e.icon_game_bg);
        as.a(this.dDo, n.e.icon_search_bg_s, n.e.icon_search_bg);
        as.a(this.dDl, n.e.icon_sign_bg_s, n.e.icon_sign_bg);
    }

    public void a(com.baidu.tbadk.data.e eVar, int i) {
        if (eVar != null) {
            View inflate = LayoutInflater.from(this.dDj.getPageContext().getPageActivity()).inflate(n.g.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(n.f.member_icon);
            TextView textView = (TextView) inflate.findViewById(n.f.member_died_line_tip);
            boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
            as.b(textView, n.c.cp_cont_b, 1);
            if (!StringUtils.isNull(eVar.AV())) {
                textView.setText(eVar.AV());
            }
            if (!StringUtils.isNull(eVar.getUrl())) {
                tbImageView.d(eVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                as.c(tbImageView, n.e.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dDj.getPageContext().getPageActivity());
            aVar.m(inflate);
            aVar.bO(n.c.cp_link_tip_d);
            aVar.b(n.i.member_i_know, new ab(this, aVar, i));
            String string = this.dDj.getPageContext().getString(n.i.member_continue_pay);
            if (i == 0) {
                string = this.dDj.getPageContext().getString(n.i.open_member);
            }
            aVar.a(string, new ac(this, aVar, i));
            aVar.am(false);
            aVar.b(this.dDj.getPageContext()).tv();
            com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("show_member_deid_line", false);
        }
    }

    public void aES() {
        FragmentTabHost.b cm;
        if (this.blo != null && (cm = this.blo.cm(this.blo.getCurrentTabType())) != null && cm.Zx != null && cm.Zx.getFragmentTabStructure() != null) {
            String string = this.dDj.getPageContext().getString(cm.Zx.getFragmentTabStructure().avS);
            if (this.dDk != null) {
                this.dDk.setText(string);
            }
        }
    }

    public void Qh() {
        this.mNavigationBar = (NavigationBar) this.dDj.findViewById(n.f.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.dDk = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, n.g.maintab_title_layout, (View.OnClickListener) null).findViewById(n.f.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.dDj.getResources().getDimension(n.d.navi_btn_margin_right);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.dDk.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.game_tip_view, (View.OnClickListener) null);
            this.dDm = (ImageView) addCustomView.findViewById(n.f.game_button_iv);
            this.dDn = (ImageView) addCustomView.findViewById(n.f.game_tip_msg_iv);
            this.dDm.setOnClickListener(new ad(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.k.d(this.dDj.getPageContext().getPageActivity(), n.d.ds16), 0);
            this.dDo = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.widget_nb_item_search, (View.OnClickListener) null);
            this.dDo.setLayoutParams(layoutParams2);
            this.dDo.setVisibility(8);
            this.dDo.setOnClickListener(new ae(this));
            this.dDl = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.widget_nb_item_signall, (View.OnClickListener) null);
            this.dDl.setLayoutParams(layoutParams2);
            this.dDl.setVisibility(8);
            this.dDl.setOnClickListener(new af(this));
            this.mNavigationBar.setLoginClickListener(new ag(this));
            this.mNavigationBar.setRegisterClickListener(new ah(this));
        }
    }

    public void hr(boolean z) {
        if (z) {
            this.dDl.setVisibility(0);
            this.dDo.setVisibility(8);
            return;
        }
        this.dDl.setVisibility(8);
        this.dDo.setVisibility(0);
    }

    public void ex(boolean z) {
        this.ctT = z;
        if (z) {
            if (this.dDq == null) {
                aET();
            }
            this.dDq.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.dDq != null) {
            this.dDq.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
    }

    public boolean ahS() {
        return this.ctT;
    }

    private void aET() {
        this.dDq = (NavigationBar) ((ViewStub) this.dDj.findViewById(n.f.viewstub_navigation_bar_in_edit)).inflate();
        this.dDq.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, n.g.enter_forum_edit_cancel, new y(this));
        this.dDr = this.dDq.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.enter_forum_edit_confirm, new z(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.d(this.dDj.getPageContext().getPageActivity(), n.d.ds16), 0);
        this.dDr.setLayoutParams(layoutParams);
        this.dDq.onChangeSkinType(this.dDj.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void hs(boolean z) {
        if (z) {
            if (this.dDn.getVisibility() != 0) {
                this.dDn.setVisibility(0);
                as.c(this.dDn, n.e.icon_news_down_bar_one);
                return;
            }
            return;
        }
        this.dDn.setVisibility(4);
    }

    public void R(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.blo.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.dDj.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2 && TbadkCoreApplication.m411getInst().isThemeIconCover()) {
            this.blo.ci(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.blo.ci(1);
        } else {
            this.blo.ci(0);
        }
        this.blo.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.Zw = cVar.avR;
            bVar2.mType = cVar.type;
            fragmentTabIndicator.setText(cVar.avS);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.dDj.getResources().getDimension(n.d.ds24));
                fragmentTabIndicator.setTextColorResId(n.c.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.avT);
                fragmentTabIndicator.setContentTvTopMargin(this.dDj.getResources().getDimensionPixelSize(n.d.ds2));
            } else {
                fragmentTabIndicator.setTextSize(0, this.dDj.getResources().getDimension(n.d.fontsize32));
                fragmentTabIndicator.setTextColorResId(n.c.s_tabbar_text_color);
            }
            fragmentTabIndicator.cX(TbadkCoreApplication.m411getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.Zv = fragmentTabIndicator;
            bVar2.Zx = bVar;
            this.blo.a(bVar2);
        }
    }

    public FragmentTabHost aEU() {
        return this.blo;
    }
}
