package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import com.baidu.mobstat.Config;
import com.baidu.tieba.d60;
import com.baidu.tieba.g60;
import com.baidu.tieba.p30;
import com.baidu.tieba.w30;
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
public class r30 extends p30 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;
    public volatile f d;
    public final Object e;

    /* loaded from: classes7.dex */
    public class a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r30 a;

        public a(r30 r30Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r30Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r30Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                r30 r30Var = this.a;
                r30Var.o(r30Var.d);
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r30 a;

        public b(r30 r30Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r30Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r30Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                r30 r30Var = this.a;
                r30Var.j(r30Var.d);
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p30.c a;
        public final /* synthetic */ r30 b;

        public c(r30 r30Var, p30.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r30Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r30Var;
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
        public final /* synthetic */ p30.c a;

        public d(r30 r30Var, p30.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r30Var, cVar};
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
        public volatile h60 a;
        public volatile x30 b;
        public volatile TrustSubjectManager c;
        public volatile TrustSubjectManager.d d;
        public volatile Future<Boolean> e;
        public volatile Future<Boolean> f;
        public volatile d60 g;
        public volatile k h;
        public volatile Map<String, w30> i;
        public volatile Map<String, g60> j;

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
    public static class g<T> implements g60.d<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public p30.c<T> a;

        public g(p30.c<T> cVar) {
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

        @Override // com.baidu.tieba.g60.d
        public void a(int i, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, exc, bundle) == null) {
                this.a.a(i, exc, bundle);
            }
        }

        @Override // com.baidu.tieba.g60.d
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
        public d60.a a;
        public FileOutputStream b;
        public FileLock c;

        public i(d60.a aVar) {
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
                            y50.b(fileOutputStream);
                            this.b = null;
                        }
                        this.c = null;
                        return true;
                    } catch (IOException unused) {
                        FileOutputStream fileOutputStream2 = this.b;
                        if (fileOutputStream2 != null) {
                            y50.b(fileOutputStream2);
                            this.b = null;
                        }
                        this.c = null;
                        return false;
                    } catch (Throwable th) {
                        FileOutputStream fileOutputStream3 = this.b;
                        if (fileOutputStream3 != null) {
                            y50.b(fileOutputStream3);
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

    public r30() {
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

    @Override // com.baidu.tieba.p30
    public void a(String str, Bundle bundle, p30.c<String> cVar) {
        ExecutorService executorService;
        Runnable dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            m(str);
            g60 g60Var = this.d.j.get(str);
            if (g60Var != null) {
                g60Var.g(new g(cVar));
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

    @Override // com.baidu.tieba.p30
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            q();
        }
    }

    @Override // com.baidu.tieba.p30
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

    @Override // com.baidu.tieba.p30
    public void f(p30.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.c = this.a.c;
            this.d = new f();
            this.d.e = this.a.d.submit(new a(this));
        }
    }

    @Override // com.baidu.tieba.p30
    public p30.d g(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bundle)) == null) {
            m(str);
            g60 g60Var = this.d.j.get(str);
            return g60Var != null ? p30.d.c(g60Var.c()) : p30.d.a(-1, null);
        }
        return (p30.d) invokeLL.objValue;
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
            d60 d60Var = new d60(this.c);
            fVar.g = d60Var;
            i iVar = new i(d60Var.d().f("init"));
            try {
                iVar.a();
                TrustSubjectManager.a aVar = new TrustSubjectManager.a();
                aVar.a = this.c;
                aVar.b = d60Var;
                TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
                fVar.c = trustSubjectManager;
                trustSubjectManager.f(aVar);
                trustSubjectManager.i(new TrustSubjectManager.b());
                fVar.d = trustSubjectManager.query(new TrustSubjectManager.c());
                if (fVar.a == null) {
                    fVar.a = new h60(this.a.a);
                }
                h60 h60Var = fVar.a;
                g60.b bVar = new g60.b();
                bVar.a = this.c;
                bVar.b = d60Var;
                bVar.c = fVar.d;
                bVar.d = this.a.d;
                bVar.e = this.a.e;
                g60.c cVar = new g60.c();
                cVar.a = false;
                List<g60> b2 = h60Var.b();
                ArrayList<g60> arrayList = b2 == null ? new ArrayList() : new ArrayList(b2);
                if (fVar.d.b != null) {
                    hVar = new h();
                    hVar.b(fVar.d.b);
                } else {
                    hVar = null;
                }
                if (arrayList.size() > 0 && hVar != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        h.a a2 = hVar.a(((g60) it.next()).e());
                        if (a2 != null && !a2.a) {
                            it.remove();
                        }
                    }
                }
                for (g60 g60Var : arrayList) {
                    fVar.j.put(g60Var.e(), g60Var);
                    g60Var.a(bVar);
                    g60Var.f(cVar);
                }
                x30 x30Var = new x30(this.a.b);
                fVar.b = x30Var;
                w30.b bVar2 = new w30.b();
                bVar2.a = this.c;
                bVar2.c = h60Var;
                bVar2.b = d60Var;
                List<w30> a3 = x30Var.a();
                ArrayList arrayList2 = a3 == null ? new ArrayList() : new ArrayList(a3);
                if (arrayList2.size() > 0 && fVar.d.b != null) {
                    e eVar = new e();
                    eVar.b(fVar.d.b);
                    Iterator<w30> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        w30 next = it2.next();
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
                Collections.sort(arrayList2, w30.e);
                w30.d dVar = new w30.d();
                w30.e eVar2 = new w30.e();
                for (w30 w30Var : arrayList2) {
                    fVar.i.put(w30Var.c(), w30Var);
                    w30Var.a(bVar2);
                    w30Var.e(dVar);
                    w30Var.f(eVar2);
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

    public final void k(f fVar, List<w30> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, fVar, list) == null) {
            List<TrustSubject> list2 = fVar.d.a;
            w30.g gVar = new w30.g();
            gVar.a = true;
            fVar.h = new k();
            if (list2 != null) {
                for (TrustSubject trustSubject : list2) {
                    Iterator<w30> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        w30.h b2 = it.next().b(trustSubject.a, gVar);
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
            d60 d60Var = new d60(this.c);
            fVar.g = d60Var;
            i iVar = new i(d60Var.d().f("init"));
            try {
                iVar.a();
                h60 h60Var = new h60(this.a.a);
                fVar.a = h60Var;
                g60 a2 = h60Var.a("iid");
                g60.b bVar = new g60.b();
                bVar.a = this.c;
                bVar.b = d60Var;
                bVar.d = this.a.d;
                bVar.e = this.a.e;
                g60.c cVar = new g60.c();
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
