package com.baidu.tieba;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class lh3 implements fi3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public final Handler b;
    public Runnable c;
    public volatile boolean d;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh3 a;

        /* renamed from: com.baidu.tieba.lh3$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0316a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0316a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (lh3.e) {
                        Log.d("SwanH2HeartBeatManager", "do updateCore, isStop=" + this.a.a.d);
                    }
                    if (!this.a.a.d) {
                        this.a.a.j();
                    }
                }
            }
        }

        public a(lh3 lh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!ProcessUtils.isMainProcess()) {
                    zz2.c(c.class, null);
                    return;
                }
                this.a.d = false;
                synchronized (lh3.class) {
                    this.a.a = System.currentTimeMillis();
                    if (this.a.c != null) {
                        this.a.b.removeCallbacks(this.a.c);
                    }
                    this.a.c = new RunnableC0316a(this);
                    long a = sf4.a(300) * 1000;
                    this.a.b.postDelayed(this.a.c, a);
                    if (lh3.e) {
                        Log.d("SwanH2HeartBeatManager", "wait next heart beat: " + a);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh3 a;

        public b(lh3 lh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wa4.l(new te4(0), new p62(this.a, true));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                lh3.k().m();
                return null;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public static final lh3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-632696526, "Lcom/baidu/tieba/lh3$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-632696526, "Lcom/baidu/tieba/lh3$d;");
                    return;
                }
            }
            a = new lh3(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947942834, "Lcom/baidu/tieba/lh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947942834, "Lcom/baidu/tieba/lh3;");
                return;
            }
        }
        e = wj1.a;
    }

    public lh3() {
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
        this.d = false;
        this.b = new Handler(Looper.getMainLooper());
    }

    public static lh3 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return d.a;
        }
        return (lh3) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            gg3.l(new b(this), "SwanH2HeartBeatManager");
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || !sf4.a) {
            return;
        }
        if (e) {
            Log.d("SwanH2HeartBeatManager", "startHeartBeat");
        }
        gg3.l(new a(this), "SwanH2HeartBeatManager");
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || !sf4.a) {
            return;
        }
        if (e) {
            Log.d("SwanH2HeartBeatManager", "stopHeartBeat");
        }
        this.d = true;
        Runnable runnable = this.c;
        if (runnable != null) {
            this.b.removeCallbacks(runnable);
        }
        this.c = null;
    }

    public /* synthetic */ lh3(a aVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fi3
    /* renamed from: l */
    public void a(Exception exc) {
        gc4 pmsError;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            this.c = null;
            if (e) {
                Log.w("SwanH2HeartBeatManager", "onCallback", exc);
            }
            if (exc != null) {
                Throwable cause = exc.getCause();
                if ((cause instanceof PMSException) && (pmsError = ((PMSException) cause).getPmsError()) != null && pmsError.f >= 500) {
                    n();
                    sf4.a = false;
                    m02.k("SwanH2HeartBeatManager", "update core heartBeat exception: code=" + pmsError.f);
                    return;
                }
                m();
            }
        }
    }
}
