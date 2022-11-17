package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class u97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            qc7.o();
            fd7.n();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            xc7.n().o(TbadkCoreApplication.getInst().getContext());
            gd7.b().c();
            bd7.i();
            jd7.k();
        }
    }
}
