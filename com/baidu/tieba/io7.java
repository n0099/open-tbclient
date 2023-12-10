package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class io7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && TbadkCoreApplication.getInst().isDebugMode()) {
            if (str == null) {
                str = "error param！！！";
            }
            throw new IllegalStateException(str);
        }
    }

    public static /* synthetic */ void b(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        a(str);
    }
}
