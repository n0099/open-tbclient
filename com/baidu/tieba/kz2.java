package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.c33;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class kz2 extends g33 implements iz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> b;
    public final HashMap<String, jz2> c;

    /* loaded from: classes4.dex */
    public class a implements rh3<c33.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz2 a;

        public a(kz2 kz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(c33.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (kz2.d) {
                    kz2 kz2Var = this.a;
                    kz2Var.T("onEventCallback msg" + aVar);
                }
                this.a.V(aVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements rh3<c33.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz2 a;

        public b(kz2 kz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(c33.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (kz2.d) {
                    kz2 kz2Var = this.a;
                    kz2Var.T("onEventCallback msg" + aVar);
                }
                this.a.W(aVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static kz2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-644732121, "Lcom/baidu/tieba/kz2$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-644732121, "Lcom/baidu/tieba/kz2$c;");
                    return;
                }
            }
            a = new kz2(x23.K());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947930310, "Lcom/baidu/tieba/kz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947930310, "Lcom/baidu/tieba/kz2;");
                return;
            }
        }
        d = ij1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kz2(b33 b33Var) {
        super(b33Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b33Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b33) newInitContext.callArgs[0]);
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
        v23 v23Var = new v23();
        v23Var.f(new b(this), "event_messenger_call_out");
        v23Var.f(new a(this), "event_messenger_call_in");
        u(v23Var);
    }

    public static synchronized boolean J(@NonNull Bundle bundle, @NonNull String str) {
        InterceptResult invokeLL;
        boolean L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bundle, str)) == null) {
            synchronized (kz2.class) {
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
            synchronized (kz2.class) {
                L = R().L(a0(str), str2);
            }
            return L;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized jz2 Q(@NonNull String str) {
        InterceptResult invokeL;
        jz2 e0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            synchronized (kz2.class) {
                e0 = R().e0(str);
            }
            return e0;
        }
        return (jz2) invokeL.objValue;
    }

    public static kz2 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c.a : (kz2) invokeV.objValue;
    }

    public static void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            R();
        }
    }

    public static synchronized jz2 Z(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        jz2 c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bundle)) == null) {
            synchronized (kz2.class) {
                c0 = R().c0(bundle);
            }
            return c0;
        }
        return (jz2) invokeL.objValue;
    }

    public static synchronized jz2 a0(@NonNull String str) {
        InterceptResult invokeL;
        jz2 d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            synchronized (kz2.class) {
                d0 = R().d0(str, null);
            }
            return d0;
        }
        return (jz2) invokeL.objValue;
    }

    public final synchronized boolean I(@NonNull jz2 jz2Var, @NonNull Bundle bundle) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jz2Var, bundle)) == null) {
            synchronized (this) {
                if (jz2Var.Z()) {
                    z = L(jz2Var, bundle.getString("ipc_topic", ""));
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public final synchronized boolean L(@NonNull jz2 jz2Var, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jz2Var, str)) == null) {
            synchronized (this) {
                boolean z = false;
                if (jz2Var.Z()) {
                    String Q = jz2Var.Q();
                    String str2 = this.b.get(Q);
                    boolean z2 = !TextUtils.isEmpty(str2);
                    z = (!z2 || TextUtils.equals(str2, str)) ? true : true;
                    if (z && !z2 && !TextUtils.isEmpty(str)) {
                        this.b.put(Q, str);
                    }
                    return z;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && d) {
            Log.i("SwanIpc", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    public final void U(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            T(str + ": " + str2);
        }
    }

    public final void V(c33.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (d) {
                U("onCallIn", "msg=" + aVar);
            }
            if (aVar != null) {
                Bundle D = aVar.D();
                c33.a aVar2 = new c33.a("event_messenger_call", D);
                jz2 Z = Z(D);
                if (I(Z, D) && Z.X(aVar2)) {
                    return;
                }
                x23.K().A(aVar2);
            }
        }
    }

    public final void W(c33.a aVar) {
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

    public String X(@NonNull jz2 jz2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jz2Var)) == null) ? Y(jz2Var.Q()) : (String) invokeL.objValue;
    }

    public String Y(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? this.b.get(str) : (String) invokeL.objValue;
    }

    public kz2 b0(jz2 jz2Var, Exception exc) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jz2Var, exc)) == null) {
            if (jz2Var != null) {
                synchronized (this.c) {
                    jz2Var.M(exc);
                    this.c.remove(jz2Var.Q());
                }
            }
            return this;
        }
        return (kz2) invokeLL.objValue;
    }

    public final synchronized jz2 c0(Bundle bundle) {
        InterceptResult invokeL;
        jz2 d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bundle)) == null) {
            synchronized (this) {
                d0 = d0(bundle == null ? null : bundle.getString("ipc_session_id"), bundle);
            }
            return d0;
        }
        return (jz2) invokeL.objValue;
    }

    public final synchronized jz2 d0(String str, Bundle bundle) {
        InterceptResult invokeLL;
        jz2 jz2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bundle)) == null) {
            synchronized (this) {
                jz2Var = TextUtils.isEmpty(str) ? null : this.c.get(str);
                if (jz2Var == null || !jz2Var.Z()) {
                    b0(jz2Var, new IllegalStateException("invalid session"));
                    jz2Var = new jz2(this, str);
                    this.c.put(jz2Var.Q(), jz2Var);
                }
                boolean z = bundle != null && I(jz2Var, bundle);
                if (z) {
                    int i = bundle.getInt("ipc_session_repal", SwanAppProcessInfo.UNKNOWN.index);
                    if (SwanAppProcessInfo.checkProcessId(i)) {
                        jz2Var.I(i);
                    } else if (SwanAppProcessInfo.SERVICE.index == i) {
                        jz2Var.K(true);
                    }
                }
                jz2Var.S(z ? bundle.getLong("ipc_session_timeout") : iz2.n0);
                if (d) {
                    U("session", "id=" + str + " session=" + bundle + " session=" + jz2Var);
                }
            }
            return jz2Var;
        }
        return (jz2) invokeLL.objValue;
    }

    public final synchronized jz2 e0(String str) {
        InterceptResult invokeL;
        jz2 c0;
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
        return (jz2) invokeL.objValue;
    }
}
