package com.baidu.tieba.write.album;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.GridView;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class TransparentHeadGridView extends GridView {

    /* renamed from: e  reason: collision with root package name */
    public int f21807e;

    /* renamed from: f  reason: collision with root package name */
    public float f21808f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21809g;

    /* renamed from: h  reason: collision with root package name */
    public int f21810h;

    /* renamed from: i  reason: collision with root package name */
    public View f21811i;
    public Interpolator j;
    public f k;
    public int l;
    public c m;
    public d n;
    public AbsListView.OnScrollListener o;
    public Context p;
    public int q;
    public boolean r;
    public e s;
    public AbsListView.OnScrollListener t;

    /* loaded from: classes5.dex */
    public class a implements e {
        public a() {
        }

        @Override // com.baidu.tieba.write.album.TransparentHeadGridView.e
        public void a() {
            if (TransparentHeadGridView.this.r) {
                TransparentHeadGridView.this.setVisibility(8);
            }
            if (TransparentHeadGridView.this.n != null) {
                TransparentHeadGridView.this.n.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AbsListView.OnScrollListener {
        public b() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            int height;
            if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                if (TransparentHeadGridView.this.m != null && TransparentHeadGridView.this.q != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                    TransparentHeadGridView.this.m.a(100);
                    TransparentHeadGridView.this.q = 100;
                }
            } else {
                View childAt = absListView.getChildAt(0);
                if (TransparentHeadGridView.this.f21810h < 0) {
                    TransparentHeadGridView.this.f21810h = childAt.getTop();
                }
                int i5 = -(childAt.getTop() - TransparentHeadGridView.this.f21810h);
                TransparentHeadGridView.this.f21809g = i5 == 0;
                if (TransparentHeadGridView.this.f21811i != null) {
                    TransparentHeadGridView.this.f21811i.scrollTo(0, i5);
                }
                if (TransparentHeadGridView.this.m != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.q) {
                    TransparentHeadGridView.this.m.a(height);
                    TransparentHeadGridView.this.q = height;
                }
            }
            if (TransparentHeadGridView.this.o != null) {
                TransparentHeadGridView.this.o.onScroll(absListView, i2, i3, i4);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (TransparentHeadGridView.this.o != null) {
                TransparentHeadGridView.this.o.onScrollStateChanged(absListView, i2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i2);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a();

        void b(int i2);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Interpolator f21814e;

        /* renamed from: f  reason: collision with root package name */
        public final int f21815f;

        /* renamed from: g  reason: collision with root package name */
        public final int f21816g;

        /* renamed from: h  reason: collision with root package name */
        public final long f21817h;

        /* renamed from: i  reason: collision with root package name */
        public e f21818i;
        public boolean j = true;
        public long k = -1;
        public int l = -1;

        public f(int i2, int i3, long j, e eVar) {
            this.f21816g = i2;
            this.f21815f = i3;
            this.f21814e = TransparentHeadGridView.this.j;
            this.f21817h = j;
            this.f21818i = eVar;
        }

        public void a() {
            this.j = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.k == -1) {
                this.k = System.currentTimeMillis();
            } else {
                int round = this.f21816g - Math.round((this.f21816g - this.f21815f) * this.f21814e.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.k) * 1000) / this.f21817h, 1000L), 0L)) / 1000.0f));
                this.l = round;
                TransparentHeadGridView.this.setPadding(0, round, 0, 0);
                if (TransparentHeadGridView.this.n != null && this.l >= 0 && TransparentHeadGridView.this.l > 0 && this.l <= TransparentHeadGridView.this.l) {
                    TransparentHeadGridView.this.n.b((this.l * 100) / TransparentHeadGridView.this.l);
                }
            }
            if (this.j && this.f21815f != this.l) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
                return;
            }
            e eVar = this.f21818i;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.f21807e = 0;
        this.f21808f = 0.0f;
        this.f21809g = true;
        this.f21810h = -1;
        this.q = -1;
        this.r = false;
        this.s = new a();
        this.t = new b();
        m(context);
    }

    public final void m(Context context) {
        this.p = context;
        setOnScrollListener(this.t);
        this.l = (int) (l.i(context) * 0.22f);
    }

    public void n() {
        setPadding(0, (int) ((10.0f - this.f21808f) / 2.0f), 0, 0);
        this.f21807e = 0;
        this.f21808f = 0.0f;
        if (this.r && getPaddingTop() > this.l) {
            o(getHeight(), 200L, 0L, this.s);
        } else {
            o(0, 200L, 0L, null);
        }
    }

    public final void o(int i2, long j, long j2, e eVar) {
        f fVar = this.k;
        if (fVar != null) {
            fVar.a();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i2) {
            if (this.j == null) {
                this.j = new DecelerateInterpolator();
            }
            f fVar2 = new f(paddingTop, i2, j, eVar);
            this.k = fVar2;
            if (j2 > 0) {
                postDelayed(fVar2, j2);
            } else {
                post(fVar2);
            }
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        int action = motionEvent.getAction();
        if (action == 1) {
            this.f21807e = 0;
            this.f21808f = 0.0f;
            if (this.r && getPaddingTop() > this.l) {
                o(getHeight(), 200L, 0L, this.s);
            } else {
                o(0, 200L, 0L, null);
            }
        } else if (action == 2) {
            if (this.f21808f == 0.0f) {
                this.f21808f = motionEvent.getY();
            }
            float y = motionEvent.getY();
            if (y > this.f21808f && getPaddingTop() == 0 && this.f21809g) {
                this.f21807e = 1;
            }
            if (this.f21807e == 1) {
                int i3 = (int) ((y - this.f21808f) / 2.0f);
                d dVar = this.n;
                if (dVar != null && i3 >= 0 && (i2 = this.l) > 0 && i3 <= i2) {
                    dVar.b((i3 * 100) / i2);
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBottomMoveView(View view) {
        this.f21811i = view;
    }

    public void setOnHeadDisplayChangeListener(c cVar) {
        this.m = cVar;
    }

    public void setOnPullChangeListener(d dVar) {
        this.n = dVar;
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.o = onScrollListener;
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21807e = 0;
        this.f21808f = 0.0f;
        this.f21809g = true;
        this.f21810h = -1;
        this.q = -1;
        this.r = false;
        this.s = new a();
        this.t = new b();
        m(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21807e = 0;
        this.f21808f = 0.0f;
        this.f21809g = true;
        this.f21810h = -1;
        this.q = -1;
        this.r = false;
        this.s = new a();
        this.t = new b();
        m(context);
    }
}
