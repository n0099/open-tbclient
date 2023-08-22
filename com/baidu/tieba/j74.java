package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.nk3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j74 extends le2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.le2
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947836194, "Lcom/baidu/tieba/j74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947836194, "Lcom/baidu/tieba/j74;");
                return;
            }
        }
        k = nr1.a;
    }

    @Override // com.baidu.tieba.le2
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.le2
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ve2.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.le2
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return ve2.e();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j74(wp3<Exception> wp3Var) {
        super(wp3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wp3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wp3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.le2
    public wm3 b0(yj4 yj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, yj4Var)) == null) {
            if (yj4Var == null) {
                wm3 wm3Var = new wm3();
                wm3Var.k(14L);
                wm3Var.b(2908L);
                wm3Var.d("小游戏Extension包 Extension null");
                return wm3Var;
            }
            jm2 jm2Var = new jm2();
            jm2Var.b = yj4Var.i;
            jm2Var.a = yj4Var.j;
            jm2Var.c = yj4Var.a;
            jm2Var.d = yj4Var.m;
            boolean z = true;
            if (ml2.b(1, jm2Var) != null) {
                z = false;
            }
            if (z) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            wm3 wm3Var2 = new wm3();
            wm3Var2.k(14L);
            wm3Var2.b(2908L);
            wm3Var2.d("小游戏Extension包更新失败");
            return wm3Var2;
        }
        return (wm3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.le2
    public wm3 c0(ak4 ak4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ak4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + ak4Var);
            }
            if (ak4Var == null) {
                wm3 wm3Var = new wm3();
                wm3Var.k(13L);
                wm3Var.b(2907L);
                wm3Var.d("小游戏GameCore包 Framework null");
                return wm3Var;
            }
            nk3.b c = nk3.c(ak4Var, 1);
            hr4.k(ak4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = nk3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            wm3 wm3Var2 = new wm3();
            wm3Var2.k(13L);
            wm3Var2.b(2907L);
            wm3Var2.d("小游戏GameCore包更新失败");
            return wm3Var2;
        }
        return (wm3) invokeL.objValue;
    }
}
