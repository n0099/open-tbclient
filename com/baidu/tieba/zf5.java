package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class zf5 {
    public static /* synthetic */ Interceptable $ic;
    public static final zf5 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948358048, "Lcom/baidu/tieba/zf5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948358048, "Lcom/baidu/tieba/zf5;");
                return;
            }
        }
        a = new zf5();
    }

    public zf5() {
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

    public final void a(ag5 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            StatisticItem statisticItem = new StatisticItem("c15544");
            statisticItem.param("obj_type", data.f());
            statisticItem.param("obj_name", data.c());
            statisticItem.param("fname", data.a());
            statisticItem.param("tid", data.e());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.eventStat();
        }
    }

    public final void c(ag5 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            StatisticItem statisticItem = new StatisticItem("c15542");
            statisticItem.param("obj_type", data.f());
            statisticItem.param("obj_source", data.d());
            statisticItem.param("fname", data.a());
            statisticItem.param("tid", data.e());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.eventStat();
        }
    }

    public final void b(ag5 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            StatisticItem statisticItem = new StatisticItem("c15543");
            statisticItem.param("obj_type", data.f());
            statisticItem.param("obj_name", data.c());
            if (data.f() != 3) {
                statisticItem.param("obj_id", data.b());
                statisticItem.param("obj_source", data.d());
            }
            statisticItem.param("fname", data.a());
            statisticItem.param("tid", data.e());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.eventStat();
        }
    }
}
