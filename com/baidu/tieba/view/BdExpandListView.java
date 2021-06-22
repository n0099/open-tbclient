package com.baidu.tieba.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.Scroller;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.R$styleable;
/* loaded from: classes5.dex */
public class BdExpandListView extends BdTypeListView {
    public static int m0 = 1;
    public final Context N;
    public final Scroller O;
    public View P;
    public float Q;
    public float R;
    public c S;
    public boolean T;
    public final int U;
    public final int V;
    public b W;
    public long a0;
    public long b0;
    public Handler c0;
    public int i0;
    public boolean j0;
    public Runnable k0;
    public int l0;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BdExpandListView.this.i0 > 0) {
                BdExpandListView.this.P.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.P.getWidth(), BdExpandListView.this.i0));
                BdExpandListView.this.invalidate();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(float f2);

        void b();

        void onRefresh();
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f21721a;

        /* renamed from: b  reason: collision with root package name */
        public int f21722b;

        public c(int i2, int i3, int i4, int i5) {
            this.f21721a = i3;
            this.f21722b = i5;
        }

        public int a(float f2) {
            return (int) (this.f21721a + (f2 / 2.5f));
        }
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.T = false;
        this.a0 = 0L;
        this.b0 = 0L;
        this.c0 = new Handler();
        this.j0 = false;
        this.k0 = new a();
        this.l0 = 0;
        this.N = context;
        this.O = new Scroller(this.N);
        this.U = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExpandListView);
        this.V = obtainStyledAttributes.getDimensionPixelSize(m0, 0);
        obtainStyledAttributes.recycle();
    }

    private int getOriginalHeight() {
        if (this.i0 <= 0) {
            this.i0 = this.P.getHeight();
        }
        return this.i0;
    }

    private void setClickEventEnabled(boolean z) {
        setClickable(z);
        setLongClickable(z);
        setEnabled(z);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView
    public void F() {
        if (this.j0) {
            super.F();
            return;
        }
        if (getLastVisiblePosition() > 10) {
            setSelection(10);
        }
        smoothScrollToPosition(0);
        if (this.P == null || this.T) {
            return;
        }
        this.T = true;
        Scroller scroller = this.O;
        int originalHeight = getOriginalHeight();
        int i2 = this.V;
        scroller.startScroll(0, originalHeight + i2, 0, -i2, 200);
        L();
        invalidate();
        this.c0.removeCallbacks(this.k0);
        this.c0.postDelayed(this.k0, 200L);
        this.T = false;
    }

    public final void K(float f2) {
        float f3 = 360.0f - ((f2 * 360.0f) / this.V);
        b bVar = this.W;
        if (bVar != null) {
            bVar.a(f3);
        }
    }

    public void L() {
        b bVar = this.W;
        if (bVar != null) {
            bVar.onRefresh();
        }
    }

    public void M() {
        if (this.S == null) {
            return;
        }
        if (this.P.getHeight() >= this.S.f21722b - (this.V / 2)) {
            L();
        } else {
            b bVar = this.W;
            if (bVar != null) {
                bVar.b();
            }
        }
        this.O.startScroll(0, this.P.getHeight(), 0, this.S.f21721a - this.P.getHeight(), 200);
        invalidate();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.j0) {
            super.computeScroll();
        } else if (this.O.computeScrollOffset()) {
            int currY = this.O.getCurrY();
            if (Math.abs(this.l0 - currY) > this.U * 2) {
                this.l0 = currY;
                this.P.setLayoutParams(new AbsListView.LayoutParams(this.P.getWidth(), currY));
            }
        } else {
            scrollTo(0, 0);
            super.computeScroll();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
        if (r0 != 3) goto L20;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.j0) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.O.isFinished()) {
            if (this.P == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            float y = motionEvent.getY();
            this.R = y;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float f2 = y - this.Q;
                        if (this.P.getParent() == this && this.S != null && this.P.isShown() && this.P.getTop() >= 0 && Math.abs(f2) >= this.U && this.a0 > 400) {
                            int a2 = this.S.a(this.R - this.Q);
                            c cVar = this.S;
                            if (a2 > cVar.f21721a && a2 <= cVar.f21722b) {
                                this.T = true;
                                setClickEventEnabled(false);
                                this.P.setLayoutParams(new AbsListView.LayoutParams(this.P.getWidth(), a2));
                                K(a2 - this.S.f21721a);
                            } else {
                                c cVar2 = this.S;
                                if (a2 <= cVar2.f21721a) {
                                    this.T = false;
                                } else if (a2 > cVar2.f21722b) {
                                    this.T = true;
                                    setClickEventEnabled(false);
                                } else {
                                    this.T = false;
                                }
                            }
                        } else {
                            this.T = false;
                        }
                    }
                }
                if (this.T) {
                    setClickEventEnabled(false);
                    M();
                    this.T = false;
                } else {
                    b bVar = this.W;
                    if (bVar != null) {
                        bVar.b();
                    }
                }
                this.c0.removeCallbacks(this.k0);
                this.c0.postDelayed(this.k0, 200L);
            } else {
                this.a0 = System.currentTimeMillis() - this.b0;
                this.b0 = System.currentTimeMillis();
                this.T = false;
                setClickEventEnabled(true);
                if (this.i0 == 0) {
                    this.i0 = this.P.getHeight();
                }
                int height = this.P.getHeight();
                this.Q = this.R;
                this.S = new c(0, height, 0, this.V + height);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.T) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.T) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setExpandView(View view, int i2) {
        this.P = view;
    }

    public void setPersonListRefreshListener(b bVar) {
        this.W = bVar;
    }

    public void setStarForum(boolean z) {
        this.j0 = z;
    }
}
