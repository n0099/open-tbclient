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
public class m16 extends l16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext c;
    public n16 d;
    public int e;

    public m16(TbPageContext tbPageContext, d16 d16Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, d16Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = d16Var;
        this.c = tbPageContext;
        d16Var.a(this);
    }

    @Override // com.baidu.tieba.k16
    public boolean a(String str) {
        InterceptResult invokeL;
        d16 d16Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            d16 d16Var2 = this.b;
            if (d16Var2 != null) {
                d16Var2.i(str);
            }
            o16 o16Var = this.a;
            if (o16Var != null && (d16Var = this.b) != null) {
                o16Var.d(d16Var.c());
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.k16
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.e = i;
        }
    }

    @Override // com.baidu.tieba.k16
    public boolean c(g16 g16Var) {
        InterceptResult invokeL;
        d16 d16Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, g16Var)) == null) {
            d16 d16Var2 = this.b;
            if (d16Var2 != null && d16Var2.c() >= 30) {
                j(this.c.getPageActivity(), false, String.format(this.c.getString(R.string.bawu_multi_del_post_max_num), 30));
                return false;
            }
            d16 d16Var3 = this.b;
            if (d16Var3 != null) {
                d16Var3.f(g16Var);
            }
            o16 o16Var = this.a;
            if (o16Var != null && (d16Var = this.b) != null) {
                o16Var.d(d16Var.c());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.l16, com.baidu.tieba.k16
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            o16 o16Var = this.a;
            if (o16Var != null) {
                o16Var.a();
            }
            d16 d16Var = this.b;
            if (d16Var != null && d16Var.b() != null && this.b.b().g() != null) {
                this.b.b().g().a();
            }
        }
    }

    @Override // com.baidu.tieba.l16
    public void f() {
        d16 d16Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (d16Var = this.b) != null && d16Var.c() != 0) {
            this.b.h("1");
            i();
            StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_MULTI_DEL_BUTTON_CLICK).param("obj_type", "1");
            if (this.e == 3) {
                str = "3";
            } else {
                str = "2";
            }
            TiebaStatic.log(param.param("obj_source", str));
        }
    }

    @Override // com.baidu.tieba.l16
    public void g() {
        d16 d16Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (d16Var = this.b) != null && d16Var.c() != 0) {
            String str = "2";
            this.b.h("2");
            i();
            StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_MULTI_DEL_BUTTON_CLICK).param("obj_type", "2");
            if (this.e == 3) {
                str = "3";
            }
            TiebaStatic.log(param.param("obj_source", str));
        }
    }

    @Override // com.baidu.tieba.l16
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            dismiss();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            n16 n16Var = new n16(this.c, this.b);
            this.d = n16Var;
            n16Var.c(this.e);
        }
    }

    @Override // com.baidu.tieba.k16
    public void show() {
        o16 o16Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (o16Var = this.a) != null) {
            o16Var.e();
        }
    }

    @Override // com.baidu.tieba.l16
    public void h(i16 i16Var) {
        String str;
        boolean z;
        j16 j16Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, i16Var) == null) {
            List<String> list = null;
            int i = -1;
            if (i16Var != null) {
                if (i16Var.a && (j16Var = i16Var.c) != null) {
                    list = j16Var.a;
                    i = j16Var.c;
                    str = j16Var.d;
                } else {
                    str = i16Var.b;
                }
            } else {
                str = "";
            }
            n16 n16Var = this.d;
            if (n16Var != null) {
                n16Var.b();
            }
            Activity pageActivity = this.c.getPageActivity();
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            j(pageActivity, z, str);
            d16 d16Var = this.b;
            if (d16Var != null && d16Var.b() != null && this.b.b().g() != null) {
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

    public final void j(Activity activity, boolean z, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{activity, Boolean.valueOf(z), str}) == null) && activity != null && !TextUtils.isEmpty(str)) {
            View findViewById = activity.findViewById(16908290);
            if (!(findViewById instanceof ViewGroup)) {
                return;
            }
            BdTopToast bdTopToast = new BdTopToast(activity, 3000);
            bdTopToast.h(z);
            bdTopToast.g(str);
            bdTopToast.i((ViewGroup) findViewById);
        }
    }
}
