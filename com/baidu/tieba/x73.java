package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class x73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* loaded from: classes8.dex */
    public interface c {
        void a();

        void b(@NonNull z73 z73Var);

        void c(String str);

        void d(String str);
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z73 a;
        public final /* synthetic */ x73 b;

        public a(x73 x73Var, z73 z73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x73Var, z73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x73Var;
            this.a = z73Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.g(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static x73 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-334399305, "Lcom/baidu/tieba/x73$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-334399305, "Lcom/baidu/tieba/x73$b;");
                    return;
                }
            }
            a = new x73();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948253237, "Lcom/baidu/tieba/x73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948253237, "Lcom/baidu/tieba/x73;");
                return;
            }
        }
        b = rr1.a;
    }

    public x73() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static x73 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (x73) invokeV.objValue;
    }

    public void c() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (cVar = this.a) != null) {
            cVar.a();
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) && b) {
            Log.i("SwanAppMessenger", str);
        }
    }

    public void b(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && (cVar = this.a) != null) {
            cVar.d(str);
        }
    }

    public void d(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (cVar = this.a) != null) {
            cVar.c(str);
        }
    }

    public final void g(@NonNull z73 z73Var) {
        c d83Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, z73Var) == null) {
            boolean isMainProcess = ProcessUtils.isMainProcess();
            if (!isMainProcess && !SwanAppProcessInfo.isInited()) {
                f("send: return by process check");
                return;
            }
            if (this.a == null) {
                if (isMainProcess) {
                    d83Var = new h83();
                } else {
                    d83Var = new d83();
                }
                this.a = d83Var;
            }
            f("send: sender=" + this.a);
            this.a.a();
            this.a.b(z73Var);
            this.a.a();
        }
    }

    public void h(@NonNull z73 z73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, z73Var) == null) {
            long i = z73Var.i();
            int i2 = (i > 0L ? 1 : (i == 0L ? 0 : -1));
            if (i2 <= 0 && Looper.getMainLooper() == Looper.myLooper()) {
                g(z73Var);
                return;
            }
            Handler M = gb3.M();
            a aVar = new a(this, z73Var);
            if (i2 < 0) {
                i = 0;
            }
            M.postDelayed(aVar, i);
        }
    }
}
