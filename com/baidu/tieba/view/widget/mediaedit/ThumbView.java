package com.baidu.tieba.view.widget.mediaedit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes7.dex */
public class ThumbView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f58576e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f58577f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58578g;

    /* renamed from: h  reason: collision with root package name */
    public int f58579h;

    /* renamed from: i  reason: collision with root package name */
    public int f58580i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThumbView(Context context, int i2, int i3, Drawable drawable) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), drawable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58579h = i2;
        this.f58580i = i3;
        this.f58577f = drawable;
        this.f58576e = (int) TypedValue.applyDimension(1, 15.0f, context.getResources().getDisplayMetrics());
        setBackgroundDrawable(this.f58577f);
    }

    public boolean inInTarget(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            Rect rect = new Rect();
            getHitRect(rect);
            int i4 = rect.left;
            int i5 = this.f58576e;
            rect.left = i4 - i5;
            rect.right += i5;
            rect.top -= i5;
            rect.bottom += i5;
            return rect.contains(i2, i3);
        }
        return invokeII.booleanValue;
    }

    @Override // android.view.View
    public boolean isPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f58578g : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f58579h, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f58580i, 1073741824));
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f58578g = z;
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, drawable) == null) {
            this.f58577f = drawable;
        }
    }

    public void setThumbHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f58580i = i2;
        }
    }

    public void setThumbWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f58579h = i2;
        }
    }
}
