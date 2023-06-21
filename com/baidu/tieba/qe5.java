package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qe5 {
    public static /* synthetic */ Interceptable $ic;
    public static qe5 c;
    public transient /* synthetic */ FieldHolder $fh;
    public le5 a;
    public String b;

    public qe5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = b();
    }

    public static qe5 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (qe5.class) {
                    if (c == null) {
                        c = new qe5();
                    }
                }
            }
            return c;
        }
        return (qe5) invokeV.objValue;
    }

    public final le5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, le5.class);
            if (runTask != null) {
                return (le5) runTask.getData();
            }
            return null;
        }
        return (le5) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            le5 le5Var = this.a;
            if (le5Var != null) {
                return le5Var.g();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            le5 le5Var = this.a;
            if (le5Var != null) {
                return le5Var.b();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            le5 le5Var = this.a;
            if (le5Var != null) {
                return le5Var.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        le5 le5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (le5Var = this.a) != null) {
            le5Var.c();
        }
    }

    public void a(int i, TbPageContext tbPageContext, ViewGroup viewGroup, boolean z) {
        le5 le5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), tbPageContext, viewGroup, Boolean.valueOf(z)}) == null) && (le5Var = this.a) != null) {
            le5Var.f(i, tbPageContext, viewGroup, z);
        }
    }

    public void h(boolean z, int i, int i2) {
        le5 le5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) && (le5Var = this.a) != null) {
            le5Var.i(z, i, i2);
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.b = str;
        }
    }

    public NavigationBarCoverTip j(Activity activity, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, viewGroup)) == null) {
            le5 le5Var = this.a;
            if (le5Var != null) {
                return le5Var.e(activity, viewGroup);
            }
            return null;
        }
        return (NavigationBarCoverTip) invokeLL.objValue;
    }

    public void m(boolean z, long j) {
        le5 le5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) && (le5Var = this.a) != null) {
            le5Var.h(z, j);
        }
    }

    public Dialog k(int i, TbPageContext tbPageContext, o26 o26Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), tbPageContext, o26Var, Boolean.valueOf(z)})) == null) {
            le5 le5Var = this.a;
            if (le5Var != null) {
                return le5Var.d(i, tbPageContext, o26Var, z);
            }
            return null;
        }
        return (Dialog) invokeCommon.objValue;
    }
}
