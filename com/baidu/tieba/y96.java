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
public class y96 implements gv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public y96() {
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

    @Override // com.baidu.tieba.gv2
    public boolean a(Context context, String str, wm3 wm3Var) {
        InterceptResult invokeLLL;
        String n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, wm3Var)) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_START_FAIL);
            if (n86.k().n() == null) {
                n = "";
            } else {
                n = n86.k().n();
            }
            statisticItem.param("uid", n);
            statisticItem.param("obj_param1", wm3Var.h());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, wm3Var.e());
            TiebaStatic.log(statisticItem);
            if (wm3Var.j() == 10 && wm3Var.h() == 1013) {
                b(context, wm3Var);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void b(Context context, wm3 wm3Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, wm3Var) == null) {
            db3 b0 = db3.b0();
            if (context != null && b0 != null) {
                String i = ik3.i(qw2.T().getCoreVersion(), b0.Y().G());
                long h = wm3Var.h();
                String r = wm3Var.r();
                if (1020 == h && !TextUtils.isEmpty(r)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    r = bn4.b().a(h);
                }
                ForbiddenInfo forbiddenInfo = new ForbiddenInfo(b0.W(), r, "v" + xo3.D() + "/" + i + "/" + wm3Var.a());
                forbiddenInfo.enableSlidingFlag = -1;
                xv2.l(context, "type_need_update_sdk", wm3Var, forbiddenInfo, b0.Y().D());
            }
        }
    }
}
