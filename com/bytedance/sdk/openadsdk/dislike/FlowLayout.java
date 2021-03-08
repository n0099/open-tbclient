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
    private List<List<View>> f4662a;
    private List<Integer> b;

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4662a = new ArrayList();
        this.b = new ArrayList();
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
            if ((i8 + measuredWidth) - marginLayoutParams.rightMargin > (size - getPaddingLeft()) - getPaddingRight()) {
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
        this.f4662a.clear();
        this.b.clear();
        int width = getWidth();
        int i5 = 0;
        int i6 = 0;
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            i7++;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if ((measuredWidth * i7) + ((marginLayoutParams.leftMargin + marginLayoutParams.rightMargin) * (i7 - 1)) > (width - getPaddingLeft()) - getPaddingRight()) {
                this.b.add(Integer.valueOf(i6));
                this.f4662a.add(arrayList);
                i5 = 0;
                i6 = marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
                arrayList = new ArrayList();
                i7 = 0;
            }
            i5 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            i6 = Math.max(i6, marginLayoutParams.bottomMargin + marginLayoutParams.topMargin + measuredHeight);
            arrayList.add(childAt);
        }
        this.b.add(Integer.valueOf(i6));
        this.f4662a.add(arrayList);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.f4662a.size();
        int i9 = 0;
        int i10 = paddingTop;
        while (i9 < size) {
            List<View> list = this.f4662a.get(i9);
            int intValue = this.b.get(i9).intValue();
            int i11 = 0;
            while (true) {
                int i12 = i11;
                int i13 = paddingLeft;
                if (i12 < list.size()) {
                    View view = list.get(i12);
                    if (view.getVisibility() == 8) {
                        paddingLeft = i13;
                    } else {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i14 = marginLayoutParams2.leftMargin + i13;
                        int i15 = marginLayoutParams2.topMargin + i10;
                        view.layout(i14, i15, view.getMeasuredWidth() + i14, view.getMeasuredHeight() + i15);
                        paddingLeft = i13 + view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                    }
                    i11 = i12 + 1;
                }
            }
            paddingLeft = getPaddingLeft();
            i9++;
            i10 += intValue;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }
}
