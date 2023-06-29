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
public class la6 implements fw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public la6() {
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

    @Override // com.baidu.tieba.fw2
    public boolean a(Context context, String str, vn3 vn3Var) {
        InterceptResult invokeLLL;
        String p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, vn3Var)) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_START_FAIL);
            if (a96.l().p() == null) {
                p = "";
            } else {
                p = a96.l().p();
            }
            statisticItem.param("uid", p);
            statisticItem.param("obj_param1", vn3Var.h());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, vn3Var.e());
            TiebaStatic.log(statisticItem);
            if (vn3Var.j() == 10 && vn3Var.h() == 1013) {
                b(context, vn3Var);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void b(Context context, vn3 vn3Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, vn3Var) == null) {
            cc3 b0 = cc3.b0();
            if (context != null && b0 != null) {
                String i = hl3.i(px2.T().getCoreVersion(), b0.Y().G());
                long h = vn3Var.h();
                String r = vn3Var.r();
                if (1020 == h && !TextUtils.isEmpty(r)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    r = ao4.b().a(h);
                }
                ForbiddenInfo forbiddenInfo = new ForbiddenInfo(b0.W(), r, "v" + wp3.D() + "/" + i + "/" + vn3Var.a());
                forbiddenInfo.enableSlidingFlag = -1;
                ww2.l(context, "type_need_update_sdk", vn3Var, forbiddenInfo, b0.Y().D());
            }
        }
    }
}
