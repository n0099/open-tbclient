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
/* loaded from: classes6.dex */
public class ThumbView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f37149b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37150c;

    /* renamed from: d  reason: collision with root package name */
    public int f37151d;

    /* renamed from: e  reason: collision with root package name */
    public int f37152e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThumbView(Context context, int i, int i2, Drawable drawable) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), drawable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37151d = i;
        this.f37152e = i2;
        this.f37149b = drawable;
        this.a = (int) TypedValue.applyDimension(1, 15.0f, context.getResources().getDisplayMetrics());
        setBackgroundDrawable(this.f37149b);
    }

    public boolean a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            Rect rect = new Rect();
            getHitRect(rect);
            int i3 = rect.left;
            int i4 = this.a;
            rect.left = i3 - i4;
            rect.right += i4;
            rect.top -= i4;
            rect.bottom += i4;
            return rect.contains(i, i2);
        }
        return invokeII.booleanValue;
    }

    @Override // android.view.View
    public boolean isPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37150c : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f37151d, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f37152e, 1073741824));
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f37150c = z;
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, drawable) == null) {
            this.f37149b = drawable;
        }
    }

    public void setThumbHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f37152e = i;
        }
    }

    public void setThumbWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f37151d = i;
        }
    }
}
