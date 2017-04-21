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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class z {
    private ImageView aYJ;
    private FragmentTabHost bCG;
    private ImageView cym;
    private ImageView cyn;
    private boolean dVa;
    private TextView dmS;
    private NavigationBar fCC;
    private View fCD;
    private MainTabActivity fCy;
    private ImageView fCz;
    private NavigationBar mNavigationBar;
    private Handler mHandler = null;
    private boolean fCA = false;
    private boolean fCB = false;
    private int dUW = -1;
    private FragmentTabHost.b fCE = new aa(this);
    private com.baidu.tbadk.coreExtra.view.j aDB = null;
    private int mSkinType = 0;

    public z(MainTabActivity mainTabActivity) {
        this.fCy = mainTabActivity;
    }

    public void lA(boolean z) {
        this.bCG = (FragmentTabHost) this.fCy.findViewById(w.h.tab_host);
        this.bCG.setup(this.fCy.getSupportFragmentManager());
        this.bCG.setOnTabSelectionListener(this.fCE);
        this.bCG.setFrameLayerClickListener(new ae(this));
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bCG.setShouldDrawIndicatorLine(false);
            this.bCG.setShouldDrawTopLine(true);
            this.bCG.e(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds10), 0, 0);
            this.bCG.aE(true);
        }
        this.bCG.setOnPageChangeListener(new af(this));
        this.fCB = com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("has_show_message_tab_tips", false);
        avH();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.fCy.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        this.fCA = z;
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void bkZ() {
        com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("has_show_message_tab_tips", this.fCB);
    }

    public boolean ajZ() {
        return this.cym != null && this.cym.getVisibility() == 0;
    }

    public void fc(boolean z) {
        if (this.cym != null) {
            if (z) {
                this.cym.setVisibility(0);
            } else {
                this.cym.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bCG.setShouldDrawTopLine(false);
            } else {
                this.bCG.setShouldDrawTopLine(true);
            }
        }
        if (this.bCG.getFragmentTabWidget() != null) {
            this.bCG.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bCG.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.fCy.getPageContext(), i);
        if (this.fCC != null) {
            this.fCC.onChangeSkinType(this.fCy.getPageContext(), i);
        }
        aq.a(this.dmS, w.e.cp_cont_b, w.e.s_navbar_title_color, i);
        aq.c(this.cyn, w.g.icon_news_down_bar_one);
        aq.b(this.cym, w.g.icon_game_bg_s, w.g.icon_game_bg);
        aq.b(this.aYJ, w.g.icon_search_bg_s, w.g.icon_search_bg);
        aq.b(this.fCz, w.g.icon_sign_bg_s, w.g.icon_sign_bg);
    }

    public void a(com.baidu.tbadk.data.h hVar, int i) {
        if (hVar != null) {
            View inflate = LayoutInflater.from(this.fCy.getPageContext().getPageActivity()).inflate(w.j.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(w.h.member_icon);
            TextView textView = (TextView) inflate.findViewById(w.h.member_died_line_tip);
            boolean z = TbadkCoreApplication.m9getInst().getSkinType() == 1;
            aq.c(textView, w.e.cp_cont_b, 1);
            if (!StringUtils.isNull(hVar.CH())) {
                textView.setText(hVar.CH());
            }
            if (!StringUtils.isNull(hVar.getUrl())) {
                tbImageView.c(hVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                aq.c(tbImageView, w.g.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fCy.getPageContext().getPageActivity());
            aVar.v(inflate);
            aVar.ca(w.e.cp_link_tip_d);
            aVar.b(w.l.member_i_know, new ag(this, aVar, i));
            String string = this.fCy.getPageContext().getString(w.l.member_continue_pay);
            if (i == 0) {
                string = this.fCy.getPageContext().getString(w.l.open_member);
            }
            aVar.a(string, new ah(this, aVar, i));
            aVar.aw(false);
            aVar.b(this.fCy.getPageContext()).tQ();
            com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("show_member_deid_line", false);
        }
    }

    public void bla() {
        FragmentTabHost.c cA;
        if (this.bCG != null && (cA = this.bCG.cA(this.bCG.getCurrentTabType())) != null && cA.adN != null && cA.adN.Fe() != null) {
            String string = this.fCy.getPageContext().getString(cA.adN.Fe().aEi);
            if (this.dmS != null) {
                this.dmS.setText(string);
            }
        }
    }

    public void avH() {
        this.mNavigationBar = (NavigationBar) this.fCy.findViewById(w.h.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.dmS = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.maintab_title_layout, (View.OnClickListener) null).findViewById(w.h.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.fCy.getResources().getDimension(w.f.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.dmS.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.game_tip_view, (View.OnClickListener) null);
            this.cym = (ImageView) addCustomView.findViewById(w.h.game_button_iv);
            this.cyn = (ImageView) addCustomView.findViewById(w.h.game_tip_msg_iv);
            this.cym.setOnClickListener(new ai(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.fCy.getPageContext().getPageActivity(), w.f.ds16), 0);
            this.aYJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_search, (View.OnClickListener) null);
            this.aYJ.setLayoutParams(layoutParams2);
            this.aYJ.setVisibility(8);
            this.aYJ.setOnClickListener(new aj(this));
            this.fCz = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_signall, (View.OnClickListener) null);
            this.fCz.setLayoutParams(layoutParams2);
            this.fCz.setVisibility(8);
            this.fCz.setOnClickListener(new ak(this));
            this.mNavigationBar.setLoginClickListener(new al(this));
            this.mNavigationBar.setRegisterClickListener(new ab(this));
        }
    }

    public void lB(boolean z) {
        if (z) {
            this.fCz.setVisibility(0);
            this.aYJ.setVisibility(8);
            return;
        }
        this.fCz.setVisibility(8);
        this.aYJ.setVisibility(0);
    }

    public void hJ(boolean z) {
        this.dVa = z;
        if (z) {
            if (this.fCC == null) {
                blb();
            }
            this.fCC.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.fCC != null) {
            this.fCC.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.onChangeSkinType(this.fCy.getPageContext(), this.mSkinType);
    }

    public boolean aGp() {
        return this.dVa;
    }

    private void blb() {
        this.fCC = (NavigationBar) ((ViewStub) this.fCy.findViewById(w.h.viewstub_navigation_bar_in_edit)).inflate();
        this.fCC.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.enter_forum_edit_cancel, new ac(this));
        this.fCD = this.fCC.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.enter_forum_edit_confirm, new ad(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.fCy.getPageContext().getPageActivity(), w.f.ds16), 0);
        this.fCD.setLayoutParams(layoutParams);
        this.fCC.onChangeSkinType(this.fCy.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void fb(boolean z) {
        if (ajZ()) {
            if (z) {
                if (this.cyn.getVisibility() != 0) {
                    this.cyn.setVisibility(0);
                    fd(true);
                    aq.c(this.cyn, w.g.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            fd(false);
            this.cyn.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cym.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.fCy.getPageContext().getPageActivity(), w.f.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.fCy.getPageContext().getPageActivity(), w.f.ds20);
            }
            this.cym.setLayoutParams(layoutParams);
        }
    }

    public void ae(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bCG.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Fe(), next.aP(this.fCy.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2 && TbadkCoreApplication.m9getInst().isThemeIconCover()) {
            this.bCG.cw(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bCG.cw(1);
        } else {
            this.bCG.cw(0);
        }
        this.bCG.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.adM = cVar.aEh;
            cVar2.mType = cVar.type;
            fragmentTabIndicator.setText(cVar.aEi);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.fCy.getResources().getDimension(w.f.ds24));
                fragmentTabIndicator.setTextColorResId(w.e.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.aEj);
                fragmentTabIndicator.setContentTvTopMargin(this.fCy.getResources().getDimensionPixelSize(w.f.ds2));
            } else {
                fragmentTabIndicator.setTextSize(0, this.fCy.getResources().getDimension(w.f.fontsize32));
                fragmentTabIndicator.setTextColorResId(w.e.s_tabbar_text_color);
            }
            fragmentTabIndicator.m14do(TbadkCoreApplication.m9getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.adL = fragmentTabIndicator;
            cVar2.adN = bVar;
            this.bCG.a(cVar2);
        }
    }

    public FragmentTabHost blc() {
        return this.bCG;
    }

    public void bld() {
        if (this.bCG != null) {
            if (this.bCG.getCurrentTabType() == 8 || this.bCG.getCurrentTabType() == 3 || this.bCG.getCurrentTabType() == 2 || this.bCG.getCurrentTabType() == 15) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                if (this.fCC != null) {
                    this.fCC.setVisibility(8);
                }
            } else {
                hJ(aGp());
            }
            if (this.bCG.getCurrentTabType() != 1) {
                if (this.fCz != null) {
                    this.fCz.setVisibility(8);
                }
                if (this.aYJ != null && this.bCG.getCurrentTabType() != 3) {
                    this.aYJ.setVisibility(0);
                }
            }
        }
    }
}
