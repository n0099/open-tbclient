package com.baidu.tieba;

import android.app.Activity;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.asb;
import com.baidu.tieba.xrb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
/* loaded from: classes6.dex */
public final class jsb implements xrb.a {
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

    /* loaded from: classes6.dex */
    public interface e {
        void aq();

        void ar();
    }

    @Override // com.baidu.tieba.xrb.a
    public final void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
        }
    }

    @Override // com.baidu.tieba.xrb.a
    public final void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jsb a;

        /* renamed from: com.baidu.tieba.jsb$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0369a extends msb {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0369a(a aVar) {
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

            @Override // com.baidu.tieba.msb
            public final void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ksb.b("记录一次app启动事件");
                    hrb.c("power_on", "", "", null);
                    jrb.i().d(false);
                }
            }
        }

        public a(jsb jsbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jsbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jsbVar;
        }

        @Override // com.baidu.tieba.jsb.e
        public final void aq() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                ksb.b("app   went foreground ");
                if (currentTimeMillis - jsb.h > jsb.g) {
                    this.a.l(currentTimeMillis);
                }
                if (jrb.i().h()) {
                    lsb.a(new C0369a(this));
                }
            }
        }

        @Override // com.baidu.tieba.jsb.e
        public final void ar() {
            asb asbVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                asbVar = asb.a.a;
                if (asbVar.a().size() == 0) {
                    ksb.b("后台应用退出了 了               ");
                    jrb.i().d(true);
                    jsb.g();
                    return;
                }
                ksb.b("进入后台但没退出                  ");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jsb a;

        public b(jsb jsbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jsbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jsbVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a && this.a.b) {
                jsb.j(this.a);
                try {
                    this.a.e.ar();
                } catch (Exception e) {
                    ssb.b("Listener threw exception!:" + e.toString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends msb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(jsb jsbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jsbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.msb
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                jsb.f.z(String.valueOf(currentTimeMillis));
                try {
                    jsb.f.A(String.valueOf(currentTimeMillis - Long.parseLong(jsb.f.N())));
                } catch (NumberFormatException e) {
                    ksb.b(e.getLocalizedMessage());
                }
                urb urbVar = new urb();
                if (urbVar.b(jsb.f.I())) {
                    urbVar.e(jsb.f);
                } else {
                    urbVar.f(jsb.f);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends msb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(jsb jsbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jsbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.msb
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ksb.b("超时了……………… 一个新的session");
                new urb().f(jsb.f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947895280, "Lcom/baidu/tieba/jsb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947895280, "Lcom/baidu/tieba/jsb;");
                return;
            }
        }
        g = csb.a();
    }

    public static com.baidu.ubs.analytics.a.n d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return f;
        }
        return (com.baidu.ubs.analytics.a.n) invokeV.objValue;
    }

    public static /* synthetic */ long g() {
        h = 0L;
        return 0L;
    }

    public jsb() {
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
        l(currentTimeMillis);
    }

    @Override // com.baidu.tieba.xrb.a
    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = false;
            boolean z = !this.a;
            this.a = true;
            Runnable runnable = this.d;
            if (runnable != null) {
                this.c.removeCallbacks(runnable);
            }
            if (z) {
                try {
                    this.e.aq();
                } catch (Exception e2) {
                    ssb.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    @Override // com.baidu.tieba.xrb.a
    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = true;
            Runnable runnable = this.d;
            if (runnable != null) {
                this.c.removeCallbacks(runnable);
                this.d = null;
            }
            h = System.currentTimeMillis();
            lsb.c(new c(this));
            Handler handler = this.c;
            b bVar = new b(this);
            this.d = bVar;
            handler.postDelayed(bVar, 1000L);
        }
    }

    public static /* synthetic */ boolean j(jsb jsbVar) {
        jsbVar.a = false;
        return false;
    }

    public final void l(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            com.baidu.ubs.analytics.a.n nVar = new com.baidu.ubs.analytics.a.n();
            f = nVar;
            nVar.setStartTime(String.valueOf(j));
            f.x(UUID.randomUUID().toString().replace("-", ""));
            lsb.c(new d(this));
        }
    }
}
