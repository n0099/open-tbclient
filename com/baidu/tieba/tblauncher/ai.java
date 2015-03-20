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
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ai {
    private TextView aMC;
    private SlidingMenu aNA;
    private FragmentTabHost aPm;
    private int bST;
    private int crB = -1;
    private NavigationBar crC;
    private View crD;
    private ImageView crE;
    private ImageView crF;
    private ImageView crG;
    private MainTabActivity crH;
    private HeadImageView crI;
    private TbImageView crJ;
    private com.baidu.tieba.tblauncher.a.d crK;
    private boolean crL;
    private View crM;
    private NavigationBar mNavigationBar;

    public ai(MainTabActivity mainTabActivity) {
        this.crH = mainTabActivity;
    }

    public void ov() {
        this.aPm = (FragmentTabHost) this.crH.findViewById(com.baidu.tieba.v.tab_host);
        this.aPm.setup(this.crH.getSupportFragmentManager());
        this.aPm.setShouldDrawIndicatorLine(false);
        this.aPm.setTabWidgetViewHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds110));
        this.aPm.d(0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds2), 0, 0);
        this.aPm.setTabWidgetBackgroundRes(com.baidu.tieba.u.bg_tabbar);
        this.aPm.setOnPageChangeListener(new aj(this));
        Lv();
        aoi();
        aog();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001314, this.crH.getPageContext()));
    }

    public boolean aof() {
        return this.crF != null && this.crF.getVisibility() == 0;
    }

    public void eV(boolean z) {
        if (this.crF != null) {
            if (z) {
                this.crF.setVisibility(0);
            } else {
                this.crF.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.aPm.onChangeSkinType(i);
        boolean z = i == 1;
        if (this.bST != 0) {
            ba.i((View) this.aMC, this.bST);
        }
        this.mNavigationBar.onChangeSkinType(this.crH.getPageContext(), i);
        if (this.crC != null) {
            this.crC.onChangeSkinType(this.crH.getPageContext(), i);
        }
        if (this.crI != null && this.crI.getVisibility() == 0) {
            this.crI.setIsNight(z);
        }
        if (this.crJ != null && this.crJ.getVisibility() == 0) {
            ba.c(this.crJ, com.baidu.tieba.u.icon_news_down_bar_one);
        }
        this.crK.f(this.crH.getPageContext());
        ba.c(this.crG, com.baidu.tieba.u.icon_news_down_bar_one);
        ba.c(this.crF, com.baidu.tieba.u.icon_game_n);
    }

    public void x(float f) {
        if (this.crI != null && this.crJ != null) {
            this.crI.setAlphaValue(f);
            this.crJ.setAlphaValue(f);
            Drawable background = this.crI.getBackground();
            if (background != null) {
                background.setAlpha((int) (255.0f * f));
                this.crI.setBackgroundDrawable(background);
            }
            if (this.crM != null) {
                if (Math.abs(f) < 1.0E-7f) {
                    this.crM.setVisibility(8);
                } else {
                    this.crM.setVisibility(0);
                }
            }
        }
    }

    private void aog() {
        this.aNA = new SlidingMenu(this.crH.getPageContext().getPageActivity());
        this.aNA.setBackgroundResource(com.baidu.tieba.u.bg_home);
        this.aNA.setMode(0);
        this.aNA.setTouchModeAbove(1);
        int M = (int) (com.baidu.adp.lib.util.n.M(this.crH.getPageContext().getPageActivity()) * 0.28f);
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds240);
        if (M <= dimensionPixelSize) {
            dimensionPixelSize = M;
        }
        this.aNA.setBehindOffset(dimensionPixelSize);
        this.aNA.setFadeEnabled(true);
        this.aNA.setFadeDegree(1.0f);
        this.aNA.setFadeType(0);
        this.aNA.setSettleDuration(400);
        aoh();
        this.aNA.attachToActivity(this.crH.getPageContext().getPageActivity(), 1);
        this.aNA.setOnAboveViewScrollListener(new ar(this));
        this.aNA.setAboveCanvasTransformer(new as(this));
        this.aNA.setBehindCanvasTransformer(new at(this));
        this.aNA.setOnOpenedListener(new au(this));
        this.aNA.setOnClosedListener(new av(this));
    }

    public boolean isMenuShowing() {
        return this.aNA != null && this.aNA.isMenuShowing();
    }

    public void a(com.baidu.tbadk.data.g gVar, int i) {
        if (gVar != null) {
            View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.crH.getPageContext().getPageActivity(), com.baidu.tieba.w.show_member_died_line_layout, null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(com.baidu.tieba.v.member_icon);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.member_died_line_tip);
            boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
            ba.b(textView, com.baidu.tieba.s.cp_cont_b, 1);
            if (!StringUtils.isNull(gVar.xV())) {
                textView.setText(gVar.xV());
            }
            if (!StringUtils.isNull(gVar.getUrl())) {
                tbImageView.c(gVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ba.c(tbImageView, com.baidu.tieba.u.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.crH.getPageContext().getPageActivity());
            aVar.j(inflate);
            aVar.b(com.baidu.tieba.y.member_i_know, new aw(this, aVar, i));
            String string = this.crH.getPageContext().getString(com.baidu.tieba.y.member_continue_pay);
            if (i == 0) {
                string = this.crH.getPageContext().getString(com.baidu.tieba.y.open_member);
            }
            aVar.a(string, new ax(this, aVar, i));
            aVar.ad(false);
            aVar.b(this.crH.getPageContext()).re();
            com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("show_member_deid_line", false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void aoh() {
        if (this.crK != null && this.crK.aoz() == null) {
            this.crK.k(this.crH.getPageContext());
            this.crK.aov();
            this.aNA.setMenu(this.crK.aoz());
        }
    }

    private void aoi() {
        this.crK = new com.baidu.tieba.tblauncher.a.d();
        this.crK.a(new ay(this));
    }

    public void aoj() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        if (aor() != null && aor().aox() != null) {
            gVar.b(aor().aox()).O(0).v(false);
            gVar.a(new al(this));
            com.baidu.adp.lib.guide.d gV = gVar.gV();
            gV.t(false);
            gV.i(this.crH.getPageContext().getPageActivity());
        }
    }

    private void aok() {
        if (this.crI != null) {
            this.crI.setIsRound(true);
            this.crI.setDefaultBgResource(0);
            this.crI.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.crI.setDefaultResource(com.baidu.tieba.u.pic_mycenter_avatar_def);
        }
    }

    public void aol() {
        if (this.crI != null) {
            this.crI.c(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        }
    }

    public void eW(boolean z) {
        if (this.crJ != null) {
            if (z) {
                this.crJ.setVisibility(0);
                ba.c(this.crJ, com.baidu.tieba.u.icon_news_down_bar_one);
                return;
            }
            this.crJ.setVisibility(8);
            this.crJ.setImageDrawable(null);
        }
    }

    public void Lv() {
        this.mNavigationBar = (NavigationBar) this.crH.findViewById(com.baidu.tieba.v.view_navigation_bar);
        if (this.mNavigationBar != null) {
            try {
                this.crM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.w.main_tab_top_navi_avatar, (View.OnClickListener) null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.crM != null) {
                this.crM.setOnClickListener(new am(this));
                this.crI = (HeadImageView) this.crM.findViewById(com.baidu.tieba.v.top_navi_avatar_icon);
                this.crJ = (TbImageView) this.crM.findViewById(com.baidu.tieba.v.top_navi_avatar_msg_icon);
                aok();
                aol();
            }
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.game_tip_view, (View.OnClickListener) null);
            this.crF = (ImageView) addCustomView.findViewById(com.baidu.tieba.v.game_button_iv);
            this.crG = (ImageView) addCustomView.findViewById(com.baidu.tieba.v.game_tip_msg_iv);
            this.crF.setOnClickListener(new an(this));
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_maintab_message, (View.OnClickListener) null);
            this.crD = addCustomView2.findViewById(com.baidu.tieba.v.maintab_message_button);
            this.crD.setOnClickListener(this.crH);
            this.aMC = (TextView) addCustomView2.findViewById(com.baidu.tieba.v.maintab_message_text);
            this.crE = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_search, (View.OnClickListener) null);
            this.crE.setOnClickListener(new ao(this));
        }
    }

    public void eX(boolean z) {
        this.crL = z;
        if (z) {
            if (this.crC == null) {
                aon();
            }
            this.crC.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.crC != null) {
            this.crC.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
    }

    public boolean aom() {
        return this.crL;
    }

    private void aon() {
        this.crC = (NavigationBar) ((ViewStub) this.crH.findViewById(com.baidu.tieba.v.viewstub_navigation_bar_in_edit)).inflate();
        this.crC.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.w.enter_forum_edit_cancel, new ap(this));
        this.crC.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.enter_forum_edit_confirm, new aq(this));
        this.crC.onChangeSkinType(this.crH.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void iE(int i) {
        TextView textView = this.aMC;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        ba.b(textView, com.baidu.tieba.s.top_msg_num_day, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            this.bST = com.baidu.tieba.u.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            this.bST = com.baidu.tieba.u.icon_news_head_prompt_two;
        } else {
            textView.setText("   ");
            this.bST = com.baidu.tieba.u.icon_news_head_prompt_more;
        }
        ba.i((View) textView, this.bST);
    }

    public void eY(boolean z) {
        if (z) {
            if (this.crG.getVisibility() != 0) {
                this.crG.setVisibility(0);
                ba.c(this.crG, com.baidu.tieba.u.icon_news_down_bar_one);
                return;
            }
            return;
        }
        this.crG.setVisibility(4);
    }

    public void X(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.aPm.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null) {
                a(next.zL(), next.af(this.crH.getPageContext().getPageActivity()));
            }
        }
        this.aPm.bM(1);
    }

    private void a(com.baidu.tbadk.mainTab.d dVar, FragmentTabIndicator fragmentTabIndicator) {
        if (dVar != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            bVar.SQ = dVar.alV;
            bVar.mType = dVar.type;
            fragmentTabIndicator.setText(dVar.alW);
            fragmentTabIndicator.setTextSize(0, this.crH.getResources().getDimension(com.baidu.tieba.t.ds24));
            fragmentTabIndicator.setTextColorResId(com.baidu.tieba.s.main_tab_indicator);
            fragmentTabIndicator.setCompoundDrawablesTopResId(dVar.alM);
            fragmentTabIndicator.setCompoundDrawablePadding(this.crH.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds1));
            fragmentTabIndicator.cu(TbadkCoreApplication.m411getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar.SP = fragmentTabIndicator;
            this.aPm.a(bVar);
        }
    }

    public void aoo() {
        if (this.aPm.getCurrentTabIndex() == 0 || this.aNA.isMenuShowing()) {
            this.aNA.setSlidingEnabled(true);
        } else {
            this.aNA.setSlidingEnabled(false);
        }
    }

    public FragmentTabHost aop() {
        return this.aPm;
    }

    public SlidingMenu aoq() {
        return this.aNA;
    }

    public com.baidu.tieba.tblauncher.a.d aor() {
        return this.crK;
    }

    public View aos() {
        return this.crD;
    }
}
