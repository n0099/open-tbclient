package com.baidu.tieba.personPolymeric.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class p {
    public static int jLl = 5000;
    private static final float mFT = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout ZM;
    private BdUniqueId agC;
    private TbPageContext eUY;
    private CustomViewPager eZd;
    private BaseFragment fID;
    private ValueAnimator fjh;
    private NoNetworkView gAv;
    private PluginErrorTipView iIQ;
    private NewPagerSlidingTabBaseStrip iJF;
    private com.baidu.tieba.personPolymeric.c.a mAM;
    private CustomMessageListener mAccountChangedListener;
    private LinearLayout mAn;
    protected FrameLayout mAo;
    protected RelativeLayout mAq;
    private com.baidu.tieba.personPolymeric.b.f mAw;
    private com.baidu.tieba.model.a mFQ;
    private CustomMessageListener mFR;
    private CustomMessageListener mFS;
    private PullRefreshFrameLayout mFW;
    private com.baidu.tieba.personPolymeric.header.a mFX;
    private FrameLayout mFY;
    private View mFZ;
    private a mGa;
    private int mGb;
    private int mGc;
    private GradientDrawable mGd;
    private FrameLayout mGe;
    private FrameLayout.LayoutParams mGf;
    private AlphaAnimation mGg;
    private AlphaAnimation mGh;
    private com.baidu.tieba.personPolymeric.header.c mGi;
    private k mGj;
    private int mGm;
    private boolean mGn;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private CustomMessageListener mUpdatePendantListener;
    private long mUserId;
    private float[] mFU = {mFT, mFT, mFT, mFT, 0.0f, 0.0f, 0.0f, 0.0f};
    private float mFV = 674.0f;
    private boolean jLp = false;
    private int mGk = -1;
    private Runnable jLz = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.6
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.jLp) {
                p.this.cLI();
            }
        }
    };
    private com.baidu.tieba.personPolymeric.b.a mCV = new com.baidu.tieba.personPolymeric.b.a() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.tieba.personPolymeric.b.a
        public void CC(int i) {
            p.this.mGf.height = -2;
            p.this.mGe.setLayoutParams(p.this.mGf);
        }

        @Override // com.baidu.tieba.personPolymeric.b.a
        public void hS(boolean z) {
            p.this.mGn = z;
            if (!z) {
                p.this.mFX.Ha(p.this.mGm);
            }
            if (p.this.mGi != null && p.this.mGi.dzo() != null) {
                p.this.mGi.dzo().setOpen(z);
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.g gVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.fID = baseFragment;
        this.eUY = baseFragment.getPageContext();
        this.agC = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.mAw = gVar.dyx();
        am(gVar.mRootView);
    }

    private void am(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.mFW = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.mFX = new com.baidu.tieba.personPolymeric.header.a(this.eUY, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.mGj = new k(this.eUY, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.mGe = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.mGf = (FrameLayout.LayoutParams) this.mGe.getLayoutParams();
        this.mFW.setOnTouchCallback(new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void q(double d) {
                p.this.mGf.height = (int) ((p.this.mGn ? com.baidu.tieba.personPolymeric.header.b.mCQ : 0) + p.this.mGb + (PullRefreshFrameLayout.fiL * d));
                p.this.mGe.setLayoutParams(p.this.mGf);
                if (p.this.mFX != null) {
                    p.this.mFX.x(d);
                }
                p.this.mFW.buk();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void b(final int i, double d) {
                p.this.fjh = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.fjh.setDuration(150L);
                final int measuredHeight = p.this.mGe.getMeasuredHeight();
                final int cDt = p.this.mFX.cDt();
                p.this.fjh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.mGf.height = (int) (measuredHeight - (i * animatedFraction));
                        p.this.mGe.setLayoutParams(p.this.mGf);
                        if (p.this.mFX != null) {
                            p.this.mFX.Hb((int) (cDt - (animatedFraction * i)));
                        }
                    }
                });
                p.this.fjh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.mGc = p.this.mGf.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.fjh.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void bun() {
                final int measuredHeight = p.this.mGe.getMeasuredHeight();
                final int i = (measuredHeight - p.this.mGb) - (p.this.mGn ? com.baidu.tieba.personPolymeric.header.b.mCQ : 0);
                final int cDt = p.this.mFX != null ? p.this.mFX.cDt() : 0;
                if (p.this.mGn) {
                    p.this.mGi.wV(false);
                    p.this.mGi.dyP();
                }
                if (i > 0 || (i == 0 && p.this.mGn)) {
                    p.this.fjh = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.fjh.setDuration(300L);
                    p.this.fjh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.mGf.height = (int) (measuredHeight - (i * floatValue));
                            p.this.mGe.setLayoutParams(p.this.mGf);
                            if (p.this.mFX != null && cDt > 0) {
                                p.this.mFX.Hb((int) (cDt - (floatValue * i)));
                            }
                        }
                    });
                    p.this.fjh.start();
                    p.this.fjh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (p.this.mGn) {
                                p.this.mGi.dyQ();
                            }
                            p.this.mGc = 0;
                            p.this.mGf.height = -2;
                            p.this.mGe.setLayoutParams(p.this.mGf);
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
        this.mFW.setOnPullRefreshListener(new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.personPolymeric.view.p.8
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bum() {
                com.baidu.adp.lib.f.e.mA().postDelayed(p.this.jLz, p.jLl);
                p.this.jLp = true;
                p.this.mGk = p.this.mGa.getCurrentTabType();
                p.this.dyo();
                p.this.mGa.bSx();
            }
        });
        this.mFW.setOnCancelCallBack(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void onCancel() {
                p.this.mGc = 0;
                p.this.mGf.height = -2;
                p.this.mGe.setLayoutParams(p.this.mGf);
            }
        });
        this.mFW.setOnLoadingStartCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.10
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void bul() {
                p.this.mGf.height = -2;
                p.this.mGe.setLayoutParams(p.this.mGf);
            }
        });
        this.ZM = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.ZM.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.11
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.eUY.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.eUY.getPageActivity());
                }
                p.this.mFW.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.mGj.xb(abs == 0);
                p.this.mGj.xc(((float) abs) > p.this.mFV / 2.0f);
                float abs2 = ((double) p.this.mFV) == 0.0d ? 0.0f : Math.abs(abs / p.this.mFV);
                p.this.mGj.aX(abs2);
                if (abs2 >= 1.0f) {
                    p.this.mFU = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mGd.setCornerRadii(p.this.mFU);
                    p.this.mFY.setBackgroundDrawable(p.this.mGd);
                    p.this.bRQ();
                } else {
                    p.this.mFU = new float[]{p.mFT, p.mFT, p.mFT, p.mFT, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mGd.setCornerRadii(p.this.mFU);
                    p.this.mFY.setBackgroundDrawable(p.this.mGd);
                    p.this.dzB();
                }
                int i2 = p.this.mGc - p.this.mGb;
                if (p.this.mGc > 0 && Math.abs(i) >= i2) {
                    p.this.mFW.dismissLoading();
                }
            }
        });
        this.mFY = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.iJF = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.iJF.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        this.iJF.setRectPaintColor(R.color.CAM_X0302);
        this.iJF.a(com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds46), true);
        this.iJF.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds64));
        this.iJF.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds8));
        this.iJF.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds8));
        this.iJF.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds0));
        this.iJF.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds166), -1));
        this.iJF.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.12
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.mGa.Hf(i);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.mGd = new GradientDrawable();
        this.mGd.setColor(ap.getColor(R.color.CAM_X0201));
        this.mGd.setCornerRadii(this.mFU);
        this.mFY.setBackgroundDrawable(this.mGd);
        this.mFZ = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        ap.setBackgroundResource(this.mFZ, R.drawable.personalize_tab_shadow);
        this.eZd = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.mGa = new a(this.fID.getActivity().getSupportFragmentManager());
        this.eZd.setAdapter(this.mGa);
        this.eZd.setOffscreenPageLimit(this.mGa.mFragments.size());
        this.mGa.notifyDataSetChanged();
        this.iJF.setViewPager(this.eZd);
        this.eZd.setCurrentItem(1);
        this.mGi = new com.baidu.tieba.personPolymeric.header.c(this.eUY, this.mIsHost);
        this.mGi.a(this.mCV);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.mGe.addView(this.mGi.getView(), layoutParams);
        if (this.mGj.dzz()) {
            H(this.eUY);
        }
        G(this.eUY);
        this.gAv = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.iIQ = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.mAn = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.mAo = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.mAq = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void G(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.mGj != null) {
                    p.this.mGj.dzx();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.agC);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c dzA() {
        return this.mGi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends FragmentPagerAdapter {
        private List<PersonCenterTabBaseFragment> mFragments;
        private List<String> mla;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mla = new ArrayList();
            this.mla.add(p.this.eUY.getResources().getString(R.string.person_center_tab_main));
            this.mla.add(p.this.eUY.getResources().getString(R.string.person_center_tab_thread));
            this.mla.add(p.this.eUY.getResources().getString(R.string.person_center_tab_dynamic));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.q(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.r(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.p(p.this.mUserId, p.this.mIsHost));
        }

        public void Hf(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.mla.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
                if (i2 == i) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return Hh(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (this.mFragments != null) {
                return this.mFragments.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return Hg(i);
        }

        private String Hg(int i) {
            return this.mla.get(i);
        }

        public PersonCenterTabBaseFragment Hh(int i) {
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

        public void bSx() {
            if (!y.isEmpty(this.mFragments)) {
                for (int i = 0; i < this.mFragments.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.wX(false);
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
                            personCenterTabBaseFragment.a(aVar.eRz);
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

    private boolean bRP() {
        return this.mFZ.getVisibility() == 0;
    }

    public void bRQ() {
        if (!bRP() && this.mGg == null) {
            this.mFZ.setVisibility(0);
            if (this.mGg == null) {
                this.mGg = new AlphaAnimation(0.0f, 1.0f);
                this.mGg.setFillAfter(true);
                this.mGg.setDuration(300L);
                this.mGg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.14
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.mGg.reset();
                        p.this.mGg = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.mFZ.startAnimation(this.mGg);
            }
        }
    }

    public void dzB() {
        if (bRP() && this.mGh == null && this.mGh == null) {
            this.mGh = new AlphaAnimation(1.0f, 0.0f);
            this.mGh.setFillAfter(true);
            this.mGh.setDuration(300L);
            this.mGh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.15
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.mFZ.setVisibility(8);
                    p.this.mGh.reset();
                    p.this.mGh = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mFZ.startAnimation(this.mGh);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mGj != null) {
            this.mGj.onChangeSkinType(i);
        }
        if (this.iJF != null) {
            this.iJF.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.iJF.setRectPaintColor(R.color.CAM_X0302);
            this.iJF.onChangeSkinType();
        }
        if (this.mGd != null) {
            this.mGd.setColor(ap.getColor(R.color.CAM_X0201));
        }
        if (this.mGi != null) {
            this.mGi.onChangeSkinType(i);
        }
        if (this.mGa != null) {
            this.mGa.onChangeSkinType(i);
        }
        if (this.gAv != null) {
            this.gAv.onChangeSkinType(this.eUY, i);
        }
        if (this.iIQ != null) {
            this.iIQ.onChangeSkinType(this.eUY, i);
        }
        ap.setBackgroundResource(this.mAn, R.color.CAM_X0201);
        ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
        ap.setBackgroundResource(this.mFZ, R.drawable.personalize_tab_shadow);
    }

    public void dyo() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.mFQ.resetData();
            this.mFQ.refreshData();
            this.mAw.doRefresh();
            return;
        }
        this.mAw.cKp();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        if (this.mGj != null) {
            this.mGj.setOnViewResponseListener(fVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.mAM = aVar;
            this.mAn.setVisibility(8);
            this.mAq.setVisibility(0);
            if (this.mGj != null) {
                this.mGj.a(aVar, personStatus);
            }
            if (this.mGi != null) {
                this.mGi.b(aVar);
            }
            if (this.mFX != null) {
                this.mFX.d(this.mAM.getUserData());
            }
            this.mGe.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.2
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.mGb == 0) {
                        p.this.mGb = p.this.mGe.getMeasuredHeight();
                        p.this.mFV = p.this.mGe.getMeasuredHeight() - p.this.mGj.dzy().getMeasuredHeight();
                        if (p.this.mFX != null) {
                            p.this.mGm = p.this.mStatusBarHeight + p.this.mGj.dzy().getMeasuredHeight() + p.this.mGe.getMeasuredHeight() + p.this.iJF.getMeasuredHeight();
                            boolean z2 = (p.this.mIsHost || p.this.mAM.getUserData() == null || p.this.mAM.getUserData().getNewGodData() == null || !p.this.mAM.getUserData().getNewGodData().isNewGod()) ? false : true;
                            p.this.mGf.height = p.this.mGm;
                            p.this.mGe.setLayoutParams(p.this.mGf);
                            p.this.mGm += z2 ? com.baidu.tieba.personPolymeric.header.b.mCQ : 0;
                            p.this.mFX.Ha(p.this.mGm);
                            p.this.mGf.height = -2;
                            p.this.mGe.setLayoutParams(p.this.mGf);
                        }
                    }
                }
            });
            this.mGa.h(aVar);
            this.mGa.g(aVar);
            if (y.isEmpty(aVar.cTv())) {
                this.mAw.bSy();
                com.baidu.adp.lib.util.l.showToast(this.eUY.getContext(), this.eUY.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.dFe().xK(this.mIsHost);
            int size = aVar.cTv().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.n nVar = aVar.cTv().get(i);
                if (nVar != null && (nVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.mAw.bSy();
                    return;
                }
            }
            if (!z) {
                this.mAw.h(true, aVar.cTv());
            }
        }
    }

    public void cKp() {
        this.mAw.cKp();
    }

    private void H(TbPageContext tbPageContext) {
        this.mFR = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).nch;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.mGi != null && aVar != null) {
                            p.this.mGi.wU(aVar.drR);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.mAM != null) {
                            if (p.this.mAM.mBC != null && p.this.mAM.mBC.iRZ != null && aVar2 != null) {
                                p.this.mAM.mBC.iRZ.putBoolean("person_center_item_red_tip_show", aVar2.drR);
                            }
                            if (aVar3 != null && p.this.mAM.mBB != null && p.this.mAM.mBB.iRZ != null) {
                                p.this.mAM.mBB.iRZ.putBoolean("person_center_item_red_tip_show", aVar3.drR);
                            }
                            if (aVar4 != null && p.this.mAM.mBA != null && p.this.mAM.mBA.iRZ != null) {
                                p.this.mAM.mBA.iRZ.putBoolean("person_center_item_red_tip_show", aVar4.drR);
                            }
                            if (aVar5 != null && p.this.mAM.mBD != null && p.this.mAM.mBD.iRZ != null) {
                                p.this.mAM.mBD.iRZ.putBoolean("person_center_item_red_tip_show", aVar5.drR);
                            }
                            if (aVar6 != null && p.this.mAM.mBE != null && p.this.mAM.mBE.iRZ != null) {
                                p.this.mAM.mBE.iRZ.putBoolean("person_center_item_red_tip_show", aVar6.drR);
                                p.this.mAM.mBE.iRZ.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.mFR.setTag(this.agC);
        tbPageContext.registerListener(this.mFR);
        this.mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.n nVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n) && (nVar = (com.baidu.tbadk.data.n) customResponsedMessage.getData()) != null) {
                    p.this.mGi.QA(nVar.getImgUrl());
                }
            }
        };
        this.mUpdatePendantListener.setTag(this.agC);
        tbPageContext.registerListener(this.mUpdatePendantListener);
        this.mFS = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.mGk == ((Integer) customResponsedMessage.getData()).intValue() && p.this.jLp) {
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(p.this.jLz);
                    p.this.cLI();
                }
            }
        };
        this.mFS.setTag(this.agC);
        tbPageContext.registerListener(this.mFS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLI() {
        this.mGk = -1;
        this.jLp = false;
        if (this.mFW != null) {
            this.mFW.bui();
        }
    }

    public void onDestory() {
        if (this.mGi != null) {
            this.mGi.onDestroy();
        }
        if (this.mFW != null) {
            this.mFW.onDestroy();
        }
        if (this.fjh != null) {
            this.fjh.cancel();
            this.fjh.removeAllListeners();
            this.fjh.removeAllUpdateListeners();
            this.fjh = null;
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jLz);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.mFQ = aVar;
    }
}
