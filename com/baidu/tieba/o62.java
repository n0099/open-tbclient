package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.vc3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class o62 extends t62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947984126, "Lcom/baidu/tieba/o62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947984126, "Lcom/baidu/tieba/o62;");
                return;
            }
        }
        l = vj1.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o62(ei3<Exception> ei3Var) {
        this(ei3Var, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ei3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ei3) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.gb4
    public Map<String, String> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Map<String, String> B = super.B();
            if (this.k && rf4.a) {
                if (B == null) {
                    B = new HashMap<>();
                }
                B.put("hb_type", "1");
                B.put("lastsynctime", String.valueOf(rf4.c));
                B.put("SWAN-TIMEOUT-SETTING", String.valueOf(rf4.b(60) * 1000));
            }
            return B;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t62
    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.t62
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PMSDownloadType.SWAN_APP_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t62
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d72.d() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t62
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? d72.h() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t62
    public ef3 b0(gc4 gc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gc4Var)) == null) {
            if (gc4Var == null) {
                ef3 ef3Var = new ef3();
                ef3Var.k(14L);
                ef3Var.b(2908L);
                ef3Var.d("小程序Extension包 Extension null");
                return ef3Var;
            }
            re2 re2Var = new re2();
            re2Var.b = gc4Var.i;
            re2Var.a = gc4Var.j;
            re2Var.c = gc4Var.a;
            re2Var.d = gc4Var.m;
            if (ud2.b(0, re2Var) == null) {
                if (l) {
                    Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
                }
                boolean m = sm2.g0().m();
                if (l) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + m);
                }
                if (m) {
                    if (l) {
                        Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                    }
                    xd2 f = ud2.f(0);
                    if (f == null) {
                        return null;
                    }
                    long g = f.f().g();
                    if (g > 0) {
                        if (l) {
                            Log.d("SwanAppUpdateCore", "发送extension core更新事件");
                        }
                        SwanAppMessengerService.sendMessageWithDataToAllClient(121, g);
                    }
                }
                return null;
            }
            ef3 ef3Var2 = new ef3();
            ef3Var2.k(14L);
            ef3Var2.b(2908L);
            ef3Var2.d("小程序Extension包更新失败");
            return ef3Var2;
        }
        return (ef3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.t62
    public ef3 c0(ic4 ic4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ic4Var)) == null) {
            if (l) {
                Log.d("SwanAppUpdateCore", "onFrameworkDownloadFinish framework = " + ic4Var);
            }
            if (ic4Var == null) {
                ef3 ef3Var = new ef3();
                ef3Var.k(13L);
                ef3Var.b(2907L);
                ef3Var.d("小程序Core包 Framework null");
                return ef3Var;
            }
            vc3.b c = vc3.c(ic4Var, 0);
            l02.k("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c);
            pj4.k(ic4Var.a);
            if (c.c()) {
                long e = vc3.e(0);
                if (e > 0) {
                    SwanJSVersionUpdateEvent.sendEvent(e);
                    SwanAppMessengerService.sendMessageWithDataToAllClient(114, e);
                    return null;
                }
                return null;
            }
            ef3 ef3Var2 = new ef3();
            ef3Var2.k(13L);
            ef3Var2.b(2907L);
            ef3Var2.d("小程序Core包更新失败");
            return ef3Var2;
        }
        return (ef3) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o62(ei3<Exception> ei3Var, boolean z) {
        super(ei3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ei3Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ei3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = z;
    }
}
