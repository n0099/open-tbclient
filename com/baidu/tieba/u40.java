package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.lcp.sdk.pb.LcmPb$Common;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class u40 {
    public static /* synthetic */ Interceptable $ic;
    public static a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = "";
            this.b = "";
            this.c = "";
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "CommonData{manufacture='" + this.a + "', userKey='" + this.b + "', modelType='" + this.c + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948160888, "Lcom/baidu/tieba/u40;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948160888, "Lcom/baidu/tieba/u40;");
                return;
            }
        }
        a = new a();
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                if (v40.a) {
                    w40.c("LCPCommon", "getAppVersionName NameNotFoundException", e);
                    return null;
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static Object b(Context context, boolean z) {
        InterceptResult invokeLZ;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, context, z)) == null) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            if (TextUtils.isEmpty(a(context))) {
                a2 = "";
            } else {
                a2 = a(context);
            }
            long currentTimeMillis = System.currentTimeMillis();
            String b = x40.b(context);
            String e = x40.e(context);
            try {
                if (z) {
                    if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(e)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, valueOf);
                        jSONObject.put("cuid", e);
                        jSONObject.put(HttpConstants.DEVICE_TYPE, "android");
                        jSONObject.put("app_id", b);
                        jSONObject.put("app_version", a2);
                        jSONObject.put("sdk_version", "3460016");
                        jSONObject.put("ts", currentTimeMillis);
                        jSONObject.put("manufacture", a.a);
                        jSONObject.put(ARPMessageType.ARPMessageParamKeys.MODEL_TYPE_KEY, a.c);
                        jSONObject.put("user_key", a.b);
                        jSONObject.put("sign", d(b, e, "android", currentTimeMillis));
                        return jSONObject;
                    }
                    if (v40.a) {
                        w40.b("LCPCommon", "getData appId : " + b + ", cuid :" + e);
                    }
                    return null;
                }
                String str = "nonNet";
                if (RequsetNetworkUtils.isNetworkAvailable(context)) {
                    if (RequsetNetworkUtils.isWifiConnected(context)) {
                        str = "wifi";
                    } else {
                        str = RequsetNetworkUtils.getMobileType(context);
                    }
                }
                w40.b("HEHE", "commonData :" + a.toString());
                LcmPb$Common.b newBuilder = LcmPb$Common.newBuilder();
                newBuilder.v(e);
                newBuilder.w("android");
                newBuilder.t(b);
                newBuilder.u(a2);
                newBuilder.A("3460016");
                newBuilder.z(str);
                newBuilder.x(a.a);
                newBuilder.y(a.c);
                newBuilder.B(a.b);
                return newBuilder.build();
            } catch (Exception e2) {
                if (v40.a) {
                    w40.c("LCPCommon", "getData :", e2);
                }
                return null;
            }
        }
        return invokeLZ.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    int i = b & 255;
                    if (i < 16) {
                        sb.append(0);
                    }
                    sb.append(Integer.toHexString(i));
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static String d(String str, String str2, String str3, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, str3, Long.valueOf(j)})) == null) {
            return c(String.format("%s%s%s%d", str, str2, str3, Long.valueOf(j)));
        }
        return (String) invokeCommon.objValue;
    }
}
