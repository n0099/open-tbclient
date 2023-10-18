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
/* loaded from: classes6.dex */
public class j56 implements sp2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j56() {
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

    @Override // com.baidu.tieba.sp2
    public boolean a(Context context, String str, ih3 ih3Var) {
        InterceptResult invokeLLL;
        String n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, ih3Var)) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_START_FAIL);
            if (y36.k().n() == null) {
                n = "";
            } else {
                n = y36.k().n();
            }
            statisticItem.param("uid", n);
            statisticItem.param("obj_param1", ih3Var.h());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, ih3Var.e());
            TiebaStatic.log(statisticItem);
            if (ih3Var.j() == 10 && ih3Var.h() == 1013) {
                b(context, ih3Var);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void b(Context context, ih3 ih3Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ih3Var) == null) {
            p53 c0 = p53.c0();
            if (context != null && c0 != null) {
                String i = ue3.i(cr2.V().getCoreVersion(), c0.Z().H());
                long h = ih3Var.h();
                String r = ih3Var.r();
                if (1020 == h && !TextUtils.isEmpty(r)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    r = nh4.b().a(h);
                }
                ForbiddenInfo forbiddenInfo = new ForbiddenInfo(c0.X(), r, "v" + jj3.D() + "/" + i + "/" + ih3Var.a());
                forbiddenInfo.enableSlidingFlag = -1;
                jq2.l(context, "type_need_update_sdk", ih3Var, forbiddenInfo, c0.Z().D());
            }
        }
    }
}
