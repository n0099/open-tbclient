package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class sp0 {
    public static /* synthetic */ Interceptable $ic;
    public static final sp0 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface a {
        void a(cs0 cs0Var);

        void onFail(Exception exc);
    }

    /* loaded from: classes8.dex */
    public static final class b implements it0<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Function2 a;
        public final /* synthetic */ js0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Function2 d;

        @Override // com.baidu.tieba.ht0
        public void c(Headers headers, InputStream stream, int i) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, headers, stream, i) == null) {
                Intrinsics.checkNotNullParameter(headers, "headers");
                Intrinsics.checkNotNullParameter(stream, "stream");
            }
        }

        public b(Function2 function2, js0 js0Var, String str, Function2 function22) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function2, js0Var, str, function22};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = function2;
            this.b = js0Var;
            this.c = str;
            this.d = function22;
        }

        @Override // com.baidu.tieba.ht0
        public void a(Exception exception, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exception, i) == null) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                this.a.invoke(exception, 1);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.it0
        /* renamed from: f */
        public JSONObject d(Headers headers, String response, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048581, this, headers, response, i)) == null) {
                Intrinsics.checkNotNullParameter(headers, "headers");
                Intrinsics.checkNotNullParameter(response, "response");
                return new JSONObject(response);
            }
            return (JSONObject) invokeLLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.it0
        /* renamed from: e */
        public void b(Headers headers, JSONObject jSONObject, int i) {
            String str;
            boolean z;
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048580, this, headers, jSONObject, i) == null) {
                Intrinsics.checkNotNullParameter(headers, "headers");
                if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                    str = optJSONObject.optString("token");
                } else {
                    str = null;
                }
                String str2 = str;
                if (str2 != null && str2.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    sp0.a.e(this.b, this.c, str2, this.d, this.a);
                    return;
                }
                Function2 function2 = this.a;
                function2.invoke(new IllegalStateException("token 为空, taskId: " + this.c), 1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends jt0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public String f(Headers headers, String response, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, response, i)) == null) {
                Intrinsics.checkNotNullParameter(headers, "headers");
                Intrinsics.checkNotNullParameter(response, "response");
                return response;
            }
            return (String) invokeLLI.objValue;
        }

        public c(a aVar) {
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

        @Override // com.baidu.tieba.ht0
        public void a(Exception exception, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exception, i) == null) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                this.a.onFail(exception);
            }
        }

        @Override // com.baidu.tieba.it0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.it0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLI(1048579, this, headers, str, i) != null) || str == null) {
                return;
            }
            try {
                this.a.a(cs0.g.a(new JSONObject(str)));
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d implements rq {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Function2 a;
        public final /* synthetic */ Function2 b;

        public d(Function2 function2, Function2 function22) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function2, function22};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = function2;
            this.b = function22;
        }

        @Override // com.baidu.tieba.rq
        public void a(TaskResponseData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                try {
                    String coin = new JSONObject(data.getUi().getExtra()).optString("coin");
                    String nextCoin = new JSONObject(data.getUi().getExtra()).optString("invokeCoin");
                    Function2 function2 = this.a;
                    Intrinsics.checkNotNullExpressionValue(coin, "coin");
                    Intrinsics.checkNotNullExpressionValue(nextCoin, "nextCoin");
                    function2.invoke(coin, nextCoin);
                } catch (Exception e) {
                    this.b.invoke(e, 2);
                }
            }
        }

        @Override // com.baidu.tieba.rq
        public void onError(int i, String errorMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, errorMsg) == null) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                this.b.invoke(new RuntimeException(errorMsg), 2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948158966, "Lcom/baidu/tieba/sp0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948158966, "Lcom/baidu/tieba/sp0;");
                return;
            }
        }
        a = new sp0();
    }

    public sp0() {
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

    public final HashMap<String, String> a(js0 js0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, js0Var)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            try {
                hashMap.put("logid", js0Var.t());
                hashMap.put("id_from", js0Var.B());
                hashMap.put("task_policy", js0Var.v());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public final JSONObject b(js0 js0Var) {
        InterceptResult invokeL;
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, js0Var)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (js0Var != null) {
                    str = js0Var.t();
                } else {
                    str = null;
                }
                jSONObject.put("id_from", str);
                if (js0Var != null) {
                    str2 = js0Var.B();
                } else {
                    str2 = null;
                }
                jSONObject.put("logid", str2);
                if (js0Var != null) {
                    str3 = js0Var.v();
                } else {
                    str3 = null;
                }
                jSONObject.put("task_policy", str3);
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void c(js0 js0Var, String activeUrl, String completeTaskId, Function2<? super String, ? super String, Unit> success, Function2<? super Throwable, ? super Integer, Unit> fail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, js0Var, activeUrl, completeTaskId, success, fail) == null) {
            Intrinsics.checkNotNullParameter(activeUrl, "activeUrl");
            Intrinsics.checkNotNullParameter(completeTaskId, "completeTaskId");
            Intrinsics.checkNotNullParameter(success, "success");
            Intrinsics.checkNotNullParameter(fail, "fail");
            xs0 b2 = xs0.b();
            Intrinsics.checkNotNullExpressionValue(b2, "HttpFactory.getInstance()");
            bt0 a2 = b2.a();
            qt0 qt0Var = new qt0();
            qt0Var.l(activeUrl);
            qt0Var.h(lt0.c);
            qt0Var.d("User-Agent", sj0.c().a().h());
            a2.a(qt0Var, new b(fail, js0Var, completeTaskId, success));
        }
    }

    public final void d(js0 rewardData, String str, a callback) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, rewardData, str, callback) == null) {
            Intrinsics.checkNotNullParameter(rewardData, "rewardData");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            hp0 hp0Var = (hp0) ServiceManager.getService(hp0.a);
            if (hp0Var != null) {
                str = hp0Var.a(str);
            }
            qt0 qt0Var = new qt0();
            qt0Var.h(lt0.c);
            qt0Var.d("User-Agent", sj0.c().a().h());
            qt0Var.l(str);
            qt0Var.f(pt0.e(a(rewardData)));
            qt0Var.g(3000);
            xs0 b2 = xs0.b();
            Intrinsics.checkNotNullExpressionValue(b2, "HttpFactory.getInstance()");
            b2.a().a(qt0Var, new c(callback));
        }
    }

    public final void e(js0 js0Var, String completeTaskId, String token, Function2<? super String, ? super String, Unit> success, Function2<? super Throwable, ? super Integer, Unit> fail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, js0Var, completeTaskId, token, success, fail) == null) {
            Intrinsics.checkNotNullParameter(completeTaskId, "completeTaskId");
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(success, "success");
            Intrinsics.checkNotNullParameter(fail, "fail");
            if (!TextUtils.isEmpty(token) && !TextUtils.isEmpty(completeTaskId)) {
                BDPTask.m.G(token, completeTaskId, 0, b(js0Var), new d(success, fail));
                return;
            }
            fail.invoke(new IllegalArgumentException("token: " + token + " taskId: " + completeTaskId), 2);
        }
    }
}
