package com.baidu.ufosdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    public float c;
    public float d;
    public boolean e;
    public int f;
    public int g;
    public String h;

    public x() {
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
        this.f = 0;
        this.g = 2;
        this.h = null;
    }

    public x(float f, float f2, float f3, float f4, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = 0;
        this.g = 2;
        this.h = null;
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = z;
        this.h = str;
    }

    public int a(float f, float f2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (a(f, i, f2, i2)) {
                this.e = true;
                float f3 = this.a;
                int i3 = this.g;
                float f4 = i * i3;
                float f5 = f3 - f4;
                float f6 = this.b;
                float f7 = i3 * i2;
                float f8 = f6 - f7;
                float f9 = f6 + f7;
                if ((f5 - f) * ((f3 + f4) - f) < 0.0f && (f8 - f2) * (f9 - f2) < 0.0f) {
                    return 13;
                }
                float f10 = this.a;
                int i4 = this.g;
                float f11 = i * i4;
                float f12 = f10 - f11;
                float f13 = (this.b + this.d) / 2.0f;
                float f14 = i4 * i2;
                float f15 = f13 - f14;
                float f16 = f13 + f14;
                if ((f12 - f) * ((f10 + f11) - f) < 0.0f && (f15 - f2) * (f16 - f2) < 0.0f) {
                    return 1;
                }
                float f17 = this.a;
                int i5 = this.g;
                float f18 = i * i5;
                float f19 = f17 - f18;
                float f20 = this.d;
                float f21 = i5 * i2;
                float f22 = f20 - f21;
                float f23 = f20 + f21;
                if ((f19 - f) * ((f17 + f18) - f) < 0.0f && (f22 - f2) * (f23 - f2) < 0.0f) {
                    return 14;
                }
                float f24 = (this.a + this.c) / 2.0f;
                int i6 = this.g;
                float f25 = i * i6;
                float f26 = f24 - f25;
                float f27 = this.b;
                float f28 = i6 * i2;
                float f29 = f27 - f28;
                float f30 = f27 + f28;
                if ((f26 - f) * ((f24 + f25) - f) < 0.0f && (f29 - f2) * (f30 - f2) < 0.0f) {
                    return 3;
                }
                float f31 = (this.a + this.c) / 2.0f;
                int i7 = this.g;
                float f32 = i * i7;
                float f33 = f31 - f32;
                float f34 = this.d;
                float f35 = i7 * i2;
                float f36 = f34 - f35;
                float f37 = f34 + f35;
                if ((f33 - f) * ((f31 + f32) - f) < 0.0f && (f36 - f2) * (f37 - f2) < 0.0f) {
                    return 4;
                }
                float f38 = this.c;
                int i8 = this.g;
                float f39 = i * i8;
                float f40 = f38 - f39;
                float f41 = (this.b + this.d) / 2.0f;
                float f42 = i8 * i2;
                float f43 = f41 - f42;
                float f44 = f41 + f42;
                if ((f40 - f) * ((f38 + f39) - f) < 0.0f && (f43 - f2) * (f44 - f2) < 0.0f) {
                    return 2;
                }
                float f45 = this.c;
                int i9 = this.g;
                float f46 = i * i9;
                float f47 = f45 - f46;
                float f48 = this.d;
                float f49 = i9 * i2;
                float f50 = f48 - f49;
                float f51 = f48 + f49;
                if ((f47 - f) * ((f45 + f46) - f) < 0.0f && (f50 - f2) * (f51 - f2) < 0.0f) {
                    return 24;
                }
                float f52 = this.c;
                int i10 = this.g;
                float f53 = i * i10;
                float f54 = f52 - f53;
                float f55 = this.b;
                float f56 = i10 * i2;
                float f57 = f55 - f56;
                float f58 = f55 + f56;
                if ((f54 - f) * ((f52 + f53) - f) >= 0.0f || (f57 - f2) * (f58 - f2) >= 0.0f) {
                    return 0;
                }
                return 23;
            }
            this.e = false;
            return -1;
        }
        return invokeCommon.intValue;
    }

    public boolean a(float f, int i, float f2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)})) == null) {
            float f3 = i;
            if (((this.a - f3) - f) * ((this.c + f3) - f) < 0.0f) {
                float f4 = i2;
                if (((this.b - f4) - f2) * ((this.d + f4) - f2) < 0.0f) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
