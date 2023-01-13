package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class re7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            mh7.n();
            ai7.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            th7.n().o(TbadkCoreApplication.getInst().getContext());
            bi7.b().c();
            wh7.i();
            ei7.k();
        }
    }
}
