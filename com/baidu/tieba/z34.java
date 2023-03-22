package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.dh3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class z34 extends bb2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.bb2
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948309006, "Lcom/baidu/tieba/z34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948309006, "Lcom/baidu/tieba/z34;");
                return;
            }
        }
        k = do1.a;
    }

    @Override // com.baidu.tieba.bb2
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bb2
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return lb2.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bb2
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return lb2.e();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z34(mm3<Exception> mm3Var) {
        super(mm3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mm3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mm3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.bb2
    public mj3 b0(og4 og4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, og4Var)) == null) {
            if (og4Var == null) {
                mj3 mj3Var = new mj3();
                mj3Var.k(14L);
                mj3Var.b(2908L);
                mj3Var.d("小游戏Extension包 Extension null");
                return mj3Var;
            }
            zi2 zi2Var = new zi2();
            zi2Var.b = og4Var.i;
            zi2Var.a = og4Var.j;
            zi2Var.c = og4Var.a;
            zi2Var.d = og4Var.m;
            boolean z = true;
            if (ci2.b(1, zi2Var) != null) {
                z = false;
            }
            if (z) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            mj3 mj3Var2 = new mj3();
            mj3Var2.k(14L);
            mj3Var2.b(2908L);
            mj3Var2.d("小游戏Extension包更新失败");
            return mj3Var2;
        }
        return (mj3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bb2
    public mj3 c0(qg4 qg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, qg4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + qg4Var);
            }
            if (qg4Var == null) {
                mj3 mj3Var = new mj3();
                mj3Var.k(13L);
                mj3Var.b(2907L);
                mj3Var.d("小游戏GameCore包 Framework null");
                return mj3Var;
            }
            dh3.b c = dh3.c(qg4Var, 1);
            xn4.k(qg4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = dh3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            mj3 mj3Var2 = new mj3();
            mj3Var2.k(13L);
            mj3Var2.b(2907L);
            mj3Var2.d("小游戏GameCore包更新失败");
            return mj3Var2;
        }
        return (mj3) invokeL.objValue;
    }
}
