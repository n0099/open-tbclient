package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class zm8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            ew8.n();
            sw8.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            lw8.n().o(TbadkCoreApplication.getInst().getContext());
            tw8.b().c();
            ow8.i();
            xw8.k();
        }
    }
}
