package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class x57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            t87.o();
            i97.n();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            a97.l().m(TbadkCoreApplication.getInst().getContext());
            j97.b().c();
            e97.i();
            m97.k();
        }
    }
}
