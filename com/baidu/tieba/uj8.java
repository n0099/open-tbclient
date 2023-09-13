package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final class uj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            StatisticItem.make("c14880").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", str).eventStat();
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            StatisticItem.make("c14879").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", str).eventStat();
        }
    }

    public static void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, null, j) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            sj8.a("私信链路耗时监控 Tb = " + j + "-x-" + currentTimeMillis);
            TiebaStatic.log(new StatisticItem("c14673").param("obj_id", j).param("obj_param1", currentTimeMillis));
        }
    }

    public static void d(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            sj8.a("私信链路耗时监控 Tc = " + j + "-" + i + "-" + currentTimeMillis);
            TiebaStatic.log(new StatisticItem("c14674").param("obj_id", j).param("obj_type", i).param("obj_param1", currentTimeMillis));
        }
    }

    public static void e(long j, int i, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2)}) == null) {
            long c = vj8.c(j);
            sj8.a("私信链路耗时监控 Ta = " + c + "-" + i + "-" + j2);
            TiebaStatic.log(new StatisticItem("c14672").param("obj_id", c).param("obj_type", i).param("obj_param1", j2));
        }
    }
}
