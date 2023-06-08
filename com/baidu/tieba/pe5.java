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
public class pe5 {
    public static /* synthetic */ Interceptable $ic;
    public static pe5 c;
    public transient /* synthetic */ FieldHolder $fh;
    public ke5 a;
    public String b;

    public pe5() {
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

    public static pe5 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (pe5.class) {
                    if (c == null) {
                        c = new pe5();
                    }
                }
            }
            return c;
        }
        return (pe5) invokeV.objValue;
    }

    public final ke5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, ke5.class);
            if (runTask != null) {
                return (ke5) runTask.getData();
            }
            return null;
        }
        return (ke5) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ke5 ke5Var = this.a;
            if (ke5Var != null) {
                return ke5Var.g();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ke5 ke5Var = this.a;
            if (ke5Var != null) {
                return ke5Var.b();
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
            ke5 ke5Var = this.a;
            if (ke5Var != null) {
                return ke5Var.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        ke5 ke5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (ke5Var = this.a) != null) {
            ke5Var.c();
        }
    }

    public void a(int i, TbPageContext tbPageContext, ViewGroup viewGroup, boolean z) {
        ke5 ke5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), tbPageContext, viewGroup, Boolean.valueOf(z)}) == null) && (ke5Var = this.a) != null) {
            ke5Var.f(i, tbPageContext, viewGroup, z);
        }
    }

    public void h(boolean z, int i, int i2) {
        ke5 ke5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) && (ke5Var = this.a) != null) {
            ke5Var.i(z, i, i2);
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
            ke5 ke5Var = this.a;
            if (ke5Var != null) {
                return ke5Var.e(activity, viewGroup);
            }
            return null;
        }
        return (NavigationBarCoverTip) invokeLL.objValue;
    }

    public void m(boolean z, long j) {
        ke5 ke5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) && (ke5Var = this.a) != null) {
            ke5Var.h(z, j);
        }
    }

    public Dialog k(int i, TbPageContext tbPageContext, j26 j26Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), tbPageContext, j26Var, Boolean.valueOf(z)})) == null) {
            ke5 ke5Var = this.a;
            if (ke5Var != null) {
                return ke5Var.d(i, tbPageContext, j26Var, z);
            }
            return null;
        }
        return (Dialog) invokeCommon.objValue;
    }
}
