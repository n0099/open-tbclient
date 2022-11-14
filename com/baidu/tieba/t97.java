package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class t97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            pc7.o();
            ed7.n();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            wc7.n().o(TbadkCoreApplication.getInst().getContext());
            fd7.b().c();
            ad7.i();
            id7.k();
        }
    }
}
