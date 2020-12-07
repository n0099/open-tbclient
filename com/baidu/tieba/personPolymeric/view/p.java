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
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterMainTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment;
import com.baidu.tieba.q.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class p {
    public static int jxA = 5000;
    private static final float mvQ = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout Zj;
    private BdUniqueId ajD;
    private TbPageContext eNx;
    private CustomViewPager eRw;
    private BaseFragment fBs;
    private ValueAnimator fbQ;
    private NoNetworkView grd;
    private NewPagerSlidingTabBaseStrip ivZ;
    private PluginErrorTipView ivk;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private CustomMessageListener mUpdatePendantListener;
    private long mUserId;
    private com.baidu.tieba.personPolymeric.c.a mqN;
    private LinearLayout mqp;
    protected FrameLayout mqq;
    protected RelativeLayout mqs;
    private com.baidu.tieba.personPolymeric.b.f mqy;
    private com.baidu.tieba.model.a mvN;
    private CustomMessageListener mvO;
    private CustomMessageListener mvP;
    private PullRefreshFrameLayout mvT;
    private com.baidu.tieba.personPolymeric.header.a mvU;
    private FrameLayout mvV;
    private View mvW;
    private a mvX;
    private int mvY;
    private int mvZ;
    private GradientDrawable mwa;
    private FrameLayout mwb;
    private FrameLayout.LayoutParams mwc;
    private AlphaAnimation mwd;
    private AlphaAnimation mwe;
    private com.baidu.tieba.personPolymeric.header.c mwf;
    private k mwg;
    private int mwi;
    private boolean mwj;
    private float[] mvR = {mvQ, mvQ, mvQ, mvQ, 0.0f, 0.0f, 0.0f, 0.0f};
    private float mvS = 674.0f;
    private boolean jxE = false;
    private int mwh = -1;
    private Runnable jxO = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.6
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.jxE) {
                p.this.cLc();
            }
        }
    };
    private com.baidu.tieba.personPolymeric.b.a msV = new com.baidu.tieba.personPolymeric.b.a() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.tieba.personPolymeric.b.a
        public void DD(int i) {
            p.this.mwc.height = -2;
            p.this.mwb.setLayoutParams(p.this.mwc);
        }

        @Override // com.baidu.tieba.personPolymeric.b.a
        public void hC(boolean z) {
            p.this.mwj = z;
            if (!z) {
                p.this.mvU.Iv(p.this.mwi);
            }
            if (p.this.mwf != null && p.this.mwf.dAZ() != null) {
                p.this.mwf.dAZ().setOpen(z);
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.g gVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.fBs = baseFragment;
        this.eNx = baseFragment.getPageContext();
        this.ajD = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.mqy = gVar.dAi();
        an(gVar.mRootView);
    }

    private void an(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.mvT = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.mvU = new com.baidu.tieba.personPolymeric.header.a(this.eNx, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.mwg = new k(this.eNx, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.mwb = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.mwc = (FrameLayout.LayoutParams) this.mwb.getLayoutParams();
        this.mvT.setOnTouchCallback(new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void w(double d) {
                p.this.mwc.height = (int) ((p.this.mwj ? com.baidu.tieba.personPolymeric.header.b.msQ : 0) + p.this.mvY + (PullRefreshFrameLayout.fbu * d));
                p.this.mwb.setLayoutParams(p.this.mwc);
                if (p.this.mvU != null) {
                    p.this.mvU.E(d);
                }
                p.this.mvT.bvo();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                p.this.fbQ = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.fbQ.setDuration(150L);
                final int measuredHeight = p.this.mwb.getMeasuredHeight();
                final int cCW = p.this.mvU.cCW();
                p.this.fbQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.mwc.height = (int) (measuredHeight - (i * animatedFraction));
                        p.this.mwb.setLayoutParams(p.this.mwc);
                        if (p.this.mvU != null) {
                            p.this.mvU.Iw((int) (cCW - (animatedFraction * i)));
                        }
                    }
                });
                p.this.fbQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.mvZ = p.this.mwc.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.fbQ.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void bvr() {
                final int measuredHeight = p.this.mwb.getMeasuredHeight();
                final int i = (measuredHeight - p.this.mvY) - (p.this.mwj ? com.baidu.tieba.personPolymeric.header.b.msQ : 0);
                final int cCW = p.this.mvU != null ? p.this.mvU.cCW() : 0;
                if (p.this.mwj) {
                    p.this.mwf.wH(false);
                    p.this.mwf.dAA();
                }
                if (i > 0 || (i == 0 && p.this.mwj)) {
                    p.this.fbQ = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.fbQ.setDuration(300L);
                    p.this.fbQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.mwc.height = (int) (measuredHeight - (i * floatValue));
                            p.this.mwb.setLayoutParams(p.this.mwc);
                            if (p.this.mvU != null && cCW > 0) {
                                p.this.mvU.Iw((int) (cCW - (floatValue * i)));
                            }
                        }
                    });
                    p.this.fbQ.start();
                    p.this.fbQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (p.this.mwj) {
                                p.this.mwf.dAB();
                            }
                            p.this.mvZ = 0;
                            p.this.mwc.height = -2;
                            p.this.mwb.setLayoutParams(p.this.mwc);
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
        this.mvT.setOnPullRefreshListener(new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.personPolymeric.view.p.8
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bvq() {
                com.baidu.adp.lib.f.e.mY().postDelayed(p.this.jxO, p.jxA);
                p.this.jxE = true;
                p.this.mwh = p.this.mvX.getCurrentTabType();
                p.this.dzZ();
                p.this.mvX.bSZ();
            }
        });
        this.mvT.setOnCancelCallBack(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void onCancel() {
                p.this.mvZ = 0;
                p.this.mwc.height = -2;
                p.this.mwb.setLayoutParams(p.this.mwc);
            }
        });
        this.mvT.setOnLoadingStartCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.10
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void bvp() {
                p.this.mwc.height = -2;
                p.this.mwb.setLayoutParams(p.this.mwc);
            }
        });
        this.Zj = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.Zj.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.11
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.eNx.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.eNx.getPageActivity());
                }
                p.this.mvT.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.mwg.wN(abs == 0);
                p.this.mwg.wO(((float) abs) > p.this.mvS / 2.0f);
                float abs2 = ((double) p.this.mvS) == 0.0d ? 0.0f : Math.abs(abs / p.this.mvS);
                p.this.mwg.aS(abs2);
                if (abs2 >= 1.0f) {
                    p.this.mvR = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mwa.setCornerRadii(p.this.mvR);
                    p.this.mvV.setBackgroundDrawable(p.this.mwa);
                    p.this.bSu();
                } else {
                    p.this.mvR = new float[]{p.mvQ, p.mvQ, p.mvQ, p.mvQ, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mwa.setCornerRadii(p.this.mvR);
                    p.this.mvV.setBackgroundDrawable(p.this.mwa);
                    p.this.dBm();
                }
                int i2 = p.this.mvZ - p.this.mvY;
                if (p.this.mvZ > 0 && Math.abs(i) >= i2) {
                    p.this.mvT.dismissLoading();
                }
            }
        });
        this.mvV = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.ivZ = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.ivZ.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        this.ivZ.setRectPaintColor(R.color.CAM_X0302);
        this.ivZ.a(com.baidu.adp.lib.util.l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds46), true);
        this.ivZ.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds64));
        this.ivZ.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds8));
        this.ivZ.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds8));
        this.ivZ.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds0));
        this.ivZ.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds166), -1));
        this.ivZ.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.12
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.mvX.IA(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.mwa = new GradientDrawable();
        this.mwa.setColor(ap.getColor(R.color.CAM_X0201));
        this.mwa.setCornerRadii(this.mvR);
        this.mvV.setBackgroundDrawable(this.mwa);
        this.mvW = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        ap.setBackgroundResource(this.mvW, R.drawable.personalize_tab_shadow);
        this.eRw = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.mvX = new a(this.fBs.getActivity().getSupportFragmentManager());
        this.eRw.setAdapter(this.mvX);
        this.eRw.setOffscreenPageLimit(this.mvX.mFragments.size());
        this.mvX.notifyDataSetChanged();
        this.ivZ.setViewPager(this.eRw);
        this.eRw.setCurrentItem(1);
        this.mwf = new com.baidu.tieba.personPolymeric.header.c(this.eNx, this.mIsHost);
        this.mwf.a(this.msV);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.mwb.addView(this.mwf.getView(), layoutParams);
        if (this.mwg.dBk()) {
            E(this.eNx);
        }
        D(this.eNx);
        this.grd = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.ivk = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.mqp = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.mqq = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.mqs = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void D(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.mwg != null) {
                    p.this.mwg.dBi();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.ajD);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c dBl() {
        return this.mwf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a extends FragmentPagerAdapter {
        private List<PersonCenterTabBaseFragment> mFragments;
        private List<String> mba;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mba = new ArrayList();
            this.mba.add(p.this.eNx.getResources().getString(R.string.person_center_tab_main));
            this.mba.add(p.this.eNx.getResources().getString(R.string.person_center_tab_thread));
            this.mba.add(p.this.eNx.getResources().getString(R.string.person_center_tab_dynamic));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.o(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.p(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.n(p.this.mUserId, p.this.mIsHost));
        }

        public void IA(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.mba.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
                if (i2 == i) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return IC(i);
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
            return IB(i);
        }

        private String IB(int i) {
            return this.mba.get(i);
        }

        public PersonCenterTabBaseFragment IC(int i) {
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

        public void bSZ() {
            if (!y.isEmpty(this.mFragments)) {
                for (int i = 0; i < this.mFragments.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.wJ(false);
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
                            personCenterTabBaseFragment.a(aVar.eKe);
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

    private boolean bSt() {
        return this.mvW.getVisibility() == 0;
    }

    public void bSu() {
        if (!bSt() && this.mwd == null) {
            this.mvW.setVisibility(0);
            if (this.mwd == null) {
                this.mwd = new AlphaAnimation(0.0f, 1.0f);
                this.mwd.setFillAfter(true);
                this.mwd.setDuration(300L);
                this.mwd.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.14
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.mwd.reset();
                        p.this.mwd = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.mvW.startAnimation(this.mwd);
            }
        }
    }

    public void dBm() {
        if (bSt() && this.mwe == null && this.mwe == null) {
            this.mwe = new AlphaAnimation(1.0f, 0.0f);
            this.mwe.setFillAfter(true);
            this.mwe.setDuration(300L);
            this.mwe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.15
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.mvW.setVisibility(8);
                    p.this.mwe.reset();
                    p.this.mwe = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mvW.startAnimation(this.mwe);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mwg != null) {
            this.mwg.onChangeSkinType(i);
        }
        if (this.ivZ != null) {
            this.ivZ.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.ivZ.setRectPaintColor(R.color.CAM_X0302);
            this.ivZ.onChangeSkinType();
        }
        if (this.mwa != null) {
            this.mwa.setColor(ap.getColor(R.color.CAM_X0201));
        }
        if (this.mwf != null) {
            this.mwf.onChangeSkinType(i);
        }
        if (this.mvX != null) {
            this.mvX.onChangeSkinType(i);
        }
        if (this.grd != null) {
            this.grd.onChangeSkinType(this.eNx, i);
        }
        if (this.ivk != null) {
            this.ivk.onChangeSkinType(this.eNx, i);
        }
        ap.setBackgroundResource(this.mqp, R.color.CAM_X0201);
        ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
        ap.setBackgroundResource(this.mvW, R.drawable.personalize_tab_shadow);
    }

    public void dzZ() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.mvN.resetData();
            this.mvN.refreshData();
            this.mqy.doRefresh();
            return;
        }
        this.mqy.cJL();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        if (this.mwg != null) {
            this.mwg.setOnViewResponseListener(fVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.mqN = aVar;
            this.mqp.setVisibility(8);
            this.mqs.setVisibility(0);
            if (this.mwg != null) {
                this.mwg.a(aVar, personStatus);
            }
            if (this.mwf != null) {
                this.mwf.b(aVar);
            }
            if (this.mvU != null) {
                this.mvU.e(this.mqN.getUserData());
            }
            this.mwb.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.2
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.mvY == 0) {
                        p.this.mvY = p.this.mwb.getMeasuredHeight();
                        p.this.mvS = p.this.mwb.getMeasuredHeight() - p.this.mwg.dBj().getMeasuredHeight();
                        if (p.this.mvU != null) {
                            p.this.mwi = p.this.mStatusBarHeight + p.this.mwg.dBj().getMeasuredHeight() + p.this.mwb.getMeasuredHeight() + p.this.ivZ.getMeasuredHeight();
                            boolean z2 = (p.this.mIsHost || p.this.mqN.getUserData() == null || p.this.mqN.getUserData().getNewGodData() == null || !p.this.mqN.getUserData().getNewGodData().isNewGod()) ? false : true;
                            p.this.mwc.height = p.this.mwi;
                            p.this.mwb.setLayoutParams(p.this.mwc);
                            p.this.mwi += z2 ? com.baidu.tieba.personPolymeric.header.b.msQ : 0;
                            p.this.mvU.Iv(p.this.mwi);
                            p.this.mwc.height = -2;
                            p.this.mwb.setLayoutParams(p.this.mwc);
                        }
                    }
                }
            });
            this.mvX.h(aVar);
            this.mvX.g(aVar);
            if (y.isEmpty(aVar.cRZ())) {
                this.mqy.bTa();
                com.baidu.adp.lib.util.l.showToast(this.eNx.getContext(), this.eNx.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.q.a.dGN().xu(this.mIsHost);
            int size = aVar.cRZ().size();
            for (int i = 0; i < size; i++) {
                q qVar = aVar.cRZ().get(i);
                if (qVar != null && (qVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.mqy.bTa();
                    return;
                }
            }
            if (!z) {
                this.mqy.g(true, aVar.cRZ());
            }
        }
    }

    public void cJL() {
        this.mqy.cJL();
    }

    private void E(TbPageContext tbPageContext) {
        this.mvO = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.q.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.q.b) customResponsedMessage.getData()).mRu;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.mwf != null && aVar != null) {
                            p.this.mwf.wG(aVar.dpw);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.mqN != null) {
                            if (p.this.mqN.mrC != null && p.this.mqN.mrC.iEw != null && aVar2 != null) {
                                p.this.mqN.mrC.iEw.putBoolean("person_center_item_red_tip_show", aVar2.dpw);
                            }
                            if (aVar3 != null && p.this.mqN.mrB != null && p.this.mqN.mrB.iEw != null) {
                                p.this.mqN.mrB.iEw.putBoolean("person_center_item_red_tip_show", aVar3.dpw);
                            }
                            if (aVar4 != null && p.this.mqN.mrA != null && p.this.mqN.mrA.iEw != null) {
                                p.this.mqN.mrA.iEw.putBoolean("person_center_item_red_tip_show", aVar4.dpw);
                            }
                            if (aVar5 != null && p.this.mqN.mrD != null && p.this.mqN.mrD.iEw != null) {
                                p.this.mqN.mrD.iEw.putBoolean("person_center_item_red_tip_show", aVar5.dpw);
                            }
                            if (aVar6 != null && p.this.mqN.mrE != null && p.this.mqN.mrE.iEw != null) {
                                p.this.mqN.mrE.iEw.putBoolean("person_center_item_red_tip_show", aVar6.dpw);
                                p.this.mqN.mrE.iEw.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.mvO.setTag(this.ajD);
        tbPageContext.registerListener(this.mvO);
        this.mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.n nVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n) && (nVar = (com.baidu.tbadk.data.n) customResponsedMessage.getData()) != null) {
                    p.this.mwf.Rk(nVar.bmL());
                }
            }
        };
        this.mUpdatePendantListener.setTag(this.ajD);
        tbPageContext.registerListener(this.mUpdatePendantListener);
        this.mvP = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.mwh == ((Integer) customResponsedMessage.getData()).intValue() && p.this.jxE) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(p.this.jxO);
                    p.this.cLc();
                }
            }
        };
        this.mvP.setTag(this.ajD);
        tbPageContext.registerListener(this.mvP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLc() {
        this.mwh = -1;
        this.jxE = false;
        if (this.mvT != null) {
            this.mvT.bvm();
        }
    }

    public void onDestory() {
        if (this.mwf != null) {
            this.mwf.onDestroy();
        }
        if (this.mvT != null) {
            this.mvT.onDestroy();
        }
        if (this.fbQ != null) {
            this.fbQ.cancel();
            this.fbQ.removeAllListeners();
            this.fbQ.removeAllUpdateListeners();
            this.fbQ = null;
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jxO);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.mvN = aVar;
    }
}
