package com.baidu.tieba;

import android.app.AppOpsManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o44 extends f44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947982266, "Lcom/baidu/tieba/o44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947982266, "Lcom/baidu/tieba/o44;");
                return;
            }
        }
        c = js1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o44() {
        super("GetAppUseDuration");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.f44
    public z32 a(@NonNull JSONObject jSONObject, @NonNull dp2 dp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, dp2Var)) == null) {
            if (jSONObject == null) {
                dp2Var.onFail(202, "params may be error");
                return null;
            }
            if (c) {
                Log.e("GetAppUseDuration", "params is " + jSONObject.toString());
            }
            String optString = jSONObject.optString("packageName");
            if (TextUtils.isEmpty(optString)) {
                dp2Var.onFail(202, "params may be error");
            } else {
                b(optString, dp2Var);
            }
            return null;
        }
        return (z32) invokeLL.objValue;
    }

    public final void b(String str, @NonNull dp2 dp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dp2Var) == null) {
            try {
                if (c()) {
                    PackageInfo packageInfo = AppRuntime.getAppContext().getPackageManager().getPackageInfo(str, 0);
                    if (packageInfo != null) {
                        List<UsageStats> queryUsageStats = ((UsageStatsManager) AppRuntime.getAppContext().getSystemService("usagestats")).queryUsageStats(3, packageInfo.firstInstallTime, Calendar.getInstance().getTimeInMillis());
                        if (queryUsageStats.size() == 0) {
                            dp2Var.onFail(101, "noPermission");
                            return;
                        }
                        for (UsageStats usageStats : queryUsageStats) {
                            if (TextUtils.equals(usageStats.getPackageName(), str)) {
                                JSONObject jSONObject = new JSONObject();
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("appUseDuration", usageStats.getTotalTimeInForeground());
                                jSONObject.put("data", jSONObject2);
                                dp2Var.onSuccess(jSONObject);
                                return;
                            }
                        }
                        dp2Var.onFail(31016, "no package info");
                        return;
                    }
                    dp2Var.onFail(31016, "no package info");
                    return;
                }
                dp2Var.onFail(101, "noPermission");
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                dp2Var.onFail(31011, "app is not installed");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (((AppOpsManager) AppRuntime.getAppContext().getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), AppRuntime.getAppContext().getPackageName()) == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
