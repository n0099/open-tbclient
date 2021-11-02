package com.baidu.wallet.base.widget.pulltorefresh.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class RefreshLoadingDrawable extends Drawable {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f57893a = "RefreshLoadingView";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Paint f57894b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f57895c;

    /* renamed from: d  reason: collision with root package name */
    public int f57896d;

    /* renamed from: e  reason: collision with root package name */
    public int f57897e;

    /* renamed from: f  reason: collision with root package name */
    public int f57898f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f57899g;

    /* renamed from: h  reason: collision with root package name */
    public Path f57900h;

    /* renamed from: i  reason: collision with root package name */
    public int f57901i;
    public Context j;

    public RefreshLoadingDrawable(Context context, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57894b = new Paint();
        this.f57895c = new Paint();
        this.f57899g = new RectF();
        this.f57900h = new Path();
        i2 = i2 < 0 ? 0 : i2;
        this.f57896d = i3;
        Context applicationContext = DxmApplicationContextImpl.getApplicationContext(context);
        this.j = applicationContext;
        int dip2px = DisplayUtils.dip2px(applicationContext, 1.0f);
        this.f57897e = dip2px;
        int i6 = i2 + (dip2px * 2);
        this.f57901i = i6;
        this.f57894b.setAntiAlias(true);
        this.f57894b.setDither(true);
        this.f57894b.setColor(this.f57896d);
        this.f57894b.setStyle(Paint.Style.STROKE);
        this.f57894b.setStrokeJoin(Paint.Join.ROUND);
        this.f57894b.setStrokeCap(Paint.Cap.ROUND);
        this.f57894b.setStrokeWidth(this.f57897e);
        this.f57895c.set(this.f57894b);
        RectF rectF = this.f57899g;
        int i7 = this.f57897e;
        int i8 = this.f57901i;
        rectF.set(i7, i7, i8 - i7, i8 - i7);
        this.f57900h.reset();
        float f2 = i6;
        float f3 = 0.5f * f2;
        float f4 = 0.25f * f2;
        this.f57900h.moveTo(f3, f4);
        float f5 = f2 * 0.75f;
        this.f57900h.lineTo(f5, f3);
        this.f57900h.lineTo(f3, f5);
        this.f57900h.lineTo(f4, f3);
        this.f57900h.close();
    }

    public static RefreshLoadingDrawable newInstanceBlue(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? new RefreshLoadingDrawable(context, DisplayUtils.dip2px(DxmApplicationContextImpl.getApplicationContext(context), 18.0f), ResUtils.getColor(context, "wallet_base_font_text8Color")) : (RefreshLoadingDrawable) invokeL.objValue;
    }

    public static RefreshLoadingDrawable newInstanceRed(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new RefreshLoadingDrawable(context, DisplayUtils.dip2px(DxmApplicationContextImpl.getApplicationContext(context), 18.0f), ResUtils.getColor(context, "wallet_base_font_text6Color")) : (RefreshLoadingDrawable) invokeL.objValue;
    }

    public static RefreshLoadingDrawable newInstanceWhite(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? new RefreshLoadingDrawable(context, DisplayUtils.dip2px(DxmApplicationContextImpl.getApplicationContext(context), 18.0f), ResUtils.getColor(context, "wallet_base_whiteColor")) : (RefreshLoadingDrawable) invokeL.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            canvas.drawArc(this.f57899g, -90.0f, (this.f57898f * 360.0f) / 100.0f, false, this.f57894b);
            if (this.f57898f >= 100) {
                this.f57895c.setColor(this.f57896d);
                canvas.drawPath(this.f57900h, this.f57895c);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57901i : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f57901i : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, colorFilter) == null) {
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            if (i2 > 100) {
                i2 = 100;
            }
            if (this.f57898f == i2) {
                return;
            }
            this.f57898f = i2;
        }
    }
}
