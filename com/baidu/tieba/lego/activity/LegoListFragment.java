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
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
import com.baidu.tieba.lego.LegoListView;
import com.baidu.tieba.lego.c.c;
import com.baidu.tieba.lego.c.e;
import com.baidu.tieba.lego.card.a.a;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.view.m;
import com.baidu.tieba.lego.card.view.n;
import com.baidu.tieba.lego.d;
import com.baidu.tieba.lego.d.b;
import com.baidu.tieba.lego.j;
import com.baidu.tieba.lego.k;
import com.baidu.tieba.recapp.r;
import com.squareup.wire.Message;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tbclient.Lego.DataRes;
/* loaded from: classes8.dex */
public class LegoListFragment extends BaseFragment {
    public static Set<String> kSP;
    private ImageView bzS;
    private String from;
    private NoNetworkView gSQ;
    private boolean hasAnimation;
    private String itemId;
    private a jFc;
    private g kRI;
    private n kRM;
    private e kRq;
    private long kRu;
    private LegoListView kSA;
    private c kSB;
    private com.baidu.tieba.lego.model.a kSC;
    private RelativeLayout kSE;
    private ImageView kSF;
    private TbImageView kSG;
    private TbImageView kSH;
    private a.C0773a kSI;
    private int kSJ;
    private String kSK;
    private float kSL;
    private j kSm;
    private boolean kSo;
    private com.baidu.tieba.lego.card.view.c kSu;
    private LinearLayout kSz;
    private Rect rect;
    private h refreshView;
    private int screenWidth;
    private boolean kSD = false;
    private boolean kRD = false;
    private int gwh = -1;
    private int jcJ = -1;
    private boolean jdt = false;
    private int kSM = 0;
    private View kSN = null;
    private k kSO = null;
    private m kSQ = new m() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.1
        @Override // com.baidu.tieba.lego.card.view.m
        public void mc(String str) {
            if (LegoListFragment.this.kRM != null) {
                LegoListFragment.this.kRM.MU(str);
            }
        }
    };
    private d kSR = new d() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.7
        @Override // com.baidu.tieba.lego.d
        public void c(int i, long j, String str, String str2) {
            LegoListFragment.this.kSC.a(2, j, str, i, str2);
        }

        @Override // com.baidu.tieba.lego.d
        public void o(long j, String str) {
            LegoListFragment.this.kSC.v(j, str);
        }
    };
    private View.OnLayoutChangeListener kSS = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.8
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            LegoListFragment.this.kSu.DI(LegoListFragment.this.cZq());
            if (!LegoListFragment.this.isFullScreen()) {
                LegoListFragment.this.kSu.daq();
            }
        }
    };
    private View.OnTouchListener bPd = new View.OnTouchListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (LegoListFragment.this.kSu.das()) {
                if (LegoListFragment.this.kSA != null && view == LegoListFragment.this.kSA.getListView() && LegoListFragment.this.jFc != null) {
                    LegoListFragment.this.jFc.onTouchEvent(motionEvent);
                }
                return false;
            }
            return true;
        }
    };
    private a.InterfaceC0710a izu = new a.InterfaceC0710a() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.10
        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void G(int i, int i2) {
            LegoListFragment.this.jdt = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void H(int i, int i2) {
            LegoListFragment.this.jdt = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void cj(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void I(int i, int i2) {
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11
        private int fKW = 0;
        private int kSU = 0;
        private boolean kSV = false;
        private int kSW = -1;
        private int kSX = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            View findFocus;
            LegoListFragment.this.kSM = i;
            if (1 == i && LegoListFragment.this.kSN != null && (findFocus = LegoListFragment.this.kSN.findFocus()) != null) {
                findFocus.clearFocus();
            }
            if (i == 0) {
                LegoListFragment.this.aa(1, LegoListFragment.this.jdt);
                if (this.kSV) {
                    LegoListFragment.this.kSu.DG(com.baidu.tieba.lego.card.c.c.kUc);
                    LegoListFragment.this.kSA.getListView().setSelectionFromTop(this.kSW, this.kSX);
                    LegoListFragment.this.kSu.daq();
                    LegoListFragment.this.kSA.getListView().post(new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LegoListFragment.this.aa(1, LegoListFragment.this.jdt);
                            AnonymousClass11.this.kSV = false;
                        }
                    });
                }
            }
            if (LegoListFragment.this.kSO != null) {
                LegoListFragment.this.kSO.onScrollStateChanged(absListView, i);
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
            if (LegoListFragment.this.kSu.das() && LegoListFragment.this.kSA != null && LegoListFragment.this.kSA.getListView() != null && LegoListFragment.this.kSA.getListView().getChildAt(0) != null) {
                LegoListFragment.this.kSu.daq();
                boolean z2 = true;
                if (i == this.fKW && LegoListFragment.this.jdt) {
                    z2 = false;
                }
                boolean z3 = ((i + i2) + (-1) != this.kSU || LegoListFragment.this.jdt) ? z2 : false;
                boolean z4 = false;
                if (this.kSU < (i + i2) - 1) {
                    z4 = false;
                    z = true;
                } else if (this.fKW > i) {
                    z4 = true;
                    z = true;
                } else {
                    z = false;
                }
                if (z && !this.kSV) {
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
                                this.kSV = true;
                                this.kSW = (i + i2) - 1;
                                this.kSX = 0;
                                com.baidu.tieba.lego.card.c.c.kUc = i7;
                                LegoListFragment.this.kSA.getListView().post(new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        LegoListFragment.this.kSA.getListView().smoothScrollToPositionFromTop(AnonymousClass11.this.kSW, AnonymousClass11.this.kSX, 400);
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
                                this.kSV = true;
                                if (ratio > 2.67d) {
                                    this.kSW = i + 1;
                                    this.kSX = (int) ((l.getScreenSize(LegoListFragment.this.getActivity()).widthPixels * 1.78d) + 0.5d);
                                } else {
                                    this.kSW = i12;
                                    this.kSX = 0;
                                }
                                com.baidu.tieba.lego.card.c.c.kUc = i4;
                                LegoListFragment.this.kSA.getListView().post(new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        LegoListFragment.this.kSA.getListView().smoothScrollToPositionFromTop(AnonymousClass11.this.kSW, AnonymousClass11.this.kSX, 400);
                                    }
                                });
                            }
                        }
                    }
                }
                this.fKW = i;
                this.kSU = (i + i2) - 1;
                if (this.kSX > 0) {
                    this.kSU--;
                }
                LegoListFragment.this.jcJ = i;
                LegoListFragment.this.gwh = (i + i2) - 1;
                if (z3) {
                    LegoListFragment.this.aa(2, LegoListFragment.this.jdt);
                }
            }
        }
    };
    private Runnable klI = new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.12
        @Override // java.lang.Runnable
        public void run() {
            if (LegoListFragment.this.kRM != null) {
                LegoListFragment.this.kRM.daF();
            }
        }
    };

    public static void cZo() {
        if (kSP == null) {
            kSP = new HashSet();
        } else {
            kSP.clear();
        }
    }

    public int cZp() {
        return this.kSM;
    }

    public void b(j jVar) {
        this.kSm = jVar;
    }

    public void a(com.baidu.tieba.lego.card.view.c cVar) {
        this.kSu = cVar;
        this.kSu.a(this.kSQ);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null && this.kSE != null) {
            if (configuration.orientation == 2) {
                this.kSE.setVisibility(8);
            } else if (this.kSo) {
                this.kSE.setVisibility(0);
            } else {
                this.kSE.setVisibility(8);
            }
        }
    }

    public void hb(long j) {
        this.kRu = j;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    public void setImmersive(boolean z) {
        this.kRD = z;
    }

    public boolean isFullScreen() {
        return !this.kSu.das();
    }

    public int cZq() {
        int[] iArr = new int[2];
        this.kSA.getLocationOnScreen(iArr);
        return iArr[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(int i, boolean z) {
        if (this.kRM != null && this.kSA != null && this.kSA.getListView() != null && this.kSA.kRr != null && this.kSA.kRr.getCount() != 0) {
            this.kRM.a(this.jcJ, this.gwh, z, i);
        }
    }

    public void a(k kVar) {
        this.kSO = kVar;
    }

    public void b(RelativeLayout relativeLayout) {
        this.kSE = relativeLayout;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.screenWidth = l.getEquipmentWidth(getActivity());
        FrameLayout frameLayout = new FrameLayout(getActivity());
        this.kSz = new LinearLayout(getActivity());
        this.kSz.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.kSz.setOrientation(1);
        this.gSQ = new NoNetworkView(getActivity());
        if (!this.kSo) {
            this.kSz.addView(this.gSQ);
            if (l.isNetOk()) {
                this.gSQ.setVisibility(8);
            } else {
                this.gSQ.setVisibility(0);
            }
        }
        this.kSA = a(this.kSR);
        this.kSA.setDrawingCacheEnabled(false);
        this.kRq = new e();
        this.kRq.kXA = this.kRu;
        this.kRq.itemId = this.itemId;
        this.kSB = new c(this.kRq);
        this.kSA.a(this.kSB, true);
        this.kSz.addView(this.kSA);
        this.kSA.getListView().setOnScrollListener(this.mOnScrollListener);
        this.kSA.getListView().addOnLayoutChangeListener(this.kSS);
        this.kSA.getListView().setOnTouchListener(this.bPd);
        this.jFc = new com.baidu.tieba.f.a();
        this.jFc.a(this.izu);
        this.kRM = this.kSA.getPlaySwitchController();
        frameLayout.addView(this.kSz, new FrameLayout.LayoutParams(-1, -1));
        if (this.kSo) {
            this.kSE.setVisibility(0);
            this.kSF = (ImageView) this.kSE.findViewById(R.id.btn_share);
            l.addToParentArea(getActivity(), this.kSF, 20, 20, 20, 20);
            this.kSF.setVisibility(8);
            this.bzS = (ImageView) this.kSE.findViewById(R.id.btn_close);
            l.addToParentArea(getActivity(), this.bzS, 20, 20, 20, 20);
            this.bzS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LegoListFragment.this.endAnimation();
                }
            });
            getBaseFragmentActivity().setSwipeBackEnabled(false);
            if (this.hasAnimation && this.kSI != null && this.kSI.isValid()) {
                frameLayout.setBackgroundColor(getActivity().getResources().getColor(R.color.black_alpha100));
                this.kSJ = l.getStatusBarHeight(getActivity());
                this.rect = this.kSI.rect;
                this.rect.top -= this.kSJ;
                this.rect.bottom -= this.kSJ;
                this.kSG = new TbImageView(getActivity());
                this.kSG.setScaleType(ImageView.ScaleType.FIT_XY);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.rect.right - this.rect.left, this.rect.bottom - this.rect.top);
                layoutParams.setMargins(this.rect.left, this.rect.top, 0, 0);
                this.kSG.setLayoutParams(layoutParams);
                this.kSG.startLoad(this.kSI.picUrl, 17, false);
                frameLayout.addView(this.kSG, layoutParams);
                if (this.kSI.cZz()) {
                    Rect rect = this.kSI.kTn;
                    this.kSL = l.getDimens(getActivity(), R.dimen.ds10);
                    this.kSH = new TbImageView(getActivity());
                    this.kSH.setScaleType(ImageView.ScaleType.FIT_XY);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.screenWidth, (int) (this.screenWidth * (((rect.bottom - rect.top) * 1.0d) / (rect.right - rect.left))));
                    layoutParams2.setMargins(0, (int) (((this.screenWidth / (this.rect.right - this.rect.left)) * (this.rect.bottom - this.rect.top)) + this.kSL), 0, 0);
                    this.kSH.setLayoutParams(layoutParams2);
                    this.kSH.startLoad(this.kSI.kTm, 17, false);
                    frameLayout.addView(this.kSH, layoutParams2);
                    this.kSH.setVisibility(8);
                }
                e(this.rect);
                this.kSz.setVisibility(8);
            }
            r.dBe().dBa().f(this.kRu, this.itemId, this.from);
        } else if (this.kSE != null) {
            this.kSE.setVisibility(8);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.kSN = activity.getWindow().getDecorView();
        }
        return frameLayout;
    }

    private void e(Rect rect) {
        float f = this.screenWidth / (rect.right - rect.left);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.kSG, "scaleX", 1.0f, f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.kSG, "scaleY", 1.0f, f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.kSG, "translationX", -rect.left);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.kSG, "translationY", -rect.top);
        this.kSG.setPivotX(0.0f);
        this.kSG.setPivotY(0.0f);
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.14
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LegoListFragment.this.kSz.setVisibility(8);
                LegoListFragment.this.kSG.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (LegoListFragment.this.kSI.cZz()) {
                    LegoListFragment.this.kSz.setVisibility(8);
                    LegoListFragment.this.cZr();
                    return;
                }
                LegoListFragment.this.kSz.setVisibility(0);
                LegoListFragment.this.kSG.setVisibility(8);
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
    public void cZr() {
        this.kSH.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.kSH, "translationY", -this.kSL);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.kSH, "alpha", 0.0f, 1.0f);
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LegoListFragment.this.kSz.setVisibility(8);
                LegoListFragment.this.kSG.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LegoListFragment.this.kSH.setVisibility(8);
                LegoListFragment.this.kSG.setVisibility(8);
                LegoListFragment.this.kSz.setVisibility(0);
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
        if (this.kSH == null) {
            getActivity().finish();
            return;
        }
        this.kSG.startLoad(this.kSI.picUrl, 17, false);
        float f = this.rect.top - this.kSJ;
        float f2 = this.screenWidth / (this.rect.right - this.rect.left);
        AnimationSet animationSet = new AnimationSet(false);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, this.rect.left, 0.0f, f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f / f2, 1.0f, 1.0f / f2);
        this.kSG.setPivotX(0.5f);
        this.kSG.setPivotY(0.5f);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(200L);
        this.kSG.startAnimation(animationSet);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                LegoListFragment.this.kSz.setVisibility(8);
                if (LegoListFragment.this.kSI.cZz()) {
                    LegoListFragment.this.kSH.setVisibility(8);
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
        LegoListView legoListView = new LegoListView(getPageContext().getPageActivity(), this.kRD);
        legoListView.kRr.setFrom(this.from);
        if (this.kSo) {
            legoListView.setFriction(ViewConfiguration.getScrollFriction() * 12.0f);
        }
        legoListView.l(getUniqueId());
        legoListView.setCallback(dVar);
        return legoListView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eK(List<com.baidu.tieba.lego.c.d> list) {
        if (this.kSF != null) {
            if (x.isEmpty(list)) {
                this.kSF.setVisibility(8);
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).type == 2) {
                    final com.baidu.tieba.lego.c.d dVar = list.get(i);
                    if (!TextUtils.isEmpty(list.get(i).scheme)) {
                        this.kSF.setVisibility(0);
                        this.kSF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (LegoListFragment.this.mIsLogin) {
                                    if (LegoListFragment.this.kSm != null) {
                                        LegoListFragment.this.kSm.a(dVar);
                                        return;
                                    }
                                    return;
                                }
                                bg.skipToLoginActivity(LegoListFragment.this.getActivity());
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
        if (!TextUtils.isEmpty(this.kSK)) {
            this.kSB.MX(this.kSK);
            if (this.kSB.daR()) {
                eK(this.kSB.daQ());
                this.kSA.a(this.kSB, true);
                return;
            }
        }
        if (isAdded() && isPrimary() && !this.kSD) {
            cZs();
        }
    }

    private void cZs() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            b(getView(), false, getResources().getDimensionPixelSize(R.dimen.ds360));
        }
        this.kSA.setViewForeground();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initModel();
    }

    private void initModel() {
        this.kSC = b.daV().b(getPageContext(), getUniqueId());
        this.kSC.a(new com.baidu.tieba.lego.model.b() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.5
            @Override // com.baidu.tieba.lego.model.b
            public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
                if (z) {
                    LegoListFragment.this.ds(LegoListFragment.this.getView());
                }
                DataRes dataRes = (DataRes) message;
                if (!z || (dataRes != null && dataRes.cards != null)) {
                    LegoListFragment.this.kSD = true;
                    LegoListFragment.this.kSB.a(z, dataRes, z2, i);
                    if (TextUtils.isEmpty(LegoListFragment.this.kSB.daO()) || TextUtils.isEmpty(LegoListFragment.this.kSB.daP())) {
                        if (LegoListFragment.this.kSm != null) {
                            LegoListFragment.this.kSm.JU(LegoListFragment.this.kSB.getTitle());
                        }
                    } else if (LegoListFragment.this.kSm != null) {
                        LegoListFragment.this.kSm.fG(LegoListFragment.this.kSB.daO(), LegoListFragment.this.kSB.daP());
                    }
                    if (LegoListFragment.this.kSm != null) {
                        LegoListFragment.this.kSm.eI(LegoListFragment.this.kSB.daQ());
                    }
                    LegoListFragment.this.kSA.a(LegoListFragment.this.kSB, false);
                    if (LegoListFragment.this.kRD && LegoListFragment.this.kSo) {
                        LegoListFragment.this.eK(LegoListFragment.this.kSB.daQ());
                    }
                } else if (LegoListFragment.this.getPageContext() != null && LegoListFragment.this.getPageContext().getResources() != null) {
                    LegoListFragment.this.showNetRefreshView(LegoListFragment.this.getView(), LegoListFragment.this.getPageContext().getResources().getString(R.string.neterror), false);
                }
            }

            @Override // com.baidu.tieba.lego.model.b
            public void a(long j, String str, String str2, int i) {
                LegoListFragment.this.ds(LegoListFragment.this.getView());
                if (LegoListFragment.this.kSB.hasData()) {
                    LegoListFragment.this.kSA.a(LegoListFragment.this.kSB, false);
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
        if (this.kRI == null) {
            if (i < 0) {
                this.kRI = new g(getActivity());
            } else {
                this.kRI = new g(getActivity(), i);
            }
            this.kRI.onChangeSkinType();
        }
        this.kRI.attachView(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ds(View view) {
        if (this.kRI != null) {
            this.kRI.dettachView(view);
            this.kRI = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getPageContext().getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (LegoListFragment.this.kSC != null) {
                        LegoListFragment.this.kSC.a(2, LegoListFragment.this.kRq.kXA, LegoListFragment.this.kRq.itemId, 1, "");
                        LegoListFragment.this.Vq();
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
    public void Vq() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(getView());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.kSA.setViewBackGround();
        if (this.kRM != null) {
            this.kRM.tA(false);
            this.kRM.daE();
        }
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.klI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.kSA.setViewForeground();
        if (this.kRM != null) {
            this.kRM.tA(true);
            com.baidu.adp.lib.f.e.mB().postDelayed(this.klI, 200L);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.kSA.onDestory();
        if (this.kRM != null) {
            this.kRM.destroy();
        }
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.klI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gSQ != null) {
            this.gSQ.onChangeSkinType(com.baidu.adp.base.j.K(getActivity()), i);
        }
        if (this.kSE != null) {
            getBaseFragmentActivity().getLayoutMode().onModeChanged(this.kSE);
        }
        super.onChangeSkinType(i);
    }

    public void MM(String str) {
        this.kSK = str;
    }

    public void fI(String str, String str2) {
        this.kSI = a.C0773a.MP(str);
        this.kSI.MQ(str2);
    }

    public void tp(boolean z) {
        this.hasAnimation = z;
    }

    public void tq(boolean z) {
        this.kSo = z;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public BaseAdapter getAdapter() {
        if (this.kSA == null) {
            return null;
        }
        return this.kSA.kRr;
    }

    public n getPlaySwitchController() {
        return this.kRM;
    }
}
