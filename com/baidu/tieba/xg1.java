package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class xg1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            Context a = ki1.a();
            Intrinsics.checkExpressionValueIsNotNull(a, "SdkRunTime.getAppContext()");
            PackageManager packageManager = a.getPackageManager();
            try {
                Context a2 = ki1.a();
                Intrinsics.checkExpressionValueIsNotNull(a2, "SdkRunTime.getAppContext()");
                String str = packageManager.getPackageInfo(a2.getPackageName(), 0).packageName;
                Intrinsics.checkExpressionValueIsNotNull(str, "packageInfo.packageName");
                return str;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            Context a = ki1.a();
            Intrinsics.checkExpressionValueIsNotNull(a, "SdkRunTime.getAppContext()");
            PackageManager packageManager = a.getPackageManager();
            try {
                Context a2 = ki1.a();
                Intrinsics.checkExpressionValueIsNotNull(a2, "SdkRunTime.getAppContext()");
                String str = packageManager.getPackageInfo(a2.getPackageName(), 0).versionName;
                Intrinsics.checkExpressionValueIsNotNull(str, "packageInfo.versionName");
                return str;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static final void c(qg1 qg1Var, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, qg1Var, str) == null) && qg1Var != null) {
            boolean z2 = false;
            if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                String a = qg1Var.a("Cookie");
                String str2 = "BDUSS=" + str;
                if ((a == null || StringsKt__StringsJVMKt.isBlank(a)) ? true : true) {
                    qg1Var.d("Cookie", str2);
                    return;
                }
                qg1Var.d("Cookie", a + "; " + str2);
            }
        }
    }

    public static final void d(qg1 qg1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, qg1Var) == null) && qg1Var != null) {
            qg1Var.d("channel", "cashiersdk");
            qg1Var.d("deviceType", "ANDROID");
            qg1Var.d("osVersion", Build.VERSION.RELEASE);
            qg1Var.d(com.heytap.mcssdk.constant.b.C, "2.8.7.9");
            qg1Var.d("appVersion", b());
            qg1Var.d("sdkPgName", a());
            qg1Var.d("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        }
    }

    public static final pg1 e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            pg1 pg1Var = new pg1();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    pg1Var.d(next, jSONObject.optString(next));
                }
            }
            return pg1Var;
        }
        return (pg1) invokeL.objValue;
    }
}
