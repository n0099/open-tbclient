package com.baidu.tieba.lego.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
import com.baidu.tieba.lego.LegoListView;
import com.baidu.tieba.lego.c.e;
import com.baidu.tieba.lego.card.a.a;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.view.c;
import com.baidu.tieba.lego.card.view.m;
import com.baidu.tieba.lego.card.view.n;
import com.baidu.tieba.lego.d;
import com.baidu.tieba.lego.d.b;
import com.baidu.tieba.lego.j;
import com.baidu.tieba.lego.k;
import com.baidu.tieba.recapp.s;
import com.squareup.wire.Message;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tbclient.Lego.DataRes;
/* loaded from: classes9.dex */
public class LegoListFragment extends BaseFragment {
    public static Set<String> lbg;
    private ImageView bDy;
    private String from;
    private NoNetworkView gVO;
    private boolean hasAnimation;
    private String itemId;
    private a jKU;
    private e kZG;
    private long kZK;
    private g kZY;
    private j laD;
    private boolean laF;
    private c laL;
    private LinearLayout laQ;
    private LegoListView laR;
    private com.baidu.tieba.lego.c.c laS;
    private com.baidu.tieba.lego.model.a laT;
    private RelativeLayout laV;
    private ImageView laW;
    private TbImageView laX;
    private TbImageView laY;
    private a.C0776a laZ;
    private n lac;
    private int lba;
    private String lbb;
    private float lbc;
    private Rect rect;
    private h refreshView;
    private int screenWidth;
    private boolean laU = false;
    private boolean kZT = false;
    private int gzf = -1;
    private int jiE = -1;
    private boolean jjo = false;
    private int lbd = 0;
    private View lbe = null;
    private k lbf = null;
    private m lbh = new m() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.1
        @Override // com.baidu.tieba.lego.card.view.m
        public void mu(String str) {
            if (LegoListFragment.this.lac != null) {
                LegoListFragment.this.lac.NK(str);
            }
        }
    };
    private d lbi = new d() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.7
        @Override // com.baidu.tieba.lego.d
        public void c(int i, long j, String str, String str2) {
            LegoListFragment.this.laT.a(2, j, str, i, str2);
        }

        @Override // com.baidu.tieba.lego.d
        public void p(long j, String str) {
            LegoListFragment.this.laT.w(j, str);
        }
    };
    private View.OnLayoutChangeListener lbj = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.8
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            LegoListFragment.this.laL.Ea(LegoListFragment.this.dbv());
            if (!LegoListFragment.this.isFullScreen()) {
                LegoListFragment.this.laL.dcv();
            }
        }
    };
    private View.OnTouchListener bST = new View.OnTouchListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (LegoListFragment.this.laL.dcx()) {
                if (LegoListFragment.this.laR != null && view == LegoListFragment.this.laR.getListView() && LegoListFragment.this.jKU != null) {
                    LegoListFragment.this.jKU.onTouchEvent(motionEvent);
                }
                return false;
            }
            return true;
        }
    };
    private a.InterfaceC0711a iFs = new a.InterfaceC0711a() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.10
        @Override // com.baidu.tieba.f.a.InterfaceC0711a
        public void G(int i, int i2) {
            LegoListFragment.this.jjo = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0711a
        public void H(int i, int i2) {
            LegoListFragment.this.jjo = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0711a
        public void ch(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0711a
        public void I(int i, int i2) {
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11
        private int fNi = 0;
        private int lbl = 0;
        private boolean lbm = false;
        private int lbn = -1;
        private int lbo = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            View findFocus;
            LegoListFragment.this.lbd = i;
            if (1 == i && LegoListFragment.this.lbe != null && (findFocus = LegoListFragment.this.lbe.findFocus()) != null) {
                findFocus.clearFocus();
            }
            if (i == 0) {
                LegoListFragment.this.aa(1, LegoListFragment.this.jjo);
                if (this.lbm) {
                    LegoListFragment.this.laL.DY(com.baidu.tieba.lego.card.c.c.lcu);
                    LegoListFragment.this.laR.getListView().setSelectionFromTop(this.lbn, this.lbo);
                    LegoListFragment.this.laL.dcv();
                    LegoListFragment.this.laR.getListView().post(new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LegoListFragment.this.aa(1, LegoListFragment.this.jjo);
                            AnonymousClass11.this.lbm = false;
                        }
                    });
                }
            }
            if (LegoListFragment.this.lbf != null) {
                LegoListFragment.this.lbf.onScrollStateChanged(absListView, i);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            boolean z;
            int i4;
            int i5;
            double d;
            int i6;
            int i7;
            if (LegoListFragment.this.laL.dcx() && LegoListFragment.this.laR != null && LegoListFragment.this.laR.getListView() != null && LegoListFragment.this.laR.getListView().getChildAt(0) != null) {
                LegoListFragment.this.laL.dcv();
                boolean z2 = true;
                if (i == this.fNi && LegoListFragment.this.jjo) {
                    z2 = false;
                }
                boolean z3 = ((i + i2) + (-1) != this.lbl || LegoListFragment.this.jjo) ? z2 : false;
                boolean z4 = false;
                if (this.lbl < (i + i2) - 1) {
                    z4 = false;
                    z = true;
                } else if (this.fNi > i) {
                    z4 = true;
                    z = true;
                } else {
                    z = false;
                }
                if (z && !this.lbm) {
                    BaseAdapter adapter = LegoListFragment.this.getAdapter();
                    if (!z4) {
                        if (adapter != null && adapter.getCount() > (i + i2) - 1) {
                            int i8 = ((i + i2) - 1) - 1;
                            if (i8 < 0) {
                                i8 = 0;
                            }
                            Object item = adapter.getItem(i8);
                            int i9 = 0;
                            if (item instanceof BaseLegoCardInfo) {
                                i9 = ((BaseLegoCardInfo) item).getPage();
                            }
                            Object item2 = adapter.getItem((i + i2) - 1);
                            if (!(item2 instanceof BaseLegoCardInfo)) {
                                i7 = 0;
                            } else {
                                i7 = ((BaseLegoCardInfo) item2).getPage();
                            }
                            if (i9 != 0 && i7 != 0 && i9 < i7) {
                                this.lbm = true;
                                this.lbn = (i + i2) - 1;
                                this.lbo = 0;
                                com.baidu.tieba.lego.card.c.c.lcu = i7;
                                LegoListFragment.this.laR.getListView().post(new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        LegoListFragment.this.laR.getListView().smoothScrollToPositionFromTop(AnonymousClass11.this.lbn, AnonymousClass11.this.lbo, 400);
                                    }
                                });
                            }
                        }
                    } else {
                        int i10 = i + 1;
                        if (adapter != null && adapter.getCount() > i10) {
                            Object item3 = adapter.getItem(i);
                            if (!(item3 instanceof BaseLegoCardInfo)) {
                                i4 = 0;
                            } else {
                                i4 = ((BaseLegoCardInfo) item3).getPage();
                            }
                            Object item4 = adapter.getItem(i10);
                            if (!(item4 instanceof BaseLegoCardInfo)) {
                                i5 = 0;
                            } else {
                                i5 = ((BaseLegoCardInfo) item4).getPage();
                            }
                            if (i4 != 0 && i5 != 0 && i4 < i5) {
                                int i11 = i - 1;
                                double ratio = ((BaseLegoCardInfo) item3).getRatio();
                                int i12 = i;
                                while (i11 >= 0) {
                                    Object item5 = adapter.getItem(i11);
                                    if (!(item5 instanceof BaseLegoCardInfo)) {
                                        d = ratio;
                                        i6 = i11;
                                    } else if (((BaseLegoCardInfo) item5).getPage() != i4) {
                                        break;
                                    } else {
                                        d = ((BaseLegoCardInfo) item5).getRatio() + ratio;
                                        i12 = i11;
                                        i6 = i11 - 1;
                                    }
                                    ratio = d;
                                    i11 = i6;
                                }
                                this.lbm = true;
                                if (ratio > 2.67d) {
                                    this.lbn = i + 1;
                                    this.lbo = (int) ((l.getScreenSize(LegoListFragment.this.getActivity()).widthPixels * 1.78d) + 0.5d);
                                } else {
                                    this.lbn = i12;
                                    this.lbo = 0;
                                }
                                com.baidu.tieba.lego.card.c.c.lcu = i4;
                                LegoListFragment.this.laR.getListView().post(new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        LegoListFragment.this.laR.getListView().smoothScrollToPositionFromTop(AnonymousClass11.this.lbn, AnonymousClass11.this.lbo, 400);
                                    }
                                });
                            }
                        }
                    }
                }
                this.fNi = i;
                this.lbl = (i + i2) - 1;
                if (this.lbo > 0) {
                    this.lbl--;
                }
                LegoListFragment.this.jiE = i;
                LegoListFragment.this.gzf = (i + i2) - 1;
                if (z3) {
                    LegoListFragment.this.aa(2, LegoListFragment.this.jjo);
                }
            }
        }
    };
    private Runnable kud = new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.12
        @Override // java.lang.Runnable
        public void run() {
            if (LegoListFragment.this.lac != null) {
                LegoListFragment.this.lac.dcK();
            }
        }
    };

    public static void dbt() {
        if (lbg == null) {
            lbg = new HashSet();
        } else {
            lbg.clear();
        }
    }

    public int dbu() {
        return this.lbd;
    }

    public void b(j jVar) {
        this.laD = jVar;
    }

    public void a(c cVar) {
        this.laL = cVar;
        this.laL.a(this.lbh);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null && this.laV != null) {
            if (configuration.orientation == 2) {
                this.laV.setVisibility(8);
            } else if (this.laF) {
                this.laV.setVisibility(0);
            } else {
                this.laV.setVisibility(8);
            }
        }
    }

    public void hg(long j) {
        this.kZK = j;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    public void setImmersive(boolean z) {
        this.kZT = z;
    }

    public boolean isFullScreen() {
        return !this.laL.dcx();
    }

    public int dbv() {
        int[] iArr = new int[2];
        this.laR.getLocationOnScreen(iArr);
        return iArr[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(int i, boolean z) {
        if (this.lac != null && this.laR != null && this.laR.getListView() != null && this.laR.kZH != null && this.laR.kZH.getCount() != 0) {
            this.lac.a(this.jiE, this.gzf, z, i);
        }
    }

    public void a(k kVar) {
        this.lbf = kVar;
    }

    public void b(RelativeLayout relativeLayout) {
        this.laV = relativeLayout;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.screenWidth = l.getEquipmentWidth(getActivity());
        FrameLayout frameLayout = new FrameLayout(getActivity());
        this.laQ = new LinearLayout(getActivity());
        this.laQ.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.laQ.setOrientation(1);
        this.gVO = new NoNetworkView(getActivity());
        if (!this.laF) {
            this.laQ.addView(this.gVO);
            if (l.isNetOk()) {
                this.gVO.setVisibility(8);
            } else {
                this.gVO.setVisibility(0);
            }
        }
        this.laR = a(this.lbi);
        this.laR.setDrawingCacheEnabled(false);
        this.kZG = new e();
        this.kZG.lfS = this.kZK;
        this.kZG.itemId = this.itemId;
        this.laS = new com.baidu.tieba.lego.c.c(this.kZG);
        this.laR.a(this.laS, true);
        this.laQ.addView(this.laR);
        this.laR.getListView().setOnScrollListener(this.mOnScrollListener);
        this.laR.getListView().addOnLayoutChangeListener(this.lbj);
        this.laR.getListView().setOnTouchListener(this.bST);
        this.jKU = new com.baidu.tieba.f.a();
        this.jKU.a(this.iFs);
        this.lac = this.laR.getPlaySwitchController();
        frameLayout.addView(this.laQ, new FrameLayout.LayoutParams(-1, -1));
        if (this.laF) {
            this.laV.setVisibility(0);
            this.laW = (ImageView) this.laV.findViewById(R.id.btn_share);
            l.addToParentArea(getActivity(), this.laW, 20, 20, 20, 20);
            this.laW.setVisibility(8);
            this.bDy = (ImageView) this.laV.findViewById(R.id.btn_close);
            l.addToParentArea(getActivity(), this.bDy, 20, 20, 20, 20);
            this.bDy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LegoListFragment.this.endAnimation();
                }
            });
            getBaseFragmentActivity().setSwipeBackEnabled(false);
            if (this.hasAnimation && this.laZ != null && this.laZ.isValid()) {
                frameLayout.setBackgroundColor(getActivity().getResources().getColor(R.color.black_alpha100));
                this.lba = l.getStatusBarHeight(getActivity());
                this.rect = this.laZ.rect;
                this.rect.top -= this.lba;
                this.rect.bottom -= this.lba;
                this.laX = new TbImageView(getActivity());
                this.laX.setScaleType(ImageView.ScaleType.FIT_XY);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.rect.right - this.rect.left, this.rect.bottom - this.rect.top);
                layoutParams.setMargins(this.rect.left, this.rect.top, 0, 0);
                this.laX.setLayoutParams(layoutParams);
                this.laX.startLoad(this.laZ.picUrl, 17, false);
                frameLayout.addView(this.laX, layoutParams);
                if (this.laZ.dbE()) {
                    Rect rect = this.laZ.lbE;
                    this.lbc = l.getDimens(getActivity(), R.dimen.ds10);
                    this.laY = new TbImageView(getActivity());
                    this.laY.setScaleType(ImageView.ScaleType.FIT_XY);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.screenWidth, (int) (this.screenWidth * (((rect.bottom - rect.top) * 1.0d) / (rect.right - rect.left))));
                    layoutParams2.setMargins(0, (int) (((this.screenWidth / (this.rect.right - this.rect.left)) * (this.rect.bottom - this.rect.top)) + this.lbc), 0, 0);
                    this.laY.setLayoutParams(layoutParams2);
                    this.laY.startLoad(this.laZ.lbD, 17, false);
                    frameLayout.addView(this.laY, layoutParams2);
                    this.laY.setVisibility(8);
                }
                e(this.rect);
                this.laQ.setVisibility(8);
            }
            s.dDt().dDp().f(this.kZK, this.itemId, this.from);
        } else if (this.laV != null) {
            this.laV.setVisibility(8);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.lbe = activity.getWindow().getDecorView();
        }
        return frameLayout;
    }

    private void e(Rect rect) {
        float f = this.screenWidth / (rect.right - rect.left);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.laX, "scaleX", 1.0f, f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.laX, "scaleY", 1.0f, f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.laX, "translationX", -rect.left);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.laX, "translationY", -rect.top);
        this.laX.setPivotX(0.0f);
        this.laX.setPivotY(0.0f);
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.14
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LegoListFragment.this.laQ.setVisibility(8);
                LegoListFragment.this.laX.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (LegoListFragment.this.laZ.dbE()) {
                    LegoListFragment.this.laQ.setVisibility(8);
                    LegoListFragment.this.dbw();
                    return;
                }
                LegoListFragment.this.laQ.setVisibility(0);
                LegoListFragment.this.laX.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbw() {
        this.laY.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.laY, "translationY", -this.lbc);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.laY, "alpha", 0.0f, 1.0f);
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LegoListFragment.this.laQ.setVisibility(8);
                LegoListFragment.this.laX.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LegoListFragment.this.laY.setVisibility(8);
                LegoListFragment.this.laX.setVisibility(8);
                LegoListFragment.this.laQ.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    public void endAnimation() {
        if (this.laY == null) {
            getActivity().finish();
            return;
        }
        this.laX.startLoad(this.laZ.picUrl, 17, false);
        float f = this.rect.top - this.lba;
        float f2 = this.screenWidth / (this.rect.right - this.rect.left);
        AnimationSet animationSet = new AnimationSet(false);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, this.rect.left, 0.0f, f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f / f2, 1.0f, 1.0f / f2);
        this.laX.setPivotX(0.5f);
        this.laX.setPivotY(0.5f);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(200L);
        this.laX.startAnimation(animationSet);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                LegoListFragment.this.laQ.setVisibility(8);
                if (LegoListFragment.this.laZ.dbE()) {
                    LegoListFragment.this.laY.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LegoListFragment.this.getActivity().finish();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private LegoListView a(d dVar) {
        LegoListView legoListView = new LegoListView(getPageContext().getPageActivity(), this.kZT);
        legoListView.kZH.setFrom(this.from);
        if (this.laF) {
            legoListView.setFriction(ViewConfiguration.getScrollFriction() * 12.0f);
        }
        legoListView.l(getUniqueId());
        legoListView.setCallback(dVar);
        return legoListView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(List<com.baidu.tieba.lego.c.d> list) {
        if (this.laW != null) {
            if (y.isEmpty(list)) {
                this.laW.setVisibility(8);
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).type == 2) {
                    final com.baidu.tieba.lego.c.d dVar = list.get(i);
                    if (!TextUtils.isEmpty(list.get(i).scheme)) {
                        this.laW.setVisibility(0);
                        this.laW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (LegoListFragment.this.mIsLogin) {
                                    if (LegoListFragment.this.laD != null) {
                                        LegoListFragment.this.laD.a(dVar);
                                        return;
                                    }
                                    return;
                                }
                                bh.skipToLoginActivity(LegoListFragment.this.getActivity());
                            }
                        });
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (!TextUtils.isEmpty(this.lbb)) {
            this.laS.NN(this.lbb);
            if (this.laS.dcW()) {
                eI(this.laS.dcV());
                this.laR.a(this.laS, true);
                return;
            }
        }
        if (isAdded() && isPrimary() && !this.laU) {
            dbx();
        }
    }

    private void dbx() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            b(getView(), false, getResources().getDimensionPixelSize(R.dimen.ds360));
        }
        this.laR.setViewForeground();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initModel();
    }

    private void initModel() {
        this.laT = b.dda().b(getPageContext(), getUniqueId());
        this.laT.a(new com.baidu.tieba.lego.model.b() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.5
            @Override // com.baidu.tieba.lego.model.b
            public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
                if (z) {
                    LegoListFragment.this.dq(LegoListFragment.this.getView());
                }
                DataRes dataRes = (DataRes) message;
                if (!z || (dataRes != null && dataRes.cards != null)) {
                    LegoListFragment.this.laU = true;
                    LegoListFragment.this.laS.a(z, dataRes, z2, i);
                    if (TextUtils.isEmpty(LegoListFragment.this.laS.dcT()) || TextUtils.isEmpty(LegoListFragment.this.laS.dcU())) {
                        if (LegoListFragment.this.laD != null) {
                            LegoListFragment.this.laD.KG(LegoListFragment.this.laS.getTitle());
                        }
                    } else if (LegoListFragment.this.laD != null) {
                        LegoListFragment.this.laD.fG(LegoListFragment.this.laS.dcT(), LegoListFragment.this.laS.dcU());
                    }
                    if (LegoListFragment.this.laD != null) {
                        LegoListFragment.this.laD.eG(LegoListFragment.this.laS.dcV());
                    }
                    LegoListFragment.this.laR.a(LegoListFragment.this.laS, false);
                    if (LegoListFragment.this.kZT && LegoListFragment.this.laF) {
                        LegoListFragment.this.eI(LegoListFragment.this.laS.dcV());
                    }
                } else if (LegoListFragment.this.getPageContext() != null && LegoListFragment.this.getPageContext().getResources() != null) {
                    LegoListFragment.this.showNetRefreshView(LegoListFragment.this.getView(), LegoListFragment.this.getPageContext().getResources().getString(R.string.neterror), false);
                }
            }

            @Override // com.baidu.tieba.lego.model.b
            public void a(long j, String str, String str2, int i) {
                LegoListFragment.this.dq(LegoListFragment.this.getView());
                if (LegoListFragment.this.laS.hasData()) {
                    LegoListFragment.this.laR.a(LegoListFragment.this.laS, false);
                } else if (LegoListFragment.this.getPageContext() != null && LegoListFragment.this.getPageContext().getResources() != null) {
                    LegoListFragment.this.showNetRefreshView(LegoListFragment.this.getView(), LegoListFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str2, Integer.valueOf(i)), false);
                }
            }

            @Override // com.baidu.tieba.lego.model.b
            public void a(long j, String str, Message message, boolean z) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, int i) {
        if (this.kZY == null) {
            if (i < 0) {
                this.kZY = new g(getActivity());
            } else {
                this.kZY = new g(getActivity(), i);
            }
            this.kZY.onChangeSkinType();
        }
        this.kZY.attachView(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dq(View view) {
        if (this.kZY != null) {
            this.kZY.dettachView(view);
            this.kZY = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getPageContext().getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (LegoListFragment.this.laT != null) {
                        LegoListFragment.this.laT.a(2, LegoListFragment.this.kZG.lfS, LegoListFragment.this.kZG.itemId, 1, "");
                        LegoListFragment.this.WZ();
                        LegoListFragment.this.b(LegoListFragment.this.getView(), false, LegoListFragment.this.getResources().getDimensionPixelSize(R.dimen.ds360));
                    }
                }
            });
        }
        this.refreshView.setLayoutMargin(getResources().getDimensionPixelSize(R.dimen.ds160));
        this.refreshView.setSubText(str);
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WZ() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(getView());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.laR.setViewBackGround();
        if (this.lac != null) {
            this.lac.tN(false);
            this.lac.dcJ();
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.kud);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.laR.setViewForeground();
        if (this.lac != null) {
            this.lac.tN(true);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.kud, 200L);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.laR.onDestory();
        if (this.lac != null) {
            this.lac.destroy();
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.kud);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gVO != null) {
            this.gVO.onChangeSkinType(com.baidu.adp.base.j.K(getActivity()), i);
        }
        if (this.laV != null) {
            getBaseFragmentActivity().getLayoutMode().onModeChanged(this.laV);
        }
        super.onChangeSkinType(i);
    }

    public void NC(String str) {
        this.lbb = str;
    }

    public void fI(String str, String str2) {
        this.laZ = a.C0776a.NF(str);
        this.laZ.NG(str2);
    }

    public void tC(boolean z) {
        this.hasAnimation = z;
    }

    public void tD(boolean z) {
        this.laF = z;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public BaseAdapter getAdapter() {
        if (this.laR == null) {
            return null;
        }
        return this.laR.kZH;
    }

    public n getPlaySwitchController() {
        return this.lac;
    }
}
