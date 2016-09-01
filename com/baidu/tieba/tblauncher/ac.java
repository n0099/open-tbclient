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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ac {
    private FragmentTabHost bdA;
    private ImageView cDH;
    private ImageView cDI;
    private ImageView cDJ;
    private boolean dXa;
    private MainTabActivity fwG;
    private TextView fwH;
    private ImageView fwI;
    private ImageView fwJ;
    private TextView fwK;
    private NavigationBar fwN;
    private View fwO;
    private int fwP;
    private NavigationBar mNavigationBar;
    private com.baidu.adp.lib.guide.d Hs = null;
    private Handler mHandler = null;
    private boolean fwL = false;
    private boolean fwM = false;
    private int dWX = -1;
    private FragmentTabHost.b fwQ = new ad(this);
    private com.baidu.tbadk.coreExtra.view.j azc = null;
    private Runnable bRZ = new ak(this);
    private Runnable bSa = new am(this);

    public ac(MainTabActivity mainTabActivity) {
        this.fwG = mainTabActivity;
    }

    public void kP(boolean z) {
        this.bdA = (FragmentTabHost) this.fwG.findViewById(t.g.tab_host);
        this.bdA.setup(this.fwG.getSupportFragmentManager());
        this.bdA.setOnTabSelectionListener(this.fwQ);
        this.bdA.setFrameLayerClickListener(new an(this));
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bdA.setShouldDrawIndicatorLine(false);
            this.bdA.setShouldDrawTopLine(true);
            this.bdA.e(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds10), 0, 0);
            this.bdA.az(true);
        }
        this.bdA.setOnPageChangeListener(new ao(this));
        this.fwM = com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("has_show_message_tab_tips", false);
        Vg();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.fwG.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        this.fwL = z;
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void aca() {
        com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("has_show_message_tab_tips", this.fwM);
    }

    public void abZ() {
        if (!this.fwM) {
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bRZ, 2000L);
        }
    }

    public boolean amb() {
        return this.cDH != null && this.cDH.getVisibility() == 0;
    }

    public void eW(boolean z) {
        if (this.cDH != null) {
            if (z) {
                this.cDH.setVisibility(0);
            } else {
                this.cDH.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.bdA.setShouldDrawTopLine(false);
            } else {
                this.bdA.setShouldDrawTopLine(true);
            }
        }
        if (this.bdA.getFragmentTabWidget() != null) {
            this.bdA.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.bdA.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.fwG.getPageContext(), i);
        if (this.fwN != null) {
            this.fwN.onChangeSkinType(this.fwG.getPageContext(), i);
        }
        av.a(this.fwH, t.d.cp_cont_b, t.d.s_navbar_title_color, i);
        av.c(this.cDI, t.f.icon_news_down_bar_one);
        av.b(this.cDH, t.f.icon_game_bg_s, t.f.icon_game_bg);
        av.b(this.cDJ, t.f.icon_search_bg_s, t.f.icon_search_bg);
        av.b(this.fwI, t.f.icon_sign_bg_s, t.f.icon_sign_bg);
        av.b(this.fwJ, t.f.icon_message_bg_s, t.f.icon_message_bg);
        if (this.fwJ.getVisibility() == 0 && this.fwK.getVisibility() == 0) {
            com.baidu.tbadk.j.a.a(this.fwG.getPageContext(), this.fwK);
        }
        if (this.fwK != null) {
            r(this.fwK, this.fwP);
        }
    }

    public void a(com.baidu.tbadk.data.h hVar, int i) {
        if (hVar != null) {
            View inflate = LayoutInflater.from(this.fwG.getPageContext().getPageActivity()).inflate(t.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(t.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(t.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.m9getInst().getSkinType() == 1;
            av.c(textView, t.d.cp_cont_b, 1);
            if (!StringUtils.isNull(hVar.BZ())) {
                textView.setText(hVar.BZ());
            }
            if (!StringUtils.isNull(hVar.getUrl())) {
                tbImageView.c(hVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                av.c(tbImageView, t.f.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fwG.getPageContext().getPageActivity());
            aVar.z(inflate);
            aVar.ca(t.d.cp_link_tip_d);
            aVar.b(t.j.member_i_know, new ap(this, aVar, i));
            String string = this.fwG.getPageContext().getString(t.j.member_continue_pay);
            if (i == 0) {
                string = this.fwG.getPageContext().getString(t.j.open_member);
            }
            aVar.a(string, new aq(this, aVar, i));
            aVar.ar(false);
            aVar.b(this.fwG.getPageContext()).sX();
            com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("show_member_deid_line", false);
        }
    }

    public void bkW() {
        FragmentTabHost.c cz;
        if (this.bdA != null && (cz = this.bdA.cz(this.bdA.getCurrentTabType())) != null && cz.YQ != null && cz.YQ.EF() != null) {
            String string = this.fwG.getPageContext().getString(cz.YQ.EF().azJ);
            if (this.fwH != null) {
                this.fwH.setText(string);
            }
        }
    }

    public void Vg() {
        this.mNavigationBar = (NavigationBar) this.fwG.findViewById(t.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.fwH = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.maintab_title_layout, (View.OnClickListener) null).findViewById(t.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.fwG.getResources().getDimension(t.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.fwH.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.game_tip_view, (View.OnClickListener) null);
            this.cDH = (ImageView) addCustomView.findViewById(t.g.game_button_iv);
            this.cDI = (ImageView) addCustomView.findViewById(t.g.game_tip_msg_iv);
            this.cDH.setOnClickListener(new ar(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.fwG.getPageContext().getPageActivity(), t.e.ds16), 0);
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.message_tip_view, (View.OnClickListener) null);
            this.fwJ = (ImageView) addCustomView2.findViewById(t.g.message_button_iv);
            this.fwK = (TextView) addCustomView2.findViewById(t.g.message_tip_msg_iv);
            bkX();
            this.fwJ.setOnClickListener(new as(this));
            this.cDJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_search, (View.OnClickListener) null);
            this.cDJ.setLayoutParams(layoutParams2);
            this.cDJ.setVisibility(8);
            this.cDJ.setOnClickListener(new ae(this));
            this.fwI = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.fwI.setLayoutParams(layoutParams2);
            this.fwI.setVisibility(8);
            this.fwI.setOnClickListener(new af(this));
            this.mNavigationBar.setLoginClickListener(new ag(this));
            this.mNavigationBar.setRegisterClickListener(new ah(this));
        }
    }

    public void bkX() {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.yA().getMsgReplyme();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.yA().getMsgAtme();
        int msgChat = ((msgReplyme + msgAtme) + com.baidu.tbadk.coreExtra.messageCenter.a.yA().getMsgChat()) - com.baidu.tbadk.coreExtra.messageCenter.a.yA().yH();
        if (msgChat == 0) {
            a(true, false, 0);
        } else {
            a(true, true, msgChat);
        }
    }

    public void kQ(boolean z) {
        if (z) {
            this.fwI.setVisibility(0);
            this.cDJ.setVisibility(8);
            return;
        }
        this.fwI.setVisibility(8);
        this.cDJ.setVisibility(0);
    }

    public void a(boolean z, boolean z2, int i) {
        if (this.fwJ != null && this.fwK != null) {
            if (z) {
                this.fwJ.setVisibility(0);
                if (z2) {
                    this.fwK.setVisibility(0);
                    r(this.fwK, i);
                    return;
                }
                this.fwK.setVisibility(8);
                return;
            }
            this.fwJ.setVisibility(8);
            this.fwK.setVisibility(8);
        }
    }

    private void r(TextView textView, int i) {
        if (textView != null) {
            this.fwP = i;
            textView.setVisibility(0);
            av.c(textView, t.d.common_color_10225, 1);
            if (i <= 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                av.k(textView, t.f.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                av.k(textView, t.f.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                av.k(textView, t.f.icon_news_head_prompt_more);
            }
        }
    }

    public void ho(boolean z) {
        this.dXa = z;
        if (z) {
            if (this.fwN == null) {
                bkY();
            }
            this.fwN.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.fwN != null) {
            this.fwN.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
    }

    public boolean aHU() {
        return this.dXa;
    }

    private void bkY() {
        this.fwN = (NavigationBar) ((ViewStub) this.fwG.findViewById(t.g.viewstub_navigation_bar_in_edit)).inflate();
        this.fwN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.enter_forum_edit_cancel, new ai(this));
        this.fwO = this.fwN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.enter_forum_edit_confirm, new aj(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.fwG.getPageContext().getPageActivity(), t.e.ds16), 0);
        this.fwO.setLayoutParams(layoutParams);
        this.fwN.onChangeSkinType(this.fwG.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void eV(boolean z) {
        if (z) {
            if (this.cDI.getVisibility() != 0) {
                this.cDI.setVisibility(0);
                eX(true);
                av.c(this.cDI, t.f.icon_news_down_bar_one);
                return;
            }
            return;
        }
        eX(false);
        this.cDI.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eX(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cDH.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.fwG.getPageContext().getPageActivity(), t.e.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.e(this.fwG.getPageContext().getPageActivity(), t.e.ds20);
            }
            this.cDH.setLayoutParams(layoutParams);
        }
    }

    public void af(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.bdA.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.EF(), next.ar(this.fwG.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2 && TbadkCoreApplication.m9getInst().isThemeIconCover()) {
            this.bdA.cv(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.bdA.cv(1);
        } else {
            this.bdA.cv(0);
        }
        this.bdA.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.YP = cVar.azI;
            cVar2.mType = cVar.type;
            fragmentTabIndicator.setText(cVar.azJ);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.fwG.getResources().getDimension(t.e.ds24));
                fragmentTabIndicator.setTextColorResId(t.d.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.azK);
                fragmentTabIndicator.setContentTvTopMargin(this.fwG.getResources().getDimensionPixelSize(t.e.ds2));
            } else {
                fragmentTabIndicator.setTextSize(0, this.fwG.getResources().getDimension(t.e.fontsize32));
                fragmentTabIndicator.setTextColorResId(t.d.s_tabbar_text_color);
            }
            fragmentTabIndicator.dl(TbadkCoreApplication.m9getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.YO = fragmentTabIndicator;
            cVar2.YQ = bVar;
            this.bdA.a(cVar2);
        }
    }

    public FragmentTabHost bkZ() {
        return this.bdA;
    }

    public void bla() {
        String currentAccount;
        if (this.bdA != null) {
            if (this.bdA.getCurrentTabType() == 8 || this.bdA.getCurrentTabType() == 14 || this.bdA.getCurrentTabType() == 2) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                if (this.fwN != null) {
                    this.fwN.setVisibility(8);
                }
            } else {
                ho(aHU());
            }
            if (this.bdA.getCurrentTabType() == 6 || this.dWX == 6) {
                TbadkCoreApplication.m9getInst().setFriendFeedNew(false);
            }
            if (this.bdA.getCurrentTabType() != 1) {
                if (this.fwI != null) {
                    this.fwI.setVisibility(8);
                }
                if (this.cDJ != null) {
                    this.cDJ.setVisibility(0);
                }
            }
            if (this.bdA.getCurrentTabType() == 14) {
                if (!TbadkCoreApplication.isLogin()) {
                    currentAccount = "temp";
                } else {
                    currentAccount = TbadkCoreApplication.getCurrentAccount();
                }
                com.baidu.tbadk.core.sharedPref.b.tS().putLong("maintab_member_center_red_tip_" + currentAccount, TbadkCoreApplication.m9getInst().getLastUpdateMemberCenterTime());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, false));
            }
            if (this.bdA.getCurrentTabType() != 1) {
                if (this.mHandler != null) {
                    this.mHandler.removeCallbacks(this.bRZ);
                    this.mHandler.removeCallbacks(this.bSa);
                }
                if (this.Hs != null) {
                    this.Hs.dismiss();
                    this.Hs = null;
                }
            } else if (this.fwL) {
                abZ();
            }
        }
    }
}
