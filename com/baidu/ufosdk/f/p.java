package com.baidu.ufosdk.f;

import android.content.Context;
import android.content.pm.PackageManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public final class p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static PackageManager f56702a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f56703b;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, context) == null) {
            f56703b = context;
            PackageManager packageManager = context.getPackageManager();
            f56702a = packageManager;
            if (packageManager == null) {
                c.d("PermissionUtil#init fail to get PackageManager.");
            }
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            PackageManager packageManager = f56702a;
            if (packageManager == null) {
                c.d("PermissionUtil fail to get PackageManager.");
                return false;
            }
            try {
                return packageManager.checkPermission(str, f56703b.getPackageName()) == 0;
            } catch (RuntimeException e2) {
                c.a("PermissionUtil#hasPermission failed.", e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
