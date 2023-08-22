package com.baidu.tieba;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.notification.NotificationReceiver;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public class ql0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NotificationManager a;
    public NotificationCompat.Builder b;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ql0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-485946122, "Lcom/baidu/tieba/ql0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-485946122, "Lcom/baidu/tieba/ql0$b;");
                    return;
                }
            }
            a = new ql0(null);
        }
    }

    public ql0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = (NotificationManager) sj0.b().getSystemService("notification");
    }

    public static ql0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (ql0) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.a == null) {
            return;
        }
        try {
            a(135637042);
            a(1743353008);
            a(-1276312226);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ ql0(a aVar) {
        this();
    }

    public void a(int i) {
        NotificationManager notificationManager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || (notificationManager = this.a) == null) {
            return;
        }
        try {
            notificationManager.cancel(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final NotificationCompat.Builder c() {
        InterceptResult invokeV;
        NotificationCompat.Builder builder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Context b2 = sj0.b();
            if (Build.VERSION.SDK_INT >= 26) {
                d();
                builder = new NotificationCompat.Builder(b2, "com.baidu.nadcore.notification.channel");
            } else {
                builder = new NotificationCompat.Builder(b2);
            }
            builder.setSmallIcon(gl0.b().f());
            builder.setWhen(System.currentTimeMillis());
            builder.setPriority(0);
            builder.setDefaults(-1);
            builder.setVisibility(1);
            builder.setVibrate(new long[]{0});
            builder.setSound(null);
            return builder;
        }
        return (NotificationCompat.Builder) invokeV.objValue;
    }

    @RequiresApi(api = 26)
    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.a == null) {
            return;
        }
        NotificationChannel notificationChannel = new NotificationChannel("com.baidu.nadcore.notification.channel", "下载消息提示", 4);
        notificationChannel.setLockscreenVisibility(1);
        notificationChannel.enableLights(false);
        notificationChannel.enableVibration(false);
        notificationChannel.setVibrationPattern(new long[]{0});
        notificationChannel.setSound(null, null);
        this.a.createNotificationChannel(notificationChannel);
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(sj0.b()).areNotificationsEnabled();
            if (this.a != null && !TextUtils.isEmpty("com.baidu.nadcore.notification.channel") && Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = this.a.getNotificationChannel("com.baidu.nadcore.notification.channel");
                if (notificationChannel == null) {
                    return areNotificationsEnabled;
                }
                if (areNotificationsEnabled && notificationChannel.getImportance() != 0) {
                    return true;
                }
                return false;
            }
            return areNotificationsEnabled;
        }
        return invokeV.booleanValue;
    }

    public PendingIntent e(String str, hl0 hl0Var) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, hl0Var)) == null) {
            if (!TextUtils.isEmpty(str) && hl0Var != null) {
                Context b2 = sj0.b();
                Intent intent = new Intent(str);
                intent.setComponent(new ComponentName(b2.getPackageName(), NotificationReceiver.class.getName()));
                intent.putExtra("key_package_name", hl0Var.d);
                File file = hl0Var.h;
                if (file != null && file.exists()) {
                    str2 = hl0Var.h.getAbsolutePath();
                } else {
                    str2 = "";
                }
                intent.putExtra("key_download_path", str2);
                intent.putExtra("key_notify_type", hl0Var.q.m);
                intent.putExtra("key_notification_id", hl0Var.e().hashCode());
                intent.putExtra("key_extra_param", hl0Var.p.a);
                return v61.a(b2, hl0Var.e().hashCode(), intent, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
            }
            return null;
        }
        return (PendingIntent) invokeLL.objValue;
    }

    public void i(hl0 hl0Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, hl0Var, str) != null) || this.a == null) {
            return;
        }
        try {
            b();
            Context b2 = sj0.b();
            String str2 = hl0Var.p.h;
            String str3 = "";
            if (TextUtils.equals(str, "notify_type_pause")) {
                str3 = b2.getResources().getString(R.string.nad_download_paused);
            } else if (TextUtils.equals(str, "notify_type_stop")) {
                str3 = b2.getResources().getString(R.string.nad_download_stopped);
            }
            NotificationCompat.Builder c = c();
            c.setTicker(str2 + str3);
            c.setContentTitle(str2);
            c.setContentText(str3);
            c.setAutoCancel(true);
            c.setOngoing(false);
            this.a.notify(1743353008, c.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void h(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, str4) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (!TextUtils.isEmpty(str)) {
                clogBuilder.z(str);
            }
            if (!TextUtils.equals(str, ClogBuilder.LogType.DOWNLOAD_INSTALL.type) && !TextUtils.equals(str, ClogBuilder.LogType.OPEN_APP.type)) {
                clogBuilder.u(ClogBuilder.Page.AD_NOTIFICATION);
            } else {
                clogBuilder.u(ClogBuilder.Page.RETARGET);
            }
            if (!TextUtils.isEmpty(str2)) {
                clogBuilder.j(str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                clogBuilder.p(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                clogBuilder.k(str4);
            }
            t31.e(clogBuilder);
        }
    }

    public void j(@NonNull Bitmap bitmap, @NonNull RemoteViews remoteViews, PendingIntent pendingIntent, PendingIntent pendingIntent2, @NonNull hl0 hl0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bitmap, remoteViews, pendingIntent, pendingIntent2, hl0Var) != null) || this.a == null) {
            return;
        }
        try {
            a(hl0Var.e().hashCode());
            NotificationCompat.Builder c = c();
            if (Build.VERSION.SDK_INT >= 24) {
                c.setCustomContentView(remoteViews).setContentIntent(pendingIntent).setDeleteIntent(pendingIntent2).setPriority(2).setAutoCancel(true);
            } else {
                c.setContentIntent(pendingIntent).setDeleteIntent(pendingIntent2).setLargeIcon(bitmap).setContentTitle(hl0Var.p.h).setContentText(hl0Var.q.n).setPriority(2).setAutoCancel(true);
            }
            Notification build = c.build();
            build.flags |= 32;
            this.a.notify(hl0Var.e().hashCode(), build);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void k(hl0 hl0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, hl0Var) != null) || this.a == null) {
            return;
        }
        try {
            b();
            Context b2 = sj0.b();
            String str = hl0Var.p.h;
            String string = b2.getResources().getString(R.string.nad_download_succeed);
            NotificationCompat.Builder c = c();
            c.setTicker(string);
            c.setContentTitle(str);
            c.setContentText(string);
            c.setContentIntent(e(NotificationReceiver.RECEIVER_ACTION_DOWNLOAD_SUCCESS, hl0Var));
            c.setAutoCancel(true);
            c.setOngoing(false);
            this.a.notify(-1276312226, c.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void l(hl0 hl0Var) {
        NotificationManager notificationManager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, hl0Var) != null) || (notificationManager = this.a) == null) {
            return;
        }
        try {
            notificationManager.cancel(1743353008);
            this.a.cancel(-1276312226);
            Context b2 = sj0.b();
            String str = hl0Var.p.h;
            String string = b2.getResources().getString(R.string.nad_downloading);
            int i = (int) (hl0Var.i * 100.0f);
            if (this.b == null) {
                NotificationCompat.Builder c = c();
                this.b = c;
                c.setAutoCancel(false);
                this.b.setOngoing(true);
                NotificationCompat.Builder builder = this.b;
                builder.setTicker(string + "：" + str);
                this.b.setContentTitle(str);
                this.b.setContentText(string);
            } else {
                NotificationCompat.Builder builder2 = this.b;
                builder2.setTicker(string + "：" + str);
                this.b.setContentTitle(str);
                this.b.setDefaults(4);
            }
            this.b.setProgress(100, i, false);
            this.a.notify(135637042, this.b.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
