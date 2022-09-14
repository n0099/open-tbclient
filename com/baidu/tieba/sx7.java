package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class sx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a75 a;
    public TbPageContext b;
    public RelativeLayout c;
    public PbFakeFloorModel d;
    public String e;
    public String f;
    public NewWriteModel.d g;
    public vu7 h;
    public View.OnClickListener i;

    public sx7(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, pbFakeFloorModel, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
        this.c = relativeLayout;
        this.d = pbFakeFloorModel;
    }

    public final void a() {
        a75 a75Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c == null || (a75Var = this.a) == null || a75Var.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.c.addView(this.a.a(), layoutParams);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public a75 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (a75) invokeV.objValue;
    }

    public void c() {
        a75 a75Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (a75Var = this.a) == null) {
            return;
        }
        a75Var.z();
        if (StringUtils.isNull(this.e)) {
            this.a.E();
        }
        this.a.a().y();
    }

    public void d() {
        a75 a75Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (a75Var = this.a) == null || a75Var.a() == null) {
            return;
        }
        this.a.a().q();
    }

    public final void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) && this.c != null && this.a == null) {
            b75 b75Var = new b75(z);
            b75Var.i(str);
            a75 a75Var = (a75) b75Var.a(this.b.getPageActivity());
            this.a = a75Var;
            a75Var.O(this.b);
            this.a.b0(this.d);
            this.a.P(1);
            vu7 vu7Var = this.h;
            if (vu7Var != null) {
                this.a.d0(vu7Var.O());
            }
            this.a.a().C(true);
            this.a.a().setOnCancelClickListener(this.i);
            this.a.A(this.b);
            a();
            this.a.R(this.g);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            a75 a75Var = this.a;
            if (a75Var == null || a75Var.a() == null) {
                return false;
            }
            return this.a.a().u();
        }
        return invokeV.booleanValue;
    }

    public void g(int i, int i2, Intent intent) {
        a75 a75Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) || (a75Var = this.a) == null) {
            return;
        }
        a75Var.D(i, i2, intent);
    }

    public void h(int i) {
        a75 a75Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (a75Var = this.a) == null || a75Var.a() == null) {
            return;
        }
        this.a.a().w(i);
    }

    public void i() {
        a75 a75Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (a75Var = this.a) == null) {
            return;
        }
        a75Var.F();
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f = str;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.i = onClickListener;
        }
    }

    public void l(int i) {
        a75 a75Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || (a75Var = this.a) == null) {
            return;
        }
        a75Var.Q(i);
    }

    public void m(vu7 vu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, vu7Var) == null) {
            this.h = vu7Var;
        }
    }

    public void n(NewWriteModel.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.g = dVar;
            a75 a75Var = this.a;
            if (a75Var != null) {
                a75Var.R(dVar);
            }
        }
    }

    public void o(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            this.e = str2;
            a75 a75Var = this.a;
            if (a75Var == null) {
                e(str3, z);
            } else {
                a75Var.b0(this.d);
                if (StringUtils.isNull(this.e)) {
                    this.a.A(this.b);
                }
            }
            this.a.X(str);
            this.a.W(str2, "");
            this.a.q(this.f);
            if (this.a.y()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.a.w(null);
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }
}
