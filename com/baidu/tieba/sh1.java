package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class sh1 {
    public static /* synthetic */ Interceptable $ic;
    public static long a;
    public static JSONObject b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948151309, "Lcom/baidu/tieba/sh1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948151309, "Lcom/baidu/tieba/sh1;");
                return;
            }
        }
        b = new JSONObject();
    }

    public static final void a(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65537, null, str, j) == null) {
            try {
                if (b == null) {
                    b = new JSONObject();
                }
                JSONObject jSONObject = b;
                if (jSONObject != null) {
                    jSONObject.put(str, j);
                }
            } catch (Exception unused) {
                fi1.g("add panelShow json error");
            }
        }
    }

    public static final void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("exceptionCode", 3);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("errno", str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("errmsg", str3);
                }
            } catch (Exception unused) {
            }
            th1 th1Var = new th1(str);
            th1Var.c(jSONObject);
            wh1.e(th1Var);
        }
    }

    public static final void c(String str, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, hashMap) == null) {
            if (hashMap != null) {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                th1 th1Var = new th1(str);
                th1Var.c(jSONObject);
                wh1.e(th1Var);
                return;
            }
            wh1.e(new th1(str));
        }
    }

    public static final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) && a > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("3", a);
                jSONObject.put("4", System.currentTimeMillis());
            } catch (Exception unused) {
            }
            th1 th1Var = new th1(Constants.DEFAULT_UIN);
            th1Var.c(jSONObject);
            wh1.e(th1Var);
            a = 0L;
        }
    }

    public static final void e() {
        JSONObject jSONObject;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, null) == null) && (jSONObject = b) != null) {
            if (jSONObject != null) {
                i = jSONObject.length();
            } else {
                i = 0;
            }
            if (i > 0) {
                a("2", System.currentTimeMillis());
                th1 th1Var = new th1(Constants.DEFAULT_UIN);
                th1Var.c(b);
                wh1.e(th1Var);
                b = null;
            }
        }
    }

    public static final void f(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65542, null, j) == null) {
            a = j;
        }
    }

    public static final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("exceptionCode", 0);
            } catch (Exception unused) {
            }
            th1 th1Var = new th1(str);
            th1Var.c(jSONObject);
            wh1.e(th1Var);
        }
    }

    public static final void g(int i, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i), str, str2, str3, str4}) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exceptionType", i);
            jSONObject.put("payChannel", str2);
            jSONObject.put(StatConstants.KEY_EXT_ERR_CODE, str3);
            jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, str4);
            th1 th1Var = new th1(str);
            th1Var.c(jSONObject);
            wh1.e(th1Var);
        }
    }
}
