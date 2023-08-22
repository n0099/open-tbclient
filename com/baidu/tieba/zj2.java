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
/* loaded from: classes9.dex */
public class zj2 extends ProviderDelegation {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948361799, "Lcom/baidu/tieba/zj2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948361799, "Lcom/baidu/tieba/zj2;");
                return;
            }
        }
        ku2.g0().getSwitch("swan_recovery_enable", true);
        a = true;
    }

    public zj2() {
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

    public static void c(jk2 jk2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, jk2Var) != null) || !a || jk2Var == null) {
            return;
        }
        if (ProcessUtils.isMainProcess()) {
            ak2.a(jk2Var).b();
            ik2.b().a(jk2Var.a);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("recovery_level", jk2Var.a);
        bundle.putStringArrayList("recovery_app_list", jk2Var.b);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), zj2.class, bundle);
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
            jk2 jk2Var = new jk2();
            jk2Var.a = i;
            if (stringArrayList != null) {
                jk2Var.b = stringArrayList;
            }
            ak2.a(jk2Var).b();
            ik2.b().a(jk2Var.a);
            return null;
        }
        return (Bundle) invokeL.objValue;
    }
}
