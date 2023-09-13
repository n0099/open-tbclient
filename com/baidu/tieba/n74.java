package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.rk3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class n74 extends pe2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.pe2
    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947955358, "Lcom/baidu/tieba/n74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947955358, "Lcom/baidu/tieba/n74;");
                return;
            }
        }
        k = rr1.a;
    }

    @Override // com.baidu.tieba.pe2
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pe2
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ze2.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pe2
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return ze2.e();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n74(aq3<Exception> aq3Var) {
        super(aq3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aq3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((aq3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.pe2
    public an3 b0(ck4 ck4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ck4Var)) == null) {
            if (ck4Var == null) {
                an3 an3Var = new an3();
                an3Var.k(14L);
                an3Var.b(2908L);
                an3Var.d("小游戏Extension包 Extension null");
                return an3Var;
            }
            nm2 nm2Var = new nm2();
            nm2Var.b = ck4Var.i;
            nm2Var.a = ck4Var.j;
            nm2Var.c = ck4Var.a;
            nm2Var.d = ck4Var.m;
            boolean z = true;
            if (ql2.b(1, nm2Var) != null) {
                z = false;
            }
            if (z) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            an3 an3Var2 = new an3();
            an3Var2.k(14L);
            an3Var2.b(2908L);
            an3Var2.d("小游戏Extension包更新失败");
            return an3Var2;
        }
        return (an3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.pe2
    public an3 c0(ek4 ek4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ek4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + ek4Var);
            }
            if (ek4Var == null) {
                an3 an3Var = new an3();
                an3Var.k(13L);
                an3Var.b(2907L);
                an3Var.d("小游戏GameCore包 Framework null");
                return an3Var;
            }
            rk3.b c = rk3.c(ek4Var, 1);
            lr4.k(ek4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = rk3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            an3 an3Var2 = new an3();
            an3Var2.k(13L);
            an3Var2.b(2907L);
            an3Var2.d("小游戏GameCore包更新失败");
            return an3Var2;
        }
        return (an3) invokeL.objValue;
    }
}
