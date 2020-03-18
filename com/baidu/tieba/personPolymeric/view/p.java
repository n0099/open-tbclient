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
    public static int jtZ = 5000;
    private static final float jud = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout CD;
    private BdUniqueId MP;
    private TbPageContext cVv;
    private CustomViewPager cYo;
    private BaseFragment dDo;
    private NoNetworkView elL;
    private PluginErrorTipView fVN;
    private NewPagerSlidingTabBaseStrip fWC;
    private CustomMessageListener jiP;
    private LinearLayout joV;
    protected FrameLayout joW;
    protected RelativeLayout joY;
    private com.baidu.tieba.personPolymeric.b.e jpe;
    private com.baidu.tieba.personPolymeric.c.a jpt;
    private com.baidu.tieba.model.a jua;
    private CustomMessageListener jub;
    private CustomMessageListener juc;
    private PullRefreshFrameLayout jug;
    private com.baidu.tieba.personPolymeric.header.a juh;
    private FrameLayout jui;
    private View juj;
    private a juk;
    private int jul;
    private int jum;
    private GradientDrawable jun;
    private FrameLayout juo;
    private FrameLayout.LayoutParams jup;
    private AlphaAnimation juq;
    private AlphaAnimation jur;
    private com.baidu.tieba.personPolymeric.header.c jus;
    private k jut;
    private ValueAnimator juu;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private long mUserId;
    private float[] jue = {jud, jud, jud, jud, 0.0f, 0.0f, 0.0f, 0.0f};
    private float juf = 674.0f;
    private boolean juv = false;
    private int juw = -1;
    private Runnable jux = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.juv) {
                p.this.cyk();
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.f fVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.dDo = baseFragment;
        this.cVv = baseFragment.getPageContext();
        this.MP = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.jpe = fVar.cxk();
        initView(fVar.mRootView);
    }

    private void initView(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.jug = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.juh = new com.baidu.tieba.personPolymeric.header.a(this.cVv, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.jut = new k(this.cVv, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.juo = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.jup = (FrameLayout.LayoutParams) this.juo.getLayoutParams();
        this.jug.setOnTouchCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.b
            public void l(double d) {
                p.this.jup.height = (int) (p.this.jul + (PullRefreshFrameLayout.juO * d));
                p.this.juo.setLayoutParams(p.this.jup);
                if (p.this.juh != null) {
                    p.this.juh.k(d);
                }
            }

            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.b
            public void c(final int i, double d) {
                p.this.juu = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.juu.setDuration(150L);
                final int i2 = p.this.jup.height;
                final int cxB = p.this.juh.cxB();
                p.this.juu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.jup.height = (int) (i2 - (i * animatedFraction));
                        p.this.juo.setLayoutParams(p.this.jup);
                        if (p.this.juh != null) {
                            p.this.juh.Aj((int) (cxB - (animatedFraction * i)));
                        }
                    }
                });
                p.this.juu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.jum = p.this.jup.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.juu.start();
            }

            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.b
            public void cym() {
                final int i = p.this.jup.height;
                final int i2 = p.this.jup.height - p.this.jul;
                final int i3 = 0;
                if (p.this.juh != null) {
                    i3 = p.this.juh.cxB();
                }
                if (i2 > 0) {
                    p.this.juu = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.juu.setDuration(300L);
                    p.this.juu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.jup.height = (int) (i - (i2 * floatValue));
                            p.this.juo.setLayoutParams(p.this.jup);
                            if (p.this.juh != null && i3 > 0) {
                                p.this.juh.Aj((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    p.this.juu.start();
                    p.this.juu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            p.this.jum = 0;
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
        this.jug.setOnPullRefreshListener(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.5
            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.a
            public void cyn() {
                com.baidu.adp.lib.f.e.gx().postDelayed(p.this.jux, p.jtZ);
                p.this.juv = true;
                p.this.juw = p.this.juk.getCurrentTabType();
                p.this.cxb();
                p.this.juk.bdw();
            }
        });
        this.CD = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.CD.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.6
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.cVv.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.cVv.getPageActivity());
                }
                p.this.jug.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.jut.rH(abs == 0);
                p.this.jut.rI(((float) abs) > p.this.juf / 2.0f);
                float abs2 = ((double) p.this.juf) == 0.0d ? 0.0f : Math.abs(abs / p.this.juf);
                p.this.jut.aH(abs2);
                if (abs2 >= 1.0f) {
                    p.this.jue = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.jun.setCornerRadii(p.this.jue);
                    p.this.jui.setBackgroundDrawable(p.this.jun);
                    p.this.bcR();
                } else {
                    p.this.jue = new float[]{p.jud, p.jud, p.jud, p.jud, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.jun.setCornerRadii(p.this.jue);
                    p.this.jui.setBackgroundDrawable(p.this.jun);
                    p.this.cyj();
                }
                int i2 = p.this.jum - p.this.jul;
                if (p.this.jum > 0 && Math.abs(i) >= i2) {
                    p.this.jug.ahZ();
                }
            }
        });
        this.jui = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.fWC = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.fWC.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.fWC.setRectPaintColor(R.color.cp_link_tip_a);
        this.fWC.a(com.baidu.adp.lib.util.l.getDimens(this.cVv.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.cVv.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.cVv.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.cVv.getPageActivity(), R.dimen.tbds46), true);
        this.fWC.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.cVv.getPageActivity(), R.dimen.tbds64));
        this.fWC.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.cVv.getPageActivity(), R.dimen.tbds8));
        this.fWC.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.cVv.getPageActivity(), R.dimen.tbds8));
        this.fWC.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.cVv.getPageActivity(), R.dimen.tbds0));
        this.fWC.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.cVv.getPageActivity(), R.dimen.tbds166), -1));
        this.fWC.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.juk.An(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.jun = new GradientDrawable();
        this.jun.setColor(am.getColor(R.color.cp_bg_line_d));
        this.jun.setCornerRadii(this.jue);
        this.jui.setBackgroundDrawable(this.jun);
        this.juj = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        am.setBackgroundResource(this.juj, R.drawable.personalize_tab_shadow);
        this.cYo = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.juk = new a(this.dDo.getActivity().getSupportFragmentManager());
        this.cYo.setAdapter(this.juk);
        this.cYo.setOffscreenPageLimit(this.juk.mFragments.size());
        this.juk.notifyDataSetChanged();
        this.fWC.setViewPager(this.cYo);
        if (this.mIsHost) {
            this.cYo.setCurrentItem(1);
        } else {
            this.cYo.setCurrentItem(0);
        }
        this.jus = new com.baidu.tieba.personPolymeric.header.c(this.cVv, this.mIsHost);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.juo.addView(this.jus.getView(), layoutParams);
        if (this.jut.cyh()) {
            A(this.cVv);
        }
        z(this.cVv);
        this.elL = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.fVN = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.joV = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.joW = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.joY = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void z(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.jut != null) {
                    p.this.jut.cyf();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.MP);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c cyi() {
        return this.jus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends FragmentPagerAdapter {
        private List<String> jaN;
        private List<PersonCenterTabBaseFragment> mFragments;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.jaN = new ArrayList();
            this.jaN.add(p.this.cVv.getResources().getString(R.string.person_center_tab_main));
            this.jaN.add(p.this.cVv.getResources().getString(R.string.person_center_tab_dynamic));
            this.jaN.add(p.this.cVv.getResources().getString(R.string.person_center_tab_thread));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.k(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.j(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.l(p.this.mUserId, p.this.mIsHost));
        }

        public void An(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.jaN.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
                if (i2 == i) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return Ap(i);
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
            return Ao(i);
        }

        private String Ao(int i) {
            return this.jaN.get(i);
        }

        public PersonCenterTabBaseFragment Ap(int i) {
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

        public void bdw() {
            if (!v.isEmpty(this.mFragments)) {
                for (int i = 0; i < this.mFragments.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.rD(false);
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

    private boolean bcQ() {
        return this.juj.getVisibility() == 0;
    }

    public void bcR() {
        if (!bcQ() && this.juq == null) {
            this.juj.setVisibility(0);
            if (this.juq == null) {
                this.juq = new AlphaAnimation(0.0f, 1.0f);
                this.juq.setFillAfter(true);
                this.juq.setDuration(300L);
                this.juq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.9
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.juq.reset();
                        p.this.juq = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.juj.startAnimation(this.juq);
            }
        }
    }

    public void cyj() {
        if (bcQ() && this.jur == null && this.jur == null) {
            this.jur = new AlphaAnimation(1.0f, 0.0f);
            this.jur.setFillAfter(true);
            this.jur.setDuration(300L);
            this.jur.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.juj.setVisibility(8);
                    p.this.jur.reset();
                    p.this.jur = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.juj.startAnimation(this.jur);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jut != null) {
            this.jut.onChangeSkinType(i);
        }
        if (this.fWC != null) {
            this.fWC.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
            this.fWC.setRectPaintColor(R.color.cp_link_tip_a);
            this.fWC.onChangeSkinType();
        }
        if (this.jun != null) {
            this.jun.setColor(am.getColor(R.color.cp_bg_line_d));
        }
        if (this.jus != null) {
            this.jus.onChangeSkinType(i);
        }
        if (this.juk != null) {
            this.juk.onChangeSkinType(i);
        }
        if (this.elL != null) {
            this.elL.onChangeSkinType(this.cVv, i);
        }
        if (this.fVN != null) {
            this.fVN.onChangeSkinType(this.cVv, i);
        }
        am.setBackgroundResource(this.joV, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.juj, R.drawable.personalize_tab_shadow);
    }

    public void cxb() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.jua.resetData();
            this.jua.refreshData();
            this.jpe.doRefresh();
            return;
        }
        this.jpe.bKb();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.e eVar) {
        if (this.jut != null) {
            this.jut.setOnViewResponseListener(eVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.jpt = aVar;
            this.joV.setVisibility(8);
            this.joY.setVisibility(0);
            if (this.jut != null) {
                this.jut.a(aVar, personStatus);
            }
            if (this.jus != null) {
                this.jus.b(aVar);
            }
            if (this.juh != null) {
                this.juh.e(this.jpt.getUserData());
            }
            this.juo.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.11
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.jul == 0) {
                        p.this.jul = p.this.juo.getMeasuredHeight();
                        p.this.juf = p.this.juo.getMeasuredHeight() - p.this.jut.cyg().getMeasuredHeight();
                        if (p.this.juh != null) {
                            p.this.juh.Ai(p.this.mStatusBarHeight + p.this.jut.cyg().getMeasuredHeight() + p.this.juo.getMeasuredHeight() + p.this.fWC.getMeasuredHeight());
                        }
                    }
                }
            });
            this.juk.h(aVar);
            this.juk.g(aVar);
            if (v.isEmpty(aVar.bQQ())) {
                this.jpe.bdz();
                com.baidu.adp.lib.util.l.showToast(this.cVv.getContext(), this.cVv.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.cEk().sp(this.mIsHost);
            int size = aVar.bQQ().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.m mVar = aVar.bQQ().get(i);
                if (mVar != null && (mVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.jpe.bdz();
                    return;
                }
            }
            if (!z) {
                this.jpe.e(true, aVar.bQQ());
            }
        }
    }

    public void bKb() {
        this.jpe.bKb();
    }

    private void A(TbPageContext tbPageContext) {
        this.jub = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).jQD;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.jus != null && aVar != null) {
                            p.this.jus.rB(aVar.dGK);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.jpt != null) {
                            if (p.this.jpt.jqk != null && p.this.jpt.jqk.gbn != null && aVar2 != null) {
                                p.this.jpt.jqk.gbn.putBoolean("person_center_item_red_tip_show", aVar2.dGK);
                            }
                            if (aVar3 != null && p.this.jpt.jqj != null && p.this.jpt.jqj.gbn != null) {
                                p.this.jpt.jqj.gbn.putBoolean("person_center_item_red_tip_show", aVar3.dGK);
                            }
                            if (aVar4 != null && p.this.jpt.jqi != null && p.this.jpt.jqi.gbn != null) {
                                p.this.jpt.jqi.gbn.putBoolean("person_center_item_red_tip_show", aVar4.dGK);
                            }
                            if (aVar5 != null && p.this.jpt.jql != null && p.this.jpt.jql.gbn != null) {
                                p.this.jpt.jql.gbn.putBoolean("person_center_item_red_tip_show", aVar5.dGK);
                            }
                            if (aVar6 != null && p.this.jpt.jqm != null && p.this.jpt.jqm.gbn != null) {
                                p.this.jpt.jqm.gbn.putBoolean("person_center_item_red_tip_show", aVar6.dGK);
                                p.this.jpt.jqm.gbn.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.jub.setTag(this.MP);
        tbPageContext.registerListener(this.jub);
        this.jiP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.m mVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && (mVar = (com.baidu.tbadk.data.m) customResponsedMessage.getData()) != null) {
                    p.this.jus.GU(mVar.aAJ());
                }
            }
        };
        this.jiP.setTag(this.MP);
        tbPageContext.registerListener(this.jiP);
        this.juc = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.juw == ((Integer) customResponsedMessage.getData()).intValue() && p.this.juv) {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(p.this.jux);
                    p.this.cyk();
                }
            }
        };
        this.juc.setTag(this.MP);
        tbPageContext.registerListener(this.juc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyk() {
        this.juw = -1;
        this.juv = false;
        if (this.jug != null) {
            this.jug.cyp();
        }
    }

    public void onDestory() {
        if (this.jus != null) {
            this.jus.onDestroy();
        }
        if (this.jug != null) {
            this.jug.onDestroy();
        }
        if (this.juu != null) {
            this.juu.cancel();
            this.juu.removeAllListeners();
            this.juu.removeAllUpdateListeners();
            this.juu = null;
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jux);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.jua = aVar;
    }
}
