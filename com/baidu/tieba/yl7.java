package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yl7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            to7.n();
            hp7.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            ap7.n().o(TbadkCoreApplication.getInst().getContext());
            ip7.b().c();
            dp7.i();
            lp7.k();
        }
    }
}
