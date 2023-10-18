package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class jta {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public mta c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947896210, "Lcom/baidu/tieba/jta;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947896210, "Lcom/baidu/tieba/jta;");
        }
    }

    public jta() {
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

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.b = str;
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.a = str;
        }
    }

    public final void c(mta mtaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mtaVar) == null) {
            this.c = mtaVar;
        }
    }

    public final void d(int i) {
        qta d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COMPETE_CARD_CLICK);
            if (!ad.isEmpty(this.a) && !ad.isEmpty(this.b)) {
                statisticItem.param("obj_type", 2);
            } else {
                statisticItem.param("obj_type", 1);
            }
            statisticItem.param("fname", this.a);
            statisticItem.param("fid", this.b);
            mta mtaVar = this.c;
            if (mtaVar != null && (d = mtaVar.d()) != null) {
                Long e = d.e();
                if (e != null) {
                    statisticItem.param("obj_param1", e.longValue());
                }
                Long f = d.f();
                if (f != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, f.longValue());
                }
            }
            statisticItem.param("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void e() {
        qta d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COMPETE_CARD_SHOW);
            if (!ad.isEmpty(this.a) && !ad.isEmpty(this.b)) {
                statisticItem.param("obj_type", 2);
            } else {
                statisticItem.param("obj_type", 1);
            }
            statisticItem.param("fname", this.a);
            statisticItem.param("fid", this.b);
            mta mtaVar = this.c;
            if (mtaVar != null && (d = mtaVar.d()) != null) {
                Long e = d.e();
                if (e != null) {
                    statisticItem.param("obj_param1", e.longValue());
                }
                Long f = d.f();
                if (f != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, f.longValue());
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
