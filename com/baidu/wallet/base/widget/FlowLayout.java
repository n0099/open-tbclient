package com.baidu.wallet.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.apollon.utils.DisplayUtils;
/* loaded from: classes5.dex */
public final class FlowLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23494a = 6;

    /* renamed from: b  reason: collision with root package name */
    public static final int f23495b = 6;

    /* renamed from: c  reason: collision with root package name */
    public static final int f23496c = 55;

    /* renamed from: d  reason: collision with root package name */
    public int f23497d;

    /* renamed from: e  reason: collision with root package name */
    public int f23498e;

    /* renamed from: f  reason: collision with root package name */
    public int f23499f;

    /* renamed from: g  reason: collision with root package name */
    public int f23500g;

    /* renamed from: h  reason: collision with root package name */
    public int f23501h;

    public FlowLayout(Context context) {
        super(context);
        this.f23501h = 2;
    }

    public int getChildViewHeight() {
        return this.f23500g;
    }

    public int getHorizontalChildNum() {
        return this.f23501h;
    }

    public int getHorizontalSpacing() {
        return this.f23498e;
    }

    public int getVerticalSpacing() {
        return this.f23499f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, childAt.getMeasuredHeight() + paddingTop);
                if (i6 != childCount - 1) {
                    paddingLeft += this.f23498e + measuredWidth;
                    if ((measuredWidth + paddingLeft) - 1 > i5) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += this.f23497d;
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        View.MeasureSpec.getSize(i2);
        getPaddingTop();
        getPaddingBottom();
        int childCount = getChildCount();
        int i3 = this.f23498e;
        int i4 = this.f23501h;
        int i5 = (size - (i3 * (i4 - 1))) / i4;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f23500g, 1073741824));
                i6 = Math.max(i6, childAt.getMeasuredHeight() + this.f23499f);
            }
        }
        this.f23497d = i6;
        int i8 = this.f23501h;
        int i9 = (childCount / i8) + (childCount % i8 != 0 ? 1 : 0);
        setMeasuredDimension(size, (this.f23500g * i9) + (this.f23499f * (i9 - 1)));
    }

    public void setChildViewHeight(int i) {
        this.f23500g = i;
    }

    public void setHorizontalChildNum(int i) {
        this.f23501h = i;
    }

    public void setHorizontalSpacing(int i) {
        this.f23498e = i;
    }

    public void setVerticalSpacing(int i) {
        this.f23499f = i;
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23501h = 2;
        this.f23498e = DisplayUtils.dip2px(context, 6.0f);
        this.f23499f = DisplayUtils.dip2px(context, 6.0f);
        this.f23500g = DisplayUtils.dip2px(context, 55.0f);
    }
}
