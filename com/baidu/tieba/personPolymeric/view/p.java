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
/* loaded from: classes24.dex */
public class p {
    public static int jdo = 5000;
    private static final float mbu = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout Yh;
    private BdUniqueId aiz;
    private TbPageContext eCn;
    private CustomViewPager eFw;
    private ValueAnimator ePu;
    private BaseFragment foC;
    private NoNetworkView gdx;
    private PluginErrorTipView idG;
    private NewPagerSlidingTabBaseStrip ieu;
    private LinearLayout lVS;
    protected FrameLayout lVT;
    protected RelativeLayout lVV;
    private com.baidu.tieba.personPolymeric.b.f lWb;
    private com.baidu.tieba.personPolymeric.c.a lWq;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private CustomMessageListener mUpdatePendantListener;
    private long mUserId;
    private View mbA;
    private a mbB;
    private int mbC;
    private int mbD;
    private GradientDrawable mbE;
    private FrameLayout mbF;
    private FrameLayout.LayoutParams mbG;
    private AlphaAnimation mbH;
    private AlphaAnimation mbI;
    private com.baidu.tieba.personPolymeric.header.c mbJ;
    private k mbK;
    private int mbM;
    private boolean mbN;
    private com.baidu.tieba.model.a mbr;
    private CustomMessageListener mbs;
    private CustomMessageListener mbt;
    private PullRefreshFrameLayout mbx;
    private com.baidu.tieba.personPolymeric.header.a mby;
    private FrameLayout mbz;
    private float[] mbv = {mbu, mbu, mbu, mbu, 0.0f, 0.0f, 0.0f, 0.0f};
    private float mbw = 674.0f;
    private boolean jds = false;
    private int mbL = -1;
    private Runnable jdC = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.6
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.jds) {
                p.this.cDG();
            }
        }
    };
    private com.baidu.tieba.personPolymeric.b.a lYx = new com.baidu.tieba.personPolymeric.b.a() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.tieba.personPolymeric.b.a
        public void Cd(int i) {
            p.this.mbG.height = -2;
            p.this.mbF.setLayoutParams(p.this.mbG);
        }

        @Override // com.baidu.tieba.personPolymeric.b.a
        public void hb(boolean z) {
            p.this.mbN = z;
            if (!z) {
                p.this.mby.GT(p.this.mbM);
            }
            if (p.this.mbJ != null && p.this.mbJ.dtF() != null) {
                p.this.mbJ.dtF().setOpen(z);
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.g gVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.foC = baseFragment;
        this.eCn = baseFragment.getPageContext();
        this.aiz = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.lWb = gVar.dsO();
        ah(gVar.mRootView);
    }

    private void ah(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.mbx = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.mby = new com.baidu.tieba.personPolymeric.header.a(this.eCn, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.mbK = new k(this.eCn, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.mbF = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.mbG = (FrameLayout.LayoutParams) this.mbF.getLayoutParams();
        this.mbx.setOnTouchCallback(new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void x(double d) {
                p.this.mbG.height = (int) ((p.this.mbN ? com.baidu.tieba.personPolymeric.header.b.lYs : 0) + p.this.mbC + (PullRefreshFrameLayout.ePa * d));
                p.this.mbF.setLayoutParams(p.this.mbG);
                if (p.this.mby != null) {
                    p.this.mby.D(d);
                }
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                p.this.ePu = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.ePu.setDuration(150L);
                final int measuredHeight = p.this.mbF.getMeasuredHeight();
                final int cwB = p.this.mby.cwB();
                p.this.ePu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.mbG.height = (int) (measuredHeight - (i * animatedFraction));
                        p.this.mbF.setLayoutParams(p.this.mbG);
                        if (p.this.mby != null) {
                            p.this.mby.GU((int) (cwB - (animatedFraction * i)));
                        }
                    }
                });
                p.this.ePu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.mbD = p.this.mbG.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.ePu.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void bqc() {
                final int measuredHeight = p.this.mbF.getMeasuredHeight();
                final int i = (measuredHeight - p.this.mbC) - (p.this.mbN ? com.baidu.tieba.personPolymeric.header.b.lYs : 0);
                final int cwB = p.this.mby != null ? p.this.mby.cwB() : 0;
                if (p.this.mbN) {
                    p.this.mbJ.vR(false);
                    p.this.mbJ.dtg();
                }
                if (i > 0 || (i == 0 && p.this.mbN)) {
                    p.this.ePu = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.ePu.setDuration(300L);
                    p.this.ePu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.mbG.height = (int) (measuredHeight - (i * floatValue));
                            p.this.mbF.setLayoutParams(p.this.mbG);
                            if (p.this.mby != null && cwB > 0) {
                                p.this.mby.GU((int) (cwB - (floatValue * i)));
                            }
                        }
                    });
                    p.this.ePu.start();
                    p.this.ePu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (p.this.mbN) {
                                p.this.mbJ.dth();
                            }
                            p.this.mbD = 0;
                            p.this.mbG.height = -2;
                            p.this.mbF.setLayoutParams(p.this.mbG);
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
        this.mbx.setOnPullRefreshListener(new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.personPolymeric.view.p.8
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bqb() {
                com.baidu.adp.lib.f.e.mY().postDelayed(p.this.jdC, p.jdo);
                p.this.jds = true;
                p.this.mbL = p.this.mbB.getCurrentTabType();
                p.this.dsF();
                p.this.mbB.bNv();
            }
        });
        this.mbx.setOnCancelCallBack(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void onCancel() {
                p.this.mbD = 0;
                p.this.mbG.height = -2;
                p.this.mbF.setLayoutParams(p.this.mbG);
            }
        });
        this.mbx.setOnLoadingStartCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.10
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void bqa() {
                p.this.mbG.height = -2;
                p.this.mbF.setLayoutParams(p.this.mbG);
            }
        });
        this.Yh = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.Yh.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.11
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.eCn.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.eCn.getPageActivity());
                }
                p.this.mbx.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.mbK.vX(abs == 0);
                p.this.mbK.vY(((float) abs) > p.this.mbw / 2.0f);
                float abs2 = ((double) p.this.mbw) == 0.0d ? 0.0f : Math.abs(abs / p.this.mbw);
                p.this.mbK.aI(abs2);
                if (abs2 >= 1.0f) {
                    p.this.mbv = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mbE.setCornerRadii(p.this.mbv);
                    p.this.mbz.setBackgroundDrawable(p.this.mbE);
                    p.this.bMQ();
                } else {
                    p.this.mbv = new float[]{p.mbu, p.mbu, p.mbu, p.mbu, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mbE.setCornerRadii(p.this.mbv);
                    p.this.mbz.setBackgroundDrawable(p.this.mbE);
                    p.this.dtS();
                }
                int i2 = p.this.mbD - p.this.mbC;
                if (p.this.mbD > 0 && Math.abs(i) >= i2) {
                    p.this.mbx.dismissLoading();
                }
            }
        });
        this.mbz = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.ieu = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.ieu.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.ieu.setRectPaintColor(R.color.cp_link_tip_a);
        this.ieu.a(com.baidu.adp.lib.util.l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds46), true);
        this.ieu.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds64));
        this.ieu.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds8));
        this.ieu.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds8));
        this.ieu.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds0));
        this.ieu.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds166), -1));
        this.ieu.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.12
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.mbB.GY(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.mbE = new GradientDrawable();
        this.mbE.setColor(ap.getColor(R.color.cp_bg_line_d));
        this.mbE.setCornerRadii(this.mbv);
        this.mbz.setBackgroundDrawable(this.mbE);
        this.mbA = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        ap.setBackgroundResource(this.mbA, R.drawable.personalize_tab_shadow);
        this.eFw = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.mbB = new a(this.foC.getActivity().getSupportFragmentManager());
        this.eFw.setAdapter(this.mbB);
        this.eFw.setOffscreenPageLimit(this.mbB.mFragments.size());
        this.mbB.notifyDataSetChanged();
        this.ieu.setViewPager(this.eFw);
        this.eFw.setCurrentItem(1);
        this.mbJ = new com.baidu.tieba.personPolymeric.header.c(this.eCn, this.mIsHost);
        this.mbJ.a(this.lYx);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.mbF.addView(this.mbJ.getView(), layoutParams);
        if (this.mbK.dtQ()) {
            E(this.eCn);
        }
        D(this.eCn);
        this.gdx = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.idG = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.lVS = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.lVT = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.lVV = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void D(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.mbK != null) {
                    p.this.mbK.dtO();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.aiz);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c dtR() {
        return this.mbJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a extends FragmentPagerAdapter {
        private List<String> lGK;
        private List<PersonCenterTabBaseFragment> mFragments;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.lGK = new ArrayList();
            this.lGK.add(p.this.eCn.getResources().getString(R.string.person_center_tab_main));
            this.lGK.add(p.this.eCn.getResources().getString(R.string.person_center_tab_thread));
            this.lGK.add(p.this.eCn.getResources().getString(R.string.person_center_tab_dynamic));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.o(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.p(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.n(p.this.mUserId, p.this.mIsHost));
        }

        public void GY(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.lGK.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
                if (i2 == i) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return Ha(i);
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
            return GZ(i);
        }

        private String GZ(int i) {
            return this.lGK.get(i);
        }

        public PersonCenterTabBaseFragment Ha(int i) {
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

        public void bNv() {
            if (!y.isEmpty(this.mFragments)) {
                for (int i = 0; i < this.mFragments.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.vT(false);
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
                            personCenterTabBaseFragment.a(aVar.eyV);
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

    private boolean bMP() {
        return this.mbA.getVisibility() == 0;
    }

    public void bMQ() {
        if (!bMP() && this.mbH == null) {
            this.mbA.setVisibility(0);
            if (this.mbH == null) {
                this.mbH = new AlphaAnimation(0.0f, 1.0f);
                this.mbH.setFillAfter(true);
                this.mbH.setDuration(300L);
                this.mbH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.14
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.mbH.reset();
                        p.this.mbH = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.mbA.startAnimation(this.mbH);
            }
        }
    }

    public void dtS() {
        if (bMP() && this.mbI == null && this.mbI == null) {
            this.mbI = new AlphaAnimation(1.0f, 0.0f);
            this.mbI.setFillAfter(true);
            this.mbI.setDuration(300L);
            this.mbI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.15
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.mbA.setVisibility(8);
                    p.this.mbI.reset();
                    p.this.mbI = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mbA.startAnimation(this.mbI);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mbK != null) {
            this.mbK.onChangeSkinType(i);
        }
        if (this.ieu != null) {
            this.ieu.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
            this.ieu.setRectPaintColor(R.color.cp_link_tip_a);
            this.ieu.onChangeSkinType();
        }
        if (this.mbE != null) {
            this.mbE.setColor(ap.getColor(R.color.cp_bg_line_d));
        }
        if (this.mbJ != null) {
            this.mbJ.onChangeSkinType(i);
        }
        if (this.mbB != null) {
            this.mbB.onChangeSkinType(i);
        }
        if (this.gdx != null) {
            this.gdx.onChangeSkinType(this.eCn, i);
        }
        if (this.idG != null) {
            this.idG.onChangeSkinType(this.eCn, i);
        }
        ap.setBackgroundResource(this.lVS, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.mbA, R.drawable.personalize_tab_shadow);
    }

    public void dsF() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.mbr.resetData();
            this.mbr.refreshData();
            this.lWb.doRefresh();
            return;
        }
        this.lWb.cCs();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        if (this.mbK != null) {
            this.mbK.setOnViewResponseListener(fVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.lWq = aVar;
            this.lVS.setVisibility(8);
            this.lVV.setVisibility(0);
            if (this.mbK != null) {
                this.mbK.a(aVar, personStatus);
            }
            if (this.mbJ != null) {
                this.mbJ.b(aVar);
            }
            if (this.mby != null) {
                this.mby.e(this.lWq.getUserData());
            }
            this.mbF.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.2
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.mbC == 0) {
                        p.this.mbC = p.this.mbF.getMeasuredHeight();
                        p.this.mbw = p.this.mbF.getMeasuredHeight() - p.this.mbK.dtP().getMeasuredHeight();
                        if (p.this.mby != null) {
                            p.this.mbM = p.this.mStatusBarHeight + p.this.mbK.dtP().getMeasuredHeight() + p.this.mbF.getMeasuredHeight() + p.this.ieu.getMeasuredHeight();
                            boolean z2 = (p.this.mIsHost || p.this.lWq.getUserData() == null || p.this.lWq.getUserData().getNewGodData() == null || !p.this.lWq.getUserData().getNewGodData().isNewGod()) ? false : true;
                            p.this.mbG.height = p.this.mbM;
                            p.this.mbF.setLayoutParams(p.this.mbG);
                            p.this.mbM += z2 ? com.baidu.tieba.personPolymeric.header.b.lYs : 0;
                            p.this.mby.GT(p.this.mbM);
                            p.this.mbG.height = -2;
                            p.this.mbF.setLayoutParams(p.this.mbG);
                        }
                    }
                }
            });
            this.mbB.h(aVar);
            this.mbB.g(aVar);
            if (y.isEmpty(aVar.cKD())) {
                this.lWb.bNw();
                com.baidu.adp.lib.util.l.showToast(this.eCn.getContext(), this.eCn.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.dzw().wE(this.mIsHost);
            int size = aVar.cKD().size();
            for (int i = 0; i < size; i++) {
                q qVar = aVar.cKD().get(i);
                if (qVar != null && (qVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.lWb.bNw();
                    return;
                }
            }
            if (!z) {
                this.lWb.g(true, aVar.cKD());
            }
        }
    }

    public void cCs() {
        this.lWb.cCs();
    }

    private void E(TbPageContext tbPageContext) {
        this.mbs = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).mwY;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.mbJ != null && aVar != null) {
                            p.this.mbJ.vQ(aVar.dei);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.lWq != null) {
                            if (p.this.lWq.lXf != null && p.this.lWq.lXf.imS != null && aVar2 != null) {
                                p.this.lWq.lXf.imS.putBoolean("person_center_item_red_tip_show", aVar2.dei);
                            }
                            if (aVar3 != null && p.this.lWq.lXe != null && p.this.lWq.lXe.imS != null) {
                                p.this.lWq.lXe.imS.putBoolean("person_center_item_red_tip_show", aVar3.dei);
                            }
                            if (aVar4 != null && p.this.lWq.lXd != null && p.this.lWq.lXd.imS != null) {
                                p.this.lWq.lXd.imS.putBoolean("person_center_item_red_tip_show", aVar4.dei);
                            }
                            if (aVar5 != null && p.this.lWq.lXg != null && p.this.lWq.lXg.imS != null) {
                                p.this.lWq.lXg.imS.putBoolean("person_center_item_red_tip_show", aVar5.dei);
                            }
                            if (aVar6 != null && p.this.lWq.lXh != null && p.this.lWq.lXh.imS != null) {
                                p.this.lWq.lXh.imS.putBoolean("person_center_item_red_tip_show", aVar6.dei);
                                p.this.lWq.lXh.imS.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.mbs.setTag(this.aiz);
        tbPageContext.registerListener(this.mbs);
        this.mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.m mVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && (mVar = (com.baidu.tbadk.data.m) customResponsedMessage.getData()) != null) {
                    p.this.mbJ.Qp(mVar.bhW());
                }
            }
        };
        this.mUpdatePendantListener.setTag(this.aiz);
        tbPageContext.registerListener(this.mUpdatePendantListener);
        this.mbt = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.mbL == ((Integer) customResponsedMessage.getData()).intValue() && p.this.jds) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(p.this.jdC);
                    p.this.cDG();
                }
            }
        };
        this.mbt.setTag(this.aiz);
        tbPageContext.registerListener(this.mbt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDG() {
        this.mbL = -1;
        this.jds = false;
        if (this.mbx != null) {
            this.mbx.bpY();
        }
    }

    public void onDestory() {
        if (this.mbJ != null) {
            this.mbJ.onDestroy();
        }
        if (this.mbx != null) {
            this.mbx.onDestroy();
        }
        if (this.ePu != null) {
            this.ePu.cancel();
            this.ePu.removeAllListeners();
            this.ePu.removeAllUpdateListeners();
            this.ePu = null;
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jdC);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.mbr = aVar;
    }
}
