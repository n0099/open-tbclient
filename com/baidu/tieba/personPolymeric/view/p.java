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
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.o.b;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterMainTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment;
import com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class p {
    public static int jnK = 5000;
    private static final float jnP = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout Cf;
    private BdUniqueId Mh;
    private TbPageContext cQU;
    private CustomViewPager cTN;
    private BaseFragment dyF;
    private NoNetworkView egT;
    private PluginErrorTipView fPm;
    private NewPagerSlidingTabBaseStrip fQd;
    private com.baidu.tieba.write.f gmy;
    private CustomMessageListener jcA;
    private LinearLayout jiI;
    protected FrameLayout jiJ;
    protected RelativeLayout jiL;
    private com.baidu.tieba.personPolymeric.b.e jiR;
    private com.baidu.tieba.personPolymeric.c.a jjg;
    private com.baidu.tieba.model.a jnL;
    private CustomMessageListener jnM;
    private CustomMessageListener jnN;
    private boolean jnO;
    private PullRefreshFrameLayout jnS;
    private OvalActionButton jnT;
    private com.baidu.tieba.personPolymeric.header.a jnU;
    private FrameLayout jnV;
    private View jnW;
    private View jnX;
    private View jnY;
    private View jnZ;
    private ImageView joa;
    private FrameLayout job;
    private ImageView joc;
    private a jod;
    private int joe;
    private int jof;
    private GradientDrawable jog;
    private FrameLayout joh;
    private FrameLayout.LayoutParams joi;
    private AlphaAnimation joj;
    private AlphaAnimation jok;
    private com.baidu.tieba.personPolymeric.header.c jol;
    private k jom;
    private ValueAnimator jon;
    private boolean joo;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private long mUserId;
    private float[] jnQ = {jnP, jnP, jnP, jnP, 0.0f, 0.0f, 0.0f, 0.0f};
    private float jnR = 674.0f;
    private boolean jop = false;
    private int joq = -1;
    private Runnable jor = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.6
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.jop) {
                p.this.cvm();
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.f fVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.dyF = baseFragment;
        this.cQU = baseFragment.getPageContext();
        this.Mh = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.jiR = fVar.cum();
        initView(fVar.mRootView);
    }

    private void initView(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.jnS = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        this.jnT = (OvalActionButton) this.mRootView.findViewById(R.id.person_center_post_forum_btn);
        this.gmy = new com.baidu.tieba.write.f(this.cQU, (ViewGroup) view, AlbumActivityConfig.FROM_PERSON, 1);
        this.gmy.Kp("3");
        this.jnT.setVisibility(this.mIsHost ? 0 : 8);
        String[] cvk = cvk();
        this.jnT.setStartAndEndColor(cvk[0], cvk[1]);
        this.jnT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                p.this.cvj();
                p.this.gmy.a(false, (View) null, (View) p.this.jnT);
            }
        });
        this.jnU = new com.baidu.tieba.personPolymeric.header.a(this.cQU, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), this.mRootView.findViewById(R.id.person_center_background_cover), this.mIsHost);
        this.jom = new k(this.cQU, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.joh = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.joi = (FrameLayout.LayoutParams) this.joh.getLayoutParams();
        this.jnS.setOnTouchCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.7
            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.b
            public void l(double d) {
                p.this.joi.height = (int) (p.this.joe + (PullRefreshFrameLayout.joI * d));
                p.this.joh.setLayoutParams(p.this.joi);
                if (p.this.jnU != null) {
                    p.this.jnU.k(d);
                }
            }

            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.b
            public void c(final int i, double d) {
                p.this.jon = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.jon.setDuration(150L);
                final int i2 = p.this.joi.height;
                final int cuC = p.this.jnU.cuC();
                p.this.jon.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.joi.height = (int) (i2 - (i * animatedFraction));
                        p.this.joh.setLayoutParams(p.this.joi);
                        if (p.this.jnU != null) {
                            p.this.jnU.zP((int) (cuC - (animatedFraction * i)));
                        }
                    }
                });
                p.this.jon.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.jof = p.this.joi.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.jon.start();
            }

            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.b
            public void cvo() {
                final int i = p.this.joi.height;
                final int i2 = p.this.joi.height - p.this.joe;
                final int i3 = 0;
                if (p.this.jnU != null) {
                    i3 = p.this.jnU.cuC();
                }
                if (i2 > 0) {
                    p.this.jon = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.jon.setDuration(300L);
                    p.this.jon.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.joi.height = (int) (i - (i2 * floatValue));
                            p.this.joh.setLayoutParams(p.this.joi);
                            if (p.this.jnU != null && i3 > 0) {
                                p.this.jnU.zP((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    p.this.jon.start();
                    p.this.jon.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            p.this.jof = 0;
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
        this.jnS.setOnPullRefreshListener(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.a
            public void cvp() {
                com.baidu.adp.lib.f.e.gy().postDelayed(p.this.jor, p.jnK);
                p.this.jop = true;
                p.this.joq = p.this.jod.getCurrentTabType();
                p.this.cud();
                p.this.jod.baE();
            }
        });
        this.Cf = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.Cf.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.9
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.cQU.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.cQU.getPageActivity());
                }
                p.this.jnS.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.jom.rl(abs == 0);
                p.this.jom.rm(((float) abs) > p.this.jnR / 2.0f);
                float abs2 = ((double) p.this.jnR) == 0.0d ? 0.0f : Math.abs(abs / p.this.jnR);
                p.this.jom.aJ(abs2);
                if (abs2 >= 1.0f) {
                    p.this.jnQ = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.jog.setCornerRadii(p.this.jnQ);
                    p.this.jnV.setBackgroundDrawable(p.this.jog);
                    p.this.aZW();
                    p.this.jnX.setVisibility(8);
                } else {
                    p.this.jnQ = new float[]{p.jnP, p.jnP, p.jnP, p.jnP, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.jog.setCornerRadii(p.this.jnQ);
                    p.this.jnV.setBackgroundDrawable(p.this.jog);
                    p.this.jnX.setVisibility(0);
                    p.this.cvl();
                }
                int i2 = p.this.jof - p.this.joe;
                if (p.this.jof > 0 && Math.abs(i) >= i2) {
                    p.this.jnS.afn();
                }
            }
        });
        this.jnV = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.fQd = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.fQd.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.fQd.setRectPaintColor(R.color.cp_link_tip_a);
        this.fQd.a(com.baidu.adp.lib.util.l.getDimens(this.cQU.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.cQU.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.cQU.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.cQU.getPageActivity(), R.dimen.tbds46), true);
        this.fQd.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.cQU.getPageActivity(), R.dimen.tbds64));
        this.fQd.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.cQU.getPageActivity(), R.dimen.tbds8));
        this.fQd.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.cQU.getPageActivity(), R.dimen.tbds8));
        this.fQd.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.cQU.getPageActivity(), R.dimen.tbds0));
        this.fQd.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.cQU.getPageActivity(), R.dimen.tbds170), -1));
        this.fQd.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.10
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.jod.zS(i);
                if (!p.this.mIsHost || i != 1) {
                    p.this.jnT.setVisibility(8);
                    p.this.jnZ.setVisibility(8);
                    return;
                }
                p.this.jnT.setVisibility(0);
                if (p.this.joo) {
                    p.this.jnZ.setVisibility(0);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.jnW = this.mRootView.findViewById(R.id.person_center_tab_divider_container);
        this.jnX = this.mRootView.findViewById(R.id.person_center_tab_divider);
        this.jog = new GradientDrawable();
        this.jog.setColor(am.getColor(R.color.cp_bg_line_d));
        this.jog.setCornerRadii(this.jnQ);
        this.jnV.setBackgroundDrawable(this.jog);
        this.jnZ = this.mRootView.findViewById(R.id.person_center_pop_layout);
        this.joo = com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean("key_shown_post_forum_tip_pop", true);
        if (this.mIsHost && this.joo) {
            this.joa = (ImageView) this.mRootView.findViewById(R.id.person_center_pop_img);
            this.joa.setImageDrawable(am.getDrawable(R.drawable.ic_pic_mask_mine_dong_toast));
            this.joc = (ImageView) this.mRootView.findViewById(R.id.person_center_pop_close_btn);
            SvgManager.aDW().a(this.joc, R.drawable.ic_icon_pure_me_delete_white_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.job = (FrameLayout) this.mRootView.findViewById(R.id.person_center_pop_close_layout);
            this.job.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    p.this.cvj();
                }
            });
        } else {
            this.jnZ.setVisibility(8);
        }
        this.jnY = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        am.setBackgroundResource(this.jnY, R.drawable.personalize_tab_shadow);
        this.cTN = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.jod = new a(this.dyF.getActivity().getSupportFragmentManager());
        this.cTN.setAdapter(this.jod);
        this.cTN.setOffscreenPageLimit(this.jod.mFragments.size());
        this.jod.notifyDataSetChanged();
        this.fQd.setViewPager(this.cTN);
        if (this.mIsHost) {
            this.cTN.setCurrentItem(1);
        } else {
            this.cTN.setCurrentItem(0);
            this.jnT.setVisibility(8);
            this.jnZ.setVisibility(8);
        }
        this.jol = new com.baidu.tieba.personPolymeric.header.c(this.cQU, this.mIsHost);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.joh.addView(this.jol.getView(), layoutParams);
        if (this.jom.cvh()) {
            z(this.cQU);
        }
        y(this.cQU);
        this.egT = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.fPm = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.jiI = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.jiJ = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.jiL = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void y(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.jom != null) {
                    p.this.jom.cvf();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.Mh);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c cvi() {
        return this.jol;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvj() {
        if (this.joo) {
            this.joo = false;
            com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean("key_shown_post_forum_tip_pop", false);
            this.jnZ.setVisibility(8);
        }
    }

    private String[] cvk() {
        String[] strArr = new String[2];
        if (1 == TbadkCoreApplication.getInst().getSkinType()) {
            strArr[0] = "#218DBF";
            strArr[1] = "#2165BF";
        } else {
            strArr[0] = "#2BBCFF";
            strArr[1] = "#2B87ff";
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends FragmentPagerAdapter {
        private List<String> iTR;
        private List<PersonCenterTabBaseFragment> mFragments;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.iTR = new ArrayList();
            this.iTR.add(p.this.cQU.getResources().getString(R.string.person_center_tab_main));
            this.iTR.add(p.this.cQU.getResources().getString(R.string.person_center_tab_dynamic));
            this.iTR.add(p.this.cQU.getResources().getString(R.string.person_center_tab_thread));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.h(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.g(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.i(p.this.mUserId, p.this.mIsHost));
        }

        public void zS(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.iTR.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
                if (i2 == i) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return zU(i);
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
            return zT(i);
        }

        private String zT(int i) {
            return this.iTR.get(i);
        }

        public PersonCenterTabBaseFragment zU(int i) {
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

        public void baE() {
            if (!v.isEmpty(this.mFragments)) {
                for (int i = 0; i < this.mFragments.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.rh(false);
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

    private boolean aZV() {
        return this.jnY.getVisibility() == 0;
    }

    public void aZW() {
        if (!aZV() && this.joj == null) {
            this.jnY.setVisibility(0);
            if (this.joj == null) {
                this.joj = new AlphaAnimation(0.0f, 1.0f);
                this.joj.setFillAfter(true);
                this.joj.setDuration(300L);
                this.joj.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.13
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.joj.reset();
                        p.this.joj = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.jnY.startAnimation(this.joj);
            }
        }
    }

    public void cvl() {
        if (aZV() && this.jok == null && this.jok == null) {
            this.jok = new AlphaAnimation(1.0f, 0.0f);
            this.jok.setFillAfter(true);
            this.jok.setDuration(300L);
            this.jok.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.14
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.jnY.setVisibility(8);
                    p.this.jok.reset();
                    p.this.jok = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.jnY.startAnimation(this.jok);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jom != null) {
            this.jom.onChangeSkinType(i);
        }
        if (this.fQd != null) {
            this.fQd.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
            this.fQd.setRectPaintColor(R.color.cp_link_tip_a);
            this.fQd.onChangeSkinType();
        }
        if (this.jog != null) {
            this.jog.setColor(am.getColor(R.color.cp_bg_line_d));
        }
        if (this.jol != null) {
            this.jol.onChangeSkinType(i);
        }
        if (this.jod != null) {
            this.jod.onChangeSkinType(i);
        }
        if (this.egT != null) {
            this.egT.onChangeSkinType(this.cQU, i);
        }
        if (this.fPm != null) {
            this.fPm.onChangeSkinType(this.cQU, i);
        }
        if (this.joa != null && this.joa.getVisibility() == 0) {
            am.setImageResource(this.joa, R.drawable.ic_pic_mask_mine_dong_toast);
        }
        am.setBackgroundResource(this.jnW, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.jiI, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.jnX, R.color.cp_bg_line_b);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.jnY, R.drawable.personalize_tab_shadow);
    }

    public void cud() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.jnL.resetData();
            this.jnL.refreshData();
            this.jiR.doRefresh();
            return;
        }
        this.jiR.bHh();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.e eVar) {
        if (this.jom != null) {
            this.jom.setOnViewResponseListener(eVar);
        }
    }

    public void rc(boolean z) {
        this.jnO = z;
    }

    public void aO(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        dU(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.jjg = aVar;
            this.jiI.setVisibility(8);
            this.jiL.setVisibility(0);
            if (this.jom != null) {
                this.jom.a(aVar, personStatus);
            }
            if (this.jol != null) {
                this.jol.b(aVar);
            }
            if (this.jnU != null) {
                this.jnU.e(this.jjg.getUserData());
            }
            this.joh.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.2
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.joe == 0) {
                        p.this.joe = p.this.joh.getMeasuredHeight();
                        p.this.jnR = p.this.joh.getMeasuredHeight() - p.this.jom.cvg().getMeasuredHeight();
                        if (p.this.jnU != null) {
                            p.this.jnU.zO(p.this.mStatusBarHeight + p.this.jom.cvg().getMeasuredHeight() + p.this.joh.getMeasuredHeight() + p.this.fQd.getMeasuredHeight());
                        }
                    }
                }
            });
            this.jod.h(aVar);
            this.jod.g(aVar);
            if (v.isEmpty(aVar.bNL())) {
                dU(null);
                this.jiR.baH();
                com.baidu.adp.lib.util.l.showToast(this.cQU.getContext(), this.cQU.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.cBe().rU(this.mIsHost);
            dU(aVar.bNL());
            int size = aVar.bNL().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.m mVar = aVar.bNL().get(i);
                if (mVar != null && (mVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.jiR.baH();
                    return;
                }
            }
            if (!z) {
                this.jiR.e(true, aVar.bNL());
            }
        }
    }

    public void bHh() {
        this.jiR.bHh();
    }

    private void z(TbPageContext tbPageContext) {
        this.jnM = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).jKk;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.jol != null && aVar != null) {
                            p.this.jol.rf(aVar.dBS);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.jjg != null) {
                            if (p.this.jjg.jjW != null && p.this.jjg.jjW.fVh != null && aVar2 != null) {
                                p.this.jjg.jjW.fVh.putBoolean("person_center_item_red_tip_show", aVar2.dBS);
                            }
                            if (aVar3 != null && p.this.jjg.jjV != null && p.this.jjg.jjV.fVh != null) {
                                p.this.jjg.jjV.fVh.putBoolean("person_center_item_red_tip_show", aVar3.dBS);
                            }
                            if (aVar4 != null && p.this.jjg.jjU != null && p.this.jjg.jjU.fVh != null) {
                                p.this.jjg.jjU.fVh.putBoolean("person_center_item_red_tip_show", aVar4.dBS);
                            }
                            if (aVar5 != null && p.this.jjg.jjX != null && p.this.jjg.jjX.fVh != null) {
                                p.this.jjg.jjX.fVh.putBoolean("person_center_item_red_tip_show", aVar5.dBS);
                            }
                            if (aVar6 != null && p.this.jjg.jjY != null && p.this.jjg.jjY.fVh != null) {
                                p.this.jjg.jjY.fVh.putBoolean("person_center_item_red_tip_show", aVar6.dBS);
                                p.this.jjg.jjY.fVh.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.jnM.setTag(this.Mh);
        tbPageContext.registerListener(this.jnM);
        this.jcA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.m mVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && (mVar = (com.baidu.tbadk.data.m) customResponsedMessage.getData()) != null) {
                    p.this.jol.Gw(mVar.axX());
                }
            }
        };
        this.jcA.setTag(this.Mh);
        tbPageContext.registerListener(this.jcA);
        this.jnN = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.joq == ((Integer) customResponsedMessage.getData()).intValue() && p.this.jop) {
                    com.baidu.adp.lib.f.e.gy().removeCallbacks(p.this.jor);
                    p.this.cvm();
                }
            }
        };
        this.jnN.setTag(this.Mh);
        tbPageContext.registerListener(this.jnN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvm() {
        this.joq = -1;
        this.jop = false;
        if (this.jnS != null) {
            this.jnS.cvr();
        }
    }

    public boolean onBackPressed() {
        if (this.gmy.isShowing()) {
            this.gmy.ts(true);
            return true;
        }
        return false;
    }

    public void onDestory() {
        if (this.gmy != null) {
            this.gmy.onDestroy();
        }
        if (this.jol != null) {
            this.jol.onDestroy();
        }
        if (this.jnS != null) {
            this.jnS.onDestroy();
        }
        if (this.jon != null) {
            this.jon.cancel();
            this.jon.removeAllListeners();
            this.jon.removeAllUpdateListeners();
            this.jon = null;
        }
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jor);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.jnL = aVar;
    }

    public void dU(List<com.baidu.adp.widget.ListView.m> list) {
    }
}
