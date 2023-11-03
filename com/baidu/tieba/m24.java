package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.qf3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class m24 extends o92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.o92
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947920762, "Lcom/baidu/tieba/m24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947920762, "Lcom/baidu/tieba/m24;");
                return;
            }
        }
        k = rm1.a;
    }

    @Override // com.baidu.tieba.o92
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o92
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return y92.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o92
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return y92.e();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m24(zk3<Exception> zk3Var) {
        super(zk3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zk3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zk3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.o92
    public zh3 b0(bf4 bf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bf4Var)) == null) {
            if (bf4Var == null) {
                zh3 zh3Var = new zh3();
                zh3Var.k(14L);
                zh3Var.b(2908L);
                zh3Var.d("小游戏Extension包 Extension null");
                return zh3Var;
            }
            mh2 mh2Var = new mh2();
            mh2Var.b = bf4Var.i;
            mh2Var.a = bf4Var.j;
            mh2Var.c = bf4Var.a;
            mh2Var.d = bf4Var.m;
            boolean z = true;
            if (pg2.b(1, mh2Var) != null) {
                z = false;
            }
            if (z) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            zh3 zh3Var2 = new zh3();
            zh3Var2.k(14L);
            zh3Var2.b(2908L);
            zh3Var2.d("小游戏Extension包更新失败");
            return zh3Var2;
        }
        return (zh3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.o92
    public zh3 c0(df4 df4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, df4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + df4Var);
            }
            if (df4Var == null) {
                zh3 zh3Var = new zh3();
                zh3Var.k(13L);
                zh3Var.b(2907L);
                zh3Var.d("小游戏GameCore包 Framework null");
                return zh3Var;
            }
            qf3.b c = qf3.c(df4Var, 1);
            jm4.k(df4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = qf3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            zh3 zh3Var2 = new zh3();
            zh3Var2.k(13L);
            zh3Var2.b(2907L);
            zh3Var2.d("小游戏GameCore包更新失败");
            return zh3Var2;
        }
        return (zh3) invokeL.objValue;
    }
}
