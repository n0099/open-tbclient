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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
    public static int jFt = 5000;
    private static final float mwA = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout ZQ;
    private BdUniqueId agN;
    private TbPageContext eSJ;
    private CustomViewPager eWN;
    private BaseFragment fGr;
    private ValueAnimator fgO;
    private NoNetworkView gxx;
    private PluginErrorTipView iCS;
    private NewPagerSlidingTabBaseStrip iDH;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private CustomMessageListener mUpdatePendantListener;
    private long mUserId;
    private LinearLayout mqY;
    protected FrameLayout mqZ;
    protected RelativeLayout mrb;
    private com.baidu.tieba.personPolymeric.b.f mrh;
    private com.baidu.tieba.personPolymeric.c.a mrx;
    private PullRefreshFrameLayout mwD;
    private com.baidu.tieba.personPolymeric.header.a mwE;
    private FrameLayout mwF;
    private View mwG;
    private a mwH;
    private int mwI;
    private int mwJ;
    private GradientDrawable mwK;
    private FrameLayout mwL;
    private FrameLayout.LayoutParams mwM;
    private AlphaAnimation mwN;
    private AlphaAnimation mwO;
    private com.baidu.tieba.personPolymeric.header.c mwP;
    private k mwQ;
    private int mwS;
    private boolean mwT;
    private com.baidu.tieba.model.a mwx;
    private CustomMessageListener mwy;
    private CustomMessageListener mwz;
    private float[] mwB = {mwA, mwA, mwA, mwA, 0.0f, 0.0f, 0.0f, 0.0f};
    private float mwC = 674.0f;
    private boolean jFx = false;
    private int mwR = -1;
    private Runnable jFH = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.6
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.jFx) {
                p.this.cKn();
            }
        }
    };
    private com.baidu.tieba.personPolymeric.b.a mtF = new com.baidu.tieba.personPolymeric.b.a() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.tieba.personPolymeric.b.a
        public void Ck(int i) {
            p.this.mwM.height = -2;
            p.this.mwL.setLayoutParams(p.this.mwM);
        }

        @Override // com.baidu.tieba.personPolymeric.b.a
        public void hQ(boolean z) {
            p.this.mwT = z;
            if (!z) {
                p.this.mwE.GI(p.this.mwS);
            }
            if (p.this.mwP != null && p.this.mwP.dwY() != null) {
                p.this.mwP.dwY().setOpen(z);
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.g gVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.fGr = baseFragment;
        this.eSJ = baseFragment.getPageContext();
        this.agN = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.mrh = gVar.dwh();
        ap(gVar.mRootView);
    }

    private void ap(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.mwD = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.mwE = new com.baidu.tieba.personPolymeric.header.a(this.eSJ, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.mwQ = new k(this.eSJ, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.mwL = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.mwM = (FrameLayout.LayoutParams) this.mwL.getLayoutParams();
        this.mwD.setOnTouchCallback(new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void q(double d) {
                p.this.mwM.height = (int) ((p.this.mwT ? com.baidu.tieba.personPolymeric.header.b.mtA : 0) + p.this.mwI + (PullRefreshFrameLayout.fgs * d));
                p.this.mwL.setLayoutParams(p.this.mwM);
                if (p.this.mwE != null) {
                    p.this.mwE.x(d);
                }
                p.this.mwD.btQ();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void b(final int i, double d) {
                p.this.fgO = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.fgO.setDuration(150L);
                final int measuredHeight = p.this.mwL.getMeasuredHeight();
                final int cCa = p.this.mwE.cCa();
                p.this.fgO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.mwM.height = (int) (measuredHeight - (i * animatedFraction));
                        p.this.mwL.setLayoutParams(p.this.mwM);
                        if (p.this.mwE != null) {
                            p.this.mwE.GJ((int) (cCa - (animatedFraction * i)));
                        }
                    }
                });
                p.this.fgO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.mwJ = p.this.mwM.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.fgO.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void btT() {
                final int measuredHeight = p.this.mwL.getMeasuredHeight();
                final int i = (measuredHeight - p.this.mwI) - (p.this.mwT ? com.baidu.tieba.personPolymeric.header.b.mtA : 0);
                final int cCa = p.this.mwE != null ? p.this.mwE.cCa() : 0;
                if (p.this.mwT) {
                    p.this.mwP.wE(false);
                    p.this.mwP.dwz();
                }
                if (i > 0 || (i == 0 && p.this.mwT)) {
                    p.this.fgO = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.fgO.setDuration(300L);
                    p.this.fgO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.mwM.height = (int) (measuredHeight - (i * floatValue));
                            p.this.mwL.setLayoutParams(p.this.mwM);
                            if (p.this.mwE != null && cCa > 0) {
                                p.this.mwE.GJ((int) (cCa - (floatValue * i)));
                            }
                        }
                    });
                    p.this.fgO.start();
                    p.this.fgO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (p.this.mwT) {
                                p.this.mwP.dwA();
                            }
                            p.this.mwJ = 0;
                            p.this.mwM.height = -2;
                            p.this.mwL.setLayoutParams(p.this.mwM);
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
        this.mwD.setOnPullRefreshListener(new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.personPolymeric.view.p.8
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void btS() {
                com.baidu.adp.lib.f.e.mB().postDelayed(p.this.jFH, p.jFt);
                p.this.jFx = true;
                p.this.mwR = p.this.mwH.getCurrentTabType();
                p.this.dvY();
                p.this.mwH.bRN();
            }
        });
        this.mwD.setOnCancelCallBack(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void onCancel() {
                p.this.mwJ = 0;
                p.this.mwM.height = -2;
                p.this.mwL.setLayoutParams(p.this.mwM);
            }
        });
        this.mwD.setOnLoadingStartCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.10
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void btR() {
                p.this.mwM.height = -2;
                p.this.mwL.setLayoutParams(p.this.mwM);
            }
        });
        this.ZQ = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.ZQ.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.11
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.eSJ.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.eSJ.getPageActivity());
                }
                p.this.mwD.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.mwQ.wK(abs == 0);
                p.this.mwQ.wL(((float) abs) > p.this.mwC / 2.0f);
                float abs2 = ((double) p.this.mwC) == 0.0d ? 0.0f : Math.abs(abs / p.this.mwC);
                p.this.mwQ.aU(abs2);
                if (abs2 >= 1.0f) {
                    p.this.mwB = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mwK.setCornerRadii(p.this.mwB);
                    p.this.mwF.setBackgroundDrawable(p.this.mwK);
                    p.this.bRg();
                } else {
                    p.this.mwB = new float[]{p.mwA, p.mwA, p.mwA, p.mwA, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mwK.setCornerRadii(p.this.mwB);
                    p.this.mwF.setBackgroundDrawable(p.this.mwK);
                    p.this.dxl();
                }
                int i2 = p.this.mwJ - p.this.mwI;
                if (p.this.mwJ > 0 && Math.abs(i) >= i2) {
                    p.this.mwD.dismissLoading();
                }
            }
        });
        this.mwF = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.iDH = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.iDH.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        this.iDH.setRectPaintColor(R.color.CAM_X0302);
        this.iDH.a(com.baidu.adp.lib.util.l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds46), true);
        this.iDH.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds64));
        this.iDH.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds8));
        this.iDH.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds8));
        this.iDH.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds0));
        this.iDH.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds166), -1));
        this.iDH.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.12
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.mwH.GN(i);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.mwK = new GradientDrawable();
        this.mwK.setColor(ao.getColor(R.color.CAM_X0201));
        this.mwK.setCornerRadii(this.mwB);
        this.mwF.setBackgroundDrawable(this.mwK);
        this.mwG = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        ao.setBackgroundResource(this.mwG, R.drawable.personalize_tab_shadow);
        this.eWN = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.mwH = new a(this.fGr.getActivity().getSupportFragmentManager());
        this.eWN.setAdapter(this.mwH);
        this.eWN.setOffscreenPageLimit(this.mwH.mFragments.size());
        this.mwH.notifyDataSetChanged();
        this.iDH.setViewPager(this.eWN);
        this.eWN.setCurrentItem(1);
        this.mwP = new com.baidu.tieba.personPolymeric.header.c(this.eSJ, this.mIsHost);
        this.mwP.a(this.mtF);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.mwL.addView(this.mwP.getView(), layoutParams);
        if (this.mwQ.dxj()) {
            D(this.eSJ);
        }
        C(this.eSJ);
        this.gxx = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.iCS = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.mqY = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.mqZ = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.mrb = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void C(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.mwQ != null) {
                    p.this.mwQ.dxh();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.agN);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c dxk() {
        return this.mwP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends FragmentPagerAdapter {
        private List<PersonCenterTabBaseFragment> mFragments;
        private List<String> mbI;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mbI = new ArrayList();
            this.mbI.add(p.this.eSJ.getResources().getString(R.string.person_center_tab_main));
            this.mbI.add(p.this.eSJ.getResources().getString(R.string.person_center_tab_thread));
            this.mbI.add(p.this.eSJ.getResources().getString(R.string.person_center_tab_dynamic));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.q(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.r(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.p(p.this.mUserId, p.this.mIsHost));
        }

        public void GN(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.mbI.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
                if (i2 == i) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return GP(i);
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
            return GO(i);
        }

        private String GO(int i) {
            return this.mbI.get(i);
        }

        public PersonCenterTabBaseFragment GP(int i) {
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

        public void bRN() {
            if (!x.isEmpty(this.mFragments)) {
                for (int i = 0; i < this.mFragments.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.wG(false);
                    }
                }
            }
        }

        public void g(com.baidu.tieba.personPolymeric.c.a aVar) {
            if (aVar != null && !x.isEmpty(this.mFragments)) {
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
            if (aVar != null && aVar.getThreadUser() != null && !x.isEmpty(this.mFragments)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.mFragments.size()) {
                        PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i2);
                        if (personCenterTabBaseFragment != null) {
                            personCenterTabBaseFragment.a(aVar.ePn);
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
            if (x.isEmpty(this.mFragments)) {
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

    private boolean bRf() {
        return this.mwG.getVisibility() == 0;
    }

    public void bRg() {
        if (!bRf() && this.mwN == null) {
            this.mwG.setVisibility(0);
            if (this.mwN == null) {
                this.mwN = new AlphaAnimation(0.0f, 1.0f);
                this.mwN.setFillAfter(true);
                this.mwN.setDuration(300L);
                this.mwN.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.14
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.mwN.reset();
                        p.this.mwN = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.mwG.startAnimation(this.mwN);
            }
        }
    }

    public void dxl() {
        if (bRf() && this.mwO == null && this.mwO == null) {
            this.mwO = new AlphaAnimation(1.0f, 0.0f);
            this.mwO.setFillAfter(true);
            this.mwO.setDuration(300L);
            this.mwO.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.15
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.mwG.setVisibility(8);
                    p.this.mwO.reset();
                    p.this.mwO = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mwG.startAnimation(this.mwO);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mwQ != null) {
            this.mwQ.onChangeSkinType(i);
        }
        if (this.iDH != null) {
            this.iDH.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.iDH.setRectPaintColor(R.color.CAM_X0302);
            this.iDH.onChangeSkinType();
        }
        if (this.mwK != null) {
            this.mwK.setColor(ao.getColor(R.color.CAM_X0201));
        }
        if (this.mwP != null) {
            this.mwP.onChangeSkinType(i);
        }
        if (this.mwH != null) {
            this.mwH.onChangeSkinType(i);
        }
        if (this.gxx != null) {
            this.gxx.onChangeSkinType(this.eSJ, i);
        }
        if (this.iCS != null) {
            this.iCS.onChangeSkinType(this.eSJ, i);
        }
        ao.setBackgroundResource(this.mqY, R.color.CAM_X0201);
        ao.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
        ao.setBackgroundResource(this.mwG, R.drawable.personalize_tab_shadow);
    }

    public void dvY() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.mwx.resetData();
            this.mwx.refreshData();
            this.mrh.doRefresh();
            return;
        }
        this.mrh.cIV();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        if (this.mwQ != null) {
            this.mwQ.setOnViewResponseListener(fVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.mrx = aVar;
            this.mqY.setVisibility(8);
            this.mrb.setVisibility(0);
            if (this.mwQ != null) {
                this.mwQ.a(aVar, personStatus);
            }
            if (this.mwP != null) {
                this.mwP.b(aVar);
            }
            if (this.mwE != null) {
                this.mwE.d(this.mrx.getUserData());
            }
            this.mwL.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.2
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.mwI == 0) {
                        p.this.mwI = p.this.mwL.getMeasuredHeight();
                        p.this.mwC = p.this.mwL.getMeasuredHeight() - p.this.mwQ.dxi().getMeasuredHeight();
                        if (p.this.mwE != null) {
                            p.this.mwS = p.this.mStatusBarHeight + p.this.mwQ.dxi().getMeasuredHeight() + p.this.mwL.getMeasuredHeight() + p.this.iDH.getMeasuredHeight();
                            boolean z2 = (p.this.mIsHost || p.this.mrx.getUserData() == null || p.this.mrx.getUserData().getNewGodData() == null || !p.this.mrx.getUserData().getNewGodData().isNewGod()) ? false : true;
                            p.this.mwM.height = p.this.mwS;
                            p.this.mwL.setLayoutParams(p.this.mwM);
                            p.this.mwS += z2 ? com.baidu.tieba.personPolymeric.header.b.mtA : 0;
                            p.this.mwE.GI(p.this.mwS);
                            p.this.mwM.height = -2;
                            p.this.mwL.setLayoutParams(p.this.mwM);
                        }
                    }
                }
            });
            this.mwH.h(aVar);
            this.mwH.g(aVar);
            if (x.isEmpty(aVar.cRp())) {
                this.mrh.bRO();
                com.baidu.adp.lib.util.l.showToast(this.eSJ.getContext(), this.eSJ.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.dCM().xr(this.mIsHost);
            int size = aVar.cRp().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.n nVar = aVar.cRp().get(i);
                if (nVar != null && (nVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.mrh.bRO();
                    return;
                }
            }
            if (!z) {
                this.mrh.h(true, aVar.cRp());
            }
        }
    }

    public void cIV() {
        this.mrh.cIV();
    }

    private void D(TbPageContext tbPageContext) {
        this.mwy = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).mSk;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.mwP != null && aVar != null) {
                            p.this.mwP.wD(aVar.dpG);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.mrx != null) {
                            if (p.this.mrx.msn != null && p.this.mrx.msn.iMd != null && aVar2 != null) {
                                p.this.mrx.msn.iMd.putBoolean("person_center_item_red_tip_show", aVar2.dpG);
                            }
                            if (aVar3 != null && p.this.mrx.msm != null && p.this.mrx.msm.iMd != null) {
                                p.this.mrx.msm.iMd.putBoolean("person_center_item_red_tip_show", aVar3.dpG);
                            }
                            if (aVar4 != null && p.this.mrx.msl != null && p.this.mrx.msl.iMd != null) {
                                p.this.mrx.msl.iMd.putBoolean("person_center_item_red_tip_show", aVar4.dpG);
                            }
                            if (aVar5 != null && p.this.mrx.mso != null && p.this.mrx.mso.iMd != null) {
                                p.this.mrx.mso.iMd.putBoolean("person_center_item_red_tip_show", aVar5.dpG);
                            }
                            if (aVar6 != null && p.this.mrx.msp != null && p.this.mrx.msp.iMd != null) {
                                p.this.mrx.msp.iMd.putBoolean("person_center_item_red_tip_show", aVar6.dpG);
                                p.this.mrx.msp.iMd.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.mwy.setTag(this.agN);
        tbPageContext.registerListener(this.mwy);
        this.mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.n nVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n) && (nVar = (com.baidu.tbadk.data.n) customResponsedMessage.getData()) != null) {
                    p.this.mwP.PI(nVar.getImgUrl());
                }
            }
        };
        this.mUpdatePendantListener.setTag(this.agN);
        tbPageContext.registerListener(this.mUpdatePendantListener);
        this.mwz = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.mwR == ((Integer) customResponsedMessage.getData()).intValue() && p.this.jFx) {
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(p.this.jFH);
                    p.this.cKn();
                }
            }
        };
        this.mwz.setTag(this.agN);
        tbPageContext.registerListener(this.mwz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKn() {
        this.mwR = -1;
        this.jFx = false;
        if (this.mwD != null) {
            this.mwD.btO();
        }
    }

    public void onDestory() {
        if (this.mwP != null) {
            this.mwP.onDestroy();
        }
        if (this.mwD != null) {
            this.mwD.onDestroy();
        }
        if (this.fgO != null) {
            this.fgO.cancel();
            this.fgO.removeAllListeners();
            this.fgO.removeAllUpdateListeners();
            this.fgO = null;
        }
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jFH);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.mwx = aVar;
    }
}
