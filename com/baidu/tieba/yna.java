package com.baidu.tieba;

import android.app.ActivityManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class yna {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            try {
                String e = coa.e();
                Object systemService = TbadkCoreApplication.getInst().getContext().getSystemService("activity");
                if (systemService != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) systemService).getRunningAppProcesses()) {
                        if (Intrinsics.areEqual(runningAppProcessInfo.processName, e)) {
                            return runningAppProcessInfo.pid;
                        }
                    }
                    return -1;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }
}
