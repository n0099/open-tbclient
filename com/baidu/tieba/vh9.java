package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vh9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vh9 f;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public boolean c;
    public int d;
    public int e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948240930, "Lcom/baidu/tieba/vh9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948240930, "Lcom/baidu/tieba/vh9;");
        }
    }

    /* loaded from: classes8.dex */
    public class a extends ht5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.ht5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
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

        public a(vh9 vh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh9Var};
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

    public vh9() {
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
        this.a = 0L;
        this.b = 0L;
        this.c = false;
        this.d = 0;
        this.d = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds144);
        this.e = yi.j(TbadkCoreApplication.getInst());
    }

    public static vh9 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f == null) {
                synchronized (vh9.class) {
                    if (f == null) {
                        f = new vh9();
                    }
                }
            }
            return f;
        }
        return (vh9) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            f = null;
            this.a = 0L;
            this.c = false;
            this.b = 0L;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a == 0) {
            this.a = System.currentTimeMillis();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.b == 0) {
            this.b = System.currentTimeMillis();
        }
    }

    public final boolean b(View view2, ListView listView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, listView)) == null) {
            if (view2 != null) {
                int[] iArr = new int[2];
                view2.getLocationOnScreen(iArr);
                if (iArr[1] > 0 && iArr[1] < this.e - this.d) {
                    return true;
                }
            }
            if (listView == null || listView.getChildCount() <= 2) {
                return false;
            }
            View childAt = listView.getChildAt(listView.getChildCount() - 3);
            if (!(childAt instanceof ViewGroup)) {
                return false;
            }
            return ((ViewGroup) childAt).getChildAt(0) instanceof ThreadCardView;
        }
        return invokeLL.booleanValue;
    }

    public final boolean c(View view2, View view3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, view3)) == null) {
            if (view2 == null || view3 == null) {
                return false;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (view3.getVisibility() == 0) {
                return true;
            }
            if (i <= 0 || i >= this.e - this.d) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void e(Context context, jt5 jt5Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048579, this, context, jt5Var, str) != null) || jt5Var == null || StringUtils.isNull(jt5Var.c()) || !new a(this).a(jt5Var)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_source", it5.a(jt5Var.h()));
        statisticItem.param("obj_type", jt5Var.c());
        statisticItem.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(jt5Var.i()));
        if (jt5Var.d() > 0) {
            statisticItem.param("fid", String.valueOf(jt5Var.d()));
        }
        if (jt5Var.m() > 0) {
            statisticItem.param("tid", String.valueOf(jt5Var.m()));
        }
        if (!StringUtils.isNull(jt5Var.e())) {
            statisticItem.param("nid", jt5Var.e());
        }
        if (jt5Var.g() > 0) {
            statisticItem.param("pid", String.valueOf(jt5Var.g()));
        }
        if (!StringUtils.isNull(jt5Var.k)) {
            statisticItem.param("obj_param1", jt5Var.k);
        }
        if (!StringUtils.isNull(jt5Var.l)) {
            statisticItem.param(TiebaStatic.Params.IS_VERTICAL, jt5Var.l);
        }
        if (!StringUtils.isNull(jt5Var.r)) {
            statisticItem.param("is_dynamic", jt5Var.r);
        }
        if (!StringUtils.isNull(jt5Var.s)) {
            statisticItem.param("resource_id", jt5Var.s);
        }
        if (!xi.isEmpty(jt5Var.j())) {
            statisticItem.param("task_id", String.valueOf(jt5Var.j()));
        }
        if (!xi.isEmpty(jt5Var.a())) {
            statisticItem.param("ab_tag", jt5Var.a());
        }
        if (!StringUtils.isNull(jt5Var.f())) {
            statisticItem.param("obj_location", jt5Var.f());
        }
        ct5.b(context, statisticItem, jt5Var);
        TiebaStatic.log(statisticItem);
    }

    public void f(boolean z, View view2, View view3, jt5 jt5Var, boolean z2, View view4, ListView listView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), view2, view3, jt5Var, Boolean.valueOf(z2), view4, listView}) == null) {
            if (this.c) {
                z = false;
            } else {
                this.c = z;
            }
            if (!c(view2, view3) && (!z || z2)) {
                if (z2) {
                    j(jt5Var);
                }
            } else {
                g();
            }
            if (b(view4, listView)) {
                h();
            } else {
                k(jt5Var);
            }
        }
    }

    public void i(AbsPbActivity absPbActivity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, absPbActivity) == null) && absPbActivity != null) {
            j(absPbActivity.getPageStayDurationItem());
            k(absPbActivity.getPageStayDurationItem());
        }
    }

    public final void j(jt5 jt5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jt5Var) == null) && this.a > 0) {
            this.a = 0L;
            jt5Var.y(System.currentTimeMillis() - this.a);
            e(TbadkCoreApplication.getInst(), jt5Var, "c14085");
        }
    }

    public final void k(jt5 jt5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, jt5Var) == null) && this.b > 0) {
            this.b = 0L;
            jt5Var.y(System.currentTimeMillis() - this.b);
            e(TbadkCoreApplication.getInst(), jt5Var, "rec_stime");
        }
    }
}
