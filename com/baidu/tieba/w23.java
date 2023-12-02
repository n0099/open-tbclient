package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.o63;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class w23 extends s63 implements u23 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> b;
    public final HashMap<String, v23> c;

    /* loaded from: classes8.dex */
    public class a implements dl3<o63.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w23 a;

        public a(w23 w23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w23Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w23Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(o63.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (w23.d) {
                    w23 w23Var = this.a;
                    w23Var.T("onEventCallback msg" + aVar);
                }
                this.a.V(aVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements dl3<o63.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w23 a;

        public b(w23 w23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w23Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w23Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(o63.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (w23.d) {
                    w23 w23Var = this.a;
                    w23Var.T("onEventCallback msg" + aVar);
                }
                this.a.W(aVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static w23 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-367646030, "Lcom/baidu/tieba/w23$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-367646030, "Lcom/baidu/tieba/w23$c;");
                    return;
                }
            }
            a = new w23(j63.K());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948218641, "Lcom/baidu/tieba/w23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948218641, "Lcom/baidu/tieba/w23;");
                return;
            }
        }
        d = vm1.a;
    }

    public static w23 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return c.a;
        }
        return (w23) invokeV.objValue;
    }

    public static void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            R();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w23(n63 n63Var) {
        super(n63Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n63Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((n63) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new HashMap<>();
        this.c = new HashMap<>();
        if (d) {
            T("SwanIpc");
        }
        h63 h63Var = new h63();
        h63Var.f(new b(this), "event_messenger_call_out");
        h63Var.f(new a(this), "event_messenger_call_in");
        u(h63Var);
    }

    public static synchronized boolean J(@NonNull Bundle bundle, @NonNull String str) {
        InterceptResult invokeLL;
        boolean L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bundle, str)) == null) {
            synchronized (w23.class) {
                L = R().L(Z(bundle), str);
            }
            return L;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized boolean K(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        boolean L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            synchronized (w23.class) {
                L = R().L(a0(str), str2);
            }
            return L;
        }
        return invokeLL.booleanValue;
    }

    public final synchronized boolean I(@NonNull v23 v23Var, @NonNull Bundle bundle) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, v23Var, bundle)) == null) {
            synchronized (this) {
                if (v23Var.c0()) {
                    if (L(v23Var, bundle.getString("ipc_topic", ""))) {
                        z = true;
                    }
                }
                z = false;
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public final void U(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            T(str + ": " + str2);
        }
    }

    public w23 b0(v23 v23Var, Exception exc) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v23Var, exc)) == null) {
            if (v23Var != null) {
                synchronized (this.c) {
                    v23Var.P(exc);
                    this.c.remove(v23Var.T());
                }
            }
            return this;
        }
        return (w23) invokeLL.objValue;
    }

    public static synchronized v23 Q(@NonNull String str) {
        InterceptResult invokeL;
        v23 e0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            synchronized (w23.class) {
                e0 = R().e0(str);
            }
            return e0;
        }
        return (v23) invokeL.objValue;
    }

    public static synchronized v23 Z(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        v23 c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bundle)) == null) {
            synchronized (w23.class) {
                c0 = R().c0(bundle);
            }
            return c0;
        }
        return (v23) invokeL.objValue;
    }

    public static synchronized v23 a0(@NonNull String str) {
        InterceptResult invokeL;
        v23 d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            synchronized (w23.class) {
                d0 = R().d0(str, null);
            }
            return d0;
        }
        return (v23) invokeL.objValue;
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && d) {
            Log.i("SwanIpc", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    public String X(@NonNull v23 v23Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, v23Var)) == null) {
            return Y(v23Var.T());
        }
        return (String) invokeL.objValue;
    }

    public String Y(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return this.b.get(str);
        }
        return (String) invokeL.objValue;
    }

    public final synchronized v23 c0(Bundle bundle) {
        InterceptResult invokeL;
        String string;
        v23 d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bundle)) == null) {
            synchronized (this) {
                if (bundle == null) {
                    string = null;
                } else {
                    string = bundle.getString("ipc_session_id");
                }
                d0 = d0(string, bundle);
            }
            return d0;
        }
        return (v23) invokeL.objValue;
    }

    public final synchronized boolean L(@NonNull v23 v23Var, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v23Var, str)) == null) {
            synchronized (this) {
                boolean z = false;
                if (!v23Var.c0()) {
                    return false;
                }
                String T2 = v23Var.T();
                String str2 = this.b.get(T2);
                boolean z2 = !TextUtils.isEmpty(str2);
                z = (!z2 || TextUtils.equals(str2, str)) ? true : true;
                if (z && !z2 && !TextUtils.isEmpty(str)) {
                    this.b.put(T2, str);
                }
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void V(o63.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (d) {
                U("onCallIn", "msg=" + aVar);
            }
            if (aVar != null) {
                Bundle D = aVar.D();
                o63.a aVar2 = new o63.a("event_messenger_call", D);
                v23 Z = Z(D);
                if (!I(Z, D) || !Z.a0(aVar2)) {
                    j63.K().A(aVar2);
                }
            }
        }
    }

    public final void W(o63.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (d) {
                U("onCallOut", "msg=" + aVar);
            }
            if (aVar != null) {
                Z(aVar.D()).M();
            }
        }
    }

    public final synchronized v23 e0(String str) {
        InterceptResult invokeL;
        v23 c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            synchronized (this) {
                c0 = c0(null);
                L(c0, str);
                if (d) {
                    U("topic", str + " session=" + c0);
                }
            }
            return c0;
        }
        return (v23) invokeL.objValue;
    }

    public final synchronized v23 d0(String str, Bundle bundle) {
        InterceptResult invokeLL;
        v23 v23Var;
        boolean z;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bundle)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    v23Var = null;
                } else {
                    v23Var = this.c.get(str);
                }
                if (v23Var == null || !v23Var.c0()) {
                    b0(v23Var, new IllegalStateException("invalid session"));
                    v23Var = new v23(this, str);
                    this.c.put(v23Var.T(), v23Var);
                }
                if (bundle != null && I(v23Var, bundle)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    int i = bundle.getInt("ipc_session_repal", SwanAppProcessInfo.UNKNOWN.index);
                    if (SwanAppProcessInfo.checkProcessId(i)) {
                        v23Var.J(i);
                    } else if (SwanAppProcessInfo.SERVICE.index == i) {
                        v23Var.L(true);
                    }
                }
                if (z) {
                    j = bundle.getLong("ipc_session_timeout");
                } else {
                    j = u23.o0;
                }
                v23Var.V(j);
                if (d) {
                    U("session", "id=" + str + " session=" + bundle + " session=" + v23Var);
                }
            }
            return v23Var;
        }
        return (v23) invokeLL.objValue;
    }
}
