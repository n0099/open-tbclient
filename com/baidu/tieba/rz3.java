package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.vc3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class rz3 extends t62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948138878, "Lcom/baidu/tieba/rz3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948138878, "Lcom/baidu/tieba/rz3;");
                return;
            }
        }
        k = vj1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rz3(ei3<Exception> ei3Var) {
        super(ei3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ei3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ei3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.t62
    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.t62
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? PMSDownloadType.SWAN_GAME_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t62
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d72.f() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t62
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d72.e() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t62
    public ef3 b0(gc4 gc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gc4Var)) == null) {
            if (gc4Var == null) {
                ef3 ef3Var = new ef3();
                ef3Var.k(14L);
                ef3Var.b(2908L);
                ef3Var.d("小游戏Extension包 Extension null");
                return ef3Var;
            }
            re2 re2Var = new re2();
            re2Var.b = gc4Var.i;
            re2Var.a = gc4Var.j;
            re2Var.c = gc4Var.a;
            re2Var.d = gc4Var.m;
            if (ud2.b(1, re2Var) == null) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            ef3 ef3Var2 = new ef3();
            ef3Var2.k(14L);
            ef3Var2.b(2908L);
            ef3Var2.d("小游戏Extension包更新失败");
            return ef3Var2;
        }
        return (ef3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.t62
    public ef3 c0(ic4 ic4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ic4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + ic4Var);
            }
            if (ic4Var == null) {
                ef3 ef3Var = new ef3();
                ef3Var.k(13L);
                ef3Var.b(2907L);
                ef3Var.d("小游戏GameCore包 Framework null");
                return ef3Var;
            }
            vc3.b c = vc3.c(ic4Var, 1);
            pj4.k(ic4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = vc3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            ef3 ef3Var2 = new ef3();
            ef3Var2.k(13L);
            ef3Var2.b(2907L);
            ef3Var2.d("小游戏GameCore包更新失败");
            return ef3Var2;
        }
        return (ef3) invokeL.objValue;
    }
}
