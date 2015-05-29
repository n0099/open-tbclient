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
    private TextView aOX;
    private SlidingMenu aQd;
    private FragmentTabHost aRO;
    private int bVQ;
    private int cwa = -1;
    private NavigationBar cwb;
    private View cwc;
    private ImageView cwd;
    private ImageView cwe;
    private ImageView cwf;
    private ImageView cwg;
    private MainTabActivity cwh;
    private HeadImageView cwi;
    private TbImageView cwj;
    private com.baidu.tieba.tblauncher.a.d cwk;
    private boolean cwl;
    private View cwm;
    private NavigationBar mNavigationBar;

    public aj(MainTabActivity mainTabActivity) {
        this.cwh = mainTabActivity;
    }

    public void fm(boolean z) {
        this.aRO = (FragmentTabHost) this.cwh.findViewById(com.baidu.tieba.q.tab_host);
        this.aRO.setup(this.cwh.getSupportFragmentManager());
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aRO.setShouldDrawIndicatorLine(false);
            this.aRO.setTabWidgetViewHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds110));
            this.aRO.d(0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds2), 0, 0);
        }
        this.aRO.setTabWidgetBackgroundRes(com.baidu.tieba.p.bg_tabbar);
        this.aRO.setOnPageChangeListener(new ak(this));
        MM();
        aqp();
        aqn();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001314, this.cwh.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public boolean aqm() {
        return this.cwe != null && this.cwe.getVisibility() == 0;
    }

    public void fn(boolean z) {
        if (this.cwe != null) {
            if (z) {
                this.cwe.setVisibility(0);
            } else {
                this.cwe.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.aRO.onChangeSkinType(i);
        boolean z = i == 1;
        if (this.bVQ != 0) {
            com.baidu.tbadk.core.util.ay.i((View) this.aOX, this.bVQ);
        }
        this.mNavigationBar.onChangeSkinType(this.cwh.getPageContext(), i);
        if (this.cwb != null) {
            this.cwb.onChangeSkinType(this.cwh.getPageContext(), i);
        }
        if (this.cwi != null && this.cwi.getVisibility() == 0) {
            this.cwi.setIsNight(z);
        }
        if (this.cwj != null && this.cwj.getVisibility() == 0) {
            com.baidu.tbadk.core.util.ay.c(this.cwj, com.baidu.tieba.p.icon_news_down_bar_one);
        }
        this.cwk.d(this.cwh.getPageContext());
        com.baidu.tbadk.core.util.ay.c(this.cwf, com.baidu.tieba.p.icon_news_down_bar_one);
        com.baidu.tbadk.core.util.ay.c(this.cwe, com.baidu.tieba.p.icon_game_n);
    }

    public void y(float f) {
        if (this.cwi != null && this.cwj != null) {
            this.cwi.setAlphaValue(f);
            this.cwj.setAlphaValue(f);
            Drawable background = this.cwi.getBackground();
            if (background != null) {
                background.setAlpha((int) (255.0f * f));
                this.cwi.setBackgroundDrawable(background);
            }
            if (this.cwm != null) {
                if (Math.abs(f) < 1.0E-7f) {
                    this.cwm.setVisibility(8);
                } else {
                    this.cwm.setVisibility(0);
                }
            }
        }
    }

    private void aqn() {
        this.aQd = new SlidingMenu(this.cwh.getPageContext().getPageActivity());
        this.aQd.setBackgroundResource(com.baidu.tieba.p.bg_home);
        this.aQd.setMode(0);
        this.aQd.setTouchModeAbove(1);
        int M = (int) (com.baidu.adp.lib.util.n.M(this.cwh.getPageContext().getPageActivity()) * 0.28f);
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds240);
        if (M <= dimensionPixelSize) {
            dimensionPixelSize = M;
        }
        this.aQd.setBehindOffset(dimensionPixelSize);
        this.aQd.setFadeEnabled(true);
        this.aQd.setFadeDegree(1.0f);
        this.aQd.setFadeType(0);
        this.aQd.setSettleDuration(400);
        aqo();
        this.aQd.attachToActivity(this.cwh.getPageContext().getPageActivity(), 1, true);
        this.aQd.setOnAboveViewScrollListener(new au(this));
        this.aQd.setAboveCanvasTransformer(new av(this));
        this.aQd.setBehindCanvasTransformer(new aw(this));
        this.aQd.setOnOpenedListener(new ax(this));
        this.aQd.setOnClosedListener(new ay(this));
    }

    public boolean isMenuShowing() {
        return this.aQd != null && this.aQd.isMenuShowing();
    }

    public void a(com.baidu.tbadk.data.g gVar, int i) {
        if (gVar != null) {
            View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.cwh.getPageContext().getPageActivity(), com.baidu.tieba.r.show_member_died_line_layout, null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(com.baidu.tieba.q.member_icon);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.q.member_died_line_tip);
            boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
            com.baidu.tbadk.core.util.ay.b(textView, com.baidu.tieba.n.cp_cont_b, 1);
            if (!StringUtils.isNull(gVar.yO())) {
                textView.setText(gVar.yO());
            }
            if (!StringUtils.isNull(gVar.getUrl())) {
                tbImageView.c(gVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                com.baidu.tbadk.core.util.ay.c(tbImageView, com.baidu.tieba.p.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cwh.getPageContext().getPageActivity());
            aVar.l(inflate);
            aVar.bv(com.baidu.tieba.n.cp_link_tip_d);
            aVar.b(com.baidu.tieba.t.member_i_know, new az(this, aVar, i));
            String string = this.cwh.getPageContext().getString(com.baidu.tieba.t.member_continue_pay);
            if (i == 0) {
                string = this.cwh.getPageContext().getString(com.baidu.tieba.t.open_member);
            }
            aVar.a(string, new ba(this, aVar, i));
            aVar.ah(false);
            aVar.b(this.cwh.getPageContext()).rL();
            com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("show_member_deid_line", false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void aqo() {
        if (this.cwk != null && this.cwk.aqC() == null) {
            this.cwk.k(this.cwh.getPageContext());
            this.cwk.aqz();
            this.aQd.setMenu(this.cwk.aqC());
        }
    }

    private void aqp() {
        this.cwk = new com.baidu.tieba.tblauncher.a.d();
        this.cwk.a(new bb(this));
    }

    private void aqq() {
        if (this.cwi != null) {
            this.cwi.setIsRound(true);
            this.cwi.setDefaultBgResource(0);
            this.cwi.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.cwi.setDefaultResource(com.baidu.tieba.p.pic_mycenter_avatar_def);
        }
    }

    public void aqr() {
        if (this.cwi != null) {
            this.cwi.c(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        }
    }

    public void fo(boolean z) {
        if (this.cwj != null) {
            if (z) {
                this.cwj.setVisibility(0);
                com.baidu.tbadk.core.util.ay.c(this.cwj, com.baidu.tieba.p.icon_news_down_bar_one);
                return;
            }
            this.cwj.setVisibility(8);
            this.cwj.setImageDrawable(null);
        }
    }

    public void MM() {
        this.mNavigationBar = (NavigationBar) this.cwh.findViewById(com.baidu.tieba.q.view_navigation_bar);
        if (this.mNavigationBar != null) {
            try {
                this.cwm = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.r.main_tab_top_navi_avatar, (View.OnClickListener) null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.cwm != null) {
                this.cwm.setOnClickListener(new am(this));
                this.cwi = (HeadImageView) this.cwm.findViewById(com.baidu.tieba.q.top_navi_avatar_icon);
                this.cwj = (TbImageView) this.cwm.findViewById(com.baidu.tieba.q.top_navi_avatar_msg_icon);
                aqq();
                aqr();
            }
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.game_tip_view, (View.OnClickListener) null);
            this.cwe = (ImageView) addCustomView.findViewById(com.baidu.tieba.q.game_button_iv);
            this.cwf = (ImageView) addCustomView.findViewById(com.baidu.tieba.q.game_tip_msg_iv);
            this.cwe.setOnClickListener(new an(this));
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.nb_item_maintab_message, (View.OnClickListener) null);
            this.cwc = addCustomView2.findViewById(com.baidu.tieba.q.maintab_message_button);
            this.cwc.setOnClickListener(this.cwh);
            this.aOX = (TextView) addCustomView2.findViewById(com.baidu.tieba.q.maintab_message_text);
            this.cwg = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.widget_nb_item_search, (View.OnClickListener) null);
            this.cwg.setVisibility(8);
            this.cwg.setOnClickListener(new ao(this));
            this.cwd = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.widget_nb_item_signall, (View.OnClickListener) null);
            this.cwd.setVisibility(8);
            this.cwd.setOnClickListener(new ap(this));
            this.mNavigationBar.setLoginClickListener(new aq(this));
            this.mNavigationBar.setRegisterClickListener(new ar(this));
        }
    }

    public void fp(boolean z) {
        if (z) {
            this.cwd.setVisibility(0);
            this.cwg.setVisibility(8);
            return;
        }
        this.cwd.setVisibility(8);
        this.cwg.setVisibility(0);
    }

    public void fq(boolean z) {
        this.cwl = z;
        if (z) {
            if (this.cwb == null) {
                aqt();
            }
            this.cwb.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.cwb != null) {
            this.cwb.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
    }

    public boolean aqs() {
        return this.cwl;
    }

    private void aqt() {
        this.cwb = (NavigationBar) ((ViewStub) this.cwh.findViewById(com.baidu.tieba.q.viewstub_navigation_bar_in_edit)).inflate();
        this.cwb.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.r.enter_forum_edit_cancel, new as(this));
        this.cwb.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.enter_forum_edit_confirm, new at(this));
        this.cwb.onChangeSkinType(this.cwh.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void jd(int i) {
        TextView textView = this.aOX;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        com.baidu.tbadk.core.util.ay.b(textView, com.baidu.tieba.n.top_msg_num_day, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            this.bVQ = com.baidu.tieba.p.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            this.bVQ = com.baidu.tieba.p.icon_news_head_prompt_two;
        } else {
            textView.setText("   ");
            this.bVQ = com.baidu.tieba.p.icon_news_head_prompt_more;
        }
        com.baidu.tbadk.core.util.ay.i((View) textView, this.bVQ);
    }

    public void fr(boolean z) {
        if (z) {
            if (this.cwf.getVisibility() != 0) {
                this.cwf.setVisibility(0);
                com.baidu.tbadk.core.util.ay.c(this.cwf, com.baidu.tieba.p.icon_news_down_bar_one);
                return;
            }
            return;
        }
        this.cwf.setVisibility(4);
    }

    public void V(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.aRO.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next.AD(), next.aj(this.cwh.getPageContext().getPageActivity()));
            }
        }
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aRO.bP(1);
        } else {
            this.aRO.bP(0);
        }
        this.aRO.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.d dVar, FragmentTabIndicator fragmentTabIndicator) {
        if (dVar != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            bVar.TC = dVar.anf;
            bVar.mType = dVar.type;
            fragmentTabIndicator.setText(dVar.ang);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.cwh.getResources().getDimension(com.baidu.tieba.o.ds24));
                fragmentTabIndicator.setTextColorResId(com.baidu.tieba.n.main_tab_indicator);
                fragmentTabIndicator.setCompoundDrawablesTopResId(dVar.anh);
                fragmentTabIndicator.setCompoundDrawablePadding(this.cwh.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds1));
            } else {
                fragmentTabIndicator.setTextSize(0, this.cwh.getResources().getDimension(com.baidu.tieba.o.fontsize32));
                fragmentTabIndicator.setTextColorResId(com.baidu.tieba.n.main_bottom_button_color);
            }
            fragmentTabIndicator.cz(TbadkCoreApplication.m411getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar.TB = fragmentTabIndicator;
            this.aRO.a(bVar);
        }
    }

    public void fs(boolean z) {
        if (!z) {
            this.aQd.setSlidingEnabled(false);
        } else if (MainTabActivityConfig.IS_SUPPORT_LEFT_BAR && (this.aRO.getCurrentTabIndex() == 0 || this.aQd.isMenuShowing())) {
            this.aQd.setSlidingEnabled(true);
        } else {
            this.aQd.setSlidingEnabled(false);
        }
    }

    public FragmentTabHost aqu() {
        return this.aRO;
    }

    public SlidingMenu aqv() {
        return this.aQd;
    }

    public com.baidu.tieba.tblauncher.a.d aqw() {
        return this.cwk;
    }

    public View aqx() {
        return this.cwc;
    }

    public void setSlidingEnabled(boolean z) {
        if (this.aQd != null) {
            if (this.aQd.isMenuShowing()) {
                this.aQd.showContent(false);
            }
            this.aQd.setSlidingEnabled(z);
        }
    }
}
