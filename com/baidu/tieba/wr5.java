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
public class wr5 {
    public static /* synthetic */ Interceptable $ic;
    public static wr5 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948280207, "Lcom/baidu/tieba/wr5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948280207, "Lcom/baidu/tieba/wr5;");
        }
    }

    /* loaded from: classes8.dex */
    public class a extends tr5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.tr5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 6;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.tr5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public a(wr5 wr5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr5Var};
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
    public class b extends tr5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr5 b;

        @Override // com.baidu.tieba.tr5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public b(wr5 wr5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wr5Var;
        }

        @Override // com.baidu.tieba.tr5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b.b;
            }
            return invokeV.intValue;
        }
    }

    public wr5() {
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

    public static wr5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (wr5.class) {
                    if (d == null) {
                        d = new wr5();
                    }
                }
            }
            return d;
        }
        return (wr5) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return n95.m().n("page_stay_max_cost", 0);
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
            n95.m().z("page_stay_max_cost", this.b);
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

    public void k(Context context, vr5 vr5Var, tr5 tr5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, vr5Var, tr5Var) == null) && vr5Var != null && !StringUtils.isNull(vr5Var.c())) {
            if (vr5Var.a) {
                if (tr5Var == null) {
                    tr5Var = new a(this);
                }
                if (!tr5Var.a(vr5Var)) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", ur5.a(vr5Var.h()));
                statisticItem.param("obj_locate", vr5Var.c());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(vr5Var.i)) {
                    statisticItem.param("obj_id", vr5Var.i);
                }
                if (vr5Var.b() != 0) {
                    statisticItem.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, vr5Var.b());
                }
                or5.b(context, statisticItem, vr5Var);
                TiebaStatic.log(statisticItem);
                return;
            }
            if (tr5Var == null) {
                tr5Var = new b(this);
            }
            if (!tr5Var.d() || !tr5Var.a(vr5Var)) {
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("stime");
            statisticItem2.param("obj_source", ur5.a(vr5Var.h()));
            statisticItem2.param("obj_type", vr5Var.c());
            statisticItem2.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(vr5Var.i()));
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (!StringUtils.isNull(vr5Var.n())) {
                statisticItem2.param("topic_id", vr5Var.n());
            }
            if (!StringUtils.isNull(vr5Var.o())) {
                statisticItem2.param(TiebaStatic.Params.TOPIC_TYPE, vr5Var.o());
            }
            if (vr5Var.d() > 0) {
                statisticItem2.param("fid", String.valueOf(vr5Var.d()));
            }
            if (vr5Var.m() > 0) {
                statisticItem2.param("tid", String.valueOf(vr5Var.m()));
            }
            if (vr5Var.l() > 0) {
                statisticItem2.param("thread_type", String.valueOf(vr5Var.l()));
            }
            if (!StringUtils.isNull(vr5Var.e())) {
                statisticItem2.param("nid", vr5Var.e());
            }
            if (vr5Var.g() > 0) {
                statisticItem2.param("pid", String.valueOf(vr5Var.g()));
            }
            if (!StringUtils.isNull(vr5Var.k)) {
                statisticItem2.param("obj_param1", vr5Var.k);
            }
            if (!StringUtils.isNull(vr5Var.l)) {
                statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, vr5Var.l);
            }
            if (!StringUtils.isNull(vr5Var.r)) {
                statisticItem2.param("is_dynamic", vr5Var.r);
            }
            if (!StringUtils.isNull(vr5Var.s)) {
                statisticItem2.param("resource_id", vr5Var.s);
            }
            if (!StringUtils.isNull(vr5Var.t)) {
                statisticItem2.param("resource_type", vr5Var.t);
            }
            if (!ui.isEmpty(vr5Var.j())) {
                statisticItem2.param("task_id", String.valueOf(vr5Var.j()));
            }
            if (!ui.isEmpty(vr5Var.a())) {
                statisticItem2.param("ab_tag", vr5Var.a());
            }
            if (g()) {
                if (!StringUtils.isNull(vr5Var.i)) {
                    statisticItem2.param("obj_id", vr5Var.i);
                }
                if (!StringUtils.isNull(vr5Var.j)) {
                    statisticItem2.param("obj_name", vr5Var.j);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(vr5Var.f())) {
                statisticItem2.param("obj_location", vr5Var.f());
            }
            if (vr5Var.b() != 0) {
                statisticItem2.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, vr5Var.b());
            }
            String fromWhichSearchSource = TbSingleton.getInstance().getFromWhichSearchSource();
            if (!StringUtils.isNull(fromWhichSearchSource) && vr5Var.h() != null && d(vr5Var.h())) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, fromWhichSearchSource);
                if (e(vr5Var.h())) {
                    TbSingleton.getInstance().setFromWhichSearchSource("");
                }
            }
            or5.b(context, statisticItem2, vr5Var);
            TiebaStatic.log(statisticItem2);
            TiebaStatic.log(new StatisticItem("PushOptTime").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(vr5Var.i())).param("obj_source", ur5.a(vr5Var.h())).param("obj_locate", vr5Var.c()).param("obj_param1", g85.a().b()));
        }
    }
}
