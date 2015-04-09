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
    private TextView aMN;
    private SlidingMenu aNR;
    private FragmentTabHost aPD;
    private int bTj;
    private int crR = -1;
    private NavigationBar crS;
    private View crT;
    private ImageView crU;
    private ImageView crV;
    private ImageView crW;
    private MainTabActivity crX;
    private HeadImageView crY;
    private TbImageView crZ;
    private com.baidu.tieba.tblauncher.a.d csa;
    private boolean csb;
    private View csc;
    private NavigationBar mNavigationBar;

    public ai(MainTabActivity mainTabActivity) {
        this.crX = mainTabActivity;
    }

    public void ov() {
        this.aPD = (FragmentTabHost) this.crX.findViewById(com.baidu.tieba.v.tab_host);
        this.aPD.setup(this.crX.getSupportFragmentManager());
        this.aPD.setShouldDrawIndicatorLine(false);
        this.aPD.setTabWidgetViewHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds110));
        this.aPD.d(0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds2), 0, 0);
        this.aPD.setTabWidgetBackgroundRes(com.baidu.tieba.u.bg_tabbar);
        this.aPD.setOnPageChangeListener(new aj(this));
        LH();
        aox();
        aov();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001314, this.crX.getPageContext()));
    }

    public boolean aou() {
        return this.crV != null && this.crV.getVisibility() == 0;
    }

    public void eT(boolean z) {
        if (this.crV != null) {
            if (z) {
                this.crV.setVisibility(0);
            } else {
                this.crV.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.aPD.onChangeSkinType(i);
        boolean z = i == 1;
        if (this.bTj != 0) {
            ba.i((View) this.aMN, this.bTj);
        }
        this.mNavigationBar.onChangeSkinType(this.crX.getPageContext(), i);
        if (this.crS != null) {
            this.crS.onChangeSkinType(this.crX.getPageContext(), i);
        }
        if (this.crY != null && this.crY.getVisibility() == 0) {
            this.crY.setIsNight(z);
        }
        if (this.crZ != null && this.crZ.getVisibility() == 0) {
            ba.c(this.crZ, com.baidu.tieba.u.icon_news_down_bar_one);
        }
        this.csa.f(this.crX.getPageContext());
        ba.c(this.crW, com.baidu.tieba.u.icon_news_down_bar_one);
        ba.c(this.crV, com.baidu.tieba.u.icon_game_n);
    }

    public void x(float f) {
        if (this.crY != null && this.crZ != null) {
            this.crY.setAlphaValue(f);
            this.crZ.setAlphaValue(f);
            Drawable background = this.crY.getBackground();
            if (background != null) {
                background.setAlpha((int) (255.0f * f));
                this.crY.setBackgroundDrawable(background);
            }
            if (this.csc != null) {
                if (Math.abs(f) < 1.0E-7f) {
                    this.csc.setVisibility(8);
                } else {
                    this.csc.setVisibility(0);
                }
            }
        }
    }

    private void aov() {
        this.aNR = new SlidingMenu(this.crX.getPageContext().getPageActivity());
        this.aNR.setBackgroundResource(com.baidu.tieba.u.bg_home);
        this.aNR.setMode(0);
        this.aNR.setTouchModeAbove(1);
        int M = (int) (com.baidu.adp.lib.util.n.M(this.crX.getPageContext().getPageActivity()) * 0.28f);
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds240);
        if (M <= dimensionPixelSize) {
            dimensionPixelSize = M;
        }
        this.aNR.setBehindOffset(dimensionPixelSize);
        this.aNR.setFadeEnabled(true);
        this.aNR.setFadeDegree(1.0f);
        this.aNR.setFadeType(0);
        this.aNR.setSettleDuration(400);
        aow();
        this.aNR.attachToActivity(this.crX.getPageContext().getPageActivity(), 1);
        this.aNR.setOnAboveViewScrollListener(new ar(this));
        this.aNR.setAboveCanvasTransformer(new as(this));
        this.aNR.setBehindCanvasTransformer(new at(this));
        this.aNR.setOnOpenedListener(new au(this));
        this.aNR.setOnClosedListener(new av(this));
    }

    public boolean isMenuShowing() {
        return this.aNR != null && this.aNR.isMenuShowing();
    }

    public void a(com.baidu.tbadk.data.g gVar, int i) {
        if (gVar != null) {
            View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.crX.getPageContext().getPageActivity(), com.baidu.tieba.w.show_member_died_line_layout, null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(com.baidu.tieba.v.member_icon);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.member_died_line_tip);
            boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
            ba.b(textView, com.baidu.tieba.s.cp_cont_b, 1);
            if (!StringUtils.isNull(gVar.yb())) {
                textView.setText(gVar.yb());
            }
            if (!StringUtils.isNull(gVar.getUrl())) {
                tbImageView.c(gVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ba.c(tbImageView, com.baidu.tieba.u.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.crX.getPageContext().getPageActivity());
            aVar.j(inflate);
            aVar.b(com.baidu.tieba.y.member_i_know, new aw(this, aVar, i));
            String string = this.crX.getPageContext().getString(com.baidu.tieba.y.member_continue_pay);
            if (i == 0) {
                string = this.crX.getPageContext().getString(com.baidu.tieba.y.open_member);
            }
            aVar.a(string, new ax(this, aVar, i));
            aVar.ad(false);
            aVar.b(this.crX.getPageContext()).re();
            com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("show_member_deid_line", false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void aow() {
        if (this.csa != null && this.csa.aoO() == null) {
            this.csa.k(this.crX.getPageContext());
            this.csa.aoK();
            this.aNR.setMenu(this.csa.aoO());
        }
    }

    private void aox() {
        this.csa = new com.baidu.tieba.tblauncher.a.d();
        this.csa.a(new ay(this));
    }

    public void aoy() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        if (aoG() != null && aoG().aoM() != null) {
            gVar.b(aoG().aoM()).O(0).v(false);
            gVar.a(new al(this));
            com.baidu.adp.lib.guide.d gV = gVar.gV();
            gV.t(false);
            gV.i(this.crX.getPageContext().getPageActivity());
        }
    }

    private void aoz() {
        if (this.crY != null) {
            this.crY.setIsRound(true);
            this.crY.setDefaultBgResource(0);
            this.crY.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.crY.setDefaultResource(com.baidu.tieba.u.pic_mycenter_avatar_def);
        }
    }

    public void aoA() {
        if (this.crY != null) {
            this.crY.c(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        }
    }

    public void eU(boolean z) {
        if (this.crZ != null) {
            if (z) {
                this.crZ.setVisibility(0);
                ba.c(this.crZ, com.baidu.tieba.u.icon_news_down_bar_one);
                return;
            }
            this.crZ.setVisibility(8);
            this.crZ.setImageDrawable(null);
        }
    }

    public void LH() {
        this.mNavigationBar = (NavigationBar) this.crX.findViewById(com.baidu.tieba.v.view_navigation_bar);
        if (this.mNavigationBar != null) {
            try {
                this.csc = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.w.main_tab_top_navi_avatar, (View.OnClickListener) null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.csc != null) {
                this.csc.setOnClickListener(new am(this));
                this.crY = (HeadImageView) this.csc.findViewById(com.baidu.tieba.v.top_navi_avatar_icon);
                this.crZ = (TbImageView) this.csc.findViewById(com.baidu.tieba.v.top_navi_avatar_msg_icon);
                aoz();
                aoA();
            }
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.game_tip_view, (View.OnClickListener) null);
            this.crV = (ImageView) addCustomView.findViewById(com.baidu.tieba.v.game_button_iv);
            this.crW = (ImageView) addCustomView.findViewById(com.baidu.tieba.v.game_tip_msg_iv);
            this.crV.setOnClickListener(new an(this));
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_maintab_message, (View.OnClickListener) null);
            this.crT = addCustomView2.findViewById(com.baidu.tieba.v.maintab_message_button);
            this.crT.setOnClickListener(this.crX);
            this.aMN = (TextView) addCustomView2.findViewById(com.baidu.tieba.v.maintab_message_text);
            this.crU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_search, (View.OnClickListener) null);
            this.crU.setOnClickListener(new ao(this));
        }
    }

    public void eV(boolean z) {
        this.csb = z;
        if (z) {
            if (this.crS == null) {
                aoC();
            }
            this.crS.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.crS != null) {
            this.crS.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
    }

    public boolean aoB() {
        return this.csb;
    }

    private void aoC() {
        this.crS = (NavigationBar) ((ViewStub) this.crX.findViewById(com.baidu.tieba.v.viewstub_navigation_bar_in_edit)).inflate();
        this.crS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.w.enter_forum_edit_cancel, new ap(this));
        this.crS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.enter_forum_edit_confirm, new aq(this));
        this.crS.onChangeSkinType(this.crX.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void iH(int i) {
        TextView textView = this.aMN;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        ba.b(textView, com.baidu.tieba.s.top_msg_num_day, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            this.bTj = com.baidu.tieba.u.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            this.bTj = com.baidu.tieba.u.icon_news_head_prompt_two;
        } else {
            textView.setText("   ");
            this.bTj = com.baidu.tieba.u.icon_news_head_prompt_more;
        }
        ba.i((View) textView, this.bTj);
    }

    public void eW(boolean z) {
        if (z) {
            if (this.crW.getVisibility() != 0) {
                this.crW.setVisibility(0);
                ba.c(this.crW, com.baidu.tieba.u.icon_news_down_bar_one);
                return;
            }
            return;
        }
        this.crW.setVisibility(4);
    }

    public void Z(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.aPD.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null) {
                a(next.zR(), next.af(this.crX.getPageContext().getPageActivity()));
            }
        }
        this.aPD.bM(1);
    }

    private void a(com.baidu.tbadk.mainTab.d dVar, FragmentTabIndicator fragmentTabIndicator) {
        if (dVar != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            bVar.SS = dVar.amd;
            bVar.mType = dVar.type;
            fragmentTabIndicator.setText(dVar.ame);
            fragmentTabIndicator.setTextSize(0, this.crX.getResources().getDimension(com.baidu.tieba.t.ds24));
            fragmentTabIndicator.setTextColorResId(com.baidu.tieba.s.main_tab_indicator);
            fragmentTabIndicator.setCompoundDrawablesTopResId(dVar.alU);
            fragmentTabIndicator.setCompoundDrawablePadding(this.crX.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds1));
            fragmentTabIndicator.cu(TbadkCoreApplication.m411getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar.SR = fragmentTabIndicator;
            this.aPD.a(bVar);
        }
    }

    public void aoD() {
        if (this.aPD.getCurrentTabIndex() == 0 || this.aNR.isMenuShowing()) {
            this.aNR.setSlidingEnabled(true);
        } else {
            this.aNR.setSlidingEnabled(false);
        }
    }

    public FragmentTabHost aoE() {
        return this.aPD;
    }

    public SlidingMenu aoF() {
        return this.aNR;
    }

    public com.baidu.tieba.tblauncher.a.d aoG() {
        return this.csa;
    }

    public View aoH() {
        return this.crT;
    }
}
