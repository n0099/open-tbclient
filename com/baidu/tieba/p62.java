package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.wc3;
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
public class p62 extends u62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean k;

    @Override // com.baidu.tieba.u62
    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948013917, "Lcom/baidu/tieba/p62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948013917, "Lcom/baidu/tieba/p62;");
                return;
            }
        }
        l = wj1.a;
    }

    @Override // com.baidu.tieba.u62
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return PMSDownloadType.SWAN_APP_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u62
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return e72.d();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u62
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return e72.h();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p62(fi3 fi3Var) {
        this(fi3Var, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fi3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((fi3) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p62(fi3 fi3Var, boolean z) {
        super(fi3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fi3Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((fi3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = z;
    }

    @Override // com.baidu.tieba.hb4
    public Map B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Map B = super.B();
            if (this.k && sf4.a) {
                if (B == null) {
                    B = new HashMap();
                }
                B.put("hb_type", "1");
                B.put("lastsynctime", String.valueOf(sf4.c));
                B.put("SWAN-TIMEOUT-SETTING", String.valueOf(sf4.b(60) * 1000));
            }
            return B;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u62
    public ff3 b0(hc4 hc4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hc4Var)) == null) {
            if (hc4Var == null) {
                ff3 ff3Var = new ff3();
                ff3Var.k(14L);
                ff3Var.b(2908L);
                ff3Var.d("小程序Extension包 Extension null");
                return ff3Var;
            }
            se2 se2Var = new se2();
            se2Var.b = hc4Var.i;
            se2Var.a = hc4Var.j;
            se2Var.c = hc4Var.a;
            se2Var.d = hc4Var.m;
            if (vd2.b(0, se2Var) == null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (l) {
                    Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
                }
                boolean m = tm2.g0().m();
                if (l) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + m);
                }
                if (m) {
                    if (l) {
                        Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                    }
                    yd2 f = vd2.f(0);
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
            ff3 ff3Var2 = new ff3();
            ff3Var2.k(14L);
            ff3Var2.b(2908L);
            ff3Var2.d("小程序Extension包更新失败");
            return ff3Var2;
        }
        return (ff3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.u62
    public ff3 c0(jc4 jc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jc4Var)) == null) {
            if (l) {
                Log.d("SwanAppUpdateCore", "onFrameworkDownloadFinish framework = " + jc4Var);
            }
            if (jc4Var == null) {
                ff3 ff3Var = new ff3();
                ff3Var.k(13L);
                ff3Var.b(2907L);
                ff3Var.d("小程序Core包 Framework null");
                return ff3Var;
            }
            wc3.b c = wc3.c(jc4Var, 0);
            m02.k("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c);
            qj4.k(jc4Var.a);
            if (c.c()) {
                long e = wc3.e(0);
                if (e > 0) {
                    SwanJSVersionUpdateEvent.sendEvent(e);
                    SwanAppMessengerService.sendMessageWithDataToAllClient(114, e);
                    return null;
                }
                return null;
            }
            ff3 ff3Var2 = new ff3();
            ff3Var2.k(13L);
            ff3Var2.b(2907L);
            ff3Var2.d("小程序Core包更新失败");
            return ff3Var2;
        }
        return (ff3) invokeL.objValue;
    }
}
