package com.baidu.tieba;

import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class ul7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < j) {
                return 1;
            }
            if (currentTimeMillis > j2) {
                return 3;
            }
            return 2;
        }
        return invokeCommon.intValue;
    }

    public static final boolean b(Object bindData) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bindData)) == null) {
            Intrinsics.checkNotNullParameter(bindData, "bindData");
            if (bindData instanceof e57) {
                Map<String, String> a = ((e57) bindData).e().a().a();
                int i = JavaTypesHelper.toInt(a.get("thread_type"), 0);
                if (JavaTypesHelper.toInt(a.get("is_livepost"), 0) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                long j = JavaTypesHelper.toLong(a.get("task_start_time"), 0L);
                long j2 = JavaTypesHelper.toLong(a.get("task_end_time"), 0L);
                if (i == 41 && z && a(j, j2) == 2) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final boolean c(Object bindData) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bindData)) == null) {
            Intrinsics.checkNotNullParameter(bindData, "bindData");
            if (bindData instanceof e57) {
                Map<String, String> a = ((e57) bindData).e().a().a();
                int i = JavaTypesHelper.toInt(a.get("thread_type"), 0);
                if (JavaTypesHelper.toInt(a.get("is_official"), 0) == 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (JavaTypesHelper.toInt(a.get("frs_toplive_force"), 0) == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if ((i == 49 || i == 69) && z && z2) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
