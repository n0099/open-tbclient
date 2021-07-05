package com.baidu.ufosdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Context f23184a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f23185b;

    /* renamed from: c  reason: collision with root package name */
    public static PackageInfo f23186c;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            Context context = f23184a;
            return context == null ? "N/A" : context.getPackageName();
        }
        return (String) invokeV.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, context) == null) && f23184a == null) {
            f23184a = context;
            PackageManager packageManager = context.getPackageManager();
            f23185b = packageManager;
            try {
                f23186c = packageManager.getPackageInfo(f23184a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.ufosdk.f.c.a("PackageCollector.init fail.", e2);
            }
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            PackageInfo packageInfo = f23186c;
            return packageInfo == null ? "N/A" : packageInfo.versionName;
        }
        return (String) invokeV.objValue;
    }
}
