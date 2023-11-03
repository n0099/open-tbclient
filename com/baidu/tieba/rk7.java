package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class rk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(String fid, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65536, null, fid, i) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            TiebaStatic.log(new StatisticItem("c15559").param("fid", fid).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", i));
        }
    }

    public static final void b(String fid, boolean z, boolean z2, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{fid, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            StatisticItem param = new StatisticItem("c15546").param("fid", fid).param("uid", TbadkCoreApplication.getCurrentAccount());
            int i3 = 2;
            if (z) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            StatisticItem param2 = param.param("obj_type", i2);
            if (!z2) {
                i3 = 1;
            }
            TiebaStatic.log(param2.param("obj_locate", i3).param("obj_source", i));
        }
    }

    public static final void c(String fid, boolean z, boolean z2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{fid, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            StatisticItem param = new StatisticItem("c15545").param("fid", fid).param("uid", TbadkCoreApplication.getCurrentAccount());
            int i2 = 2;
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            StatisticItem param2 = param.param("obj_type", i);
            if (!z2) {
                i2 = 1;
            }
            TiebaStatic.log(param2.param("obj_locate", i2));
        }
    }
}
