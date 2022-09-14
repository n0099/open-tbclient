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
import com.baidu.tieba.fi9;
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
/* loaded from: classes6.dex */
public class th9 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile th9 g;
    public transient /* synthetic */ FieldHolder $fh;
    public ScheduledExecutorService a;
    public ExecutorService b;
    public gi9 c;
    public Context d;
    public ci9 e;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ki9 a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ th9 e;

        public a(th9 th9Var, ki9 ki9Var, boolean z, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th9Var, ki9Var, Boolean.valueOf(z), str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = th9Var;
            this.a = ki9Var;
            this.b = z;
            this.c = str;
            this.d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            ki9 ki9Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (ki9Var = this.a) == null) {
                return;
            }
            if (this.b) {
                ki9Var.onSuccess(this.c, this.d);
                this.e.o(false);
                return;
            }
            String str = this.c;
            if (TextUtils.isEmpty(str)) {
                str = IActiveUploadListener.UPLOAD_ERR_MSG;
            }
            this.a.onFailure(str, this.d);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ fi9 c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ JSONObject f;
        public final /* synthetic */ th9 g;

        public b(th9 th9Var, boolean z, boolean z2, fi9 fi9Var, long j, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th9Var, Boolean.valueOf(z), Boolean.valueOf(z2), fi9Var, Long.valueOf(j), str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = th9Var;
            this.a = z;
            this.b = z2;
            this.c = fi9Var;
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
                    this.g.o(!this.b);
                } else {
                    this.g.c.s(this.b, this.c, this.d);
                }
                this.g.l(this.a, this.c.a(), this.e, this.f, this.c.b());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ th9 a;

        public c(th9 th9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = th9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && he1.g()) {
                this.a.e = new ci9();
                if (vh9.f().p()) {
                    this.a.c = new gi9(this.a.d, wh9.c);
                    this.a.n();
                } else if (vh9.f().o()) {
                    this.a.c = new gi9(this.a.d, wh9.d);
                } else {
                    this.a.c = new gi9(this.a.d, wh9.c);
                }
            }
        }

        public /* synthetic */ c(th9 th9Var, a aVar) {
            this(th9Var);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public String b;
        public String c;
        public JSONObject d;
        public JSONObject e;
        public final /* synthetic */ th9 f;

        public e(th9 th9Var, boolean z, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th9Var, Boolean.valueOf(z), str, str2, jSONObject, jSONObject2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = th9Var;
            this.a = z;
            this.b = str;
            this.c = str2;
            this.d = jSONObject;
            this.e = jSONObject2;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<ii9> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f.e == null || TextUtils.isEmpty(this.b) || (list = this.f.e.a.getList()) == null || list.size() <= 0) {
                return;
            }
            for (ii9 ii9Var : list) {
                if (TextUtils.equals(this.b, ii9Var.getBizType())) {
                    ii9Var.onReceiveResult(this.a, this.b, this.c, this.d, this.e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public long b;
        public final /* synthetic */ th9 c;

        /* loaded from: classes6.dex */
        public class a implements ai9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ fi9 a;
            public final /* synthetic */ f b;

            public a(f fVar, fi9 fi9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, fi9Var};
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
                this.a = fi9Var;
            }

            @Override // com.baidu.tieba.ai9
            public void a(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
                    this.b.c.c.m(true, this.a);
                    this.b.c.l(false, this.a.a(), "dir not found", jSONObject, this.a.b());
                }
            }

            @Override // com.baidu.tieba.ai9
            public void b(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) {
                    this.b.c.c.u(true, this.a);
                    this.b.c.l(false, this.a.a(), "zip failed", jSONObject, this.a.b());
                }
            }

            @Override // com.baidu.tieba.ai9
            public void c(String str, int i, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, str, i, str2, jSONObject) == null) {
                    f fVar = this.b;
                    fVar.c.k(false, true, this.a, fVar.b, str2, jSONObject);
                }
            }

            @Override // com.baidu.tieba.ai9
            public void d(String str, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, jSONObject) == null) {
                    f fVar = this.b;
                    fVar.c.k(true, true, this.a, fVar.b, str2, jSONObject);
                }
            }
        }

        public f(th9 th9Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th9Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = th9Var;
            this.a = z;
        }

        public final boolean a(fi9 fi9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fi9Var)) == null) {
                if (!vh9.f().p()) {
                    if (th9.f) {
                        Log.d("VoyagerFileProcessor", "Voyager component disable.");
                    }
                    return false;
                } else if (vh9.f().a(fi9Var.a())) {
                    return true;
                } else {
                    if (th9.f) {
                        Log.d("VoyagerFileProcessor", "Voyager bizType " + fi9Var.a() + " disable.");
                    }
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.c.c == null) {
                    if (th9.f) {
                        Log.d("VoyagerFileProcessor", "TaskModel not init");
                    }
                } else if (!NetWorkUtils.isConnected(this.c.d)) {
                    if (th9.f) {
                        Log.d("VoyagerFileProcessor", "network error, won't retry ");
                    }
                } else {
                    fi9 i = this.c.c.i();
                    if (i == null) {
                        if (th9.f) {
                            Log.d("VoyagerFileProcessor", "don't have retry task ");
                            return;
                        }
                        return;
                    }
                    if (!a(i)) {
                        this.c.l(false, i.a(), "component disabled", i.b(), null);
                    }
                    if (this.a || this.c.c.b()) {
                        this.c.c.p();
                        this.c.c.r();
                        xh9.g().c(i, new a(this, i));
                        return;
                    }
                    this.c.a.schedule(this, vh9.f().l(), TimeUnit.MILLISECONDS);
                    if (th9.f) {
                        Log.d("VoyagerFileProcessor", "time error, won't retry ");
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948181348, "Lcom/baidu/tieba/th9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948181348, "Lcom/baidu/tieba/th9;");
                return;
            }
        }
        f = AppConfig.isDebug();
    }

    public th9() {
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

    public static th9 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (g == null) {
                synchronized (th9.class) {
                    if (g == null) {
                        g = new th9();
                    }
                }
            }
            return g;
        }
        return (th9) invokeV.objValue;
    }

    public void j(boolean z, String str, JSONObject jSONObject, ki9 ki9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, jSONObject, ki9Var}) == null) {
            this.b.execute(new a(this, ki9Var, z, str, jSONObject));
        }
    }

    public final void k(boolean z, boolean z2, fi9 fi9Var, long j, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), fi9Var, Long.valueOf(j), str, jSONObject}) == null) {
            this.a.execute(new b(this, z, z2, fi9Var, j, str, jSONObject));
        }
    }

    public final void l(boolean z, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, str2, jSONObject, jSONObject2}) == null) {
            this.b.execute(new e(this, z, str, str2, jSONObject, jSONObject2));
        }
    }

    public void n() {
        zh9 zh9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (zh9Var = (zh9) ServiceManager.getService(zh9.a)) == null) {
            return;
        }
        if (f) {
            Log.e("VoyagerFileProcessor", "register retry listener");
        }
        zh9Var.b();
        zh9Var.a();
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.a.execute(new f(this, z));
        }
    }

    public void p(List<String> list, String str, long j, int i, int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{list, str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), jSONObject}) == null) {
            this.a.execute(new d(this, new ArrayList(list), str, j, i, i2, jSONObject));
        }
    }

    public void q(List<String> list, String str, long j, int i, ki9 ki9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, str, Long.valueOf(j), Integer.valueOf(i), ki9Var}) == null) {
            this.a.execute(new d(this, new ArrayList(list), str, j, i, ki9Var));
        }
    }

    public void r(String str, String str2, int i, int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), jSONObject}) == null) {
            this.a.execute(new d(this, str, str2, i, i2, jSONObject));
        }
    }

    public void s(String str, String str2, ki9 ki9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, ki9Var) == null) {
            this.a.execute(new d(this, str, str2, ki9Var));
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public fi9 a;
        public long b;
        public boolean c;
        public ki9 d;
        public final /* synthetic */ th9 e;

        /* loaded from: classes6.dex */
        public class a implements ai9 {
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

            @Override // com.baidu.tieba.ai9
            public void a(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
                    if (this.a.c) {
                        this.a.e.c.m(false, this.a.a);
                        d dVar = this.a;
                        dVar.e.l(false, dVar.a.a(), "dir not found", this.a.a.b(), null);
                    } else if (this.a.d != null) {
                        d dVar2 = this.a;
                        dVar2.e.j(false, "dir not found", dVar2.a.c(), this.a.d);
                    }
                }
            }

            @Override // com.baidu.tieba.ai9
            public void b(String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) {
                    this.a.a.n(jSONObject);
                    if (this.a.c) {
                        this.a.e.c.u(false, this.a.a);
                        d dVar = this.a;
                        dVar.e.l(false, dVar.a.a(), "zip failed", this.a.a.b(), null);
                    } else if (this.a.d != null) {
                        d dVar2 = this.a;
                        dVar2.e.j(false, "zip failed", dVar2.a.c(), this.a.d);
                    }
                }
            }

            @Override // com.baidu.tieba.ai9
            public void c(String str, int i, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, str, i, str2, jSONObject) == null) {
                    if (!this.a.c) {
                        if (this.a.d != null) {
                            d dVar = this.a;
                            dVar.e.j(false, str2, jSONObject, dVar.d);
                            return;
                        }
                        return;
                    }
                    d dVar2 = this.a;
                    dVar2.e.k(false, false, dVar2.a, this.a.b, str2, jSONObject);
                }
            }

            @Override // com.baidu.tieba.ai9
            public void d(String str, String str2, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, jSONObject) == null) {
                    if (!this.a.c) {
                        if (this.a.d != null) {
                            d dVar = this.a;
                            dVar.e.j(true, str2, jSONObject, dVar.d);
                            return;
                        }
                        return;
                    }
                    d dVar2 = this.a;
                    dVar2.e.k(true, false, dVar2.a, this.a.b, str2, jSONObject);
                }
            }
        }

        public d(th9 th9Var, ArrayList<String> arrayList, String str, long j, int i, int i2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th9Var, arrayList, str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), jSONObject};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.e = th9Var;
            fi9.b bVar = new fi9.b(str, arrayList);
            bVar.o(i);
            bVar.l(jSONObject);
            bVar.m(j);
            bVar.p(true);
            bVar.n(i2);
            this.a = bVar.k();
            this.c = true;
        }

        public final boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!vh9.f().p()) {
                    if (th9.f) {
                        Log.d("VoyagerFileProcessor", "Voyager component disable.");
                    }
                    if (vh9.f().o()) {
                        this.e.c.c();
                    }
                    return false;
                } else if (vh9.f().a(this.a.a())) {
                    return true;
                } else {
                    if (th9.f) {
                        Log.d("VoyagerFileProcessor", "Voyager bizType " + this.a.a() + " disable.");
                    }
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                xh9.g().d(this.a, new a(this));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (!e()) {
                    if (this.c) {
                        this.e.l(false, this.a.a(), "component disabled", this.a.b(), null);
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

        public d(th9 th9Var, ArrayList<String> arrayList, String str, long j, int i, ki9 ki9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th9Var, arrayList, str, Long.valueOf(j), Integer.valueOf(i), ki9Var};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.e = th9Var;
            fi9.b bVar = new fi9.b(str, arrayList);
            bVar.m(j);
            bVar.n(i);
            bVar.p(true);
            this.a = bVar.k();
            this.d = ki9Var;
        }

        public d(th9 th9Var, String str, String str2, ki9 ki9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th9Var, str, str2, ki9Var};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.e = th9Var;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            fi9.b bVar = new fi9.b(str2, arrayList);
            bVar.p(false);
            this.a = bVar.k();
            this.d = ki9Var;
        }

        public d(th9 th9Var, String str, String str2, int i, int i2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th9Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = th9Var;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            fi9.b bVar = new fi9.b(str2, arrayList);
            bVar.p(false);
            bVar.o(i);
            bVar.n(i2);
            bVar.l(jSONObject);
            this.a = bVar.k();
            this.c = true;
        }
    }
}
