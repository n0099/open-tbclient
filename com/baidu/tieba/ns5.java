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
/* loaded from: classes5.dex */
public class ns5 implements bn2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ns5() {
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

    @Override // com.baidu.tieba.bn2
    public boolean a(Context context, String str, re3 re3Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, re3Var)) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_START_FAIL);
            statisticItem.param("uid", cr5.l().p() == null ? "" : cr5.l().p());
            statisticItem.param("obj_param1", re3Var.h());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, re3Var.e());
            TiebaStatic.log(statisticItem);
            if (re3Var.j() == 10 && re3Var.h() == 1013) {
                b(context, re3Var);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void b(Context context, re3 re3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, re3Var) == null) {
            y23 b0 = y23.b0();
            if (context == null || b0 == null) {
                return;
            }
            String i = dc3.i(lo2.U().M(), b0.Y().G());
            long h = re3Var.h();
            String r = re3Var.r();
            if (!(1020 == h && !TextUtils.isEmpty(r))) {
                r = we4.b().a(h);
            }
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo(b0.W(), r, "v" + sg3.D() + "/" + i + "/" + re3Var.a());
            forbiddenInfo.enableSlidingFlag = -1;
            sn2.l(context, "type_need_update_sdk", re3Var, forbiddenInfo, b0.Y().D());
        }
    }
}
