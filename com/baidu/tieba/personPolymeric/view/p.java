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
    public static int jsA = 5000;
    private static final float jsE = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout CD;
    private BdUniqueId MO;
    private TbPageContext cVi;
    private CustomViewPager cYb;
    private BaseFragment dDb;
    private NoNetworkView elv;
    private NewPagerSlidingTabBaseStrip fVU;
    private PluginErrorTipView fVe;
    private CustomMessageListener jhp;
    private com.baidu.tieba.personPolymeric.b.e jnF;
    private com.baidu.tieba.personPolymeric.c.a jnU;
    private LinearLayout jnw;
    protected FrameLayout jnx;
    protected RelativeLayout jnz;
    private com.baidu.tieba.model.a jsB;
    private CustomMessageListener jsC;
    private CustomMessageListener jsD;
    private PullRefreshFrameLayout jsH;
    private com.baidu.tieba.personPolymeric.header.a jsI;
    private FrameLayout jsJ;
    private View jsK;
    private a jsL;
    private int jsM;
    private int jsN;
    private GradientDrawable jsO;
    private FrameLayout jsP;
    private FrameLayout.LayoutParams jsQ;
    private AlphaAnimation jsR;
    private AlphaAnimation jsS;
    private com.baidu.tieba.personPolymeric.header.c jsT;
    private k jsU;
    private ValueAnimator jsV;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private long mUserId;
    private float[] jsF = {jsE, jsE, jsE, jsE, 0.0f, 0.0f, 0.0f, 0.0f};
    private float jsG = 674.0f;
    private boolean jsW = false;
    private int jsX = -1;
    private Runnable jsY = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.jsW) {
                p.this.cxR();
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.f fVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.dDb = baseFragment;
        this.cVi = baseFragment.getPageContext();
        this.MO = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.jnF = fVar.cwR();
        initView(fVar.mRootView);
    }

    private void initView(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.jsH = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.jsI = new com.baidu.tieba.personPolymeric.header.a(this.cVi, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.jsU = new k(this.cVi, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.jsP = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.jsQ = (FrameLayout.LayoutParams) this.jsP.getLayoutParams();
        this.jsH.setOnTouchCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.b
            public void l(double d) {
                p.this.jsQ.height = (int) (p.this.jsM + (PullRefreshFrameLayout.jtp * d));
                p.this.jsP.setLayoutParams(p.this.jsQ);
                if (p.this.jsI != null) {
                    p.this.jsI.k(d);
                }
            }

            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.b
            public void c(final int i, double d) {
                p.this.jsV = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.jsV.setDuration(150L);
                final int i2 = p.this.jsQ.height;
                final int cxi = p.this.jsI.cxi();
                p.this.jsV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.jsQ.height = (int) (i2 - (i * animatedFraction));
                        p.this.jsP.setLayoutParams(p.this.jsQ);
                        if (p.this.jsI != null) {
                            p.this.jsI.Ab((int) (cxi - (animatedFraction * i)));
                        }
                    }
                });
                p.this.jsV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.jsN = p.this.jsQ.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.jsV.start();
            }

            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.b
            public void cxT() {
                final int i = p.this.jsQ.height;
                final int i2 = p.this.jsQ.height - p.this.jsM;
                final int i3 = 0;
                if (p.this.jsI != null) {
                    i3 = p.this.jsI.cxi();
                }
                if (i2 > 0) {
                    p.this.jsV = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.jsV.setDuration(300L);
                    p.this.jsV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.jsQ.height = (int) (i - (i2 * floatValue));
                            p.this.jsP.setLayoutParams(p.this.jsQ);
                            if (p.this.jsI != null && i3 > 0) {
                                p.this.jsI.Ab((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    p.this.jsV.start();
                    p.this.jsV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            p.this.jsN = 0;
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
        this.jsH.setOnPullRefreshListener(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.5
            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.a
            public void cxU() {
                com.baidu.adp.lib.f.e.gx().postDelayed(p.this.jsY, p.jsA);
                p.this.jsW = true;
                p.this.jsX = p.this.jsL.getCurrentTabType();
                p.this.cwI();
                p.this.jsL.bdr();
            }
        });
        this.CD = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.CD.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.6
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.cVi.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.cVi.getPageActivity());
                }
                p.this.jsH.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.jsU.rB(abs == 0);
                p.this.jsU.rC(((float) abs) > p.this.jsG / 2.0f);
                float abs2 = ((double) p.this.jsG) == 0.0d ? 0.0f : Math.abs(abs / p.this.jsG);
                p.this.jsU.aH(abs2);
                if (abs2 >= 1.0f) {
                    p.this.jsF = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.jsO.setCornerRadii(p.this.jsF);
                    p.this.jsJ.setBackgroundDrawable(p.this.jsO);
                    p.this.bcN();
                } else {
                    p.this.jsF = new float[]{p.jsE, p.jsE, p.jsE, p.jsE, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.jsO.setCornerRadii(p.this.jsF);
                    p.this.jsJ.setBackgroundDrawable(p.this.jsO);
                    p.this.cxQ();
                }
                int i2 = p.this.jsN - p.this.jsM;
                if (p.this.jsN > 0 && Math.abs(i) >= i2) {
                    p.this.jsH.ahW();
                }
            }
        });
        this.jsJ = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.fVU = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.fVU.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.fVU.setRectPaintColor(R.color.cp_link_tip_a);
        this.fVU.a(com.baidu.adp.lib.util.l.getDimens(this.cVi.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.cVi.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.cVi.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.cVi.getPageActivity(), R.dimen.tbds46), true);
        this.fVU.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.cVi.getPageActivity(), R.dimen.tbds64));
        this.fVU.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.cVi.getPageActivity(), R.dimen.tbds8));
        this.fVU.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.cVi.getPageActivity(), R.dimen.tbds8));
        this.fVU.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.cVi.getPageActivity(), R.dimen.tbds0));
        this.fVU.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.cVi.getPageActivity(), R.dimen.tbds166), -1));
        this.fVU.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.jsL.Af(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.jsO = new GradientDrawable();
        this.jsO.setColor(am.getColor(R.color.cp_bg_line_d));
        this.jsO.setCornerRadii(this.jsF);
        this.jsJ.setBackgroundDrawable(this.jsO);
        this.jsK = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        am.setBackgroundResource(this.jsK, R.drawable.personalize_tab_shadow);
        this.cYb = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.jsL = new a(this.dDb.getActivity().getSupportFragmentManager());
        this.cYb.setAdapter(this.jsL);
        this.cYb.setOffscreenPageLimit(this.jsL.mFragments.size());
        this.jsL.notifyDataSetChanged();
        this.fVU.setViewPager(this.cYb);
        if (this.mIsHost) {
            this.cYb.setCurrentItem(1);
        } else {
            this.cYb.setCurrentItem(0);
        }
        this.jsT = new com.baidu.tieba.personPolymeric.header.c(this.cVi, this.mIsHost);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.jsP.addView(this.jsT.getView(), layoutParams);
        if (this.jsU.cxO()) {
            z(this.cVi);
        }
        y(this.cVi);
        this.elv = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.fVe = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.jnw = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.jnx = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.jnz = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void y(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.jsU != null) {
                    p.this.jsU.cxM();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.MO);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c cxP() {
        return this.jsT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends FragmentPagerAdapter {
        private List<String> iZn;
        private List<PersonCenterTabBaseFragment> mFragments;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.iZn = new ArrayList();
            this.iZn.add(p.this.cVi.getResources().getString(R.string.person_center_tab_main));
            this.iZn.add(p.this.cVi.getResources().getString(R.string.person_center_tab_dynamic));
            this.iZn.add(p.this.cVi.getResources().getString(R.string.person_center_tab_thread));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.j(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.i(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.k(p.this.mUserId, p.this.mIsHost));
        }

        public void Af(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.iZn.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
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
            return this.iZn.get(i);
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

        public void bdr() {
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

    private boolean bcM() {
        return this.jsK.getVisibility() == 0;
    }

    public void bcN() {
        if (!bcM() && this.jsR == null) {
            this.jsK.setVisibility(0);
            if (this.jsR == null) {
                this.jsR = new AlphaAnimation(0.0f, 1.0f);
                this.jsR.setFillAfter(true);
                this.jsR.setDuration(300L);
                this.jsR.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.9
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.jsR.reset();
                        p.this.jsR = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.jsK.startAnimation(this.jsR);
            }
        }
    }

    public void cxQ() {
        if (bcM() && this.jsS == null && this.jsS == null) {
            this.jsS = new AlphaAnimation(1.0f, 0.0f);
            this.jsS.setFillAfter(true);
            this.jsS.setDuration(300L);
            this.jsS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.jsK.setVisibility(8);
                    p.this.jsS.reset();
                    p.this.jsS = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.jsK.startAnimation(this.jsS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jsU != null) {
            this.jsU.onChangeSkinType(i);
        }
        if (this.fVU != null) {
            this.fVU.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
            this.fVU.setRectPaintColor(R.color.cp_link_tip_a);
            this.fVU.onChangeSkinType();
        }
        if (this.jsO != null) {
            this.jsO.setColor(am.getColor(R.color.cp_bg_line_d));
        }
        if (this.jsT != null) {
            this.jsT.onChangeSkinType(i);
        }
        if (this.jsL != null) {
            this.jsL.onChangeSkinType(i);
        }
        if (this.elv != null) {
            this.elv.onChangeSkinType(this.cVi, i);
        }
        if (this.fVe != null) {
            this.fVe.onChangeSkinType(this.cVi, i);
        }
        am.setBackgroundResource(this.jnw, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.jsK, R.drawable.personalize_tab_shadow);
    }

    public void cwI() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.jsB.resetData();
            this.jsB.refreshData();
            this.jnF.doRefresh();
            return;
        }
        this.jnF.bJO();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.e eVar) {
        if (this.jsU != null) {
            this.jsU.setOnViewResponseListener(eVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.jnU = aVar;
            this.jnw.setVisibility(8);
            this.jnz.setVisibility(0);
            if (this.jsU != null) {
                this.jsU.a(aVar, personStatus);
            }
            if (this.jsT != null) {
                this.jsT.b(aVar);
            }
            if (this.jsI != null) {
                this.jsI.e(this.jnU.getUserData());
            }
            this.jsP.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.11
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.jsM == 0) {
                        p.this.jsM = p.this.jsP.getMeasuredHeight();
                        p.this.jsG = p.this.jsP.getMeasuredHeight() - p.this.jsU.cxN().getMeasuredHeight();
                        if (p.this.jsI != null) {
                            p.this.jsI.Aa(p.this.mStatusBarHeight + p.this.jsU.cxN().getMeasuredHeight() + p.this.jsP.getMeasuredHeight() + p.this.fVU.getMeasuredHeight());
                        }
                    }
                }
            });
            this.jsL.h(aVar);
            this.jsL.g(aVar);
            if (v.isEmpty(aVar.bQy())) {
                this.jnF.bdu();
                com.baidu.adp.lib.util.l.showToast(this.cVi.getContext(), this.cVi.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.cDQ().sj(this.mIsHost);
            int size = aVar.bQy().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.m mVar = aVar.bQy().get(i);
                if (mVar != null && (mVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.jnF.bdu();
                    return;
                }
            }
            if (!z) {
                this.jnF.e(true, aVar.bQy());
            }
        }
    }

    public void bJO() {
        this.jnF.bJO();
    }

    private void z(TbPageContext tbPageContext) {
        this.jsC = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).jPb;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.jsT != null && aVar != null) {
                            p.this.jsT.rv(aVar.dGu);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.jnU != null) {
                            if (p.this.jnU.joL != null && p.this.jnU.joL.gaF != null && aVar2 != null) {
                                p.this.jnU.joL.gaF.putBoolean("person_center_item_red_tip_show", aVar2.dGu);
                            }
                            if (aVar3 != null && p.this.jnU.joK != null && p.this.jnU.joK.gaF != null) {
                                p.this.jnU.joK.gaF.putBoolean("person_center_item_red_tip_show", aVar3.dGu);
                            }
                            if (aVar4 != null && p.this.jnU.joJ != null && p.this.jnU.joJ.gaF != null) {
                                p.this.jnU.joJ.gaF.putBoolean("person_center_item_red_tip_show", aVar4.dGu);
                            }
                            if (aVar5 != null && p.this.jnU.joM != null && p.this.jnU.joM.gaF != null) {
                                p.this.jnU.joM.gaF.putBoolean("person_center_item_red_tip_show", aVar5.dGu);
                            }
                            if (aVar6 != null && p.this.jnU.joN != null && p.this.jnU.joN.gaF != null) {
                                p.this.jnU.joN.gaF.putBoolean("person_center_item_red_tip_show", aVar6.dGu);
                                p.this.jnU.joN.gaF.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.jsC.setTag(this.MO);
        tbPageContext.registerListener(this.jsC);
        this.jhp = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.m mVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && (mVar = (com.baidu.tbadk.data.m) customResponsedMessage.getData()) != null) {
                    p.this.jsT.GV(mVar.aAG());
                }
            }
        };
        this.jhp.setTag(this.MO);
        tbPageContext.registerListener(this.jhp);
        this.jsD = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.jsX == ((Integer) customResponsedMessage.getData()).intValue() && p.this.jsW) {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(p.this.jsY);
                    p.this.cxR();
                }
            }
        };
        this.jsD.setTag(this.MO);
        tbPageContext.registerListener(this.jsD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxR() {
        this.jsX = -1;
        this.jsW = false;
        if (this.jsH != null) {
            this.jsH.cxW();
        }
    }

    public void onDestory() {
        if (this.jsT != null) {
            this.jsT.onDestroy();
        }
        if (this.jsH != null) {
            this.jsH.onDestroy();
        }
        if (this.jsV != null) {
            this.jsV.cancel();
            this.jsV.removeAllListeners();
            this.jsV.removeAllUpdateListeners();
            this.jsV = null;
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jsY);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.jsB = aVar;
    }
}
