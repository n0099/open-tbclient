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
    public static int jxC = 5000;
    private static final float mvS = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout Zj;
    private BdUniqueId ajD;
    private TbPageContext eNx;
    private CustomViewPager eRw;
    private BaseFragment fBs;
    private ValueAnimator fbQ;
    private NoNetworkView grf;
    private PluginErrorTipView ivm;
    private NewPagerSlidingTabBaseStrip iwb;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private CustomMessageListener mUpdatePendantListener;
    private long mUserId;
    private com.baidu.tieba.personPolymeric.b.f mqA;
    private com.baidu.tieba.personPolymeric.c.a mqP;
    private LinearLayout mqr;
    protected FrameLayout mqs;
    protected RelativeLayout mqu;
    private com.baidu.tieba.model.a mvP;
    private CustomMessageListener mvQ;
    private CustomMessageListener mvR;
    private PullRefreshFrameLayout mvV;
    private com.baidu.tieba.personPolymeric.header.a mvW;
    private FrameLayout mvX;
    private View mvY;
    private a mvZ;
    private int mwa;
    private int mwb;
    private GradientDrawable mwc;
    private FrameLayout mwd;
    private FrameLayout.LayoutParams mwe;
    private AlphaAnimation mwf;
    private AlphaAnimation mwg;
    private com.baidu.tieba.personPolymeric.header.c mwh;
    private k mwi;
    private int mwk;
    private boolean mwl;
    private float[] mvT = {mvS, mvS, mvS, mvS, 0.0f, 0.0f, 0.0f, 0.0f};
    private float mvU = 674.0f;
    private boolean jxG = false;
    private int mwj = -1;
    private Runnable jxQ = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.6
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.jxG) {
                p.this.cLd();
            }
        }
    };
    private com.baidu.tieba.personPolymeric.b.a msX = new com.baidu.tieba.personPolymeric.b.a() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.tieba.personPolymeric.b.a
        public void DD(int i) {
            p.this.mwe.height = -2;
            p.this.mwd.setLayoutParams(p.this.mwe);
        }

        @Override // com.baidu.tieba.personPolymeric.b.a
        public void hC(boolean z) {
            p.this.mwl = z;
            if (!z) {
                p.this.mvW.Iv(p.this.mwk);
            }
            if (p.this.mwh != null && p.this.mwh.dBa() != null) {
                p.this.mwh.dBa().setOpen(z);
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.g gVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.fBs = baseFragment;
        this.eNx = baseFragment.getPageContext();
        this.ajD = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.mqA = gVar.dAj();
        an(gVar.mRootView);
    }

    private void an(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.mvV = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.mvW = new com.baidu.tieba.personPolymeric.header.a(this.eNx, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.mwi = new k(this.eNx, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.mwd = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.mwe = (FrameLayout.LayoutParams) this.mwd.getLayoutParams();
        this.mvV.setOnTouchCallback(new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void w(double d) {
                p.this.mwe.height = (int) ((p.this.mwl ? com.baidu.tieba.personPolymeric.header.b.msS : 0) + p.this.mwa + (PullRefreshFrameLayout.fbu * d));
                p.this.mwd.setLayoutParams(p.this.mwe);
                if (p.this.mvW != null) {
                    p.this.mvW.E(d);
                }
                p.this.mvV.bvo();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                p.this.fbQ = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.fbQ.setDuration(150L);
                final int measuredHeight = p.this.mwd.getMeasuredHeight();
                final int cCX = p.this.mvW.cCX();
                p.this.fbQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.mwe.height = (int) (measuredHeight - (i * animatedFraction));
                        p.this.mwd.setLayoutParams(p.this.mwe);
                        if (p.this.mvW != null) {
                            p.this.mvW.Iw((int) (cCX - (animatedFraction * i)));
                        }
                    }
                });
                p.this.fbQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.mwb = p.this.mwe.height;
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
                final int measuredHeight = p.this.mwd.getMeasuredHeight();
                final int i = (measuredHeight - p.this.mwa) - (p.this.mwl ? com.baidu.tieba.personPolymeric.header.b.msS : 0);
                final int cCX = p.this.mvW != null ? p.this.mvW.cCX() : 0;
                if (p.this.mwl) {
                    p.this.mwh.wH(false);
                    p.this.mwh.dAB();
                }
                if (i > 0 || (i == 0 && p.this.mwl)) {
                    p.this.fbQ = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.fbQ.setDuration(300L);
                    p.this.fbQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.mwe.height = (int) (measuredHeight - (i * floatValue));
                            p.this.mwd.setLayoutParams(p.this.mwe);
                            if (p.this.mvW != null && cCX > 0) {
                                p.this.mvW.Iw((int) (cCX - (floatValue * i)));
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
                            if (p.this.mwl) {
                                p.this.mwh.dAC();
                            }
                            p.this.mwb = 0;
                            p.this.mwe.height = -2;
                            p.this.mwd.setLayoutParams(p.this.mwe);
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
        this.mvV.setOnPullRefreshListener(new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.personPolymeric.view.p.8
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bvq() {
                com.baidu.adp.lib.f.e.mY().postDelayed(p.this.jxQ, p.jxC);
                p.this.jxG = true;
                p.this.mwj = p.this.mvZ.getCurrentTabType();
                p.this.dAa();
                p.this.mvZ.bTa();
            }
        });
        this.mvV.setOnCancelCallBack(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void onCancel() {
                p.this.mwb = 0;
                p.this.mwe.height = -2;
                p.this.mwd.setLayoutParams(p.this.mwe);
            }
        });
        this.mvV.setOnLoadingStartCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.10
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void bvp() {
                p.this.mwe.height = -2;
                p.this.mwd.setLayoutParams(p.this.mwe);
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
                p.this.mvV.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.mwi.wN(abs == 0);
                p.this.mwi.wO(((float) abs) > p.this.mvU / 2.0f);
                float abs2 = ((double) p.this.mvU) == 0.0d ? 0.0f : Math.abs(abs / p.this.mvU);
                p.this.mwi.aS(abs2);
                if (abs2 >= 1.0f) {
                    p.this.mvT = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mwc.setCornerRadii(p.this.mvT);
                    p.this.mvX.setBackgroundDrawable(p.this.mwc);
                    p.this.bSv();
                } else {
                    p.this.mvT = new float[]{p.mvS, p.mvS, p.mvS, p.mvS, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mwc.setCornerRadii(p.this.mvT);
                    p.this.mvX.setBackgroundDrawable(p.this.mwc);
                    p.this.dBn();
                }
                int i2 = p.this.mwb - p.this.mwa;
                if (p.this.mwb > 0 && Math.abs(i) >= i2) {
                    p.this.mvV.dismissLoading();
                }
            }
        });
        this.mvX = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.iwb = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.iwb.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        this.iwb.setRectPaintColor(R.color.CAM_X0302);
        this.iwb.a(com.baidu.adp.lib.util.l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds46), true);
        this.iwb.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds64));
        this.iwb.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds8));
        this.iwb.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds8));
        this.iwb.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds0));
        this.iwb.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds166), -1));
        this.iwb.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.12
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.mvZ.IA(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.mwc = new GradientDrawable();
        this.mwc.setColor(ap.getColor(R.color.CAM_X0201));
        this.mwc.setCornerRadii(this.mvT);
        this.mvX.setBackgroundDrawable(this.mwc);
        this.mvY = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        ap.setBackgroundResource(this.mvY, R.drawable.personalize_tab_shadow);
        this.eRw = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.mvZ = new a(this.fBs.getActivity().getSupportFragmentManager());
        this.eRw.setAdapter(this.mvZ);
        this.eRw.setOffscreenPageLimit(this.mvZ.mFragments.size());
        this.mvZ.notifyDataSetChanged();
        this.iwb.setViewPager(this.eRw);
        this.eRw.setCurrentItem(1);
        this.mwh = new com.baidu.tieba.personPolymeric.header.c(this.eNx, this.mIsHost);
        this.mwh.a(this.msX);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.mwd.addView(this.mwh.getView(), layoutParams);
        if (this.mwi.dBl()) {
            E(this.eNx);
        }
        D(this.eNx);
        this.grf = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.ivm = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.mqr = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.mqs = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.mqu = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void D(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.mwi != null) {
                    p.this.mwi.dBj();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.ajD);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c dBm() {
        return this.mwh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a extends FragmentPagerAdapter {
        private List<PersonCenterTabBaseFragment> mFragments;
        private List<String> mbc;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mbc = new ArrayList();
            this.mbc.add(p.this.eNx.getResources().getString(R.string.person_center_tab_main));
            this.mbc.add(p.this.eNx.getResources().getString(R.string.person_center_tab_thread));
            this.mbc.add(p.this.eNx.getResources().getString(R.string.person_center_tab_dynamic));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.o(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.p(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.n(p.this.mUserId, p.this.mIsHost));
        }

        public void IA(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.mbc.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
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
            return this.mbc.get(i);
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

        public void bTa() {
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

    private boolean bSu() {
        return this.mvY.getVisibility() == 0;
    }

    public void bSv() {
        if (!bSu() && this.mwf == null) {
            this.mvY.setVisibility(0);
            if (this.mwf == null) {
                this.mwf = new AlphaAnimation(0.0f, 1.0f);
                this.mwf.setFillAfter(true);
                this.mwf.setDuration(300L);
                this.mwf.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.14
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.mwf.reset();
                        p.this.mwf = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.mvY.startAnimation(this.mwf);
            }
        }
    }

    public void dBn() {
        if (bSu() && this.mwg == null && this.mwg == null) {
            this.mwg = new AlphaAnimation(1.0f, 0.0f);
            this.mwg.setFillAfter(true);
            this.mwg.setDuration(300L);
            this.mwg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.15
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.mvY.setVisibility(8);
                    p.this.mwg.reset();
                    p.this.mwg = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mvY.startAnimation(this.mwg);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mwi != null) {
            this.mwi.onChangeSkinType(i);
        }
        if (this.iwb != null) {
            this.iwb.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.iwb.setRectPaintColor(R.color.CAM_X0302);
            this.iwb.onChangeSkinType();
        }
        if (this.mwc != null) {
            this.mwc.setColor(ap.getColor(R.color.CAM_X0201));
        }
        if (this.mwh != null) {
            this.mwh.onChangeSkinType(i);
        }
        if (this.mvZ != null) {
            this.mvZ.onChangeSkinType(i);
        }
        if (this.grf != null) {
            this.grf.onChangeSkinType(this.eNx, i);
        }
        if (this.ivm != null) {
            this.ivm.onChangeSkinType(this.eNx, i);
        }
        ap.setBackgroundResource(this.mqr, R.color.CAM_X0201);
        ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
        ap.setBackgroundResource(this.mvY, R.drawable.personalize_tab_shadow);
    }

    public void dAa() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.mvP.resetData();
            this.mvP.refreshData();
            this.mqA.doRefresh();
            return;
        }
        this.mqA.cJM();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        if (this.mwi != null) {
            this.mwi.setOnViewResponseListener(fVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.mqP = aVar;
            this.mqr.setVisibility(8);
            this.mqu.setVisibility(0);
            if (this.mwi != null) {
                this.mwi.a(aVar, personStatus);
            }
            if (this.mwh != null) {
                this.mwh.b(aVar);
            }
            if (this.mvW != null) {
                this.mvW.e(this.mqP.getUserData());
            }
            this.mwd.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.2
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.mwa == 0) {
                        p.this.mwa = p.this.mwd.getMeasuredHeight();
                        p.this.mvU = p.this.mwd.getMeasuredHeight() - p.this.mwi.dBk().getMeasuredHeight();
                        if (p.this.mvW != null) {
                            p.this.mwk = p.this.mStatusBarHeight + p.this.mwi.dBk().getMeasuredHeight() + p.this.mwd.getMeasuredHeight() + p.this.iwb.getMeasuredHeight();
                            boolean z2 = (p.this.mIsHost || p.this.mqP.getUserData() == null || p.this.mqP.getUserData().getNewGodData() == null || !p.this.mqP.getUserData().getNewGodData().isNewGod()) ? false : true;
                            p.this.mwe.height = p.this.mwk;
                            p.this.mwd.setLayoutParams(p.this.mwe);
                            p.this.mwk += z2 ? com.baidu.tieba.personPolymeric.header.b.msS : 0;
                            p.this.mvW.Iv(p.this.mwk);
                            p.this.mwe.height = -2;
                            p.this.mwd.setLayoutParams(p.this.mwe);
                        }
                    }
                }
            });
            this.mvZ.h(aVar);
            this.mvZ.g(aVar);
            if (y.isEmpty(aVar.cSa())) {
                this.mqA.bTb();
                com.baidu.adp.lib.util.l.showToast(this.eNx.getContext(), this.eNx.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.q.a.dGO().xu(this.mIsHost);
            int size = aVar.cSa().size();
            for (int i = 0; i < size; i++) {
                q qVar = aVar.cSa().get(i);
                if (qVar != null && (qVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.mqA.bTb();
                    return;
                }
            }
            if (!z) {
                this.mqA.g(true, aVar.cSa());
            }
        }
    }

    public void cJM() {
        this.mqA.cJM();
    }

    private void E(TbPageContext tbPageContext) {
        this.mvQ = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.q.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.q.b) customResponsedMessage.getData()).mRw;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.mwh != null && aVar != null) {
                            p.this.mwh.wG(aVar.dpw);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.mqP != null) {
                            if (p.this.mqP.mrE != null && p.this.mqP.mrE.iEy != null && aVar2 != null) {
                                p.this.mqP.mrE.iEy.putBoolean("person_center_item_red_tip_show", aVar2.dpw);
                            }
                            if (aVar3 != null && p.this.mqP.mrD != null && p.this.mqP.mrD.iEy != null) {
                                p.this.mqP.mrD.iEy.putBoolean("person_center_item_red_tip_show", aVar3.dpw);
                            }
                            if (aVar4 != null && p.this.mqP.mrC != null && p.this.mqP.mrC.iEy != null) {
                                p.this.mqP.mrC.iEy.putBoolean("person_center_item_red_tip_show", aVar4.dpw);
                            }
                            if (aVar5 != null && p.this.mqP.mrF != null && p.this.mqP.mrF.iEy != null) {
                                p.this.mqP.mrF.iEy.putBoolean("person_center_item_red_tip_show", aVar5.dpw);
                            }
                            if (aVar6 != null && p.this.mqP.mrG != null && p.this.mqP.mrG.iEy != null) {
                                p.this.mqP.mrG.iEy.putBoolean("person_center_item_red_tip_show", aVar6.dpw);
                                p.this.mqP.mrG.iEy.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.mvQ.setTag(this.ajD);
        tbPageContext.registerListener(this.mvQ);
        this.mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.n nVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n) && (nVar = (com.baidu.tbadk.data.n) customResponsedMessage.getData()) != null) {
                    p.this.mwh.Rk(nVar.bmL());
                }
            }
        };
        this.mUpdatePendantListener.setTag(this.ajD);
        tbPageContext.registerListener(this.mUpdatePendantListener);
        this.mvR = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.mwj == ((Integer) customResponsedMessage.getData()).intValue() && p.this.jxG) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(p.this.jxQ);
                    p.this.cLd();
                }
            }
        };
        this.mvR.setTag(this.ajD);
        tbPageContext.registerListener(this.mvR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLd() {
        this.mwj = -1;
        this.jxG = false;
        if (this.mvV != null) {
            this.mvV.bvm();
        }
    }

    public void onDestory() {
        if (this.mwh != null) {
            this.mwh.onDestroy();
        }
        if (this.mvV != null) {
            this.mvV.onDestroy();
        }
        if (this.fbQ != null) {
            this.fbQ.cancel();
            this.fbQ.removeAllListeners();
            this.fbQ.removeAllUpdateListeners();
            this.fbQ = null;
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jxQ);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.mvP = aVar;
    }
}
