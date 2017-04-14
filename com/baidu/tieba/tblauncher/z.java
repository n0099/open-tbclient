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
    private ImageView aYG;
    private FragmentTabHost bAp;
    private ImageView cvV;
    private ImageView cvW;
    private boolean dSK;
    private TextView dkB;
    private MainTabActivity fAi;
    private ImageView fAj;
    private NavigationBar fAm;
    private View fAn;
    private NavigationBar mNavigationBar;
    private Handler mHandler = null;
    private boolean fAk = false;
    private boolean fAl = false;
    private int dSG = -1;
    private FragmentTabHost.b fAo = new aa(this);
    private com.baidu.tbadk.coreExtra.view.j aDz = null;
    private int mSkinType = 0;

    public z(MainTabActivity mainTabActivity) {
        this.fAi = mainTabActivity;
    }

    public void lq(boolean z) {
        this.bAp = (FragmentTabHost) this.fAi.findViewById(w.h.tab_host);
        this.bAp.setup(this.fAi.getSupportFragmentManager());
        this.bAp.setOnTabSelectionListener(this.fAo);
        this.bAp.setFrameLayerClickListener(new ae(this));
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bAp.setShouldDrawIndicatorLine(false);
            this.bAp.setShouldDrawTopLine(true);
            this.bAp.e(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds10), 0, 0);
            this.bAp.aE(true);
        }
        this.bAp.setOnPageChangeListener(new af(this));
        this.fAl = com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("has_show_message_tab_tips", false);
        auG();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.fAi.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        this.fAk = z;
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void bjY() {
        com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("has_show_message_tab_tips", this.fAl);
    }

    public boolean aiY() {
        return this.cvV != null && this.cvV.getVisibility() == 0;
    }

    public void eS(boolean z) {
        if (this.cvV != null) {
            if (z) {
                this.cvV.setVisibility(0);
            } else {
                this.cvV.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bAp.setShouldDrawTopLine(false);
            } else {
                this.bAp.setShouldDrawTopLine(true);
            }
        }
        if (this.bAp.getFragmentTabWidget() != null) {
            this.bAp.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bAp.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.fAi.getPageContext(), i);
        if (this.fAm != null) {
            this.fAm.onChangeSkinType(this.fAi.getPageContext(), i);
        }
        aq.a(this.dkB, w.e.cp_cont_b, w.e.s_navbar_title_color, i);
        aq.c(this.cvW, w.g.icon_news_down_bar_one);
        aq.b(this.cvV, w.g.icon_game_bg_s, w.g.icon_game_bg);
        aq.b(this.aYG, w.g.icon_search_bg_s, w.g.icon_search_bg);
        aq.b(this.fAj, w.g.icon_sign_bg_s, w.g.icon_sign_bg);
    }

    public void a(com.baidu.tbadk.data.h hVar, int i) {
        if (hVar != null) {
            View inflate = LayoutInflater.from(this.fAi.getPageContext().getPageActivity()).inflate(w.j.show_member_died_line_layout, (ViewGroup) null);
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
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fAi.getPageContext().getPageActivity());
            aVar.v(inflate);
            aVar.ca(w.e.cp_link_tip_d);
            aVar.b(w.l.member_i_know, new ag(this, aVar, i));
            String string = this.fAi.getPageContext().getString(w.l.member_continue_pay);
            if (i == 0) {
                string = this.fAi.getPageContext().getString(w.l.open_member);
            }
            aVar.a(string, new ah(this, aVar, i));
            aVar.aw(false);
            aVar.b(this.fAi.getPageContext()).tQ();
            com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("show_member_deid_line", false);
        }
    }

    public void bjZ() {
        FragmentTabHost.c cA;
        if (this.bAp != null && (cA = this.bAp.cA(this.bAp.getCurrentTabType())) != null && cA.adM != null && cA.adM.Fe() != null) {
            String string = this.fAi.getPageContext().getString(cA.adM.Fe().aEg);
            if (this.dkB != null) {
                this.dkB.setText(string);
            }
        }
    }

    public void auG() {
        this.mNavigationBar = (NavigationBar) this.fAi.findViewById(w.h.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.dkB = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.maintab_title_layout, (View.OnClickListener) null).findViewById(w.h.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.fAi.getResources().getDimension(w.f.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.dkB.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.game_tip_view, (View.OnClickListener) null);
            this.cvV = (ImageView) addCustomView.findViewById(w.h.game_button_iv);
            this.cvW = (ImageView) addCustomView.findViewById(w.h.game_tip_msg_iv);
            this.cvV.setOnClickListener(new ai(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.fAi.getPageContext().getPageActivity(), w.f.ds16), 0);
            this.aYG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_search, (View.OnClickListener) null);
            this.aYG.setLayoutParams(layoutParams2);
            this.aYG.setVisibility(8);
            this.aYG.setOnClickListener(new aj(this));
            this.fAj = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_signall, (View.OnClickListener) null);
            this.fAj.setLayoutParams(layoutParams2);
            this.fAj.setVisibility(8);
            this.fAj.setOnClickListener(new ak(this));
            this.mNavigationBar.setLoginClickListener(new al(this));
            this.mNavigationBar.setRegisterClickListener(new ab(this));
        }
    }

    public void lr(boolean z) {
        if (z) {
            this.fAj.setVisibility(0);
            this.aYG.setVisibility(8);
            return;
        }
        this.fAj.setVisibility(8);
        this.aYG.setVisibility(0);
    }

    public void hz(boolean z) {
        this.dSK = z;
        if (z) {
            if (this.fAm == null) {
                bka();
            }
            this.fAm.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.fAm != null) {
            this.fAm.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.onChangeSkinType(this.fAi.getPageContext(), this.mSkinType);
    }

    public boolean aFo() {
        return this.dSK;
    }

    private void bka() {
        this.fAm = (NavigationBar) ((ViewStub) this.fAi.findViewById(w.h.viewstub_navigation_bar_in_edit)).inflate();
        this.fAm.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.enter_forum_edit_cancel, new ac(this));
        this.fAn = this.fAm.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.enter_forum_edit_confirm, new ad(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.fAi.getPageContext().getPageActivity(), w.f.ds16), 0);
        this.fAn.setLayoutParams(layoutParams);
        this.fAm.onChangeSkinType(this.fAi.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void eR(boolean z) {
        if (aiY()) {
            if (z) {
                if (this.cvW.getVisibility() != 0) {
                    this.cvW.setVisibility(0);
                    eT(true);
                    aq.c(this.cvW, w.g.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            eT(false);
            this.cvW.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eT(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cvV.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.fAi.getPageContext().getPageActivity(), w.f.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.fAi.getPageContext().getPageActivity(), w.f.ds20);
            }
            this.cvV.setLayoutParams(layoutParams);
        }
    }

    public void ae(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bAp.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Fe(), next.aP(this.fAi.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2 && TbadkCoreApplication.m9getInst().isThemeIconCover()) {
            this.bAp.cw(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bAp.cw(1);
        } else {
            this.bAp.cw(0);
        }
        this.bAp.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.adL = cVar.aEf;
            cVar2.mType = cVar.type;
            fragmentTabIndicator.setText(cVar.aEg);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.fAi.getResources().getDimension(w.f.ds24));
                fragmentTabIndicator.setTextColorResId(w.e.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.aEh);
                fragmentTabIndicator.setContentTvTopMargin(this.fAi.getResources().getDimensionPixelSize(w.f.ds2));
            } else {
                fragmentTabIndicator.setTextSize(0, this.fAi.getResources().getDimension(w.f.fontsize32));
                fragmentTabIndicator.setTextColorResId(w.e.s_tabbar_text_color);
            }
            fragmentTabIndicator.m14do(TbadkCoreApplication.m9getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.adK = fragmentTabIndicator;
            cVar2.adM = bVar;
            this.bAp.a(cVar2);
        }
    }

    public FragmentTabHost bkb() {
        return this.bAp;
    }

    public void bkc() {
        if (this.bAp != null) {
            if (this.bAp.getCurrentTabType() == 8 || this.bAp.getCurrentTabType() == 3 || this.bAp.getCurrentTabType() == 2 || this.bAp.getCurrentTabType() == 15) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                if (this.fAm != null) {
                    this.fAm.setVisibility(8);
                }
            } else {
                hz(aFo());
            }
            if (this.bAp.getCurrentTabType() != 1) {
                if (this.fAj != null) {
                    this.fAj.setVisibility(8);
                }
                if (this.aYG != null && this.bAp.getCurrentTabType() != 3) {
                    this.aYG.setVisibility(0);
                }
            }
        }
    }
}
