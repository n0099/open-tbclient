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
/* loaded from: classes6.dex */
public class ql5 {
    public static /* synthetic */ Interceptable $ic;
    public static ql5 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948095695, "Lcom/baidu/tieba/ql5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948095695, "Lcom/baidu/tieba/ql5;");
        }
    }

    /* loaded from: classes6.dex */
    public class a extends nl5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.nl5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 6;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.nl5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public a(ql5 ql5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ql5Var};
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

    /* loaded from: classes6.dex */
    public class b extends nl5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ql5 b;

        @Override // com.baidu.tieba.nl5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public b(ql5 ql5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ql5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ql5Var;
        }

        @Override // com.baidu.tieba.nl5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b.b;
            }
            return invokeV.intValue;
        }
    }

    public ql5() {
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

    public static ql5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (ql5.class) {
                    if (d == null) {
                        d = new ql5();
                    }
                }
            }
            return d;
        }
        return (ql5) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return q45.m().n("page_stay_max_cost", 0);
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
            q45.m().z("page_stay_max_cost", this.b);
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

    public void k(Context context, pl5 pl5Var, nl5 nl5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, pl5Var, nl5Var) == null) && pl5Var != null && !StringUtils.isNull(pl5Var.c())) {
            if (pl5Var.a) {
                if (nl5Var == null) {
                    nl5Var = new a(this);
                }
                if (!nl5Var.a(pl5Var)) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", ol5.a(pl5Var.h()));
                statisticItem.param("obj_locate", pl5Var.c());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(pl5Var.i)) {
                    statisticItem.param("obj_id", pl5Var.i);
                }
                if (pl5Var.b() != 0) {
                    statisticItem.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, pl5Var.b());
                }
                il5.b(context, statisticItem, pl5Var);
                TiebaStatic.log(statisticItem);
                return;
            }
            if (nl5Var == null) {
                nl5Var = new b(this);
            }
            if (!nl5Var.d() || !nl5Var.a(pl5Var)) {
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("stime");
            statisticItem2.param("obj_source", ol5.a(pl5Var.h()));
            statisticItem2.param("obj_type", pl5Var.c());
            statisticItem2.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(pl5Var.i()));
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (!StringUtils.isNull(pl5Var.n())) {
                statisticItem2.param("topic_id", pl5Var.n());
            }
            if (!StringUtils.isNull(pl5Var.o())) {
                statisticItem2.param(TiebaStatic.Params.TOPIC_TYPE, pl5Var.o());
            }
            if (pl5Var.d() > 0) {
                statisticItem2.param("fid", String.valueOf(pl5Var.d()));
            }
            if (pl5Var.m() > 0) {
                statisticItem2.param("tid", String.valueOf(pl5Var.m()));
            }
            if (pl5Var.l() > 0) {
                statisticItem2.param("thread_type", String.valueOf(pl5Var.l()));
            }
            if (!StringUtils.isNull(pl5Var.e())) {
                statisticItem2.param("nid", pl5Var.e());
            }
            if (pl5Var.g() > 0) {
                statisticItem2.param("pid", String.valueOf(pl5Var.g()));
            }
            if (!StringUtils.isNull(pl5Var.k)) {
                statisticItem2.param("obj_param1", pl5Var.k);
            }
            if (!StringUtils.isNull(pl5Var.l)) {
                statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, pl5Var.l);
            }
            if (!StringUtils.isNull(pl5Var.r)) {
                statisticItem2.param("is_dynamic", pl5Var.r);
            }
            if (!StringUtils.isNull(pl5Var.s)) {
                statisticItem2.param("resource_id", pl5Var.s);
            }
            if (!StringUtils.isNull(pl5Var.t)) {
                statisticItem2.param("resource_type", pl5Var.t);
            }
            if (!hi.isEmpty(pl5Var.j())) {
                statisticItem2.param("task_id", String.valueOf(pl5Var.j()));
            }
            if (!hi.isEmpty(pl5Var.a())) {
                statisticItem2.param("ab_tag", pl5Var.a());
            }
            if (g()) {
                if (!StringUtils.isNull(pl5Var.i)) {
                    statisticItem2.param("obj_id", pl5Var.i);
                }
                if (!StringUtils.isNull(pl5Var.j)) {
                    statisticItem2.param("obj_name", pl5Var.j);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(pl5Var.f())) {
                statisticItem2.param("obj_location", pl5Var.f());
            }
            if (pl5Var.b() != 0) {
                statisticItem2.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, pl5Var.b());
            }
            String fromWhichSearchSource = TbSingleton.getInstance().getFromWhichSearchSource();
            if (!StringUtils.isNull(fromWhichSearchSource) && pl5Var.h() != null && d(pl5Var.h())) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, fromWhichSearchSource);
                if (e(pl5Var.h())) {
                    TbSingleton.getInstance().setFromWhichSearchSource("");
                }
            }
            il5.b(context, statisticItem2, pl5Var);
            TiebaStatic.log(statisticItem2);
            TiebaStatic.log(new StatisticItem("PushOptTime").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(pl5Var.i())).param("obj_source", ol5.a(pl5Var.h())).param("obj_locate", pl5Var.c()).param("obj_param1", j35.a().b()));
        }
    }
}
