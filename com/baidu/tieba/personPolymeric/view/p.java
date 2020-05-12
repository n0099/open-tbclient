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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
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
/* loaded from: classes11.dex */
public class p {
    public static int hxG = 5000;
    private static final float kew = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout Wc;
    private BdUniqueId afD;
    private ValueAnimator dGZ;
    private TbPageContext duK;
    private CustomViewPager dxC;
    private NoNetworkView ePq;
    private BaseFragment eda;
    private PluginErrorTipView gAN;
    private NewPagerSlidingTabBaseStrip gBC;
    private CustomMessageListener jTd;
    private com.baidu.tieba.personPolymeric.c.a jZL;
    private LinearLayout jZn;
    protected FrameLayout jZo;
    protected RelativeLayout jZq;
    private com.baidu.tieba.personPolymeric.b.e jZw;
    private PullRefreshFrameLayout keA;
    private com.baidu.tieba.personPolymeric.header.a keB;
    private FrameLayout keC;
    private View keD;
    private a keE;
    private int keF;
    private int keG;
    private GradientDrawable keH;
    private FrameLayout keI;
    private FrameLayout.LayoutParams keJ;
    private AlphaAnimation keK;
    private AlphaAnimation keL;
    private com.baidu.tieba.personPolymeric.header.c keM;
    private k keN;
    private com.baidu.tieba.model.a ket;
    private CustomMessageListener keu;
    private CustomMessageListener kev;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private long mUserId;
    private float[] kex = {kew, kew, kew, kew, 0.0f, 0.0f, 0.0f, 0.0f};
    private float kez = 674.0f;
    private boolean hxK = false;
    private int keO = -1;
    private Runnable hxU = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.hxK) {
                p.this.bVH();
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.f fVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.eda = baseFragment;
        this.duK = baseFragment.getPageContext();
        this.afD = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.jZw = fVar.cHT();
        ag(fVar.mRootView);
    }

    private void ag(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.keA = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.keB = new com.baidu.tieba.personPolymeric.header.a(this.duK, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.keN = new k(this.duK, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.keI = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.keJ = (FrameLayout.LayoutParams) this.keI.getLayoutParams();
        this.keA.setOnTouchCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void m(double d) {
                p.this.keJ.height = (int) (p.this.keF + (PullRefreshFrameLayout.dGH * d));
                p.this.keI.setLayoutParams(p.this.keJ);
                if (p.this.keB != null) {
                    p.this.keB.r(d);
                }
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void c(final int i, double d) {
                p.this.dGZ = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.dGZ.setDuration(150L);
                final int i2 = p.this.keJ.height;
                final int bPi = p.this.keB.bPi();
                p.this.dGZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.keJ.height = (int) (i2 - (i * animatedFraction));
                        p.this.keI.setLayoutParams(p.this.keJ);
                        if (p.this.keB != null) {
                            p.this.keB.AK((int) (bPi - (animatedFraction * i)));
                        }
                    }
                });
                p.this.dGZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.keG = p.this.keJ.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.dGZ.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void aQl() {
                final int i = p.this.keJ.height;
                final int i2 = p.this.keJ.height - p.this.keF;
                final int i3 = 0;
                if (p.this.keB != null) {
                    i3 = p.this.keB.bPi();
                }
                if (i2 > 0) {
                    p.this.dGZ = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.dGZ.setDuration(300L);
                    p.this.dGZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.keJ.height = (int) (i - (i2 * floatValue));
                            p.this.keI.setLayoutParams(p.this.keJ);
                            if (p.this.keB != null && i3 > 0) {
                                p.this.keB.AK((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    p.this.dGZ.start();
                    p.this.dGZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            p.this.keG = 0;
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
        this.keA.setOnPullRefreshListener(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.5
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void aQk() {
                com.baidu.adp.lib.f.e.lb().postDelayed(p.this.hxU, p.hxG);
                p.this.hxK = true;
                p.this.keO = p.this.keE.getCurrentTabType();
                p.this.cHK();
                p.this.keE.bml();
            }
        });
        this.Wc = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.Wc.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.6
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.duK.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.duK.getPageActivity());
                }
                p.this.keA.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.keN.sL(abs == 0);
                p.this.keN.sM(((float) abs) > p.this.kez / 2.0f);
                float abs2 = ((double) p.this.kez) == 0.0d ? 0.0f : Math.abs(abs / p.this.kez);
                p.this.keN.ar(abs2);
                if (abs2 >= 1.0f) {
                    p.this.kex = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.keH.setCornerRadii(p.this.kex);
                    p.this.keC.setBackgroundDrawable(p.this.keH);
                    p.this.blG();
                } else {
                    p.this.kex = new float[]{p.kew, p.kew, p.kew, p.kew, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.keH.setCornerRadii(p.this.kex);
                    p.this.keC.setBackgroundDrawable(p.this.keH);
                    p.this.cIR();
                }
                int i2 = p.this.keG - p.this.keF;
                if (p.this.keG > 0 && Math.abs(i) >= i2) {
                    p.this.keA.aqg();
                }
            }
        });
        this.keC = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.gBC = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.gBC.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.gBC.setRectPaintColor(R.color.cp_link_tip_a);
        this.gBC.a(com.baidu.adp.lib.util.l.getDimens(this.duK.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.duK.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.duK.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.duK.getPageActivity(), R.dimen.tbds46), true);
        this.gBC.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.duK.getPageActivity(), R.dimen.tbds64));
        this.gBC.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.duK.getPageActivity(), R.dimen.tbds8));
        this.gBC.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.duK.getPageActivity(), R.dimen.tbds8));
        this.gBC.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.duK.getPageActivity(), R.dimen.tbds0));
        this.gBC.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.duK.getPageActivity(), R.dimen.tbds166), -1));
        this.gBC.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.keE.AO(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.keH = new GradientDrawable();
        this.keH.setColor(am.getColor(R.color.cp_bg_line_d));
        this.keH.setCornerRadii(this.kex);
        this.keC.setBackgroundDrawable(this.keH);
        this.keD = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        am.setBackgroundResource(this.keD, R.drawable.personalize_tab_shadow);
        this.dxC = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.keE = new a(this.eda.getActivity().getSupportFragmentManager());
        this.dxC.setAdapter(this.keE);
        this.dxC.setOffscreenPageLimit(this.keE.mFragments.size());
        this.keE.notifyDataSetChanged();
        this.gBC.setViewPager(this.dxC);
        if (this.mIsHost) {
            this.dxC.setCurrentItem(1);
        } else {
            this.dxC.setCurrentItem(0);
        }
        this.keM = new com.baidu.tieba.personPolymeric.header.c(this.duK, this.mIsHost);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.keI.addView(this.keM.getView(), layoutParams);
        if (this.keN.cIP()) {
            C(this.duK);
        }
        B(this.duK);
        this.ePq = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.gAN = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.jZn = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.jZo = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.jZq = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void B(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.keN != null) {
                    p.this.keN.cIN();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.afD);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c cIQ() {
        return this.keM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends FragmentPagerAdapter {
        private List<String> jKZ;
        private List<PersonCenterTabBaseFragment> mFragments;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.jKZ = new ArrayList();
            this.jKZ.add(p.this.duK.getResources().getString(R.string.person_center_tab_main));
            this.jKZ.add(p.this.duK.getResources().getString(R.string.person_center_tab_dynamic));
            this.jKZ.add(p.this.duK.getResources().getString(R.string.person_center_tab_thread));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.k(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.j(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.l(p.this.mUserId, p.this.mIsHost));
        }

        public void AO(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.jKZ.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
                if (i2 == i) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return AQ(i);
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
            return AP(i);
        }

        private String AP(int i) {
            return this.jKZ.get(i);
        }

        public PersonCenterTabBaseFragment AQ(int i) {
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

        public void bml() {
            if (!v.isEmpty(this.mFragments)) {
                for (int i = 0; i < this.mFragments.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.sH(false);
                    }
                }
            }
        }

        public void g(com.baidu.tieba.personPolymeric.c.a aVar) {
            if (aVar != null && !v.isEmpty(this.mFragments)) {
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
            if (aVar != null && aVar.getThreadUser() != null && !v.isEmpty(this.mFragments)) {
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
            if (v.isEmpty(this.mFragments)) {
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

    private boolean blF() {
        return this.keD.getVisibility() == 0;
    }

    public void blG() {
        if (!blF() && this.keK == null) {
            this.keD.setVisibility(0);
            if (this.keK == null) {
                this.keK = new AlphaAnimation(0.0f, 1.0f);
                this.keK.setFillAfter(true);
                this.keK.setDuration(300L);
                this.keK.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.9
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.keK.reset();
                        p.this.keK = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.keD.startAnimation(this.keK);
            }
        }
    }

    public void cIR() {
        if (blF() && this.keL == null && this.keL == null) {
            this.keL = new AlphaAnimation(1.0f, 0.0f);
            this.keL.setFillAfter(true);
            this.keL.setDuration(300L);
            this.keL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.keD.setVisibility(8);
                    p.this.keL.reset();
                    p.this.keL = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.keD.startAnimation(this.keL);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.keN != null) {
            this.keN.onChangeSkinType(i);
        }
        if (this.gBC != null) {
            this.gBC.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
            this.gBC.setRectPaintColor(R.color.cp_link_tip_a);
            this.gBC.onChangeSkinType();
        }
        if (this.keH != null) {
            this.keH.setColor(am.getColor(R.color.cp_bg_line_d));
        }
        if (this.keM != null) {
            this.keM.onChangeSkinType(i);
        }
        if (this.keE != null) {
            this.keE.onChangeSkinType(i);
        }
        if (this.ePq != null) {
            this.ePq.onChangeSkinType(this.duK, i);
        }
        if (this.gAN != null) {
            this.gAN.onChangeSkinType(this.duK, i);
        }
        am.setBackgroundResource(this.jZn, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.keD, R.drawable.personalize_tab_shadow);
    }

    public void cHK() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.ket.resetData();
            this.ket.refreshData();
            this.jZw.doRefresh();
            return;
        }
        this.jZw.bUx();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        if (this.keN != null) {
            this.keN.setOnViewResponseListener(fVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.jZL = aVar;
            this.jZn.setVisibility(8);
            this.jZq.setVisibility(0);
            if (this.keN != null) {
                this.keN.a(aVar, personStatus);
            }
            if (this.keM != null) {
                this.keM.b(aVar);
            }
            if (this.keB != null) {
                this.keB.e(this.jZL.getUserData());
            }
            this.keI.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.11
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.keF == 0) {
                        p.this.keF = p.this.keI.getMeasuredHeight();
                        p.this.kez = p.this.keI.getMeasuredHeight() - p.this.keN.cIO().getMeasuredHeight();
                        if (p.this.keB != null) {
                            p.this.keB.AJ(p.this.mStatusBarHeight + p.this.keN.cIO().getMeasuredHeight() + p.this.keI.getMeasuredHeight() + p.this.gBC.getMeasuredHeight());
                        }
                    }
                }
            });
            this.keE.h(aVar);
            this.keE.g(aVar);
            if (v.isEmpty(aVar.cbp())) {
                this.jZw.bmo();
                com.baidu.adp.lib.util.l.showToast(this.duK.getContext(), this.duK.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.cOJ().tq(this.mIsHost);
            int size = aVar.cbp().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.m mVar = aVar.cbp().get(i);
                if (mVar != null && (mVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.jZw.bmo();
                    return;
                }
            }
            if (!z) {
                this.jZw.e(true, aVar.cbp());
            }
        }
    }

    public void bUx() {
        this.jZw.bUx();
    }

    private void C(TbPageContext tbPageContext) {
        this.keu = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).kzV;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.keM != null && aVar != null) {
                            p.this.keM.sF(aVar.egw);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.jZL != null) {
                            if (p.this.jZL.kaD != null && p.this.jZL.kaD.gKC != null && aVar2 != null) {
                                p.this.jZL.kaD.gKC.putBoolean("person_center_item_red_tip_show", aVar2.egw);
                            }
                            if (aVar3 != null && p.this.jZL.kaC != null && p.this.jZL.kaC.gKC != null) {
                                p.this.jZL.kaC.gKC.putBoolean("person_center_item_red_tip_show", aVar3.egw);
                            }
                            if (aVar4 != null && p.this.jZL.kaB != null && p.this.jZL.kaB.gKC != null) {
                                p.this.jZL.kaB.gKC.putBoolean("person_center_item_red_tip_show", aVar4.egw);
                            }
                            if (aVar5 != null && p.this.jZL.kaE != null && p.this.jZL.kaE.gKC != null) {
                                p.this.jZL.kaE.gKC.putBoolean("person_center_item_red_tip_show", aVar5.egw);
                            }
                            if (aVar6 != null && p.this.jZL.kaF != null && p.this.jZL.kaF.gKC != null) {
                                p.this.jZL.kaF.gKC.putBoolean("person_center_item_red_tip_show", aVar6.egw);
                                p.this.jZL.kaF.gKC.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.keu.setTag(this.afD);
        tbPageContext.registerListener(this.keu);
        this.jTd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.k kVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k) && (kVar = (com.baidu.tbadk.data.k) customResponsedMessage.getData()) != null) {
                    p.this.keM.IF(kVar.aIU());
                }
            }
        };
        this.jTd.setTag(this.afD);
        tbPageContext.registerListener(this.jTd);
        this.kev = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.keO == ((Integer) customResponsedMessage.getData()).intValue() && p.this.hxK) {
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(p.this.hxU);
                    p.this.bVH();
                }
            }
        };
        this.kev.setTag(this.afD);
        tbPageContext.registerListener(this.kev);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVH() {
        this.keO = -1;
        this.hxK = false;
        if (this.keA != null) {
            this.keA.aQi();
        }
    }

    public void onDestory() {
        if (this.keM != null) {
            this.keM.onDestroy();
        }
        if (this.keA != null) {
            this.keA.onDestroy();
        }
        if (this.dGZ != null) {
            this.dGZ.cancel();
            this.dGZ.removeAllListeners();
            this.dGZ.removeAllUpdateListeners();
            this.dGZ = null;
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hxU);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.ket = aVar;
    }
}
