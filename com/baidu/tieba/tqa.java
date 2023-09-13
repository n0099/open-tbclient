package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final class tqa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(String str) {
        oe<byte[]> j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && (j = x45.j(str, TbadkCoreApplication.getCurrentAccount())) != null) {
            j.g("0", null);
        }
    }

    public static final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            a("tb.rec_frs_update");
        }
    }
}
