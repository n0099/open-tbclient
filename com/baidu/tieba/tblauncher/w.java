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
    private FragmentTabHost bpf;
    private boolean cxV;
    private MainTabActivity dKM;
    private TextView dKN;
    private ImageView dKO;
    private ImageView dKP;
    private ImageView dKQ;
    private ImageView dKR;
    private PluginErrorTipView dKS;
    private NavigationBar dKT;
    private View dKU;
    private NavigationBar mNavigationBar;
    private int cxS = -1;
    private FragmentTabHost.b dKV = new x(this);

    public w(MainTabActivity mainTabActivity) {
        this.dKM = mainTabActivity;
    }

    public void hy(boolean z) {
        this.bpf = (FragmentTabHost) this.dKM.findViewById(n.g.tab_host);
        this.bpf.setup(this.dKM.getSupportFragmentManager());
        this.bpf.setOnTabSelectionListener(this.dKV);
        this.bpf.setFrameLayerClickListener(new ab(this));
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bpf.setShouldDrawIndicatorLine(false);
            int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds10);
            this.bpf.g(0, dimensionPixelSize, 0, dimensionPixelSize);
        }
        this.bpf.setTabWidgetBackgroundRes(n.f.s_tabbar_bg);
        this.bpf.setOnPageChangeListener(new ac(this));
        Qz();
        this.dKS = (PluginErrorTipView) this.dKM.findViewById(n.g.view_plugin_error_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.dKM.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public boolean aHf() {
        return this.dKP != null && this.dKP.getVisibility() == 0;
    }

    public void hz(boolean z) {
        if (this.dKP != null) {
            if (z) {
                this.dKP.setVisibility(0);
            } else {
                this.dKP.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.bpf.onChangeSkinType(i);
        this.bpf.getFragmentTabWidget().setBackgroundDrawable(new BitmapDrawable(as.cz(n.f.s_tabbar_bg)));
        this.mNavigationBar.onChangeSkinType(this.dKM.getPageContext(), i);
        this.dKS.onChangeSkinType(this.dKM.getPageContext(), i);
        if (this.dKT != null) {
            this.dKT.onChangeSkinType(this.dKM.getPageContext(), i);
        }
        as.h((View) this.dKN, n.d.s_navbar_title_color);
        as.c(this.dKQ, n.f.icon_news_down_bar_one);
        as.a(this.dKP, n.f.icon_game_bg_s, n.f.icon_game_bg);
        as.a(this.dKR, n.f.icon_search_bg_s, n.f.icon_search_bg);
        as.a(this.dKO, n.f.icon_sign_bg_s, n.f.icon_sign_bg);
    }

    public void a(com.baidu.tbadk.data.e eVar, int i) {
        if (eVar != null) {
            View inflate = LayoutInflater.from(this.dKM.getPageContext().getPageActivity()).inflate(n.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(n.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(n.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
            as.b(textView, n.d.cp_cont_b, 1);
            if (!StringUtils.isNull(eVar.AL())) {
                textView.setText(eVar.AL());
            }
            if (!StringUtils.isNull(eVar.getUrl())) {
                tbImageView.d(eVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                as.c(tbImageView, n.f.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dKM.getPageContext().getPageActivity());
            aVar.m(inflate);
            aVar.bH(n.d.cp_link_tip_d);
            aVar.b(n.j.member_i_know, new ad(this, aVar, i));
            String string = this.dKM.getPageContext().getString(n.j.member_continue_pay);
            if (i == 0) {
                string = this.dKM.getPageContext().getString(n.j.open_member);
            }
            aVar.a(string, new ae(this, aVar, i));
            aVar.aj(false);
            aVar.b(this.dKM.getPageContext()).tf();
            com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("show_member_deid_line", false);
        }
    }

    public void aHg() {
        FragmentTabHost.c cf;
        if (this.bpf != null && (cf = this.bpf.cf(this.bpf.getCurrentTabType())) != null && cf.aab != null && cf.aab.getFragmentTabStructure() != null) {
            String string = this.dKM.getPageContext().getString(cf.aab.getFragmentTabStructure().axw);
            if (this.dKN != null) {
                this.dKN.setText(string);
            }
        }
    }

    public void Qz() {
        this.mNavigationBar = (NavigationBar) this.dKM.findViewById(n.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.dKN = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, n.h.maintab_title_layout, (View.OnClickListener) null).findViewById(n.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.dKM.getResources().getDimension(n.e.navi_btn_margin_right);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.dKN.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.game_tip_view, (View.OnClickListener) null);
            this.dKP = (ImageView) addCustomView.findViewById(n.g.game_button_iv);
            this.dKQ = (ImageView) addCustomView.findViewById(n.g.game_tip_msg_iv);
            this.dKP.setOnClickListener(new af(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.k.d(this.dKM.getPageContext().getPageActivity(), n.e.ds16), 0);
            this.dKR = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.widget_nb_item_search, (View.OnClickListener) null);
            this.dKR.setLayoutParams(layoutParams2);
            this.dKR.setVisibility(8);
            this.dKR.setOnClickListener(new ag(this));
            this.dKO = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.dKO.setLayoutParams(layoutParams2);
            this.dKO.setVisibility(8);
            this.dKO.setOnClickListener(new ah(this));
            this.mNavigationBar.setLoginClickListener(new ai(this));
            this.mNavigationBar.setRegisterClickListener(new y(this));
        }
    }

    public void hA(boolean z) {
        if (z) {
            this.dKO.setVisibility(0);
            this.dKR.setVisibility(8);
            return;
        }
        this.dKO.setVisibility(8);
        this.dKR.setVisibility(0);
    }

    public void ex(boolean z) {
        this.cxV = z;
        if (z) {
            if (this.dKT == null) {
                aHh();
            }
            this.dKT.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.dKT != null) {
            this.dKT.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
    }

    public boolean ajc() {
        return this.cxV;
    }

    private void aHh() {
        this.dKT = (NavigationBar) ((ViewStub) this.dKM.findViewById(n.g.viewstub_navigation_bar_in_edit)).inflate();
        this.dKT.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, n.h.enter_forum_edit_cancel, new z(this));
        this.dKU = this.dKT.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.enter_forum_edit_confirm, new aa(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.d(this.dKM.getPageContext().getPageActivity(), n.e.ds16), 0);
        this.dKU.setLayoutParams(layoutParams);
        this.dKT.onChangeSkinType(this.dKM.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void hB(boolean z) {
        if (z) {
            if (this.dKQ.getVisibility() != 0) {
                this.dKQ.setVisibility(0);
                as.c(this.dKQ, n.f.icon_news_down_bar_one);
                return;
            }
            return;
        }
        this.dKQ.setVisibility(4);
    }

    public void Q(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bpf.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.dKM.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2 && TbadkCoreApplication.m411getInst().isThemeIconCover()) {
            this.bpf.cb(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bpf.cb(1);
        } else {
            this.bpf.cb(0);
        }
        this.bpf.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.aaa = cVar.axv;
            cVar2.mType = cVar.type;
            fragmentTabIndicator.setText(cVar.axw);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.dKM.getResources().getDimension(n.e.ds24));
                fragmentTabIndicator.setTextColorResId(n.d.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.axx);
                fragmentTabIndicator.setContentTvTopMargin(this.dKM.getResources().getDimensionPixelSize(n.e.ds2));
            } else {
                fragmentTabIndicator.setTextSize(0, this.dKM.getResources().getDimension(n.e.fontsize32));
                fragmentTabIndicator.setTextColorResId(n.d.s_tabbar_text_color);
            }
            fragmentTabIndicator.cR(TbadkCoreApplication.m411getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.ZZ = fragmentTabIndicator;
            cVar2.aab = bVar;
            this.bpf.a(cVar2);
        }
    }

    public FragmentTabHost aHi() {
        return this.bpf;
    }

    public void aHj() {
        if (this.bpf != null) {
            if (this.bpf.getCurrentTabType() == 8) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                if (this.dKT != null) {
                    this.dKT.setVisibility(8);
                }
            } else {
                ex(ajc());
            }
            if (this.bpf.getCurrentTabType() == 6 || this.cxS == 6) {
                TbadkCoreApplication.m411getInst().setFriendFeedNew(false);
            }
            if (this.bpf.getCurrentTabType() != 1) {
                if (this.dKO != null) {
                    this.dKO.setVisibility(8);
                }
                if (this.dKR != null) {
                    this.dKR.setVisibility(0);
                }
            }
        }
    }
}
