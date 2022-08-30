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
public class yh5 extends xh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext c;
    public zh5 d;
    public int e;

    public yh5(TbPageContext tbPageContext, ph5 ph5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ph5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = ph5Var;
        this.c = tbPageContext;
        ph5Var.a(this);
    }

    @Override // com.baidu.tieba.wh5
    public boolean a(String str) {
        InterceptResult invokeL;
        ph5 ph5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            ph5 ph5Var2 = this.b;
            if (ph5Var2 != null) {
                ph5Var2.i(str);
            }
            ai5 ai5Var = this.a;
            if (ai5Var == null || (ph5Var = this.b) == null) {
                return true;
            }
            ai5Var.d(ph5Var.c());
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.wh5
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.e = i;
        }
    }

    @Override // com.baidu.tieba.wh5
    public boolean c(sh5 sh5Var) {
        InterceptResult invokeL;
        ph5 ph5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sh5Var)) == null) {
            ph5 ph5Var2 = this.b;
            if (ph5Var2 != null && ph5Var2.c() >= 30) {
                j(this.c.getPageActivity(), false, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f02fd), 30));
                return false;
            }
            ph5 ph5Var3 = this.b;
            if (ph5Var3 != null) {
                ph5Var3.f(sh5Var);
            }
            ai5 ai5Var = this.a;
            if (ai5Var != null && (ph5Var = this.b) != null) {
                ai5Var.d(ph5Var.c());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.xh5, com.baidu.tieba.wh5
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ai5 ai5Var = this.a;
            if (ai5Var != null) {
                ai5Var.a();
            }
            ph5 ph5Var = this.b;
            if (ph5Var == null || ph5Var.b() == null || this.b.b().g() == null) {
                return;
            }
            this.b.b().g().a();
        }
    }

    @Override // com.baidu.tieba.xh5
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            dismiss();
        }
    }

    @Override // com.baidu.tieba.xh5
    public void f() {
        ph5 ph5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (ph5Var = this.b) == null || ph5Var.c() == 0) {
            return;
        }
        this.b.h("1");
        i();
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_MULTI_DEL_BUTTON_CLICK).param("obj_type", "1").param("obj_source", this.e == 3 ? "3" : "2"));
    }

    @Override // com.baidu.tieba.xh5
    public void g() {
        ph5 ph5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (ph5Var = this.b) == null || ph5Var.c() == 0) {
            return;
        }
        this.b.h("2");
        i();
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_MULTI_DEL_BUTTON_CLICK).param("obj_type", "2").param("obj_source", this.e == 3 ? "3" : "2"));
    }

    @Override // com.baidu.tieba.xh5
    public void h(uh5 uh5Var) {
        String str;
        vh5 vh5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, uh5Var) == null) {
            List<String> list = null;
            int i = -1;
            if (uh5Var == null) {
                str = "";
            } else if (uh5Var.a && (vh5Var = uh5Var.c) != null) {
                list = vh5Var.a;
                i = vh5Var.c;
                str = vh5Var.d;
            } else {
                str = uh5Var.b;
            }
            zh5 zh5Var = this.d;
            if (zh5Var != null) {
                zh5Var.b();
            }
            j(this.c.getPageActivity(), i == 0, str);
            ph5 ph5Var = this.b;
            if (ph5Var != null && ph5Var.b() != null && this.b.b().g() != null) {
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
            zh5 zh5Var = new zh5(this.c, this.b);
            this.d = zh5Var;
            zh5Var.c(this.e);
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

    @Override // com.baidu.tieba.wh5
    public void show() {
        ai5 ai5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (ai5Var = this.a) == null) {
            return;
        }
        ai5Var.e();
    }
}
