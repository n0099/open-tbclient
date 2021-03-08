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
/* loaded from: classes7.dex */
public class p {
    public static int jMU = 5000;
    private static final float mHW = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout abf;
    private BdUniqueId ahU;
    private TbPageContext eWx;
    private BaseFragment fKc;
    private CustomViewPager faC;
    private ValueAnimator fkG;
    private NoNetworkView gCe;
    private PluginErrorTipView iKz;
    private NewPagerSlidingTabBaseStrip iLo;
    private CustomMessageListener mAccountChangedListener;
    private com.baidu.tieba.personPolymeric.b.f mCA;
    private com.baidu.tieba.personPolymeric.c.a mCQ;
    private LinearLayout mCq;
    protected FrameLayout mCr;
    protected RelativeLayout mCt;
    private com.baidu.tieba.model.a mHT;
    private CustomMessageListener mHU;
    private CustomMessageListener mHV;
    private PullRefreshFrameLayout mHZ;
    private com.baidu.tieba.personPolymeric.header.a mIa;
    private FrameLayout mIb;
    private View mIc;
    private a mIe;
    private int mIf;
    private int mIg;
    private GradientDrawable mIh;
    private FrameLayout mIi;
    private FrameLayout.LayoutParams mIj;
    private AlphaAnimation mIk;
    private AlphaAnimation mIl;
    private com.baidu.tieba.personPolymeric.header.c mIm;
    private k mIn;
    private int mIq;
    private boolean mIr;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private CustomMessageListener mUpdatePendantListener;
    private long mUserId;
    private float[] mHX = {mHW, mHW, mHW, mHW, 0.0f, 0.0f, 0.0f, 0.0f};
    private float mHY = 674.0f;
    private boolean jMY = false;
    private int mIo = -1;
    private Runnable jNi = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.6
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.jMY) {
                p.this.cLO();
            }
        }
    };
    private com.baidu.tieba.personPolymeric.b.a mFa = new com.baidu.tieba.personPolymeric.b.a() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.tieba.personPolymeric.b.a
        public void CF(int i) {
            p.this.mIj.height = -2;
            p.this.mIi.setLayoutParams(p.this.mIj);
        }

        @Override // com.baidu.tieba.personPolymeric.b.a
        public void hS(boolean z) {
            p.this.mIr = z;
            if (!z) {
                p.this.mIa.Hd(p.this.mIq);
            }
            if (p.this.mIm != null && p.this.mIm.dzx() != null) {
                p.this.mIm.dzx().setOpen(z);
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.g gVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.fKc = baseFragment;
        this.eWx = baseFragment.getPageContext();
        this.ahU = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.mCA = gVar.dyG();
        am(gVar.mRootView);
    }

    private void am(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.mHZ = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.mIa = new com.baidu.tieba.personPolymeric.header.a(this.eWx, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.mIn = new k(this.eWx, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.mIi = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.mIj = (FrameLayout.LayoutParams) this.mIi.getLayoutParams();
        this.mHZ.setOnTouchCallback(new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void q(double d) {
                p.this.mIj.height = (int) ((p.this.mIr ? com.baidu.tieba.personPolymeric.header.b.mEV : 0) + p.this.mIf + (PullRefreshFrameLayout.fkk * d));
                p.this.mIi.setLayoutParams(p.this.mIj);
                if (p.this.mIa != null) {
                    p.this.mIa.x(d);
                }
                p.this.mHZ.bun();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void b(final int i, double d) {
                p.this.fkG = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.fkG.setDuration(150L);
                final int measuredHeight = p.this.mIi.getMeasuredHeight();
                final int cDz = p.this.mIa.cDz();
                p.this.fkG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.mIj.height = (int) (measuredHeight - (i * animatedFraction));
                        p.this.mIi.setLayoutParams(p.this.mIj);
                        if (p.this.mIa != null) {
                            p.this.mIa.He((int) (cDz - (animatedFraction * i)));
                        }
                    }
                });
                p.this.fkG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.mIg = p.this.mIj.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.fkG.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void buq() {
                final int measuredHeight = p.this.mIi.getMeasuredHeight();
                final int i = (measuredHeight - p.this.mIf) - (p.this.mIr ? com.baidu.tieba.personPolymeric.header.b.mEV : 0);
                final int cDz = p.this.mIa != null ? p.this.mIa.cDz() : 0;
                if (p.this.mIr) {
                    p.this.mIm.wV(false);
                    p.this.mIm.dyY();
                }
                if (i > 0 || (i == 0 && p.this.mIr)) {
                    p.this.fkG = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.fkG.setDuration(300L);
                    p.this.fkG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.mIj.height = (int) (measuredHeight - (i * floatValue));
                            p.this.mIi.setLayoutParams(p.this.mIj);
                            if (p.this.mIa != null && cDz > 0) {
                                p.this.mIa.He((int) (cDz - (floatValue * i)));
                            }
                        }
                    });
                    p.this.fkG.start();
                    p.this.fkG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (p.this.mIr) {
                                p.this.mIm.dyZ();
                            }
                            p.this.mIg = 0;
                            p.this.mIj.height = -2;
                            p.this.mIi.setLayoutParams(p.this.mIj);
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
        this.mHZ.setOnPullRefreshListener(new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.personPolymeric.view.p.8
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bup() {
                com.baidu.adp.lib.f.e.mA().postDelayed(p.this.jNi, p.jMU);
                p.this.jMY = true;
                p.this.mIo = p.this.mIe.getCurrentTabType();
                p.this.dyx();
                p.this.mIe.bSD();
            }
        });
        this.mHZ.setOnCancelCallBack(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void onCancel() {
                p.this.mIg = 0;
                p.this.mIj.height = -2;
                p.this.mIi.setLayoutParams(p.this.mIj);
            }
        });
        this.mHZ.setOnLoadingStartCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.10
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void buo() {
                p.this.mIj.height = -2;
                p.this.mIi.setLayoutParams(p.this.mIj);
            }
        });
        this.abf = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.abf.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.11
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.eWx.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.eWx.getPageActivity());
                }
                p.this.mHZ.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.mIn.xb(abs == 0);
                p.this.mIn.xc(((float) abs) > p.this.mHY / 2.0f);
                float abs2 = ((double) p.this.mHY) == 0.0d ? 0.0f : Math.abs(abs / p.this.mHY);
                p.this.mIn.bb(abs2);
                if (abs2 >= 1.0f) {
                    p.this.mHX = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mIh.setCornerRadii(p.this.mHX);
                    p.this.mIb.setBackgroundDrawable(p.this.mIh);
                    p.this.bRW();
                } else {
                    p.this.mHX = new float[]{p.mHW, p.mHW, p.mHW, p.mHW, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mIh.setCornerRadii(p.this.mHX);
                    p.this.mIb.setBackgroundDrawable(p.this.mIh);
                    p.this.dzK();
                }
                int i2 = p.this.mIg - p.this.mIf;
                if (p.this.mIg > 0 && Math.abs(i) >= i2) {
                    p.this.mHZ.dismissLoading();
                }
            }
        });
        this.mIb = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.iLo = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.iLo.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        this.iLo.setRectPaintColor(R.color.CAM_X0302);
        this.iLo.a(com.baidu.adp.lib.util.l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds46), true);
        this.iLo.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds64));
        this.iLo.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds8));
        this.iLo.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds8));
        this.iLo.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds0));
        this.iLo.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds166), -1));
        this.iLo.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.12
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.mIe.Hi(i);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.mIh = new GradientDrawable();
        this.mIh.setColor(ap.getColor(R.color.CAM_X0201));
        this.mIh.setCornerRadii(this.mHX);
        this.mIb.setBackgroundDrawable(this.mIh);
        this.mIc = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        ap.setBackgroundResource(this.mIc, R.drawable.personalize_tab_shadow);
        this.faC = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.mIe = new a(this.fKc.getActivity().getSupportFragmentManager());
        this.faC.setAdapter(this.mIe);
        this.faC.setOffscreenPageLimit(this.mIe.mFragments.size());
        this.mIe.notifyDataSetChanged();
        this.iLo.setViewPager(this.faC);
        this.faC.setCurrentItem(1);
        this.mIm = new com.baidu.tieba.personPolymeric.header.c(this.eWx, this.mIsHost);
        this.mIm.a(this.mFa);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.mIi.addView(this.mIm.getView(), layoutParams);
        if (this.mIn.dzI()) {
            H(this.eWx);
        }
        G(this.eWx);
        this.gCe = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.iKz = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.mCq = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.mCr = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.mCt = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void G(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.mIn != null) {
                    p.this.mIn.dzG();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.ahU);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c dzJ() {
        return this.mIm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends FragmentPagerAdapter {
        private List<PersonCenterTabBaseFragment> mFragments;
        private List<String> mnc;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mnc = new ArrayList();
            this.mnc.add(p.this.eWx.getResources().getString(R.string.person_center_tab_main));
            this.mnc.add(p.this.eWx.getResources().getString(R.string.person_center_tab_thread));
            this.mnc.add(p.this.eWx.getResources().getString(R.string.person_center_tab_dynamic));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.q(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.r(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.p(p.this.mUserId, p.this.mIsHost));
        }

        public void Hi(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.mnc.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
                if (i2 == i) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return Hk(i);
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
            return Hj(i);
        }

        private String Hj(int i) {
            return this.mnc.get(i);
        }

        public PersonCenterTabBaseFragment Hk(int i) {
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

        public void bSD() {
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
                            personCenterTabBaseFragment.a(aVar.eTa);
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

    private boolean bRV() {
        return this.mIc.getVisibility() == 0;
    }

    public void bRW() {
        if (!bRV() && this.mIk == null) {
            this.mIc.setVisibility(0);
            if (this.mIk == null) {
                this.mIk = new AlphaAnimation(0.0f, 1.0f);
                this.mIk.setFillAfter(true);
                this.mIk.setDuration(300L);
                this.mIk.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.14
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.mIk.reset();
                        p.this.mIk = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.mIc.startAnimation(this.mIk);
            }
        }
    }

    public void dzK() {
        if (bRV() && this.mIl == null && this.mIl == null) {
            this.mIl = new AlphaAnimation(1.0f, 0.0f);
            this.mIl.setFillAfter(true);
            this.mIl.setDuration(300L);
            this.mIl.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.15
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.mIc.setVisibility(8);
                    p.this.mIl.reset();
                    p.this.mIl = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mIc.startAnimation(this.mIl);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mIn != null) {
            this.mIn.onChangeSkinType(i);
        }
        if (this.iLo != null) {
            this.iLo.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.iLo.setRectPaintColor(R.color.CAM_X0302);
            this.iLo.onChangeSkinType();
        }
        if (this.mIh != null) {
            this.mIh.setColor(ap.getColor(R.color.CAM_X0201));
        }
        if (this.mIm != null) {
            this.mIm.onChangeSkinType(i);
        }
        if (this.mIe != null) {
            this.mIe.onChangeSkinType(i);
        }
        if (this.gCe != null) {
            this.gCe.onChangeSkinType(this.eWx, i);
        }
        if (this.iKz != null) {
            this.iKz.onChangeSkinType(this.eWx, i);
        }
        ap.setBackgroundResource(this.mCq, R.color.CAM_X0201);
        ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
        ap.setBackgroundResource(this.mIc, R.drawable.personalize_tab_shadow);
    }

    public void dyx() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.mHT.resetData();
            this.mHT.refreshData();
            this.mCA.doRefresh();
            return;
        }
        this.mCA.cKv();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        if (this.mIn != null) {
            this.mIn.setOnViewResponseListener(fVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.mCQ = aVar;
            this.mCq.setVisibility(8);
            this.mCt.setVisibility(0);
            if (this.mIn != null) {
                this.mIn.a(aVar, personStatus);
            }
            if (this.mIm != null) {
                this.mIm.b(aVar);
            }
            if (this.mIa != null) {
                this.mIa.d(this.mCQ.getUserData());
            }
            this.mIi.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.2
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.mIf == 0) {
                        p.this.mIf = p.this.mIi.getMeasuredHeight();
                        p.this.mHY = p.this.mIi.getMeasuredHeight() - p.this.mIn.dzH().getMeasuredHeight();
                        if (p.this.mIa != null) {
                            p.this.mIq = p.this.mStatusBarHeight + p.this.mIn.dzH().getMeasuredHeight() + p.this.mIi.getMeasuredHeight() + p.this.iLo.getMeasuredHeight();
                            boolean z2 = (p.this.mIsHost || p.this.mCQ.getUserData() == null || p.this.mCQ.getUserData().getNewGodData() == null || !p.this.mCQ.getUserData().getNewGodData().isNewGod()) ? false : true;
                            p.this.mIj.height = p.this.mIq;
                            p.this.mIi.setLayoutParams(p.this.mIj);
                            p.this.mIq += z2 ? com.baidu.tieba.personPolymeric.header.b.mEV : 0;
                            p.this.mIa.Hd(p.this.mIq);
                            p.this.mIj.height = -2;
                            p.this.mIi.setLayoutParams(p.this.mIj);
                        }
                    }
                }
            });
            this.mIe.h(aVar);
            this.mIe.g(aVar);
            if (y.isEmpty(aVar.cTC())) {
                this.mCA.bSE();
                com.baidu.adp.lib.util.l.showToast(this.eWx.getContext(), this.eWx.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.dFm().xK(this.mIsHost);
            int size = aVar.cTC().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.n nVar = aVar.cTC().get(i);
                if (nVar != null && (nVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.mCA.bSE();
                    return;
                }
            }
            if (!z) {
                this.mCA.i(true, aVar.cTC());
            }
        }
    }

    public void cKv() {
        this.mCA.cKv();
    }

    private void H(TbPageContext tbPageContext) {
        this.mHU = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).nel;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.mIm != null && aVar != null) {
                            p.this.mIm.wU(aVar.dtu);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.mCQ != null) {
                            if (p.this.mCQ.mDI != null && p.this.mCQ.mDI.iTI != null && aVar2 != null) {
                                p.this.mCQ.mDI.iTI.putBoolean("person_center_item_red_tip_show", aVar2.dtu);
                            }
                            if (aVar3 != null && p.this.mCQ.mDH != null && p.this.mCQ.mDH.iTI != null) {
                                p.this.mCQ.mDH.iTI.putBoolean("person_center_item_red_tip_show", aVar3.dtu);
                            }
                            if (aVar4 != null && p.this.mCQ.mDG != null && p.this.mCQ.mDG.iTI != null) {
                                p.this.mCQ.mDG.iTI.putBoolean("person_center_item_red_tip_show", aVar4.dtu);
                            }
                            if (aVar5 != null && p.this.mCQ.mDJ != null && p.this.mCQ.mDJ.iTI != null) {
                                p.this.mCQ.mDJ.iTI.putBoolean("person_center_item_red_tip_show", aVar5.dtu);
                            }
                            if (aVar6 != null && p.this.mCQ.mDK != null && p.this.mCQ.mDK.iTI != null) {
                                p.this.mCQ.mDK.iTI.putBoolean("person_center_item_red_tip_show", aVar6.dtu);
                                p.this.mCQ.mDK.iTI.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.mHU.setTag(this.ahU);
        tbPageContext.registerListener(this.mHU);
        this.mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.n nVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n) && (nVar = (com.baidu.tbadk.data.n) customResponsedMessage.getData()) != null) {
                    p.this.mIm.QG(nVar.getImgUrl());
                }
            }
        };
        this.mUpdatePendantListener.setTag(this.ahU);
        tbPageContext.registerListener(this.mUpdatePendantListener);
        this.mHV = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.mIo == ((Integer) customResponsedMessage.getData()).intValue() && p.this.jMY) {
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(p.this.jNi);
                    p.this.cLO();
                }
            }
        };
        this.mHV.setTag(this.ahU);
        tbPageContext.registerListener(this.mHV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLO() {
        this.mIo = -1;
        this.jMY = false;
        if (this.mHZ != null) {
            this.mHZ.bul();
        }
    }

    public void onDestory() {
        if (this.mIm != null) {
            this.mIm.onDestroy();
        }
        if (this.mHZ != null) {
            this.mHZ.onDestroy();
        }
        if (this.fkG != null) {
            this.fkG.cancel();
            this.fkG.removeAllListeners();
            this.fkG.removeAllUpdateListeners();
            this.fkG = null;
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jNi);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.mHT = aVar;
    }
}
