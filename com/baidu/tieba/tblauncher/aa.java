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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class aa {
    private ImageView aSh;
    private FragmentTabHost bto;
    private ImageView cvW;
    private ImageView cvX;
    private boolean dSx;
    private TextView djI;
    private MainTabActivity fua;
    private ImageView fub;
    private NavigationBar fue;
    private View fuf;
    private NavigationBar mNavigationBar;
    private Handler mHandler = null;
    private boolean fuc = false;
    private boolean fud = false;
    private int dSu = -1;
    private FragmentTabHost.b fug = new ab(this);
    private com.baidu.tbadk.coreExtra.view.j axP = null;

    public aa(MainTabActivity mainTabActivity) {
        this.fua = mainTabActivity;
    }

    public void lo(boolean z) {
        this.bto = (FragmentTabHost) this.fua.findViewById(r.h.tab_host);
        this.bto.setup(this.fua.getSupportFragmentManager());
        this.bto.setOnTabSelectionListener(this.fug);
        this.bto.setFrameLayerClickListener(new af(this));
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bto.setShouldDrawIndicatorLine(false);
            this.bto.setShouldDrawTopLine(true);
            this.bto.e(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds10), 0, 0);
            this.bto.aD(true);
        }
        this.bto.setOnPageChangeListener(new ag(this));
        this.fud = com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("has_show_message_tab_tips", false);
        adO();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.fua.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        this.fuc = z;
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void bjy() {
        com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("has_show_message_tab_tips", this.fud);
    }

    public boolean ajS() {
        return this.cvW != null && this.cvW.getVisibility() == 0;
    }

    public void fb(boolean z) {
        if (this.cvW != null) {
            if (z) {
                this.cvW.setVisibility(0);
            } else {
                this.cvW.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bto.setShouldDrawTopLine(false);
            } else {
                this.bto.setShouldDrawTopLine(true);
            }
        }
        if (this.bto.getFragmentTabWidget() != null) {
            this.bto.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bto.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.fua.getPageContext(), i);
        if (this.fue != null) {
            this.fue.onChangeSkinType(this.fua.getPageContext(), i);
        }
        ap.a(this.djI, r.e.cp_cont_b, r.e.s_navbar_title_color, i);
        ap.c(this.cvX, r.g.icon_news_down_bar_one);
        ap.b(this.cvW, r.g.icon_game_bg_s, r.g.icon_game_bg);
        ap.b(this.aSh, r.g.icon_search_bg_s, r.g.icon_search_bg);
        ap.b(this.fub, r.g.icon_sign_bg_s, r.g.icon_sign_bg);
    }

    public void a(com.baidu.tbadk.data.h hVar, int i) {
        if (hVar != null) {
            View inflate = LayoutInflater.from(this.fua.getPageContext().getPageActivity()).inflate(r.j.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(r.h.member_icon);
            TextView textView = (TextView) inflate.findViewById(r.h.member_died_line_tip);
            boolean z = TbadkCoreApplication.m9getInst().getSkinType() == 1;
            ap.c(textView, r.e.cp_cont_b, 1);
            if (!StringUtils.isNull(hVar.BQ())) {
                textView.setText(hVar.BQ());
            }
            if (!StringUtils.isNull(hVar.getUrl())) {
                tbImageView.c(hVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ap.c(tbImageView, r.g.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fua.getPageContext().getPageActivity());
            aVar.x(inflate);
            aVar.cb(r.e.cp_link_tip_d);
            aVar.b(r.l.member_i_know, new ah(this, aVar, i));
            String string = this.fua.getPageContext().getString(r.l.member_continue_pay);
            if (i == 0) {
                string = this.fua.getPageContext().getString(r.l.open_member);
            }
            aVar.a(string, new ai(this, aVar, i));
            aVar.av(false);
            aVar.b(this.fua.getPageContext()).sV();
            com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("show_member_deid_line", false);
        }
    }

    public void bjz() {
        FragmentTabHost.c cB;
        if (this.bto != null && (cB = this.bto.cB(this.bto.getCurrentTabType())) != null && cB.Yj != null && cB.Yj.En() != null) {
            String string = this.fua.getPageContext().getString(cB.Yj.En().ayw);
            if (this.djI != null) {
                this.djI.setText(string);
            }
        }
    }

    public void adO() {
        this.mNavigationBar = (NavigationBar) this.fua.findViewById(r.h.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.djI = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.j.maintab_title_layout, (View.OnClickListener) null).findViewById(r.h.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.fua.getResources().getDimension(r.f.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.djI.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.j.game_tip_view, (View.OnClickListener) null);
            this.cvW = (ImageView) addCustomView.findViewById(r.h.game_button_iv);
            this.cvX = (ImageView) addCustomView.findViewById(r.h.game_tip_msg_iv);
            this.cvW.setOnClickListener(new aj(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.fua.getPageContext().getPageActivity(), r.f.ds16), 0);
            this.aSh = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.j.widget_nb_item_search, (View.OnClickListener) null);
            this.aSh.setLayoutParams(layoutParams2);
            this.aSh.setVisibility(8);
            this.aSh.setOnClickListener(new ak(this));
            this.fub = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.j.widget_nb_item_signall, (View.OnClickListener) null);
            this.fub.setLayoutParams(layoutParams2);
            this.fub.setVisibility(8);
            this.fub.setOnClickListener(new al(this));
            this.mNavigationBar.setLoginClickListener(new am(this));
            this.mNavigationBar.setRegisterClickListener(new ac(this));
        }
    }

    public void lp(boolean z) {
        if (z) {
            this.fub.setVisibility(0);
            this.aSh.setVisibility(8);
            return;
        }
        this.fub.setVisibility(8);
        this.aSh.setVisibility(0);
    }

    public void hJ(boolean z) {
        this.dSx = z;
        if (z) {
            if (this.fue == null) {
                bjA();
            }
            this.fue.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.fue != null) {
            this.fue.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
    }

    public boolean aGe() {
        return this.dSx;
    }

    private void bjA() {
        this.fue = (NavigationBar) ((ViewStub) this.fua.findViewById(r.h.viewstub_navigation_bar_in_edit)).inflate();
        this.fue.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.j.enter_forum_edit_cancel, new ad(this));
        this.fuf = this.fue.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.j.enter_forum_edit_confirm, new ae(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.fua.getPageContext().getPageActivity(), r.f.ds16), 0);
        this.fuf.setLayoutParams(layoutParams);
        this.fue.onChangeSkinType(this.fua.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void fa(boolean z) {
        if (z) {
            if (this.cvX.getVisibility() != 0) {
                this.cvX.setVisibility(0);
                fc(true);
                ap.c(this.cvX, r.g.icon_news_down_bar_one);
                return;
            }
            return;
        }
        fc(false);
        this.cvX.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fc(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cvW.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.fua.getPageContext().getPageActivity(), r.f.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.fua.getPageContext().getPageActivity(), r.f.ds20);
            }
            this.cvW.setLayoutParams(layoutParams);
        }
    }

    public void ae(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bto.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.En(), next.ap(this.fua.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2 && TbadkCoreApplication.m9getInst().isThemeIconCover()) {
            this.bto.cx(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bto.cx(1);
        } else {
            this.bto.cx(0);
        }
        this.bto.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.Yi = cVar.ayv;
            cVar2.mType = cVar.type;
            fragmentTabIndicator.setText(cVar.ayw);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.fua.getResources().getDimension(r.f.ds24));
                fragmentTabIndicator.setTextColorResId(r.e.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.ayx);
                fragmentTabIndicator.setContentTvTopMargin(this.fua.getResources().getDimensionPixelSize(r.f.ds2));
            } else {
                fragmentTabIndicator.setTextSize(0, this.fua.getResources().getDimension(r.f.fontsize32));
                fragmentTabIndicator.setTextColorResId(r.e.s_tabbar_text_color);
            }
            fragmentTabIndicator.dp(TbadkCoreApplication.m9getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.Yh = fragmentTabIndicator;
            cVar2.Yj = bVar;
            this.bto.a(cVar2);
        }
    }

    public FragmentTabHost bjB() {
        return this.bto;
    }

    public void bjC() {
        if (this.bto != null) {
            if (this.bto.getCurrentTabType() == 8 || this.bto.getCurrentTabType() == 3 || this.bto.getCurrentTabType() == 2 || this.bto.getCurrentTabType() == 15) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                if (this.fue != null) {
                    this.fue.setVisibility(8);
                }
            } else {
                hJ(aGe());
            }
            if (this.bto.getCurrentTabType() != 1) {
                if (this.fub != null) {
                    this.fub.setVisibility(8);
                }
                if (this.aSh != null && this.bto.getCurrentTabType() != 3) {
                    this.aSh.setVisibility(0);
                }
            }
        }
    }
}
