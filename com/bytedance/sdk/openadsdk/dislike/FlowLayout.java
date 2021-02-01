package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private List<List<View>> f7006a;

    /* renamed from: b  reason: collision with root package name */
    private List<Integer> f7007b;

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7006a = new ArrayList();
        this.f7007b = new ArrayList();
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i4 = 0;
        int i5 = 0;
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            measureChild(childAt, i, i2);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            if (i8 + measuredWidth > (size - getPaddingLeft()) - getPaddingRight()) {
                i4 = Math.max(i4, i8);
                i3 = i5 + i7;
            } else {
                measuredWidth += i8;
                measuredHeight = Math.max(i7, measuredHeight);
                i3 = i5;
            }
            if (i6 == childCount - 1) {
                i4 = Math.max(measuredWidth, i4);
                i3 += measuredHeight;
            }
            i6++;
            i7 = measuredHeight;
            i8 = measuredWidth;
            i5 = i3;
        }
        Log.e("TAG", "sizeWidth = " + size + "|sizeHeight = " + size2);
        Log.e("TAG", "width = " + i4);
        setMeasuredDimension(mode == 1073741824 ? size : getPaddingLeft() + i4 + getPaddingRight(), mode2 == 1073741824 ? size2 : getPaddingTop() + i5 + getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Log.e("TAG", "onLayout");
        this.f7006a.clear();
        this.f7007b.clear();
        int width = getWidth();
        int i5 = 0;
        int i6 = 0;
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredWidth + i5 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin > (width - getPaddingLeft()) - getPaddingRight()) {
                this.f7007b.add(Integer.valueOf(i6));
                this.f7006a.add(arrayList);
                i5 = 0;
                i6 = marginLayoutParams.bottomMargin + marginLayoutParams.topMargin + measuredHeight;
                arrayList = new ArrayList();
            }
            i5 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            i6 = Math.max(i6, marginLayoutParams.bottomMargin + marginLayoutParams.topMargin + measuredHeight);
            arrayList.add(childAt);
        }
        this.f7007b.add(Integer.valueOf(i6));
        this.f7006a.add(arrayList);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.f7006a.size();
        int i8 = 0;
        int i9 = paddingTop;
        while (i8 < size) {
            List<View> list = this.f7006a.get(i8);
            int intValue = this.f7007b.get(i8).intValue();
            int i10 = 0;
            while (true) {
                int i11 = i10;
                int i12 = paddingLeft;
                if (i11 < list.size()) {
                    View view = list.get(i11);
                    if (view.getVisibility() == 8) {
                        paddingLeft = i12;
                    } else {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i13 = marginLayoutParams2.leftMargin + i12;
                        int i14 = marginLayoutParams2.topMargin + i9;
                        view.layout(i13, i14, view.getMeasuredWidth() + i13, view.getMeasuredHeight() + i14);
                        paddingLeft = i12 + view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                    }
                    i10 = i11 + 1;
                }
            }
            paddingLeft = getPaddingLeft();
            i8++;
            i9 += intValue;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }
}
