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
public class GridLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public static final int f24247a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static final int f24248b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f24249c = 1;

    /* renamed from: d  reason: collision with root package name */
    public int f24250d;

    /* renamed from: e  reason: collision with root package name */
    public int f24251e;

    /* renamed from: f  reason: collision with root package name */
    public int f24252f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f24253g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f24254h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f24255i;
    public int j;
    public Paint k;
    public Integer l;
    public int m;

    /* loaded from: classes5.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f24256a;

        /* renamed from: b  reason: collision with root package name */
        public int f24257b;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public GridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24255i = null;
        this.l = null;
        this.m = 0;
        a();
    }

    private void a() {
        this.f24250d = 3;
        this.f24251e = DisplayUtils.dip2px(getContext(), 1.0f);
        this.f24252f = DisplayUtils.dip2px(getContext(), 1.0f);
        this.f24253g = new RectF();
        this.f24254h = new Paint();
        this.k = new Paint();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.l != null && getChildCount() > this.f24250d && this.f24252f > 0) {
            float height = getChildAt(getChildCount() - 1).getHeight();
            for (int i2 = 1; i2 < Math.ceil((getChildCount() * 1.0f) / this.f24250d); i2++) {
                float f2 = i2 * height;
                canvas.drawRect(new RectF(getLeft() + this.j, getPaddingTop() + f2, getRight() - this.j, getPaddingTop() + f2 + this.f24252f), this.k);
            }
        }
        if (getChildCount() % this.f24250d == 0 || this.f24255i == null) {
            return;
        }
        View childAt = getChildAt(getChildCount() - 1);
        this.f24253g.set(childAt.getLeft() + childAt.getWidth() + this.f24251e, childAt.getTop(), getLeft() + getWidth(), getTop() + getHeight());
        this.f24254h.setColor(this.f24255i.intValue());
        canvas.drawRect(this.f24253g, this.f24254h);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i7 = layoutParams.f24256a;
                int i8 = layoutParams.f24257b;
                childAt.layout(i7, i8, ((ViewGroup.LayoutParams) layoutParams).width + i7, ((ViewGroup.LayoutParams) layoutParams).height + i8);
            }
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i2, int i3) {
        LayoutParams layoutParams;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 0);
        int size = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int i4 = this.f24251e;
        int i5 = this.f24250d;
        int i6 = (size - (i4 * (i5 - 1))) / i5;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i2, makeMeasureSpec);
                i8 = childAt.getMeasuredHeight();
                if (this.m <= i8) {
                    this.m = i8;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(this.m, 1073741824));
                if ((i9 - i7) % this.f24250d == 0) {
                    paddingLeft = getPaddingLeft();
                    if (i9 != 0) {
                        paddingTop += this.m + this.f24252f;
                    }
                } else {
                    paddingLeft += this.f24251e + i6;
                }
                if (childAt.getLayoutParams() != null && (childAt.getLayoutParams() instanceof LayoutParams)) {
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                } else {
                    LayoutParams layoutParams2 = new LayoutParams(0, 0);
                    childAt.setLayoutParams(layoutParams2);
                    layoutParams = layoutParams2;
                }
                layoutParams.f24256a = paddingLeft;
                layoutParams.f24257b = paddingTop;
                ((ViewGroup.LayoutParams) layoutParams).width = i6;
                ((ViewGroup.LayoutParams) layoutParams).height = this.m;
            } else {
                i7++;
            }
        }
        int i10 = childCount - i7;
        int i11 = this.f24250d;
        int i12 = (i10 / i11) + (i10 % i11 != 0 ? 1 : 0);
        setMeasuredDimension(View.MeasureSpec.getSize(i2), (i8 * i12) + (this.f24252f * (i12 - 1)) + getPaddingTop() + getPaddingBottom());
    }

    public void setColumnCount(int i2) {
        this.f24250d = i2;
    }

    public void setEmptyAreaColor(int i2) {
        this.f24255i = Integer.valueOf(i2);
    }

    public void setHorizontalSpacing(int i2) {
        this.f24251e = i2;
    }

    public void setSeparateLine(int i2, int i3) {
        Integer valueOf = Integer.valueOf(i2);
        this.l = valueOf;
        this.j = i3;
        this.k.setColor(valueOf.intValue());
    }

    public void setVerticalSpacing(int i2) {
        this.f24252f = i2;
    }

    public GridLayout(Context context) {
        super(context);
        this.f24255i = null;
        this.l = null;
        this.m = 0;
        a();
    }
}
