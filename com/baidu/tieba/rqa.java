package com.baidu.tieba;

import android.content.Intent;
import android.os.Process;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class rqa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            String packageName = dra.d().getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getAppCtx().packageName");
            return packageName;
        }
        return (String) invokeV.objValue;
    }

    @JvmOverloads
    public static final void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            Intent launchIntentForPackage = dra.d().getPackageManager().getLaunchIntentForPackage(dra.d().getPackageName());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(335577088);
            }
            if (launchIntentForPackage != null) {
                int h = dra.h();
                dra.d().startActivity(launchIntentForPackage);
                if (z && h > 0) {
                    Process.killProcess(h);
                    System.exit(0);
                    throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
                }
            }
        }
    }
}
