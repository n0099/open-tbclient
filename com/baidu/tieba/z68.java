package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class z68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            x98.n();
            la8.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            ea8.n().o(TbadkCoreApplication.getInst().getContext());
            ma8.b().c();
            ha8.i();
            pa8.k();
        }
    }
}
