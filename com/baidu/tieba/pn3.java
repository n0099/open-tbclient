package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class pn3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return 5894;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948067764, "Lcom/baidu/tieba/pn3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948067764, "Lcom/baidu/tieba/pn3;");
                return;
            }
        }
        a = qr1.a;
    }

    public static void a(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, activity) == null) && activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            Window window = activity.getWindow();
            window.clearFlags(1024);
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility() & (~c());
            if (ca3.b) {
                systemUiVisibility |= 5120;
            }
            window.getDecorView().setSystemUiVisibility(systemUiVisibility);
        }
    }

    public static void b(Activity activity, Dialog dialog) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, activity, dialog) == null) && activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null && dialog != null && dialog.getWindow() != null && dialog.getWindow().getDecorView() != null) {
            dialog.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility());
        }
    }

    public static boolean d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity)) == null) {
            if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void e(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, activity) == null) && activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            Window window = activity.getWindow();
            window.setFlags(1024, 1024);
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | c());
        }
    }

    public static void j(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, activity) == null) {
            if (a) {
                Log.i(ActivityUtils.TAG, "tryFinishAndRemoveTask: " + activity);
            }
            if (activity != null && !activity.isDestroyed()) {
                if (Build.VERSION.SDK_INT >= 21) {
                    activity.finishAndRemoveTask();
                } else {
                    activity.finish();
                }
            }
        }
    }

    public static void f(Activity activity, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, activity, intent) == null) {
            h(activity, intent, true);
        }
    }

    public static boolean g(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, intent)) == null) {
            return h(context, intent, false);
        }
        return invokeLL.booleanValue;
    }

    public static boolean h(Context context, Intent intent, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65544, null, context, intent, z)) == null) {
            return i(context, intent, z, true);
        }
        return invokeLLZ.booleanValue;
    }

    public static boolean i(Context context, Intent intent, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{context, intent, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z || !(context instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            try {
                context.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException unused) {
                if (!z2) {
                    return false;
                }
                Toast.makeText(context, (int) R.string.obfuscated_res_0x7f0f14be, 0).show();
                return false;
            } catch (SecurityException e) {
                if (z2) {
                    Toast.makeText(context, (int) R.string.obfuscated_res_0x7f0f14be, 0).show();
                }
                if (!a) {
                    return false;
                }
                Log.e(ActivityUtils.TAG, "Launcher does not have the permission to launch " + intent + ". Make sure to create a MAIN intent-filter for the corresponding activity or use the exported attribute for this activity.", e);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
