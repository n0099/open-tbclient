package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.v8engine.FontParser;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class t24 extends r24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public va2 b;

    /* loaded from: classes5.dex */
    public class a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z24 a;
        public final /* synthetic */ sv1 b;
        public final /* synthetic */ t24 c;

        /* renamed from: com.baidu.tieba.t24$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0420a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONObject a;
            public final /* synthetic */ a b;

            public RunnableC0420a(a aVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    x54.call(this.b.b, true, this.a);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.a;
                    x54.call(aVar.b, false, aVar.a);
                }
            }
        }

        public a(t24 t24Var, z24 z24Var, sv1 sv1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t24Var, z24Var, sv1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = t24Var;
            this.a = z24Var;
            this.b = sv1Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (r24.a) {
                    Log.e("OpenDataApi", "on fail");
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    z24 z24Var = this.a;
                    z24Var.errNo = "100";
                    z24Var.errMsg = String.format("%s: fail Error: %s", "getUserInfo", exc.getMessage());
                }
                this.c.b.post(new b(this));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (r24.a) {
                    Log.d("OpenDataApi", "on success");
                }
                this.c.b.post(new RunnableC0420a(this, jSONObject));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (r24.a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (r24.a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    z24 z24Var = this.a;
                    z24Var.errNo = optString;
                    z24Var.errMsg = String.format("%s: fail Error: %s", "getUserInfo", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put(StatConstants.KEY_EXT_ERR_MSG, x54.b("getUserInfo", "ok"));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends ResponseCallback<z24> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z24 a;
        public final /* synthetic */ sv1 b;
        public final /* synthetic */ t24 c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ z24 a;
            public final /* synthetic */ b b;

            public a(b bVar, z24 z24Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, z24Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = z24Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    x54.call(this.b.b, true, this.a);
                }
            }
        }

        /* renamed from: com.baidu.tieba.t24$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0421b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public RunnableC0421b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.a;
                    x54.call(bVar.b, false, bVar.a);
                }
            }
        }

        public b(t24 t24Var, z24 z24Var, sv1 sv1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t24Var, z24Var, sv1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = t24Var;
            this.a = z24Var;
            this.b = sv1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(z24 z24Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, z24Var, i) == null) {
                if (r24.a) {
                    Log.d("OpenDataApi", "on success ");
                }
                this.c.b.post(new a(this, z24Var));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public z24 parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (r24.a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (r24.a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    z24 z24Var = this.a;
                    z24Var.errNo = optString;
                    z24Var.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                z24 z24Var2 = this.a;
                z24Var2.errNo = "0";
                z24Var2.errMsg = x54.b("removeUserCloudStorage", "ok");
                return this.a;
            }
            return (z24) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (r24.a) {
                    Log.d("OpenDataApi", "on fail");
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    z24 z24Var = this.a;
                    z24Var.errNo = "100";
                    z24Var.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", exc.getMessage());
                }
                this.c.b.post(new RunnableC0421b(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z24 a;
        public final /* synthetic */ sv1 b;
        public final /* synthetic */ t24 c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONObject a;
            public final /* synthetic */ c b;

            public a(c cVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    x54.call(this.b.b, true, this.a);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.a;
                    x54.call(cVar.b, false, cVar.a);
                }
            }
        }

        public c(t24 t24Var, z24 z24Var, sv1 sv1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t24Var, z24Var, sv1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = t24Var;
            this.a = z24Var;
            this.b = sv1Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (r24.a) {
                    Log.e("OpenDataApi", "on fail");
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    z24 z24Var = this.a;
                    z24Var.errNo = "100";
                    z24Var.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", exc.getMessage());
                }
                this.c.b.post(new b(this));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (r24.a) {
                    Log.d("OpenDataApi", "on success");
                }
                this.c.b.post(new a(this, jSONObject));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (r24.a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (r24.a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    z24 z24Var = this.a;
                    z24Var.errNo = optString;
                    z24Var.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put(StatConstants.KEY_EXT_ERR_MSG, x54.b("getUserCloudStorage", "ok"));
                jSONObject2.put("KVDataList", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d extends ResponseCallback<z24> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z24 a;
        public final /* synthetic */ sv1 b;
        public final /* synthetic */ t24 c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ z24 a;
            public final /* synthetic */ d b;

            public a(d dVar, z24 z24Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, z24Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = z24Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    x54.call(this.b.b, true, this.a);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.a;
                    x54.call(dVar.b, false, dVar.a);
                }
            }
        }

        public d(t24 t24Var, z24 z24Var, sv1 sv1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t24Var, z24Var, sv1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = t24Var;
            this.a = z24Var;
            this.b = sv1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(z24 z24Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, z24Var, i) == null) {
                if (r24.a) {
                    Log.d("OpenDataApi", "on success");
                }
                this.c.b.post(new a(this, z24Var));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public z24 parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (r24.a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (r24.a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    z24 z24Var = this.a;
                    z24Var.errNo = optString;
                    z24Var.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                z24 z24Var2 = this.a;
                z24Var2.errNo = "0";
                z24Var2.errMsg = x54.b("setUserCloudStorage", "ok");
                return this.a;
            }
            return (z24) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (r24.a) {
                    Log.e("OpenDataApi", "on fail");
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    z24 z24Var = this.a;
                    z24Var.errNo = "100";
                    z24Var.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", exc.getMessage());
                }
                this.c.b.post(new b(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z24 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ sv1 c;
        public final /* synthetic */ t24 d;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONObject a;
            public final /* synthetic */ e b;

            public a(e eVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    x54.call(this.b.c, true, this.a);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e eVar = this.a;
                    x54.call(eVar.c, false, eVar.a);
                }
            }
        }

        public e(t24 t24Var, z24 z24Var, String str, sv1 sv1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t24Var, z24Var, str, sv1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = t24Var;
            this.a = z24Var;
            this.b = str;
            this.c = sv1Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (r24.a) {
                    Log.e("OpenDataApi", "on fail");
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    z24 z24Var = this.a;
                    z24Var.errNo = "100";
                    z24Var.errMsg = String.format("%s: fail Error: %s", this.b, exc.getMessage());
                }
                this.d.b.post(new b(this));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (r24.a) {
                    Log.d("OpenDataApi", "on success");
                }
                this.d.b.post(new a(this, jSONObject));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (r24.a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (r24.a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    z24 z24Var = this.a;
                    z24Var.errNo = optString;
                    z24Var.errMsg = String.format("%s: fail Error: %s", this.b, jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put(StatConstants.KEY_EXT_ERR_MSG, x54.b(this.b, "ok"));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    public t24(@NonNull va2 va2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {va2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = va2Var;
    }

    public final y24[] c(sv1 sv1Var, JsObject[] jsObjectArr, z24 z24Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, sv1Var, jsObjectArr, z24Var)) == null) {
            int length = jsObjectArr.length;
            if (length < 1) {
                z24Var.errMsg = x54.b("setUserCloudStorage", "fail KVDataList.length must greater than 0");
                x54.call(sv1Var, false, z24Var);
                return null;
            } else if (length > 128) {
                z24Var.errMsg = x54.b("setUserCloudStorage", "fail user has stored too much keys. delete some keys and try again");
                x54.call(sv1Var, false, z24Var);
                return null;
            } else {
                y24[] y24VarArr = new y24[length];
                for (int i = 0; i < length; i++) {
                    sv1 F = sv1.F(jsObjectArr[i]);
                    if (F != null && F.k() == 2 && !TextUtils.isEmpty(F.B("key")) && !TextUtils.isEmpty(F.B("value"))) {
                        y24VarArr[i] = new y24();
                        y24VarArr[i].key = F.B("key");
                        y24VarArr[i].value = F.B("value");
                        if (!y24VarArr[i].a()) {
                            z24Var.errMsg = x54.b("setUserCloudStorage", "fail some keys in list meet length exceed");
                            x54.call(sv1Var, false, z24Var);
                            return null;
                        } else if (!y24VarArr[i].b()) {
                            z24Var.errMsg = x54.b("setUserCloudStorage", "fail some key-value in list meet length exceed");
                            x54.call(sv1Var, false, z24Var);
                            return null;
                        }
                    } else {
                        z24Var.errMsg = x54.b("setUserCloudStorage", "fail invalid KVData item");
                        x54.call(sv1Var, false, z24Var);
                        return null;
                    }
                }
                return y24VarArr;
            }
        }
        return (y24[]) invokeLLL.objValue;
    }

    public final void d(JsObject jsObject, int i) {
        sv1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject, i) == null) || (F = sv1.F(jsObject)) == null) {
            return;
        }
        if (i == 5) {
            z24 z24Var = new z24();
            if (!g()) {
                z24Var.errNo = FontParser.sFontWeightDefault;
                z24Var.errMsg = x54.b("getFriendCloudStorage", "fail must login before calling");
                x54.call(F, false, z24Var);
                h(jsObject);
                return;
            }
            try {
                String[] h = F.h("keyList");
                h(jsObject);
                j(i, h, new e(this, z24Var, "getFriendCloudStorage", F));
                return;
            } catch (JSTypeMismatchException e2) {
                if (r24.a) {
                    e2.printStackTrace();
                }
                z24Var.errNo = FontParser.sFontWeightDefault;
                z24Var.errMsg = x54.b("getFriendCloudStorage", "fail invalid keyList");
                x54.call(F, false, z24Var);
                h(jsObject);
                return;
            }
        }
        h(jsObject);
    }

    public final JSONObject e(y24[] y24VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, y24VarArr)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", l33.g0());
                JSONArray jSONArray = new JSONArray();
                for (y24 y24Var : y24VarArr) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("key", y24Var.key);
                    jSONObject2.put("value", y24Var.value);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("data", jSONArray);
            } catch (JSONException e2) {
                if (r24.a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final String f(int i) {
        InterceptResult invokeI;
        String r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i == 1) {
                r = c04.b().r();
            } else if (i == 2) {
                r = c04.b().m();
            } else if (i == 3) {
                r = c04.b().s();
            } else if (i != 4) {
                r = i != 5 ? "" : c04.b().k();
            } else {
                r = c04.b().o();
            }
            if (TextUtils.isEmpty(r) && r24.a) {
                Log.e("OpenDataApi", "getUrlByType（）meet empty url !");
            }
            return r;
        }
        return (String) invokeI.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            l33 M = l33.M();
            if (M == null) {
                return false;
            }
            return M.N().e(AppRuntime.getAppContext());
        }
        return invokeV.booleanValue;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jsObject) == null) {
            d(jsObject, 5);
        }
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        sv1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) || (F = sv1.F(jsObject)) == null) {
            return;
        }
        z24 z24Var = new z24();
        if (!g()) {
            z24Var.errNo = FontParser.sFontWeightDefault;
            z24Var.errMsg = x54.b("getUserCloudStorage", "fail must login before calling");
            x54.call(F, false, z24Var);
            h(jsObject);
            return;
        }
        try {
            String[] h = F.h("keyList");
            h(jsObject);
            j(3, h, new c(this, z24Var, F));
        } catch (JSTypeMismatchException e2) {
            if (r24.a) {
                e2.printStackTrace();
            }
            z24Var.errNo = FontParser.sFontWeightDefault;
            z24Var.errMsg = x54.b("getUserCloudStorage", "fail invalid keyList");
            x54.call(F, false, z24Var);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        sv1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) || (F = sv1.F(jsObject)) == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            String[] h = F.h("swanIdList");
            if (h != null && h.length > 0) {
                for (String str : h) {
                    jSONArray.put(str);
                }
            }
        } catch (JSTypeMismatchException e2) {
            if (r24.a) {
                e2.printStackTrace();
            }
        }
        h(jsObject);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", l33.g0());
            jSONObject.put("swanid_list", jSONArray);
        } catch (JSONException e3) {
            if (r24.a) {
                e3.printStackTrace();
            }
        }
        a(f(1), jSONObject.toString(), new a(this, new z24(), F));
    }

    public final void h(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) || jsObject == null) {
            return;
        }
        jsObject.release();
    }

    public final void i(JsObject[] jsObjectArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, jsObjectArr) == null) || jsObjectArr == null) {
            return;
        }
        for (JsObject jsObject : jsObjectArr) {
            h(jsObject);
        }
    }

    public final <T> void j(int i, @NonNull String[] strArr, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048586, this, i, strArr, responseCallback) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (strArr.length > 0) {
                for (String str : strArr) {
                    jSONArray.put(str);
                }
            }
            try {
                jSONObject.put("ma_id", l33.g0());
                jSONObject.put("key_list", jSONArray);
            } catch (JSONException e2) {
                if (r24.a) {
                    e2.printStackTrace();
                }
            }
            a(f(i), jSONObject.toString(), responseCallback);
        }
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        sv1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) || (F = sv1.F(jsObject)) == null) {
            return;
        }
        z24 z24Var = new z24();
        if (!g()) {
            z24Var.errNo = FontParser.sFontWeightDefault;
            z24Var.errMsg = x54.b("removeUserCloudStorage", "fail must login before calling");
            x54.call(F, false, z24Var);
            h(jsObject);
            return;
        }
        try {
            String[] h = F.h("keyList");
            h(jsObject);
            j(2, h, new b(this, z24Var, F));
        } catch (JSTypeMismatchException e2) {
            if (r24.a) {
                e2.printStackTrace();
            }
            z24Var.errNo = FontParser.sFontWeightDefault;
            z24Var.errMsg = x54.b("removeUserCloudStorage", "fail invalid keyList");
            x54.call(F, false, z24Var);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        sv1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) || (F = sv1.F(jsObject)) == null) {
            return;
        }
        z24 z24Var = new z24();
        if (!g()) {
            z24Var.errNo = FontParser.sFontWeightDefault;
            z24Var.errMsg = x54.b("setUserCloudStorage", "fail must login before calling");
            x54.call(F, false, z24Var);
            i(F.z("KVDataList"));
            h(jsObject);
            return;
        }
        try {
            JsObject[] e2 = F.e("KVDataList");
            h(jsObject);
            y24[] c2 = c(F, e2, z24Var);
            i(e2);
            if (c2 == null) {
                return;
            }
            a(f(4), e(c2).toString(), new d(this, z24Var, F));
        } catch (JSTypeMismatchException e3) {
            if (r24.a) {
                e3.printStackTrace();
            }
            z24Var.errNo = FontParser.sFontWeightDefault;
            z24Var.errMsg = x54.b("setUserCloudStorage", "fail KVDataList must be an Array");
            x54.call(F, false, z24Var);
            h(jsObject);
        }
    }
}
