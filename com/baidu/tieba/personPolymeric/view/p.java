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
    public static int iQS = 5000;
    private static final float lOW = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout Yg;
    private BdUniqueId aiy;
    private ValueAnimator eGY;
    private TbPageContext etO;
    private CustomViewPager ewX;
    private NoNetworkView fTu;
    private BaseFragment fgd;
    private NewPagerSlidingTabBaseStrip hRT;
    private PluginErrorTipView hRf;
    private com.baidu.tieba.personPolymeric.b.f lJF;
    private com.baidu.tieba.personPolymeric.c.a lJU;
    private LinearLayout lJw;
    protected FrameLayout lJx;
    protected RelativeLayout lJz;
    private com.baidu.tieba.model.a lOT;
    private CustomMessageListener lOU;
    private CustomMessageListener lOV;
    private PullRefreshFrameLayout lOZ;
    private com.baidu.tieba.personPolymeric.header.a lPa;
    private FrameLayout lPb;
    private View lPc;
    private a lPd;
    private int lPe;
    private int lPf;
    private GradientDrawable lPg;
    private FrameLayout lPh;
    private FrameLayout.LayoutParams lPi;
    private AlphaAnimation lPj;
    private AlphaAnimation lPk;
    private com.baidu.tieba.personPolymeric.header.c lPl;
    private k lPm;
    private int lPo;
    private boolean lPp;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private CustomMessageListener mUpdatePendantListener;
    private long mUserId;
    private float[] lOX = {lOW, lOW, lOW, lOW, 0.0f, 0.0f, 0.0f, 0.0f};
    private float lOY = 674.0f;
    private boolean iQW = false;
    private int lPn = -1;
    private Runnable iRg = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.6
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.iQW) {
                p.this.cAz();
            }
        }
    };
    private com.baidu.tieba.personPolymeric.b.a lMb = new com.baidu.tieba.personPolymeric.b.a() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.tieba.personPolymeric.b.a
        public void BK(int i) {
            p.this.lPi.height = -2;
            p.this.lPh.setLayoutParams(p.this.lPi);
        }

        @Override // com.baidu.tieba.personPolymeric.b.a
        public void gO(boolean z) {
            p.this.lPp = z;
            if (!z) {
                p.this.lPa.GA(p.this.lPo);
            }
            if (p.this.lPl != null && p.this.lPl.dqy() != null) {
                p.this.lPl.dqy().setOpen(z);
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.g gVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.fgd = baseFragment;
        this.etO = baseFragment.getPageContext();
        this.aiy = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.lJF = gVar.dpH();
        an(gVar.mRootView);
    }

    private void an(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.lOZ = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.lPa = new com.baidu.tieba.personPolymeric.header.a(this.etO, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.lPm = new k(this.etO, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.lPh = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.lPi = (FrameLayout.LayoutParams) this.lPh.getLayoutParams();
        this.lOZ.setOnTouchCallback(new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void w(double d) {
                p.this.lPi.height = (int) ((p.this.lPp ? com.baidu.tieba.personPolymeric.header.b.lLW : 0) + p.this.lPe + (PullRefreshFrameLayout.eGE * d));
                p.this.lPh.setLayoutParams(p.this.lPi);
                if (p.this.lPa != null) {
                    p.this.lPa.C(d);
                }
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                p.this.eGY = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.eGY.setDuration(150L);
                final int measuredHeight = p.this.lPh.getMeasuredHeight();
                final int ctu = p.this.lPa.ctu();
                p.this.eGY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.lPi.height = (int) (measuredHeight - (i * animatedFraction));
                        p.this.lPh.setLayoutParams(p.this.lPi);
                        if (p.this.lPa != null) {
                            p.this.lPa.GB((int) (ctu - (animatedFraction * i)));
                        }
                    }
                });
                p.this.eGY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.lPf = p.this.lPi.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.eGY.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void boj() {
                final int measuredHeight = p.this.lPh.getMeasuredHeight();
                final int i = (measuredHeight - p.this.lPe) - (p.this.lPp ? com.baidu.tieba.personPolymeric.header.b.lLW : 0);
                final int ctu = p.this.lPa != null ? p.this.lPa.ctu() : 0;
                if (p.this.lPp) {
                    p.this.lPl.vA(false);
                    p.this.lPl.dpZ();
                }
                if (i > 0 || (i == 0 && p.this.lPp)) {
                    p.this.eGY = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.eGY.setDuration(300L);
                    p.this.eGY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.lPi.height = (int) (measuredHeight - (i * floatValue));
                            p.this.lPh.setLayoutParams(p.this.lPi);
                            if (p.this.lPa != null && ctu > 0) {
                                p.this.lPa.GB((int) (ctu - (floatValue * i)));
                            }
                        }
                    });
                    p.this.eGY.start();
                    p.this.eGY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (p.this.lPp) {
                                p.this.lPl.dqa();
                            }
                            p.this.lPf = 0;
                            p.this.lPi.height = -2;
                            p.this.lPh.setLayoutParams(p.this.lPi);
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
        this.lOZ.setOnPullRefreshListener(new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.personPolymeric.view.p.8
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void boi() {
                com.baidu.adp.lib.f.e.mY().postDelayed(p.this.iRg, p.iQS);
                p.this.iQW = true;
                p.this.lPn = p.this.lPd.getCurrentTabType();
                p.this.dpy();
                p.this.lPd.bKT();
            }
        });
        this.lOZ.setOnCancelCallBack(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void onCancel() {
                p.this.lPf = 0;
                p.this.lPi.height = -2;
                p.this.lPh.setLayoutParams(p.this.lPi);
            }
        });
        this.lOZ.setOnLoadingStartCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.10
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void boh() {
                p.this.lPi.height = -2;
                p.this.lPh.setLayoutParams(p.this.lPi);
            }
        });
        this.Yg = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.Yg.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.11
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.etO.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.etO.getPageActivity());
                }
                p.this.lOZ.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.lPm.vG(abs == 0);
                p.this.lPm.vH(((float) abs) > p.this.lOY / 2.0f);
                float abs2 = ((double) p.this.lOY) == 0.0d ? 0.0f : Math.abs(abs / p.this.lOY);
                p.this.lPm.aG(abs2);
                if (abs2 >= 1.0f) {
                    p.this.lOX = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.lPg.setCornerRadii(p.this.lOX);
                    p.this.lPb.setBackgroundDrawable(p.this.lPg);
                    p.this.bKo();
                } else {
                    p.this.lOX = new float[]{p.lOW, p.lOW, p.lOW, p.lOW, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.lPg.setCornerRadii(p.this.lOX);
                    p.this.lPb.setBackgroundDrawable(p.this.lPg);
                    p.this.dqL();
                }
                int i2 = p.this.lPf - p.this.lPe;
                if (p.this.lPf > 0 && Math.abs(i) >= i2) {
                    p.this.lOZ.dismissLoading();
                }
            }
        });
        this.lPb = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.hRT = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.hRT.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.hRT.setRectPaintColor(R.color.cp_link_tip_a);
        this.hRT.a(com.baidu.adp.lib.util.l.getDimens(this.etO.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.etO.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.etO.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.etO.getPageActivity(), R.dimen.tbds46), true);
        this.hRT.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.etO.getPageActivity(), R.dimen.tbds64));
        this.hRT.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.etO.getPageActivity(), R.dimen.tbds8));
        this.hRT.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.etO.getPageActivity(), R.dimen.tbds8));
        this.hRT.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.etO.getPageActivity(), R.dimen.tbds0));
        this.hRT.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.etO.getPageActivity(), R.dimen.tbds166), -1));
        this.hRT.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.12
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.lPd.GF(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.lPg = new GradientDrawable();
        this.lPg.setColor(ap.getColor(R.color.cp_bg_line_d));
        this.lPg.setCornerRadii(this.lOX);
        this.lPb.setBackgroundDrawable(this.lPg);
        this.lPc = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        ap.setBackgroundResource(this.lPc, R.drawable.personalize_tab_shadow);
        this.ewX = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.lPd = new a(this.fgd.getActivity().getSupportFragmentManager());
        this.ewX.setAdapter(this.lPd);
        this.ewX.setOffscreenPageLimit(this.lPd.mFragments.size());
        this.lPd.notifyDataSetChanged();
        this.hRT.setViewPager(this.ewX);
        this.ewX.setCurrentItem(1);
        this.lPl = new com.baidu.tieba.personPolymeric.header.c(this.etO, this.mIsHost);
        this.lPl.a(this.lMb);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.lPh.addView(this.lPl.getView(), layoutParams);
        if (this.lPm.dqJ()) {
            E(this.etO);
        }
        D(this.etO);
        this.fTu = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.hRf = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.lJw = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.lJx = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.lJz = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void D(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.lPm != null) {
                    p.this.lPm.dqH();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.aiy);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c dqK() {
        return this.lPl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a extends FragmentPagerAdapter {
        private List<String> lum;
        private List<PersonCenterTabBaseFragment> mFragments;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.lum = new ArrayList();
            this.lum.add(p.this.etO.getResources().getString(R.string.person_center_tab_main));
            this.lum.add(p.this.etO.getResources().getString(R.string.person_center_tab_thread));
            this.lum.add(p.this.etO.getResources().getString(R.string.person_center_tab_dynamic));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.n(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.o(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.m(p.this.mUserId, p.this.mIsHost));
        }

        public void GF(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.lum.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
                if (i2 == i) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return GH(i);
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
            return GG(i);
        }

        private String GG(int i) {
            return this.lum.get(i);
        }

        public PersonCenterTabBaseFragment GH(int i) {
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

        public void bKT() {
            if (!y.isEmpty(this.mFragments)) {
                for (int i = 0; i < this.mFragments.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.vC(false);
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
                            personCenterTabBaseFragment.a(aVar.equ);
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

    private boolean bKn() {
        return this.lPc.getVisibility() == 0;
    }

    public void bKo() {
        if (!bKn() && this.lPj == null) {
            this.lPc.setVisibility(0);
            if (this.lPj == null) {
                this.lPj = new AlphaAnimation(0.0f, 1.0f);
                this.lPj.setFillAfter(true);
                this.lPj.setDuration(300L);
                this.lPj.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.14
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.lPj.reset();
                        p.this.lPj = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.lPc.startAnimation(this.lPj);
            }
        }
    }

    public void dqL() {
        if (bKn() && this.lPk == null && this.lPk == null) {
            this.lPk = new AlphaAnimation(1.0f, 0.0f);
            this.lPk.setFillAfter(true);
            this.lPk.setDuration(300L);
            this.lPk.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.15
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.lPc.setVisibility(8);
                    p.this.lPk.reset();
                    p.this.lPk = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.lPc.startAnimation(this.lPk);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lPm != null) {
            this.lPm.onChangeSkinType(i);
        }
        if (this.hRT != null) {
            this.hRT.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
            this.hRT.setRectPaintColor(R.color.cp_link_tip_a);
            this.hRT.onChangeSkinType();
        }
        if (this.lPg != null) {
            this.lPg.setColor(ap.getColor(R.color.cp_bg_line_d));
        }
        if (this.lPl != null) {
            this.lPl.onChangeSkinType(i);
        }
        if (this.lPd != null) {
            this.lPd.onChangeSkinType(i);
        }
        if (this.fTu != null) {
            this.fTu.onChangeSkinType(this.etO, i);
        }
        if (this.hRf != null) {
            this.hRf.onChangeSkinType(this.etO, i);
        }
        ap.setBackgroundResource(this.lJw, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.lPc, R.drawable.personalize_tab_shadow);
    }

    public void dpy() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.lOT.resetData();
            this.lOT.refreshData();
            this.lJF.doRefresh();
            return;
        }
        this.lJF.czl();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        if (this.lPm != null) {
            this.lPm.setOnViewResponseListener(fVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.lJU = aVar;
            this.lJw.setVisibility(8);
            this.lJz.setVisibility(0);
            if (this.lPm != null) {
                this.lPm.a(aVar, personStatus);
            }
            if (this.lPl != null) {
                this.lPl.b(aVar);
            }
            if (this.lPa != null) {
                this.lPa.e(this.lJU.getUserData());
            }
            this.lPh.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.2
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.lPe == 0) {
                        p.this.lPe = p.this.lPh.getMeasuredHeight();
                        p.this.lOY = p.this.lPh.getMeasuredHeight() - p.this.lPm.dqI().getMeasuredHeight();
                        if (p.this.lPa != null) {
                            p.this.lPo = p.this.mStatusBarHeight + p.this.lPm.dqI().getMeasuredHeight() + p.this.lPh.getMeasuredHeight() + p.this.hRT.getMeasuredHeight();
                            boolean z2 = (p.this.mIsHost || p.this.lJU.getUserData() == null || p.this.lJU.getUserData().getNewGodData() == null || !p.this.lJU.getUserData().getNewGodData().isNewGod()) ? false : true;
                            p.this.lPi.height = p.this.lPo;
                            p.this.lPh.setLayoutParams(p.this.lPi);
                            p.this.lPo += z2 ? com.baidu.tieba.personPolymeric.header.b.lLW : 0;
                            p.this.lPa.GA(p.this.lPo);
                            p.this.lPi.height = -2;
                            p.this.lPh.setLayoutParams(p.this.lPi);
                        }
                    }
                }
            });
            this.lPd.h(aVar);
            this.lPd.g(aVar);
            if (y.isEmpty(aVar.cHw())) {
                this.lJF.bKU();
                com.baidu.adp.lib.util.l.showToast(this.etO.getContext(), this.etO.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.dwo().wn(this.mIsHost);
            int size = aVar.cHw().size();
            for (int i = 0; i < size; i++) {
                q qVar = aVar.cHw().get(i);
                if (qVar != null && (qVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.lJF.bKU();
                    return;
                }
            }
            if (!z) {
                this.lJF.h(true, aVar.cHw());
            }
        }
    }

    public void czl() {
        this.lJF.czl();
    }

    private void E(TbPageContext tbPageContext) {
        this.lOU = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).mkx;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.lPl != null && aVar != null) {
                            p.this.lPl.vz(aVar.cVI);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.lJU != null) {
                            if (p.this.lJU.lKJ != null && p.this.lJU.lKJ.iar != null && aVar2 != null) {
                                p.this.lJU.lKJ.iar.putBoolean("person_center_item_red_tip_show", aVar2.cVI);
                            }
                            if (aVar3 != null && p.this.lJU.lKI != null && p.this.lJU.lKI.iar != null) {
                                p.this.lJU.lKI.iar.putBoolean("person_center_item_red_tip_show", aVar3.cVI);
                            }
                            if (aVar4 != null && p.this.lJU.lKH != null && p.this.lJU.lKH.iar != null) {
                                p.this.lJU.lKH.iar.putBoolean("person_center_item_red_tip_show", aVar4.cVI);
                            }
                            if (aVar5 != null && p.this.lJU.lKK != null && p.this.lJU.lKK.iar != null) {
                                p.this.lJU.lKK.iar.putBoolean("person_center_item_red_tip_show", aVar5.cVI);
                            }
                            if (aVar6 != null && p.this.lJU.lKL != null && p.this.lJU.lKL.iar != null) {
                                p.this.lJU.lKL.iar.putBoolean("person_center_item_red_tip_show", aVar6.cVI);
                                p.this.lJU.lKL.iar.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.lOU.setTag(this.aiy);
        tbPageContext.registerListener(this.lOU);
        this.mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.m mVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && (mVar = (com.baidu.tbadk.data.m) customResponsedMessage.getData()) != null) {
                    p.this.lPl.PR(mVar.bgd());
                }
            }
        };
        this.mUpdatePendantListener.setTag(this.aiy);
        tbPageContext.registerListener(this.mUpdatePendantListener);
        this.lOV = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.lPn == ((Integer) customResponsedMessage.getData()).intValue() && p.this.iQW) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(p.this.iRg);
                    p.this.cAz();
                }
            }
        };
        this.lOV.setTag(this.aiy);
        tbPageContext.registerListener(this.lOV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAz() {
        this.lPn = -1;
        this.iQW = false;
        if (this.lOZ != null) {
            this.lOZ.bof();
        }
    }

    public void onDestory() {
        if (this.lPl != null) {
            this.lPl.onDestroy();
        }
        if (this.lOZ != null) {
            this.lOZ.onDestroy();
        }
        if (this.eGY != null) {
            this.eGY.cancel();
            this.eGY.removeAllListeners();
            this.eGY.removeAllUpdateListeners();
            this.eGY = null;
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iRg);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.lOT = aVar;
    }
}
