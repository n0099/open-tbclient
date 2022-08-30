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
/* loaded from: classes5.dex */
public class sz4 {
    public static /* synthetic */ Interceptable $ic;
    public static sz4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public mz4 a;
    public String b;

    public sz4() {
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

    public static sz4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (sz4.class) {
                    if (c == null) {
                        c = new sz4();
                    }
                }
            }
            return c;
        }
        return (sz4) invokeV.objValue;
    }

    public void a(int i, TbPageContext tbPageContext, ViewGroup viewGroup) {
        mz4 mz4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048576, this, i, tbPageContext, viewGroup) == null) || (mz4Var = this.a) == null) {
            return;
        }
        mz4Var.c(i, tbPageContext, viewGroup);
    }

    public final mz4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, mz4.class);
            if (runTask != null) {
                return (mz4) runTask.getData();
            }
            return null;
        }
        return (mz4) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            mz4 mz4Var = this.a;
            if (mz4Var != null) {
                return mz4Var.f();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            mz4 mz4Var = this.a;
            if (mz4Var != null) {
                return mz4Var.b();
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
            mz4 mz4Var = this.a;
            if (mz4Var != null) {
                return mz4Var.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h(boolean z, int i, int i2) {
        mz4 mz4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) || (mz4Var = this.a) == null) {
            return;
        }
        mz4Var.h(z, i, i2);
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
            mz4 mz4Var = this.a;
            if (mz4Var != null) {
                return mz4Var.e(activity, viewGroup);
            }
            return null;
        }
        return (NavigationBarCoverTip) invokeLL.objValue;
    }

    public Dialog k(int i, TbPageContext tbPageContext, gj5 gj5Var) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, tbPageContext, gj5Var)) == null) {
            mz4 mz4Var = this.a;
            if (mz4Var != null) {
                return mz4Var.i(i, tbPageContext, gj5Var);
            }
            return null;
        }
        return (Dialog) invokeILL.objValue;
    }

    public void l() {
        mz4 mz4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (mz4Var = this.a) == null) {
            return;
        }
        mz4Var.d();
    }

    public void m(boolean z, long j) {
        mz4 mz4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) || (mz4Var = this.a) == null) {
            return;
        }
        mz4Var.g(z, j);
    }
}
