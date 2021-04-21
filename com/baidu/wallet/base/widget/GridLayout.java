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
    public static final int f23520a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static final int f23521b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f23522c = 1;

    /* renamed from: d  reason: collision with root package name */
    public int f23523d;

    /* renamed from: e  reason: collision with root package name */
    public int f23524e;

    /* renamed from: f  reason: collision with root package name */
    public int f23525f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f23526g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f23527h;
    public Integer i;
    public int j;
    public Paint k;
    public Integer l;
    public int m;

    /* loaded from: classes5.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f23528a;

        /* renamed from: b  reason: collision with root package name */
        public int f23529b;

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

    public GridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = null;
        this.l = null;
        this.m = 0;
        a();
    }

    private void a() {
        this.f23523d = 3;
        this.f23524e = DisplayUtils.dip2px(getContext(), 1.0f);
        this.f23525f = DisplayUtils.dip2px(getContext(), 1.0f);
        this.f23526g = new RectF();
        this.f23527h = new Paint();
        this.k = new Paint();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.l != null && getChildCount() > this.f23523d && this.f23525f > 0) {
            float height = getChildAt(getChildCount() - 1).getHeight();
            for (int i = 1; i < Math.ceil((getChildCount() * 1.0f) / this.f23523d); i++) {
                float f2 = i * height;
                canvas.drawRect(new RectF(getLeft() + this.j, getPaddingTop() + f2, getRight() - this.j, getPaddingTop() + f2 + this.f23525f), this.k);
            }
        }
        if (getChildCount() % this.f23523d == 0 || this.i == null) {
            return;
        }
        View childAt = getChildAt(getChildCount() - 1);
        this.f23526g.set(childAt.getLeft() + childAt.getWidth() + this.f23524e, childAt.getTop(), getLeft() + getWidth(), getTop() + getHeight());
        this.f23527h.setColor(this.i.intValue());
        canvas.drawRect(this.f23526g, this.f23527h);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i6 = layoutParams.f23528a;
                int i7 = layoutParams.f23529b;
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
        int i3 = this.f23524e;
        int i4 = this.f23523d;
        int i5 = (size - (i3 * (i4 - 1))) / i4;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, makeMeasureSpec);
                i7 = childAt.getMeasuredHeight();
                if (this.m <= i7) {
                    this.m = i7;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(this.m, 1073741824));
                if ((i8 - i6) % this.f23523d == 0) {
                    paddingLeft = getPaddingLeft();
                    if (i8 != 0) {
                        paddingTop += this.m + this.f23525f;
                    }
                } else {
                    paddingLeft += this.f23524e + i5;
                }
                if (childAt.getLayoutParams() != null && (childAt.getLayoutParams() instanceof LayoutParams)) {
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                } else {
                    LayoutParams layoutParams2 = new LayoutParams(0, 0);
                    childAt.setLayoutParams(layoutParams2);
                    layoutParams = layoutParams2;
                }
                layoutParams.f23528a = paddingLeft;
                layoutParams.f23529b = paddingTop;
                ((ViewGroup.LayoutParams) layoutParams).width = i5;
                ((ViewGroup.LayoutParams) layoutParams).height = this.m;
            } else {
                i6++;
            }
        }
        int i9 = childCount - i6;
        int i10 = this.f23523d;
        int i11 = (i9 / i10) + (i9 % i10 != 0 ? 1 : 0);
        setMeasuredDimension(View.MeasureSpec.getSize(i), (i7 * i11) + (this.f23525f * (i11 - 1)) + getPaddingTop() + getPaddingBottom());
    }

    public void setColumnCount(int i) {
        this.f23523d = i;
    }

    public void setEmptyAreaColor(int i) {
        this.i = Integer.valueOf(i);
    }

    public void setHorizontalSpacing(int i) {
        this.f23524e = i;
    }

    public void setSeparateLine(int i, int i2) {
        Integer valueOf = Integer.valueOf(i);
        this.l = valueOf;
        this.j = i2;
        this.k.setColor(valueOf.intValue());
    }

    public void setVerticalSpacing(int i) {
        this.f23525f = i;
    }

    public GridLayout(Context context) {
        super(context);
        this.i = null;
        this.l = null;
        this.m = 0;
        a();
    }
}
