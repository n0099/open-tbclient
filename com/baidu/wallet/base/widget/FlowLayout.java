package com.baidu.wallet.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.apollon.utils.DisplayUtils;
/* loaded from: classes5.dex */
public final class FlowLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23587a = 6;

    /* renamed from: b  reason: collision with root package name */
    public static final int f23588b = 6;

    /* renamed from: c  reason: collision with root package name */
    public static final int f23589c = 55;

    /* renamed from: d  reason: collision with root package name */
    public int f23590d;

    /* renamed from: e  reason: collision with root package name */
    public int f23591e;

    /* renamed from: f  reason: collision with root package name */
    public int f23592f;

    /* renamed from: g  reason: collision with root package name */
    public int f23593g;

    /* renamed from: h  reason: collision with root package name */
    public int f23594h;

    public FlowLayout(Context context) {
        super(context);
        this.f23594h = 2;
    }

    public int getChildViewHeight() {
        return this.f23593g;
    }

    public int getHorizontalChildNum() {
        return this.f23594h;
    }

    public int getHorizontalSpacing() {
        return this.f23591e;
    }

    public int getVerticalSpacing() {
        return this.f23592f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, childAt.getMeasuredHeight() + paddingTop);
                if (i7 != childCount - 1) {
                    paddingLeft += this.f23591e + measuredWidth;
                    if ((measuredWidth + paddingLeft) - 1 > i6) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += this.f23590d;
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int size = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
        View.MeasureSpec.getSize(i3);
        getPaddingTop();
        getPaddingBottom();
        int childCount = getChildCount();
        int i4 = this.f23591e;
        int i5 = this.f23594h;
        int i6 = (size - (i4 * (i5 - 1))) / i5;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f23593g, 1073741824));
                i7 = Math.max(i7, childAt.getMeasuredHeight() + this.f23592f);
            }
        }
        this.f23590d = i7;
        int i9 = this.f23594h;
        int i10 = (childCount / i9) + (childCount % i9 != 0 ? 1 : 0);
        setMeasuredDimension(size, (this.f23593g * i10) + (this.f23592f * (i10 - 1)));
    }

    public void setChildViewHeight(int i2) {
        this.f23593g = i2;
    }

    public void setHorizontalChildNum(int i2) {
        this.f23594h = i2;
    }

    public void setHorizontalSpacing(int i2) {
        this.f23591e = i2;
    }

    public void setVerticalSpacing(int i2) {
        this.f23592f = i2;
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23594h = 2;
        this.f23591e = DisplayUtils.dip2px(context, 6.0f);
        this.f23592f = DisplayUtils.dip2px(context, 6.0f);
        this.f23593g = DisplayUtils.dip2px(context, 55.0f);
    }
}
