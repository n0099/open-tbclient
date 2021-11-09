package com.baidu.tieba.pluginCenter.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class CircleProgressBar extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f53352e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f53353f;

    /* renamed from: g  reason: collision with root package name */
    public float f53354g;

    /* renamed from: h  reason: collision with root package name */
    public int f53355h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f53356i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgressBar(Context context) {
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
        this.f53354g = 5.0f;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f53356i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
            Paint paint = new Paint();
            this.f53352e = paint;
            paint.setAntiAlias(true);
            this.f53352e.setDither(true);
            this.f53352e.setStyle(Paint.Style.STROKE);
            this.f53352e.setStrokeCap(Paint.Cap.ROUND);
            this.f53352e.setStrokeWidth(this.f53354g);
            Paint paint2 = new Paint();
            this.f53353f = paint2;
            paint2.setAntiAlias(true);
            this.f53353f.setDither(true);
            this.f53353f.setStyle(Paint.Style.STROKE);
            this.f53353f.setStrokeCap(Paint.Cap.ROUND);
            this.f53353f.setStrokeWidth(this.f53354g);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) || this.f53355h < 0) {
            return;
        }
        RectF rectF = this.f53356i;
        float f2 = this.f53354g;
        rectF.left = f2;
        rectF.top = f2;
        rectF.right = getWidth() - this.f53354g;
        this.f53356i.bottom = getHeight() - this.f53354g;
        canvas.drawArc(this.f53356i, 0.0f, 360.0f, false, this.f53353f);
        canvas.drawArc(this.f53356i, -90.0f, (this.f53355h / 100) * 360.0f, false, this.f53352e);
    }

    public void setCircleBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f53353f.setColor(i2);
            postInvalidate();
        }
    }

    public void setCircleForegroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f53352e.setColor(i2);
            postInvalidate();
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f53355h = i2;
            postInvalidate();
        }
    }

    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            float f2 = i2;
            this.f53354g = f2;
            this.f53353f.setStrokeWidth(f2);
            this.f53352e.setStrokeWidth(f2);
            postInvalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgressBar(Context context, AttributeSet attributeSet) {
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
        this.f53354g = 5.0f;
        a();
    }
}
