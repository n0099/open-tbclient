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
/* loaded from: classes7.dex */
public class pa4 extends na4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ri2 b;

    /* loaded from: classes7.dex */
    public class a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va4 a;
        public final /* synthetic */ o32 b;
        public final /* synthetic */ pa4 c;

        /* renamed from: com.baidu.tieba.pa4$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0434a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONObject a;
            public final /* synthetic */ a b;

            public RunnableC0434a(a aVar, JSONObject jSONObject) {
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
                    td4.call(this.b.b, true, this.a);
                }
            }
        }

        /* loaded from: classes7.dex */
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
                    td4.call(aVar.b, false, aVar.a);
                }
            }
        }

        public a(pa4 pa4Var, va4 va4Var, o32 o32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa4Var, va4Var, o32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pa4Var;
            this.a = va4Var;
            this.b = o32Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (na4.a) {
                    Log.e("OpenDataApi", "on fail");
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    va4 va4Var = this.a;
                    va4Var.errNo = YYOption.UrlProtocol.USER;
                    va4Var.errMsg = String.format("%s: fail Error: %s", "getUserInfo", exc.getMessage());
                }
                this.c.b.post(new b(this));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (na4.a) {
                    Log.d("OpenDataApi", "on success");
                }
                this.c.b.post(new RunnableC0434a(this, jSONObject));
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
                if (na4.a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (na4.a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    va4 va4Var = this.a;
                    va4Var.errNo = optString;
                    va4Var.errMsg = String.format("%s: fail Error: %s", "getUserInfo", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put(StatConstants.KEY_EXT_ERR_MSG, td4.b("getUserInfo", DnsModel.MSG_OK));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ResponseCallback<va4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va4 a;
        public final /* synthetic */ o32 b;
        public final /* synthetic */ pa4 c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ va4 a;
            public final /* synthetic */ b b;

            public a(b bVar, va4 va4Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, va4Var};
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
                this.a = va4Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    td4.call(this.b.b, true, this.a);
                }
            }
        }

        /* renamed from: com.baidu.tieba.pa4$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0435b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public RunnableC0435b(b bVar) {
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
                    td4.call(bVar.b, false, bVar.a);
                }
            }
        }

        public b(pa4 pa4Var, va4 va4Var, o32 o32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa4Var, va4Var, o32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pa4Var;
            this.a = va4Var;
            this.b = o32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(va4 va4Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, va4Var, i) == null) {
                if (na4.a) {
                    Log.d("OpenDataApi", "on success ");
                }
                this.c.b.post(new a(this, va4Var));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public va4 parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (na4.a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (na4.a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    va4 va4Var = this.a;
                    va4Var.errNo = optString;
                    va4Var.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                va4 va4Var2 = this.a;
                va4Var2.errNo = "0";
                va4Var2.errMsg = td4.b("removeUserCloudStorage", DnsModel.MSG_OK);
                return this.a;
            }
            return (va4) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (na4.a) {
                    Log.d("OpenDataApi", "on fail");
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    va4 va4Var = this.a;
                    va4Var.errNo = YYOption.UrlProtocol.USER;
                    va4Var.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", exc.getMessage());
                }
                this.c.b.post(new RunnableC0435b(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va4 a;
        public final /* synthetic */ o32 b;
        public final /* synthetic */ pa4 c;

        /* loaded from: classes7.dex */
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
                    td4.call(this.b.b, true, this.a);
                }
            }
        }

        /* loaded from: classes7.dex */
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
                    td4.call(cVar.b, false, cVar.a);
                }
            }
        }

        public c(pa4 pa4Var, va4 va4Var, o32 o32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa4Var, va4Var, o32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pa4Var;
            this.a = va4Var;
            this.b = o32Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (na4.a) {
                    Log.e("OpenDataApi", "on fail");
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    va4 va4Var = this.a;
                    va4Var.errNo = YYOption.UrlProtocol.USER;
                    va4Var.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", exc.getMessage());
                }
                this.c.b.post(new b(this));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (na4.a) {
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
                if (na4.a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (na4.a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    va4 va4Var = this.a;
                    va4Var.errNo = optString;
                    va4Var.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put(StatConstants.KEY_EXT_ERR_MSG, td4.b("getUserCloudStorage", DnsModel.MSG_OK));
                jSONObject2.put("KVDataList", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d extends ResponseCallback<va4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va4 a;
        public final /* synthetic */ o32 b;
        public final /* synthetic */ pa4 c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ va4 a;
            public final /* synthetic */ d b;

            public a(d dVar, va4 va4Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, va4Var};
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
                this.a = va4Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    td4.call(this.b.b, true, this.a);
                }
            }
        }

        /* loaded from: classes7.dex */
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
                    td4.call(dVar.b, false, dVar.a);
                }
            }
        }

        public d(pa4 pa4Var, va4 va4Var, o32 o32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa4Var, va4Var, o32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pa4Var;
            this.a = va4Var;
            this.b = o32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(va4 va4Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, va4Var, i) == null) {
                if (na4.a) {
                    Log.d("OpenDataApi", "on success");
                }
                this.c.b.post(new a(this, va4Var));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public va4 parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (na4.a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (na4.a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    va4 va4Var = this.a;
                    va4Var.errNo = optString;
                    va4Var.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                va4 va4Var2 = this.a;
                va4Var2.errNo = "0";
                va4Var2.errMsg = td4.b("setUserCloudStorage", DnsModel.MSG_OK);
                return this.a;
            }
            return (va4) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (na4.a) {
                    Log.e("OpenDataApi", "on fail");
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    va4 va4Var = this.a;
                    va4Var.errNo = YYOption.UrlProtocol.USER;
                    va4Var.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", exc.getMessage());
                }
                this.c.b.post(new b(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va4 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ o32 c;
        public final /* synthetic */ pa4 d;

        /* loaded from: classes7.dex */
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
                    td4.call(this.b.c, true, this.a);
                }
            }
        }

        /* loaded from: classes7.dex */
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
                    td4.call(eVar.c, false, eVar.a);
                }
            }
        }

        public e(pa4 pa4Var, va4 va4Var, String str, o32 o32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa4Var, va4Var, str, o32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = pa4Var;
            this.a = va4Var;
            this.b = str;
            this.c = o32Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (na4.a) {
                    Log.e("OpenDataApi", "on fail");
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    va4 va4Var = this.a;
                    va4Var.errNo = YYOption.UrlProtocol.USER;
                    va4Var.errMsg = String.format("%s: fail Error: %s", this.b, exc.getMessage());
                }
                this.d.b.post(new b(this));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (na4.a) {
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
                if (na4.a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (na4.a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    va4 va4Var = this.a;
                    va4Var.errNo = optString;
                    va4Var.errMsg = String.format("%s: fail Error: %s", this.b, jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put(StatConstants.KEY_EXT_ERR_MSG, td4.b(this.b, DnsModel.MSG_OK));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    public pa4(@NonNull ri2 ri2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ri2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = ri2Var;
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

    public final ua4[] c(o32 o32Var, JsObject[] jsObjectArr, va4 va4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, o32Var, jsObjectArr, va4Var)) == null) {
            int length = jsObjectArr.length;
            if (length < 1) {
                va4Var.errMsg = td4.b("setUserCloudStorage", "fail KVDataList.length must greater than 0");
                td4.call(o32Var, false, va4Var);
                return null;
            } else if (length > 128) {
                va4Var.errMsg = td4.b("setUserCloudStorage", "fail user has stored too much keys. delete some keys and try again");
                td4.call(o32Var, false, va4Var);
                return null;
            } else {
                ua4[] ua4VarArr = new ua4[length];
                for (int i = 0; i < length; i++) {
                    o32 F = o32.F(jsObjectArr[i]);
                    if (F != null && F.k() == 2 && !TextUtils.isEmpty(F.B("key")) && !TextUtils.isEmpty(F.B("value"))) {
                        ua4VarArr[i] = new ua4();
                        ua4VarArr[i].key = F.B("key");
                        ua4VarArr[i].value = F.B("value");
                        if (!ua4VarArr[i].a()) {
                            va4Var.errMsg = td4.b("setUserCloudStorage", "fail some keys in list meet length exceed");
                            td4.call(o32Var, false, va4Var);
                            return null;
                        } else if (!ua4VarArr[i].b()) {
                            va4Var.errMsg = td4.b("setUserCloudStorage", "fail some key-value in list meet length exceed");
                            td4.call(o32Var, false, va4Var);
                            return null;
                        }
                    } else {
                        va4Var.errMsg = td4.b("setUserCloudStorage", "fail invalid KVData item");
                        td4.call(o32Var, false, va4Var);
                        return null;
                    }
                }
                return ua4VarArr;
            }
        }
        return (ua4[]) invokeLLL.objValue;
    }

    public final void d(JsObject jsObject, int i) {
        o32 F;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject, i) != null) || (F = o32.F(jsObject)) == null) {
            return;
        }
        if (i == 5) {
            va4 va4Var = new va4();
            if (!g()) {
                va4Var.errNo = FontParser.sFontWeightDefault;
                va4Var.errMsg = td4.b("getFriendCloudStorage", "fail must login before calling");
                td4.call(F, false, va4Var);
                h(jsObject);
                return;
            }
            try {
                String[] h = F.h("keyList");
                h(jsObject);
                j(i, h, new e(this, va4Var, "getFriendCloudStorage", F));
                return;
            } catch (JSTypeMismatchException e2) {
                if (na4.a) {
                    e2.printStackTrace();
                }
                va4Var.errNo = FontParser.sFontWeightDefault;
                va4Var.errMsg = td4.b("getFriendCloudStorage", "fail invalid keyList");
                td4.call(F, false, va4Var);
                h(jsObject);
                return;
            }
        }
        h(jsObject);
    }

    public final JSONObject e(ua4[] ua4VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ua4VarArr)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", hb3.g0());
                JSONArray jSONArray = new JSONArray();
                for (ua4 ua4Var : ua4VarArr) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("key", ua4Var.key);
                    jSONObject2.put("value", ua4Var.value);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("data", jSONArray);
            } catch (JSONException e2) {
                if (na4.a) {
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
                                r = y74.b().k();
                            }
                        } else {
                            r = y74.b().o();
                        }
                    } else {
                        r = y74.b().s();
                    }
                } else {
                    r = y74.b().m();
                }
            } else {
                r = y74.b().r();
            }
            if (TextUtils.isEmpty(r) && na4.a) {
                Log.e("OpenDataApi", "getUrlByType（）meet empty url !");
            }
            return r;
        }
        return (String) invokeI.objValue;
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        o32 F;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, jsObject) != null) || (F = o32.F(jsObject)) == null) {
            return;
        }
        va4 va4Var = new va4();
        if (!g()) {
            va4Var.errNo = FontParser.sFontWeightDefault;
            va4Var.errMsg = td4.b("getUserCloudStorage", "fail must login before calling");
            td4.call(F, false, va4Var);
            h(jsObject);
            return;
        }
        try {
            String[] h = F.h("keyList");
            h(jsObject);
            j(3, h, new c(this, va4Var, F));
        } catch (JSTypeMismatchException e2) {
            if (na4.a) {
                e2.printStackTrace();
            }
            va4Var.errNo = FontParser.sFontWeightDefault;
            va4Var.errMsg = td4.b("getUserCloudStorage", "fail invalid keyList");
            td4.call(F, false, va4Var);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        o32 F;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, jsObject) != null) || (F = o32.F(jsObject)) == null) {
            return;
        }
        va4 va4Var = new va4();
        if (!g()) {
            va4Var.errNo = FontParser.sFontWeightDefault;
            va4Var.errMsg = td4.b("removeUserCloudStorage", "fail must login before calling");
            td4.call(F, false, va4Var);
            h(jsObject);
            return;
        }
        try {
            String[] h = F.h("keyList");
            h(jsObject);
            j(2, h, new b(this, va4Var, F));
        } catch (JSTypeMismatchException e2) {
            if (na4.a) {
                e2.printStackTrace();
            }
            va4Var.errNo = FontParser.sFontWeightDefault;
            va4Var.errMsg = td4.b("removeUserCloudStorage", "fail invalid keyList");
            td4.call(F, false, va4Var);
            h(jsObject);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            hb3 M = hb3.M();
            if (M == null) {
                return false;
            }
            return M.N().e(AppRuntime.getAppContext());
        }
        return invokeV.booleanValue;
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        o32 F;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, jsObject) != null) || (F = o32.F(jsObject)) == null) {
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
            if (na4.a) {
                e2.printStackTrace();
            }
        }
        h(jsObject);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", hb3.g0());
            jSONObject.put("swanid_list", jSONArray);
        } catch (JSONException e3) {
            if (na4.a) {
                e3.printStackTrace();
            }
        }
        a(f(1), jSONObject.toString(), new a(this, new va4(), F));
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        o32 F;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, jsObject) != null) || (F = o32.F(jsObject)) == null) {
            return;
        }
        va4 va4Var = new va4();
        if (!g()) {
            va4Var.errNo = FontParser.sFontWeightDefault;
            va4Var.errMsg = td4.b("setUserCloudStorage", "fail must login before calling");
            td4.call(F, false, va4Var);
            i(F.z("KVDataList"));
            h(jsObject);
            return;
        }
        try {
            JsObject[] e2 = F.e("KVDataList");
            h(jsObject);
            ua4[] c2 = c(F, e2, va4Var);
            i(e2);
            if (c2 == null) {
                return;
            }
            a(f(4), e(c2).toString(), new d(this, va4Var, F));
        } catch (JSTypeMismatchException e3) {
            if (na4.a) {
                e3.printStackTrace();
            }
            va4Var.errNo = FontParser.sFontWeightDefault;
            va4Var.errMsg = td4.b("setUserCloudStorage", "fail KVDataList must be an Array");
            td4.call(F, false, va4Var);
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
                jSONObject.put("ma_id", hb3.g0());
                jSONObject.put("key_list", jSONArray);
            } catch (JSONException e2) {
                if (na4.a) {
                    e2.printStackTrace();
                }
            }
            a(f(i), jSONObject.toString(), responseCallback);
        }
    }
}
