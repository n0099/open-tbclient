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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes11.dex */
public class p {
    public static int ias = 5000;
    private static final float kRq = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout WW;
    private BdUniqueId agK;
    private TbPageContext dPv;
    private CustomViewPager dSy;
    private BaseFragment eAe;
    private ValueAnimator ecC;
    private NoNetworkView fns;
    private PluginErrorTipView hcq;
    private NewPagerSlidingTabBaseStrip hdf;
    private CustomMessageListener kFO;
    private com.baidu.tieba.personPolymeric.c.a kMH;
    private LinearLayout kMj;
    protected FrameLayout kMk;
    protected RelativeLayout kMm;
    private com.baidu.tieba.personPolymeric.b.e kMs;
    private GradientDrawable kRA;
    private FrameLayout kRB;
    private FrameLayout.LayoutParams kRC;
    private AlphaAnimation kRD;
    private AlphaAnimation kRE;
    private com.baidu.tieba.personPolymeric.header.c kRF;
    private k kRG;
    private com.baidu.tieba.model.a kRn;
    private CustomMessageListener kRo;
    private CustomMessageListener kRp;
    private PullRefreshFrameLayout kRt;
    private com.baidu.tieba.personPolymeric.header.a kRu;
    private FrameLayout kRv;
    private View kRw;
    private a kRx;
    private int kRy;
    private int kRz;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private long mUserId;
    private float[] kRr = {kRq, kRq, kRq, kRq, 0.0f, 0.0f, 0.0f, 0.0f};
    private float kRs = 674.0f;
    private boolean iaw = false;
    private int kRH = -1;
    private Runnable iaG = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.iaw) {
                p.this.cfG();
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.f fVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.eAe = baseFragment;
        this.dPv = baseFragment.getPageContext();
        this.agK = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.kMs = fVar.cTA();
        ag(fVar.mRootView);
    }

    private void ag(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.kRt = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.kRu = new com.baidu.tieba.personPolymeric.header.a(this.dPv, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.kRG = new k(this.dPv, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.kRB = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.kRC = (FrameLayout.LayoutParams) this.kRB.getLayoutParams();
        this.kRt.setOnTouchCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void n(double d) {
                p.this.kRC.height = (int) (p.this.kRy + (PullRefreshFrameLayout.eck * d));
                p.this.kRB.setLayoutParams(p.this.kRC);
                if (p.this.kRu != null) {
                    p.this.kRu.t(d);
                }
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void c(final int i, double d) {
                p.this.ecC = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.ecC.setDuration(150L);
                final int i2 = p.this.kRC.height;
                final int bYP = p.this.kRu.bYP();
                p.this.ecC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.kRC.height = (int) (i2 - (i * animatedFraction));
                        p.this.kRB.setLayoutParams(p.this.kRC);
                        if (p.this.kRu != null) {
                            p.this.kRu.Cz((int) (bYP - (animatedFraction * i)));
                        }
                    }
                });
                p.this.ecC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.kRz = p.this.kRC.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.ecC.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void aYh() {
                final int i = p.this.kRC.height;
                final int i2 = p.this.kRC.height - p.this.kRy;
                final int i3 = 0;
                if (p.this.kRu != null) {
                    i3 = p.this.kRu.bYP();
                }
                if (i2 > 0) {
                    p.this.ecC = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.ecC.setDuration(300L);
                    p.this.ecC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.kRC.height = (int) (i - (i2 * floatValue));
                            p.this.kRB.setLayoutParams(p.this.kRC);
                            if (p.this.kRu != null && i3 > 0) {
                                p.this.kRu.Cz((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    p.this.ecC.start();
                    p.this.ecC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            p.this.kRz = 0;
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
        this.kRt.setOnPullRefreshListener(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.5
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void aYg() {
                com.baidu.adp.lib.f.e.lt().postDelayed(p.this.iaG, p.ias);
                p.this.iaw = true;
                p.this.kRH = p.this.kRx.getCurrentTabType();
                p.this.cTr();
                p.this.kRx.buI();
            }
        });
        this.WW = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.WW.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.6
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.dPv.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.dPv.getPageActivity());
                }
                p.this.kRt.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.kRG.tx(abs == 0);
                p.this.kRG.ty(((float) abs) > p.this.kRs / 2.0f);
                float abs2 = ((double) p.this.kRs) == 0.0d ? 0.0f : Math.abs(abs / p.this.kRs);
                p.this.kRG.av(abs2);
                if (abs2 >= 1.0f) {
                    p.this.kRr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.kRA.setCornerRadii(p.this.kRr);
                    p.this.kRv.setBackgroundDrawable(p.this.kRA);
                    p.this.bud();
                } else {
                    p.this.kRr = new float[]{p.kRq, p.kRq, p.kRq, p.kRq, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.kRA.setCornerRadii(p.this.kRr);
                    p.this.kRv.setBackgroundDrawable(p.this.kRA);
                    p.this.cUy();
                }
                int i2 = p.this.kRz - p.this.kRy;
                if (p.this.kRz > 0 && Math.abs(i) >= i2) {
                    p.this.kRt.dismissLoading();
                }
            }
        });
        this.kRv = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.hdf = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.hdf.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.hdf.setRectPaintColor(R.color.cp_link_tip_a);
        this.hdf.a(com.baidu.adp.lib.util.l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds46), true);
        this.hdf.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds64));
        this.hdf.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds8));
        this.hdf.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds8));
        this.hdf.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds0));
        this.hdf.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds166), -1));
        this.hdf.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.kRx.CD(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.kRA = new GradientDrawable();
        this.kRA.setColor(an.getColor(R.color.cp_bg_line_d));
        this.kRA.setCornerRadii(this.kRr);
        this.kRv.setBackgroundDrawable(this.kRA);
        this.kRw = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        an.setBackgroundResource(this.kRw, R.drawable.personalize_tab_shadow);
        this.dSy = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.kRx = new a(this.eAe.getActivity().getSupportFragmentManager());
        this.dSy.setAdapter(this.kRx);
        this.dSy.setOffscreenPageLimit(this.kRx.mFragments.size());
        this.kRx.notifyDataSetChanged();
        this.hdf.setViewPager(this.dSy);
        this.dSy.setCurrentItem(1);
        this.kRF = new com.baidu.tieba.personPolymeric.header.c(this.dPv, this.mIsHost);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.kRB.addView(this.kRF.getView(), layoutParams);
        if (this.kRG.cUw()) {
            F(this.dPv);
        }
        E(this.dPv);
        this.fns = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.hcq = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.kMj = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.kMk = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.kMm = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void E(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.kRG != null) {
                    p.this.kRG.cUu();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.agK);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c cUx() {
        return this.kRF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends FragmentPagerAdapter {
        private List<String> kxG;
        private List<PersonCenterTabBaseFragment> mFragments;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.kxG = new ArrayList();
            this.kxG.add(p.this.dPv.getResources().getString(R.string.person_center_tab_main));
            this.kxG.add(p.this.dPv.getResources().getString(R.string.person_center_tab_thread));
            this.kxG.add(p.this.dPv.getResources().getString(R.string.person_center_tab_dynamic));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.l(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.m(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.k(p.this.mUserId, p.this.mIsHost));
        }

        public void CD(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.kxG.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
                if (i2 == i) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return CF(i);
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
            return CE(i);
        }

        private String CE(int i) {
            return this.kxG.get(i);
        }

        public PersonCenterTabBaseFragment CF(int i) {
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

        public void buI() {
            if (!w.isEmpty(this.mFragments)) {
                for (int i = 0; i < this.mFragments.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.tt(false);
                    }
                }
            }
        }

        public void g(com.baidu.tieba.personPolymeric.c.a aVar) {
            if (aVar != null && !w.isEmpty(this.mFragments)) {
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
            if (aVar != null && aVar.getThreadUser() != null && !w.isEmpty(this.mFragments)) {
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
            if (w.isEmpty(this.mFragments)) {
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

    private boolean buc() {
        return this.kRw.getVisibility() == 0;
    }

    public void bud() {
        if (!buc() && this.kRD == null) {
            this.kRw.setVisibility(0);
            if (this.kRD == null) {
                this.kRD = new AlphaAnimation(0.0f, 1.0f);
                this.kRD.setFillAfter(true);
                this.kRD.setDuration(300L);
                this.kRD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.9
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.kRD.reset();
                        p.this.kRD = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.kRw.startAnimation(this.kRD);
            }
        }
    }

    public void cUy() {
        if (buc() && this.kRE == null && this.kRE == null) {
            this.kRE = new AlphaAnimation(1.0f, 0.0f);
            this.kRE.setFillAfter(true);
            this.kRE.setDuration(300L);
            this.kRE.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.kRw.setVisibility(8);
                    p.this.kRE.reset();
                    p.this.kRE = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.kRw.startAnimation(this.kRE);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kRG != null) {
            this.kRG.onChangeSkinType(i);
        }
        if (this.hdf != null) {
            this.hdf.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
            this.hdf.setRectPaintColor(R.color.cp_link_tip_a);
            this.hdf.onChangeSkinType();
        }
        if (this.kRA != null) {
            this.kRA.setColor(an.getColor(R.color.cp_bg_line_d));
        }
        if (this.kRF != null) {
            this.kRF.onChangeSkinType(i);
        }
        if (this.kRx != null) {
            this.kRx.onChangeSkinType(i);
        }
        if (this.fns != null) {
            this.fns.onChangeSkinType(this.dPv, i);
        }
        if (this.hcq != null) {
            this.hcq.onChangeSkinType(this.dPv, i);
        }
        an.setBackgroundResource(this.kMj, R.color.cp_bg_line_d);
        an.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        an.setBackgroundResource(this.kRw, R.drawable.personalize_tab_shadow);
    }

    public void cTr() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.kRn.resetData();
            this.kRn.refreshData();
            this.kMs.doRefresh();
            return;
        }
        this.kMs.cev();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        if (this.kRG != null) {
            this.kRG.setOnViewResponseListener(fVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.kMH = aVar;
            this.kMj.setVisibility(8);
            this.kMm.setVisibility(0);
            if (this.kRG != null) {
                this.kRG.a(aVar, personStatus);
            }
            if (this.kRF != null) {
                this.kRF.b(aVar);
            }
            if (this.kRu != null) {
                this.kRu.e(this.kMH.getUserData());
            }
            this.kRB.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.11
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.kRy == 0) {
                        p.this.kRy = p.this.kRB.getMeasuredHeight();
                        p.this.kRs = p.this.kRB.getMeasuredHeight() - p.this.kRG.cUv().getMeasuredHeight();
                        if (p.this.kRu != null) {
                            p.this.kRu.Cy(p.this.mStatusBarHeight + p.this.kRG.cUv().getMeasuredHeight() + p.this.kRB.getMeasuredHeight() + p.this.hdf.getMeasuredHeight());
                        }
                    }
                }
            });
            this.kRx.h(aVar);
            this.kRx.g(aVar);
            if (w.isEmpty(aVar.clM())) {
                this.kMs.buL();
                com.baidu.adp.lib.util.l.showToast(this.dPv.getContext(), this.dPv.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.dar().ud(this.mIsHost);
            int size = aVar.clM().size();
            for (int i = 0; i < size; i++) {
                q qVar = aVar.clM().get(i);
                if (qVar != null && (qVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.kMs.buL();
                    return;
                }
            }
            if (!z) {
                this.kMs.g(true, aVar.clM());
            }
        }
    }

    public void cev() {
        this.kMs.cev();
    }

    private void F(TbPageContext tbPageContext) {
        this.kRo = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).lmY;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.kRF != null && aVar != null) {
                            p.this.kRF.tr(aVar.eDO);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.kMH != null) {
                            if (p.this.kMH.kNy != null && p.this.kMH.kNy.hlL != null && aVar2 != null) {
                                p.this.kMH.kNy.hlL.putBoolean("person_center_item_red_tip_show", aVar2.eDO);
                            }
                            if (aVar3 != null && p.this.kMH.kNx != null && p.this.kMH.kNx.hlL != null) {
                                p.this.kMH.kNx.hlL.putBoolean("person_center_item_red_tip_show", aVar3.eDO);
                            }
                            if (aVar4 != null && p.this.kMH.kNw != null && p.this.kMH.kNw.hlL != null) {
                                p.this.kMH.kNw.hlL.putBoolean("person_center_item_red_tip_show", aVar4.eDO);
                            }
                            if (aVar5 != null && p.this.kMH.kNz != null && p.this.kMH.kNz.hlL != null) {
                                p.this.kMH.kNz.hlL.putBoolean("person_center_item_red_tip_show", aVar5.eDO);
                            }
                            if (aVar6 != null && p.this.kMH.kNA != null && p.this.kMH.kNA.hlL != null) {
                                p.this.kMH.kNA.hlL.putBoolean("person_center_item_red_tip_show", aVar6.eDO);
                                p.this.kMH.kNA.hlL.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.kRo.setTag(this.agK);
        tbPageContext.registerListener(this.kRo);
        this.kFO = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.l lVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null) {
                    p.this.kRF.KT(lVar.aQl());
                }
            }
        };
        this.kFO.setTag(this.agK);
        tbPageContext.registerListener(this.kFO);
        this.kRp = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.kRH == ((Integer) customResponsedMessage.getData()).intValue() && p.this.iaw) {
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(p.this.iaG);
                    p.this.cfG();
                }
            }
        };
        this.kRp.setTag(this.agK);
        tbPageContext.registerListener(this.kRp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfG() {
        this.kRH = -1;
        this.iaw = false;
        if (this.kRt != null) {
            this.kRt.aYe();
        }
    }

    public void onDestory() {
        if (this.kRF != null) {
            this.kRF.onDestroy();
        }
        if (this.kRt != null) {
            this.kRt.onDestroy();
        }
        if (this.ecC != null) {
            this.ecC.cancel();
            this.ecC.removeAllListeners();
            this.ecC.removeAllUpdateListeners();
            this.ecC = null;
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.iaG);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.kRn = aVar;
    }
}
