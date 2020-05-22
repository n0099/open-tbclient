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
    public static int hMt = 5000;
    private static final float kwn = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout Wr;
    private BdUniqueId afZ;
    private TbPageContext dIF;
    private CustomViewPager dLI;
    private ValueAnimator dVl;
    private BaseFragment erm;
    private NoNetworkView fbX;
    private PluginErrorTipView gPw;
    private NewPagerSlidingTabBaseStrip gQl;
    private CustomMessageListener kkV;
    private com.baidu.tieba.personPolymeric.c.a krE;
    private LinearLayout krg;
    protected FrameLayout krh;
    protected RelativeLayout krj;
    private com.baidu.tieba.personPolymeric.b.e krp;
    private AlphaAnimation kwA;
    private AlphaAnimation kwB;
    private com.baidu.tieba.personPolymeric.header.c kwC;
    private k kwD;
    private com.baidu.tieba.model.a kwk;
    private CustomMessageListener kwl;
    private CustomMessageListener kwm;
    private PullRefreshFrameLayout kwq;
    private com.baidu.tieba.personPolymeric.header.a kwr;
    private FrameLayout kws;
    private View kwt;
    private a kwu;
    private int kwv;
    private int kww;
    private GradientDrawable kwx;
    private FrameLayout kwy;
    private FrameLayout.LayoutParams kwz;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private long mUserId;
    private float[] kwo = {kwn, kwn, kwn, kwn, 0.0f, 0.0f, 0.0f, 0.0f};
    private float kwp = 674.0f;
    private boolean hMx = false;
    private int kwE = -1;
    private Runnable hMH = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.hMx) {
                p.this.ccf();
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.f fVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.erm = baseFragment;
        this.dIF = baseFragment.getPageContext();
        this.afZ = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.krp = fVar.cOS();
        ag(fVar.mRootView);
    }

    private void ag(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.kwq = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.kwr = new com.baidu.tieba.personPolymeric.header.a(this.dIF, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.kwD = new k(this.dIF, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.kwy = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.kwz = (FrameLayout.LayoutParams) this.kwy.getLayoutParams();
        this.kwq.setOnTouchCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void n(double d) {
                p.this.kwz.height = (int) (p.this.kwv + (PullRefreshFrameLayout.dUT * d));
                p.this.kwy.setLayoutParams(p.this.kwz);
                if (p.this.kwr != null) {
                    p.this.kwr.s(d);
                }
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void c(final int i, double d) {
                p.this.dVl = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.dVl.setDuration(150L);
                final int i2 = p.this.kwz.height;
                final int bVE = p.this.kwr.bVE();
                p.this.dVl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.kwz.height = (int) (i2 - (i * animatedFraction));
                        p.this.kwy.setLayoutParams(p.this.kwz);
                        if (p.this.kwr != null) {
                            p.this.kwr.Bv((int) (bVE - (animatedFraction * i)));
                        }
                    }
                });
                p.this.dVl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.kww = p.this.kwz.height;
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
            public void aWp() {
                final int i = p.this.kwz.height;
                final int i2 = p.this.kwz.height - p.this.kwv;
                final int i3 = 0;
                if (p.this.kwr != null) {
                    i3 = p.this.kwr.bVE();
                }
                if (i2 > 0) {
                    p.this.dVl = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.dVl.setDuration(300L);
                    p.this.dVl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.kwz.height = (int) (i - (i2 * floatValue));
                            p.this.kwy.setLayoutParams(p.this.kwz);
                            if (p.this.kwr != null && i3 > 0) {
                                p.this.kwr.Bv((int) (i3 - (floatValue * i2)));
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
                            p.this.kww = 0;
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
        this.kwq.setOnPullRefreshListener(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.5
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void aWo() {
                com.baidu.adp.lib.f.e.ld().postDelayed(p.this.hMH, p.hMt);
                p.this.hMx = true;
                p.this.kwE = p.this.kwu.getCurrentTabType();
                p.this.cOJ();
                p.this.kwu.brJ();
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
                p.this.kwq.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.kwD.tj(abs == 0);
                p.this.kwD.tk(((float) abs) > p.this.kwp / 2.0f);
                float abs2 = ((double) p.this.kwp) == 0.0d ? 0.0f : Math.abs(abs / p.this.kwp);
                p.this.kwD.aq(abs2);
                if (abs2 >= 1.0f) {
                    p.this.kwo = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.kwx.setCornerRadii(p.this.kwo);
                    p.this.kws.setBackgroundDrawable(p.this.kwx);
                    p.this.bre();
                } else {
                    p.this.kwo = new float[]{p.kwn, p.kwn, p.kwn, p.kwn, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.kwx.setCornerRadii(p.this.kwo);
                    p.this.kws.setBackgroundDrawable(p.this.kwx);
                    p.this.cPQ();
                }
                int i2 = p.this.kww - p.this.kwv;
                if (p.this.kww > 0 && Math.abs(i) >= i2) {
                    p.this.kwq.dismissLoading();
                }
            }
        });
        this.kws = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.gQl = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.gQl.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.gQl.setRectPaintColor(R.color.cp_link_tip_a);
        this.gQl.a(com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds46), true);
        this.gQl.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds64));
        this.gQl.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds8));
        this.gQl.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds8));
        this.gQl.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds0));
        this.gQl.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds166), -1));
        this.gQl.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.kwu.Bz(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.kwx = new GradientDrawable();
        this.kwx.setColor(am.getColor(R.color.cp_bg_line_d));
        this.kwx.setCornerRadii(this.kwo);
        this.kws.setBackgroundDrawable(this.kwx);
        this.kwt = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        am.setBackgroundResource(this.kwt, R.drawable.personalize_tab_shadow);
        this.dLI = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.kwu = new a(this.erm.getActivity().getSupportFragmentManager());
        this.dLI.setAdapter(this.kwu);
        this.dLI.setOffscreenPageLimit(this.kwu.mFragments.size());
        this.kwu.notifyDataSetChanged();
        this.gQl.setViewPager(this.dLI);
        if (this.mIsHost) {
            this.dLI.setCurrentItem(1);
        } else {
            this.dLI.setCurrentItem(0);
        }
        this.kwC = new com.baidu.tieba.personPolymeric.header.c(this.dIF, this.mIsHost);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.kwy.addView(this.kwC.getView(), layoutParams);
        if (this.kwD.cPO()) {
            C(this.dIF);
        }
        B(this.dIF);
        this.fbX = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.gPw = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.krg = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.krh = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.krj = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void B(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.kwD != null) {
                    p.this.kwD.cPM();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.afZ);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c cPP() {
        return this.kwC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends FragmentPagerAdapter {
        private List<String> kcL;
        private List<PersonCenterTabBaseFragment> mFragments;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.kcL = new ArrayList();
            this.kcL.add(p.this.dIF.getResources().getString(R.string.person_center_tab_main));
            this.kcL.add(p.this.dIF.getResources().getString(R.string.person_center_tab_dynamic));
            this.kcL.add(p.this.dIF.getResources().getString(R.string.person_center_tab_thread));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.l(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.k(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.m(p.this.mUserId, p.this.mIsHost));
        }

        public void Bz(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.kcL.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
                if (i2 == i) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return BB(i);
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
            return BA(i);
        }

        private String BA(int i) {
            return this.kcL.get(i);
        }

        public PersonCenterTabBaseFragment BB(int i) {
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

        public void brJ() {
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

    private boolean brd() {
        return this.kwt.getVisibility() == 0;
    }

    public void bre() {
        if (!brd() && this.kwA == null) {
            this.kwt.setVisibility(0);
            if (this.kwA == null) {
                this.kwA = new AlphaAnimation(0.0f, 1.0f);
                this.kwA.setFillAfter(true);
                this.kwA.setDuration(300L);
                this.kwA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.9
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.kwA.reset();
                        p.this.kwA = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.kwt.startAnimation(this.kwA);
            }
        }
    }

    public void cPQ() {
        if (brd() && this.kwB == null && this.kwB == null) {
            this.kwB = new AlphaAnimation(1.0f, 0.0f);
            this.kwB.setFillAfter(true);
            this.kwB.setDuration(300L);
            this.kwB.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.kwt.setVisibility(8);
                    p.this.kwB.reset();
                    p.this.kwB = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.kwt.startAnimation(this.kwB);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kwD != null) {
            this.kwD.onChangeSkinType(i);
        }
        if (this.gQl != null) {
            this.gQl.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
            this.gQl.setRectPaintColor(R.color.cp_link_tip_a);
            this.gQl.onChangeSkinType();
        }
        if (this.kwx != null) {
            this.kwx.setColor(am.getColor(R.color.cp_bg_line_d));
        }
        if (this.kwC != null) {
            this.kwC.onChangeSkinType(i);
        }
        if (this.kwu != null) {
            this.kwu.onChangeSkinType(i);
        }
        if (this.fbX != null) {
            this.fbX.onChangeSkinType(this.dIF, i);
        }
        if (this.gPw != null) {
            this.gPw.onChangeSkinType(this.dIF, i);
        }
        am.setBackgroundResource(this.krg, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.kwt, R.drawable.personalize_tab_shadow);
    }

    public void cOJ() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.kwk.resetData();
            this.kwk.refreshData();
            this.krp.doRefresh();
            return;
        }
        this.krp.caU();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        if (this.kwD != null) {
            this.kwD.setOnViewResponseListener(fVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.krE = aVar;
            this.krg.setVisibility(8);
            this.krj.setVisibility(0);
            if (this.kwD != null) {
                this.kwD.a(aVar, personStatus);
            }
            if (this.kwC != null) {
                this.kwC.b(aVar);
            }
            if (this.kwr != null) {
                this.kwr.e(this.krE.getUserData());
            }
            this.kwy.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.11
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.kwv == 0) {
                        p.this.kwv = p.this.kwy.getMeasuredHeight();
                        p.this.kwp = p.this.kwy.getMeasuredHeight() - p.this.kwD.cPN().getMeasuredHeight();
                        if (p.this.kwr != null) {
                            p.this.kwr.Bu(p.this.mStatusBarHeight + p.this.kwD.cPN().getMeasuredHeight() + p.this.kwy.getMeasuredHeight() + p.this.gQl.getMeasuredHeight());
                        }
                    }
                }
            });
            this.kwu.h(aVar);
            this.kwu.g(aVar);
            if (v.isEmpty(aVar.chO())) {
                this.krp.brM();
                com.baidu.adp.lib.util.l.showToast(this.dIF.getContext(), this.dIF.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.cVL().tO(this.mIsHost);
            int size = aVar.chO().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.o oVar = aVar.chO().get(i);
                if (oVar != null && (oVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.krp.brM();
                    return;
                }
            }
            if (!z) {
                this.krp.f(true, aVar.chO());
            }
        }
    }

    public void caU() {
        this.krp.caU();
    }

    private void C(TbPageContext tbPageContext) {
        this.kwl = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).kRX;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.kwC != null && aVar != null) {
                            p.this.kwC.td(aVar.euK);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.krE != null) {
                            if (p.this.krE.ksv != null && p.this.krE.ksv.gZo != null && aVar2 != null) {
                                p.this.krE.ksv.gZo.putBoolean("person_center_item_red_tip_show", aVar2.euK);
                            }
                            if (aVar3 != null && p.this.krE.ksu != null && p.this.krE.ksu.gZo != null) {
                                p.this.krE.ksu.gZo.putBoolean("person_center_item_red_tip_show", aVar3.euK);
                            }
                            if (aVar4 != null && p.this.krE.kst != null && p.this.krE.kst.gZo != null) {
                                p.this.krE.kst.gZo.putBoolean("person_center_item_red_tip_show", aVar4.euK);
                            }
                            if (aVar5 != null && p.this.krE.ksw != null && p.this.krE.ksw.gZo != null) {
                                p.this.krE.ksw.gZo.putBoolean("person_center_item_red_tip_show", aVar5.euK);
                            }
                            if (aVar6 != null && p.this.krE.ksx != null && p.this.krE.ksx.gZo != null) {
                                p.this.krE.ksx.gZo.putBoolean("person_center_item_red_tip_show", aVar6.euK);
                                p.this.krE.ksx.gZo.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.kwl.setTag(this.afZ);
        tbPageContext.registerListener(this.kwl);
        this.kkV = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.l lVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null) {
                    p.this.kwC.Kr(lVar.aOP());
                }
            }
        };
        this.kkV.setTag(this.afZ);
        tbPageContext.registerListener(this.kkV);
        this.kwm = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.kwE == ((Integer) customResponsedMessage.getData()).intValue() && p.this.hMx) {
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(p.this.hMH);
                    p.this.ccf();
                }
            }
        };
        this.kwm.setTag(this.afZ);
        tbPageContext.registerListener(this.kwm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccf() {
        this.kwE = -1;
        this.hMx = false;
        if (this.kwq != null) {
            this.kwq.aWm();
        }
    }

    public void onDestory() {
        if (this.kwC != null) {
            this.kwC.onDestroy();
        }
        if (this.kwq != null) {
            this.kwq.onDestroy();
        }
        if (this.dVl != null) {
            this.dVl.cancel();
            this.dVl.removeAllListeners();
            this.dVl.removeAllUpdateListeners();
            this.dVl = null;
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.hMH);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.kwk = aVar;
    }
}
