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
public class m76 implements kq2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m76() {
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

    @Override // com.baidu.tieba.kq2
    public boolean a(Context context, String str, ai3 ai3Var) {
        InterceptResult invokeLLL;
        String n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, ai3Var)) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_START_FAIL);
            if (b66.k().n() == null) {
                n = "";
            } else {
                n = b66.k().n();
            }
            statisticItem.param("uid", n);
            statisticItem.param("obj_param1", ai3Var.h());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, ai3Var.e());
            TiebaStatic.log(statisticItem);
            if (ai3Var.j() == 10 && ai3Var.h() == 1013) {
                b(context, ai3Var);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void b(Context context, ai3 ai3Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ai3Var) == null) {
            h63 c0 = h63.c0();
            if (context != null && c0 != null) {
                String i = mf3.i(ur2.V().getCoreVersion(), c0.Z().H());
                long h = ai3Var.h();
                String r = ai3Var.r();
                if (1020 == h && !TextUtils.isEmpty(r)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    r = fi4.b().a(h);
                }
                ForbiddenInfo forbiddenInfo = new ForbiddenInfo(c0.X(), r, "v" + bk3.D() + "/" + i + "/" + ai3Var.a());
                forbiddenInfo.enableSlidingFlag = -1;
                br2.l(context, "type_need_update_sdk", ai3Var, forbiddenInfo, c0.Z().D());
            }
        }
    }
}
