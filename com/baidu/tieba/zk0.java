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
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.nadcore.download.notification.NotificationReceiver;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public class zk0 {
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
        public static final zk0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-229207284, "Lcom/baidu/tieba/zk0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-229207284, "Lcom/baidu/tieba/zk0$b;");
                    return;
                }
            }
            a = new zk0(null);
        }
    }

    public zk0() {
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
        this.a = (NotificationManager) ej0.b().getSystemService(ActionJsonData.TAG_NOTIFICATION);
    }

    public static zk0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (zk0) invokeV.objValue;
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

    public /* synthetic */ zk0(a aVar) {
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
            Context b2 = ej0.b();
            if (Build.VERSION.SDK_INT >= 26) {
                d();
                builder = new NotificationCompat.Builder(b2, "com.baidu.nadcore.notification.channel");
            } else {
                builder = new NotificationCompat.Builder(b2);
            }
            builder.setSmallIcon(pk0.b().f());
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
            boolean areNotificationsEnabled = NotificationManagerCompat.from(ej0.b()).areNotificationsEnabled();
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

    public PendingIntent e(String str, qk0 qk0Var) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, qk0Var)) == null) {
            if (!TextUtils.isEmpty(str) && qk0Var != null) {
                Context b2 = ej0.b();
                Intent intent = new Intent(str);
                intent.setComponent(new ComponentName(b2.getPackageName(), NotificationReceiver.class.getName()));
                intent.putExtra(NotificationReceiver.INTENT_PARAMS_KEY_PACKAGE_NAME, qk0Var.d);
                File file = qk0Var.h;
                if (file != null && file.exists()) {
                    str2 = qk0Var.h.getAbsolutePath();
                } else {
                    str2 = "";
                }
                intent.putExtra(NotificationReceiver.INTENT_PARAMS_KEY_DOWNLOAD_FILE_PATH, str2);
                intent.putExtra(NotificationReceiver.INTENT_PARAMS_KEY_NOTIFY_TYPE, qk0Var.q.m);
                intent.putExtra(NotificationReceiver.INTENT_PARAMS_KEY_NOTIFICATION_ID, qk0Var.e().hashCode());
                intent.putExtra(NotificationReceiver.INTENT_PARAMS_KEY_EXTRA_PARAM, qk0Var.p.a);
                return z31.a(b2, qk0Var.e().hashCode(), intent, 134217728);
            }
            return null;
        }
        return (PendingIntent) invokeLL.objValue;
    }

    public void i(qk0 qk0Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, qk0Var, str) != null) || this.a == null) {
            return;
        }
        try {
            b();
            Context b2 = ej0.b();
            String str2 = qk0Var.p.h;
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
            e11.b(clogBuilder);
        }
    }

    public void j(@NonNull Bitmap bitmap, @NonNull RemoteViews remoteViews, PendingIntent pendingIntent, PendingIntent pendingIntent2, @NonNull qk0 qk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bitmap, remoteViews, pendingIntent, pendingIntent2, qk0Var) != null) || this.a == null) {
            return;
        }
        try {
            a(qk0Var.e().hashCode());
            NotificationCompat.Builder c = c();
            if (Build.VERSION.SDK_INT >= 24) {
                c.setCustomContentView(remoteViews).setContentIntent(pendingIntent).setDeleteIntent(pendingIntent2).setPriority(2).setAutoCancel(true);
            } else {
                c.setContentIntent(pendingIntent).setDeleteIntent(pendingIntent2).setLargeIcon(bitmap).setContentTitle(qk0Var.p.h).setContentText(qk0Var.q.n).setPriority(2).setAutoCancel(true);
            }
            Notification build = c.build();
            build.flags |= 32;
            this.a.notify(qk0Var.e().hashCode(), build);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void k(qk0 qk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, qk0Var) != null) || this.a == null) {
            return;
        }
        try {
            b();
            Context b2 = ej0.b();
            String str = qk0Var.p.h;
            String string = b2.getResources().getString(R.string.nad_download_succeed);
            NotificationCompat.Builder c = c();
            c.setTicker(string);
            c.setContentTitle(str);
            c.setContentText(string);
            c.setContentIntent(e(NotificationReceiver.RECEIVER_ACTION_DOWNLOAD_SUCCESS, qk0Var));
            c.setAutoCancel(true);
            c.setOngoing(false);
            this.a.notify(-1276312226, c.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void l(qk0 qk0Var) {
        NotificationManager notificationManager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, qk0Var) != null) || (notificationManager = this.a) == null) {
            return;
        }
        try {
            notificationManager.cancel(1743353008);
            this.a.cancel(-1276312226);
            Context b2 = ej0.b();
            String str = qk0Var.p.h;
            String string = b2.getResources().getString(R.string.nad_downloading);
            int i = (int) (qk0Var.i * 100.0f);
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
