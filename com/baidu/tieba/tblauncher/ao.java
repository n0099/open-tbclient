package com.baidu.tieba.tblauncher;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
public class ao {
    private TextView aZr;
    private SlidingMenu bcE;
    private FragmentTabHost beK;
    private int cbU = -1;
    private boolean cbX;
    private int cvS;
    private ImageView dfA;
    private ImageView dfB;
    private MainTabActivity dfC;
    private HeadImageView dfD;
    private TbImageView dfE;
    private com.baidu.tieba.tbadkCore.f.e dfF;
    private View dfG;
    private NavigationBar dfu;
    private View dfv;
    private PluginErrorTipView dfw;
    private ImageView dfx;
    private ImageView dfy;
    private ImageView dfz;
    private NavigationBar mNavigationBar;

    public ao(MainTabActivity mainTabActivity) {
        this.dfC = mainTabActivity;
    }

    public void gF(boolean z) {
        this.beK = (FragmentTabHost) this.dfC.findViewById(i.f.tab_host);
        this.beK.setup(this.dfC.getSupportFragmentManager());
        this.beK.setFrameLayerClickListener(new ap(this));
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.beK.setShouldDrawIndicatorLine(false);
            this.beK.g(0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds10), 0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds10));
        }
        this.beK.setTabWidgetBackgroundRes(i.e.s_tabbar_bg);
        this.beK.setOnPageChangeListener(new az(this));
        OC();
        this.dfw = (PluginErrorTipView) this.dfC.findViewById(i.f.view_plugin_error_tip);
        azG();
        azE();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.dfC.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public boolean azD() {
        return this.dfz != null && this.dfz.getVisibility() == 0;
    }

    public void gG(boolean z) {
        if (this.dfz != null) {
            if (z) {
                this.dfz.setVisibility(0);
            } else {
                this.dfz.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.beK.onChangeSkinType(i);
        this.beK.getFragmentTabWidget().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.an.cy(i.e.s_tabbar_bg)));
        this.bcE.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.an.cx(i.e.s_leftbar_bg)));
        boolean z = i == 1;
        if (this.cvS != 0) {
            com.baidu.tbadk.core.util.an.i((View) this.aZr, this.cvS);
        }
        this.mNavigationBar.onChangeSkinType(this.dfC.getPageContext(), i);
        this.dfw.onChangeSkinType(this.dfC.getPageContext(), i);
        if (this.dfu != null) {
            this.dfu.onChangeSkinType(this.dfC.getPageContext(), i);
        }
        if (this.dfD != null && this.dfD.getVisibility() == 0) {
            this.dfD.setIsNight(z);
        }
        if (this.dfE != null && this.dfE.getVisibility() == 0) {
            com.baidu.tbadk.core.util.an.c(this.dfE, i.e.icon_news_down_bar_one);
        }
        this.dfF.e(this.dfC.getPageContext());
        com.baidu.tbadk.core.util.an.c(this.dfA, i.e.icon_news_down_bar_one);
        com.baidu.tbadk.core.util.an.a(this.dfz, i.e.icon_game_bg_s, i.e.icon_game_bg);
        com.baidu.tbadk.core.util.an.a(this.dfB, i.e.icon_search_bg_s, i.e.icon_search_bg);
        com.baidu.tbadk.core.util.an.a(this.dfy, i.e.icon_sign_bg_s, i.e.icon_sign_bg);
        com.baidu.tbadk.core.util.an.a(this.dfx, i.e.icon_remind_bg_s, i.e.icon_remind_bg);
    }

    public void z(float f) {
        if (this.dfD != null && this.dfE != null) {
            this.dfD.setAlphaValue(f);
            this.dfE.setAlphaValue(f);
            Drawable background = this.dfD.getBackground();
            if (background != null) {
                background.setAlpha((int) (255.0f * f));
                this.dfD.setBackgroundDrawable(background);
            }
            if (this.dfG != null) {
                if (Math.abs(f) < 1.0E-7f) {
                    this.dfG.setVisibility(8);
                } else {
                    this.dfG.setVisibility(0);
                }
            }
        }
    }

    private void azE() {
        this.bcE = new SlidingMenu(this.dfC.getPageContext().getPageActivity());
        this.bcE.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.an.cx(i.e.s_leftbar_bg)));
        this.bcE.setMode(0);
        this.bcE.setTouchModeAbove(1);
        int K = (int) (com.baidu.adp.lib.util.k.K(this.dfC.getPageContext().getPageActivity()) * 0.28f);
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds240);
        if (K <= dimensionPixelSize) {
            dimensionPixelSize = K;
        }
        this.bcE.setBehindOffset(dimensionPixelSize);
        this.bcE.setFadeEnabled(true);
        this.bcE.setFadeDegree(1.0f);
        this.bcE.setFadeType(0);
        this.bcE.setSettleDuration(400);
        azF();
        this.bcE.attachToActivity(this.dfC.getPageContext().getPageActivity(), 1, true);
        this.bcE.setOnAboveViewScrollListener(new bb(this));
        this.bcE.setAboveCanvasTransformer(new bc(this));
        this.bcE.setBehindCanvasTransformer(new bd(this));
        this.bcE.setOnOpenedListener(new be(this));
        this.bcE.setOnClosedListener(new bf(this));
    }

    public boolean isMenuShowing() {
        return this.bcE != null && this.bcE.isMenuShowing();
    }

    public void a(com.baidu.tbadk.data.e eVar, int i) {
        if (eVar != null) {
            View inflate = LayoutInflater.from(this.dfC.getPageContext().getPageActivity()).inflate(i.g.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(i.f.member_icon);
            TextView textView = (TextView) inflate.findViewById(i.f.member_died_line_tip);
            boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
            com.baidu.tbadk.core.util.an.b(textView, i.c.cp_cont_b, 1);
            if (!StringUtils.isNull(eVar.zZ())) {
                textView.setText(eVar.zZ());
            }
            if (!StringUtils.isNull(eVar.getUrl())) {
                tbImageView.d(eVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                com.baidu.tbadk.core.util.an.c(tbImageView, i.e.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dfC.getPageContext().getPageActivity());
            aVar.m(inflate);
            aVar.bG(i.c.cp_link_tip_d);
            aVar.b(i.h.member_i_know, new bg(this, aVar, i));
            String string = this.dfC.getPageContext().getString(i.h.member_continue_pay);
            if (i == 0) {
                string = this.dfC.getPageContext().getString(i.h.open_member);
            }
            aVar.a(string, new bh(this, aVar, i));
            aVar.ak(false);
            aVar.b(this.dfC.getPageContext()).sR();
            com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("show_member_deid_line", false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void azF() {
        if (this.dfF != null && this.dfF.aye() == null) {
            this.dfF.m(this.dfC.getPageContext());
            this.dfF.aya();
            this.bcE.setMenu(this.dfF.aye());
        }
    }

    private void azG() {
        this.dfF = new com.baidu.tieba.tbadkCore.f.e();
        this.dfF.a(new aq(this));
    }

    private void azH() {
        if (this.dfD != null) {
            this.dfD.setIsRound(true);
            this.dfD.setDefaultBgResource(0);
            this.dfD.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public void azI() {
        if (this.dfD != null) {
            this.dfD.d(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        }
    }

    public void gH(boolean z) {
        if (this.dfE != null) {
            if (z) {
                this.dfE.setVisibility(0);
                com.baidu.tbadk.core.util.an.c(this.dfE, i.e.icon_news_down_bar_one);
                return;
            }
            this.dfE.setVisibility(8);
            this.dfE.setImageDrawable(null);
        }
    }

    public HeadImageView azJ() {
        return this.dfD;
    }

    public void OC() {
        this.mNavigationBar = (NavigationBar) this.dfC.findViewById(i.f.view_navigation_bar);
        if (this.mNavigationBar != null) {
            try {
                this.dfG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.main_tab_top_navi_avatar, (View.OnClickListener) null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.dfG != null) {
                this.dfG.setOnClickListener(new ar(this));
                this.dfD = (HeadImageView) this.dfG.findViewById(i.f.top_navi_avatar_icon);
                this.dfE = (TbImageView) this.dfG.findViewById(i.f.top_navi_avatar_msg_icon);
                azH();
                azI();
            }
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.game_tip_view, (View.OnClickListener) null);
            this.dfz = (ImageView) addCustomView.findViewById(i.f.game_button_iv);
            this.dfA = (ImageView) addCustomView.findViewById(i.f.game_tip_msg_iv);
            this.dfz.setOnClickListener(new as(this));
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_maintab_message, (View.OnClickListener) null);
            this.dfx = (ImageView) addCustomView2.findViewById(i.f.maintab_message_button);
            this.dfx.setOnClickListener(this.dfC);
            this.aZr = (TextView) addCustomView2.findViewById(i.f.maintab_message_text);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.d(this.dfC.getPageContext().getPageActivity(), i.d.ds16), 0);
            this.dfB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_search, (View.OnClickListener) null);
            this.dfB.setLayoutParams(layoutParams);
            this.dfB.setVisibility(8);
            this.dfB.setOnClickListener(new at(this));
            this.dfy = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_signall, (View.OnClickListener) null);
            this.dfy.setLayoutParams(layoutParams);
            this.dfy.setVisibility(8);
            this.dfy.setOnClickListener(new au(this));
            this.mNavigationBar.setLoginClickListener(new av(this));
            this.mNavigationBar.setRegisterClickListener(new aw(this));
        }
    }

    public void gI(boolean z) {
        if (z) {
            this.dfy.setVisibility(0);
            this.dfB.setVisibility(8);
            return;
        }
        this.dfy.setVisibility(8);
        this.dfB.setVisibility(0);
    }

    public void dY(boolean z) {
        this.cbX = z;
        if (z) {
            if (this.dfu == null) {
                azK();
            }
            this.dfu.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.dfu != null) {
            this.dfu.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
    }

    public boolean adI() {
        return this.cbX;
    }

    private void azK() {
        this.dfu = (NavigationBar) ((ViewStub) this.dfC.findViewById(i.f.viewstub_navigation_bar_in_edit)).inflate();
        this.dfu.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.enter_forum_edit_cancel, new ax(this));
        this.dfv = this.dfu.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.enter_forum_edit_confirm, new ay(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.d(this.dfC.getPageContext().getPageActivity(), i.d.ds16), 0);
        this.dfv.setLayoutParams(layoutParams);
        this.dfu.onChangeSkinType(this.dfC.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void lD(int i) {
        TextView textView = this.aZr;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        com.baidu.tbadk.core.util.an.b(textView, i.c.top_msg_num_day, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            this.cvS = i.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            this.cvS = i.e.icon_news_head_prompt_two;
        } else {
            textView.setText("   ");
            this.cvS = i.e.icon_news_head_prompt_more;
        }
        com.baidu.tbadk.core.util.an.i((View) textView, this.cvS);
    }

    public void gJ(boolean z) {
        if (z) {
            if (this.dfA.getVisibility() != 0) {
                this.dfA.setVisibility(0);
                com.baidu.tbadk.core.util.an.c(this.dfA, i.e.icon_news_down_bar_one);
                return;
            }
            return;
        }
        this.dfA.setVisibility(4);
    }

    public void L(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.beK.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.dfC.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2 && TbadkCoreApplication.m411getInst().isThemeIconCover()) {
            this.beK.ca(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.beK.ca(1);
        } else {
            this.beK.ca(0);
        }
        this.beK.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.YK = cVar.atN;
            bVar2.mType = cVar.type;
            fragmentTabIndicator.setText(cVar.atO);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.dfC.getResources().getDimension(i.d.ds24));
                fragmentTabIndicator.setTextColorResId(i.c.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.atP);
                fragmentTabIndicator.setCompoundDrawablePadding(this.dfC.getResources().getDimensionPixelSize(i.d.ds1));
            } else {
                fragmentTabIndicator.setTextSize(0, this.dfC.getResources().getDimension(i.d.fontsize32));
                fragmentTabIndicator.setTextColorResId(i.c.s_tabbar_text_color);
            }
            fragmentTabIndicator.cP(TbadkCoreApplication.m411getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.YJ = fragmentTabIndicator;
            bVar2.YL = bVar;
            this.beK.a(bVar2);
        }
    }

    public void gK(boolean z) {
        if (!z) {
            this.bcE.setSlidingEnabled(false);
        } else if (MainTabActivityConfig.IS_SUPPORT_LEFT_BAR && (this.beK.getCurrentTabIndex() == 0 || this.bcE.isMenuShowing())) {
            this.bcE.setSlidingEnabled(true);
        } else {
            this.bcE.setSlidingEnabled(false);
        }
    }

    public FragmentTabHost azL() {
        return this.beK;
    }

    public SlidingMenu azM() {
        return this.bcE;
    }

    public com.baidu.tieba.tbadkCore.f.e azN() {
        return this.dfF;
    }

    public View azO() {
        return this.dfx;
    }

    public void setSlidingEnabled(boolean z) {
        if (this.bcE != null) {
            if (this.bcE.isMenuShowing()) {
                this.bcE.showContent(false);
            }
            this.bcE.setSlidingEnabled(z);
        }
    }
}
