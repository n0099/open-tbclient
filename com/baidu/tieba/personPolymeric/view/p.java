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
    public static int jKX = 5000;
    private static final float mFE = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout ZM;
    private BdUniqueId agC;
    private TbPageContext eUY;
    private CustomViewPager eZd;
    private BaseFragment fID;
    private ValueAnimator fjh;
    private NoNetworkView gAh;
    private PluginErrorTipView iIC;
    private NewPagerSlidingTabBaseStrip iJr;
    protected RelativeLayout mAb;
    private CustomMessageListener mAccountChangedListener;
    private com.baidu.tieba.personPolymeric.b.f mAh;
    private com.baidu.tieba.personPolymeric.c.a mAx;
    private com.baidu.tieba.model.a mFB;
    private CustomMessageListener mFC;
    private CustomMessageListener mFD;
    private PullRefreshFrameLayout mFH;
    private com.baidu.tieba.personPolymeric.header.a mFI;
    private FrameLayout mFJ;
    private View mFK;
    private a mFL;
    private int mFM;
    private int mFN;
    private GradientDrawable mFO;
    private FrameLayout mFP;
    private FrameLayout.LayoutParams mFQ;
    private AlphaAnimation mFR;
    private AlphaAnimation mFS;
    private com.baidu.tieba.personPolymeric.header.c mFT;
    private k mFU;
    private int mFW;
    private boolean mFX;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private CustomMessageListener mUpdatePendantListener;
    private long mUserId;
    private LinearLayout mzY;
    protected FrameLayout mzZ;
    private float[] mFF = {mFE, mFE, mFE, mFE, 0.0f, 0.0f, 0.0f, 0.0f};
    private float mFG = 674.0f;
    private boolean jLb = false;
    private int mFV = -1;
    private Runnable jLl = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.6
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.jLb) {
                p.this.cLB();
            }
        }
    };
    private com.baidu.tieba.personPolymeric.b.a mCG = new com.baidu.tieba.personPolymeric.b.a() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.tieba.personPolymeric.b.a
        public void CC(int i) {
            p.this.mFQ.height = -2;
            p.this.mFP.setLayoutParams(p.this.mFQ);
        }

        @Override // com.baidu.tieba.personPolymeric.b.a
        public void hS(boolean z) {
            p.this.mFX = z;
            if (!z) {
                p.this.mFI.Ha(p.this.mFW);
            }
            if (p.this.mFT != null && p.this.mFT.dzh() != null) {
                p.this.mFT.dzh().setOpen(z);
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.g gVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.fID = baseFragment;
        this.eUY = baseFragment.getPageContext();
        this.agC = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.mAh = gVar.dyq();
        am(gVar.mRootView);
    }

    private void am(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.mFH = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.mFI = new com.baidu.tieba.personPolymeric.header.a(this.eUY, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.mFU = new k(this.eUY, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.mFP = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.mFQ = (FrameLayout.LayoutParams) this.mFP.getLayoutParams();
        this.mFH.setOnTouchCallback(new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void q(double d) {
                p.this.mFQ.height = (int) ((p.this.mFX ? com.baidu.tieba.personPolymeric.header.b.mCB : 0) + p.this.mFM + (PullRefreshFrameLayout.fiL * d));
                p.this.mFP.setLayoutParams(p.this.mFQ);
                if (p.this.mFI != null) {
                    p.this.mFI.x(d);
                }
                p.this.mFH.buk();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void b(final int i, double d) {
                p.this.fjh = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.fjh.setDuration(150L);
                final int measuredHeight = p.this.mFP.getMeasuredHeight();
                final int cDm = p.this.mFI.cDm();
                p.this.fjh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.mFQ.height = (int) (measuredHeight - (i * animatedFraction));
                        p.this.mFP.setLayoutParams(p.this.mFQ);
                        if (p.this.mFI != null) {
                            p.this.mFI.Hb((int) (cDm - (animatedFraction * i)));
                        }
                    }
                });
                p.this.fjh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.mFN = p.this.mFQ.height;
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
                final int measuredHeight = p.this.mFP.getMeasuredHeight();
                final int i = (measuredHeight - p.this.mFM) - (p.this.mFX ? com.baidu.tieba.personPolymeric.header.b.mCB : 0);
                final int cDm = p.this.mFI != null ? p.this.mFI.cDm() : 0;
                if (p.this.mFX) {
                    p.this.mFT.wV(false);
                    p.this.mFT.dyI();
                }
                if (i > 0 || (i == 0 && p.this.mFX)) {
                    p.this.fjh = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.fjh.setDuration(300L);
                    p.this.fjh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.mFQ.height = (int) (measuredHeight - (i * floatValue));
                            p.this.mFP.setLayoutParams(p.this.mFQ);
                            if (p.this.mFI != null && cDm > 0) {
                                p.this.mFI.Hb((int) (cDm - (floatValue * i)));
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
                            if (p.this.mFX) {
                                p.this.mFT.dyJ();
                            }
                            p.this.mFN = 0;
                            p.this.mFQ.height = -2;
                            p.this.mFP.setLayoutParams(p.this.mFQ);
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
        this.mFH.setOnPullRefreshListener(new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.personPolymeric.view.p.8
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bum() {
                com.baidu.adp.lib.f.e.mA().postDelayed(p.this.jLl, p.jKX);
                p.this.jLb = true;
                p.this.mFV = p.this.mFL.getCurrentTabType();
                p.this.dyh();
                p.this.mFL.bSq();
            }
        });
        this.mFH.setOnCancelCallBack(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void onCancel() {
                p.this.mFN = 0;
                p.this.mFQ.height = -2;
                p.this.mFP.setLayoutParams(p.this.mFQ);
            }
        });
        this.mFH.setOnLoadingStartCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.10
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void bul() {
                p.this.mFQ.height = -2;
                p.this.mFP.setLayoutParams(p.this.mFQ);
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
                p.this.mFH.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.mFU.xb(abs == 0);
                p.this.mFU.xc(((float) abs) > p.this.mFG / 2.0f);
                float abs2 = ((double) p.this.mFG) == 0.0d ? 0.0f : Math.abs(abs / p.this.mFG);
                p.this.mFU.aX(abs2);
                if (abs2 >= 1.0f) {
                    p.this.mFF = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mFO.setCornerRadii(p.this.mFF);
                    p.this.mFJ.setBackgroundDrawable(p.this.mFO);
                    p.this.bRJ();
                } else {
                    p.this.mFF = new float[]{p.mFE, p.mFE, p.mFE, p.mFE, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mFO.setCornerRadii(p.this.mFF);
                    p.this.mFJ.setBackgroundDrawable(p.this.mFO);
                    p.this.dzu();
                }
                int i2 = p.this.mFN - p.this.mFM;
                if (p.this.mFN > 0 && Math.abs(i) >= i2) {
                    p.this.mFH.dismissLoading();
                }
            }
        });
        this.mFJ = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.iJr = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.iJr.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        this.iJr.setRectPaintColor(R.color.CAM_X0302);
        this.iJr.a(com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds46), true);
        this.iJr.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds64));
        this.iJr.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds8));
        this.iJr.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds8));
        this.iJr.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds0));
        this.iJr.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds166), -1));
        this.iJr.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.12
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.mFL.Hf(i);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.mFO = new GradientDrawable();
        this.mFO.setColor(ap.getColor(R.color.CAM_X0201));
        this.mFO.setCornerRadii(this.mFF);
        this.mFJ.setBackgroundDrawable(this.mFO);
        this.mFK = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        ap.setBackgroundResource(this.mFK, R.drawable.personalize_tab_shadow);
        this.eZd = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.mFL = new a(this.fID.getActivity().getSupportFragmentManager());
        this.eZd.setAdapter(this.mFL);
        this.eZd.setOffscreenPageLimit(this.mFL.mFragments.size());
        this.mFL.notifyDataSetChanged();
        this.iJr.setViewPager(this.eZd);
        this.eZd.setCurrentItem(1);
        this.mFT = new com.baidu.tieba.personPolymeric.header.c(this.eUY, this.mIsHost);
        this.mFT.a(this.mCG);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.mFP.addView(this.mFT.getView(), layoutParams);
        if (this.mFU.dzs()) {
            H(this.eUY);
        }
        G(this.eUY);
        this.gAh = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.iIC = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.mzY = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.mzZ = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.mAb = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void G(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.mFU != null) {
                    p.this.mFU.dzq();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.agC);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c dzt() {
        return this.mFT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends FragmentPagerAdapter {
        private List<PersonCenterTabBaseFragment> mFragments;
        private List<String> mkL;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mkL = new ArrayList();
            this.mkL.add(p.this.eUY.getResources().getString(R.string.person_center_tab_main));
            this.mkL.add(p.this.eUY.getResources().getString(R.string.person_center_tab_thread));
            this.mkL.add(p.this.eUY.getResources().getString(R.string.person_center_tab_dynamic));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.q(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.r(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.p(p.this.mUserId, p.this.mIsHost));
        }

        public void Hf(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.mkL.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
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
            return this.mkL.get(i);
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

        public void bSq() {
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

    private boolean bRI() {
        return this.mFK.getVisibility() == 0;
    }

    public void bRJ() {
        if (!bRI() && this.mFR == null) {
            this.mFK.setVisibility(0);
            if (this.mFR == null) {
                this.mFR = new AlphaAnimation(0.0f, 1.0f);
                this.mFR.setFillAfter(true);
                this.mFR.setDuration(300L);
                this.mFR.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.14
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.mFR.reset();
                        p.this.mFR = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.mFK.startAnimation(this.mFR);
            }
        }
    }

    public void dzu() {
        if (bRI() && this.mFS == null && this.mFS == null) {
            this.mFS = new AlphaAnimation(1.0f, 0.0f);
            this.mFS.setFillAfter(true);
            this.mFS.setDuration(300L);
            this.mFS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.15
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.mFK.setVisibility(8);
                    p.this.mFS.reset();
                    p.this.mFS = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mFK.startAnimation(this.mFS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mFU != null) {
            this.mFU.onChangeSkinType(i);
        }
        if (this.iJr != null) {
            this.iJr.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.iJr.setRectPaintColor(R.color.CAM_X0302);
            this.iJr.onChangeSkinType();
        }
        if (this.mFO != null) {
            this.mFO.setColor(ap.getColor(R.color.CAM_X0201));
        }
        if (this.mFT != null) {
            this.mFT.onChangeSkinType(i);
        }
        if (this.mFL != null) {
            this.mFL.onChangeSkinType(i);
        }
        if (this.gAh != null) {
            this.gAh.onChangeSkinType(this.eUY, i);
        }
        if (this.iIC != null) {
            this.iIC.onChangeSkinType(this.eUY, i);
        }
        ap.setBackgroundResource(this.mzY, R.color.CAM_X0201);
        ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
        ap.setBackgroundResource(this.mFK, R.drawable.personalize_tab_shadow);
    }

    public void dyh() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.mFB.resetData();
            this.mFB.refreshData();
            this.mAh.doRefresh();
            return;
        }
        this.mAh.cKi();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        if (this.mFU != null) {
            this.mFU.setOnViewResponseListener(fVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.mAx = aVar;
            this.mzY.setVisibility(8);
            this.mAb.setVisibility(0);
            if (this.mFU != null) {
                this.mFU.a(aVar, personStatus);
            }
            if (this.mFT != null) {
                this.mFT.b(aVar);
            }
            if (this.mFI != null) {
                this.mFI.d(this.mAx.getUserData());
            }
            this.mFP.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.2
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.mFM == 0) {
                        p.this.mFM = p.this.mFP.getMeasuredHeight();
                        p.this.mFG = p.this.mFP.getMeasuredHeight() - p.this.mFU.dzr().getMeasuredHeight();
                        if (p.this.mFI != null) {
                            p.this.mFW = p.this.mStatusBarHeight + p.this.mFU.dzr().getMeasuredHeight() + p.this.mFP.getMeasuredHeight() + p.this.iJr.getMeasuredHeight();
                            boolean z2 = (p.this.mIsHost || p.this.mAx.getUserData() == null || p.this.mAx.getUserData().getNewGodData() == null || !p.this.mAx.getUserData().getNewGodData().isNewGod()) ? false : true;
                            p.this.mFQ.height = p.this.mFW;
                            p.this.mFP.setLayoutParams(p.this.mFQ);
                            p.this.mFW += z2 ? com.baidu.tieba.personPolymeric.header.b.mCB : 0;
                            p.this.mFI.Ha(p.this.mFW);
                            p.this.mFQ.height = -2;
                            p.this.mFP.setLayoutParams(p.this.mFQ);
                        }
                    }
                }
            });
            this.mFL.h(aVar);
            this.mFL.g(aVar);
            if (y.isEmpty(aVar.cTo())) {
                this.mAh.bSr();
                com.baidu.adp.lib.util.l.showToast(this.eUY.getContext(), this.eUY.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.dEW().xK(this.mIsHost);
            int size = aVar.cTo().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.n nVar = aVar.cTo().get(i);
                if (nVar != null && (nVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.mAh.bSr();
                    return;
                }
            }
            if (!z) {
                this.mAh.h(true, aVar.cTo());
            }
        }
    }

    public void cKi() {
        this.mAh.cKi();
    }

    private void H(TbPageContext tbPageContext) {
        this.mFC = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).nbH;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.mFT != null && aVar != null) {
                            p.this.mFT.wU(aVar.drR);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.mAx != null) {
                            if (p.this.mAx.mBn != null && p.this.mAx.mBn.iRL != null && aVar2 != null) {
                                p.this.mAx.mBn.iRL.putBoolean("person_center_item_red_tip_show", aVar2.drR);
                            }
                            if (aVar3 != null && p.this.mAx.mBm != null && p.this.mAx.mBm.iRL != null) {
                                p.this.mAx.mBm.iRL.putBoolean("person_center_item_red_tip_show", aVar3.drR);
                            }
                            if (aVar4 != null && p.this.mAx.mBl != null && p.this.mAx.mBl.iRL != null) {
                                p.this.mAx.mBl.iRL.putBoolean("person_center_item_red_tip_show", aVar4.drR);
                            }
                            if (aVar5 != null && p.this.mAx.mBo != null && p.this.mAx.mBo.iRL != null) {
                                p.this.mAx.mBo.iRL.putBoolean("person_center_item_red_tip_show", aVar5.drR);
                            }
                            if (aVar6 != null && p.this.mAx.mBp != null && p.this.mAx.mBp.iRL != null) {
                                p.this.mAx.mBp.iRL.putBoolean("person_center_item_red_tip_show", aVar6.drR);
                                p.this.mAx.mBp.iRL.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.mFC.setTag(this.agC);
        tbPageContext.registerListener(this.mFC);
        this.mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.n nVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n) && (nVar = (com.baidu.tbadk.data.n) customResponsedMessage.getData()) != null) {
                    p.this.mFT.Qz(nVar.getImgUrl());
                }
            }
        };
        this.mUpdatePendantListener.setTag(this.agC);
        tbPageContext.registerListener(this.mUpdatePendantListener);
        this.mFD = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.mFV == ((Integer) customResponsedMessage.getData()).intValue() && p.this.jLb) {
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(p.this.jLl);
                    p.this.cLB();
                }
            }
        };
        this.mFD.setTag(this.agC);
        tbPageContext.registerListener(this.mFD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLB() {
        this.mFV = -1;
        this.jLb = false;
        if (this.mFH != null) {
            this.mFH.bui();
        }
    }

    public void onDestory() {
        if (this.mFT != null) {
            this.mFT.onDestroy();
        }
        if (this.mFH != null) {
            this.mFH.onDestroy();
        }
        if (this.fjh != null) {
            this.fjh.cancel();
            this.fjh.removeAllListeners();
            this.fjh.removeAllUpdateListeners();
            this.fjh = null;
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jLl);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.mFB = aVar;
    }
}
