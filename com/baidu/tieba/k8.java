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
/* loaded from: classes5.dex */
public class k8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k8 h;
    public transient /* synthetic */ FieldHolder $fh;
    public m10 a;
    public Context b;
    public volatile int c;
    public AtomicReference<HashMap<String, r8>>[] d;
    public Object e;
    public AtomicReference<HashMap<String, j8>> f;
    public Object g;

    @Deprecated
    public void i(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ k8 c;

        public a(k8 k8Var, List list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k8Var, list, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = k8Var;
            this.a = list;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HashMap[] hashMapArr = new HashMap[this.c.c];
                for (r8 r8Var : this.a) {
                    int a = u10.a(r8Var.a(), this.c.c);
                    if (hashMapArr[a] == null) {
                        hashMapArr[a] = new HashMap();
                    }
                    hashMapArr[a].put(r8Var.a(), r8Var);
                }
                for (int i = 0; i < this.c.c; i++) {
                    if (hashMapArr[i] != null) {
                        ArrayList arrayList = new ArrayList(hashMapArr[i].values());
                        if (this.c.d[i].get() == null) {
                            this.c.z(i);
                        }
                        this.c.A(arrayList, i, this.b);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ k8 b;

        public b(k8 k8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k8Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k8Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.f.get() == null) {
                    this.b.y();
                }
                HashMap hashMap = new HashMap((Map) this.b.f.get());
                for (j8 j8Var : this.a) {
                    hashMap.put(j8Var.c() + "_" + j8Var.b(), j8Var);
                }
                this.b.f.set(hashMap);
                if (AppConfig.isDebug()) {
                    Log.d("ExperimentManager", "updateAddExpInfo mExpInfoRef updated size>> " + ((HashMap) this.b.f.get()).size());
                }
            }
        }
    }

    public k8(Context context) {
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
        this.c = t8.b().a();
        this.a = new m10(this.b);
        w();
    }

    public boolean x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            if (this.f.get() != null && this.f.get().size() > 0) {
                for (j8 j8Var : this.f.get().values()) {
                    if (j8Var.c() == i) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void z(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i) == null) && this.d[i].get() == null) {
            synchronized (this.e) {
                if (this.d[i].get() == null) {
                    List<r8> p = this.a.p(i);
                    if (AppConfig.isDebug()) {
                        Log.d("ExperimentManager", "loadSwitchInfo switchInfoList size " + p.size());
                    }
                    A(p, i, true);
                }
            }
        }
    }

    public static k8 n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (h == null) {
                synchronized (k8.class) {
                    if (h == null) {
                        h = new k8(context);
                    }
                }
            }
            return h;
        }
        return (k8) invokeL.objValue;
    }

    public final int C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode < 0) {
                hashCode = -hashCode;
            }
            return hashCode % this.c;
        }
        return invokeL.intValue;
    }

    public void D(List<j8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && list != null && list.size() > 0) {
            ElasticTaskScheduler.getInstance().postSerialTask(new b(this, list), "updateAddExpInfo", 3);
        }
    }

    public Object t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            r8 s = s(str);
            if (s != null) {
                return s.b();
            }
            return null;
        }
        return invokeL.objValue;
    }

    public boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (t(str) == null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void E(List<r8> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048580, this, list, z) == null) && list != null && list.size() > 0) {
            ElasticTaskScheduler.getInstance().postSerialTask(new a(this, list, z), "updateNewSwitchInfo", 3);
        }
    }

    public boolean j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z)) == null) {
            return t10.a(t(str), z);
        }
        return invokeLZ.booleanValue;
    }

    public double k(String str, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, Double.valueOf(d)})) == null) {
            return t10.b(t(str), d);
        }
        return invokeCommon.doubleValue;
    }

    public int o(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, str, i)) == null) {
            return t10.c(t(str), i);
        }
        return invokeLI.intValue;
    }

    public long p(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048589, this, str, j)) == null) {
            return t10.e(t(str), j);
        }
        return invokeLJ.longValue;
    }

    public String r(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, str, str2)) == null) {
            return t10.f(t(str), str2);
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public int u(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, str, i)) == null) {
            return this.a.k(str, i);
        }
        return invokeLI.intValue;
    }

    public final void A(List<r8> list, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{list, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            HashMap<String, r8> hashMap = new HashMap<>();
            if (list != null && list.size() > 0) {
                if (this.d[i].get() != null) {
                    hashMap.putAll(this.d[i].get());
                }
                for (r8 r8Var : list) {
                    if (hashMap.get(r8Var.a()) == null || z) {
                        hashMap.put(r8Var.a(), r8Var);
                    }
                }
            }
            this.d[i].set(hashMap);
        }
    }

    public void B(JSONObject jSONObject, JSONObject jSONObject2, List<j8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, jSONObject2, list) == null) {
            this.a.q(jSONObject, jSONObject2, list);
        }
    }

    public void g(q8 q8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, q8Var) == null) && q8Var != null && q8Var.a()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            try {
                jSONObject.put(q8Var.c(), q8Var.e());
                jSONObject2.put(q8Var.c(), q8Var.d());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            j8 a2 = j8.a(q8Var.b());
            if (a2 != null) {
                arrayList.add(a2);
                arrayList3.add(a2);
            }
            arrayList2.add(new r8(q8Var.c(), q8Var.d()));
            B(jSONObject, jSONObject2, arrayList);
            E(arrayList2, true);
            D(arrayList3);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (int i = 0; i < this.c; i++) {
                z(i);
            }
            y();
        }
    }

    public ArrayList<j8> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ArrayList<j8> arrayList = new ArrayList<>();
            if (this.f.get() != null && this.f.get().size() > 0) {
                arrayList.addAll(this.f.get().values());
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.d = new AtomicReference[this.c];
            for (int i = 0; i < this.c; i++) {
                this.d[i] = new AtomicReference<>();
            }
            this.f = new AtomicReference<>();
            this.e = new Object();
            this.g = new Object();
        }
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (this.f.get() != null && this.f.get().size() > 0) {
                for (j8 j8Var : this.f.get().values()) {
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(String.valueOf(j8Var.c()));
                    jSONArray2.put(String.valueOf(j8Var.b()));
                    jSONArray.put(jSONArray2);
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }

    public JSONObject q() {
        InterceptResult invokeV;
        Object b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < this.c; i++) {
                try {
                    HashMap<String, r8> hashMap = this.d[i].get();
                    if (hashMap != null) {
                        for (String str : hashMap.keySet()) {
                            r8 r8Var = hashMap.get(str);
                            if (r8Var != null && (b2 = r8Var.b()) != null) {
                                jSONObject.put(str, b2);
                            }
                        }
                    }
                } catch (JSONException e) {
                    m8.a("ExperimentManager", " getRawFlags JSONException", e);
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (this.f.get() == null) {
                synchronized (this.g) {
                    if (this.f.get() == null) {
                        HashMap<String, j8> n = this.a.n();
                        if (AppConfig.isDebug()) {
                            Log.d("ExperimentManager", "loadExpInfo expInfoMap size>> " + n.size());
                        }
                        this.f.set(n);
                    }
                }
            }
            this.a.g();
        }
    }

    public r8 s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            int C = C(str);
            if (this.d[C].get() == null) {
                z(C);
            }
            return this.d[C].get().get(str);
        }
        return (r8) invokeL.objValue;
    }
}
