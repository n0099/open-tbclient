package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class sk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            if ((!TbadkCoreApplication.getInst().isDebugMode() && !jv4.h()) || StringUtils.isNull(str)) {
                return;
            }
            for (String str2 : str.split("\n")) {
                System.out.println("[FunAdSdk] " + str2);
            }
        }
    }
}
