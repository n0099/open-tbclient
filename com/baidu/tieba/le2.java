package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class le2 extends ProviderDelegation {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947939920, "Lcom/baidu/tieba/le2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947939920, "Lcom/baidu/tieba/le2;");
                return;
            }
        }
        wo2.g0().getSwitch("swan_recovery_enable", true);
        a = true;
    }

    public le2() {
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

    public static void c(ve2 ve2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, ve2Var) != null) || !a || ve2Var == null) {
            return;
        }
        if (ProcessUtils.isMainProcess()) {
            me2.a(ve2Var).b();
            ue2.b().a(ve2Var.a);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("recovery_level", ve2Var.a);
        bundle.putStringArrayList("recovery_app_list", ve2Var.b);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), le2.class, bundle);
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            if (!a) {
                return null;
            }
            int i = bundle.getInt("recovery_level", -1);
            ArrayList<String> stringArrayList = bundle.getStringArrayList("recovery_app_list");
            ve2 ve2Var = new ve2();
            ve2Var.a = i;
            if (stringArrayList != null) {
                ve2Var.b = stringArrayList;
            }
            me2.a(ve2Var).b();
            ue2.b().a(ve2Var.a);
            return null;
        }
        return (Bundle) invokeL.objValue;
    }
}
