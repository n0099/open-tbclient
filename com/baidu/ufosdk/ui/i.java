package com.baidu.ufosdk.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class i extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Paint f23558a;

    /* renamed from: b  reason: collision with root package name */
    public Path f23559b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context) {
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
        Paint paint = new Paint(1);
        this.f23558a = paint;
        paint.setColor(-3355444);
        this.f23558a.setStyle(Paint.Style.STROKE);
        this.f23558a.setStrokeWidth(3.0f);
        this.f23559b = new Path();
        this.f23558a.setPathEffect(new DashPathEffect(new float[]{15.0f, 5.0f}, 0.0f));
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.f23559b.reset();
            this.f23559b.moveTo(0.0f, 0.0f);
            this.f23559b.lineTo(getWidth(), 0.0f);
            canvas.drawPath(this.f23559b, this.f23558a);
        }
    }
}
