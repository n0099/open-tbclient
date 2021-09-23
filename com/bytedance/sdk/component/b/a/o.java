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
    public final byte[] f64749a;

    /* renamed from: b  reason: collision with root package name */
    public int f64750b;

    /* renamed from: c  reason: collision with root package name */
    public int f64751c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64752d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64753e;

    /* renamed from: f  reason: collision with root package name */
    public o f64754f;

    /* renamed from: g  reason: collision with root package name */
    public o f64755g;

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
        this.f64749a = new byte[8192];
        this.f64753e = true;
        this.f64752d = false;
    }

    public final o a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.f64752d = true;
            return new o(this.f64749a, this.f64750b, this.f64751c, true, false);
        }
        return (o) invokeV.objValue;
    }

    public final o b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            o oVar = this.f64754f;
            if (oVar == this) {
                oVar = null;
            }
            o oVar2 = this.f64755g;
            oVar2.f64754f = this.f64754f;
            this.f64754f.f64755g = oVar2;
            this.f64754f = null;
            this.f64755g = null;
            return oVar;
        }
        return (o) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            o oVar = this.f64755g;
            if (oVar != this) {
                if (oVar.f64753e) {
                    int i2 = this.f64751c - this.f64750b;
                    if (i2 > (8192 - oVar.f64751c) + (oVar.f64752d ? 0 : oVar.f64750b)) {
                        return;
                    }
                    a(this.f64755g, i2);
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
            oVar.f64755g = this;
            oVar.f64754f = this.f64754f;
            this.f64754f.f64755g = oVar;
            this.f64754f = oVar;
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
        this.f64749a = bArr;
        this.f64750b = i2;
        this.f64751c = i3;
        this.f64752d = z;
        this.f64753e = z2;
    }

    public final o a(int i2) {
        InterceptResult invokeI;
        o a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 > 0 && i2 <= this.f64751c - this.f64750b) {
                if (i2 >= 1024) {
                    a2 = a();
                } else {
                    a2 = p.a();
                    System.arraycopy(this.f64749a, this.f64750b, a2.f64749a, 0, i2);
                }
                a2.f64751c = a2.f64750b + i2;
                this.f64750b += i2;
                this.f64755g.a(a2);
                return a2;
            }
            throw new IllegalArgumentException();
        }
        return (o) invokeI.objValue;
    }

    public final void a(o oVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, oVar, i2) == null) {
            if (oVar.f64753e) {
                int i3 = oVar.f64751c;
                if (i3 + i2 > 8192) {
                    if (!oVar.f64752d) {
                        int i4 = oVar.f64750b;
                        if ((i3 + i2) - i4 <= 8192) {
                            byte[] bArr = oVar.f64749a;
                            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
                            oVar.f64751c -= oVar.f64750b;
                            oVar.f64750b = 0;
                        } else {
                            throw new IllegalArgumentException();
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                System.arraycopy(this.f64749a, this.f64750b, oVar.f64749a, oVar.f64751c, i2);
                oVar.f64751c += i2;
                this.f64750b += i2;
                return;
            }
            throw new IllegalArgumentException();
        }
    }
}
