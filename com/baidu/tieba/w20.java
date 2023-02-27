package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class w20 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return v20.a().a("expInfo.txt");
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return v20.a().a("sapFile.txt");
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return v20.a().a("v1_.txt");
        }
        return (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return v20.a().a("v2_.txt");
        }
        return (String) invokeV.objValue;
    }

    public static String e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            return v20.a().a("v3_" + i + "_" + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION);
        }
        return (String) invokeI.objValue;
    }

    public static void f(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, jSONObject) == null) && jSONObject != null) {
            v20.a().b("expInfo.txt", jSONObject.toString());
        }
    }

    public static void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, jSONObject) == null) && jSONObject != null) {
            v20.a().b("sapFile.txt", jSONObject.toString());
        }
    }

    public static void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, jSONObject) == null) && jSONObject != null) {
            v20.a().b("v1_.txt", jSONObject.toString());
        }
    }

    public static void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, jSONObject) == null) && jSONObject != null) {
            v20.a().b("v2_.txt", jSONObject.toString());
        }
    }

    public static void j(JSONObject jSONObject, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65545, null, jSONObject, i) == null) && jSONObject != null) {
            z20 a = v20.a();
            a.b("v3_" + i + "_" + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION, jSONObject.toString());
        }
    }
}
