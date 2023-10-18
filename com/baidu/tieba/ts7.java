package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ts7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, long j, String str2, os7 os7Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), str2, os7Var, Integer.valueOf(i)}) == null) {
            StatisticItem param = new StatisticItem(str).param("fid", j).param("fname", str2).param("obj_param1", UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE).param(TiebaStatic.Params.OBJ_PARAM2, i);
            if (os7Var != null) {
                param.param(TiebaStatic.Params.OBJ_PARAM3, os7Var.e);
            }
            param.eventStat();
        }
    }
}
