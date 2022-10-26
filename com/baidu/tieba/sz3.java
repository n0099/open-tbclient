package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.wc3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class sz3 extends u62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.u62
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948168669, "Lcom/baidu/tieba/sz3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948168669, "Lcom/baidu/tieba/sz3;");
                return;
            }
        }
        k = wj1.a;
    }

    @Override // com.baidu.tieba.u62
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u62
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return e72.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u62
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return e72.e();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sz3(fi3 fi3Var) {
        super(fi3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fi3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((fi3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.u62
    public ff3 b0(hc4 hc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hc4Var)) == null) {
            if (hc4Var == null) {
                ff3 ff3Var = new ff3();
                ff3Var.k(14L);
                ff3Var.b(2908L);
                ff3Var.d("小游戏Extension包 Extension null");
                return ff3Var;
            }
            se2 se2Var = new se2();
            se2Var.b = hc4Var.i;
            se2Var.a = hc4Var.j;
            se2Var.c = hc4Var.a;
            se2Var.d = hc4Var.m;
            boolean z = true;
            if (vd2.b(1, se2Var) != null) {
                z = false;
            }
            if (z) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            ff3 ff3Var2 = new ff3();
            ff3Var2.k(14L);
            ff3Var2.b(2908L);
            ff3Var2.d("小游戏Extension包更新失败");
            return ff3Var2;
        }
        return (ff3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u62
    public ff3 c0(jc4 jc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jc4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + jc4Var);
            }
            if (jc4Var == null) {
                ff3 ff3Var = new ff3();
                ff3Var.k(13L);
                ff3Var.b(2907L);
                ff3Var.d("小游戏GameCore包 Framework null");
                return ff3Var;
            }
            wc3.b c = wc3.c(jc4Var, 1);
            qj4.k(jc4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = wc3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            ff3 ff3Var2 = new ff3();
            ff3Var2.k(13L);
            ff3Var2.b(2907L);
            ff3Var2.d("小游戏GameCore包更新失败");
            return ff3Var2;
        }
        return (ff3) invokeL.objValue;
    }
}
