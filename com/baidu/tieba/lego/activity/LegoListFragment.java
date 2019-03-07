package com.baidu.tieba.lego.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import com.baidu.adp.base.i;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
import com.baidu.tieba.lego.LegoListView;
import com.baidu.tieba.lego.c.e;
import com.baidu.tieba.lego.card.b.a;
import com.baidu.tieba.lego.card.d.b;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.view.c;
import com.baidu.tieba.lego.card.view.l;
import com.baidu.tieba.lego.d;
import com.baidu.tieba.lego.j;
import com.baidu.tieba.lego.k;
import com.baidu.tieba.recapp.r;
import com.squareup.wire.Message;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tbclient.Lego.DataRes;
/* loaded from: classes2.dex */
public class LegoListFragment extends BaseFragment {
    public static Set<String> gGd;
    private NoNetworkView dok;
    private String from;
    private a fvR;
    private e gEB;
    private long gEF;
    private g gET;
    private l gEX;
    private boolean gFA;
    private boolean gFB;
    private c gFI;
    private LinearLayout gFM;
    private LegoListView gFN;
    private com.baidu.tieba.lego.c.c gFO;
    private com.baidu.tieba.lego.model.a gFP;
    private RelativeLayout gFR;
    private ImageView gFS;
    private ImageView gFT;
    private TbImageView gFU;
    private TbImageView gFV;
    private a.C0268a gFW;
    private int gFX;
    private String gFY;
    private float gFZ;
    private j gFy;
    private String itemId;
    private Rect rect;
    private h refreshView;
    private int screenWidth;
    private boolean gFQ = false;
    private boolean gEO = false;
    private int cZV = -1;
    private int fay = -1;
    private boolean fbe = false;
    private int gGa = 0;
    private View gGb = null;
    private k gGc = null;
    private com.baidu.tieba.lego.card.view.k gGe = new com.baidu.tieba.lego.card.view.k() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.1
        @Override // com.baidu.tieba.lego.card.view.k
        public void xV(String str) {
            if (LegoListFragment.this.gEX != null) {
                LegoListFragment.this.gEX.ye(str);
            }
        }
    };
    private d gGf = new d() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.7
        @Override // com.baidu.tieba.lego.d
        public void a(int i, long j, String str, String str2) {
            LegoListFragment.this.gFP.a(2, j, str, i, str2);
        }

        @Override // com.baidu.tieba.lego.d
        public void i(long j, String str) {
            LegoListFragment.this.gFP.p(j, str);
        }
    };
    private View.OnLayoutChangeListener gGg = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.8
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            LegoListFragment.this.gFI.uW(LegoListFragment.this.bzD());
            if (!LegoListFragment.this.isFullScreen()) {
                LegoListFragment.this.gFI.bAG();
            }
        }
    };
    private View.OnTouchListener ccU = new View.OnTouchListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (LegoListFragment.this.gFI.bAI()) {
                if (LegoListFragment.this.gFN != null && view == LegoListFragment.this.gFN.getListView() && LegoListFragment.this.fvR != null) {
                    LegoListFragment.this.fvR.onTouchEvent(motionEvent);
                }
                return false;
            }
            return true;
        }
    };
    private a.InterfaceC0243a dMw = new a.InterfaceC0243a() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.10
        @Override // com.baidu.tieba.f.a.InterfaceC0243a
        public void aR(int i, int i2) {
            LegoListFragment.this.fbe = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0243a
        public void aS(int i, int i2) {
            LegoListFragment.this.fbe = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0243a
        public void aT(int i, int i2) {
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11
        private int ctH = 0;
        private int gGi = 0;
        private boolean gGj = false;
        private int gGk = -1;
        private int gGl = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            View findFocus;
            LegoListFragment.this.gGa = i;
            if (1 == i && LegoListFragment.this.gGb != null && (findFocus = LegoListFragment.this.gGb.findFocus()) != null) {
                findFocus.clearFocus();
            }
            if (i == 0) {
                LegoListFragment.this.F(1, LegoListFragment.this.fbe);
                if (this.gGj) {
                    LegoListFragment.this.gFI.uU(b.gHs);
                    LegoListFragment.this.gFN.getListView().setSelectionFromTop(this.gGk, this.gGl);
                    LegoListFragment.this.gFI.bAG();
                    LegoListFragment.this.gFN.getListView().post(new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LegoListFragment.this.F(1, LegoListFragment.this.fbe);
                            AnonymousClass11.this.gGj = false;
                        }
                    });
                }
            }
            if (LegoListFragment.this.gGc != null) {
                LegoListFragment.this.gGc.onScrollStateChanged(absListView, i);
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
            if (LegoListFragment.this.gFI.bAI() && LegoListFragment.this.gFN != null && LegoListFragment.this.gFN.getListView() != null && LegoListFragment.this.gFN.getListView().getChildAt(0) != null) {
                LegoListFragment.this.gFI.bAG();
                boolean z2 = true;
                if (i == this.ctH && LegoListFragment.this.fbe) {
                    z2 = false;
                }
                boolean z3 = ((i + i2) + (-1) != this.gGi || LegoListFragment.this.fbe) ? z2 : false;
                boolean z4 = false;
                if (this.gGi < (i + i2) - 1) {
                    z4 = false;
                    z = true;
                } else if (this.ctH > i) {
                    z4 = true;
                    z = true;
                } else {
                    z = false;
                }
                if (z && !this.gGj) {
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
                                this.gGj = true;
                                this.gGk = (i + i2) - 1;
                                this.gGl = 0;
                                b.gHs = i7;
                                LegoListFragment.this.gFN.getListView().post(new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        LegoListFragment.this.gFN.getListView().smoothScrollToPositionFromTop(AnonymousClass11.this.gGk, AnonymousClass11.this.gGl, 400);
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
                                        i6 = i12;
                                    } else if (((BaseLegoCardInfo) item5).getPage() != i4) {
                                        break;
                                    } else {
                                        d = ((BaseLegoCardInfo) item5).getRatio() + ratio;
                                        int i13 = i11;
                                        i11--;
                                        i6 = i13;
                                    }
                                    i12 = i6;
                                    ratio = d;
                                }
                                this.gGj = true;
                                if (ratio > 2.67d) {
                                    this.gGk = i + 1;
                                    this.gGl = (int) ((com.baidu.adp.lib.util.l.s(LegoListFragment.this.getActivity()).widthPixels * 1.78d) + 0.5d);
                                } else {
                                    this.gGk = i12;
                                    this.gGl = 0;
                                }
                                b.gHs = i4;
                                LegoListFragment.this.gFN.getListView().post(new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        LegoListFragment.this.gFN.getListView().smoothScrollToPositionFromTop(AnonymousClass11.this.gGk, AnonymousClass11.this.gGl, 400);
                                    }
                                });
                            }
                        }
                    }
                }
                this.ctH = i;
                this.gGi = (i + i2) - 1;
                if (this.gGl > 0) {
                    this.gGi--;
                }
                LegoListFragment.this.fay = i;
                LegoListFragment.this.cZV = (i + i2) - 1;
                if (z3) {
                    LegoListFragment.this.F(2, LegoListFragment.this.fbe);
                }
            }
        }
    };
    private Runnable fUJ = new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.12
        @Override // java.lang.Runnable
        public void run() {
            if (LegoListFragment.this.gEX != null) {
                LegoListFragment.this.gEX.bAV();
            }
        }
    };

    public static void bzB() {
        if (gGd == null) {
            gGd = new HashSet();
        } else {
            gGd.clear();
        }
    }

    public int bzC() {
        return this.gGa;
    }

    public void b(j jVar) {
        this.gFy = jVar;
    }

    public void a(c cVar) {
        this.gFI = cVar;
        this.gFI.a(this.gGe);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null && this.gFR != null) {
            if (configuration.orientation == 2) {
                this.gFR.setVisibility(8);
            } else if (this.gFB) {
                this.gFR.setVisibility(0);
            } else {
                this.gFR.setVisibility(8);
            }
        }
    }

    public void dp(long j) {
        this.gEF = j;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    public void setImmersive(boolean z) {
        this.gEO = z;
    }

    public boolean isFullScreen() {
        return !this.gFI.bAI();
    }

    public int bzD() {
        int[] iArr = new int[2];
        this.gFN.getLocationOnScreen(iArr);
        return iArr[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(int i, boolean z) {
        if (this.gEX != null && this.gFN != null && this.gFN.getListView() != null && this.gFN.gEC != null && this.gFN.gEC.getCount() != 0) {
            this.gEX.a(this.fay, this.cZV, z, i);
        }
    }

    public void a(k kVar) {
        this.gGc = kVar;
    }

    public void b(RelativeLayout relativeLayout) {
        this.gFR = relativeLayout;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.screenWidth = com.baidu.adp.lib.util.l.aO(getActivity());
        FrameLayout frameLayout = new FrameLayout(getActivity());
        this.gFM = new LinearLayout(getActivity());
        this.gFM.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.gFM.setOrientation(1);
        this.dok = new NoNetworkView(getActivity());
        if (!this.gFB) {
            this.gFM.addView(this.dok);
            if (com.baidu.adp.lib.util.l.lo()) {
                this.dok.setVisibility(8);
            } else {
                this.dok.setVisibility(0);
            }
        }
        this.gFN = a(this.gGf);
        this.gFN.setDrawingCacheEnabled(false);
        this.gEB = new e();
        this.gEB.gKV = this.gEF;
        this.gEB.itemId = this.itemId;
        this.gFO = new com.baidu.tieba.lego.c.c(this.gEB);
        this.gFN.a(this.gFO, true);
        this.gFM.addView(this.gFN);
        this.gFN.getListView().setOnScrollListener(this.mOnScrollListener);
        this.gFN.getListView().addOnLayoutChangeListener(this.gGg);
        this.gFN.getListView().setOnTouchListener(this.ccU);
        this.fvR = new com.baidu.tieba.f.a();
        this.fvR.a(this.dMw);
        this.gEX = this.gFN.getPlaySwitchController();
        frameLayout.addView(this.gFM, new FrameLayout.LayoutParams(-1, -1));
        if (this.gFB) {
            this.gFR.setVisibility(0);
            this.gFT = (ImageView) this.gFR.findViewById(d.g.btn_share);
            com.baidu.adp.lib.util.l.b(getActivity(), this.gFT, 20, 20, 20, 20);
            this.gFT.setVisibility(8);
            this.gFS = (ImageView) this.gFR.findViewById(d.g.btn_close);
            com.baidu.adp.lib.util.l.b(getActivity(), this.gFS, 20, 20, 20, 20);
            this.gFS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LegoListFragment.this.oS();
                }
            });
            getBaseFragmentActivity().setSwipeBackEnabled(false);
            if (this.gFA && this.gFW != null && this.gFW.isValid()) {
                frameLayout.setBackgroundColor(getActivity().getResources().getColor(d.C0236d.black_alpha100));
                this.gFX = com.baidu.adp.lib.util.l.r(getActivity());
                this.rect = this.gFW.rect;
                this.rect.top -= this.gFX;
                this.rect.bottom -= this.gFX;
                this.gFU = new TbImageView(getActivity());
                this.gFU.setScaleType(ImageView.ScaleType.FIT_XY);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.rect.right - this.rect.left, this.rect.bottom - this.rect.top);
                layoutParams.setMargins(this.rect.left, this.rect.top, 0, 0);
                this.gFU.setLayoutParams(layoutParams);
                this.gFU.startLoad(this.gFW.picUrl, 17, false);
                frameLayout.addView(this.gFU, layoutParams);
                if (this.gFW.bzM()) {
                    Rect rect = this.gFW.gGD;
                    this.gFZ = com.baidu.adp.lib.util.l.h(getActivity(), d.e.ds10);
                    this.gFV = new TbImageView(getActivity());
                    this.gFV.setScaleType(ImageView.ScaleType.FIT_XY);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.screenWidth, (int) (this.screenWidth * (((rect.bottom - rect.top) * 1.0d) / (rect.right - rect.left))));
                    layoutParams2.setMargins(0, (int) (((this.screenWidth / (this.rect.right - this.rect.left)) * (this.rect.bottom - this.rect.top)) + this.gFZ), 0, 0);
                    this.gFV.setLayoutParams(layoutParams2);
                    this.gFV.startLoad(this.gFW.gGC, 17, false);
                    frameLayout.addView(this.gFV, layoutParams2);
                    this.gFV.setVisibility(8);
                }
                l(this.rect);
                this.gFM.setVisibility(8);
            }
            r.bWG().bWC().b(this.gEF, this.itemId, this.from);
        } else if (this.gFR != null) {
            this.gFR.setVisibility(8);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.gGb = activity.getWindow().getDecorView();
        }
        return frameLayout;
    }

    private void l(Rect rect) {
        float f = this.screenWidth / (rect.right - rect.left);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gFU, "scaleX", 1.0f, f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gFU, "scaleY", 1.0f, f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gFU, "translationX", -rect.left);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.gFU, "translationY", -rect.top);
        this.gFU.setPivotX(0.0f);
        this.gFU.setPivotY(0.0f);
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.14
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LegoListFragment.this.gFM.setVisibility(8);
                LegoListFragment.this.gFU.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (LegoListFragment.this.gFW.bzM()) {
                    LegoListFragment.this.gFM.setVisibility(8);
                    LegoListFragment.this.bzE();
                    return;
                }
                LegoListFragment.this.gFM.setVisibility(0);
                LegoListFragment.this.gFU.setVisibility(8);
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
    public void bzE() {
        this.gFV.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gFV, "translationY", -this.gFZ);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gFV, "alpha", 0.0f, 1.0f);
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LegoListFragment.this.gFM.setVisibility(8);
                LegoListFragment.this.gFU.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LegoListFragment.this.gFV.setVisibility(8);
                LegoListFragment.this.gFU.setVisibility(8);
                LegoListFragment.this.gFM.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    public void oS() {
        if (this.gFV == null) {
            getActivity().finish();
            return;
        }
        this.gFU.startLoad(this.gFW.picUrl, 17, false);
        float f = this.rect.top - this.gFX;
        float f2 = this.screenWidth / (this.rect.right - this.rect.left);
        AnimationSet animationSet = new AnimationSet(false);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, this.rect.left, 0.0f, f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f / f2, 1.0f, 1.0f / f2);
        this.gFU.setPivotX(0.5f);
        this.gFU.setPivotY(0.5f);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(200L);
        this.gFU.startAnimation(animationSet);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                LegoListFragment.this.gFM.setVisibility(8);
                if (LegoListFragment.this.gFW.bzM()) {
                    LegoListFragment.this.gFV.setVisibility(8);
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

    private LegoListView a(com.baidu.tieba.lego.d dVar) {
        LegoListView legoListView = new LegoListView(getPageContext().getPageActivity(), this.gEO);
        legoListView.gEC.setFrom(this.from);
        if (this.gFB) {
            legoListView.setFriction(ViewConfiguration.getScrollFriction() * 12.0f);
        }
        legoListView.i(getUniqueId());
        legoListView.setCallback(dVar);
        return legoListView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(List<com.baidu.tieba.lego.c.d> list) {
        if (this.gFT != null) {
            if (v.T(list)) {
                this.gFT.setVisibility(8);
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).type == 2) {
                    final com.baidu.tieba.lego.c.d dVar = list.get(i);
                    if (!TextUtils.isEmpty(list.get(i).scheme)) {
                        this.gFT.setVisibility(0);
                        this.gFT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (LegoListFragment.this.mIsLogin) {
                                    if (LegoListFragment.this.gFy != null) {
                                        LegoListFragment.this.gFy.a(dVar);
                                        return;
                                    }
                                    return;
                                }
                                bc.cY(LegoListFragment.this.getActivity());
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
        if (!TextUtils.isEmpty(this.gFY)) {
            this.gFO.yh(this.gFY);
            if (this.gFO.bBh()) {
                dh(this.gFO.bBg());
                this.gFN.a(this.gFO, true);
                return;
            }
        }
        if (isAdded() && isPrimary() && !this.gFQ) {
            bzF();
        }
    }

    private void bzF() {
        if (com.baidu.adp.lib.util.j.kY()) {
            a(getView(), false, getResources().getDimensionPixelSize(d.e.ds360));
        }
        this.gFN.setViewForeground();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        fb();
    }

    private void fb() {
        this.gFP = com.baidu.tieba.lego.d.b.bBl().b(getPageContext(), getUniqueId());
        this.gFP.a(new com.baidu.tieba.lego.model.b() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.5
            @Override // com.baidu.tieba.lego.model.b
            public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
                if (z) {
                    LegoListFragment.this.bY(LegoListFragment.this.getView());
                }
                DataRes dataRes = (DataRes) message;
                if (!z || (dataRes != null && dataRes.cards != null)) {
                    LegoListFragment.this.gFQ = true;
                    LegoListFragment.this.gFO.a(z, dataRes, z2, i);
                    if (TextUtils.isEmpty(LegoListFragment.this.gFO.bBe()) || TextUtils.isEmpty(LegoListFragment.this.gFO.bBf())) {
                        if (LegoListFragment.this.gFy != null) {
                            LegoListFragment.this.gFy.xR(LegoListFragment.this.gFO.getTitle());
                        }
                    } else if (LegoListFragment.this.gFy != null) {
                        LegoListFragment.this.gFy.dj(LegoListFragment.this.gFO.bBe(), LegoListFragment.this.gFO.bBf());
                    }
                    if (LegoListFragment.this.gFy != null) {
                        LegoListFragment.this.gFy.df(LegoListFragment.this.gFO.bBg());
                    }
                    LegoListFragment.this.gFN.a(LegoListFragment.this.gFO, false);
                    if (LegoListFragment.this.gEO && LegoListFragment.this.gFB) {
                        LegoListFragment.this.dh(LegoListFragment.this.gFO.bBg());
                    }
                } else if (LegoListFragment.this.getPageContext() != null && LegoListFragment.this.getPageContext().getResources() != null) {
                    LegoListFragment.this.showNetRefreshView(LegoListFragment.this.getView(), LegoListFragment.this.getPageContext().getResources().getString(d.j.neterror), false);
                }
            }

            @Override // com.baidu.tieba.lego.model.b
            public void a(long j, String str, String str2, int i) {
                LegoListFragment.this.bY(LegoListFragment.this.getView());
                if (LegoListFragment.this.gFO.hasData()) {
                    LegoListFragment.this.gFN.a(LegoListFragment.this.gFO, false);
                } else if (LegoListFragment.this.getPageContext() != null && LegoListFragment.this.getPageContext().getResources() != null) {
                    LegoListFragment.this.showNetRefreshView(LegoListFragment.this.getView(), LegoListFragment.this.getPageContext().getResources().getString(d.j.net_error_text, str2, Integer.valueOf(i)), false);
                }
            }

            @Override // com.baidu.tieba.lego.model.b
            public void a(long j, String str, Message message, boolean z) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, boolean z, int i) {
        if (this.gET == null) {
            if (i < 0) {
                this.gET = new g(getActivity());
            } else {
                this.gET = new g(getActivity(), i);
            }
            this.gET.onChangeSkinType();
        }
        this.gET.attachView(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(View view) {
        if (this.gET != null) {
            this.gET.dettachView(view);
            this.gET = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getPageContext().getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (LegoListFragment.this.gFP != null) {
                        LegoListFragment.this.gFP.a(2, LegoListFragment.this.gEB.gKV, LegoListFragment.this.gEB.itemId, 1, "");
                        LegoListFragment.this.aBt();
                        LegoListFragment.this.a(LegoListFragment.this.getView(), false, LegoListFragment.this.getResources().getDimensionPixelSize(d.e.ds360));
                    }
                }
            });
        }
        this.refreshView.jR(getResources().getDimensionPixelSize(d.e.ds160));
        this.refreshView.po(str);
        this.refreshView.attachView(view, z);
        this.refreshView.anC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBt() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(getView());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.gFN.setViewBackGround();
        if (this.gEX != null) {
            this.gEX.md(false);
            this.gEX.bAU();
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fUJ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.gFN.setViewForeground();
        if (this.gEX != null) {
            this.gEX.md(true);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.fUJ, 200L);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gFN.onDestory();
        if (this.gEX != null) {
            this.gEX.destroy();
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fUJ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dok != null) {
            this.dok.onChangeSkinType(i.aK(getActivity()), i);
        }
        if (this.gFR != null) {
            getBaseFragmentActivity().getLayoutMode().onModeChanged(this.gFR);
        }
        super.onChangeSkinType(i);
    }

    public void xU(String str) {
        this.gFY = str;
    }

    public void dl(String str, String str2) {
        this.gFW = a.C0268a.xY(str);
        this.gFW.xZ(str2);
    }

    public void lT(boolean z) {
        this.gFA = z;
    }

    public void lU(boolean z) {
        this.gFB = z;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public BaseAdapter getAdapter() {
        if (this.gFN == null) {
            return null;
        }
        return this.gFN.gEC;
    }

    public l getPlaySwitchController() {
        return this.gEX;
    }
}
