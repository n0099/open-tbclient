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
    private static final float mBf = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
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
    private com.baidu.tieba.model.a mBc;
    private CustomMessageListener mBd;
    private CustomMessageListener mBe;
    private PullRefreshFrameLayout mBj;
    private com.baidu.tieba.personPolymeric.header.a mBk;
    private FrameLayout mBl;
    private View mBm;
    private a mBn;
    private int mBo;
    private int mBp;
    private GradientDrawable mBq;
    private FrameLayout mBr;
    private FrameLayout.LayoutParams mBs;
    private AlphaAnimation mBt;
    private AlphaAnimation mBu;
    private com.baidu.tieba.personPolymeric.header.c mBv;
    private k mBw;
    private int mBy;
    private boolean mBz;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private CustomMessageListener mUpdatePendantListener;
    private long mUserId;
    private LinearLayout mvE;
    protected FrameLayout mvF;
    protected RelativeLayout mvH;
    private com.baidu.tieba.personPolymeric.b.f mvN;
    private com.baidu.tieba.personPolymeric.c.a mwd;
    private float[] mBh = {mBf, mBf, mBf, mBf, 0.0f, 0.0f, 0.0f, 0.0f};
    private float mBi = 674.0f;
    private boolean jKd = false;
    private int mBx = -1;
    private Runnable jKn = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.6
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.jKd) {
                p.this.cOe();
            }
        }
    };
    private com.baidu.tieba.personPolymeric.b.a myk = new com.baidu.tieba.personPolymeric.b.a() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.tieba.personPolymeric.b.a
        public void DR(int i) {
            p.this.mBs.height = -2;
            p.this.mBr.setLayoutParams(p.this.mBs);
        }

        @Override // com.baidu.tieba.personPolymeric.b.a
        public void hU(boolean z) {
            p.this.mBz = z;
            if (!z) {
                p.this.mBk.Ip(p.this.mBy);
            }
            if (p.this.mBv != null && p.this.mBv.dAP() != null) {
                p.this.mBv.dAP().setOpen(z);
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.g gVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.fKY = baseFragment;
        this.eXu = baseFragment.getPageContext();
        this.ahE = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.mvN = gVar.dzY();
        ap(gVar.mRootView);
    }

    private void ap(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.mBj = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.mBk = new com.baidu.tieba.personPolymeric.header.a(this.eXu, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.mBw = new k(this.eXu, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.mBr = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.mBs = (FrameLayout.LayoutParams) this.mBr.getLayoutParams();
        this.mBj.setOnTouchCallback(new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void w(double d) {
                p.this.mBs.height = (int) ((p.this.mBz ? com.baidu.tieba.personPolymeric.header.b.myf : 0) + p.this.mBo + (PullRefreshFrameLayout.fld * d));
                p.this.mBr.setLayoutParams(p.this.mBs);
                if (p.this.mBk != null) {
                    p.this.mBk.D(d);
                }
                p.this.mBj.bxJ();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void b(final int i, double d) {
                p.this.flz = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.flz.setDuration(150L);
                final int measuredHeight = p.this.mBr.getMeasuredHeight();
                final int cFR = p.this.mBk.cFR();
                p.this.flz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.mBs.height = (int) (measuredHeight - (i * animatedFraction));
                        p.this.mBr.setLayoutParams(p.this.mBs);
                        if (p.this.mBk != null) {
                            p.this.mBk.Iq((int) (cFR - (animatedFraction * i)));
                        }
                    }
                });
                p.this.flz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.mBp = p.this.mBs.height;
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
            public void bxM() {
                final int measuredHeight = p.this.mBr.getMeasuredHeight();
                final int i = (measuredHeight - p.this.mBo) - (p.this.mBz ? com.baidu.tieba.personPolymeric.header.b.myf : 0);
                final int cFR = p.this.mBk != null ? p.this.mBk.cFR() : 0;
                if (p.this.mBz) {
                    p.this.mBv.wI(false);
                    p.this.mBv.dAq();
                }
                if (i > 0 || (i == 0 && p.this.mBz)) {
                    p.this.flz = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.flz.setDuration(300L);
                    p.this.flz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.mBs.height = (int) (measuredHeight - (i * floatValue));
                            p.this.mBr.setLayoutParams(p.this.mBs);
                            if (p.this.mBk != null && cFR > 0) {
                                p.this.mBk.Iq((int) (cFR - (floatValue * i)));
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
                            if (p.this.mBz) {
                                p.this.mBv.dAr();
                            }
                            p.this.mBp = 0;
                            p.this.mBs.height = -2;
                            p.this.mBr.setLayoutParams(p.this.mBs);
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
        this.mBj.setOnPullRefreshListener(new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.personPolymeric.view.p.8
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void bxL() {
                com.baidu.adp.lib.f.e.mB().postDelayed(p.this.jKn, p.jJZ);
                p.this.jKd = true;
                p.this.mBx = p.this.mBn.getCurrentTabType();
                p.this.dzP();
                p.this.mBn.bVE();
            }
        });
        this.mBj.setOnCancelCallBack(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void onCancel() {
                p.this.mBp = 0;
                p.this.mBs.height = -2;
                p.this.mBr.setLayoutParams(p.this.mBs);
            }
        });
        this.mBj.setOnLoadingStartCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.10
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void bxK() {
                p.this.mBs.height = -2;
                p.this.mBr.setLayoutParams(p.this.mBs);
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
                p.this.mBj.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.mBw.wO(abs == 0);
                p.this.mBw.wP(((float) abs) > p.this.mBi / 2.0f);
                float abs2 = ((double) p.this.mBi) == 0.0d ? 0.0f : Math.abs(abs / p.this.mBi);
                p.this.mBw.aU(abs2);
                if (abs2 >= 1.0f) {
                    p.this.mBh = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mBq.setCornerRadii(p.this.mBh);
                    p.this.mBl.setBackgroundDrawable(p.this.mBq);
                    p.this.bUX();
                } else {
                    p.this.mBh = new float[]{p.mBf, p.mBf, p.mBf, p.mBf, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mBq.setCornerRadii(p.this.mBh);
                    p.this.mBl.setBackgroundDrawable(p.this.mBq);
                    p.this.dBc();
                }
                int i2 = p.this.mBp - p.this.mBo;
                if (p.this.mBp > 0 && Math.abs(i) >= i2) {
                    p.this.mBj.dismissLoading();
                }
            }
        });
        this.mBl = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
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
                p.this.mBn.Iu(i);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.mBq = new GradientDrawable();
        this.mBq.setColor(ao.getColor(R.color.CAM_X0201));
        this.mBq.setCornerRadii(this.mBh);
        this.mBl.setBackgroundDrawable(this.mBq);
        this.mBm = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        ao.setBackgroundResource(this.mBm, R.drawable.personalize_tab_shadow);
        this.fbv = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.mBn = new a(this.fKY.getActivity().getSupportFragmentManager());
        this.fbv.setAdapter(this.mBn);
        this.fbv.setOffscreenPageLimit(this.mBn.mFragments.size());
        this.mBn.notifyDataSetChanged();
        this.iIo.setViewPager(this.fbv);
        this.fbv.setCurrentItem(1);
        this.mBv = new com.baidu.tieba.personPolymeric.header.c(this.eXu, this.mIsHost);
        this.mBv.a(this.myk);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.mBr.addView(this.mBv.getView(), layoutParams);
        if (this.mBw.dBa()) {
            D(this.eXu);
        }
        C(this.eXu);
        this.gCe = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.iHz = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.mvE = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.mvF = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.mvH = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void C(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.mBw != null) {
                    p.this.mBw.dAY();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.ahE);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c dBb() {
        return this.mBv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends FragmentPagerAdapter {
        private List<PersonCenterTabBaseFragment> mFragments;
        private List<String> mgo;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mgo = new ArrayList();
            this.mgo.add(p.this.eXu.getResources().getString(R.string.person_center_tab_main));
            this.mgo.add(p.this.eXu.getResources().getString(R.string.person_center_tab_thread));
            this.mgo.add(p.this.eXu.getResources().getString(R.string.person_center_tab_dynamic));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.p(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.q(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.o(p.this.mUserId, p.this.mIsHost));
        }

        public void Iu(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.mgo.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
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
            return this.mgo.get(i);
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

        public void bVE() {
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

    private boolean bUW() {
        return this.mBm.getVisibility() == 0;
    }

    public void bUX() {
        if (!bUW() && this.mBt == null) {
            this.mBm.setVisibility(0);
            if (this.mBt == null) {
                this.mBt = new AlphaAnimation(0.0f, 1.0f);
                this.mBt.setFillAfter(true);
                this.mBt.setDuration(300L);
                this.mBt.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.14
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.mBt.reset();
                        p.this.mBt = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.mBm.startAnimation(this.mBt);
            }
        }
    }

    public void dBc() {
        if (bUW() && this.mBu == null && this.mBu == null) {
            this.mBu = new AlphaAnimation(1.0f, 0.0f);
            this.mBu.setFillAfter(true);
            this.mBu.setDuration(300L);
            this.mBu.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.15
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.mBm.setVisibility(8);
                    p.this.mBu.reset();
                    p.this.mBu = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mBm.startAnimation(this.mBu);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mBw != null) {
            this.mBw.onChangeSkinType(i);
        }
        if (this.iIo != null) {
            this.iIo.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.iIo.setRectPaintColor(R.color.CAM_X0302);
            this.iIo.onChangeSkinType();
        }
        if (this.mBq != null) {
            this.mBq.setColor(ao.getColor(R.color.CAM_X0201));
        }
        if (this.mBv != null) {
            this.mBv.onChangeSkinType(i);
        }
        if (this.mBn != null) {
            this.mBn.onChangeSkinType(i);
        }
        if (this.gCe != null) {
            this.gCe.onChangeSkinType(this.eXu, i);
        }
        if (this.iHz != null) {
            this.iHz.onChangeSkinType(this.eXu, i);
        }
        ao.setBackgroundResource(this.mvE, R.color.CAM_X0201);
        ao.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
        ao.setBackgroundResource(this.mBm, R.drawable.personalize_tab_shadow);
    }

    public void dzP() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.mBc.resetData();
            this.mBc.refreshData();
            this.mvN.doRefresh();
            return;
        }
        this.mvN.cMM();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        if (this.mBw != null) {
            this.mBw.setOnViewResponseListener(fVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.mwd = aVar;
            this.mvE.setVisibility(8);
            this.mvH.setVisibility(0);
            if (this.mBw != null) {
                this.mBw.a(aVar, personStatus);
            }
            if (this.mBv != null) {
                this.mBv.b(aVar);
            }
            if (this.mBk != null) {
                this.mBk.d(this.mwd.getUserData());
            }
            this.mBr.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.2
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.mBo == 0) {
                        p.this.mBo = p.this.mBr.getMeasuredHeight();
                        p.this.mBi = p.this.mBr.getMeasuredHeight() - p.this.mBw.dAZ().getMeasuredHeight();
                        if (p.this.mBk != null) {
                            p.this.mBy = p.this.mStatusBarHeight + p.this.mBw.dAZ().getMeasuredHeight() + p.this.mBr.getMeasuredHeight() + p.this.iIo.getMeasuredHeight();
                            boolean z2 = (p.this.mIsHost || p.this.mwd.getUserData() == null || p.this.mwd.getUserData().getNewGodData() == null || !p.this.mwd.getUserData().getNewGodData().isNewGod()) ? false : true;
                            p.this.mBs.height = p.this.mBy;
                            p.this.mBr.setLayoutParams(p.this.mBs);
                            p.this.mBy += z2 ? com.baidu.tieba.personPolymeric.header.b.myf : 0;
                            p.this.mBk.Ip(p.this.mBy);
                            p.this.mBs.height = -2;
                            p.this.mBr.setLayoutParams(p.this.mBs);
                        }
                    }
                }
            });
            this.mBn.h(aVar);
            this.mBn.g(aVar);
            if (x.isEmpty(aVar.cVg())) {
                this.mvN.bVF();
                com.baidu.adp.lib.util.l.showToast(this.eXu.getContext(), this.eXu.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.p.a.dGD().xv(this.mIsHost);
            int size = aVar.cVg().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.n nVar = aVar.cVg().get(i);
                if (nVar != null && (nVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.mvN.bVF();
                    return;
                }
            }
            if (!z) {
                this.mvN.h(true, aVar.cVg());
            }
        }
    }

    public void cMM() {
        this.mvN.cMM();
    }

    private void D(TbPageContext tbPageContext) {
        this.mBd = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.p.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.p.b) customResponsedMessage.getData()).mWX;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.mBv != null && aVar != null) {
                            p.this.mBv.wH(aVar.duv);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.mwd != null) {
                            if (p.this.mwd.mwS != null && p.this.mwd.mwS.iQK != null && aVar2 != null) {
                                p.this.mwd.mwS.iQK.putBoolean("person_center_item_red_tip_show", aVar2.duv);
                            }
                            if (aVar3 != null && p.this.mwd.mwR != null && p.this.mwd.mwR.iQK != null) {
                                p.this.mwd.mwR.iQK.putBoolean("person_center_item_red_tip_show", aVar3.duv);
                            }
                            if (aVar4 != null && p.this.mwd.mwQ != null && p.this.mwd.mwQ.iQK != null) {
                                p.this.mwd.mwQ.iQK.putBoolean("person_center_item_red_tip_show", aVar4.duv);
                            }
                            if (aVar5 != null && p.this.mwd.mwT != null && p.this.mwd.mwT.iQK != null) {
                                p.this.mwd.mwT.iQK.putBoolean("person_center_item_red_tip_show", aVar5.duv);
                            }
                            if (aVar6 != null && p.this.mwd.mwU != null && p.this.mwd.mwU.iQK != null) {
                                p.this.mwd.mwU.iQK.putBoolean("person_center_item_red_tip_show", aVar6.duv);
                                p.this.mwd.mwU.iQK.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.mBd.setTag(this.ahE);
        tbPageContext.registerListener(this.mBd);
        this.mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.n nVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n) && (nVar = (com.baidu.tbadk.data.n) customResponsedMessage.getData()) != null) {
                    p.this.mBv.QQ(nVar.getImgUrl());
                }
            }
        };
        this.mUpdatePendantListener.setTag(this.ahE);
        tbPageContext.registerListener(this.mUpdatePendantListener);
        this.mBe = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.mBx == ((Integer) customResponsedMessage.getData()).intValue() && p.this.jKd) {
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(p.this.jKn);
                    p.this.cOe();
                }
            }
        };
        this.mBe.setTag(this.ahE);
        tbPageContext.registerListener(this.mBe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOe() {
        this.mBx = -1;
        this.jKd = false;
        if (this.mBj != null) {
            this.mBj.bxH();
        }
    }

    public void onDestory() {
        if (this.mBv != null) {
            this.mBv.onDestroy();
        }
        if (this.mBj != null) {
            this.mBj.onDestroy();
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
        this.mBc = aVar;
    }
}
