package com.baidu.tieba;

import android.os.Debug;
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
import com.github.anrwatchdog.ANRError;
/* loaded from: classes9.dex */
public class y2c extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public static final f o;
    public static final e p;
    public static final g q;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;
    public e b;
    public g c;
    public final Handler d;
    public final int e;
    public String f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public z2c k;
    public volatile long l;
    public volatile boolean m;
    public final Runnable n;

    /* loaded from: classes9.dex */
    public interface e {
        long a(long j);
    }

    /* loaded from: classes9.dex */
    public interface f {
        void onAppNotResponding(ANRError aNRError);
    }

    /* loaded from: classes9.dex */
    public interface g {
        void a(InterruptedException interruptedException);
    }

    /* loaded from: classes9.dex */
    public static class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.tieba.y2c.f
        public void onAppNotResponding(ANRError aNRError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aNRError) == null) {
                throw aNRError;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.y2c.e
        public long a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                return 0L;
            }
            return invokeJ.longValue;
        }

        public b() {
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
    }

    /* loaded from: classes9.dex */
    public static class c implements g {
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

        @Override // com.baidu.tieba.y2c.g
        public void a(InterruptedException interruptedException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, interruptedException) == null) {
                Log.w("ANRWatchdog", "Interrupted: " + interruptedException.getMessage());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y2c a;

        public d(y2c y2cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y2cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y2cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.l = 0L;
            this.a.m = false;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948279711, "Lcom/baidu/tieba/y2c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948279711, "Lcom/baidu/tieba/y2c;");
                return;
            }
        }
        o = new a();
        p = new b();
        q = new c();
    }

    public y2c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = o;
        this.b = p;
        this.c = q;
        this.d = new Handler(Looper.getMainLooper());
        this.f = "";
        this.g = false;
        this.h = true;
        this.i = false;
        this.j = false;
        this.k = null;
        this.l = 0L;
        this.m = false;
        this.n = new d(this);
        this.e = i;
    }

    public y2c c(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            if (fVar == null) {
                this.a = o;
            } else {
                this.a = fVar;
            }
            return this;
        }
        return (y2c) invokeL.objValue;
    }

    public y2c d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.i = z;
            return this;
        }
        return (y2c) invokeZ.objValue;
    }

    public y2c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.f = null;
            return this;
        }
        return (y2c) invokeV.objValue;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setName("|ANR-WatchDog|");
            long j = this.e;
            long j2 = 0;
            while (!isInterrupted()) {
                if (this.l == 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.l += j;
                if (z) {
                    this.d.post(this.n);
                }
                try {
                    Thread.sleep(j);
                    if (this.i && this.j) {
                        if (this.k == null) {
                            this.k = new z2c();
                        }
                        if (this.l == 0 && !this.m) {
                            this.j = false;
                            ANRError NewMainAllStackTrace = ANRError.NewMainAllStackTrace(this.k.b(), j2);
                            if (NewMainAllStackTrace != null) {
                                this.a.onAppNotResponding(NewMainAllStackTrace);
                            }
                        } else {
                            j2 = this.l;
                            this.k.a();
                        }
                    }
                    if (this.l != 0 && !this.m) {
                        if (!this.h && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                            Log.w("ANRWatchdog", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                            this.m = true;
                        } else {
                            j = this.b.a(this.l);
                            if (j <= 0) {
                                if (this.f != null) {
                                    this.a.onAppNotResponding(ANRError.New(this.l, this.f, this.g));
                                } else if (this.i) {
                                    this.j = true;
                                    z2c z2cVar = new z2c();
                                    this.k = z2cVar;
                                    z2cVar.a();
                                } else {
                                    this.a.onAppNotResponding(ANRError.NewMainOnly(this.l));
                                }
                                j = this.e;
                                this.m = true;
                            }
                        }
                    }
                } catch (InterruptedException e2) {
                    this.c.a(e2);
                    return;
                }
            }
        }
    }
}
