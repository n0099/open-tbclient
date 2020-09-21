package com.baidu.tieba.personPolymeric.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.p.b;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterMainTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class p {
    public static int iCc = 5000;
    private static final float lzH = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout XP;
    private BdUniqueId aih;
    private BaseFragment eTV;
    private TbPageContext ehG;
    private CustomViewPager ekP;
    private ValueAnimator euO;
    private NoNetworkView fHl;
    private NewPagerSlidingTabBaseStrip hCX;
    private PluginErrorTipView hCk;
    private boolean lAa;
    private com.baidu.tieba.personPolymeric.c.a luI;
    private LinearLayout luk;
    protected FrameLayout lul;
    protected RelativeLayout lun;
    private com.baidu.tieba.personPolymeric.b.f lut;
    private com.baidu.tieba.model.a lzE;
    private CustomMessageListener lzF;
    private CustomMessageListener lzG;
    private PullRefreshFrameLayout lzK;
    private com.baidu.tieba.personPolymeric.header.a lzL;
    private FrameLayout lzM;
    private View lzN;
    private a lzO;
    private int lzP;
    private int lzQ;
    private GradientDrawable lzR;
    private FrameLayout lzS;
    private FrameLayout.LayoutParams lzT;
    private AlphaAnimation lzU;
    private AlphaAnimation lzV;
    private com.baidu.tieba.personPolymeric.header.c lzW;
    private k lzX;
    private int lzZ;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private CustomMessageListener mUpdatePendantListener;
    private long mUserId;
    private float[] lzI = {lzH, lzH, lzH, lzH, 0.0f, 0.0f, 0.0f, 0.0f};
    private float lzJ = 674.0f;
    private boolean iCg = false;
    private int lzY = -1;
    private Runnable iCq = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.6
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.iCg) {
                p.this.cxc();
            }
        }
    };
    private com.baidu.tieba.personPolymeric.b.a lwL = new com.baidu.tieba.personPolymeric.b.a() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.tieba.personPolymeric.b.a
        public void Be(int i) {
            p.this.lzT.height = -2;
            p.this.lzS.setLayoutParams(p.this.lzT);
        }

        @Override // com.baidu.tieba.personPolymeric.b.a
        public void gs(boolean z) {
            p.this.lAa = z;
            if (!z) {
                p.this.lzL.FU(p.this.lzZ);
            }
            if (p.this.lzW != null && p.this.lzW.dmM() != null) {
                p.this.lzW.dmM().setOpen(z);
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.g gVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.eTV = baseFragment;
        this.ehG = baseFragment.getPageContext();
        this.aih = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.lut = gVar.dlX();
        am(gVar.mRootView);
    }

    private void am(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.lzK = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.lzL = new com.baidu.tieba.personPolymeric.header.a(this.ehG, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.lzX = new k(this.ehG, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.lzS = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.lzT = (FrameLayout.LayoutParams) this.lzS.getLayoutParams();
        this.lzK.setOnTouchCallback(new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void t(double d) {
                p.this.lzT.height = (int) ((p.this.lAa ? com.baidu.tieba.personPolymeric.header.b.lwG : 0) + p.this.lzP + (PullRefreshFrameLayout.euu * d));
                p.this.lzS.setLayoutParams(p.this.lzT);
                if (p.this.lzL != null) {
                    p.this.lzL.z(d);
                }
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                p.this.euO = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.euO.setDuration(150L);
                final int measuredHeight = p.this.lzS.getMeasuredHeight();
                final int cpW = p.this.lzL.cpW();
                p.this.euO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.lzT.height = (int) (measuredHeight - (i * animatedFraction));
                        p.this.lzS.setLayoutParams(p.this.lzT);
                        if (p.this.lzL != null) {
                            p.this.lzL.FV((int) (cpW - (animatedFraction * i)));
                        }
                    }
                });
                p.this.euO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.lzQ = p.this.lzT.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.euO.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void blz() {
                final int measuredHeight = p.this.lzS.getMeasuredHeight();
                final int i = (measuredHeight - p.this.lzP) - (p.this.lAa ? com.baidu.tieba.personPolymeric.header.b.lwG : 0);
                final int cpW = p.this.lzL != null ? p.this.lzL.cpW() : 0;
                if (p.this.lAa) {
                    p.this.lzW.uT(false);
                    p.this.lzW.dmp();
                }
                if (i > 0 || (i == 0 && p.this.lAa)) {
                    p.this.euO = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.euO.setDuration(300L);
                    p.this.euO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.lzT.height = (int) (measuredHeight - (i * floatValue));
                            p.this.lzS.setLayoutParams(p.this.lzT);
                            if (p.this.lzL != null && cpW > 0) {
                                p.this.lzL.FV((int) (cpW - (floatValue * i)));
                            }
                        }
                    });
                    p.this.euO.start();
                    p.this.euO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (p.this.lAa) {
                                p.this.lzW.dmq();
                            }
                            p.this.lzQ = 0;
                            p.this.lzT.height = -2;
                            p.this.lzS.setLayoutParams(p.this.lzT);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                }
            }
        });
        this.lzK.setOnPullRefreshListener(new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.personPolymeric.view.p.8
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bly() {
                com.baidu.adp.lib.f.e.mX().postDelayed(p.this.iCq, p.iCc);
                p.this.iCg = true;
                p.this.lzY = p.this.lzO.getCurrentTabType();
                p.this.dlO();
                p.this.lzO.bIh();
            }
        });
        this.lzK.setOnCancelCallBack(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void onCancel() {
                p.this.lzQ = 0;
                p.this.lzT.height = -2;
                p.this.lzS.setLayoutParams(p.this.lzT);
            }
        });
        this.lzK.setOnLoadingStartCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.10
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void blx() {
                p.this.lzT.height = -2;
                p.this.lzS.setLayoutParams(p.this.lzT);
            }
        });
        this.XP = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.XP.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.11
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.ehG.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.ehG.getPageActivity());
                }
                p.this.lzK.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.lzX.uZ(abs == 0);
                p.this.lzX.va(((float) abs) > p.this.lzJ / 2.0f);
                float abs2 = ((double) p.this.lzJ) == 0.0d ? 0.0f : Math.abs(abs / p.this.lzJ);
                p.this.lzX.aA(abs2);
                if (abs2 >= 1.0f) {
                    p.this.lzI = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.lzR.setCornerRadii(p.this.lzI);
                    p.this.lzM.setBackgroundDrawable(p.this.lzR);
                    p.this.bHC();
                } else {
                    p.this.lzI = new float[]{p.lzH, p.lzH, p.lzH, p.lzH, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.lzR.setCornerRadii(p.this.lzI);
                    p.this.lzM.setBackgroundDrawable(p.this.lzR);
                    p.this.dmZ();
                }
                int i2 = p.this.lzQ - p.this.lzP;
                if (p.this.lzQ > 0 && Math.abs(i) >= i2) {
                    p.this.lzK.dismissLoading();
                }
            }
        });
        this.lzM = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.hCX = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.hCX.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.hCX.setRectPaintColor(R.color.cp_link_tip_a);
        this.hCX.a(com.baidu.adp.lib.util.l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds46), true);
        this.hCX.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds64));
        this.hCX.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds8));
        this.hCX.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds8));
        this.hCX.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds0));
        this.hCX.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds166), -1));
        this.hCX.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.12
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.lzO.FZ(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.lzR = new GradientDrawable();
        this.lzR.setColor(ap.getColor(R.color.cp_bg_line_d));
        this.lzR.setCornerRadii(this.lzI);
        this.lzM.setBackgroundDrawable(this.lzR);
        this.lzN = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        ap.setBackgroundResource(this.lzN, R.drawable.personalize_tab_shadow);
        this.ekP = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.lzO = new a(this.eTV.getActivity().getSupportFragmentManager());
        this.ekP.setAdapter(this.lzO);
        this.ekP.setOffscreenPageLimit(this.lzO.mFragments.size());
        this.lzO.notifyDataSetChanged();
        this.hCX.setViewPager(this.ekP);
        this.ekP.setCurrentItem(1);
        this.lzW = new com.baidu.tieba.personPolymeric.header.c(this.ehG, this.mIsHost);
        this.lzW.a(this.lwL);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.lzS.addView(this.lzW.getView(), layoutParams);
        if (this.lzX.dmX()) {
            E(this.ehG);
        }
        D(this.ehG);
        this.fHl = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.hCk = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.luk = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.lul = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.lun = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void D(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.lzX != null) {
                    p.this.lzX.dmV();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.aih);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c dmY() {
        return this.lzW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a extends FragmentPagerAdapter {
        private List<String> leV;
        private List<PersonCenterTabBaseFragment> mFragments;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.leV = new ArrayList();
            this.leV.add(p.this.ehG.getResources().getString(R.string.person_center_tab_main));
            this.leV.add(p.this.ehG.getResources().getString(R.string.person_center_tab_thread));
            this.leV.add(p.this.ehG.getResources().getString(R.string.person_center_tab_dynamic));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.n(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.o(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.m(p.this.mUserId, p.this.mIsHost));
        }

        public void FZ(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.leV.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
                if (i2 == i) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return Gb(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (this.mFragments != null) {
                return this.mFragments.size();
            }
            return 0;
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return Ga(i);
        }

        private String Ga(int i) {
            return this.leV.get(i);
        }

        public PersonCenterTabBaseFragment Gb(int i) {
            if (i < this.mFragments.size()) {
                return this.mFragments.get(i);
            }
            return null;
        }

        public void onChangeSkinType(int i) {
            if (this.mFragments != null && this.mFragments.size() > 0) {
                int size = this.mFragments.size();
                for (int i2 = 0; i2 < size; i2++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i2);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.onChangeSkinType(i);
                    }
                }
            }
        }

        public void bIh() {
            if (!y.isEmpty(this.mFragments)) {
                for (int i = 0; i < this.mFragments.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.uV(false);
                    }
                }
            }
        }

        public void g(com.baidu.tieba.personPolymeric.c.a aVar) {
            if (aVar != null && !y.isEmpty(this.mFragments)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.mFragments.size()) {
                        PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i2);
                        if (personCenterTabBaseFragment instanceof PersonCenterMainTabFragment) {
                            ((PersonCenterMainTabFragment) personCenterTabBaseFragment).d(aVar);
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }

        public void h(com.baidu.tieba.personPolymeric.c.a aVar) {
            if (aVar != null && aVar.getThreadUser() != null && !y.isEmpty(this.mFragments)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.mFragments.size()) {
                        PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i2);
                        if (personCenterTabBaseFragment != null) {
                            personCenterTabBaseFragment.a(aVar.eep);
                            personCenterTabBaseFragment.d(aVar.getThreadUser());
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }

        public int getCurrentTabType() {
            int i;
            if (y.isEmpty(this.mFragments)) {
                return -1;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.mFragments.size()) {
                    i = -1;
                    break;
                }
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i3);
                if (personCenterTabBaseFragment == null || !personCenterTabBaseFragment.isPrimary()) {
                    i2 = i3 + 1;
                } else {
                    i = personCenterTabBaseFragment.getTabType();
                    break;
                }
            }
            return i;
        }
    }

    private boolean bHB() {
        return this.lzN.getVisibility() == 0;
    }

    public void bHC() {
        if (!bHB() && this.lzU == null) {
            this.lzN.setVisibility(0);
            if (this.lzU == null) {
                this.lzU = new AlphaAnimation(0.0f, 1.0f);
                this.lzU.setFillAfter(true);
                this.lzU.setDuration(300L);
                this.lzU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.14
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.lzU.reset();
                        p.this.lzU = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.lzN.startAnimation(this.lzU);
            }
        }
    }

    public void dmZ() {
        if (bHB() && this.lzV == null && this.lzV == null) {
            this.lzV = new AlphaAnimation(1.0f, 0.0f);
            this.lzV.setFillAfter(true);
            this.lzV.setDuration(300L);
            this.lzV.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.15
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.lzN.setVisibility(8);
                    p.this.lzV.reset();
                    p.this.lzV = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.lzN.startAnimation(this.lzV);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lzX != null) {
            this.lzX.onChangeSkinType(i);
        }
        if (this.hCX != null) {
            this.hCX.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
            this.hCX.setRectPaintColor(R.color.cp_link_tip_a);
            this.hCX.onChangeSkinType();
        }
        if (this.lzR != null) {
            this.lzR.setColor(ap.getColor(R.color.cp_bg_line_d));
        }
        if (this.lzW != null) {
            this.lzW.onChangeSkinType(i);
        }
        if (this.lzO != null) {
            this.lzO.onChangeSkinType(i);
        }
        if (this.fHl != null) {
            this.fHl.onChangeSkinType(this.ehG, i);
        }
        if (this.hCk != null) {
            this.hCk.onChangeSkinType(this.ehG, i);
        }
        ap.setBackgroundResource(this.luk, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.lzN, R.drawable.personalize_tab_shadow);
    }

    public void dlO() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.lzE.resetData();
            this.lzE.refreshData();
            this.lut.doRefresh();
            return;
        }
        this.lut.cvO();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        if (this.lzX != null) {
            this.lzX.setOnViewResponseListener(fVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.luI = aVar;
            this.luk.setVisibility(8);
            this.lun.setVisibility(0);
            if (this.lzX != null) {
                this.lzX.a(aVar, personStatus);
            }
            if (this.lzW != null) {
                this.lzW.b(aVar);
            }
            if (this.lzL != null) {
                this.lzL.e(this.luI.getUserData());
            }
            this.lzS.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.2
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.lzP == 0) {
                        p.this.lzP = p.this.lzS.getMeasuredHeight();
                        p.this.lzJ = p.this.lzS.getMeasuredHeight() - p.this.lzX.dmW().getMeasuredHeight();
                        if (p.this.lzL != null) {
                            p.this.lzZ = p.this.mStatusBarHeight + p.this.lzX.dmW().getMeasuredHeight() + p.this.lzS.getMeasuredHeight() + p.this.hCX.getMeasuredHeight();
                            boolean z2 = (p.this.mIsHost || p.this.luI.getUserData() == null || p.this.luI.getUserData().getNewGodData() == null || !p.this.luI.getUserData().getNewGodData().isNewGod()) ? false : true;
                            p.this.lzT.height = p.this.lzZ;
                            p.this.lzS.setLayoutParams(p.this.lzT);
                            p.this.lzZ += z2 ? com.baidu.tieba.personPolymeric.header.b.lwG : 0;
                            p.this.lzL.FU(p.this.lzZ);
                            p.this.lzT.height = -2;
                            p.this.lzS.setLayoutParams(p.this.lzT);
                        }
                    }
                }
            });
            this.lzO.h(aVar);
            this.lzO.g(aVar);
            if (y.isEmpty(aVar.cDN())) {
                this.lut.bIk();
                com.baidu.adp.lib.util.l.showToast(this.ehG.getContext(), this.ehG.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.dsD().vG(this.mIsHost);
            int size = aVar.cDN().size();
            for (int i = 0; i < size; i++) {
                q qVar = aVar.cDN().get(i);
                if (qVar != null && (qVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.lut.bIk();
                    return;
                }
            }
            if (!z) {
                this.lut.h(true, aVar.cDN());
            }
        }
    }

    public void cvO() {
        this.lut.cvO();
    }

    private void E(TbPageContext tbPageContext) {
        this.lzF = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).lUQ;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.lzW != null && aVar != null) {
                            p.this.lzW.uS(aVar.cJF);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.luI != null) {
                            if (p.this.luI.lvx != null && p.this.luI.lvx.hLw != null && aVar2 != null) {
                                p.this.luI.lvx.hLw.putBoolean("person_center_item_red_tip_show", aVar2.cJF);
                            }
                            if (aVar3 != null && p.this.luI.lvw != null && p.this.luI.lvw.hLw != null) {
                                p.this.luI.lvw.hLw.putBoolean("person_center_item_red_tip_show", aVar3.cJF);
                            }
                            if (aVar4 != null && p.this.luI.lvv != null && p.this.luI.lvv.hLw != null) {
                                p.this.luI.lvv.hLw.putBoolean("person_center_item_red_tip_show", aVar4.cJF);
                            }
                            if (aVar5 != null && p.this.luI.lvy != null && p.this.luI.lvy.hLw != null) {
                                p.this.luI.lvy.hLw.putBoolean("person_center_item_red_tip_show", aVar5.cJF);
                            }
                            if (aVar6 != null && p.this.luI.lvz != null && p.this.luI.lvz.hLw != null) {
                                p.this.luI.lvz.hLw.putBoolean("person_center_item_red_tip_show", aVar6.cJF);
                                p.this.luI.lvz.hLw.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.lzF.setTag(this.aih);
        tbPageContext.registerListener(this.lzF);
        this.mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.m mVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && (mVar = (com.baidu.tbadk.data.m) customResponsedMessage.getData()) != null) {
                    p.this.lzW.Pc(mVar.bdu());
                }
            }
        };
        this.mUpdatePendantListener.setTag(this.aih);
        tbPageContext.registerListener(this.mUpdatePendantListener);
        this.lzG = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.lzY == ((Integer) customResponsedMessage.getData()).intValue() && p.this.iCg) {
                    com.baidu.adp.lib.f.e.mX().removeCallbacks(p.this.iCq);
                    p.this.cxc();
                }
            }
        };
        this.lzG.setTag(this.aih);
        tbPageContext.registerListener(this.lzG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxc() {
        this.lzY = -1;
        this.iCg = false;
        if (this.lzK != null) {
            this.lzK.blv();
        }
    }

    public void onDestory() {
        if (this.lzW != null) {
            this.lzW.onDestroy();
        }
        if (this.lzK != null) {
            this.lzK.onDestroy();
        }
        if (this.euO != null) {
            this.euO.cancel();
            this.euO.removeAllListeners();
            this.euO.removeAllUpdateListeners();
            this.euO = null;
        }
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iCq);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.lzE = aVar;
    }
}
