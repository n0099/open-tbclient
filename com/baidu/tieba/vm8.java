package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vm8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            aw8.n();
            ow8.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            hw8.n().o(TbadkCoreApplication.getInst().getContext());
            pw8.b().c();
            kw8.i();
            tw8.k();
        }
    }
}
