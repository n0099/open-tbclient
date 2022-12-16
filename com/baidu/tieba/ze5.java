package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class ze5 {
    public static /* synthetic */ Interceptable $ic;
    public static ze5 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948357087, "Lcom/baidu/tieba/ze5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948357087, "Lcom/baidu/tieba/ze5;");
        }
    }

    /* loaded from: classes7.dex */
    public class a extends we5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.we5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 6;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.we5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public a(ze5 ze5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends we5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ze5 b;

        @Override // com.baidu.tieba.we5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public b(ze5 ze5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ze5Var;
        }

        @Override // com.baidu.tieba.we5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b.b;
            }
            return invokeV.intValue;
        }
    }

    public ze5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.c = false;
    }

    public static ze5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (ze5.class) {
                    if (d == null) {
                        d = new ze5();
                    }
                }
            }
            return d;
        }
        return (ze5) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return ry4.l().m("page_stay_max_cost", 0);
            }
            return this.b;
        }
        return invokeV.intValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public final boolean e(List<String> list) {
        InterceptResult invokeL;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (ListUtils.isEmpty(list) || (size = list.size()) < 2 || !"a026".equals(list.get(size - 2))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.b = i;
            ry4.l().x("page_stay_max_cost", this.b);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.a = z;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.c = z;
        }
    }

    public final boolean d(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            if (!"a026".equals(list.get(list.size() - 1)) && !e(list)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void k(Context context, ye5 ye5Var, we5 we5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, ye5Var, we5Var) == null) && ye5Var != null && !StringUtils.isNull(ye5Var.c())) {
            if (ye5Var.a) {
                if (we5Var == null) {
                    we5Var = new a(this);
                }
                if (!we5Var.a(ye5Var)) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", xe5.a(ye5Var.h()));
                statisticItem.param("obj_locate", ye5Var.c());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(ye5Var.i)) {
                    statisticItem.param("obj_id", ye5Var.i);
                }
                if (ye5Var.b() != 0) {
                    statisticItem.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, ye5Var.b());
                }
                re5.b(context, statisticItem, ye5Var);
                TiebaStatic.log(statisticItem);
                return;
            }
            if (we5Var == null) {
                we5Var = new b(this);
            }
            if (!we5Var.d() || !we5Var.a(ye5Var)) {
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("stime");
            statisticItem2.param("obj_source", xe5.a(ye5Var.h()));
            statisticItem2.param("obj_type", ye5Var.c());
            statisticItem2.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(ye5Var.i()));
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (!StringUtils.isNull(ye5Var.n())) {
                statisticItem2.param("topic_id", ye5Var.n());
            }
            if (!StringUtils.isNull(ye5Var.o())) {
                statisticItem2.param(TiebaStatic.Params.TOPIC_TYPE, ye5Var.o());
            }
            if (ye5Var.d() > 0) {
                statisticItem2.param("fid", String.valueOf(ye5Var.d()));
            }
            if (ye5Var.m() > 0) {
                statisticItem2.param("tid", String.valueOf(ye5Var.m()));
            }
            if (ye5Var.l() > 0) {
                statisticItem2.param("thread_type", String.valueOf(ye5Var.l()));
            }
            if (!StringUtils.isNull(ye5Var.e())) {
                statisticItem2.param("nid", ye5Var.e());
            }
            if (ye5Var.g() > 0) {
                statisticItem2.param("pid", String.valueOf(ye5Var.g()));
            }
            if (!StringUtils.isNull(ye5Var.k)) {
                statisticItem2.param("obj_param1", ye5Var.k);
            }
            if (!StringUtils.isNull(ye5Var.l)) {
                statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, ye5Var.l);
            }
            if (!StringUtils.isNull(ye5Var.r)) {
                statisticItem2.param("is_dynamic", ye5Var.r);
            }
            if (!StringUtils.isNull(ye5Var.s)) {
                statisticItem2.param("resource_id", ye5Var.s);
            }
            if (!StringUtils.isNull(ye5Var.t)) {
                statisticItem2.param("resource_type", ye5Var.t);
            }
            if (!xi.isEmpty(ye5Var.j())) {
                statisticItem2.param("task_id", String.valueOf(ye5Var.j()));
            }
            if (!xi.isEmpty(ye5Var.a())) {
                statisticItem2.param("ab_tag", ye5Var.a());
            }
            if (g()) {
                if (!StringUtils.isNull(ye5Var.i)) {
                    statisticItem2.param("obj_id", ye5Var.i);
                }
                if (!StringUtils.isNull(ye5Var.j)) {
                    statisticItem2.param("obj_name", ye5Var.j);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(ye5Var.f())) {
                statisticItem2.param("obj_location", ye5Var.f());
            }
            if (ye5Var.b() != 0) {
                statisticItem2.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, ye5Var.b());
            }
            String fromWhichSearchSource = TbSingleton.getInstance().getFromWhichSearchSource();
            if (!StringUtils.isNull(fromWhichSearchSource) && ye5Var.h() != null && d(ye5Var.h())) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, fromWhichSearchSource);
                if (e(ye5Var.h())) {
                    TbSingleton.getInstance().setFromWhichSearchSource("");
                }
            }
            re5.b(context, statisticItem2, ye5Var);
            TiebaStatic.log(statisticItem2);
            TiebaStatic.log(new StatisticItem("PushOptTime").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(ye5Var.i())).param("obj_source", xe5.a(ye5Var.h())).param("obj_locate", ye5Var.c()).param("obj_param1", jx4.a().b()));
        }
    }
}
