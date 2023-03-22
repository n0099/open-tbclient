package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.tieba.qr1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class tp1 implements qr1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Boolean a;

    @Override // com.baidu.tieba.qr1
    public void c(ho1 ho1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ho1Var) == null) {
        }
    }

    @Override // com.baidu.tieba.qr1
    public void j(fo1 fo1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fo1Var) == null) {
        }
    }

    public tp1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.qr1
    public void a(qr1.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && aVar != null) {
            aVar.onFinish();
        }
    }

    @Override // com.baidu.tieba.qr1
    public String d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            return ev1.a.a();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qr1
    public boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            boolean g = SwanAppAllianceLoginHelper.d.g();
            this.a = Boolean.TRUE;
            return g;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.qr1
    public String f(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            return fo4.b(context).a();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qr1
    public void g(qr1.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) && cVar != null) {
            cVar.b();
        }
    }

    @Override // com.baidu.tieba.qr1
    public String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            return hv1.b.a();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qr1
    public String i(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            return fo4.b(context).a();
        }
        return (String) invokeL.objValue;
    }

    public boolean k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) {
            if (this.a == null) {
                e(context);
            }
            Boolean bool = this.a;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.qr1
    public void b(Activity activity, Bundle bundle, fo1 fo1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bundle, fo1Var) == null) {
            SwanAppAllianceLoginHelper.d.i(fo1Var);
        }
    }
}
