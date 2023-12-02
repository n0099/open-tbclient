package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class uqb {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pqb a;
    public static mqb b;
    public static oqb c;
    public static nqb d;
    public static opb e;
    public static spb f;
    public transient /* synthetic */ FieldHolder $fh;

    public uqb() {
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

    public static pqb d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (uqb.class) {
                if (a == null) {
                    a = tqb.a();
                }
            }
            return a;
        }
        return (pqb) invokeV.objValue;
    }

    public static mqb a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            mqb mqbVar = b;
            if (mqbVar != null) {
                return mqbVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                b = a.a();
            }
            return b;
        }
        return (mqb) invokeV.objValue;
    }

    public static nqb b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            nqb nqbVar = d;
            if (nqbVar != null) {
                return nqbVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                d = a.e();
            }
            return d;
        }
        return (nqb) invokeV.objValue;
    }

    public static oqb c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            oqb oqbVar = c;
            if (oqbVar != null) {
                return oqbVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                c = a.b();
            }
            return c;
        }
        return (oqb) invokeV.objValue;
    }

    public static opb e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            opb opbVar = e;
            if (opbVar != null) {
                return opbVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                e = a.c();
            }
            return e;
        }
        return (opb) invokeV.objValue;
    }

    public static spb f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            spb spbVar = f;
            if (spbVar != null) {
                return spbVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                f = a.d();
            }
            return f;
        }
        return (spb) invokeV.objValue;
    }
}
