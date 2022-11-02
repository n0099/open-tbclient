package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.od3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class k04 extends m72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.m72
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947859258, "Lcom/baidu/tieba/k04;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947859258, "Lcom/baidu/tieba/k04;");
                return;
            }
        }
        k = ok1.a;
    }

    @Override // com.baidu.tieba.m72
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m72
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return w72.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m72
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return w72.e();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k04(xi3<Exception> xi3Var) {
        super(xi3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xi3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((xi3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.m72
    public xf3 b0(zc4 zc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, zc4Var)) == null) {
            if (zc4Var == null) {
                xf3 xf3Var = new xf3();
                xf3Var.k(14L);
                xf3Var.b(2908L);
                xf3Var.d("小游戏Extension包 Extension null");
                return xf3Var;
            }
            kf2 kf2Var = new kf2();
            kf2Var.b = zc4Var.i;
            kf2Var.a = zc4Var.j;
            kf2Var.c = zc4Var.a;
            kf2Var.d = zc4Var.m;
            boolean z = true;
            if (ne2.b(1, kf2Var) != null) {
                z = false;
            }
            if (z) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            xf3 xf3Var2 = new xf3();
            xf3Var2.k(14L);
            xf3Var2.b(2908L);
            xf3Var2.d("小游戏Extension包更新失败");
            return xf3Var2;
        }
        return (xf3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.m72
    public xf3 c0(bd4 bd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bd4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + bd4Var);
            }
            if (bd4Var == null) {
                xf3 xf3Var = new xf3();
                xf3Var.k(13L);
                xf3Var.b(2907L);
                xf3Var.d("小游戏GameCore包 Framework null");
                return xf3Var;
            }
            od3.b c = od3.c(bd4Var, 1);
            ik4.k(bd4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = od3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            xf3 xf3Var2 = new xf3();
            xf3Var2.k(13L);
            xf3Var2.b(2907L);
            xf3Var2.d("小游戏GameCore包更新失败");
            return xf3Var2;
        }
        return (xf3) invokeL.objValue;
    }
}
