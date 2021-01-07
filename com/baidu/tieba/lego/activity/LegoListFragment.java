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
import com.baidu.tieba.recapp.r;
import com.squareup.wire.Message;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tbclient.Lego.DataRes;
/* loaded from: classes9.dex */
public class LegoListFragment extends BaseFragment {
    public static Set<String> kXu;
    private ImageView bEE;
    private String from;
    private NoNetworkView gXw;
    private boolean hasAnimation;
    private String itemId;
    private a jJI;
    private e kVV;
    private long kVZ;
    private j kWR;
    private boolean kWT;
    private c kWZ;
    private g kWn;
    private n kWr;
    private LinearLayout kXe;
    private LegoListView kXf;
    private com.baidu.tieba.lego.c.c kXg;
    private com.baidu.tieba.lego.model.a kXh;
    private RelativeLayout kXj;
    private ImageView kXk;
    private TbImageView kXl;
    private TbImageView kXm;
    private a.C0790a kXn;
    private int kXo;
    private String kXp;
    private float kXq;
    private Rect rect;
    private h refreshView;
    private int screenWidth;
    private boolean kXi = false;
    private boolean kWi = false;
    private int gAO = -1;
    private int jhq = -1;
    private boolean jia = false;
    private int kXr = 0;
    private View kXs = null;
    private k kXt = null;
    private m kXv = new m() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.1
        @Override // com.baidu.tieba.lego.card.view.m
        public void nn(String str) {
            if (LegoListFragment.this.kWr != null) {
                LegoListFragment.this.kWr.Oc(str);
            }
        }
    };
    private d kXw = new d() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.7
        @Override // com.baidu.tieba.lego.d
        public void c(int i, long j, String str, String str2) {
            LegoListFragment.this.kXh.a(2, j, str, i, str2);
        }

        @Override // com.baidu.tieba.lego.d
        public void o(long j, String str) {
            LegoListFragment.this.kXh.v(j, str);
        }
    };
    private View.OnLayoutChangeListener kXx = new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.8
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            LegoListFragment.this.kWZ.Fo(LegoListFragment.this.ddi());
            if (!LegoListFragment.this.isFullScreen()) {
                LegoListFragment.this.kWZ.dei();
            }
        }
    };
    private View.OnTouchListener bTP = new View.OnTouchListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (LegoListFragment.this.kWZ.dek()) {
                if (LegoListFragment.this.kXf != null && view == LegoListFragment.this.kXf.getListView() && LegoListFragment.this.jJI != null) {
                    LegoListFragment.this.jJI.onTouchEvent(motionEvent);
                }
                return false;
            }
            return true;
        }
    };
    private a.InterfaceC0727a iEb = new a.InterfaceC0727a() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.10
        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void G(int i, int i2) {
            LegoListFragment.this.jia = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void H(int i, int i2) {
            LegoListFragment.this.jia = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void cj(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void I(int i, int i2) {
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11
        private int fPD = 0;
        private int kXz = 0;
        private boolean kXA = false;
        private int kXB = -1;
        private int kXC = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            View findFocus;
            LegoListFragment.this.kXr = i;
            if (1 == i && LegoListFragment.this.kXs != null && (findFocus = LegoListFragment.this.kXs.findFocus()) != null) {
                findFocus.clearFocus();
            }
            if (i == 0) {
                LegoListFragment.this.aa(1, LegoListFragment.this.jia);
                if (this.kXA) {
                    LegoListFragment.this.kWZ.Fm(com.baidu.tieba.lego.card.c.c.kYH);
                    LegoListFragment.this.kXf.getListView().setSelectionFromTop(this.kXB, this.kXC);
                    LegoListFragment.this.kWZ.dei();
                    LegoListFragment.this.kXf.getListView().post(new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LegoListFragment.this.aa(1, LegoListFragment.this.jia);
                            AnonymousClass11.this.kXA = false;
                        }
                    });
                }
            }
            if (LegoListFragment.this.kXt != null) {
                LegoListFragment.this.kXt.onScrollStateChanged(absListView, i);
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
            if (LegoListFragment.this.kWZ.dek() && LegoListFragment.this.kXf != null && LegoListFragment.this.kXf.getListView() != null && LegoListFragment.this.kXf.getListView().getChildAt(0) != null) {
                LegoListFragment.this.kWZ.dei();
                boolean z2 = true;
                if (i == this.fPD && LegoListFragment.this.jia) {
                    z2 = false;
                }
                boolean z3 = ((i + i2) + (-1) != this.kXz || LegoListFragment.this.jia) ? z2 : false;
                boolean z4 = false;
                if (this.kXz < (i + i2) - 1) {
                    z4 = false;
                    z = true;
                } else if (this.fPD > i) {
                    z4 = true;
                    z = true;
                } else {
                    z = false;
                }
                if (z && !this.kXA) {
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
                                this.kXA = true;
                                this.kXB = (i + i2) - 1;
                                this.kXC = 0;
                                com.baidu.tieba.lego.card.c.c.kYH = i7;
                                LegoListFragment.this.kXf.getListView().post(new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        LegoListFragment.this.kXf.getListView().smoothScrollToPositionFromTop(AnonymousClass11.this.kXB, AnonymousClass11.this.kXC, 400);
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
                                this.kXA = true;
                                if (ratio > 2.67d) {
                                    this.kXB = i + 1;
                                    this.kXC = (int) ((l.getScreenSize(LegoListFragment.this.getActivity()).widthPixels * 1.78d) + 0.5d);
                                } else {
                                    this.kXB = i12;
                                    this.kXC = 0;
                                }
                                com.baidu.tieba.lego.card.c.c.kYH = i4;
                                LegoListFragment.this.kXf.getListView().post(new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.11.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        LegoListFragment.this.kXf.getListView().smoothScrollToPositionFromTop(AnonymousClass11.this.kXB, AnonymousClass11.this.kXC, 400);
                                    }
                                });
                            }
                        }
                    }
                }
                this.fPD = i;
                this.kXz = (i + i2) - 1;
                if (this.kXC > 0) {
                    this.kXz--;
                }
                LegoListFragment.this.jhq = i;
                LegoListFragment.this.gAO = (i + i2) - 1;
                if (z3) {
                    LegoListFragment.this.aa(2, LegoListFragment.this.jia);
                }
            }
        }
    };
    private Runnable kqn = new Runnable() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.12
        @Override // java.lang.Runnable
        public void run() {
            if (LegoListFragment.this.kWr != null) {
                LegoListFragment.this.kWr.dex();
            }
        }
    };

    public static void ddg() {
        if (kXu == null) {
            kXu = new HashSet();
        } else {
            kXu.clear();
        }
    }

    public int ddh() {
        return this.kXr;
    }

    public void b(j jVar) {
        this.kWR = jVar;
    }

    public void a(c cVar) {
        this.kWZ = cVar;
        this.kWZ.a(this.kXv);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null && this.kXj != null) {
            if (configuration.orientation == 2) {
                this.kXj.setVisibility(8);
            } else if (this.kWT) {
                this.kXj.setVisibility(0);
            } else {
                this.kXj.setVisibility(8);
            }
        }
    }

    public void hb(long j) {
        this.kVZ = j;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    public void setImmersive(boolean z) {
        this.kWi = z;
    }

    public boolean isFullScreen() {
        return !this.kWZ.dek();
    }

    public int ddi() {
        int[] iArr = new int[2];
        this.kXf.getLocationOnScreen(iArr);
        return iArr[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(int i, boolean z) {
        if (this.kWr != null && this.kXf != null && this.kXf.getListView() != null && this.kXf.kVW != null && this.kXf.kVW.getCount() != 0) {
            this.kWr.a(this.jhq, this.gAO, z, i);
        }
    }

    public void a(k kVar) {
        this.kXt = kVar;
    }

    public void b(RelativeLayout relativeLayout) {
        this.kXj = relativeLayout;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.screenWidth = l.getEquipmentWidth(getActivity());
        FrameLayout frameLayout = new FrameLayout(getActivity());
        this.kXe = new LinearLayout(getActivity());
        this.kXe.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.kXe.setOrientation(1);
        this.gXw = new NoNetworkView(getActivity());
        if (!this.kWT) {
            this.kXe.addView(this.gXw);
            if (l.isNetOk()) {
                this.gXw.setVisibility(8);
            } else {
                this.gXw.setVisibility(0);
            }
        }
        this.kXf = a(this.kXw);
        this.kXf.setDrawingCacheEnabled(false);
        this.kVV = new e();
        this.kVV.lcg = this.kVZ;
        this.kVV.itemId = this.itemId;
        this.kXg = new com.baidu.tieba.lego.c.c(this.kVV);
        this.kXf.a(this.kXg, true);
        this.kXe.addView(this.kXf);
        this.kXf.getListView().setOnScrollListener(this.mOnScrollListener);
        this.kXf.getListView().addOnLayoutChangeListener(this.kXx);
        this.kXf.getListView().setOnTouchListener(this.bTP);
        this.jJI = new com.baidu.tieba.f.a();
        this.jJI.a(this.iEb);
        this.kWr = this.kXf.getPlaySwitchController();
        frameLayout.addView(this.kXe, new FrameLayout.LayoutParams(-1, -1));
        if (this.kWT) {
            this.kXj.setVisibility(0);
            this.kXk = (ImageView) this.kXj.findViewById(R.id.btn_share);
            l.addToParentArea(getActivity(), this.kXk, 20, 20, 20, 20);
            this.kXk.setVisibility(8);
            this.bEE = (ImageView) this.kXj.findViewById(R.id.btn_close);
            l.addToParentArea(getActivity(), this.bEE, 20, 20, 20, 20);
            this.bEE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LegoListFragment.this.endAnimation();
                }
            });
            getBaseFragmentActivity().setSwipeBackEnabled(false);
            if (this.hasAnimation && this.kXn != null && this.kXn.isValid()) {
                frameLayout.setBackgroundColor(getActivity().getResources().getColor(R.color.black_alpha100));
                this.kXo = l.getStatusBarHeight(getActivity());
                this.rect = this.kXn.rect;
                this.rect.top -= this.kXo;
                this.rect.bottom -= this.kXo;
                this.kXl = new TbImageView(getActivity());
                this.kXl.setScaleType(ImageView.ScaleType.FIT_XY);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.rect.right - this.rect.left, this.rect.bottom - this.rect.top);
                layoutParams.setMargins(this.rect.left, this.rect.top, 0, 0);
                this.kXl.setLayoutParams(layoutParams);
                this.kXl.startLoad(this.kXn.picUrl, 17, false);
                frameLayout.addView(this.kXl, layoutParams);
                if (this.kXn.ddr()) {
                    Rect rect = this.kXn.kXS;
                    this.kXq = l.getDimens(getActivity(), R.dimen.ds10);
                    this.kXm = new TbImageView(getActivity());
                    this.kXm.setScaleType(ImageView.ScaleType.FIT_XY);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.screenWidth, (int) (this.screenWidth * (((rect.bottom - rect.top) * 1.0d) / (rect.right - rect.left))));
                    layoutParams2.setMargins(0, (int) (((this.screenWidth / (this.rect.right - this.rect.left)) * (this.rect.bottom - this.rect.top)) + this.kXq), 0, 0);
                    this.kXm.setLayoutParams(layoutParams2);
                    this.kXm.startLoad(this.kXn.kXR, 17, false);
                    frameLayout.addView(this.kXm, layoutParams2);
                    this.kXm.setVisibility(8);
                }
                e(this.rect);
                this.kXe.setVisibility(8);
            }
            r.dEW().dES().f(this.kVZ, this.itemId, this.from);
        } else if (this.kXj != null) {
            this.kXj.setVisibility(8);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.kXs = activity.getWindow().getDecorView();
        }
        return frameLayout;
    }

    private void e(Rect rect) {
        float f = this.screenWidth / (rect.right - rect.left);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.kXl, "scaleX", 1.0f, f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.kXl, "scaleY", 1.0f, f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.kXl, "translationX", -rect.left);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.kXl, "translationY", -rect.top);
        this.kXl.setPivotX(0.0f);
        this.kXl.setPivotY(0.0f);
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.14
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LegoListFragment.this.kXe.setVisibility(8);
                LegoListFragment.this.kXl.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (LegoListFragment.this.kXn.ddr()) {
                    LegoListFragment.this.kXe.setVisibility(8);
                    LegoListFragment.this.ddj();
                    return;
                }
                LegoListFragment.this.kXe.setVisibility(0);
                LegoListFragment.this.kXl.setVisibility(8);
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
    public void ddj() {
        this.kXm.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.kXm, "translationY", -this.kXq);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.kXm, "alpha", 0.0f, 1.0f);
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LegoListFragment.this.kXe.setVisibility(8);
                LegoListFragment.this.kXl.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LegoListFragment.this.kXm.setVisibility(8);
                LegoListFragment.this.kXl.setVisibility(8);
                LegoListFragment.this.kXe.setVisibility(0);
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
        if (this.kXm == null) {
            getActivity().finish();
            return;
        }
        this.kXl.startLoad(this.kXn.picUrl, 17, false);
        float f = this.rect.top - this.kXo;
        float f2 = this.screenWidth / (this.rect.right - this.rect.left);
        AnimationSet animationSet = new AnimationSet(false);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, this.rect.left, 0.0f, f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f / f2, 1.0f, 1.0f / f2);
        this.kXl.setPivotX(0.5f);
        this.kXl.setPivotY(0.5f);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(200L);
        this.kXl.startAnimation(animationSet);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                LegoListFragment.this.kXe.setVisibility(8);
                if (LegoListFragment.this.kXn.ddr()) {
                    LegoListFragment.this.kXm.setVisibility(8);
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
        LegoListView legoListView = new LegoListView(getPageContext().getPageActivity(), this.kWi);
        legoListView.kVW.setFrom(this.from);
        if (this.kWT) {
            legoListView.setFriction(ViewConfiguration.getScrollFriction() * 12.0f);
        }
        legoListView.l(getUniqueId());
        legoListView.setCallback(dVar);
        return legoListView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eK(List<com.baidu.tieba.lego.c.d> list) {
        if (this.kXk != null) {
            if (x.isEmpty(list)) {
                this.kXk.setVisibility(8);
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).type == 2) {
                    final com.baidu.tieba.lego.c.d dVar = list.get(i);
                    if (!TextUtils.isEmpty(list.get(i).scheme)) {
                        this.kXk.setVisibility(0);
                        this.kXk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (LegoListFragment.this.mIsLogin) {
                                    if (LegoListFragment.this.kWR != null) {
                                        LegoListFragment.this.kWR.a(dVar);
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
        if (!TextUtils.isEmpty(this.kXp)) {
            this.kXg.Of(this.kXp);
            if (this.kXg.deJ()) {
                eK(this.kXg.deI());
                this.kXf.a(this.kXg, true);
                return;
            }
        }
        if (isAdded() && isPrimary() && !this.kXi) {
            ddk();
        }
    }

    private void ddk() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            b(getView(), false, getResources().getDimensionPixelSize(R.dimen.ds360));
        }
        this.kXf.setViewForeground();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initModel();
    }

    private void initModel() {
        this.kXh = b.deN().b(getPageContext(), getUniqueId());
        this.kXh.a(new com.baidu.tieba.lego.model.b() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.5
            @Override // com.baidu.tieba.lego.model.b
            public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
                if (z) {
                    LegoListFragment.this.ds(LegoListFragment.this.getView());
                }
                DataRes dataRes = (DataRes) message;
                if (!z || (dataRes != null && dataRes.cards != null)) {
                    LegoListFragment.this.kXi = true;
                    LegoListFragment.this.kXg.a(z, dataRes, z2, i);
                    if (TextUtils.isEmpty(LegoListFragment.this.kXg.deG()) || TextUtils.isEmpty(LegoListFragment.this.kXg.deH())) {
                        if (LegoListFragment.this.kWR != null) {
                            LegoListFragment.this.kWR.Le(LegoListFragment.this.kXg.getTitle());
                        }
                    } else if (LegoListFragment.this.kWR != null) {
                        LegoListFragment.this.kWR.fH(LegoListFragment.this.kXg.deG(), LegoListFragment.this.kXg.deH());
                    }
                    if (LegoListFragment.this.kWR != null) {
                        LegoListFragment.this.kWR.eI(LegoListFragment.this.kXg.deI());
                    }
                    LegoListFragment.this.kXf.a(LegoListFragment.this.kXg, false);
                    if (LegoListFragment.this.kWi && LegoListFragment.this.kWT) {
                        LegoListFragment.this.eK(LegoListFragment.this.kXg.deI());
                    }
                } else if (LegoListFragment.this.getPageContext() != null && LegoListFragment.this.getPageContext().getResources() != null) {
                    LegoListFragment.this.showNetRefreshView(LegoListFragment.this.getView(), LegoListFragment.this.getPageContext().getResources().getString(R.string.neterror), false);
                }
            }

            @Override // com.baidu.tieba.lego.model.b
            public void a(long j, String str, String str2, int i) {
                LegoListFragment.this.ds(LegoListFragment.this.getView());
                if (LegoListFragment.this.kXg.hasData()) {
                    LegoListFragment.this.kXf.a(LegoListFragment.this.kXg, false);
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
        if (this.kWn == null) {
            if (i < 0) {
                this.kWn = new g(getActivity());
            } else {
                this.kWn = new g(getActivity(), i);
            }
            this.kWn.onChangeSkinType();
        }
        this.kWn.attachView(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ds(View view) {
        if (this.kWn != null) {
            this.kWn.dettachView(view);
            this.kWn = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getPageContext().getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoListFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (LegoListFragment.this.kXh != null) {
                        LegoListFragment.this.kXh.a(2, LegoListFragment.this.kVV.lcg, LegoListFragment.this.kVV.itemId, 1, "");
                        LegoListFragment.this.Zj();
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
    public void Zj() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(getView());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.kXf.setViewBackGround();
        if (this.kWr != null) {
            this.kWr.tE(false);
            this.kWr.dew();
        }
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kqn);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.kXf.setViewForeground();
        if (this.kWr != null) {
            this.kWr.tE(true);
            com.baidu.adp.lib.f.e.mB().postDelayed(this.kqn, 200L);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.kXf.onDestory();
        if (this.kWr != null) {
            this.kWr.destroy();
        }
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kqn);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gXw != null) {
            this.gXw.onChangeSkinType(com.baidu.adp.base.j.K(getActivity()), i);
        }
        if (this.kXj != null) {
            getBaseFragmentActivity().getLayoutMode().onModeChanged(this.kXj);
        }
        super.onChangeSkinType(i);
    }

    public void NU(String str) {
        this.kXp = str;
    }

    public void fJ(String str, String str2) {
        this.kXn = a.C0790a.NX(str);
        this.kXn.NY(str2);
    }

    public void tt(boolean z) {
        this.hasAnimation = z;
    }

    public void tu(boolean z) {
        this.kWT = z;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public BaseAdapter getAdapter() {
        if (this.kXf == null) {
            return null;
        }
        return this.kXf.kVW;
    }

    public n getPlaySwitchController() {
        return this.kWr;
    }
}
