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
/* loaded from: classes8.dex */
public class LegoListFragment extends BaseFragment {
    public static Set<String> ldj;
    private ImageView bEY;
    private String from;
    private NoNetworkView gXx;
    private boolean hasAnimation;
    private String itemId;
    private a jMD;
    private e lbJ;
    private long lbN;
    private j lcG;
    private boolean lcI;
    private c lcO;
    private LinearLayout lcT;
    private LegoListView lcU;
    private com.baidu.tieba.lego.c.c lcV;
    private com.baidu.tieba.lego.model.a lcW;
    private RelativeLayout lcY;
    private ImageView lcZ;
    private g lcb;
    private n lcf;
    private TbImageView lda;
    private TbImageView ldb;
    private a.C0782a ldc;
    private int ldd;
    private String lde;
    private float ldf;
    private Rect rect;
    private h refreshView;
    private int screenWidth;
    private boolean lcX = false;
    private boolean lbW = false;
    private int gAO = -1;
    private int jkn = -1;
    private boolean jkX = false;
    private int ldg = 0;
    private View ldh = null;
    private k ldi = null;
    private m ldk = new m() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.1
        @Override // com.baidu.tieba.lego.card.view.m
        public void mB(String str) {
            if (LegoListFragment.this.lcf != null) {
                LegoListFragment.this.lcf.NQ(str);
            }
        }
    };
    private d ldl = new d() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.7
        @Override // com.baidu.tieba.lego.d
        public void c(int i, long j, String str, String str2) {
            LegoListFragment.this.lcW.a(2, j, str, i, str2);
        }

        @Override // com.baidu.tieba.lego.d
        public void p(long j, String str) {
            LegoListFragment.this.lcW.w(j, str);
        }
    };
    private View.OnLayoutChangeListener ldm = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.8
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            LegoListFragment.this.lcO.Ed(LegoListFragment.this.dbE());
            if (!LegoListFragment.this.isFullScreen()) {
                LegoListFragment.this.lcO.dcE();
            }
        }
    };
    private View.OnTouchListener bUt = new View.OnTouchListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (LegoListFragment.this.lcO.dcG()) {
                if (LegoListFragment.this.lcU != null && view == LegoListFragment.this.lcU.getListView() && LegoListFragment.this.jMD != null) {
                    LegoListFragment.this.jMD.onTouchEvent(motionEvent);
                }
                return false;
            }
            return true;
        }
    };
    private a.InterfaceC0717a iHb = new a.InterfaceC0717a() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.10
        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void G(int i, int i2) {
            LegoListFragment.this.jkX = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void H(int i, int i2) {
            LegoListFragment.this.jkX = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void ch(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void I(int i, int i2) {
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11
        private int fOI = 0;
        private int ldo = 0;
        private boolean ldp = false;
        private int ldq = -1;
        private int ldr = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            View findFocus;
            LegoListFragment.this.ldg = i;
            if (1 == i && LegoListFragment.this.ldh != null && (findFocus = LegoListFragment.this.ldh.findFocus()) != null) {
                findFocus.clearFocus();
            }
            if (i == 0) {
                LegoListFragment.this.aa(1, LegoListFragment.this.jkX);
                if (this.ldp) {
                    LegoListFragment.this.lcO.Eb(com.baidu.tieba.lego.card.c.c.lex);
                    LegoListFragment.this.lcU.getListView().setSelectionFromTop(this.ldq, this.ldr);
                    LegoListFragment.this.lcO.dcE();
                    LegoListFragment.this.lcU.getListView().post(new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LegoListFragment.this.aa(1, LegoListFragment.this.jkX);
                            AnonymousClass11.this.ldp = false;
                        }
                    });
                }
            }
            if (LegoListFragment.this.ldi != null) {
                LegoListFragment.this.ldi.onScrollStateChanged(absListView, i);
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
            if (LegoListFragment.this.lcO.dcG() && LegoListFragment.this.lcU != null && LegoListFragment.this.lcU.getListView() != null && LegoListFragment.this.lcU.getListView().getChildAt(0) != null) {
                LegoListFragment.this.lcO.dcE();
                boolean z2 = true;
                if (i == this.fOI && LegoListFragment.this.jkX) {
                    z2 = false;
                }
                boolean z3 = ((i + i2) + (-1) != this.ldo || LegoListFragment.this.jkX) ? z2 : false;
                boolean z4 = false;
                if (this.ldo < (i + i2) - 1) {
                    z4 = false;
                    z = true;
                } else if (this.fOI > i) {
                    z4 = true;
                    z = true;
                } else {
                    z = false;
                }
                if (z && !this.ldp) {
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
                                this.ldp = true;
                                this.ldq = (i + i2) - 1;
                                this.ldr = 0;
                                com.baidu.tieba.lego.card.c.c.lex = i7;
                                LegoListFragment.this.lcU.getListView().post(new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        LegoListFragment.this.lcU.getListView().smoothScrollToPositionFromTop(AnonymousClass11.this.ldq, AnonymousClass11.this.ldr, 400);
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
                                this.ldp = true;
                                if (ratio > 2.67d) {
                                    this.ldq = i + 1;
                                    this.ldr = (int) ((l.getScreenSize(LegoListFragment.this.getActivity()).widthPixels * 1.78d) + 0.5d);
                                } else {
                                    this.ldq = i12;
                                    this.ldr = 0;
                                }
                                com.baidu.tieba.lego.card.c.c.lex = i4;
                                LegoListFragment.this.lcU.getListView().post(new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        LegoListFragment.this.lcU.getListView().smoothScrollToPositionFromTop(AnonymousClass11.this.ldq, AnonymousClass11.this.ldr, 400);
                                    }
                                });
                            }
                        }
                    }
                }
                this.fOI = i;
                this.ldo = (i + i2) - 1;
                if (this.ldr > 0) {
                    this.ldo--;
                }
                LegoListFragment.this.jkn = i;
                LegoListFragment.this.gAO = (i + i2) - 1;
                if (z3) {
                    LegoListFragment.this.aa(2, LegoListFragment.this.jkX);
                }
            }
        }
    };
    private Runnable kwf = new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.12
        @Override // java.lang.Runnable
        public void run() {
            if (LegoListFragment.this.lcf != null) {
                LegoListFragment.this.lcf.dcT();
            }
        }
    };

    public static void dbC() {
        if (ldj == null) {
            ldj = new HashSet();
        } else {
            ldj.clear();
        }
    }

    public int dbD() {
        return this.ldg;
    }

    public void b(j jVar) {
        this.lcG = jVar;
    }

    public void a(c cVar) {
        this.lcO = cVar;
        this.lcO.a(this.ldk);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null && this.lcY != null) {
            if (configuration.orientation == 2) {
                this.lcY.setVisibility(8);
            } else if (this.lcI) {
                this.lcY.setVisibility(0);
            } else {
                this.lcY.setVisibility(8);
            }
        }
    }

    public void hg(long j) {
        this.lbN = j;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    public void setImmersive(boolean z) {
        this.lbW = z;
    }

    public boolean isFullScreen() {
        return !this.lcO.dcG();
    }

    public int dbE() {
        int[] iArr = new int[2];
        this.lcU.getLocationOnScreen(iArr);
        return iArr[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(int i, boolean z) {
        if (this.lcf != null && this.lcU != null && this.lcU.getListView() != null && this.lcU.lbK != null && this.lcU.lbK.getCount() != 0) {
            this.lcf.a(this.jkn, this.gAO, z, i);
        }
    }

    public void a(k kVar) {
        this.ldi = kVar;
    }

    public void b(RelativeLayout relativeLayout) {
        this.lcY = relativeLayout;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.screenWidth = l.getEquipmentWidth(getActivity());
        FrameLayout frameLayout = new FrameLayout(getActivity());
        this.lcT = new LinearLayout(getActivity());
        this.lcT.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.lcT.setOrientation(1);
        this.gXx = new NoNetworkView(getActivity());
        if (!this.lcI) {
            this.lcT.addView(this.gXx);
            if (l.isNetOk()) {
                this.gXx.setVisibility(8);
            } else {
                this.gXx.setVisibility(0);
            }
        }
        this.lcU = a(this.ldl);
        this.lcU.setDrawingCacheEnabled(false);
        this.lbJ = new e();
        this.lbJ.lhU = this.lbN;
        this.lbJ.itemId = this.itemId;
        this.lcV = new com.baidu.tieba.lego.c.c(this.lbJ);
        this.lcU.a(this.lcV, true);
        this.lcT.addView(this.lcU);
        this.lcU.getListView().setOnScrollListener(this.mOnScrollListener);
        this.lcU.getListView().addOnLayoutChangeListener(this.ldm);
        this.lcU.getListView().setOnTouchListener(this.bUt);
        this.jMD = new com.baidu.tieba.f.a();
        this.jMD.a(this.iHb);
        this.lcf = this.lcU.getPlaySwitchController();
        frameLayout.addView(this.lcT, new FrameLayout.LayoutParams(-1, -1));
        if (this.lcI) {
            this.lcY.setVisibility(0);
            this.lcZ = (ImageView) this.lcY.findViewById(R.id.btn_share);
            l.addToParentArea(getActivity(), this.lcZ, 20, 20, 20, 20);
            this.lcZ.setVisibility(8);
            this.bEY = (ImageView) this.lcY.findViewById(R.id.btn_close);
            l.addToParentArea(getActivity(), this.bEY, 20, 20, 20, 20);
            this.bEY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LegoListFragment.this.endAnimation();
                }
            });
            getBaseFragmentActivity().setSwipeBackEnabled(false);
            if (this.hasAnimation && this.ldc != null && this.ldc.isValid()) {
                frameLayout.setBackgroundColor(getActivity().getResources().getColor(R.color.black_alpha100));
                this.ldd = l.getStatusBarHeight(getActivity());
                this.rect = this.ldc.rect;
                this.rect.top -= this.ldd;
                this.rect.bottom -= this.ldd;
                this.lda = new TbImageView(getActivity());
                this.lda.setScaleType(ImageView.ScaleType.FIT_XY);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.rect.right - this.rect.left, this.rect.bottom - this.rect.top);
                layoutParams.setMargins(this.rect.left, this.rect.top, 0, 0);
                this.lda.setLayoutParams(layoutParams);
                this.lda.startLoad(this.ldc.picUrl, 17, false);
                frameLayout.addView(this.lda, layoutParams);
                if (this.ldc.dbN()) {
                    Rect rect = this.ldc.ldH;
                    this.ldf = l.getDimens(getActivity(), R.dimen.ds10);
                    this.ldb = new TbImageView(getActivity());
                    this.ldb.setScaleType(ImageView.ScaleType.FIT_XY);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.screenWidth, (int) (this.screenWidth * (((rect.bottom - rect.top) * 1.0d) / (rect.right - rect.left))));
                    layoutParams2.setMargins(0, (int) (((this.screenWidth / (this.rect.right - this.rect.left)) * (this.rect.bottom - this.rect.top)) + this.ldf), 0, 0);
                    this.ldb.setLayoutParams(layoutParams2);
                    this.ldb.startLoad(this.ldc.ldG, 17, false);
                    frameLayout.addView(this.ldb, layoutParams2);
                    this.ldb.setVisibility(8);
                }
                e(this.rect);
                this.lcT.setVisibility(8);
            }
            s.dDB().dDx().f(this.lbN, this.itemId, this.from);
        } else if (this.lcY != null) {
            this.lcY.setVisibility(8);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.ldh = activity.getWindow().getDecorView();
        }
        return frameLayout;
    }

    private void e(Rect rect) {
        float f = this.screenWidth / (rect.right - rect.left);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.lda, "scaleX", 1.0f, f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.lda, "scaleY", 1.0f, f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.lda, "translationX", -rect.left);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.lda, "translationY", -rect.top);
        this.lda.setPivotX(0.0f);
        this.lda.setPivotY(0.0f);
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.14
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LegoListFragment.this.lcT.setVisibility(8);
                LegoListFragment.this.lda.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (LegoListFragment.this.ldc.dbN()) {
                    LegoListFragment.this.lcT.setVisibility(8);
                    LegoListFragment.this.dbF();
                    return;
                }
                LegoListFragment.this.lcT.setVisibility(0);
                LegoListFragment.this.lda.setVisibility(8);
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
    public void dbF() {
        this.ldb.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ldb, "translationY", -this.ldf);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ldb, "alpha", 0.0f, 1.0f);
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LegoListFragment.this.lcT.setVisibility(8);
                LegoListFragment.this.lda.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LegoListFragment.this.ldb.setVisibility(8);
                LegoListFragment.this.lda.setVisibility(8);
                LegoListFragment.this.lcT.setVisibility(0);
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
        if (this.ldb == null) {
            getActivity().finish();
            return;
        }
        this.lda.startLoad(this.ldc.picUrl, 17, false);
        float f = this.rect.top - this.ldd;
        float f2 = this.screenWidth / (this.rect.right - this.rect.left);
        AnimationSet animationSet = new AnimationSet(false);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, this.rect.left, 0.0f, f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f / f2, 1.0f, 1.0f / f2);
        this.lda.setPivotX(0.5f);
        this.lda.setPivotY(0.5f);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(200L);
        this.lda.startAnimation(animationSet);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                LegoListFragment.this.lcT.setVisibility(8);
                if (LegoListFragment.this.ldc.dbN()) {
                    LegoListFragment.this.ldb.setVisibility(8);
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
        LegoListView legoListView = new LegoListView(getPageContext().getPageActivity(), this.lbW);
        legoListView.lbK.setFrom(this.from);
        if (this.lcI) {
            legoListView.setFriction(ViewConfiguration.getScrollFriction() * 12.0f);
        }
        legoListView.l(getUniqueId());
        legoListView.setCallback(dVar);
        return legoListView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(List<com.baidu.tieba.lego.c.d> list) {
        if (this.lcZ != null) {
            if (y.isEmpty(list)) {
                this.lcZ.setVisibility(8);
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).type == 2) {
                    final com.baidu.tieba.lego.c.d dVar = list.get(i);
                    if (!TextUtils.isEmpty(list.get(i).scheme)) {
                        this.lcZ.setVisibility(0);
                        this.lcZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (LegoListFragment.this.mIsLogin) {
                                    if (LegoListFragment.this.lcG != null) {
                                        LegoListFragment.this.lcG.a(dVar);
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
        if (!TextUtils.isEmpty(this.lde)) {
            this.lcV.NT(this.lde);
            if (this.lcV.ddf()) {
                eI(this.lcV.dde());
                this.lcU.a(this.lcV, true);
                return;
            }
        }
        if (isAdded() && isPrimary() && !this.lcX) {
            dbG();
        }
    }

    private void dbG() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            b(getView(), false, getResources().getDimensionPixelSize(R.dimen.ds360));
        }
        this.lcU.setViewForeground();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initModel();
    }

    private void initModel() {
        this.lcW = b.ddj().b(getPageContext(), getUniqueId());
        this.lcW.a(new com.baidu.tieba.lego.model.b() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.5
            @Override // com.baidu.tieba.lego.model.b
            public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
                if (z) {
                    LegoListFragment.this.dq(LegoListFragment.this.getView());
                }
                DataRes dataRes = (DataRes) message;
                if (!z || (dataRes != null && dataRes.cards != null)) {
                    LegoListFragment.this.lcX = true;
                    LegoListFragment.this.lcV.a(z, dataRes, z2, i);
                    if (TextUtils.isEmpty(LegoListFragment.this.lcV.ddc()) || TextUtils.isEmpty(LegoListFragment.this.lcV.ddd())) {
                        if (LegoListFragment.this.lcG != null) {
                            LegoListFragment.this.lcG.KP(LegoListFragment.this.lcV.getTitle());
                        }
                    } else if (LegoListFragment.this.lcG != null) {
                        LegoListFragment.this.lcG.fG(LegoListFragment.this.lcV.ddc(), LegoListFragment.this.lcV.ddd());
                    }
                    if (LegoListFragment.this.lcG != null) {
                        LegoListFragment.this.lcG.eG(LegoListFragment.this.lcV.dde());
                    }
                    LegoListFragment.this.lcU.a(LegoListFragment.this.lcV, false);
                    if (LegoListFragment.this.lbW && LegoListFragment.this.lcI) {
                        LegoListFragment.this.eI(LegoListFragment.this.lcV.dde());
                    }
                } else if (LegoListFragment.this.getPageContext() != null && LegoListFragment.this.getPageContext().getResources() != null) {
                    LegoListFragment.this.showNetRefreshView(LegoListFragment.this.getView(), LegoListFragment.this.getPageContext().getResources().getString(R.string.neterror), false);
                }
            }

            @Override // com.baidu.tieba.lego.model.b
            public void a(long j, String str, String str2, int i) {
                LegoListFragment.this.dq(LegoListFragment.this.getView());
                if (LegoListFragment.this.lcV.hasData()) {
                    LegoListFragment.this.lcU.a(LegoListFragment.this.lcV, false);
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
        if (this.lcb == null) {
            if (i < 0) {
                this.lcb = new g(getActivity());
            } else {
                this.lcb = new g(getActivity(), i);
            }
            this.lcb.onChangeSkinType();
        }
        this.lcb.attachView(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dq(View view) {
        if (this.lcb != null) {
            this.lcb.dettachView(view);
            this.lcb = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getPageContext().getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (LegoListFragment.this.lcW != null) {
                        LegoListFragment.this.lcW.a(2, LegoListFragment.this.lbJ.lhU, LegoListFragment.this.lbJ.itemId, 1, "");
                        LegoListFragment.this.Xc();
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
    public void Xc() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(getView());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.lcU.setViewBackGround();
        if (this.lcf != null) {
            this.lcf.tN(false);
            this.lcf.dcS();
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.kwf);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.lcU.setViewForeground();
        if (this.lcf != null) {
            this.lcf.tN(true);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.kwf, 200L);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.lcU.onDestory();
        if (this.lcf != null) {
            this.lcf.destroy();
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.kwf);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gXx != null) {
            this.gXx.onChangeSkinType(com.baidu.adp.base.j.J(getActivity()), i);
        }
        if (this.lcY != null) {
            getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lcY);
        }
        super.onChangeSkinType(i);
    }

    public void NI(String str) {
        this.lde = str;
    }

    public void fI(String str, String str2) {
        this.ldc = a.C0782a.NL(str);
        this.ldc.NM(str2);
    }

    public void tC(boolean z) {
        this.hasAnimation = z;
    }

    public void tD(boolean z) {
        this.lcI = z;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public BaseAdapter getAdapter() {
        if (this.lcU == null) {
            return null;
        }
        return this.lcU.lbK;
    }

    public n getPlaySwitchController() {
        return this.lcf;
    }
}
