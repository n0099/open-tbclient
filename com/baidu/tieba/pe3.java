package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.us2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class pe3 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948059115, "Lcom/baidu/tieba/pe3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948059115, "Lcom/baidu/tieba/pe3;");
                return;
            }
        }
        boolean z = ho1.a;
        a = 0;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a;
        }
        return invokeV.intValue;
    }

    public static void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, jSONObject) != null) || jSONObject == null) {
            return;
        }
        us2.a W = w73.K().q().W();
        String i = ch3.i(W.j0(), W.G());
        if (!jSONObject.has("appid")) {
            xk3.f(jSONObject, "appid", W.H());
        }
        if (!jSONObject.has("swan")) {
            xk3.f(jSONObject, "swan", i);
        }
        if (!jSONObject.has("appversion")) {
            xk3.f(jSONObject, "appversion", W.v1());
        }
        if (!jSONObject.has("swanNativeVersion")) {
            xk3.f(jSONObject, "swanNativeVersion", io1.a());
        }
        if (!jSONObject.has("thirdversion")) {
            xk3.f(jSONObject, "thirdversion", W.w1());
        }
        if (w73.K().q().y0() && !jSONObject.has("isWebDowngrade")) {
            xk3.f(jSONObject, "isWebDowngrade", "1");
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String o = pl3.o(str);
            if (TextUtils.isEmpty(o)) {
                return str;
            }
            HashSet hashSet = new HashSet();
            hashSet.add("bduss");
            hashSet.add("bduss".toUpperCase());
            String i = pl3.i(o, hashSet);
            String f = pl3.f(str);
            return f + "?" + i;
        }
        return (String) invokeL.objValue;
    }

    public static void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) {
            a = i;
        }
    }

    public static <EvenT extends ze3> EvenT f(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, event)) == null) {
            e(event, "isDownloading", String.valueOf(w73.K().q().F0() ? 1 : 0));
            return event;
        }
        return (EvenT) invokeL.objValue;
    }

    public static <EvenT extends ze3> EvenT g(EvenT event) {
        InterceptResult invokeL;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, event)) == null) {
            if (c() == 2) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                str = "2";
            } else {
                str = "1";
            }
            e(event, "launchType", str);
            return event;
        }
        return (EvenT) invokeL.objValue;
    }

    public static <EvenT extends ze3> EvenT h(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, event)) == null) {
            e(event, "packageState", String.valueOf(w73.K().q().E0()));
            return event;
        }
        return (EvenT) invokeL.objValue;
    }

    public static <EvenT extends ze3> EvenT i(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, event)) == null) {
            e(event, "coreState", String.valueOf(re2.B0()));
            return event;
        }
        return (EvenT) invokeL.objValue;
    }

    public static <EvenT extends ze3> EvenT e(EvenT event, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, event, str, obj)) == null) {
            if (event != null && !TextUtils.isEmpty(str)) {
                event.a(str, obj);
            }
            return event;
        }
        return (EvenT) invokeLLL.objValue;
    }
}
