package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import com.baidu.mobstat.Config;
import com.baidu.tieba.b00;
import com.baidu.tieba.e00;
import com.baidu.tieba.nx;
import com.baidu.tieba.ux;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class px extends nx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;
    public volatile f d;
    public final Object e;

    /* loaded from: classes7.dex */
    public class a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ px a;

        public a(px pxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pxVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                px pxVar = this.a;
                pxVar.o(pxVar.d);
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ px a;

        public b(px pxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pxVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                px pxVar = this.a;
                pxVar.j(pxVar.d);
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nx.c a;
        public final /* synthetic */ px b;

        public c(px pxVar, nx.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pxVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pxVar;
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.d.h == null) {
                    this.a.a(-1, null, null);
                    return;
                }
                this.a.onResult(this.b.d.h.a(), null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nx.c a;

        public d(px pxVar, nx.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pxVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(-1, null, null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, a> a;

        /* loaded from: classes7.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean a;
            public long b;

            public a(boolean z, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Boolean.valueOf(z), Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = z;
                this.b = j;
            }
        }

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new HashMap();
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.a.get(str) : (a) invokeL.objValue;
        }

        public void b(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, trustSubject) == null) {
                try {
                    String m = trustSubject.m("config-cs");
                    if (TextUtils.isEmpty(m) || (optJSONObject = new JSONObject(m).optJSONObject("cs")) == null) {
                        return;
                    }
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject jSONObject = optJSONObject.getJSONObject(next);
                        this.a.put(next, new a(jSONObject.optBoolean("enable", true), jSONObject.optLong("priority", -1L)));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile f00 a;
        public volatile vx b;
        public volatile TrustSubjectManager c;
        public volatile TrustSubjectManager.d d;
        public volatile Future<Boolean> e;
        public volatile Future<Boolean> f;
        public volatile b00 g;
        public volatile k h;
        public volatile Map<String, ux> i;
        public volatile Map<String, e00> j;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = new HashMap();
            this.j = new HashMap();
        }
    }

    /* loaded from: classes7.dex */
    public static class g<T> implements e00.d<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public nx.c<T> a;

        public g(nx.c<T> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.tieba.e00.d
        public void a(int i, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, exc, bundle) == null) {
                this.a.a(i, exc, bundle);
            }
        }

        @Override // com.baidu.tieba.e00.d
        public void onResult(T t, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, bundle) == null) {
                this.a.onResult(t, bundle);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, a> a;

        /* loaded from: classes7.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean a;

            public a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = z;
            }
        }

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new HashMap();
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.a.get(str) : (a) invokeL.objValue;
        }

        public void b(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, trustSubject) == null) {
                try {
                    String m = trustSubject.m("config-ids");
                    if (TextUtils.isEmpty(m) || (optJSONObject = new JSONObject(m).optJSONObject("ids")) == null) {
                        return;
                    }
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.a.put(next, new a(optJSONObject.getJSONObject(next).optBoolean("enable", true)));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b00.a a;
        public FileOutputStream b;
        public FileLock c;

        public i(b00.a aVar) {
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

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.a();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.a.d("lock"));
                    this.b = fileOutputStream;
                    this.c = fileOutputStream.getChannel().lock();
                    return true;
                } catch (IOException unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, INVOKE, IPUT, IPUT, IF] complete} */
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                FileLock fileLock = this.c;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                        FileOutputStream fileOutputStream = this.b;
                        if (fileOutputStream != null) {
                            wz.b(fileOutputStream);
                            this.b = null;
                        }
                        this.c = null;
                        return true;
                    } catch (IOException unused) {
                        FileOutputStream fileOutputStream2 = this.b;
                        if (fileOutputStream2 != null) {
                            wz.b(fileOutputStream2);
                            this.b = null;
                        }
                        this.c = null;
                        return false;
                    } catch (Throwable th) {
                        FileOutputStream fileOutputStream3 = this.b;
                        if (fileOutputStream3 != null) {
                            wz.b(fileOutputStream3);
                            this.b = null;
                        }
                        this.c = null;
                        throw th;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public long c;

        public j(String str, String str2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = j;
        }
    }

    /* loaded from: classes7.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<j> a;

        public k() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new ArrayList();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONArray jSONArray = new JSONArray();
                try {
                    for (j jVar : this.a) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pkg", jVar.a);
                        jSONObject.put("aid", jVar.b);
                        jSONObject.put("priority", jVar.c);
                        jSONArray.put(jSONObject);
                    }
                } catch (Exception unused) {
                }
                return jSONArray.toString();
            }
            return (String) invokeV.objValue;
        }

        public void b(String str, String str2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Long.valueOf(j)}) == null) {
                this.a.add(new j(str, str2, j));
            }
        }
    }

    public px() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new Object();
    }

    @Override // com.baidu.tieba.nx
    public void a(String str, Bundle bundle, nx.c<String> cVar) {
        ExecutorService executorService;
        Runnable dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            m(str);
            e00 e00Var = this.d.j.get(str);
            if (e00Var != null) {
                e00Var.g(new g(cVar));
                return;
            }
            if (Config.SID.equals(str)) {
                executorService = this.a.d;
                dVar = new c(this, cVar);
            } else {
                executorService = this.a.d;
                dVar = new d(this, cVar);
            }
            executorService.submit(dVar);
        }
    }

    @Override // com.baidu.tieba.nx
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            q();
        }
    }

    @Override // com.baidu.tieba.nx
    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            n();
            List<TrustSubject> list = this.d.d.a;
            if (list != null) {
                for (TrustSubject trustSubject : list) {
                    if (trustSubject.a.equals(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.nx
    public void f(nx.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.c = this.a.c;
            this.d = new f();
            this.d.e = this.a.d.submit(new a(this));
        }
    }

    @Override // com.baidu.tieba.nx
    public nx.d g(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bundle)) == null) {
            m(str);
            e00 e00Var = this.d.j.get(str);
            return e00Var != null ? nx.d.c(e00Var.c()) : nx.d.a(-1, null);
        }
        return (nx.d) invokeLL.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                this.d.e.get();
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            } catch (ExecutionException e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    public final void j(f fVar) {
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            b00 b00Var = new b00(this.c);
            fVar.g = b00Var;
            i iVar = new i(b00Var.d().f("init"));
            try {
                iVar.a();
                TrustSubjectManager.a aVar = new TrustSubjectManager.a();
                aVar.a = this.c;
                aVar.b = b00Var;
                TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
                fVar.c = trustSubjectManager;
                trustSubjectManager.f(aVar);
                trustSubjectManager.i(new TrustSubjectManager.b());
                fVar.d = trustSubjectManager.j(new TrustSubjectManager.c());
                if (fVar.a == null) {
                    fVar.a = new f00(this.a.a);
                }
                f00 f00Var = fVar.a;
                e00.b bVar = new e00.b();
                bVar.a = this.c;
                bVar.b = b00Var;
                bVar.c = fVar.d;
                bVar.d = this.a.d;
                bVar.e = this.a.e;
                e00.c cVar = new e00.c();
                cVar.a = false;
                List<e00> b2 = f00Var.b();
                ArrayList<e00> arrayList = b2 == null ? new ArrayList() : new ArrayList(b2);
                if (fVar.d.b != null) {
                    hVar = new h();
                    hVar.b(fVar.d.b);
                } else {
                    hVar = null;
                }
                if (arrayList.size() > 0 && hVar != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        h.a a2 = hVar.a(((e00) it.next()).e());
                        if (a2 != null && !a2.a) {
                            it.remove();
                        }
                    }
                }
                for (e00 e00Var : arrayList) {
                    fVar.j.put(e00Var.e(), e00Var);
                    e00Var.a(bVar);
                    e00Var.f(cVar);
                }
                vx vxVar = new vx(this.a.b);
                fVar.b = vxVar;
                ux.b bVar2 = new ux.b();
                bVar2.a = this.c;
                bVar2.c = f00Var;
                bVar2.b = b00Var;
                List<ux> a3 = vxVar.a();
                ArrayList arrayList2 = a3 == null ? new ArrayList() : new ArrayList(a3);
                if (arrayList2.size() > 0 && fVar.d.b != null) {
                    e eVar = new e();
                    eVar.b(fVar.d.b);
                    Iterator<ux> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ux next = it2.next();
                        e.a a4 = eVar.a(next.c());
                        if (a4 != null) {
                            if (!a4.a) {
                                it2.remove();
                            } else if (a4.b > -1) {
                                next.g(a4.b);
                            }
                        }
                    }
                }
                Collections.sort(arrayList2, ux.e);
                ux.d dVar = new ux.d();
                ux.e eVar2 = new ux.e();
                for (ux uxVar : arrayList2) {
                    fVar.i.put(uxVar.c(), uxVar);
                    uxVar.a(bVar2);
                    uxVar.e(dVar);
                    uxVar.f(eVar2);
                }
                h.a a5 = hVar != null ? hVar.a(Config.SID) : null;
                if (a5 == null || a5.a) {
                    k(fVar, arrayList2);
                }
            } finally {
                iVar.b();
            }
        }
    }

    public final void k(f fVar, List<ux> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, fVar, list) == null) {
            List<TrustSubject> list2 = fVar.d.a;
            ux.g gVar = new ux.g();
            gVar.a = true;
            fVar.h = new k();
            if (list2 != null) {
                for (TrustSubject trustSubject : list2) {
                    Iterator<ux> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ux.h b2 = it.next().b(trustSubject.a, gVar);
                        if (b2 != null && b2.e()) {
                            fVar.h.b(trustSubject.a, b2.a, trustSubject.o());
                            break;
                        }
                    }
                }
            }
        }
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (TextUtils.equals(str, "iid")) {
                i();
            } else {
                n();
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                q();
                this.d.f.get();
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            } catch (ExecutionException e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    public final void o(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            b00 b00Var = new b00(this.c);
            fVar.g = b00Var;
            i iVar = new i(b00Var.d().f("init"));
            try {
                iVar.a();
                f00 f00Var = new f00(this.a.a);
                fVar.a = f00Var;
                e00 a2 = f00Var.a("iid");
                e00.b bVar = new e00.b();
                bVar.a = this.c;
                bVar.b = b00Var;
                bVar.d = this.a.d;
                bVar.e = this.a.e;
                e00.c cVar = new e00.c();
                cVar.a = false;
                fVar.j.put(a2.e(), a2);
                a2.a(bVar);
                a2.f(cVar);
            } finally {
                iVar.b();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this.e) {
                if (this.d.f != null) {
                    return;
                }
                this.d.f = this.a.d.submit(new b(this));
            }
        }
    }
}
