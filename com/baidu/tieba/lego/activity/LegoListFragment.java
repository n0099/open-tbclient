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
    public static Set<String> gGe;
    private NoNetworkView dok;
    private String from;
    private a fvR;
    private e gEC;
    private long gEG;
    private g gEU;
    private l gEY;
    private boolean gFB;
    private boolean gFC;
    private c gFJ;
    private LinearLayout gFN;
    private LegoListView gFO;
    private com.baidu.tieba.lego.c.c gFP;
    private com.baidu.tieba.lego.model.a gFQ;
    private RelativeLayout gFS;
    private ImageView gFT;
    private ImageView gFU;
    private TbImageView gFV;
    private TbImageView gFW;
    private a.C0268a gFX;
    private int gFY;
    private String gFZ;
    private j gFz;
    private float gGa;
    private String itemId;
    private Rect rect;
    private h refreshView;
    private int screenWidth;
    private boolean gFR = false;
    private boolean gEP = false;
    private int cZV = -1;
    private int fay = -1;
    private boolean fbe = false;
    private int gGb = 0;
    private View gGc = null;
    private k gGd = null;
    private com.baidu.tieba.lego.card.view.k gGf = new com.baidu.tieba.lego.card.view.k() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.1
        @Override // com.baidu.tieba.lego.card.view.k
        public void xW(String str) {
            if (LegoListFragment.this.gEY != null) {
                LegoListFragment.this.gEY.yf(str);
            }
        }
    };
    private d gGg = new d() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.7
        @Override // com.baidu.tieba.lego.d
        public void a(int i, long j, String str, String str2) {
            LegoListFragment.this.gFQ.a(2, j, str, i, str2);
        }

        @Override // com.baidu.tieba.lego.d
        public void i(long j, String str) {
            LegoListFragment.this.gFQ.p(j, str);
        }
    };
    private View.OnLayoutChangeListener gGh = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.8
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            LegoListFragment.this.gFJ.uW(LegoListFragment.this.bzE());
            if (!LegoListFragment.this.isFullScreen()) {
                LegoListFragment.this.gFJ.bAH();
            }
        }
    };
    private View.OnTouchListener ccU = new View.OnTouchListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (LegoListFragment.this.gFJ.bAJ()) {
                if (LegoListFragment.this.gFO != null && view == LegoListFragment.this.gFO.getListView() && LegoListFragment.this.fvR != null) {
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
        private int gGj = 0;
        private boolean gGk = false;
        private int gGl = -1;
        private int gGm = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            View findFocus;
            LegoListFragment.this.gGb = i;
            if (1 == i && LegoListFragment.this.gGc != null && (findFocus = LegoListFragment.this.gGc.findFocus()) != null) {
                findFocus.clearFocus();
            }
            if (i == 0) {
                LegoListFragment.this.F(1, LegoListFragment.this.fbe);
                if (this.gGk) {
                    LegoListFragment.this.gFJ.uU(b.gHt);
                    LegoListFragment.this.gFO.getListView().setSelectionFromTop(this.gGl, this.gGm);
                    LegoListFragment.this.gFJ.bAH();
                    LegoListFragment.this.gFO.getListView().post(new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LegoListFragment.this.F(1, LegoListFragment.this.fbe);
                            AnonymousClass11.this.gGk = false;
                        }
                    });
                }
            }
            if (LegoListFragment.this.gGd != null) {
                LegoListFragment.this.gGd.onScrollStateChanged(absListView, i);
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
            if (LegoListFragment.this.gFJ.bAJ() && LegoListFragment.this.gFO != null && LegoListFragment.this.gFO.getListView() != null && LegoListFragment.this.gFO.getListView().getChildAt(0) != null) {
                LegoListFragment.this.gFJ.bAH();
                boolean z2 = true;
                if (i == this.ctH && LegoListFragment.this.fbe) {
                    z2 = false;
                }
                boolean z3 = ((i + i2) + (-1) != this.gGj || LegoListFragment.this.fbe) ? z2 : false;
                boolean z4 = false;
                if (this.gGj < (i + i2) - 1) {
                    z4 = false;
                    z = true;
                } else if (this.ctH > i) {
                    z4 = true;
                    z = true;
                } else {
                    z = false;
                }
                if (z && !this.gGk) {
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
                                this.gGk = true;
                                this.gGl = (i + i2) - 1;
                                this.gGm = 0;
                                b.gHt = i7;
                                LegoListFragment.this.gFO.getListView().post(new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        LegoListFragment.this.gFO.getListView().smoothScrollToPositionFromTop(AnonymousClass11.this.gGl, AnonymousClass11.this.gGm, 400);
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
                                this.gGk = true;
                                if (ratio > 2.67d) {
                                    this.gGl = i + 1;
                                    this.gGm = (int) ((com.baidu.adp.lib.util.l.s(LegoListFragment.this.getActivity()).widthPixels * 1.78d) + 0.5d);
                                } else {
                                    this.gGl = i12;
                                    this.gGm = 0;
                                }
                                b.gHt = i4;
                                LegoListFragment.this.gFO.getListView().post(new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        LegoListFragment.this.gFO.getListView().smoothScrollToPositionFromTop(AnonymousClass11.this.gGl, AnonymousClass11.this.gGm, 400);
                                    }
                                });
                            }
                        }
                    }
                }
                this.ctH = i;
                this.gGj = (i + i2) - 1;
                if (this.gGm > 0) {
                    this.gGj--;
                }
                LegoListFragment.this.fay = i;
                LegoListFragment.this.cZV = (i + i2) - 1;
                if (z3) {
                    LegoListFragment.this.F(2, LegoListFragment.this.fbe);
                }
            }
        }
    };
    private Runnable fUK = new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.12
        @Override // java.lang.Runnable
        public void run() {
            if (LegoListFragment.this.gEY != null) {
                LegoListFragment.this.gEY.bAW();
            }
        }
    };

    public static void bzC() {
        if (gGe == null) {
            gGe = new HashSet();
        } else {
            gGe.clear();
        }
    }

    public int bzD() {
        return this.gGb;
    }

    public void b(j jVar) {
        this.gFz = jVar;
    }

    public void a(c cVar) {
        this.gFJ = cVar;
        this.gFJ.a(this.gGf);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null && this.gFS != null) {
            if (configuration.orientation == 2) {
                this.gFS.setVisibility(8);
            } else if (this.gFC) {
                this.gFS.setVisibility(0);
            } else {
                this.gFS.setVisibility(8);
            }
        }
    }

    public void dp(long j) {
        this.gEG = j;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    public void setImmersive(boolean z) {
        this.gEP = z;
    }

    public boolean isFullScreen() {
        return !this.gFJ.bAJ();
    }

    public int bzE() {
        int[] iArr = new int[2];
        this.gFO.getLocationOnScreen(iArr);
        return iArr[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(int i, boolean z) {
        if (this.gEY != null && this.gFO != null && this.gFO.getListView() != null && this.gFO.gED != null && this.gFO.gED.getCount() != 0) {
            this.gEY.a(this.fay, this.cZV, z, i);
        }
    }

    public void a(k kVar) {
        this.gGd = kVar;
    }

    public void b(RelativeLayout relativeLayout) {
        this.gFS = relativeLayout;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.screenWidth = com.baidu.adp.lib.util.l.aO(getActivity());
        FrameLayout frameLayout = new FrameLayout(getActivity());
        this.gFN = new LinearLayout(getActivity());
        this.gFN.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.gFN.setOrientation(1);
        this.dok = new NoNetworkView(getActivity());
        if (!this.gFC) {
            this.gFN.addView(this.dok);
            if (com.baidu.adp.lib.util.l.lo()) {
                this.dok.setVisibility(8);
            } else {
                this.dok.setVisibility(0);
            }
        }
        this.gFO = a(this.gGg);
        this.gFO.setDrawingCacheEnabled(false);
        this.gEC = new e();
        this.gEC.gKW = this.gEG;
        this.gEC.itemId = this.itemId;
        this.gFP = new com.baidu.tieba.lego.c.c(this.gEC);
        this.gFO.a(this.gFP, true);
        this.gFN.addView(this.gFO);
        this.gFO.getListView().setOnScrollListener(this.mOnScrollListener);
        this.gFO.getListView().addOnLayoutChangeListener(this.gGh);
        this.gFO.getListView().setOnTouchListener(this.ccU);
        this.fvR = new com.baidu.tieba.f.a();
        this.fvR.a(this.dMw);
        this.gEY = this.gFO.getPlaySwitchController();
        frameLayout.addView(this.gFN, new FrameLayout.LayoutParams(-1, -1));
        if (this.gFC) {
            this.gFS.setVisibility(0);
            this.gFU = (ImageView) this.gFS.findViewById(d.g.btn_share);
            com.baidu.adp.lib.util.l.b(getActivity(), this.gFU, 20, 20, 20, 20);
            this.gFU.setVisibility(8);
            this.gFT = (ImageView) this.gFS.findViewById(d.g.btn_close);
            com.baidu.adp.lib.util.l.b(getActivity(), this.gFT, 20, 20, 20, 20);
            this.gFT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LegoListFragment.this.oS();
                }
            });
            getBaseFragmentActivity().setSwipeBackEnabled(false);
            if (this.gFB && this.gFX != null && this.gFX.isValid()) {
                frameLayout.setBackgroundColor(getActivity().getResources().getColor(d.C0236d.black_alpha100));
                this.gFY = com.baidu.adp.lib.util.l.r(getActivity());
                this.rect = this.gFX.rect;
                this.rect.top -= this.gFY;
                this.rect.bottom -= this.gFY;
                this.gFV = new TbImageView(getActivity());
                this.gFV.setScaleType(ImageView.ScaleType.FIT_XY);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.rect.right - this.rect.left, this.rect.bottom - this.rect.top);
                layoutParams.setMargins(this.rect.left, this.rect.top, 0, 0);
                this.gFV.setLayoutParams(layoutParams);
                this.gFV.startLoad(this.gFX.picUrl, 17, false);
                frameLayout.addView(this.gFV, layoutParams);
                if (this.gFX.bzN()) {
                    Rect rect = this.gFX.gGE;
                    this.gGa = com.baidu.adp.lib.util.l.h(getActivity(), d.e.ds10);
                    this.gFW = new TbImageView(getActivity());
                    this.gFW.setScaleType(ImageView.ScaleType.FIT_XY);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.screenWidth, (int) (this.screenWidth * (((rect.bottom - rect.top) * 1.0d) / (rect.right - rect.left))));
                    layoutParams2.setMargins(0, (int) (((this.screenWidth / (this.rect.right - this.rect.left)) * (this.rect.bottom - this.rect.top)) + this.gGa), 0, 0);
                    this.gFW.setLayoutParams(layoutParams2);
                    this.gFW.startLoad(this.gFX.gGD, 17, false);
                    frameLayout.addView(this.gFW, layoutParams2);
                    this.gFW.setVisibility(8);
                }
                l(this.rect);
                this.gFN.setVisibility(8);
            }
            r.bWH().bWD().b(this.gEG, this.itemId, this.from);
        } else if (this.gFS != null) {
            this.gFS.setVisibility(8);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.gGc = activity.getWindow().getDecorView();
        }
        return frameLayout;
    }

    private void l(Rect rect) {
        float f = this.screenWidth / (rect.right - rect.left);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gFV, "scaleX", 1.0f, f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gFV, "scaleY", 1.0f, f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gFV, "translationX", -rect.left);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.gFV, "translationY", -rect.top);
        this.gFV.setPivotX(0.0f);
        this.gFV.setPivotY(0.0f);
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.14
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LegoListFragment.this.gFN.setVisibility(8);
                LegoListFragment.this.gFV.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (LegoListFragment.this.gFX.bzN()) {
                    LegoListFragment.this.gFN.setVisibility(8);
                    LegoListFragment.this.bzF();
                    return;
                }
                LegoListFragment.this.gFN.setVisibility(0);
                LegoListFragment.this.gFV.setVisibility(8);
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
    public void bzF() {
        this.gFW.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gFW, "translationY", -this.gGa);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gFW, "alpha", 0.0f, 1.0f);
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LegoListFragment.this.gFN.setVisibility(8);
                LegoListFragment.this.gFV.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LegoListFragment.this.gFW.setVisibility(8);
                LegoListFragment.this.gFV.setVisibility(8);
                LegoListFragment.this.gFN.setVisibility(0);
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
        if (this.gFW == null) {
            getActivity().finish();
            return;
        }
        this.gFV.startLoad(this.gFX.picUrl, 17, false);
        float f = this.rect.top - this.gFY;
        float f2 = this.screenWidth / (this.rect.right - this.rect.left);
        AnimationSet animationSet = new AnimationSet(false);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, this.rect.left, 0.0f, f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f / f2, 1.0f, 1.0f / f2);
        this.gFV.setPivotX(0.5f);
        this.gFV.setPivotY(0.5f);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(200L);
        this.gFV.startAnimation(animationSet);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                LegoListFragment.this.gFN.setVisibility(8);
                if (LegoListFragment.this.gFX.bzN()) {
                    LegoListFragment.this.gFW.setVisibility(8);
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
        LegoListView legoListView = new LegoListView(getPageContext().getPageActivity(), this.gEP);
        legoListView.gED.setFrom(this.from);
        if (this.gFC) {
            legoListView.setFriction(ViewConfiguration.getScrollFriction() * 12.0f);
        }
        legoListView.i(getUniqueId());
        legoListView.setCallback(dVar);
        return legoListView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(List<com.baidu.tieba.lego.c.d> list) {
        if (this.gFU != null) {
            if (v.T(list)) {
                this.gFU.setVisibility(8);
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).type == 2) {
                    final com.baidu.tieba.lego.c.d dVar = list.get(i);
                    if (!TextUtils.isEmpty(list.get(i).scheme)) {
                        this.gFU.setVisibility(0);
                        this.gFU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (LegoListFragment.this.mIsLogin) {
                                    if (LegoListFragment.this.gFz != null) {
                                        LegoListFragment.this.gFz.a(dVar);
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
        if (!TextUtils.isEmpty(this.gFZ)) {
            this.gFP.yi(this.gFZ);
            if (this.gFP.bBi()) {
                dh(this.gFP.bBh());
                this.gFO.a(this.gFP, true);
                return;
            }
        }
        if (isAdded() && isPrimary() && !this.gFR) {
            bzG();
        }
    }

    private void bzG() {
        if (com.baidu.adp.lib.util.j.kY()) {
            a(getView(), false, getResources().getDimensionPixelSize(d.e.ds360));
        }
        this.gFO.setViewForeground();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        fb();
    }

    private void fb() {
        this.gFQ = com.baidu.tieba.lego.d.b.bBm().b(getPageContext(), getUniqueId());
        this.gFQ.a(new com.baidu.tieba.lego.model.b() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.5
            @Override // com.baidu.tieba.lego.model.b
            public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
                if (z) {
                    LegoListFragment.this.bY(LegoListFragment.this.getView());
                }
                DataRes dataRes = (DataRes) message;
                if (!z || (dataRes != null && dataRes.cards != null)) {
                    LegoListFragment.this.gFR = true;
                    LegoListFragment.this.gFP.a(z, dataRes, z2, i);
                    if (TextUtils.isEmpty(LegoListFragment.this.gFP.bBf()) || TextUtils.isEmpty(LegoListFragment.this.gFP.bBg())) {
                        if (LegoListFragment.this.gFz != null) {
                            LegoListFragment.this.gFz.xS(LegoListFragment.this.gFP.getTitle());
                        }
                    } else if (LegoListFragment.this.gFz != null) {
                        LegoListFragment.this.gFz.dj(LegoListFragment.this.gFP.bBf(), LegoListFragment.this.gFP.bBg());
                    }
                    if (LegoListFragment.this.gFz != null) {
                        LegoListFragment.this.gFz.df(LegoListFragment.this.gFP.bBh());
                    }
                    LegoListFragment.this.gFO.a(LegoListFragment.this.gFP, false);
                    if (LegoListFragment.this.gEP && LegoListFragment.this.gFC) {
                        LegoListFragment.this.dh(LegoListFragment.this.gFP.bBh());
                    }
                } else if (LegoListFragment.this.getPageContext() != null && LegoListFragment.this.getPageContext().getResources() != null) {
                    LegoListFragment.this.showNetRefreshView(LegoListFragment.this.getView(), LegoListFragment.this.getPageContext().getResources().getString(d.j.neterror), false);
                }
            }

            @Override // com.baidu.tieba.lego.model.b
            public void a(long j, String str, String str2, int i) {
                LegoListFragment.this.bY(LegoListFragment.this.getView());
                if (LegoListFragment.this.gFP.hasData()) {
                    LegoListFragment.this.gFO.a(LegoListFragment.this.gFP, false);
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
        if (this.gEU == null) {
            if (i < 0) {
                this.gEU = new g(getActivity());
            } else {
                this.gEU = new g(getActivity(), i);
            }
            this.gEU.onChangeSkinType();
        }
        this.gEU.attachView(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(View view) {
        if (this.gEU != null) {
            this.gEU.dettachView(view);
            this.gEU = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getPageContext().getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (LegoListFragment.this.gFQ != null) {
                        LegoListFragment.this.gFQ.a(2, LegoListFragment.this.gEC.gKW, LegoListFragment.this.gEC.itemId, 1, "");
                        LegoListFragment.this.aBu();
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
    public void aBu() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(getView());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.gFO.setViewBackGround();
        if (this.gEY != null) {
            this.gEY.md(false);
            this.gEY.bAV();
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fUK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.gFO.setViewForeground();
        if (this.gEY != null) {
            this.gEY.md(true);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.fUK, 200L);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gFO.onDestory();
        if (this.gEY != null) {
            this.gEY.destroy();
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fUK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dok != null) {
            this.dok.onChangeSkinType(i.aK(getActivity()), i);
        }
        if (this.gFS != null) {
            getBaseFragmentActivity().getLayoutMode().onModeChanged(this.gFS);
        }
        super.onChangeSkinType(i);
    }

    public void xV(String str) {
        this.gFZ = str;
    }

    public void dl(String str, String str2) {
        this.gFX = a.C0268a.xZ(str);
        this.gFX.ya(str2);
    }

    public void lT(boolean z) {
        this.gFB = z;
    }

    public void lU(boolean z) {
        this.gFC = z;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public BaseAdapter getAdapter() {
        if (this.gFO == null) {
            return null;
        }
        return this.gFO.gED;
    }

    public l getPlaySwitchController() {
        return this.gEY;
    }
}
