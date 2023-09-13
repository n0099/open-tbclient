package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.player.model.YYOption;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class oa4 extends na4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ri2 b;

    /* loaded from: classes7.dex */
    public class a extends ResponseCallback<ta4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va4 a;
        public final /* synthetic */ o32 b;
        public final /* synthetic */ oa4 c;

        /* renamed from: com.baidu.tieba.oa4$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0423a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ta4 a;
            public final /* synthetic */ a b;

            public RunnableC0423a(a aVar, ta4 ta4Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ta4Var};
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
                this.a = ta4Var;
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

        public a(oa4 oa4Var, va4 va4Var, o32 o32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oa4Var, va4Var, o32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = oa4Var;
            this.a = va4Var;
            this.b = o32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(ta4 ta4Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, ta4Var, i) == null) {
                if (na4.a) {
                    Log.d("CheckAdvisedToRestApi", "on success");
                }
                this.c.b.post(new RunnableC0423a(this, ta4Var));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public ta4 parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (na4.a) {
                    Log.d("CheckAdvisedToRestApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (na4.a) {
                        Log.d("CheckAdvisedToRestApi", "errno = " + optString);
                    }
                    va4 va4Var = this.a;
                    va4Var.errNo = optString;
                    va4Var.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", jSONObject.optString("errmsg"));
                    return null;
                }
                String optString2 = jSONObject.optJSONObject("data").optString("result");
                ta4 ta4Var = new ta4();
                ta4Var.result = !TextUtils.equals(optString2, "0");
                ta4Var.errNo = "0";
                ta4Var.errMsg = td4.b("checkIsUserAdvisedToRest", DnsModel.MSG_OK);
                return ta4Var;
            }
            return (ta4) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (na4.a) {
                    Log.e("CheckAdvisedToRestApi", "on fail");
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    va4 va4Var = this.a;
                    va4Var.errNo = YYOption.UrlProtocol.USER;
                    va4Var.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", exc.getMessage());
                }
                this.c.b.post(new b(this));
            }
        }
    }

    public oa4(@NonNull ri2 ri2Var) {
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
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        o32 F;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && (F = o32.F(jsObject)) != null && this.b != null) {
            va4 va4Var = new va4();
            try {
                int d = F.d("todayPlayedTime");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ma_id", hb3.g0());
                    jSONObject.put("todayPlayedTime", String.valueOf(d));
                } catch (JSONException e) {
                    if (na4.a) {
                        e.printStackTrace();
                    }
                }
                a(y74.b().f(), jSONObject.toString(), new a(this, va4Var, F));
            } catch (JSTypeMismatchException e2) {
                if (na4.a) {
                    e2.printStackTrace();
                }
                va4Var.errNo = FontParser.sFontWeightDefault;
                va4Var.errMsg = td4.a("checkIsUserAdvisedToRest", e2);
                td4.call(F, false, va4Var);
            }
        }
    }
}
