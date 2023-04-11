package com.baidu.tieba;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class sz3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65536, null, context, i) == null) {
            ((NotificationManager) context.getSystemService("notification")).cancel(i);
        }
    }

    public static final Bitmap b(Drawable drawable) {
        InterceptResult invokeL;
        Bitmap.Config config;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, drawable)) == null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (drawable.getOpacity() != -1) {
                config = Bitmap.Config.ARGB_8888;
            } else {
                config = Bitmap.Config.RGB_565;
            }
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static void c(Context context, int i, String str, String str2, Bitmap bitmap, long j, PendingIntent pendingIntent, String str3, String str4) {
        NotificationCompat.Builder builder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i), str, str2, bitmap, Long.valueOf(j), pendingIntent, str3, str4}) == null) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (Build.VERSION.SDK_INT >= 26) {
                notificationManager.createNotificationChannel(new NotificationChannel(String.valueOf(i), "swan_game_center", 4));
                builder = new NotificationCompat.Builder(context, String.valueOf(i));
            } else {
                builder = new NotificationCompat.Builder(context);
            }
            if (!TextUtils.isEmpty(str3)) {
                vz3.c("notifyShow", str3, str4);
            }
            if (pendingIntent != null) {
                builder.setContentIntent(pendingIntent);
            }
            NotificationCompat.Builder smallIcon = builder.setContentTitle(str).setContentText(str2).setWhen(j).setSmallIcon(R.drawable.obfuscated_res_0x7f08016a);
            if (bitmap == null) {
                bitmap = b(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f08016a));
            }
            notificationManager.notify(i, smallIcon.setLargeIcon(bitmap).setAutoCancel(true).build());
        }
    }
}
