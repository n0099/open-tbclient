package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
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
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class m10 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public l8 b;
    public u8 c;
    public ElasticTaskScheduler d;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m10 a;

        public a(m10 m10Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m10Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m10Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.c == null) {
                    this.a.c = new u8();
                }
                this.a.c.g();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m10 a;

        public b(m10 m10Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m10Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m10Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.c == null) {
                    this.a.c = new u8();
                }
                this.a.c.f();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ int b;

        public c(m10 m10Var, List list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m10Var, list, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (r8 r8Var : this.a) {
                        jSONObject.put(r8Var.a(), r8Var.b());
                    }
                    l10.m(jSONObject, this.b);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m10 a;

        public d(m10 m10Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m10Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m10Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.b == null) {
                    m10 m10Var = this.a;
                    m10Var.b = new l8(m10Var.a);
                }
                this.a.b.d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HashMap a;

        public e(m10 m10Var, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m10Var, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (hashMap = this.a) != null && hashMap.size() > 0 && this.a.values().size() > 0) {
                l10.g(new ArrayList(this.a.values()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m10 a;

        public f(m10 m10Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m10Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m10Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            j8 j8Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.b == null) {
                    m10 m10Var = this.a;
                    m10Var.b = new l8(m10Var.a);
                }
                if (this.a.c == null) {
                    this.a.c = new u8();
                }
                ArrayList arrayList = new ArrayList();
                String d = l10.d();
                HashMap<String, j8> hashMap = new HashMap<>();
                if (!TextUtils.isEmpty(d)) {
                    hashMap = this.a.b.b(d);
                }
                HashMap hashMap2 = new HashMap();
                String e = l10.e();
                if (!TextUtils.isEmpty(e)) {
                    hashMap2.putAll(this.a.c.b(e));
                }
                HashMap hashMap3 = new HashMap();
                String c = l10.c();
                if (!TextUtils.isEmpty(c)) {
                    hashMap3.putAll(this.a.c.d(c));
                }
                HashMap hashMap4 = new HashMap();
                hashMap4.putAll(hashMap);
                hashMap4.putAll(hashMap2);
                hashMap4.putAll(hashMap3);
                for (String str : hashMap4.keySet()) {
                    if (((j8) hashMap4.get(str)) != null) {
                        String str2 = j8Var.c() + "_" + j8Var.b();
                        if (!TextUtils.isEmpty(str2) && !arrayList.contains(str2)) {
                            arrayList.add(str2);
                        }
                    }
                }
                String b = l10.b();
                if (TextUtils.isEmpty(b)) {
                    return;
                }
                HashMap l = this.a.l(b);
                ArrayList arrayList2 = new ArrayList();
                for (String str3 : l.keySet()) {
                    if (!TextUtils.isEmpty(str3) && !arrayList.contains(str3)) {
                        arrayList2.add(l.get(str3));
                    }
                }
                if (arrayList2.size() > 0) {
                    l10.a(arrayList2);
                }
                if (AppConfig.isDebug()) {
                    Log.d("EasyABDataProducer", "checkInvalidSidFileData sidList " + arrayList.size());
                    Log.d("EasyABDataProducer", "checkInvalidSidFileData expInfoHashMap sidList " + l.size());
                }
            }
        }
    }

    public m10(Context context) {
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
        this.a = context;
        this.d = ElasticTaskScheduler.getInstance();
    }

    public final void r(HashMap<String, j8> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, hashMap) == null) {
            this.d.postConcurrentTask(new e(this, hashMap), "transferData", 3);
        }
    }

    public final void t(List<r8> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, list, i) == null) {
            this.d.postConcurrentTask(new c(this, list, i), "transferData", 3);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && i8.a(this.a).b()) {
            this.d.postConcurrentTask(new f(this), "checkInvalidSidFileData", 3);
        }
    }

    public HashMap<String, j8> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String b2 = l10.b();
            if (!TextUtils.isEmpty(b2)) {
                return l(b2);
            }
            return m();
        }
        return (HashMap) invokeV.objValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ElasticTaskScheduler.getInstance().postConcurrentTask(new b(this), "transferData", 3);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.d.postConcurrentTask(new d(this), "transferData", 3);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ElasticTaskScheduler.getInstance().postConcurrentTask(new a(this), "transferData", 3);
        }
    }

    public final HashMap<String, j8> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String c2 = l10.c();
            if (this.c == null) {
                this.c = new u8();
            }
            if (!TextUtils.isEmpty(c2)) {
                return this.c.d(c2);
            }
            return this.c.c();
        }
        return (HashMap) invokeV.objValue;
    }

    public final HashMap<String, j8> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String d2 = l10.d();
            if (this.b == null) {
                this.b = new l8(this.a);
            }
            if (!TextUtils.isEmpty(d2)) {
                return this.b.b(d2);
            }
            l8 l8Var = this.b;
            return l8Var.b(l8Var.a().d());
        }
        return (HashMap) invokeV.objValue;
    }

    public final HashMap<String, j8> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String e2 = l10.e();
            if (this.c == null) {
                this.c = new u8();
            }
            if (!TextUtils.isEmpty(e2)) {
                return this.c.b(e2);
            }
            return this.c.a();
        }
        return (HashMap) invokeV.objValue;
    }

    @Deprecated
    public int k(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i)) == null) {
            try {
                JSONArray jSONArray = new JSONObject(this.b.a().d()).getJSONArray("exps");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2).getJSONObject("components_values");
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (TextUtils.equals(str, next)) {
                            return jSONObject.optInt(next, i);
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return i;
        }
        return invokeLI.intValue;
    }

    public final HashMap<String, j8> l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            HashMap<String, j8> hashMap = new HashMap<>();
            try {
                JSONObject jSONObject = new JSONObject(str);
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String[] split = next.split("_");
                    int d2 = t10.d(split[0]);
                    int d3 = t10.d(split[1]);
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    if (jSONObject2.has("expired_time") && jSONObject2.has("is_upload")) {
                        boolean z = jSONObject2.getBoolean("is_upload");
                        long j = jSONObject2.getLong("expired_time");
                        if (z && currentTimeMillis <= j) {
                            hashMap.put(next, new j8(d2, d3, j, z));
                        }
                    } else {
                        hashMap.put(next, new j8(d2, d3));
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public List<r8> o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (this.b == null) {
                this.b = new l8(this.a);
            }
            List<r8> c2 = this.b.c(i);
            if (this.c == null) {
                this.c = new u8();
            }
            List<r8> e2 = this.c.e(i);
            List<r8> arrayList = new ArrayList<>();
            arrayList.addAll(c2);
            arrayList.addAll(e2);
            if (AppConfig.isDebug()) {
                Log.d("EasyABDataProducer", "loadSwitchInfoFromV1AndV2 v1SwitchInfoList " + c2.size() + " v2SwitchInfoList " + e2.size() + "sampleInfoList " + arrayList.size());
            }
            if (arrayList.size() > 0) {
                t(arrayList, i);
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public List<r8> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            String e2 = o10.e(i);
            if (!TextUtils.isEmpty(e2)) {
                try {
                    ArrayList arrayList = new ArrayList();
                    JSONObject jSONObject = new JSONObject(e2);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        arrayList.add(new r8(next, jSONObject.get(next)));
                    }
                    if (AppConfig.isDebug()) {
                        Log.d("EasyABDataProducer", "loadV3SampleSwitchInfo switchInfoList size " + arrayList.size());
                    }
                    return arrayList;
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            return o(i);
        }
        return (List) invokeI.objValue;
    }

    public final HashMap<String, j8> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            HashMap<String, j8> hashMap = new HashMap<>();
            HashMap<String, j8> i = i();
            HashMap<String, j8> j = j();
            HashMap<String, j8> h = h();
            hashMap.putAll(i);
            hashMap.putAll(j);
            hashMap.putAll(h);
            if (AppConfig.isDebug()) {
                Log.d("ExperimentManager", "loadExpInfoFromV1AndV2 expV1SidInfo>> " + i.size());
                Log.d("ExperimentManager", "loadExpInfoFromV1AndV2 expV2SidInfo>> " + j.size());
                Log.d("ExperimentManager", "loadExpInfoFromV1AndV2 expSapSidInfo>> " + h.size());
            }
            v();
            u();
            s();
            r(hashMap);
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public void q(JSONObject jSONObject, JSONObject jSONObject2, List<j8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, jSONObject, jSONObject2, list) == null) {
            l10.j(jSONObject, jSONObject2, list);
        }
    }
}
