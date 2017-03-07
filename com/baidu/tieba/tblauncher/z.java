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
    private ImageView aYs;
    private FragmentTabHost bAw;
    private ImageView cxv;
    private ImageView cxw;
    private boolean dVr;
    private TextView dmc;
    private ImageView fyA;
    private NavigationBar fyD;
    private View fyE;
    private MainTabActivity fyz;
    private NavigationBar mNavigationBar;
    private Handler mHandler = null;
    private boolean fyB = false;
    private boolean fyC = false;
    private int dVn = -1;
    private FragmentTabHost.b fyF = new aa(this);
    private com.baidu.tbadk.coreExtra.view.j aDj = null;
    private int mSkinType = 0;

    public z(MainTabActivity mainTabActivity) {
        this.fyz = mainTabActivity;
    }

    public void ln(boolean z) {
        this.bAw = (FragmentTabHost) this.fyz.findViewById(w.h.tab_host);
        this.bAw.setup(this.fyz.getSupportFragmentManager());
        this.bAw.setOnTabSelectionListener(this.fyF);
        this.bAw.setFrameLayerClickListener(new ae(this));
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bAw.setShouldDrawIndicatorLine(false);
            this.bAw.setShouldDrawTopLine(true);
            this.bAw.e(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds10), 0, 0);
            this.bAw.aC(true);
        }
        this.bAw.setOnPageChangeListener(new af(this));
        this.fyC = com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("has_show_message_tab_tips", false);
        auN();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.fyz.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        this.fyB = z;
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void bjn() {
        com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("has_show_message_tab_tips", this.fyC);
    }

    public boolean aje() {
        return this.cxv != null && this.cxv.getVisibility() == 0;
    }

    public void eS(boolean z) {
        if (this.cxv != null) {
            if (z) {
                this.cxv.setVisibility(0);
            } else {
                this.cxv.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bAw.setShouldDrawTopLine(false);
            } else {
                this.bAw.setShouldDrawTopLine(true);
            }
        }
        if (this.bAw.getFragmentTabWidget() != null) {
            this.bAw.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bAw.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.fyz.getPageContext(), i);
        if (this.fyD != null) {
            this.fyD.onChangeSkinType(this.fyz.getPageContext(), i);
        }
        aq.a(this.dmc, w.e.cp_cont_b, w.e.s_navbar_title_color, i);
        aq.c(this.cxw, w.g.icon_news_down_bar_one);
        aq.b(this.cxv, w.g.icon_game_bg_s, w.g.icon_game_bg);
        aq.b(this.aYs, w.g.icon_search_bg_s, w.g.icon_search_bg);
        aq.b(this.fyA, w.g.icon_sign_bg_s, w.g.icon_sign_bg);
    }

    public void a(com.baidu.tbadk.data.h hVar, int i) {
        if (hVar != null) {
            View inflate = LayoutInflater.from(this.fyz.getPageContext().getPageActivity()).inflate(w.j.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(w.h.member_icon);
            TextView textView = (TextView) inflate.findViewById(w.h.member_died_line_tip);
            boolean z = TbadkCoreApplication.m9getInst().getSkinType() == 1;
            aq.c(textView, w.e.cp_cont_b, 1);
            if (!StringUtils.isNull(hVar.Cj())) {
                textView.setText(hVar.Cj());
            }
            if (!StringUtils.isNull(hVar.getUrl())) {
                tbImageView.c(hVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                aq.c(tbImageView, w.g.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fyz.getPageContext().getPageActivity());
            aVar.v(inflate);
            aVar.bX(w.e.cp_link_tip_d);
            aVar.b(w.l.member_i_know, new ag(this, aVar, i));
            String string = this.fyz.getPageContext().getString(w.l.member_continue_pay);
            if (i == 0) {
                string = this.fyz.getPageContext().getString(w.l.open_member);
            }
            aVar.a(string, new ah(this, aVar, i));
            aVar.au(false);
            aVar.b(this.fyz.getPageContext()).ts();
            com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("show_member_deid_line", false);
        }
    }

    public void bjo() {
        FragmentTabHost.c cx;
        if (this.bAw != null && (cx = this.bAw.cx(this.bAw.getCurrentTabType())) != null && cx.ady != null && cx.ady.EG() != null) {
            String string = this.fyz.getPageContext().getString(cx.ady.EG().aDQ);
            if (this.dmc != null) {
                this.dmc.setText(string);
            }
        }
    }

    public void auN() {
        this.mNavigationBar = (NavigationBar) this.fyz.findViewById(w.h.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.dmc = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.maintab_title_layout, (View.OnClickListener) null).findViewById(w.h.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.fyz.getResources().getDimension(w.f.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.dmc.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.game_tip_view, (View.OnClickListener) null);
            this.cxv = (ImageView) addCustomView.findViewById(w.h.game_button_iv);
            this.cxw = (ImageView) addCustomView.findViewById(w.h.game_tip_msg_iv);
            this.cxv.setOnClickListener(new ai(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.fyz.getPageContext().getPageActivity(), w.f.ds16), 0);
            this.aYs = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_search, (View.OnClickListener) null);
            this.aYs.setLayoutParams(layoutParams2);
            this.aYs.setVisibility(8);
            this.aYs.setOnClickListener(new aj(this));
            this.fyA = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.widget_nb_item_signall, (View.OnClickListener) null);
            this.fyA.setLayoutParams(layoutParams2);
            this.fyA.setVisibility(8);
            this.fyA.setOnClickListener(new ak(this));
            this.mNavigationBar.setLoginClickListener(new al(this));
            this.mNavigationBar.setRegisterClickListener(new ab(this));
        }
    }

    public void lo(boolean z) {
        if (z) {
            this.fyA.setVisibility(0);
            this.aYs.setVisibility(8);
            return;
        }
        this.fyA.setVisibility(8);
        this.aYs.setVisibility(0);
    }

    public void hC(boolean z) {
        this.dVr = z;
        if (z) {
            if (this.fyD == null) {
                bjp();
            }
            this.fyD.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.fyD != null) {
            this.fyD.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.onChangeSkinType(this.fyz.getPageContext(), this.mSkinType);
    }

    public boolean aFB() {
        return this.dVr;
    }

    private void bjp() {
        this.fyD = (NavigationBar) ((ViewStub) this.fyz.findViewById(w.h.viewstub_navigation_bar_in_edit)).inflate();
        this.fyD.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.enter_forum_edit_cancel, new ac(this));
        this.fyE = this.fyD.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.enter_forum_edit_confirm, new ad(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.fyz.getPageContext().getPageActivity(), w.f.ds16), 0);
        this.fyE.setLayoutParams(layoutParams);
        this.fyD.onChangeSkinType(this.fyz.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void eR(boolean z) {
        if (aje()) {
            if (z) {
                if (this.cxw.getVisibility() != 0) {
                    this.cxw.setVisibility(0);
                    eT(true);
                    aq.c(this.cxw, w.g.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            eT(false);
            this.cxw.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eT(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cxv.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.fyz.getPageContext().getPageActivity(), w.f.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.g(this.fyz.getPageContext().getPageActivity(), w.f.ds20);
            }
            this.cxv.setLayoutParams(layoutParams);
        }
    }

    public void ae(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bAw.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.EG(), next.aN(this.fyz.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2 && TbadkCoreApplication.m9getInst().isThemeIconCover()) {
            this.bAw.ct(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bAw.ct(1);
        } else {
            this.bAw.ct(0);
        }
        this.bAw.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.adx = cVar.aDP;
            cVar2.mType = cVar.type;
            fragmentTabIndicator.setText(cVar.aDQ);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.fyz.getResources().getDimension(w.f.ds24));
                fragmentTabIndicator.setTextColorResId(w.e.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.aDR);
                fragmentTabIndicator.setContentTvTopMargin(this.fyz.getResources().getDimensionPixelSize(w.f.ds2));
            } else {
                fragmentTabIndicator.setTextSize(0, this.fyz.getResources().getDimension(w.f.fontsize32));
                fragmentTabIndicator.setTextColorResId(w.e.s_tabbar_text_color);
            }
            fragmentTabIndicator.dl(TbadkCoreApplication.m9getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.adw = fragmentTabIndicator;
            cVar2.ady = bVar;
            this.bAw.a(cVar2);
        }
    }

    public FragmentTabHost bjq() {
        return this.bAw;
    }

    public void bjr() {
        if (this.bAw != null) {
            if (this.bAw.getCurrentTabType() == 8 || this.bAw.getCurrentTabType() == 3 || this.bAw.getCurrentTabType() == 2 || this.bAw.getCurrentTabType() == 15) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                if (this.fyD != null) {
                    this.fyD.setVisibility(8);
                }
            } else {
                hC(aFB());
            }
            if (this.bAw.getCurrentTabType() != 1) {
                if (this.fyA != null) {
                    this.fyA.setVisibility(8);
                }
                if (this.aYs != null && this.bAw.getCurrentTabType() != 3) {
                    this.aYs.setVisibility(0);
                }
            }
        }
    }
}
