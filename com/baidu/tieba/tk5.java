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
public class tk5 extends sk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext c;
    public uk5 d;
    public int e;

    public tk5(TbPageContext tbPageContext, kk5 kk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, kk5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = kk5Var;
        this.c = tbPageContext;
        kk5Var.a(this);
    }

    @Override // com.baidu.tieba.rk5
    public boolean a(String str) {
        InterceptResult invokeL;
        kk5 kk5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            kk5 kk5Var2 = this.b;
            if (kk5Var2 != null) {
                kk5Var2.i(str);
            }
            vk5 vk5Var = this.a;
            if (vk5Var == null || (kk5Var = this.b) == null) {
                return true;
            }
            vk5Var.d(kk5Var.c());
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.rk5
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.e = i;
        }
    }

    @Override // com.baidu.tieba.rk5
    public boolean c(nk5 nk5Var) {
        InterceptResult invokeL;
        kk5 kk5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nk5Var)) == null) {
            kk5 kk5Var2 = this.b;
            if (kk5Var2 != null && kk5Var2.c() >= 30) {
                j(this.c.getPageActivity(), false, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0301), 30));
                return false;
            }
            kk5 kk5Var3 = this.b;
            if (kk5Var3 != null) {
                kk5Var3.f(nk5Var);
            }
            vk5 vk5Var = this.a;
            if (vk5Var != null && (kk5Var = this.b) != null) {
                vk5Var.d(kk5Var.c());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.sk5, com.baidu.tieba.rk5
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            vk5 vk5Var = this.a;
            if (vk5Var != null) {
                vk5Var.a();
            }
            kk5 kk5Var = this.b;
            if (kk5Var == null || kk5Var.b() == null || this.b.b().g() == null) {
                return;
            }
            this.b.b().g().a();
        }
    }

    @Override // com.baidu.tieba.sk5
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            dismiss();
        }
    }

    @Override // com.baidu.tieba.sk5
    public void f() {
        kk5 kk5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (kk5Var = this.b) == null || kk5Var.c() == 0) {
            return;
        }
        this.b.h("1");
        i();
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_MULTI_DEL_BUTTON_CLICK).param("obj_type", "1").param("obj_source", this.e == 3 ? "3" : "2"));
    }

    @Override // com.baidu.tieba.sk5
    public void g() {
        kk5 kk5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (kk5Var = this.b) == null || kk5Var.c() == 0) {
            return;
        }
        this.b.h("2");
        i();
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_MULTI_DEL_BUTTON_CLICK).param("obj_type", "2").param("obj_source", this.e == 3 ? "3" : "2"));
    }

    @Override // com.baidu.tieba.sk5
    public void h(pk5 pk5Var) {
        String str;
        qk5 qk5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, pk5Var) == null) {
            List<String> list = null;
            int i = -1;
            if (pk5Var == null) {
                str = "";
            } else if (pk5Var.a && (qk5Var = pk5Var.c) != null) {
                list = qk5Var.a;
                i = qk5Var.c;
                str = qk5Var.d;
            } else {
                str = pk5Var.b;
            }
            uk5 uk5Var = this.d;
            if (uk5Var != null) {
                uk5Var.b();
            }
            j(this.c.getPageActivity(), i == 0, str);
            kk5 kk5Var = this.b;
            if (kk5Var != null && kk5Var.b() != null && this.b.b().g() != null) {
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
            uk5 uk5Var = new uk5(this.c, this.b);
            this.d = uk5Var;
            uk5Var.c(this.e);
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

    @Override // com.baidu.tieba.rk5
    public void show() {
        vk5 vk5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (vk5Var = this.a) == null) {
            return;
        }
        vk5Var.e();
    }
}
