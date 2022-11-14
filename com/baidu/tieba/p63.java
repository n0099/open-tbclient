package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.j43;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class p63 extends n43 implements yi3<j43.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public boolean c;

    public abstract void I(String str);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p63(i43 i43Var) {
        super(i43Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i43Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((i43) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = false;
    }

    public static void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            q03 Q = r03.Q("swan_kill_to_client");
            Q.J(str);
            Q.call();
        }
    }

    public static void L(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, str, i) == null) {
            if (SwanAppProcessInfo.SERVICE.equals(SwanAppProcessInfo.current())) {
                p63 B = e43.K().B();
                B.b = i;
                B.I(str);
                return;
            }
            q03 w = r03.Q("swan_forbidden_kill_on_server").z("mAppId", str).w("ipc_forbidden_flag", i);
            w.K(true);
            w.call();
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.c) {
            c43 c43Var = new c43();
            c43Var.f(this, "event_messenger_call");
            u(c43Var);
            this.c = true;
        }
    }
}
