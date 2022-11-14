package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.j43;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class r03 extends n43 implements p03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> b;
    public final HashMap<String, q03> c;

    /* loaded from: classes5.dex */
    public class a implements yi3<j43.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r03 a;

        public a(r03 r03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r03Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(j43.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (r03.d) {
                    r03 r03Var = this.a;
                    r03Var.T("onEventCallback msg" + aVar);
                }
                this.a.V(aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements yi3<j43.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r03 a;

        public b(r03 r03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r03Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(j43.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (r03.d) {
                    r03 r03Var = this.a;
                    r03Var.T("onEventCallback msg" + aVar);
                }
                this.a.W(aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static r03 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-512638827, "Lcom/baidu/tieba/r03$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-512638827, "Lcom/baidu/tieba/r03$c;");
                    return;
                }
            }
            a = new r03(e43.K());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948067764, "Lcom/baidu/tieba/r03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948067764, "Lcom/baidu/tieba/r03;");
                return;
            }
        }
        d = pk1.a;
    }

    public static r03 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return c.a;
        }
        return (r03) invokeV.objValue;
    }

    public static void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            R();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r03(i43 i43Var) {
        super(i43Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i43Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((i43) newInitContext.callArgs[0]);
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
        c43 c43Var = new c43();
        c43Var.f(new b(this), "event_messenger_call_out");
        c43Var.f(new a(this), "event_messenger_call_in");
        u(c43Var);
    }

    public static synchronized boolean J(@NonNull Bundle bundle, @NonNull String str) {
        InterceptResult invokeLL;
        boolean L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bundle, str)) == null) {
            synchronized (r03.class) {
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
            synchronized (r03.class) {
                L = R().L(a0(str), str2);
            }
            return L;
        }
        return invokeLL.booleanValue;
    }

    public final synchronized boolean I(@NonNull q03 q03Var, @NonNull Bundle bundle) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, q03Var, bundle)) == null) {
            synchronized (this) {
                if (q03Var.Z()) {
                    if (L(q03Var, bundle.getString("ipc_topic", ""))) {
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

    public r03 b0(q03 q03Var, Exception exc) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, q03Var, exc)) == null) {
            if (q03Var != null) {
                synchronized (this.c) {
                    q03Var.M(exc);
                    this.c.remove(q03Var.Q());
                }
            }
            return this;
        }
        return (r03) invokeLL.objValue;
    }

    public static synchronized q03 Q(@NonNull String str) {
        InterceptResult invokeL;
        q03 e0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            synchronized (r03.class) {
                e0 = R().e0(str);
            }
            return e0;
        }
        return (q03) invokeL.objValue;
    }

    public static synchronized q03 Z(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        q03 c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bundle)) == null) {
            synchronized (r03.class) {
                c0 = R().c0(bundle);
            }
            return c0;
        }
        return (q03) invokeL.objValue;
    }

    public static synchronized q03 a0(@NonNull String str) {
        InterceptResult invokeL;
        q03 d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            synchronized (r03.class) {
                d0 = R().d0(str, null);
            }
            return d0;
        }
        return (q03) invokeL.objValue;
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && d) {
            Log.i("SwanIpc", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    public String X(@NonNull q03 q03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, q03Var)) == null) {
            return Y(q03Var.Q());
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

    public final synchronized q03 c0(Bundle bundle) {
        InterceptResult invokeL;
        String string;
        q03 d0;
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
        return (q03) invokeL.objValue;
    }

    public final synchronized boolean L(@NonNull q03 q03Var, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q03Var, str)) == null) {
            synchronized (this) {
                boolean z = false;
                if (!q03Var.Z()) {
                    return false;
                }
                String Q = q03Var.Q();
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

    public final void V(j43.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (d) {
                U("onCallIn", "msg=" + aVar);
            }
            if (aVar != null) {
                Bundle D = aVar.D();
                j43.a aVar2 = new j43.a("event_messenger_call", D);
                q03 Z = Z(D);
                if (!I(Z, D) || !Z.X(aVar2)) {
                    e43.K().A(aVar2);
                }
            }
        }
    }

    public final void W(j43.a aVar) {
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

    public final synchronized q03 e0(String str) {
        InterceptResult invokeL;
        q03 c0;
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
        return (q03) invokeL.objValue;
    }

    public final synchronized q03 d0(String str, Bundle bundle) {
        InterceptResult invokeLL;
        q03 q03Var;
        boolean z;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bundle)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    q03Var = null;
                } else {
                    q03Var = this.c.get(str);
                }
                if (q03Var == null || !q03Var.Z()) {
                    b0(q03Var, new IllegalStateException("invalid session"));
                    q03Var = new q03(this, str);
                    this.c.put(q03Var.Q(), q03Var);
                }
                if (bundle != null && I(q03Var, bundle)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    int i = bundle.getInt("ipc_session_repal", SwanAppProcessInfo.UNKNOWN.index);
                    if (SwanAppProcessInfo.checkProcessId(i)) {
                        q03Var.I(i);
                    } else if (SwanAppProcessInfo.SERVICE.index == i) {
                        q03Var.K(true);
                    }
                }
                if (z) {
                    j = bundle.getLong("ipc_session_timeout");
                } else {
                    j = p03.n0;
                }
                q03Var.S(j);
                if (d) {
                    U("session", "id=" + str + " session=" + bundle + " session=" + q03Var);
                }
            }
            return q03Var;
        }
        return (q03) invokeLL.objValue;
    }
}
