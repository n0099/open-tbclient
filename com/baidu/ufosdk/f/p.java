package com.baidu.ufosdk.f;

import android.content.Context;
import android.content.pm.PackageManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public final class p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static PackageManager f57623a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f57624b;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, context) == null) {
            f57624b = context;
            PackageManager packageManager = context.getPackageManager();
            f57623a = packageManager;
            if (packageManager == null) {
                c.d("PermissionUtil#init fail to get PackageManager.");
            }
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            PackageManager packageManager = f57623a;
            if (packageManager == null) {
                c.d("PermissionUtil fail to get PackageManager.");
                return false;
            }
            try {
                return packageManager.checkPermission(str, f57624b.getPackageName()) == 0;
            } catch (RuntimeException e2) {
                c.a("PermissionUtil#hasPermission failed.", e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
