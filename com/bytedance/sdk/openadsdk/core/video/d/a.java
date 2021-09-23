package com.bytedance.sdk.openadsdk.core.video.d;

import android.os.Build;
import android.view.View;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f67437a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-992149804, "Lcom/bytedance/sdk/openadsdk/core/video/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-992149804, "Lcom/bytedance/sdk/openadsdk/core/video/d/a;");
                return;
            }
        }
        f67437a = Build.VERSION.SDK_INT;
    }

    public static int a(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            return Math.min(Math.max(0, j3 > 0 ? (int) (((j2 * 1.0d) / j3) * 100.0d) : 0), 100);
        }
        return invokeCommon.intValue;
    }

    public static String a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j2)) == null) {
            StringBuilder sb = new StringBuilder();
            long j3 = j2 / 60000;
            long j4 = ((j2 % 3600000) % 60000) / 1000;
            if (j3 >= 10) {
                sb.append(j3);
            } else if (j3 > 0) {
                sb.append(0);
                sb.append(j3);
            } else {
                sb.append(0);
                sb.append(0);
            }
            sb.append(":");
            if (j4 >= 10) {
                sb.append(j4);
            } else if (j4 > 0) {
                sb.append(0);
                sb.append(j4);
            } else {
                sb.append(0);
                sb.append(0);
            }
            return sb.toString();
        }
        return (String) invokeJ.objValue;
    }

    public static void a(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65539, null, view, z) == null) || view == null) {
            return;
        }
        if (z) {
            view.setSystemUiVisibility(0);
            return;
        }
        int i2 = f67437a;
        if (i2 >= 19) {
            view.setSystemUiVisibility(3846);
        } else if (i2 >= 16) {
            view.setSystemUiVisibility(5);
        } else {
            view.setSystemUiVisibility(1);
        }
    }
}
