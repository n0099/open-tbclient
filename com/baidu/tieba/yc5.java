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
public class yc5 {
    public static /* synthetic */ Interceptable $ic;
    public static yc5 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;

    /* loaded from: classes6.dex */
    public class a extends vc5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(yc5 yc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.vc5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 6;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.vc5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends vc5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc5 b;

        public b(yc5 yc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yc5Var;
        }

        @Override // com.baidu.tieba.vc5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b.b : invokeV.intValue;
        }

        @Override // com.baidu.tieba.vc5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948325374, "Lcom/baidu/tieba/yc5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948325374, "Lcom/baidu/tieba/yc5;");
        }
    }

    public yc5() {
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

    public static yc5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (yc5.class) {
                    if (d == null) {
                        d = new yc5();
                    }
                }
            }
            return d;
        }
        return (yc5) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return ox4.k().l("page_stay_max_cost", 0);
            }
            return this.b;
        }
        return invokeV.intValue;
    }

    public final boolean d(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            return "a026".equals(list.get(list.size() - 1)) || e(list);
        }
        return invokeL.booleanValue;
    }

    public final boolean e(List<String> list) {
        InterceptResult invokeL;
        int size;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) ? !ListUtils.isEmpty(list) && (size = list.size()) >= 2 && "a026".equals(list.get(size - 2)) : invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : invokeV.booleanValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.b = i;
            ox4.k().w("page_stay_max_cost", this.b);
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

    public void k(Context context, xc5 xc5Var, vc5 vc5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, xc5Var, vc5Var) == null) || xc5Var == null || StringUtils.isNull(xc5Var.c())) {
            return;
        }
        if (xc5Var.a) {
            if (vc5Var == null) {
                vc5Var = new a(this);
            }
            if (vc5Var.a(xc5Var)) {
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", wc5.a(xc5Var.h()));
                statisticItem.param("obj_locate", xc5Var.c());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(xc5Var.i)) {
                    statisticItem.param("obj_id", xc5Var.i);
                }
                if (xc5Var.b() != 0) {
                    statisticItem.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, xc5Var.b());
                }
                qc5.b(context, statisticItem, xc5Var);
                TiebaStatic.log(statisticItem);
                return;
            }
            return;
        }
        if (vc5Var == null) {
            vc5Var = new b(this);
        }
        if (vc5Var.d() && vc5Var.a(xc5Var)) {
            StatisticItem statisticItem2 = new StatisticItem("stime");
            statisticItem2.param("obj_source", wc5.a(xc5Var.h()));
            statisticItem2.param("obj_type", xc5Var.c());
            statisticItem2.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(xc5Var.i()));
            if (!StringUtils.isNull(xc5Var.n())) {
                statisticItem2.param("topic_id", xc5Var.n());
            }
            if (!StringUtils.isNull(xc5Var.o())) {
                statisticItem2.param(TiebaStatic.Params.TOPIC_TYPE, xc5Var.o());
            }
            if (xc5Var.d() > 0) {
                statisticItem2.param("fid", String.valueOf(xc5Var.d()));
            }
            if (xc5Var.m() > 0) {
                statisticItem2.param("tid", String.valueOf(xc5Var.m()));
            }
            if (xc5Var.l() > 0) {
                statisticItem2.param("thread_type", String.valueOf(xc5Var.l()));
            }
            if (!StringUtils.isNull(xc5Var.e())) {
                statisticItem2.param("nid", xc5Var.e());
            }
            if (xc5Var.g() > 0) {
                statisticItem2.param("pid", String.valueOf(xc5Var.g()));
            }
            if (!StringUtils.isNull(xc5Var.k)) {
                statisticItem2.param("obj_param1", xc5Var.k);
            }
            if (!StringUtils.isNull(xc5Var.l)) {
                statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, xc5Var.l);
            }
            if (!StringUtils.isNull(xc5Var.r)) {
                statisticItem2.param("is_dynamic", xc5Var.r);
            }
            if (!StringUtils.isNull(xc5Var.s)) {
                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, xc5Var.s);
            }
            if (!StringUtils.isNull(xc5Var.t)) {
                statisticItem2.param("resource_type", xc5Var.t);
            }
            if (!dj.isEmpty(xc5Var.j())) {
                statisticItem2.param("task_id", String.valueOf(xc5Var.j()));
            }
            if (!dj.isEmpty(xc5Var.a())) {
                statisticItem2.param("ab_tag", xc5Var.a());
            }
            if (g()) {
                if (!StringUtils.isNull(xc5Var.i)) {
                    statisticItem2.param("obj_id", xc5Var.i);
                }
                if (!StringUtils.isNull(xc5Var.j)) {
                    statisticItem2.param("obj_name", xc5Var.j);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(xc5Var.f())) {
                statisticItem2.param("obj_location", xc5Var.f());
            }
            if (xc5Var.b() != 0) {
                statisticItem2.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, xc5Var.b());
            }
            String fromWhichSearchSource = TbSingleton.getInstance().getFromWhichSearchSource();
            if (!StringUtils.isNull(fromWhichSearchSource) && xc5Var.h() != null && d(xc5Var.h())) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, fromWhichSearchSource);
                if (e(xc5Var.h())) {
                    TbSingleton.getInstance().setFromWhichSearchSource("");
                }
            }
            qc5.b(context, statisticItem2, xc5Var);
            TiebaStatic.log(statisticItem2);
            TiebaStatic.log(new StatisticItem("PushOptTime").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(xc5Var.i())).param("obj_source", wc5.a(xc5Var.h())).param("obj_locate", xc5Var.c()).param("obj_param1", aw4.a().b()));
        }
    }
}
