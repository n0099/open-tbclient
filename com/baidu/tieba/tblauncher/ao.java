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
    private TextView aYU;
    private SlidingMenu bbO;
    private FragmentTabHost bdT;
    private int cbi = -1;
    private boolean cbl;
    private int cul;
    private NavigationBar dcL;
    private View dcM;
    private PluginErrorTipView dcN;
    private ImageView dcO;
    private ImageView dcP;
    private ImageView dcQ;
    private ImageView dcR;
    private ImageView dcS;
    private MainTabActivity dcT;
    private HeadImageView dcU;
    private TbImageView dcV;
    private com.baidu.tieba.tblauncher.a.e dcW;
    private View dcX;
    private NavigationBar mNavigationBar;

    public ao(MainTabActivity mainTabActivity) {
        this.dcT = mainTabActivity;
    }

    public void gz(boolean z) {
        this.bdT = (FragmentTabHost) this.dcT.findViewById(i.f.tab_host);
        this.bdT.setup(this.dcT.getSupportFragmentManager());
        this.bdT.setFrameLayerClickListener(new ap(this));
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bdT.setShouldDrawIndicatorLine(false);
            this.bdT.g(0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds10), 0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds10));
        }
        this.bdT.setTabWidgetBackgroundRes(i.e.s_tabbar_bg);
        this.bdT.setOnPageChangeListener(new az(this));
        Ok();
        this.dcN = (PluginErrorTipView) this.dcT.findViewById(i.f.view_plugin_error_tip);
        ayt();
        ayr();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.dcT.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public boolean ayq() {
        return this.dcQ != null && this.dcQ.getVisibility() == 0;
    }

    public void gA(boolean z) {
        if (this.dcQ != null) {
            if (z) {
                this.dcQ.setVisibility(0);
            } else {
                this.dcQ.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.bdT.onChangeSkinType(i);
        this.bdT.getFragmentTabWidget().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.am.cy(i.e.s_tabbar_bg)));
        this.bbO.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.am.cx(i.e.s_leftbar_bg)));
        boolean z = i == 1;
        if (this.cul != 0) {
            com.baidu.tbadk.core.util.am.i((View) this.aYU, this.cul);
        }
        this.mNavigationBar.onChangeSkinType(this.dcT.getPageContext(), i);
        this.dcN.onChangeSkinType(this.dcT.getPageContext(), i);
        if (this.dcL != null) {
            this.dcL.onChangeSkinType(this.dcT.getPageContext(), i);
        }
        if (this.dcU != null && this.dcU.getVisibility() == 0) {
            this.dcU.setIsNight(z);
        }
        if (this.dcV != null && this.dcV.getVisibility() == 0) {
            com.baidu.tbadk.core.util.am.c(this.dcV, i.e.icon_news_down_bar_one);
        }
        this.dcW.e(this.dcT.getPageContext());
        com.baidu.tbadk.core.util.am.c(this.dcR, i.e.icon_news_down_bar_one);
        com.baidu.tbadk.core.util.am.a(this.dcQ, i.e.icon_game_bg_s, i.e.icon_game_bg);
        com.baidu.tbadk.core.util.am.a(this.dcS, i.e.icon_search_bg_s, i.e.icon_search_bg);
        com.baidu.tbadk.core.util.am.a(this.dcP, i.e.icon_sign_bg_s, i.e.icon_sign_bg);
        com.baidu.tbadk.core.util.am.a(this.dcO, i.e.icon_remind_bg_s, i.e.icon_remind_bg);
    }

    public void z(float f) {
        if (this.dcU != null && this.dcV != null) {
            this.dcU.setAlphaValue(f);
            this.dcV.setAlphaValue(f);
            Drawable background = this.dcU.getBackground();
            if (background != null) {
                background.setAlpha((int) (255.0f * f));
                this.dcU.setBackgroundDrawable(background);
            }
            if (this.dcX != null) {
                if (Math.abs(f) < 1.0E-7f) {
                    this.dcX.setVisibility(8);
                } else {
                    this.dcX.setVisibility(0);
                }
            }
        }
    }

    private void ayr() {
        this.bbO = new SlidingMenu(this.dcT.getPageContext().getPageActivity());
        this.bbO.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.am.cx(i.e.s_leftbar_bg)));
        this.bbO.setMode(0);
        this.bbO.setTouchModeAbove(1);
        int K = (int) (com.baidu.adp.lib.util.k.K(this.dcT.getPageContext().getPageActivity()) * 0.28f);
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds240);
        if (K <= dimensionPixelSize) {
            dimensionPixelSize = K;
        }
        this.bbO.setBehindOffset(dimensionPixelSize);
        this.bbO.setFadeEnabled(true);
        this.bbO.setFadeDegree(1.0f);
        this.bbO.setFadeType(0);
        this.bbO.setSettleDuration(400);
        ays();
        this.bbO.attachToActivity(this.dcT.getPageContext().getPageActivity(), 1, true);
        this.bbO.setOnAboveViewScrollListener(new bb(this));
        this.bbO.setAboveCanvasTransformer(new bc(this));
        this.bbO.setBehindCanvasTransformer(new bd(this));
        this.bbO.setOnOpenedListener(new be(this));
        this.bbO.setOnClosedListener(new bf(this));
    }

    public boolean isMenuShowing() {
        return this.bbO != null && this.bbO.isMenuShowing();
    }

    public void a(com.baidu.tbadk.data.e eVar, int i) {
        if (eVar != null) {
            View inflate = LayoutInflater.from(this.dcT.getPageContext().getPageActivity()).inflate(i.g.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(i.f.member_icon);
            TextView textView = (TextView) inflate.findViewById(i.f.member_died_line_tip);
            boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
            com.baidu.tbadk.core.util.am.b(textView, i.c.cp_cont_b, 1);
            if (!StringUtils.isNull(eVar.zX())) {
                textView.setText(eVar.zX());
            }
            if (!StringUtils.isNull(eVar.getUrl())) {
                tbImageView.d(eVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                com.baidu.tbadk.core.util.am.c(tbImageView, i.e.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dcT.getPageContext().getPageActivity());
            aVar.m(inflate);
            aVar.bG(i.c.cp_link_tip_d);
            aVar.b(i.h.member_i_know, new bg(this, aVar, i));
            String string = this.dcT.getPageContext().getString(i.h.member_continue_pay);
            if (i == 0) {
                string = this.dcT.getPageContext().getString(i.h.open_member);
            }
            aVar.a(string, new bh(this, aVar, i));
            aVar.ak(false);
            aVar.b(this.dcT.getPageContext()).sR();
            com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("show_member_deid_line", false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void ays() {
        if (this.dcW != null && this.dcW.ayP() == null) {
            this.dcW.m(this.dcT.getPageContext());
            this.dcW.ayL();
            this.bbO.setMenu(this.dcW.ayP());
        }
    }

    private void ayt() {
        this.dcW = new com.baidu.tieba.tblauncher.a.e();
        this.dcW.a(new aq(this));
    }

    private void ayu() {
        if (this.dcU != null) {
            this.dcU.setIsRound(true);
            this.dcU.setDefaultBgResource(0);
            this.dcU.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public void ayv() {
        if (this.dcU != null) {
            this.dcU.d(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        }
    }

    public void gB(boolean z) {
        if (this.dcV != null) {
            if (z) {
                this.dcV.setVisibility(0);
                com.baidu.tbadk.core.util.am.c(this.dcV, i.e.icon_news_down_bar_one);
                return;
            }
            this.dcV.setVisibility(8);
            this.dcV.setImageDrawable(null);
        }
    }

    public HeadImageView ayw() {
        return this.dcU;
    }

    public void Ok() {
        this.mNavigationBar = (NavigationBar) this.dcT.findViewById(i.f.view_navigation_bar);
        if (this.mNavigationBar != null) {
            try {
                this.dcX = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.main_tab_top_navi_avatar, (View.OnClickListener) null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.dcX != null) {
                this.dcX.setOnClickListener(new ar(this));
                this.dcU = (HeadImageView) this.dcX.findViewById(i.f.top_navi_avatar_icon);
                this.dcV = (TbImageView) this.dcX.findViewById(i.f.top_navi_avatar_msg_icon);
                ayu();
                ayv();
            }
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.game_tip_view, (View.OnClickListener) null);
            this.dcQ = (ImageView) addCustomView.findViewById(i.f.game_button_iv);
            this.dcR = (ImageView) addCustomView.findViewById(i.f.game_tip_msg_iv);
            this.dcQ.setOnClickListener(new as(this));
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_maintab_message, (View.OnClickListener) null);
            this.dcO = (ImageView) addCustomView2.findViewById(i.f.maintab_message_button);
            this.dcO.setOnClickListener(this.dcT);
            this.aYU = (TextView) addCustomView2.findViewById(i.f.maintab_message_text);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.d(this.dcT.getPageContext().getPageActivity(), i.d.ds16), 0);
            this.dcS = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_search, (View.OnClickListener) null);
            this.dcS.setLayoutParams(layoutParams);
            this.dcS.setVisibility(8);
            this.dcS.setOnClickListener(new at(this));
            this.dcP = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_signall, (View.OnClickListener) null);
            this.dcP.setLayoutParams(layoutParams);
            this.dcP.setVisibility(8);
            this.dcP.setOnClickListener(new au(this));
            this.mNavigationBar.setLoginClickListener(new av(this));
            this.mNavigationBar.setRegisterClickListener(new aw(this));
        }
    }

    public void gC(boolean z) {
        if (z) {
            this.dcP.setVisibility(0);
            this.dcS.setVisibility(8);
            return;
        }
        this.dcP.setVisibility(8);
        this.dcS.setVisibility(0);
    }

    public void dW(boolean z) {
        this.cbl = z;
        if (z) {
            if (this.dcL == null) {
                ayx();
            }
            this.dcL.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.dcL != null) {
            this.dcL.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
    }

    public boolean adr() {
        return this.cbl;
    }

    private void ayx() {
        this.dcL = (NavigationBar) ((ViewStub) this.dcT.findViewById(i.f.viewstub_navigation_bar_in_edit)).inflate();
        this.dcL.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.enter_forum_edit_cancel, new ax(this));
        this.dcM = this.dcL.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.enter_forum_edit_confirm, new ay(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.d(this.dcT.getPageContext().getPageActivity(), i.d.ds16), 0);
        this.dcM.setLayoutParams(layoutParams);
        this.dcL.onChangeSkinType(this.dcT.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void lm(int i) {
        TextView textView = this.aYU;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        com.baidu.tbadk.core.util.am.b(textView, i.c.top_msg_num_day, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            this.cul = i.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            this.cul = i.e.icon_news_head_prompt_two;
        } else {
            textView.setText("   ");
            this.cul = i.e.icon_news_head_prompt_more;
        }
        com.baidu.tbadk.core.util.am.i((View) textView, this.cul);
    }

    public void gD(boolean z) {
        if (z) {
            if (this.dcR.getVisibility() != 0) {
                this.dcR.setVisibility(0);
                com.baidu.tbadk.core.util.am.c(this.dcR, i.e.icon_news_down_bar_one);
                return;
            }
            return;
        }
        this.dcR.setVisibility(4);
    }

    public void L(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bdT.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.dcT.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2 && TbadkCoreApplication.m411getInst().isThemeIconCover()) {
            this.bdT.ca(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bdT.ca(1);
        } else {
            this.bdT.ca(0);
        }
        this.bdT.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.YE = cVar.auY;
            bVar2.mType = cVar.type;
            fragmentTabIndicator.setText(cVar.auZ);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.dcT.getResources().getDimension(i.d.ds24));
                fragmentTabIndicator.setTextColorResId(i.c.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.ava);
                fragmentTabIndicator.setCompoundDrawablePadding(this.dcT.getResources().getDimensionPixelSize(i.d.ds1));
            } else {
                fragmentTabIndicator.setTextSize(0, this.dcT.getResources().getDimension(i.d.fontsize32));
                fragmentTabIndicator.setTextColorResId(i.c.s_tabbar_text_color);
            }
            fragmentTabIndicator.cP(TbadkCoreApplication.m411getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.YD = fragmentTabIndicator;
            bVar2.YF = bVar;
            this.bdT.a(bVar2);
        }
    }

    public void gE(boolean z) {
        if (!z) {
            this.bbO.setSlidingEnabled(false);
        } else if (MainTabActivityConfig.IS_SUPPORT_LEFT_BAR && (this.bdT.getCurrentTabIndex() == 0 || this.bbO.isMenuShowing())) {
            this.bbO.setSlidingEnabled(true);
        } else {
            this.bbO.setSlidingEnabled(false);
        }
    }

    public FragmentTabHost ayy() {
        return this.bdT;
    }

    public SlidingMenu ayz() {
        return this.bbO;
    }

    public com.baidu.tieba.tblauncher.a.e ayA() {
        return this.dcW;
    }

    public View ayB() {
        return this.dcO;
    }

    public void setSlidingEnabled(boolean z) {
        if (this.bbO != null) {
            if (this.bbO.isMenuShowing()) {
                this.bbO.showContent(false);
            }
            this.bbO.setSlidingEnabled(z);
        }
    }
}
