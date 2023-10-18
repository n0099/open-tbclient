package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class lx2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static volatile lx2 e;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ox2> a;
    public AtomicInteger b;
    public CopyOnWriteArrayList<mx2> c;

    /* loaded from: classes7.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ List b;
        public final /* synthetic */ ArrayMap c;
        public final /* synthetic */ String d;
        public final /* synthetic */ lx2 e;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public a(lx2 lx2Var, String str, List list, ArrayMap arrayMap, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lx2Var, str, list, arrayMap, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = lx2Var;
            this.a = str;
            this.b = list;
            this.c = arrayMap;
            this.d = str2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.e.d(this.b);
                p22.l("SwanAppUpdateManager", "update request failure: ", exc);
                ic3.z(this.d, -1, exc.toString());
                uc3.b(SwanInterfaceType.UPDATE, 2101, this.d, null, exc.getMessage());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                String appId = o53.K().getAppId();
                if (TextUtils.equals(this.a, appId)) {
                    this.e.s(this.a, response, this.b, this.c);
                    p22.k("SwanAppUpdateManager", "response code = " + response.code());
                    if (!response.isSuccessful()) {
                        ic3.z(this.d, response.code(), response.message());
                    }
                    return response;
                }
                p22.k("SwanAppUpdateManager", "invalid response requestAppId:" + this.a + ";currentAppId:" + appId);
                this.e.d(this.b);
                lx2.x(this.a);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx2 a;

        public b(lx2 lx2Var, mx2 mx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lx2Var, mx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947958179, "Lcom/baidu/tieba/lx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947958179, "Lcom/baidu/tieba/lx2;");
                return;
            }
        }
        d = am1.a;
    }

    public lx2() {
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
        k();
    }

    public static lx2 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (lx2.class) {
                    if (e == null) {
                        e = new lx2();
                    }
                }
            }
            return e;
        }
        return (lx2) invokeV.objValue;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            B(null);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            l();
            this.b = new AtomicInteger(0);
            this.c = new CopyOnWriteArrayList<>();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            arrayList.add(new nx2());
            this.a.add(new px2());
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && o53.K().E()) {
            o53.K().q().f0().A(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, System.currentTimeMillis());
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "release: ");
            }
            if (e == null) {
                return;
            }
            this.c.clear();
            e = null;
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (o53.K().E()) {
                o53.K().q().f0().D(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
            }
            y();
        }
    }

    public static void x(String str) {
        p53 c0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, str) != null) || (c0 = p53.c0()) == null) {
            return;
        }
        ih3 ih3Var = new ih3();
        ih3Var.k(5L);
        ih3Var.i(53L);
        qc3 qc3Var = new qc3();
        qc3Var.p(ih3Var);
        qc3Var.r(c0.X());
        qc3Var.q(ic3.n(c0.k()));
        qc3Var.m(c0.getAppId());
        qc3Var.a("requestAppId", str);
        ic3.R(qc3Var);
    }

    public void w(ox2 ox2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, ox2Var) == null) {
            if (ox2Var == null) {
                if (d) {
                    Log.w("SwanAppUpdateManager", "resetNodeVersion: node is null");
                    return;
                }
                return;
            }
            if (d) {
                Log.d("SwanAppUpdateManager", "resetNodeVersion: " + ox2Var.a());
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(ox2Var);
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            arrayMap.put(ox2Var.a(), "");
            C(arrayList, arrayMap);
        }
    }

    public void B(@Nullable mx2 mx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mx2Var) == null) {
            if (mx2Var != null) {
                this.c.add(mx2Var);
            }
            f(this.a);
        }
    }

    public final void d(@NonNull List<ox2> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "doRequestFail: ");
            }
            n(list);
            o(false);
        }
    }

    public final void n(@NonNull List<ox2> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            for (ox2 ox2Var : list) {
                ox2Var.b();
            }
        }
    }

    public final void C(@NonNull List<ox2> list, @NonNull ArrayMap<String, String> arrayMap) {
        p53 M;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, arrayMap) != null) || list.size() == 0 || (M = p53.M()) == null) {
            return;
        }
        String q = M.f0().q("update_nodes_version", "");
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(q)) {
            try {
                jSONObject = new JSONObject(q);
            } catch (JSONException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
        }
        for (ox2 ox2Var : list) {
            String str = arrayMap.get(ox2Var.a());
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            try {
                if (d) {
                    Log.d("SwanAppUpdateManager", "updateNodeVersions: update node => " + ox2Var.a() + " , version => " + str);
                }
                jSONObject.put(ox2Var.a(), str);
            } catch (JSONException e3) {
                if (d) {
                    e3.printStackTrace();
                }
            }
        }
        M.f0().B("update_nodes_version", jSONObject.toString());
    }

    @Nullable
    public final JSONObject c(@NonNull List<ox2> list, @NonNull ArrayMap<String, String> arrayMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, list, arrayMap)) == null) {
            if (list.size() == 0) {
                return null;
            }
            String P = o53.K().q().P();
            if (TextUtils.isEmpty(P)) {
                return null;
            }
            String U = p53.M().Z().U();
            if (TextUtils.isEmpty(U)) {
                U = "NA";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", P);
                jSONObject.put("source", U);
            } catch (JSONException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
            for (ox2 ox2Var : list) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    String str = "";
                    if (arrayMap.containsKey(ox2Var.a())) {
                        str = arrayMap.get(ox2Var.a());
                    }
                    if (d) {
                        Log.d("SwanAppUpdateManager", "buildRequestParams: node => " + ox2Var.a() + " , version => " + str);
                    }
                    jSONObject2.put("version", str);
                    jSONObject.put(ox2Var.a(), jSONObject2);
                } catch (JSONException e3) {
                    if (d) {
                        e3.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final void e(String str, @NonNull JSONObject jSONObject, @NonNull List<ox2> list, @NonNull ArrayMap<String, String> arrayMap, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, str, jSONObject, list, arrayMap, str2) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "doRequestSuccess: start");
            }
            t();
            boolean z = false;
            for (ox2 ox2Var : list) {
                JSONObject optJSONObject = jSONObject.optJSONObject(ox2Var.a());
                if (optJSONObject == null) {
                    ox2Var.b();
                } else if (!TextUtils.equals(optJSONObject.optString("errno"), "0")) {
                    ox2Var.b();
                } else {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                    if (optJSONObject2 == null) {
                        ox2Var.c();
                    } else {
                        if (d) {
                            Log.d("SwanAppUpdateManager", "doRequestSuccess: node => " + ox2Var.a() + " update");
                        }
                        ox2Var.d(str, optJSONObject2, str2);
                        String optString = optJSONObject.optString("version", "");
                        if (!TextUtils.isEmpty(optString)) {
                            if (d) {
                                Log.d("SwanAppUpdateManager", "doRequestSuccess: " + ox2Var.a() + " update , version " + optString);
                            }
                            arrayMap.put(ox2Var.a(), optString);
                            z = true;
                        }
                    }
                }
            }
            if (z) {
                C(list, arrayMap);
            }
            o(true);
        }
    }

    public final void f(@NonNull List<ox2> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (list.size() == 0) {
                p22.k("SwanAppUpdateManager", "doUpdate: finish => nodes are empty");
                p();
                return;
            }
            if (d) {
                Log.d("SwanAppUpdateManager", "doUpdate: start => nodes size " + list.size());
            }
            if (this.b.incrementAndGet() > 1) {
                p22.k("SwanAppUpdateManager", "doUpdate: pending => wait previous request");
                return;
            }
            ArrayMap<String, String> i = i(this.a);
            JSONObject c = c(list, i);
            if (c == null) {
                p22.k("SwanAppUpdateManager", "doUpdate: finish => build params is null");
                p();
                return;
            }
            if (d) {
                Log.w("SwanAppUpdateManager", "doUpdate: start to request update data");
            }
            FormBody build = new FormBody.Builder().add("data", c.toString()).build();
            String b2 = wo2.o().b();
            p22.k("SwanAppUpdateManager", "appId =" + o53.K().getAppId() + ", update url = " + b2 + ",body=" + c);
            j(o53.K().getAppId(), b2, build, list, i);
        }
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (o53.K().E()) {
                return o53.K().q().f0().n(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
            }
            return System.currentTimeMillis();
        }
        return invokeV.longValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            long h = h();
            if (h <= 0) {
                return true;
            }
            if (System.currentTimeMillis() - h > zh4.b(o53.K().getAppId())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "onUpdateFinish: real finish update");
            }
            this.b.set(0);
            Iterator<mx2> it = this.c.iterator();
            while (it.hasNext()) {
                na3.l(new b(this, it.next()));
            }
            this.c.clear();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            boolean m = o53.K().q().f0().m("swan_service_update_degraded", false);
            p22.i("SwanAppUpdateManager", "tryUpdate, isServiceDegraded = " + m);
            if (!m) {
                z(null);
            }
        }
    }

    @NonNull
    public final ArrayMap<String, String> i(@NonNull List<ox2> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list)) == null) {
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            if (list.size() == 0) {
                return arrayMap;
            }
            for (ox2 ox2Var : list) {
                arrayMap.put(ox2Var.a(), "");
            }
            p53 M = p53.M();
            if (M == null) {
                return arrayMap;
            }
            String q = M.f0().q("update_nodes_version", "");
            if (TextUtils.isEmpty(q)) {
                return arrayMap;
            }
            try {
                JSONObject jSONObject = new JSONObject(q);
                for (ox2 ox2Var2 : list) {
                    arrayMap.put(ox2Var2.a(), jSONObject.optString(ox2Var2.a(), ""));
                }
            } catch (JSONException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
            return arrayMap;
        }
        return (ArrayMap) invokeL.objValue;
    }

    public final void j(String str, String str2, RequestBody requestBody, List<ox2> list, ArrayMap<String, String> arrayMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048585, this, str, str2, requestBody, list, arrayMap) == null) {
            sc4 sc4Var = new sc4(str2, requestBody, new a(this, str, list, arrayMap, str2));
            sc4Var.f = true;
            sc4Var.g = true;
            sc4Var.h = false;
            sc4Var.k = 20;
            tc4.g().e(sc4Var);
            uc3.a(SwanInterfaceType.UPDATE);
        }
    }

    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "onRequestFinish: request finish");
            }
            if (this.b.decrementAndGet() > 0) {
                if (d) {
                    Log.d("SwanAppUpdateManager", "onRequestFinish: do pending request");
                }
                this.b.set(0);
                if (!z) {
                    A();
                    return;
                } else {
                    p();
                    return;
                }
            }
            p();
        }
    }

    public final HashMap<String, JSONObject> r(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, jSONObject)) == null) {
            HashMap<String, JSONObject> hashMap = new HashMap<>();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = jSONObject.optJSONObject(next)) != null) {
                    hashMap.put(next, optJSONObject);
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public void z(@Nullable mx2 mx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, mx2Var) == null) {
            if (m()) {
                if (d) {
                    Log.d("SwanAppUpdateManager", "tryUpdate: start => cache data invalid");
                }
                B(mx2Var);
                return;
            }
            if (d) {
                Log.d("SwanAppUpdateManager", "tryUpdate: finish => cache data valid");
            }
            if (mx2Var != null) {
                mx2Var.a();
            }
        }
    }

    public void q(@NonNull xd3 xd3Var, @NonNull JSONObject jSONObject) {
        int length;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, xd3Var, jSONObject) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (d) {
                Log.d("SwanAppUpdateManager", "parse increment accredit node start");
            }
            String string = xd3Var.getString("node_data_accredit_list", "");
            p22.k("SwanAppUpdateManager", "prefName: " + xd3Var.g() + ",cacheData is Empty = " + TextUtils.isEmpty(string) + ":accreditNodeObj=" + jSONObject);
            if (TextUtils.isEmpty(string)) {
                JSONObject jSONObject3 = new JSONObject();
                pi3.f(jSONObject3, "list", jSONObject);
                String jSONObject4 = jSONObject3.toString();
                xd3Var.putString("node_data_accredit_list", jSONObject4);
                xd3Var.putString("cur_request_id", "pkgInfo:" + System.currentTimeMillis());
                if (d) {
                    Log.d("SwanAppUpdateManager", "local has no cache data, write directly. pending data = " + jSONObject4);
                }
            } else {
                HashMap<String, JSONObject> r = r(jSONObject);
                if (r != null && r.size() != 0) {
                    JSONObject d2 = pi3.d(string);
                    JSONObject optJSONObject = d2.optJSONObject("list");
                    if (optJSONObject == null) {
                        pi3.f(d2, "list", jSONObject);
                        xd3Var.putString("node_data_accredit_list", d2.toString());
                        xd3Var.putString("cur_request_id", "pkgInfo:" + System.currentTimeMillis());
                        p22.k("SwanAppUpdateManager", "local has cache data, but list node is empty");
                        return;
                    }
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next) && (jSONObject2 = r.get(next)) != null) {
                            pi3.f(optJSONObject, next, jSONObject2);
                        }
                    }
                    pi3.f(d2, "list", optJSONObject);
                    xd3Var.putString("node_data_accredit_list", d2.toString());
                    String string2 = xd3Var.getString("cur_request_id", "");
                    if (!TextUtils.isEmpty(string2) && (length = string2.length()) > 100) {
                        string2 = string2.substring(length - 100);
                    }
                    xd3Var.putString("cur_request_id", string2 + ";merge:" + System.currentTimeMillis());
                    p22.k("SwanAppUpdateManager", "prefName: " + xd3Var.g() + ",mergeAccredit = " + d2);
                } else {
                    p22.k("SwanAppUpdateManager", "local has cache data, but pending data is empty");
                    return;
                }
            }
            if (d) {
                Log.d("SwanAppUpdateManager", "parse increment accredit node end, cost = " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public final void s(String str, Response response, @NonNull List<ox2> list, @NonNull ArrayMap<String, String> arrayMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048594, this, str, response, list, arrayMap) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "onResponse: update request return");
            }
            String str2 = null;
            if (!response.isSuccessful()) {
                d(list);
                uc3.c(SwanInterfaceType.UPDATE, RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, null, response);
                return;
            }
            ResponseBody body = response.body();
            if (body == null) {
                d(list);
                uc3.c(SwanInterfaceType.UPDATE, 2103, null, response);
                return;
            }
            try {
                str2 = body.string();
            } catch (IOException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
            p22.k("SwanAppUpdateManager", "response body = " + str2);
            if (TextUtils.isEmpty(str2)) {
                d(list);
                uc3.c(SwanInterfaceType.UPDATE, 2103, str2, response);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                    d(list);
                    uc3.c(SwanInterfaceType.UPDATE, jSONObject.optInt("errno", 2103), str2, response);
                    return;
                }
                String optString = jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, "");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                p22.k("SwanAppUpdateManager", "request_id = " + optString);
                if (optJSONObject == null) {
                    d(list);
                } else {
                    e(str, optJSONObject, list, arrayMap, optString);
                }
            } catch (JSONException e3) {
                if (d) {
                    e3.printStackTrace();
                }
                d(list);
                uc3.c(SwanInterfaceType.UPDATE, 2103, str2, response);
            }
        }
    }
}
