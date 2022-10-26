package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
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
/* loaded from: classes5.dex */
public class qz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static volatile qz2 e;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap a;
    public ConcurrentHashMap b;
    public a c;

    /* loaded from: classes5.dex */
    public class a extends Handler {
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

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference a;
        public String b;

        public b(qz2 qz2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference(qz2Var);
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            qz2 qz2Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (qz2Var = (qz2) this.a.get()) == null) {
                return;
            }
            if (qz2.d) {
                Log.d("MDelegate-Observe", "run: observer timeout " + this.b);
            }
            pz2 pz2Var = new pz2(this.b);
            pz2Var.setResult(null);
            qz2Var.c(pz2Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948109056, "Lcom/baidu/tieba/qz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948109056, "Lcom/baidu/tieba/qz2;");
                return;
            }
        }
        d = wj1.a;
    }

    public static qz2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (e == null) {
                synchronized (qz2.class) {
                    if (e == null) {
                        e = new qz2();
                    }
                }
            }
            return e;
        }
        return (qz2) invokeV.objValue;
    }

    public qz2() {
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
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = new a(Looper.getMainLooper());
    }

    public void c(pz2 pz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pz2Var) == null) {
            rz2 rz2Var = (rz2) this.a.get(pz2Var.b());
            if (rz2Var == null) {
                if (d) {
                    Log.e("MDelegate-Observe", "notify a null observer");
                    return;
                }
                return;
            }
            String b2 = rz2Var.b();
            if (d) {
                Log.d("MDelegate-Observe", "notify observer: " + b2);
            }
            rz2Var.onEvent(pz2Var);
            if (this.b.containsKey(b2)) {
                if (d) {
                    Log.d("MDelegate-Observe", "remove observer: " + b2 + " timeout runnable");
                }
                this.c.removeCallbacks((Runnable) this.b.get(b2));
                this.b.remove(b2);
            }
            if (rz2Var.c()) {
                if (d) {
                    Log.d("MDelegate-Observe", "auto unregister disposable observer: " + b2);
                }
                f(rz2Var);
            }
        }
    }

    public void e(rz2 rz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rz2Var) == null) {
            if (rz2Var == null) {
                if (d) {
                    Log.e("MDelegate-Observe", "register a null observer");
                    return;
                }
                return;
            }
            String b2 = rz2Var.b();
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
            this.a.put(b2, rz2Var);
            long a2 = rz2Var.a();
            if (a2 > 0 && rz2Var.c()) {
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
            for (Map.Entry entry : this.b.entrySet()) {
                if (d) {
                    Log.d("MDelegate-Observe", "remove observer: " + ((String) entry.getKey()) + " timeout runnable");
                }
                this.c.removeCallbacks((Runnable) entry.getValue());
            }
            this.b.clear();
            e = null;
        }
    }

    public void f(rz2 rz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rz2Var) == null) {
            if (rz2Var == null) {
                if (d) {
                    Log.e("MDelegate-Observe", "unregister a null observer");
                    return;
                }
                return;
            }
            String b2 = rz2Var.b();
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
