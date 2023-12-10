package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.player.model.YYOption;
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
/* loaded from: classes8.dex */
public class s54 extends q54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ud2 b;

    /* loaded from: classes8.dex */
    public class a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y54 a;
        public final /* synthetic */ sy1 b;
        public final /* synthetic */ s54 c;

        /* renamed from: com.baidu.tieba.s54$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0464a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONObject a;
            public final /* synthetic */ a b;

            public RunnableC0464a(a aVar, JSONObject jSONObject) {
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
                    w84.a(this.b.b, true, this.a);
                }
            }
        }

        /* loaded from: classes8.dex */
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
                    w84.a(aVar.b, false, aVar.a);
                }
            }
        }

        public a(s54 s54Var, y54 y54Var, sy1 sy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s54Var, y54Var, sy1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s54Var;
            this.a = y54Var;
            this.b = sy1Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (q54.a) {
                    Log.e("OpenDataApi", "on fail");
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    y54 y54Var = this.a;
                    y54Var.errNo = YYOption.UrlProtocol.USER;
                    y54Var.errMsg = String.format("%s: fail Error: %s", "getUserInfo", exc.getMessage());
                }
                this.c.b.post(new b(this));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (q54.a) {
                    Log.d("OpenDataApi", "on success");
                }
                this.c.b.post(new RunnableC0464a(this, jSONObject));
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
                if (q54.a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (q54.a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    y54 y54Var = this.a;
                    y54Var.errNo = optString;
                    y54Var.errMsg = String.format("%s: fail Error: %s", "getUserInfo", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put(StatConstants.KEY_EXT_ERR_MSG, w84.c("getUserInfo", DnsModel.MSG_OK));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends ResponseCallback<y54> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y54 a;
        public final /* synthetic */ sy1 b;
        public final /* synthetic */ s54 c;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ y54 a;
            public final /* synthetic */ b b;

            public a(b bVar, y54 y54Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, y54Var};
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
                this.a = y54Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    w84.a(this.b.b, true, this.a);
                }
            }
        }

        /* renamed from: com.baidu.tieba.s54$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0465b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public RunnableC0465b(b bVar) {
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
                    w84.a(bVar.b, false, bVar.a);
                }
            }
        }

        public b(s54 s54Var, y54 y54Var, sy1 sy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s54Var, y54Var, sy1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s54Var;
            this.a = y54Var;
            this.b = sy1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(y54 y54Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, y54Var, i) == null) {
                if (q54.a) {
                    Log.d("OpenDataApi", "on success ");
                }
                this.c.b.post(new a(this, y54Var));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public y54 parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (q54.a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (q54.a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    y54 y54Var = this.a;
                    y54Var.errNo = optString;
                    y54Var.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                y54 y54Var2 = this.a;
                y54Var2.errNo = "0";
                y54Var2.errMsg = w84.c("removeUserCloudStorage", DnsModel.MSG_OK);
                return this.a;
            }
            return (y54) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (q54.a) {
                    Log.d("OpenDataApi", "on fail");
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    y54 y54Var = this.a;
                    y54Var.errNo = YYOption.UrlProtocol.USER;
                    y54Var.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", exc.getMessage());
                }
                this.c.b.post(new RunnableC0465b(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y54 a;
        public final /* synthetic */ sy1 b;
        public final /* synthetic */ s54 c;

        /* loaded from: classes8.dex */
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
                    w84.a(this.b.b, true, this.a);
                }
            }
        }

        /* loaded from: classes8.dex */
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
                    w84.a(cVar.b, false, cVar.a);
                }
            }
        }

        public c(s54 s54Var, y54 y54Var, sy1 sy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s54Var, y54Var, sy1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s54Var;
            this.a = y54Var;
            this.b = sy1Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (q54.a) {
                    Log.e("OpenDataApi", "on fail");
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    y54 y54Var = this.a;
                    y54Var.errNo = YYOption.UrlProtocol.USER;
                    y54Var.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", exc.getMessage());
                }
                this.c.b.post(new b(this));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (q54.a) {
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
                if (q54.a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (q54.a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    y54 y54Var = this.a;
                    y54Var.errNo = optString;
                    y54Var.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put(StatConstants.KEY_EXT_ERR_MSG, w84.c("getUserCloudStorage", DnsModel.MSG_OK));
                jSONObject2.put("KVDataList", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d extends ResponseCallback<y54> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y54 a;
        public final /* synthetic */ sy1 b;
        public final /* synthetic */ s54 c;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ y54 a;
            public final /* synthetic */ d b;

            public a(d dVar, y54 y54Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, y54Var};
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
                this.a = y54Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    w84.a(this.b.b, true, this.a);
                }
            }
        }

        /* loaded from: classes8.dex */
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
                    w84.a(dVar.b, false, dVar.a);
                }
            }
        }

        public d(s54 s54Var, y54 y54Var, sy1 sy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s54Var, y54Var, sy1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s54Var;
            this.a = y54Var;
            this.b = sy1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(y54 y54Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, y54Var, i) == null) {
                if (q54.a) {
                    Log.d("OpenDataApi", "on success");
                }
                this.c.b.post(new a(this, y54Var));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public y54 parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (q54.a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (q54.a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    y54 y54Var = this.a;
                    y54Var.errNo = optString;
                    y54Var.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                y54 y54Var2 = this.a;
                y54Var2.errNo = "0";
                y54Var2.errMsg = w84.c("setUserCloudStorage", DnsModel.MSG_OK);
                return this.a;
            }
            return (y54) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (q54.a) {
                    Log.e("OpenDataApi", "on fail");
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    y54 y54Var = this.a;
                    y54Var.errNo = YYOption.UrlProtocol.USER;
                    y54Var.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", exc.getMessage());
                }
                this.c.b.post(new b(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y54 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ sy1 c;
        public final /* synthetic */ s54 d;

        /* loaded from: classes8.dex */
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
                    w84.a(this.b.c, true, this.a);
                }
            }
        }

        /* loaded from: classes8.dex */
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
                    w84.a(eVar.c, false, eVar.a);
                }
            }
        }

        public e(s54 s54Var, y54 y54Var, String str, sy1 sy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s54Var, y54Var, str, sy1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = s54Var;
            this.a = y54Var;
            this.b = str;
            this.c = sy1Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (q54.a) {
                    Log.e("OpenDataApi", "on fail");
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    y54 y54Var = this.a;
                    y54Var.errNo = YYOption.UrlProtocol.USER;
                    y54Var.errMsg = String.format("%s: fail Error: %s", this.b, exc.getMessage());
                }
                this.d.b.post(new b(this));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (q54.a) {
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
                if (q54.a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (q54.a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    y54 y54Var = this.a;
                    y54Var.errNo = optString;
                    y54Var.errMsg = String.format("%s: fail Error: %s", this.b, jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put(StatConstants.KEY_EXT_ERR_MSG, w84.c(this.b, DnsModel.MSG_OK));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    public s54(@NonNull ud2 ud2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ud2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = ud2Var;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jsObject) == null) {
            d(jsObject, 5);
        }
    }

    public final void h(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) && jsObject != null) {
            jsObject.release();
        }
    }

    public final void i(JsObject[] jsObjectArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, jsObjectArr) == null) && jsObjectArr != null) {
            for (JsObject jsObject : jsObjectArr) {
                h(jsObject);
            }
        }
    }

    public final x54[] c(sy1 sy1Var, JsObject[] jsObjectArr, y54 y54Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, sy1Var, jsObjectArr, y54Var)) == null) {
            int length = jsObjectArr.length;
            if (length < 1) {
                y54Var.errMsg = w84.c("setUserCloudStorage", "fail KVDataList.length must greater than 0");
                w84.a(sy1Var, false, y54Var);
                return null;
            } else if (length > 128) {
                y54Var.errMsg = w84.c("setUserCloudStorage", "fail user has stored too much keys. delete some keys and try again");
                w84.a(sy1Var, false, y54Var);
                return null;
            } else {
                x54[] x54VarArr = new x54[length];
                for (int i = 0; i < length; i++) {
                    sy1 G = sy1.G(jsObjectArr[i]);
                    if (G != null && G.l() == 2 && !TextUtils.isEmpty(G.C("key")) && !TextUtils.isEmpty(G.C("value"))) {
                        x54VarArr[i] = new x54();
                        x54VarArr[i].key = G.C("key");
                        x54VarArr[i].value = G.C("value");
                        if (!x54VarArr[i].a()) {
                            y54Var.errMsg = w84.c("setUserCloudStorage", "fail some keys in list meet length exceed");
                            w84.a(sy1Var, false, y54Var);
                            return null;
                        } else if (!x54VarArr[i].b()) {
                            y54Var.errMsg = w84.c("setUserCloudStorage", "fail some key-value in list meet length exceed");
                            w84.a(sy1Var, false, y54Var);
                            return null;
                        }
                    } else {
                        y54Var.errMsg = w84.c("setUserCloudStorage", "fail invalid KVData item");
                        w84.a(sy1Var, false, y54Var);
                        return null;
                    }
                }
                return x54VarArr;
            }
        }
        return (x54[]) invokeLLL.objValue;
    }

    public final void d(JsObject jsObject, int i) {
        sy1 G;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject, i) != null) || (G = sy1.G(jsObject)) == null) {
            return;
        }
        if (i == 5) {
            y54 y54Var = new y54();
            if (!g()) {
                y54Var.errNo = FontParser.sFontWeightDefault;
                y54Var.errMsg = w84.c("getFriendCloudStorage", "fail must login before calling");
                w84.a(G, false, y54Var);
                h(jsObject);
                return;
            }
            try {
                String[] h = G.h("keyList");
                h(jsObject);
                j(i, h, new e(this, y54Var, "getFriendCloudStorage", G));
                return;
            } catch (JSTypeMismatchException e2) {
                if (q54.a) {
                    e2.printStackTrace();
                }
                y54Var.errNo = FontParser.sFontWeightDefault;
                y54Var.errMsg = w84.c("getFriendCloudStorage", "fail invalid keyList");
                w84.a(G, false, y54Var);
                h(jsObject);
                return;
            }
        }
        h(jsObject);
    }

    public final JSONObject e(x54[] x54VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x54VarArr)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", k63.h0());
                JSONArray jSONArray = new JSONArray();
                for (x54 x54Var : x54VarArr) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("key", x54Var.key);
                    jSONObject2.put("value", x54Var.value);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("data", jSONArray);
            } catch (JSONException e2) {
                if (q54.a) {
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
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                r = "";
                            } else {
                                r = b34.b().k();
                            }
                        } else {
                            r = b34.b().o();
                        }
                    } else {
                        r = b34.b().s();
                    }
                } else {
                    r = b34.b().m();
                }
            } else {
                r = b34.b().r();
            }
            if (TextUtils.isEmpty(r) && q54.a) {
                Log.e("OpenDataApi", "getUrlByType（）meet empty url !");
            }
            return r;
        }
        return (String) invokeI.objValue;
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        sy1 G;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, jsObject) != null) || (G = sy1.G(jsObject)) == null) {
            return;
        }
        y54 y54Var = new y54();
        if (!g()) {
            y54Var.errNo = FontParser.sFontWeightDefault;
            y54Var.errMsg = w84.c("getUserCloudStorage", "fail must login before calling");
            w84.a(G, false, y54Var);
            h(jsObject);
            return;
        }
        try {
            String[] h = G.h("keyList");
            h(jsObject);
            j(3, h, new c(this, y54Var, G));
        } catch (JSTypeMismatchException e2) {
            if (q54.a) {
                e2.printStackTrace();
            }
            y54Var.errNo = FontParser.sFontWeightDefault;
            y54Var.errMsg = w84.c("getUserCloudStorage", "fail invalid keyList");
            w84.a(G, false, y54Var);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        sy1 G;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, jsObject) != null) || (G = sy1.G(jsObject)) == null) {
            return;
        }
        y54 y54Var = new y54();
        if (!g()) {
            y54Var.errNo = FontParser.sFontWeightDefault;
            y54Var.errMsg = w84.c("removeUserCloudStorage", "fail must login before calling");
            w84.a(G, false, y54Var);
            h(jsObject);
            return;
        }
        try {
            String[] h = G.h("keyList");
            h(jsObject);
            j(2, h, new b(this, y54Var, G));
        } catch (JSTypeMismatchException e2) {
            if (q54.a) {
                e2.printStackTrace();
            }
            y54Var.errNo = FontParser.sFontWeightDefault;
            y54Var.errMsg = w84.c("removeUserCloudStorage", "fail invalid keyList");
            w84.a(G, false, y54Var);
            h(jsObject);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            k63 M = k63.M();
            if (M == null) {
                return false;
            }
            return M.N().e(AppRuntime.getAppContext());
        }
        return invokeV.booleanValue;
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        sy1 G;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, jsObject) != null) || (G = sy1.G(jsObject)) == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            String[] h = G.h("swanIdList");
            if (h != null && h.length > 0) {
                for (String str : h) {
                    jSONArray.put(str);
                }
            }
        } catch (JSTypeMismatchException e2) {
            if (q54.a) {
                e2.printStackTrace();
            }
        }
        h(jsObject);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", k63.h0());
            jSONObject.put("swanid_list", jSONArray);
        } catch (JSONException e3) {
            if (q54.a) {
                e3.printStackTrace();
            }
        }
        a(f(1), jSONObject.toString(), new a(this, new y54(), G));
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        sy1 G;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, jsObject) != null) || (G = sy1.G(jsObject)) == null) {
            return;
        }
        y54 y54Var = new y54();
        if (!g()) {
            y54Var.errNo = FontParser.sFontWeightDefault;
            y54Var.errMsg = w84.c("setUserCloudStorage", "fail must login before calling");
            w84.a(G, false, y54Var);
            i(G.A("KVDataList"));
            h(jsObject);
            return;
        }
        try {
            JsObject[] e2 = G.e("KVDataList");
            h(jsObject);
            x54[] c2 = c(G, e2, y54Var);
            i(e2);
            if (c2 == null) {
                return;
            }
            a(f(4), e(c2).toString(), new d(this, y54Var, G));
        } catch (JSTypeMismatchException e3) {
            if (q54.a) {
                e3.printStackTrace();
            }
            y54Var.errNo = FontParser.sFontWeightDefault;
            y54Var.errMsg = w84.c("setUserCloudStorage", "fail KVDataList must be an Array");
            w84.a(G, false, y54Var);
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
                jSONObject.put("ma_id", k63.h0());
                jSONObject.put("key_list", jSONArray);
            } catch (JSONException e2) {
                if (q54.a) {
                    e2.printStackTrace();
                }
            }
            a(f(i), jSONObject.toString(), responseCallback);
        }
    }
}
