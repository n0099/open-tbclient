package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class vm6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        jo6 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65536, null) == null) && (b = b()) != null) {
            b.c();
        }
    }

    public static jo6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return (jo6) ServiceManager.getService(jo6.a);
        }
        return (jo6) invokeV.objValue;
    }

    public static void c() {
        jo6 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (b = b()) != null) {
            b.b();
        }
    }

    public static JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            jo6 b = b();
            if (b != null) {
                return b.a();
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }
}
