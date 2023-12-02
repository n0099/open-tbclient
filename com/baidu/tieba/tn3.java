package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.tieba.pb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class tn3 extends ou1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ou1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "PrivateBusiness" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "QuickLoginApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class b implements qo3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ tn3 b;

        /* loaded from: classes8.dex */
        public class a implements so3 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
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

            @Override // com.baidu.tieba.so3
            public void onResult(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                    if (i == 0) {
                        b bVar = this.a;
                        bVar.b.d(bVar.a, new ly1(0));
                        return;
                    }
                    b bVar2 = this.a;
                    bVar2.b.d(bVar2.a, new ly1(10004, "user not logged in"));
                }
            }
        }

        public b(tn3 tn3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tn3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tn3Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.qo3
        public void a(QuickLoginInfo quickLoginInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, quickLoginInfo) == null) {
                if (quickLoginInfo == null) {
                    this.b.d(this.a, new ly1(1001));
                    return;
                }
                boolean z = quickLoginInfo.supportQuickLogin;
                int i = quickLoginInfo.loginMode;
                if (z) {
                    to3.e(j63.K().w(), i, new a(this));
                } else {
                    this.b.d(this.a, new ly1(10004, "user not logged in"));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ tn3 b;

        public a(tn3 tn3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tn3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tn3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (ib3.h(nb3Var)) {
                    this.b.D(this.a);
                    return;
                }
                int b = nb3Var.b();
                ib3.f(b);
                this.b.d(this.a, new ly1(b, ib3.f(b)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ tn3 b;

        public c(tn3 tn3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tn3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tn3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (ib3.h(nb3Var)) {
                    this.b.C(this.a);
                    return;
                }
                int b = nb3Var.b();
                ib3.f(b);
                this.b.d(this.a, new ly1(b, ib3.f(b)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements qo3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ tn3 b;

        public d(tn3 tn3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tn3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tn3Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.qo3
        public void a(QuickLoginInfo quickLoginInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, quickLoginInfo) == null) {
                if (quickLoginInfo == null) {
                    this.b.E(this.a);
                } else {
                    this.b.F(this.a, quickLoginInfo);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tn3(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            to3.b(new d(this, str));
        }
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            to3.b(new b(this, str));
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            d(str, new ly1(10001, "internal error"));
        }
    }

    public final void F(String str, QuickLoginInfo quickLoginInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, quickLoginInfo) == null) {
            if (quickLoginInfo == null) {
                d(str, new ly1(1001));
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("supportQuickLogin", quickLoginInfo.supportQuickLogin);
                jSONObject.put("encryptPhoneNum", quickLoginInfo.encryptPhoneNum);
                jSONObject.put("serviceAgreement", quickLoginInfo.serviceAgreement);
                jSONObject.put("hasHistory", quickLoginInfo.hasHistory);
                d(str, new ly1(0, jSONObject));
            } catch (JSONException unused) {
                d(str, new ly1(1001));
            }
        }
    }

    public ly1 G(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            if (ly1Var.isSuccess() && (obj = t.second) != null) {
                String optString = ((JSONObject) obj).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new ly1(1001, "cb is empty");
                }
                k63 c0 = k63.c0();
                if (c0 == null) {
                    return new ly1(1001);
                }
                c0.f0().g(i(), "scope_quick_login", new c(this, optString));
                return new ly1(0);
            }
            k32.c("QuickLoginApi", "parse fail");
            return ly1Var;
        }
        return (ly1) invokeL.objValue;
    }

    public ly1 H(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            r("#quickLogin", false);
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            if (ly1Var.isSuccess() && (obj = t.second) != null) {
                String optString = ((JSONObject) obj).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new ly1(1001, "cb is empty");
                }
                k63 c0 = k63.c0();
                if (c0 == null) {
                    return new ly1(1001);
                }
                c0.f0().g(i(), "scope_quick_login", new a(this, optString));
                return ly1.f();
            }
            return ly1Var;
        }
        return (ly1) invokeL.objValue;
    }
}
