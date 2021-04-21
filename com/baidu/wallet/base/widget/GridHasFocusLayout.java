package com.baidu.wallet.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.apollon.utils.DisplayUtils;
/* loaded from: classes5.dex */
public class GridHasFocusLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23510a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static final int f23511b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f23512c = 1;

    /* renamed from: d  reason: collision with root package name */
    public int f23513d;

    /* renamed from: e  reason: collision with root package name */
    public int f23514e;

    /* renamed from: f  reason: collision with root package name */
    public int f23515f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f23516g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f23517h;
    public Integer i;
    public int j;
    public boolean k;
    public Paint l;

    /* loaded from: classes5.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f23518a;

        /* renamed from: b  reason: collision with root package name */
        public int f23519b;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public GridHasFocusLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = null;
        this.j = -1;
        this.k = true;
        this.l = new Paint();
        a();
    }

    private void a() {
        this.f23513d = 3;
        this.f23514e = DisplayUtils.dip2px(getContext(), 1.0f);
        this.f23515f = DisplayUtils.dip2px(getContext(), 1.0f);
        this.f23516g = new RectF();
        this.f23517h = new Paint();
        this.l.setColor(-65536);
    }

    private void b() {
        this.j = -1;
        invalidate();
    }

    public void addSelectionView(View view) {
    }

    public void configFocusPaintColor(int i) {
        this.l.setColor(i);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        if (getChildCount() % this.f23513d == 0 || this.i == null) {
            return;
        }
        View childAt = getChildAt(getChildCount() - 1);
        this.f23516g.set(childAt.getLeft() + childAt.getWidth() + this.f23514e, childAt.getTop(), getLeft() + getWidth(), getTop() + getHeight());
        this.f23517h.setColor(this.i.intValue());
        canvas.drawRect(this.f23516g, this.f23517h);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i6 = layoutParams.f23518a;
                int i7 = layoutParams.f23519b;
                childAt.layout(i6, i7, ((ViewGroup.LayoutParams) layoutParams).width + i6, ((ViewGroup.LayoutParams) layoutParams).height + i7);
            }
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 0);
        int size = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int i3 = size - (this.k ? this.f23514e * 2 : 0);
        int i4 = this.f23514e;
        int i5 = this.f23513d;
        int i6 = (i3 - (i4 * (i5 - 1))) / i5;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, makeMeasureSpec);
                i8 = childAt.getMeasuredHeight();
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                if ((i9 - i7) % this.f23513d == 0) {
                    paddingLeft = getPaddingLeft() + (this.k ? this.f23514e : 0);
                    if (i9 != 0) {
                        paddingTop += this.f23515f + i8;
                    } else {
                        paddingTop = this.k ? this.f23515f : 0;
                    }
                } else {
                    paddingLeft += this.f23514e + i6;
                }
                if (childAt.getLayoutParams() != null && (childAt.getLayoutParams() instanceof LayoutParams)) {
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                } else {
                    LayoutParams layoutParams2 = new LayoutParams(0, 0);
                    childAt.setLayoutParams(layoutParams2);
                    layoutParams = layoutParams2;
                }
                layoutParams.f23518a = paddingLeft;
                layoutParams.f23519b = paddingTop;
                ((ViewGroup.LayoutParams) layoutParams).width = i6;
                ((ViewGroup.LayoutParams) layoutParams).height = i8;
            } else {
                i7++;
            }
        }
        int i10 = childCount - i7;
        int i11 = this.f23513d;
        int i12 = (i10 / i11) + (i10 % i11 == 0 ? 0 : 1);
        int i13 = this.f23515f;
        setMeasuredDimension(View.MeasureSpec.getSize(i), (i8 * i12) + ((i12 - 1) * i13) + (this.k ? i13 * 2 : 0));
    }

    public void setColumnCount(int i) {
        this.f23513d = i;
    }

    public void setEmptyAreaColor(int i) {
        this.i = Integer.valueOf(i);
    }

    public void setHorizontalSpacing(int i) {
        this.f23514e = i;
    }

    public void setSelection(int i) {
        this.j = i;
        invalidate();
    }

    public void setVerticalSpacing(int i) {
        this.f23515f = i;
    }

    public void showSideLine(boolean z) {
        this.k = z;
    }

    public GridHasFocusLayout(Context context) {
        super(context);
        this.i = null;
        this.j = -1;
        this.k = true;
        this.l = new Paint();
        a();
    }

    private void a(Canvas canvas) {
        this.l.setStrokeWidth(this.f23514e);
        int i = this.j;
        if (i < 0 || i >= getChildCount()) {
            return;
        }
        View childAt = getChildAt(this.j);
        float left = childAt.getLeft() - (this.k ? this.f23515f : 0);
        float top = childAt.getTop() - (this.k ? this.f23514e : 0);
        float left2 = ((childAt.getLeft() + childAt.getWidth()) + (this.k ? this.f23515f : 0)) - 1;
        float top2 = ((childAt.getTop() + childAt.getHeight()) + 0) - 1;
        canvas.drawLine(left, top, left, top2, this.l);
        canvas.drawLine(left, top2, left2, top2, this.l);
        canvas.drawLine(left, top, left2, top, this.l);
        canvas.drawLine(left2, top, left2, top2, this.l);
    }
}
