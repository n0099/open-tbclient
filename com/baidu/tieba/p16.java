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
/* loaded from: classes7.dex */
public class p16 extends o16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext c;
    public q16 d;
    public int e;

    public p16(TbPageContext tbPageContext, g16 g16Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, g16Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = g16Var;
        this.c = tbPageContext;
        g16Var.a(this);
    }

    @Override // com.baidu.tieba.n16
    public boolean a(String str) {
        InterceptResult invokeL;
        g16 g16Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            g16 g16Var2 = this.b;
            if (g16Var2 != null) {
                g16Var2.i(str);
            }
            r16 r16Var = this.a;
            if (r16Var != null && (g16Var = this.b) != null) {
                r16Var.d(g16Var.c());
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.n16
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.e = i;
        }
    }

    @Override // com.baidu.tieba.n16
    public boolean c(j16 j16Var) {
        InterceptResult invokeL;
        g16 g16Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, j16Var)) == null) {
            g16 g16Var2 = this.b;
            if (g16Var2 != null && g16Var2.c() >= 30) {
                j(this.c.getPageActivity(), false, String.format(this.c.getString(R.string.bawu_multi_del_post_max_num), 30));
                return false;
            }
            g16 g16Var3 = this.b;
            if (g16Var3 != null) {
                g16Var3.f(j16Var);
            }
            r16 r16Var = this.a;
            if (r16Var != null && (g16Var = this.b) != null) {
                r16Var.d(g16Var.c());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.o16, com.baidu.tieba.n16
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            r16 r16Var = this.a;
            if (r16Var != null) {
                r16Var.a();
            }
            g16 g16Var = this.b;
            if (g16Var != null && g16Var.b() != null && this.b.b().g() != null) {
                this.b.b().g().a();
            }
        }
    }

    @Override // com.baidu.tieba.o16
    public void f() {
        g16 g16Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (g16Var = this.b) != null && g16Var.c() != 0) {
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

    @Override // com.baidu.tieba.o16
    public void g() {
        g16 g16Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (g16Var = this.b) != null && g16Var.c() != 0) {
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

    @Override // com.baidu.tieba.o16
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            dismiss();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            q16 q16Var = new q16(this.c, this.b);
            this.d = q16Var;
            q16Var.c(this.e);
        }
    }

    @Override // com.baidu.tieba.n16
    public void show() {
        r16 r16Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (r16Var = this.a) != null) {
            r16Var.e();
        }
    }

    @Override // com.baidu.tieba.o16
    public void h(l16 l16Var) {
        String str;
        boolean z;
        m16 m16Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, l16Var) == null) {
            List<String> list = null;
            int i = -1;
            if (l16Var != null) {
                if (l16Var.a && (m16Var = l16Var.c) != null) {
                    list = m16Var.a;
                    i = m16Var.c;
                    str = m16Var.d;
                } else {
                    str = l16Var.b;
                }
            } else {
                str = "";
            }
            q16 q16Var = this.d;
            if (q16Var != null) {
                q16Var.b();
            }
            Activity pageActivity = this.c.getPageActivity();
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            j(pageActivity, z, str);
            g16 g16Var = this.b;
            if (g16Var != null && g16Var.b() != null && this.b.b().g() != null) {
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
            new BdTopToast(activity, 3000).setIcon(z).setContent(str).show((ViewGroup) findViewById);
        }
    }
}
