package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class v57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            r87.o();
            g97.n();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            y87.l().m(TbadkCoreApplication.getInst().getContext());
            h97.b().c();
            c97.i();
            k97.k();
        }
    }
}
