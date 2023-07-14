package com.baidu.tieba;

import android.app.Activity;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.k5b;
import com.baidu.tieba.n5b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
/* loaded from: classes8.dex */
public final class w5b implements k5b.a {
    public static /* synthetic */ Interceptable $ic;
    public static com.baidu.ubs.analytics.a.n f;
    public static long g;
    public static long h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public Handler c;
    public Runnable d;
    public e e;

    /* loaded from: classes8.dex */
    public interface e {
        void a();

        void b();
    }

    @Override // com.baidu.tieba.k5b.a
    public final void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
        }
    }

    @Override // com.baidu.tieba.k5b.a
    public final void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w5b a;

        /* renamed from: com.baidu.tieba.w5b$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0519a extends z5b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0519a(a aVar) {
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
                    }
                }
            }

            @Override // com.baidu.tieba.z5b
            public final void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    x5b.b("记录一次app启动事件");
                    u4b.c("power_on", "", "", null);
                    w4b.h().d(false);
                }
            }
        }

        public a(w5b w5bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w5bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w5bVar;
        }

        @Override // com.baidu.tieba.w5b.e
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                x5b.b("app   went foreground ");
                if (currentTimeMillis - w5b.h > w5b.g) {
                    this.a.m(currentTimeMillis);
                }
                if (w4b.h().g()) {
                    y5b.a(new C0519a(this));
                }
            }
        }

        @Override // com.baidu.tieba.w5b.e
        public final void b() {
            n5b n5bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                n5bVar = n5b.a.a;
                if (n5bVar.a().size() == 0) {
                    x5b.b("后台应用退出了 了               ");
                    w4b.h().d(true);
                    w5b.h();
                    return;
                }
                x5b.b("进入后台但没退出                  ");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w5b a;

        public b(w5b w5bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w5bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w5bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a && this.a.b) {
                w5b.k(this.a);
                try {
                    this.a.e.b();
                } catch (Exception e) {
                    f6b.b("Listener threw exception!:" + e.toString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends z5b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(w5b w5bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w5bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.z5b
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                w5b.f.z(String.valueOf(currentTimeMillis));
                try {
                    w5b.f.A(String.valueOf(currentTimeMillis - Long.parseLong(w5b.f.N())));
                } catch (NumberFormatException e) {
                    x5b.b(e.getLocalizedMessage());
                }
                h5b h5bVar = new h5b();
                if (h5bVar.b(w5b.f.I())) {
                    h5bVar.e(w5b.f);
                } else {
                    h5bVar.f(w5b.f);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends z5b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(w5b w5bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w5bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.z5b
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                x5b.b("超时了……………… 一个新的session");
                new h5b().f(w5b.f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948222981, "Lcom/baidu/tieba/w5b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948222981, "Lcom/baidu/tieba/w5b;");
                return;
            }
        }
        g = p5b.a();
    }

    public static com.baidu.ubs.analytics.a.n e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return f;
        }
        return (com.baidu.ubs.analytics.a.n) invokeV.objValue;
    }

    public static /* synthetic */ long h() {
        h = 0L;
        return 0L;
    }

    public w5b() {
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
        this.a = false;
        this.b = true;
        this.c = new Handler();
        this.e = new a(this);
        long currentTimeMillis = System.currentTimeMillis();
        h = currentTimeMillis;
        m(currentTimeMillis);
    }

    @Override // com.baidu.tieba.k5b.a
    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = true;
            Runnable runnable = this.d;
            if (runnable != null) {
                this.c.removeCallbacks(runnable);
                this.d = null;
            }
            h = System.currentTimeMillis();
            y5b.c(new c(this));
            Handler handler = this.c;
            b bVar = new b(this);
            this.d = bVar;
            handler.postDelayed(bVar, 1000L);
        }
    }

    @Override // com.baidu.tieba.k5b.a
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = false;
            boolean z = !this.a;
            this.a = true;
            Runnable runnable = this.d;
            if (runnable != null) {
                this.c.removeCallbacks(runnable);
            }
            if (z) {
                try {
                    this.e.a();
                } catch (Exception e2) {
                    f6b.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    public static /* synthetic */ boolean k(w5b w5bVar) {
        w5bVar.a = false;
        return false;
    }

    public final void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            com.baidu.ubs.analytics.a.n nVar = new com.baidu.ubs.analytics.a.n();
            f = nVar;
            nVar.setStartTime(String.valueOf(j));
            f.x(UUID.randomUUID().toString().replace("-", ""));
            y5b.c(new d(this));
        }
    }
}
