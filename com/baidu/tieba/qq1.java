package com.baidu.tieba;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qq1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = null;
    public static long b = 60000;
    public static long c;
    public static long d;
    public static long e;
    public static boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    public static void d(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948100376, "Lcom/baidu/tieba/qq1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948100376, "Lcom/baidu/tieba/qq1;");
                return;
            }
        }
        long j = b * 60;
        c = j;
        d = j * 24;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                Calendar calendar = Calendar.getInstance();
                int i = calendar.get(1);
                int i2 = calendar.get(5);
                return i + "" + (calendar.get(2) + 1) + "" + i2;
            } catch (Throwable th) {
                d(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
            } catch (Throwable th) {
                d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            try {
                return ((PowerManager) context.getSystemService("power")).isScreenOn();
            } catch (Throwable th) {
                d(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static JSONObject c(Context context, JSONObject jSONObject, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, jSONObject, str)) == null) {
            if (jSONObject == null) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("1", b(context));
                jSONObject2.put("2", context.getPackageName());
                jSONObject2.put("3", e(context));
                jSONObject2.put("4", rq1.b(context));
                jSONObject2.put("5", str);
                jSONObject2.put("6", System.currentTimeMillis());
                jSONObject2.put("7", "");
                jSONObject2.put("8", zo1.b);
                jSONObject2.put("9", AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO);
                jSONObject2.put("10", "1.2.1");
                jSONObject2.put("11", "");
                jSONObject2.put("12", "");
                jSONObject2.put("13", 1);
                jSONObject2.put("14", g(context));
                jSONObject2.put("26", "");
                jSONObject2.put("24", cq1.a(context));
                jSONObject2.put("module_section", jSONArray);
                return jSONObject2;
            } catch (Throwable th) {
                d(th);
                return null;
            }
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Throwable th;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                try {
                    if (TextUtils.isEmpty(str)) {
                        return "";
                    }
                } catch (Throwable th2) {
                    th = th2;
                    d(th);
                    return str;
                }
            } catch (Throwable th3) {
                th = th3;
                str = "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static int g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    return -1;
                }
                if (activeNetworkInfo.getType() == 1) {
                    return 1;
                }
                return f(context);
            } catch (Throwable th) {
                d(th);
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static int h(Context context) {
        InterceptResult invokeL;
        NetworkInfo networkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            context.deleteDatabase("");
            try {
                networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Throwable th) {
                d(th);
                networkInfo = null;
            }
            if (networkInfo == null) {
                return 0;
            }
            if (1 == networkInfo.getType()) {
                return 2;
            }
            networkInfo.getType();
            return 1;
        }
        return invokeL.intValue;
    }

    public static boolean n(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - e < 1000) {
                return f;
            }
            if (m(context) && k(context)) {
                z = true;
            } else {
                z = false;
            }
            f = z;
            e = currentTimeMillis;
            return z;
        }
        return invokeL.booleanValue;
    }

    public static int f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            try {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 3;
                    case 13:
                        return 4;
                    default:
                        return 5;
                }
            } catch (Throwable th) {
                d(th);
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            try {
                o(context);
                eq1.c(context).j();
                eq1.c(context).e();
                long currentTimeMillis = System.currentTimeMillis();
                long O = ap1.g(context).O();
                long q = ap1.g(context).q();
                long j = currentTimeMillis - O;
                if (j >= q) {
                    ap1.g(context).s(currentTimeMillis);
                    pq1.a(context, q);
                    return;
                }
                pq1.a(context, q - j);
            } catch (Throwable th) {
                d(th);
            }
        }
    }

    public static boolean l(Context context) {
        InterceptResult invokeL;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            try {
                if (!wq1.a(context, com.kuaishou.weapon.p0.h.e)) {
                    return true;
                }
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager.getRunningTasks(1) == null || (runningTaskInfo = activityManager.getRunningTasks(1).get(0)) == null) {
                    return false;
                }
                return context.getPackageName().equals(runningTaskInfo.topActivity.getPackageName());
            } catch (Throwable th) {
                d(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                if (!TextUtils.isEmpty(a)) {
                    return a;
                }
                String n0 = ap1.g(context).n0();
                a = n0;
                if (!TextUtils.isEmpty(n0)) {
                    return a;
                }
                Signature signature = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0];
                if (signature != null) {
                    String d2 = vq1.d(signature.toByteArray());
                    a = d2;
                    if (!TextUtils.isEmpty(d2)) {
                        ap1.g(context).U(a);
                        return a;
                    }
                    return "";
                }
                return "";
            } catch (Throwable th) {
                d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT < 21) {
                    return l(context);
                }
                if (context != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                        if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.importanceReasonCode == 0 && runningAppProcessInfo.pkgList != null && runningAppProcessInfo.pkgList.length != 0 && Arrays.asList(runningAppProcessInfo.pkgList).contains(context.getPackageName())) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            } catch (Throwable th) {
                d(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, context) == null) {
            try {
                String S = ap1.g(context).S();
                String a2 = a();
                if (!TextUtils.isEmpty(a2) && TextUtils.equals(S, a2)) {
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", context.getPackageName());
                jSONObject.put("1", e(context));
                jSONObject.put("2", "1.2.1");
                jSONObject.put("3", AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO);
                jSONObject.put("4", System.currentTimeMillis());
                jSONArray.put(jSONObject);
                eq1.c(context).f(jSONArray.toString(), "1077103", 2);
                ap1.g(context).t(a2);
            } catch (Throwable th) {
                d(th);
            }
        }
    }
}
