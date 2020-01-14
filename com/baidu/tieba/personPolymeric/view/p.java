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
    public static int jrr = 5000;
    private static final float jrw = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    private AppBarLayout Ck;
    private BdUniqueId Mm;
    private TbPageContext cRe;
    private CustomViewPager cTX;
    private BaseFragment dyN;
    private NoNetworkView ehd;
    private PluginErrorTipView fSv;
    private NewPagerSlidingTabBaseStrip fTm;
    private com.baidu.tieba.write.f gpH;
    private CustomMessageListener jgi;
    private com.baidu.tieba.personPolymeric.c.a jmN;
    private LinearLayout jmo;
    protected FrameLayout jmq;
    protected RelativeLayout jms;
    private com.baidu.tieba.personPolymeric.b.e jmy;
    private OvalActionButton jrA;
    private com.baidu.tieba.personPolymeric.header.a jrB;
    private FrameLayout jrC;
    private View jrD;
    private View jrE;
    private View jrF;
    private View jrG;
    private ImageView jrH;
    private FrameLayout jrI;
    private ImageView jrJ;
    private a jrK;
    private int jrL;
    private int jrM;
    private GradientDrawable jrN;
    private FrameLayout jrO;
    private FrameLayout.LayoutParams jrP;
    private AlphaAnimation jrQ;
    private AlphaAnimation jrR;
    private com.baidu.tieba.personPolymeric.header.c jrS;
    private k jrT;
    private ValueAnimator jrU;
    private boolean jrV;
    private com.baidu.tieba.model.a jrs;
    private CustomMessageListener jrt;
    private CustomMessageListener jru;
    private boolean jrv;
    private PullRefreshFrameLayout jrz;
    private CustomMessageListener mAccountChangedListener;
    private boolean mIsHost;
    private View mRootView;
    private int mStatusBarHeight;
    private long mUserId;
    private float[] jrx = {jrw, jrw, jrw, jrw, 0.0f, 0.0f, 0.0f, 0.0f};
    private float jry = 674.0f;
    private boolean jrW = false;
    private int jrX = -1;
    private Runnable jrY = new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.6
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.jrW) {
                p.this.cwv();
            }
        }
    };

    public p(BaseFragment baseFragment, com.baidu.tieba.personPolymeric.b.f fVar, BdUniqueId bdUniqueId, boolean z, long j) {
        this.dyN = baseFragment;
        this.cRe = baseFragment.getPageContext();
        this.Mm = bdUniqueId;
        this.mIsHost = z;
        this.mUserId = j;
        this.jmy = fVar.cvv();
        initView(fVar.mRootView);
    }

    private void initView(View view) {
        this.mRootView = view;
        this.mStatusBarHeight = UtilHelper.getStatusBarHeight();
        this.jrz = (PullRefreshFrameLayout) this.mRootView.findViewById(R.id.person_center_content_view);
        this.jrA = (OvalActionButton) this.mRootView.findViewById(R.id.person_center_post_forum_btn);
        this.gpH = new com.baidu.tieba.write.f(this.cRe, (ViewGroup) view, AlbumActivityConfig.FROM_PERSON, 1);
        this.gpH.Kz("3");
        this.jrA.setVisibility(this.mIsHost ? 0 : 8);
        String[] cwt = cwt();
        this.jrA.setStartAndEndColor(cwt[0], cwt[1]);
        this.jrA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                p.this.cws();
                p.this.gpH.a(false, (View) null, (View) p.this.jrA);
            }
        });
        this.jrB = new com.baidu.tieba.personPolymeric.header.a(this.cRe, (TbImageView) this.mRootView.findViewById(R.id.person_center_header_bg), this.mRootView.findViewById(R.id.person_center_background_cover), this.mIsHost);
        this.jrT = new k(this.cRe, this.mRootView, this.mRootView.findViewById(R.id.person_center_status_bar_space), this.mIsHost);
        this.jrO = (FrameLayout) this.mRootView.findViewById(R.id.person_center_header_container);
        this.jrP = (FrameLayout.LayoutParams) this.jrO.getLayoutParams();
        this.jrz.setOnTouchCallback(new PullRefreshFrameLayout.b() { // from class: com.baidu.tieba.personPolymeric.view.p.7
            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.b
            public void l(double d) {
                p.this.jrP.height = (int) (p.this.jrL + (PullRefreshFrameLayout.jsp * d));
                p.this.jrO.setLayoutParams(p.this.jrP);
                if (p.this.jrB != null) {
                    p.this.jrB.k(d);
                }
            }

            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.b
            public void c(final int i, double d) {
                p.this.jrU = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.jrU.setDuration(150L);
                final int i2 = p.this.jrP.height;
                final int cvL = p.this.jrB.cvL();
                p.this.jrU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        p.this.jrP.height = (int) (i2 - (i * animatedFraction));
                        p.this.jrO.setLayoutParams(p.this.jrP);
                        if (p.this.jrB != null) {
                            p.this.jrB.zU((int) (cvL - (animatedFraction * i)));
                        }
                    }
                });
                p.this.jrU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        p.this.jrM = p.this.jrP.height;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                p.this.jrU.start();
            }

            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.b
            public void cwx() {
                final int i = p.this.jrP.height;
                final int i2 = p.this.jrP.height - p.this.jrL;
                final int i3 = 0;
                if (p.this.jrB != null) {
                    i3 = p.this.jrB.cvL();
                }
                if (i2 > 0) {
                    p.this.jrU = ValueAnimator.ofFloat(0.0f, 1.0f);
                    p.this.jrU.setDuration(300L);
                    p.this.jrU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            p.this.jrP.height = (int) (i - (i2 * floatValue));
                            p.this.jrO.setLayoutParams(p.this.jrP);
                            if (p.this.jrB != null && i3 > 0) {
                                p.this.jrB.zU((int) (i3 - (floatValue * i2)));
                            }
                        }
                    });
                    p.this.jrU.start();
                    p.this.jrU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.p.7.4
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            p.this.jrM = 0;
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
        this.jrz.setOnPullRefreshListener(new PullRefreshFrameLayout.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
            @Override // com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.a
            public void cwy() {
                com.baidu.adp.lib.f.e.gx().postDelayed(p.this.jrY, p.jrr);
                p.this.jrW = true;
                p.this.jrX = p.this.jrK.getCurrentTabType();
                p.this.cvm();
                p.this.jrK.baZ();
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
                p.this.jrz.setInterceptScrollDown(i == 0);
                int abs = Math.abs(i);
                p.this.jrT.ry(abs == 0);
                p.this.jrT.rz(((float) abs) > p.this.jry / 2.0f);
                float abs2 = ((double) p.this.jry) == 0.0d ? 0.0f : Math.abs(abs / p.this.jry);
                p.this.jrT.aI(abs2);
                if (abs2 >= 1.0f) {
                    p.this.jrx = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.jrN.setCornerRadii(p.this.jrx);
                    p.this.jrC.setBackgroundDrawable(p.this.jrN);
                    p.this.bav();
                    p.this.jrE.setVisibility(8);
                } else {
                    p.this.jrx = new float[]{p.jrw, p.jrw, p.jrw, p.jrw, 0.0f, 0.0f, 0.0f, 0.0f};
                    p.this.jrN.setCornerRadii(p.this.jrx);
                    p.this.jrC.setBackgroundDrawable(p.this.jrN);
                    p.this.jrE.setVisibility(0);
                    p.this.cwu();
                }
                int i2 = p.this.jrM - p.this.jrL;
                if (p.this.jrM > 0 && Math.abs(i) >= i2) {
                    p.this.jrz.afG();
                }
            }
        });
        this.jrC = (FrameLayout) this.mRootView.findViewById(R.id.person_center_tab_layout_container);
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
                p.this.jrK.zX(i);
                if (!p.this.mIsHost || i != 1) {
                    p.this.jrA.setVisibility(8);
                    p.this.jrG.setVisibility(8);
                    return;
                }
                p.this.jrA.setVisibility(0);
                if (p.this.jrV) {
                    p.this.jrG.setVisibility(0);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.jrD = this.mRootView.findViewById(R.id.person_center_tab_divider_container);
        this.jrE = this.mRootView.findViewById(R.id.person_center_tab_divider);
        this.jrN = new GradientDrawable();
        this.jrN.setColor(am.getColor(R.color.cp_bg_line_d));
        this.jrN.setCornerRadii(this.jrx);
        this.jrC.setBackgroundDrawable(this.jrN);
        this.jrG = this.mRootView.findViewById(R.id.person_center_pop_layout);
        this.jrV = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("key_shown_post_forum_tip_pop", true);
        if (this.mIsHost && this.jrV) {
            this.jrH = (ImageView) this.mRootView.findViewById(R.id.person_center_pop_img);
            this.jrH.setImageDrawable(am.getDrawable(R.drawable.ic_pic_mask_mine_dong_toast));
            this.jrJ = (ImageView) this.mRootView.findViewById(R.id.person_center_pop_close_btn);
            SvgManager.aEp().a(this.jrJ, R.drawable.ic_icon_pure_me_delete_white_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jrI = (FrameLayout) this.mRootView.findViewById(R.id.person_center_pop_close_layout);
            this.jrI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    p.this.cws();
                }
            });
        } else {
            this.jrG.setVisibility(8);
        }
        this.jrF = this.mRootView.findViewById(R.id.person_center_pager_shadow);
        am.setBackgroundResource(this.jrF, R.drawable.personalize_tab_shadow);
        this.cTX = (CustomViewPager) this.mRootView.findViewById(R.id.person_center_view_pager);
        this.jrK = new a(this.dyN.getActivity().getSupportFragmentManager());
        this.cTX.setAdapter(this.jrK);
        this.cTX.setOffscreenPageLimit(this.jrK.mFragments.size());
        this.jrK.notifyDataSetChanged();
        this.fTm.setViewPager(this.cTX);
        if (this.mIsHost) {
            this.cTX.setCurrentItem(1);
        } else {
            this.cTX.setCurrentItem(0);
            this.jrA.setVisibility(8);
            this.jrG.setVisibility(8);
        }
        this.jrS = new com.baidu.tieba.personPolymeric.header.c(this.cRe, this.mIsHost);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.jrO.addView(this.jrS.getView(), layoutParams);
        if (this.jrT.cwq()) {
            z(this.cRe);
        }
        y(this.cRe);
        this.ehd = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.fSv = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.jmo = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
        this.jmq = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
        this.jms = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
    }

    private void y(TbPageContext tbPageContext) {
        this.mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.personPolymeric.view.p.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && p.this.jrT != null) {
                    p.this.jrT.cwo();
                }
            }
        };
        this.mAccountChangedListener.setTag(this.Mm);
        tbPageContext.registerListener(this.mAccountChangedListener);
    }

    public com.baidu.tieba.personPolymeric.header.c cwr() {
        return this.jrS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cws() {
        if (this.jrV) {
            this.jrV = false;
            com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("key_shown_post_forum_tip_pop", false);
            this.jrG.setVisibility(8);
        }
    }

    private String[] cwt() {
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
        private List<String> iXz;
        private List<PersonCenterTabBaseFragment> mFragments;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.iXz = new ArrayList();
            this.iXz.add(p.this.cRe.getResources().getString(R.string.person_center_tab_main));
            this.iXz.add(p.this.cRe.getResources().getString(R.string.person_center_tab_dynamic));
            this.iXz.add(p.this.cRe.getResources().getString(R.string.person_center_tab_thread));
            this.mFragments = new ArrayList();
            this.mFragments.add(PersonCenterMainTabFragment.h(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterDynamicTabFragment.g(p.this.mUserId, p.this.mIsHost));
            this.mFragments.add(PersonCenterThreadTabFragment.i(p.this.mUserId, p.this.mIsHost));
        }

        public void zX(int i) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i2 = 0; i2 < this.iXz.size() && (personCenterTabBaseFragment = this.mFragments.get(i2)) != null; i2++) {
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
            return this.iXz.get(i);
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
        return this.jrF.getVisibility() == 0;
    }

    public void bav() {
        if (!bau() && this.jrQ == null) {
            this.jrF.setVisibility(0);
            if (this.jrQ == null) {
                this.jrQ = new AlphaAnimation(0.0f, 1.0f);
                this.jrQ.setFillAfter(true);
                this.jrQ.setDuration(300L);
                this.jrQ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.13
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        p.this.jrQ.reset();
                        p.this.jrQ = null;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.jrF.startAnimation(this.jrQ);
            }
        }
    }

    public void cwu() {
        if (bau() && this.jrR == null && this.jrR == null) {
            this.jrR = new AlphaAnimation(1.0f, 0.0f);
            this.jrR.setFillAfter(true);
            this.jrR.setDuration(300L);
            this.jrR.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.14
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    p.this.jrF.setVisibility(8);
                    p.this.jrR.reset();
                    p.this.jrR = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.jrF.startAnimation(this.jrR);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jrT != null) {
            this.jrT.onChangeSkinType(i);
        }
        if (this.fTm != null) {
            this.fTm.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
            this.fTm.setRectPaintColor(R.color.cp_link_tip_a);
            this.fTm.onChangeSkinType();
        }
        if (this.jrN != null) {
            this.jrN.setColor(am.getColor(R.color.cp_bg_line_d));
        }
        if (this.jrS != null) {
            this.jrS.onChangeSkinType(i);
        }
        if (this.jrK != null) {
            this.jrK.onChangeSkinType(i);
        }
        if (this.ehd != null) {
            this.ehd.onChangeSkinType(this.cRe, i);
        }
        if (this.fSv != null) {
            this.fSv.onChangeSkinType(this.cRe, i);
        }
        if (this.jrH != null && this.jrH.getVisibility() == 0) {
            am.setImageResource(this.jrH, R.drawable.ic_pic_mask_mine_dong_toast);
        }
        am.setBackgroundResource(this.jrD, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.jmo, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.jrE, R.color.cp_bg_line_b);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.jrF, R.drawable.personalize_tab_shadow);
    }

    public void cvm() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.jrs.resetData();
            this.jrs.refreshData();
            this.jmy.doRefresh();
            return;
        }
        this.jmy.bIj();
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.e eVar) {
        if (this.jrT != null) {
            this.jrT.setOnViewResponseListener(eVar);
        }
    }

    public void rp(boolean z) {
        this.jrv = z;
    }

    public void aO(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        dU(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar != null) {
            this.jmN = aVar;
            this.jmo.setVisibility(8);
            this.jms.setVisibility(0);
            if (this.jrT != null) {
                this.jrT.a(aVar, personStatus);
            }
            if (this.jrS != null) {
                this.jrS.b(aVar);
            }
            if (this.jrB != null) {
                this.jrB.e(this.jmN.getUserData());
            }
            this.jrO.post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.view.p.2
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.jrL == 0) {
                        p.this.jrL = p.this.jrO.getMeasuredHeight();
                        p.this.jry = p.this.jrO.getMeasuredHeight() - p.this.jrT.cwp().getMeasuredHeight();
                        if (p.this.jrB != null) {
                            p.this.jrB.zT(p.this.mStatusBarHeight + p.this.jrT.cwp().getMeasuredHeight() + p.this.jrO.getMeasuredHeight() + p.this.fTm.getMeasuredHeight());
                        }
                    }
                }
            });
            this.jrK.h(aVar);
            this.jrK.g(aVar);
            if (v.isEmpty(aVar.bOU())) {
                dU(null);
                this.jmy.bbc();
                com.baidu.adp.lib.util.l.showToast(this.cRe.getContext(), this.cRe.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.cCm().sg(this.mIsHost);
            dU(aVar.bOU());
            int size = aVar.bOU().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.m mVar = aVar.bOU().get(i);
                if (mVar != null && (mVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.jmy.bbc();
                    return;
                }
            }
            if (!z) {
                this.jmy.e(true, aVar.bOU());
            }
        }
    }

    public void bIj() {
        this.jmy.bIj();
    }

    private void z(TbPageContext tbPageContext) {
        this.jrt = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).jNR;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (p.this.jrS != null && aVar != null) {
                            p.this.jrS.rs(aVar.dCc);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.jmN != null) {
                            if (p.this.jmN.jnD != null && p.this.jmN.jnD.fYq != null && aVar2 != null) {
                                p.this.jmN.jnD.fYq.putBoolean("person_center_item_red_tip_show", aVar2.dCc);
                            }
                            if (aVar3 != null && p.this.jmN.jnC != null && p.this.jmN.jnC.fYq != null) {
                                p.this.jmN.jnC.fYq.putBoolean("person_center_item_red_tip_show", aVar3.dCc);
                            }
                            if (aVar4 != null && p.this.jmN.jnB != null && p.this.jmN.jnB.fYq != null) {
                                p.this.jmN.jnB.fYq.putBoolean("person_center_item_red_tip_show", aVar4.dCc);
                            }
                            if (aVar5 != null && p.this.jmN.jnE != null && p.this.jmN.jnE.fYq != null) {
                                p.this.jmN.jnE.fYq.putBoolean("person_center_item_red_tip_show", aVar5.dCc);
                            }
                            if (aVar6 != null && p.this.jmN.jnF != null && p.this.jmN.jnF.fYq != null) {
                                p.this.jmN.jnF.fYq.putBoolean("person_center_item_red_tip_show", aVar6.dCc);
                                p.this.jmN.jnF.fYq.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                    }
                }
            }
        };
        this.jrt.setTag(this.Mm);
        tbPageContext.registerListener(this.jrt);
        this.jgi = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.m mVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && (mVar = (com.baidu.tbadk.data.m) customResponsedMessage.getData()) != null) {
                    p.this.jrS.GG(mVar.ayq());
                }
            }
        };
        this.jgi.setTag(this.Mm);
        tbPageContext.registerListener(this.jgi);
        this.jru = new CustomMessageListener(2921435) { // from class: com.baidu.tieba.personPolymeric.view.p.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.jrX == ((Integer) customResponsedMessage.getData()).intValue() && p.this.jrW) {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(p.this.jrY);
                    p.this.cwv();
                }
            }
        };
        this.jru.setTag(this.Mm);
        tbPageContext.registerListener(this.jru);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwv() {
        this.jrX = -1;
        this.jrW = false;
        if (this.jrz != null) {
            this.jrz.cwA();
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
        if (this.jrS != null) {
            this.jrS.onDestroy();
        }
        if (this.jrz != null) {
            this.jrz.onDestroy();
        }
        if (this.jrU != null) {
            this.jrU.cancel();
            this.jrU.removeAllListeners();
            this.jrU.removeAllUpdateListeners();
            this.jrU = null;
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jrY);
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.jrs = aVar;
    }

    public void dU(List<com.baidu.adp.widget.ListView.m> list) {
    }
}
