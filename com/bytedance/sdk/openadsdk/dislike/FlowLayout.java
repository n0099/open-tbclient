package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public List<List<View>> f29658a;

    /* renamed from: b  reason: collision with root package name */
    public List<Integer> f29659b;

    public FlowLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f29658a = new ArrayList();
        this.f29659b = new ArrayList();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Log.e("TAG", "onLayout");
        this.f29658a.clear();
        this.f29659b.clear();
        int width = getWidth();
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            i7++;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if ((measuredWidth * i7) + ((marginLayoutParams.leftMargin + marginLayoutParams.rightMargin) * (i7 - 1)) > (width - getPaddingLeft()) - getPaddingRight()) {
                this.f29659b.add(Integer.valueOf(i6));
                this.f29658a.add(arrayList);
                i6 = marginLayoutParams.bottomMargin + marginLayoutParams.topMargin + measuredHeight;
                arrayList = new ArrayList();
                i7 = 0;
            }
            int i9 = marginLayoutParams.leftMargin;
            int i10 = marginLayoutParams.rightMargin;
            i6 = Math.max(i6, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
            arrayList.add(childAt);
        }
        this.f29659b.add(Integer.valueOf(i6));
        this.f29658a.add(arrayList);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.f29658a.size();
        for (int i11 = 0; i11 < size; i11++) {
            List<View> list = this.f29658a.get(i11);
            int intValue = this.f29659b.get(i11).intValue();
            for (int i12 = 0; i12 < list.size(); i12++) {
                View view = list.get(i12);
                if (view.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i13 = marginLayoutParams2.leftMargin + paddingLeft;
                    int i14 = marginLayoutParams2.topMargin + paddingTop;
                    view.layout(i13, i14, view.getMeasuredWidth() + i13, view.getMeasuredHeight() + i14);
                    paddingLeft += view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                }
            }
            paddingLeft = getPaddingLeft();
            paddingTop += intValue;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            measureChild(childAt, i2, i3);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            int i9 = i5 + measuredWidth;
            if (i9 - marginLayoutParams.rightMargin > (size - getPaddingLeft()) - getPaddingRight()) {
                i4 = Math.max(i4, i5);
                i7 += i6;
                i6 = measuredHeight;
                i5 = measuredWidth;
            } else {
                i6 = Math.max(i6, measuredHeight);
                i5 = i9;
            }
            if (i8 == childCount - 1) {
                i4 = Math.max(i5, i4);
                i7 += i6;
            }
        }
        Log.e("TAG", "sizeWidth = " + size + "|sizeHeight = " + size2);
        StringBuilder sb = new StringBuilder();
        sb.append("width = ");
        sb.append(i4);
        Log.e("TAG", sb.toString());
        if (mode != 1073741824) {
            size = getPaddingRight() + i4 + getPaddingLeft();
        }
        if (mode2 != 1073741824) {
            size2 = i7 + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, size2);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context) {
        this(context, null);
    }
}
