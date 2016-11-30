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
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ae {
    private ImageView aXq;
    private FragmentTabHost bgU;
    private ImageView cJA;
    private ImageView cJz;
    private boolean eeT;
    private MainTabActivity fGL;
    private TextView fGM;
    private ImageView fGN;
    private ImageView fGO;
    private TextView fGP;
    private NavigationBar fGS;
    private View fGT;
    private int fGU;
    private NavigationBar mNavigationBar;
    private com.baidu.adp.lib.guide.d Hu = null;
    private Handler mHandler = null;
    private boolean fGQ = false;
    private boolean fGR = false;
    private int eeQ = -1;
    private FragmentTabHost.b fGV = new af(this);
    private com.baidu.tbadk.coreExtra.view.j azx = null;
    private Runnable eDp = new am(this);
    private Runnable eDq = new ao(this);

    public ae(MainTabActivity mainTabActivity) {
        this.fGL = mainTabActivity;
    }

    public void lr(boolean z) {
        this.bgU = (FragmentTabHost) this.fGL.findViewById(r.g.tab_host);
        this.bgU.setup(this.fGL.getSupportFragmentManager());
        this.bgU.setOnTabSelectionListener(this.fGV);
        this.bgU.setFrameLayerClickListener(new ap(this));
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bgU.setShouldDrawIndicatorLine(false);
            this.bgU.setShouldDrawTopLine(true);
            this.bgU.e(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds10), 0, 0);
            this.bgU.aC(true);
        }
        this.bgU.setOnPageChangeListener(new aq(this));
        this.fGR = com.baidu.tbadk.core.sharedPref.b.um().getBoolean("has_show_message_tab_tips", false);
        WB();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.fGL.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        this.fGQ = z;
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void bnU() {
        com.baidu.tbadk.core.sharedPref.b.um().putBoolean("has_show_message_tab_tips", this.fGR);
    }

    public void bnV() {
        if (!this.fGR) {
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.eDp, 2000L);
        }
    }

    public boolean aok() {
        return this.cJz != null && this.cJz.getVisibility() == 0;
    }

    public void fm(boolean z) {
        if (this.cJz != null) {
            if (z) {
                this.cJz.setVisibility(0);
            } else {
                this.cJz.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bgU.setShouldDrawTopLine(false);
            } else {
                this.bgU.setShouldDrawTopLine(true);
            }
        }
        if (this.bgU.getFragmentTabWidget() != null) {
            this.bgU.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bgU.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.fGL.getPageContext(), i);
        if (this.fGS != null) {
            this.fGS.onChangeSkinType(this.fGL.getPageContext(), i);
        }
        com.baidu.tbadk.core.util.at.a(this.fGM, r.d.cp_cont_b, r.d.s_navbar_title_color, i);
        com.baidu.tbadk.core.util.at.c(this.cJA, r.f.icon_news_down_bar_one);
        com.baidu.tbadk.core.util.at.b(this.cJz, r.f.icon_game_bg_s, r.f.icon_game_bg);
        com.baidu.tbadk.core.util.at.b(this.aXq, r.f.icon_search_bg_s, r.f.icon_search_bg);
        com.baidu.tbadk.core.util.at.b(this.fGN, r.f.icon_sign_bg_s, r.f.icon_sign_bg);
        com.baidu.tbadk.core.util.at.b(this.fGO, r.f.icon_message_bg_s, r.f.icon_message_bg);
        if (this.fGO.getVisibility() == 0 && this.fGP.getVisibility() == 0) {
            com.baidu.tbadk.i.a.a(this.fGL.getPageContext(), this.fGP);
        }
        if (this.fGP != null) {
            r(this.fGP, this.fGU);
        }
    }

    public void a(com.baidu.tbadk.data.h hVar, int i) {
        if (hVar != null) {
            View inflate = LayoutInflater.from(this.fGL.getPageContext().getPageActivity()).inflate(r.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(r.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(r.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.m9getInst().getSkinType() == 1;
            com.baidu.tbadk.core.util.at.c(textView, r.d.cp_cont_b, 1);
            if (!StringUtils.isNull(hVar.Ci())) {
                textView.setText(hVar.Ci());
            }
            if (!StringUtils.isNull(hVar.getUrl())) {
                tbImageView.c(hVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                com.baidu.tbadk.core.util.at.c(tbImageView, r.f.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fGL.getPageContext().getPageActivity());
            aVar.z(inflate);
            aVar.cb(r.d.cp_link_tip_d);
            aVar.b(r.j.member_i_know, new ar(this, aVar, i));
            String string = this.fGL.getPageContext().getString(r.j.member_continue_pay);
            if (i == 0) {
                string = this.fGL.getPageContext().getString(r.j.open_member);
            }
            aVar.a(string, new as(this, aVar, i));
            aVar.au(false);
            aVar.b(this.fGL.getPageContext()).tq();
            com.baidu.tbadk.core.sharedPref.b.um().putBoolean("show_member_deid_line", false);
        }
    }

    public void bnW() {
        FragmentTabHost.c cA;
        if (this.bgU != null && (cA = this.bgU.cA(this.bgU.getCurrentTabType())) != null && cA.ZB != null && cA.ZB.EK() != null) {
            String string = this.fGL.getPageContext().getString(cA.ZB.EK().aAe);
            if (this.fGM != null) {
                this.fGM.setText(string);
            }
        }
    }

    public void WB() {
        this.mNavigationBar = (NavigationBar) this.fGL.findViewById(r.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.fGM = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.maintab_title_layout, (View.OnClickListener) null).findViewById(r.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.fGL.getResources().getDimension(r.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.fGM.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.game_tip_view, (View.OnClickListener) null);
            this.cJz = (ImageView) addCustomView.findViewById(r.g.game_button_iv);
            this.cJA = (ImageView) addCustomView.findViewById(r.g.game_tip_msg_iv);
            this.cJz.setOnClickListener(new at(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.fGL.getPageContext().getPageActivity(), r.e.ds16), 0);
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.message_tip_view, (View.OnClickListener) null);
            this.fGO = (ImageView) addCustomView2.findViewById(r.g.message_button_iv);
            this.fGP = (TextView) addCustomView2.findViewById(r.g.message_tip_msg_iv);
            bnX();
            this.fGO.setOnClickListener(new au(this));
            this.aXq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.widget_nb_item_search, (View.OnClickListener) null);
            this.aXq.setLayoutParams(layoutParams2);
            this.aXq.setVisibility(8);
            this.aXq.setOnClickListener(new ag(this));
            this.fGN = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.fGN.setLayoutParams(layoutParams2);
            this.fGN.setVisibility(8);
            this.fGN.setOnClickListener(new ah(this));
            this.mNavigationBar.setLoginClickListener(new ai(this));
            this.mNavigationBar.setRegisterClickListener(new aj(this));
        }
    }

    public void bnX() {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.yK().getMsgReplyme();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.yK().getMsgAtme();
        int msgChat = ((msgReplyme + msgAtme) + com.baidu.tbadk.coreExtra.messageCenter.a.yK().getMsgChat()) - com.baidu.tbadk.coreExtra.messageCenter.a.yK().yR();
        if (msgChat == 0) {
            a(true, false, 0);
        } else {
            a(true, true, msgChat);
        }
    }

    public void ls(boolean z) {
        if (z) {
            this.fGN.setVisibility(0);
            this.aXq.setVisibility(8);
            return;
        }
        this.fGN.setVisibility(8);
        this.aXq.setVisibility(0);
    }

    public void a(boolean z, boolean z2, int i) {
        if (this.fGO != null && this.fGP != null) {
            if (z) {
                this.fGO.setVisibility(0);
                if (z2) {
                    this.fGP.setVisibility(0);
                    r(this.fGP, i);
                    return;
                }
                this.fGP.setVisibility(8);
                return;
            }
            this.fGO.setVisibility(8);
            this.fGP.setVisibility(8);
        }
    }

    private void r(TextView textView, int i) {
        if (textView != null) {
            this.fGU = i;
            textView.setVisibility(0);
            com.baidu.tbadk.core.util.at.c(textView, r.d.common_color_10225, 1);
            if (i <= 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                com.baidu.tbadk.core.util.at.k(textView, r.f.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                com.baidu.tbadk.core.util.at.k(textView, r.f.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                com.baidu.tbadk.core.util.at.k(textView, r.f.icon_news_head_prompt_more);
            }
        }
    }

    public void hK(boolean z) {
        this.eeT = z;
        if (z) {
            if (this.fGS == null) {
                bnY();
            }
            this.fGS.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.fGS != null) {
            this.fGS.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
    }

    public boolean aKq() {
        return this.eeT;
    }

    private void bnY() {
        this.fGS = (NavigationBar) ((ViewStub) this.fGL.findViewById(r.g.viewstub_navigation_bar_in_edit)).inflate();
        this.fGS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.enter_forum_edit_cancel, new ak(this));
        this.fGT = this.fGS.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.enter_forum_edit_confirm, new al(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.fGL.getPageContext().getPageActivity(), r.e.ds16), 0);
        this.fGT.setLayoutParams(layoutParams);
        this.fGS.onChangeSkinType(this.fGL.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void fl(boolean z) {
        if (z) {
            if (this.cJA.getVisibility() != 0) {
                this.cJA.setVisibility(0);
                fn(true);
                com.baidu.tbadk.core.util.at.c(this.cJA, r.f.icon_news_down_bar_one);
                return;
            }
            return;
        }
        fn(false);
        this.cJA.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fn(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cJz.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.fGL.getPageContext().getPageActivity(), r.e.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.fGL.getPageContext().getPageActivity(), r.e.ds20);
            }
            this.cJz.setLayoutParams(layoutParams);
        }
    }

    public void ai(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bgU.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.EK(), next.ap(this.fGL.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2 && TbadkCoreApplication.m9getInst().isThemeIconCover()) {
            this.bgU.cw(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bgU.cw(1);
        } else {
            this.bgU.cw(0);
        }
        this.bgU.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.ZA = cVar.aAd;
            cVar2.mType = cVar.type;
            fragmentTabIndicator.setText(cVar.aAe);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.fGL.getResources().getDimension(r.e.ds24));
                fragmentTabIndicator.setTextColorResId(r.d.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.aAf);
                fragmentTabIndicator.setContentTvTopMargin(this.fGL.getResources().getDimensionPixelSize(r.e.ds2));
            } else {
                fragmentTabIndicator.setTextSize(0, this.fGL.getResources().getDimension(r.e.fontsize32));
                fragmentTabIndicator.setTextColorResId(r.d.s_tabbar_text_color);
            }
            fragmentTabIndicator.dm(TbadkCoreApplication.m9getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.Zz = fragmentTabIndicator;
            cVar2.ZB = bVar;
            this.bgU.a(cVar2);
        }
    }

    public FragmentTabHost bnZ() {
        return this.bgU;
    }

    public void boa() {
        String currentAccount;
        if (this.bgU != null) {
            if (this.bgU.getCurrentTabType() == 8 || this.bgU.getCurrentTabType() == 14 || this.bgU.getCurrentTabType() == 2 || this.bgU.getCurrentTabType() == 15) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                if (this.fGS != null) {
                    this.fGS.setVisibility(8);
                }
            } else {
                hK(aKq());
            }
            if (this.bgU.getCurrentTabType() != 1) {
                if (this.fGN != null) {
                    this.fGN.setVisibility(8);
                }
                if (this.aXq != null) {
                    this.aXq.setVisibility(0);
                }
            }
            if (this.bgU.getCurrentTabType() == 14) {
                if (!TbadkCoreApplication.isLogin()) {
                    currentAccount = "temp";
                } else {
                    currentAccount = TbadkCoreApplication.getCurrentAccount();
                }
                com.baidu.tbadk.core.sharedPref.b.um().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.m9getInst().getLastUpdateMemberCenterTime());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, false));
            }
            if (this.bgU.getCurrentTabType() != 1) {
                if (this.mHandler != null) {
                    this.mHandler.removeCallbacks(this.eDp);
                    this.mHandler.removeCallbacks(this.eDq);
                }
                if (this.Hu != null) {
                    this.Hu.dismiss();
                    this.Hu = null;
                }
            } else if (this.fGQ) {
                bnV();
            }
        }
    }
}
