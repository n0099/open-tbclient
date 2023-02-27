package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.wi3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class s54 extends uc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.uc2
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948102391, "Lcom/baidu/tieba/s54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948102391, "Lcom/baidu/tieba/s54;");
                return;
            }
        }
        k = wp1.a;
    }

    @Override // com.baidu.tieba.uc2
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uc2
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ed2.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uc2
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return ed2.e();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s54(fo3<Exception> fo3Var) {
        super(fo3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fo3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((fo3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.uc2
    public fl3 b0(hi4 hi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hi4Var)) == null) {
            if (hi4Var == null) {
                fl3 fl3Var = new fl3();
                fl3Var.k(14L);
                fl3Var.b(2908L);
                fl3Var.d("小游戏Extension包 Extension null");
                return fl3Var;
            }
            sk2 sk2Var = new sk2();
            sk2Var.b = hi4Var.i;
            sk2Var.a = hi4Var.j;
            sk2Var.c = hi4Var.a;
            sk2Var.d = hi4Var.m;
            boolean z = true;
            if (vj2.b(1, sk2Var) != null) {
                z = false;
            }
            if (z) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            fl3 fl3Var2 = new fl3();
            fl3Var2.k(14L);
            fl3Var2.b(2908L);
            fl3Var2.d("小游戏Extension包更新失败");
            return fl3Var2;
        }
        return (fl3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.uc2
    public fl3 c0(ji4 ji4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ji4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + ji4Var);
            }
            if (ji4Var == null) {
                fl3 fl3Var = new fl3();
                fl3Var.k(13L);
                fl3Var.b(2907L);
                fl3Var.d("小游戏GameCore包 Framework null");
                return fl3Var;
            }
            wi3.b c = wi3.c(ji4Var, 1);
            qp4.k(ji4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = wi3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            fl3 fl3Var2 = new fl3();
            fl3Var2.k(13L);
            fl3Var2.b(2907L);
            fl3Var2.d("小游戏GameCore包更新失败");
            return fl3Var2;
        }
        return (fl3) invokeL.objValue;
    }
}
