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
/* loaded from: classes8.dex */
public final class y33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static volatile y33 e;
    public transient /* synthetic */ FieldHolder $fh;
    public List<b43> a;
    public AtomicInteger b;
    public CopyOnWriteArrayList<z33> c;

    /* loaded from: classes8.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ List b;
        public final /* synthetic */ ArrayMap c;
        public final /* synthetic */ String d;
        public final /* synthetic */ y33 e;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public a(y33 y33Var, String str, List list, ArrayMap arrayMap, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y33Var, str, list, arrayMap, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = y33Var;
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
                c92.l("SwanAppUpdateManager", "update request failure: ", exc);
                vi3.z(this.d, -1, exc.toString());
                hj3.b(SwanInterfaceType.UPDATE, 2101, this.d, null, exc.getMessage());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                String appId = bc3.K().getAppId();
                if (TextUtils.equals(this.a, appId)) {
                    this.e.s(this.a, response, this.b, this.c);
                    c92.k("SwanAppUpdateManager", "response code = " + response.code());
                    if (!response.isSuccessful()) {
                        vi3.z(this.d, response.code(), response.message());
                    }
                    return response;
                }
                c92.k("SwanAppUpdateManager", "invalid response requestAppId:" + this.a + ";currentAppId:" + appId);
                this.e.d(this.b);
                y33.x(this.a);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z33 a;

        public b(y33 y33Var, z33 z33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y33Var, z33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z33Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948279184, "Lcom/baidu/tieba/y33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948279184, "Lcom/baidu/tieba/y33;");
                return;
            }
        }
        d = ms1.a;
    }

    public y33() {
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

    public static y33 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (y33.class) {
                    if (e == null) {
                        e = new y33();
                    }
                }
            }
            return e;
        }
        return (y33) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            l();
            this.b = new AtomicInteger(0);
            this.c = new CopyOnWriteArrayList<>();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            arrayList.add(new a43());
            this.a.add(new c43());
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && bc3.K().E()) {
            bc3.K().q().e0().A(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, System.currentTimeMillis());
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
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

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            update(null);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (bc3.K().E()) {
                bc3.K().q().e0().D(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
            }
            y();
        }
    }

    public static void x(String str) {
        cc3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, str) != null) || (b0 = cc3.b0()) == null) {
            return;
        }
        vn3 vn3Var = new vn3();
        vn3Var.k(5L);
        vn3Var.i(53L);
        dj3 dj3Var = new dj3();
        dj3Var.p(vn3Var);
        dj3Var.r(b0.W());
        dj3Var.q(vi3.n(b0.k()));
        dj3Var.m(b0.getAppId());
        dj3Var.a("requestAppId", str);
        vi3.R(dj3Var);
    }

    public void w(b43 b43Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, b43Var) == null) {
            if (b43Var == null) {
                if (d) {
                    Log.w("SwanAppUpdateManager", "resetNodeVersion: node is null");
                    return;
                }
                return;
            }
            if (d) {
                Log.d("SwanAppUpdateManager", "resetNodeVersion: " + b43Var.a());
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(b43Var);
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            arrayMap.put(b43Var.a(), "");
            A(arrayList, arrayMap);
        }
    }

    public final void A(@NonNull List<b43> list, @NonNull ArrayMap<String, String> arrayMap) {
        cc3 M;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, list, arrayMap) != null) || list.size() == 0 || (M = cc3.M()) == null) {
            return;
        }
        String q = M.e0().q("update_nodes_version", "");
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
        for (b43 b43Var : list) {
            String str = arrayMap.get(b43Var.a());
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            try {
                if (d) {
                    Log.d("SwanAppUpdateManager", "updateNodeVersions: update node => " + b43Var.a() + " , version => " + str);
                }
                jSONObject.put(b43Var.a(), str);
            } catch (JSONException e3) {
                if (d) {
                    e3.printStackTrace();
                }
            }
        }
        M.e0().B("update_nodes_version", jSONObject.toString());
    }

    @Nullable
    public final JSONObject c(@NonNull List<b43> list, @NonNull ArrayMap<String, String> arrayMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, arrayMap)) == null) {
            if (list.size() == 0) {
                return null;
            }
            String O = bc3.K().q().O();
            if (TextUtils.isEmpty(O)) {
                return null;
            }
            String T2 = cc3.M().Y().T();
            if (TextUtils.isEmpty(T2)) {
                T2 = "NA";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", O);
                jSONObject.put("source", T2);
            } catch (JSONException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
            for (b43 b43Var : list) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    String str = "";
                    if (arrayMap.containsKey(b43Var.a())) {
                        str = arrayMap.get(b43Var.a());
                    }
                    if (d) {
                        Log.d("SwanAppUpdateManager", "buildRequestParams: node => " + b43Var.a() + " , version => " + str);
                    }
                    jSONObject2.put("version", str);
                    jSONObject.put(b43Var.a(), jSONObject2);
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

    public final void d(@NonNull List<b43> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "doRequestFail: ");
            }
            n(list);
            o(false);
        }
    }

    public final void n(@NonNull List<b43> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            for (b43 b43Var : list) {
                b43Var.b();
            }
        }
    }

    public void update(@Nullable z33 z33Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, z33Var) == null) {
            if (z33Var != null) {
                this.c.add(z33Var);
            }
            f(this.a);
        }
    }

    public final void e(String str, @NonNull JSONObject jSONObject, @NonNull List<b43> list, @NonNull ArrayMap<String, String> arrayMap, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, str, jSONObject, list, arrayMap, str2) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "doRequestSuccess: start");
            }
            t();
            boolean z = false;
            for (b43 b43Var : list) {
                JSONObject optJSONObject = jSONObject.optJSONObject(b43Var.a());
                if (optJSONObject == null) {
                    b43Var.b();
                } else if (!TextUtils.equals(optJSONObject.optString("errno"), "0")) {
                    b43Var.b();
                } else {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                    if (optJSONObject2 == null) {
                        b43Var.c();
                    } else {
                        if (d) {
                            Log.d("SwanAppUpdateManager", "doRequestSuccess: node => " + b43Var.a() + " update");
                        }
                        b43Var.d(str, optJSONObject2, str2);
                        String optString = optJSONObject.optString("version", "");
                        if (!TextUtils.isEmpty(optString)) {
                            if (d) {
                                Log.d("SwanAppUpdateManager", "doRequestSuccess: " + b43Var.a() + " update , version " + optString);
                            }
                            arrayMap.put(b43Var.a(), optString);
                            z = true;
                        }
                    }
                }
            }
            if (z) {
                A(list, arrayMap);
            }
            o(true);
        }
    }

    public final void f(@NonNull List<b43> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list.size() == 0) {
                c92.k("SwanAppUpdateManager", "doUpdate: finish => nodes are empty");
                p();
                return;
            }
            if (d) {
                Log.d("SwanAppUpdateManager", "doUpdate: start => nodes size " + list.size());
            }
            if (this.b.incrementAndGet() > 1) {
                c92.k("SwanAppUpdateManager", "doUpdate: pending => wait previous request");
                return;
            }
            ArrayMap<String, String> i = i(this.a);
            JSONObject c = c(list, i);
            if (c == null) {
                c92.k("SwanAppUpdateManager", "doUpdate: finish => build params is null");
                p();
                return;
            }
            if (d) {
                Log.w("SwanAppUpdateManager", "doUpdate: start to request update data");
            }
            FormBody build = new FormBody.Builder().add("data", c.toString()).build();
            String b2 = jv2.o().b();
            c92.k("SwanAppUpdateManager", "appId =" + bc3.K().getAppId() + ", update url = " + b2 + ",body=" + c);
            j(bc3.K().getAppId(), b2, build, list, i);
        }
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (bc3.K().E()) {
                return bc3.K().q().e0().n(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
            }
            return System.currentTimeMillis();
        }
        return invokeV.longValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            long h = h();
            if (h <= 0) {
                return true;
            }
            if (System.currentTimeMillis() - h > mo4.b(bc3.K().getAppId())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "onUpdateFinish: real finish update");
            }
            this.b.set(0);
            Iterator<z33> it = this.c.iterator();
            while (it.hasNext()) {
                ah3.l(new b(this, it.next()));
            }
            this.c.clear();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            boolean m = bc3.K().q().e0().m("swan_service_update_degraded", false);
            c92.i("SwanAppUpdateManager", "tryUpdate, isServiceDegraded = " + m);
            if (!m) {
                z(null);
            }
        }
    }

    @NonNull
    public final ArrayMap<String, String> i(@NonNull List<b43> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            if (list.size() == 0) {
                return arrayMap;
            }
            for (b43 b43Var : list) {
                arrayMap.put(b43Var.a(), "");
            }
            cc3 M = cc3.M();
            if (M == null) {
                return arrayMap;
            }
            String q = M.e0().q("update_nodes_version", "");
            if (TextUtils.isEmpty(q)) {
                return arrayMap;
            }
            try {
                JSONObject jSONObject = new JSONObject(q);
                for (b43 b43Var2 : list) {
                    arrayMap.put(b43Var2.a(), jSONObject.optString(b43Var2.a(), ""));
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

    public final void j(String str, String str2, RequestBody requestBody, List<b43> list, ArrayMap<String, String> arrayMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, str2, requestBody, list, arrayMap) == null) {
            fj4 fj4Var = new fj4(str2, requestBody, new a(this, str, list, arrayMap, str2));
            fj4Var.f = true;
            fj4Var.g = true;
            fj4Var.h = false;
            fj4Var.k = 20;
            gj4.g().e(fj4Var);
            hj3.a(SwanInterfaceType.UPDATE);
        }
    }

    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "onRequestFinish: request finish");
            }
            if (this.b.decrementAndGet() > 0) {
                if (d) {
                    Log.d("SwanAppUpdateManager", "onRequestFinish: do pending request");
                }
                this.b.set(0);
                if (!z) {
                    update();
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, jSONObject)) == null) {
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

    public void z(@Nullable z33 z33Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, z33Var) == null) {
            if (m()) {
                if (d) {
                    Log.d("SwanAppUpdateManager", "tryUpdate: start => cache data invalid");
                }
                update(z33Var);
                return;
            }
            if (d) {
                Log.d("SwanAppUpdateManager", "tryUpdate: finish => cache data valid");
            }
            if (z33Var != null) {
                z33Var.a();
            }
        }
    }

    public void q(@NonNull kk3 kk3Var, @NonNull JSONObject jSONObject) {
        int length;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, kk3Var, jSONObject) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (d) {
                Log.d("SwanAppUpdateManager", "parse increment accredit node start");
            }
            String string = kk3Var.getString("node_data_accredit_list", "");
            c92.k("SwanAppUpdateManager", "prefName: " + kk3Var.g() + ",cacheData is Empty = " + TextUtils.isEmpty(string) + ":accreditNodeObj=" + jSONObject);
            if (TextUtils.isEmpty(string)) {
                JSONObject jSONObject3 = new JSONObject();
                cp3.f(jSONObject3, "list", jSONObject);
                String jSONObject4 = jSONObject3.toString();
                kk3Var.putString("node_data_accredit_list", jSONObject4);
                kk3Var.putString("cur_request_id", "pkgInfo:" + System.currentTimeMillis());
                if (d) {
                    Log.d("SwanAppUpdateManager", "local has no cache data, write directly. pending data = " + jSONObject4);
                }
            } else {
                HashMap<String, JSONObject> r = r(jSONObject);
                if (r != null && r.size() != 0) {
                    JSONObject d2 = cp3.d(string);
                    JSONObject optJSONObject = d2.optJSONObject("list");
                    if (optJSONObject == null) {
                        cp3.f(d2, "list", jSONObject);
                        kk3Var.putString("node_data_accredit_list", d2.toString());
                        kk3Var.putString("cur_request_id", "pkgInfo:" + System.currentTimeMillis());
                        c92.k("SwanAppUpdateManager", "local has cache data, but list node is empty");
                        return;
                    }
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next) && (jSONObject2 = r.get(next)) != null) {
                            cp3.f(optJSONObject, next, jSONObject2);
                        }
                    }
                    cp3.f(d2, "list", optJSONObject);
                    kk3Var.putString("node_data_accredit_list", d2.toString());
                    String string2 = kk3Var.getString("cur_request_id", "");
                    if (!TextUtils.isEmpty(string2) && (length = string2.length()) > 100) {
                        string2 = string2.substring(length - 100);
                    }
                    kk3Var.putString("cur_request_id", string2 + ";merge:" + System.currentTimeMillis());
                    c92.k("SwanAppUpdateManager", "prefName: " + kk3Var.g() + ",mergeAccredit = " + d2);
                } else {
                    c92.k("SwanAppUpdateManager", "local has cache data, but pending data is empty");
                    return;
                }
            }
            if (d) {
                Log.d("SwanAppUpdateManager", "parse increment accredit node end, cost = " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public final void s(String str, Response response, @NonNull List<b43> list, @NonNull ArrayMap<String, String> arrayMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048592, this, str, response, list, arrayMap) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "onResponse: update request return");
            }
            String str2 = null;
            if (!response.isSuccessful()) {
                d(list);
                hj3.c(SwanInterfaceType.UPDATE, RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, null, response);
                return;
            }
            ResponseBody body = response.body();
            if (body == null) {
                d(list);
                hj3.c(SwanInterfaceType.UPDATE, 2103, null, response);
                return;
            }
            try {
                str2 = body.string();
            } catch (IOException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
            c92.k("SwanAppUpdateManager", "response body = " + str2);
            if (TextUtils.isEmpty(str2)) {
                d(list);
                hj3.c(SwanInterfaceType.UPDATE, 2103, str2, response);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                    d(list);
                    hj3.c(SwanInterfaceType.UPDATE, jSONObject.optInt("errno", 2103), str2, response);
                    return;
                }
                String optString = jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, "");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                c92.k("SwanAppUpdateManager", "request_id = " + optString);
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
                hj3.c(SwanInterfaceType.UPDATE, 2103, str2, response);
            }
        }
    }
}
