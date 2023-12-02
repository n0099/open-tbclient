package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class kr8 {
    public static /* synthetic */ Interceptable $ic;
    public static final kr8 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947922808, "Lcom/baidu/tieba/kr8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947922808, "Lcom/baidu/tieba/kr8;");
                return;
            }
        }
        a = new kr8();
    }

    public kr8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void a(String botId, Integer num, String duration) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, botId, num, duration) == null) {
            Intrinsics.checkNotNullParameter(botId, "botId");
            Intrinsics.checkNotNullParameter(duration, "duration");
            StatisticItem statisticItem = new StatisticItem("c15413");
            statisticItem.param("obj_type", 5);
            statisticItem.param("obj_id", botId);
            if (num != null) {
                i = num.intValue();
            } else {
                i = 0;
            }
            statisticItem.param("obj_source", i);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.OBJ_DURATION, duration);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void b(int i, String botPaid, Integer num) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, botPaid, num) == null) {
            Intrinsics.checkNotNullParameter(botPaid, "botPaid");
            StatisticItem statisticItem = new StatisticItem("c15413");
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_id", botPaid);
            if (num != null) {
                i2 = num.intValue();
            } else {
                i2 = 0;
            }
            statisticItem.param("obj_source", i2);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            StatisticItem statisticItem = new StatisticItem("c15439");
            statisticItem.param("obj_type", i);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }
}
