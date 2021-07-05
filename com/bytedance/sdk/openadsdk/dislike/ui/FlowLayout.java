package com.bytedance.sdk.openadsdk.dislike.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class FlowLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<List<View>> f30926a;

    /* renamed from: b  reason: collision with root package name */
    public List<Integer> f30927b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f30926a = new ArrayList();
        this.f30927b = new ArrayList();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, attributeSet)) == null) ? new ViewGroup.MarginLayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            Log.e("TAG", "onLayout");
            this.f30926a.clear();
            this.f30927b.clear();
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
                    this.f30927b.add(Integer.valueOf(i6));
                    this.f30926a.add(arrayList);
                    i6 = marginLayoutParams.bottomMargin + marginLayoutParams.topMargin + measuredHeight;
                    arrayList = new ArrayList();
                    i7 = 0;
                }
                int i9 = marginLayoutParams.leftMargin;
                int i10 = marginLayoutParams.rightMargin;
                i6 = Math.max(i6, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                arrayList.add(childAt);
            }
            this.f30927b.add(Integer.valueOf(i6));
            this.f30926a.add(arrayList);
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int size = this.f30926a.size();
            for (int i11 = 0; i11 < size; i11++) {
                List<View> list = this.f30926a.get(i11);
                int intValue = this.f30927b.get(i11).intValue();
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
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
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
                int i9 = i6 + measuredWidth;
                if (i9 - marginLayoutParams.rightMargin > (size - getPaddingLeft()) - getPaddingRight()) {
                    i4 = Math.max(i4, i6);
                    i5 += i7;
                    i7 = measuredHeight;
                    i6 = measuredWidth;
                } else {
                    i7 = Math.max(i7, measuredHeight);
                    i6 = i9;
                }
                if (i8 == childCount - 1) {
                    i4 = Math.max(i6, i4);
                    i5 += i7;
                }
            }
            Log.e("TAG", "sizeWidth = " + size + "|sizeHeight = " + size2);
            StringBuilder sb = new StringBuilder();
            sb.append("width = ");
            sb.append(i4);
            Log.e("TAG", sb.toString());
            Log.e("TAG", "height = " + i5);
            if (mode != 1073741824) {
                size = getPaddingRight() + i4 + getPaddingLeft();
            }
            if (mode2 != 1073741824) {
                size2 = i5 + getPaddingTop() + getPaddingBottom();
            }
            setMeasuredDimension(size, size2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlowLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
