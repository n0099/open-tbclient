package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class kg1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static long a = 60000;
    public static long b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947912020, "Lcom/baidu/tieba/kg1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947912020, "Lcom/baidu/tieba/kg1;");
                return;
            }
        }
        b = a * 60;
    }

    @SuppressLint({"WrongConstant"})
    public static void a(Context context, long j) {
        PendingIntent broadcast;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65537, null, context, j) == null) || j <= 0) {
            return;
        }
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction("sso_action_t_m");
            if (b(context)) {
                broadcast = PendingIntent.getBroadcast(context, 101, intent, 201326592);
            } else {
                broadcast = PendingIntent.getBroadcast(context, 101, intent, 134217728);
            }
            alarmManager.cancel(broadcast);
            alarmManager.set(0, System.currentTimeMillis() + j, broadcast);
        } catch (Throwable th) {
            lg1.d(th);
        }
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                if (context.getApplicationInfo().targetSdkVersion >= 31) {
                    return Build.VERSION.SDK_INT >= 31;
                }
                return false;
            } catch (Throwable th) {
                lg1.d(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
