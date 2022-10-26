package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.kf;
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
/* loaded from: classes6.dex */
public class td8 implements ee8, ge8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile td8 h;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference a;
    public AtomicReference b;
    public HashMap c;
    public int d;
    public String e;
    public boolean f;
    public boolean g;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ td8 a;

        /* renamed from: com.baidu.tieba.td8$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0408a implements kf.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0408a(a aVar) {
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
            @Override // com.baidu.tieba.kf.a
            /* renamed from: b */
            public void a(String str, String str2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && !TextUtils.isEmpty(str2)) {
                    Iterator it = this.a.a.q(str2).iterator();
                    while (it.hasNext()) {
                        yd8 yd8Var = (yd8) it.next();
                        if (yd8Var != null) {
                            this.a.a.c.put(yd8Var.a, yd8Var);
                            this.a.a.f = true;
                        }
                    }
                }
            }
        }

        public a(td8 td8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {td8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = td8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            kf kfVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (kfVar = (kf) this.a.a.get()) == null) {
                return;
            }
            kfVar.f(this.a.e, new C0408a(this));
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ td8 a;

        /* loaded from: classes6.dex */
        public class a implements kf.a {
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
            @Override // com.baidu.tieba.kf.a
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

        public b(td8 td8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {td8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = td8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((kf) this.a.b.get()).f(this.a.e, new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class c extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicReference a;
        public final String b;
        public final Runnable c;

        public c(AtomicReference atomicReference, String str, Runnable runnable) {
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
                        AtomicReference atomicReference = this.a;
                        ou4.f();
                        atomicReference.set(ou4.g(this.b));
                    }
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    public td8() {
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
        this.a = new AtomicReference(null);
        this.b = new AtomicReference(null);
        this.f = false;
        this.g = false;
        this.c = new HashMap();
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

    @Override // com.baidu.tieba.ee8
    public int d(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            return s(str, true, z);
        }
        return invokeLZ.intValue;
    }

    @Override // com.baidu.tieba.ee8
    public int e(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            return s(str, false, z);
        }
        return invokeLZ.intValue;
    }

    public static td8 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (h == null) {
                synchronized (td8.class) {
                    if (h == null) {
                        h = new td8();
                    }
                }
            }
            return h;
        }
        return (td8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ge8
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

    @Override // com.baidu.tieba.ge8
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

    @Override // com.baidu.tieba.ee8
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

    @Override // com.baidu.tieba.ge8
    public void b() {
        kf kfVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (kfVar = (kf) this.b.get()) == null) {
            return;
        }
        p();
        this.d++;
        System.out.println("TestTest => mCachedHotSplashCount: " + this.d);
        kfVar.i(this.e, Integer.toString(this.d), 86400000L);
    }

    @Override // com.baidu.tieba.ee8
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
            yd8 yd8Var = (yd8) this.c.get(str);
            if (yd8Var != null && v(r())) {
                return yd8Var.b(z, z2);
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public final ArrayList q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new yd8(jSONArray.optJSONObject(i)));
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
            yd8 yd8Var = (yd8) this.c.get(str);
            if (yd8Var == null) {
                yd8Var = new yd8();
                yd8Var.a = str;
                this.c.put(str, yd8Var);
            }
            yd8Var.a(z, z2);
            w(this.c);
        }
    }

    public final synchronized void w(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, hashMap) == null) {
            synchronized (this) {
                kf kfVar = (kf) this.a.get();
                if (kfVar == null) {
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry entry : hashMap.entrySet()) {
                    JSONObject c2 = ((yd8) entry.getValue()).c();
                    if (c2 != null) {
                        jSONArray.put(c2);
                    }
                }
                kfVar.i(this.e, jSONArray.toString(), 86400000L);
            }
        }
    }
}
