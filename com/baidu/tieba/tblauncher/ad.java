package com.baidu.tieba.tblauncher;

import android.os.Handler;
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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ad {
    private ImageView aWH;
    private FragmentTabHost bgm;
    private ImageView coU;
    private ImageView coV;
    private boolean dJA;
    private TextView dcx;
    private MainTabActivity fkU;
    private ImageView fkV;
    private NavigationBar fkY;
    private View fkZ;
    private NavigationBar mNavigationBar;
    private Handler mHandler = null;
    private boolean fkW = false;
    private boolean fkX = false;
    private int dJx = -1;
    private FragmentTabHost.b fla = new ae(this);
    private com.baidu.tbadk.coreExtra.view.j ayU = null;

    public ad(MainTabActivity mainTabActivity) {
        this.fkU = mainTabActivity;
    }

    public void lc(boolean z) {
        this.bgm = (FragmentTabHost) this.fkU.findViewById(r.g.tab_host);
        this.bgm.setup(this.fkU.getSupportFragmentManager());
        this.bgm.setOnTabSelectionListener(this.fla);
        this.bgm.setFrameLayerClickListener(new ai(this));
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bgm.setShouldDrawIndicatorLine(false);
            this.bgm.setShouldDrawTopLine(true);
            this.bgm.e(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds10), 0, 0);
            this.bgm.aD(true);
        }
        this.bgm.setOnPageChangeListener(new aj(this));
        this.fkX = com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("has_show_message_tab_tips", false);
        acE();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.fkU.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        this.fkW = z;
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void bhQ() {
        com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("has_show_message_tab_tips", this.fkX);
    }

    public boolean aiK() {
        return this.coU != null && this.coU.getVisibility() == 0;
    }

    public void eX(boolean z) {
        if (this.coU != null) {
            if (z) {
                this.coU.setVisibility(0);
            } else {
                this.coU.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bgm.setShouldDrawTopLine(false);
            } else {
                this.bgm.setShouldDrawTopLine(true);
            }
        }
        if (this.bgm.getFragmentTabWidget() != null) {
            this.bgm.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bgm.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.fkU.getPageContext(), i);
        if (this.fkY != null) {
            this.fkY.onChangeSkinType(this.fkU.getPageContext(), i);
        }
        ar.a(this.dcx, r.d.cp_cont_b, r.d.s_navbar_title_color, i);
        ar.c(this.coV, r.f.icon_news_down_bar_one);
        ar.b(this.coU, r.f.icon_game_bg_s, r.f.icon_game_bg);
        ar.b(this.aWH, r.f.icon_search_bg_s, r.f.icon_search_bg);
        ar.b(this.fkV, r.f.icon_sign_bg_s, r.f.icon_sign_bg);
    }

    public void a(com.baidu.tbadk.data.h hVar, int i) {
        if (hVar != null) {
            View inflate = LayoutInflater.from(this.fkU.getPageContext().getPageActivity()).inflate(r.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(r.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(r.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.m9getInst().getSkinType() == 1;
            ar.c(textView, r.d.cp_cont_b, 1);
            if (!StringUtils.isNull(hVar.BV())) {
                textView.setText(hVar.BV());
            }
            if (!StringUtils.isNull(hVar.getUrl())) {
                tbImageView.c(hVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ar.c(tbImageView, r.f.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fkU.getPageContext().getPageActivity());
            aVar.z(inflate);
            aVar.cc(r.d.cp_link_tip_d);
            aVar.b(r.j.member_i_know, new ak(this, aVar, i));
            String string = this.fkU.getPageContext().getString(r.j.member_continue_pay);
            if (i == 0) {
                string = this.fkU.getPageContext().getString(r.j.open_member);
            }
            aVar.a(string, new al(this, aVar, i));
            aVar.av(false);
            aVar.b(this.fkU.getPageContext()).tb();
            com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("show_member_deid_line", false);
        }
    }

    public void bhR() {
        FragmentTabHost.c cC;
        if (this.bgm != null && (cC = this.bgm.cC(this.bgm.getCurrentTabType())) != null && cC.YV != null && cC.YV.Es() != null) {
            String string = this.fkU.getPageContext().getString(cC.YV.Es().azB);
            if (this.dcx != null) {
                this.dcx.setText(string);
            }
        }
    }

    public void acE() {
        this.mNavigationBar = (NavigationBar) this.fkU.findViewById(r.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.dcx = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.maintab_title_layout, (View.OnClickListener) null).findViewById(r.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.fkU.getResources().getDimension(r.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.dcx.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.game_tip_view, (View.OnClickListener) null);
            this.coU = (ImageView) addCustomView.findViewById(r.g.game_button_iv);
            this.coV = (ImageView) addCustomView.findViewById(r.g.game_tip_msg_iv);
            this.coU.setOnClickListener(new am(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.fkU.getPageContext().getPageActivity(), r.e.ds16), 0);
            this.aWH = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.widget_nb_item_search, (View.OnClickListener) null);
            this.aWH.setLayoutParams(layoutParams2);
            this.aWH.setVisibility(8);
            this.aWH.setOnClickListener(new an(this));
            this.fkV = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.fkV.setLayoutParams(layoutParams2);
            this.fkV.setVisibility(8);
            this.fkV.setOnClickListener(new ao(this));
            this.mNavigationBar.setLoginClickListener(new ap(this));
            this.mNavigationBar.setRegisterClickListener(new af(this));
        }
    }

    public void ld(boolean z) {
        if (z) {
            this.fkV.setVisibility(0);
            this.aWH.setVisibility(8);
            return;
        }
        this.fkV.setVisibility(8);
        this.aWH.setVisibility(0);
    }

    public void hy(boolean z) {
        this.dJA = z;
        if (z) {
            if (this.fkY == null) {
                bhS();
            }
            this.fkY.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.fkY != null) {
            this.fkY.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
    }

    public boolean aEr() {
        return this.dJA;
    }

    private void bhS() {
        this.fkY = (NavigationBar) ((ViewStub) this.fkU.findViewById(r.g.viewstub_navigation_bar_in_edit)).inflate();
        this.fkY.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.enter_forum_edit_cancel, new ag(this));
        this.fkZ = this.fkY.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.enter_forum_edit_confirm, new ah(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.fkU.getPageContext().getPageActivity(), r.e.ds16), 0);
        this.fkZ.setLayoutParams(layoutParams);
        this.fkY.onChangeSkinType(this.fkU.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void eW(boolean z) {
        if (z) {
            if (this.coV.getVisibility() != 0) {
                this.coV.setVisibility(0);
                eY(true);
                ar.c(this.coV, r.f.icon_news_down_bar_one);
                return;
            }
            return;
        }
        eY(false);
        this.coV.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.coU.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.fkU.getPageContext().getPageActivity(), r.e.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.fkU.getPageContext().getPageActivity(), r.e.ds20);
            }
            this.coU.setLayoutParams(layoutParams);
        }
    }

    public void Z(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bgm.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Es(), next.an(this.fkU.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2 && TbadkCoreApplication.m9getInst().isThemeIconCover()) {
            this.bgm.cy(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bgm.cy(1);
        } else {
            this.bgm.cy(0);
        }
        this.bgm.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.YU = cVar.azA;
            cVar2.mType = cVar.type;
            fragmentTabIndicator.setText(cVar.azB);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.fkU.getResources().getDimension(r.e.ds24));
                fragmentTabIndicator.setTextColorResId(r.d.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.azC);
                fragmentTabIndicator.setContentTvTopMargin(this.fkU.getResources().getDimensionPixelSize(r.e.ds2));
            } else {
                fragmentTabIndicator.setTextSize(0, this.fkU.getResources().getDimension(r.e.fontsize32));
                fragmentTabIndicator.setTextColorResId(r.d.s_tabbar_text_color);
            }
            fragmentTabIndicator.m14do(TbadkCoreApplication.m9getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.YT = fragmentTabIndicator;
            cVar2.YV = bVar;
            this.bgm.a(cVar2);
        }
    }

    public FragmentTabHost bhT() {
        return this.bgm;
    }

    public void bhU() {
        if (this.bgm != null) {
            if (this.bgm.getCurrentTabType() == 8 || this.bgm.getCurrentTabType() == 3 || this.bgm.getCurrentTabType() == 2 || this.bgm.getCurrentTabType() == 15) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                if (this.fkY != null) {
                    this.fkY.setVisibility(8);
                }
            } else {
                hy(aEr());
            }
            if (this.bgm.getCurrentTabType() != 1) {
                if (this.fkV != null) {
                    this.fkV.setVisibility(8);
                }
                if (this.aWH != null && this.bgm.getCurrentTabType() != 3) {
                    this.aWH.setVisibility(0);
                }
            }
        }
    }
}
