package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class wh5 extends vh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext c;
    public xh5 d;
    public int e;

    public wh5(TbPageContext tbPageContext, nh5 nh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, nh5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = nh5Var;
        this.c = tbPageContext;
        nh5Var.a(this);
    }

    @Override // com.baidu.tieba.uh5
    public boolean a(String str) {
        InterceptResult invokeL;
        nh5 nh5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            nh5 nh5Var2 = this.b;
            if (nh5Var2 != null) {
                nh5Var2.i(str);
            }
            yh5 yh5Var = this.a;
            if (yh5Var == null || (nh5Var = this.b) == null) {
                return true;
            }
            yh5Var.d(nh5Var.c());
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.uh5
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.e = i;
        }
    }

    @Override // com.baidu.tieba.uh5
    public boolean c(qh5 qh5Var) {
        InterceptResult invokeL;
        nh5 nh5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qh5Var)) == null) {
            nh5 nh5Var2 = this.b;
            if (nh5Var2 != null && nh5Var2.c() >= 30) {
                j(this.c.getPageActivity(), false, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f02fd), 30));
                return false;
            }
            nh5 nh5Var3 = this.b;
            if (nh5Var3 != null) {
                nh5Var3.f(qh5Var);
            }
            yh5 yh5Var = this.a;
            if (yh5Var != null && (nh5Var = this.b) != null) {
                yh5Var.d(nh5Var.c());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.vh5, com.baidu.tieba.uh5
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            yh5 yh5Var = this.a;
            if (yh5Var != null) {
                yh5Var.a();
            }
            nh5 nh5Var = this.b;
            if (nh5Var == null || nh5Var.b() == null || this.b.b().g() == null) {
                return;
            }
            this.b.b().g().a();
        }
    }

    @Override // com.baidu.tieba.vh5
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            dismiss();
        }
    }

    @Override // com.baidu.tieba.vh5
    public void f() {
        nh5 nh5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (nh5Var = this.b) == null || nh5Var.c() == 0) {
            return;
        }
        this.b.h("1");
        i();
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_MULTI_DEL_BUTTON_CLICK).param("obj_type", "1").param("obj_source", this.e == 3 ? "3" : "2"));
    }

    @Override // com.baidu.tieba.vh5
    public void g() {
        nh5 nh5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (nh5Var = this.b) == null || nh5Var.c() == 0) {
            return;
        }
        this.b.h("2");
        i();
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_MULTI_DEL_BUTTON_CLICK).param("obj_type", "2").param("obj_source", this.e == 3 ? "3" : "2"));
    }

    @Override // com.baidu.tieba.vh5
    public void h(sh5 sh5Var) {
        String str;
        th5 th5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sh5Var) == null) {
            List<String> list = null;
            int i = -1;
            if (sh5Var == null) {
                str = "";
            } else if (sh5Var.a && (th5Var = sh5Var.c) != null) {
                list = th5Var.a;
                i = th5Var.c;
                str = th5Var.d;
            } else {
                str = sh5Var.b;
            }
            xh5 xh5Var = this.d;
            if (xh5Var != null) {
                xh5Var.b();
            }
            j(this.c.getPageActivity(), i == 0, str);
            nh5 nh5Var = this.b;
            if (nh5Var != null && nh5Var.b() != null && this.b.b().g() != null) {
                this.b.b().g().b(list);
            }
            if (i == 0) {
                dismiss();
            } else if (!ListUtils.isEmpty(list)) {
                for (String str2 : list) {
                    a(str2);
                }
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            xh5 xh5Var = new xh5(this.c, this.b);
            this.d = xh5Var;
            xh5Var.c(this.e);
        }
    }

    public final void j(Activity activity, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{activity, Boolean.valueOf(z), str}) == null) || activity == null || TextUtils.isEmpty(str)) {
            return;
        }
        View findViewById = activity.findViewById(16908290);
        if (findViewById instanceof ViewGroup) {
            BdTopToast bdTopToast = new BdTopToast(activity, 3000);
            bdTopToast.h(z);
            bdTopToast.g(str);
            bdTopToast.i((ViewGroup) findViewById);
        }
    }

    @Override // com.baidu.tieba.uh5
    public void show() {
        yh5 yh5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (yh5Var = this.a) == null) {
            return;
        }
        yh5Var.e();
    }
}
