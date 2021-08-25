package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.q.s;
/* loaded from: classes9.dex */
public class TTRatingBar extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f67094a;

    /* renamed from: b  reason: collision with root package name */
    public int f67095b;

    /* renamed from: c  reason: collision with root package name */
    public int f67096c;

    /* renamed from: d  reason: collision with root package name */
    public float f67097d;

    /* renamed from: e  reason: collision with root package name */
    public float f67098e;

    /* renamed from: f  reason: collision with root package name */
    public float f67099f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f67100g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f67101h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f67102i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TTRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67094a = 5;
        this.f67095b = 0;
        this.f67096c = 0;
        setOrientation(0);
        this.f67100g = t.c(context, "tt_star_empty_bg");
        this.f67101h = t.c(context, "tt_star_full_bg");
        this.f67102i = t.c(context, "tt_star_empty_bg");
        this.f67097d = s.d(context, 15.0f);
        this.f67098e = s.d(context, 15.0f);
        this.f67099f = s.d(context, 5.0f);
    }

    private ImageView getStarImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.f67097d), Math.round(this.f67098e)));
            imageView.setPadding(0, 0, Math.round(this.f67099f), 0);
            return imageView;
        }
        return (ImageView) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            removeAllViews();
            for (int i2 = 0; i2 < getStarFillNum(); i2++) {
                ImageView starImageView = getStarImageView();
                starImageView.setImageDrawable(getStarFillDrawable());
                addView(starImageView);
            }
            for (int i3 = 0; i3 < getStarHalfNum(); i3++) {
                ImageView starImageView2 = getStarImageView();
                starImageView2.setImageDrawable(getStarHalfDrawable());
                addView(starImageView2);
            }
            for (int i4 = 0; i4 < getStarEmptyNum(); i4++) {
                ImageView starImageView3 = getStarImageView();
                starImageView3.setImageDrawable(getStarEmptyDrawable());
                addView(starImageView3);
            }
        }
    }

    public Drawable getStarEmptyDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67100g : (Drawable) invokeV.objValue;
    }

    public int getStarEmptyNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f67096c : invokeV.intValue;
    }

    public Drawable getStarFillDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f67101h : (Drawable) invokeV.objValue;
    }

    public int getStarFillNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f67094a : invokeV.intValue;
    }

    public Drawable getStarHalfDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f67102i : (Drawable) invokeV.objValue;
    }

    public int getStarHalfNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f67095b : invokeV.intValue;
    }

    public float getStarImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f67098e : invokeV.floatValue;
    }

    public float getStarImagePadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f67099f : invokeV.floatValue;
    }

    public float getStarImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f67097d : invokeV.floatValue;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, drawable) == null) {
            this.f67100g = drawable;
        }
    }

    public void setStarEmptyNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f67096c = i2;
        }
    }

    public void setStarFillDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, drawable) == null) {
            this.f67101h = drawable;
        }
    }

    public void setStarFillNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f67094a = i2;
        }
    }

    public void setStarHalfDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, drawable) == null) {
            this.f67102i = drawable;
        }
    }

    public void setStarHalfNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f67095b = i2;
        }
    }

    public void setStarImageHeight(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.f67098e = f2;
        }
    }

    public void setStarImagePadding(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f2) == null) {
            this.f67099f = f2;
        }
    }

    public void setStarImageWidth(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f2) == null) {
            this.f67097d = f2;
        }
    }
}
