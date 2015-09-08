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
public class am {
    private TextView aZf;
    private int bXw = -1;
    private boolean bXz;
    private SlidingMenu bbU;
    private FragmentTabHost bdG;
    private NavigationBar cVe;
    private PluginErrorTipView cVf;
    private View cVg;
    private ImageView cVh;
    private ImageView cVi;
    private ImageView cVj;
    private ImageView cVk;
    private MainTabActivity cVl;
    private HeadImageView cVm;
    private TbImageView cVn;
    private com.baidu.tieba.tblauncher.a.d cVo;
    private View cVp;
    private int coE;
    private NavigationBar mNavigationBar;

    public am(MainTabActivity mainTabActivity) {
        this.cVl = mainTabActivity;
    }

    public void gp(boolean z) {
        this.bdG = (FragmentTabHost) this.cVl.findViewById(i.f.tab_host);
        this.bdG.setup(this.cVl.getSupportFragmentManager());
        this.bdG.setFrameLayerClickListener(new an(this));
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bdG.setShouldDrawIndicatorLine(false);
            this.bdG.setTabWidgetViewHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds110));
            this.bdG.g(0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds2), 0, 0);
        }
        this.bdG.setTabWidgetBackgroundRes(i.e.bg_tabbar);
        this.bdG.setOnPageChangeListener(new ax(this));
        Oj();
        this.cVf = (PluginErrorTipView) this.cVl.findViewById(i.f.view_plugin_error_tip);
        awe();
        awc();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.cVl.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public boolean awb() {
        return this.cVi != null && this.cVi.getVisibility() == 0;
    }

    public void gq(boolean z) {
        if (this.cVi != null) {
            if (z) {
                this.cVi.setVisibility(0);
            } else {
                this.cVi.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.bdG.onChangeSkinType(i);
        boolean z = i == 1;
        if (this.coE != 0) {
            com.baidu.tbadk.core.util.al.h((View) this.aZf, this.coE);
        }
        this.mNavigationBar.onChangeSkinType(this.cVl.getPageContext(), i);
        this.cVf.onChangeSkinType(this.cVl.getPageContext(), i);
        if (this.cVe != null) {
            this.cVe.onChangeSkinType(this.cVl.getPageContext(), i);
        }
        if (this.cVm != null && this.cVm.getVisibility() == 0) {
            this.cVm.setIsNight(z);
        }
        if (this.cVn != null && this.cVn.getVisibility() == 0) {
            com.baidu.tbadk.core.util.al.c(this.cVn, i.e.icon_news_down_bar_one);
        }
        this.cVo.e(this.cVl.getPageContext());
        com.baidu.tbadk.core.util.al.c(this.cVj, i.e.icon_news_down_bar_one);
        com.baidu.tbadk.core.util.al.c(this.cVi, i.e.icon_game_n);
    }

    public void z(float f) {
        if (this.cVm != null && this.cVn != null) {
            this.cVm.setAlphaValue(f);
            this.cVn.setAlphaValue(f);
            Drawable background = this.cVm.getBackground();
            if (background != null) {
                background.setAlpha((int) (255.0f * f));
                this.cVm.setBackgroundDrawable(background);
            }
            if (this.cVp != null) {
                if (Math.abs(f) < 1.0E-7f) {
                    this.cVp.setVisibility(8);
                } else {
                    this.cVp.setVisibility(0);
                }
            }
        }
    }

    private void awc() {
        this.bbU = new SlidingMenu(this.cVl.getPageContext().getPageActivity());
        this.bbU.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.al.cx(i.e.bg_home)));
        this.bbU.setMode(0);
        this.bbU.setTouchModeAbove(1);
        int K = (int) (com.baidu.adp.lib.util.k.K(this.cVl.getPageContext().getPageActivity()) * 0.28f);
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds240);
        if (K <= dimensionPixelSize) {
            dimensionPixelSize = K;
        }
        this.bbU.setBehindOffset(dimensionPixelSize);
        this.bbU.setFadeEnabled(true);
        this.bbU.setFadeDegree(1.0f);
        this.bbU.setFadeType(0);
        this.bbU.setSettleDuration(400);
        awd();
        this.bbU.attachToActivity(this.cVl.getPageContext().getPageActivity(), 1, true);
        this.bbU.setOnAboveViewScrollListener(new az(this));
        this.bbU.setAboveCanvasTransformer(new ba(this));
        this.bbU.setBehindCanvasTransformer(new bb(this));
        this.bbU.setOnOpenedListener(new bc(this));
        this.bbU.setOnClosedListener(new bd(this));
    }

    public boolean isMenuShowing() {
        return this.bbU != null && this.bbU.isMenuShowing();
    }

    public void a(com.baidu.tbadk.data.f fVar, int i) {
        if (fVar != null) {
            View inflate = LayoutInflater.from(this.cVl.getPageContext().getPageActivity()).inflate(i.g.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(i.f.member_icon);
            TextView textView = (TextView) inflate.findViewById(i.f.member_died_line_tip);
            boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
            com.baidu.tbadk.core.util.al.b(textView, i.c.cp_cont_b, 1);
            if (!StringUtils.isNull(fVar.Am())) {
                textView.setText(fVar.Am());
            }
            if (!StringUtils.isNull(fVar.getUrl())) {
                tbImageView.d(fVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                com.baidu.tbadk.core.util.al.c(tbImageView, i.e.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVl.getPageContext().getPageActivity());
            aVar.m(inflate);
            aVar.bG(i.c.cp_link_tip_d);
            aVar.b(i.h.member_i_know, new be(this, aVar, i));
            String string = this.cVl.getPageContext().getString(i.h.member_continue_pay);
            if (i == 0) {
                string = this.cVl.getPageContext().getString(i.h.open_member);
            }
            aVar.a(string, new bf(this, aVar, i));
            aVar.ak(false);
            aVar.b(this.cVl.getPageContext()).sU();
            com.baidu.tbadk.core.sharedPref.b.tx().putBoolean("show_member_deid_line", false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void awd() {
        if (this.cVo != null && this.cVo.awx() == null) {
            this.cVo.m(this.cVl.getPageContext());
            this.cVo.awt();
            this.bbU.setMenu(this.cVo.awx());
        }
    }

    private void awe() {
        this.cVo = new com.baidu.tieba.tblauncher.a.d();
        this.cVo.a(new ao(this));
    }

    private void awf() {
        if (this.cVm != null) {
            this.cVm.setIsRound(true);
            this.cVm.setDefaultBgResource(0);
            this.cVm.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public void awg() {
        if (this.cVm != null) {
            this.cVm.d(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        }
    }

    public void gr(boolean z) {
        if (this.cVn != null) {
            if (z) {
                this.cVn.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(this.cVn, i.e.icon_news_down_bar_one);
                return;
            }
            this.cVn.setVisibility(8);
            this.cVn.setImageDrawable(null);
        }
    }

    public HeadImageView awh() {
        return this.cVm;
    }

    public void Oj() {
        this.mNavigationBar = (NavigationBar) this.cVl.findViewById(i.f.view_navigation_bar);
        if (this.mNavigationBar != null) {
            try {
                this.cVp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.main_tab_top_navi_avatar, (View.OnClickListener) null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.cVp != null) {
                this.cVp.setOnClickListener(new ap(this));
                this.cVm = (HeadImageView) this.cVp.findViewById(i.f.top_navi_avatar_icon);
                this.cVn = (TbImageView) this.cVp.findViewById(i.f.top_navi_avatar_msg_icon);
                awf();
                awg();
            }
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.game_tip_view, (View.OnClickListener) null);
            this.cVi = (ImageView) addCustomView.findViewById(i.f.game_button_iv);
            this.cVj = (ImageView) addCustomView.findViewById(i.f.game_tip_msg_iv);
            this.cVi.setOnClickListener(new aq(this));
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_maintab_message, (View.OnClickListener) null);
            this.cVg = addCustomView2.findViewById(i.f.maintab_message_button);
            this.cVg.setOnClickListener(this.cVl);
            this.aZf = (TextView) addCustomView2.findViewById(i.f.maintab_message_text);
            this.cVk = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_search, (View.OnClickListener) null);
            this.cVk.setVisibility(8);
            this.cVk.setOnClickListener(new ar(this));
            this.cVh = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_signall, (View.OnClickListener) null);
            this.cVh.setVisibility(8);
            this.cVh.setOnClickListener(new as(this));
            this.mNavigationBar.setLoginClickListener(new at(this));
            this.mNavigationBar.setRegisterClickListener(new au(this));
        }
    }

    public void gs(boolean z) {
        if (z) {
            this.cVh.setVisibility(0);
            this.cVk.setVisibility(8);
            return;
        }
        this.cVh.setVisibility(8);
        this.cVk.setVisibility(0);
    }

    public void dV(boolean z) {
        this.bXz = z;
        if (z) {
            if (this.cVe == null) {
                awi();
            }
            this.cVe.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.cVe != null) {
            this.cVe.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
    }

    public boolean abZ() {
        return this.bXz;
    }

    private void awi() {
        this.cVe = (NavigationBar) ((ViewStub) this.cVl.findViewById(i.f.viewstub_navigation_bar_in_edit)).inflate();
        this.cVe.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.enter_forum_edit_cancel, new av(this));
        this.cVe.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.enter_forum_edit_confirm, new aw(this));
        this.cVe.onChangeSkinType(this.cVl.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void kJ(int i) {
        TextView textView = this.aZf;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        com.baidu.tbadk.core.util.al.b(textView, i.c.top_msg_num_day, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            this.coE = i.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            this.coE = i.e.icon_news_head_prompt_two;
        } else {
            textView.setText("   ");
            this.coE = i.e.icon_news_head_prompt_more;
        }
        com.baidu.tbadk.core.util.al.h((View) textView, this.coE);
    }

    public void gt(boolean z) {
        if (z) {
            if (this.cVj.getVisibility() != 0) {
                this.cVj.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(this.cVj, i.e.icon_news_down_bar_one);
                return;
            }
            return;
        }
        this.cVj.setVisibility(4);
    }

    public void L(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bdG.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.cVl.getPageContext().getPageActivity()));
            }
        }
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bdG.ca(1);
        } else {
            this.bdG.ca(0);
        }
        this.bdG.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.YM = cVar.awz;
            bVar2.mType = cVar.type;
            fragmentTabIndicator.setText(cVar.awA);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.cVl.getResources().getDimension(i.d.ds24));
                fragmentTabIndicator.setTextColorResId(i.c.main_tab_indicator);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.awB);
                fragmentTabIndicator.setCompoundDrawablePadding(this.cVl.getResources().getDimensionPixelSize(i.d.ds1));
            } else {
                fragmentTabIndicator.setTextSize(0, this.cVl.getResources().getDimension(i.d.fontsize32));
                fragmentTabIndicator.setTextColorResId(i.c.main_bottom_button_color);
            }
            fragmentTabIndicator.cO(TbadkCoreApplication.m411getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.YL = fragmentTabIndicator;
            bVar2.YN = bVar;
            this.bdG.a(bVar2);
        }
    }

    public void gu(boolean z) {
        if (!z) {
            this.bbU.setSlidingEnabled(false);
        } else if (MainTabActivityConfig.IS_SUPPORT_LEFT_BAR && (this.bdG.getCurrentTabIndex() == 0 || this.bbU.isMenuShowing())) {
            this.bbU.setSlidingEnabled(true);
        } else {
            this.bbU.setSlidingEnabled(false);
        }
    }

    public FragmentTabHost awj() {
        return this.bdG;
    }

    public SlidingMenu awk() {
        return this.bbU;
    }

    public com.baidu.tieba.tblauncher.a.d awl() {
        return this.cVo;
    }

    public View awm() {
        return this.cVg;
    }

    public void setSlidingEnabled(boolean z) {
        if (this.bbU != null) {
            if (this.bbU.isMenuShowing()) {
                this.bbU.showContent(false);
            }
            this.bbU.setSlidingEnabled(z);
        }
    }
}
