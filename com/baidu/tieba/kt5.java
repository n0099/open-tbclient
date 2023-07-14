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
public class kt5 {
    public static /* synthetic */ Interceptable $ic;
    public static kt5 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947924637, "Lcom/baidu/tieba/kt5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947924637, "Lcom/baidu/tieba/kt5;");
        }
    }

    /* loaded from: classes6.dex */
    public class a extends ht5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.ht5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 6;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.ht5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public a(kt5 kt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kt5Var};
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
    public class b extends ht5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kt5 b;

        @Override // com.baidu.tieba.ht5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public b(kt5 kt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kt5Var;
        }

        @Override // com.baidu.tieba.ht5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b.b;
            }
            return invokeV.intValue;
        }
    }

    public kt5() {
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

    public static kt5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (kt5.class) {
                    if (d == null) {
                        d = new kt5();
                    }
                }
            }
            return d;
        }
        return (kt5) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return da5.p().q("page_stay_max_cost", 0);
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
            da5.p().F("page_stay_max_cost", this.b);
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

    public void k(Context context, jt5 jt5Var, ht5 ht5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, jt5Var, ht5Var) == null) && jt5Var != null && !StringUtils.isNull(jt5Var.c())) {
            if (jt5Var.a) {
                if (ht5Var == null) {
                    ht5Var = new a(this);
                }
                if (!ht5Var.a(jt5Var)) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", it5.a(jt5Var.h()));
                statisticItem.param("obj_locate", jt5Var.c());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(jt5Var.i)) {
                    statisticItem.param("obj_id", jt5Var.i);
                }
                if (jt5Var.b() != 0) {
                    statisticItem.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, jt5Var.b());
                }
                ct5.b(context, statisticItem, jt5Var);
                TiebaStatic.log(statisticItem);
                return;
            }
            if (ht5Var == null) {
                ht5Var = new b(this);
            }
            if (!ht5Var.d() || !ht5Var.a(jt5Var)) {
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("stime");
            statisticItem2.param("obj_source", it5.a(jt5Var.h()));
            statisticItem2.param("obj_type", jt5Var.c());
            statisticItem2.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(jt5Var.i()));
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (!StringUtils.isNull(jt5Var.n())) {
                statisticItem2.param("topic_id", jt5Var.n());
            }
            if (!StringUtils.isNull(jt5Var.o())) {
                statisticItem2.param(TiebaStatic.Params.TOPIC_TYPE, jt5Var.o());
            }
            if (jt5Var.d() > 0) {
                statisticItem2.param("fid", String.valueOf(jt5Var.d()));
            }
            if (jt5Var.m() > 0) {
                statisticItem2.param("tid", String.valueOf(jt5Var.m()));
            }
            if (jt5Var.l() > 0) {
                statisticItem2.param("thread_type", String.valueOf(jt5Var.l()));
            }
            if (!StringUtils.isNull(jt5Var.e())) {
                statisticItem2.param("nid", jt5Var.e());
            }
            if (jt5Var.g() > 0) {
                statisticItem2.param("pid", String.valueOf(jt5Var.g()));
            }
            if (!StringUtils.isNull(jt5Var.k)) {
                statisticItem2.param("obj_param1", jt5Var.k);
            }
            if (!StringUtils.isNull(jt5Var.l)) {
                statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, jt5Var.l);
            }
            if (!StringUtils.isNull(jt5Var.r)) {
                statisticItem2.param("is_dynamic", jt5Var.r);
            }
            if (!StringUtils.isNull(jt5Var.s)) {
                statisticItem2.param("resource_id", jt5Var.s);
            }
            if (!StringUtils.isNull(jt5Var.t)) {
                statisticItem2.param("resource_type", jt5Var.t);
            }
            if (!xi.isEmpty(jt5Var.j())) {
                statisticItem2.param("task_id", String.valueOf(jt5Var.j()));
            }
            if (!xi.isEmpty(jt5Var.a())) {
                statisticItem2.param("ab_tag", jt5Var.a());
            }
            if (g()) {
                if (!StringUtils.isNull(jt5Var.i)) {
                    statisticItem2.param("obj_id", jt5Var.i);
                }
                if (!StringUtils.isNull(jt5Var.j)) {
                    statisticItem2.param("obj_name", jt5Var.j);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(jt5Var.f())) {
                statisticItem2.param("obj_location", jt5Var.f());
            }
            if (jt5Var.b() != 0) {
                statisticItem2.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, jt5Var.b());
            }
            String fromWhichSearchSource = TbSingleton.getInstance().getFromWhichSearchSource();
            if (!StringUtils.isNull(fromWhichSearchSource) && jt5Var.h() != null && d(jt5Var.h())) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, fromWhichSearchSource);
                if (e(jt5Var.h())) {
                    TbSingleton.getInstance().setFromWhichSearchSource("");
                }
            }
            ct5.b(context, statisticItem2, jt5Var);
            TiebaStatic.log(statisticItem2);
            TiebaStatic.log(new StatisticItem("PushOptTime").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(jt5Var.i())).param("obj_source", it5.a(jt5Var.h())).param("obj_locate", jt5Var.c()).param("obj_param1", v85.a().b()));
        }
    }
}
