package com.baidu.tieba.tblauncher;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.g;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tblauncher.a.d;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ai {
    private SlidingMenu aFG;
    private TextView aHp;
    private FragmentTabHost aJp;
    private int bKK;
    private int cdm = -1;
    private View cdn;
    private ImageView cdo;
    private ImageView cdp;
    private ImageView cdq;
    private MainTabActivity cdr;
    private HeadImageView cds;
    private TbImageView cdt;
    private d cdu;
    private View cdv;
    private NavigationBar mNavigationBar;

    public ai(MainTabActivity mainTabActivity) {
        this.cdr = mainTabActivity;
    }

    public void kJ() {
        this.aJp = (FragmentTabHost) this.cdr.findViewById(com.baidu.tieba.w.tab_host);
        this.aJp.setup(this.cdr.getSupportFragmentManager());
        this.aJp.setShouldDrawIndicatorLine(false);
        this.aJp.setTabWidgetViewHeight(TbadkCoreApplication.m255getInst().getResources().getDimensionPixelSize(com.baidu.tieba.u.ds110));
        this.aJp.c(0, TbadkCoreApplication.m255getInst().getResources().getDimensionPixelSize(com.baidu.tieba.u.ds2), 0, 0);
        this.aJp.setTabWidgetBackgroundRes(com.baidu.tieba.v.bg_tabbar);
        this.aJp.setOnPageChangeListener(new aj(this));
        HN();
        aju();
        ajs();
    }

    public boolean ajr() {
        return this.cdp != null && this.cdp.getVisibility() == 0;
    }

    public void eI(boolean z) {
        if (this.cdp != null) {
            if (z) {
                this.cdp.setVisibility(0);
            } else {
                this.cdp.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.aJp.onChangeSkinType(i);
        boolean z = i == 1;
        if (this.bKK != 0) {
            bc.i((View) this.aHp, this.bKK);
        }
        this.mNavigationBar.onChangeSkinType(this.cdr.getPageContext(), i);
        if (this.cds != null && this.cds.getVisibility() == 0) {
            this.cds.setIsNight(z);
        }
        if (this.cdt != null && this.cdt.getVisibility() == 0) {
            bc.c(this.cdt, com.baidu.tieba.v.icon_news_down_bar_one);
        }
        this.cdu.c(this.cdr.getPageContext());
        bc.c(this.cdq, com.baidu.tieba.v.icon_news_down_bar_one);
        bc.c(this.cdp, com.baidu.tieba.v.icon_game_n);
    }

    public void y(float f) {
        if (this.cds != null && this.cdt != null) {
            this.cds.setAlphaValue(f);
            this.cdt.setAlphaValue(f);
            Drawable background = this.cds.getBackground();
            if (background != null) {
                background.setAlpha((int) (255.0f * f));
                this.cds.setBackgroundDrawable(background);
            }
            if (this.cdv != null) {
                if (Math.abs(f) < 1.0E-7f) {
                    this.cdv.setVisibility(8);
                } else {
                    this.cdv.setVisibility(0);
                }
            }
        }
    }

    private void ajs() {
        this.aFG = new SlidingMenu(this.cdr.getPageContext().getPageActivity());
        this.aFG.setBackgroundResource(com.baidu.tieba.v.bg_home);
        this.aFG.setMode(0);
        this.aFG.setTouchModeAbove(1);
        this.aFG.setBehindOffset((int) (com.baidu.adp.lib.util.l.M(this.cdr.getPageContext().getPageActivity()) * 0.28f));
        this.aFG.setFadeEnabled(true);
        this.aFG.setFadeDegree(1.0f);
        this.aFG.setFadeType(0);
        this.aFG.setSettleDuration(400);
        ajt();
        this.aFG.attachToActivity(this.cdr.getPageContext().getPageActivity(), 1);
        this.aFG.setOnAboveViewScrollListener(new ap(this));
        this.aFG.setAboveCanvasTransformer(new aq(this));
        this.aFG.setBehindCanvasTransformer(new ar(this));
        this.aFG.setOnOpenedListener(new as(this));
        this.aFG.setOnClosedListener(new at(this));
    }

    public boolean isMenuShowing() {
        return this.aFG != null && this.aFG.isMenuShowing();
    }

    public void a(g gVar, int i) {
        if (gVar != null) {
            View inflate = b.ei().inflate(this.cdr.getPageContext().getPageActivity(), com.baidu.tieba.x.show_member_died_line_layout, null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(com.baidu.tieba.w.member_icon);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.member_died_line_tip);
            boolean z = TbadkCoreApplication.m255getInst().getSkinType() == 1;
            bc.b(textView, com.baidu.tieba.t.cp_cont_b, 1);
            if (!StringUtils.isNull(gVar.uL())) {
                textView.setText(gVar.uL());
            }
            if (!StringUtils.isNull(gVar.getUrl())) {
                tbImageView.d(gVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                bc.c(tbImageView, com.baidu.tieba.v.icon_vip_advanced);
            }
            a aVar = new a(this.cdr.getPageContext().getPageActivity());
            aVar.j(inflate);
            aVar.b(com.baidu.tieba.z.member_i_know, new au(this, aVar, i));
            String string = this.cdr.getPageContext().getString(com.baidu.tieba.z.member_continue_pay);
            if (i == 0) {
                string = this.cdr.getPageContext().getString(com.baidu.tieba.z.open_member);
            }
            aVar.a(string, new av(this, aVar, i));
            aVar.ai(false);
            aVar.b(this.cdr.getPageContext()).nX();
            com.baidu.tbadk.core.sharedPref.b.oj().putBoolean("show_member_deid_line", false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void ajt() {
        if (this.cdu != null && this.cdu.ajK() == null) {
            this.cdu.h(this.cdr.getPageContext());
            this.cdu.ajH();
            this.aFG.setMenu(this.cdu.ajK());
        }
    }

    private void aju() {
        this.cdu = new d();
        this.cdu.a(new aw(this));
    }

    public void ajv() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.b(ajB().getUserHeadView()).N(0).v(false);
        gVar.a(new al(this));
        com.baidu.adp.lib.guide.d dx = gVar.dx();
        dx.t(false);
        dx.i(this.cdr.getPageContext().getPageActivity());
    }

    private void ajw() {
        if (this.cds != null) {
            this.cds.setIsRound(true);
            this.cds.setDefaultBgResource(0);
            this.cds.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.cds.setDefaultResource(com.baidu.tieba.v.pic_mycenter_avatar_def);
        }
    }

    public void ajx() {
        if (this.cds != null) {
            this.cds.d(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        }
    }

    public void eJ(boolean z) {
        if (this.cdt != null) {
            if (z) {
                this.cdt.setVisibility(0);
                bc.c(this.cdt, com.baidu.tieba.v.icon_news_down_bar_one);
                return;
            }
            this.cdt.setVisibility(8);
            this.cdt.setImageDrawable(null);
        }
    }

    public void HN() {
        this.mNavigationBar = (NavigationBar) this.cdr.findViewById(com.baidu.tieba.w.view_navigation_bar);
        if (this.mNavigationBar != null) {
            try {
                this.cdv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.x.main_tab_top_navi_avatar, (View.OnClickListener) null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.cdv != null) {
                this.cdv.setOnClickListener(new am(this));
                this.cds = (HeadImageView) this.cdv.findViewById(com.baidu.tieba.w.top_navi_avatar_icon);
                this.cdt = (TbImageView) this.cdv.findViewById(com.baidu.tieba.w.top_navi_avatar_msg_icon);
                ajw();
                ajx();
            }
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.game_tip_view, (View.OnClickListener) null);
            this.cdp = (ImageView) addCustomView.findViewById(com.baidu.tieba.w.game_button_iv);
            this.cdq = (ImageView) addCustomView.findViewById(com.baidu.tieba.w.game_tip_msg_iv);
            this.cdp.setOnClickListener(new an(this));
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.nb_item_maintab_message, (View.OnClickListener) null);
            this.cdn = addCustomView2.findViewById(com.baidu.tieba.w.maintab_message_button);
            this.cdn.setOnClickListener(this.cdr);
            this.aHp = (TextView) addCustomView2.findViewById(com.baidu.tieba.w.maintab_message_text);
            this.cdo = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.widget_nb_item_search, (View.OnClickListener) null);
            this.cdo.setOnClickListener(new ao(this));
        }
    }

    public void im(int i) {
        TextView textView = this.aHp;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        bc.b(textView, com.baidu.tieba.t.top_msg_num_day, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            this.bKK = com.baidu.tieba.v.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            this.bKK = com.baidu.tieba.v.icon_news_head_prompt_two;
        } else {
            textView.setText("   ");
            this.bKK = com.baidu.tieba.v.icon_news_head_prompt_more;
        }
        bc.i((View) textView, this.bKK);
    }

    public void eK(boolean z) {
        if (z) {
            if (this.cdq.getVisibility() != 0) {
                this.cdq.setVisibility(0);
                bc.c(this.cdq, com.baidu.tieba.v.icon_news_down_bar_one);
                return;
            }
            return;
        }
        this.cdq.setVisibility(4);
    }

    public void S(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.aJp.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null) {
                a(next.ww(), next.W(this.cdr.getPageContext().getPageActivity()));
            }
        }
        this.aJp.bL(1);
    }

    private void a(com.baidu.tbadk.mainTab.d dVar, FragmentTabIndicator fragmentTabIndicator) {
        if (dVar != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            bVar.GS = dVar.acz;
            bVar.mType = dVar.type;
            fragmentTabIndicator.setText(dVar.acA);
            fragmentTabIndicator.setTextSize(0, this.cdr.getResources().getDimension(com.baidu.tieba.u.ds24));
            fragmentTabIndicator.setTextColorResId(com.baidu.tieba.t.main_tab_indicator);
            fragmentTabIndicator.setCompoundDrawablesTopResId(dVar.acp);
            fragmentTabIndicator.setCompoundDrawablePadding(this.cdr.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds1));
            fragmentTabIndicator.ct(TbadkCoreApplication.m255getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar.GR = fragmentTabIndicator;
            this.aJp.a(bVar);
        }
    }

    public void ajy() {
        if (this.aJp.getCurrentTabIndex() == 0 || this.aFG.isMenuShowing()) {
            this.aFG.setSlidingEnabled(true);
        } else {
            this.aFG.setSlidingEnabled(false);
        }
    }

    public FragmentTabHost ajz() {
        return this.aJp;
    }

    public SlidingMenu ajA() {
        return this.aFG;
    }

    public d ajB() {
        return this.cdu;
    }

    public View ajC() {
        return this.cdn;
    }
}
