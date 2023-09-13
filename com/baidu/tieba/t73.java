package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.lb3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class t73 extends pb3 implements r73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> b;
    public final HashMap<String, s73> c;

    /* loaded from: classes8.dex */
    public class a implements aq3<lb3.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t73 a;

        public a(t73 t73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t73Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(lb3.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (t73.d) {
                    t73 t73Var = this.a;
                    t73Var.T("onEventCallback msg" + aVar);
                }
                this.a.V(aVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements aq3<lb3.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t73 a;

        public b(t73 t73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t73Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(lb3.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (t73.d) {
                    t73 t73Var = this.a;
                    t73Var.T("onEventCallback msg" + aVar);
                }
                this.a.W(aVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static t73 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-448915878, "Lcom/baidu/tieba/t73$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-448915878, "Lcom/baidu/tieba/t73$c;");
                    return;
                }
            }
            a = new t73(gb3.K());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948134073, "Lcom/baidu/tieba/t73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948134073, "Lcom/baidu/tieba/t73;");
                return;
            }
        }
        d = rr1.a;
    }

    public static t73 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return c.a;
        }
        return (t73) invokeV.objValue;
    }

    public static void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            R();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t73(kb3 kb3Var) {
        super(kb3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kb3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((kb3) newInitContext.callArgs[0]);
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
        eb3 eb3Var = new eb3();
        eb3Var.f(new b(this), "event_messenger_call_out");
        eb3Var.f(new a(this), "event_messenger_call_in");
        u(eb3Var);
    }

    public static synchronized boolean J(@NonNull Bundle bundle, @NonNull String str) {
        InterceptResult invokeLL;
        boolean L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bundle, str)) == null) {
            synchronized (t73.class) {
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
            synchronized (t73.class) {
                L = R().L(a0(str), str2);
            }
            return L;
        }
        return invokeLL.booleanValue;
    }

    public final synchronized boolean I(@NonNull s73 s73Var, @NonNull Bundle bundle) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, s73Var, bundle)) == null) {
            synchronized (this) {
                if (s73Var.Z()) {
                    if (L(s73Var, bundle.getString("ipc_topic", ""))) {
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

    public t73 b0(s73 s73Var, Exception exc) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, s73Var, exc)) == null) {
            if (s73Var != null) {
                synchronized (this.c) {
                    s73Var.M(exc);
                    this.c.remove(s73Var.Q());
                }
            }
            return this;
        }
        return (t73) invokeLL.objValue;
    }

    public static synchronized s73 Q(@NonNull String str) {
        InterceptResult invokeL;
        s73 e0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            synchronized (t73.class) {
                e0 = R().e0(str);
            }
            return e0;
        }
        return (s73) invokeL.objValue;
    }

    public static synchronized s73 Z(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        s73 c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bundle)) == null) {
            synchronized (t73.class) {
                c0 = R().c0(bundle);
            }
            return c0;
        }
        return (s73) invokeL.objValue;
    }

    public static synchronized s73 a0(@NonNull String str) {
        InterceptResult invokeL;
        s73 d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            synchronized (t73.class) {
                d0 = R().d0(str, null);
            }
            return d0;
        }
        return (s73) invokeL.objValue;
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && d) {
            Log.i("SwanIpc", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    public String X(@NonNull s73 s73Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, s73Var)) == null) {
            return Y(s73Var.Q());
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

    public final synchronized s73 c0(Bundle bundle) {
        InterceptResult invokeL;
        String string;
        s73 d0;
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
        return (s73) invokeL.objValue;
    }

    public final synchronized boolean L(@NonNull s73 s73Var, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s73Var, str)) == null) {
            synchronized (this) {
                boolean z = false;
                if (!s73Var.Z()) {
                    return false;
                }
                String Q = s73Var.Q();
                String str2 = this.b.get(Q);
                boolean z2 = !TextUtils.isEmpty(str2);
                z = (!z2 || TextUtils.equals(str2, str)) ? true : true;
                if (z && !z2 && !TextUtils.isEmpty(str)) {
                    this.b.put(Q, str);
                }
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void V(lb3.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (d) {
                U("onCallIn", "msg=" + aVar);
            }
            if (aVar != null) {
                Bundle D = aVar.D();
                lb3.a aVar2 = new lb3.a("event_messenger_call", D);
                s73 Z = Z(D);
                if (!I(Z, D) || !Z.X(aVar2)) {
                    gb3.K().A(aVar2);
                }
            }
        }
    }

    public final void W(lb3.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (d) {
                U("onCallOut", "msg=" + aVar);
            }
            if (aVar != null) {
                Z(aVar.D()).call();
            }
        }
    }

    public final synchronized s73 e0(String str) {
        InterceptResult invokeL;
        s73 c0;
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
        return (s73) invokeL.objValue;
    }

    public final synchronized s73 d0(String str, Bundle bundle) {
        InterceptResult invokeLL;
        s73 s73Var;
        boolean z;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bundle)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    s73Var = null;
                } else {
                    s73Var = this.c.get(str);
                }
                if (s73Var == null || !s73Var.Z()) {
                    b0(s73Var, new IllegalStateException("invalid session"));
                    s73Var = new s73(this, str);
                    this.c.put(s73Var.Q(), s73Var);
                }
                if (bundle != null && I(s73Var, bundle)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    int i = bundle.getInt("ipc_session_repal", SwanAppProcessInfo.UNKNOWN.index);
                    if (SwanAppProcessInfo.checkProcessId(i)) {
                        s73Var.I(i);
                    } else if (SwanAppProcessInfo.SERVICE.index == i) {
                        s73Var.K(true);
                    }
                }
                if (z) {
                    j = bundle.getLong("ipc_session_timeout");
                } else {
                    j = r73.o0;
                }
                s73Var.S(j);
                if (d) {
                    U("session", "id=" + str + " session=" + bundle + " session=" + s73Var);
                }
            }
            return s73Var;
        }
        return (s73) invokeLL.objValue;
    }
}
