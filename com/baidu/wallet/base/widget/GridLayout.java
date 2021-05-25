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
    public static final int f23421a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static final int f23422b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f23423c = 1;

    /* renamed from: d  reason: collision with root package name */
    public int f23424d;

    /* renamed from: e  reason: collision with root package name */
    public int f23425e;

    /* renamed from: f  reason: collision with root package name */
    public int f23426f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f23427g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f23428h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f23429i;
    public int j;
    public Paint k;
    public Integer l;
    public int m;

    /* loaded from: classes5.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f23430a;

        /* renamed from: b  reason: collision with root package name */
        public int f23431b;

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
        this.f23429i = null;
        this.l = null;
        this.m = 0;
        a();
    }

    private void a() {
        this.f23424d = 3;
        this.f23425e = DisplayUtils.dip2px(getContext(), 1.0f);
        this.f23426f = DisplayUtils.dip2px(getContext(), 1.0f);
        this.f23427g = new RectF();
        this.f23428h = new Paint();
        this.k = new Paint();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.l != null && getChildCount() > this.f23424d && this.f23426f > 0) {
            float height = getChildAt(getChildCount() - 1).getHeight();
            for (int i2 = 1; i2 < Math.ceil((getChildCount() * 1.0f) / this.f23424d); i2++) {
                float f2 = i2 * height;
                canvas.drawRect(new RectF(getLeft() + this.j, getPaddingTop() + f2, getRight() - this.j, getPaddingTop() + f2 + this.f23426f), this.k);
            }
        }
        if (getChildCount() % this.f23424d == 0 || this.f23429i == null) {
            return;
        }
        View childAt = getChildAt(getChildCount() - 1);
        this.f23427g.set(childAt.getLeft() + childAt.getWidth() + this.f23425e, childAt.getTop(), getLeft() + getWidth(), getTop() + getHeight());
        this.f23428h.setColor(this.f23429i.intValue());
        canvas.drawRect(this.f23427g, this.f23428h);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i7 = layoutParams.f23430a;
                int i8 = layoutParams.f23431b;
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
        int i4 = this.f23425e;
        int i5 = this.f23424d;
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
                if ((i9 - i7) % this.f23424d == 0) {
                    paddingLeft = getPaddingLeft();
                    if (i9 != 0) {
                        paddingTop += this.m + this.f23426f;
                    }
                } else {
                    paddingLeft += this.f23425e + i6;
                }
                if (childAt.getLayoutParams() != null && (childAt.getLayoutParams() instanceof LayoutParams)) {
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                } else {
                    LayoutParams layoutParams2 = new LayoutParams(0, 0);
                    childAt.setLayoutParams(layoutParams2);
                    layoutParams = layoutParams2;
                }
                layoutParams.f23430a = paddingLeft;
                layoutParams.f23431b = paddingTop;
                ((ViewGroup.LayoutParams) layoutParams).width = i6;
                ((ViewGroup.LayoutParams) layoutParams).height = this.m;
            } else {
                i7++;
            }
        }
        int i10 = childCount - i7;
        int i11 = this.f23424d;
        int i12 = (i10 / i11) + (i10 % i11 != 0 ? 1 : 0);
        setMeasuredDimension(View.MeasureSpec.getSize(i2), (i8 * i12) + (this.f23426f * (i12 - 1)) + getPaddingTop() + getPaddingBottom());
    }

    public void setColumnCount(int i2) {
        this.f23424d = i2;
    }

    public void setEmptyAreaColor(int i2) {
        this.f23429i = Integer.valueOf(i2);
    }

    public void setHorizontalSpacing(int i2) {
        this.f23425e = i2;
    }

    public void setSeparateLine(int i2, int i3) {
        Integer valueOf = Integer.valueOf(i2);
        this.l = valueOf;
        this.j = i3;
        this.k.setColor(valueOf.intValue());
    }

    public void setVerticalSpacing(int i2) {
        this.f23426f = i2;
    }

    public GridLayout(Context context) {
        super(context);
        this.f23429i = null;
        this.l = null;
        this.m = 0;
        a();
    }
}
