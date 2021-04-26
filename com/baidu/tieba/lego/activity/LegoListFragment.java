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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.LegoListView;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.squareup.wire.Message;
import d.a.j0.f0.a;
import d.a.j0.s2.w;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tbclient.Lego.DataRes;
/* loaded from: classes4.dex */
public class LegoListFragment extends BaseFragment {
    public static Set<String> V;
    public int A;
    public int B;
    public boolean D;
    public boolean E;
    public String F;
    public String G;
    public float H;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f18602e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f18603f;

    /* renamed from: g  reason: collision with root package name */
    public LegoListView f18604g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.j1.o.l.c f18605h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.j0.j1.o.l.n f18606i;
    public d.a.j0.f0.a j;
    public long k;
    public String l;
    public d.a.j0.j1.p.e m;
    public d.a.j0.j1.p.c n;
    public d.a.j0.j1.s.a o;
    public d.a.i0.d0.h p;
    public d.a.i0.d0.g q;
    public d.a.j0.j1.j s;
    public RelativeLayout t;
    public ImageView u;
    public ImageView v;
    public TbImageView w;
    public TbImageView x;
    public d.a.j0.j1.o.h.a y;
    public Rect z;
    public boolean r = false;
    public boolean C = false;
    public int I = -1;
    public int J = -1;
    public boolean K = false;
    public int L = 0;
    public View M = null;
    public d.a.j0.j1.k N = null;
    public d.a.j0.j1.o.l.m O = new f();
    public d.a.j0.j1.d P = new g();
    public View.OnLayoutChangeListener Q = new h();
    public View.OnTouchListener R = new i();
    public a.b S = new j();
    public AbsListView.OnScrollListener T = new k();
    public Runnable U = new l();

    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            LegoListFragment.this.x.setVisibility(8);
            LegoListFragment.this.w.setVisibility(8);
            LegoListFragment.this.f18602e.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            LegoListFragment.this.f18602e.setVisibility(8);
            LegoListFragment.this.w.setVisibility(0);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            LegoListFragment.this.getActivity().finish();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            LegoListFragment.this.f18602e.setVisibility(8);
            if (LegoListFragment.this.y.b()) {
                LegoListFragment.this.x.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.j1.p.d f18609e;

        public c(d.a.j0.j1.p.d dVar) {
            this.f18609e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LegoListFragment.this.mIsLogin) {
                if (LegoListFragment.this.s != null) {
                    LegoListFragment.this.s.h(this.f18609e);
                    return;
                }
                return;
            }
            ViewHelper.skipToLoginActivity(LegoListFragment.this.getActivity());
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.a.j0.j1.s.b {
        public d() {
        }

        @Override // d.a.j0.j1.s.b
        public void a(boolean z, Message message, boolean z2, long j, String str, int i2) {
            if (z) {
                LegoListFragment legoListFragment = LegoListFragment.this;
                legoListFragment.o1(legoListFragment.getView());
            }
            DataRes dataRes = (DataRes) message;
            if (!z || (dataRes != null && dataRes.cards != null)) {
                LegoListFragment.this.r = true;
                LegoListFragment.this.n.d(z, dataRes, z2, i2);
                if (TextUtils.isEmpty(LegoListFragment.this.n.k()) || TextUtils.isEmpty(LegoListFragment.this.n.l())) {
                    if (LegoListFragment.this.s != null) {
                        LegoListFragment.this.s.i(LegoListFragment.this.n.j());
                    }
                } else if (LegoListFragment.this.s != null) {
                    LegoListFragment.this.s.j(LegoListFragment.this.n.k(), LegoListFragment.this.n.l());
                }
                if (LegoListFragment.this.s != null) {
                    LegoListFragment.this.s.g(LegoListFragment.this.n.f());
                }
                LegoListFragment.this.f18604g.u(LegoListFragment.this.n, false);
                if (LegoListFragment.this.C && LegoListFragment.this.E) {
                    LegoListFragment legoListFragment2 = LegoListFragment.this;
                    legoListFragment2.h1(legoListFragment2.n.f());
                }
            } else if (LegoListFragment.this.getPageContext() == null || LegoListFragment.this.getPageContext().getResources() == null) {
            } else {
                LegoListFragment legoListFragment3 = LegoListFragment.this;
                legoListFragment3.showNetRefreshView(legoListFragment3.getView(), LegoListFragment.this.getPageContext().getResources().getString(R.string.neterror), false);
            }
        }

        @Override // d.a.j0.j1.s.b
        public void b(long j, String str, String str2, int i2) {
            LegoListFragment legoListFragment = LegoListFragment.this;
            legoListFragment.o1(legoListFragment.getView());
            if (LegoListFragment.this.n.b()) {
                LegoListFragment.this.f18604g.u(LegoListFragment.this.n, false);
            } else if (LegoListFragment.this.getPageContext() == null || LegoListFragment.this.getPageContext().getResources() == null) {
            } else {
                LegoListFragment legoListFragment2 = LegoListFragment.this;
                legoListFragment2.showNetRefreshView(legoListFragment2.getView(), LegoListFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str2, Integer.valueOf(i2)), false);
            }
        }

        @Override // d.a.j0.j1.s.b
        public void c(long j, String str, Message message, boolean z) {
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LegoListFragment.this.o != null) {
                LegoListFragment.this.o.c(2, LegoListFragment.this.m.f55871a, LegoListFragment.this.m.f55872b, 1, "");
                LegoListFragment.this.p1();
                LegoListFragment legoListFragment = LegoListFragment.this;
                legoListFragment.F1(legoListFragment.getView(), false, LegoListFragment.this.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.j0.j1.o.l.m {
        public f() {
        }

        @Override // d.a.j0.j1.o.l.m
        public void a(String str) {
            if (LegoListFragment.this.f18606i != null) {
                LegoListFragment.this.f18606i.l(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d.a.j0.j1.d {
        public g() {
        }

        @Override // d.a.j0.j1.d
        public void a(int i2, long j, String str, String str2) {
            LegoListFragment.this.o.c(2, j, str, i2, str2);
        }

        @Override // d.a.j0.j1.d
        public void b(long j, String str) {
            LegoListFragment.this.o.a(j, str);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnLayoutChangeListener {
        public h() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            LegoListFragment.this.f18605h.u0(LegoListFragment.this.m1());
            if (LegoListFragment.this.C()) {
                return;
            }
            LegoListFragment.this.f18605h.Q();
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnTouchListener {
        public i() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (LegoListFragment.this.f18605h.e0()) {
                if (LegoListFragment.this.f18604g == null || view != LegoListFragment.this.f18604g.getListView() || LegoListFragment.this.j == null) {
                    return false;
                }
                LegoListFragment.this.j.c(motionEvent);
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class j implements a.b {
        public j() {
        }

        @Override // d.a.j0.f0.a.b
        public void a(int i2, int i3) {
            LegoListFragment.this.K = false;
        }

        @Override // d.a.j0.f0.a.b
        public void b(int i2, int i3) {
            LegoListFragment.this.K = true;
        }

        @Override // d.a.j0.f0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.j0.f0.a.b
        public void d(int i2, int i3) {
        }
    }

    /* loaded from: classes4.dex */
    public class k implements AbsListView.OnScrollListener {

        /* renamed from: e  reason: collision with root package name */
        public int f18618e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f18619f = 0;

        /* renamed from: g  reason: collision with root package name */
        public boolean f18620g = false;

        /* renamed from: h  reason: collision with root package name */
        public int f18621h = -1;

        /* renamed from: i  reason: collision with root package name */
        public int f18622i = 0;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LegoListFragment legoListFragment = LegoListFragment.this;
                legoListFragment.t1(1, legoListFragment.K);
                k.this.f18620g = false;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LegoListFragment.this.f18604g.getListView().smoothScrollToPositionFromTop(k.this.f18621h, k.this.f18622i, 400);
            }
        }

        /* loaded from: classes4.dex */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LegoListFragment.this.f18604g.getListView().smoothScrollToPositionFromTop(k.this.f18621h, k.this.f18622i, 400);
            }
        }

        public k() {
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00c9  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0168  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0178  */
        /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
        @Override // android.widget.AbsListView.OnScrollListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            boolean z;
            boolean z2;
            if (!LegoListFragment.this.f18605h.e0() || LegoListFragment.this.f18604g == null || LegoListFragment.this.f18604g.getListView() == null || LegoListFragment.this.f18604g.getListView().getChildAt(0) == null) {
                return;
            }
            LegoListFragment.this.f18605h.Q();
            boolean z3 = (i2 == this.f18618e && LegoListFragment.this.K) ? false : true;
            int i5 = (i3 + i2) - 1;
            if (i5 == this.f18619f && !LegoListFragment.this.K) {
                z3 = false;
            }
            if (this.f18619f < i5) {
                z = true;
            } else if (this.f18618e > i2) {
                z = true;
                z2 = true;
                if (z && !this.f18620g) {
                    BaseAdapter k1 = LegoListFragment.this.k1();
                    if (z2) {
                        if (k1 != null && k1.getCount() > i5) {
                            int i6 = i5 - 1;
                            if (i6 < 0) {
                                i6 = 0;
                            }
                            Object item = k1.getItem(i6);
                            int page = item instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item).getPage() : 0;
                            Object item2 = k1.getItem(i5);
                            int page2 = item2 instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item2).getPage() : 0;
                            if (page != 0 && page2 != 0 && page < page2) {
                                this.f18620g = true;
                                this.f18621h = i5;
                                this.f18622i = 0;
                                d.a.j0.j1.o.k.c.f55780a = page2;
                                LegoListFragment.this.f18604g.getListView().post(new b());
                            }
                        }
                    } else {
                        int i7 = i2 + 1;
                        if (k1 != null && k1.getCount() > i7) {
                            Object item3 = k1.getItem(i2);
                            int page3 = item3 instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item3).getPage() : 0;
                            Object item4 = k1.getItem(i7);
                            int page4 = item4 instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item4).getPage() : 0;
                            if (page3 != 0 && page4 != 0 && page3 < page4) {
                                int i8 = i2 - 1;
                                double ratio = ((BaseLegoCardInfo) item3).getRatio();
                                int i9 = i2;
                                while (i8 >= 0) {
                                    Object item5 = k1.getItem(i8);
                                    if (item5 instanceof BaseLegoCardInfo) {
                                        BaseLegoCardInfo baseLegoCardInfo = (BaseLegoCardInfo) item5;
                                        if (baseLegoCardInfo.getPage() != page3) {
                                            break;
                                        }
                                        ratio += baseLegoCardInfo.getRatio();
                                        int i10 = i8;
                                        i8--;
                                        i9 = i10;
                                    }
                                }
                                this.f18620g = true;
                                if (ratio > 2.67d) {
                                    this.f18621h = i7;
                                    this.f18622i = (int) ((d.a.c.e.p.l.q(LegoListFragment.this.getActivity()).widthPixels * 1.78d) + 0.5d);
                                } else {
                                    this.f18621h = i9;
                                    this.f18622i = 0;
                                }
                                d.a.j0.j1.o.k.c.f55780a = page3;
                                LegoListFragment.this.f18604g.getListView().post(new c());
                            }
                        }
                    }
                }
                this.f18618e = i2;
                this.f18619f = i5;
                if (this.f18622i > 0) {
                    this.f18619f = i5 - 1;
                }
                LegoListFragment.this.J = i2;
                LegoListFragment.this.I = i5;
                if (z3) {
                    return;
                }
                LegoListFragment legoListFragment = LegoListFragment.this;
                legoListFragment.t1(2, legoListFragment.K);
                return;
            } else {
                z = false;
            }
            z2 = false;
            if (z) {
                BaseAdapter k12 = LegoListFragment.this.k1();
                if (z2) {
                }
            }
            this.f18618e = i2;
            this.f18619f = i5;
            if (this.f18622i > 0) {
            }
            LegoListFragment.this.J = i2;
            LegoListFragment.this.I = i5;
            if (z3) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            View findFocus;
            LegoListFragment.this.L = i2;
            if (1 == i2 && LegoListFragment.this.M != null && (findFocus = LegoListFragment.this.M.findFocus()) != null) {
                findFocus.clearFocus();
            }
            if (i2 == 0) {
                LegoListFragment legoListFragment = LegoListFragment.this;
                legoListFragment.t1(1, legoListFragment.K);
                if (this.f18620g) {
                    LegoListFragment.this.f18605h.K0(d.a.j0.j1.o.k.c.f55780a);
                    LegoListFragment.this.f18604g.getListView().setSelectionFromTop(this.f18621h, this.f18622i);
                    LegoListFragment.this.f18605h.Q();
                    LegoListFragment.this.f18604g.getListView().post(new a());
                }
            }
            if (LegoListFragment.this.N != null) {
                LegoListFragment.this.N.onScrollStateChanged(absListView, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LegoListFragment.this.f18606i != null) {
                LegoListFragment.this.f18606i.m();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LegoListFragment.this.i1();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Animator.AnimatorListener {
        public n() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (LegoListFragment.this.y.b()) {
                LegoListFragment.this.f18602e.setVisibility(8);
                LegoListFragment.this.H1();
                return;
            }
            LegoListFragment.this.f18602e.setVisibility(0);
            LegoListFragment.this.w.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            LegoListFragment.this.f18602e.setVisibility(8);
            LegoListFragment.this.w.setVisibility(0);
        }
    }

    public static void q1() {
        Set<String> set = V;
        if (set == null) {
            V = new HashSet();
        } else {
            set.clear();
        }
    }

    public void A1(boolean z) {
        this.E = z;
    }

    public void B1(d.a.j0.j1.j jVar) {
        this.s = jVar;
    }

    public boolean C() {
        return !this.f18605h.e0();
    }

    public void C1(d.a.j0.j1.k kVar) {
        this.N = kVar;
    }

    public void D1(String str) {
        this.G = str;
    }

    public void E1(long j2) {
        this.k = j2;
    }

    public final void F1(View view, boolean z, int i2) {
        if (this.q == null) {
            if (i2 < 0) {
                this.q = new d.a.i0.d0.g(getActivity());
            } else {
                this.q = new d.a.i0.d0.g(getActivity(), i2);
            }
            this.q.onChangeSkinType();
        }
        this.q.attachView(view, z);
    }

    public final void G1(Rect rect) {
        int i2 = rect.right;
        int i3 = rect.left;
        float f2 = this.A / (i2 - i3);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.w, "scaleX", 1.0f, f2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.w, "scaleY", 1.0f, f2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.w, "translationX", -i3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.w, "translationY", -rect.top);
        this.w.setPivotX(0.0f);
        this.w.setPivotY(0.0f);
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet.addListener(new n());
        animatorSet.start();
    }

    public final void H1() {
        this.x.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.x, "translationY", -this.H);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.x, "alpha", 0.0f, 1.0f);
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new a());
    }

    public final void h1(List<d.a.j0.j1.p.d> list) {
        if (this.v == null) {
            return;
        }
        if (ListUtils.isEmpty(list)) {
            this.v.setVisibility(8);
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).f55866d == 2) {
                d.a.j0.j1.p.d dVar = list.get(i2);
                if (!TextUtils.isEmpty(list.get(i2).f55865c)) {
                    this.v.setVisibility(0);
                    this.v.setOnClickListener(new c(dVar));
                }
            }
        }
    }

    public void i1() {
        if (this.x == null) {
            getActivity().finish();
            return;
        }
        this.w.V(this.y.f55753a, 17, false);
        Rect rect = this.z;
        int i2 = rect.left;
        float f2 = rect.top - this.B;
        float f3 = this.A / (rect.right - i2);
        AnimationSet animationSet = new AnimationSet(false);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, i2, 0.0f, f2);
        float f4 = 1.0f / f3;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f4, 1.0f, f4);
        this.w.setPivotX(0.5f);
        this.w.setPivotY(0.5f);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(200L);
        this.w.startAnimation(animationSet);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new b());
    }

    public final void j1() {
        if (d.a.c.e.p.j.z()) {
            F1(getView(), false, getResources().getDimensionPixelSize(R.dimen.ds360));
        }
        this.f18604g.setViewForeground();
    }

    public BaseAdapter k1() {
        LegoListView legoListView = this.f18604g;
        if (legoListView == null) {
            return null;
        }
        return legoListView.f18587h;
    }

    public int l1() {
        return this.L;
    }

    public int m1() {
        int[] iArr = new int[2];
        this.f18604g.getLocationOnScreen(iArr);
        return iArr[1];
    }

    public d.a.j0.j1.o.l.n n1() {
        return this.f18606i;
    }

    public final void o1(View view) {
        d.a.i0.d0.g gVar = this.q;
        if (gVar != null) {
            gVar.dettachView(view);
            this.q = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        r1();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        if (this.f18603f != null) {
            this.f18603f.c(d.a.c.a.j.a(getActivity()), i2);
        }
        if (this.t != null) {
            getBaseFragmentActivity().getLayoutMode().j(this.t);
        }
        super.onChangeSkinType(i2);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        RelativeLayout relativeLayout;
        if (configuration == null || (relativeLayout = this.t) == null) {
            return;
        }
        if (configuration.orientation == 2) {
            relativeLayout.setVisibility(8);
        } else if (this.E) {
            relativeLayout.setVisibility(0);
        } else {
            relativeLayout.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.a.j0.j1.o.h.a aVar;
        this.A = d.a.c.e.p.l.k(getActivity());
        FrameLayout frameLayout = new FrameLayout(getActivity());
        LinearLayout linearLayout = new LinearLayout(getActivity());
        this.f18602e = linearLayout;
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f18602e.setOrientation(1);
        NoNetworkView noNetworkView = new NoNetworkView(getActivity());
        this.f18603f = noNetworkView;
        if (!this.E) {
            this.f18602e.addView(noNetworkView);
            if (d.a.c.e.p.l.D()) {
                this.f18603f.setVisibility(8);
            } else {
                this.f18603f.setVisibility(0);
            }
        }
        LegoListView s1 = s1(this.P);
        this.f18604g = s1;
        s1.setDrawingCacheEnabled(false);
        d.a.j0.j1.p.e eVar = new d.a.j0.j1.p.e();
        this.m = eVar;
        eVar.f55871a = this.k;
        eVar.f55872b = this.l;
        d.a.j0.j1.p.c cVar = new d.a.j0.j1.p.c(eVar);
        this.n = cVar;
        this.f18604g.u(cVar, true);
        this.f18602e.addView(this.f18604g);
        this.f18604g.getListView().setOnScrollListener(this.T);
        this.f18604g.getListView().addOnLayoutChangeListener(this.Q);
        this.f18604g.getListView().setOnTouchListener(this.R);
        d.a.j0.f0.a aVar2 = new d.a.j0.f0.a();
        this.j = aVar2;
        aVar2.d(this.S);
        this.f18606i = this.f18604g.getPlaySwitchController();
        frameLayout.addView(this.f18602e, new FrameLayout.LayoutParams(-1, -1));
        if (this.E) {
            this.t.setVisibility(0);
            this.v = (ImageView) this.t.findViewById(R.id.btn_share);
            d.a.c.e.p.l.c(getActivity(), this.v, 20, 20, 20, 20);
            this.v.setVisibility(8);
            this.u = (ImageView) this.t.findViewById(R.id.btn_close);
            d.a.c.e.p.l.c(getActivity(), this.u, 20, 20, 20, 20);
            this.u.setOnClickListener(new m());
            getBaseFragmentActivity().setSwipeBackEnabled(false);
            if (this.D && (aVar = this.y) != null && aVar.c()) {
                frameLayout.setBackgroundColor(getActivity().getResources().getColor(R.color.black_alpha100));
                int r = d.a.c.e.p.l.r(getActivity());
                this.B = r;
                Rect rect = this.y.f55754b;
                this.z = rect;
                rect.top -= r;
                rect.bottom -= r;
                TbImageView tbImageView = new TbImageView(getActivity());
                this.w = tbImageView;
                tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                Rect rect2 = this.z;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(rect2.right - rect2.left, rect2.bottom - rect2.top);
                Rect rect3 = this.z;
                layoutParams.setMargins(rect3.left, rect3.top, 0, 0);
                this.w.setLayoutParams(layoutParams);
                this.w.V(this.y.f55753a, 17, false);
                frameLayout.addView(this.w, layoutParams);
                if (this.y.b()) {
                    Rect rect4 = this.y.f55756d;
                    Rect rect5 = this.z;
                    float f2 = this.A / (rect5.right - rect5.left);
                    this.H = d.a.c.e.p.l.g(getActivity(), R.dimen.ds10);
                    Rect rect6 = this.z;
                    float f3 = f2 * (rect6.bottom - rect6.top);
                    TbImageView tbImageView2 = new TbImageView(getActivity());
                    this.x = tbImageView2;
                    tbImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                    int i2 = this.A;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, (int) (i2 * (((rect4.bottom - rect4.top) * 1.0d) / (rect4.right - rect4.left))));
                    layoutParams2.setMargins(0, (int) (f3 + this.H), 0, 0);
                    this.x.setLayoutParams(layoutParams2);
                    this.x.V(this.y.f55755c, 17, false);
                    frameLayout.addView(this.x, layoutParams2);
                    this.x.setVisibility(8);
                }
                G1(this.z);
                this.f18602e.setVisibility(8);
            }
            w.p().m().f(this.k, this.l, this.F);
        } else {
            RelativeLayout relativeLayout = this.t;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.M = activity.getWindow().getDecorView();
        }
        return frameLayout;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f18604g.t();
        d.a.j0.j1.o.l.n nVar = this.f18606i;
        if (nVar != null) {
            nVar.c();
        }
        d.a.c.e.m.e.a().removeCallbacks(this.U);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f18604g.setViewBackGround();
        d.a.j0.j1.o.l.n nVar = this.f18606i;
        if (nVar != null) {
            nVar.n(false);
            this.f18606i.t();
        }
        d.a.c.e.m.e.a().removeCallbacks(this.U);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (!TextUtils.isEmpty(this.G)) {
            this.n.r(this.G);
            if (this.n.o()) {
                h1(this.n.f());
                this.f18604g.u(this.n, true);
                return;
            }
        }
        if (isAdded() && isPrimary() && !this.r) {
            j1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f18604g.setViewForeground();
        d.a.j0.j1.o.l.n nVar = this.f18606i;
        if (nVar != null) {
            nVar.n(true);
            d.a.c.e.m.e.a().postDelayed(this.U, 200L);
        }
    }

    public final void p1() {
        d.a.i0.d0.h hVar = this.p;
        if (hVar != null) {
            hVar.dettachView(getView());
            this.p = null;
        }
    }

    public final void r1() {
        d.a.j0.j1.s.a c2 = d.a.j0.j1.r.b.d().c(getPageContext(), getUniqueId());
        this.o = c2;
        c2.b(new d());
    }

    public final LegoListView s1(d.a.j0.j1.d dVar) {
        LegoListView legoListView = new LegoListView(getPageContext().getPageActivity(), this.C);
        legoListView.f18587h.E(this.F);
        if (this.E) {
            legoListView.setFriction(ViewConfiguration.getScrollFriction() * 12.0f);
        }
        legoListView.v(getUniqueId());
        legoListView.setCallback(dVar);
        return legoListView;
    }

    public void setFrom(String str) {
        this.F = str;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.p == null) {
            this.p = new d.a.i0.d0.h(getPageContext().getPageActivity(), new e());
        }
        this.p.j(getResources().getDimensionPixelSize(R.dimen.ds160));
        this.p.l(str);
        this.p.attachView(view, z);
        this.p.o();
    }

    public final void t1(int i2, boolean z) {
        LegoListView legoListView;
        d.a.j0.j1.n.a aVar;
        if (this.f18606i == null || (legoListView = this.f18604g) == null || legoListView.getListView() == null || (aVar = this.f18604g.f18587h) == null || aVar.getCount() == 0) {
            return;
        }
        this.f18606i.j(this.J, this.I, z, i2);
    }

    public void u1(String str, String str2) {
        d.a.j0.j1.o.h.a a2 = d.a.j0.j1.o.h.a.a(str);
        this.y = a2;
        a2.d(str2);
    }

    public void v1(d.a.j0.j1.o.l.c cVar) {
        this.f18605h = cVar;
        cVar.y0(this.O);
    }

    public void w1(boolean z) {
        this.D = z;
    }

    public void x1(boolean z) {
        this.C = z;
    }

    public void y1(String str) {
        this.l = str;
    }

    public void z1(RelativeLayout relativeLayout) {
        this.t = relativeLayout;
    }
}
