package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.connect.NetWorkUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.tieba.ehb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class tgb {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile tgb g;
    public transient /* synthetic */ FieldHolder $fh;
    public ScheduledExecutorService a;
    public ExecutorService b;
    public fhb c;
    public Context d;
    public chb e;

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ehb a;
        public long b;
        public boolean c;
        public jhb d;
        public final /* synthetic */ tgb e;

        /* loaded from: classes8.dex */
        public class a implements ahb {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // com.baidu.tieba.ahb
            public void a(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
                    if (this.a.c) {
                        this.a.e.c.m(false, this.a.a);
                        d dVar = this.a;
                        dVar.e.m(false, dVar.a.a(), "dir not found", this.a.a.b(), null);
                    } else if (this.a.d != null) {
                        d dVar2 = this.a;
                        dVar2.e.j(false, "dir not found", dVar2.a.c(), this.a.d);
                    }
                }
            }

            @Override // com.baidu.tieba.ahb
            public void b(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) {
                    this.a.a.n(jSONObject);
                    if (this.a.c) {
                        this.a.e.c.u(false, this.a.a);
                        d dVar = this.a;
                        dVar.e.m(false, dVar.a.a(), "zip failed", this.a.a.b(), null);
                    } else if (this.a.d != null) {
                        d dVar2 = this.a;
                        dVar2.e.j(false, "zip failed", dVar2.a.c(), this.a.d);
                    }
                }
            }

            @Override // com.baidu.tieba.ahb
            public void c(String str, int i, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, str, i, str2, jSONObject) == null) {
                    if (this.a.c) {
                        d dVar = this.a;
                        dVar.e.k(false, false, dVar.a, this.a.b, str2, jSONObject);
                    } else if (this.a.d != null) {
                        d dVar2 = this.a;
                        dVar2.e.j(false, str2, jSONObject, dVar2.d);
                    }
                }
            }

            @Override // com.baidu.tieba.ahb
            public void d(String str, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, jSONObject) == null) {
                    if (this.a.c) {
                        d dVar = this.a;
                        dVar.e.k(true, false, dVar.a, this.a.b, str2, jSONObject);
                    } else if (this.a.d != null) {
                        d dVar2 = this.a;
                        dVar2.e.j(true, str2, jSONObject, dVar2.d);
                    }
                }
            }
        }

        public d(tgb tgbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tgbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = tgbVar;
        }

        public d(tgb tgbVar, String str, String str2, int i, int i2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tgbVar, str, str2, Integer.valueOf(i), Integer.valueOf(i2), jSONObject};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.e = tgbVar;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            ehb.b bVar = new ehb.b(str2, arrayList);
            bVar.p(false);
            bVar.o(i);
            bVar.n(i2);
            bVar.l(jSONObject);
            this.a = bVar.k();
            this.c = true;
        }

        public d(tgb tgbVar, String str, String str2, jhb jhbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tgbVar, str, str2, jhbVar};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.e = tgbVar;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            ehb.b bVar = new ehb.b(str2, arrayList);
            bVar.p(false);
            this.a = bVar.k();
            this.d = jhbVar;
        }

        public d(tgb tgbVar, ArrayList<String> arrayList, String str, long j, int i, int i2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tgbVar, arrayList, str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), jSONObject};
                interceptable.invokeUnInit(65539, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.e = tgbVar;
            ehb.b bVar = new ehb.b(str, arrayList);
            bVar.o(i);
            bVar.l(jSONObject);
            bVar.m(j);
            bVar.p(true);
            bVar.n(i2);
            this.a = bVar.k();
            this.c = true;
        }

        public d(tgb tgbVar, ArrayList<String> arrayList, String str, long j, int i, jhb jhbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tgbVar, arrayList, str, Long.valueOf(j), Integer.valueOf(i), jhbVar};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.e = tgbVar;
            ehb.b bVar = new ehb.b(str, arrayList);
            bVar.m(j);
            bVar.n(i);
            bVar.p(true);
            this.a = bVar.k();
            this.d = jhbVar;
        }

        public final boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!vgb.f().p()) {
                    if (tgb.f) {
                        Log.d("VoyagerFileProcessor", "Voyager component disable.");
                    }
                    if (vgb.f().o()) {
                        this.e.c.c();
                    }
                    return false;
                } else if (!vgb.f().a(this.a.a())) {
                    if (tgb.f) {
                        Log.d("VoyagerFileProcessor", "Voyager bizType " + this.a.a() + " disable.");
                    }
                    return false;
                } else {
                    return true;
                }
            }
            return invokeV.booleanValue;
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                xgb.g().d(this.a, new a(this));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (!e()) {
                    if (this.c) {
                        this.e.m(false, this.a.a(), "component disabled", this.a.b(), null);
                        return;
                    } else if (this.d != null) {
                        this.e.j(false, "component disabled", this.a.c(), this.d);
                        return;
                    } else {
                        return;
                    }
                }
                if (this.c) {
                    this.e.c.k(this.a);
                }
                f();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public long b;
        public final /* synthetic */ tgb c;

        /* loaded from: classes8.dex */
        public class a implements ahb {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ehb a;
            public final /* synthetic */ f b;

            public a(f fVar, ehb ehbVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, ehbVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = fVar;
                this.a = ehbVar;
            }

            @Override // com.baidu.tieba.ahb
            public void a(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
                    this.b.c.c.m(true, this.a);
                    this.b.c.m(false, this.a.a(), "dir not found", jSONObject, this.a.b());
                }
            }

            @Override // com.baidu.tieba.ahb
            public void b(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) {
                    this.b.c.c.u(true, this.a);
                    this.b.c.m(false, this.a.a(), "zip failed", jSONObject, this.a.b());
                }
            }

            @Override // com.baidu.tieba.ahb
            public void c(String str, int i, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, str, i, str2, jSONObject) == null) {
                    f fVar = this.b;
                    fVar.c.k(false, true, this.a, fVar.b, str2, jSONObject);
                }
            }

            @Override // com.baidu.tieba.ahb
            public void d(String str, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, jSONObject) == null) {
                    f fVar = this.b;
                    fVar.c.k(true, true, this.a, fVar.b, str2, jSONObject);
                }
            }
        }

        public f(tgb tgbVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tgbVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tgbVar;
            this.a = z;
        }

        public final boolean a(ehb ehbVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ehbVar)) == null) {
                if (!vgb.f().p()) {
                    if (tgb.f) {
                        Log.d("VoyagerFileProcessor", "Voyager component disable.");
                    }
                    return false;
                } else if (!vgb.f().a(ehbVar.a())) {
                    if (tgb.f) {
                        Log.d("VoyagerFileProcessor", "Voyager bizType " + ehbVar.a() + " disable.");
                    }
                    return false;
                } else {
                    return true;
                }
            }
            return invokeL.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.c.c == null) {
                    if (tgb.f) {
                        Log.d("VoyagerFileProcessor", "TaskModel not init");
                    }
                } else if (!NetWorkUtils.isConnected(this.c.d)) {
                    if (tgb.f) {
                        Log.d("VoyagerFileProcessor", "network error, won't retry ");
                    }
                } else {
                    ehb i = this.c.c.i();
                    if (i == null) {
                        if (tgb.f) {
                            Log.d("VoyagerFileProcessor", "don't have retry task ");
                            return;
                        }
                        return;
                    }
                    if (!a(i)) {
                        this.c.m(false, i.a(), "component disabled", i.b(), null);
                    }
                    if (!this.a && !this.c.c.b()) {
                        this.c.a.schedule(this, vgb.f().l(), TimeUnit.MILLISECONDS);
                        if (tgb.f) {
                            Log.d("VoyagerFileProcessor", "time error, won't retry ");
                            return;
                        }
                        return;
                    }
                    this.c.c.p();
                    this.c.c.r();
                    xgb.g().c(i, new a(this, i));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jhb a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ tgb e;

        public a(tgb tgbVar, jhb jhbVar, boolean z, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tgbVar, jhbVar, Boolean.valueOf(z), str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = tgbVar;
            this.a = jhbVar;
            this.b = z;
            this.c = str;
            this.d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            jhb jhbVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (jhbVar = this.a) == null) {
                return;
            }
            if (this.b) {
                jhbVar.onSuccess(this.c, this.d);
                this.e.p(false);
                return;
            }
            String str = this.c;
            if (TextUtils.isEmpty(str)) {
                str = IActiveUploadListener.UPLOAD_ERR_MSG;
            }
            this.a.onFailure(str, this.d);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ ehb c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ JSONObject f;
        public final /* synthetic */ tgb g;

        public b(tgb tgbVar, boolean z, boolean z2, ehb ehbVar, long j, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tgbVar, Boolean.valueOf(z), Boolean.valueOf(z2), ehbVar, Long.valueOf(j), str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = tgbVar;
            this.a = z;
            this.b = z2;
            this.c = ehbVar;
            this.d = j;
            this.e = str;
            this.f = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a) {
                    this.g.c.t(this.b, this.c, this.d, this.e);
                    this.g.p(!this.b);
                } else {
                    this.g.c.s(this.b, this.c, this.d);
                }
                this.g.m(this.a, this.c.a(), this.e, this.f, this.c.b());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tgb a;

        public c(tgb tgbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tgbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tgbVar;
        }

        public /* synthetic */ c(tgb tgbVar, a aVar) {
            this(tgbVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !ze1.g()) {
                return;
            }
            this.a.e = new chb();
            if (vgb.f().p()) {
                this.a.c = new fhb(this.a.d, wgb.c);
                this.a.o();
            } else if (vgb.f().o()) {
                this.a.c = new fhb(this.a.d, wgb.d);
            } else {
                this.a.c = new fhb(this.a.d, wgb.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public String b;
        public String c;
        public JSONObject d;
        public JSONObject e;
        public final /* synthetic */ tgb f;

        public e(tgb tgbVar, boolean z, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tgbVar, Boolean.valueOf(z), str, str2, jSONObject, jSONObject2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = tgbVar;
            this.a = z;
            this.b = str;
            this.c = str2;
            this.d = jSONObject;
            this.e = jSONObject2;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<hhb> list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f.e != null && !TextUtils.isEmpty(this.b) && (list = this.f.e.a.getList()) != null && list.size() > 0) {
                for (hhb hhbVar : list) {
                    if (TextUtils.equals(this.b, hhbVar.getBizType())) {
                        hhbVar.onReceiveResult(this.a, this.b, this.c, this.d, this.e);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948181658, "Lcom/baidu/tieba/tgb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948181658, "Lcom/baidu/tieba/tgb;");
                return;
            }
        }
        f = AppConfig.isDebug();
    }

    public static tgb n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (g == null) {
                synchronized (tgb.class) {
                    if (g == null) {
                        g = new tgb();
                    }
                }
            }
            return g;
        }
        return (tgb) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.execute(new d(this));
        }
    }

    public void o() {
        zgb zgbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (zgbVar = (zgb) ServiceManager.getService(zgb.a)) != null) {
            if (f) {
                Log.e("VoyagerFileProcessor", "register retry listener");
            }
            zgbVar.b();
            zgbVar.a();
        }
    }

    public tgb() {
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
        this.d = AppRuntime.getAppContext();
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.a = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.execute(new c(this, null));
        this.b = new ThreadPoolExecutor(1, 1, 600000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.a.execute(new f(this, z));
        }
    }

    public void j(boolean z, String str, JSONObject jSONObject, jhb jhbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, jSONObject, jhbVar}) == null) {
            this.b.execute(new a(this, jhbVar, z, str, jSONObject));
        }
    }

    public final void k(boolean z, boolean z2, ehb ehbVar, long j, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), ehbVar, Long.valueOf(j), str, jSONObject}) == null) {
            this.a.execute(new b(this, z, z2, ehbVar, j, str, jSONObject));
        }
    }

    public void q(List<String> list, String str, long j, int i, int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), jSONObject}) == null) {
            this.a.execute(new d(this, new ArrayList(list), str, j, i, i2, jSONObject));
        }
    }

    public final void m(boolean z, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), str, str2, jSONObject, jSONObject2}) == null) {
            this.b.execute(new e(this, z, str, str2, jSONObject, jSONObject2));
        }
    }

    public void r(List<String> list, String str, long j, int i, jhb jhbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{list, str, Long.valueOf(j), Integer.valueOf(i), jhbVar}) == null) {
            this.a.execute(new d(this, new ArrayList(list), str, j, i, jhbVar));
        }
    }

    public void s(String str, String str2, int i, int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), jSONObject}) == null) {
            this.a.execute(new d(this, str, str2, i, i2, jSONObject));
        }
    }

    public void t(String str, String str2, jhb jhbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, str, str2, jhbVar) == null) {
            this.a.execute(new d(this, str, str2, jhbVar));
        }
    }
}
