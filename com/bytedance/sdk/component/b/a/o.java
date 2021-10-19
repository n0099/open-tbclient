package com.bytedance.sdk.component.b.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f64784a;

    /* renamed from: b  reason: collision with root package name */
    public int f64785b;

    /* renamed from: c  reason: collision with root package name */
    public int f64786c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64787d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64788e;

    /* renamed from: f  reason: collision with root package name */
    public o f64789f;

    /* renamed from: g  reason: collision with root package name */
    public o f64790g;

    public o() {
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
        this.f64784a = new byte[8192];
        this.f64788e = true;
        this.f64787d = false;
    }

    public final o a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.f64787d = true;
            return new o(this.f64784a, this.f64785b, this.f64786c, true, false);
        }
        return (o) invokeV.objValue;
    }

    public final o b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            o oVar = this.f64789f;
            if (oVar == this) {
                oVar = null;
            }
            o oVar2 = this.f64790g;
            oVar2.f64789f = this.f64789f;
            this.f64789f.f64790g = oVar2;
            this.f64789f = null;
            this.f64790g = null;
            return oVar;
        }
        return (o) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            o oVar = this.f64790g;
            if (oVar != this) {
                if (oVar.f64788e) {
                    int i2 = this.f64786c - this.f64785b;
                    if (i2 > (8192 - oVar.f64786c) + (oVar.f64787d ? 0 : oVar.f64785b)) {
                        return;
                    }
                    a(this.f64790g, i2);
                    b();
                    p.a(this);
                    return;
                }
                return;
            }
            throw new IllegalStateException();
        }
    }

    public final o a(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oVar)) == null) {
            oVar.f64790g = this;
            oVar.f64789f = this.f64789f;
            this.f64789f.f64790g = oVar;
            this.f64789f = oVar;
            return oVar;
        }
        return (o) invokeL.objValue;
    }

    public o(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64784a = bArr;
        this.f64785b = i2;
        this.f64786c = i3;
        this.f64787d = z;
        this.f64788e = z2;
    }

    public final o a(int i2) {
        InterceptResult invokeI;
        o a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 > 0 && i2 <= this.f64786c - this.f64785b) {
                if (i2 >= 1024) {
                    a2 = a();
                } else {
                    a2 = p.a();
                    System.arraycopy(this.f64784a, this.f64785b, a2.f64784a, 0, i2);
                }
                a2.f64786c = a2.f64785b + i2;
                this.f64785b += i2;
                this.f64790g.a(a2);
                return a2;
            }
            throw new IllegalArgumentException();
        }
        return (o) invokeI.objValue;
    }

    public final void a(o oVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, oVar, i2) == null) {
            if (oVar.f64788e) {
                int i3 = oVar.f64786c;
                if (i3 + i2 > 8192) {
                    if (!oVar.f64787d) {
                        int i4 = oVar.f64785b;
                        if ((i3 + i2) - i4 <= 8192) {
                            byte[] bArr = oVar.f64784a;
                            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
                            oVar.f64786c -= oVar.f64785b;
                            oVar.f64785b = 0;
                        } else {
                            throw new IllegalArgumentException();
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                System.arraycopy(this.f64784a, this.f64785b, oVar.f64784a, oVar.f64786c, i2);
                oVar.f64786c += i2;
                this.f64785b += i2;
                return;
            }
            throw new IllegalArgumentException();
        }
    }
}
