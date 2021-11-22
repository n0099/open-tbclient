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
    public Paint f54271e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f54272f;

    /* renamed from: g  reason: collision with root package name */
    public float f54273g;

    /* renamed from: h  reason: collision with root package name */
    public int f54274h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f54275i;

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
        this.f54273g = 5.0f;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f54275i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
            Paint paint = new Paint();
            this.f54271e = paint;
            paint.setAntiAlias(true);
            this.f54271e.setDither(true);
            this.f54271e.setStyle(Paint.Style.STROKE);
            this.f54271e.setStrokeCap(Paint.Cap.ROUND);
            this.f54271e.setStrokeWidth(this.f54273g);
            Paint paint2 = new Paint();
            this.f54272f = paint2;
            paint2.setAntiAlias(true);
            this.f54272f.setDither(true);
            this.f54272f.setStyle(Paint.Style.STROKE);
            this.f54272f.setStrokeCap(Paint.Cap.ROUND);
            this.f54272f.setStrokeWidth(this.f54273g);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) || this.f54274h < 0) {
            return;
        }
        RectF rectF = this.f54275i;
        float f2 = this.f54273g;
        rectF.left = f2;
        rectF.top = f2;
        rectF.right = getWidth() - this.f54273g;
        this.f54275i.bottom = getHeight() - this.f54273g;
        canvas.drawArc(this.f54275i, 0.0f, 360.0f, false, this.f54272f);
        canvas.drawArc(this.f54275i, -90.0f, (this.f54274h / 100) * 360.0f, false, this.f54271e);
    }

    public void setCircleBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f54272f.setColor(i2);
            postInvalidate();
        }
    }

    public void setCircleForegroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f54271e.setColor(i2);
            postInvalidate();
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f54274h = i2;
            postInvalidate();
        }
    }

    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            float f2 = i2;
            this.f54273g = f2;
            this.f54272f.setStrokeWidth(f2);
            this.f54271e.setStrokeWidth(f2);
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
        this.f54273g = 5.0f;
        a();
    }
}
