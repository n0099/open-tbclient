package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class m08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            j38.n();
            x38.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            q38.n().o(TbadkCoreApplication.getInst().getContext());
            y38.b().c();
            t38.i();
            b48.k();
        }
    }
}
