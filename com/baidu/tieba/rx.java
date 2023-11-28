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
/* loaded from: classes8.dex */
public class rx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public List<p4> c;
    public j4 d;
    public u4 e;
    public t4 f;
    public ElasticTaskScheduler g;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rx a;

        public a(rx rxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rxVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e == null) {
                    this.a.e = new u4();
                }
                this.a.e.g();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rx a;

        public b(rx rxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rxVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e == null) {
                    this.a.e = new u4();
                }
                this.a.e.f();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ int b;

        public c(rx rxVar, List list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rxVar, list, Integer.valueOf(i)};
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
                    for (q4 q4Var : this.a) {
                        jSONObject.put(q4Var.a(), q4Var.b());
                    }
                    qx.n(jSONObject, this.b);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rx a;

        public d(rx rxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rxVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.d == null) {
                    rx rxVar = this.a;
                    rxVar.d = new j4(rxVar.a);
                }
                this.a.d.h();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HashMap a;

        public e(rx rxVar, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rxVar, hashMap};
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
                qx.g(new ArrayList(this.a.values()));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rx a;

        public f(rx rxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rxVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h4 h4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.d == null) {
                    rx rxVar = this.a;
                    rxVar.d = new j4(rxVar.a);
                }
                if (this.a.e == null) {
                    this.a.e = new u4();
                }
                ArrayList arrayList = new ArrayList();
                String d = qx.d();
                HashMap<String, h4> hashMap = new HashMap<>();
                if (!TextUtils.isEmpty(d)) {
                    hashMap = this.a.d.d(d);
                }
                HashMap hashMap2 = new HashMap();
                String e = qx.e();
                if (!TextUtils.isEmpty(e)) {
                    hashMap2.putAll(this.a.e.b(e));
                }
                HashMap hashMap3 = new HashMap();
                String c = qx.c();
                if (!TextUtils.isEmpty(c)) {
                    hashMap3.putAll(this.a.e.d(c));
                }
                HashMap hashMap4 = new HashMap();
                hashMap4.putAll(hashMap);
                hashMap4.putAll(hashMap2);
                hashMap4.putAll(hashMap3);
                for (String str : hashMap4.keySet()) {
                    if (((h4) hashMap4.get(str)) != null) {
                        String str2 = h4Var.c() + "_" + h4Var.b();
                        if (!TextUtils.isEmpty(str2) && !arrayList.contains(str2)) {
                            arrayList.add(str2);
                        }
                    }
                }
                String b = qx.b();
                if (TextUtils.isEmpty(b)) {
                    return;
                }
                HashMap o = this.a.o(b);
                ArrayList arrayList2 = new ArrayList();
                for (String str3 : o.keySet()) {
                    if (!TextUtils.isEmpty(str3) && !arrayList.contains(str3)) {
                        arrayList2.add((h4) o.get(str3));
                    }
                }
                if (arrayList2.size() > 0) {
                    qx.a(arrayList2);
                }
                if (AppConfig.isDebug()) {
                    Log.d("EasyABDataProducer", "checkInvalidSidFileData sidList " + arrayList.size());
                    Log.d("EasyABDataProducer", "checkInvalidSidFileData expInfoHashMap sidList " + o.size());
                }
            }
        }
    }

    public rx(Context context) {
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
        this.b = s4.b().a();
        this.g = ElasticTaskScheduler.getInstance();
    }

    public final void u(HashMap<String, h4> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, hashMap) == null) {
            this.g.postConcurrentTask(new e(this, hashMap), "transferData", 3);
        }
    }

    public final void w(List<q4> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, list, i) == null) {
            this.g.postConcurrentTask(new c(this, list, i), "transferData", 3);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && g4.d(this.a).f()) {
            this.g.postConcurrentTask(new f(this), "checkInvalidSidFileData", 3);
        }
    }

    public j4 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.d == null) {
                this.d = new j4(this.a);
            }
            return this.d;
        }
        return (j4) invokeV.objValue;
    }

    public HashMap<String, h4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            String b2 = qx.b();
            if (!TextUtils.isEmpty(b2)) {
                return o(b2);
            }
            return p();
        }
        return (HashMap) invokeV.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ElasticTaskScheduler.getInstance().postConcurrentTask(new b(this), "transferData", 3);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.g.postConcurrentTask(new d(this), "transferData", 3);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ElasticTaskScheduler.getInstance().postConcurrentTask(new a(this), "transferData", 3);
        }
    }

    public final HashMap<String, h4> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String c2 = qx.c();
            if (this.e == null) {
                this.e = new u4();
            }
            if (!TextUtils.isEmpty(c2)) {
                return this.e.d(c2);
            }
            return this.e.c();
        }
        return (HashMap) invokeV.objValue;
    }

    public final HashMap<String, h4> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String d2 = qx.d();
            if (this.d == null) {
                this.d = new j4(this.a);
            }
            if (!TextUtils.isEmpty(d2)) {
                return this.d.d(d2);
            }
            j4 j4Var = this.d;
            return j4Var.d(j4Var.c().getConfig());
        }
        return (HashMap) invokeV.objValue;
    }

    public final HashMap<String, h4> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String e2 = qx.e();
            if (this.e == null) {
                this.e = new u4();
            }
            if (!TextUtils.isEmpty(e2)) {
                return this.e.b(e2);
            }
            return this.e.a();
        }
        return (HashMap) invokeV.objValue;
    }

    @Deprecated
    public int l(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            try {
                JSONArray jSONArray = new JSONObject(this.d.c().getConfig()).getJSONArray("exps");
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

    public HashMap<String, h4> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.c == null) {
                if (this.f == null) {
                    this.f = new t4();
                }
                this.c = this.f.a(this.a);
            }
            HashMap<String, h4> hashMap = new HashMap<>();
            List<p4> list = this.c;
            if (list != null && list.size() > 0) {
                for (p4 p4Var : this.c) {
                    hashMap.put(p4Var.b(), h4.a(p4Var.b()));
                }
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public List<q4> n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (this.c == null) {
                if (this.f == null) {
                    this.f = new t4();
                }
                this.c = this.f.a(this.a);
            }
            ArrayList arrayList = new ArrayList();
            List<p4> list = this.c;
            if (list != null && list.size() > 0) {
                for (p4 p4Var : this.c) {
                    if (ay.a(p4Var.c(), this.b) == i) {
                        arrayList.add(new q4(p4Var.c(), p4Var.d()));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public final HashMap<String, h4> o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            HashMap<String, h4> hashMap = new HashMap<>();
            try {
                JSONObject jSONObject = new JSONObject(str);
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String[] split = next.split("_");
                    int d2 = zx.d(split[0]);
                    int d3 = zx.d(split[1]);
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    if (jSONObject2.has("expired_time") && jSONObject2.has("is_upload")) {
                        boolean z = jSONObject2.getBoolean("is_upload");
                        long j = jSONObject2.getLong("expired_time");
                        if (z && currentTimeMillis <= j) {
                            hashMap.put(next, new h4(d2, d3, j, z));
                        }
                    } else {
                        hashMap.put(next, new h4(d2, d3));
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public List<q4> r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (this.d == null) {
                this.d = new j4(this.a);
            }
            List<q4> e2 = this.d.e(i);
            if (this.e == null) {
                this.e = new u4();
            }
            List<q4> e3 = this.e.e(i);
            List<q4> arrayList = new ArrayList<>();
            arrayList.addAll(e2);
            arrayList.addAll(e3);
            if (AppConfig.isDebug()) {
                Log.d("EasyABDataProducer", "loadSwitchInfoFromV1AndV2 v1SwitchInfoList " + e2.size() + " v2SwitchInfoList " + e3.size() + "sampleInfoList " + arrayList.size());
            }
            if (arrayList.size() > 0) {
                w(arrayList, i);
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public List<q4> s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            String e2 = tx.e(i);
            if (!TextUtils.isEmpty(e2)) {
                try {
                    ArrayList arrayList = new ArrayList();
                    JSONObject jSONObject = new JSONObject(e2);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        arrayList.add(new q4(next, jSONObject.get(next)));
                    }
                    if (AppConfig.isDebug()) {
                        Log.d("EasyABDataProducer", "loadV3SampleSwitchInfo switchInfoList size " + arrayList.size());
                    }
                    return arrayList;
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            return r(i);
        }
        return (List) invokeI.objValue;
    }

    public final HashMap<String, h4> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            HashMap<String, h4> hashMap = new HashMap<>();
            HashMap<String, h4> i = i();
            HashMap<String, h4> j = j();
            HashMap<String, h4> h = h();
            hashMap.putAll(i);
            hashMap.putAll(j);
            hashMap.putAll(h);
            if (AppConfig.isDebug()) {
                Log.d("ExperimentManager", "loadExpInfoFromV1AndV2 expV1SidInfo>> " + i.size());
                Log.d("ExperimentManager", "loadExpInfoFromV1AndV2 expV2SidInfo>> " + j.size());
                Log.d("ExperimentManager", "loadExpInfoFromV1AndV2 expSapSidInfo>> " + h.size());
            }
            y();
            x();
            v();
            u(hashMap);
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public void t(JSONObject jSONObject, JSONObject jSONObject2, List<h4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, jSONObject, jSONObject2, list) == null) {
            qx.k(jSONObject, jSONObject2, list);
        }
    }
}
