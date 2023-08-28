package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.Locale;
/* loaded from: classes8.dex */
public final class u7b {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;
    public static int b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948165321, "Lcom/baidu/tieba/u7b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948165321, "Lcom/baidu/tieba/u7b;");
                return;
            }
        }
        a = new Object();
    }

    public static void a(StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, sb) == null) {
            sb.append(" TurboNet/");
            sb.append(c7b.a());
        }
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(WebvttCueParser.CHAR_SLASH);
            sb.append(c(context));
            sb.append(" (Linux; U; Android ");
            sb.append(Build.VERSION.RELEASE);
            sb.append("; ");
            sb.append(Locale.getDefault().toString());
            String str = Build.MODEL;
            if (str.length() > 0) {
                sb.append("; ");
                sb.append(str);
            }
            String str2 = Build.ID;
            if (str2.length() > 0) {
                sb.append("; Build/");
                sb.append(str2);
            }
            sb.append(ParamableElem.DIVIDE_PARAM);
            a(sb);
            sb.append(')');
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static int c(Context context) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (a) {
                if (b == 0) {
                    try {
                        b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                    } catch (PackageManager.NameNotFoundException e) {
                        throw new IllegalStateException("Cannot determine package version", e);
                    }
                }
                i = b;
            }
            return i;
        }
        return invokeL.intValue;
    }
}
