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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
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
    public static int hNg = 5000;
    private static final float kxt = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout Wr;
    private BdUniqueId afZ;
    private TbPageContext dIF;
    private CustomViewPager dLI;
    private ValueAnimator dVl;
    private BaseFragment erm;
    private NoNetworkView fci;
    private PluginErrorTipView gPH;
    private NewPagerSlidingTabBaseStrip gQw;
    private CustomMessageListener kmb;
    private com.baidu.tieba.personPolymeric.c.a ksK;
    private LinearLayout ksm;
    protected FrameLayout ksn;
    protected RelativeLayout ksp;
    private com.baidu.tieba.personPolymeric.b.e ksv;
    private a kxA;
    private int kxB;
    private int kxC;
    private GradientDrawable kxD;
    private FrameLayout kxE;
    private FrameLayout.LayoutParams kxF;
    private AlphaAnimation kxG;
    private AlphaAnimation kxH;
    private com.baidu.tieba.personPolymeric.header.c kxI;
    private k kxJ;
    private com.baidu.tieba.model.a kxq;
    private CustomMessageListener kxr;
    private CustomMessageListener kxs;
    private PullRefreshFrameLayout kxw;
    private com.baidu.tieba.personPolymeric.header.a kxx;
    private FrameLayout kxy;
    private View kxz;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private long mUserId;
    private float[] kxu = {kxt, kxt, kxt, kxt, 0.0f, 0.0f, 0.0f, 0.0f};
    private float kxv = 674.0f;
    private boolean hNk = false;
    private int kxK = -1;
    private Runnable hNu = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.hNk) {
                p.this.ccn();
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.f fVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.erm = baseFragment;
        this.dIF = baseFragment.getPageContext();
        this.afZ = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.ksv = fVar.cPi();
        ag(fVar.mRootView);
    }

    private void ag(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.kxw = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.kxx = new com.baidu.tieba.personPolymeric.header.a(this.dIF, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.kxJ = new k(this.dIF, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.kxE = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.kxF = (FrameLayout.LayoutParams) this.kxE.getLayoutParams();
        this.kxw.setOnTouchCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void n(double d) {
                p.this.kxF.height = (int) (p.this.kxB + (PullRefreshFrameLayout.dUT * d));
                p.this.kxE.setLayoutParams(p.this.kxF);
                if (p.this.kxx != null) {
                    p.this.kxx.s(d);
                }
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void c(final int i, double d) {
                p.this.dVl = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.dVl.setDuration(150L);
                final int i2 = p.this.kxF.height;
                final int bVG = p.this.kxx.bVG();
                p.this.dVl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.kxF.height = (int) (i2 - (i * animatedFraction));
                        p.this.kxE.setLayoutParams(p.this.kxF);
                        if (p.this.kxx != null) {
                            p.this.kxx.Bx((int) (bVG - (animatedFraction * i)));
                        }
                    }
                });
                p.this.dVl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.kxC = p.this.kxF.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.dVl.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void aWq() {
                final int i = p.this.kxF.height;
                final int i2 = p.this.kxF.height - p.this.kxB;
                final int i3 = 0;
                if (p.this.kxx != null) {
                    i3 = p.this.kxx.bVG();
                }
                if (i2 > 0) {
                    p.this.dVl = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.dVl.setDuration(300L);
                    p.this.dVl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.kxF.height = (int) (i - (i2 * floatValue));
                            p.this.kxE.setLayoutParams(p.this.kxF);
                            if (p.this.kxx != null && i3 > 0) {
                                p.this.kxx.Bx((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    p.this.dVl.start();
                    p.this.dVl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            p.this.kxC = 0;
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
        this.kxw.setOnPullRefreshListener(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.5
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void aWp() {
                com.baidu.adp.lib.f.e.ld().postDelayed(p.this.hNu, p.hNg);
                p.this.hNk = true;
                p.this.kxK = p.this.kxA.getCurrentTabType();
                p.this.cOZ();
                p.this.kxA.brL();
            }
        });
        this.Wr = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.Wr.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.6
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.dIF.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.dIF.getPageActivity());
                }
                p.this.kxw.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.kxJ.tj(abs == 0);
                p.this.kxJ.tk(((float) abs) > p.this.kxv / 2.0f);
                float abs2 = ((double) p.this.kxv) == 0.0d ? 0.0f : Math.abs(abs / p.this.kxv);
                p.this.kxJ.aq(abs2);
                if (abs2 >= 1.0f) {
                    p.this.kxu = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.kxD.setCornerRadii(p.this.kxu);
                    p.this.kxy.setBackgroundDrawable(p.this.kxD);
                    p.this.brg();
                } else {
                    p.this.kxu = new float[]{p.kxt, p.kxt, p.kxt, p.kxt, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.kxD.setCornerRadii(p.this.kxu);
                    p.this.kxy.setBackgroundDrawable(p.this.kxD);
                    p.this.cQg();
                }
                int i2 = p.this.kxC - p.this.kxB;
                if (p.this.kxC > 0 && Math.abs(i) >= i2) {
                    p.this.kxw.dismissLoading();
                }
            }
        });
        this.kxy = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.gQw = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.gQw.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.gQw.setRectPaintColor(R.color.cp_link_tip_a);
        this.gQw.a(com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds46), true);
        this.gQw.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds64));
        this.gQw.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds8));
        this.gQw.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds8));
        this.gQw.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds0));
        this.gQw.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds166), -1));
        this.gQw.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.kxA.BB(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.kxD = new GradientDrawable();
        this.kxD.setColor(am.getColor(R.color.cp_bg_line_d));
        this.kxD.setCornerRadii(this.kxu);
        this.kxy.setBackgroundDrawable(this.kxD);
        this.kxz = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        am.setBackgroundResource(this.kxz, R.drawable.personalize_tab_shadow);
        this.dLI = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.kxA = new a(this.erm.getActivity().getSupportFragmentManager());
        this.dLI.setAdapter(this.kxA);
        this.dLI.setOffscreenPageLimit(this.kxA.mFragments.size());
        this.kxA.notifyDataSetChanged();
        this.gQw.setViewPager(this.dLI);
        if (this.mIsHost) {
            this.dLI.setCurrentItem(1);
        } else {
            this.dLI.setCurrentItem(0);
        }
        this.kxI = new com.baidu.tieba.personPolymeric.header.c(this.dIF, this.mIsHost);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.kxE.addView(this.kxI.getView(), layoutParams);
        if (this.kxJ.cQe()) {
            C(this.dIF);
        }
        B(this.dIF);
        this.fci = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.gPH = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.ksm = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.ksn = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.ksp = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void B(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.kxJ != null) {
                    p.this.kxJ.cQc();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.afZ);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c cQf() {
        return this.kxI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends FragmentPagerAdapter {
        private List<String> kdR;
        private List<PersonCenterTabBaseFragment> mFragments;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.kdR = new ArrayList();
            this.kdR.add(p.this.dIF.getResources().getString(R.string.person_center_tab_main));
            this.kdR.add(p.this.dIF.getResources().getString(R.string.person_center_tab_dynamic));
            this.kdR.add(p.this.dIF.getResources().getString(R.string.person_center_tab_thread));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.l(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.k(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.m(p.this.mUserId, p.this.mIsHost));
        }

        public void BB(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.kdR.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
                if (i2 == i) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return BD(i);
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
            return BC(i);
        }

        private String BC(int i) {
            return this.kdR.get(i);
        }

        public PersonCenterTabBaseFragment BD(int i) {
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

        public void brL() {
            if (!v.isEmpty(this.mFragments)) {
                for (int i = 0; i < this.mFragments.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.tf(false);
                    }
                }
            }
        }

        public void g(com.baidu.tieba.personPolymeric.c.a aVar) {
            if (aVar != null && !v.isEmpty(this.mFragments)) {
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
            if (aVar != null && aVar.getThreadUser() != null && !v.isEmpty(this.mFragments)) {
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
            if (v.isEmpty(this.mFragments)) {
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

    private boolean brf() {
        return this.kxz.getVisibility() == 0;
    }

    public void brg() {
        if (!brf() && this.kxG == null) {
            this.kxz.setVisibility(0);
            if (this.kxG == null) {
                this.kxG = new AlphaAnimation(0.0f, 1.0f);
                this.kxG.setFillAfter(true);
                this.kxG.setDuration(300L);
                this.kxG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.9
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.kxG.reset();
                        p.this.kxG = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.kxz.startAnimation(this.kxG);
            }
        }
    }

    public void cQg() {
        if (brf() && this.kxH == null && this.kxH == null) {
            this.kxH = new AlphaAnimation(1.0f, 0.0f);
            this.kxH.setFillAfter(true);
            this.kxH.setDuration(300L);
            this.kxH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.kxz.setVisibility(8);
                    p.this.kxH.reset();
                    p.this.kxH = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.kxz.startAnimation(this.kxH);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kxJ != null) {
            this.kxJ.onChangeSkinType(i);
        }
        if (this.gQw != null) {
            this.gQw.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
            this.gQw.setRectPaintColor(R.color.cp_link_tip_a);
            this.gQw.onChangeSkinType();
        }
        if (this.kxD != null) {
            this.kxD.setColor(am.getColor(R.color.cp_bg_line_d));
        }
        if (this.kxI != null) {
            this.kxI.onChangeSkinType(i);
        }
        if (this.kxA != null) {
            this.kxA.onChangeSkinType(i);
        }
        if (this.fci != null) {
            this.fci.onChangeSkinType(this.dIF, i);
        }
        if (this.gPH != null) {
            this.gPH.onChangeSkinType(this.dIF, i);
        }
        am.setBackgroundResource(this.ksm, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.kxz, R.drawable.personalize_tab_shadow);
    }

    public void cOZ() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.kxq.resetData();
            this.kxq.refreshData();
            this.ksv.doRefresh();
            return;
        }
        this.ksv.cbc();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        if (this.kxJ != null) {
            this.kxJ.setOnViewResponseListener(fVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.ksK = aVar;
            this.ksm.setVisibility(8);
            this.ksp.setVisibility(0);
            if (this.kxJ != null) {
                this.kxJ.a(aVar, personStatus);
            }
            if (this.kxI != null) {
                this.kxI.b(aVar);
            }
            if (this.kxx != null) {
                this.kxx.e(this.ksK.getUserData());
            }
            this.kxE.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.11
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.kxB == 0) {
                        p.this.kxB = p.this.kxE.getMeasuredHeight();
                        p.this.kxv = p.this.kxE.getMeasuredHeight() - p.this.kxJ.cQd().getMeasuredHeight();
                        if (p.this.kxx != null) {
                            p.this.kxx.Bw(p.this.mStatusBarHeight + p.this.kxJ.cQd().getMeasuredHeight() + p.this.kxE.getMeasuredHeight() + p.this.gQw.getMeasuredHeight());
                        }
                    }
                }
            });
            this.kxA.h(aVar);
            this.kxA.g(aVar);
            if (v.isEmpty(aVar.chX())) {
                this.ksv.brO();
                com.baidu.adp.lib.util.l.showToast(this.dIF.getContext(), this.dIF.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.cWb().tO(this.mIsHost);
            int size = aVar.chX().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.o oVar = aVar.chX().get(i);
                if (oVar != null && (oVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.ksv.brO();
                    return;
                }
            }
            if (!z) {
                this.ksv.f(true, aVar.chX());
            }
        }
    }

    public void cbc() {
        this.ksv.cbc();
    }

    private void C(TbPageContext tbPageContext) {
        this.kxr = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).kTg;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.kxI != null && aVar != null) {
                            p.this.kxI.td(aVar.euK);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.ksK != null) {
                            if (p.this.ksK.ktB != null && p.this.ksK.ktB.gZz != null && aVar2 != null) {
                                p.this.ksK.ktB.gZz.putBoolean("person_center_item_red_tip_show", aVar2.euK);
                            }
                            if (aVar3 != null && p.this.ksK.ktA != null && p.this.ksK.ktA.gZz != null) {
                                p.this.ksK.ktA.gZz.putBoolean("person_center_item_red_tip_show", aVar3.euK);
                            }
                            if (aVar4 != null && p.this.ksK.ktz != null && p.this.ksK.ktz.gZz != null) {
                                p.this.ksK.ktz.gZz.putBoolean("person_center_item_red_tip_show", aVar4.euK);
                            }
                            if (aVar5 != null && p.this.ksK.ktC != null && p.this.ksK.ktC.gZz != null) {
                                p.this.ksK.ktC.gZz.putBoolean("person_center_item_red_tip_show", aVar5.euK);
                            }
                            if (aVar6 != null && p.this.ksK.ktD != null && p.this.ksK.ktD.gZz != null) {
                                p.this.ksK.ktD.gZz.putBoolean("person_center_item_red_tip_show", aVar6.euK);
                                p.this.ksK.ktD.gZz.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.kxr.setTag(this.afZ);
        tbPageContext.registerListener(this.kxr);
        this.kmb = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.l lVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null) {
                    p.this.kxI.Ks(lVar.aOP());
                }
            }
        };
        this.kmb.setTag(this.afZ);
        tbPageContext.registerListener(this.kmb);
        this.kxs = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.kxK == ((Integer) customResponsedMessage.getData()).intValue() && p.this.hNk) {
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(p.this.hNu);
                    p.this.ccn();
                }
            }
        };
        this.kxs.setTag(this.afZ);
        tbPageContext.registerListener(this.kxs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccn() {
        this.kxK = -1;
        this.hNk = false;
        if (this.kxw != null) {
            this.kxw.aWn();
        }
    }

    public void onDestory() {
        if (this.kxI != null) {
            this.kxI.onDestroy();
        }
        if (this.kxw != null) {
            this.kxw.onDestroy();
        }
        if (this.dVl != null) {
            this.dVl.cancel();
            this.dVl.removeAllListeners();
            this.dVl.removeAllUpdateListeners();
            this.dVl = null;
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.hNu);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.kxq = aVar;
    }
}
