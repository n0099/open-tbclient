package com.baidu.tieba;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, long j, String str2, qw6 qw6Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), str2, qw6Var, Integer.valueOf(i)}) == null) {
            StatisticItem param = new StatisticItem(str).param("fid", j).param("fname", str2).param("obj_param1", UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE).param(TiebaStatic.Params.OBJ_PARAM2, i);
            if (qw6Var != null) {
                param.param(TiebaStatic.Params.OBJ_PARAM3, qw6Var.e);
            }
            param.eventStat();
        }
    }
}
