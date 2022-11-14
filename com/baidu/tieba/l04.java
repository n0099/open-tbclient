package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.pd3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class l04 extends n72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.n72
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947889049, "Lcom/baidu/tieba/l04;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947889049, "Lcom/baidu/tieba/l04;");
                return;
            }
        }
        k = pk1.a;
    }

    @Override // com.baidu.tieba.n72
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.n72
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return x72.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.n72
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return x72.e();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l04(yi3<Exception> yi3Var) {
        super(yi3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yi3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((yi3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.n72
    public yf3 b0(ad4 ad4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ad4Var)) == null) {
            if (ad4Var == null) {
                yf3 yf3Var = new yf3();
                yf3Var.k(14L);
                yf3Var.b(2908L);
                yf3Var.d("小游戏Extension包 Extension null");
                return yf3Var;
            }
            lf2 lf2Var = new lf2();
            lf2Var.b = ad4Var.i;
            lf2Var.a = ad4Var.j;
            lf2Var.c = ad4Var.a;
            lf2Var.d = ad4Var.m;
            boolean z = true;
            if (oe2.b(1, lf2Var) != null) {
                z = false;
            }
            if (z) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            yf3 yf3Var2 = new yf3();
            yf3Var2.k(14L);
            yf3Var2.b(2908L);
            yf3Var2.d("小游戏Extension包更新失败");
            return yf3Var2;
        }
        return (yf3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.n72
    public yf3 c0(cd4 cd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cd4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + cd4Var);
            }
            if (cd4Var == null) {
                yf3 yf3Var = new yf3();
                yf3Var.k(13L);
                yf3Var.b(2907L);
                yf3Var.d("小游戏GameCore包 Framework null");
                return yf3Var;
            }
            pd3.b c = pd3.c(cd4Var, 1);
            jk4.k(cd4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = pd3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            yf3 yf3Var2 = new yf3();
            yf3Var2.k(13L);
            yf3Var2.b(2907L);
            yf3Var2.d("小游戏GameCore包更新失败");
            return yf3Var2;
        }
        return (yf3) invokeL.objValue;
    }
}
