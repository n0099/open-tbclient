package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tieba.iq0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class xp0 extends pl1<iq0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements iq0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.xp0$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0538a implements cu0<JSONObject> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ js0 a;
            public final /* synthetic */ iq0.b b;
            public final /* synthetic */ ct0 c;
            public final /* synthetic */ a d;

            @Override // com.baidu.tieba.bu0
            public void c(Headers headers, InputStream inputStream, int i) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, headers, inputStream, i) == null) {
                }
            }

            public C0538a(a aVar, js0 js0Var, iq0.b bVar, ct0 ct0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, js0Var, bVar, ct0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = aVar;
                this.a = js0Var;
                this.b = bVar;
                this.c = ct0Var;
            }

            @Override // com.baidu.tieba.bu0
            public void a(Exception exc, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                    n41.e(new ClogBuilder().y(ClogBuilder.LogType.REWARD_TOKEN_FAIL).u(ClogBuilder.Page.WELFAREMAXLP).p(this.a.f.d));
                    this.b.onFail(exc);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.cu0
            /* renamed from: f */
            public JSONObject d(Headers headers, String str, int i) throws Exception {
                InterceptResult invokeLLI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048581, this, headers, str, i)) == null) {
                    return new JSONObject(str);
                }
                return (JSONObject) invokeLLI.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.cu0
            /* renamed from: e */
            public void b(Headers headers, JSONObject jSONObject, int i) {
                JSONObject optJSONObject;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(1048580, this, headers, jSONObject, i) == null) {
                    if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                        this.d.e(optJSONObject.optString("token"), this.a, this.c, this.b);
                        return;
                    }
                    n41.e(new ClogBuilder().y(ClogBuilder.LogType.REWARD_TOKEN_FAIL).u(ClogBuilder.Page.WELFAREMAXLP).p(this.a.f.d));
                    this.b.onFail(new IllegalArgumentException("data: null"));
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements pr {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ iq0.b a;
            public final /* synthetic */ js0 b;

            public b(a aVar, iq0.b bVar, js0 js0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar, js0Var};
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
                this.b = js0Var;
            }

            @Override // com.baidu.tieba.pr
            public void a(@NonNull TaskResponseData taskResponseData) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, taskResponseData) == null) {
                    try {
                        this.a.a(aq0.b(new JSONObject(taskResponseData.getUi().getExtra())));
                    } catch (Exception e) {
                        n41.e(new ClogBuilder().y(ClogBuilder.LogType.REWARD_COIN_FAIL).u(ClogBuilder.Page.WELFAREMAXLP).p(this.b.f.d).k("1").l("2"));
                        this.a.onFail(e);
                    }
                }
            }

            @Override // com.baidu.tieba.pr
            public void onError(int i, @NonNull String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                    n41.e(new ClogBuilder().y(ClogBuilder.LogType.REWARD_COIN_FAIL).u(ClogBuilder.Page.WELFAREMAXLP).p(this.b.f.d).k("1").l("1").m(String.valueOf(i)));
                    this.a.onFail(new RuntimeException(str));
                }
            }
        }

        public a(xp0 xp0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xp0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.iq0
        public void a(@NonNull js0 js0Var, @NonNull ct0 ct0Var, @NonNull iq0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, js0Var, ct0Var, bVar) == null) {
                String A = js0Var.h().A();
                if (!TextUtils.isEmpty(A)) {
                    e(A, js0Var, ct0Var, bVar);
                    return;
                }
                vt0 a = rt0.b().a();
                ku0 ku0Var = new ku0();
                ku0Var.l(d(js0Var.h()));
                ku0Var.h(fu0.c);
                ku0Var.d("User-Agent", rk0.c().a().h());
                a.a(ku0Var, new C0538a(this, js0Var, bVar, ct0Var));
            }
        }

        @Nullable
        public final JSONObject c(js0 js0Var, ct0 ct0Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, js0Var, ct0Var)) == null) {
                try {
                    dt0 h = js0Var.h();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id_from", h.t());
                    jSONObject.put("logid", h.B());
                    jSONObject.put("session_rewards", ct0Var.a());
                    jSONObject.put("task_policy", h.v());
                    return jSONObject;
                } catch (JSONException unused) {
                    return null;
                }
            }
            return (JSONObject) invokeLL.objValue;
        }

        public final String d(@Nullable dt0 dt0Var) {
            InterceptResult invokeL;
            String b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dt0Var)) == null) {
                if (dt0Var != null && !TextUtils.isEmpty(dt0Var.a())) {
                    b2 = dt0Var.a();
                } else {
                    b2 = wp0.a().b();
                }
                String g = rk0.d().g();
                if (!TextUtils.isEmpty(g)) {
                    return z71.a(b2, "cd", new String(Base64Encoder.B64Encode(g.getBytes())));
                }
                return b2;
            }
            return (String) invokeL.objValue;
        }

        public final void e(String str, @NonNull js0 js0Var, @NonNull ct0 ct0Var, @NonNull iq0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, js0Var, ct0Var, bVar) == null) {
                String u = js0Var.h().u();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(u)) {
                    BDPTask.m.G(str, u, 0, c(js0Var, ct0Var), new b(this, bVar, js0Var));
                    return;
                }
                bVar.onFail(new IllegalArgumentException("token: " + str + " taskId: " + u));
            }
        }
    }

    public xp0() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pl1
    /* renamed from: a */
    public iq0 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (iq0) invokeV.objValue;
    }
}
