package com.baidu.ufosdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Context f23452a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f23453b;

    /* renamed from: c  reason: collision with root package name */
    public static PackageInfo f23454c;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            Context context = f23452a;
            return context == null ? "N/A" : context.getPackageName();
        }
        return (String) invokeV.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, context) == null) && f23452a == null) {
            f23452a = context;
            PackageManager packageManager = context.getPackageManager();
            f23453b = packageManager;
            try {
                f23454c = packageManager.getPackageInfo(f23452a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.ufosdk.f.c.a("PackageCollector.init fail.", e2);
            }
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            PackageInfo packageInfo = f23454c;
            return packageInfo == null ? "N/A" : packageInfo.versionName;
        }
        return (String) invokeV.objValue;
    }
}
