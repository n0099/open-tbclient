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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes18.dex */
public class p {
    public static int igw = 5000;
    private static final float lao = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout WP;
    private BdUniqueId agB;
    private TbPageContext dVN;
    private CustomViewPager dYQ;
    private BaseFragment eGu;
    private ValueAnimator eiM;
    private NoNetworkView fsB;
    private PluginErrorTipView hhZ;
    private NewPagerSlidingTabBaseStrip hiP;
    private com.baidu.tieba.personPolymeric.c.a kVJ;
    private LinearLayout kVl;
    protected FrameLayout kVm;
    protected RelativeLayout kVo;
    private com.baidu.tieba.personPolymeric.b.e kVu;
    private FrameLayout laA;
    private FrameLayout.LayoutParams laB;
    private AlphaAnimation laC;
    private AlphaAnimation laD;
    private com.baidu.tieba.personPolymeric.header.c laE;
    private k laF;
    private com.baidu.tieba.model.a lal;
    private CustomMessageListener lam;
    private CustomMessageListener lan;
    private PullRefreshFrameLayout lar;
    private com.baidu.tieba.personPolymeric.header.a las;
    private FrameLayout lau;
    private View lav;
    private a law;
    private int lax;
    private int lay;
    private GradientDrawable laz;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private CustomMessageListener mUpdatePendantListener;
    private long mUserId;
    private float[] lap = {lao, lao, lao, lao, 0.0f, 0.0f, 0.0f, 0.0f};
    private float laq = 674.0f;
    private boolean igA = false;
    private int laG = -1;
    private Runnable igK = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.igA) {
                p.this.cjf();
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.f fVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.eGu = baseFragment;
        this.dVN = baseFragment.getPageContext();
        this.agB = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.kVu = fVar.cXq();
        aj(fVar.mRootView);
    }

    private void aj(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.lar = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.las = new com.baidu.tieba.personPolymeric.header.a(this.dVN, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.laF = new k(this.dVN, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.laA = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.laB = (FrameLayout.LayoutParams) this.laA.getLayoutParams();
        this.lar.setOnTouchCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void n(double d) {
                p.this.laB.height = (int) (p.this.lax + (PullRefreshFrameLayout.eiu * d));
                p.this.laA.setLayoutParams(p.this.laB);
                if (p.this.las != null) {
                    p.this.las.t(d);
                }
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void c(final int i, double d) {
                p.this.eiM = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.eiM.setDuration(150L);
                final int i2 = p.this.laB.height;
                final int ccm = p.this.las.ccm();
                p.this.eiM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.laB.height = (int) (i2 - (i * animatedFraction));
                        p.this.laA.setLayoutParams(p.this.laB);
                        if (p.this.las != null) {
                            p.this.las.CZ((int) (ccm - (animatedFraction * i)));
                        }
                    }
                });
                p.this.eiM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.lay = p.this.laB.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.eiM.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void bch() {
                final int i = p.this.laB.height;
                final int i2 = p.this.laB.height - p.this.lax;
                final int i3 = 0;
                if (p.this.las != null) {
                    i3 = p.this.las.ccm();
                }
                if (i2 > 0) {
                    p.this.eiM = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.eiM.setDuration(300L);
                    p.this.eiM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.laB.height = (int) (i - (i2 * floatValue));
                            p.this.laA.setLayoutParams(p.this.laB);
                            if (p.this.las != null && i3 > 0) {
                                p.this.las.CZ((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    p.this.eiM.start();
                    p.this.eiM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            p.this.lay = 0;
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
        this.lar.setOnPullRefreshListener(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.5
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void bcg() {
                com.baidu.adp.lib.f.e.lt().postDelayed(p.this.igK, p.igw);
                p.this.igA = true;
                p.this.laG = p.this.law.getCurrentTabType();
                p.this.cXh();
                p.this.law.bxR();
            }
        });
        this.WP = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.WP.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.6
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.dVN.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.dVN.getPageActivity());
                }
                p.this.lar.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.laF.ud(abs == 0);
                p.this.laF.ue(((float) abs) > p.this.laq / 2.0f);
                float abs2 = ((double) p.this.laq) == 0.0d ? 0.0f : Math.abs(abs / p.this.laq);
                p.this.laF.au(abs2);
                if (abs2 >= 1.0f) {
                    p.this.lap = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.laz.setCornerRadii(p.this.lap);
                    p.this.lau.setBackgroundDrawable(p.this.laz);
                    p.this.bxm();
                } else {
                    p.this.lap = new float[]{p.lao, p.lao, p.lao, p.lao, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.laz.setCornerRadii(p.this.lap);
                    p.this.lau.setBackgroundDrawable(p.this.laz);
                    p.this.cYo();
                }
                int i2 = p.this.lay - p.this.lax;
                if (p.this.lay > 0 && Math.abs(i) >= i2) {
                    p.this.lar.dismissLoading();
                }
            }
        });
        this.lau = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.hiP = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.hiP.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.hiP.setRectPaintColor(R.color.cp_link_tip_a);
        this.hiP.a(com.baidu.adp.lib.util.l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds46), true);
        this.hiP.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds64));
        this.hiP.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds8));
        this.hiP.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds8));
        this.hiP.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds0));
        this.hiP.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds166), -1));
        this.hiP.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.law.Dd(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.laz = new GradientDrawable();
        this.laz.setColor(ao.getColor(R.color.cp_bg_line_d));
        this.laz.setCornerRadii(this.lap);
        this.lau.setBackgroundDrawable(this.laz);
        this.lav = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        ao.setBackgroundResource(this.lav, R.drawable.personalize_tab_shadow);
        this.dYQ = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.law = new a(this.eGu.getActivity().getSupportFragmentManager());
        this.dYQ.setAdapter(this.law);
        this.dYQ.setOffscreenPageLimit(this.law.mFragments.size());
        this.law.notifyDataSetChanged();
        this.hiP.setViewPager(this.dYQ);
        this.dYQ.setCurrentItem(1);
        this.laE = new com.baidu.tieba.personPolymeric.header.c(this.dVN, this.mIsHost);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.laA.addView(this.laE.getView(), layoutParams);
        if (this.laF.cYm()) {
            E(this.dVN);
        }
        D(this.dVN);
        this.fsB = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.hhZ = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.kVl = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.kVm = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.kVo = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void D(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.laF != null) {
                    p.this.laF.cYk();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.agB);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c cYn() {
        return this.laE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends FragmentPagerAdapter {
        private List<String> kGC;
        private List<PersonCenterTabBaseFragment> mFragments;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.kGC = new ArrayList();
            this.kGC.add(p.this.dVN.getResources().getString(R.string.person_center_tab_main));
            this.kGC.add(p.this.dVN.getResources().getString(R.string.person_center_tab_thread));
            this.kGC.add(p.this.dVN.getResources().getString(R.string.person_center_tab_dynamic));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.l(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.m(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.k(p.this.mUserId, p.this.mIsHost));
        }

        public void Dd(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.kGC.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
                if (i2 == i) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return Df(i);
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
            return De(i);
        }

        private String De(int i) {
            return this.kGC.get(i);
        }

        public PersonCenterTabBaseFragment Df(int i) {
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

        public void bxR() {
            if (!x.isEmpty(this.mFragments)) {
                for (int i = 0; i < this.mFragments.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.tZ(false);
                    }
                }
            }
        }

        public void g(com.baidu.tieba.personPolymeric.c.a aVar) {
            if (aVar != null && !x.isEmpty(this.mFragments)) {
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
            if (aVar != null && aVar.getThreadUser() != null && !x.isEmpty(this.mFragments)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.mFragments.size()) {
                        PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i2);
                        if (personCenterTabBaseFragment != null) {
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
            if (x.isEmpty(this.mFragments)) {
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

    private boolean bxl() {
        return this.lav.getVisibility() == 0;
    }

    public void bxm() {
        if (!bxl() && this.laC == null) {
            this.lav.setVisibility(0);
            if (this.laC == null) {
                this.laC = new AlphaAnimation(0.0f, 1.0f);
                this.laC.setFillAfter(true);
                this.laC.setDuration(300L);
                this.laC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.9
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.laC.reset();
                        p.this.laC = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.lav.startAnimation(this.laC);
            }
        }
    }

    public void cYo() {
        if (bxl() && this.laD == null && this.laD == null) {
            this.laD = new AlphaAnimation(1.0f, 0.0f);
            this.laD.setFillAfter(true);
            this.laD.setDuration(300L);
            this.laD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.lav.setVisibility(8);
                    p.this.laD.reset();
                    p.this.laD = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.lav.startAnimation(this.laD);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.laF != null) {
            this.laF.onChangeSkinType(i);
        }
        if (this.hiP != null) {
            this.hiP.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
            this.hiP.setRectPaintColor(R.color.cp_link_tip_a);
            this.hiP.onChangeSkinType();
        }
        if (this.laz != null) {
            this.laz.setColor(ao.getColor(R.color.cp_bg_line_d));
        }
        if (this.laE != null) {
            this.laE.onChangeSkinType(i);
        }
        if (this.law != null) {
            this.law.onChangeSkinType(i);
        }
        if (this.fsB != null) {
            this.fsB.onChangeSkinType(this.dVN, i);
        }
        if (this.hhZ != null) {
            this.hhZ.onChangeSkinType(this.dVN, i);
        }
        ao.setBackgroundResource(this.kVl, R.color.cp_bg_line_d);
        ao.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        ao.setBackgroundResource(this.lav, R.drawable.personalize_tab_shadow);
    }

    public void cXh() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.lal.resetData();
            this.lal.refreshData();
            this.kVu.doRefresh();
            return;
        }
        this.kVu.chU();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        if (this.laF != null) {
            this.laF.setOnViewResponseListener(fVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.kVJ = aVar;
            this.kVl.setVisibility(8);
            this.kVo.setVisibility(0);
            if (this.laF != null) {
                this.laF.a(aVar, personStatus);
            }
            if (this.laE != null) {
                this.laE.b(aVar);
            }
            if (this.las != null) {
                this.las.e(this.kVJ.getUserData());
            }
            this.laA.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.11
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.lax == 0) {
                        p.this.lax = p.this.laA.getMeasuredHeight();
                        p.this.laq = p.this.laA.getMeasuredHeight() - p.this.laF.cYl().getMeasuredHeight();
                        if (p.this.las != null) {
                            p.this.las.CY(p.this.mStatusBarHeight + p.this.laF.cYl().getMeasuredHeight() + p.this.laA.getMeasuredHeight() + p.this.hiP.getMeasuredHeight());
                        }
                    }
                }
            });
            this.law.h(aVar);
            this.law.g(aVar);
            if (x.isEmpty(aVar.cpm())) {
                this.kVu.bxU();
                com.baidu.adp.lib.util.l.showToast(this.dVN.getContext(), this.dVN.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.ddy().uH(this.mIsHost);
            int size = aVar.cpm().size();
            for (int i = 0; i < size; i++) {
                q qVar = aVar.cpm().get(i);
                if (qVar != null && (qVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.kVu.bxU();
                    return;
                }
            }
            if (!z) {
                this.kVu.g(true, aVar.cpm());
            }
        }
    }

    public void chU() {
        this.kVu.chU();
    }

    private void E(TbPageContext tbPageContext) {
        this.lam = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).luw;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.laE != null && aVar != null) {
                            p.this.laE.tX(aVar.czr);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.kVJ != null) {
                            if (p.this.kVJ.kWy != null && p.this.kVJ.kWy.hrx != null && aVar2 != null) {
                                p.this.kVJ.kWy.hrx.putBoolean("person_center_item_red_tip_show", aVar2.czr);
                            }
                            if (aVar3 != null && p.this.kVJ.kWx != null && p.this.kVJ.kWx.hrx != null) {
                                p.this.kVJ.kWx.hrx.putBoolean("person_center_item_red_tip_show", aVar3.czr);
                            }
                            if (aVar4 != null && p.this.kVJ.kWw != null && p.this.kVJ.kWw.hrx != null) {
                                p.this.kVJ.kWw.hrx.putBoolean("person_center_item_red_tip_show", aVar4.czr);
                            }
                            if (aVar5 != null && p.this.kVJ.kWz != null && p.this.kVJ.kWz.hrx != null) {
                                p.this.kVJ.kWz.hrx.putBoolean("person_center_item_red_tip_show", aVar5.czr);
                            }
                            if (aVar6 != null && p.this.kVJ.kWA != null && p.this.kVJ.kWA.hrx != null) {
                                p.this.kVJ.kWA.hrx.putBoolean("person_center_item_red_tip_show", aVar6.czr);
                                p.this.kVJ.kWA.hrx.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.lam.setTag(this.agB);
        tbPageContext.registerListener(this.lam);
        this.mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.l lVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null) {
                    p.this.laE.LH(lVar.aUh());
                }
            }
        };
        this.mUpdatePendantListener.setTag(this.agB);
        tbPageContext.registerListener(this.mUpdatePendantListener);
        this.lan = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.laG == ((Integer) customResponsedMessage.getData()).intValue() && p.this.igA) {
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(p.this.igK);
                    p.this.cjf();
                }
            }
        };
        this.lan.setTag(this.agB);
        tbPageContext.registerListener(this.lan);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjf() {
        this.laG = -1;
        this.igA = false;
        if (this.lar != null) {
            this.lar.bce();
        }
    }

    public void onDestory() {
        if (this.laE != null) {
            this.laE.onDestroy();
        }
        if (this.lar != null) {
            this.lar.onDestroy();
        }
        if (this.eiM != null) {
            this.eiM.cancel();
            this.eiM.removeAllListeners();
            this.eiM.removeAllUpdateListeners();
            this.eiM = null;
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.igK);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.lal = aVar;
    }
}
