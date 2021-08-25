package com.baidu.ufosdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Context f59381a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f59382b;

    /* renamed from: c  reason: collision with root package name */
    public static PackageInfo f59383c;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            Context context = f59381a;
            return context == null ? "N/A" : context.getPackageName();
        }
        return (String) invokeV.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, context) == null) && f59381a == null) {
            f59381a = context;
            PackageManager packageManager = context.getPackageManager();
            f59382b = packageManager;
            try {
                f59383c = packageManager.getPackageInfo(f59381a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.ufosdk.f.c.a("PackageCollector.init fail.", e2);
            }
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            PackageInfo packageInfo = f59383c;
            return packageInfo == null ? "N/A" : packageInfo.versionName;
        }
        return (String) invokeV.objValue;
    }
}
