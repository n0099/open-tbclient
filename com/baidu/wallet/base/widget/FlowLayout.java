package com.baidu.wallet.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class FlowLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f60619a = 6;

    /* renamed from: b  reason: collision with root package name */
    public static final int f60620b = 6;

    /* renamed from: c  reason: collision with root package name */
    public static final int f60621c = 55;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public int f60622d;

    /* renamed from: e  reason: collision with root package name */
    public int f60623e;

    /* renamed from: f  reason: collision with root package name */
    public int f60624f;

    /* renamed from: g  reason: collision with root package name */
    public int f60625g;

    /* renamed from: h  reason: collision with root package name */
    public int f60626h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60626h = 2;
    }

    public int getChildViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f60625g : invokeV.intValue;
    }

    public int getHorizontalChildNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60626h : invokeV.intValue;
    }

    public int getHorizontalSpacing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60623e : invokeV.intValue;
    }

    public int getVerticalSpacing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f60624f : invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
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
                        paddingLeft += this.f60623e + measuredWidth;
                        if ((measuredWidth + paddingLeft) - 1 > i6) {
                            paddingLeft = getPaddingLeft();
                            paddingTop += this.f60622d;
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            int size = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
            View.MeasureSpec.getSize(i3);
            getPaddingTop();
            getPaddingBottom();
            int childCount = getChildCount();
            int i4 = this.f60623e;
            int i5 = this.f60626h;
            int i6 = (size - (i4 * (i5 - 1))) / i5;
            int i7 = 0;
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                if (childAt.getVisibility() != 8) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f60625g, 1073741824));
                    i7 = Math.max(i7, childAt.getMeasuredHeight() + this.f60624f);
                }
            }
            this.f60622d = i7;
            int i9 = this.f60626h;
            int i10 = (childCount / i9) + (childCount % i9 != 0 ? 1 : 0);
            setMeasuredDimension(size, (this.f60625g * i10) + (this.f60624f * (i10 - 1)));
        }
    }

    public void setChildViewHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f60625g = i2;
        }
    }

    public void setHorizontalChildNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f60626h = i2;
        }
    }

    public void setHorizontalSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f60623e = i2;
        }
    }

    public void setVerticalSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f60624f = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f60626h = 2;
        this.f60623e = DisplayUtils.dip2px(context, 6.0f);
        this.f60624f = DisplayUtils.dip2px(context, 6.0f);
        this.f60625g = DisplayUtils.dip2px(context, 55.0f);
    }
}
