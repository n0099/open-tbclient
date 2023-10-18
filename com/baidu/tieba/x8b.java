package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class x8b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s8b a;
    public static p8b b;
    public static r8b c;
    public static q8b d;
    public static r7b e;
    public static v7b f;
    public transient /* synthetic */ FieldHolder $fh;

    public x8b() {
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

    public static s8b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (x8b.class) {
                if (a == null) {
                    a = w8b.a();
                }
            }
            return a;
        }
        return (s8b) invokeV.objValue;
    }

    public static p8b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            p8b p8bVar = b;
            if (p8bVar != null) {
                return p8bVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                b = a.a();
            }
            return b;
        }
        return (p8b) invokeV.objValue;
    }

    public static q8b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            q8b q8bVar = d;
            if (q8bVar != null) {
                return q8bVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                d = a.e();
            }
            return d;
        }
        return (q8b) invokeV.objValue;
    }

    public static r8b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            r8b r8bVar = c;
            if (r8bVar != null) {
                return r8bVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                c = a.b();
            }
            return c;
        }
        return (r8b) invokeV.objValue;
    }

    public static r7b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            r7b r7bVar = e;
            if (r7bVar != null) {
                return r7bVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                e = a.c();
            }
            return e;
        }
        return (r7b) invokeV.objValue;
    }

    public static v7b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            v7b v7bVar = f;
            if (v7bVar != null) {
                return v7bVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                f = a.d();
            }
            return f;
        }
        return (v7b) invokeV.objValue;
    }
}
