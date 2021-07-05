package com.bytedance.sdk.component.b.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f28011a;

    /* renamed from: b  reason: collision with root package name */
    public int f28012b;

    /* renamed from: c  reason: collision with root package name */
    public int f28013c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f28014d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28015e;

    /* renamed from: f  reason: collision with root package name */
    public o f28016f;

    /* renamed from: g  reason: collision with root package name */
    public o f28017g;

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
        this.f28011a = new byte[8192];
        this.f28015e = true;
        this.f28014d = false;
    }

    public final o a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.f28014d = true;
            return new o(this.f28011a, this.f28012b, this.f28013c, true, false);
        }
        return (o) invokeV.objValue;
    }

    public final o b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            o oVar = this.f28016f;
            if (oVar == this) {
                oVar = null;
            }
            o oVar2 = this.f28017g;
            oVar2.f28016f = this.f28016f;
            this.f28016f.f28017g = oVar2;
            this.f28016f = null;
            this.f28017g = null;
            return oVar;
        }
        return (o) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            o oVar = this.f28017g;
            if (oVar != this) {
                if (oVar.f28015e) {
                    int i2 = this.f28013c - this.f28012b;
                    if (i2 > (8192 - oVar.f28013c) + (oVar.f28014d ? 0 : oVar.f28012b)) {
                        return;
                    }
                    a(this.f28017g, i2);
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
            oVar.f28017g = this;
            oVar.f28016f = this.f28016f;
            this.f28016f.f28017g = oVar;
            this.f28016f = oVar;
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
        this.f28011a = bArr;
        this.f28012b = i2;
        this.f28013c = i3;
        this.f28014d = z;
        this.f28015e = z2;
    }

    public final o a(int i2) {
        InterceptResult invokeI;
        o a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 > 0 && i2 <= this.f28013c - this.f28012b) {
                if (i2 >= 1024) {
                    a2 = a();
                } else {
                    a2 = p.a();
                    System.arraycopy(this.f28011a, this.f28012b, a2.f28011a, 0, i2);
                }
                a2.f28013c = a2.f28012b + i2;
                this.f28012b += i2;
                this.f28017g.a(a2);
                return a2;
            }
            throw new IllegalArgumentException();
        }
        return (o) invokeI.objValue;
    }

    public final void a(o oVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, oVar, i2) == null) {
            if (oVar.f28015e) {
                int i3 = oVar.f28013c;
                if (i3 + i2 > 8192) {
                    if (!oVar.f28014d) {
                        int i4 = oVar.f28012b;
                        if ((i3 + i2) - i4 <= 8192) {
                            byte[] bArr = oVar.f28011a;
                            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
                            oVar.f28013c -= oVar.f28012b;
                            oVar.f28012b = 0;
                        } else {
                            throw new IllegalArgumentException();
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                System.arraycopy(this.f28011a, this.f28012b, oVar.f28011a, oVar.f28013c, i2);
                oVar.f28013c += i2;
                this.f28012b += i2;
                return;
            }
            throw new IllegalArgumentException();
        }
    }
}
