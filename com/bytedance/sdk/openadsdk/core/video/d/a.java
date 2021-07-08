package com.bytedance.sdk.openadsdk.core.video.d;

import android.os.Build;
import android.view.View;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f30644a;
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
        f30644a = Build.VERSION.SDK_INT;
    }

    public static int a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return Math.min(Math.max(0, j2 > 0 ? (int) (((j * 1.0d) / j2) * 100.0d) : 0), 100);
        }
        return invokeCommon.intValue;
    }

    public static String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) {
            StringBuilder sb = new StringBuilder();
            long j2 = j / 60000;
            long j3 = ((j % 3600000) % 60000) / 1000;
            if (j2 >= 10) {
                sb.append(j2);
            } else if (j2 > 0) {
                sb.append(0);
                sb.append(j2);
            } else {
                sb.append(0);
                sb.append(0);
            }
            sb.append(":");
            if (j3 >= 10) {
                sb.append(j3);
            } else if (j3 > 0) {
                sb.append(0);
                sb.append(j3);
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
        int i2 = f30644a;
        if (i2 >= 19) {
            view.setSystemUiVisibility(3846);
        } else if (i2 >= 16) {
            view.setSystemUiVisibility(5);
        } else {
            view.setSystemUiVisibility(1);
        }
    }
}
