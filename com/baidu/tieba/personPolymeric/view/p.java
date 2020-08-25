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
    public static int iuA = 5000;
    private static final float lqD = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout Xv;
    private BdUniqueId ahK;
    private BaseFragment eRa;
    private TbPageContext efn;
    private CustomViewPager eiw;
    private ValueAnimator esF;
    private NoNetworkView fDV;
    private PluginErrorTipView huZ;
    private NewPagerSlidingTabBaseStrip hvN;
    private com.baidu.tieba.personPolymeric.c.a llA;
    private LinearLayout llc;
    protected FrameLayout lld;
    protected RelativeLayout llf;
    private com.baidu.tieba.personPolymeric.b.f lll;
    private com.baidu.tieba.model.a lqA;
    private CustomMessageListener lqB;
    private CustomMessageListener lqC;
    private PullRefreshFrameLayout lqG;
    private com.baidu.tieba.personPolymeric.header.a lqH;
    private FrameLayout lqI;
    private View lqJ;
    private a lqK;
    private int lqL;
    private int lqM;
    private GradientDrawable lqN;
    private FrameLayout lqO;
    private FrameLayout.LayoutParams lqP;
    private AlphaAnimation lqQ;
    private AlphaAnimation lqR;
    private com.baidu.tieba.personPolymeric.header.c lqS;
    private k lqT;
    private int lqV;
    private boolean lqW;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private CustomMessageListener mUpdatePendantListener;
    private long mUserId;
    private float[] lqE = {lqD, lqD, lqD, lqD, 0.0f, 0.0f, 0.0f, 0.0f};
    private float lqF = 674.0f;
    private boolean iuE = false;
    private int lqU = -1;
    private Runnable iuO = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.6
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.iuE) {
                p.this.ctJ();
            }
        }
    };
    private com.baidu.tieba.personPolymeric.b.a lnE = new com.baidu.tieba.personPolymeric.b.a() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.tieba.personPolymeric.b.a
        public void AD(int i) {
            p.this.lqP.height = -2;
            p.this.lqO.setLayoutParams(p.this.lqP);
        }

        @Override // com.baidu.tieba.personPolymeric.b.a
        public void gt(boolean z) {
            p.this.lqW = z;
            if (!z) {
                p.this.lqH.Ft(p.this.lqV);
            }
            if (p.this.lqS != null && p.this.lqS.dje() != null) {
                p.this.lqS.dje().setOpen(z);
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.g gVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.eRa = baseFragment;
        this.efn = baseFragment.getPageContext();
        this.ahK = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.lll = gVar.dip();
        ak(gVar.mRootView);
    }

    private void ak(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.lqG = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.lqH = new com.baidu.tieba.personPolymeric.header.a(this.efn, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.lqT = new k(this.efn, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.lqO = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.lqP = (FrameLayout.LayoutParams) this.lqO.getLayoutParams();
        this.lqG.setOnTouchCallback(new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void t(double d) {
                p.this.lqP.height = (int) ((p.this.lqW ? com.baidu.tieba.personPolymeric.header.b.lnz : 0) + p.this.lqL + (PullRefreshFrameLayout.esl * d));
                p.this.lqO.setLayoutParams(p.this.lqP);
                if (p.this.lqH != null) {
                    p.this.lqH.z(d);
                }
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                p.this.esF = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.esF.setDuration(150L);
                final int measuredHeight = p.this.lqO.getMeasuredHeight();
                final int cmJ = p.this.lqH.cmJ();
                p.this.esF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.lqP.height = (int) (measuredHeight - (i * animatedFraction));
                        p.this.lqO.setLayoutParams(p.this.lqP);
                        if (p.this.lqH != null) {
                            p.this.lqH.Fu((int) (cmJ - (animatedFraction * i)));
                        }
                    }
                });
                p.this.esF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.lqM = p.this.lqP.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.esF.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void bkE() {
                final int measuredHeight = p.this.lqO.getMeasuredHeight();
                final int i = (measuredHeight - p.this.lqL) - (p.this.lqW ? com.baidu.tieba.personPolymeric.header.b.lnz : 0);
                final int cmJ = p.this.lqH != null ? p.this.lqH.cmJ() : 0;
                if (p.this.lqW) {
                    p.this.lqS.uJ(false);
                    p.this.lqS.diH();
                }
                if (i > 0 || (i == 0 && p.this.lqW)) {
                    p.this.esF = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.esF.setDuration(300L);
                    p.this.esF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.lqP.height = (int) (measuredHeight - (i * floatValue));
                            p.this.lqO.setLayoutParams(p.this.lqP);
                            if (p.this.lqH != null && cmJ > 0) {
                                p.this.lqH.Fu((int) (cmJ - (floatValue * i)));
                            }
                        }
                    });
                    p.this.esF.start();
                    p.this.esF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (p.this.lqW) {
                                p.this.lqS.diI();
                            }
                            p.this.lqM = 0;
                            p.this.lqP.height = -2;
                            p.this.lqO.setLayoutParams(p.this.lqP);
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
        this.lqG.setOnPullRefreshListener(new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.personPolymeric.view.p.8
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bkD() {
                com.baidu.adp.lib.f.e.mS().postDelayed(p.this.iuO, p.iuA);
                p.this.iuE = true;
                p.this.lqU = p.this.lqK.getCurrentTabType();
                p.this.dig();
                p.this.lqK.bGQ();
            }
        });
        this.lqG.setOnCancelCallBack(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void onCancel() {
                p.this.lqM = 0;
                p.this.lqP.height = -2;
                p.this.lqO.setLayoutParams(p.this.lqP);
            }
        });
        this.lqG.setOnLoadingStartCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.10
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void bkC() {
                p.this.lqP.height = -2;
                p.this.lqO.setLayoutParams(p.this.lqP);
            }
        });
        this.Xv = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.Xv.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.11
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.efn.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.efn.getPageActivity());
                }
                p.this.lqG.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.lqT.uP(abs == 0);
                p.this.lqT.uQ(((float) abs) > p.this.lqF / 2.0f);
                float abs2 = ((double) p.this.lqF) == 0.0d ? 0.0f : Math.abs(abs / p.this.lqF);
                p.this.lqT.aA(abs2);
                if (abs2 >= 1.0f) {
                    p.this.lqE = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.lqN.setCornerRadii(p.this.lqE);
                    p.this.lqI.setBackgroundDrawable(p.this.lqN);
                    p.this.bGl();
                } else {
                    p.this.lqE = new float[]{p.lqD, p.lqD, p.lqD, p.lqD, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.lqN.setCornerRadii(p.this.lqE);
                    p.this.lqI.setBackgroundDrawable(p.this.lqN);
                    p.this.djr();
                }
                int i2 = p.this.lqM - p.this.lqL;
                if (p.this.lqM > 0 && Math.abs(i) >= i2) {
                    p.this.lqG.dismissLoading();
                }
            }
        });
        this.lqI = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.hvN = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.hvN.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.hvN.setRectPaintColor(R.color.cp_link_tip_a);
        this.hvN.a(com.baidu.adp.lib.util.l.getDimens(this.efn.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.efn.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.efn.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.efn.getPageActivity(), R.dimen.tbds46), true);
        this.hvN.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.efn.getPageActivity(), R.dimen.tbds64));
        this.hvN.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.efn.getPageActivity(), R.dimen.tbds8));
        this.hvN.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.efn.getPageActivity(), R.dimen.tbds8));
        this.hvN.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.efn.getPageActivity(), R.dimen.tbds0));
        this.hvN.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.efn.getPageActivity(), R.dimen.tbds166), -1));
        this.hvN.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.12
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.lqK.Fy(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.lqN = new GradientDrawable();
        this.lqN.setColor(ap.getColor(R.color.cp_bg_line_d));
        this.lqN.setCornerRadii(this.lqE);
        this.lqI.setBackgroundDrawable(this.lqN);
        this.lqJ = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        ap.setBackgroundResource(this.lqJ, R.drawable.personalize_tab_shadow);
        this.eiw = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.lqK = new a(this.eRa.getActivity().getSupportFragmentManager());
        this.eiw.setAdapter(this.lqK);
        this.eiw.setOffscreenPageLimit(this.lqK.mFragments.size());
        this.lqK.notifyDataSetChanged();
        this.hvN.setViewPager(this.eiw);
        this.eiw.setCurrentItem(1);
        this.lqS = new com.baidu.tieba.personPolymeric.header.c(this.efn, this.mIsHost);
        this.lqS.a(this.lnE);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.lqO.addView(this.lqS.getView(), layoutParams);
        if (this.lqT.djp()) {
            E(this.efn);
        }
        D(this.efn);
        this.fDV = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.huZ = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.llc = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.lld = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.llf = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void D(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.lqT != null) {
                    p.this.lqT.djn();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.ahK);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c djq() {
        return this.lqS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends FragmentPagerAdapter {
        private List<String> kWj;
        private List<PersonCenterTabBaseFragment> mFragments;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.kWj = new ArrayList();
            this.kWj.add(p.this.efn.getResources().getString(R.string.person_center_tab_main));
            this.kWj.add(p.this.efn.getResources().getString(R.string.person_center_tab_thread));
            this.kWj.add(p.this.efn.getResources().getString(R.string.person_center_tab_dynamic));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.l(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.m(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.k(p.this.mUserId, p.this.mIsHost));
        }

        public void Fy(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.kWj.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
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
            return this.kWj.get(i);
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

        public void bGQ() {
            if (!y.isEmpty(this.mFragments)) {
                for (int i = 0; i < this.mFragments.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.uL(false);
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

    private boolean bGk() {
        return this.lqJ.getVisibility() == 0;
    }

    public void bGl() {
        if (!bGk() && this.lqQ == null) {
            this.lqJ.setVisibility(0);
            if (this.lqQ == null) {
                this.lqQ = new AlphaAnimation(0.0f, 1.0f);
                this.lqQ.setFillAfter(true);
                this.lqQ.setDuration(300L);
                this.lqQ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.14
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.lqQ.reset();
                        p.this.lqQ = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.lqJ.startAnimation(this.lqQ);
            }
        }
    }

    public void djr() {
        if (bGk() && this.lqR == null && this.lqR == null) {
            this.lqR = new AlphaAnimation(1.0f, 0.0f);
            this.lqR.setFillAfter(true);
            this.lqR.setDuration(300L);
            this.lqR.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.15
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.lqJ.setVisibility(8);
                    p.this.lqR.reset();
                    p.this.lqR = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.lqJ.startAnimation(this.lqR);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lqT != null) {
            this.lqT.onChangeSkinType(i);
        }
        if (this.hvN != null) {
            this.hvN.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
            this.hvN.setRectPaintColor(R.color.cp_link_tip_a);
            this.hvN.onChangeSkinType();
        }
        if (this.lqN != null) {
            this.lqN.setColor(ap.getColor(R.color.cp_bg_line_d));
        }
        if (this.lqS != null) {
            this.lqS.onChangeSkinType(i);
        }
        if (this.lqK != null) {
            this.lqK.onChangeSkinType(i);
        }
        if (this.fDV != null) {
            this.fDV.onChangeSkinType(this.efn, i);
        }
        if (this.huZ != null) {
            this.huZ.onChangeSkinType(this.efn, i);
        }
        ap.setBackgroundResource(this.llc, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.lqJ, R.drawable.personalize_tab_shadow);
    }

    public void dig() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.lqA.resetData();
            this.lqA.refreshData();
            this.lll.doRefresh();
            return;
        }
        this.lll.csy();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        if (this.lqT != null) {
            this.lqT.setOnViewResponseListener(fVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.llA = aVar;
            this.llc.setVisibility(8);
            this.llf.setVisibility(0);
            if (this.lqT != null) {
                this.lqT.a(aVar, personStatus);
            }
            if (this.lqS != null) {
                this.lqS.b(aVar);
            }
            if (this.lqH != null) {
                this.lqH.e(this.llA.getUserData());
            }
            this.lqO.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.2
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.lqL == 0) {
                        p.this.lqL = p.this.lqO.getMeasuredHeight();
                        p.this.lqF = p.this.lqO.getMeasuredHeight() - p.this.lqT.djo().getMeasuredHeight();
                        if (p.this.lqH != null) {
                            p.this.lqV = p.this.mStatusBarHeight + p.this.lqT.djo().getMeasuredHeight() + p.this.lqO.getMeasuredHeight() + p.this.hvN.getMeasuredHeight();
                            boolean z2 = (p.this.mIsHost || p.this.llA.getUserData() == null || p.this.llA.getUserData().getNewGodData() == null || !p.this.llA.getUserData().getNewGodData().isNewGod()) ? false : true;
                            p.this.lqP.height = p.this.lqV;
                            p.this.lqO.setLayoutParams(p.this.lqP);
                            p.this.lqV += z2 ? com.baidu.tieba.personPolymeric.header.b.lnz : 0;
                            p.this.lqH.Ft(p.this.lqV);
                            p.this.lqP.height = -2;
                            p.this.lqO.setLayoutParams(p.this.lqP);
                        }
                    }
                }
            });
            this.lqK.h(aVar);
            this.lqK.g(aVar);
            if (y.isEmpty(aVar.cAf())) {
                this.lll.bGT();
                com.baidu.adp.lib.util.l.showToast(this.efn.getContext(), this.efn.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.doQ().vw(this.mIsHost);
            int size = aVar.cAf().size();
            for (int i = 0; i < size; i++) {
                q qVar = aVar.cAf().get(i);
                if (qVar != null && (qVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.lll.bGT();
                    return;
                }
            }
            if (!z) {
                this.lll.h(true, aVar.cAf());
            }
        }
    }

    public void csy() {
        this.lll.csy();
    }

    private void E(TbPageContext tbPageContext) {
        this.lqB = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).lLJ;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.lqS != null && aVar != null) {
                            p.this.lqS.uI(aVar.cHB);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.llA != null) {
                            if (p.this.llA.lmp != null && p.this.llA.lmp.hEo != null && aVar2 != null) {
                                p.this.llA.lmp.hEo.putBoolean("person_center_item_red_tip_show", aVar2.cHB);
                            }
                            if (aVar3 != null && p.this.llA.lmo != null && p.this.llA.lmo.hEo != null) {
                                p.this.llA.lmo.hEo.putBoolean("person_center_item_red_tip_show", aVar3.cHB);
                            }
                            if (aVar4 != null && p.this.llA.lmn != null && p.this.llA.lmn.hEo != null) {
                                p.this.llA.lmn.hEo.putBoolean("person_center_item_red_tip_show", aVar4.cHB);
                            }
                            if (aVar5 != null && p.this.llA.lmq != null && p.this.llA.lmq.hEo != null) {
                                p.this.llA.lmq.hEo.putBoolean("person_center_item_red_tip_show", aVar5.cHB);
                            }
                            if (aVar6 != null && p.this.llA.lmr != null && p.this.llA.lmr.hEo != null) {
                                p.this.llA.lmr.hEo.putBoolean("person_center_item_red_tip_show", aVar6.cHB);
                                p.this.llA.lmr.hEo.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.lqB.setTag(this.ahK);
        tbPageContext.registerListener(this.lqB);
        this.mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.l lVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null) {
                    p.this.lqS.OA(lVar.bcA());
                }
            }
        };
        this.mUpdatePendantListener.setTag(this.ahK);
        tbPageContext.registerListener(this.mUpdatePendantListener);
        this.lqC = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.lqU == ((Integer) customResponsedMessage.getData()).intValue() && p.this.iuE) {
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(p.this.iuO);
                    p.this.ctJ();
                }
            }
        };
        this.lqC.setTag(this.ahK);
        tbPageContext.registerListener(this.lqC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctJ() {
        this.lqU = -1;
        this.iuE = false;
        if (this.lqG != null) {
            this.lqG.bkA();
        }
    }

    public void onDestory() {
        if (this.lqS != null) {
            this.lqS.onDestroy();
        }
        if (this.lqG != null) {
            this.lqG.onDestroy();
        }
        if (this.esF != null) {
            this.esF.cancel();
            this.esF.removeAllListeners();
            this.esF.removeAllUpdateListeners();
            this.esF = null;
        }
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iuO);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.lqA = aVar;
    }
}
