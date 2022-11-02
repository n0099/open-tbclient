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
public class yl5 extends xl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext c;
    public zl5 d;
    public int e;

    public yl5(TbPageContext tbPageContext, pl5 pl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, pl5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = pl5Var;
        this.c = tbPageContext;
        pl5Var.a(this);
    }

    @Override // com.baidu.tieba.wl5
    public boolean a(String str) {
        InterceptResult invokeL;
        pl5 pl5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            pl5 pl5Var2 = this.b;
            if (pl5Var2 != null) {
                pl5Var2.i(str);
            }
            am5 am5Var = this.a;
            if (am5Var != null && (pl5Var = this.b) != null) {
                am5Var.d(pl5Var.c());
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.wl5
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.e = i;
        }
    }

    @Override // com.baidu.tieba.wl5
    public boolean c(sl5 sl5Var) {
        InterceptResult invokeL;
        pl5 pl5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sl5Var)) == null) {
            pl5 pl5Var2 = this.b;
            if (pl5Var2 != null && pl5Var2.c() >= 30) {
                j(this.c.getPageActivity(), false, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f0302), 30));
                return false;
            }
            pl5 pl5Var3 = this.b;
            if (pl5Var3 != null) {
                pl5Var3.f(sl5Var);
            }
            am5 am5Var = this.a;
            if (am5Var != null && (pl5Var = this.b) != null) {
                am5Var.d(pl5Var.c());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.xl5, com.baidu.tieba.wl5
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            am5 am5Var = this.a;
            if (am5Var != null) {
                am5Var.a();
            }
            pl5 pl5Var = this.b;
            if (pl5Var != null && pl5Var.b() != null && this.b.b().g() != null) {
                this.b.b().g().a();
            }
        }
    }

    @Override // com.baidu.tieba.xl5
    public void f() {
        pl5 pl5Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (pl5Var = this.b) != null && pl5Var.c() != 0) {
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

    @Override // com.baidu.tieba.xl5
    public void g() {
        pl5 pl5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (pl5Var = this.b) != null && pl5Var.c() != 0) {
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

    @Override // com.baidu.tieba.xl5
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            dismiss();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            zl5 zl5Var = new zl5(this.c, this.b);
            this.d = zl5Var;
            zl5Var.c(this.e);
        }
    }

    @Override // com.baidu.tieba.wl5
    public void show() {
        am5 am5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (am5Var = this.a) != null) {
            am5Var.e();
        }
    }

    @Override // com.baidu.tieba.xl5
    public void h(ul5 ul5Var) {
        String str;
        boolean z;
        vl5 vl5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ul5Var) == null) {
            List<String> list = null;
            int i = -1;
            if (ul5Var != null) {
                if (ul5Var.a && (vl5Var = ul5Var.c) != null) {
                    list = vl5Var.a;
                    i = vl5Var.c;
                    str = vl5Var.d;
                } else {
                    str = ul5Var.b;
                }
            } else {
                str = "";
            }
            zl5 zl5Var = this.d;
            if (zl5Var != null) {
                zl5Var.b();
            }
            Activity pageActivity = this.c.getPageActivity();
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            j(pageActivity, z, str);
            pl5 pl5Var = this.b;
            if (pl5Var != null && pl5Var.b() != null && this.b.b().g() != null) {
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
