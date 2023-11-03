package com.baidu.tieba;

import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tieba.k53;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.AbstractBceClient;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class nz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public static nz2 f;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, JSONArray> a;
    public String[] b;
    public String c;
    public Map<String, String> d;

    /* loaded from: classes7.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void c(String str);

        public a() {
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

        public final void b(int i) {
            Application c;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (c = np2.c()) != null) {
                c(c.getString(i));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AtomicInteger a;
        public boolean b;
        public int c;
        public a d;
        public final /* synthetic */ nz2 e;

        public b(nz2 nz2Var, int i, a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz2Var, Integer.valueOf(i), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = nz2Var;
            this.a = new AtomicInteger(0);
            this.c = i;
            this.d = aVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, exc) == null) && !this.b && this.a.incrementAndGet() >= this.c && (aVar = this.d) != null) {
                aVar.b(R.string.obfuscated_res_0x7f0f017a);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
                this.b = true;
                this.e.a = new ArrayMap();
                a aVar = this.d;
                if (aVar != null) {
                    aVar.b(R.string.obfuscated_res_0x7f0f017e);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                if (response != null && response.body() != null && response.isSuccessful()) {
                    try {
                        return response.body().string();
                    } catch (IOException e) {
                        if (nz2.e) {
                            Log.d("TraceDataManager", "Trace Data publish fail for IOException", e);
                        }
                    }
                }
                return null;
            }
            return invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948019683, "Lcom/baidu/tieba/nz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948019683, "Lcom/baidu/tieba/nz2;");
                return;
            }
        }
        e = rm1.a;
    }

    public static nz2 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f == null) {
                synchronized (nz2.class) {
                    if (f == null) {
                        f = new nz2();
                    }
                }
            }
            return f;
        }
        return (nz2) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String[] strArr = this.b;
            if (strArr != null && strArr.length > 0 && !TextUtils.isEmpty(this.c)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public nz2() {
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
        this.a = new ArrayMap();
        this.c = "";
        this.d = new HashMap();
    }

    public void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && this.a != null && jSONObject != null) {
            String U = tr2.V().U();
            JSONArray jSONArray = this.a.get(U);
            if (jSONArray == null) {
                jSONArray = new JSONArray();
                this.a.put(U, jSONArray);
            }
            jSONArray.put(jSONObject);
        }
    }

    public final String d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (f() && i < this.b.length) {
                StringBuilder sb = new StringBuilder();
                sb.append("http://");
                sb.append(this.b[i]);
                sb.append(":");
                sb.append(this.c);
                sb.append("/uploadTraceData");
                sb.append("?");
                for (Map.Entry<String, String> entry : this.d.entrySet()) {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                }
                return sb.toString();
            }
            return "";
        }
        return (String) invokeI.objValue;
    }

    public void h(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, bundle) != null) || bundle == null) {
            return;
        }
        String string = bundle.getString("tool_ip");
        String string2 = bundle.getString("tool_port");
        String string3 = bundle.getString("projectId");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
            if (e) {
                Log.d("TraceDataManager", "IP : " + string);
                Log.d("TraceDataManager", "Port : " + string2);
                Log.d("TraceDataManager", "Project ID : " + string3);
            }
            this.b = string.split("_");
            this.c = string2;
            this.d.put("projectId", string3);
        } else if (e) {
            Log.d("TraceDataManager", "Trace Data Params is invalid");
        }
    }

    public void g(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (!f()) {
                y53.f(f63.K().w(), R.string.obfuscated_res_0x7f0f017b).G();
                return;
            }
            Map<String, JSONArray> map = this.a;
            if (map != null && map.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                try {
                    for (Map.Entry<String, JSONArray> entry : this.a.entrySet()) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.putOpt("path", entry.getKey());
                        jSONObject.putOpt("data", entry.getValue().toString());
                        jSONArray.put(jSONObject);
                    }
                } catch (JSONException e2) {
                    if (e) {
                        Log.e("TraceDataManager", "Maybe the format of the Trace data is incorrect", e2);
                    }
                }
                ed4 postRequest = kd4.g().postRequest();
                postRequest.requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONArray.toString()));
                postRequest.connectionTimeout(3000);
                int min = Math.min(this.b.length, 4);
                b bVar = new b(this, min, aVar);
                for (int i = 0; i < min; i++) {
                    postRequest.url(d(i));
                    postRequest.build().executeAsync(bVar);
                }
                return;
            }
            k53.a aVar2 = new k53.a(f63.K().w());
            aVar2.U(R.string.obfuscated_res_0x7f0f017d);
            aVar2.v(R.string.obfuscated_res_0x7f0f017c);
            aVar2.n(new ol3());
            aVar2.O(R.string.obfuscated_res_0x7f0f0149, null);
            aVar2.X();
        }
    }
}
