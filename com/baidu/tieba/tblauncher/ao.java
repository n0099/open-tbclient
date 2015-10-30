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
    private TextView aZf;
    private SlidingMenu bbZ;
    private FragmentTabHost bee;
    private int cbt = -1;
    private boolean cbw;
    private int cuw;
    private NavigationBar ddl;
    private View ddm;
    private PluginErrorTipView ddn;
    private ImageView ddo;
    private ImageView ddp;
    private ImageView ddq;
    private ImageView ddr;
    private ImageView dds;
    private MainTabActivity ddt;
    private HeadImageView ddu;
    private TbImageView ddv;
    private com.baidu.tieba.tblauncher.a.e ddw;
    private View ddx;
    private NavigationBar mNavigationBar;

    public ao(MainTabActivity mainTabActivity) {
        this.ddt = mainTabActivity;
    }

    public void gz(boolean z) {
        this.bee = (FragmentTabHost) this.ddt.findViewById(i.f.tab_host);
        this.bee.setup(this.ddt.getSupportFragmentManager());
        this.bee.setFrameLayerClickListener(new ap(this));
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bee.setShouldDrawIndicatorLine(false);
            this.bee.g(0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds10), 0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds10));
        }
        this.bee.setTabWidgetBackgroundRes(i.e.s_tabbar_bg);
        this.bee.setOnPageChangeListener(new az(this));
        Og();
        this.ddn = (PluginErrorTipView) this.ddt.findViewById(i.f.view_plugin_error_tip);
        ayz();
        ayx();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.ddt.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public boolean ayw() {
        return this.ddq != null && this.ddq.getVisibility() == 0;
    }

    public void gA(boolean z) {
        if (this.ddq != null) {
            if (z) {
                this.ddq.setVisibility(0);
            } else {
                this.ddq.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.bee.onChangeSkinType(i);
        this.bee.getFragmentTabWidget().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.an.cy(i.e.s_tabbar_bg)));
        this.bbZ.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.an.cx(i.e.s_leftbar_bg)));
        boolean z = i == 1;
        if (this.cuw != 0) {
            com.baidu.tbadk.core.util.an.i((View) this.aZf, this.cuw);
        }
        this.mNavigationBar.onChangeSkinType(this.ddt.getPageContext(), i);
        this.ddn.onChangeSkinType(this.ddt.getPageContext(), i);
        if (this.ddl != null) {
            this.ddl.onChangeSkinType(this.ddt.getPageContext(), i);
        }
        if (this.ddu != null && this.ddu.getVisibility() == 0) {
            this.ddu.setIsNight(z);
        }
        if (this.ddv != null && this.ddv.getVisibility() == 0) {
            com.baidu.tbadk.core.util.an.c(this.ddv, i.e.icon_news_down_bar_one);
        }
        this.ddw.e(this.ddt.getPageContext());
        com.baidu.tbadk.core.util.an.c(this.ddr, i.e.icon_news_down_bar_one);
        com.baidu.tbadk.core.util.an.a(this.ddq, i.e.icon_game_bg_s, i.e.icon_game_bg);
        com.baidu.tbadk.core.util.an.a(this.dds, i.e.icon_search_bg_s, i.e.icon_search_bg);
        com.baidu.tbadk.core.util.an.a(this.ddp, i.e.icon_sign_bg_s, i.e.icon_sign_bg);
        com.baidu.tbadk.core.util.an.a(this.ddo, i.e.icon_remind_bg_s, i.e.icon_remind_bg);
    }

    public void z(float f) {
        if (this.ddu != null && this.ddv != null) {
            this.ddu.setAlphaValue(f);
            this.ddv.setAlphaValue(f);
            Drawable background = this.ddu.getBackground();
            if (background != null) {
                background.setAlpha((int) (255.0f * f));
                this.ddu.setBackgroundDrawable(background);
            }
            if (this.ddx != null) {
                if (Math.abs(f) < 1.0E-7f) {
                    this.ddx.setVisibility(8);
                } else {
                    this.ddx.setVisibility(0);
                }
            }
        }
    }

    private void ayx() {
        this.bbZ = new SlidingMenu(this.ddt.getPageContext().getPageActivity());
        this.bbZ.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.an.cx(i.e.s_leftbar_bg)));
        this.bbZ.setMode(0);
        this.bbZ.setTouchModeAbove(1);
        int K = (int) (com.baidu.adp.lib.util.k.K(this.ddt.getPageContext().getPageActivity()) * 0.28f);
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds240);
        if (K <= dimensionPixelSize) {
            dimensionPixelSize = K;
        }
        this.bbZ.setBehindOffset(dimensionPixelSize);
        this.bbZ.setFadeEnabled(true);
        this.bbZ.setFadeDegree(1.0f);
        this.bbZ.setFadeType(0);
        this.bbZ.setSettleDuration(400);
        ayy();
        this.bbZ.attachToActivity(this.ddt.getPageContext().getPageActivity(), 1, true);
        this.bbZ.setOnAboveViewScrollListener(new bb(this));
        this.bbZ.setAboveCanvasTransformer(new bc(this));
        this.bbZ.setBehindCanvasTransformer(new bd(this));
        this.bbZ.setOnOpenedListener(new be(this));
        this.bbZ.setOnClosedListener(new bf(this));
    }

    public boolean isMenuShowing() {
        return this.bbZ != null && this.bbZ.isMenuShowing();
    }

    public void a(com.baidu.tbadk.data.e eVar, int i) {
        if (eVar != null) {
            View inflate = LayoutInflater.from(this.ddt.getPageContext().getPageActivity()).inflate(i.g.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(i.f.member_icon);
            TextView textView = (TextView) inflate.findViewById(i.f.member_died_line_tip);
            boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
            com.baidu.tbadk.core.util.an.b(textView, i.c.cp_cont_b, 1);
            if (!StringUtils.isNull(eVar.zU())) {
                textView.setText(eVar.zU());
            }
            if (!StringUtils.isNull(eVar.getUrl())) {
                tbImageView.d(eVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                com.baidu.tbadk.core.util.an.c(tbImageView, i.e.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ddt.getPageContext().getPageActivity());
            aVar.m(inflate);
            aVar.bG(i.c.cp_link_tip_d);
            aVar.b(i.h.member_i_know, new bg(this, aVar, i));
            String string = this.ddt.getPageContext().getString(i.h.member_continue_pay);
            if (i == 0) {
                string = this.ddt.getPageContext().getString(i.h.open_member);
            }
            aVar.a(string, new bh(this, aVar, i));
            aVar.ak(false);
            aVar.b(this.ddt.getPageContext()).sO();
            com.baidu.tbadk.core.sharedPref.b.tr().putBoolean("show_member_deid_line", false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void ayy() {
        if (this.ddw != null && this.ddw.ayV() == null) {
            this.ddw.m(this.ddt.getPageContext());
            this.ddw.ayR();
            this.bbZ.setMenu(this.ddw.ayV());
        }
    }

    private void ayz() {
        this.ddw = new com.baidu.tieba.tblauncher.a.e();
        this.ddw.a(new aq(this));
    }

    private void ayA() {
        if (this.ddu != null) {
            this.ddu.setIsRound(true);
            this.ddu.setDefaultBgResource(0);
            this.ddu.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public void ayB() {
        if (this.ddu != null) {
            this.ddu.d(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        }
    }

    public void gB(boolean z) {
        if (this.ddv != null) {
            if (z) {
                this.ddv.setVisibility(0);
                com.baidu.tbadk.core.util.an.c(this.ddv, i.e.icon_news_down_bar_one);
                return;
            }
            this.ddv.setVisibility(8);
            this.ddv.setImageDrawable(null);
        }
    }

    public HeadImageView ayC() {
        return this.ddu;
    }

    public void Og() {
        this.mNavigationBar = (NavigationBar) this.ddt.findViewById(i.f.view_navigation_bar);
        if (this.mNavigationBar != null) {
            try {
                this.ddx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.main_tab_top_navi_avatar, (View.OnClickListener) null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.ddx != null) {
                this.ddx.setOnClickListener(new ar(this));
                this.ddu = (HeadImageView) this.ddx.findViewById(i.f.top_navi_avatar_icon);
                this.ddv = (TbImageView) this.ddx.findViewById(i.f.top_navi_avatar_msg_icon);
                ayA();
                ayB();
            }
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.game_tip_view, (View.OnClickListener) null);
            this.ddq = (ImageView) addCustomView.findViewById(i.f.game_button_iv);
            this.ddr = (ImageView) addCustomView.findViewById(i.f.game_tip_msg_iv);
            this.ddq.setOnClickListener(new as(this));
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_maintab_message, (View.OnClickListener) null);
            this.ddo = (ImageView) addCustomView2.findViewById(i.f.maintab_message_button);
            this.ddo.setOnClickListener(this.ddt);
            this.aZf = (TextView) addCustomView2.findViewById(i.f.maintab_message_text);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.d(this.ddt.getPageContext().getPageActivity(), i.d.ds16), 0);
            this.dds = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_search, (View.OnClickListener) null);
            this.dds.setLayoutParams(layoutParams);
            this.dds.setVisibility(8);
            this.dds.setOnClickListener(new at(this));
            this.ddp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_signall, (View.OnClickListener) null);
            this.ddp.setLayoutParams(layoutParams);
            this.ddp.setVisibility(8);
            this.ddp.setOnClickListener(new au(this));
            this.mNavigationBar.setLoginClickListener(new av(this));
            this.mNavigationBar.setRegisterClickListener(new aw(this));
        }
    }

    public void gC(boolean z) {
        if (z) {
            this.ddp.setVisibility(0);
            this.dds.setVisibility(8);
            return;
        }
        this.ddp.setVisibility(8);
        this.dds.setVisibility(0);
    }

    public void dW(boolean z) {
        this.cbw = z;
        if (z) {
            if (this.ddl == null) {
                ayD();
            }
            this.ddl.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.ddl != null) {
            this.ddl.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
    }

    public boolean adn() {
        return this.cbw;
    }

    private void ayD() {
        this.ddl = (NavigationBar) ((ViewStub) this.ddt.findViewById(i.f.viewstub_navigation_bar_in_edit)).inflate();
        this.ddl.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.enter_forum_edit_cancel, new ax(this));
        this.ddm = this.ddl.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.enter_forum_edit_confirm, new ay(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.d(this.ddt.getPageContext().getPageActivity(), i.d.ds16), 0);
        this.ddm.setLayoutParams(layoutParams);
        this.ddl.onChangeSkinType(this.ddt.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void lo(int i) {
        TextView textView = this.aZf;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        com.baidu.tbadk.core.util.an.b(textView, i.c.top_msg_num_day, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            this.cuw = i.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            this.cuw = i.e.icon_news_head_prompt_two;
        } else {
            textView.setText("   ");
            this.cuw = i.e.icon_news_head_prompt_more;
        }
        com.baidu.tbadk.core.util.an.i((View) textView, this.cuw);
    }

    public void gD(boolean z) {
        if (z) {
            if (this.ddr.getVisibility() != 0) {
                this.ddr.setVisibility(0);
                com.baidu.tbadk.core.util.an.c(this.ddr, i.e.icon_news_down_bar_one);
                return;
            }
            return;
        }
        this.ddr.setVisibility(4);
    }

    public void L(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bee.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.ddt.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2 && TbadkCoreApplication.m411getInst().isThemeIconCover()) {
            this.bee.ca(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bee.ca(1);
        } else {
            this.bee.ca(0);
        }
        this.bee.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.YG = cVar.auZ;
            bVar2.mType = cVar.type;
            fragmentTabIndicator.setText(cVar.ava);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.ddt.getResources().getDimension(i.d.ds24));
                fragmentTabIndicator.setTextColorResId(i.c.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.avb);
                fragmentTabIndicator.setCompoundDrawablePadding(this.ddt.getResources().getDimensionPixelSize(i.d.ds1));
            } else {
                fragmentTabIndicator.setTextSize(0, this.ddt.getResources().getDimension(i.d.fontsize32));
                fragmentTabIndicator.setTextColorResId(i.c.s_tabbar_text_color);
            }
            fragmentTabIndicator.cP(TbadkCoreApplication.m411getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar2.YF = fragmentTabIndicator;
            bVar2.YH = bVar;
            this.bee.a(bVar2);
        }
    }

    public void gE(boolean z) {
        if (!z) {
            this.bbZ.setSlidingEnabled(false);
        } else if (MainTabActivityConfig.IS_SUPPORT_LEFT_BAR && (this.bee.getCurrentTabIndex() == 0 || this.bbZ.isMenuShowing())) {
            this.bbZ.setSlidingEnabled(true);
        } else {
            this.bbZ.setSlidingEnabled(false);
        }
    }

    public FragmentTabHost ayE() {
        return this.bee;
    }

    public SlidingMenu ayF() {
        return this.bbZ;
    }

    public com.baidu.tieba.tblauncher.a.e ayG() {
        return this.ddw;
    }

    public View ayH() {
        return this.ddo;
    }

    public void setSlidingEnabled(boolean z) {
        if (this.bbZ != null) {
            if (this.bbZ.isMenuShowing()) {
                this.bbZ.showContent(false);
            }
            this.bbZ.setSlidingEnabled(z);
        }
    }
}
