package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.lcp.sdk.pb.LcmPb$Common;
import com.baidu.tieba.g80;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class j90 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{context, Long.valueOf(j), str, str2}) == null) {
            try {
                g80.c cVar = new g80.c(context);
                cVar.e(str);
                cVar.f("1");
                cVar.c(j);
                cVar.d(str2);
                cVar.a(501112L);
                cVar.b();
            } catch (Exception e) {
                l90.c("LCPCommon", "businessEvent exception ", e);
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static String e(String str, String str2, String str3, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, str3, Long.valueOf(j)})) == null) {
            return d(String.format("%s%s%s%d", str, str2, str3, Long.valueOf(j)));
        }
        return (String) invokeCommon.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                l90.c("LCPCommon", "getAppVersionName NameNotFoundException", e);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static Object c(Context context, boolean z) {
        InterceptResult invokeLZ;
        String b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, context, z)) == null) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            if (TextUtils.isEmpty(b(context))) {
                b = "";
            } else {
                b = b(context);
            }
            long currentTimeMillis = System.currentTimeMillis();
            String b2 = m90.b(context);
            String e = m90.e(context);
            try {
                if (z) {
                    if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(e)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, valueOf);
                        jSONObject.put("cuid", e);
                        jSONObject.put(HttpConstants.DEVICE_TYPE, "android");
                        jSONObject.put("app_id", b2);
                        jSONObject.put("app_version", b);
                        jSONObject.put("sdk_version", "2310016");
                        jSONObject.put("ts", currentTimeMillis);
                        jSONObject.put("sign", e(b2, e, "android", currentTimeMillis));
                        return jSONObject;
                    }
                    l90.b("LCPCommon", "getData appId : " + b2 + ", cuid :" + e);
                    return null;
                }
                LcmPb$Common.b newBuilder = LcmPb$Common.newBuilder();
                newBuilder.w(e);
                newBuilder.x("android");
                newBuilder.u(b2);
                newBuilder.v(b);
                newBuilder.y("2310016");
                return newBuilder.build();
            } catch (Exception e2) {
                l90.c("LCPCommon", "getData :", e2);
                return null;
            }
        }
        return invokeLZ.objValue;
    }

    public static String d(String str) {
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
}
