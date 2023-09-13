package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ko3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"ObsoleteSdkInt"})
    public static boolean a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return NotificationManagerCompat.from(context).areNotificationsEnabled();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
