package com.bytedance.sdk.openadsdk.core.g;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull Activity activity, @NonNull String[] strArr, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65537, null, activity, strArr, i2) == null) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        activity.requestPermissions(strArr, i2);
    }

    public static int a(@NonNull Context context, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            if (str != null) {
                try {
                    return context.checkPermission(str, Process.myPid(), Process.myUid());
                } catch (Throwable th) {
                    th.printStackTrace();
                    return Build.VERSION.SDK_INT >= 23 ? -1 : 0;
                }
            }
            throw new IllegalArgumentException("permission is null");
        }
        return invokeLL.intValue;
    }
}
