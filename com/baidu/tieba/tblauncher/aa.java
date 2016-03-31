package com.baidu.tieba.tblauncher;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class aa {
    private FragmentTabHost aXu;
    private boolean cXU;
    private MainTabActivity etM;
    private TextView etN;
    private ImageView etO;
    private ViewGroup etP;
    private ImageView etQ;
    private ImageView etR;
    private ImageView etS;
    private ImageView etT;
    private PluginErrorTipView etU;
    private NavigationBar etV;
    private View etW;
    private NavigationBar mNavigationBar;
    private int cXR = -1;
    private FragmentTabHost.b etX = new ab(this);
    private com.baidu.tbadk.coreExtra.view.j ayp = null;
    private final a.InterfaceC0042a YU = new aj(this);

    public aa(MainTabActivity mainTabActivity) {
        this.etM = mainTabActivity;
    }

    public void iP(boolean z) {
        this.aXu = (FragmentTabHost) this.etM.findViewById(t.g.tab_host);
        this.aXu.setup(this.etM.getSupportFragmentManager());
        this.aXu.setOnTabSelectionListener(this.etX);
        this.aXu.setFrameLayerClickListener(new al(this));
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aXu.setShouldDrawIndicatorLine(false);
            int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds10);
            this.aXu.d(0, dimensionPixelSize, 0, dimensionPixelSize);
        }
        this.aXu.setTabWidgetBackgroundRes(t.f.s_tabbar_bg);
        this.aXu.setOnPageChangeListener(new am(this));
        Ux();
        this.etU = (PluginErrorTipView) this.etM.findViewById(t.g.view_plugin_error_tip);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.etM.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void iQ(boolean z) {
        if (this.etU != null && (this.etU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            if (z && UtilHelper.canUseStyleImmersiveSticky()) {
                ((ViewGroup.MarginLayoutParams) this.etU.getLayoutParams()).setMargins(0, UtilHelper.getStatusBarHeight(), 0, 0);
                this.etU.requestLayout();
                return;
            }
            ((ViewGroup.MarginLayoutParams) this.etU.getLayoutParams()).setMargins(0, 0, 0, 0);
            this.etU.requestLayout();
        }
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public boolean aVm() {
        return this.etR != null && this.etR.getVisibility() == 0;
    }

    public void iR(boolean z) {
        if (this.etR != null) {
            if (z) {
                this.etR.setVisibility(0);
            } else {
                this.etR.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.aXu.onChangeSkinType(i);
        this.aXu.getFragmentTabWidget().setBackgroundDrawable(new BitmapDrawable(at.cT(t.f.s_tabbar_bg)));
        this.mNavigationBar.onChangeSkinType(this.etM.getPageContext(), i);
        this.etU.onChangeSkinType(this.etM.getPageContext(), i);
        if (this.etV != null) {
            this.etV.onChangeSkinType(this.etM.getPageContext(), i);
        }
        at.j((View) this.etN, t.d.s_navbar_title_color);
        at.c(this.etS, t.f.icon_news_down_bar_one);
        at.a(this.etR, t.f.icon_game_bg_s, t.f.icon_game_bg);
        at.a(this.etT, t.f.icon_search_bg_s, t.f.icon_search_bg);
        at.a(this.etO, t.f.icon_sign_bg_s, t.f.icon_sign_bg);
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            this.etQ.setImageResource(t.f.s_icon_guanggao);
        } else {
            at.c(this.etQ, t.f.icon_guanggao_off);
        }
    }

    public void a(com.baidu.tbadk.data.f fVar, int i) {
        if (fVar != null) {
            View inflate = LayoutInflater.from(this.etM.getPageContext().getPageActivity()).inflate(t.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(t.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(t.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
            at.b(textView, t.d.cp_cont_b, 1);
            if (!StringUtils.isNull(fVar.CG())) {
                textView.setText(fVar.CG());
            }
            if (!StringUtils.isNull(fVar.getUrl())) {
                tbImageView.c(fVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                at.c(tbImageView, t.f.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.etM.getPageContext().getPageActivity());
            aVar.z(inflate);
            aVar.cb(t.d.cp_link_tip_d);
            aVar.b(t.j.member_i_know, new an(this, aVar, i));
            String string = this.etM.getPageContext().getString(t.j.member_continue_pay);
            if (i == 0) {
                string = this.etM.getPageContext().getString(t.j.open_member);
            }
            aVar.a(string, new ao(this, aVar, i));
            aVar.an(false);
            aVar.b(this.etM.getPageContext()).up();
            com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("show_member_deid_line", false);
        }
    }

    public void aVn() {
        FragmentTabHost.c cD;
        if (this.aXu != null && (cD = this.aXu.cD(this.aXu.getCurrentTabType())) != null && cD.ZL != null && cD.ZL.Fl() != null) {
            String string = this.etM.getPageContext().getString(cD.ZL.Fl().ayW);
            if (this.etN != null) {
                this.etN.setText(string);
            }
        }
    }

    public void Ux() {
        this.mNavigationBar = (NavigationBar) this.etM.findViewById(t.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.etN = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.maintab_title_layout, (View.OnClickListener) null).findViewById(t.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.etM.getResources().getDimension(t.e.navi_btn_margin_right);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.etN.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.game_tip_view, (View.OnClickListener) null);
            this.etR = (ImageView) addCustomView.findViewById(t.g.game_button_iv);
            this.etS = (ImageView) addCustomView.findViewById(t.g.game_tip_msg_iv);
            this.etR.setOnClickListener(new ap(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.k.c(this.etM.getPageContext().getPageActivity(), t.e.ds16), 0);
            this.etP = (ViewGroup) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_adkiller, (View.OnClickListener) null);
            this.etQ = (ImageView) this.etP.findViewById(t.g.navigationBarGoAdKiller);
            this.etP.setLayoutParams(layoutParams2);
            this.etP.setVisibility(8);
            this.etQ.setOnClickListener(new aq(this));
            this.etT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_search, (View.OnClickListener) null);
            this.etT.setLayoutParams(layoutParams2);
            this.etT.setVisibility(8);
            this.etT.setOnClickListener(new ar(this));
            this.etO = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.etO.setLayoutParams(layoutParams2);
            this.etO.setVisibility(8);
            this.etO.setOnClickListener(new ac(this));
            this.mNavigationBar.setLoginClickListener(new ad(this));
            this.mNavigationBar.setRegisterClickListener(new ae(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.ayp == null) {
            this.ayp = new com.baidu.tbadk.coreExtra.view.j(this.etM.getPageContext());
            this.ayp.a(new af(this));
        }
        this.ayp.Bw();
        this.ayp.h(accountData);
        this.ayp.Bs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(AccountData accountData) {
        com.baidu.adp.lib.h.k.hy().b(new ag(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, this.etM.getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.J(TbadkCoreApplication.m411getInst());
        com.baidu.tbadk.core.d.b.b(this.etM.getPageContext().getPageActivity(), 1, false);
    }

    public void iS(boolean z) {
        if (z) {
            this.etO.setVisibility(0);
            this.etT.setVisibility(8);
            return;
        }
        this.etO.setVisibility(8);
        this.etT.setVisibility(0);
    }

    public void iT(boolean z) {
        if (z) {
            if (TbadkCoreApplication.m411getInst().isShowAdKiller()) {
                this.etP.setVisibility(0);
                return;
            } else {
                this.etP.setVisibility(8);
                return;
            }
        }
        this.etP.setVisibility(8);
    }

    public void fx(boolean z) {
        this.cXU = z;
        if (z) {
            if (this.etV == null) {
                aVo();
            }
            this.etV.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.etV != null) {
            this.etV.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
    }

    public boolean atR() {
        return this.cXU;
    }

    private void aVo() {
        this.etV = (NavigationBar) ((ViewStub) this.etM.findViewById(t.g.viewstub_navigation_bar_in_edit)).inflate();
        this.etV.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.enter_forum_edit_cancel, new ah(this));
        this.etW = this.etV.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.enter_forum_edit_confirm, new ai(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(this.etM.getPageContext().getPageActivity(), t.e.ds16), 0);
        this.etW.setLayoutParams(layoutParams);
        this.etV.onChangeSkinType(this.etM.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void iU(boolean z) {
        if (z) {
            if (this.etS.getVisibility() != 0) {
                this.etS.setVisibility(0);
                iV(true);
                at.c(this.etS, t.f.icon_news_down_bar_one);
                return;
            }
            return;
        }
        iV(false);
        this.etS.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iV(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.etR.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(this.etM.getPageContext().getPageActivity(), t.e.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(this.etM.getPageContext().getPageActivity(), t.e.ds20);
            }
            this.etR.setLayoutParams(layoutParams);
        }
    }

    public void S(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.aXu.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Fl(), next.aj(this.etM.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2 && TbadkCoreApplication.m411getInst().isThemeIconCover()) {
            this.aXu.cz(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aXu.cz(1);
        } else {
            this.aXu.cz(0);
        }
        this.aXu.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.ZK = cVar.ayV;
            cVar2.mType = cVar.type;
            fragmentTabIndicator.setText(cVar.ayW);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.etM.getResources().getDimension(t.e.ds24));
                fragmentTabIndicator.setTextColorResId(t.d.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.ayX);
                fragmentTabIndicator.setContentTvTopMargin(this.etM.getResources().getDimensionPixelSize(t.e.ds2));
            } else {
                fragmentTabIndicator.setTextSize(0, this.etM.getResources().getDimension(t.e.fontsize32));
                fragmentTabIndicator.setTextColorResId(t.d.s_tabbar_text_color);
            }
            fragmentTabIndicator.dn(TbadkCoreApplication.m411getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.ZJ = fragmentTabIndicator;
            cVar2.ZL = bVar;
            this.aXu.a(cVar2);
        }
    }

    public FragmentTabHost aVp() {
        return this.aXu;
    }

    public void aVq() {
        if (this.aXu != null) {
            if (this.aXu.getCurrentTabType() == 8) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                if (this.etV != null) {
                    this.etV.setVisibility(8);
                }
                iQ(true);
            } else {
                fx(atR());
                iQ(false);
            }
            if (this.aXu.getCurrentTabType() == 6 || this.cXR == 6) {
                TbadkCoreApplication.m411getInst().setFriendFeedNew(false);
            }
            if (this.aXu.getCurrentTabType() != 1) {
                if (this.etO != null) {
                    this.etO.setVisibility(8);
                }
                if (this.etT != null) {
                    this.etT.setVisibility(0);
                }
            }
        }
    }
}
