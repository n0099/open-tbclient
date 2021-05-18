package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.Scroller;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.R$styleable;
/* loaded from: classes3.dex */
public class BdMemberCenterListView extends BdTypeListView {
    public static int c0 = 1;
    public final Context N;
    public final Scroller O;
    public View P;
    public float Q;
    public float R;
    public b S;
    public boolean T;
    public float U;
    public float V;
    public final int W;
    public final int a0;
    public a b0;

    /* loaded from: classes3.dex */
    public interface a {
        void a(float f2);

        void b();

        void onRefresh();
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f18294a;

        /* renamed from: b  reason: collision with root package name */
        public int f18295b;

        public b(int i2, int i3, int i4, int i5) {
            this.f18294a = i3;
            this.f18295b = i5;
        }

        public int a(float f2) {
            return (int) (this.f18294a + (f2 / 2.5f));
        }
    }

    public BdMemberCenterListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.T = false;
        this.N = context;
        this.O = new Scroller(this.N);
        this.W = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExpandListView);
        this.a0 = obtainStyledAttributes.getDimensionPixelSize(c0, 0);
        obtainStyledAttributes.recycle();
    }

    public final void I(float f2) {
        this.b0.a(360.0f - ((f2 * 360.0f) / this.a0));
    }

    public void J() {
        a aVar = this.b0;
        if (aVar != null) {
            aVar.onRefresh();
        }
    }

    public void K() {
        if (this.S == null) {
            return;
        }
        View view = this.P;
        int height = view == null ? 0 : view.getHeight();
        if (height >= this.S.f18295b - (this.a0 / 2)) {
            J();
        } else {
            this.b0.b();
        }
        this.O.startScroll(0, height, 0, this.S.f18294a - height, 200);
        invalidate();
        this.T = false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.O.computeScrollOffset() && this.P != null) {
            this.P.setLayoutParams(new AbsListView.LayoutParams(this.P.getWidth(), this.O.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.O.isFinished()) {
            float y = motionEvent.getY();
            this.R = y;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float f2 = this.V;
                        float f3 = f2 - this.U;
                        float f4 = y - this.Q;
                        this.U = f2;
                        View view = this.P;
                        if (view != null && view.getParent() == this && this.S != null && this.P.isShown() && this.P.getTop() >= 0 && Math.abs(f4) >= this.W && Math.abs(f3) < this.W) {
                            int a2 = this.S.a(this.R - this.Q);
                            b bVar = this.S;
                            if (a2 > bVar.f18294a && a2 <= bVar.f18295b) {
                                this.T = true;
                                this.P.setLayoutParams(new AbsListView.LayoutParams(this.P.getWidth(), a2));
                                I(a2 - this.S.f18294a);
                            } else {
                                b bVar2 = this.S;
                                if (a2 <= bVar2.f18294a) {
                                    this.T = false;
                                } else if (a2 > bVar2.f18295b) {
                                    this.T = true;
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
                    K();
                } else {
                    this.b0.b();
                }
            } else {
                View view2 = this.P;
                int height = view2 == null ? 0 : view2.getHeight();
                this.Q = this.R;
                this.U = this.V;
                this.S = new b(0, height, 0, this.a0 + height);
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

    public void setMemberCenterListRefreshListener(a aVar) {
        this.b0 = aVar;
    }
}
