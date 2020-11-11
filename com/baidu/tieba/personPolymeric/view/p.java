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
    public static int jjm = 5000;
    private static final float mhr = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout Yh;
    private BdUniqueId aiz;
    private TbPageContext eIc;
    private CustomViewPager eLl;
    private ValueAnimator eVj;
    private BaseFragment fux;
    private NoNetworkView gjn;
    private PluginErrorTipView ijD;
    private NewPagerSlidingTabBaseStrip ikr;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private CustomMessageListener mUpdatePendantListener;
    private long mUserId;
    private LinearLayout mbR;
    protected FrameLayout mbS;
    protected RelativeLayout mbU;
    private com.baidu.tieba.personPolymeric.b.f mca;
    private com.baidu.tieba.personPolymeric.c.a mcp;
    private int mhA;
    private GradientDrawable mhB;
    private FrameLayout mhC;
    private FrameLayout.LayoutParams mhD;
    private AlphaAnimation mhE;
    private AlphaAnimation mhF;
    private com.baidu.tieba.personPolymeric.header.c mhG;
    private k mhH;
    private int mhJ;
    private boolean mhK;
    private com.baidu.tieba.model.a mho;
    private CustomMessageListener mhp;
    private CustomMessageListener mhq;
    private PullRefreshFrameLayout mhu;
    private com.baidu.tieba.personPolymeric.header.a mhv;
    private FrameLayout mhw;
    private View mhx;
    private a mhy;
    private int mhz;
    private float[] mhs = {mhr, mhr, mhr, mhr, 0.0f, 0.0f, 0.0f, 0.0f};
    private float mht = 674.0f;
    private boolean jjq = false;
    private int mhI = -1;
    private Runnable jjA = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.6
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.jjq) {
                p.this.cGh();
            }
        }
    };
    private com.baidu.tieba.personPolymeric.b.a mex = new com.baidu.tieba.personPolymeric.b.a() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.tieba.personPolymeric.b.a
        public void Cq(int i) {
            p.this.mhD.height = -2;
            p.this.mhC.setLayoutParams(p.this.mhD);
        }

        @Override // com.baidu.tieba.personPolymeric.b.a
        public void hk(boolean z) {
            p.this.mhK = z;
            if (!z) {
                p.this.mhv.Hg(p.this.mhJ);
            }
            if (p.this.mhG != null && p.this.mhG.dwh() != null) {
                p.this.mhG.dwh().setOpen(z);
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.g gVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.fux = baseFragment;
        this.eIc = baseFragment.getPageContext();
        this.aiz = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.mca = gVar.dvq();
        al(gVar.mRootView);
    }

    private void al(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.mhu = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.mhv = new com.baidu.tieba.personPolymeric.header.a(this.eIc, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.mhH = new k(this.eIc, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.mhC = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.mhD = (FrameLayout.LayoutParams) this.mhC.getLayoutParams();
        this.mhu.setOnTouchCallback(new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void x(double d) {
                p.this.mhD.height = (int) ((p.this.mhK ? com.baidu.tieba.personPolymeric.header.b.mes : 0) + p.this.mhz + (PullRefreshFrameLayout.eUP * d));
                p.this.mhC.setLayoutParams(p.this.mhD);
                if (p.this.mhv != null) {
                    p.this.mhv.D(d);
                }
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                p.this.eVj = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.eVj.setDuration(150L);
                final int measuredHeight = p.this.mhC.getMeasuredHeight();
                final int czc = p.this.mhv.czc();
                p.this.eVj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.mhD.height = (int) (measuredHeight - (i * animatedFraction));
                        p.this.mhC.setLayoutParams(p.this.mhD);
                        if (p.this.mhv != null) {
                            p.this.mhv.Hh((int) (czc - (animatedFraction * i)));
                        }
                    }
                });
                p.this.eVj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.mhA = p.this.mhD.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.eVj.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void bsC() {
                final int measuredHeight = p.this.mhC.getMeasuredHeight();
                final int i = (measuredHeight - p.this.mhz) - (p.this.mhK ? com.baidu.tieba.personPolymeric.header.b.mes : 0);
                final int czc = p.this.mhv != null ? p.this.mhv.czc() : 0;
                if (p.this.mhK) {
                    p.this.mhG.wa(false);
                    p.this.mhG.dvI();
                }
                if (i > 0 || (i == 0 && p.this.mhK)) {
                    p.this.eVj = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.eVj.setDuration(300L);
                    p.this.eVj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.mhD.height = (int) (measuredHeight - (i * floatValue));
                            p.this.mhC.setLayoutParams(p.this.mhD);
                            if (p.this.mhv != null && czc > 0) {
                                p.this.mhv.Hh((int) (czc - (floatValue * i)));
                            }
                        }
                    });
                    p.this.eVj.start();
                    p.this.eVj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (p.this.mhK) {
                                p.this.mhG.dvJ();
                            }
                            p.this.mhA = 0;
                            p.this.mhD.height = -2;
                            p.this.mhC.setLayoutParams(p.this.mhD);
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
        this.mhu.setOnPullRefreshListener(new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.personPolymeric.view.p.8
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bsB() {
                com.baidu.adp.lib.f.e.mY().postDelayed(p.this.jjA, p.jjm);
                p.this.jjq = true;
                p.this.mhI = p.this.mhy.getCurrentTabType();
                p.this.dvh();
                p.this.mhy.bPV();
            }
        });
        this.mhu.setOnCancelCallBack(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void onCancel() {
                p.this.mhA = 0;
                p.this.mhD.height = -2;
                p.this.mhC.setLayoutParams(p.this.mhD);
            }
        });
        this.mhu.setOnLoadingStartCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.10
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void bsA() {
                p.this.mhD.height = -2;
                p.this.mhC.setLayoutParams(p.this.mhD);
            }
        });
        this.Yh = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.Yh.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.11
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.eIc.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.eIc.getPageActivity());
                }
                p.this.mhu.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.mhH.wg(abs == 0);
                p.this.mhH.wh(((float) abs) > p.this.mht / 2.0f);
                float abs2 = ((double) p.this.mht) == 0.0d ? 0.0f : Math.abs(abs / p.this.mht);
                p.this.mhH.aK(abs2);
                if (abs2 >= 1.0f) {
                    p.this.mhs = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mhB.setCornerRadii(p.this.mhs);
                    p.this.mhw.setBackgroundDrawable(p.this.mhB);
                    p.this.bPq();
                } else {
                    p.this.mhs = new float[]{p.mhr, p.mhr, p.mhr, p.mhr, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mhB.setCornerRadii(p.this.mhs);
                    p.this.mhw.setBackgroundDrawable(p.this.mhB);
                    p.this.dwu();
                }
                int i2 = p.this.mhA - p.this.mhz;
                if (p.this.mhA > 0 && Math.abs(i) >= i2) {
                    p.this.mhu.dismissLoading();
                }
            }
        });
        this.mhw = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.ikr = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.ikr.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.ikr.setRectPaintColor(R.color.cp_link_tip_a);
        this.ikr.a(com.baidu.adp.lib.util.l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds46), true);
        this.ikr.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds64));
        this.ikr.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds8));
        this.ikr.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds8));
        this.ikr.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds0));
        this.ikr.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds166), -1));
        this.ikr.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.12
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.mhy.Hl(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.mhB = new GradientDrawable();
        this.mhB.setColor(ap.getColor(R.color.cp_bg_line_d));
        this.mhB.setCornerRadii(this.mhs);
        this.mhw.setBackgroundDrawable(this.mhB);
        this.mhx = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        ap.setBackgroundResource(this.mhx, R.drawable.personalize_tab_shadow);
        this.eLl = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.mhy = new a(this.fux.getActivity().getSupportFragmentManager());
        this.eLl.setAdapter(this.mhy);
        this.eLl.setOffscreenPageLimit(this.mhy.mFragments.size());
        this.mhy.notifyDataSetChanged();
        this.ikr.setViewPager(this.eLl);
        this.eLl.setCurrentItem(1);
        this.mhG = new com.baidu.tieba.personPolymeric.header.c(this.eIc, this.mIsHost);
        this.mhG.a(this.mex);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.mhC.addView(this.mhG.getView(), layoutParams);
        if (this.mhH.dws()) {
            E(this.eIc);
        }
        D(this.eIc);
        this.gjn = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.ijD = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.mbR = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.mbS = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.mbU = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void D(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.mhH != null) {
                    p.this.mhH.dwq();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.aiz);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c dwt() {
        return this.mhG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a extends FragmentPagerAdapter {
        private List<String> lMG;
        private List<PersonCenterTabBaseFragment> mFragments;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.lMG = new ArrayList();
            this.lMG.add(p.this.eIc.getResources().getString(R.string.person_center_tab_main));
            this.lMG.add(p.this.eIc.getResources().getString(R.string.person_center_tab_thread));
            this.lMG.add(p.this.eIc.getResources().getString(R.string.person_center_tab_dynamic));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.o(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.p(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.n(p.this.mUserId, p.this.mIsHost));
        }

        public void Hl(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.lMG.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
                if (i2 == i) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return Hn(i);
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
            return Hm(i);
        }

        private String Hm(int i) {
            return this.lMG.get(i);
        }

        public PersonCenterTabBaseFragment Hn(int i) {
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

        public void bPV() {
            if (!y.isEmpty(this.mFragments)) {
                for (int i = 0; i < this.mFragments.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.wc(false);
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
                            personCenterTabBaseFragment.a(aVar.eEK);
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

    private boolean bPp() {
        return this.mhx.getVisibility() == 0;
    }

    public void bPq() {
        if (!bPp() && this.mhE == null) {
            this.mhx.setVisibility(0);
            if (this.mhE == null) {
                this.mhE = new AlphaAnimation(0.0f, 1.0f);
                this.mhE.setFillAfter(true);
                this.mhE.setDuration(300L);
                this.mhE.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.14
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.mhE.reset();
                        p.this.mhE = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.mhx.startAnimation(this.mhE);
            }
        }
    }

    public void dwu() {
        if (bPp() && this.mhF == null && this.mhF == null) {
            this.mhF = new AlphaAnimation(1.0f, 0.0f);
            this.mhF.setFillAfter(true);
            this.mhF.setDuration(300L);
            this.mhF.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.15
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.mhx.setVisibility(8);
                    p.this.mhF.reset();
                    p.this.mhF = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mhx.startAnimation(this.mhF);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mhH != null) {
            this.mhH.onChangeSkinType(i);
        }
        if (this.ikr != null) {
            this.ikr.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
            this.ikr.setRectPaintColor(R.color.cp_link_tip_a);
            this.ikr.onChangeSkinType();
        }
        if (this.mhB != null) {
            this.mhB.setColor(ap.getColor(R.color.cp_bg_line_d));
        }
        if (this.mhG != null) {
            this.mhG.onChangeSkinType(i);
        }
        if (this.mhy != null) {
            this.mhy.onChangeSkinType(i);
        }
        if (this.gjn != null) {
            this.gjn.onChangeSkinType(this.eIc, i);
        }
        if (this.ijD != null) {
            this.ijD.onChangeSkinType(this.eIc, i);
        }
        ap.setBackgroundResource(this.mbR, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.mhx, R.drawable.personalize_tab_shadow);
    }

    public void dvh() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.mho.resetData();
            this.mho.refreshData();
            this.mca.doRefresh();
            return;
        }
        this.mca.cET();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        if (this.mhH != null) {
            this.mhH.setOnViewResponseListener(fVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.mcp = aVar;
            this.mbR.setVisibility(8);
            this.mbU.setVisibility(0);
            if (this.mhH != null) {
                this.mhH.a(aVar, personStatus);
            }
            if (this.mhG != null) {
                this.mhG.b(aVar);
            }
            if (this.mhv != null) {
                this.mhv.e(this.mcp.getUserData());
            }
            this.mhC.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.2
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.mhz == 0) {
                        p.this.mhz = p.this.mhC.getMeasuredHeight();
                        p.this.mht = p.this.mhC.getMeasuredHeight() - p.this.mhH.dwr().getMeasuredHeight();
                        if (p.this.mhv != null) {
                            p.this.mhJ = p.this.mStatusBarHeight + p.this.mhH.dwr().getMeasuredHeight() + p.this.mhC.getMeasuredHeight() + p.this.ikr.getMeasuredHeight();
                            boolean z2 = (p.this.mIsHost || p.this.mcp.getUserData() == null || p.this.mcp.getUserData().getNewGodData() == null || !p.this.mcp.getUserData().getNewGodData().isNewGod()) ? false : true;
                            p.this.mhD.height = p.this.mhJ;
                            p.this.mhC.setLayoutParams(p.this.mhD);
                            p.this.mhJ += z2 ? com.baidu.tieba.personPolymeric.header.b.mes : 0;
                            p.this.mhv.Hg(p.this.mhJ);
                            p.this.mhD.height = -2;
                            p.this.mhC.setLayoutParams(p.this.mhD);
                        }
                    }
                }
            });
            this.mhy.h(aVar);
            this.mhy.g(aVar);
            if (y.isEmpty(aVar.cNe())) {
                this.mca.bPW();
                com.baidu.adp.lib.util.l.showToast(this.eIc.getContext(), this.eIc.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.dBY().wN(this.mIsHost);
            int size = aVar.cNe().size();
            for (int i = 0; i < size; i++) {
                q qVar = aVar.cNe().get(i);
                if (qVar != null && (qVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.mca.bPW();
                    return;
                }
            }
            if (!z) {
                this.mca.g(true, aVar.cNe());
            }
        }
    }

    public void cET() {
        this.mca.cET();
    }

    private void E(TbPageContext tbPageContext) {
        this.mhp = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).mCW;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.mhG != null && aVar != null) {
                            p.this.mhG.vZ(aVar.dke);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.mcp != null) {
                            if (p.this.mcp.mde != null && p.this.mcp.mde.isQ != null && aVar2 != null) {
                                p.this.mcp.mde.isQ.putBoolean("person_center_item_red_tip_show", aVar2.dke);
                            }
                            if (aVar3 != null && p.this.mcp.mdd != null && p.this.mcp.mdd.isQ != null) {
                                p.this.mcp.mdd.isQ.putBoolean("person_center_item_red_tip_show", aVar3.dke);
                            }
                            if (aVar4 != null && p.this.mcp.mdc != null && p.this.mcp.mdc.isQ != null) {
                                p.this.mcp.mdc.isQ.putBoolean("person_center_item_red_tip_show", aVar4.dke);
                            }
                            if (aVar5 != null && p.this.mcp.mdf != null && p.this.mcp.mdf.isQ != null) {
                                p.this.mcp.mdf.isQ.putBoolean("person_center_item_red_tip_show", aVar5.dke);
                            }
                            if (aVar6 != null && p.this.mcp.mdg != null && p.this.mcp.mdg.isQ != null) {
                                p.this.mcp.mdg.isQ.putBoolean("person_center_item_red_tip_show", aVar6.dke);
                                p.this.mcp.mdg.isQ.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.mhp.setTag(this.aiz);
        tbPageContext.registerListener(this.mhp);
        this.mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.m mVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && (mVar = (com.baidu.tbadk.data.m) customResponsedMessage.getData()) != null) {
                    p.this.mhG.QG(mVar.bkw());
                }
            }
        };
        this.mUpdatePendantListener.setTag(this.aiz);
        tbPageContext.registerListener(this.mUpdatePendantListener);
        this.mhq = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.mhI == ((Integer) customResponsedMessage.getData()).intValue() && p.this.jjq) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(p.this.jjA);
                    p.this.cGh();
                }
            }
        };
        this.mhq.setTag(this.aiz);
        tbPageContext.registerListener(this.mhq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGh() {
        this.mhI = -1;
        this.jjq = false;
        if (this.mhu != null) {
            this.mhu.bsy();
        }
    }

    public void onDestory() {
        if (this.mhG != null) {
            this.mhG.onDestroy();
        }
        if (this.mhu != null) {
            this.mhu.onDestroy();
        }
        if (this.eVj != null) {
            this.eVj.cancel();
            this.eVj.removeAllListeners();
            this.eVj.removeAllUpdateListeners();
            this.eVj = null;
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jjA);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.mho = aVar;
    }
}
