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
/* loaded from: classes18.dex */
public class p {
    public static int iuG = 5000;
    private static final float lqO = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout Xx;
    private BdUniqueId ahM;
    private BaseFragment eRe;
    private TbPageContext efr;
    private CustomViewPager eiA;
    private ValueAnimator esJ;
    private NoNetworkView fDZ;
    private NewPagerSlidingTabBaseStrip hvT;
    private PluginErrorTipView hvf;
    private com.baidu.tieba.personPolymeric.c.a llL;
    private LinearLayout lln;
    protected FrameLayout llo;
    protected RelativeLayout llq;
    private com.baidu.tieba.personPolymeric.b.f llw;
    private com.baidu.tieba.model.a lqL;
    private CustomMessageListener lqM;
    private CustomMessageListener lqN;
    private PullRefreshFrameLayout lqR;
    private com.baidu.tieba.personPolymeric.header.a lqS;
    private FrameLayout lqT;
    private View lqU;
    private a lqV;
    private int lqW;
    private int lqX;
    private GradientDrawable lqY;
    private FrameLayout lqZ;
    private FrameLayout.LayoutParams lra;
    private AlphaAnimation lrb;
    private AlphaAnimation lrc;
    private com.baidu.tieba.personPolymeric.header.c lrd;
    private k lre;
    private int lrg;
    private boolean lrh;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private CustomMessageListener mUpdatePendantListener;
    private long mUserId;
    private float[] lqP = {lqO, lqO, lqO, lqO, 0.0f, 0.0f, 0.0f, 0.0f};
    private float lqQ = 674.0f;
    private boolean iuK = false;
    private int lrf = -1;
    private Runnable iuU = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.6
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.iuK) {
                p.this.ctK();
            }
        }
    };
    private com.baidu.tieba.personPolymeric.b.a lnP = new com.baidu.tieba.personPolymeric.b.a() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.tieba.personPolymeric.b.a
        public void AD(int i) {
            p.this.lra.height = -2;
            p.this.lqZ.setLayoutParams(p.this.lra);
        }

        @Override // com.baidu.tieba.personPolymeric.b.a
        public void gu(boolean z) {
            p.this.lrh = z;
            if (!z) {
                p.this.lqS.Ft(p.this.lrg);
            }
            if (p.this.lrd != null && p.this.lrd.djh() != null) {
                p.this.lrd.djh().setOpen(z);
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.g gVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.eRe = baseFragment;
        this.efr = baseFragment.getPageContext();
        this.ahM = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.llw = gVar.dis();
        ak(gVar.mRootView);
    }

    private void ak(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.lqR = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.lqS = new com.baidu.tieba.personPolymeric.header.a(this.efr, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.lre = new k(this.efr, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.lqZ = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.lra = (FrameLayout.LayoutParams) this.lqZ.getLayoutParams();
        this.lqR.setOnTouchCallback(new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void t(double d) {
                p.this.lra.height = (int) ((p.this.lrh ? com.baidu.tieba.personPolymeric.header.b.lnK : 0) + p.this.lqW + (PullRefreshFrameLayout.esp * d));
                p.this.lqZ.setLayoutParams(p.this.lra);
                if (p.this.lqS != null) {
                    p.this.lqS.z(d);
                }
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                p.this.esJ = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.esJ.setDuration(150L);
                final int measuredHeight = p.this.lqZ.getMeasuredHeight();
                final int cmK = p.this.lqS.cmK();
                p.this.esJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.lra.height = (int) (measuredHeight - (i * animatedFraction));
                        p.this.lqZ.setLayoutParams(p.this.lra);
                        if (p.this.lqS != null) {
                            p.this.lqS.Fu((int) (cmK - (animatedFraction * i)));
                        }
                    }
                });
                p.this.esJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.lqX = p.this.lra.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.esJ.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void bkE() {
                final int measuredHeight = p.this.lqZ.getMeasuredHeight();
                final int i = (measuredHeight - p.this.lqW) - (p.this.lrh ? com.baidu.tieba.personPolymeric.header.b.lnK : 0);
                final int cmK = p.this.lqS != null ? p.this.lqS.cmK() : 0;
                if (p.this.lrh) {
                    p.this.lrd.uL(false);
                    p.this.lrd.diK();
                }
                if (i > 0 || (i == 0 && p.this.lrh)) {
                    p.this.esJ = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.esJ.setDuration(300L);
                    p.this.esJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.lra.height = (int) (measuredHeight - (i * floatValue));
                            p.this.lqZ.setLayoutParams(p.this.lra);
                            if (p.this.lqS != null && cmK > 0) {
                                p.this.lqS.Fu((int) (cmK - (floatValue * i)));
                            }
                        }
                    });
                    p.this.esJ.start();
                    p.this.esJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (p.this.lrh) {
                                p.this.lrd.diL();
                            }
                            p.this.lqX = 0;
                            p.this.lra.height = -2;
                            p.this.lqZ.setLayoutParams(p.this.lra);
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
        this.lqR.setOnPullRefreshListener(new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.personPolymeric.view.p.8
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bkD() {
                com.baidu.adp.lib.f.e.mS().postDelayed(p.this.iuU, p.iuG);
                p.this.iuK = true;
                p.this.lrf = p.this.lqV.getCurrentTabType();
                p.this.dij();
                p.this.lqV.bGR();
            }
        });
        this.lqR.setOnCancelCallBack(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void onCancel() {
                p.this.lqX = 0;
                p.this.lra.height = -2;
                p.this.lqZ.setLayoutParams(p.this.lra);
            }
        });
        this.lqR.setOnLoadingStartCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.10
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void bkC() {
                p.this.lra.height = -2;
                p.this.lqZ.setLayoutParams(p.this.lra);
            }
        });
        this.Xx = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.Xx.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.11
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.efr.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.efr.getPageActivity());
                }
                p.this.lqR.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.lre.uR(abs == 0);
                p.this.lre.uS(((float) abs) > p.this.lqQ / 2.0f);
                float abs2 = ((double) p.this.lqQ) == 0.0d ? 0.0f : Math.abs(abs / p.this.lqQ);
                p.this.lre.aA(abs2);
                if (abs2 >= 1.0f) {
                    p.this.lqP = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.lqY.setCornerRadii(p.this.lqP);
                    p.this.lqT.setBackgroundDrawable(p.this.lqY);
                    p.this.bGm();
                } else {
                    p.this.lqP = new float[]{p.lqO, p.lqO, p.lqO, p.lqO, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.lqY.setCornerRadii(p.this.lqP);
                    p.this.lqT.setBackgroundDrawable(p.this.lqY);
                    p.this.dju();
                }
                int i2 = p.this.lqX - p.this.lqW;
                if (p.this.lqX > 0 && Math.abs(i) >= i2) {
                    p.this.lqR.dismissLoading();
                }
            }
        });
        this.lqT = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.hvT = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.hvT.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.hvT.setRectPaintColor(R.color.cp_link_tip_a);
        this.hvT.a(com.baidu.adp.lib.util.l.getDimens(this.efr.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.efr.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.efr.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.efr.getPageActivity(), R.dimen.tbds46), true);
        this.hvT.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.efr.getPageActivity(), R.dimen.tbds64));
        this.hvT.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.efr.getPageActivity(), R.dimen.tbds8));
        this.hvT.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.efr.getPageActivity(), R.dimen.tbds8));
        this.hvT.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.efr.getPageActivity(), R.dimen.tbds0));
        this.hvT.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.efr.getPageActivity(), R.dimen.tbds166), -1));
        this.hvT.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.12
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.lqV.Fy(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.lqY = new GradientDrawable();
        this.lqY.setColor(ap.getColor(R.color.cp_bg_line_d));
        this.lqY.setCornerRadii(this.lqP);
        this.lqT.setBackgroundDrawable(this.lqY);
        this.lqU = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        ap.setBackgroundResource(this.lqU, R.drawable.personalize_tab_shadow);
        this.eiA = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.lqV = new a(this.eRe.getActivity().getSupportFragmentManager());
        this.eiA.setAdapter(this.lqV);
        this.eiA.setOffscreenPageLimit(this.lqV.mFragments.size());
        this.lqV.notifyDataSetChanged();
        this.hvT.setViewPager(this.eiA);
        this.eiA.setCurrentItem(1);
        this.lrd = new com.baidu.tieba.personPolymeric.header.c(this.efr, this.mIsHost);
        this.lrd.a(this.lnP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.lqZ.addView(this.lrd.getView(), layoutParams);
        if (this.lre.djs()) {
            E(this.efr);
        }
        D(this.efr);
        this.fDZ = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.hvf = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.lln = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.llo = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.llq = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void D(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.lre != null) {
                    p.this.lre.djq();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.ahM);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c djt() {
        return this.lrd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends FragmentPagerAdapter {
        private List<String> kWq;
        private List<PersonCenterTabBaseFragment> mFragments;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.kWq = new ArrayList();
            this.kWq.add(p.this.efr.getResources().getString(R.string.person_center_tab_main));
            this.kWq.add(p.this.efr.getResources().getString(R.string.person_center_tab_thread));
            this.kWq.add(p.this.efr.getResources().getString(R.string.person_center_tab_dynamic));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.l(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.m(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.k(p.this.mUserId, p.this.mIsHost));
        }

        public void Fy(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.kWq.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
                if (i2 == i) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return FA(i);
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
            return Fz(i);
        }

        private String Fz(int i) {
            return this.kWq.get(i);
        }

        public PersonCenterTabBaseFragment FA(int i) {
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

        public void bGR() {
            if (!y.isEmpty(this.mFragments)) {
                for (int i = 0; i < this.mFragments.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.uN(false);
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

    private boolean bGl() {
        return this.lqU.getVisibility() == 0;
    }

    public void bGm() {
        if (!bGl() && this.lrb == null) {
            this.lqU.setVisibility(0);
            if (this.lrb == null) {
                this.lrb = new AlphaAnimation(0.0f, 1.0f);
                this.lrb.setFillAfter(true);
                this.lrb.setDuration(300L);
                this.lrb.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.14
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.lrb.reset();
                        p.this.lrb = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.lqU.startAnimation(this.lrb);
            }
        }
    }

    public void dju() {
        if (bGl() && this.lrc == null && this.lrc == null) {
            this.lrc = new AlphaAnimation(1.0f, 0.0f);
            this.lrc.setFillAfter(true);
            this.lrc.setDuration(300L);
            this.lrc.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.15
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.lqU.setVisibility(8);
                    p.this.lrc.reset();
                    p.this.lrc = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.lqU.startAnimation(this.lrc);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lre != null) {
            this.lre.onChangeSkinType(i);
        }
        if (this.hvT != null) {
            this.hvT.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
            this.hvT.setRectPaintColor(R.color.cp_link_tip_a);
            this.hvT.onChangeSkinType();
        }
        if (this.lqY != null) {
            this.lqY.setColor(ap.getColor(R.color.cp_bg_line_d));
        }
        if (this.lrd != null) {
            this.lrd.onChangeSkinType(i);
        }
        if (this.lqV != null) {
            this.lqV.onChangeSkinType(i);
        }
        if (this.fDZ != null) {
            this.fDZ.onChangeSkinType(this.efr, i);
        }
        if (this.hvf != null) {
            this.hvf.onChangeSkinType(this.efr, i);
        }
        ap.setBackgroundResource(this.lln, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.lqU, R.drawable.personalize_tab_shadow);
    }

    public void dij() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.lqL.resetData();
            this.lqL.refreshData();
            this.llw.doRefresh();
            return;
        }
        this.llw.csz();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        if (this.lre != null) {
            this.lre.setOnViewResponseListener(fVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.llL = aVar;
            this.lln.setVisibility(8);
            this.llq.setVisibility(0);
            if (this.lre != null) {
                this.lre.a(aVar, personStatus);
            }
            if (this.lrd != null) {
                this.lrd.b(aVar);
            }
            if (this.lqS != null) {
                this.lqS.e(this.llL.getUserData());
            }
            this.lqZ.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.2
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.lqW == 0) {
                        p.this.lqW = p.this.lqZ.getMeasuredHeight();
                        p.this.lqQ = p.this.lqZ.getMeasuredHeight() - p.this.lre.djr().getMeasuredHeight();
                        if (p.this.lqS != null) {
                            p.this.lrg = p.this.mStatusBarHeight + p.this.lre.djr().getMeasuredHeight() + p.this.lqZ.getMeasuredHeight() + p.this.hvT.getMeasuredHeight();
                            boolean z2 = (p.this.mIsHost || p.this.llL.getUserData() == null || p.this.llL.getUserData().getNewGodData() == null || !p.this.llL.getUserData().getNewGodData().isNewGod()) ? false : true;
                            p.this.lra.height = p.this.lrg;
                            p.this.lqZ.setLayoutParams(p.this.lra);
                            p.this.lrg += z2 ? com.baidu.tieba.personPolymeric.header.b.lnK : 0;
                            p.this.lqS.Ft(p.this.lrg);
                            p.this.lra.height = -2;
                            p.this.lqZ.setLayoutParams(p.this.lra);
                        }
                    }
                }
            });
            this.lqV.h(aVar);
            this.lqV.g(aVar);
            if (y.isEmpty(aVar.cAg())) {
                this.llw.bGU();
                com.baidu.adp.lib.util.l.showToast(this.efr.getContext(), this.efr.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.doT().vy(this.mIsHost);
            int size = aVar.cAg().size();
            for (int i = 0; i < size; i++) {
                q qVar = aVar.cAg().get(i);
                if (qVar != null && (qVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.llw.bGU();
                    return;
                }
            }
            if (!z) {
                this.llw.h(true, aVar.cAg());
            }
        }
    }

    public void csz() {
        this.llw.csz();
    }

    private void E(TbPageContext tbPageContext) {
        this.lqM = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).lLW;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.lrd != null && aVar != null) {
                            p.this.lrd.uK(aVar.cHF);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.llL != null) {
                            if (p.this.llL.lmA != null && p.this.llL.lmA.hEu != null && aVar2 != null) {
                                p.this.llL.lmA.hEu.putBoolean("person_center_item_red_tip_show", aVar2.cHF);
                            }
                            if (aVar3 != null && p.this.llL.lmz != null && p.this.llL.lmz.hEu != null) {
                                p.this.llL.lmz.hEu.putBoolean("person_center_item_red_tip_show", aVar3.cHF);
                            }
                            if (aVar4 != null && p.this.llL.lmy != null && p.this.llL.lmy.hEu != null) {
                                p.this.llL.lmy.hEu.putBoolean("person_center_item_red_tip_show", aVar4.cHF);
                            }
                            if (aVar5 != null && p.this.llL.lmB != null && p.this.llL.lmB.hEu != null) {
                                p.this.llL.lmB.hEu.putBoolean("person_center_item_red_tip_show", aVar5.cHF);
                            }
                            if (aVar6 != null && p.this.llL.lmC != null && p.this.llL.lmC.hEu != null) {
                                p.this.llL.lmC.hEu.putBoolean("person_center_item_red_tip_show", aVar6.cHF);
                                p.this.llL.lmC.hEu.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.lqM.setTag(this.ahM);
        tbPageContext.registerListener(this.lqM);
        this.mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.l lVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null) {
                    p.this.lrd.OB(lVar.bcA());
                }
            }
        };
        this.mUpdatePendantListener.setTag(this.ahM);
        tbPageContext.registerListener(this.mUpdatePendantListener);
        this.lqN = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.lrf == ((Integer) customResponsedMessage.getData()).intValue() && p.this.iuK) {
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(p.this.iuU);
                    p.this.ctK();
                }
            }
        };
        this.lqN.setTag(this.ahM);
        tbPageContext.registerListener(this.lqN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctK() {
        this.lrf = -1;
        this.iuK = false;
        if (this.lqR != null) {
            this.lqR.bkA();
        }
    }

    public void onDestory() {
        if (this.lrd != null) {
            this.lrd.onDestroy();
        }
        if (this.lqR != null) {
            this.lqR.onDestroy();
        }
        if (this.esJ != null) {
            this.esJ.cancel();
            this.esJ.removeAllListeners();
            this.esJ.removeAllUpdateListeners();
            this.esJ = null;
        }
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iuU);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.lqL = aVar;
    }
}
