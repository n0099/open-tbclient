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
    private SlidingMenu aFD;
    private TextView aHm;
    private FragmentTabHost aJm;
    private int bKJ;
    private int cdl = -1;
    private View cdm;
    private ImageView cdn;
    private ImageView cdo;
    private ImageView cdp;
    private MainTabActivity cdq;
    private HeadImageView cdr;
    private TbImageView cds;
    private d cdt;
    private View cdu;
    private NavigationBar mNavigationBar;

    public ai(MainTabActivity mainTabActivity) {
        this.cdq = mainTabActivity;
    }

    public void kC() {
        this.aJm = (FragmentTabHost) this.cdq.findViewById(com.baidu.tieba.w.tab_host);
        this.aJm.setup(this.cdq.getSupportFragmentManager());
        this.aJm.setShouldDrawIndicatorLine(false);
        this.aJm.setTabWidgetViewHeight(TbadkCoreApplication.m255getInst().getResources().getDimensionPixelSize(com.baidu.tieba.u.ds110));
        this.aJm.c(0, TbadkCoreApplication.m255getInst().getResources().getDimensionPixelSize(com.baidu.tieba.u.ds2), 0, 0);
        this.aJm.setTabWidgetBackgroundRes(com.baidu.tieba.v.bg_tabbar);
        this.aJm.setOnPageChangeListener(new aj(this));
        HH();
        ajp();
        ajn();
    }

    public boolean ajm() {
        return this.cdo != null && this.cdo.getVisibility() == 0;
    }

    public void eI(boolean z) {
        if (this.cdo != null) {
            if (z) {
                this.cdo.setVisibility(0);
            } else {
                this.cdo.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.aJm.onChangeSkinType(i);
        boolean z = i == 1;
        if (this.bKJ != 0) {
            bc.i((View) this.aHm, this.bKJ);
        }
        this.mNavigationBar.onChangeSkinType(this.cdq.getPageContext(), i);
        if (this.cdr != null && this.cdr.getVisibility() == 0) {
            this.cdr.setIsNight(z);
        }
        if (this.cds != null && this.cds.getVisibility() == 0) {
            bc.c(this.cds, com.baidu.tieba.v.icon_news_down_bar_one);
        }
        this.cdt.c(this.cdq.getPageContext());
        bc.c(this.cdp, com.baidu.tieba.v.icon_news_down_bar_one);
        bc.c(this.cdo, com.baidu.tieba.v.icon_game_n);
    }

    public void y(float f) {
        if (this.cdr != null && this.cds != null) {
            this.cdr.setAlphaValue(f);
            this.cds.setAlphaValue(f);
            Drawable background = this.cdr.getBackground();
            if (background != null) {
                background.setAlpha((int) (255.0f * f));
                this.cdr.setBackgroundDrawable(background);
            }
            if (this.cdu != null) {
                if (Math.abs(f) < 1.0E-7f) {
                    this.cdu.setVisibility(8);
                } else {
                    this.cdu.setVisibility(0);
                }
            }
        }
    }

    private void ajn() {
        this.aFD = new SlidingMenu(this.cdq.getPageContext().getPageActivity());
        this.aFD.setBackgroundResource(com.baidu.tieba.v.bg_home);
        this.aFD.setMode(0);
        this.aFD.setTouchModeAbove(1);
        this.aFD.setBehindOffset((int) (com.baidu.adp.lib.util.l.M(this.cdq.getPageContext().getPageActivity()) * 0.28f));
        this.aFD.setFadeEnabled(true);
        this.aFD.setFadeDegree(1.0f);
        this.aFD.setFadeType(0);
        this.aFD.setSettleDuration(400);
        ajo();
        this.aFD.attachToActivity(this.cdq.getPageContext().getPageActivity(), 1);
        this.aFD.setOnAboveViewScrollListener(new ap(this));
        this.aFD.setAboveCanvasTransformer(new aq(this));
        this.aFD.setBehindCanvasTransformer(new ar(this));
        this.aFD.setOnOpenedListener(new as(this));
        this.aFD.setOnClosedListener(new at(this));
    }

    public boolean isMenuShowing() {
        return this.aFD != null && this.aFD.isMenuShowing();
    }

    public void a(g gVar, int i) {
        if (gVar != null) {
            View inflate = b.ei().inflate(this.cdq.getPageContext().getPageActivity(), com.baidu.tieba.x.show_member_died_line_layout, null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(com.baidu.tieba.w.member_icon);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.member_died_line_tip);
            boolean z = TbadkCoreApplication.m255getInst().getSkinType() == 1;
            bc.b(textView, com.baidu.tieba.t.cp_cont_b, 1);
            if (!StringUtils.isNull(gVar.uF())) {
                textView.setText(gVar.uF());
            }
            if (!StringUtils.isNull(gVar.getUrl())) {
                tbImageView.d(gVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                bc.c(tbImageView, com.baidu.tieba.v.icon_vip_advanced);
            }
            a aVar = new a(this.cdq.getPageContext().getPageActivity());
            aVar.j(inflate);
            aVar.b(com.baidu.tieba.z.member_i_know, new au(this, aVar, i));
            String string = this.cdq.getPageContext().getString(com.baidu.tieba.z.member_continue_pay);
            if (i == 0) {
                string = this.cdq.getPageContext().getString(com.baidu.tieba.z.open_member);
            }
            aVar.a(string, new av(this, aVar, i));
            aVar.ai(false);
            aVar.b(this.cdq.getPageContext()).nQ();
            com.baidu.tbadk.core.sharedPref.b.oc().putBoolean("show_member_deid_line", false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void ajo() {
        if (this.cdt != null && this.cdt.ajF() == null) {
            this.cdt.h(this.cdq.getPageContext());
            this.cdt.ajC();
            this.aFD.setMenu(this.cdt.ajF());
        }
    }

    private void ajp() {
        this.cdt = new d();
        this.cdt.a(new aw(this));
    }

    public void ajq() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.b(ajw().getUserHeadView()).N(0).v(false);
        gVar.a(new al(this));
        com.baidu.adp.lib.guide.d dx = gVar.dx();
        dx.t(false);
        dx.i(this.cdq.getPageContext().getPageActivity());
    }

    private void ajr() {
        if (this.cdr != null) {
            this.cdr.setIsRound(true);
            this.cdr.setDefaultBgResource(0);
            this.cdr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.cdr.setDefaultResource(com.baidu.tieba.v.pic_mycenter_avatar_def);
        }
    }

    public void ajs() {
        if (this.cdr != null) {
            this.cdr.d(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        }
    }

    public void eJ(boolean z) {
        if (this.cds != null) {
            if (z) {
                this.cds.setVisibility(0);
                bc.c(this.cds, com.baidu.tieba.v.icon_news_down_bar_one);
                return;
            }
            this.cds.setVisibility(8);
            this.cds.setImageDrawable(null);
        }
    }

    public void HH() {
        this.mNavigationBar = (NavigationBar) this.cdq.findViewById(com.baidu.tieba.w.view_navigation_bar);
        if (this.mNavigationBar != null) {
            try {
                this.cdu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.x.main_tab_top_navi_avatar, (View.OnClickListener) null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.cdu != null) {
                this.cdu.setOnClickListener(new am(this));
                this.cdr = (HeadImageView) this.cdu.findViewById(com.baidu.tieba.w.top_navi_avatar_icon);
                this.cds = (TbImageView) this.cdu.findViewById(com.baidu.tieba.w.top_navi_avatar_msg_icon);
                ajr();
                ajs();
            }
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.game_tip_view, (View.OnClickListener) null);
            this.cdo = (ImageView) addCustomView.findViewById(com.baidu.tieba.w.game_button_iv);
            this.cdp = (ImageView) addCustomView.findViewById(com.baidu.tieba.w.game_tip_msg_iv);
            this.cdo.setOnClickListener(new an(this));
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.nb_item_maintab_message, (View.OnClickListener) null);
            this.cdm = addCustomView2.findViewById(com.baidu.tieba.w.maintab_message_button);
            this.cdm.setOnClickListener(this.cdq);
            this.aHm = (TextView) addCustomView2.findViewById(com.baidu.tieba.w.maintab_message_text);
            this.cdn = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.widget_nb_item_search, (View.OnClickListener) null);
            this.cdn.setOnClickListener(new ao(this));
        }
    }

    public void im(int i) {
        TextView textView = this.aHm;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        bc.b(textView, com.baidu.tieba.t.top_msg_num_day, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            this.bKJ = com.baidu.tieba.v.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            this.bKJ = com.baidu.tieba.v.icon_news_head_prompt_two;
        } else {
            textView.setText("   ");
            this.bKJ = com.baidu.tieba.v.icon_news_head_prompt_more;
        }
        bc.i((View) textView, this.bKJ);
    }

    public void eK(boolean z) {
        if (z) {
            if (this.cdp.getVisibility() != 0) {
                this.cdp.setVisibility(0);
                bc.c(this.cdp, com.baidu.tieba.v.icon_news_down_bar_one);
                return;
            }
            return;
        }
        this.cdp.setVisibility(4);
    }

    public void S(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.aJm.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null) {
                a(next.wq(), next.W(this.cdq.getPageContext().getPageActivity()));
            }
        }
        this.aJm.bL(1);
    }

    private void a(com.baidu.tbadk.mainTab.d dVar, FragmentTabIndicator fragmentTabIndicator) {
        if (dVar != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            bVar.GP = dVar.acw;
            bVar.mType = dVar.type;
            fragmentTabIndicator.setText(dVar.acx);
            fragmentTabIndicator.setTextSize(0, this.cdq.getResources().getDimension(com.baidu.tieba.u.ds24));
            fragmentTabIndicator.setTextColorResId(com.baidu.tieba.t.main_tab_indicator);
            fragmentTabIndicator.setCompoundDrawablesTopResId(dVar.acm);
            fragmentTabIndicator.setCompoundDrawablePadding(this.cdq.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds1));
            fragmentTabIndicator.ct(TbadkCoreApplication.m255getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar.GN = fragmentTabIndicator;
            this.aJm.a(bVar);
        }
    }

    public void ajt() {
        if (this.aJm.getCurrentTabIndex() == 0 || this.aFD.isMenuShowing()) {
            this.aFD.setSlidingEnabled(true);
        } else {
            this.aFD.setSlidingEnabled(false);
        }
    }

    public FragmentTabHost aju() {
        return this.aJm;
    }

    public SlidingMenu ajv() {
        return this.aFD;
    }

    public d ajw() {
        return this.cdt;
    }

    public View ajx() {
        return this.cdm;
    }
}
