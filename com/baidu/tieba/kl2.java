package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.rh2;
import com.baidu.tieba.us2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class kl2 implements lo1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements il2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ us2 a;

        public a(us2 us2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = us2Var;
        }

        @Override // com.baidu.tieba.il2
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                af2.u(AppRuntime.getAppContext().getContentResolver(), this.a.H(), 1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ il2 a;

        public b(il2 il2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {il2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = il2Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            il2 il2Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, exc) != null) || (il2Var = this.a) == null) {
                return;
            }
            il2Var.onResult(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            il2 il2Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) != null) || (il2Var = this.a) == null) {
                return;
            }
            if (jSONObject == null) {
                il2Var.onResult(false);
                return;
            }
            if (kl2.a) {
                Log.d("SwanHistoryManager", "上报数据 onSuccess: response=" + jSONObject);
            }
            if (jSONObject.optInt("errno", -1) == 0) {
                this.a.onResult(true);
            } else {
                this.a.onResult(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                if (response != null && response.body() != null) {
                    return xk3.d(response.body().string());
                }
                return null;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kl2.h(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements hl2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.hl2
        public void a(List<jl2> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || list == null) {
                return;
            }
            af2.f();
            af2.l(list);
        }
    }

    /* loaded from: classes5.dex */
    public static class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hl2 a;

        public e(hl2 hl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hl2Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            hl2 hl2Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, exc) == null) && (hl2Var = this.a) != null) {
                hl2Var.a(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            hl2 hl2Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) != null) || (hl2Var = this.a) == null) {
                return;
            }
            if (jSONObject == null) {
                hl2Var.a(null);
                return;
            }
            if (kl2.a) {
                Log.d("SwanHistoryManager", "下拉数据 onSuccess: response=" + jSONObject);
            }
            if (jSONObject.optInt("errno", -1) != 0) {
                this.a.a(null);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                this.a.a(null);
                return;
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("items");
            if (optJSONArray == null) {
                this.a.a(null);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                jl2 b = jl2.b(optJSONArray.optJSONObject(i2));
                if (b != null) {
                    arrayList.add(b);
                }
            }
            lg3.a().putString("fetch_history_data_last_id", optJSONObject.optString(ImageViewerConfig.LAST_ID));
            this.a.a(arrayList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                if (response != null && response.body() != null) {
                    return xk3.d(response.body().string());
                }
                return null;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public static final kl2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-657661322, "Lcom/baidu/tieba/kl2$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-657661322, "Lcom/baidu/tieba/kl2$f;");
                    return;
                }
            }
            a = new kl2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947916856, "Lcom/baidu/tieba/kl2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947916856, "Lcom/baidu/tieba/kl2;");
                return;
            }
        }
        a = ho1.a;
    }

    public kl2() {
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
        er2.h0().c(this);
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            rk3.k(new c(), "fetchHistoryDataFromServer");
        }
    }

    public static kl2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return f.a;
        }
        return (kl2) invokeV.objValue;
    }

    public /* synthetic */ kl2(a aVar) {
        this();
    }

    public static void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            List<jl2> r = af2.r();
            if (!z && (r == null || r.size() <= 0)) {
                return;
            }
            g("ADD", r, new d());
        }
    }

    @Override // com.baidu.tieba.lo1
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            f();
        }
    }

    @WorkerThread
    public static void c(x73 x73Var, rh2.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, x73Var, bVar) != null) || x73Var == null) {
            return;
        }
        us2.a W = x73Var.W();
        if (TextUtils.equals("1", W.c0())) {
            x42.b("SwanHistoryManager", "add history with 'notinhis=1': " + W.H() + "/" + W.K());
            return;
        }
        x42.b("SwanHistoryManager", "add history: " + W.H() + "/" + W.K());
        jl2 a2 = jl2.a(W);
        boolean c2 = af2.c(AppRuntime.getAppContext().getContentResolver(), a2, bVar);
        a aVar = new a(W);
        if (c2) {
            j("ADD", a2.a, a2.e, a2.b, a2.g, a2.j, aVar);
        }
        if (a && !c2) {
            Log.e("SwanHistoryManager", "addHistoryAsync Failed!");
        }
    }

    public static String d(String str, List<jl2> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, list)) == null) {
            if (list != null && list.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                try {
                    for (jl2 jl2Var : list) {
                        if (jl2Var != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("cmd", str);
                            jSONObject2.put("bundle_id", jl2Var.a);
                            jSONObject2.put("time", jl2Var.e);
                            jSONArray.put(jSONObject2);
                        }
                    }
                    jSONObject.put("items", jSONArray);
                } catch (JSONException e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                }
                return jSONObject.toString();
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String e(String str, String str2, long j, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{str, str2, Long.valueOf(j), str3, str4, str5})) == null) {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("cmd", str);
                if (TextUtils.isEmpty(str3)) {
                    jSONObject2.put("bundle_id", str2);
                } else {
                    jSONObject2.put("appkey", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("pkg_type", Integer.parseInt(str4));
                }
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject2.put("version_code", Integer.parseInt(str5));
                }
                jSONObject2.put("time", j);
                jSONArray.put(jSONObject2);
                jSONObject.put("items", jSONArray);
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static void g(String str, List<jl2> list, hl2 hl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, list, hl2Var) == null) {
            String p = er2.o().p();
            HashMap hashMap = new HashMap();
            hashMap.put(ImageViewerConfig.LAST_ID, lg3.a().getString("fetch_history_data_last_id", ""));
            String b2 = pl3.b(p, hashMap);
            String d2 = d(str, list);
            if (a) {
                Log.d("SwanHistoryManager", "fetchHistoryDataFromServer: url=" + b2 + "  params=" + d2);
            }
            e eVar = new e(hl2Var);
            af4 af4Var = new af4();
            af4Var.b = "POST";
            af4Var.a = b2;
            af4Var.f = true;
            af4Var.g = true;
            if (!TextUtils.isEmpty(d2)) {
                af4Var.d = RequestBody.create(ez2.a, d2);
            }
            af4Var.e = eVar;
            bf4.g().e(af4Var);
        }
    }

    public static void j(String str, String str2, long j, String str3, String str4, String str5, il2 il2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{str, str2, Long.valueOf(j), str3, str4, str5, il2Var}) == null) {
            String c2 = er2.o().c();
            String e2 = e(str, str2, j, str3, str4, str5);
            if (TextUtils.isEmpty(e2)) {
                return;
            }
            if (a) {
                Log.d("SwanHistoryManager", "reportHistoryDataToServer: 上行参数" + e2);
            }
            b bVar = new b(il2Var);
            af4 af4Var = new af4();
            af4Var.b = "POST";
            af4Var.a = c2;
            af4Var.f = true;
            af4Var.g = true;
            af4Var.d = RequestBody.create(ez2.a, e2);
            af4Var.e = bVar;
            bf4.g().e(af4Var);
        }
    }
}
