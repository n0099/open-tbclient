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
/* loaded from: classes8.dex */
public class ur5 {
    public static /* synthetic */ Interceptable $ic;
    public static ur5 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948220625, "Lcom/baidu/tieba/ur5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948220625, "Lcom/baidu/tieba/ur5;");
        }
    }

    /* loaded from: classes8.dex */
    public class a extends rr5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.rr5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 6;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.rr5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public a(ur5 ur5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ur5Var};
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

    /* loaded from: classes8.dex */
    public class b extends rr5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ur5 b;

        @Override // com.baidu.tieba.rr5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public b(ur5 ur5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ur5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ur5Var;
        }

        @Override // com.baidu.tieba.rr5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b.b;
            }
            return invokeV.intValue;
        }
    }

    public ur5() {
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

    public static ur5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (ur5.class) {
                    if (d == null) {
                        d = new ur5();
                    }
                }
            }
            return d;
        }
        return (ur5) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return l95.m().n("page_stay_max_cost", 0);
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
            l95.m().z("page_stay_max_cost", this.b);
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

    public void k(Context context, tr5 tr5Var, rr5 rr5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, tr5Var, rr5Var) == null) && tr5Var != null && !StringUtils.isNull(tr5Var.c())) {
            if (tr5Var.a) {
                if (rr5Var == null) {
                    rr5Var = new a(this);
                }
                if (!rr5Var.a(tr5Var)) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", sr5.a(tr5Var.h()));
                statisticItem.param("obj_locate", tr5Var.c());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(tr5Var.i)) {
                    statisticItem.param("obj_id", tr5Var.i);
                }
                if (tr5Var.b() != 0) {
                    statisticItem.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, tr5Var.b());
                }
                mr5.b(context, statisticItem, tr5Var);
                TiebaStatic.log(statisticItem);
                return;
            }
            if (rr5Var == null) {
                rr5Var = new b(this);
            }
            if (!rr5Var.d() || !rr5Var.a(tr5Var)) {
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("stime");
            statisticItem2.param("obj_source", sr5.a(tr5Var.h()));
            statisticItem2.param("obj_type", tr5Var.c());
            statisticItem2.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(tr5Var.i()));
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (!StringUtils.isNull(tr5Var.n())) {
                statisticItem2.param("topic_id", tr5Var.n());
            }
            if (!StringUtils.isNull(tr5Var.o())) {
                statisticItem2.param(TiebaStatic.Params.TOPIC_TYPE, tr5Var.o());
            }
            if (tr5Var.d() > 0) {
                statisticItem2.param("fid", String.valueOf(tr5Var.d()));
            }
            if (tr5Var.m() > 0) {
                statisticItem2.param("tid", String.valueOf(tr5Var.m()));
            }
            if (tr5Var.l() > 0) {
                statisticItem2.param("thread_type", String.valueOf(tr5Var.l()));
            }
            if (!StringUtils.isNull(tr5Var.e())) {
                statisticItem2.param("nid", tr5Var.e());
            }
            if (tr5Var.g() > 0) {
                statisticItem2.param("pid", String.valueOf(tr5Var.g()));
            }
            if (!StringUtils.isNull(tr5Var.k)) {
                statisticItem2.param("obj_param1", tr5Var.k);
            }
            if (!StringUtils.isNull(tr5Var.l)) {
                statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, tr5Var.l);
            }
            if (!StringUtils.isNull(tr5Var.r)) {
                statisticItem2.param("is_dynamic", tr5Var.r);
            }
            if (!StringUtils.isNull(tr5Var.s)) {
                statisticItem2.param("resource_id", tr5Var.s);
            }
            if (!StringUtils.isNull(tr5Var.t)) {
                statisticItem2.param("resource_type", tr5Var.t);
            }
            if (!ui.isEmpty(tr5Var.j())) {
                statisticItem2.param("task_id", String.valueOf(tr5Var.j()));
            }
            if (!ui.isEmpty(tr5Var.a())) {
                statisticItem2.param("ab_tag", tr5Var.a());
            }
            if (g()) {
                if (!StringUtils.isNull(tr5Var.i)) {
                    statisticItem2.param("obj_id", tr5Var.i);
                }
                if (!StringUtils.isNull(tr5Var.j)) {
                    statisticItem2.param("obj_name", tr5Var.j);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(tr5Var.f())) {
                statisticItem2.param("obj_location", tr5Var.f());
            }
            if (tr5Var.b() != 0) {
                statisticItem2.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, tr5Var.b());
            }
            String fromWhichSearchSource = TbSingleton.getInstance().getFromWhichSearchSource();
            if (!StringUtils.isNull(fromWhichSearchSource) && tr5Var.h() != null && d(tr5Var.h())) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, fromWhichSearchSource);
                if (e(tr5Var.h())) {
                    TbSingleton.getInstance().setFromWhichSearchSource("");
                }
            }
            mr5.b(context, statisticItem2, tr5Var);
            TiebaStatic.log(statisticItem2);
            TiebaStatic.log(new StatisticItem("PushOptTime").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(tr5Var.i())).param("obj_source", sr5.a(tr5Var.h())).param("obj_locate", tr5Var.c()).param("obj_param1", e85.a().b()));
        }
    }
}
