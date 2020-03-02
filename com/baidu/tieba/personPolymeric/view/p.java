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
    public static int jso = 5000;
    private static final float jss = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout CD;
    private BdUniqueId MO;
    private TbPageContext cVh;
    private CustomViewPager cYa;
    private BaseFragment dCO;
    private NoNetworkView eli;
    private PluginErrorTipView fUR;
    private NewPagerSlidingTabBaseStrip fVH;
    private CustomMessageListener jhd;
    private com.baidu.tieba.personPolymeric.c.a jnI;
    private LinearLayout jnk;
    protected FrameLayout jnl;
    protected RelativeLayout jnn;
    private com.baidu.tieba.personPolymeric.b.e jnt;
    private int jsA;
    private int jsB;
    private GradientDrawable jsC;
    private FrameLayout jsD;
    private FrameLayout.LayoutParams jsE;
    private AlphaAnimation jsF;
    private AlphaAnimation jsG;
    private com.baidu.tieba.personPolymeric.header.c jsH;
    private k jsI;
    private ValueAnimator jsJ;
    private com.baidu.tieba.model.a jsp;
    private CustomMessageListener jsq;
    private CustomMessageListener jsr;
    private PullRefreshFrameLayout jsv;
    private com.baidu.tieba.personPolymeric.header.a jsw;
    private FrameLayout jsx;
    private View jsy;
    private a jsz;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private long mUserId;
    private float[] jst = {jss, jss, jss, jss, 0.0f, 0.0f, 0.0f, 0.0f};
    private float jsu = 674.0f;
    private boolean jsK = false;
    private int jsL = -1;
    private Runnable jsM = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.jsK) {
                p.this.cxQ();
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.f fVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.dCO = baseFragment;
        this.cVh = baseFragment.getPageContext();
        this.MO = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.jnt = fVar.cwQ();
        initView(fVar.mRootView);
    }

    private void initView(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.jsv = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.jsw = new com.baidu.tieba.personPolymeric.header.a(this.cVh, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.jsI = new k(this.cVh, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.jsD = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.jsE = (FrameLayout.LayoutParams) this.jsD.getLayoutParams();
        this.jsv.setOnTouchCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.b
            public void l(double d) {
                p.this.jsE.height = (int) (p.this.jsA + (PullRefreshFrameLayout.jtd * d));
                p.this.jsD.setLayoutParams(p.this.jsE);
                if (p.this.jsw != null) {
                    p.this.jsw.k(d);
                }
            }

            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.b
            public void c(final int i, double d) {
                p.this.jsJ = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.jsJ.setDuration(150L);
                final int i2 = p.this.jsE.height;
                final int cxh = p.this.jsw.cxh();
                p.this.jsJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.jsE.height = (int) (i2 - (i * animatedFraction));
                        p.this.jsD.setLayoutParams(p.this.jsE);
                        if (p.this.jsw != null) {
                            p.this.jsw.Ab((int) (cxh - (animatedFraction * i)));
                        }
                    }
                });
                p.this.jsJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.jsB = p.this.jsE.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.jsJ.start();
            }

            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.b
            public void cxS() {
                final int i = p.this.jsE.height;
                final int i2 = p.this.jsE.height - p.this.jsA;
                final int i3 = 0;
                if (p.this.jsw != null) {
                    i3 = p.this.jsw.cxh();
                }
                if (i2 > 0) {
                    p.this.jsJ = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.jsJ.setDuration(300L);
                    p.this.jsJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.jsE.height = (int) (i - (i2 * floatValue));
                            p.this.jsD.setLayoutParams(p.this.jsE);
                            if (p.this.jsw != null && i3 > 0) {
                                p.this.jsw.Ab((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    p.this.jsJ.start();
                    p.this.jsJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            p.this.jsB = 0;
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
        this.jsv.setOnPullRefreshListener(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.5
            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.a
            public void cxT() {
                com.baidu.adp.lib.f.e.gx().postDelayed(p.this.jsM, p.jso);
                p.this.jsK = true;
                p.this.jsL = p.this.jsz.getCurrentTabType();
                p.this.cwH();
                p.this.jsz.bdq();
            }
        });
        this.CD = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.CD.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.6
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.cVh.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.cVh.getPageActivity());
                }
                p.this.jsv.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.jsI.rB(abs == 0);
                p.this.jsI.rC(((float) abs) > p.this.jsu / 2.0f);
                float abs2 = ((double) p.this.jsu) == 0.0d ? 0.0f : Math.abs(abs / p.this.jsu);
                p.this.jsI.aH(abs2);
                if (abs2 >= 1.0f) {
                    p.this.jst = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.jsC.setCornerRadii(p.this.jst);
                    p.this.jsx.setBackgroundDrawable(p.this.jsC);
                    p.this.bcM();
                } else {
                    p.this.jst = new float[]{p.jss, p.jss, p.jss, p.jss, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.jsC.setCornerRadii(p.this.jst);
                    p.this.jsx.setBackgroundDrawable(p.this.jsC);
                    p.this.cxP();
                }
                int i2 = p.this.jsB - p.this.jsA;
                if (p.this.jsB > 0 && Math.abs(i) >= i2) {
                    p.this.jsv.ahW();
                }
            }
        });
        this.jsx = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.fVH = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.fVH.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.fVH.setRectPaintColor(R.color.cp_link_tip_a);
        this.fVH.a(com.baidu.adp.lib.util.l.getDimens(this.cVh.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.cVh.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.cVh.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.cVh.getPageActivity(), R.dimen.tbds46), true);
        this.fVH.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.cVh.getPageActivity(), R.dimen.tbds64));
        this.fVH.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.cVh.getPageActivity(), R.dimen.tbds8));
        this.fVH.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.cVh.getPageActivity(), R.dimen.tbds8));
        this.fVH.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.cVh.getPageActivity(), R.dimen.tbds0));
        this.fVH.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.cVh.getPageActivity(), R.dimen.tbds166), -1));
        this.fVH.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.jsz.Af(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.jsC = new GradientDrawable();
        this.jsC.setColor(am.getColor(R.color.cp_bg_line_d));
        this.jsC.setCornerRadii(this.jst);
        this.jsx.setBackgroundDrawable(this.jsC);
        this.jsy = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        am.setBackgroundResource(this.jsy, R.drawable.personalize_tab_shadow);
        this.cYa = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.jsz = new a(this.dCO.getActivity().getSupportFragmentManager());
        this.cYa.setAdapter(this.jsz);
        this.cYa.setOffscreenPageLimit(this.jsz.mFragments.size());
        this.jsz.notifyDataSetChanged();
        this.fVH.setViewPager(this.cYa);
        if (this.mIsHost) {
            this.cYa.setCurrentItem(1);
        } else {
            this.cYa.setCurrentItem(0);
        }
        this.jsH = new com.baidu.tieba.personPolymeric.header.c(this.cVh, this.mIsHost);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.jsD.addView(this.jsH.getView(), layoutParams);
        if (this.jsI.cxN()) {
            z(this.cVh);
        }
        y(this.cVh);
        this.eli = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.fUR = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.jnk = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.jnl = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.jnn = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void y(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.jsI != null) {
                    p.this.jsI.cxL();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.MO);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c cxO() {
        return this.jsH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends FragmentPagerAdapter {
        private List<String> iZb;
        private List<PersonCenterTabBaseFragment> mFragments;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.iZb = new ArrayList();
            this.iZb.add(p.this.cVh.getResources().getString(R.string.person_center_tab_main));
            this.iZb.add(p.this.cVh.getResources().getString(R.string.person_center_tab_dynamic));
            this.iZb.add(p.this.cVh.getResources().getString(R.string.person_center_tab_thread));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.j(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.i(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.k(p.this.mUserId, p.this.mIsHost));
        }

        public void Af(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.iZb.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
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
            return this.iZb.get(i);
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

        public void bdq() {
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

    private boolean bcL() {
        return this.jsy.getVisibility() == 0;
    }

    public void bcM() {
        if (!bcL() && this.jsF == null) {
            this.jsy.setVisibility(0);
            if (this.jsF == null) {
                this.jsF = new AlphaAnimation(0.0f, 1.0f);
                this.jsF.setFillAfter(true);
                this.jsF.setDuration(300L);
                this.jsF.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.9
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.jsF.reset();
                        p.this.jsF = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.jsy.startAnimation(this.jsF);
            }
        }
    }

    public void cxP() {
        if (bcL() && this.jsG == null && this.jsG == null) {
            this.jsG = new AlphaAnimation(1.0f, 0.0f);
            this.jsG.setFillAfter(true);
            this.jsG.setDuration(300L);
            this.jsG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.jsy.setVisibility(8);
                    p.this.jsG.reset();
                    p.this.jsG = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.jsy.startAnimation(this.jsG);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jsI != null) {
            this.jsI.onChangeSkinType(i);
        }
        if (this.fVH != null) {
            this.fVH.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
            this.fVH.setRectPaintColor(R.color.cp_link_tip_a);
            this.fVH.onChangeSkinType();
        }
        if (this.jsC != null) {
            this.jsC.setColor(am.getColor(R.color.cp_bg_line_d));
        }
        if (this.jsH != null) {
            this.jsH.onChangeSkinType(i);
        }
        if (this.jsz != null) {
            this.jsz.onChangeSkinType(i);
        }
        if (this.eli != null) {
            this.eli.onChangeSkinType(this.cVh, i);
        }
        if (this.fUR != null) {
            this.fUR.onChangeSkinType(this.cVh, i);
        }
        am.setBackgroundResource(this.jnk, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.jsy, R.drawable.personalize_tab_shadow);
    }

    public void cwH() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.jsp.resetData();
            this.jsp.refreshData();
            this.jnt.doRefresh();
            return;
        }
        this.jnt.bJN();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.e eVar) {
        if (this.jsI != null) {
            this.jsI.setOnViewResponseListener(eVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.jnI = aVar;
            this.jnk.setVisibility(8);
            this.jnn.setVisibility(0);
            if (this.jsI != null) {
                this.jsI.a(aVar, personStatus);
            }
            if (this.jsH != null) {
                this.jsH.b(aVar);
            }
            if (this.jsw != null) {
                this.jsw.e(this.jnI.getUserData());
            }
            this.jsD.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.11
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.jsA == 0) {
                        p.this.jsA = p.this.jsD.getMeasuredHeight();
                        p.this.jsu = p.this.jsD.getMeasuredHeight() - p.this.jsI.cxM().getMeasuredHeight();
                        if (p.this.jsw != null) {
                            p.this.jsw.Aa(p.this.mStatusBarHeight + p.this.jsI.cxM().getMeasuredHeight() + p.this.jsD.getMeasuredHeight() + p.this.fVH.getMeasuredHeight());
                        }
                    }
                }
            });
            this.jsz.h(aVar);
            this.jsz.g(aVar);
            if (v.isEmpty(aVar.bQx())) {
                this.jnt.bdt();
                com.baidu.adp.lib.util.l.showToast(this.cVh.getContext(), this.cVh.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.cDP().sj(this.mIsHost);
            int size = aVar.bQx().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.m mVar = aVar.bQx().get(i);
                if (mVar != null && (mVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.jnt.bdt();
                    return;
                }
            }
            if (!z) {
                this.jnt.e(true, aVar.bQx());
            }
        }
    }

    public void bJN() {
        this.jnt.bJN();
    }

    private void z(TbPageContext tbPageContext) {
        this.jsq = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).jOP;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.jsH != null && aVar != null) {
                            p.this.jsH.rv(aVar.dGh);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.jnI != null) {
                            if (p.this.jnI.joz != null && p.this.jnI.joz.gas != null && aVar2 != null) {
                                p.this.jnI.joz.gas.putBoolean("person_center_item_red_tip_show", aVar2.dGh);
                            }
                            if (aVar3 != null && p.this.jnI.joy != null && p.this.jnI.joy.gas != null) {
                                p.this.jnI.joy.gas.putBoolean("person_center_item_red_tip_show", aVar3.dGh);
                            }
                            if (aVar4 != null && p.this.jnI.jox != null && p.this.jnI.jox.gas != null) {
                                p.this.jnI.jox.gas.putBoolean("person_center_item_red_tip_show", aVar4.dGh);
                            }
                            if (aVar5 != null && p.this.jnI.joA != null && p.this.jnI.joA.gas != null) {
                                p.this.jnI.joA.gas.putBoolean("person_center_item_red_tip_show", aVar5.dGh);
                            }
                            if (aVar6 != null && p.this.jnI.joB != null && p.this.jnI.joB.gas != null) {
                                p.this.jnI.joB.gas.putBoolean("person_center_item_red_tip_show", aVar6.dGh);
                                p.this.jnI.joB.gas.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.jsq.setTag(this.MO);
        tbPageContext.registerListener(this.jsq);
        this.jhd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.m mVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && (mVar = (com.baidu.tbadk.data.m) customResponsedMessage.getData()) != null) {
                    p.this.jsH.GU(mVar.aAG());
                }
            }
        };
        this.jhd.setTag(this.MO);
        tbPageContext.registerListener(this.jhd);
        this.jsr = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.jsL == ((Integer) customResponsedMessage.getData()).intValue() && p.this.jsK) {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(p.this.jsM);
                    p.this.cxQ();
                }
            }
        };
        this.jsr.setTag(this.MO);
        tbPageContext.registerListener(this.jsr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxQ() {
        this.jsL = -1;
        this.jsK = false;
        if (this.jsv != null) {
            this.jsv.cxV();
        }
    }

    public void onDestory() {
        if (this.jsH != null) {
            this.jsH.onDestroy();
        }
        if (this.jsv != null) {
            this.jsv.onDestroy();
        }
        if (this.jsJ != null) {
            this.jsJ.cancel();
            this.jsJ.removeAllListeners();
            this.jsJ.removeAllUpdateListeners();
            this.jsJ = null;
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jsM);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.jsp = aVar;
    }
}
