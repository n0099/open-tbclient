package com.baidu.wallet.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.apollon.utils.DisplayUtils;
/* loaded from: classes5.dex */
public final class FlowLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23505a = 6;

    /* renamed from: b  reason: collision with root package name */
    public static final int f23506b = 6;

    /* renamed from: c  reason: collision with root package name */
    public static final int f23507c = 55;

    /* renamed from: d  reason: collision with root package name */
    public int f23508d;

    /* renamed from: e  reason: collision with root package name */
    public int f23509e;

    /* renamed from: f  reason: collision with root package name */
    public int f23510f;

    /* renamed from: g  reason: collision with root package name */
    public int f23511g;

    /* renamed from: h  reason: collision with root package name */
    public int f23512h;

    public FlowLayout(Context context) {
        super(context);
        this.f23512h = 2;
    }

    public int getChildViewHeight() {
        return this.f23511g;
    }

    public int getHorizontalChildNum() {
        return this.f23512h;
    }

    public int getHorizontalSpacing() {
        return this.f23509e;
    }

    public int getVerticalSpacing() {
        return this.f23510f;
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
                    paddingLeft += this.f23509e + measuredWidth;
                    if ((measuredWidth + paddingLeft) - 1 > i6) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += this.f23508d;
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
        int i4 = this.f23509e;
        int i5 = this.f23512h;
        int i6 = (size - (i4 * (i5 - 1))) / i5;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f23511g, 1073741824));
                i7 = Math.max(i7, childAt.getMeasuredHeight() + this.f23510f);
            }
        }
        this.f23508d = i7;
        int i9 = this.f23512h;
        int i10 = (childCount / i9) + (childCount % i9 != 0 ? 1 : 0);
        setMeasuredDimension(size, (this.f23511g * i10) + (this.f23510f * (i10 - 1)));
    }

    public void setChildViewHeight(int i2) {
        this.f23511g = i2;
    }

    public void setHorizontalChildNum(int i2) {
        this.f23512h = i2;
    }

    public void setHorizontalSpacing(int i2) {
        this.f23509e = i2;
    }

    public void setVerticalSpacing(int i2) {
        this.f23510f = i2;
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23512h = 2;
        this.f23509e = DisplayUtils.dip2px(context, 6.0f);
        this.f23510f = DisplayUtils.dip2px(context, 6.0f);
        this.f23511g = DisplayUtils.dip2px(context, 55.0f);
    }
}
