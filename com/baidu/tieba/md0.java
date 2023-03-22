package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mcn.McnVideoAdView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class md0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public McnVideoAdView a;
    public McnVideoAdView.c b;

    /* loaded from: classes5.dex */
    public class a implements McnVideoAdView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(md0 md0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {md0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.c
        public void a(kd0 kd0Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, kd0Var) == null) && kd0Var != null && !StringUtils.isNull(kd0Var.d)) {
                ld0.b().c(kd0Var.d);
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.c
        public void b(kd0 kd0Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kd0Var) != null) || kd0Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13405");
            statisticItem.param("tid", kd0Var.e);
            statisticItem.param("fid", kd0Var.f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", kd0Var.g);
            TiebaStatic.log(statisticItem);
        }

        @Override // com.baidu.mcn.McnVideoAdView.c
        public void c(kd0 kd0Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kd0Var) != null) || kd0Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13404");
            statisticItem.param("tid", kd0Var.e);
            statisticItem.param("fid", kd0Var.f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", kd0Var.g);
            TiebaStatic.log(statisticItem);
        }
    }

    public md0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new a(this);
        McnVideoAdView mcnVideoAdView = new McnVideoAdView(context);
        this.a = mcnVideoAdView;
        mcnVideoAdView.setIMcnStatListener(this.b);
    }

    public void a() {
        McnVideoAdView mcnVideoAdView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (mcnVideoAdView = this.a) != null) {
            mcnVideoAdView.f();
        }
    }

    public void b() {
        McnVideoAdView mcnVideoAdView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (mcnVideoAdView = this.a) != null) {
            mcnVideoAdView.g();
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            McnVideoAdView mcnVideoAdView = this.a;
            if (mcnVideoAdView != null) {
                return mcnVideoAdView.i();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        McnVideoAdView mcnVideoAdView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (mcnVideoAdView = this.a) != null) {
            mcnVideoAdView.k();
        }
    }

    public void e(kd0 kd0Var, ViewGroup viewGroup) {
        McnVideoAdView mcnVideoAdView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, kd0Var, viewGroup) == null) && (mcnVideoAdView = this.a) != null) {
            mcnVideoAdView.l(kd0Var, viewGroup);
        }
    }

    public void f(kd0 kd0Var, ViewGroup viewGroup) {
        McnVideoAdView mcnVideoAdView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, kd0Var, viewGroup) == null) && (mcnVideoAdView = this.a) != null) {
            mcnVideoAdView.m(kd0Var, viewGroup);
        }
    }
}
