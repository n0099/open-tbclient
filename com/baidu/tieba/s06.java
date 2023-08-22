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
public class s06 extends r06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext c;
    public t06 d;
    public int e;

    public s06(TbPageContext tbPageContext, j06 j06Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, j06Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = j06Var;
        this.c = tbPageContext;
        j06Var.a(this);
    }

    @Override // com.baidu.tieba.q06
    public boolean a(String str) {
        InterceptResult invokeL;
        j06 j06Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            j06 j06Var2 = this.b;
            if (j06Var2 != null) {
                j06Var2.i(str);
            }
            u06 u06Var = this.a;
            if (u06Var != null && (j06Var = this.b) != null) {
                u06Var.d(j06Var.c());
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.q06
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.e = i;
        }
    }

    @Override // com.baidu.tieba.q06
    public boolean c(m06 m06Var) {
        InterceptResult invokeL;
        j06 j06Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, m06Var)) == null) {
            j06 j06Var2 = this.b;
            if (j06Var2 != null && j06Var2.c() >= 30) {
                j(this.c.getPageActivity(), false, String.format(this.c.getString(R.string.bawu_multi_del_post_max_num), 30));
                return false;
            }
            j06 j06Var3 = this.b;
            if (j06Var3 != null) {
                j06Var3.f(m06Var);
            }
            u06 u06Var = this.a;
            if (u06Var != null && (j06Var = this.b) != null) {
                u06Var.d(j06Var.c());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.r06, com.baidu.tieba.q06
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            u06 u06Var = this.a;
            if (u06Var != null) {
                u06Var.a();
            }
            j06 j06Var = this.b;
            if (j06Var != null && j06Var.b() != null && this.b.b().g() != null) {
                this.b.b().g().a();
            }
        }
    }

    @Override // com.baidu.tieba.r06
    public void f() {
        j06 j06Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (j06Var = this.b) != null && j06Var.c() != 0) {
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

    @Override // com.baidu.tieba.r06
    public void g() {
        j06 j06Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (j06Var = this.b) != null && j06Var.c() != 0) {
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

    @Override // com.baidu.tieba.r06
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            dismiss();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            t06 t06Var = new t06(this.c, this.b);
            this.d = t06Var;
            t06Var.c(this.e);
        }
    }

    @Override // com.baidu.tieba.q06
    public void show() {
        u06 u06Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (u06Var = this.a) != null) {
            u06Var.e();
        }
    }

    @Override // com.baidu.tieba.r06
    public void h(o06 o06Var) {
        String str;
        boolean z;
        p06 p06Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, o06Var) == null) {
            List<String> list = null;
            int i = -1;
            if (o06Var != null) {
                if (o06Var.a && (p06Var = o06Var.c) != null) {
                    list = p06Var.a;
                    i = p06Var.c;
                    str = p06Var.d;
                } else {
                    str = o06Var.b;
                }
            } else {
                str = "";
            }
            t06 t06Var = this.d;
            if (t06Var != null) {
                t06Var.b();
            }
            Activity pageActivity = this.c.getPageActivity();
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            j(pageActivity, z, str);
            j06 j06Var = this.b;
            if (j06Var != null && j06Var.b() != null && this.b.b().g() != null) {
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
