package com.baidu.tieba.tblauncher;

import android.os.Handler;
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
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ab {
    private FragmentTabHost bdU;
    private ImageView cEl;
    private ImageView cEm;
    private ImageView cEn;
    private boolean dYU;
    private MainTabActivity fzj;
    private TextView fzk;
    private ImageView fzl;
    private ImageView fzm;
    private TextView fzn;
    private NavigationBar fzq;
    private View fzr;
    private int fzs;
    private NavigationBar mNavigationBar;
    private com.baidu.adp.lib.guide.d Hs = null;
    private Handler mHandler = null;
    private boolean fzo = false;
    private boolean fzp = false;
    private int dYR = -1;
    private FragmentTabHost.b fzt = new ac(this);
    private com.baidu.tbadk.coreExtra.view.j ayF = null;
    private Runnable bRS = new aj(this);
    private Runnable bRT = new al(this);

    public ab(MainTabActivity mainTabActivity) {
        this.fzj = mainTabActivity;
    }

    public void kS(boolean z) {
        this.bdU = (FragmentTabHost) this.fzj.findViewById(r.g.tab_host);
        this.bdU.setup(this.fzj.getSupportFragmentManager());
        this.bdU.setOnTabSelectionListener(this.fzt);
        this.bdU.setFrameLayerClickListener(new am(this));
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bdU.setShouldDrawIndicatorLine(false);
            this.bdU.setShouldDrawTopLine(true);
            this.bdU.e(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds10), 0, 0);
            this.bdU.az(true);
        }
        this.bdU.setOnPageChangeListener(new an(this));
        this.fzp = com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("has_show_message_tab_tips", false);
        Vz();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.fzj.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        this.fzo = z;
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void acn() {
        com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("has_show_message_tab_tips", this.fzp);
    }

    public void acm() {
        if (!this.fzp) {
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bRS, 2000L);
        }
    }

    public boolean amp() {
        return this.cEl != null && this.cEl.getVisibility() == 0;
    }

    public void eX(boolean z) {
        if (this.cEl != null) {
            if (z) {
                this.cEl.setVisibility(0);
            } else {
                this.cEl.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bdU.setShouldDrawTopLine(false);
            } else {
                this.bdU.setShouldDrawTopLine(true);
            }
        }
        if (this.bdU.getFragmentTabWidget() != null) {
            this.bdU.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bdU.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.fzj.getPageContext(), i);
        if (this.fzq != null) {
            this.fzq.onChangeSkinType(this.fzj.getPageContext(), i);
        }
        av.a(this.fzk, r.d.cp_cont_b, r.d.s_navbar_title_color, i);
        av.c(this.cEm, r.f.icon_news_down_bar_one);
        av.b(this.cEl, r.f.icon_game_bg_s, r.f.icon_game_bg);
        av.b(this.cEn, r.f.icon_search_bg_s, r.f.icon_search_bg);
        av.b(this.fzl, r.f.icon_sign_bg_s, r.f.icon_sign_bg);
        av.b(this.fzm, r.f.icon_message_bg_s, r.f.icon_message_bg);
        if (this.fzm.getVisibility() == 0 && this.fzn.getVisibility() == 0) {
            com.baidu.tbadk.i.a.a(this.fzj.getPageContext(), this.fzn);
        }
        if (this.fzn != null) {
            r(this.fzn, this.fzs);
        }
    }

    public void a(com.baidu.tbadk.data.h hVar, int i) {
        if (hVar != null) {
            View inflate = LayoutInflater.from(this.fzj.getPageContext().getPageActivity()).inflate(r.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(r.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(r.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.m9getInst().getSkinType() == 1;
            av.c(textView, r.d.cp_cont_b, 1);
            if (!StringUtils.isNull(hVar.Cc())) {
                textView.setText(hVar.Cc());
            }
            if (!StringUtils.isNull(hVar.getUrl())) {
                tbImageView.c(hVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                av.c(tbImageView, r.f.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fzj.getPageContext().getPageActivity());
            aVar.z(inflate);
            aVar.ca(r.d.cp_link_tip_d);
            aVar.b(r.j.member_i_know, new ao(this, aVar, i));
            String string = this.fzj.getPageContext().getString(r.j.member_continue_pay);
            if (i == 0) {
                string = this.fzj.getPageContext().getString(r.j.open_member);
            }
            aVar.a(string, new ap(this, aVar, i));
            aVar.ar(false);
            aVar.b(this.fzj.getPageContext()).tm();
            com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("show_member_deid_line", false);
        }
    }

    public void blE() {
        FragmentTabHost.c cz;
        if (this.bdU != null && (cz = this.bdU.cz(this.bdU.getCurrentTabType())) != null && cz.Zd != null && cz.Zd.EF() != null) {
            String string = this.fzj.getPageContext().getString(cz.Zd.EF().azm);
            if (this.fzk != null) {
                this.fzk.setText(string);
            }
        }
    }

    public void Vz() {
        this.mNavigationBar = (NavigationBar) this.fzj.findViewById(r.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.fzk = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.maintab_title_layout, (View.OnClickListener) null).findViewById(r.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.fzj.getResources().getDimension(r.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.fzk.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.game_tip_view, (View.OnClickListener) null);
            this.cEl = (ImageView) addCustomView.findViewById(r.g.game_button_iv);
            this.cEm = (ImageView) addCustomView.findViewById(r.g.game_tip_msg_iv);
            this.cEl.setOnClickListener(new aq(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.fzj.getPageContext().getPageActivity(), r.e.ds16), 0);
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.message_tip_view, (View.OnClickListener) null);
            this.fzm = (ImageView) addCustomView2.findViewById(r.g.message_button_iv);
            this.fzn = (TextView) addCustomView2.findViewById(r.g.message_tip_msg_iv);
            blF();
            this.fzm.setOnClickListener(new ar(this));
            this.cEn = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.widget_nb_item_search, (View.OnClickListener) null);
            this.cEn.setLayoutParams(layoutParams2);
            this.cEn.setVisibility(8);
            this.cEn.setOnClickListener(new ad(this));
            this.fzl = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.fzl.setLayoutParams(layoutParams2);
            this.fzl.setVisibility(8);
            this.fzl.setOnClickListener(new ae(this));
            this.mNavigationBar.setLoginClickListener(new af(this));
            this.mNavigationBar.setRegisterClickListener(new ag(this));
        }
    }

    public void blF() {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.yD().getMsgReplyme();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.yD().getMsgAtme();
        int msgChat = ((msgReplyme + msgAtme) + com.baidu.tbadk.coreExtra.messageCenter.a.yD().getMsgChat()) - com.baidu.tbadk.coreExtra.messageCenter.a.yD().yK();
        if (msgChat == 0) {
            a(true, false, 0);
        } else {
            a(true, true, msgChat);
        }
    }

    public void kT(boolean z) {
        if (z) {
            this.fzl.setVisibility(0);
            this.cEn.setVisibility(8);
            return;
        }
        this.fzl.setVisibility(8);
        this.cEn.setVisibility(0);
    }

    public void a(boolean z, boolean z2, int i) {
        if (this.fzm != null && this.fzn != null) {
            if (z) {
                this.fzm.setVisibility(0);
                if (z2) {
                    this.fzn.setVisibility(0);
                    r(this.fzn, i);
                    return;
                }
                this.fzn.setVisibility(8);
                return;
            }
            this.fzm.setVisibility(8);
            this.fzn.setVisibility(8);
        }
    }

    private void r(TextView textView, int i) {
        if (textView != null) {
            this.fzs = i;
            textView.setVisibility(0);
            av.c(textView, r.d.common_color_10225, 1);
            if (i <= 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                av.k(textView, r.f.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                av.k(textView, r.f.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                av.k(textView, r.f.icon_news_head_prompt_more);
            }
        }
    }

    public void hr(boolean z) {
        this.dYU = z;
        if (z) {
            if (this.fzq == null) {
                blG();
            }
            this.fzq.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.fzq != null) {
            this.fzq.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
    }

    public boolean aIv() {
        return this.dYU;
    }

    private void blG() {
        this.fzq = (NavigationBar) ((ViewStub) this.fzj.findViewById(r.g.viewstub_navigation_bar_in_edit)).inflate();
        this.fzq.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.enter_forum_edit_cancel, new ah(this));
        this.fzr = this.fzq.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.enter_forum_edit_confirm, new ai(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.fzj.getPageContext().getPageActivity(), r.e.ds16), 0);
        this.fzr.setLayoutParams(layoutParams);
        this.fzq.onChangeSkinType(this.fzj.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void eW(boolean z) {
        if (z) {
            if (this.cEm.getVisibility() != 0) {
                this.cEm.setVisibility(0);
                eY(true);
                av.c(this.cEm, r.f.icon_news_down_bar_one);
                return;
            }
            return;
        }
        eY(false);
        this.cEm.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cEl.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.fzj.getPageContext().getPageActivity(), r.e.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.fzj.getPageContext().getPageActivity(), r.e.ds20);
            }
            this.cEl.setLayoutParams(layoutParams);
        }
    }

    public void af(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bdU.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.EF(), next.ap(this.fzj.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2 && TbadkCoreApplication.m9getInst().isThemeIconCover()) {
            this.bdU.cv(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bdU.cv(1);
        } else {
            this.bdU.cv(0);
        }
        this.bdU.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.Zc = cVar.azl;
            cVar2.mType = cVar.type;
            fragmentTabIndicator.setText(cVar.azm);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.fzj.getResources().getDimension(r.e.ds24));
                fragmentTabIndicator.setTextColorResId(r.d.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.azn);
                fragmentTabIndicator.setContentTvTopMargin(this.fzj.getResources().getDimensionPixelSize(r.e.ds2));
            } else {
                fragmentTabIndicator.setTextSize(0, this.fzj.getResources().getDimension(r.e.fontsize32));
                fragmentTabIndicator.setTextColorResId(r.d.s_tabbar_text_color);
            }
            fragmentTabIndicator.dl(TbadkCoreApplication.m9getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.Zb = fragmentTabIndicator;
            cVar2.Zd = bVar;
            this.bdU.a(cVar2);
        }
    }

    public FragmentTabHost blH() {
        return this.bdU;
    }

    public void blI() {
        String currentAccount;
        if (this.bdU != null) {
            if (this.bdU.getCurrentTabType() == 8 || this.bdU.getCurrentTabType() == 14 || this.bdU.getCurrentTabType() == 2 || this.bdU.getCurrentTabType() == 15) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                if (this.fzq != null) {
                    this.fzq.setVisibility(8);
                }
            } else {
                hr(aIv());
            }
            if (this.bdU.getCurrentTabType() == 6 || this.dYR == 6) {
                TbadkCoreApplication.m9getInst().setFriendFeedNew(false);
            }
            if (this.bdU.getCurrentTabType() != 1) {
                if (this.fzl != null) {
                    this.fzl.setVisibility(8);
                }
                if (this.cEn != null) {
                    this.cEn.setVisibility(0);
                }
            }
            if (this.bdU.getCurrentTabType() == 14) {
                if (!TbadkCoreApplication.isLogin()) {
                    currentAccount = "temp";
                } else {
                    currentAccount = TbadkCoreApplication.getCurrentAccount();
                }
                com.baidu.tbadk.core.sharedPref.b.uh().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.m9getInst().getLastUpdateMemberCenterTime());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, false));
            }
            if (this.bdU.getCurrentTabType() != 1) {
                if (this.mHandler != null) {
                    this.mHandler.removeCallbacks(this.bRS);
                    this.mHandler.removeCallbacks(this.bRT);
                }
                if (this.Hs != null) {
                    this.Hs.dismiss();
                    this.Hs = null;
                }
            } else if (this.fzo) {
                acm();
            }
        }
    }
}
