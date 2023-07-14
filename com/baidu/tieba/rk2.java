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
public class rk2 extends ProviderDelegation {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948124432, "Lcom/baidu/tieba/rk2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948124432, "Lcom/baidu/tieba/rk2;");
                return;
            }
        }
        cv2.g0().getSwitch("swan_recovery_enable", true);
        a = true;
    }

    public rk2() {
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

    public static void c(bl2 bl2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, bl2Var) != null) || !a || bl2Var == null) {
            return;
        }
        if (ProcessUtils.isMainProcess()) {
            sk2.a(bl2Var).b();
            al2.b().a(bl2Var.a);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("recovery_level", bl2Var.a);
        bundle.putStringArrayList("recovery_app_list", bl2Var.b);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), rk2.class, bundle);
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
            bl2 bl2Var = new bl2();
            bl2Var.a = i;
            if (stringArrayList != null) {
                bl2Var.b = stringArrayList;
            }
            sk2.a(bl2Var).b();
            al2.b().a(bl2Var.a);
            return null;
        }
        return (Bundle) invokeL.objValue;
    }
}
