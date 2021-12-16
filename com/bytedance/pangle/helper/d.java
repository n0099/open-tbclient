package com.bytedance.pangle.helper;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.j;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public static SDKMonitor a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1168482262, "Lcom/bytedance/pangle/helper/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1168482262, "Lcom/bytedance/pangle/helper/d;");
        }
    }

    @NonNull
    public static SDKMonitor a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                a = SDKMonitorUtils.getInstance("7520");
            }
            return a;
        }
        return (SDKMonitor) invokeV.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x004d: IGET  (r7v6 int A[REMOVE]) = 
      (wrap: android.content.pm.PackageInfo : 0x0049: INVOKE  (r7v5 android.content.pm.PackageInfo A[REMOVE]) = 
      (wrap: android.content.pm.PackageManager : 0x0040: INVOKE  (r7v4 android.content.pm.PackageManager A[REMOVE]) = (r4v0 android.content.Context) type: VIRTUAL call: android.content.Context.getPackageManager():android.content.pm.PackageManager)
      (wrap: java.lang.String : 0x0044: INVOKE  (r2v3 java.lang.String A[REMOVE]) = (r4v0 android.content.Context) type: VIRTUAL call: android.content.Context.getPackageName():java.lang.String)
      (0 int)
     type: VIRTUAL call: android.content.pm.PackageManager.getPackageInfo(java.lang.String, int):android.content.pm.PackageInfo)
     android.content.pm.PackageInfo.versionCode int)] */
    public static synchronized void a(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, context, str, str2, str3) == null) {
            synchronized (d.class) {
                j.a().execute(new Runnable() { // from class: com.bytedance.pangle.helper.d.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            for (int i2 = 0; i2 < 5; i2++) {
                                SystemClock.sleep(2000L);
                                d.a().flushBuffer(new com.bytedance.pangle.log.b("flush buffer result : "));
                            }
                            d.a().flushReport(new com.bytedance.pangle.log.b("flush report result : "));
                        }
                    }
                });
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("device_id", str3);
                    jSONObject.putOpt("host_aid", str);
                    jSONObject.putOpt("channel", str2);
                    jSONObject.putOpt("sdk_version", "0.0.1-beta.53-bugfix.13-pangle");
                    if (context != null) {
                        jSONObject.putOpt("package_name", context.getPackageName());
                        StringBuilder sb = new StringBuilder();
                        sb.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
                        jSONObject.putOpt("app_version", sb.toString());
                    }
                } catch (JSONException | Exception unused) {
                }
                ZeusLogger.d("SDKMonitorHelper", "initSDKMonitor :" + jSONObject.toString());
                ArrayList arrayList = new ArrayList();
                arrayList.add("https://mon.snssdk.com/monitor/appmonitor/v2/settings");
                SDKMonitorUtils.setConfigUrl("7520", arrayList);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add("https://mon.snssdk.com/monitor/collect/");
                SDKMonitorUtils.setDefaultReportUrl("7520", arrayList2);
                SDKMonitorUtils.initMonitor(context, "7520", jSONObject, new SDKMonitor.IGetExtendParams() { // from class: com.bytedance.pangle.helper.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    public final Map<String, String> getCommonParams() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            return null;
                        }
                        return (Map) invokeV.objValue;
                    }

                    public final String getSessionId() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return null;
                        }
                        return (String) invokeV.objValue;
                    }
                });
            }
        }
    }
}
