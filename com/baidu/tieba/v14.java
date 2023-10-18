package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.ze3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class v14 extends x82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.x82
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948187920, "Lcom/baidu/tieba/v14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948187920, "Lcom/baidu/tieba/v14;");
                return;
            }
        }
        k = am1.a;
    }

    @Override // com.baidu.tieba.x82
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.x82
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return h92.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.x82
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return h92.e();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v14(ik3<Exception> ik3Var) {
        super(ik3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ik3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ik3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.x82
    public ih3 b0(ke4 ke4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ke4Var)) == null) {
            if (ke4Var == null) {
                ih3 ih3Var = new ih3();
                ih3Var.k(14L);
                ih3Var.b(2908L);
                ih3Var.d("小游戏Extension包 Extension null");
                return ih3Var;
            }
            vg2 vg2Var = new vg2();
            vg2Var.b = ke4Var.i;
            vg2Var.a = ke4Var.j;
            vg2Var.c = ke4Var.a;
            vg2Var.d = ke4Var.m;
            boolean z = true;
            if (yf2.b(1, vg2Var) != null) {
                z = false;
            }
            if (z) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            ih3 ih3Var2 = new ih3();
            ih3Var2.k(14L);
            ih3Var2.b(2908L);
            ih3Var2.d("小游戏Extension包更新失败");
            return ih3Var2;
        }
        return (ih3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.x82
    public ih3 c0(me4 me4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, me4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + me4Var);
            }
            if (me4Var == null) {
                ih3 ih3Var = new ih3();
                ih3Var.k(13L);
                ih3Var.b(2907L);
                ih3Var.d("小游戏GameCore包 Framework null");
                return ih3Var;
            }
            ze3.b c = ze3.c(me4Var, 1);
            sl4.k(me4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = ze3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            ih3 ih3Var2 = new ih3();
            ih3Var2.k(13L);
            ih3Var2.b(2907L);
            ih3Var2.d("小游戏GameCore包更新失败");
            return ih3Var2;
        }
        return (ih3) invokeL.objValue;
    }
}
