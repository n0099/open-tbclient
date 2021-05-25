package com.baidu.tieba.person.listview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Scroller;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.R$styleable;
/* loaded from: classes5.dex */
public class BdPersonListView extends BdTypeListView {
    public static int i0 = 1;
    public final Context N;
    public final Scroller O;
    public final Scroller P;
    public View Q;
    public View R;
    public float S;
    public float T;
    public b U;
    public b V;
    public boolean W;
    public float a0;
    public float b0;
    public final int c0;
    public final int d0;
    public a e0;
    public boolean f0;
    public boolean g0;
    public boolean h0;

    /* loaded from: classes5.dex */
    public interface a {
        void a(float f2);

        void b();

        void onRefresh();
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f19649a;

        /* renamed from: b  reason: collision with root package name */
        public int f19650b;

        public b(int i2, int i3, int i4, int i5) {
            this.f19649a = i3;
            this.f19650b = i5;
        }

        public int a(float f2) {
            return (int) (this.f19649a + (f2 / 2.5f));
        }
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.W = false;
        this.f0 = true;
        this.g0 = false;
        this.h0 = false;
        this.N = context;
        this.O = new Scroller(this.N);
        this.P = new Scroller(this.N);
        this.c0 = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExpandListView);
        this.d0 = obtainStyledAttributes.getDimensionPixelSize(i0, 0);
        obtainStyledAttributes.recycle();
    }

    public final void I(float f2) {
        this.e0.a(360.0f - ((f2 * 360.0f) / this.d0));
    }

    public void J() {
        a aVar = this.e0;
        if (aVar != null) {
            aVar.onRefresh();
        }
    }

    public final void K() {
        if (this.U == null) {
            return;
        }
        if (this.Q.getHeight() >= this.U.f19650b - (this.d0 / 2)) {
            J();
        } else {
            this.e0.b();
        }
        this.O.startScroll(0, this.Q.getHeight(), 0, this.U.f19649a - this.Q.getHeight(), 200);
        this.P.startScroll(0, this.R.getHeight(), 0, this.V.f19649a - this.R.getHeight(), 200);
        invalidate();
        this.W = false;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.O.computeScrollOffset()) {
            this.Q.setLayoutParams(new AbsListView.LayoutParams(this.Q.getWidth(), this.O.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.P.computeScrollOffset()) {
            int currY = this.P.getCurrY();
            View view = this.R;
            if (view == null || (layoutParams = view.getLayoutParams()) == null) {
                return;
            }
            layoutParams.height = currY;
            this.R.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
        if (r0 != 3) goto L16;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.Q != null && this.f0) {
            int action = motionEvent.getAction();
            if (this.O.isFinished()) {
                float y = motionEvent.getY();
                this.T = y;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float f2 = this.b0;
                            float f3 = f2 - this.a0;
                            float f4 = y - this.S;
                            this.a0 = f2;
                            if (this.Q.getParent() == this && this.U != null && this.Q.isShown() && this.Q.getTop() >= 0 && Math.abs(f4) >= this.c0 && Math.abs(f3) < this.c0) {
                                int a2 = this.U.a(this.T - this.S);
                                b bVar = this.U;
                                if (a2 > bVar.f19649a && a2 <= bVar.f19650b) {
                                    this.W = true;
                                    this.Q.setLayoutParams(new AbsListView.LayoutParams(this.Q.getWidth(), a2));
                                    if (this.R != null) {
                                        int a3 = this.V.a(this.T - this.S);
                                        ViewGroup.LayoutParams layoutParams = this.R.getLayoutParams();
                                        if (layoutParams != null) {
                                            layoutParams.height = a3;
                                            this.R.setLayoutParams(layoutParams);
                                        }
                                    }
                                    I(a2 - this.U.f19649a);
                                } else {
                                    b bVar2 = this.U;
                                    if (a2 <= bVar2.f19649a) {
                                        this.W = false;
                                    } else if (a2 > bVar2.f19650b) {
                                        this.W = true;
                                    } else {
                                        this.W = false;
                                    }
                                }
                            } else {
                                this.W = false;
                            }
                        }
                    }
                    if (this.W) {
                        K();
                        if (this.g0) {
                            return true;
                        }
                    } else {
                        this.e0.b();
                    }
                } else {
                    int height = this.Q.getHeight();
                    this.S = this.T;
                    this.a0 = this.b0;
                    this.U = new b(0, height, 0, this.d0 + height);
                    int height2 = this.R.getHeight();
                    this.V = new b(0, height2, 0, this.d0 + height2);
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public View getOuterExpandView() {
        return this.R;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.W) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.W || this.h0) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setExpandView(View view) {
        this.Q = view;
    }

    public void setNeedConsumeTouchEvent(boolean z) {
        this.h0 = z;
    }

    public void setOuterExpandView(View view) {
        this.R = view;
    }

    public void setPersonListRefreshListener(a aVar) {
        this.e0 = aVar;
    }
}
