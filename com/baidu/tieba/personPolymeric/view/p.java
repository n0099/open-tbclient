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
import com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class p {
    public static int jsm = 5000;
    private static final float jsq = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout CD;
    private BdUniqueId MO;
    private TbPageContext cVg;
    private CustomViewPager cXZ;
    private BaseFragment dCN;
    private NoNetworkView elh;
    private PluginErrorTipView fUP;
    private NewPagerSlidingTabBaseStrip fVF;
    private CustomMessageListener jhb;
    private com.baidu.tieba.personPolymeric.c.a jnG;
    private LinearLayout jni;
    protected FrameLayout jnj;
    protected RelativeLayout jnl;
    private com.baidu.tieba.personPolymeric.b.e jnr;
    private GradientDrawable jsA;
    private FrameLayout jsB;
    private FrameLayout.LayoutParams jsC;
    private AlphaAnimation jsD;
    private AlphaAnimation jsE;
    private com.baidu.tieba.personPolymeric.header.c jsF;
    private k jsG;
    private ValueAnimator jsH;
    private com.baidu.tieba.model.a jsn;
    private CustomMessageListener jso;
    private CustomMessageListener jsp;
    private PullRefreshFrameLayout jst;
    private com.baidu.tieba.personPolymeric.header.a jsu;
    private FrameLayout jsv;
    private View jsw;
    private a jsx;
    private int jsy;
    private int jsz;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private long mUserId;
    private float[] jsr = {jsq, jsq, jsq, jsq, 0.0f, 0.0f, 0.0f, 0.0f};
    private float jss = 674.0f;
    private boolean jsI = false;
    private int jsJ = -1;
    private Runnable jsK = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.jsI) {
                p.this.cxO();
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.f fVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.dCN = baseFragment;
        this.cVg = baseFragment.getPageContext();
        this.MO = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.jnr = fVar.cwO();
        initView(fVar.mRootView);
    }

    private void initView(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.jst = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.jsu = new com.baidu.tieba.personPolymeric.header.a(this.cVg, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.jsG = new k(this.cVg, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.jsB = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.jsC = (FrameLayout.LayoutParams) this.jsB.getLayoutParams();
        this.jst.setOnTouchCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.b
            public void l(double d) {
                p.this.jsC.height = (int) (p.this.jsy + (PullRefreshFrameLayout.jtb * d));
                p.this.jsB.setLayoutParams(p.this.jsC);
                if (p.this.jsu != null) {
                    p.this.jsu.k(d);
                }
            }

            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.b
            public void c(final int i, double d) {
                p.this.jsH = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.jsH.setDuration(150L);
                final int i2 = p.this.jsC.height;
                final int cxf = p.this.jsu.cxf();
                p.this.jsH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.jsC.height = (int) (i2 - (i * animatedFraction));
                        p.this.jsB.setLayoutParams(p.this.jsC);
                        if (p.this.jsu != null) {
                            p.this.jsu.Ab((int) (cxf - (animatedFraction * i)));
                        }
                    }
                });
                p.this.jsH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.jsz = p.this.jsC.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.jsH.start();
            }

            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.b
            public void cxQ() {
                final int i = p.this.jsC.height;
                final int i2 = p.this.jsC.height - p.this.jsy;
                final int i3 = 0;
                if (p.this.jsu != null) {
                    i3 = p.this.jsu.cxf();
                }
                if (i2 > 0) {
                    p.this.jsH = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.jsH.setDuration(300L);
                    p.this.jsH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.jsC.height = (int) (i - (i2 * floatValue));
                            p.this.jsB.setLayoutParams(p.this.jsC);
                            if (p.this.jsu != null && i3 > 0) {
                                p.this.jsu.Ab((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    p.this.jsH.start();
                    p.this.jsH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            p.this.jsz = 0;
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
        this.jst.setOnPullRefreshListener(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.5
            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.a
            public void cxR() {
                com.baidu.adp.lib.f.e.gx().postDelayed(p.this.jsK, p.jsm);
                p.this.jsI = true;
                p.this.jsJ = p.this.jsx.getCurrentTabType();
                p.this.cwF();
                p.this.jsx.bdo();
            }
        });
        this.CD = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.CD.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.6
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.cVg.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.cVg.getPageActivity());
                }
                p.this.jst.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.jsG.rB(abs == 0);
                p.this.jsG.rC(((float) abs) > p.this.jss / 2.0f);
                float abs2 = ((double) p.this.jss) == 0.0d ? 0.0f : Math.abs(abs / p.this.jss);
                p.this.jsG.aH(abs2);
                if (abs2 >= 1.0f) {
                    p.this.jsr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.jsA.setCornerRadii(p.this.jsr);
                    p.this.jsv.setBackgroundDrawable(p.this.jsA);
                    p.this.bcK();
                } else {
                    p.this.jsr = new float[]{p.jsq, p.jsq, p.jsq, p.jsq, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.jsA.setCornerRadii(p.this.jsr);
                    p.this.jsv.setBackgroundDrawable(p.this.jsA);
                    p.this.cxN();
                }
                int i2 = p.this.jsz - p.this.jsy;
                if (p.this.jsz > 0 && Math.abs(i) >= i2) {
                    p.this.jst.ahU();
                }
            }
        });
        this.jsv = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.fVF = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.fVF.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.fVF.setRectPaintColor(R.color.cp_link_tip_a);
        this.fVF.a(com.baidu.adp.lib.util.l.getDimens(this.cVg.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.cVg.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.cVg.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.cVg.getPageActivity(), R.dimen.tbds46), true);
        this.fVF.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.cVg.getPageActivity(), R.dimen.tbds64));
        this.fVF.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.cVg.getPageActivity(), R.dimen.tbds8));
        this.fVF.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.cVg.getPageActivity(), R.dimen.tbds8));
        this.fVF.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.cVg.getPageActivity(), R.dimen.tbds0));
        this.fVF.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.cVg.getPageActivity(), R.dimen.tbds166), -1));
        this.fVF.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.jsx.Af(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.jsA = new GradientDrawable();
        this.jsA.setColor(am.getColor(R.color.cp_bg_line_d));
        this.jsA.setCornerRadii(this.jsr);
        this.jsv.setBackgroundDrawable(this.jsA);
        this.jsw = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        am.setBackgroundResource(this.jsw, R.drawable.personalize_tab_shadow);
        this.cXZ = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.jsx = new a(this.dCN.getActivity().getSupportFragmentManager());
        this.cXZ.setAdapter(this.jsx);
        this.cXZ.setOffscreenPageLimit(this.jsx.mFragments.size());
        this.jsx.notifyDataSetChanged();
        this.fVF.setViewPager(this.cXZ);
        if (this.mIsHost) {
            this.cXZ.setCurrentItem(1);
        } else {
            this.cXZ.setCurrentItem(0);
        }
        this.jsF = new com.baidu.tieba.personPolymeric.header.c(this.cVg, this.mIsHost);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.jsB.addView(this.jsF.getView(), layoutParams);
        if (this.jsG.cxL()) {
            z(this.cVg);
        }
        y(this.cVg);
        this.elh = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.fUP = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.jni = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.jnj = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.jnl = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void y(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.jsG != null) {
                    p.this.jsG.cxJ();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.MO);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c cxM() {
        return this.jsF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends FragmentPagerAdapter {
        private List<String> iYZ;
        private List<PersonCenterTabBaseFragment> mFragments;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.iYZ = new ArrayList();
            this.iYZ.add(p.this.cVg.getResources().getString(R.string.person_center_tab_main));
            this.iYZ.add(p.this.cVg.getResources().getString(R.string.person_center_tab_dynamic));
            this.iYZ.add(p.this.cVg.getResources().getString(R.string.person_center_tab_thread));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.j(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.i(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.k(p.this.mUserId, p.this.mIsHost));
        }

        public void Af(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.iYZ.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
                if (i2 == i) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return Ah(i);
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
            return Ag(i);
        }

        private String Ag(int i) {
            return this.iYZ.get(i);
        }

        public PersonCenterTabBaseFragment Ah(int i) {
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

        public void bdo() {
            if (!v.isEmpty(this.mFragments)) {
                for (int i = 0; i < this.mFragments.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.rx(false);
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
                            personCenterTabBaseFragment.b(aVar.getThreadUser());
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

    private boolean bcJ() {
        return this.jsw.getVisibility() == 0;
    }

    public void bcK() {
        if (!bcJ() && this.jsD == null) {
            this.jsw.setVisibility(0);
            if (this.jsD == null) {
                this.jsD = new AlphaAnimation(0.0f, 1.0f);
                this.jsD.setFillAfter(true);
                this.jsD.setDuration(300L);
                this.jsD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.9
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.jsD.reset();
                        p.this.jsD = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.jsw.startAnimation(this.jsD);
            }
        }
    }

    public void cxN() {
        if (bcJ() && this.jsE == null && this.jsE == null) {
            this.jsE = new AlphaAnimation(1.0f, 0.0f);
            this.jsE.setFillAfter(true);
            this.jsE.setDuration(300L);
            this.jsE.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.jsw.setVisibility(8);
                    p.this.jsE.reset();
                    p.this.jsE = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.jsw.startAnimation(this.jsE);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jsG != null) {
            this.jsG.onChangeSkinType(i);
        }
        if (this.fVF != null) {
            this.fVF.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
            this.fVF.setRectPaintColor(R.color.cp_link_tip_a);
            this.fVF.onChangeSkinType();
        }
        if (this.jsA != null) {
            this.jsA.setColor(am.getColor(R.color.cp_bg_line_d));
        }
        if (this.jsF != null) {
            this.jsF.onChangeSkinType(i);
        }
        if (this.jsx != null) {
            this.jsx.onChangeSkinType(i);
        }
        if (this.elh != null) {
            this.elh.onChangeSkinType(this.cVg, i);
        }
        if (this.fUP != null) {
            this.fUP.onChangeSkinType(this.cVg, i);
        }
        am.setBackgroundResource(this.jni, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.jsw, R.drawable.personalize_tab_shadow);
    }

    public void cwF() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.jsn.resetData();
            this.jsn.refreshData();
            this.jnr.doRefresh();
            return;
        }
        this.jnr.bJL();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.e eVar) {
        if (this.jsG != null) {
            this.jsG.setOnViewResponseListener(eVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.jnG = aVar;
            this.jni.setVisibility(8);
            this.jnl.setVisibility(0);
            if (this.jsG != null) {
                this.jsG.a(aVar, personStatus);
            }
            if (this.jsF != null) {
                this.jsF.b(aVar);
            }
            if (this.jsu != null) {
                this.jsu.e(this.jnG.getUserData());
            }
            this.jsB.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.11
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.jsy == 0) {
                        p.this.jsy = p.this.jsB.getMeasuredHeight();
                        p.this.jss = p.this.jsB.getMeasuredHeight() - p.this.jsG.cxK().getMeasuredHeight();
                        if (p.this.jsu != null) {
                            p.this.jsu.Aa(p.this.mStatusBarHeight + p.this.jsG.cxK().getMeasuredHeight() + p.this.jsB.getMeasuredHeight() + p.this.fVF.getMeasuredHeight());
                        }
                    }
                }
            });
            this.jsx.h(aVar);
            this.jsx.g(aVar);
            if (v.isEmpty(aVar.bQv())) {
                this.jnr.bdr();
                com.baidu.adp.lib.util.l.showToast(this.cVg.getContext(), this.cVg.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.cDN().sj(this.mIsHost);
            int size = aVar.bQv().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.m mVar = aVar.bQv().get(i);
                if (mVar != null && (mVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.jnr.bdr();
                    return;
                }
            }
            if (!z) {
                this.jnr.e(true, aVar.bQv());
            }
        }
    }

    public void bJL() {
        this.jnr.bJL();
    }

    private void z(TbPageContext tbPageContext) {
        this.jso = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).jON;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.jsF != null && aVar != null) {
                            p.this.jsF.rv(aVar.dGg);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.jnG != null) {
                            if (p.this.jnG.jox != null && p.this.jnG.jox.gaq != null && aVar2 != null) {
                                p.this.jnG.jox.gaq.putBoolean("person_center_item_red_tip_show", aVar2.dGg);
                            }
                            if (aVar3 != null && p.this.jnG.jow != null && p.this.jnG.jow.gaq != null) {
                                p.this.jnG.jow.gaq.putBoolean("person_center_item_red_tip_show", aVar3.dGg);
                            }
                            if (aVar4 != null && p.this.jnG.jov != null && p.this.jnG.jov.gaq != null) {
                                p.this.jnG.jov.gaq.putBoolean("person_center_item_red_tip_show", aVar4.dGg);
                            }
                            if (aVar5 != null && p.this.jnG.joy != null && p.this.jnG.joy.gaq != null) {
                                p.this.jnG.joy.gaq.putBoolean("person_center_item_red_tip_show", aVar5.dGg);
                            }
                            if (aVar6 != null && p.this.jnG.joz != null && p.this.jnG.joz.gaq != null) {
                                p.this.jnG.joz.gaq.putBoolean("person_center_item_red_tip_show", aVar6.dGg);
                                p.this.jnG.joz.gaq.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.jso.setTag(this.MO);
        tbPageContext.registerListener(this.jso);
        this.jhb = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.m mVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && (mVar = (com.baidu.tbadk.data.m) customResponsedMessage.getData()) != null) {
                    p.this.jsF.GU(mVar.aAE());
                }
            }
        };
        this.jhb.setTag(this.MO);
        tbPageContext.registerListener(this.jhb);
        this.jsp = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.jsJ == ((Integer) customResponsedMessage.getData()).intValue() && p.this.jsI) {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(p.this.jsK);
                    p.this.cxO();
                }
            }
        };
        this.jsp.setTag(this.MO);
        tbPageContext.registerListener(this.jsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxO() {
        this.jsJ = -1;
        this.jsI = false;
        if (this.jst != null) {
            this.jst.cxT();
        }
    }

    public void onDestory() {
        if (this.jsF != null) {
            this.jsF.onDestroy();
        }
        if (this.jst != null) {
            this.jst.onDestroy();
        }
        if (this.jsH != null) {
            this.jsH.cancel();
            this.jsH.removeAllListeners();
            this.jsH.removeAllUpdateListeners();
            this.jsH = null;
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jsK);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.jsn = aVar;
    }
}
