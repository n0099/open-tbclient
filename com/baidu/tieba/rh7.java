package com.baidu.tieba;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
/* loaded from: classes8.dex */
public final class rh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<KClass<? extends sh7>, ? extends sh7> a;

    public rh7(Map<KClass<? extends sh7>, ? extends sh7> controllerMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {controllerMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(controllerMap, "controllerMap");
        this.a = controllerMap;
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (KClass<? extends sh7> kClass : this.a.keySet()) {
                sh7 sh7Var = this.a.get(kClass);
                if (sh7Var != null) {
                    sh7Var.i(i);
                }
            }
        }
    }

    public void f(Configuration newConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, newConfig) == null) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            for (KClass<? extends sh7> kClass : this.a.keySet()) {
                sh7 sh7Var = this.a.get(kClass);
                if (sh7Var != null) {
                    sh7Var.j(newConfig);
                }
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (KClass<? extends sh7> kClass : this.a.keySet()) {
                sh7 sh7Var = this.a.get(kClass);
                if (sh7Var != null) {
                    sh7Var.e();
                }
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Iterator<KClass<? extends sh7>> it = this.a.keySet().iterator();
            do {
                z = false;
                if (!it.hasNext()) {
                    return false;
                }
                sh7 sh7Var = this.a.get(it.next());
                if (sh7Var != null && sh7Var.h()) {
                    z = true;
                    continue;
                }
            } while (!z);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            for (KClass<? extends sh7> kClass : this.a.keySet()) {
                sh7 sh7Var = this.a.get(kClass);
                if (sh7Var != null) {
                    sh7Var.l();
                }
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (KClass<? extends sh7> kClass : this.a.keySet()) {
                sh7 sh7Var = this.a.get(kClass);
                if (sh7Var != null) {
                    sh7Var.m();
                }
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (KClass<? extends sh7> kClass : this.a.keySet()) {
                sh7 sh7Var = this.a.get(kClass);
                if (sh7Var != null) {
                    sh7Var.n();
                }
            }
        }
    }

    public final <T extends sh7> T b(KClass<T> clazz) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, clazz)) == null) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            sh7 sh7Var = this.a.get(clazz);
            if (sh7Var instanceof sh7) {
                return (T) sh7Var;
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public void c(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            for (KClass<? extends sh7> kClass : this.a.keySet()) {
                sh7 sh7Var = this.a.get(kClass);
                if (sh7Var != null) {
                    sh7Var.g(i, i2, intent);
                }
            }
        }
    }

    public void g(Bundle bundle, ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            for (KClass<? extends sh7> kClass : this.a.keySet()) {
                sh7 sh7Var = this.a.get(kClass);
                if (sh7Var != null) {
                    sh7Var.k(bundle, binding);
                }
            }
        }
    }
}
