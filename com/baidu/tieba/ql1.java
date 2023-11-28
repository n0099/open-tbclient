package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.newwidget.ImageView.BDImageView;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ql1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static long a = 60000;
    public static long b;
    public static long c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948095571, "Lcom/baidu/tieba/ql1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948095571, "Lcom/baidu/tieba/ql1;");
                return;
            }
        }
        long j = a * 60;
        b = j;
        c = j * 24;
    }

    @SuppressLint({"WrongConstant"})
    public static void a(Context context, long j) {
        PendingIntent broadcast;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(65537, null, context, j) != null) || j <= 0) {
            return;
        }
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction("sso_action_t_m");
            if (b(context)) {
                broadcast = PendingIntent.getBroadcast(context, 101, intent, BDImageView.DEFAULT_BORDER_COLOR);
            } else {
                broadcast = PendingIntent.getBroadcast(context, 101, intent, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
            }
            alarmManager.cancel(broadcast);
            alarmManager.set(0, System.currentTimeMillis() + j, broadcast);
        } catch (Throwable th) {
            rl1.d(th);
        }
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                if (context.getApplicationInfo().targetSdkVersion >= 31) {
                    if (Build.VERSION.SDK_INT >= 31) {
                        return true;
                    }
                    return false;
                }
                return false;
            } catch (Throwable th) {
                rl1.d(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
