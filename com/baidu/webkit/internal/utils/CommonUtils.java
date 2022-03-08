package com.baidu.webkit.internal.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebKitVersionBlink;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.WebKitFactory;
import com.kuaishou.weapon.un.s;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public final class CommonUtils implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "CommonUtils";
    public static final String URL_KEY_APP_VERSION = "appversion";
    public static final String URL_KEY_BLINK_VER = "zeus_ver";
    public static final String URL_KEY_SDK_APP = "app";
    public static final String URL_KEY_ZEUS_SDK = "sdk";
    public static String[] sFiledsSysMemInfo;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-919547194, "Lcom/baidu/webkit/internal/utils/CommonUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-919547194, "Lcom/baidu/webkit/internal/utils/CommonUtils;");
                return;
            }
        }
        sFiledsSysMemInfo = new String[]{"MemTotal:", "MemFree:", "Buffers:", "Cached:", "Active:", "Inactive:", "Dirty:"};
    }

    public CommonUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void appendUrlParam(StringBuilder sb, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, sb, str, str2) == null) || sb == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        sb.append("&");
    }

    public static boolean checkPermissionGranted(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) ? str != null && context.checkPermission(str, Process.myPid(), Process.myUid()) == 0 : invokeLL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
        if (checkPermissionGranted(r5, "android.permission.READ_CALL_LOG") != false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean checkPhonePermission(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) != null) {
            return invokeL.booleanValue;
        }
        boolean z2 = false;
        if (context == null) {
            return false;
        }
        try {
            if (!checkPermissionGranted(context, "android.permission.CALL_PHONE") && !checkPermissionGranted(context, "android.permission.MODIFY_PHONE_STATE") && !checkPermissionGranted(context, s.f53804c) && !checkPermissionGranted(context, "android.permission.PROCESS_OUTGOING_CALLS")) {
                z = false;
                if (Build.VERSION.SDK_INT < 16) {
                    if (!z) {
                    }
                    z2 = true;
                    return z2;
                }
                return z;
            }
            z = true;
            if (Build.VERSION.SDK_INT < 16) {
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String getCookieValue(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager == null) {
                return null;
            }
            String cookie = cookieManager.getCookie(str);
            if (TextUtils.isEmpty(cookie)) {
                return null;
            }
            String[] split = cookie.split(";");
            int length = split.length;
            for (int i2 = 0; i2 != length; i2++) {
                String[] split2 = split[i2].trim().split("=");
                if (split2.length == 2 && TextUtils.equals(str2, split2[0])) {
                    return split2[1];
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String getQueryParameter(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65542, null, str, str2)) != null) {
            return (String) invokeLL.objValue;
        }
        int length = str.length();
        int indexOf = str.indexOf("?") + 1;
        while (true) {
            int indexOf2 = str.indexOf(38, indexOf);
            int i2 = indexOf2 != -1 ? indexOf2 : length;
            int indexOf3 = str.indexOf(61, indexOf);
            if (indexOf3 > i2 || indexOf3 == -1) {
                indexOf3 = i2;
            }
            if (indexOf3 - indexOf == str2.length() && str.regionMatches(indexOf, str2, 0, str2.length())) {
                return indexOf3 == i2 ? "" : str.substring(indexOf3 + 1, i2);
            } else if (indexOf2 == -1) {
                return null;
            } else {
                indexOf = indexOf2 + 1;
            }
        }
    }

    public static Map<String, Long> getSysMemoryInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            HashMap hashMap = new HashMap();
            try {
                Method method = Class.forName("android.os.Process").getMethod("readProcLines", String.class, String[].class, long[].class);
                if (method != null) {
                    int length = sFiledsSysMemInfo.length;
                    long[] jArr = new long[length];
                    jArr[0] = 30;
                    jArr[1] = -30;
                    method.invoke(null, HardwareInfoUtils.MEM_INFO_FILE, sFiledsSysMemInfo, jArr);
                    for (int i2 = 0; i2 < length; i2++) {
                        hashMap.put(sFiledsSysMemInfo[i2], Long.valueOf(jArr[i2]));
                    }
                }
                return hashMap;
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException unused) {
                return null;
            }
        }
        return (Map) invokeV.objValue;
    }

    public static String getVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "0.8";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String processUrl(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, context)) == null) {
            if (context == null) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str);
            String versionName = WebKitVersionBlink.getVersionName();
            String sdkVersionName = WebKitFactory.getSdkVersionName();
            appendUrlParam(sb, "zeus_ver", versionName);
            appendUrlParam(sb, "sdk", sdkVersionName);
            String packageName = context.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
                appendUrlParam(sb, "app", packageName);
            }
            String versionName2 = getVersionName(context);
            if (!TextUtils.isEmpty(versionName2)) {
                appendUrlParam(sb, "appversion", versionName2);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
