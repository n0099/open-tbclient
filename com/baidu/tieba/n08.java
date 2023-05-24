package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class n08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            k38.n();
            y38.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            r38.n().o(TbadkCoreApplication.getInst().getContext());
            z38.b().c();
            u38.i();
            c48.k();
        }
    }
}
