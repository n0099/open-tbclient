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
/* loaded from: classes8.dex */
public class p {
    public static int jJZ = 5000;
    private static final float mBe = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout ZS;
    private BdUniqueId ahE;
    private TbPageContext eXu;
    private BaseFragment fKY;
    private CustomViewPager fbv;
    private ValueAnimator flz;
    private NoNetworkView gCe;
    private PluginErrorTipView iHz;
    private NewPagerSlidingTabBaseStrip iIo;
    private CustomMessageListener mAccountChangedListener;
    private com.baidu.tieba.model.a mBb;
    private CustomMessageListener mBc;
    private CustomMessageListener mBd;
    private PullRefreshFrameLayout mBi;
    private com.baidu.tieba.personPolymeric.header.a mBj;
    private FrameLayout mBk;
    private View mBl;
    private a mBm;
    private int mBn;
    private int mBo;
    private GradientDrawable mBp;
    private FrameLayout mBq;
    private FrameLayout.LayoutParams mBr;
    private AlphaAnimation mBs;
    private AlphaAnimation mBt;
    private com.baidu.tieba.personPolymeric.header.c mBu;
    private k mBv;
    private int mBx;
    private boolean mBy;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private CustomMessageListener mUpdatePendantListener;
    private long mUserId;
    private LinearLayout mvD;
    protected FrameLayout mvE;
    protected RelativeLayout mvG;
    private com.baidu.tieba.personPolymeric.b.f mvM;
    private com.baidu.tieba.personPolymeric.c.a mwc;
    private float[] mBf = {mBe, mBe, mBe, mBe, 0.0f, 0.0f, 0.0f, 0.0f};
    private float mBh = 674.0f;
    private boolean jKd = false;
    private int mBw = -1;
    private Runnable jKn = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.6
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.jKd) {
                p.this.cOf();
            }
        }
    };
    private com.baidu.tieba.personPolymeric.b.a myj = new com.baidu.tieba.personPolymeric.b.a() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.tieba.personPolymeric.b.a
        public void DR(int i) {
            p.this.mBr.height = -2;
            p.this.mBq.setLayoutParams(p.this.mBr);
        }

        @Override // com.baidu.tieba.personPolymeric.b.a
        public void hU(boolean z) {
            p.this.mBy = z;
            if (!z) {
                p.this.mBj.Ip(p.this.mBx);
            }
            if (p.this.mBu != null && p.this.mBu.dAQ() != null) {
                p.this.mBu.dAQ().setOpen(z);
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.g gVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.fKY = baseFragment;
        this.eXu = baseFragment.getPageContext();
        this.ahE = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.mvM = gVar.dzZ();
        ap(gVar.mRootView);
    }

    private void ap(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.mBi = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.mBj = new com.baidu.tieba.personPolymeric.header.a(this.eXu, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.mBv = new k(this.eXu, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.mBq = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.mBr = (FrameLayout.LayoutParams) this.mBq.getLayoutParams();
        this.mBi.setOnTouchCallback(new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void w(double d) {
                p.this.mBr.height = (int) ((p.this.mBy ? com.baidu.tieba.personPolymeric.header.b.mye : 0) + p.this.mBn + (PullRefreshFrameLayout.fld * d));
                p.this.mBq.setLayoutParams(p.this.mBr);
                if (p.this.mBj != null) {
                    p.this.mBj.D(d);
                }
                p.this.mBi.bxK();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void b(final int i, double d) {
                p.this.flz = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.flz.setDuration(150L);
                final int measuredHeight = p.this.mBq.getMeasuredHeight();
                final int cFS = p.this.mBj.cFS();
                p.this.flz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.mBr.height = (int) (measuredHeight - (i * animatedFraction));
                        p.this.mBq.setLayoutParams(p.this.mBr);
                        if (p.this.mBj != null) {
                            p.this.mBj.Iq((int) (cFS - (animatedFraction * i)));
                        }
                    }
                });
                p.this.flz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.mBo = p.this.mBr.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.flz.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void bxN() {
                final int measuredHeight = p.this.mBq.getMeasuredHeight();
                final int i = (measuredHeight - p.this.mBn) - (p.this.mBy ? com.baidu.tieba.personPolymeric.header.b.mye : 0);
                final int cFS = p.this.mBj != null ? p.this.mBj.cFS() : 0;
                if (p.this.mBy) {
                    p.this.mBu.wI(false);
                    p.this.mBu.dAr();
                }
                if (i > 0 || (i == 0 && p.this.mBy)) {
                    p.this.flz = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.flz.setDuration(300L);
                    p.this.flz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.mBr.height = (int) (measuredHeight - (i * floatValue));
                            p.this.mBq.setLayoutParams(p.this.mBr);
                            if (p.this.mBj != null && cFS > 0) {
                                p.this.mBj.Iq((int) (cFS - (floatValue * i)));
                            }
                        }
                    });
                    p.this.flz.start();
                    p.this.flz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (p.this.mBy) {
                                p.this.mBu.dAs();
                            }
                            p.this.mBo = 0;
                            p.this.mBr.height = -2;
                            p.this.mBq.setLayoutParams(p.this.mBr);
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
        this.mBi.setOnPullRefreshListener(new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.personPolymeric.view.p.8
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bxM() {
                com.baidu.adp.lib.f.e.mB().postDelayed(p.this.jKn, p.jJZ);
                p.this.jKd = true;
                p.this.mBw = p.this.mBm.getCurrentTabType();
                p.this.dzQ();
                p.this.mBm.bVF();
            }
        });
        this.mBi.setOnCancelCallBack(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void onCancel() {
                p.this.mBo = 0;
                p.this.mBr.height = -2;
                p.this.mBq.setLayoutParams(p.this.mBr);
            }
        });
        this.mBi.setOnLoadingStartCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.10
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void bxL() {
                p.this.mBr.height = -2;
                p.this.mBq.setLayoutParams(p.this.mBr);
            }
        });
        this.ZS = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.ZS.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.11
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.eXu.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.eXu.getPageActivity());
                }
                p.this.mBi.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.mBv.wO(abs == 0);
                p.this.mBv.wP(((float) abs) > p.this.mBh / 2.0f);
                float abs2 = ((double) p.this.mBh) == 0.0d ? 0.0f : Math.abs(abs / p.this.mBh);
                p.this.mBv.aU(abs2);
                if (abs2 >= 1.0f) {
                    p.this.mBf = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mBp.setCornerRadii(p.this.mBf);
                    p.this.mBk.setBackgroundDrawable(p.this.mBp);
                    p.this.bUY();
                } else {
                    p.this.mBf = new float[]{p.mBe, p.mBe, p.mBe, p.mBe, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mBp.setCornerRadii(p.this.mBf);
                    p.this.mBk.setBackgroundDrawable(p.this.mBp);
                    p.this.dBd();
                }
                int i2 = p.this.mBo - p.this.mBn;
                if (p.this.mBo > 0 && Math.abs(i) >= i2) {
                    p.this.mBi.dismissLoading();
                }
            }
        });
        this.mBk = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.iIo = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.iIo.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        this.iIo.setRectPaintColor(R.color.CAM_X0302);
        this.iIo.a(com.baidu.adp.lib.util.l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds46), true);
        this.iIo.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds64));
        this.iIo.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds8));
        this.iIo.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds8));
        this.iIo.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds0));
        this.iIo.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds166), -1));
        this.iIo.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.12
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.mBm.Iu(i);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.mBp = new GradientDrawable();
        this.mBp.setColor(ao.getColor(R.color.CAM_X0201));
        this.mBp.setCornerRadii(this.mBf);
        this.mBk.setBackgroundDrawable(this.mBp);
        this.mBl = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        ao.setBackgroundResource(this.mBl, R.drawable.personalize_tab_shadow);
        this.fbv = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.mBm = new a(this.fKY.getActivity().getSupportFragmentManager());
        this.fbv.setAdapter(this.mBm);
        this.fbv.setOffscreenPageLimit(this.mBm.mFragments.size());
        this.mBm.notifyDataSetChanged();
        this.iIo.setViewPager(this.fbv);
        this.fbv.setCurrentItem(1);
        this.mBu = new com.baidu.tieba.personPolymeric.header.c(this.eXu, this.mIsHost);
        this.mBu.a(this.myj);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.mBq.addView(this.mBu.getView(), layoutParams);
        if (this.mBv.dBb()) {
            D(this.eXu);
        }
        C(this.eXu);
        this.gCe = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.iHz = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.mvD = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.mvE = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.mvG = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void C(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.mBv != null) {
                    p.this.mBv.dAZ();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.ahE);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c dBc() {
        return this.mBu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends FragmentPagerAdapter {
        private List<PersonCenterTabBaseFragment> mFragments;
        private List<String> mgn;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mgn = new ArrayList();
            this.mgn.add(p.this.eXu.getResources().getString(R.string.person_center_tab_main));
            this.mgn.add(p.this.eXu.getResources().getString(R.string.person_center_tab_thread));
            this.mgn.add(p.this.eXu.getResources().getString(R.string.person_center_tab_dynamic));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.p(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.q(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.o(p.this.mUserId, p.this.mIsHost));
        }

        public void Iu(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.mgn.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
                if (i2 == i) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return Iw(i);
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
            return Iv(i);
        }

        private String Iv(int i) {
            return this.mgn.get(i);
        }

        public PersonCenterTabBaseFragment Iw(int i) {
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

        public void bVF() {
            if (!x.isEmpty(this.mFragments)) {
                for (int i = 0; i < this.mFragments.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.wK(false);
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
                            personCenterTabBaseFragment.a(aVar.eTY);
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

    private boolean bUX() {
        return this.mBl.getVisibility() == 0;
    }

    public void bUY() {
        if (!bUX() && this.mBs == null) {
            this.mBl.setVisibility(0);
            if (this.mBs == null) {
                this.mBs = new AlphaAnimation(0.0f, 1.0f);
                this.mBs.setFillAfter(true);
                this.mBs.setDuration(300L);
                this.mBs.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.14
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.mBs.reset();
                        p.this.mBs = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.mBl.startAnimation(this.mBs);
            }
        }
    }

    public void dBd() {
        if (bUX() && this.mBt == null && this.mBt == null) {
            this.mBt = new AlphaAnimation(1.0f, 0.0f);
            this.mBt.setFillAfter(true);
            this.mBt.setDuration(300L);
            this.mBt.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.15
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.mBl.setVisibility(8);
                    p.this.mBt.reset();
                    p.this.mBt = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mBl.startAnimation(this.mBt);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mBv != null) {
            this.mBv.onChangeSkinType(i);
        }
        if (this.iIo != null) {
            this.iIo.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.iIo.setRectPaintColor(R.color.CAM_X0302);
            this.iIo.onChangeSkinType();
        }
        if (this.mBp != null) {
            this.mBp.setColor(ao.getColor(R.color.CAM_X0201));
        }
        if (this.mBu != null) {
            this.mBu.onChangeSkinType(i);
        }
        if (this.mBm != null) {
            this.mBm.onChangeSkinType(i);
        }
        if (this.gCe != null) {
            this.gCe.onChangeSkinType(this.eXu, i);
        }
        if (this.iHz != null) {
            this.iHz.onChangeSkinType(this.eXu, i);
        }
        ao.setBackgroundResource(this.mvD, R.color.CAM_X0201);
        ao.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
        ao.setBackgroundResource(this.mBl, R.drawable.personalize_tab_shadow);
    }

    public void dzQ() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.mBb.resetData();
            this.mBb.refreshData();
            this.mvM.doRefresh();
            return;
        }
        this.mvM.cMN();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        if (this.mBv != null) {
            this.mBv.setOnViewResponseListener(fVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.mwc = aVar;
            this.mvD.setVisibility(8);
            this.mvG.setVisibility(0);
            if (this.mBv != null) {
                this.mBv.a(aVar, personStatus);
            }
            if (this.mBu != null) {
                this.mBu.b(aVar);
            }
            if (this.mBj != null) {
                this.mBj.d(this.mwc.getUserData());
            }
            this.mBq.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.2
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.mBn == 0) {
                        p.this.mBn = p.this.mBq.getMeasuredHeight();
                        p.this.mBh = p.this.mBq.getMeasuredHeight() - p.this.mBv.dBa().getMeasuredHeight();
                        if (p.this.mBj != null) {
                            p.this.mBx = p.this.mStatusBarHeight + p.this.mBv.dBa().getMeasuredHeight() + p.this.mBq.getMeasuredHeight() + p.this.iIo.getMeasuredHeight();
                            boolean z2 = (p.this.mIsHost || p.this.mwc.getUserData() == null || p.this.mwc.getUserData().getNewGodData() == null || !p.this.mwc.getUserData().getNewGodData().isNewGod()) ? false : true;
                            p.this.mBr.height = p.this.mBx;
                            p.this.mBq.setLayoutParams(p.this.mBr);
                            p.this.mBx += z2 ? com.baidu.tieba.personPolymeric.header.b.mye : 0;
                            p.this.mBj.Ip(p.this.mBx);
                            p.this.mBr.height = -2;
                            p.this.mBq.setLayoutParams(p.this.mBr);
                        }
                    }
                }
            });
            this.mBm.h(aVar);
            this.mBm.g(aVar);
            if (x.isEmpty(aVar.cVh())) {
                this.mvM.bVG();
                com.baidu.adp.lib.util.l.showToast(this.eXu.getContext(), this.eXu.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.dGE().xv(this.mIsHost);
            int size = aVar.cVh().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.n nVar = aVar.cVh().get(i);
                if (nVar != null && (nVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.mvM.bVG();
                    return;
                }
            }
            if (!z) {
                this.mvM.h(true, aVar.cVh());
            }
        }
    }

    public void cMN() {
        this.mvM.cMN();
    }

    private void D(TbPageContext tbPageContext) {
        this.mBc = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).mWW;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.mBu != null && aVar != null) {
                            p.this.mBu.wH(aVar.duv);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.mwc != null) {
                            if (p.this.mwc.mwR != null && p.this.mwc.mwR.iQK != null && aVar2 != null) {
                                p.this.mwc.mwR.iQK.putBoolean("person_center_item_red_tip_show", aVar2.duv);
                            }
                            if (aVar3 != null && p.this.mwc.mwQ != null && p.this.mwc.mwQ.iQK != null) {
                                p.this.mwc.mwQ.iQK.putBoolean("person_center_item_red_tip_show", aVar3.duv);
                            }
                            if (aVar4 != null && p.this.mwc.mwP != null && p.this.mwc.mwP.iQK != null) {
                                p.this.mwc.mwP.iQK.putBoolean("person_center_item_red_tip_show", aVar4.duv);
                            }
                            if (aVar5 != null && p.this.mwc.mwS != null && p.this.mwc.mwS.iQK != null) {
                                p.this.mwc.mwS.iQK.putBoolean("person_center_item_red_tip_show", aVar5.duv);
                            }
                            if (aVar6 != null && p.this.mwc.mwT != null && p.this.mwc.mwT.iQK != null) {
                                p.this.mwc.mwT.iQK.putBoolean("person_center_item_red_tip_show", aVar6.duv);
                                p.this.mwc.mwT.iQK.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.mBc.setTag(this.ahE);
        tbPageContext.registerListener(this.mBc);
        this.mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.n nVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n) && (nVar = (com.baidu.tbadk.data.n) customResponsedMessage.getData()) != null) {
                    p.this.mBu.QP(nVar.getImgUrl());
                }
            }
        };
        this.mUpdatePendantListener.setTag(this.ahE);
        tbPageContext.registerListener(this.mUpdatePendantListener);
        this.mBd = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.mBw == ((Integer) customResponsedMessage.getData()).intValue() && p.this.jKd) {
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(p.this.jKn);
                    p.this.cOf();
                }
            }
        };
        this.mBd.setTag(this.ahE);
        tbPageContext.registerListener(this.mBd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOf() {
        this.mBw = -1;
        this.jKd = false;
        if (this.mBi != null) {
            this.mBi.bxI();
        }
    }

    public void onDestory() {
        if (this.mBu != null) {
            this.mBu.onDestroy();
        }
        if (this.mBi != null) {
            this.mBi.onDestroy();
        }
        if (this.flz != null) {
            this.flz.cancel();
            this.flz.removeAllListeners();
            this.flz.removeAllUpdateListeners();
            this.flz = null;
        }
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jKn);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.mBb = aVar;
    }
}
