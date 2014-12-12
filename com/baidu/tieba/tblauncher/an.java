package com.baidu.tieba.tblauncher;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class an {
    private SlidingMenu aED;
    private TextView aGf;
    private FragmentTabHost aIf;
    private int bIY;
    private int cbG;
    private View cbS;
    private ImageView cbT;
    private ImageView cbU;
    private ImageView cbV;
    private MainTabActivity cbW;
    private HeadImageView cbX;
    private TbImageView cbY;
    private com.baidu.tieba.tblauncher.a.d cbZ;
    private ViewGroup cca;
    private View ccb;
    private View mMoreButton;
    private NavigationBar mNavigationBar;
    private int cbH = -1;
    private MorePopupWindow mPopWindow = null;
    private View cbI = null;
    private HeadImageView cbJ = null;
    private TextView cbK = null;
    private Drawable cbL = null;
    private View cbM = null;
    private View cbN = null;
    private ImageView cbO = null;
    private TextView cbP = null;
    private TextView cbQ = null;
    private TextView cbR = null;

    public an(MainTabActivity mainTabActivity) {
        this.cbW = mainTabActivity;
    }

    public void kJ() {
        this.aIf = (FragmentTabHost) this.cbW.findViewById(com.baidu.tieba.w.tab_host);
        this.aIf.setup(this.cbW.getSupportFragmentManager());
        this.aIf.setShouldDrawIndicatorLine(false);
        this.aIf.setTabWidgetViewHeight(TbadkCoreApplication.m255getInst().getResources().getDimensionPixelSize(com.baidu.tieba.u.ds110));
        this.aIf.c(0, TbadkCoreApplication.m255getInst().getResources().getDimensionPixelSize(com.baidu.tieba.u.ds2), 0, 0);
        this.aIf.setTabWidgetBackgroundRes(com.baidu.tieba.v.bg_tabbar);
        this.aIf.setOnPageChangeListener(new ao(this));
        Hp();
        aiS();
        aiQ();
    }

    public boolean aiP() {
        return this.cbU != null && this.cbU.getVisibility() == 0;
    }

    public void eD(boolean z) {
        if (this.cbU != null) {
            if (z) {
                this.cbU.setVisibility(0);
            } else {
                this.cbU.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.aIf.onChangeSkinType(i);
        boolean z = i == 1;
        if (z) {
            if (this.cbG != 0) {
                this.aGf.setBackgroundResource(this.cbG);
            }
        } else if (this.bIY != 0) {
            this.aGf.setBackgroundResource(this.bIY);
        }
        this.mNavigationBar.onChangeSkinType(this.cbW.getPageContext(), i);
        if (this.cbX != null && this.cbX.getVisibility() == 0) {
            this.cbX.setIsNight(z);
        }
        if (this.cbY != null && this.cbY.getVisibility() == 0) {
            com.baidu.tbadk.core.util.ax.c(this.cbY, com.baidu.tieba.v.icon_news_down_bar_one);
        }
        this.cbZ.b(this.cbW.getPageContext());
        for (int childCount = this.cca.getChildCount(); childCount > 0; childCount--) {
            if (this.cca.getChildAt(childCount - 1) instanceof al) {
                ((al) this.cca.getChildAt(childCount - 1)).wc();
            }
        }
        this.mPopWindow.onChangeSkinType(this.cbW, i, com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.bg_pull_down_right_n));
        com.baidu.tbadk.core.util.ax.c(this.cbO, com.baidu.tieba.v.icon_news_down_bar_one);
        com.baidu.tbadk.core.util.ax.c(this.cbV, com.baidu.tieba.v.icon_news_down_bar_one);
        com.baidu.tbadk.core.util.ax.c(this.cbU, com.baidu.tieba.v.icon_game_n);
        eA(false);
    }

    public void z(float f) {
        if (this.cbX != null && this.cbY != null) {
            this.cbX.setAlphaValue(f);
            this.cbY.setAlphaValue(f);
            Drawable background = this.cbX.getBackground();
            if (background != null) {
                background.setAlpha((int) (255.0f * f));
                this.cbX.setBackgroundDrawable(background);
            }
            if (this.ccb != null) {
                if (Math.abs(f) < 1.0E-7f) {
                    this.ccb.setVisibility(8);
                } else {
                    this.ccb.setVisibility(0);
                }
            }
        }
    }

    private void aiQ() {
        this.aED = new SlidingMenu(this.cbW.getPageContext().getPageActivity());
        this.aED.setBackgroundResource(com.baidu.tieba.v.bg_home);
        this.aED.setMode(0);
        this.aED.setTouchModeAbove(1);
        this.aED.setBehindOffset((int) (com.baidu.adp.lib.util.l.M(this.cbW.getPageContext().getPageActivity()) * 0.28f));
        this.aED.setFadeEnabled(true);
        this.aED.setFadeDegree(1.0f);
        this.aED.setFadeType(0);
        this.aED.setSettleDuration(400);
        aiR();
        this.aED.attachToActivity(this.cbW.getPageContext().getPageActivity(), 1);
        this.aED.setOnAboveViewScrollListener(new aw(this));
        this.aED.setAboveCanvasTransformer(new ax(this));
        this.aED.setBehindCanvasTransformer(new ay(this));
        this.aED.setOnOpenedListener(new az(this));
        this.aED.setOnClosedListener(new ba(this));
    }

    public boolean isMenuShowing() {
        return this.aED != null && this.aED.isMenuShowing();
    }

    public void a(com.baidu.tbadk.data.g gVar, int i) {
        if (gVar != null) {
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.cbW.getPageContext().getPageActivity(), com.baidu.tieba.x.show_member_died_line_layout, null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(com.baidu.tieba.w.member_icon);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.member_died_line_tip);
            boolean z = TbadkCoreApplication.m255getInst().getSkinType() == 1;
            com.baidu.tbadk.core.util.ax.b(textView, com.baidu.tieba.t.cp_cont_b, 1);
            if (!StringUtils.isNull(gVar.uu())) {
                textView.setText(gVar.uu());
            }
            if (!StringUtils.isNull(gVar.getUrl())) {
                tbImageView.d(gVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                com.baidu.tbadk.core.util.ax.c(tbImageView, com.baidu.tieba.v.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cbW.getPageContext().getPageActivity());
            aVar.j(inflate);
            aVar.b(com.baidu.tieba.z.member_i_know, new bb(this, aVar, i));
            String string = this.cbW.getPageContext().getString(com.baidu.tieba.z.member_continue_pay);
            if (i == 0) {
                string = this.cbW.getPageContext().getString(com.baidu.tieba.z.open_member);
            }
            aVar.a(string, new bc(this, aVar, i));
            aVar.ag(false);
            aVar.b(this.cbW.getPageContext()).nU();
            com.baidu.tbadk.core.sharedPref.b.og().putBoolean("show_member_deid_line", false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void aiR() {
        if (this.cbZ != null && this.cbZ.ajo() == null) {
            this.cbZ.g(this.cbW.getPageContext());
            this.cbZ.ajl();
            this.aED.setMenu(this.cbZ.ajo());
        }
    }

    private void aiS() {
        this.cbZ = new com.baidu.tieba.tblauncher.a.d();
        this.cbZ.a(new bd(this));
    }

    public void aiT() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.b(aja().getUserHeadView()).I(0).v(false);
        gVar.a(new aq(this));
        com.baidu.adp.lib.guide.d dz = gVar.dz();
        dz.t(false);
        dz.i(this.cbW.getPageContext().getPageActivity());
    }

    private void aiU() {
        if (this.cbX != null) {
            this.cbX.setIsRound(true);
            this.cbX.setDefaultBgResource(0);
            this.cbX.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.cbX.setDefaultResource(com.baidu.tieba.v.pic_mycenter_avatar_def);
        }
    }

    public void aiV() {
        if (this.cbX != null) {
            this.cbX.d(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        }
    }

    public void eE(boolean z) {
        if (this.cbY != null) {
            if (z) {
                this.cbY.setVisibility(0);
                com.baidu.tbadk.core.util.ax.c(this.cbY, com.baidu.tieba.v.icon_news_down_bar_one);
                return;
            }
            this.cbY.setVisibility(8);
            this.cbY.setImageDrawable(null);
        }
    }

    public void Hp() {
        this.mNavigationBar = (NavigationBar) this.cbW.findViewById(com.baidu.tieba.w.view_navigation_bar);
        if (this.mNavigationBar != null) {
            try {
                this.ccb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.x.main_tab_top_navi_avatar, (View.OnClickListener) null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.ccb != null) {
                this.ccb.setOnClickListener(new ar(this));
                this.cbX = (HeadImageView) this.ccb.findViewById(com.baidu.tieba.w.top_navi_avatar_icon);
                this.cbY = (TbImageView) this.ccb.findViewById(com.baidu.tieba.w.top_navi_avatar_msg_icon);
                aiU();
                aiV();
            }
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.game_tip_view, (View.OnClickListener) null);
            this.cbU = (ImageView) addCustomView.findViewById(com.baidu.tieba.w.game_button_iv);
            this.cbV = (ImageView) addCustomView.findViewById(com.baidu.tieba.w.game_tip_msg_iv);
            this.cbU.setOnClickListener(new as(this));
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.nb_item_maintab_message, (View.OnClickListener) null);
            this.cbS = addCustomView2.findViewById(com.baidu.tieba.w.maintab_message_button);
            this.cbS.setOnClickListener(this.cbW);
            this.aGf = (TextView) addCustomView2.findViewById(com.baidu.tieba.w.maintab_message_text);
            this.cbT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.widget_nb_item_search, (View.OnClickListener) null);
            this.cbT.setOnClickListener(new at(this));
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.cbW.getPageContext().getPageActivity(), com.baidu.tieba.x.main_tab_more_pop_window, null);
            this.cbI = inflate.findViewById(com.baidu.tieba.w.more_pop_item_account);
            this.cbI.setOnClickListener(this.cbW);
            this.cbJ = (HeadImageView) inflate.findViewById(com.baidu.tieba.w.more_pop_item_account_head);
            this.cbK = (TextView) inflate.findViewById(com.baidu.tieba.w.more_pop_item_account_name);
            this.cbM = inflate.findViewById(com.baidu.tieba.w.more_pop_item_mylive);
            this.cbM.setOnClickListener(new au(this));
            this.cbN = inflate.findViewById(com.baidu.tieba.w.more_pop_item_setting);
            this.cbN.setOnClickListener(this.cbW);
            this.cbO = (ImageView) inflate.findViewById(com.baidu.tieba.w.more_pop_item_setting_msg);
            this.cbP = (TextView) inflate.findViewById(com.baidu.tieba.w.more_pop_item_feedback);
            this.cbP.setOnClickListener(this.cbW);
            this.cbQ = (TextView) inflate.findViewById(com.baidu.tieba.w.more_pop_item_switchaccount);
            this.cbQ.setOnClickListener(this.cbW);
            this.cbR = (TextView) inflate.findViewById(com.baidu.tieba.w.more_pop_item_exitapp);
            this.cbR.setOnClickListener(this.cbW);
            this.cca = (ViewGroup) inflate.findViewById(com.baidu.tieba.w.local_dis_container);
            this.mPopWindow = new MorePopupWindow(this.cbW.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.cbW.getResources().getDrawable(com.baidu.tieba.v.bg_pull_down_right_n), new av(this));
        }
    }

    public void showPopMenu() {
        if (this.mPopWindow != null) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                this.cbJ.d(currentAccountObj.getPortrait(), 12, false);
                this.cbK.setText(currentAccountObj.getAccount());
            }
            this.mPopWindow.showWindowInRightBottomOfHost();
        }
    }

    public void ih(int i) {
        TextView textView = this.aGf;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        com.baidu.tbadk.core.util.ax.b(textView, com.baidu.tieba.t.top_msg_num_day, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            this.bIY = com.baidu.tieba.v.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            this.bIY = com.baidu.tieba.v.icon_news_head_prompt_two;
        } else {
            textView.setText("   ");
            this.bIY = com.baidu.tieba.v.icon_news_head_prompt_more;
        }
        com.baidu.tbadk.core.util.ax.i((View) textView, this.bIY);
    }

    public void eF(boolean z) {
        if (z) {
            if (this.cbV.getVisibility() != 0) {
                this.cbV.setVisibility(0);
                com.baidu.tbadk.core.util.ax.c(this.cbV, com.baidu.tieba.v.icon_news_down_bar_one);
                return;
            }
            return;
        }
        this.cbV.setVisibility(4);
    }

    public void R(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.aIf.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null) {
                a(next.we(), next.W(this.cbW.getPageContext().getPageActivity()));
            }
        }
        this.aIf.bG(1);
    }

    private void a(com.baidu.tbadk.mainTab.d dVar, FragmentTabIndicator fragmentTabIndicator) {
        if (dVar != null) {
            com.baidu.tbadk.core.tabHost.b bVar = new com.baidu.tbadk.core.tabHost.b();
            bVar.GI = dVar.acb;
            bVar.mType = dVar.type;
            fragmentTabIndicator.setText(dVar.acc);
            fragmentTabIndicator.setTextSize(0, this.cbW.getResources().getDimension(com.baidu.tieba.u.ds24));
            fragmentTabIndicator.setTextColorResId(com.baidu.tieba.t.main_tab_indicator);
            fragmentTabIndicator.setCompoundDrawablesTopResId(dVar.abS);
            fragmentTabIndicator.setCompoundDrawablePadding(this.cbW.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds1));
            fragmentTabIndicator.cm(TbadkCoreApplication.m255getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            bVar.GH = fragmentTabIndicator;
            this.aIf.a(bVar);
        }
    }

    public void aiW() {
        if (this.aIf.getCurrentTabIndex() == 0 || this.aED.isMenuShowing()) {
            this.aED.setSlidingEnabled(true);
        } else {
            this.aED.setSlidingEnabled(false);
        }
    }

    public void aiX() {
        com.baidu.adp.lib.g.k.a(this.mPopWindow, this.cbW.getPageContext().getPageActivity());
    }

    public void eA(boolean z) {
        this.cbL = com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.icon_news_down_bar_one);
        com.baidu.tbadk.core.util.ax.c(this.cbO, com.baidu.tieba.v.icon_news_down_bar_one);
    }

    public void b(com.baidu.tbadk.mainTab.f fVar) {
        if (this.cca != null) {
            this.cca.removeAllViews();
            int size = fVar.wi().size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (size - i2 <= 0) {
                    break;
                }
                al alVar = new al(this.cbW.getPageContext().getPageActivity(), fVar.wi().get(i2));
                alVar.H(this.cbW.cbr);
                this.cca.addView(alVar);
                i = i2 + 1;
            }
            if (this.mPopWindow != null) {
                this.mPopWindow.onChangeSkinType(this.cbW, TbadkCoreApplication.m255getInst().getSkinType(), com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.bg_pull_down_right_n));
            }
            this.mPopWindow.refresh();
        }
    }

    public FragmentTabHost aiY() {
        return this.aIf;
    }

    public SlidingMenu aiZ() {
        return this.aED;
    }

    public com.baidu.tieba.tblauncher.a.d aja() {
        return this.cbZ;
    }

    public View getMoreButton() {
        return this.mMoreButton;
    }

    public View ajb() {
        return this.cbI;
    }

    public View ajc() {
        return this.cbN;
    }

    public View ajd() {
        return this.cbP;
    }

    public View aje() {
        return this.cbQ;
    }

    public View ajf() {
        return this.cbR;
    }

    public View ajg() {
        return this.cbS;
    }
}
