package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class rec {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    public float c;
    public float d;
    public boolean e;

    public rec() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 1.0f;
        this.d = 1.0f;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public final float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return invokeV.floatValue;
    }

    public final float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return invokeV.floatValue;
    }

    public final float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return invokeV.floatValue;
    }

    public final float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return invokeV.floatValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a = 0.0f;
            this.b = 0.0f;
            this.c = 1.0f;
            this.d = 1.0f;
            this.e = false;
        }
    }

    public final void f(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), scaleType}) == null) && f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            g();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            boolean z = false;
            switch (qec.$EnumSwitchMapping$0[scaleType.ordinal()]) {
                case 1:
                    this.a = f5;
                    this.b = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.e = false;
                        this.c = f9;
                        this.d = f9;
                        this.a = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.e = true;
                    this.c = f10;
                    this.d = f10;
                    this.b = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.a = f5;
                        this.b = f6;
                        return;
                    } else if (f7 > f8) {
                        this.e = true;
                        this.c = f10;
                        this.d = f10;
                        this.b = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.e = false;
                        this.c = f9;
                        this.d = f9;
                        this.a = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.e = true;
                        this.c = f10;
                        this.d = f10;
                        this.b = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.e = false;
                    this.c = f9;
                    this.d = f9;
                    this.a = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.e = true;
                        this.c = f10;
                        this.d = f10;
                        return;
                    }
                    this.e = false;
                    this.c = f9;
                    this.d = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.e = true;
                        this.c = f10;
                        this.d = f10;
                        this.b = f2 - (f4 * f10);
                        return;
                    }
                    this.e = false;
                    this.c = f9;
                    this.d = f9;
                    this.a = f - (f3 * f9);
                    return;
                case 7:
                    Math.max(f10, f9);
                    if (f10 > f9) {
                        z = true;
                    }
                    this.e = z;
                    this.c = f10;
                    this.d = f9;
                    return;
                default:
                    this.e = true;
                    this.c = f10;
                    this.d = f10;
                    return;
            }
        }
    }
}
