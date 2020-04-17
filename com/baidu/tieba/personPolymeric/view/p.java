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
    public static int hxA = 5000;
    private static final float kes = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout VZ;
    private BdUniqueId afA;
    private ValueAnimator dGV;
    private TbPageContext duG;
    private CustomViewPager dxy;
    private NoNetworkView ePl;
    private BaseFragment ecV;
    private PluginErrorTipView gAH;
    private NewPagerSlidingTabBaseStrip gBw;
    private CustomMessageListener jSZ;
    private com.baidu.tieba.personPolymeric.c.a jZH;
    private LinearLayout jZj;
    protected FrameLayout jZk;
    protected RelativeLayout jZm;
    private com.baidu.tieba.personPolymeric.b.e jZs;
    private a keA;
    private int keB;
    private int keC;
    private GradientDrawable keD;
    private FrameLayout keE;
    private FrameLayout.LayoutParams keF;
    private AlphaAnimation keG;
    private AlphaAnimation keH;
    private com.baidu.tieba.personPolymeric.header.c keI;
    private k keJ;
    private com.baidu.tieba.model.a kep;
    private CustomMessageListener keq;
    private CustomMessageListener ker;
    private PullRefreshFrameLayout kev;
    private com.baidu.tieba.personPolymeric.header.a kew;
    private FrameLayout kex;
    private View kez;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private long mUserId;
    private float[] ket = {kes, kes, kes, kes, 0.0f, 0.0f, 0.0f, 0.0f};
    private float keu = 674.0f;
    private boolean hxE = false;
    private int keK = -1;
    private Runnable hxO = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.hxE) {
                p.this.bVI();
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.f fVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.ecV = baseFragment;
        this.duG = baseFragment.getPageContext();
        this.afA = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.jZs = fVar.cHV();
        ag(fVar.mRootView);
    }

    private void ag(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.kev = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.kew = new com.baidu.tieba.personPolymeric.header.a(this.duG, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.keJ = new k(this.duG, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.keE = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.keF = (FrameLayout.LayoutParams) this.keE.getLayoutParams();
        this.kev.setOnTouchCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void m(double d) {
                p.this.keF.height = (int) (p.this.keB + (PullRefreshFrameLayout.dGD * d));
                p.this.keE.setLayoutParams(p.this.keF);
                if (p.this.kew != null) {
                    p.this.kew.r(d);
                }
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void c(final int i, double d) {
                p.this.dGV = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.dGV.setDuration(150L);
                final int i2 = p.this.keF.height;
                final int bPj = p.this.kew.bPj();
                p.this.dGV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.keF.height = (int) (i2 - (i * animatedFraction));
                        p.this.keE.setLayoutParams(p.this.keF);
                        if (p.this.kew != null) {
                            p.this.kew.AK((int) (bPj - (animatedFraction * i)));
                        }
                    }
                });
                p.this.dGV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.keC = p.this.keF.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.dGV.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void aQo() {
                final int i = p.this.keF.height;
                final int i2 = p.this.keF.height - p.this.keB;
                final int i3 = 0;
                if (p.this.kew != null) {
                    i3 = p.this.kew.bPj();
                }
                if (i2 > 0) {
                    p.this.dGV = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.dGV.setDuration(300L);
                    p.this.dGV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.keF.height = (int) (i - (i2 * floatValue));
                            p.this.keE.setLayoutParams(p.this.keF);
                            if (p.this.kew != null && i3 > 0) {
                                p.this.kew.AK((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    p.this.dGV.start();
                    p.this.dGV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            p.this.keC = 0;
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
        this.kev.setOnPullRefreshListener(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.5
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void aQn() {
                com.baidu.adp.lib.f.e.lb().postDelayed(p.this.hxO, p.hxA);
                p.this.hxE = true;
                p.this.keK = p.this.keA.getCurrentTabType();
                p.this.cHM();
                p.this.keA.bmn();
            }
        });
        this.VZ = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.VZ.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.6
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.duG.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.duG.getPageActivity());
                }
                p.this.kev.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.keJ.sL(abs == 0);
                p.this.keJ.sM(((float) abs) > p.this.keu / 2.0f);
                float abs2 = ((double) p.this.keu) == 0.0d ? 0.0f : Math.abs(abs / p.this.keu);
                p.this.keJ.ar(abs2);
                if (abs2 >= 1.0f) {
                    p.this.ket = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.keD.setCornerRadii(p.this.ket);
                    p.this.kex.setBackgroundDrawable(p.this.keD);
                    p.this.blI();
                } else {
                    p.this.ket = new float[]{p.kes, p.kes, p.kes, p.kes, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.keD.setCornerRadii(p.this.ket);
                    p.this.kex.setBackgroundDrawable(p.this.keD);
                    p.this.cIT();
                }
                int i2 = p.this.keC - p.this.keB;
                if (p.this.keC > 0 && Math.abs(i) >= i2) {
                    p.this.kev.aqh();
                }
            }
        });
        this.kex = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.gBw = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.gBw.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.gBw.setRectPaintColor(R.color.cp_link_tip_a);
        this.gBw.a(com.baidu.adp.lib.util.l.getDimens(this.duG.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.duG.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.duG.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.duG.getPageActivity(), R.dimen.tbds46), true);
        this.gBw.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.duG.getPageActivity(), R.dimen.tbds64));
        this.gBw.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.duG.getPageActivity(), R.dimen.tbds8));
        this.gBw.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.duG.getPageActivity(), R.dimen.tbds8));
        this.gBw.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.duG.getPageActivity(), R.dimen.tbds0));
        this.gBw.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.duG.getPageActivity(), R.dimen.tbds166), -1));
        this.gBw.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.keA.AO(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.keD = new GradientDrawable();
        this.keD.setColor(am.getColor(R.color.cp_bg_line_d));
        this.keD.setCornerRadii(this.ket);
        this.kex.setBackgroundDrawable(this.keD);
        this.kez = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        am.setBackgroundResource(this.kez, R.drawable.personalize_tab_shadow);
        this.dxy = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.keA = new a(this.ecV.getActivity().getSupportFragmentManager());
        this.dxy.setAdapter(this.keA);
        this.dxy.setOffscreenPageLimit(this.keA.mFragments.size());
        this.keA.notifyDataSetChanged();
        this.gBw.setViewPager(this.dxy);
        if (this.mIsHost) {
            this.dxy.setCurrentItem(1);
        } else {
            this.dxy.setCurrentItem(0);
        }
        this.keI = new com.baidu.tieba.personPolymeric.header.c(this.duG, this.mIsHost);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.keE.addView(this.keI.getView(), layoutParams);
        if (this.keJ.cIR()) {
            C(this.duG);
        }
        B(this.duG);
        this.ePl = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.gAH = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.jZj = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.jZk = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.jZm = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void B(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.keJ != null) {
                    p.this.keJ.cIP();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.afA);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c cIS() {
        return this.keI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends FragmentPagerAdapter {
        private List<String> jKV;
        private List<PersonCenterTabBaseFragment> mFragments;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.jKV = new ArrayList();
            this.jKV.add(p.this.duG.getResources().getString(R.string.person_center_tab_main));
            this.jKV.add(p.this.duG.getResources().getString(R.string.person_center_tab_dynamic));
            this.jKV.add(p.this.duG.getResources().getString(R.string.person_center_tab_thread));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.k(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.j(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.l(p.this.mUserId, p.this.mIsHost));
        }

        public void AO(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.jKV.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
                if (i2 == i) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return AQ(i);
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
            return AP(i);
        }

        private String AP(int i) {
            return this.jKV.get(i);
        }

        public PersonCenterTabBaseFragment AQ(int i) {
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

        public void bmn() {
            if (!v.isEmpty(this.mFragments)) {
                for (int i = 0; i < this.mFragments.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.sH(false);
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

    private boolean blH() {
        return this.kez.getVisibility() == 0;
    }

    public void blI() {
        if (!blH() && this.keG == null) {
            this.kez.setVisibility(0);
            if (this.keG == null) {
                this.keG = new AlphaAnimation(0.0f, 1.0f);
                this.keG.setFillAfter(true);
                this.keG.setDuration(300L);
                this.keG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.9
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.keG.reset();
                        p.this.keG = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.kez.startAnimation(this.keG);
            }
        }
    }

    public void cIT() {
        if (blH() && this.keH == null && this.keH == null) {
            this.keH = new AlphaAnimation(1.0f, 0.0f);
            this.keH.setFillAfter(true);
            this.keH.setDuration(300L);
            this.keH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.kez.setVisibility(8);
                    p.this.keH.reset();
                    p.this.keH = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.kez.startAnimation(this.keH);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.keJ != null) {
            this.keJ.onChangeSkinType(i);
        }
        if (this.gBw != null) {
            this.gBw.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
            this.gBw.setRectPaintColor(R.color.cp_link_tip_a);
            this.gBw.onChangeSkinType();
        }
        if (this.keD != null) {
            this.keD.setColor(am.getColor(R.color.cp_bg_line_d));
        }
        if (this.keI != null) {
            this.keI.onChangeSkinType(i);
        }
        if (this.keA != null) {
            this.keA.onChangeSkinType(i);
        }
        if (this.ePl != null) {
            this.ePl.onChangeSkinType(this.duG, i);
        }
        if (this.gAH != null) {
            this.gAH.onChangeSkinType(this.duG, i);
        }
        am.setBackgroundResource(this.jZj, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.kez, R.drawable.personalize_tab_shadow);
    }

    public void cHM() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.kep.resetData();
            this.kep.refreshData();
            this.jZs.doRefresh();
            return;
        }
        this.jZs.bUy();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        if (this.keJ != null) {
            this.keJ.setOnViewResponseListener(fVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.jZH = aVar;
            this.jZj.setVisibility(8);
            this.jZm.setVisibility(0);
            if (this.keJ != null) {
                this.keJ.a(aVar, personStatus);
            }
            if (this.keI != null) {
                this.keI.b(aVar);
            }
            if (this.kew != null) {
                this.kew.e(this.jZH.getUserData());
            }
            this.keE.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.11
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.keB == 0) {
                        p.this.keB = p.this.keE.getMeasuredHeight();
                        p.this.keu = p.this.keE.getMeasuredHeight() - p.this.keJ.cIQ().getMeasuredHeight();
                        if (p.this.kew != null) {
                            p.this.kew.AJ(p.this.mStatusBarHeight + p.this.keJ.cIQ().getMeasuredHeight() + p.this.keE.getMeasuredHeight() + p.this.gBw.getMeasuredHeight());
                        }
                    }
                }
            });
            this.keA.h(aVar);
            this.keA.g(aVar);
            if (v.isEmpty(aVar.cbq())) {
                this.jZs.bmq();
                com.baidu.adp.lib.util.l.showToast(this.duG.getContext(), this.duG.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.cOL().tq(this.mIsHost);
            int size = aVar.cbq().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.m mVar = aVar.cbq().get(i);
                if (mVar != null && (mVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.jZs.bmq();
                    return;
                }
            }
            if (!z) {
                this.jZs.e(true, aVar.cbq());
            }
        }
    }

    public void bUy() {
        this.jZs.bUy();
    }

    private void C(TbPageContext tbPageContext) {
        this.keq = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).kzR;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.keI != null && aVar != null) {
                            p.this.keI.sF(aVar.egr);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.jZH != null) {
                            if (p.this.jZH.kaz != null && p.this.jZH.kaz.gKw != null && aVar2 != null) {
                                p.this.jZH.kaz.gKw.putBoolean("person_center_item_red_tip_show", aVar2.egr);
                            }
                            if (aVar3 != null && p.this.jZH.kay != null && p.this.jZH.kay.gKw != null) {
                                p.this.jZH.kay.gKw.putBoolean("person_center_item_red_tip_show", aVar3.egr);
                            }
                            if (aVar4 != null && p.this.jZH.kax != null && p.this.jZH.kax.gKw != null) {
                                p.this.jZH.kax.gKw.putBoolean("person_center_item_red_tip_show", aVar4.egr);
                            }
                            if (aVar5 != null && p.this.jZH.kaA != null && p.this.jZH.kaA.gKw != null) {
                                p.this.jZH.kaA.gKw.putBoolean("person_center_item_red_tip_show", aVar5.egr);
                            }
                            if (aVar6 != null && p.this.jZH.kaB != null && p.this.jZH.kaB.gKw != null) {
                                p.this.jZH.kaB.gKw.putBoolean("person_center_item_red_tip_show", aVar6.egr);
                                p.this.jZH.kaB.gKw.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.keq.setTag(this.afA);
        tbPageContext.registerListener(this.keq);
        this.jSZ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.k kVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k) && (kVar = (com.baidu.tbadk.data.k) customResponsedMessage.getData()) != null) {
                    p.this.keI.IC(kVar.aIW());
                }
            }
        };
        this.jSZ.setTag(this.afA);
        tbPageContext.registerListener(this.jSZ);
        this.ker = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.keK == ((Integer) customResponsedMessage.getData()).intValue() && p.this.hxE) {
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(p.this.hxO);
                    p.this.bVI();
                }
            }
        };
        this.ker.setTag(this.afA);
        tbPageContext.registerListener(this.ker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVI() {
        this.keK = -1;
        this.hxE = false;
        if (this.kev != null) {
            this.kev.aQl();
        }
    }

    public void onDestory() {
        if (this.keI != null) {
            this.keI.onDestroy();
        }
        if (this.kev != null) {
            this.kev.onDestroy();
        }
        if (this.dGV != null) {
            this.dGV.cancel();
            this.dGV.removeAllListeners();
            this.dGV.removeAllUpdateListeners();
            this.dGV = null;
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hxO);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.kep = aVar;
    }
}
