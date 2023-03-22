package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class rm1 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public static String c;
    public static String d;
    public transient /* synthetic */ FieldHolder $fh;

    public rm1() {
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

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                if (TextUtils.isEmpty(a)) {
                    a = cn1.b(context);
                }
                if (TextUtils.isEmpty(a)) {
                    return "";
                }
                return a;
            } catch (Throwable th) {
                cn1.d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                if (TextUtils.isEmpty(b)) {
                    b = cn1.e(context);
                }
                if (TextUtils.isEmpty(b)) {
                    return "";
                }
                return b;
            } catch (Throwable th) {
                cn1.d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                if (TextUtils.isEmpty(c)) {
                    c = context.getPackageName();
                }
                if (TextUtils.isEmpty(c)) {
                    return "";
                }
                return c;
            } catch (Throwable th) {
                cn1.d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static JSONObject c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("1", b(context));
                jSONObject.put("3", d(context));
                jSONObject.put("2", e(context));
                jSONObject.put("4", f(context));
                jSONObject.put("5", str);
                jSONObject.put("6", System.currentTimeMillis());
                jSONObject.put("7", "0");
                jSONObject.put("8", ll1.b);
                jSONObject.put("9", AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO);
                jSONObject.put("10", "1.2.1");
                jSONObject.put("14", cn1.g(context));
                jSONObject.put("23", om1.a(context));
                jSONObject.put("26", "");
                jSONObject.put(PayUVEventType.PAY_SPLIT_ORDER_PAGE_SHOW, ml1.g(context).F());
                return jSONObject;
            } catch (Throwable th) {
                cn1.d(th);
                return null;
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                if (!TextUtils.isEmpty(d)) {
                    return d;
                }
                String b2 = dn1.b(context);
                d = b2;
                return b2;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public um1 a(Context context, String str, String str2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(str);
                JSONObject c2 = c(context, str2);
                c2.put("module_section", jSONArray);
                um1 um1Var = new um1();
                um1Var.e(i);
                um1Var.c(c2.toString());
                um1Var.g(i2);
                return um1Var;
            } catch (Throwable th) {
                cn1.d(th);
                return null;
            }
        }
        return (um1) invokeCommon.objValue;
    }
}
