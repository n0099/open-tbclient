package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.pl2;
import com.baidu.tieba.sw2;
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
/* loaded from: classes6.dex */
public class ip2 implements js1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements gp2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sw2 a;

        public a(sw2 sw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sw2Var;
        }

        @Override // com.baidu.tieba.gp2
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                yi2.u(AppRuntime.getAppContext().getContentResolver(), this.a.H(), 1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gp2 a;

        public b(gp2 gp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gp2Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            gp2 gp2Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, exc) != null) || (gp2Var = this.a) == null) {
                return;
            }
            gp2Var.onResult(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            gp2 gp2Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) != null) || (gp2Var = this.a) == null) {
                return;
            }
            if (jSONObject == null) {
                gp2Var.onResult(false);
                return;
            }
            if (ip2.a) {
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
                    return vo3.d(response.body().string());
                }
                return null;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes6.dex */
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
                ip2.h(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements fp2 {
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

        @Override // com.baidu.tieba.fp2
        public void a(List<hp2> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || list == null) {
                return;
            }
            yi2.f();
            yi2.l(list);
        }
    }

    /* loaded from: classes6.dex */
    public static class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fp2 a;

        public e(fp2 fp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fp2Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            fp2 fp2Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, exc) == null) && (fp2Var = this.a) != null) {
                fp2Var.a(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            fp2 fp2Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) != null) || (fp2Var = this.a) == null) {
                return;
            }
            if (jSONObject == null) {
                fp2Var.a(null);
                return;
            }
            if (ip2.a) {
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
                hp2 b = hp2.b(optJSONArray.optJSONObject(i2));
                if (b != null) {
                    arrayList.add(b);
                }
            }
            jk3.a().putString("fetch_history_data_last_id", optJSONObject.optString(ImageViewerConfig.LAST_ID));
            this.a.a(arrayList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                if (response != null && response.body() != null) {
                    return vo3.d(response.body().string());
                }
                return null;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public static final ip2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-711225540, "Lcom/baidu/tieba/ip2$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-711225540, "Lcom/baidu/tieba/ip2$f;");
                    return;
                }
            }
            a = new ip2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947861118, "Lcom/baidu/tieba/ip2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947861118, "Lcom/baidu/tieba/ip2;");
                return;
            }
        }
        a = fs1.a;
    }

    public ip2() {
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
        cv2.h0().c(this);
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            po3.k(new c(), "fetchHistoryDataFromServer");
        }
    }

    public static ip2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return f.a;
        }
        return (ip2) invokeV.objValue;
    }

    public /* synthetic */ ip2(a aVar) {
        this();
    }

    public static void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            List<hp2> r = yi2.r();
            if (!z && (r == null || r.size() <= 0)) {
                return;
            }
            g("ADD", r, new d());
        }
    }

    @Override // com.baidu.tieba.js1
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            f();
        }
    }

    @WorkerThread
    public static void c(vb3 vb3Var, pl2.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, vb3Var, bVar) != null) || vb3Var == null) {
            return;
        }
        sw2.a W = vb3Var.W();
        if (TextUtils.equals("1", W.c0())) {
            v82.b("SwanHistoryManager", "add history with 'notinhis=1': " + W.H() + "/" + W.K());
            return;
        }
        v82.b("SwanHistoryManager", "add history: " + W.H() + "/" + W.K());
        hp2 a2 = hp2.a(W);
        boolean c2 = yi2.c(AppRuntime.getAppContext().getContentResolver(), a2, bVar);
        a aVar = new a(W);
        if (c2) {
            j("ADD", a2.a, a2.e, a2.b, a2.g, a2.j, aVar);
        }
        if (a && !c2) {
            Log.e("SwanHistoryManager", "addHistoryAsync Failed!");
        }
    }

    public static String d(String str, List<hp2> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, list)) == null) {
            if (list != null && list.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                try {
                    for (hp2 hp2Var : list) {
                        if (hp2Var != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("cmd", str);
                            jSONObject2.put("bundle_id", hp2Var.a);
                            jSONObject2.put("time", hp2Var.e);
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

    public static void g(String str, List<hp2> list, fp2 fp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, list, fp2Var) == null) {
            String p = cv2.o().p();
            HashMap hashMap = new HashMap();
            hashMap.put(ImageViewerConfig.LAST_ID, jk3.a().getString("fetch_history_data_last_id", ""));
            String b2 = np3.b(p, hashMap);
            String d2 = d(str, list);
            if (a) {
                Log.d("SwanHistoryManager", "fetchHistoryDataFromServer: url=" + b2 + "  params=" + d2);
            }
            e eVar = new e(fp2Var);
            yi4 yi4Var = new yi4();
            yi4Var.b = "POST";
            yi4Var.a = b2;
            yi4Var.f = true;
            yi4Var.g = true;
            if (!TextUtils.isEmpty(d2)) {
                yi4Var.d = RequestBody.create(c33.a, d2);
            }
            yi4Var.e = eVar;
            zi4.g().e(yi4Var);
        }
    }

    public static void j(String str, String str2, long j, String str3, String str4, String str5, gp2 gp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{str, str2, Long.valueOf(j), str3, str4, str5, gp2Var}) == null) {
            String c2 = cv2.o().c();
            String e2 = e(str, str2, j, str3, str4, str5);
            if (TextUtils.isEmpty(e2)) {
                return;
            }
            if (a) {
                Log.d("SwanHistoryManager", "reportHistoryDataToServer: 上行参数" + e2);
            }
            b bVar = new b(gp2Var);
            yi4 yi4Var = new yi4();
            yi4Var.b = "POST";
            yi4Var.a = c2;
            yi4Var.f = true;
            yi4Var.g = true;
            yi4Var.d = RequestBody.create(c33.a, e2);
            yi4Var.e = bVar;
            zi4.g().e(yi4Var);
        }
    }
}
