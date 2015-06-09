package com.baidu.tieba.tblauncher;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class aj {
    private TextView aOY;
    private SlidingMenu aQe;
    private FragmentTabHost aRP;
    private int bVR;
    private int cwb = -1;
    private NavigationBar cwc;
    private View cwd;
    private ImageView cwe;
    private ImageView cwf;
    private ImageView cwg;
    private ImageView cwh;
    private MainTabActivity cwi;
    private HeadImageView cwj;
    private TbImageView cwk;
    private com.baidu.tieba.tblauncher.a.d cwl;
    private boolean cwm;
    private View cwn;
    private NavigationBar mNavigationBar;

    public aj(MainTabActivity mainTabActivity) {
        this.cwi = mainTabActivity;
    }

    public void fm(boolean z) {
        this.aRP = (FragmentTabHost) this.cwi.findViewById(com.baidu.tieba.q.tab_host);
        this.aRP.setup(this.cwi.getSupportFragmentManager());
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aRP.setShouldDrawIndicatorLine(false);
            this.aRP.setTabWidgetViewHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds110));
            this.aRP.d(0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds2), 0, 0);
        }
        this.aRP.setTabWidgetBackgroundRes(com.baidu.tieba.p.bg_tabbar);
        this.aRP.setOnPageChangeListener(new ak(this));
        MN();
        aqq();
        aqo();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001314, this.cwi.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public boolean aqn() {
        return this.cwf != null && this.cwf.getVisibility() == 0;
    }

    public void fn(boolean z) {
        if (this.cwf != null) {
            if (z) {
                this.cwf.setVisibility(0);
            } else {
                this.cwf.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.aRP.onChangeSkinType(i);
        boolean z = i == 1;
        if (this.bVR != 0) {
            com.baidu.tbadk.core.util.ay.i((View) this.aOY, this.bVR);
        }
        this.mNavigationBar.onChangeSkinType(this.cwi.getPageContext(), i);
        if (this.cwc != null) {
            this.cwc.onChangeSkinType(this.cwi.getPageContext(), i);
        }
        if (this.cwj != null && this.cwj.getVisibility() == 0) {
            this.cwj.setIsNight(z);
        }
        if (this.cwk != null && this.cwk.getVisibility() == 0) {
            com.baidu.tbadk.core.util.ay.c(this.cwk, com.baidu.tieba.p.icon_news_down_bar_one);
        }
        this.cwl.d(this.cwi.getPageContext());
        com.baidu.tbadk.core.util.ay.c(this.cwg, com.baidu.tieba.p.icon_news_down_bar_one);
        com.baidu.tbadk.core.util.ay.c(this.cwf, com.baidu.tieba.p.icon_game_n);
    }

    public void y(float f) {
        if (this.cwj != null && this.cwk != null) {
            this.cwj.setAlphaValue(f);
            this.cwk.setAlphaValue(f);
            Drawable background = this.cwj.getBackground();
            if (background != null) {
                background.setAlpha((int) (255.0f * f));
                this.cwj.setBackgroundDrawable(background);
            }
            if (this.cwn != null) {
                if (Math.abs(f) < 1.0E-7f) {
                    this.cwn.setVisibility(8);
                } else {
                    this.cwn.setVisibility(0);
                }
            }
        }
    }

    private void aqo() {
        this.aQe = new SlidingMenu(this.cwi.getPageContext().getPageActivity());
        this.aQe.setBackgroundResource(com.baidu.tieba.p.bg_home);
        this.aQe.setMode(0);
        this.aQe.setTouchModeAbove(1);
        int M = (int) (com.baidu.adp.lib.util.n.M(this.cwi.getPageContext().getPageActivity()) * 0.28f);
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds240);
        if (M <= dimensionPixelSize) {
            dimensionPixelSize = M;
        }
        this.aQe.setBehindOffset(dimensionPixelSize);
        this.aQe.setFadeEnabled(true);
        this.aQe.setFadeDegree(1.0f);
        this.aQe.setFadeType(0);
        this.aQe.setSettleDuration(400);
        aqp();
        this.aQe.attachToActivity(this.cwi.getPageContext().getPageActivity(), 1, true);
        this.aQe.setOnAboveViewScrollListener(new au(this));
        this.aQe.setAboveCanvasTransformer(new av(this));
        this.aQe.setBehindCanvasTransformer(new aw(this));
        this.aQe.setOnOpenedListener(new ax(this));
        this.aQe.setOnClosedListener(new ay(this));
    }

    public boolean isMenuShowing() {
        return this.aQe != null && this.aQe.isMenuShowing();
    }

    public void a(com.baidu.tbadk.data.g gVar, int i) {
        if (gVar != null) {
            View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.cwi.getPageContext().getPageActivity(), com.baidu.tieba.r.show_member_died_line_layout, null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(com.baidu.tieba.q.member_icon);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.q.member_died_line_tip);
            boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
            com.baidu.tbadk.core.util.ay.b(textView, com.baidu.tieba.n.cp_cont_b, 1);
            if (!StringUtils.isNull(gVar.yP())) {
                textView.setText(gVar.yP());
            }
            if (!StringUtils.isNull(gVar.getUrl())) {
                tbImageView.c(gVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                com.baidu.tbadk.core.util.ay.c(tbImageView, com.baidu.tieba.p.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cwi.getPageContext().getPageActivity());
            aVar.l(inflate);
            aVar.bv(com.baidu.tieba.n.cp_link_tip_d);
            aVar.b(com.baidu.tieba.t.member_i_know, new az(this, aVar, i));
            String string = this.cwi.getPageContext().getString(com.baidu.tieba.t.member_continue_pay);
            if (i == 0) {
                string = this.cwi.getPageContext().getString(com.baidu.tieba.t.open_member);
            }
            aVar.a(string, new ba(this, aVar, i));
            aVar.ah(false);
            aVar.b(this.cwi.getPageContext()).rL();
            com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("show_member_deid_line", false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void aqp() {
        if (this.cwl != null && this.cwl.aqD() == null) {
            this.cwl.k(this.cwi.getPageContext());
            this.cwl.aqA();
            this.aQe.setMenu(this.cwl.aqD());
        }
    }

    private void aqq() {
        this.cwl = new com.baidu.tieba.tblauncher.a.d();
        this.cwl.a(new bb(this));
    }

    private void aqr() {
        if (this.cwj != null) {
            this.cwj.setIsRound(true);
            this.cwj.setDefaultBgResource(0);
            this.cwj.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.cwj.setDefaultResource(com.baidu.tieba.p.pic_mycenter_avatar_def);
        }
    }

    public void aqs() {
        if (this.cwj != null) {
            this.cwj.c(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        }
    }

    public void fo(boolean z) {
        if (this.cwk != null) {
            if (z) {
                this.cwk.setVisibility(0);
                com.baidu.tbadk.core.util.ay.c(this.cwk, com.baidu.tieba.p.icon_news_down_bar_one);
                return;
            }
            this.cwk.setVisibility(8);
            this.cwk.setImageDrawable(null);
        }
    }

    public void MN() {
        this.mNavigationBar = (NavigationBar) this.cwi.findViewById(com.baidu.tieba.q.view_navigation_bar);
        if (this.mNavigationBar != null) {
            try {
                this.cwn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.r.main_tab_top_navi_avatar, (View.OnClickListener) null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.cwn != null) {
                this.cwn.setOnClickListener(new am(this));
                this.cwj = (HeadImageView) this.cwn.findViewById(com.baidu.tieba.q.top_navi_avatar_icon);
                this.cwk = (TbImageView) this.cwn.findViewById(com.baidu.tieba.q.top_navi_avatar_msg_icon);
                aqr();
                aqs();
            }
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.game_tip_view, (View.OnClickListener) null);
            this.cwf = (ImageView) addCustomView.findViewById(com.baidu.tieba.q.game_button_iv);
            this.cwg = (ImageView) addCustomView.findViewById(com.baidu.tieba.q.game_tip_msg_iv);
            this.cwf.setOnClickListener(new an(this));
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.nb_item_maintab_message, (View.OnClickListener) null);
            this.cwd = addCustomView2.findViewById(com.baidu.tieba.q.maintab_message_button);
            this.cwd.setOnClickListener(this.cwi);
            this.aOY = (TextView) addCustomView2.findViewById(com.baidu.tieba.q.maintab_message_text);
            this.cwh = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.widget_nb_item_search, (View.OnClickListener) null);
            this.cwh.setVisibility(8);
            this.cwh.setOnClickListener(new ao(this));
            this.cwe = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.widget_nb_item_signall, (View.OnClickListener) null);
            this.cwe.setVisibility(8);
            this.cwe.setOnClickListener(new ap(this));
            this.mNavigationBar.setLoginClickListener(new aq(this));
            this.mNavigationBar.setRegisterClickListener(new ar(this));
        }
    }

    public void fp(boolean z) {
        if (z) {
            this.cwe.setVisibility(0);
            this.cwh.setVisibility(8);
            return;
        }
        this.cwe.setVisibility(8);
        this.cwh.setVisibility(0);
    }

    public void fq(boolean z) {
        this.cwm = z;
        if (z) {
            if (this.cwc == null) {
                aqu();
            }
            this.cwc.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.cwc != null) {
            this.cwc.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
    }

    public boolean aqt() {
        return this.cwm;
    }

    private void aqu() {
        this.cwc = (NavigationBar) ((ViewStub) this.cwi.findViewById(com.baidu.tieba.q.viewstub_navigation_bar_in_edit)).inflate();
        this.cwc.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.r.enter_forum_edit_cancel, new as(this));
        this.cwc.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.enter_forum_edit_confirm, new at(this));
        this.cwc.onChangeSkinType(this.cwi.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void jd(int i) {
        TextView textView = this.aOY;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        com.baidu.tbadk.core.util.ay.b(textView, com.baidu.tieba.n.top_msg_num_day, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            this.bVR = com.baidu.tieba.p.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            this.bVR = com.baidu.tieba.p.icon_news_head_prompt_two;
        } else {
            textView.setText("   ");
            this.bVR = com.baidu.tieba.p.icon_news_head_prompt_more;
        }
        com.baidu.tbadk.core.util.ay.i((View) textView, this.bVR);
    }

    public void fr(boolean z) {
        if (z) {
            if (this.cwg.getVisibility() != 0) {
                this.cwg.setVisibility(0);
                com.baidu.tbadk.core.util.ay.c(this.cwg, com.baidu.tieba.p.icon_news_down_bar_one);
                return;
            }
            return;
        }
        this.cwg.setVisibility(4);
    }

    public void V(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.aRP.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next.AE(), next.aj(this.cwi.getPageContext().getPageActivity()));
            }
        }
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aRP.bP(1);
        } else {
            this.aRP.bP(0);
        }
        this.aRP.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.d dVar, FragmentTabIndicator fragmentTabIndicator) {
        if (dVar != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            bVar.TC = dVar.anf;
            bVar.mType = dVar.type;
            fragmentTabIndicator.setText(dVar.ang);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.cwi.getResources().getDimension(com.baidu.tieba.o.ds24));
                fragmentTabIndicator.setTextColorResId(com.baidu.tieba.n.main_tab_indicator);
                fragmentTabIndicator.setCompoundDrawablesTopResId(dVar.anh);
                fragmentTabIndicator.setCompoundDrawablePadding(this.cwi.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds1));
            } else {
                fragmentTabIndicator.setTextSize(0, this.cwi.getResources().getDimension(com.baidu.tieba.o.fontsize32));
                fragmentTabIndicator.setTextColorResId(com.baidu.tieba.n.main_bottom_button_color);
            }
            fragmentTabIndicator.cz(TbadkCoreApplication.m411getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar.TB = fragmentTabIndicator;
            this.aRP.a(bVar);
        }
    }

    public void fs(boolean z) {
        if (!z) {
            this.aQe.setSlidingEnabled(false);
        } else if (MainTabActivityConfig.IS_SUPPORT_LEFT_BAR && (this.aRP.getCurrentTabIndex() == 0 || this.aQe.isMenuShowing())) {
            this.aQe.setSlidingEnabled(true);
        } else {
            this.aQe.setSlidingEnabled(false);
        }
    }

    public FragmentTabHost aqv() {
        return this.aRP;
    }

    public SlidingMenu aqw() {
        return this.aQe;
    }

    public com.baidu.tieba.tblauncher.a.d aqx() {
        return this.cwl;
    }

    public View aqy() {
        return this.cwd;
    }

    public void setSlidingEnabled(boolean z) {
        if (this.aQe != null) {
            if (this.aQe.isMenuShowing()) {
                this.aQe.showContent(false);
            }
            this.aQe.setSlidingEnabled(z);
        }
    }
}
