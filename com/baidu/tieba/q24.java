package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.uf3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class q24 extends s92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.s92
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948039926, "Lcom/baidu/tieba/q24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948039926, "Lcom/baidu/tieba/q24;");
                return;
            }
        }
        k = vm1.a;
    }

    @Override // com.baidu.tieba.s92
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s92
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ca2.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s92
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return ca2.e();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q24(dl3<Exception> dl3Var) {
        super(dl3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dl3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((dl3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.s92
    public di3 b0(ff4 ff4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ff4Var)) == null) {
            if (ff4Var == null) {
                di3 di3Var = new di3();
                di3Var.k(14L);
                di3Var.b(2908L);
                di3Var.d("小游戏Extension包 Extension null");
                return di3Var;
            }
            qh2 qh2Var = new qh2();
            qh2Var.b = ff4Var.i;
            qh2Var.a = ff4Var.j;
            qh2Var.c = ff4Var.a;
            qh2Var.d = ff4Var.m;
            boolean z = true;
            if (tg2.b(1, qh2Var) != null) {
                z = false;
            }
            if (z) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            di3 di3Var2 = new di3();
            di3Var2.k(14L);
            di3Var2.b(2908L);
            di3Var2.d("小游戏Extension包更新失败");
            return di3Var2;
        }
        return (di3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s92
    public di3 c0(hf4 hf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hf4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + hf4Var);
            }
            if (hf4Var == null) {
                di3 di3Var = new di3();
                di3Var.k(13L);
                di3Var.b(2907L);
                di3Var.d("小游戏GameCore包 Framework null");
                return di3Var;
            }
            uf3.b c = uf3.c(hf4Var, 1);
            nm4.k(hf4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = uf3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            di3 di3Var2 = new di3();
            di3Var2.k(13L);
            di3Var2.b(2907L);
            di3Var2.d("小游戏GameCore包更新失败");
            return di3Var2;
        }
        return (di3) invokeL.objValue;
    }
}
