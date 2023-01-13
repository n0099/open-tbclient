package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.td3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class p04 extends r72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.r72
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948008213, "Lcom/baidu/tieba/p04;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948008213, "Lcom/baidu/tieba/p04;");
                return;
            }
        }
        k = tk1.a;
    }

    @Override // com.baidu.tieba.r72
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r72
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return b82.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r72
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return b82.e();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p04(cj3<Exception> cj3Var) {
        super(cj3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cj3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((cj3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.r72
    public cg3 b0(ed4 ed4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ed4Var)) == null) {
            if (ed4Var == null) {
                cg3 cg3Var = new cg3();
                cg3Var.k(14L);
                cg3Var.b(2908L);
                cg3Var.d("小游戏Extension包 Extension null");
                return cg3Var;
            }
            pf2 pf2Var = new pf2();
            pf2Var.b = ed4Var.i;
            pf2Var.a = ed4Var.j;
            pf2Var.c = ed4Var.a;
            pf2Var.d = ed4Var.m;
            boolean z = true;
            if (se2.b(1, pf2Var) != null) {
                z = false;
            }
            if (z) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            cg3 cg3Var2 = new cg3();
            cg3Var2.k(14L);
            cg3Var2.b(2908L);
            cg3Var2.d("小游戏Extension包更新失败");
            return cg3Var2;
        }
        return (cg3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.r72
    public cg3 c0(gd4 gd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gd4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + gd4Var);
            }
            if (gd4Var == null) {
                cg3 cg3Var = new cg3();
                cg3Var.k(13L);
                cg3Var.b(2907L);
                cg3Var.d("小游戏GameCore包 Framework null");
                return cg3Var;
            }
            td3.b c = td3.c(gd4Var, 1);
            nk4.k(gd4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = td3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            cg3 cg3Var2 = new cg3();
            cg3Var2.k(13L);
            cg3Var2.b(2907L);
            cg3Var2.d("小游戏GameCore包更新失败");
            return cg3Var2;
        }
        return (cg3) invokeL.objValue;
    }
}
