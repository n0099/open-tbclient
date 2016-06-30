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
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ab {
    private FragmentTabHost aWJ;
    private ImageView cpU;
    private ImageView cpV;
    private ImageView cpW;
    private boolean dGR;
    private MainTabActivity fbI;
    private TextView fbJ;
    private ImageView fbK;
    private ImageView fbL;
    private TextView fbM;
    private NavigationBar fbP;
    private View fbQ;
    private int fbR;
    private NavigationBar mNavigationBar;
    private com.baidu.adp.lib.guide.d EF = null;
    private Handler mHandler = null;
    private boolean fbN = false;
    private boolean fbO = false;
    private int dGO = -1;
    private FragmentTabHost.b fbS = new ac(this);
    private com.baidu.tbadk.coreExtra.view.j avg = null;
    private Runnable bFF = new aj(this);
    private Runnable bFG = new al(this);

    public ab(MainTabActivity mainTabActivity) {
        this.fbI = mainTabActivity;
    }

    public void kp(boolean z) {
        this.aWJ = (FragmentTabHost) this.fbI.findViewById(u.g.tab_host);
        this.aWJ.setup(this.fbI.getSupportFragmentManager());
        this.aWJ.setOnTabSelectionListener(this.fbS);
        this.aWJ.setFrameLayerClickListener(new am(this));
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aWJ.setShouldDrawIndicatorLine(false);
            this.aWJ.setShouldDrawTopLine(true);
            this.aWJ.d(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds10), 0, 0);
            this.aWJ.av(true);
        }
        this.aWJ.setOnPageChangeListener(new an(this));
        this.fbO = com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("has_show_message_tab_tips", false);
        PQ();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.fbI.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        this.fbN = z;
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void WL() {
        com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("has_show_message_tab_tips", this.fbO);
    }

    public void WK() {
        if (!this.fbO) {
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bFF, 2000L);
        }
    }

    public boolean agK() {
        return this.cpU != null && this.cpU.getVisibility() == 0;
    }

    public void ez(boolean z) {
        if (this.cpU != null) {
            if (z) {
                this.cpU.setVisibility(0);
            } else {
                this.cpU.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.aWJ.setShouldDrawTopLine(false);
            } else {
                this.aWJ.setShouldDrawTopLine(true);
            }
        }
        if (this.aWJ.getFragmentTabWidget() != null) {
            this.aWJ.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.aWJ.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.fbI.getPageContext(), i);
        if (this.fbP != null) {
            this.fbP.onChangeSkinType(this.fbI.getPageContext(), i);
        }
        av.a(this.fbJ, u.d.cp_cont_b, u.d.s_navbar_title_color, i);
        av.c(this.cpV, u.f.icon_news_down_bar_one);
        av.a(this.cpU, u.f.icon_game_bg_s, u.f.icon_game_bg);
        av.a(this.cpW, u.f.icon_search_bg_s, u.f.icon_search_bg);
        av.a(this.fbK, u.f.icon_sign_bg_s, u.f.icon_sign_bg);
        av.a(this.fbL, u.f.icon_message_bg_s, u.f.icon_message_bg);
        if (this.fbL.getVisibility() == 0 && this.fbM.getVisibility() == 0) {
            com.baidu.tbadk.j.a.a(this.fbI.getPageContext(), this.fbM);
        }
        if (this.fbM != null) {
            r(this.fbM, this.fbR);
        }
    }

    public void a(com.baidu.tbadk.data.h hVar, int i) {
        if (hVar != null) {
            View inflate = LayoutInflater.from(this.fbI.getPageContext().getPageActivity()).inflate(u.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(u.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(u.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.m9getInst().getSkinType() == 1;
            av.c(textView, u.d.cp_cont_b, 1);
            if (!StringUtils.isNull(hVar.AK())) {
                textView.setText(hVar.AK());
            }
            if (!StringUtils.isNull(hVar.getUrl())) {
                tbImageView.c(hVar.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                av.c(tbImageView, u.f.icon_vip_advanced);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fbI.getPageContext().getPageActivity());
            aVar.y(inflate);
            aVar.bN(u.d.cp_link_tip_d);
            aVar.b(u.j.member_i_know, new ao(this, aVar, i));
            String string = this.fbI.getPageContext().getString(u.j.member_continue_pay);
            if (i == 0) {
                string = this.fbI.getPageContext().getString(u.j.open_member);
            }
            aVar.a(string, new ap(this, aVar, i));
            aVar.ao(false);
            aVar.b(this.fbI.getPageContext()).rT();
            com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("show_member_deid_line", false);
        }
    }

    public void bea() {
        FragmentTabHost.c cm;
        if (this.aWJ != null && (cm = this.aWJ.cm(this.aWJ.getCurrentTabType())) != null && cm.Vu != null && cm.Vu.Dm() != null) {
            String string = this.fbI.getPageContext().getString(cm.Vu.Dm().avN);
            if (this.fbJ != null) {
                this.fbJ.setText(string);
            }
        }
    }

    public void PQ() {
        this.mNavigationBar = (NavigationBar) this.fbI.findViewById(u.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.fbJ = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, u.h.maintab_title_layout, (View.OnClickListener) null).findViewById(u.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.fbI.getResources().getDimension(u.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.fbJ.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.game_tip_view, (View.OnClickListener) null);
            this.cpU = (ImageView) addCustomView.findViewById(u.g.game_button_iv);
            this.cpV = (ImageView) addCustomView.findViewById(u.g.game_tip_msg_iv);
            this.cpU.setOnClickListener(new aq(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.k.c(this.fbI.getPageContext().getPageActivity(), u.e.ds16), 0);
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.message_tip_view, (View.OnClickListener) null);
            this.fbL = (ImageView) addCustomView2.findViewById(u.g.message_button_iv);
            this.fbM = (TextView) addCustomView2.findViewById(u.g.message_tip_msg_iv);
            beb();
            this.fbL.setOnClickListener(new ar(this));
            this.cpW = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.widget_nb_item_search, (View.OnClickListener) null);
            this.cpW.setLayoutParams(layoutParams2);
            this.cpW.setVisibility(8);
            this.cpW.setOnClickListener(new ad(this));
            this.fbK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.fbK.setLayoutParams(layoutParams2);
            this.fbK.setVisibility(8);
            this.fbK.setOnClickListener(new ae(this));
            this.mNavigationBar.setLoginClickListener(new af(this));
            this.mNavigationBar.setRegisterClickListener(new ag(this));
        }
    }

    public void beb() {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgReplyme();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgAtme();
        int msgChat = ((msgReplyme + msgAtme) + com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgChat()) - com.baidu.tbadk.coreExtra.messageCenter.a.xn().xu();
        if (msgChat == 0) {
            b(true, false, 0);
        } else {
            b(true, true, msgChat);
        }
    }

    public void kq(boolean z) {
        if (z) {
            this.fbK.setVisibility(0);
            this.cpW.setVisibility(8);
            return;
        }
        this.fbK.setVisibility(8);
        this.cpW.setVisibility(0);
    }

    public void b(boolean z, boolean z2, int i) {
        if (this.fbL != null && this.fbM != null) {
            if (z) {
                this.fbL.setVisibility(0);
                if (z2) {
                    this.fbM.setVisibility(0);
                    r(this.fbM, i);
                    return;
                }
                this.fbM.setVisibility(8);
                return;
            }
            this.fbL.setVisibility(8);
            this.fbM.setVisibility(8);
        }
    }

    private void r(TextView textView, int i) {
        if (textView != null) {
            this.fbR = i;
            textView.setVisibility(0);
            av.c(textView, u.d.common_color_10225, 1);
            if (i <= 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                av.k(textView, u.f.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                av.k(textView, u.f.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                av.k(textView, u.f.icon_news_head_prompt_more);
            }
        }
    }

    public void gN(boolean z) {
        this.dGR = z;
        if (z) {
            if (this.fbP == null) {
                bec();
            }
            this.fbP.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.fbP != null) {
            this.fbP.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
    }

    public boolean aCf() {
        return this.dGR;
    }

    private void bec() {
        this.fbP = (NavigationBar) ((ViewStub) this.fbI.findViewById(u.g.viewstub_navigation_bar_in_edit)).inflate();
        this.fbP.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, u.h.enter_forum_edit_cancel, new ah(this));
        this.fbQ = this.fbP.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.enter_forum_edit_confirm, new ai(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(this.fbI.getPageContext().getPageActivity(), u.e.ds16), 0);
        this.fbQ.setLayoutParams(layoutParams);
        this.fbP.onChangeSkinType(this.fbI.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void ey(boolean z) {
        if (z) {
            if (this.cpV.getVisibility() != 0) {
                this.cpV.setVisibility(0);
                eA(true);
                av.c(this.cpV, u.f.icon_news_down_bar_one);
                return;
            }
            return;
        }
        eA(false);
        this.cpV.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eA(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cpU.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(this.fbI.getPageContext().getPageActivity(), u.e.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(this.fbI.getPageContext().getPageActivity(), u.e.ds20);
            }
            this.cpU.setLayoutParams(layoutParams);
        }
    }

    public void ae(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.aWJ.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Dm(), next.ah(this.fbI.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2 && TbadkCoreApplication.m9getInst().isThemeIconCover()) {
            this.aWJ.ci(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aWJ.ci(1);
        } else {
            this.aWJ.ci(0);
        }
        this.aWJ.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.Vt = cVar.avM;
            cVar2.mType = cVar.type;
            fragmentTabIndicator.setText(cVar.avN);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.fbI.getResources().getDimension(u.e.ds24));
                fragmentTabIndicator.setTextColorResId(u.d.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.avO);
                fragmentTabIndicator.setContentTvTopMargin(this.fbI.getResources().getDimensionPixelSize(u.e.ds2));
            } else {
                fragmentTabIndicator.setTextSize(0, this.fbI.getResources().getDimension(u.e.fontsize32));
                fragmentTabIndicator.setTextColorResId(u.d.s_tabbar_text_color);
            }
            fragmentTabIndicator.cX(TbadkCoreApplication.m9getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.Vs = fragmentTabIndicator;
            cVar2.Vu = bVar;
            this.aWJ.a(cVar2);
        }
    }

    public FragmentTabHost bed() {
        return this.aWJ;
    }

    public void bee() {
        String currentAccount;
        if (this.aWJ != null) {
            if (this.aWJ.getCurrentTabType() == 8 || this.aWJ.getCurrentTabType() == 14 || this.aWJ.getCurrentTabType() == 2) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                if (this.fbP != null) {
                    this.fbP.setVisibility(8);
                }
            } else {
                gN(aCf());
            }
            if (this.aWJ.getCurrentTabType() == 6 || this.dGO == 6) {
                TbadkCoreApplication.m9getInst().setFriendFeedNew(false);
            }
            if (this.aWJ.getCurrentTabType() != 1) {
                if (this.fbK != null) {
                    this.fbK.setVisibility(8);
                }
                if (this.cpW != null) {
                    this.cpW.setVisibility(0);
                }
            }
            if (this.aWJ.getCurrentTabType() == 14) {
                if (!TbadkCoreApplication.isLogin()) {
                    currentAccount = "temp";
                } else {
                    currentAccount = TbadkCoreApplication.getCurrentAccount();
                }
                com.baidu.tbadk.core.sharedPref.b.sO().putLong("maintab_member_center_red_tip_" + currentAccount, System.currentTimeMillis() / 1000);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, false));
            }
            if (this.aWJ.getCurrentTabType() != 1) {
                if (this.mHandler != null) {
                    this.mHandler.removeCallbacks(this.bFF);
                    this.mHandler.removeCallbacks(this.bFG);
                }
                if (this.EF != null) {
                    this.EF.dismiss();
                    this.EF = null;
                }
            } else if (this.fbN) {
                WK();
            }
        }
    }
}
