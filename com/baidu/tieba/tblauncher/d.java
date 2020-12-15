package com.baidu.tieba.tblauncher;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.d.h;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes22.dex */
public class d {
    private com.baidu.tieba.video.f iVY;
    private ImageView iwg;
    private h jrd;
    private boolean lnI;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private MainTabActivity nsB;
    private TextView nsF;
    private ImageView nsG;
    private ImageView nsH;
    private TextView nsI;
    private ImageView nsJ;
    private TextView nsK;
    private PopupWindow nsM;
    private MaintabBottomIndicator nsO;
    private MaintabBottomIndicator nsP;
    private Runnable nsW;
    private boolean nsL = false;
    private int lnE = -1;
    private boolean nsN = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean fAc = true;
    private int nsQ = 1;
    private boolean isInterrupt = false;
    private boolean nsR = false;
    private FragmentTabHost.a nsS = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b pL = d.this.mTabHost.pL(i);
            if (pL.mType == 8) {
                if (d.this.nsO != null && d.this.nsO.getAnimationView() != null && d.this.nsO.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new ar("c10605").al("obj_type", 1));
                } else {
                    TiebaStatic.log(new ar("c10605").al("obj_type", 0));
                }
                if (d.this.nsO != null) {
                    d.this.nsO.bEd();
                }
                TiebaStatic.log("c13841");
            } else if (pL.mType == 3) {
                TiebaStatic.log(new ar(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).al("obj_locate", 1));
                TiebaStatic.log(new ar(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).al("obj_locate", 1));
            }
            if (pL.mType == 2) {
                if (d.this.fAc) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.fAc = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.nsQ != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.nsQ == 1) {
                        d.this.nsP.kJ(d.this.fAc);
                    }
                } else {
                    d.this.nsP.bEh();
                }
                d.this.isInterrupt = false;
            } else {
                d.this.isInterrupt = true;
                if (d.this.fAc) {
                    d.this.nsP.kJ(d.this.fAc);
                }
                d.this.fAc = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.dRH() != null) {
                d.this.dRH().fAc = d.this.fAc;
            }
            Lq(d.this.lastIndex);
            Lr(d.this.lastIndex);
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        private void Lq(int i) {
            FragmentTabHost.b pL = d.this.mTabHost.pL(i);
            if (pL.mType == 8) {
                com.baidu.tbadk.pageExtra.d.En(PageStayDurationConstants.PageName.PERSON);
            } else if (pL.mType == 2) {
                com.baidu.tbadk.pageExtra.d.En(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            } else if (pL.mType == 3) {
                com.baidu.tbadk.pageExtra.d.En("a079");
            } else if (pL.mType == 1) {
                com.baidu.tbadk.pageExtra.d.En(PageStayDurationConstants.PageName.ENTER_FORUM);
            } else if (pL.mType == 21) {
                com.baidu.tbadk.pageExtra.d.En("a075");
            }
        }

        private void Lr(int i) {
            String bET;
            if (d.this.mTabHost.pL(i).mType == 2) {
                bET = com.baidu.tbadk.pageExtra.d.eW(d.this.nsB.getPageContext().getContext());
            } else {
                bET = com.baidu.tbadk.pageExtra.d.bET();
            }
            final CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921520, bET);
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.d.1.1
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            }, 100L);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b pL = d.this.mTabHost.pL(i);
            if (pL.mType == 9) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new k(0)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (pL.mType == 8 && !bh.checkUpIsLogin(d.this.nsB.getActivity())) {
                if (d.this.nsO != null) {
                    d.this.nsO.bEd();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (pL.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        bf.bua().a(d.this.nsB.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (pL.mType == 3 && !bh.checkUpIsLogin(d.this.nsB.getActivity())) {
                    return false;
                } else {
                    if (pL.mType == 1) {
                        TiebaStatic.log(new ar("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener nsT = new CustomMessageListener(2921492) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.mainTab.c cVar;
            if (customResponsedMessage != null && d.this.mTabHost != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.c) && (cVar = (com.baidu.tbadk.mainTab.c) customResponsedMessage.getData()) != null && d.this.mTabHost.pM(cVar.type) != null && d.this.mTabHost.getCurrentTabType() != 21) {
                FragmentTabHost.b pM = d.this.mTabHost.pM(cVar.type);
                if (pM.eRD instanceof MaintabBottomIndicator) {
                    ((MaintabBottomIndicator) pM.eRD).setImageIconUrl(cVar.fzR, cVar.text);
                }
            }
        }
    };
    private CustomMessageListener nsU = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dRH() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.isInterrupt = true;
                        d.this.fAc = true;
                        if (d.this.nsQ != 2) {
                            if (d.this.nsP.isAnimating()) {
                                d.this.nsP.kJ(d.this.fAc);
                                return;
                            }
                            return;
                        }
                        d.this.dRH().bEj();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.isInterrupt = false;
                        if (d.this.nsQ == 1) {
                            return;
                        }
                    } else {
                        d.this.nsQ = intValue;
                    }
                    if (d.this.nsQ == 1) {
                        d.this.dRH().kJ(d.this.fAc);
                    } else if (d.this.nsQ == 2) {
                        d.this.dRH().bEh();
                    } else if (intValue == 5) {
                        d.this.nsQ = 1;
                        d.this.fAc = true;
                        if (!d.this.isInterrupt) {
                            d.this.dRH().bEj();
                        }
                    } else {
                        d.this.dRH().bEi();
                    }
                    d.this.dRH().fAb = true;
                    d.this.dRH().fAd = d.this.nsQ;
                    d.this.dRH().fAc = d.this.fAc;
                }
            }
        }
    };
    private CustomMessageListener nsV = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.fAc = true;
            if (d.this.dRH() != null) {
                d.this.dRH().fAc = d.this.fAc;
            }
        }
    };
    private Runnable jyF = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.nsM != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.nsB.getActivity());
                int dimens = l.getDimens(d.this.nsB.getActivity(), R.dimen.ds178);
                View contentView = d.this.nsM.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b pM = d.this.mTabHost.pM(3);
                    if (pM != null && (tbFragmentTabIndicator = pM.eRD) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.nsB.getActivity(), R.dimen.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.nsM, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.nsN = true;
                        d.this.mHandler.postDelayed(d.this.jyG, 5000L);
                    }
                }
            }
        }
    };
    private Runnable jyG = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // java.lang.Runnable
        public void run() {
            d.this.dRJ();
        }
    };
    private View.OnClickListener jyH = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dRJ();
        }
    };

    public void setCurrentTabByType(int i) {
        cEf().setCurrentTabByType(i);
        if (i != 2) {
            this.isInterrupt = true;
            if (this.fAc) {
                this.nsP.kJ(false);
            }
            this.fAc = false;
            if (dRH() != null) {
                dRH().fAc = this.fAc;
            }
        }
    }

    public d(MainTabActivity mainTabActivity) {
        this.nsB = mainTabActivity;
    }

    public void yo(boolean z) {
        this.mTabHost = (FragmentTabHost) this.nsB.findViewById(R.id.tab_host);
        this.mTabHost.setup(this.nsB.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.nsS);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.setShouldDrawIndicatorLine(false);
            this.mTabHost.setShouldDrawTopLine(true);
        }
        this.mTabHost.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.d.14
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (d.this.mTabHost.getCurrentTabType() != 2) {
                    if (d.this.mTabHost.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                d.this.dRI();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.pL(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.iwg.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                if (d.this.mTabHost.getCurrentTabType() == 1 && !com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                d.this.lnE = d.this.mTabHost.getCurrentTabType();
                d.this.dRF();
                if (com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (d.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).dY("nobatch", "1"));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.nsL = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        bFP();
        this.nsJ = (ImageView) this.nsB.findViewById(R.id.home_page_new_write_icon);
        this.nsK = (TextView) this.nsB.findViewById(R.id.view_bottom_text);
        this.nsI = (TextView) this.nsB.findViewById(R.id.activity_prize_my_tip);
        this.mTabHost.setUIType(0);
        this.mTabHost.setTabContainerShadowShow(false);
        this.mTabHost.setBackGroundStyle(0);
        this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        dRE();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.nsB.getPageContext()));
        switchNaviBarStatus(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.nsB.registerListener(this.nsU);
        }
        this.nsB.registerListener(this.nsV);
        this.nsB.registerListener(this.nsT);
    }

    public void Ul(final String str) {
        if (StringUtils.isNull(str)) {
            this.nsI.setVisibility(8);
            return;
        }
        FragmentTabHost.b pM = this.mTabHost.pM(8);
        if (pM != null) {
            if (!this.nsN || (this.nsM != null && this.nsM.isShowing())) {
                if (this.nsW == null) {
                    this.nsW = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.15
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.Ul(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.nsW);
                TbadkCoreApplication.getInst().handler.postDelayed(this.nsW, 5000L);
                return;
            }
            a(str, pM);
            return;
        }
        this.nsI.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.eRD.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.nsB).widthPixels - (iArr[0] + (bVar.eRD.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nsI.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.nsB.getPageContext().getPageActivity(), R.dimen.ds26);
        this.nsI.setLayoutParams(layoutParams);
        this.nsI.setVisibility(0);
        this.nsI.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void dRC() {
        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.nsL);
    }

    public boolean dRD() {
        return this.nsG != null && this.nsG.getVisibility() == 0;
    }

    public void yp(boolean z) {
        if (this.nsG != null) {
            if (z) {
                this.nsG.setVisibility(0);
            } else {
                this.nsG.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.setShouldDrawTopLine(false);
        }
        if (this.mTabHost.getFragmentTabWidget() != null) {
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0207);
        }
        this.mTabHost.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(this.nsB.getPageContext(), i);
        ap.setNavbarTitleColor(this.nsF, R.color.CAM_X0105, R.color.s_navbar_title_color, i);
        ap.setImageResource(this.nsH, R.drawable.icon_news_down_bar_one);
        ap.setNavbarIconSrc(this.nsG, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        ap.setViewTextColor(this.nsK, R.color.CAM_X0106);
        SvgManager.btW().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.btW().a(this.iwg, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
                dRE();
                return;
            }
            this.mTabHost.showTabWidget();
        }
    }

    public void dRE() {
        if (this.nsJ != null) {
            this.nsJ.setVisibility(8);
        }
        if (this.nsK != null) {
            this.nsK.setVisibility(8);
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.nsB.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            ap.setViewTextColor(textView, R.color.CAM_X0105, 1);
            if (!StringUtils.isNull(payMemberInfoData.bBG())) {
                textView.setText(payMemberInfoData.bBG());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ap.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nsB.getPageContext().getPageActivity());
            aVar.bi(inflate);
            aVar.oR(R.color.CAM_X0305);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.nsB.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.nsB.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.nsB.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.nsB.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.nsB.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.nsB.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.nsB.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.jm(false);
            aVar.b(this.nsB.getPageContext()).brv();
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void dRF() {
        FragmentTabHost.b pM;
        if (this.mTabHost != null && (pM = this.mTabHost.pM(this.mTabHost.getCurrentTabType())) != null && pM.eRE != null && pM.eRE.getFragmentTabStructure() != null) {
            String string = this.nsB.getPageContext().getString(pM.eRE.getFragmentTabStructure().textResId);
            if (this.nsF != null) {
                this.nsF.setText(string);
            }
        }
    }

    public void bFP() {
        this.mNavigationBar = (NavigationBar) this.nsB.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.nsF = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.nsB.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.nsF.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.nsG = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.nsH = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.nsG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.ys(false);
                    d.this.nsH.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.nsB.getPageContext()));
                    TiebaStatic.eventStat(d.this.nsB.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.nsB.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.nsB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.nsB.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new ar(CommonStatisticKey.SEARCH_BAR_CLICK).al("obj_type", i));
                }
            });
            this.iwg = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.iwg.setLayoutParams(layoutParams2);
            this.iwg.setVisibility(8);
            this.iwg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.nsB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.nsB.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.nsB.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bh.skipToLoginActivity(d.this.nsB.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.nsB.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.lnE) {
                        case 1:
                            str = "forum";
                            break;
                        case 2:
                            str = "kantie";
                            break;
                        case 3:
                            str = "message";
                            break;
                        case 8:
                            str = ConstantData.VideoLocationType.PERSON_PROFILE;
                            break;
                    }
                    TiebaStatic.log(new ar("c10517").dY("obj_source", str));
                    bh.skipToRegisterActivity(d.this.nsB.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void yq(boolean z) {
        if (z) {
            this.iwg.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.iwg.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void yr(boolean z) {
        if (dRD()) {
            if (z) {
                if (this.nsH.getVisibility() != 0) {
                    this.nsH.setVisibility(0);
                    ys(true);
                    ap.setImageResource(this.nsH, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            ys(false);
            this.nsH.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ys(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nsG.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.nsB.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.nsB.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.nsG.setLayoutParams(layoutParams);
        }
    }

    public void aX(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.nsB.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.mTabHost.initViewPager(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.initViewPager(1);
        } else {
            this.mTabHost.initViewPager(0);
        }
        this.mTabHost.setViewPagerScrollable(false);
    }

    public void tS(boolean z) {
        this.lnI = z;
        if (!this.lnI) {
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean djs() {
        return this.lnI;
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            boolean z = false;
            bVar2.mContentFragment = cVar.frag;
            bVar2.mType = cVar.type;
            maintabBottomIndicator.setShowIconType(cVar.showIconType);
            if (cVar.showIconType == com.baidu.tbadk.mainTab.c.SHOWICON) {
                maintabBottomIndicator.setWriteIconView();
                this.nsR = true;
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.fzS) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.nsO = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (!au.isEmpty(cVar.fzR)) {
                maintabBottomIndicator.setImageIconUrl(cVar.fzR, cVar.text);
            }
            if (bVar2.mType == 2) {
                this.nsP = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.eRD = maintabBottomIndicator;
            bVar2.eRE = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost cEf() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator dRG() {
        return this.nsO;
    }

    public MaintabBottomIndicator dRH() {
        return this.nsP;
    }

    public void dRI() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void dRJ() {
        this.mHandler.removeCallbacks(this.jyF);
        this.mHandler.removeCallbacks(this.jyG);
        g.dismissPopupWindow(this.nsM);
    }

    public void Um(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.nsB.getActivity());
        aVar.Bq(str);
        aVar.a(R.string.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ar arVar = new ar("c12137");
                arVar.dY("obj_locate", "1");
                TiebaStatic.log(arVar);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ar arVar = new ar("c12137");
                arVar.dY("obj_locate", "2");
                TiebaStatic.log(arVar);
                aVar2.dismiss();
                com.baidu.tieba.k.a.cMZ();
            }
        });
        aVar.b(this.nsB.getPageContext()).brv();
    }

    public void onDestroy() {
        dRC();
        if (cEf() != null) {
            cEf().reset();
        }
        dRJ();
        if (this.jrd != null) {
            this.jrd.onDestroy();
        }
        if (this.iVY != null) {
            this.iVY.cFh();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || au.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.nsB).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.jrd == null) {
            this.jrd = new h(this.nsB.getPageContext(), (NavigationBarCoverTip) this.nsB.findViewById(R.id.navigation_cover_tip));
        }
        this.jrd.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.iVY == null) {
                this.iVY = new com.baidu.tieba.video.f(this.nsB, this.nsB.getActivityRootView());
            }
            this.iVY.j(postWriteCallBackData);
        }
    }

    public void dRK() {
        this.isInterrupt = false;
        this.nsQ = 1;
        if (dRH() != null) {
            dRH().fAd = this.nsQ;
        }
    }
}
