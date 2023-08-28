package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ne;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class y0a implements j1a, l1a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y0a h;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference<ne<String>> a;
    public AtomicReference<ne<String>> b;
    public HashMap<String, d1a> c;
    public int d;
    public String e;
    public boolean f;
    public boolean g;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y0a a;

        /* renamed from: com.baidu.tieba.y0a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0534a implements ne.a<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0534a(a aVar) {
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

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ne.a
            /* renamed from: b */
            public void a(String str, String str2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && !TextUtils.isEmpty(str2)) {
                    Iterator it = this.a.a.q(str2).iterator();
                    while (it.hasNext()) {
                        d1a d1aVar = (d1a) it.next();
                        if (d1aVar != null) {
                            this.a.a.c.put(d1aVar.a, d1aVar);
                            this.a.a.f = true;
                        }
                    }
                }
            }
        }

        public a(y0a y0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y0aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ne neVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (neVar = (ne) this.a.a.get()) == null) {
                return;
            }
            neVar.f(this.a.e, new C0534a(this));
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y0a a;

        /* loaded from: classes8.dex */
        public class a implements ne.a<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ne.a
            /* renamed from: b */
            public void a(String str, String str2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && !TextUtils.isEmpty(str2)) {
                    try {
                        this.a.a.d = Integer.parseInt(str2);
                    } catch (NumberFormatException unused) {
                        this.a.a.d = 0;
                    }
                    this.a.a.g = true;
                }
            }
        }

        public b(y0a y0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y0aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((ne) this.a.b.get()).f(this.a.e, new a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicReference<ne<String>> a;
        public final String b;
        public final Runnable c;

        public c(AtomicReference<ne<String>> atomicReference, String str, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atomicReference, str, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atomicReference;
            this.b = str;
            this.c = runnable;
            setPriority(4);
        }

        public /* synthetic */ c(AtomicReference atomicReference, String str, Runnable runnable, a aVar) {
            this(atomicReference, str, runnable);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
                super.onPostExecute(r5);
                Runnable runnable = this.c;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voidArr)) == null) {
                if (this.a.get() != null) {
                    return null;
                }
                synchronized (c.class) {
                    if (this.a.get() == null) {
                        AtomicReference<ne<String>> atomicReference = this.a;
                        r45.k();
                        atomicReference.set(r45.l(this.b));
                    }
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    public y0a() {
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
        this.a = new AtomicReference<>(null);
        this.b = new AtomicReference<>(null);
        this.f = false;
        this.g = false;
        this.c = new HashMap<>();
        this.d = 0;
        this.e = r();
    }

    public final boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (!TextUtils.isEmpty(this.e)) {
                return this.e.equals(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.j1a
    public int d(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            return s(str, true, z);
        }
        return invokeLZ.intValue;
    }

    @Override // com.baidu.tieba.j1a
    public int e(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            return s(str, false, z);
        }
        return invokeLZ.intValue;
    }

    public static y0a t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (h == null) {
                synchronized (y0a.class) {
                    if (h == null) {
                        h = new y0a();
                    }
                }
            }
            return h;
        }
        return (y0a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l1a
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!v(r())) {
                return 0;
            }
            return this.d;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.l1a
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.g) {
            return;
        }
        b bVar = new b(this);
        if (this.b.get() == null) {
            new c(this.b, "hot.splash.count", bVar, null).execute(new Void[0]);
        }
    }

    @Override // com.baidu.tieba.j1a
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.f) {
            return;
        }
        a aVar = new a(this);
        if (this.a.get() == null) {
            new c(this.a, "frs.refresh.count", aVar, null).execute(new Void[0]);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            String r = r();
            if (!v(r)) {
                this.c.clear();
                this.d = 0;
                this.e = r;
            }
        }
    }

    public final String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l1a
    public void b() {
        ne<String> neVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (neVar = this.b.get()) == null) {
            return;
        }
        p();
        this.d++;
        System.out.println("TestTest => mCachedHotSplashCount: " + this.d);
        neVar.i(this.e, Integer.toString(this.d), 86400000L);
    }

    @Override // com.baidu.tieba.j1a
    public void g(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i == 1) {
                u(str, true, z);
            } else if (i == 2) {
                u(str, false, z);
            }
        }
    }

    public final int s(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            d1a d1aVar = this.c.get(str);
            if (d1aVar != null && v(r())) {
                return d1aVar.b(z, z2);
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public final ArrayList<d1a> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            ArrayList<d1a> arrayList = new ArrayList<>();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new d1a(jSONArray.optJSONObject(i)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void u(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            p();
            d1a d1aVar = this.c.get(str);
            if (d1aVar == null) {
                d1aVar = new d1a();
                d1aVar.a = str;
                this.c.put(str, d1aVar);
            }
            d1aVar.a(z, z2);
            w(this.c);
        }
    }

    public final synchronized void w(HashMap<String, d1a> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, hashMap) == null) {
            synchronized (this) {
                ne<String> neVar = this.a.get();
                if (neVar == null) {
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, d1a> entry : hashMap.entrySet()) {
                    JSONObject c2 = entry.getValue().c();
                    if (c2 != null) {
                        jSONArray.put(c2);
                    }
                }
                neVar.i(this.e, jSONArray.toString(), 86400000L);
            }
        }
    }
}
