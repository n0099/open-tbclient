package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URLDecoder;
/* loaded from: classes8.dex */
public class wi0 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948271403, "Lcom/baidu/tieba/wi0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948271403, "Lcom/baidu/tieba/wi0;");
                return;
            }
        }
        a = new String[]{"tel:", UrlSchemaHelper.SCHEMA_TYPE_SMS, "smsto:", "mailto:", "file:"};
    }

    public static String a(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            int indexOf = str.indexOf(63);
            boolean z = false;
            if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                i = str.indexOf(UrlSchemaHelper.SCHEMA_TYPE_SMS) + 4;
            } else if (str.startsWith("smsto:")) {
                i = str.indexOf("smsto:") + 6;
            } else {
                i = 0;
            }
            if (indexOf - i > 1) {
                z = true;
            }
            if (indexOf > -1) {
                if (z) {
                    return str.substring(i, indexOf);
                }
                return "";
            }
            return str.substring(i);
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, context, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String e = e(str);
            if (!z && !c(e)) {
                return false;
            }
            if (e.startsWith("tel:")) {
                return h(context, e);
            }
            if (!e.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS) && !e.startsWith("smsto:")) {
                if (e.startsWith("mailto:")) {
                    return f(context, e);
                }
                if (!e.startsWith("file:")) {
                    return false;
                }
                return d(context, e);
            }
            return g(context, e);
        }
        return invokeLLZ.booleanValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (ej0.a().c() != null) {
                strArr = ej0.a().c();
            } else {
                strArr = a;
            }
            for (String str2 : strArr) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String e(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (str.startsWith("wtai://") && str.length() > 13) {
                return "tel:" + str.substring(13);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            try {
                Intent parseUri = Intent.parseUri(str, 1);
                if (Build.VERSION.SDK_INT >= 24) {
                    String path = Uri.parse(str).getPath();
                    if (path == null) {
                        return false;
                    }
                    z51.a(context, new File(path), parseUri);
                }
                return z51.d(context, parseUri);
            } catch (IllegalArgumentException | URISyntaxException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean f(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            if (context != null && str != null) {
                return z51.d(context, new Intent("android.intent.action.SENDTO", Uri.parse(str)));
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean h(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            return z51.d(context, intent);
        }
        return invokeLL.booleanValue;
    }

    public static boolean g(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            String str2 = UrlSchemaHelper.SCHEMA_TYPE_SMS;
            try {
                int indexOf = str.indexOf("body=");
                String str3 = null;
                if (!str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                    if (str.startsWith("smsto:")) {
                        str2 = "smsto:";
                    } else {
                        str2 = null;
                    }
                }
                String a2 = a(str);
                if (indexOf > -1) {
                    str3 = str.substring(indexOf + 5);
                    if (!TextUtils.isEmpty(str3)) {
                        str3 = URLDecoder.decode(str3, "UTF-8");
                    }
                }
                Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str2 + a2));
                intent.putExtra("sms_body", str3);
                z51.d(context, intent);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
