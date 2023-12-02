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
import com.baidu.tieba.al0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class nk0 extends fg1<al0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements al0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.nk0$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0410a implements cp0<JSONObject> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ in0 a;
            public final /* synthetic */ al0.b b;
            public final /* synthetic */ co0 c;
            public final /* synthetic */ a d;

            @Override // com.baidu.tieba.bp0
            public void c(Headers headers, InputStream inputStream, int i) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, headers, inputStream, i) == null) {
                }
            }

            public C0410a(a aVar, in0 in0Var, al0.b bVar, co0 co0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, in0Var, bVar, co0Var};
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
                this.a = in0Var;
                this.b = bVar;
                this.c = co0Var;
            }

            @Override // com.baidu.tieba.bp0
            public void a(Exception exc, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                    dz0.e(new ClogBuilder().y(ClogBuilder.LogType.REWARD_TOKEN_FAIL).u(ClogBuilder.Page.WELFAREMAXLP).p(this.a.f.d));
                    this.b.onFail(exc);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.cp0
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
            @Override // com.baidu.tieba.cp0
            /* renamed from: e */
            public void b(Headers headers, JSONObject jSONObject, int i) {
                JSONObject optJSONObject;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(1048580, this, headers, jSONObject, i) == null) {
                    if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                        this.d.e(optJSONObject.optString("token"), this.a, this.c, this.b);
                        return;
                    }
                    dz0.e(new ClogBuilder().y(ClogBuilder.LogType.REWARD_TOKEN_FAIL).u(ClogBuilder.Page.WELFAREMAXLP).p(this.a.f.d));
                    this.b.onFail(new IllegalArgumentException("data: null"));
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements gm {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ al0.b a;
            public final /* synthetic */ in0 b;

            public b(a aVar, al0.b bVar, in0 in0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar, in0Var};
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
                this.b = in0Var;
            }

            @Override // com.baidu.tieba.gm
            public void a(@NonNull TaskResponseData taskResponseData) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, taskResponseData) == null) {
                    try {
                        this.a.a(qk0.b(new JSONObject(taskResponseData.getUi().getExtra())));
                    } catch (Exception e) {
                        dz0.e(new ClogBuilder().y(ClogBuilder.LogType.REWARD_COIN_FAIL).u(ClogBuilder.Page.WELFAREMAXLP).p(this.b.f.d).k("1").l("2"));
                        this.a.onFail(e);
                    }
                }
            }

            @Override // com.baidu.tieba.gm
            public void onError(int i, @NonNull String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                    dz0.e(new ClogBuilder().y(ClogBuilder.LogType.REWARD_COIN_FAIL).u(ClogBuilder.Page.WELFAREMAXLP).p(this.b.f.d).k("1").l("1").m(String.valueOf(i)));
                    this.a.onFail(new RuntimeException(str));
                }
            }
        }

        public a(nk0 nk0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nk0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.al0
        public void a(@NonNull in0 in0Var, @NonNull co0 co0Var, @NonNull al0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, in0Var, co0Var, bVar) == null) {
                String A = in0Var.h().A();
                if (!TextUtils.isEmpty(A)) {
                    e(A, in0Var, co0Var, bVar);
                    return;
                }
                vo0 a = ro0.b().a();
                kp0 kp0Var = new kp0();
                kp0Var.l(d(in0Var.h()));
                kp0Var.h(fp0.c);
                kp0Var.d("User-Agent", hf0.c().a().h());
                a.a(kp0Var, new C0410a(this, in0Var, bVar, co0Var));
            }
        }

        @Nullable
        public final JSONObject c(in0 in0Var, co0 co0Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, in0Var, co0Var)) == null) {
                try {
                    do0 h = in0Var.h();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id_from", h.t());
                    jSONObject.put("logid", h.B());
                    jSONObject.put("session_rewards", co0Var.a());
                    jSONObject.put("task_policy", h.v());
                    return jSONObject;
                } catch (JSONException unused) {
                    return null;
                }
            }
            return (JSONObject) invokeLL.objValue;
        }

        public final String d(@Nullable do0 do0Var) {
            InterceptResult invokeL;
            String b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, do0Var)) == null) {
                if (do0Var != null && !TextUtils.isEmpty(do0Var.a())) {
                    b2 = do0Var.a();
                } else {
                    b2 = mk0.a().b();
                }
                String g = hf0.d().g();
                if (!TextUtils.isEmpty(g)) {
                    return s21.a(b2, "cd", new String(Base64Encoder.B64Encode(g.getBytes())));
                }
                return b2;
            }
            return (String) invokeL.objValue;
        }

        public final void e(String str, @NonNull in0 in0Var, @NonNull co0 co0Var, @NonNull al0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, in0Var, co0Var, bVar) == null) {
                String u = in0Var.h().u();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(u)) {
                    BDPTask.m.G(str, u, 0, c(in0Var, co0Var), new b(this, bVar, in0Var));
                    return;
                }
                bVar.onFail(new IllegalArgumentException("token: " + str + " taskId: " + u));
            }
        }
    }

    public nk0() {
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
    @Override // com.baidu.tieba.fg1
    /* renamed from: a */
    public al0 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (al0) invokeV.objValue;
    }
}
