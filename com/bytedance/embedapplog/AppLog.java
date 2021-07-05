package com.bytedance.embedapplog;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import d.b.a.e1;
import d.b.a.h0;
import d.b.a.j1;
import d.b.a.n0;
import d.b.a.r;
import d.b.a.s;
import d.b.a.t;
import d.b.a.x;
import d.b.a.y1;
import d.b.a.z;
import d.b.a.z1;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class AppLog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String UMENG_CATEGORY = "umeng";
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile y1 f27564a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f27565b = true;

    /* renamed from: c  reason: collision with root package name */
    public static z f27566c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile IExtraParams f27567d;
    public static ConcurrentHashMap<String, String> sCustomNetParams;
    @SuppressLint({"StaticFieldLeak"})
    public static z1 sDevice;
    public static IAppParam sIAppParam;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2050468249, "Lcom/bytedance/embedapplog/AppLog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2050468249, "Lcom/bytedance/embedapplog/AppLog;");
                return;
            }
        }
        f27566c = new z();
        sCustomNetParams = new ConcurrentHashMap<>(4);
    }

    public AppLog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        h0.b(null);
    }

    public static <T> T a(Object obj, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, obj, t)) == null) {
            if (obj == null) {
                obj = null;
            }
            return obj == null ? t : (T) obj;
        }
        return (T) invokeLL.objValue;
    }

    public static void addDataObserver(IDataObserver iDataObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, iDataObserver) == null) {
            f27566c.a(iDataObserver);
        }
    }

    public static void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, null) == null) {
            j1.b();
        }
    }

    @Nullable
    public static <T> T getAbConfig(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, t)) == null) {
            if (f27564a != null) {
                JSONObject B = f27564a.B(str);
                if (B != null) {
                    String optString = B.optString(TiebaStatic.Params.VID);
                    Object opt = B.opt("val");
                    sDevice.u(optString);
                    return (T) a(opt, t);
                }
                return t;
            }
            return null;
        }
        return (T) invokeLL.objValue;
    }

    @Nullable
    public static String getAbConfigVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f27564a != null) {
                return f27564a.U();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String getAbSDKVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            z1 z1Var = sDevice;
            if (z1Var != null) {
                return z1Var.F();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String getAid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            z1 z1Var = sDevice;
            return z1Var != null ? z1Var.w() : "";
        }
        return (String) invokeV.objValue;
    }

    public static boolean getAutoActiveState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? f27565b : invokeV.booleanValue;
    }

    public static String getClientUdid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            z1 z1Var = sDevice;
            return z1Var != null ? z1Var.B() : "";
        }
        return (String) invokeV.objValue;
    }

    public static ConcurrentHashMap<String, String> getCustomNetParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? sCustomNetParams : (ConcurrentHashMap) invokeV.objValue;
    }

    @NonNull
    public static IDataObserver getDataObserver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? f27566c : (IDataObserver) invokeV.objValue;
    }

    public static String getDid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            z1 z1Var = sDevice;
            return z1Var != null ? z1Var.v() : "";
        }
        return (String) invokeV.objValue;
    }

    public static boolean getEncryptAndCompress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public static IExtraParams getExtraParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? f27567d : (IExtraParams) invokeV.objValue;
    }

    public static <T> T getHeaderValue(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, str, t)) == null) {
            z1 z1Var = sDevice;
            if (z1Var != null) {
                return (T) z1Var.a(str, t);
            }
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public static IAppParam getIAppParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? sIAppParam : (IAppParam) invokeV.objValue;
    }

    public static String getIid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            z1 z1Var = sDevice;
            return z1Var != null ? z1Var.y() : "";
        }
        return (String) invokeV.objValue;
    }

    public static InitConfig getInitConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            if (f27564a != null) {
                return f27564a.o();
            }
            return null;
        }
        return (InitConfig) invokeV.objValue;
    }

    public static String getOpenUdid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            z1 z1Var = sDevice;
            return z1Var != null ? z1Var.C() : "";
        }
        return (String) invokeV.objValue;
    }

    public static String getSsid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            z1 z1Var = sDevice;
            return z1Var != null ? z1Var.z() : "";
        }
        return (String) invokeV.objValue;
    }

    public static int getSuccRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            if (f27564a != null) {
                return f27564a.J();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static String getUdid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            z1 z1Var = sDevice;
            return z1Var != null ? z1Var.x() : "";
        }
        return (String) invokeV.objValue;
    }

    public static String getUserUniqueID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            z1 z1Var = sDevice;
            return z1Var != null ? z1Var.A() : "";
        }
        return (String) invokeV.objValue;
    }

    public static void init(@NonNull Context context, @NonNull InitConfig initConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, context, initConfig) == null) {
            if (f27564a != null) {
                h0.b(new RuntimeException("Init Twice!"));
            } else if (initConfig.getSensitiveInfoProvider() == null) {
                h0.b(new RuntimeException("need to involve setSensitiveInfoProvider!"));
            } else {
                Application application = (Application) context.getApplicationContext();
                j1 k = j1.k();
                y1 y1Var = new y1(application, initConfig);
                z1 z1Var = new z1(application, y1Var);
                k.c(application, y1Var, z1Var, new e1(initConfig.getPicker()));
                f27564a = y1Var;
                sDevice = z1Var;
                h0.e("Inited", null);
            }
        }
    }

    public static boolean manualActivate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            if (sDevice != null) {
                return j1.k().o();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void onEvent(@NonNull String str, @NonNull String str2, String str3, long j, long j2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65567, null, new Object[]{str, str2, str3, Long.valueOf(j), Long.valueOf(j2), jSONObject}) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
                j1.d(new r(str, str2, str3, j, j2, jSONObject != null ? jSONObject.toString() : null));
                return;
            }
            if (h0.f71677b) {
                h0.a("category or label is empty", null);
            }
            j1.d(new x("" + str2 + str3, "2", 1));
        }
    }

    public static void onEventV3(@NonNull String str, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65569, null, str, jSONObject) == null) {
            if (TextUtils.isEmpty(str)) {
                h0.a("eventName is empty", null);
                j1.d(new x("", "2", 1));
            }
            j1.d(new t(str, false, jSONObject != null ? jSONObject.toString() : null));
        }
    }

    public static void onInternalEventV3(@NonNull String str, @Nullable JSONObject jSONObject, @Nullable String str2, @Nullable String str3, @NonNull String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65571, null, str, jSONObject, str2, str3, str4) == null) {
            if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
                h0.c("both second appid and second app name is empty, return", null);
                return;
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            String str5 = "second_app_" + str;
            try {
                jSONObject.put("params_for_special", "second_app");
                jSONObject.put("second_appid", str2);
                jSONObject.put("second_appname", str3);
                jSONObject.put("product_type", str4);
            } catch (Throwable th) {
                h0.b(th);
            }
            j1.d(new t(str5, false, jSONObject.toString()));
        }
    }

    public static void onMiscEvent(@NonNull String str, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65572, null, str, jSONObject) == null) {
            if (!TextUtils.isEmpty(str) && jSONObject != null && jSONObject.length() > 0) {
                try {
                    j1.d(new s(str, jSONObject));
                    return;
                } catch (Exception e2) {
                    h0.d("call onEventData get exception: ", e2);
                    return;
                }
            }
            h0.c("call onEventData with invalid params, return", null);
        }
    }

    public static void removeDataObserver(IDataObserver iDataObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65573, null, iDataObserver) == null) {
            f27566c.b(iDataObserver);
        }
    }

    public static void setAbSDKVersion(String str) {
        z1 z1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65574, null, str) == null) || (z1Var = sDevice) == null) {
            return;
        }
        z1Var.d(str);
    }

    public static void setAutoActiveState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65575, null, z) == null) {
            f27565b = z;
        }
    }

    public static void setCustomNetParams(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65576, null, str, str2) == null) {
            if (TextUtils.isEmpty(str2)) {
                sCustomNetParams.remove(str);
            } else {
                sCustomNetParams.put(str, str2);
            }
        }
    }

    public static void setEnableLog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65577, null, z) == null) {
            h0.f71677b = z;
        }
    }

    public static void setEncryptAndCompress(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65578, null, z) == null) {
        }
    }

    public static void setExtraParams(IExtraParams iExtraParams) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65579, null, iExtraParams) == null) && f27567d == null && iExtraParams != null) {
            f27567d = iExtraParams;
        }
    }

    public static void setHeaderInfo(HashMap<String, Object> hashMap) {
        z1 z1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65580, null, hashMap) == null) || (z1Var = sDevice) == null) {
            return;
        }
        z1Var.e(hashMap);
    }

    public static void setIAppParam(IAppParam iAppParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65581, null, iAppParam) == null) {
            sIAppParam = iAppParam;
        }
    }

    @AnyThread
    public static void setOaidObserver(@Nullable IOaidObserver iOaidObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65582, null, iOaidObserver) == null) {
            n0.e(iOaidObserver);
        }
    }

    public static void setUserUniqueID(String str) {
        z1 z1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65583, null, str) == null) || (z1Var = sDevice) == null) {
            return;
        }
        z1Var.o(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] toEncryptByte(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, str)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
            GZIPOutputStream gZIPOutputStream = null;
            try {
                try {
                    if (getEncryptAndCompress()) {
                        GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                        try {
                            gZIPOutputStream2.write(str.getBytes("UTF-8"));
                            gZIPOutputStream = gZIPOutputStream2;
                        } catch (Throwable th) {
                            th = th;
                            gZIPOutputStream = gZIPOutputStream2;
                            try {
                                h0.b(th);
                                if (gZIPOutputStream != null) {
                                    gZIPOutputStream.close();
                                }
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                if (!getEncryptAndCompress()) {
                                }
                            } catch (Throwable th2) {
                                if (gZIPOutputStream != null) {
                                    try {
                                        gZIPOutputStream.close();
                                    } catch (IOException e2) {
                                        h0.b(e2);
                                    }
                                }
                                throw th2;
                            }
                        }
                    } else {
                        byteArrayOutputStream.write(str.getBytes("UTF-8"));
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
                if (gZIPOutputStream != null) {
                    gZIPOutputStream.close();
                }
            } catch (IOException e3) {
                h0.b(e3);
            }
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            return !getEncryptAndCompress() ? TTEncryptUtils.a(byteArray2, byteArray2.length) : byteArray2;
        }
        return (byte[]) invokeL.objValue;
    }

    public void setUserAgent(String str) {
        z1 z1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (z1Var = sDevice) == null) {
            return;
        }
        z1Var.k(str);
    }

    public static void onEventV3(@NonNull String str, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65568, null, str, bundle) == null) {
            JSONObject jSONObject = null;
            if (bundle != null) {
                try {
                    if (!bundle.isEmpty()) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            for (String str2 : bundle.keySet()) {
                                jSONObject2.put(str2, bundle.get(str2));
                            }
                            jSONObject = jSONObject2;
                        } catch (Throwable th) {
                            th = th;
                            jSONObject = jSONObject2;
                            h0.b(th);
                            onEventV3(str, jSONObject);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            onEventV3(str, jSONObject);
        }
    }

    public static void onEvent(String str, String str2, String str3, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65566, null, new Object[]{str, str2, str3, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            onEvent(str, str2, str3, j, j2, null);
        }
    }

    @Nullable
    public static JSONObject getAbConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f27564a != null) {
                return f27564a.V();
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static void onEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, null, str, str2) == null) {
            onEvent(UMENG_CATEGORY, str, str2, 0L, 0L, null);
        }
    }

    public static void onEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, str) == null) {
            onEvent(UMENG_CATEGORY, str, null, 0L, 0L, null);
        }
    }

    public static void onInternalEventV3(@NonNull String str, @Nullable Bundle bundle, @Nullable String str2, @Nullable String str3, @NonNull String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65570, null, str, bundle, str2, str3, str4) == null) {
            JSONObject jSONObject = null;
            if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
                h0.c("both second appid and second app name is empty, return", null);
                return;
            }
            String str5 = "second_app_" + str;
            if (bundle != null) {
                try {
                    if (!bundle.isEmpty()) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            for (String str6 : bundle.keySet()) {
                                jSONObject2.put(str6, bundle.get(str6));
                            }
                            jSONObject2.put("params_for_special", "second_app");
                            jSONObject2.put("second_appid", str2);
                            jSONObject2.put("second_appname", str3);
                            jSONObject2.put("product_type", str4);
                            jSONObject = jSONObject2;
                        } catch (Throwable th) {
                            th = th;
                            jSONObject = jSONObject2;
                            h0.b(th);
                            onEventV3(str5, jSONObject);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            onEventV3(str5, jSONObject);
        }
    }
}
