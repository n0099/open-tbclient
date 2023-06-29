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
import com.baidu.tieba.xp0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class np0 extends wl1<xp0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements xp0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.np0$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0417a implements ot0<JSONObject> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ yr0 a;
            public final /* synthetic */ xp0.b b;
            public final /* synthetic */ os0 c;
            public final /* synthetic */ a d;

            @Override // com.baidu.tieba.nt0
            public void c(Headers headers, InputStream inputStream, int i) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, headers, inputStream, i) == null) {
                }
            }

            public C0417a(a aVar, yr0 yr0Var, xp0.b bVar, os0 os0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, yr0Var, bVar, os0Var};
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
                this.a = yr0Var;
                this.b = bVar;
                this.c = os0Var;
            }

            @Override // com.baidu.tieba.nt0
            public void a(Exception exc, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                    r31.b(new ClogBuilder().y(ClogBuilder.LogType.REWARD_TOKEN_FAIL).u(ClogBuilder.Page.WELFAREMAXLP).p(this.a.f.d));
                    this.b.onFail(exc);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ot0
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
            @Override // com.baidu.tieba.ot0
            /* renamed from: e */
            public void b(Headers headers, JSONObject jSONObject, int i) {
                JSONObject optJSONObject;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(1048580, this, headers, jSONObject, i) == null) {
                    if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                        this.d.e(optJSONObject.optString("token"), this.a, this.c, this.b);
                        return;
                    }
                    r31.b(new ClogBuilder().y(ClogBuilder.LogType.REWARD_TOKEN_FAIL).u(ClogBuilder.Page.WELFAREMAXLP).p(this.a.f.d));
                    this.b.onFail(new IllegalArgumentException("data: null"));
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements or {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xp0.b a;
            public final /* synthetic */ yr0 b;

            public b(a aVar, xp0.b bVar, yr0 yr0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar, yr0Var};
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
                this.b = yr0Var;
            }

            @Override // com.baidu.tieba.or
            public void a(@NonNull TaskResponseData taskResponseData) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, taskResponseData) == null) {
                    try {
                        this.a.a(qp0.b(new JSONObject(taskResponseData.getUi().getExtra())));
                    } catch (Exception e) {
                        r31.b(new ClogBuilder().y(ClogBuilder.LogType.REWARD_COIN_FAIL).u(ClogBuilder.Page.WELFAREMAXLP).p(this.b.f.d).k("1").l("2"));
                        this.a.onFail(e);
                    }
                }
            }

            @Override // com.baidu.tieba.or
            public void onError(int i, @NonNull String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                    r31.b(new ClogBuilder().y(ClogBuilder.LogType.REWARD_COIN_FAIL).u(ClogBuilder.Page.WELFAREMAXLP).p(this.b.f.d).k("1").l("1").m(String.valueOf(i)));
                    this.a.onFail(new RuntimeException(str));
                }
            }
        }

        public a(np0 np0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {np0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final String d(@Nullable ps0 ps0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ps0Var)) == null) {
                if (ps0Var != null && !TextUtils.isEmpty(ps0Var.a())) {
                    return ps0Var.a();
                }
                return mp0.a().b();
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.xp0
        public void a(@NonNull yr0 yr0Var, @NonNull os0 os0Var, @NonNull xp0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, yr0Var, os0Var, bVar) == null) {
                String A = yr0Var.g().A();
                if (!TextUtils.isEmpty(A)) {
                    e(A, yr0Var, os0Var, bVar);
                    return;
                }
                ht0 a = dt0.b().a();
                wt0 wt0Var = new wt0();
                wt0Var.l(d(yr0Var.g()));
                wt0Var.h(rt0.c);
                wt0Var.d("User-Agent", ok0.c().a().h());
                a.a(wt0Var, new C0417a(this, yr0Var, bVar, os0Var));
            }
        }

        @Nullable
        public final JSONObject c(yr0 yr0Var, os0 os0Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yr0Var, os0Var)) == null) {
                try {
                    ps0 g = yr0Var.g();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id_from", g.t());
                    jSONObject.put("logid", g.B());
                    jSONObject.put("session_rewards", os0Var.a());
                    jSONObject.put("task_policy", g.v());
                    return jSONObject;
                } catch (JSONException unused) {
                    return null;
                }
            }
            return (JSONObject) invokeLL.objValue;
        }

        public final void e(String str, @NonNull yr0 yr0Var, @NonNull os0 os0Var, @NonNull xp0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, yr0Var, os0Var, bVar) == null) {
                String u = yr0Var.g().u();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(u)) {
                    BDPTask.m.G(str, u, 0, c(yr0Var, os0Var), new b(this, bVar, yr0Var));
                    return;
                }
                bVar.onFail(new IllegalArgumentException("token: " + str + " taskId: " + u));
            }
        }
    }

    public np0() {
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
    @Override // com.baidu.tieba.wl1
    /* renamed from: a */
    public xp0 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (xp0) invokeV.objValue;
    }
}
