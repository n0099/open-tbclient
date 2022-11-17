package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class kr8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_THREAD_POST_RESULT_DIALOG_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", z ? 1 : 0).param("obj_source", z2 ? 1 : 0));
        }
    }

    public static void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_THREAD_POST_FAIL_DIALOG_RETRY_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", z ? 1 : 0));
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            TiebaStatic.log(new StatisticItem("c14029").param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }
}
