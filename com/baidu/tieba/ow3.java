package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes7.dex */
public class ow3 implements lv1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final qy3<JSONObject> b;
    public static final long c;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.lv1
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
        }
    }

    @Override // com.baidu.tieba.lv1
    public File b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            return null;
        }
        return (File) invokeLL.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948046622, "Lcom/baidu/tieba/ow3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948046622, "Lcom/baidu/tieba/ow3;");
                return;
            }
        }
        a = rr1.a;
        b = new qy3<>();
        c = TimeUnit.MINUTES.toMillis(2L);
    }

    public ow3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.lv1
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.b();
        }
    }

    @Override // com.baidu.tieba.lv1
    public JSONObject c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            if (a) {
                Log.i("BoxPrivateBehavior", "getIMUnReadMessageList params=" + str);
            }
            String str2 = gb3.K().getAppId() + gb3.K().q().N().c(context);
            JSONObject c2 = b.c(str2);
            if (a) {
                Log.i("BoxPrivateBehavior", "getIMUnReadMessageList k=" + str2);
            }
            if (c2 != null) {
                if (a) {
                    Log.i("BoxPrivateBehavior", "getIMUnReadMessageList ret with cache=" + c2);
                }
                return c2;
            } else if (bp3.O()) {
                return null;
            } else {
                JSONObject f = f(context, str);
                if (a) {
                    Log.i("BoxPrivateBehavior", "getIMUnReadMessageList ret with request=" + f);
                }
                return b.a(str2, f, c);
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final JSONObject e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            ho3.f(jSONObject2, Constants.EXTRA_PA_TYPE, 7);
            ho3.f(jSONObject2, "pa_unread_sums", Integer.valueOf(i));
            jSONArray.put(jSONObject2);
            ho3.f(jSONObject, "un_read_list", jSONArray);
            return jSONObject;
        }
        return (JSONObject) invokeI.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
        r9 = r4.optString(com.baidu.android.imsdk.internal.Constants.EXTRA_PAUID_TYPE);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject f(Context context, String str) {
        InterceptResult invokeLL;
        String str2;
        ResponseBody responseBody;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, context, str)) == null) {
            hb3 b0 = hb3.b0();
            ResponseBody responseBody2 = null;
            if (b0 == null) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        if (optJSONObject.optInt(Constants.EXTRA_PA_TYPE) == 7) {
                            break;
                        }
                        i2++;
                    } else {
                        str2 = null;
                        break;
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
                String n = ou2.o().n();
                ki4 ki4Var = new ki4(n, new Request.Builder().url(n).post(new FormBody.Builder().add("appkey", b0.O()).add("pa", str2).build()).build().body(), null);
                ki4Var.f = true;
                ki4Var.g = true;
                ki4Var.h = true;
                ki4Var.b = "POST";
                HttpRequestBuilder a2 = mi4.a(ki4Var);
                li4.g().u(a2, ki4Var);
                try {
                    Response executeSync = a2.build().executeSync();
                    if (!executeSync.isSuccessful()) {
                        lr4.d(null);
                        return null;
                    }
                    responseBody = executeSync.body();
                    if (responseBody == null) {
                        lr4.d(responseBody);
                        return null;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(responseBody.string());
                        if (!"0".equals(jSONObject.optString("errno"))) {
                            lr4.d(responseBody);
                            return null;
                        }
                        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                        if (optJSONObject2 != null) {
                            i = optJSONObject2.optInt("num");
                        }
                        JSONObject e = e(i);
                        ou2.K().i(e);
                        lr4.d(responseBody);
                        return e;
                    } catch (IOException | JSONException unused) {
                        lr4.d(responseBody);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        responseBody2 = responseBody;
                        lr4.d(responseBody2);
                        throw th;
                    }
                } catch (IOException | JSONException unused2) {
                    responseBody = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (JSONException unused3) {
            }
        } else {
            return (JSONObject) invokeLL.objValue;
        }
    }
}
