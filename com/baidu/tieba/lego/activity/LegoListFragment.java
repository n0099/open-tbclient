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
import d.b.i0.f0.a;
import d.b.i0.r2.s;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tbclient.Lego.DataRes;
/* loaded from: classes3.dex */
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
    public LinearLayout f18564e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f18565f;

    /* renamed from: g  reason: collision with root package name */
    public LegoListView f18566g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.i1.o.l.c f18567h;
    public d.b.i0.i1.o.l.n i;
    public d.b.i0.f0.a j;
    public long k;
    public String l;
    public d.b.i0.i1.p.e m;
    public d.b.i0.i1.p.c n;
    public d.b.i0.i1.s.a o;
    public d.b.h0.d0.h p;
    public d.b.h0.d0.g q;
    public d.b.i0.i1.j s;
    public RelativeLayout t;
    public ImageView u;
    public ImageView v;
    public TbImageView w;
    public TbImageView x;
    public d.b.i0.i1.o.h.a y;
    public Rect z;
    public boolean r = false;
    public boolean C = false;
    public int I = -1;
    public int J = -1;
    public boolean K = false;
    public int L = 0;
    public View M = null;
    public d.b.i0.i1.k N = null;
    public d.b.i0.i1.o.l.m O = new f();
    public d.b.i0.i1.d P = new g();
    public View.OnLayoutChangeListener Q = new h();
    public View.OnTouchListener R = new i();
    public a.b S = new j();
    public AbsListView.OnScrollListener T = new k();
    public Runnable U = new l();

    /* loaded from: classes3.dex */
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
            LegoListFragment.this.f18564e.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            LegoListFragment.this.f18564e.setVisibility(8);
            LegoListFragment.this.w.setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
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
            LegoListFragment.this.f18564e.setVisibility(8);
            if (LegoListFragment.this.y.b()) {
                LegoListFragment.this.x.setVisibility(8);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.i1.p.d f18570e;

        public c(d.b.i0.i1.p.d dVar) {
            this.f18570e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LegoListFragment.this.mIsLogin) {
                if (LegoListFragment.this.s != null) {
                    LegoListFragment.this.s.h(this.f18570e);
                    return;
                }
                return;
            }
            ViewHelper.skipToLoginActivity(LegoListFragment.this.getActivity());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.b.i0.i1.s.b {
        public d() {
        }

        @Override // d.b.i0.i1.s.b
        public void a(long j, String str, String str2, int i) {
            LegoListFragment legoListFragment = LegoListFragment.this;
            legoListFragment.o1(legoListFragment.getView());
            if (LegoListFragment.this.n.c()) {
                LegoListFragment.this.f18566g.u(LegoListFragment.this.n, false);
            } else if (LegoListFragment.this.getPageContext() == null || LegoListFragment.this.getPageContext().getResources() == null) {
            } else {
                LegoListFragment legoListFragment2 = LegoListFragment.this;
                legoListFragment2.showNetRefreshView(legoListFragment2.getView(), LegoListFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str2, Integer.valueOf(i)), false);
            }
        }

        @Override // d.b.i0.i1.s.b
        public void b(long j, String str, Message message, boolean z) {
        }

        @Override // d.b.i0.i1.s.b
        public void c(boolean z, Message message, boolean z2, long j, String str, int i) {
            if (z) {
                LegoListFragment legoListFragment = LegoListFragment.this;
                legoListFragment.o1(legoListFragment.getView());
            }
            DataRes dataRes = (DataRes) message;
            if (!z || (dataRes != null && dataRes.cards != null)) {
                LegoListFragment.this.r = true;
                LegoListFragment.this.n.d(z, dataRes, z2, i);
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
                LegoListFragment.this.f18566g.u(LegoListFragment.this.n, false);
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
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LegoListFragment.this.o != null) {
                LegoListFragment.this.o.c(2, LegoListFragment.this.m.f56031a, LegoListFragment.this.m.f56032b, 1, "");
                LegoListFragment.this.p1();
                LegoListFragment legoListFragment = LegoListFragment.this;
                legoListFragment.F1(legoListFragment.getView(), false, LegoListFragment.this.getResources().getDimensionPixelSize(R.dimen.ds360));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.b.i0.i1.o.l.m {
        public f() {
        }

        @Override // d.b.i0.i1.o.l.m
        public void a(String str) {
            if (LegoListFragment.this.i != null) {
                LegoListFragment.this.i.l(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.b.i0.i1.d {
        public g() {
        }

        @Override // d.b.i0.i1.d
        public void a(int i, long j, String str, String str2) {
            LegoListFragment.this.o.c(2, j, str, i, str2);
        }

        @Override // d.b.i0.i1.d
        public void b(long j, String str) {
            LegoListFragment.this.o.a(j, str);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnLayoutChangeListener {
        public h() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            LegoListFragment.this.f18567h.u0(LegoListFragment.this.m1());
            if (LegoListFragment.this.D()) {
                return;
            }
            LegoListFragment.this.f18567h.Q();
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnTouchListener {
        public i() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (LegoListFragment.this.f18567h.e0()) {
                if (LegoListFragment.this.f18566g == null || view != LegoListFragment.this.f18566g.getListView() || LegoListFragment.this.j == null) {
                    return false;
                }
                LegoListFragment.this.j.c(motionEvent);
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class j implements a.b {
        public j() {
        }

        @Override // d.b.i0.f0.a.b
        public void a(int i, int i2) {
        }

        @Override // d.b.i0.f0.a.b
        public void b(int i, int i2) {
            LegoListFragment.this.K = false;
        }

        @Override // d.b.i0.f0.a.b
        public void c(int i, int i2) {
            LegoListFragment.this.K = true;
        }

        @Override // d.b.i0.f0.a.b
        public void d(int i, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public class k implements AbsListView.OnScrollListener {

        /* renamed from: e  reason: collision with root package name */
        public int f18579e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f18580f = 0;

        /* renamed from: g  reason: collision with root package name */
        public boolean f18581g = false;

        /* renamed from: h  reason: collision with root package name */
        public int f18582h = -1;
        public int i = 0;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LegoListFragment legoListFragment = LegoListFragment.this;
                legoListFragment.t1(1, legoListFragment.K);
                k.this.f18581g = false;
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LegoListFragment.this.f18566g.getListView().smoothScrollToPositionFromTop(k.this.f18582h, k.this.i, 400);
            }
        }

        /* loaded from: classes3.dex */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LegoListFragment.this.f18566g.getListView().smoothScrollToPositionFromTop(k.this.f18582h, k.this.i, 400);
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
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            boolean z;
            boolean z2;
            if (!LegoListFragment.this.f18567h.e0() || LegoListFragment.this.f18566g == null || LegoListFragment.this.f18566g.getListView() == null || LegoListFragment.this.f18566g.getListView().getChildAt(0) == null) {
                return;
            }
            LegoListFragment.this.f18567h.Q();
            boolean z3 = (i == this.f18579e && LegoListFragment.this.K) ? false : true;
            int i4 = (i2 + i) - 1;
            if (i4 == this.f18580f && !LegoListFragment.this.K) {
                z3 = false;
            }
            if (this.f18580f < i4) {
                z = true;
            } else if (this.f18579e > i) {
                z = true;
                z2 = true;
                if (z && !this.f18581g) {
                    BaseAdapter k1 = LegoListFragment.this.k1();
                    if (z2) {
                        if (k1 != null && k1.getCount() > i4) {
                            int i5 = i4 - 1;
                            if (i5 < 0) {
                                i5 = 0;
                            }
                            Object item = k1.getItem(i5);
                            int page = item instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item).getPage() : 0;
                            Object item2 = k1.getItem(i4);
                            int page2 = item2 instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item2).getPage() : 0;
                            if (page != 0 && page2 != 0 && page < page2) {
                                this.f18581g = true;
                                this.f18582h = i4;
                                this.i = 0;
                                d.b.i0.i1.o.k.c.f55946a = page2;
                                LegoListFragment.this.f18566g.getListView().post(new b());
                            }
                        }
                    } else {
                        int i6 = i + 1;
                        if (k1 != null && k1.getCount() > i6) {
                            Object item3 = k1.getItem(i);
                            int page3 = item3 instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item3).getPage() : 0;
                            Object item4 = k1.getItem(i6);
                            int page4 = item4 instanceof BaseLegoCardInfo ? ((BaseLegoCardInfo) item4).getPage() : 0;
                            if (page3 != 0 && page4 != 0 && page3 < page4) {
                                int i7 = i - 1;
                                double ratio = ((BaseLegoCardInfo) item3).getRatio();
                                int i8 = i;
                                while (i7 >= 0) {
                                    Object item5 = k1.getItem(i7);
                                    if (item5 instanceof BaseLegoCardInfo) {
                                        BaseLegoCardInfo baseLegoCardInfo = (BaseLegoCardInfo) item5;
                                        if (baseLegoCardInfo.getPage() != page3) {
                                            break;
                                        }
                                        ratio += baseLegoCardInfo.getRatio();
                                        int i9 = i7;
                                        i7--;
                                        i8 = i9;
                                    }
                                }
                                this.f18581g = true;
                                if (ratio > 2.67d) {
                                    this.f18582h = i6;
                                    this.i = (int) ((d.b.b.e.p.l.q(LegoListFragment.this.getActivity()).widthPixels * 1.78d) + 0.5d);
                                } else {
                                    this.f18582h = i8;
                                    this.i = 0;
                                }
                                d.b.i0.i1.o.k.c.f55946a = page3;
                                LegoListFragment.this.f18566g.getListView().post(new c());
                            }
                        }
                    }
                }
                this.f18579e = i;
                this.f18580f = i4;
                if (this.i > 0) {
                    this.f18580f = i4 - 1;
                }
                LegoListFragment.this.J = i;
                LegoListFragment.this.I = i4;
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
            this.f18579e = i;
            this.f18580f = i4;
            if (this.i > 0) {
            }
            LegoListFragment.this.J = i;
            LegoListFragment.this.I = i4;
            if (z3) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            View findFocus;
            LegoListFragment.this.L = i;
            if (1 == i && LegoListFragment.this.M != null && (findFocus = LegoListFragment.this.M.findFocus()) != null) {
                findFocus.clearFocus();
            }
            if (i == 0) {
                LegoListFragment legoListFragment = LegoListFragment.this;
                legoListFragment.t1(1, legoListFragment.K);
                if (this.f18581g) {
                    LegoListFragment.this.f18567h.K0(d.b.i0.i1.o.k.c.f55946a);
                    LegoListFragment.this.f18566g.getListView().setSelectionFromTop(this.f18582h, this.i);
                    LegoListFragment.this.f18567h.Q();
                    LegoListFragment.this.f18566g.getListView().post(new a());
                }
            }
            if (LegoListFragment.this.N != null) {
                LegoListFragment.this.N.onScrollStateChanged(absListView, i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LegoListFragment.this.i != null) {
                LegoListFragment.this.i.m();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LegoListFragment.this.i1();
        }
    }

    /* loaded from: classes3.dex */
    public class n implements Animator.AnimatorListener {
        public n() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (LegoListFragment.this.y.b()) {
                LegoListFragment.this.f18564e.setVisibility(8);
                LegoListFragment.this.H1();
                return;
            }
            LegoListFragment.this.f18564e.setVisibility(0);
            LegoListFragment.this.w.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            LegoListFragment.this.f18564e.setVisibility(8);
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

    public void B1(d.b.i0.i1.j jVar) {
        this.s = jVar;
    }

    public void C1(d.b.i0.i1.k kVar) {
        this.N = kVar;
    }

    public boolean D() {
        return !this.f18567h.e0();
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
                this.q = new d.b.h0.d0.g(getActivity());
            } else {
                this.q = new d.b.h0.d0.g(getActivity(), i2);
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

    public final void h1(List<d.b.i0.i1.p.d> list) {
        if (this.v == null) {
            return;
        }
        if (ListUtils.isEmpty(list)) {
            this.v.setVisibility(8);
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).f56026d == 2) {
                d.b.i0.i1.p.d dVar = list.get(i2);
                if (!TextUtils.isEmpty(list.get(i2).f56025c)) {
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
        this.w.W(this.y.f55920a, 17, false);
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
        if (d.b.b.e.p.j.z()) {
            F1(getView(), false, getResources().getDimensionPixelSize(R.dimen.ds360));
        }
        this.f18566g.setViewForeground();
    }

    public BaseAdapter k1() {
        LegoListView legoListView = this.f18566g;
        if (legoListView == null) {
            return null;
        }
        return legoListView.f18550h;
    }

    public int l1() {
        return this.L;
    }

    public int m1() {
        int[] iArr = new int[2];
        this.f18566g.getLocationOnScreen(iArr);
        return iArr[1];
    }

    public d.b.i0.i1.o.l.n n1() {
        return this.i;
    }

    public final void o1(View view) {
        d.b.h0.d0.g gVar = this.q;
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
        if (this.f18565f != null) {
            this.f18565f.c(d.b.b.a.j.a(getActivity()), i2);
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
        d.b.i0.i1.o.h.a aVar;
        this.A = d.b.b.e.p.l.k(getActivity());
        FrameLayout frameLayout = new FrameLayout(getActivity());
        LinearLayout linearLayout = new LinearLayout(getActivity());
        this.f18564e = linearLayout;
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f18564e.setOrientation(1);
        NoNetworkView noNetworkView = new NoNetworkView(getActivity());
        this.f18565f = noNetworkView;
        if (!this.E) {
            this.f18564e.addView(noNetworkView);
            if (d.b.b.e.p.l.C()) {
                this.f18565f.setVisibility(8);
            } else {
                this.f18565f.setVisibility(0);
            }
        }
        LegoListView s1 = s1(this.P);
        this.f18566g = s1;
        s1.setDrawingCacheEnabled(false);
        d.b.i0.i1.p.e eVar = new d.b.i0.i1.p.e();
        this.m = eVar;
        eVar.f56031a = this.k;
        eVar.f56032b = this.l;
        d.b.i0.i1.p.c cVar = new d.b.i0.i1.p.c(eVar);
        this.n = cVar;
        this.f18566g.u(cVar, true);
        this.f18564e.addView(this.f18566g);
        this.f18566g.getListView().setOnScrollListener(this.T);
        this.f18566g.getListView().addOnLayoutChangeListener(this.Q);
        this.f18566g.getListView().setOnTouchListener(this.R);
        d.b.i0.f0.a aVar2 = new d.b.i0.f0.a();
        this.j = aVar2;
        aVar2.d(this.S);
        this.i = this.f18566g.getPlaySwitchController();
        frameLayout.addView(this.f18564e, new FrameLayout.LayoutParams(-1, -1));
        if (this.E) {
            this.t.setVisibility(0);
            this.v = (ImageView) this.t.findViewById(R.id.btn_share);
            d.b.b.e.p.l.c(getActivity(), this.v, 20, 20, 20, 20);
            this.v.setVisibility(8);
            this.u = (ImageView) this.t.findViewById(R.id.btn_close);
            d.b.b.e.p.l.c(getActivity(), this.u, 20, 20, 20, 20);
            this.u.setOnClickListener(new m());
            getBaseFragmentActivity().setSwipeBackEnabled(false);
            if (this.D && (aVar = this.y) != null && aVar.c()) {
                frameLayout.setBackgroundColor(getActivity().getResources().getColor(R.color.black_alpha100));
                int r = d.b.b.e.p.l.r(getActivity());
                this.B = r;
                Rect rect = this.y.f55921b;
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
                this.w.W(this.y.f55920a, 17, false);
                frameLayout.addView(this.w, layoutParams);
                if (this.y.b()) {
                    Rect rect4 = this.y.f55923d;
                    Rect rect5 = this.z;
                    float f2 = this.A / (rect5.right - rect5.left);
                    this.H = d.b.b.e.p.l.g(getActivity(), R.dimen.ds10);
                    Rect rect6 = this.z;
                    float f3 = f2 * (rect6.bottom - rect6.top);
                    TbImageView tbImageView2 = new TbImageView(getActivity());
                    this.x = tbImageView2;
                    tbImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                    int i2 = this.A;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, (int) (i2 * (((rect4.bottom - rect4.top) * 1.0d) / (rect4.right - rect4.left))));
                    layoutParams2.setMargins(0, (int) (f3 + this.H), 0, 0);
                    this.x.setLayoutParams(layoutParams2);
                    this.x.W(this.y.f55922c, 17, false);
                    frameLayout.addView(this.x, layoutParams2);
                    this.x.setVisibility(8);
                }
                G1(this.z);
                this.f18564e.setVisibility(8);
            }
            s.o().j().e(this.k, this.l, this.F);
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
        this.f18566g.t();
        d.b.i0.i1.o.l.n nVar = this.i;
        if (nVar != null) {
            nVar.c();
        }
        d.b.b.e.m.e.a().removeCallbacks(this.U);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f18566g.setViewBackGround();
        d.b.i0.i1.o.l.n nVar = this.i;
        if (nVar != null) {
            nVar.n(false);
            this.i.t();
        }
        d.b.b.e.m.e.a().removeCallbacks(this.U);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (!TextUtils.isEmpty(this.G)) {
            this.n.r(this.G);
            if (this.n.o()) {
                h1(this.n.f());
                this.f18566g.u(this.n, true);
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
        this.f18566g.setViewForeground();
        d.b.i0.i1.o.l.n nVar = this.i;
        if (nVar != null) {
            nVar.n(true);
            d.b.b.e.m.e.a().postDelayed(this.U, 200L);
        }
    }

    public final void p1() {
        d.b.h0.d0.h hVar = this.p;
        if (hVar != null) {
            hVar.dettachView(getView());
            this.p = null;
        }
    }

    public final void r1() {
        d.b.i0.i1.s.a a2 = d.b.i0.i1.r.b.d().a(getPageContext(), getUniqueId());
        this.o = a2;
        a2.b(new d());
    }

    public final LegoListView s1(d.b.i0.i1.d dVar) {
        LegoListView legoListView = new LegoListView(getPageContext().getPageActivity(), this.C);
        legoListView.f18550h.E(this.F);
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
            this.p = new d.b.h0.d0.h(getPageContext().getPageActivity(), new e());
        }
        this.p.j(getResources().getDimensionPixelSize(R.dimen.ds160));
        this.p.l(str);
        this.p.attachView(view, z);
        this.p.o();
    }

    public final void t1(int i2, boolean z) {
        LegoListView legoListView;
        d.b.i0.i1.n.a aVar;
        if (this.i == null || (legoListView = this.f18566g) == null || legoListView.getListView() == null || (aVar = this.f18566g.f18550h) == null || aVar.getCount() == 0) {
            return;
        }
        this.i.j(this.J, this.I, z, i2);
    }

    public void u1(String str, String str2) {
        d.b.i0.i1.o.h.a a2 = d.b.i0.i1.o.h.a.a(str);
        this.y = a2;
        a2.d(str2);
    }

    public void v1(d.b.i0.i1.o.l.c cVar) {
        this.f18567h = cVar;
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
