package com.baidu.tieba;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class lh4 implements Interpolator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final PointF b;
    public final PointF c;

    public final double a(double d, double d2, double d3, double d4, double d5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)})) == null) {
            double d6 = 1.0d - d;
            double d7 = d * d;
            double d8 = d6 * d6;
            return (d8 * d6 * d2) + (d8 * 3.0d * d * d3) + (d6 * 3.0d * d7 * d4) + (d7 * d * d5);
        }
        return invokeCommon.doubleValue;
    }

    public lh4(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = new PointF();
        PointF pointF = new PointF();
        this.c = pointF;
        PointF pointF2 = this.b;
        pointF2.x = f;
        pointF2.y = f2;
        pointF.x = f3;
        pointF.y = f4;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
            int i = this.a;
            float f2 = f;
            while (true) {
                if (i >= 4096) {
                    break;
                }
                f2 = (i * 1.0f) / 4096.0f;
                if (a(f2, 0.0d, this.b.x, this.c.x, 1.0d) >= f) {
                    this.a = i;
                    break;
                }
                i++;
            }
            double a = a(f2, 0.0d, this.b.y, this.c.y, 1.0d);
            if (a > 0.999d) {
                a = 1.0d;
                this.a = 0;
            }
            return (float) a;
        }
        return invokeF.floatValue;
    }
}
