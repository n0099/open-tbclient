package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.qi3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class m54 extends oc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.oc2
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947923645, "Lcom/baidu/tieba/m54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947923645, "Lcom/baidu/tieba/m54;");
                return;
            }
        }
        k = qp1.a;
    }

    @Override // com.baidu.tieba.oc2
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oc2
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return yc2.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oc2
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return yc2.e();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m54(zn3<Exception> zn3Var) {
        super(zn3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zn3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zn3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.oc2
    public zk3 b0(bi4 bi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bi4Var)) == null) {
            if (bi4Var == null) {
                zk3 zk3Var = new zk3();
                zk3Var.k(14L);
                zk3Var.b(2908L);
                zk3Var.d("小游戏Extension包 Extension null");
                return zk3Var;
            }
            mk2 mk2Var = new mk2();
            mk2Var.b = bi4Var.i;
            mk2Var.a = bi4Var.j;
            mk2Var.c = bi4Var.a;
            mk2Var.d = bi4Var.m;
            boolean z = true;
            if (pj2.b(1, mk2Var) != null) {
                z = false;
            }
            if (z) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            zk3 zk3Var2 = new zk3();
            zk3Var2.k(14L);
            zk3Var2.b(2908L);
            zk3Var2.d("小游戏Extension包更新失败");
            return zk3Var2;
        }
        return (zk3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.oc2
    public zk3 c0(di4 di4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, di4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + di4Var);
            }
            if (di4Var == null) {
                zk3 zk3Var = new zk3();
                zk3Var.k(13L);
                zk3Var.b(2907L);
                zk3Var.d("小游戏GameCore包 Framework null");
                return zk3Var;
            }
            qi3.b c = qi3.c(di4Var, 1);
            kp4.k(di4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = qi3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            zk3 zk3Var2 = new zk3();
            zk3Var2.k(13L);
            zk3Var2.b(2907L);
            zk3Var2.d("小游戏GameCore包更新失败");
            return zk3Var2;
        }
        return (zk3) invokeL.objValue;
    }
}
