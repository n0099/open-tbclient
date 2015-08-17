package com.baidu.tieba.tblauncher;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ai {
    private TextView aYN;
    private SlidingMenu bbA;
    private FragmentTabHost bdl;
    private int cMC = -1;
    private NavigationBar cMD;
    private PluginErrorTipView cME;
    private View cMF;
    private ImageView cMG;
    private ImageView cMH;
    private ImageView cMI;
    private ImageView cMJ;
    private MainTabActivity cMK;
    private HeadImageView cML;
    private TbImageView cMM;
    private com.baidu.tieba.tblauncher.a.d cMN;
    private boolean cMO;
    private View cMP;
    private int cnD;
    private NavigationBar mNavigationBar;

    public ai(MainTabActivity mainTabActivity) {
        this.cMK = mainTabActivity;
    }

    public void fE(boolean z) {
        this.bdl = (FragmentTabHost) this.cMK.findViewById(i.f.tab_host);
        this.bdl.setup(this.cMK.getSupportFragmentManager());
        this.bdl.setFrameLayerClickListener(new aj(this));
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bdl.setShouldDrawIndicatorLine(false);
            this.bdl.setTabWidgetViewHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds110));
            this.bdl.g(0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds2), 0, 0);
        }
        this.bdl.setTabWidgetBackgroundRes(i.e.bg_tabbar);
        this.bdl.setOnPageChangeListener(new at(this));
        Oi();
        this.cME = (PluginErrorTipView) this.cMK.findViewById(i.f.view_plugin_error_tip);
        arR();
        arP();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.cMK.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public boolean arO() {
        return this.cMH != null && this.cMH.getVisibility() == 0;
    }

    public void fF(boolean z) {
        if (this.cMH != null) {
            if (z) {
                this.cMH.setVisibility(0);
            } else {
                this.cMH.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.bdl.onChangeSkinType(i);
        boolean z = i == 1;
        if (this.cnD != 0) {
            com.baidu.tbadk.core.util.al.i((View) this.aYN, this.cnD);
        }
        this.mNavigationBar.onChangeSkinType(this.cMK.getPageContext(), i);
        this.cME.onChangeSkinType(this.cMK.getPageContext(), i);
        if (this.cMD != null) {
            this.cMD.onChangeSkinType(this.cMK.getPageContext(), i);
        }
        if (this.cML != null && this.cML.getVisibility() == 0) {
            this.cML.setIsNight(z);
        }
        if (this.cMM != null && this.cMM.getVisibility() == 0) {
            com.baidu.tbadk.core.util.al.c(this.cMM, i.e.icon_news_down_bar_one);
        }
        this.cMN.e(this.cMK.getPageContext());
        com.baidu.tbadk.core.util.al.c(this.cMI, i.e.icon_news_down_bar_one);
        com.baidu.tbadk.core.util.al.c(this.cMH, i.e.icon_game_n);
    }

    public void y(float f) {
        if (this.cML != null && this.cMM != null) {
            this.cML.setAlphaValue(f);
            this.cMM.setAlphaValue(f);
            Drawable background = this.cML.getBackground();
            if (background != null) {
                background.setAlpha((int) (255.0f * f));
                this.cML.setBackgroundDrawable(background);
            }
            if (this.cMP != null) {
                if (Math.abs(f) < 1.0E-7f) {
                    this.cMP.setVisibility(8);
                } else {
                    this.cMP.setVisibility(0);
                }
            }
        }
    }

    private void arP() {
        this.bbA = new SlidingMenu(this.cMK.getPageContext().getPageActivity());
        this.bbA.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.al.cs(i.e.bg_home)));
        this.bbA.setMode(0);
        this.bbA.setTouchModeAbove(1);
        int K = (int) (com.baidu.adp.lib.util.k.K(this.cMK.getPageContext().getPageActivity()) * 0.28f);
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds240);
        if (K <= dimensionPixelSize) {
            dimensionPixelSize = K;
        }
        this.bbA.setBehindOffset(dimensionPixelSize);
        this.bbA.setFadeEnabled(true);
        this.bbA.setFadeDegree(1.0f);
        this.bbA.setFadeType(0);
        this.bbA.setSettleDuration(400);
        arQ();
        this.bbA.attachToActivity(this.cMK.getPageContext().getPageActivity(), 1, true);
        this.bbA.setOnAboveViewScrollListener(new av(this));
        this.bbA.setAboveCanvasTransformer(new aw(this));
        this.bbA.setBehindCanvasTransformer(new ax(this));
        this.bbA.setOnOpenedListener(new ay(this));
        this.bbA.setOnClosedListener(new az(this));
    }

    public boolean isMenuShowing() {
        return this.bbA != null && this.bbA.isMenuShowing();
    }

    public void a(com.baidu.tbadk.data.f fVar, int i) {
        if (fVar != null) {
            View inflate = LayoutInflater.from(this.cMK.getPageContext().getPageActivity()).inflate(i.g.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(i.f.member_icon);
            TextView textView = (TextView) inflate.findViewById(i.f.member_died_line_tip);
            boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
            com.baidu.tbadk.core.util.al.b(textView, i.c.cp_cont_b, 1);
            if (!StringUtils.isNull(fVar.zZ())) {
                textView.setText(fVar.zZ());
            }
            if (!StringUtils.isNull(fVar.getUrl())) {
                tbImageView.d(fVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                com.baidu.tbadk.core.util.al.c(tbImageView, i.e.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cMK.getPageContext().getPageActivity());
            aVar.m(inflate);
            aVar.bD(i.c.cp_link_tip_d);
            aVar.b(i.C0057i.member_i_know, new ba(this, aVar, i));
            String string = this.cMK.getPageContext().getString(i.C0057i.member_continue_pay);
            if (i == 0) {
                string = this.cMK.getPageContext().getString(i.C0057i.open_member);
            }
            aVar.a(string, new bb(this, aVar, i));
            aVar.ak(false);
            aVar.b(this.cMK.getPageContext()).sP();
            com.baidu.tbadk.core.sharedPref.b.ts().putBoolean("show_member_deid_line", false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void arQ() {
        if (this.cMN != null && this.cMN.ase() == null) {
            this.cMN.m(this.cMK.getPageContext());
            this.cMN.asb();
            this.bbA.setMenu(this.cMN.ase());
        }
    }

    private void arR() {
        this.cMN = new com.baidu.tieba.tblauncher.a.d();
        this.cMN.a(new ak(this));
    }

    private void arS() {
        if (this.cML != null) {
            this.cML.setIsRound(true);
            this.cML.setDefaultBgResource(0);
            this.cML.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public void arT() {
        if (this.cML != null) {
            this.cML.d(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        }
    }

    public void fG(boolean z) {
        if (this.cMM != null) {
            if (z) {
                this.cMM.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(this.cMM, i.e.icon_news_down_bar_one);
                return;
            }
            this.cMM.setVisibility(8);
            this.cMM.setImageDrawable(null);
        }
    }

    public void Oi() {
        this.mNavigationBar = (NavigationBar) this.cMK.findViewById(i.f.view_navigation_bar);
        if (this.mNavigationBar != null) {
            try {
                this.cMP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.main_tab_top_navi_avatar, (View.OnClickListener) null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.cMP != null) {
                this.cMP.setOnClickListener(new al(this));
                this.cML = (HeadImageView) this.cMP.findViewById(i.f.top_navi_avatar_icon);
                this.cMM = (TbImageView) this.cMP.findViewById(i.f.top_navi_avatar_msg_icon);
                arS();
                arT();
            }
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.game_tip_view, (View.OnClickListener) null);
            this.cMH = (ImageView) addCustomView.findViewById(i.f.game_button_iv);
            this.cMI = (ImageView) addCustomView.findViewById(i.f.game_tip_msg_iv);
            this.cMH.setOnClickListener(new am(this));
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_maintab_message, (View.OnClickListener) null);
            this.cMF = addCustomView2.findViewById(i.f.maintab_message_button);
            this.cMF.setOnClickListener(this.cMK);
            this.aYN = (TextView) addCustomView2.findViewById(i.f.maintab_message_text);
            this.cMJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_search, (View.OnClickListener) null);
            this.cMJ.setVisibility(8);
            this.cMJ.setOnClickListener(new an(this));
            this.cMG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_signall, (View.OnClickListener) null);
            this.cMG.setVisibility(8);
            this.cMG.setOnClickListener(new ao(this));
            this.mNavigationBar.setLoginClickListener(new ap(this));
            this.mNavigationBar.setRegisterClickListener(new aq(this));
        }
    }

    public void fH(boolean z) {
        if (z) {
            this.cMG.setVisibility(0);
            this.cMJ.setVisibility(8);
            return;
        }
        this.cMG.setVisibility(8);
        this.cMJ.setVisibility(0);
    }

    public void fI(boolean z) {
        this.cMO = z;
        if (z) {
            if (this.cMD == null) {
                arV();
            }
            this.cMD.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.cMD != null) {
            this.cMD.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
    }

    public boolean arU() {
        return this.cMO;
    }

    private void arV() {
        this.cMD = (NavigationBar) ((ViewStub) this.cMK.findViewById(i.f.viewstub_navigation_bar_in_edit)).inflate();
        this.cMD.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.enter_forum_edit_cancel, new ar(this));
        this.cMD.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.enter_forum_edit_confirm, new as(this));
        this.cMD.onChangeSkinType(this.cMK.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void jY(int i) {
        TextView textView = this.aYN;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        com.baidu.tbadk.core.util.al.b(textView, i.c.top_msg_num_day, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            this.cnD = i.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            this.cnD = i.e.icon_news_head_prompt_two;
        } else {
            textView.setText("   ");
            this.cnD = i.e.icon_news_head_prompt_more;
        }
        com.baidu.tbadk.core.util.al.i((View) textView, this.cnD);
    }

    public void fJ(boolean z) {
        if (z) {
            if (this.cMI.getVisibility() != 0) {
                this.cMI.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(this.cMI, i.e.icon_news_down_bar_one);
                return;
            }
            return;
        }
        this.cMI.setVisibility(4);
    }

    public void aa(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bdl.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.CA(), next.an(this.cMK.getPageContext().getPageActivity()));
            }
        }
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bdl.bX(1);
        } else {
            this.bdl.bX(0);
        }
        this.bdl.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.YD = cVar.auR;
            bVar2.mType = cVar.type;
            fragmentTabIndicator.setText(cVar.auS);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.cMK.getResources().getDimension(i.d.ds24));
                fragmentTabIndicator.setTextColorResId(i.c.main_tab_indicator);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.auT);
                fragmentTabIndicator.setCompoundDrawablePadding(this.cMK.getResources().getDimensionPixelSize(i.d.ds1));
            } else {
                fragmentTabIndicator.setTextSize(0, this.cMK.getResources().getDimension(i.d.fontsize32));
                fragmentTabIndicator.setTextColorResId(i.c.main_bottom_button_color);
            }
            fragmentTabIndicator.cI(TbadkCoreApplication.m411getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.YC = fragmentTabIndicator;
            bVar2.YE = bVar;
            this.bdl.a(bVar2);
        }
    }

    public void fK(boolean z) {
        if (!z) {
            this.bbA.setSlidingEnabled(false);
        } else if (MainTabActivityConfig.IS_SUPPORT_LEFT_BAR && (this.bdl.getCurrentTabIndex() == 0 || this.bbA.isMenuShowing())) {
            this.bbA.setSlidingEnabled(true);
        } else {
            this.bbA.setSlidingEnabled(false);
        }
    }

    public FragmentTabHost arW() {
        return this.bdl;
    }

    public SlidingMenu arX() {
        return this.bbA;
    }

    public com.baidu.tieba.tblauncher.a.d arY() {
        return this.cMN;
    }

    public View arZ() {
        return this.cMF;
    }

    public void setSlidingEnabled(boolean z) {
        if (this.bbA != null) {
            if (this.bbA.isMenuShowing()) {
                this.bbA.showContent(false);
            }
            this.bbA.setSlidingEnabled(z);
        }
    }
}
