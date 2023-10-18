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
import com.baidu.tieba.ik0;
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
public class vj0 extends kf1<ik0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements ik0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.vj0$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0499a implements io0<JSONObject> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ pm0 a;
            public final /* synthetic */ ik0.b b;
            public final /* synthetic */ in0 c;
            public final /* synthetic */ a d;

            @Override // com.baidu.tieba.ho0
            public void c(Headers headers, InputStream inputStream, int i) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, headers, inputStream, i) == null) {
                }
            }

            public C0499a(a aVar, pm0 pm0Var, ik0.b bVar, in0 in0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, pm0Var, bVar, in0Var};
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
                this.a = pm0Var;
                this.b = bVar;
                this.c = in0Var;
            }

            @Override // com.baidu.tieba.ho0
            public void a(Exception exc, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                    jy0.e(new ClogBuilder().y(ClogBuilder.LogType.REWARD_TOKEN_FAIL).u(ClogBuilder.Page.WELFAREMAXLP).p(this.a.f.d));
                    this.b.onFail(exc);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.io0
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
            @Override // com.baidu.tieba.io0
            /* renamed from: e */
            public void b(Headers headers, JSONObject jSONObject, int i) {
                JSONObject optJSONObject;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(1048580, this, headers, jSONObject, i) == null) {
                    if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                        this.d.e(optJSONObject.optString("token"), this.a, this.c, this.b);
                        return;
                    }
                    jy0.e(new ClogBuilder().y(ClogBuilder.LogType.REWARD_TOKEN_FAIL).u(ClogBuilder.Page.WELFAREMAXLP).p(this.a.f.d));
                    this.b.onFail(new IllegalArgumentException("data: null"));
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements ol {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ik0.b a;
            public final /* synthetic */ pm0 b;

            public b(a aVar, ik0.b bVar, pm0 pm0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar, pm0Var};
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
                this.b = pm0Var;
            }

            @Override // com.baidu.tieba.ol
            public void a(@NonNull TaskResponseData taskResponseData) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, taskResponseData) == null) {
                    try {
                        this.a.a(yj0.b(new JSONObject(taskResponseData.getUi().getExtra())));
                    } catch (Exception e) {
                        jy0.e(new ClogBuilder().y(ClogBuilder.LogType.REWARD_COIN_FAIL).u(ClogBuilder.Page.WELFAREMAXLP).p(this.b.f.d).k("1").l("2"));
                        this.a.onFail(e);
                    }
                }
            }

            @Override // com.baidu.tieba.ol
            public void onError(int i, @NonNull String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                    jy0.e(new ClogBuilder().y(ClogBuilder.LogType.REWARD_COIN_FAIL).u(ClogBuilder.Page.WELFAREMAXLP).p(this.b.f.d).k("1").l("1").m(String.valueOf(i)));
                    this.a.onFail(new RuntimeException(str));
                }
            }
        }

        public a(vj0 vj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ik0
        public void a(@NonNull pm0 pm0Var, @NonNull in0 in0Var, @NonNull ik0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, pm0Var, in0Var, bVar) == null) {
                String A = pm0Var.g().A();
                if (!TextUtils.isEmpty(A)) {
                    e(A, pm0Var, in0Var, bVar);
                    return;
                }
                bo0 a = xn0.b().a();
                qo0 qo0Var = new qo0();
                qo0Var.l(d(pm0Var.g()));
                qo0Var.h(lo0.c);
                qo0Var.d("User-Agent", pe0.c().a().h());
                a.a(qo0Var, new C0499a(this, pm0Var, bVar, in0Var));
            }
        }

        @Nullable
        public final JSONObject c(pm0 pm0Var, in0 in0Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pm0Var, in0Var)) == null) {
                try {
                    jn0 g = pm0Var.g();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id_from", g.t());
                    jSONObject.put("logid", g.B());
                    jSONObject.put("session_rewards", in0Var.a());
                    jSONObject.put("task_policy", g.v());
                    return jSONObject;
                } catch (JSONException unused) {
                    return null;
                }
            }
            return (JSONObject) invokeLL.objValue;
        }

        public final String d(@Nullable jn0 jn0Var) {
            InterceptResult invokeL;
            String b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jn0Var)) == null) {
                if (jn0Var != null && !TextUtils.isEmpty(jn0Var.a())) {
                    b2 = jn0Var.a();
                } else {
                    b2 = uj0.a().b();
                }
                String g = pe0.d().g();
                if (!TextUtils.isEmpty(g)) {
                    return y11.a(b2, "cd", new String(Base64Encoder.B64Encode(g.getBytes())));
                }
                return b2;
            }
            return (String) invokeL.objValue;
        }

        public final void e(String str, @NonNull pm0 pm0Var, @NonNull in0 in0Var, @NonNull ik0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, pm0Var, in0Var, bVar) == null) {
                String u = pm0Var.g().u();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(u)) {
                    BDPTask.m.G(str, u, 0, c(pm0Var, in0Var), new b(this, bVar, pm0Var));
                    return;
                }
                bVar.onFail(new IllegalArgumentException("token: " + str + " taskId: " + u));
            }
        }
    }

    public vj0() {
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
    @Override // com.baidu.tieba.kf1
    /* renamed from: a */
    public ik0 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (ik0) invokeV.objValue;
    }
}
