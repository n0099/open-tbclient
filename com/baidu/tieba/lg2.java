package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.sc2;
import com.baidu.tieba.vn2;
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
/* loaded from: classes4.dex */
public class lg2 implements mj1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements jg2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vn2 a;

        public a(vn2 vn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vn2Var;
        }

        @Override // com.baidu.tieba.jg2
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                ba2.u(AppRuntime.getAppContext().getContentResolver(), this.a.H(), 1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jg2 a;

        public b(jg2 jg2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jg2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jg2Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            jg2 jg2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, exc) == null) || (jg2Var = this.a) == null) {
                return;
            }
            jg2Var.onResult(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            jg2 jg2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) || (jg2Var = this.a) == null) {
                return;
            }
            if (jSONObject != null) {
                if (lg2.a) {
                    Log.d("SwanHistoryManager", "上报数据 onSuccess: response=" + jSONObject);
                }
                if (jSONObject.optInt("errno", -1) == 0) {
                    this.a.onResult(true);
                    return;
                } else {
                    this.a.onResult(false);
                    return;
                }
            }
            jg2Var.onResult(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                if (response == null || response.body() == null) {
                    return null;
                }
                return yf3.d(response.body().string());
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes4.dex */
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
                lg2.h(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements ig2 {
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

        @Override // com.baidu.tieba.ig2
        public void a(List<kg2> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
                return;
            }
            ba2.f();
            ba2.l(list);
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ig2 a;

        public e(ig2 ig2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ig2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ig2Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            ig2 ig2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, exc) == null) || (ig2Var = this.a) == null) {
                return;
            }
            ig2Var.a(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            ig2 ig2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) || (ig2Var = this.a) == null) {
                return;
            }
            if (jSONObject != null) {
                if (lg2.a) {
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
                    kg2 b = kg2.b(optJSONArray.optJSONObject(i2));
                    if (b != null) {
                        arrayList.add(b);
                    }
                }
                mb3.a().putString("fetch_history_data_last_id", optJSONObject.optString(ImageViewerConfig.LAST_ID));
                this.a.a(arrayList);
                return;
            }
            ig2Var.a(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                if (response == null || response.body() == null) {
                    return null;
                }
                return yf3.d(response.body().string());
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public static final lg2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-633649776, "Lcom/baidu/tieba/lg2$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-633649776, "Lcom/baidu/tieba/lg2$f;");
                    return;
                }
            }
            a = new lg2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947941842, "Lcom/baidu/tieba/lg2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947941842, "Lcom/baidu/tieba/lg2;");
                return;
            }
        }
        a = ij1.a;
    }

    public /* synthetic */ lg2(a aVar) {
        this();
    }

    @WorkerThread
    public static void c(y23 y23Var, sc2.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, y23Var, bVar) == null) || y23Var == null) {
            return;
        }
        vn2.a W = y23Var.W();
        if (TextUtils.equals("1", W.c0())) {
            yz1.b("SwanHistoryManager", "add history with 'notinhis=1': " + W.H() + "/" + W.K());
            return;
        }
        yz1.b("SwanHistoryManager", "add history: " + W.H() + "/" + W.K());
        kg2 a2 = kg2.a(W);
        boolean c2 = ba2.c(AppRuntime.getAppContext().getContentResolver(), a2, bVar);
        a aVar = new a(W);
        if (c2) {
            j("ADD", a2.a, a2.e, a2.b, a2.g, a2.j, aVar);
        }
        if (!a || c2) {
            return;
        }
        Log.e("SwanHistoryManager", "addHistoryAsync Failed!");
    }

    public static String d(String str, List<kg2> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, list)) == null) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                for (kg2 kg2Var : list) {
                    if (kg2Var != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("cmd", str);
                        jSONObject2.put("bundle_id", kg2Var.a);
                        jSONObject2.put("time", kg2Var.e);
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

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            sf3.k(new c(), "fetchHistoryDataFromServer");
        }
    }

    public static void g(String str, List<kg2> list, ig2 ig2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, list, ig2Var) == null) {
            String p = fm2.o().p();
            HashMap hashMap = new HashMap();
            hashMap.put(ImageViewerConfig.LAST_ID, mb3.a().getString("fetch_history_data_last_id", ""));
            String b2 = qg3.b(p, hashMap);
            String d2 = d(str, list);
            if (a) {
                Log.d("SwanHistoryManager", "fetchHistoryDataFromServer: url=" + b2 + "  params=" + d2);
            }
            e eVar = new e(ig2Var);
            ba4 ba4Var = new ba4();
            ba4Var.b = "POST";
            ba4Var.a = b2;
            ba4Var.f = true;
            ba4Var.g = true;
            if (!TextUtils.isEmpty(d2)) {
                ba4Var.d = RequestBody.create(fu2.a, d2);
            }
            ba4Var.e = eVar;
            ca4.g().e(ba4Var);
        }
    }

    public static void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            List<kg2> r = ba2.r();
            if (z || (r != null && r.size() > 0)) {
                g("ADD", r, new d());
            }
        }
    }

    public static lg2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? f.a : (lg2) invokeV.objValue;
    }

    public static void j(String str, String str2, long j, String str3, String str4, String str5, jg2 jg2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{str, str2, Long.valueOf(j), str3, str4, str5, jg2Var}) == null) {
            String c2 = fm2.o().c();
            String e2 = e(str, str2, j, str3, str4, str5);
            if (TextUtils.isEmpty(e2)) {
                return;
            }
            if (a) {
                Log.d("SwanHistoryManager", "reportHistoryDataToServer: 上行参数" + e2);
            }
            b bVar = new b(jg2Var);
            ba4 ba4Var = new ba4();
            ba4Var.b = "POST";
            ba4Var.a = c2;
            ba4Var.f = true;
            ba4Var.g = true;
            ba4Var.d = RequestBody.create(fu2.a, e2);
            ba4Var.e = bVar;
            ca4.g().e(ba4Var);
        }
    }

    @Override // com.baidu.tieba.mj1
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            f();
        }
    }

    public lg2() {
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
        fm2.h0().c(this);
    }
}
