package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes8.dex */
public class y81 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return false;
            }
            return b71.a(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            boolean z = false;
            if (context == null) {
                return false;
            }
            boolean a = b71.a(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (Build.VERSION.SDK_INT >= 16) {
                return (a || b71.a(context, com.kuaishou.weapon.p0.h.i)) ? true : true;
            }
            return a;
        }
        return invokeL.booleanValue;
    }
}
