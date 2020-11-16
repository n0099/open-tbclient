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
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterMainTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment;
import com.baidu.tieba.q.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class p {
    public static int jjX = 5000;
    private static final float mhK = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout Ym;
    private BdUniqueId aiE;
    private TbPageContext eGu;
    private CustomViewPager eKk;
    private ValueAnimator eUt;
    private BaseFragment ftH;
    private NoNetworkView giU;
    private PluginErrorTipView ikr;
    private NewPagerSlidingTabBaseStrip ilf;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private CustomMessageListener mUpdatePendantListener;
    private long mUserId;
    private com.baidu.tieba.personPolymeric.c.a mcH;
    private LinearLayout mcj;
    protected FrameLayout mck;
    protected RelativeLayout mcm;
    private com.baidu.tieba.personPolymeric.b.f mcs;
    private com.baidu.tieba.model.a mhH;
    private CustomMessageListener mhI;
    private CustomMessageListener mhJ;
    private PullRefreshFrameLayout mhN;
    private com.baidu.tieba.personPolymeric.header.a mhO;
    private FrameLayout mhP;
    private View mhQ;
    private a mhR;
    private int mhS;
    private int mhT;
    private GradientDrawable mhU;
    private FrameLayout mhV;
    private FrameLayout.LayoutParams mhW;
    private AlphaAnimation mhX;
    private AlphaAnimation mhY;
    private com.baidu.tieba.personPolymeric.header.c mhZ;
    private k mia;
    private int mic;
    private boolean mie;
    private float[] mhL = {mhK, mhK, mhK, mhK, 0.0f, 0.0f, 0.0f, 0.0f};
    private float mhM = 674.0f;
    private boolean jkb = false;
    private int mib = -1;
    private Runnable jkl = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.6
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.jkb) {
                p.this.cFM();
            }
        }
    };
    private com.baidu.tieba.personPolymeric.b.a meP = new com.baidu.tieba.personPolymeric.b.a() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.tieba.personPolymeric.b.a
        public void CO(int i) {
            p.this.mhW.height = -2;
            p.this.mhV.setLayoutParams(p.this.mhW);
        }

        @Override // com.baidu.tieba.personPolymeric.b.a
        public void hn(boolean z) {
            p.this.mie = z;
            if (!z) {
                p.this.mhO.HE(p.this.mic);
            }
            if (p.this.mhZ != null && p.this.mhZ.dvH() != null) {
                p.this.mhZ.dvH().setOpen(z);
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.g gVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.ftH = baseFragment;
        this.eGu = baseFragment.getPageContext();
        this.aiE = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.mcs = gVar.duQ();
        al(gVar.mRootView);
    }

    private void al(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.mhN = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        View findViewById = this.mRootView.findViewById(R.id.person_center_background_cover);
        this.mhO = new com.baidu.tieba.personPolymeric.header.a(this.eGu, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), findViewById, this.mIsHost);
        this.mia = new k(this.eGu, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.mhV = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.mhW = (FrameLayout.LayoutParams) this.mhV.getLayoutParams();
        this.mhN.setOnTouchCallback(new PullRefreshFrameLayout.d() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void w(double d) {
                p.this.mhW.height = (int) ((p.this.mie ? com.baidu.tieba.personPolymeric.header.b.meK : 0) + p.this.mhS + (PullRefreshFrameLayout.eTX * d));
                p.this.mhV.setLayoutParams(p.this.mhW);
                if (p.this.mhO != null) {
                    p.this.mhO.D(d);
                }
                p.this.mhN.brP();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void c(final int i, double d) {
                p.this.eUt = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.eUt.setDuration(150L);
                final int measuredHeight = p.this.mhV.getMeasuredHeight();
                final int cyF = p.this.mhO.cyF();
                p.this.eUt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.mhW.height = (int) (measuredHeight - (i * animatedFraction));
                        p.this.mhV.setLayoutParams(p.this.mhW);
                        if (p.this.mhO != null) {
                            p.this.mhO.HF((int) (cyF - (animatedFraction * i)));
                        }
                    }
                });
                p.this.eUt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.mhT = p.this.mhW.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.eUt.start();
            }

            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.d
            public void brS() {
                final int measuredHeight = p.this.mhV.getMeasuredHeight();
                final int i = (measuredHeight - p.this.mhS) - (p.this.mie ? com.baidu.tieba.personPolymeric.header.b.meK : 0);
                final int cyF = p.this.mhO != null ? p.this.mhO.cyF() : 0;
                if (p.this.mie) {
                    p.this.mhZ.wd(false);
                    p.this.mhZ.dvi();
                }
                if (i > 0 || (i == 0 && p.this.mie)) {
                    p.this.eUt = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.eUt.setDuration(300L);
                    p.this.eUt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.mhW.height = (int) (measuredHeight - (i * floatValue));
                            p.this.mhV.setLayoutParams(p.this.mhW);
                            if (p.this.mhO != null && cyF > 0) {
                                p.this.mhO.HF((int) (cyF - (floatValue * i)));
                            }
                        }
                    });
                    p.this.eUt.start();
                    p.this.eUt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (p.this.mie) {
                                p.this.mhZ.dvj();
                            }
                            p.this.mhT = 0;
                            p.this.mhW.height = -2;
                            p.this.mhV.setLayoutParams(p.this.mhW);
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
        this.mhN.setOnPullRefreshListener(new PullRefreshFrameLayout.c() { // from class: com.baidu.tieba.personPolymeric.view.p.8
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.c
            public void brR() {
                com.baidu.adp.lib.f.e.mY().postDelayed(p.this.jkl, p.jjX);
                p.this.jkb = true;
                p.this.mib = p.this.mhR.getCurrentTabType();
                p.this.duH();
                p.this.mhR.bPo();
            }
        });
        this.mhN.setOnCancelCallBack(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.9
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.a
            public void onCancel() {
                p.this.mhT = 0;
                p.this.mhW.height = -2;
                p.this.mhV.setLayoutParams(p.this.mhW);
            }
        });
        this.mhN.setOnLoadingStartCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.10
            @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.b
            public void brQ() {
                p.this.mhW.height = -2;
                p.this.mhV.setLayoutParams(p.this.mhW);
            }
        });
        this.Ym = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.Ym.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.11
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.eGu.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.eGu.getPageActivity());
                }
                p.this.mhN.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.mia.wj(abs == 0);
                p.this.mia.wk(((float) abs) > p.this.mhM / 2.0f);
                float abs2 = ((double) p.this.mhM) == 0.0d ? 0.0f : Math.abs(abs / p.this.mhM);
                p.this.mia.aR(abs2);
                if (abs2 >= 1.0f) {
                    p.this.mhL = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mhU.setCornerRadii(p.this.mhL);
                    p.this.mhP.setBackgroundDrawable(p.this.mhU);
                    p.this.bOJ();
                } else {
                    p.this.mhL = new float[]{p.mhK, p.mhK, p.mhK, p.mhK, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.mhU.setCornerRadii(p.this.mhL);
                    p.this.mhP.setBackgroundDrawable(p.this.mhU);
                    p.this.dvU();
                }
                int i2 = p.this.mhT - p.this.mhS;
                if (p.this.mhT > 0 && Math.abs(i) >= i2) {
                    p.this.mhN.dismissLoading();
                }
            }
        });
        this.mhP = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.ilf = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.ilf.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        this.ilf.setRectPaintColor(R.color.CAM_X0302);
        this.ilf.a(com.baidu.adp.lib.util.l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds46), true);
        this.ilf.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds64));
        this.ilf.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds8));
        this.ilf.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds8));
        this.ilf.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds0));
        this.ilf.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds166), -1));
        this.ilf.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.12
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.mhR.HJ(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.mhU = new GradientDrawable();
        this.mhU.setColor(ap.getColor(R.color.CAM_X0201));
        this.mhU.setCornerRadii(this.mhL);
        this.mhP.setBackgroundDrawable(this.mhU);
        this.mhQ = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        ap.setBackgroundResource(this.mhQ, R.drawable.personalize_tab_shadow);
        this.eKk = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.mhR = new a(this.ftH.getActivity().getSupportFragmentManager());
        this.eKk.setAdapter(this.mhR);
        this.eKk.setOffscreenPageLimit(this.mhR.mFragments.size());
        this.mhR.notifyDataSetChanged();
        this.ilf.setViewPager(this.eKk);
        this.eKk.setCurrentItem(1);
        this.mhZ = new com.baidu.tieba.personPolymeric.header.c(this.eGu, this.mIsHost);
        this.mhZ.a(this.meP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.mhV.addView(this.mhZ.getView(), layoutParams);
        if (this.mia.dvS()) {
            E(this.eGu);
        }
        D(this.eGu);
        this.giU = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.ikr = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.mcj = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.mck = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.mcm = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void D(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.mia != null) {
                    p.this.mia.dvQ();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.aiE);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c dvT() {
        return this.mhZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a extends FragmentPagerAdapter {
        private List<String> lMY;
        private List<PersonCenterTabBaseFragment> mFragments;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.lMY = new ArrayList();
            this.lMY.add(p.this.eGu.getResources().getString(R.string.person_center_tab_main));
            this.lMY.add(p.this.eGu.getResources().getString(R.string.person_center_tab_thread));
            this.lMY.add(p.this.eGu.getResources().getString(R.string.person_center_tab_dynamic));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.o(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.p(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.n(p.this.mUserId, p.this.mIsHost));
        }

        public void HJ(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.lMY.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
                if (i2 == i) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return HL(i);
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
            return HK(i);
        }

        private String HK(int i) {
            return this.lMY.get(i);
        }

        public PersonCenterTabBaseFragment HL(int i) {
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

        public void bPo() {
            if (!y.isEmpty(this.mFragments)) {
                for (int i = 0; i < this.mFragments.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.wf(false);
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
                            personCenterTabBaseFragment.a(aVar.eDc);
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

    private boolean bOI() {
        return this.mhQ.getVisibility() == 0;
    }

    public void bOJ() {
        if (!bOI() && this.mhX == null) {
            this.mhQ.setVisibility(0);
            if (this.mhX == null) {
                this.mhX = new AlphaAnimation(0.0f, 1.0f);
                this.mhX.setFillAfter(true);
                this.mhX.setDuration(300L);
                this.mhX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.14
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.mhX.reset();
                        p.this.mhX = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.mhQ.startAnimation(this.mhX);
            }
        }
    }

    public void dvU() {
        if (bOI() && this.mhY == null && this.mhY == null) {
            this.mhY = new AlphaAnimation(1.0f, 0.0f);
            this.mhY.setFillAfter(true);
            this.mhY.setDuration(300L);
            this.mhY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.15
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.mhQ.setVisibility(8);
                    p.this.mhY.reset();
                    p.this.mhY = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mhQ.startAnimation(this.mhY);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mia != null) {
            this.mia.onChangeSkinType(i);
        }
        if (this.ilf != null) {
            this.ilf.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.ilf.setRectPaintColor(R.color.CAM_X0302);
            this.ilf.onChangeSkinType();
        }
        if (this.mhU != null) {
            this.mhU.setColor(ap.getColor(R.color.CAM_X0201));
        }
        if (this.mhZ != null) {
            this.mhZ.onChangeSkinType(i);
        }
        if (this.mhR != null) {
            this.mhR.onChangeSkinType(i);
        }
        if (this.giU != null) {
            this.giU.onChangeSkinType(this.eGu, i);
        }
        if (this.ikr != null) {
            this.ikr.onChangeSkinType(this.eGu, i);
        }
        ap.setBackgroundResource(this.mcj, R.color.CAM_X0201);
        ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
        ap.setBackgroundResource(this.mhQ, R.drawable.personalize_tab_shadow);
    }

    public void duH() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.mhH.resetData();
            this.mhH.refreshData();
            this.mcs.doRefresh();
            return;
        }
        this.mcs.cEy();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.f fVar) {
        if (this.mia != null) {
            this.mia.setOnViewResponseListener(fVar);
        }
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.mcH = aVar;
            this.mcj.setVisibility(8);
            this.mcm.setVisibility(0);
            if (this.mia != null) {
                this.mia.a(aVar, personStatus);
            }
            if (this.mhZ != null) {
                this.mhZ.b(aVar);
            }
            if (this.mhO != null) {
                this.mhO.e(this.mcH.getUserData());
            }
            this.mhV.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.2
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.mhS == 0) {
                        p.this.mhS = p.this.mhV.getMeasuredHeight();
                        p.this.mhM = p.this.mhV.getMeasuredHeight() - p.this.mia.dvR().getMeasuredHeight();
                        if (p.this.mhO != null) {
                            p.this.mic = p.this.mStatusBarHeight + p.this.mia.dvR().getMeasuredHeight() + p.this.mhV.getMeasuredHeight() + p.this.ilf.getMeasuredHeight();
                            boolean z2 = (p.this.mIsHost || p.this.mcH.getUserData() == null || p.this.mcH.getUserData().getNewGodData() == null || !p.this.mcH.getUserData().getNewGodData().isNewGod()) ? false : true;
                            p.this.mhW.height = p.this.mic;
                            p.this.mhV.setLayoutParams(p.this.mhW);
                            p.this.mic += z2 ? com.baidu.tieba.personPolymeric.header.b.meK : 0;
                            p.this.mhO.HE(p.this.mic);
                            p.this.mhW.height = -2;
                            p.this.mhV.setLayoutParams(p.this.mhW);
                        }
                    }
                }
            });
            this.mhR.h(aVar);
            this.mhR.g(aVar);
            if (y.isEmpty(aVar.cML())) {
                this.mcs.bPp();
                com.baidu.adp.lib.util.l.showToast(this.eGu.getContext(), this.eGu.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.q.a.dBC().wQ(this.mIsHost);
            int size = aVar.cML().size();
            for (int i = 0; i < size; i++) {
                q qVar = aVar.cML().get(i);
                if (qVar != null && (qVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.mcs.bPp();
                    return;
                }
            }
            if (!z) {
                this.mcs.g(true, aVar.cML());
            }
        }
    }

    public void cEy() {
        this.mcs.cEy();
    }

    private void E(TbPageContext tbPageContext) {
        this.mhI = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.q.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.q.b) customResponsedMessage.getData()).mDu;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.mhZ != null && aVar != null) {
                            p.this.mhZ.wc(aVar.dix);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.mcH != null) {
                            if (p.this.mcH.mdw != null && p.this.mcH.mdw.itE != null && aVar2 != null) {
                                p.this.mcH.mdw.itE.putBoolean("person_center_item_red_tip_show", aVar2.dix);
                            }
                            if (aVar3 != null && p.this.mcH.mdv != null && p.this.mcH.mdv.itE != null) {
                                p.this.mcH.mdv.itE.putBoolean("person_center_item_red_tip_show", aVar3.dix);
                            }
                            if (aVar4 != null && p.this.mcH.mdu != null && p.this.mcH.mdu.itE != null) {
                                p.this.mcH.mdu.itE.putBoolean("person_center_item_red_tip_show", aVar4.dix);
                            }
                            if (aVar5 != null && p.this.mcH.mdx != null && p.this.mcH.mdx.itE != null) {
                                p.this.mcH.mdx.itE.putBoolean("person_center_item_red_tip_show", aVar5.dix);
                            }
                            if (aVar6 != null && p.this.mcH.mdy != null && p.this.mcH.mdy.itE != null) {
                                p.this.mcH.mdy.itE.putBoolean("person_center_item_red_tip_show", aVar6.dix);
                                p.this.mcH.mdy.itE.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.mhI.setTag(this.aiE);
        tbPageContext.registerListener(this.mhI);
        this.mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.m mVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && (mVar = (com.baidu.tbadk.data.m) customResponsedMessage.getData()) != null) {
                    p.this.mhZ.Qb(mVar.bjy());
                }
            }
        };
        this.mUpdatePendantListener.setTag(this.aiE);
        tbPageContext.registerListener(this.mUpdatePendantListener);
        this.mhJ = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.mib == ((Integer) customResponsedMessage.getData()).intValue() && p.this.jkb) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(p.this.jkl);
                    p.this.cFM();
                }
            }
        };
        this.mhJ.setTag(this.aiE);
        tbPageContext.registerListener(this.mhJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFM() {
        this.mib = -1;
        this.jkb = false;
        if (this.mhN != null) {
            this.mhN.brN();
        }
    }

    public void onDestory() {
        if (this.mhZ != null) {
            this.mhZ.onDestroy();
        }
        if (this.mhN != null) {
            this.mhN.onDestroy();
        }
        if (this.eUt != null) {
            this.eUt.cancel();
            this.eUt.removeAllListeners();
            this.eUt.removeAllUpdateListeners();
            this.eUt = null;
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jkl);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.mhH = aVar;
    }
}
