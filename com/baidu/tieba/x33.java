package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class x33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static volatile x33 e;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, y33<w33>> a;
    public ConcurrentHashMap<String, Runnable> b;
    public a c;

    /* loaded from: classes6.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<x33> a;
        public String b;

        public b(x33 x33Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x33Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(x33Var);
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            x33 x33Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (x33Var = this.a.get()) == null) {
                return;
            }
            if (x33.d) {
                Log.d("MDelegate-Observe", "run: observer timeout " + this.b);
            }
            w33 w33Var = new w33(this.b);
            w33Var.setResult(null);
            x33Var.c(w33Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948249393, "Lcom/baidu/tieba/x33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948249393, "Lcom/baidu/tieba/x33;");
                return;
            }
        }
        d = do1.a;
    }

    public static x33 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (e == null) {
                synchronized (x33.class) {
                    if (e == null) {
                        e = new x33();
                    }
                }
            }
            return e;
        }
        return (x33) invokeV.objValue;
    }

    public x33() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap<>();
        this.b = new ConcurrentHashMap<>();
        this.c = new a(Looper.getMainLooper());
    }

    public void c(@NonNull w33 w33Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, w33Var) == null) {
            y33<w33> y33Var = this.a.get(w33Var.b());
            if (y33Var == null) {
                if (d) {
                    Log.e("MDelegate-Observe", "notify a null observer");
                    return;
                }
                return;
            }
            String b2 = y33Var.b();
            if (d) {
                Log.d("MDelegate-Observe", "notify observer: " + b2);
            }
            y33Var.onEvent(w33Var);
            if (this.b.containsKey(b2)) {
                if (d) {
                    Log.d("MDelegate-Observe", "remove observer: " + b2 + " timeout runnable");
                }
                this.c.removeCallbacks(this.b.get(b2));
                this.b.remove(b2);
            }
            if (y33Var.c()) {
                if (d) {
                    Log.d("MDelegate-Observe", "auto unregister disposable observer: " + b2);
                }
                f(y33Var);
            }
        }
    }

    public void e(y33<w33> y33Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, y33Var) == null) {
            if (y33Var == null) {
                if (d) {
                    Log.e("MDelegate-Observe", "register a null observer");
                    return;
                }
                return;
            }
            String b2 = y33Var.b();
            if (this.a.containsKey(b2)) {
                if (d) {
                    Log.e("MDelegate-Observe", "multiple register observer：" + b2);
                    return;
                }
                return;
            }
            if (d) {
                Log.d("MDelegate-Observe", "register observer: " + b2);
            }
            this.a.put(b2, y33Var);
            long a2 = y33Var.a();
            if (a2 > 0 && y33Var.c()) {
                if (d) {
                    Log.d("MDelegate-Observe", "post observer: " + b2 + " " + a2 + "ms timeout runnable");
                }
                b bVar = new b(this, b2);
                this.b.put(b2, bVar);
                this.c.postDelayed(bVar, a2);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (d) {
                Log.d("MDelegate-Observe", "release observable");
            }
            if (e == null) {
                return;
            }
            this.a.clear();
            for (Map.Entry<String, Runnable> entry : this.b.entrySet()) {
                if (d) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.c.removeCallbacks(entry.getValue());
            }
            this.b.clear();
            e = null;
        }
    }

    public void f(y33<w33> y33Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, y33Var) == null) {
            if (y33Var == null) {
                if (d) {
                    Log.e("MDelegate-Observe", "unregister a null observer");
                    return;
                }
                return;
            }
            String b2 = y33Var.b();
            if (!this.a.containsKey(b2)) {
                if (d) {
                    Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                    return;
                }
                return;
            }
            if (d) {
                Log.d("MDelegate-Observe", "unregister observer: " + b2);
            }
            this.a.remove(b2);
        }
    }
}
