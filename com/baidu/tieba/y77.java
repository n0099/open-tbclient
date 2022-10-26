package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class y77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            ua7.o();
            jb7.n();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            bb7.n().o(TbadkCoreApplication.getInst().getContext());
            kb7.b().c();
            fb7.i();
            nb7.k();
        }
    }
}
