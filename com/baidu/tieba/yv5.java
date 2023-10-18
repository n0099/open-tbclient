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
/* loaded from: classes9.dex */
public class yv5 extends xv5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext c;
    public zv5 d;
    public int e;

    public yv5(TbPageContext tbPageContext, pv5 pv5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, pv5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = pv5Var;
        this.c = tbPageContext;
        pv5Var.a(this);
    }

    @Override // com.baidu.tieba.wv5
    public boolean a(String str) {
        InterceptResult invokeL;
        pv5 pv5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            pv5 pv5Var2 = this.b;
            if (pv5Var2 != null) {
                pv5Var2.i(str);
            }
            aw5 aw5Var = this.a;
            if (aw5Var != null && (pv5Var = this.b) != null) {
                aw5Var.d(pv5Var.c());
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.wv5
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.e = i;
        }
    }

    @Override // com.baidu.tieba.wv5
    public boolean c(sv5 sv5Var) {
        InterceptResult invokeL;
        pv5 pv5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sv5Var)) == null) {
            pv5 pv5Var2 = this.b;
            if (pv5Var2 != null && pv5Var2.c() >= 30) {
                j(this.c.getPageActivity(), false, String.format(this.c.getString(R.string.bawu_multi_del_post_max_num), 30));
                return false;
            }
            pv5 pv5Var3 = this.b;
            if (pv5Var3 != null) {
                pv5Var3.f(sv5Var);
            }
            aw5 aw5Var = this.a;
            if (aw5Var != null && (pv5Var = this.b) != null) {
                aw5Var.d(pv5Var.c());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.xv5, com.baidu.tieba.wv5
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            aw5 aw5Var = this.a;
            if (aw5Var != null) {
                aw5Var.a();
            }
            pv5 pv5Var = this.b;
            if (pv5Var != null && pv5Var.b() != null && this.b.b().g() != null) {
                this.b.b().g().a();
            }
        }
    }

    @Override // com.baidu.tieba.xv5
    public void f() {
        pv5 pv5Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (pv5Var = this.b) != null && pv5Var.c() != 0) {
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

    @Override // com.baidu.tieba.xv5
    public void g() {
        pv5 pv5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (pv5Var = this.b) != null && pv5Var.c() != 0) {
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

    @Override // com.baidu.tieba.xv5
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            dismiss();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            zv5 zv5Var = new zv5(this.c, this.b);
            this.d = zv5Var;
            zv5Var.c(this.e);
        }
    }

    @Override // com.baidu.tieba.wv5
    public void show() {
        aw5 aw5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (aw5Var = this.a) != null) {
            aw5Var.e();
        }
    }

    @Override // com.baidu.tieba.xv5
    public void h(uv5 uv5Var) {
        String str;
        boolean z;
        vv5 vv5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, uv5Var) == null) {
            List<String> list = null;
            int i = -1;
            if (uv5Var != null) {
                if (uv5Var.a && (vv5Var = uv5Var.c) != null) {
                    list = vv5Var.a;
                    i = vv5Var.c;
                    str = vv5Var.d;
                } else {
                    str = uv5Var.b;
                }
            } else {
                str = "";
            }
            zv5 zv5Var = this.d;
            if (zv5Var != null) {
                zv5Var.b();
            }
            Activity pageActivity = this.c.getPageActivity();
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            j(pageActivity, z, str);
            pv5 pv5Var = this.b;
            if (pv5Var != null && pv5Var.b() != null && this.b.b().g() != null) {
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
