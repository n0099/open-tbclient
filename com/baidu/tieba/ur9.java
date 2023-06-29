package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.xe;
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
public class ur9 implements fs9, hs9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ur9 h;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference<xe<String>> a;
    public AtomicReference<xe<String>> b;
    public HashMap<String, zr9> c;
    public int d;
    public String e;
    public boolean f;
    public boolean g;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ur9 a;

        /* renamed from: com.baidu.tieba.ur9$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0484a implements xe.a<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0484a(a aVar) {
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
            @Override // com.baidu.tieba.xe.a
            /* renamed from: b */
            public void a(String str, String str2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && !TextUtils.isEmpty(str2)) {
                    Iterator it = this.a.a.q(str2).iterator();
                    while (it.hasNext()) {
                        zr9 zr9Var = (zr9) it.next();
                        if (zr9Var != null) {
                            this.a.a.c.put(zr9Var.a, zr9Var);
                            this.a.a.f = true;
                        }
                    }
                }
            }
        }

        public a(ur9 ur9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ur9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ur9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            xe xeVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (xeVar = (xe) this.a.a.get()) == null) {
                return;
            }
            xeVar.f(this.a.e, new C0484a(this));
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ur9 a;

        /* loaded from: classes8.dex */
        public class a implements xe.a<String> {
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
            @Override // com.baidu.tieba.xe.a
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

        public b(ur9 ur9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ur9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ur9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((xe) this.a.b.get()).f(this.a.e, new a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicReference<xe<String>> a;
        public final String b;
        public final Runnable c;

        public c(AtomicReference<xe<String>> atomicReference, String str, Runnable runnable) {
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
                        AtomicReference<xe<String>> atomicReference = this.a;
                        f55.d();
                        atomicReference.set(f55.e(this.b));
                    }
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    public ur9() {
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

    @Override // com.baidu.tieba.fs9
    public int d(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            return s(str, true, z);
        }
        return invokeLZ.intValue;
    }

    @Override // com.baidu.tieba.fs9
    public int e(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            return s(str, false, z);
        }
        return invokeLZ.intValue;
    }

    public static ur9 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (h == null) {
                synchronized (ur9.class) {
                    if (h == null) {
                        h = new ur9();
                    }
                }
            }
            return h;
        }
        return (ur9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hs9
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

    @Override // com.baidu.tieba.hs9
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

    @Override // com.baidu.tieba.fs9
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

    @Override // com.baidu.tieba.hs9
    public void b() {
        xe<String> xeVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (xeVar = this.b.get()) == null) {
            return;
        }
        p();
        this.d++;
        System.out.println("TestTest => mCachedHotSplashCount: " + this.d);
        xeVar.i(this.e, Integer.toString(this.d), 86400000L);
    }

    @Override // com.baidu.tieba.fs9
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
            zr9 zr9Var = this.c.get(str);
            if (zr9Var != null && v(r())) {
                return zr9Var.b(z, z2);
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public final ArrayList<zr9> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            ArrayList<zr9> arrayList = new ArrayList<>();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new zr9(jSONArray.optJSONObject(i)));
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
            zr9 zr9Var = this.c.get(str);
            if (zr9Var == null) {
                zr9Var = new zr9();
                zr9Var.a = str;
                this.c.put(str, zr9Var);
            }
            zr9Var.a(z, z2);
            w(this.c);
        }
    }

    public final synchronized void w(HashMap<String, zr9> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, hashMap) == null) {
            synchronized (this) {
                xe<String> xeVar = this.a.get();
                if (xeVar == null) {
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, zr9> entry : hashMap.entrySet()) {
                    JSONObject c2 = entry.getValue().c();
                    if (c2 != null) {
                        jSONArray.put(c2);
                    }
                }
                xeVar.i(this.e, jSONArray.toString(), 86400000L);
            }
        }
    }
}
