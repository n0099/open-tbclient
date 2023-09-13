package com.baidu.tts;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.k;
import com.baidu.tts.l;
/* loaded from: classes9.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t0 a;
    public l.a b;
    public k.a c;

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            k.a aVar = this.c;
            if (aVar != null) {
                int i = aVar.a;
                if (i >= 0 && i < 10000) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public d a() {
        InterceptResult invokeV;
        d dVar;
        d dVar2;
        d dVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int ordinal = this.a.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        return null;
                    }
                    l.a aVar = this.b;
                    if (aVar != null) {
                        dVar = aVar.a;
                    } else {
                        dVar = null;
                    }
                    k.a aVar2 = this.c;
                    if (aVar2 != null) {
                        dVar2 = aVar2.e;
                    } else {
                        dVar2 = null;
                    }
                    if (dVar != null && dVar2 != null) {
                        dVar3 = z0.a().a(u0.n0);
                    } else if (dVar == null && dVar2 != null) {
                        dVar3 = z0.a().a(u0.P);
                    } else if (dVar != null) {
                        dVar3 = z0.a().a(u0.c);
                    } else {
                        dVar3 = null;
                    }
                    if (dVar3 == null) {
                        return null;
                    }
                    return dVar3;
                }
                return this.c.e;
            }
            return this.b.a;
        }
        return (d) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            t0 t0Var = this.a;
            if (t0Var == null) {
                return false;
            }
            int ordinal = t0Var.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        return false;
                    }
                    if (this.b != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z && !b()) {
                        return false;
                    }
                    return true;
                }
                return b();
            } else if (this.b == null) {
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }
}
