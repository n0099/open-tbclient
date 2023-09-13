package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.scheduler.ElasticTaskScheduler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class u8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u8 h;
    public transient /* synthetic */ FieldHolder $fh;
    public d20 a;
    public Context b;
    public volatile int c;
    public AtomicReference<HashMap<String, c9>>[] d;
    public Object e;
    public AtomicReference<HashMap<String, t8>> f;
    public Object g;

    @Deprecated
    public void i(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ u8 c;

        public a(u8 u8Var, List list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u8Var, list, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u8Var;
            this.a = list;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HashMap[] hashMapArr = new HashMap[this.c.c];
                for (c9 c9Var : this.a) {
                    int a = m20.a(c9Var.a(), this.c.c);
                    if (hashMapArr[a] == null) {
                        hashMapArr[a] = new HashMap();
                    }
                    hashMapArr[a].put(c9Var.a(), c9Var);
                }
                for (int i = 0; i < this.c.c; i++) {
                    if (hashMapArr[i] != null) {
                        ArrayList arrayList = new ArrayList(hashMapArr[i].values());
                        if (this.c.d[i].get() == null) {
                            this.c.B(i);
                        }
                        this.c.C(arrayList, i, this.b);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ u8 b;

        public b(u8 u8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u8Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u8Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.f.get() == null) {
                    this.b.A();
                }
                HashMap hashMap = new HashMap((Map) this.b.f.get());
                for (t8 t8Var : this.a) {
                    hashMap.put(t8Var.c() + "_" + t8Var.b(), t8Var);
                }
                this.b.f.set(hashMap);
                if (AppConfig.isDebug()) {
                    Log.d("ExperimentManager", "updateAddExpInfo mExpInfoRef updated size>> " + ((HashMap) this.b.f.get()).size());
                }
            }
        }
    }

    public u8(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = context.getApplicationContext();
        this.c = e9.b().a();
        this.a = new d20(this.b);
        y();
    }

    public boolean z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
            if (this.f.get() != null && this.f.get().size() > 0) {
                for (t8 t8Var : this.f.get().values()) {
                    if (t8Var.c() == i) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static u8 n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (h == null) {
                synchronized (u8.class) {
                    if (h == null) {
                        h = new u8(context);
                    }
                }
            }
            return h;
        }
        return (u8) invokeL.objValue;
    }

    public final int E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode < 0) {
                hashCode = -hashCode;
            }
            return hashCode % this.c;
        }
        return invokeL.intValue;
    }

    public void F(List<t8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && list != null && list.size() > 0) {
            ElasticTaskScheduler.getInstance().postSerialTask(new b(this, list), "updateAddExpInfo", 3);
        }
    }

    public Object u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            c9 t = t(str);
            if (t != null) {
                return t.b();
            }
            return null;
        }
        return invokeL.objValue;
    }

    public boolean w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            if (u(str) != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void G(List<c9> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048582, this, list, z) == null) && list != null && list.size() > 0) {
            ElasticTaskScheduler.getInstance().postSerialTask(new a(this, list, z), "updateNewSwitchInfo", 3);
        }
    }

    public boolean j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, str, z)) == null) {
            return l20.a(u(str), z);
        }
        return invokeLZ.booleanValue;
    }

    public double k(String str, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, Double.valueOf(d)})) == null) {
            return l20.b(u(str), d);
        }
        return invokeCommon.doubleValue;
    }

    public int o(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, str, i)) == null) {
            return l20.c(u(str), i);
        }
        return invokeLI.intValue;
    }

    public long p(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048591, this, str, j)) == null) {
            return l20.e(u(str), j);
        }
        return invokeLJ.longValue;
    }

    public String s(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, str, str2)) == null) {
            return l20.f(u(str), str2);
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public int v(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, str, i)) == null) {
            return this.a.l(str, i);
        }
        return invokeLI.intValue;
    }

    public void x(JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048599, this, jSONObject, z) == null) {
            if (jSONObject != null) {
                this.a.k().g(jSONObject);
                return;
            }
            throw new NullPointerException("config string is empty!");
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f.get() == null) {
                synchronized (this.g) {
                    if (this.f.get() == null) {
                        HashMap<String, t8> hashMap = new HashMap<>();
                        HashMap<String, t8> m = this.a.m();
                        if (m != null && m.size() > 0) {
                            hashMap.putAll(m);
                        }
                        HashMap<String, t8> q = this.a.q();
                        if (q != null && q.size() > 0) {
                            hashMap.putAll(q);
                        }
                        if (AppConfig.isDebug()) {
                            Log.d("ExperimentManager", "loadExpInfo mergeExpInfoMap size>> " + hashMap.size());
                        }
                        this.f.set(hashMap);
                    }
                }
            }
            this.a.g();
        }
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (this.f.get() != null && this.f.get().size() > 0) {
                for (t8 t8Var : this.f.get().values()) {
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(String.valueOf(t8Var.c()));
                    jSONArray2.put(String.valueOf(t8Var.b()));
                    jSONArray.put(jSONArray2);
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void B(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && this.d[i].get() == null) {
            synchronized (this.e) {
                if (this.d[i].get() == null) {
                    List<c9> arrayList = new ArrayList<>();
                    List<c9> n = this.a.n(i);
                    if (n != null && n.size() > 0) {
                        arrayList.addAll(n);
                    }
                    List<c9> s = this.a.s(i);
                    if (s != null && s.size() > 0) {
                        arrayList.addAll(s);
                    }
                    if (AppConfig.isDebug()) {
                        Log.d("ExperimentManager", "loadSwitchInfo mergeSwitchList size " + arrayList.size());
                    }
                    C(arrayList, i, true);
                }
            }
        }
    }

    public void g(b9 b9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, b9Var) == null) && b9Var != null && b9Var.a()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            try {
                jSONObject.put(b9Var.c(), b9Var.e());
                jSONObject2.put(b9Var.c(), b9Var.d());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            t8 a2 = t8.a(b9Var.b());
            if (a2 != null) {
                arrayList.add(a2);
                arrayList3.add(a2);
            }
            arrayList2.add(new c9(b9Var.c(), b9Var.d()));
            G(arrayList2, true);
            F(arrayList3);
            D(jSONObject, jSONObject2, arrayList);
        }
    }

    public final void C(List<c9> list, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            HashMap<String, c9> hashMap = new HashMap<>();
            if (list != null && list.size() > 0) {
                if (this.d[i].get() != null) {
                    hashMap.putAll(this.d[i].get());
                }
                for (c9 c9Var : list) {
                    if (hashMap.get(c9Var.a()) == null || z) {
                        hashMap.put(c9Var.a(), c9Var);
                    }
                }
            }
            this.d[i].set(hashMap);
        }
    }

    public void D(JSONObject jSONObject, JSONObject jSONObject2, List<t8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, jSONObject, jSONObject2, list) == null) {
            this.a.t(jSONObject, jSONObject2, list);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (int i = 0; i < this.c; i++) {
                B(i);
            }
            A();
        }
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.a.k().b();
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<t8> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ArrayList<t8> arrayList = new ArrayList<>();
            if (this.f.get() != null && this.f.get().size() > 0) {
                arrayList.addAll(this.f.get().values());
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.d = new AtomicReference[this.c];
            for (int i = 0; i < this.c; i++) {
                this.d[i] = new AtomicReference<>();
            }
            this.f = new AtomicReference<>();
            this.e = new Object();
            this.g = new Object();
        }
    }

    public JSONObject q() {
        InterceptResult invokeV;
        Object b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < this.c; i++) {
                try {
                    HashMap<String, c9> hashMap = this.d[i].get();
                    if (hashMap != null) {
                        for (String str : hashMap.keySet()) {
                            c9 c9Var = hashMap.get(str);
                            if (c9Var != null && (b2 = c9Var.b()) != null) {
                                jSONObject.put(str, b2);
                            }
                        }
                    }
                } catch (JSONException e) {
                    w8.b("ExperimentManager", " getRawFlags JSONException", e);
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public c9 t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            int E = E(str);
            if (this.d[E].get() == null) {
                B(E);
            }
            return this.d[E].get().get(str);
        }
        return (c9) invokeL.objValue;
    }
}
