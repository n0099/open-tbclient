package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class sa7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            pd7.o();
            ee7.n();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            wd7.n().o(TbadkCoreApplication.getInst().getContext());
            fe7.b().c();
            ae7.i();
            ie7.k();
        }
    }
}
