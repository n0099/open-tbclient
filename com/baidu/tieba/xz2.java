package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.p33;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public final class xz2 extends t33 implements vz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> b;
    public final HashMap<String, wz2> c;

    /* loaded from: classes6.dex */
    public class a implements ei3<p33.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz2 a;

        public a(xz2 xz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(p33.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (xz2.d) {
                    xz2 xz2Var = this.a;
                    xz2Var.T("onEventCallback msg" + aVar);
                }
                this.a.V(aVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ei3<p33.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz2 a;

        public b(xz2 xz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(p33.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (xz2.d) {
                    xz2 xz2Var = this.a;
                    xz2Var.T("onEventCallback msg" + aVar);
                }
                this.a.W(aVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static xz2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-272553158, "Lcom/baidu/tieba/xz2$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-272553158, "Lcom/baidu/tieba/xz2$c;");
                    return;
                }
            }
            a = new xz2(k33.K());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948317593, "Lcom/baidu/tieba/xz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948317593, "Lcom/baidu/tieba/xz2;");
                return;
            }
        }
        d = vj1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xz2(o33 o33Var) {
        super(o33Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o33Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((o33) newInitContext.callArgs[0]);
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
        i33 i33Var = new i33();
        i33Var.f(new b(this), "event_messenger_call_out");
        i33Var.f(new a(this), "event_messenger_call_in");
        u(i33Var);
    }

    public static synchronized boolean J(@NonNull Bundle bundle, @NonNull String str) {
        InterceptResult invokeLL;
        boolean L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bundle, str)) == null) {
            synchronized (xz2.class) {
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
            synchronized (xz2.class) {
                L = R().L(a0(str), str2);
            }
            return L;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized wz2 Q(@NonNull String str) {
        InterceptResult invokeL;
        wz2 e0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            synchronized (xz2.class) {
                e0 = R().e0(str);
            }
            return e0;
        }
        return (wz2) invokeL.objValue;
    }

    public static xz2 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c.a : (xz2) invokeV.objValue;
    }

    public static void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            R();
        }
    }

    public static synchronized wz2 Z(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        wz2 c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bundle)) == null) {
            synchronized (xz2.class) {
                c0 = R().c0(bundle);
            }
            return c0;
        }
        return (wz2) invokeL.objValue;
    }

    public static synchronized wz2 a0(@NonNull String str) {
        InterceptResult invokeL;
        wz2 d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            synchronized (xz2.class) {
                d0 = R().d0(str, null);
            }
            return d0;
        }
        return (wz2) invokeL.objValue;
    }

    public final synchronized boolean I(@NonNull wz2 wz2Var, @NonNull Bundle bundle) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, wz2Var, bundle)) == null) {
            synchronized (this) {
                if (wz2Var.Z()) {
                    z = L(wz2Var, bundle.getString("ipc_topic", ""));
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public final synchronized boolean L(@NonNull wz2 wz2Var, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wz2Var, str)) == null) {
            synchronized (this) {
                boolean z = false;
                if (wz2Var.Z()) {
                    String Q = wz2Var.Q();
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

    public final void V(p33.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (d) {
                U("onCallIn", "msg=" + aVar);
            }
            if (aVar != null) {
                Bundle D = aVar.D();
                p33.a aVar2 = new p33.a("event_messenger_call", D);
                wz2 Z = Z(D);
                if (I(Z, D) && Z.X(aVar2)) {
                    return;
                }
                k33.K().A(aVar2);
            }
        }
    }

    public final void W(p33.a aVar) {
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

    public String X(@NonNull wz2 wz2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, wz2Var)) == null) ? Y(wz2Var.Q()) : (String) invokeL.objValue;
    }

    public String Y(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? this.b.get(str) : (String) invokeL.objValue;
    }

    public xz2 b0(wz2 wz2Var, Exception exc) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wz2Var, exc)) == null) {
            if (wz2Var != null) {
                synchronized (this.c) {
                    wz2Var.M(exc);
                    this.c.remove(wz2Var.Q());
                }
            }
            return this;
        }
        return (xz2) invokeLL.objValue;
    }

    public final synchronized wz2 c0(Bundle bundle) {
        InterceptResult invokeL;
        wz2 d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bundle)) == null) {
            synchronized (this) {
                d0 = d0(bundle == null ? null : bundle.getString("ipc_session_id"), bundle);
            }
            return d0;
        }
        return (wz2) invokeL.objValue;
    }

    public final synchronized wz2 d0(String str, Bundle bundle) {
        InterceptResult invokeLL;
        wz2 wz2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bundle)) == null) {
            synchronized (this) {
                wz2Var = TextUtils.isEmpty(str) ? null : this.c.get(str);
                if (wz2Var == null || !wz2Var.Z()) {
                    b0(wz2Var, new IllegalStateException("invalid session"));
                    wz2Var = new wz2(this, str);
                    this.c.put(wz2Var.Q(), wz2Var);
                }
                boolean z = bundle != null && I(wz2Var, bundle);
                if (z) {
                    int i = bundle.getInt("ipc_session_repal", SwanAppProcessInfo.UNKNOWN.index);
                    if (SwanAppProcessInfo.checkProcessId(i)) {
                        wz2Var.I(i);
                    } else if (SwanAppProcessInfo.SERVICE.index == i) {
                        wz2Var.K(true);
                    }
                }
                wz2Var.S(z ? bundle.getLong("ipc_session_timeout") : vz2.n0);
                if (d) {
                    U("session", "id=" + str + " session=" + bundle + " session=" + wz2Var);
                }
            }
            return wz2Var;
        }
        return (wz2) invokeLL.objValue;
    }

    public final synchronized wz2 e0(String str) {
        InterceptResult invokeL;
        wz2 c0;
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
        return (wz2) invokeL.objValue;
    }
}
