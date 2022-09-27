package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class q77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            ma7.o();
            bb7.n();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            ta7.l().m(TbadkCoreApplication.getInst().getContext());
            cb7.b().c();
            xa7.i();
            fb7.k();
        }
    }
}
