package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class vi0 implements ap0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<xo0> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948241612, "Lcom/baidu/tieba/vi0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948241612, "Lcom/baidu/tieba/vi0;");
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add(new ii0());
        a.add(new fo0());
        a.add(new ui0());
        yi0 yi0Var = new yi0();
        gl1<xo0> gl1Var = yi0Var.a;
        if (gl1Var != null && !x21.g(gl1Var.getList())) {
            a.addAll(yi0Var.a.getList());
        }
    }

    public vi0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !a.isEmpty();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ap0
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bundle) != null) || !e()) {
            return;
        }
        for (xo0 xo0Var : a) {
            xo0Var.onActivityCreated(activity, bundle);
        }
    }

    @Override // com.baidu.tieba.ap0
    public void onActivitySaveInstanceState(@NonNull Activity activity, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, activity, bundle) != null) || !e()) {
            return;
        }
        for (xo0 xo0Var : a) {
            xo0Var.onActivitySaveInstanceState(activity, bundle);
        }
    }

    @Override // com.baidu.tieba.ap0
    public void onActivityDestroyed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) != null) || !e()) {
            return;
        }
        for (xo0 xo0Var : a) {
            xo0Var.onActivityDestroyed(activity);
        }
    }

    @Override // com.baidu.tieba.ap0
    public void onActivityPaused(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, activity) != null) || !e()) {
            return;
        }
        for (xo0 xo0Var : a) {
            xo0Var.onActivityPaused(activity);
        }
    }

    @Override // com.baidu.tieba.ap0
    public void onActivityResumed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, activity) != null) || !e()) {
            return;
        }
        for (xo0 xo0Var : a) {
            xo0Var.onActivityResumed(activity);
        }
    }

    @Override // com.baidu.tieba.ap0
    public void onActivityStarted(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, activity) != null) || !e()) {
            return;
        }
        for (xo0 xo0Var : a) {
            xo0Var.onActivityStarted(activity);
        }
    }

    @Override // com.baidu.tieba.ap0
    public void onActivityStopped(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, activity) != null) || !e()) {
            return;
        }
        for (xo0 xo0Var : a) {
            xo0Var.onActivityStopped(activity);
        }
    }

    @Override // com.baidu.tieba.ap0
    public void onBackgroundToForeground(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) != null) || !e()) {
            return;
        }
        for (xo0 xo0Var : a) {
            xo0Var.onBackgroundToForeground(activity);
        }
    }

    @Override // com.baidu.tieba.ap0
    public void onForegroundToBackground(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, activity) != null) || !e()) {
            return;
        }
        for (xo0 xo0Var : a) {
            xo0Var.onForegroundToBackground(activity);
        }
    }
}
