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
/* loaded from: classes7.dex */
public class q76 implements nq2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public q76() {
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

    @Override // com.baidu.tieba.nq2
    public boolean a(Context context, String str, di3 di3Var) {
        InterceptResult invokeLLL;
        String n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, di3Var)) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_START_FAIL);
            if (f66.k().n() == null) {
                n = "";
            } else {
                n = f66.k().n();
            }
            statisticItem.param("uid", n);
            statisticItem.param("obj_param1", di3Var.h());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, di3Var.e());
            TiebaStatic.log(statisticItem);
            if (di3Var.j() == 10 && di3Var.h() == 1013) {
                b(context, di3Var);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void b(Context context, di3 di3Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, di3Var) == null) {
            k63 c0 = k63.c0();
            if (context != null && c0 != null) {
                String i = pf3.i(xr2.V().getCoreVersion(), c0.Z().H());
                long h = di3Var.h();
                String r = di3Var.r();
                if (1020 == h && !TextUtils.isEmpty(r)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    r = ii4.b().a(h);
                }
                ForbiddenInfo forbiddenInfo = new ForbiddenInfo(c0.X(), r, "v" + ek3.D() + "/" + i + "/" + di3Var.a());
                forbiddenInfo.enableSlidingFlag = -1;
                er2.l(context, "type_need_update_sdk", di3Var, forbiddenInfo, c0.Z().D());
            }
        }
    }
}
