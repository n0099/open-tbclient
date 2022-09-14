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
/* loaded from: classes6.dex */
public class z15 {
    public static /* synthetic */ Interceptable $ic;
    public static z15 c;
    public transient /* synthetic */ FieldHolder $fh;
    public u15 a;
    public String b;

    public z15() {
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

    public static z15 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (z15.class) {
                    if (c == null) {
                        c = new z15();
                    }
                }
            }
            return c;
        }
        return (z15) invokeV.objValue;
    }

    public void a(int i, TbPageContext tbPageContext, ViewGroup viewGroup, boolean z) {
        u15 u15Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), tbPageContext, viewGroup, Boolean.valueOf(z)}) == null) || (u15Var = this.a) == null) {
            return;
        }
        u15Var.f(i, tbPageContext, viewGroup, z);
    }

    public final u15 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, u15.class);
            if (runTask != null) {
                return (u15) runTask.getData();
            }
            return null;
        }
        return (u15) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            u15 u15Var = this.a;
            if (u15Var != null) {
                return u15Var.g();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            u15 u15Var = this.a;
            if (u15Var != null) {
                return u15Var.b();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            u15 u15Var = this.a;
            if (u15Var != null) {
                return u15Var.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h(boolean z, int i, int i2) {
        u15 u15Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) || (u15Var = this.a) == null) {
            return;
        }
        u15Var.i(z, i, i2);
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
            u15 u15Var = this.a;
            if (u15Var != null) {
                return u15Var.e(activity, viewGroup);
            }
            return null;
        }
        return (NavigationBarCoverTip) invokeLL.objValue;
    }

    public Dialog k(int i, TbPageContext tbPageContext, nl5 nl5Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), tbPageContext, nl5Var, Boolean.valueOf(z)})) == null) {
            u15 u15Var = this.a;
            if (u15Var != null) {
                return u15Var.d(i, tbPageContext, nl5Var, z);
            }
            return null;
        }
        return (Dialog) invokeCommon.objValue;
    }

    public void l() {
        u15 u15Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (u15Var = this.a) == null) {
            return;
        }
        u15Var.c();
    }

    public void m(boolean z, long j) {
        u15 u15Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) || (u15Var = this.a) == null) {
            return;
        }
        u15Var.h(z, j);
    }
}
