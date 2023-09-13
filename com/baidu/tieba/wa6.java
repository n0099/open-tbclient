package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes8.dex */
public class wa6 implements kv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public wa6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.kv2
    public boolean a(Context context, String str, an3 an3Var) {
        InterceptResult invokeLLL;
        String n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, an3Var)) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_START_FAIL);
            if (l96.k().n() == null) {
                n = "";
            } else {
                n = l96.k().n();
            }
            statisticItem.param("uid", n);
            statisticItem.param("obj_param1", an3Var.h());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, an3Var.e());
            TiebaStatic.log(statisticItem);
            if (an3Var.j() == 10 && an3Var.h() == 1013) {
                b(context, an3Var);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void b(Context context, an3 an3Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, an3Var) == null) {
            hb3 b0 = hb3.b0();
            if (context != null && b0 != null) {
                String i = mk3.i(uw2.T().getCoreVersion(), b0.Y().G());
                long h = an3Var.h();
                String r = an3Var.r();
                if (1020 == h && !TextUtils.isEmpty(r)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    r = fn4.b().a(h);
                }
                ForbiddenInfo forbiddenInfo = new ForbiddenInfo(b0.W(), r, "v" + bp3.D() + "/" + i + "/" + an3Var.a());
                forbiddenInfo.enableSlidingFlag = -1;
                bw2.l(context, "type_need_update_sdk", an3Var, forbiddenInfo, b0.Y().D());
            }
        }
    }
}
