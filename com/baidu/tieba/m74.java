package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.qk3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class m74 extends oe2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.oe2
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947925567, "Lcom/baidu/tieba/m74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947925567, "Lcom/baidu/tieba/m74;");
                return;
            }
        }
        k = qr1.a;
    }

    @Override // com.baidu.tieba.oe2
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oe2
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ye2.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oe2
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return ye2.e();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m74(zp3<Exception> zp3Var) {
        super(zp3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zp3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zp3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.oe2
    public zm3 b0(bk4 bk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bk4Var)) == null) {
            if (bk4Var == null) {
                zm3 zm3Var = new zm3();
                zm3Var.k(14L);
                zm3Var.b(2908L);
                zm3Var.d("小游戏Extension包 Extension null");
                return zm3Var;
            }
            mm2 mm2Var = new mm2();
            mm2Var.b = bk4Var.i;
            mm2Var.a = bk4Var.j;
            mm2Var.c = bk4Var.a;
            mm2Var.d = bk4Var.m;
            boolean z = true;
            if (pl2.b(1, mm2Var) != null) {
                z = false;
            }
            if (z) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            zm3 zm3Var2 = new zm3();
            zm3Var2.k(14L);
            zm3Var2.b(2908L);
            zm3Var2.d("小游戏Extension包更新失败");
            return zm3Var2;
        }
        return (zm3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.oe2
    public zm3 c0(dk4 dk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, dk4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + dk4Var);
            }
            if (dk4Var == null) {
                zm3 zm3Var = new zm3();
                zm3Var.k(13L);
                zm3Var.b(2907L);
                zm3Var.d("小游戏GameCore包 Framework null");
                return zm3Var;
            }
            qk3.b c = qk3.c(dk4Var, 1);
            kr4.k(dk4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = qk3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            zm3 zm3Var2 = new zm3();
            zm3Var2.k(13L);
            zm3Var2.b(2907L);
            zm3Var2.d("小游戏GameCore包更新失败");
            return zm3Var2;
        }
        return (zm3) invokeL.objValue;
    }
}
