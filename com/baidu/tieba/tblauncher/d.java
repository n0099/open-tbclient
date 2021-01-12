package com.baidu.tieba.tblauncher;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.c.h;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private ImageView iDM;
    private com.baidu.tieba.video.e jdD;
    private boolean lot;
    private NavigationBar mNavigationBar;
    private ImageView mSearchButton;
    private FragmentTabHost mTabHost;
    private h mrm;
    private MainTabActivity ntT;
    private TextView ntX;
    private ImageView ntY;
    private ImageView ntZ;
    private TextView nua;
    private ImageView nub;
    private TextView nuc;
    private PopupWindow nue;
    private MaintabBottomIndicator nug;
    private MaintabBottomIndicator nuh;
    private Runnable nup;
    private boolean nud = false;
    private int lop = -1;
    private boolean nuf = false;
    private Handler mHandler = new Handler();
    private int lastIndex = 0;
    private boolean fFb = true;
    private int nui = 1;
    private boolean isInterrupt = false;
    private boolean nuj = false;
    private FragmentTabHost.a nuk = new FragmentTabHost.a() { // from class: com.baidu.tieba.tblauncher.d.1
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b oo = d.this.mTabHost.oo(i);
            if (oo.mType == 8) {
                if (d.this.nug != null && d.this.nug.getAnimationView() != null && d.this.nug.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new aq("c10605").an("obj_type", 1));
                } else {
                    TiebaStatic.log(new aq("c10605").an("obj_type", 0));
                }
                if (d.this.nug != null) {
                    d.this.nug.bCF();
                }
                TiebaStatic.log("c13841");
            } else if (oo.mType == 3) {
                TiebaStatic.log(new aq(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).an("obj_locate", 1));
                TiebaStatic.log(new aq(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).an("obj_locate", 1));
            }
            if (oo.mType == 2) {
                if (d.this.fFb) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, true);
                }
                d.this.fFb = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.nui != 2 || d.this.lastIndex == i || homeBarShowType != 1) {
                    if (d.this.nui == 1) {
                        d.this.nuh.lb(d.this.fFb);
                    }
                } else {
                    d.this.nuh.bCJ();
                }
                d.this.isInterrupt = false;
            } else {
                d.this.isInterrupt = true;
                if (d.this.fFb) {
                    d.this.nuh.lb(d.this.fFb);
                }
                d.this.fFb = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.dOb() != null) {
                d.this.dOb().fFb = d.this.fFb;
            }
            JF(d.this.lastIndex);
            JG(d.this.lastIndex);
            d.this.lastIndex = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, Integer.valueOf(i)));
        }

        private void JF(int i) {
            FragmentTabHost.b oo = d.this.mTabHost.oo(i);
            if (oo.mType == 8) {
                com.baidu.tbadk.pageExtra.d.CY(PageStayDurationConstants.PageName.PERSON);
            } else if (oo.mType == 2) {
                com.baidu.tbadk.pageExtra.d.CY(PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            } else if (oo.mType == 3) {
                com.baidu.tbadk.pageExtra.d.CY("a079");
            } else if (oo.mType == 1) {
                com.baidu.tbadk.pageExtra.d.CY(PageStayDurationConstants.PageName.ENTER_FORUM);
            } else if (oo.mType == 21) {
                com.baidu.tbadk.pageExtra.d.CY("a075");
            }
        }

        private void JG(int i) {
            String bDu;
            if (d.this.mTabHost.oo(i).mType == 2) {
                bDu = com.baidu.tbadk.pageExtra.d.fq(d.this.ntT.getPageContext().getContext());
            } else {
                bDu = com.baidu.tbadk.pageExtra.d.bDu();
            }
            final CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921520, bDu);
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.d.1.1
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
            FragmentTabHost.b oo = d.this.mTabHost.oo(i);
            if (oo.mType == 9) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new k(0)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else if (oo.mType == 8 && !bg.checkUpIsLogin(d.this.ntT.getActivity())) {
                if (d.this.nug != null) {
                    d.this.nug.bCF();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WRITE_THREAD_CLICK, Integer.valueOf(i)));
                return false;
            } else {
                if (oo.mType == 15) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        be.bsB().a(d.this.ntT.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                } else if (oo.mType == 3 && !bg.checkUpIsLogin(d.this.ntT.getActivity())) {
                    return false;
                } else {
                    if (oo.mType == 1) {
                        TiebaStatic.log(new aq("c13001"));
                    }
                }
                return true;
            }
        }
    };
    private CustomMessageListener nul = new CustomMessageListener(2921492) { // from class: com.baidu.tieba.tblauncher.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.mainTab.c cVar;
            if (customResponsedMessage != null && d.this.mTabHost != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.c) && (cVar = (com.baidu.tbadk.mainTab.c) customResponsedMessage.getData()) != null && d.this.mTabHost.op(cVar.type) != null && d.this.mTabHost.getCurrentTabType() != 21) {
                FragmentTabHost.b op = d.this.mTabHost.op(cVar.type);
                if (op.eWU instanceof MaintabBottomIndicator) {
                    ((MaintabBottomIndicator) op.eWU).setImageIconUrl(cVar.fEQ, cVar.text);
                }
            }
        }
    };
    private CustomMessageListener nun = new CustomMessageListener(2921382) { // from class: com.baidu.tieba.tblauncher.d.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.dOb() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 4) {
                        d.this.isInterrupt = true;
                        d.this.fFb = true;
                        if (d.this.nui != 2) {
                            if (d.this.nuh.isAnimating()) {
                                d.this.nuh.lb(d.this.fFb);
                                return;
                            }
                            return;
                        }
                        d.this.dOb().bCL();
                        return;
                    }
                    if (intValue == 6) {
                        d.this.isInterrupt = false;
                        if (d.this.nui == 1) {
                            return;
                        }
                    } else {
                        d.this.nui = intValue;
                    }
                    if (d.this.nui == 1) {
                        d.this.dOb().lb(d.this.fFb);
                    } else if (d.this.nui == 2) {
                        d.this.dOb().bCJ();
                    } else if (intValue == 5) {
                        d.this.nui = 1;
                        d.this.fFb = true;
                        if (!d.this.isInterrupt) {
                            d.this.dOb().bCL();
                        }
                    } else {
                        d.this.dOb().bCK();
                    }
                    d.this.dOb().fFa = true;
                    d.this.dOb().fFc = d.this.nui;
                    d.this.dOb().fFb = d.this.fFb;
                }
            }
        }
    };
    private CustomMessageListener nuo = new CustomMessageListener(2921410) { // from class: com.baidu.tieba.tblauncher.d.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.fFb = true;
            if (d.this.dOb() != null) {
                d.this.dOb().fFb = d.this.fFb;
            }
        }
    };
    private Runnable jGy = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.6
        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.mTabHost != null && d.this.nue != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                l.getEquipmentWidth(d.this.ntT.getActivity());
                int dimens = l.getDimens(d.this.ntT.getActivity(), R.dimen.ds178);
                View contentView = d.this.nue.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    FragmentTabHost.b op = d.this.mTabHost.op(3);
                    if (op != null && (tbFragmentTabIndicator = op.eWU) != null) {
                        int[] iArr = new int[2];
                        tbFragmentTabIndicator.getLocationInWindow(iArr);
                        int measuredWidth2 = ((tbFragmentTabIndicator.getMeasuredWidth() / 2) + iArr[0]) - (measuredWidth / 2);
                        if (measuredWidth2 <= 0) {
                            measuredWidth2 = l.getDimens(d.this.ntT.getActivity(), R.dimen.tbds570);
                        }
                        g.showPopupWindowAsDropDown(d.this.nue, fragmentTabWidget, measuredWidth2, -dimens);
                        com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.SHOW_MAINTAB_MESSAGE_TIPS, true);
                        d.this.nuf = true;
                        d.this.mHandler.postDelayed(d.this.jGz, 5000L);
                    }
                }
            }
        }
    };
    private Runnable jGz = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.7
        @Override // java.lang.Runnable
        public void run() {
            d.this.dOd();
        }
    };
    private View.OnClickListener jGA = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dOd();
        }
    };

    public void setCurrentTabByType(int i) {
        cDj().setCurrentTabByType(i);
        if (i != 2) {
            this.isInterrupt = true;
            if (this.fFb) {
                this.nuh.lb(false);
            }
            this.fFb = false;
            if (dOb() != null) {
                dOb().fFb = this.fFb;
            }
        }
    }

    public d(MainTabActivity mainTabActivity) {
        this.ntT = mainTabActivity;
    }

    public void yp(boolean z) {
        this.mTabHost = (FragmentTabHost) this.ntT.findViewById(R.id.tab_host);
        this.mTabHost.setup(this.ntT.getSupportFragmentManager());
        this.mTabHost.setAbsoluteWeight(true);
        this.mTabHost.setOnTabSelectionListener(this.nuk);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.mTabHost.setShouldDrawIndicatorLine(false);
            this.mTabHost.setShouldDrawTopLine(true);
        }
        this.mTabHost.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.tblauncher.d.14
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (d.this.mTabHost.getCurrentTabType() != 2) {
                    if (d.this.mTabHost.getCurrentTabType() == 15) {
                        TiebaStatic.log("c12124");
                    }
                } else {
                    TiebaStatic.log("kantie_entry");
                }
                d.this.dOc();
                if (d.this.mTabHost.getCurrentTabType() != d.this.mTabHost.oo(i).mType) {
                    d.this.mTabHost.setCurrentTab(i);
                }
                if (d.this.mTabHost.getCurrentTabType() != 1) {
                    d.this.iDM.setVisibility(8);
                    d.this.mSearchButton.setVisibility(0);
                }
                if (d.this.mTabHost.getCurrentTabType() == 1 && !com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                d.this.lop = d.this.mTabHost.getCurrentTabType();
                d.this.dNZ();
                if (com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false)) {
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() == 2) {
                            TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    }
                }
                if (d.this.mTabHost.getCurrentTabType() == 3) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).dW("nobatch", "1"));
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.nud = com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, false);
        bEt();
        this.nub = (ImageView) this.ntT.findViewById(R.id.home_page_new_write_icon);
        this.nuc = (TextView) this.ntT.findViewById(R.id.view_bottom_text);
        this.nua = (TextView) this.ntT.findViewById(R.id.activity_prize_my_tip);
        this.mTabHost.setUIType(0);
        this.mTabHost.setTabContainerShadowShow(false);
        this.mTabHost.setBackGroundStyle(0);
        this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        dNY();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_FLOATING_LAYER_MAINTAB, this.ntT.getPageContext()));
        switchNaviBarStatus(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.ntT.registerListener(this.nun);
        }
        this.ntT.registerListener(this.nuo);
        this.ntT.registerListener(this.nul);
    }

    public void SP(final String str) {
        if (StringUtils.isNull(str)) {
            this.nua.setVisibility(8);
            return;
        }
        FragmentTabHost.b op = this.mTabHost.op(8);
        if (op != null) {
            if (!this.nuf || (this.nue != null && this.nue.isShowing())) {
                if (this.nup == null) {
                    this.nup = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.15
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.SP(str);
                        }
                    };
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.nup);
                TbadkCoreApplication.getInst().handler.postDelayed(this.nup, 5000L);
                return;
            }
            a(str, op);
            return;
        }
        this.nua.setVisibility(8);
    }

    private void a(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.eWU.getLocationInWindow(iArr);
        int width = l.getScreenSize(this.ntT).widthPixels - (iArr[0] + (bVar.eWU.getWidth() / 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nua.getLayoutParams();
        layoutParams.rightMargin = width - l.getDimens(this.ntT.getPageContext().getPageActivity(), R.dimen.ds26);
        this.nua.setLayoutParams(layoutParams);
        this.nua.setVisibility(0);
        this.nua.setText(str);
    }

    public void switchNaviBarStatus(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.switchNaviBarStatus(z);
        }
    }

    public void dNW() {
        com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.HAS_SHOW_MESSAGE_TAB_TIPS, this.nud);
    }

    public boolean dNX() {
        return this.ntY != null && this.ntY.getVisibility() == 0;
    }

    public void yq(boolean z) {
        if (this.ntY != null) {
            if (z) {
                this.ntY.setVisibility(0);
            } else {
                this.ntY.setVisibility(8);
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
        this.mNavigationBar.onChangeSkinType(this.ntT.getPageContext(), i);
        ao.setNavbarTitleColor(this.ntX, R.color.CAM_X0105, R.color.s_navbar_title_color, i);
        ao.setImageResource(this.ntZ, R.drawable.icon_news_down_bar_one);
        ao.setNavbarIconSrc(this.ntY, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        ao.setViewTextColor(this.nuc, R.color.CAM_X0106);
        SvgManager.bsx().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bsx().a(this.iDM, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.mTabHost != null) {
            if (z) {
                this.mTabHost.hideTabWidget();
                dNY();
                return;
            }
            this.mTabHost.showTabWidget();
        }
    }

    public void dNY() {
        if (this.nub != null) {
            this.nub.setVisibility(8);
        }
        if (this.nuc != null) {
            this.nuc.setVisibility(8);
        }
    }

    public void a(PayMemberInfoData payMemberInfoData, final int i) {
        if (payMemberInfoData != null) {
            View inflate = LayoutInflater.from(this.ntT.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            ao.setViewTextColor(textView, R.color.CAM_X0105, 1);
            if (!StringUtils.isNull(payMemberInfoData.bAi())) {
                textView.setText(payMemberInfoData.bAi());
            }
            if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
                tbImageView.startLoad(payMemberInfoData.getUrl(), 21, false);
                tbImageView.setIsNight(z);
            } else {
                ao.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
            }
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ntT.getPageContext().getPageActivity());
            aVar.br(inflate);
            aVar.nv(R.color.CAM_X0305);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.tblauncher.d.16
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    if (i == 0) {
                        TiebaStatic.eventStat(d.this.ntT.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        TiebaStatic.eventStat(d.this.ntT.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
                    }
                }
            });
            String string = this.ntT.getPageContext().getString(R.string.member_continue_pay);
            if (i == 0) {
                string = this.ntT.getPageContext().getString(R.string.open_member);
            }
            aVar.a(string, new a.b() { // from class: com.baidu.tieba.tblauncher.d.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    String str = null;
                    if (i == 0) {
                        str = "4006001000";
                        TiebaStatic.eventStat(d.this.ntT.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
                    } else if (i == 1) {
                        str = "4005001000";
                        TiebaStatic.eventStat(d.this.ntT.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.ntT.getPageContext().getPageActivity(), 2);
                    if (!StringUtils.isNULL(str)) {
                        memberPayActivityConfig.setSceneId(str);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.jE(false);
            aVar.b(this.ntT.getPageContext()).bqe();
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, false);
        }
    }

    public void dNZ() {
        FragmentTabHost.b op;
        if (this.mTabHost != null && (op = this.mTabHost.op(this.mTabHost.getCurrentTabType())) != null && op.eWV != null && op.eWV.getFragmentTabStructure() != null) {
            String string = this.ntT.getPageContext().getString(op.eWV.getFragmentTabStructure().textResId);
            if (this.ntX != null) {
                this.ntX.setText(string);
            }
        }
    }

    public void bEt() {
        this.mNavigationBar = (NavigationBar) this.ntT.findViewById(R.id.view_navigation_bar);
        if (this.mNavigationBar != null) {
            this.ntX = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.ntT.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.ntX.setLayoutParams(layoutParams);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.ntY = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.ntZ = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.ntY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.yt(false);
                    d.this.ntZ.setVisibility(8);
                    com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, d.this.ntT.getPageContext()));
                    TiebaStatic.eventStat(d.this.ntT.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.getDimens(this.ntT.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.mSearchButton.setLayoutParams(layoutParams2);
            this.mSearchButton.setVisibility(8);
            this.mSearchButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 3;
                    d.this.ntT.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(d.this.ntT.getPageContext().getPageActivity())));
                    if (d.this.mTabHost.getCurrentTabType() != 3) {
                        if (d.this.mTabHost.getCurrentTabType() != 2) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                    TiebaStatic.log(new aq(CommonStatisticKey.SEARCH_BAR_CLICK).an("obj_type", i));
                }
            });
            this.iDM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.iDM.setLayoutParams(layoutParams2);
            this.iDM.setVisibility(8);
            this.iDM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                        d.this.ntT.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(d.this.ntT.getPageContext().getPageActivity())));
                        TiebaStatic.log("c10085");
                    }
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.ntT.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bg.skipToLoginActivity(d.this.ntT.getPageContext().getPageActivity());
                }
            });
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.ntT.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    String str = "";
                    switch (d.this.lop) {
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
                    TiebaStatic.log(new aq("c10517").dW("obj_source", str));
                    bg.skipToRegisterActivity(d.this.ntT.getPageContext().getPageActivity());
                }
            });
        }
    }

    public void yr(boolean z) {
        if (z) {
            this.iDM.setVisibility(0);
            this.mSearchButton.setVisibility(8);
            return;
        }
        this.iDM.setVisibility(8);
        this.mSearchButton.setVisibility(0);
    }

    public void ys(boolean z) {
        if (dNX()) {
            if (z) {
                if (this.ntZ.getVisibility() != 0) {
                    this.ntZ.setVisibility(0);
                    yt(true);
                    ao.setImageResource(this.ntZ, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            yt(false);
            this.ntZ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yt(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ntY.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = l.getDimens(this.ntT.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = l.getDimens(this.ntT.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.ntY.setLayoutParams(layoutParams);
        }
    }

    public void aS(ArrayList<com.baidu.tbadk.mainTab.b> arrayList) {
        this.mTabHost.reset();
        Iterator<com.baidu.tbadk.mainTab.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null && next.isAvailable()) {
                a(next, next.getFragmentTabStructure(), next.getTabIndicator(this.ntT.getPageContext().getPageActivity()));
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

    public void tP(boolean z) {
        this.lot = z;
        if (!this.lot) {
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.ENTER_FORUM_EDIT_MODE, false);
        }
    }

    public boolean dfo() {
        return this.lot;
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
                this.nuj = true;
                z = true;
            } else if (cVar.showIconType == com.baidu.tbadk.mainTab.c.fER) {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
                this.nug = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(cVar.textResId);
                maintabBottomIndicator.setAnimationResId(cVar.animationResId);
            }
            if (!at.isEmpty(cVar.fEQ)) {
                maintabBottomIndicator.setImageIconUrl(cVar.fEQ, cVar.text);
            }
            if (bVar2.mType == 2) {
                this.nuh = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            bVar2.eWU = maintabBottomIndicator;
            bVar2.eWV = bVar;
            this.mTabHost.a(bVar2, -1, z);
        }
    }

    public FragmentTabHost cDj() {
        return this.mTabHost;
    }

    public MaintabBottomIndicator dOa() {
        return this.nug;
    }

    public MaintabBottomIndicator dOb() {
        return this.nuh;
    }

    public void dOc() {
        if (this.mTabHost != null) {
            if (this.mTabHost.getCurrentTabType() == 8 || this.mTabHost.getCurrentTabType() == 3 || this.mTabHost.getCurrentTabType() == 2 || this.mTabHost.getCurrentTabType() == 15 || this.mTabHost.getCurrentTabType() == 1) {
                if (this.mNavigationBar != null) {
                    this.mNavigationBar.setVisibility(8);
                }
                this.mSearchButton.setVisibility(8);
            }
        }
    }

    public void dOd() {
        this.mHandler.removeCallbacks(this.jGy);
        this.mHandler.removeCallbacks(this.jGz);
        g.dismissPopupWindow(this.nue);
    }

    public void SQ(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ntT.getActivity());
        aVar.Ad(str);
        aVar.a(R.string.close, new a.b() { // from class: com.baidu.tieba.tblauncher.d.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aq aqVar = new aq("c12137");
                aqVar.dW("obj_locate", "1");
                TiebaStatic.log(aqVar);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.check, new a.b() { // from class: com.baidu.tieba.tblauncher.d.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aq aqVar = new aq("c12137");
                aqVar.dW("obj_locate", "2");
                TiebaStatic.log(aqVar);
                aVar2.dismiss();
                com.baidu.tieba.k.a.cMv();
            }
        });
        aVar.b(this.ntT.getPageContext()).bqe();
    }

    public void onDestroy() {
        dNW();
        if (cDj() != null) {
            cDj().reset();
        }
        dOd();
        if (this.mrm != null) {
            this.mrm.onDestroy();
        }
        if (this.jdD != null) {
            this.jdD.cEk();
        }
    }

    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.ntT).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.mrm == null) {
            this.mrm = new h(this.ntT.getPageContext(), (NavigationBarCoverTip) this.ntT.findViewById(R.id.navigation_cover_tip));
        }
        this.mrm.b(postWriteCallBackData);
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 1) {
            if (this.jdD == null) {
                this.jdD = new com.baidu.tieba.video.e(this.ntT, this.ntT.getActivityRootView());
            }
            this.jdD.l(postWriteCallBackData);
        }
    }

    public void dOe() {
        this.isInterrupt = false;
        this.nui = 1;
        if (dOb() != null) {
            dOb().fFc = this.nui;
        }
    }
}
