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
public class q26 extends p26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext c;
    public r26 d;
    public int e;

    public q26(TbPageContext tbPageContext, h26 h26Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, h26Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = h26Var;
        this.c = tbPageContext;
        h26Var.a(this);
    }

    @Override // com.baidu.tieba.o26
    public boolean a(String str) {
        InterceptResult invokeL;
        h26 h26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            h26 h26Var2 = this.b;
            if (h26Var2 != null) {
                h26Var2.i(str);
            }
            s26 s26Var = this.a;
            if (s26Var != null && (h26Var = this.b) != null) {
                s26Var.d(h26Var.c());
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.o26
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.e = i;
        }
    }

    @Override // com.baidu.tieba.o26
    public boolean c(k26 k26Var) {
        InterceptResult invokeL;
        h26 h26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k26Var)) == null) {
            h26 h26Var2 = this.b;
            if (h26Var2 != null && h26Var2.c() >= 30) {
                j(this.c.getPageActivity(), false, String.format(this.c.getString(R.string.bawu_multi_del_post_max_num), 30));
                return false;
            }
            h26 h26Var3 = this.b;
            if (h26Var3 != null) {
                h26Var3.f(k26Var);
            }
            s26 s26Var = this.a;
            if (s26Var != null && (h26Var = this.b) != null) {
                s26Var.d(h26Var.c());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.p26, com.baidu.tieba.o26
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            s26 s26Var = this.a;
            if (s26Var != null) {
                s26Var.a();
            }
            h26 h26Var = this.b;
            if (h26Var != null && h26Var.b() != null && this.b.b().g() != null) {
                this.b.b().g().a();
            }
        }
    }

    @Override // com.baidu.tieba.p26
    public void f() {
        h26 h26Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (h26Var = this.b) != null && h26Var.c() != 0) {
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

    @Override // com.baidu.tieba.p26
    public void g() {
        h26 h26Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (h26Var = this.b) != null && h26Var.c() != 0) {
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

    @Override // com.baidu.tieba.p26
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            dismiss();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            r26 r26Var = new r26(this.c, this.b);
            this.d = r26Var;
            r26Var.c(this.e);
        }
    }

    @Override // com.baidu.tieba.o26
    public void show() {
        s26 s26Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (s26Var = this.a) != null) {
            s26Var.e();
        }
    }

    @Override // com.baidu.tieba.p26
    public void h(m26 m26Var) {
        String str;
        boolean z;
        n26 n26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, m26Var) == null) {
            List<String> list = null;
            int i = -1;
            if (m26Var != null) {
                if (m26Var.a && (n26Var = m26Var.c) != null) {
                    list = n26Var.a;
                    i = n26Var.c;
                    str = n26Var.d;
                } else {
                    str = m26Var.b;
                }
            } else {
                str = "";
            }
            r26 r26Var = this.d;
            if (r26Var != null) {
                r26Var.b();
            }
            Activity pageActivity = this.c.getPageActivity();
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            j(pageActivity, z, str);
            h26 h26Var = this.b;
            if (h26Var != null && h26Var.b() != null && this.b.b().g() != null) {
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
