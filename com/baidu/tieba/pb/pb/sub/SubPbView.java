package com.baidu.tieba.pb.pb.sub;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class SubPbView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public BlankView f19409e;

    /* renamed from: f  reason: collision with root package name */
    public View f19410f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f19411g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f19412h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f19413i;
    public float j;
    public float k;
    public boolean l;
    public boolean m;
    public ValueAnimator n;
    public int o;
    public int p;
    public float q;
    public boolean r;

    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SubPbView.this.o = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            SubPbView subPbView = SubPbView.this;
            subPbView.q = 1.0f - (subPbView.o / l.i(SubPbView.this.getContext()));
            if (SubPbView.this.o == 0) {
                SubPbView.this.q = 1.0f;
            } else if (SubPbView.this.o == l.i(SubPbView.this.getContext())) {
                SubPbView.this.q = 0.0f;
                if (SubPbView.this.m && (SubPbView.this.getContext() instanceof Activity)) {
                    ((Activity) SubPbView.this.getContext()).finish();
                }
            }
            SubPbView.this.requestLayout();
        }
    }

    public SubPbView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
        if (r0 != 3) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d8  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.f19409e != null && this.r) {
            if (this.n.isRunning()) {
                this.n.end();
                return true;
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float rawY = motionEvent.getRawY();
                        this.k = rawY;
                        this.q = 1.0f - ((rawY - this.j) / l.i(getContext()));
                    }
                }
                z = this.k > this.j && this.f19410f.getTop() == 0 && this.f19412h.getFirstVisiblePosition() == 0;
                boolean z2 = this.k - this.j > ((float) this.p) && this.f19410f.getTop() == 0 && this.f19412h.getFirstVisiblePosition() == 0;
                this.m = z2;
                if (z2) {
                    this.n.setIntValues((int) (this.k - this.j), l.i(getContext()));
                    this.n.start();
                } else {
                    this.q = 1.0f;
                    this.j = 0.0f;
                    this.k = 0.0f;
                    requestLayout();
                }
                if (this.k <= this.j && this.f19410f.getTop() == 0 && this.f19412h.getFirstVisiblePosition() == 0) {
                    this.l = true;
                    requestLayout();
                    return true;
                } else if (!z) {
                    this.l = true;
                    return true;
                } else {
                    this.l = false;
                    return super.dispatchTouchEvent(motionEvent);
                }
            }
            float rawY2 = motionEvent.getRawY();
            this.j = rawY2;
            this.k = rawY2;
            z = false;
            if (this.k <= this.j) {
            }
            if (!z) {
            }
        } else {
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public boolean e() {
        return this.l;
    }

    public void f() {
        this.n.cancel();
        this.n.removeAllUpdateListeners();
        clearAnimation();
    }

    public void g() {
        this.m = true;
        this.n.setIntValues(0, l.i(getContext()));
        this.n.start();
    }

    public void h() {
        if (this.q == 0.0f) {
            this.n.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        float f2 = this.q;
        if (f2 >= 0.0f && this.f19409e != null) {
            canvas.drawColor(Color.argb((int) (f2 * 168.0f), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.f19409e == null) {
            super.onLayout(z, i2, i3, i4, i5);
            return;
        }
        int i6 = this.o;
        if (i6 == 0) {
            super.onLayout(z, i2, i3, i4, i5);
            float f2 = this.k;
            float f3 = this.j;
            if (f2 > f3) {
                LinearLayout linearLayout = this.f19411g;
                linearLayout.layout(i2, (int) (f2 - f3), i4, ((int) (f2 - f3)) + linearLayout.getHeight());
                this.f19413i.layout(i2, ((int) (this.k - this.j)) + this.f19411g.getHeight(), i4, i5);
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = this.f19411g;
        linearLayout2.layout(i2, i6, i4, linearLayout2.getMeasuredHeight() + i6);
        this.f19413i.layout(i2, this.o + this.f19411g.getMeasuredHeight(), i4, i5);
    }

    public void setBlankView(BlankView blankView) {
        this.f19409e = blankView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.f19413i = relativeLayout;
    }

    public void setEnableDragExit(boolean z) {
        this.r = z;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.f19412h = bdTypeListView;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.f19411g = linearLayout;
    }

    public void setTopView(View view) {
        this.f19410f = view;
    }

    public SubPbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SubPbView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.q = 0.0f;
        this.p = (l.i(context) / 3) - l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.o = l.i(context);
        ValueAnimator ofInt = ValueAnimator.ofInt(l.i(context), 0);
        this.n = ofInt;
        ofInt.setDuration(300L);
        this.n.setInterpolator(new LinearInterpolator());
        this.n.addUpdateListener(new a());
    }
}
