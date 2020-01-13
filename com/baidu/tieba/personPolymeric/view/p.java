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
/* loaded from: classes9.dex */
public class p {
    public static int jrm = 5000;
    private static final float jrr = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout Ck;
    private BdUniqueId Mm;
    private TbPageContext cRe;
    private CustomViewPager cTX;
    private BaseFragment dyN;
    private NoNetworkView ehd;
    private PluginErrorTipView fSv;
    private NewPagerSlidingTabBaseStrip fTm;
    private com.baidu.tieba.write.f gpH;
    private CustomMessageListener jgd;
    private com.baidu.tieba.personPolymeric.c.a jmI;
    private LinearLayout jmj;
    protected FrameLayout jmk;
    protected RelativeLayout jmm;
    private com.baidu.tieba.personPolymeric.b.e jmt;
    private View jrA;
    private View jrB;
    private ImageView jrC;
    private FrameLayout jrD;
    private ImageView jrE;
    private a jrF;
    private int jrG;
    private int jrH;
    private GradientDrawable jrI;
    private FrameLayout jrJ;
    private FrameLayout.LayoutParams jrK;
    private AlphaAnimation jrL;
    private AlphaAnimation jrM;
    private com.baidu.tieba.personPolymeric.header.c jrN;
    private k jrO;
    private ValueAnimator jrP;
    private boolean jrQ;
    private com.baidu.tieba.model.a jrn;
    private CustomMessageListener jro;
    private CustomMessageListener jrp;
    private boolean jrq;
    private PullRefreshFrameLayout jru;
    private OvalActionButton jrv;
    private com.baidu.tieba.personPolymeric.header.a jrw;
    private FrameLayout jrx;
    private View jry;
    private View jrz;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private long mUserId;
    private float[] jrs = {jrr, jrr, jrr, jrr, 0.0f, 0.0f, 0.0f, 0.0f};
    private float jrt = 674.0f;
    private boolean jrR = false;
    private int jrS = -1;
    private Runnable jrT = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.6
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.jrR) {
                p.this.cwt();
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.f fVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.dyN = baseFragment;
        this.cRe = baseFragment.getPageContext();
        this.Mm = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.jmt = fVar.cvt();
        initView(fVar.mRootView);
    }

    private void initView(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.jru = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        this.jrv = (OvalActionButton) this.mRootView.findViewById(R.id.person_center_post_forum_btn);
        this.gpH = new com.baidu.tieba.write.f(this.cRe, (ViewGroup) view, AlbumActivityConfig.FROM_PERSON, 1);
        this.gpH.Kz("3");
        this.jrv.setVisibility(this.mIsHost ? 0 : 8);
        String[] cwr = cwr();
        this.jrv.setStartAndEndColor(cwr[0], cwr[1]);
        this.jrv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                p.this.cwq();
                p.this.gpH.a(false, (View) null, (View) p.this.jrv);
            }
        });
        this.jrw = new com.baidu.tieba.personPolymeric.header.a(this.cRe, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), this.mRootView.findViewById(R.id.person_center_background_cover), this.mIsHost);
        this.jrO = new k(this.cRe, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.jrJ = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.jrK = (FrameLayout.LayoutParams) this.jrJ.getLayoutParams();
        this.jru.setOnTouchCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.7
            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.b
            public void l(double d) {
                p.this.jrK.height = (int) (p.this.jrG + (PullRefreshFrameLayout.jsk * d));
                p.this.jrJ.setLayoutParams(p.this.jrK);
                if (p.this.jrw != null) {
                    p.this.jrw.k(d);
                }
            }

            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.b
            public void c(final int i, double d) {
                p.this.jrP = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.jrP.setDuration(150L);
                final int i2 = p.this.jrK.height;
                final int cvJ = p.this.jrw.cvJ();
                p.this.jrP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.jrK.height = (int) (i2 - (i * animatedFraction));
                        p.this.jrJ.setLayoutParams(p.this.jrK);
                        if (p.this.jrw != null) {
                            p.this.jrw.zU((int) (cvJ - (animatedFraction * i)));
                        }
                    }
                });
                p.this.jrP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.jrH = p.this.jrK.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.jrP.start();
            }

            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.b
            public void cwv() {
                final int i = p.this.jrK.height;
                final int i2 = p.this.jrK.height - p.this.jrG;
                final int i3 = 0;
                if (p.this.jrw != null) {
                    i3 = p.this.jrw.cvJ();
                }
                if (i2 > 0) {
                    p.this.jrP = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.jrP.setDuration(300L);
                    p.this.jrP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.jrK.height = (int) (i - (i2 * floatValue));
                            p.this.jrJ.setLayoutParams(p.this.jrK);
                            if (p.this.jrw != null && i3 > 0) {
                                p.this.jrw.zU((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    p.this.jrP.start();
                    p.this.jrP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            p.this.jrH = 0;
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
        this.jru.setOnPullRefreshListener(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.a
            public void cww() {
                com.baidu.adp.lib.f.e.gx().postDelayed(p.this.jrT, p.jrm);
                p.this.jrR = true;
                p.this.jrS = p.this.jrF.getCurrentTabType();
                p.this.cvk();
                p.this.jrF.baZ();
            }
        });
        this.Ck = (AppBarLayout) this.mRootView.findViewById(R.id.person_center_app_bar_layout);
        this.Ck.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.personPolymeric.view.p.9
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i == 0, p.this.cRe.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, p.this.cRe.getPageActivity());
                }
                p.this.jru.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.jrO.ry(abs == 0);
                p.this.jrO.rz(((float) abs) > p.this.jrt / 2.0f);
                float abs2 = ((double) p.this.jrt) == 0.0d ? 0.0f : Math.abs(abs / p.this.jrt);
                p.this.jrO.aI(abs2);
                if (abs2 >= 1.0f) {
                    p.this.jrs = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.jrI.setCornerRadii(p.this.jrs);
                    p.this.jrx.setBackgroundDrawable(p.this.jrI);
                    p.this.bav();
                    p.this.jrz.setVisibility(8);
                } else {
                    p.this.jrs = new float[]{p.jrr, p.jrr, p.jrr, p.jrr, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.jrI.setCornerRadii(p.this.jrs);
                    p.this.jrx.setBackgroundDrawable(p.this.jrI);
                    p.this.jrz.setVisibility(0);
                    p.this.cws();
                }
                int i2 = p.this.jrH - p.this.jrG;
                if (p.this.jrH > 0 && Math.abs(i) >= i2) {
                    p.this.jru.afG();
                }
            }
        });
        this.jrx = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
        this.fTm = (NewPagerSlidingTabBaseStrip) this.mRootView.findViewById(R.id.person_center_tab_layout);
        this.fTm.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.fTm.setRectPaintColor(R.color.cp_link_tip_a);
        this.fTm.a(com.baidu.adp.lib.util.l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds46), com.baidu.adp.lib.util.l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds10), com.baidu.adp.lib.util.l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds46), true);
        this.fTm.setIndicatorOffset(com.baidu.adp.lib.util.l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds64));
        this.fTm.setIndicatorOvershot(com.baidu.adp.lib.util.l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds8));
        this.fTm.setIndicatorRadius(com.baidu.adp.lib.util.l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds8));
        this.fTm.setIndicatorMarginBottom(com.baidu.adp.lib.util.l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds0));
        this.fTm.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds170), -1));
        this.fTm.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.personPolymeric.view.p.10
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                p.this.jrF.zX(i);
                if (!p.this.mIsHost || i != 1) {
                    p.this.jrv.setVisibility(8);
                    p.this.jrB.setVisibility(8);
                    return;
                }
                p.this.jrv.setVisibility(0);
                if (p.this.jrQ) {
                    p.this.jrB.setVisibility(0);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.jry = this.mRootView.findViewById(R.id.person_center_tab_divider_container);
        this.jrz = this.mRootView.findViewById(R.id.person_center_tab_divider);
        this.jrI = new GradientDrawable();
        this.jrI.setColor(am.getColor(R.color.cp_bg_line_d));
        this.jrI.setCornerRadii(this.jrs);
        this.jrx.setBackgroundDrawable(this.jrI);
        this.jrB = this.mRootView.findViewById(R.id.person_center_pop_layout);
        this.jrQ = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("key_shown_post_forum_tip_pop", true);
        if (this.mIsHost && this.jrQ) {
            this.jrC = (ImageView) this.mRootView.findViewById(R.id.person_center_pop_img);
            this.jrC.setImageDrawable(am.getDrawable(R.drawable.ic_pic_mask_mine_dong_toast));
            this.jrE = (ImageView) this.mRootView.findViewById(R.id.person_center_pop_close_btn);
            SvgManager.aEp().a(this.jrE, R.drawable.ic_icon_pure_me_delete_white_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jrD = (FrameLayout) this.mRootView.findViewById(R.id.person_center_pop_close_layout);
            this.jrD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    p.this.cwq();
                }
            });
        } else {
            this.jrB.setVisibility(8);
        }
        this.jrA = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        am.setBackgroundResource(this.jrA, R.drawable.personalize_tab_shadow);
        this.cTX = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.jrF = new a(this.dyN.getActivity().getSupportFragmentManager());
        this.cTX.setAdapter(this.jrF);
        this.cTX.setOffscreenPageLimit(this.jrF.mFragments.size());
        this.jrF.notifyDataSetChanged();
        this.fTm.setViewPager(this.cTX);
        if (this.mIsHost) {
            this.cTX.setCurrentItem(1);
        } else {
            this.cTX.setCurrentItem(0);
            this.jrv.setVisibility(8);
            this.jrB.setVisibility(8);
        }
        this.jrN = new com.baidu.tieba.personPolymeric.header.c(this.cRe, this.mIsHost);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.jrJ.addView(this.jrN.getView(), layoutParams);
        if (this.jrO.cwo()) {
            z(this.cRe);
        }
        y(this.cRe);
        this.ehd = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.fSv = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.jmj = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.jmk = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.jmm = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void y(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.jrO != null) {
                    p.this.jrO.cwm();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.Mm);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c cwp() {
        return this.jrN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwq() {
        if (this.jrQ) {
            this.jrQ = false;
            com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("key_shown_post_forum_tip_pop", false);
            this.jrB.setVisibility(8);
        }
    }

    private String[] cwr() {
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
    /* loaded from: classes9.dex */
    public class a extends FragmentPagerAdapter {
        private List<String> iXu;
        private List<PersonCenterTabBaseFragment> mFragments;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.iXu = new ArrayList();
            this.iXu.add(p.this.cRe.getResources().getString(R.string.person_center_tab_main));
            this.iXu.add(p.this.cRe.getResources().getString(R.string.person_center_tab_dynamic));
            this.iXu.add(p.this.cRe.getResources().getString(R.string.person_center_tab_thread));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.h(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.g(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.i(p.this.mUserId, p.this.mIsHost));
        }

        public void zX(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.iXu.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
                if (i2 == i) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return zZ(i);
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
            return zY(i);
        }

        private String zY(int i) {
            return this.iXu.get(i);
        }

        public PersonCenterTabBaseFragment zZ(int i) {
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

        public void baZ() {
            if (!v.isEmpty(this.mFragments)) {
                for (int i = 0; i < this.mFragments.size(); i++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.mFragments.get(i);
                    if (personCenterTabBaseFragment != null) {
                        personCenterTabBaseFragment.ru(false);
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

    private boolean bau() {
        return this.jrA.getVisibility() == 0;
    }

    public void bav() {
        if (!bau() && this.jrL == null) {
            this.jrA.setVisibility(0);
            if (this.jrL == null) {
                this.jrL = new AlphaAnimation(0.0f, 1.0f);
                this.jrL.setFillAfter(true);
                this.jrL.setDuration(300L);
                this.jrL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.13
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.jrL.reset();
                        p.this.jrL = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.jrA.startAnimation(this.jrL);
            }
        }
    }

    public void cws() {
        if (bau() && this.jrM == null && this.jrM == null) {
            this.jrM = new AlphaAnimation(1.0f, 0.0f);
            this.jrM.setFillAfter(true);
            this.jrM.setDuration(300L);
            this.jrM.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.14
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.jrA.setVisibility(8);
                    p.this.jrM.reset();
                    p.this.jrM = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.jrA.startAnimation(this.jrM);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jrO != null) {
            this.jrO.onChangeSkinType(i);
        }
        if (this.fTm != null) {
            this.fTm.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
            this.fTm.setRectPaintColor(R.color.cp_link_tip_a);
            this.fTm.onChangeSkinType();
        }
        if (this.jrI != null) {
            this.jrI.setColor(am.getColor(R.color.cp_bg_line_d));
        }
        if (this.jrN != null) {
            this.jrN.onChangeSkinType(i);
        }
        if (this.jrF != null) {
            this.jrF.onChangeSkinType(i);
        }
        if (this.ehd != null) {
            this.ehd.onChangeSkinType(this.cRe, i);
        }
        if (this.fSv != null) {
            this.fSv.onChangeSkinType(this.cRe, i);
        }
        if (this.jrC != null && this.jrC.getVisibility() == 0) {
            am.setImageResource(this.jrC, R.drawable.ic_pic_mask_mine_dong_toast);
        }
        am.setBackgroundResource(this.jry, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.jmj, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.jrz, R.color.cp_bg_line_b);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.jrA, R.drawable.personalize_tab_shadow);
    }

    public void cvk() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.jrn.resetData();
            this.jrn.refreshData();
            this.jmt.doRefresh();
            return;
        }
        this.jmt.bIj();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.e eVar) {
        if (this.jrO != null) {
            this.jrO.setOnViewResponseListener(eVar);
        }
    }

    public void rp(boolean z) {
        this.jrq = z;
    }

    public void aO(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        dU(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.jmI = aVar;
            this.jmj.setVisibility(8);
            this.jmm.setVisibility(0);
            if (this.jrO != null) {
                this.jrO.a(aVar, personStatus);
            }
            if (this.jrN != null) {
                this.jrN.b(aVar);
            }
            if (this.jrw != null) {
                this.jrw.e(this.jmI.getUserData());
            }
            this.jrJ.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.2
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.jrG == 0) {
                        p.this.jrG = p.this.jrJ.getMeasuredHeight();
                        p.this.jrt = p.this.jrJ.getMeasuredHeight() - p.this.jrO.cwn().getMeasuredHeight();
                        if (p.this.jrw != null) {
                            p.this.jrw.zT(p.this.mStatusBarHeight + p.this.jrO.cwn().getMeasuredHeight() + p.this.jrJ.getMeasuredHeight() + p.this.fTm.getMeasuredHeight());
                        }
                    }
                }
            });
            this.jrF.h(aVar);
            this.jrF.g(aVar);
            if (v.isEmpty(aVar.bOU())) {
                dU(null);
                this.jmt.bbc();
                com.baidu.adp.lib.util.l.showToast(this.cRe.getContext(), this.cRe.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.cCk().sg(this.mIsHost);
            dU(aVar.bOU());
            int size = aVar.bOU().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.m mVar = aVar.bOU().get(i);
                if (mVar != null && (mVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.jmt.bbc();
                    return;
                }
            }
            if (!z) {
                this.jmt.e(true, aVar.bOU());
            }
        }
    }

    public void bIj() {
        this.jmt.bIj();
    }

    private void z(TbPageContext tbPageContext) {
        this.jro = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).jNM;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.jrN != null && aVar != null) {
                            p.this.jrN.rs(aVar.dCc);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.jmI != null) {
                            if (p.this.jmI.jny != null && p.this.jmI.jny.fYq != null && aVar2 != null) {
                                p.this.jmI.jny.fYq.putBoolean("person_center_item_red_tip_show", aVar2.dCc);
                            }
                            if (aVar3 != null && p.this.jmI.jnx != null && p.this.jmI.jnx.fYq != null) {
                                p.this.jmI.jnx.fYq.putBoolean("person_center_item_red_tip_show", aVar3.dCc);
                            }
                            if (aVar4 != null && p.this.jmI.jnw != null && p.this.jmI.jnw.fYq != null) {
                                p.this.jmI.jnw.fYq.putBoolean("person_center_item_red_tip_show", aVar4.dCc);
                            }
                            if (aVar5 != null && p.this.jmI.jnz != null && p.this.jmI.jnz.fYq != null) {
                                p.this.jmI.jnz.fYq.putBoolean("person_center_item_red_tip_show", aVar5.dCc);
                            }
                            if (aVar6 != null && p.this.jmI.jnA != null && p.this.jmI.jnA.fYq != null) {
                                p.this.jmI.jnA.fYq.putBoolean("person_center_item_red_tip_show", aVar6.dCc);
                                p.this.jmI.jnA.fYq.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.jro.setTag(this.Mm);
        tbPageContext.registerListener(this.jro);
        this.jgd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.m mVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && (mVar = (com.baidu.tbadk.data.m) customResponsedMessage.getData()) != null) {
                    p.this.jrN.GG(mVar.ayq());
                }
            }
        };
        this.jgd.setTag(this.Mm);
        tbPageContext.registerListener(this.jgd);
        this.jrp = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.jrS == ((Integer) customResponsedMessage.getData()).intValue() && p.this.jrR) {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(p.this.jrT);
                    p.this.cwt();
                }
            }
        };
        this.jrp.setTag(this.Mm);
        tbPageContext.registerListener(this.jrp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwt() {
        this.jrS = -1;
        this.jrR = false;
        if (this.jru != null) {
            this.jru.cwy();
        }
    }

    public boolean onBackPressed() {
        if (this.gpH.isShowing()) {
            this.gpH.tE(true);
            return true;
        }
        return false;
    }

    public void onDestory() {
        if (this.gpH != null) {
            this.gpH.onDestroy();
        }
        if (this.jrN != null) {
            this.jrN.onDestroy();
        }
        if (this.jru != null) {
            this.jru.onDestroy();
        }
        if (this.jrP != null) {
            this.jrP.cancel();
            this.jrP.removeAllListeners();
            this.jrP.removeAllUpdateListeners();
            this.jrP = null;
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jrT);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.jrn = aVar;
    }

    public void dU(List<com.baidu.adp.widget.ListView.m> list) {
    }
}
