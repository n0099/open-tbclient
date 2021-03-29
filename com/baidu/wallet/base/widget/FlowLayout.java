package com.baidu.wallet.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.apollon.utils.DisplayUtils;
/* loaded from: classes5.dex */
public final class FlowLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23809a = 6;

    /* renamed from: b  reason: collision with root package name */
    public static final int f23810b = 6;

    /* renamed from: c  reason: collision with root package name */
    public static final int f23811c = 55;

    /* renamed from: d  reason: collision with root package name */
    public int f23812d;

    /* renamed from: e  reason: collision with root package name */
    public int f23813e;

    /* renamed from: f  reason: collision with root package name */
    public int f23814f;

    /* renamed from: g  reason: collision with root package name */
    public int f23815g;

    /* renamed from: h  reason: collision with root package name */
    public int f23816h;

    public FlowLayout(Context context) {
        super(context);
        this.f23816h = 2;
    }

    public int getChildViewHeight() {
        return this.f23815g;
    }

    public int getHorizontalChildNum() {
        return this.f23816h;
    }

    public int getHorizontalSpacing() {
        return this.f23813e;
    }

    public int getVerticalSpacing() {
        return this.f23814f;
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
                    paddingLeft += this.f23813e + measuredWidth;
                    if ((measuredWidth + paddingLeft) - 1 > i5) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += this.f23812d;
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
        int i3 = this.f23813e;
        int i4 = this.f23816h;
        int i5 = (size - (i3 * (i4 - 1))) / i4;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f23815g, 1073741824));
                i6 = Math.max(i6, childAt.getMeasuredHeight() + this.f23814f);
            }
        }
        this.f23812d = i6;
        int i8 = this.f23816h;
        int i9 = (childCount / i8) + (childCount % i8 != 0 ? 1 : 0);
        setMeasuredDimension(size, (this.f23815g * i9) + (this.f23814f * (i9 - 1)));
    }

    public void setChildViewHeight(int i) {
        this.f23815g = i;
    }

    public void setHorizontalChildNum(int i) {
        this.f23816h = i;
    }

    public void setHorizontalSpacing(int i) {
        this.f23813e = i;
    }

    public void setVerticalSpacing(int i) {
        this.f23814f = i;
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23816h = 2;
        this.f23813e = DisplayUtils.dip2px(context, 6.0f);
        this.f23814f = DisplayUtils.dip2px(context, 6.0f);
        this.f23815g = DisplayUtils.dip2px(context, 55.0f);
    }
}
