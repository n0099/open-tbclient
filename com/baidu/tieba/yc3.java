package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.dr2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class yc3 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948325312, "Lcom/baidu/tieba/yc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948325312, "Lcom/baidu/tieba/yc3;");
                return;
            }
        }
        boolean z = rm1.a;
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
        dr2.a X = f63.K().q().X();
        String i = lf3.i(X.k0(), X.H());
        if (!jSONObject.has("appid")) {
            gj3.f(jSONObject, "appid", X.I());
        }
        if (!jSONObject.has("swan")) {
            gj3.f(jSONObject, "swan", i);
        }
        if (!jSONObject.has("appversion")) {
            gj3.f(jSONObject, "appversion", X.x1());
        }
        if (!jSONObject.has("swanNativeVersion")) {
            gj3.f(jSONObject, "swanNativeVersion", sm1.a());
        }
        if (!jSONObject.has("thirdversion")) {
            gj3.f(jSONObject, "thirdversion", X.y1());
        }
        if (f63.K().q().z0() && !jSONObject.has("isWebDowngrade")) {
            gj3.f(jSONObject, "isWebDowngrade", "1");
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String o = yj3.o(str);
            if (TextUtils.isEmpty(o)) {
                return str;
            }
            HashSet hashSet = new HashSet();
            hashSet.add("bduss");
            hashSet.add("bduss".toUpperCase());
            String i = yj3.i(o, hashSet);
            String f = yj3.f(str);
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

    public static <EvenT extends id3> EvenT f(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, event)) == null) {
            e(event, "isDownloading", String.valueOf(f63.K().q().G0() ? 1 : 0));
            return event;
        }
        return (EvenT) invokeL.objValue;
    }

    public static <EvenT extends id3> EvenT g(EvenT event) {
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

    public static <EvenT extends id3> EvenT h(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, event)) == null) {
            e(event, "packageState", String.valueOf(f63.K().q().F0()));
            return event;
        }
        return (EvenT) invokeL.objValue;
    }

    public static <EvenT extends id3> EvenT i(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, event)) == null) {
            e(event, "coreState", String.valueOf(ad2.C0()));
            return event;
        }
        return (EvenT) invokeL.objValue;
    }

    public static <EvenT extends id3> EvenT e(EvenT event, String str, Object obj) {
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
