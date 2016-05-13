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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ab {
    private FragmentTabHost aTo;
    private ImageView dZc;
    private ImageView dZd;
    private ImageView dZe;
    private boolean daj;
    private MainTabActivity ewR;
    private TextView ewS;
    private ImageView ewT;
    private ViewGroup ewU;
    private ImageView ewV;
    private ImageView ewW;
    private TextView ewX;
    private NavigationBar exa;
    private View exb;
    private int exc;
    private NavigationBar mNavigationBar;
    private com.baidu.adp.lib.guide.d Ey = null;
    private Handler mHandler = null;
    private boolean ewY = false;
    private boolean ewZ = false;
    private int dag = -1;
    private FragmentTabHost.b exd = new ac(this);
    private com.baidu.tbadk.coreExtra.view.j auq = null;
    private Runnable exe = new ak(this);
    private Runnable exf = new am(this);

    public ab(MainTabActivity mainTabActivity) {
        this.ewR = mainTabActivity;
    }

    public void jE(boolean z) {
        this.aTo = (FragmentTabHost) this.ewR.findViewById(t.g.tab_host);
        this.aTo.setup(this.ewR.getSupportFragmentManager());
        this.aTo.setOnTabSelectionListener(this.exd);
        this.aTo.setFrameLayerClickListener(new an(this));
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aTo.setShouldDrawIndicatorLine(false);
            this.aTo.setShouldDrawTopLine(true);
            this.aTo.d(0, TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds10), 0, 0);
            this.aTo.ax(true);
        }
        this.aTo.setOnPageChangeListener(new ao(this));
        this.ewZ = com.baidu.tbadk.core.sharedPref.b.sR().getBoolean("has_show_message_tab_tips", false);
        Ux();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.ewR.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        this.ewY = z;
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void aVM() {
        com.baidu.tbadk.core.sharedPref.b.sR().putBoolean("has_show_message_tab_tips", this.ewZ);
    }

    public void aVN() {
        if (!this.ewZ) {
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.exe, 2000L);
        }
    }

    public boolean aMq() {
        return this.dZc != null && this.dZc.getVisibility() == 0;
    }

    public void iP(boolean z) {
        if (this.dZc != null) {
            if (z) {
                this.dZc.setVisibility(0);
            } else {
                this.dZc.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.aTo.setShouldDrawTopLine(false);
            } else {
                this.aTo.setShouldDrawTopLine(true);
            }
        }
        if (this.aTo.getFragmentTabWidget() != null) {
            this.aTo.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.aTo.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.ewR.getPageContext(), i);
        if (this.exa != null) {
            this.exa.onChangeSkinType(this.ewR.getPageContext(), i);
        }
        at.a(this.ewS, t.d.cp_cont_b, t.d.s_navbar_title_color, i);
        at.c(this.dZd, t.f.icon_news_down_bar_one);
        at.a(this.dZc, t.f.icon_game_bg_s, t.f.icon_game_bg);
        at.a(this.dZe, t.f.icon_search_bg_s, t.f.icon_search_bg);
        at.a(this.ewT, t.f.icon_sign_bg_s, t.f.icon_sign_bg);
        at.a(this.ewW, t.f.icon_message_bg_s, t.f.icon_message_bg);
        if (this.ewW.getVisibility() == 0 && this.ewX.getVisibility() == 0) {
            com.baidu.tbadk.i.a.a(this.ewR.getPageContext(), this.ewX);
        }
        if (TbadkCoreApplication.m11getInst().getSkinType() == 2) {
            this.ewV.setImageResource(t.f.s_icon_guanggao);
        } else {
            at.c(this.ewV, t.f.icon_guanggao_off);
        }
        if (this.ewX != null) {
            r(this.ewX, this.exc);
        }
    }

    public void a(com.baidu.tbadk.data.g gVar, int i) {
        if (gVar != null) {
            View inflate = LayoutInflater.from(this.ewR.getPageContext().getPageActivity()).inflate(t.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(t.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(t.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.m11getInst().getSkinType() == 1;
            at.c(textView, t.d.cp_cont_b, 1);
            if (!StringUtils.isNull(gVar.AB())) {
                textView.setText(gVar.AB());
            }
            if (!StringUtils.isNull(gVar.getUrl())) {
                tbImageView.c(gVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                at.c(tbImageView, t.f.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ewR.getPageContext().getPageActivity());
            aVar.z(inflate);
            aVar.bM(t.d.cp_link_tip_d);
            aVar.b(t.j.member_i_know, new ap(this, aVar, i));
            String string = this.ewR.getPageContext().getString(t.j.member_continue_pay);
            if (i == 0) {
                string = this.ewR.getPageContext().getString(t.j.open_member);
            }
            aVar.a(string, new aq(this, aVar, i));
            aVar.aq(false);
            aVar.b(this.ewR.getPageContext()).rV();
            com.baidu.tbadk.core.sharedPref.b.sR().putBoolean("show_member_deid_line", false);
        }
    }

    public void aVO() {
        FragmentTabHost.c cl;
        if (this.aTo != null && (cl = this.aTo.cl(this.aTo.getCurrentTabType())) != null && cl.Ve != null && cl.Ve.De() != null) {
            String string = this.ewR.getPageContext().getString(cl.Ve.De().auX);
            if (this.ewS != null) {
                this.ewS.setText(string);
            }
        }
    }

    public void Ux() {
        this.mNavigationBar = (NavigationBar) this.ewR.findViewById(t.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.ewS = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.maintab_title_layout, (View.OnClickListener) null).findViewById(t.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.ewR.getResources().getDimension(t.e.navi_btn_margin_right);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.ewS.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.game_tip_view, (View.OnClickListener) null);
            this.dZc = (ImageView) addCustomView.findViewById(t.g.game_button_iv);
            this.dZd = (ImageView) addCustomView.findViewById(t.g.game_tip_msg_iv);
            this.dZc.setOnClickListener(new ar(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.k.c(this.ewR.getPageContext().getPageActivity(), t.e.ds16), 0);
            this.ewU = (ViewGroup) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_adkiller, (View.OnClickListener) null);
            this.ewV = (ImageView) this.ewU.findViewById(t.g.navigationBarGoAdKiller);
            this.ewU.setLayoutParams(layoutParams2);
            this.ewU.setVisibility(8);
            this.ewV.setOnClickListener(new as(this));
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.message_tip_view, (View.OnClickListener) null);
            this.ewW = (ImageView) addCustomView2.findViewById(t.g.message_button_iv);
            this.ewX = (TextView) addCustomView2.findViewById(t.g.message_tip_msg_iv);
            aVP();
            this.ewW.setOnClickListener(new ad(this));
            this.dZe = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_search, (View.OnClickListener) null);
            this.dZe.setLayoutParams(layoutParams2);
            this.dZe.setVisibility(8);
            this.dZe.setOnClickListener(new ae(this));
            this.ewT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.ewT.setLayoutParams(layoutParams2);
            this.ewT.setVisibility(8);
            this.ewT.setOnClickListener(new af(this));
            this.mNavigationBar.setLoginClickListener(new ag(this));
            this.mNavigationBar.setRegisterClickListener(new ah(this));
        }
    }

    public void aVP() {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.xj().getMsgReplyme();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.xj().getMsgAtme();
        int msgChat = ((msgReplyme + msgAtme) + com.baidu.tbadk.coreExtra.messageCenter.a.xj().getMsgChat()) - com.baidu.tbadk.coreExtra.messageCenter.a.xj().xq();
        if (msgChat == 0) {
            b(true, false, 0);
        } else {
            b(true, true, msgChat);
        }
    }

    public void jF(boolean z) {
        if (z) {
            this.ewT.setVisibility(0);
            this.dZe.setVisibility(8);
            return;
        }
        this.ewT.setVisibility(8);
        this.dZe.setVisibility(0);
    }

    public void b(boolean z, boolean z2, int i) {
        if (this.ewW != null && this.ewX != null) {
            if (z) {
                this.ewW.setVisibility(0);
                if (z2) {
                    this.ewX.setVisibility(0);
                    r(this.ewX, i);
                    return;
                }
                this.ewX.setVisibility(8);
                return;
            }
            this.ewW.setVisibility(8);
            this.ewX.setVisibility(8);
        }
    }

    private void r(TextView textView, int i) {
        if (textView != null) {
            this.exc = i;
            textView.setVisibility(0);
            at.c(textView, t.d.frs_slidebar_message_text, 1);
            if (i <= 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                at.k(textView, t.f.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                at.k(textView, t.f.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                at.k(textView, t.f.icon_news_head_prompt_more);
            }
        }
    }

    public void jG(boolean z) {
        if (this.ewU != null) {
            this.ewU.setVisibility(8);
        }
    }

    public void fX(boolean z) {
        this.daj = z;
        if (z) {
            if (this.exa == null) {
                aVQ();
            }
            this.exa.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.exa != null) {
            this.exa.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
    }

    public boolean aua() {
        return this.daj;
    }

    private void aVQ() {
        this.exa = (NavigationBar) ((ViewStub) this.ewR.findViewById(t.g.viewstub_navigation_bar_in_edit)).inflate();
        this.exa.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.enter_forum_edit_cancel, new ai(this));
        this.exb = this.exa.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.enter_forum_edit_confirm, new aj(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(this.ewR.getPageContext().getPageActivity(), t.e.ds16), 0);
        this.exb.setLayoutParams(layoutParams);
        this.exa.onChangeSkinType(this.ewR.getPageContext(), TbadkCoreApplication.m11getInst().getSkinType());
    }

    public void iO(boolean z) {
        if (z) {
            if (this.dZd.getVisibility() != 0) {
                this.dZd.setVisibility(0);
                iQ(true);
                at.c(this.dZd, t.f.icon_news_down_bar_one);
                return;
            }
            return;
        }
        iQ(false);
        this.dZd.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iQ(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dZc.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(this.ewR.getPageContext().getPageActivity(), t.e.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(this.ewR.getPageContext().getPageActivity(), t.e.ds20);
            }
            this.dZc.setLayoutParams(layoutParams);
        }
    }

    public void U(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.aTo.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.De(), next.ai(this.ewR.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.m11getInst().getSkinType() == 2 && TbadkCoreApplication.m11getInst().isThemeIconCover()) {
            this.aTo.ch(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aTo.ch(1);
        } else {
            this.aTo.ch(0);
        }
        this.aTo.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.Vd = cVar.auW;
            cVar2.mType = cVar.type;
            fragmentTabIndicator.setText(cVar.auX);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.ewR.getResources().getDimension(t.e.ds24));
                fragmentTabIndicator.setTextColorResId(t.d.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.auY);
                fragmentTabIndicator.setContentTvTopMargin(this.ewR.getResources().getDimensionPixelSize(t.e.ds2));
            } else {
                fragmentTabIndicator.setTextSize(0, this.ewR.getResources().getDimension(t.e.fontsize32));
                fragmentTabIndicator.setTextColorResId(t.d.s_tabbar_text_color);
            }
            fragmentTabIndicator.cV(TbadkCoreApplication.m11getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.Vc = fragmentTabIndicator;
            cVar2.Ve = bVar;
            this.aTo.a(cVar2);
        }
    }

    public FragmentTabHost aVR() {
        return this.aTo;
    }

    public void aVS() {
        String currentAccount;
        if (this.aTo != null) {
            if (this.aTo.getCurrentTabType() == 8 || this.aTo.getCurrentTabType() == 14 || this.aTo.getCurrentTabType() == 2) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                if (this.exa != null) {
                    this.exa.setVisibility(8);
                }
            } else {
                fX(aua());
            }
            if (this.aTo.getCurrentTabType() == 6 || this.dag == 6) {
                TbadkCoreApplication.m11getInst().setFriendFeedNew(false);
            }
            if (this.aTo.getCurrentTabType() != 1) {
                if (this.ewT != null) {
                    this.ewT.setVisibility(8);
                }
                if (this.dZe != null) {
                    this.dZe.setVisibility(0);
                }
            }
            if (this.aTo.getCurrentTabType() == 14) {
                if (!TbadkCoreApplication.isLogin()) {
                    currentAccount = "temp";
                } else {
                    currentAccount = TbadkCoreApplication.getCurrentAccount();
                }
                com.baidu.tbadk.core.sharedPref.b.sR().putLong("maintab_member_center_red_tip_" + currentAccount, System.currentTimeMillis() / 1000);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, false));
            }
            if (this.aTo.getCurrentTabType() != 1) {
                if (this.mHandler != null) {
                    this.mHandler.removeCallbacks(this.exe);
                    this.mHandler.removeCallbacks(this.exf);
                }
                if (this.Ey != null) {
                    this.Ey.dismiss();
                    this.Ey = null;
                }
            } else if (this.ewY) {
                aVN();
            }
        }
    }
}
