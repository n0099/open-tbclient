package com.baidu.ufosdk.screencapedt;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f23512a;

    /* renamed from: b  reason: collision with root package name */
    public float f23513b;

    /* renamed from: c  reason: collision with root package name */
    public float f23514c;

    /* renamed from: d  reason: collision with root package name */
    public float f23515d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23516e;

    /* renamed from: f  reason: collision with root package name */
    public int f23517f;

    /* renamed from: g  reason: collision with root package name */
    public int f23518g;

    /* renamed from: h  reason: collision with root package name */
    public String f23519h;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23517f = 0;
        this.f23518g = 2;
        this.f23519h = null;
    }

    public a(float f2, float f3, float f4, float f5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f23517f = 0;
        this.f23518g = 2;
        this.f23519h = null;
        this.f23512a = f2;
        this.f23513b = f3;
        this.f23514c = f4;
        this.f23515d = f5;
        this.f23516e = true;
        this.f23519h = str;
    }

    public final int a(float f2, float f3, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (!a(f2, i2, f3, i3)) {
                this.f23516e = false;
                return -1;
            }
            this.f23516e = true;
            float f4 = this.f23512a;
            int i4 = this.f23518g;
            float f5 = f4 - (i2 * i4);
            float f6 = this.f23513b;
            float f7 = f6 - (i3 * i4);
            float f8 = f6 + (i4 * i3);
            if ((f5 - f2) * ((f4 + (i2 * i4)) - f2) >= 0.0f || (f7 - f3) * (f8 - f3) >= 0.0f) {
                float f9 = this.f23512a;
                int i5 = this.f23518g;
                float f10 = f9 - (i2 * i5);
                float f11 = this.f23513b;
                float f12 = this.f23515d;
                float f13 = ((f11 + f12) / 2.0f) - (i3 * i5);
                float f14 = ((f11 + f12) / 2.0f) + (i5 * i3);
                if ((f10 - f2) * ((f9 + (i2 * i5)) - f2) >= 0.0f || (f13 - f3) * (f14 - f3) >= 0.0f) {
                    float f15 = this.f23512a;
                    int i6 = this.f23518g;
                    float f16 = f15 - (i2 * i6);
                    float f17 = this.f23515d;
                    float f18 = f17 - (i3 * i6);
                    float f19 = f17 + (i6 * i3);
                    if ((f16 - f2) * ((f15 + (i2 * i6)) - f2) >= 0.0f || (f18 - f3) * (f19 - f3) >= 0.0f) {
                        float f20 = this.f23512a;
                        float f21 = this.f23514c;
                        int i7 = this.f23518g;
                        float f22 = ((f20 + f21) / 2.0f) - (i2 * i7);
                        float f23 = this.f23513b;
                        float f24 = f23 - (i3 * i7);
                        float f25 = f23 + (i7 * i3);
                        if ((f22 - f2) * ((((f20 + f21) / 2.0f) + (i2 * i7)) - f2) >= 0.0f || (f24 - f3) * (f25 - f3) >= 0.0f) {
                            float f26 = this.f23512a;
                            float f27 = this.f23514c;
                            int i8 = this.f23518g;
                            float f28 = ((f26 + f27) / 2.0f) - (i2 * i8);
                            float f29 = this.f23515d;
                            float f30 = f29 - (i3 * i8);
                            float f31 = f29 + (i8 * i3);
                            if ((f28 - f2) * ((((f26 + f27) / 2.0f) + (i2 * i8)) - f2) >= 0.0f || (f30 - f3) * (f31 - f3) >= 0.0f) {
                                float f32 = this.f23514c;
                                int i9 = this.f23518g;
                                float f33 = f32 - (i2 * i9);
                                float f34 = this.f23513b;
                                float f35 = this.f23515d;
                                float f36 = ((f34 + f35) / 2.0f) - (i3 * i9);
                                float f37 = ((f34 + f35) / 2.0f) + (i9 * i3);
                                if ((f33 - f2) * ((f32 + (i2 * i9)) - f2) >= 0.0f || (f36 - f3) * (f37 - f3) >= 0.0f) {
                                    float f38 = this.f23514c;
                                    int i10 = this.f23518g;
                                    float f39 = f38 - (i2 * i10);
                                    float f40 = this.f23515d;
                                    float f41 = f40 - (i3 * i10);
                                    float f42 = f40 + (i10 * i3);
                                    if ((f39 - f2) * ((f38 + (i2 * i10)) - f2) >= 0.0f || (f41 - f3) * (f42 - f3) >= 0.0f) {
                                        float f43 = this.f23514c;
                                        int i11 = this.f23518g;
                                        float f44 = f43 - (i11 * i2);
                                        float f45 = this.f23513b;
                                        return ((f44 - f2) * ((f43 + ((float) (i2 * i11))) - f2) >= 0.0f || ((f45 - ((float) (i11 * i3))) - f3) * ((f45 + ((float) (i11 * i3))) - f3) >= 0.0f) ? 0 : 23;
                                    }
                                    return 24;
                                }
                                return 2;
                            }
                            return 4;
                        }
                        return 3;
                    }
                    return 14;
                }
                return 1;
            }
            return 13;
        }
        return invokeCommon.intValue;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23519h : (String) invokeV.objValue;
    }

    public final void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
            this.f23512a = f2;
        }
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f23517f = i2;
        }
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f23516e = z;
        }
    }

    public final boolean a(float f2, int i2, float f3, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2), Float.valueOf(f3), Integer.valueOf(i3)})) == null) {
            float f4 = i2;
            if (((this.f23512a - f4) - f2) * ((this.f23514c + f4) - f2) < 0.0f) {
                float f5 = i3;
                return ((this.f23513b - f5) - f3) * ((this.f23515d + f5) - f3) < 0.0f;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f23512a : invokeV.floatValue;
    }

    public final void b(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            this.f23513b = f2;
        }
    }

    public final float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f23513b : invokeV.floatValue;
    }

    public final void c(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.f23514c = f2;
        }
    }

    public final float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f23514c : invokeV.floatValue;
    }

    public final void d(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f2) == null) {
            this.f23515d = f2;
        }
    }

    public final float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f23515d : invokeV.floatValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f23516e : invokeV.booleanValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f23517f : invokeV.intValue;
    }
}
