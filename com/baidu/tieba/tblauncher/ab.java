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
    private FragmentTabHost aXH;
    private ImageView csA;
    private ImageView csB;
    private ImageView csz;
    private boolean dLd;
    private MainTabActivity foM;
    private TextView foN;
    private ImageView foO;
    private ImageView foP;
    private TextView foQ;
    private NavigationBar foT;
    private View foU;
    private int foV;
    private NavigationBar mNavigationBar;
    private com.baidu.adp.lib.guide.d Ff = null;
    private Handler mHandler = null;
    private boolean foR = false;
    private boolean foS = false;
    private int dLa = -1;
    private FragmentTabHost.b foW = new ac(this);
    private com.baidu.tbadk.coreExtra.view.j avV = null;
    private Runnable bGT = new aj(this);
    private Runnable bGU = new al(this);

    public ab(MainTabActivity mainTabActivity) {
        this.foM = mainTabActivity;
    }

    public void kD(boolean z) {
        this.aXH = (FragmentTabHost) this.foM.findViewById(u.g.tab_host);
        this.aXH.setup(this.foM.getSupportFragmentManager());
        this.aXH.setOnTabSelectionListener(this.foW);
        this.aXH.setFrameLayerClickListener(new am(this));
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aXH.setShouldDrawIndicatorLine(false);
            this.aXH.setShouldDrawTopLine(true);
            this.aXH.e(0, TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds10), 0, 0);
            this.aXH.ay(true);
        }
        this.aXH.setOnPageChangeListener(new an(this));
        this.foS = com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("has_show_message_tab_tips", false);
        Qu();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.foM.getPageContext()));
        switchNaviBarStatus(z);
    }

    public void switchNaviBarStatus(boolean z) {
        this.foR = z;
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void Xd() {
        com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("has_show_message_tab_tips", this.foS);
    }

    public void Xc() {
        if (!this.foS) {
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bGT, 2000L);
        }
    }

    public boolean ahq() {
        return this.csz != null && this.csz.getVisibility() == 0;
    }

    public void eA(boolean z) {
        if (this.csz != null) {
            if (z) {
                this.csz.setVisibility(0);
            } else {
                this.csz.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            if (i == 2) {
                this.aXH.setShouldDrawTopLine(false);
            } else {
                this.aXH.setShouldDrawTopLine(true);
            }
        }
        if (this.aXH.getFragmentTabWidget() != null) {
            this.aXH.getFragmentTabWidget().setBackGroundDrawableResId(0);
        }
        this.aXH.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.foM.getPageContext(), i);
        if (this.foT != null) {
            this.foT.onChangeSkinType(this.foM.getPageContext(), i);
        }
        av.a(this.foN, u.d.cp_cont_b, u.d.s_navbar_title_color, i);
        av.c(this.csA, u.f.icon_news_down_bar_one);
        av.b(this.csz, u.f.icon_game_bg_s, u.f.icon_game_bg);
        av.b(this.csB, u.f.icon_search_bg_s, u.f.icon_search_bg);
        av.b(this.foO, u.f.icon_sign_bg_s, u.f.icon_sign_bg);
        av.b(this.foP, u.f.icon_message_bg_s, u.f.icon_message_bg);
        if (this.foP.getVisibility() == 0 && this.foQ.getVisibility() == 0) {
            com.baidu.tbadk.j.a.a(this.foM.getPageContext(), this.foQ);
        }
        if (this.foQ != null) {
            r(this.foQ, this.foV);
        }
    }

    public void a(com.baidu.tbadk.data.h hVar, int i) {
        if (hVar != null) {
            View inflate = LayoutInflater.from(this.foM.getPageContext().getPageActivity()).inflate(u.h.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(u.g.member_icon);
            TextView textView = (TextView) inflate.findViewById(u.g.member_died_line_tip);
            boolean z = TbadkCoreApplication.m10getInst().getSkinType() == 1;
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
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.foM.getPageContext().getPageActivity());
            aVar.y(inflate);
            aVar.bN(u.d.cp_link_tip_d);
            aVar.b(u.j.member_i_know, new ao(this, aVar, i));
            String string = this.foM.getPageContext().getString(u.j.member_continue_pay);
            if (i == 0) {
                string = this.foM.getPageContext().getString(u.j.open_member);
            }
            aVar.a(string, new ap(this, aVar, i));
            aVar.aq(false);
            aVar.b(this.foM.getPageContext()).rS();
            com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("show_member_deid_line", false);
        }
    }

    public void bhs() {
        FragmentTabHost.c cm;
        if (this.aXH != null && (cm = this.aXH.cm(this.aXH.getCurrentTabType())) != null && cm.Wd != null && cm.Wd.Dl() != null) {
            String string = this.foM.getPageContext().getString(cm.Wd.Dl().awC);
            if (this.foN != null) {
                this.foN.setText(string);
            }
        }
    }

    public void Qu() {
        this.mNavigationBar = (NavigationBar) this.foM.findViewById(u.g.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.foN = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, u.h.maintab_title_layout, (View.OnClickListener) null).findViewById(u.g.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.foM.getResources().getDimension(u.e.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.foN.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.game_tip_view, (View.OnClickListener) null);
            this.csz = (ImageView) addCustomView.findViewById(u.g.game_button_iv);
            this.csA = (ImageView) addCustomView.findViewById(u.g.game_tip_msg_iv);
            this.csz.setOnClickListener(new aq(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.k.c(this.foM.getPageContext().getPageActivity(), u.e.ds16), 0);
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.message_tip_view, (View.OnClickListener) null);
            this.foP = (ImageView) addCustomView2.findViewById(u.g.message_button_iv);
            this.foQ = (TextView) addCustomView2.findViewById(u.g.message_tip_msg_iv);
            bht();
            this.foP.setOnClickListener(new ar(this));
            this.csB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.widget_nb_item_search, (View.OnClickListener) null);
            this.csB.setLayoutParams(layoutParams2);
            this.csB.setVisibility(8);
            this.csB.setOnClickListener(new ad(this));
            this.foO = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.widget_nb_item_signall, (View.OnClickListener) null);
            this.foO.setLayoutParams(layoutParams2);
            this.foO.setVisibility(8);
            this.foO.setOnClickListener(new ae(this));
            this.mNavigationBar.setLoginClickListener(new af(this));
            this.mNavigationBar.setRegisterClickListener(new ag(this));
        }
    }

    public void bht() {
        int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgReplyme();
        int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgAtme();
        int msgChat = ((msgReplyme + msgAtme) + com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgChat()) - com.baidu.tbadk.coreExtra.messageCenter.a.xn().xu();
        if (msgChat == 0) {
            b(true, false, 0);
        } else {
            b(true, true, msgChat);
        }
    }

    public void kE(boolean z) {
        if (z) {
            this.foO.setVisibility(0);
            this.csB.setVisibility(8);
            return;
        }
        this.foO.setVisibility(8);
        this.csB.setVisibility(0);
    }

    public void b(boolean z, boolean z2, int i) {
        if (this.foP != null && this.foQ != null) {
            if (z) {
                this.foP.setVisibility(0);
                if (z2) {
                    this.foQ.setVisibility(0);
                    r(this.foQ, i);
                    return;
                }
                this.foQ.setVisibility(8);
                return;
            }
            this.foP.setVisibility(8);
            this.foQ.setVisibility(8);
        }
    }

    private void r(TextView textView, int i) {
        if (textView != null) {
            this.foV = i;
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

    public void gS(boolean z) {
        this.dLd = z;
        if (z) {
            if (this.foT == null) {
                bhu();
            }
            this.foT.setVisibility(0);
            this.mNavigationBar.setVisibility(8);
            return;
        }
        if (this.foT != null) {
            this.foT.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
    }

    public boolean aDg() {
        return this.dLd;
    }

    private void bhu() {
        this.foT = (NavigationBar) ((ViewStub) this.foM.findViewById(u.g.viewstub_navigation_bar_in_edit)).inflate();
        this.foT.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, u.h.enter_forum_edit_cancel, new ah(this));
        this.foU = this.foT.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.enter_forum_edit_confirm, new ai(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(this.foM.getPageContext().getPageActivity(), u.e.ds16), 0);
        this.foU.setLayoutParams(layoutParams);
        this.foT.onChangeSkinType(this.foM.getPageContext(), TbadkCoreApplication.m10getInst().getSkinType());
    }

    public void ez(boolean z) {
        if (z) {
            if (this.csA.getVisibility() != 0) {
                this.csA.setVisibility(0);
                eB(true);
                av.c(this.csA, u.f.icon_news_down_bar_one);
                return;
            }
            return;
        }
        eB(false);
        this.csA.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eB(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.csz.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(this.foM.getPageContext().getPageActivity(), u.e.ds32);
            } else {
                layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(this.foM.getPageContext().getPageActivity(), u.e.ds20);
            }
            this.csz.setLayoutParams(layoutParams);
        }
    }

    public void ag(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.aXH.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.Dl(), next.ah(this.foM.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.m10getInst().getSkinType() == 2 && TbadkCoreApplication.m10getInst().isThemeIconCover()) {
            this.aXH.ci(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.aXH.ci(1);
        } else {
            this.aXH.ci(0);
        }
        this.aXH.setViewPagerScrollable(false);
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator) {
        if (cVar != null) {
            FragmentTabHost.c cVar2 = new FragmentTabHost.c();
            cVar2.Wc = cVar.awB;
            cVar2.mType = cVar.type;
            fragmentTabIndicator.setText(cVar.awC);
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                fragmentTabIndicator.setTextSize(0, this.foM.getResources().getDimension(u.e.ds24));
                fragmentTabIndicator.setTextColorResId(u.d.s_tabbar_text_color);
                fragmentTabIndicator.setCompoundDrawablesTopResId(cVar.awD);
                fragmentTabIndicator.setContentTvTopMargin(this.foM.getResources().getDimensionPixelSize(u.e.ds2));
            } else {
                fragmentTabIndicator.setTextSize(0, this.foM.getResources().getDimension(u.e.fontsize32));
                fragmentTabIndicator.setTextColorResId(u.d.s_tabbar_text_color);
            }
            fragmentTabIndicator.cX(TbadkCoreApplication.m10getInst().getSkinType());
            fragmentTabIndicator.setTipPosType(1);
            cVar2.Wb = fragmentTabIndicator;
            cVar2.Wd = bVar;
            this.aXH.a(cVar2);
        }
    }

    public FragmentTabHost bhv() {
        return this.aXH;
    }

    public void bhw() {
        String currentAccount;
        if (this.aXH != null) {
            if (this.aXH.getCurrentTabType() == 8 || this.aXH.getCurrentTabType() == 14 || this.aXH.getCurrentTabType() == 2) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                if (this.foT != null) {
                    this.foT.setVisibility(8);
                }
            } else {
                gS(aDg());
            }
            if (this.aXH.getCurrentTabType() == 6 || this.dLa == 6) {
                TbadkCoreApplication.m10getInst().setFriendFeedNew(false);
            }
            if (this.aXH.getCurrentTabType() != 1) {
                if (this.foO != null) {
                    this.foO.setVisibility(8);
                }
                if (this.csB != null) {
                    this.csB.setVisibility(0);
                }
            }
            if (this.aXH.getCurrentTabType() == 14) {
                if (!TbadkCoreApplication.isLogin()) {
                    currentAccount = "temp";
                } else {
                    currentAccount = TbadkCoreApplication.getCurrentAccount();
                }
                com.baidu.tbadk.core.sharedPref.b.sN().putLong("maintab_member_center_red_tip_" + currentAccount, System.currentTimeMillis() / 1000);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP, false));
            }
            if (this.aXH.getCurrentTabType() != 1) {
                if (this.mHandler != null) {
                    this.mHandler.removeCallbacks(this.bGT);
                    this.mHandler.removeCallbacks(this.bGU);
                }
                if (this.Ff != null) {
                    this.Ff.dismiss();
                    this.Ff = null;
                }
            } else if (this.foR) {
                Xc();
            }
        }
    }
}
