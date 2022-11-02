package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.tieba.j93;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class nl3 extends hs1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.hs1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "PrivateBusiness" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hs1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "QuickLoginApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class b implements km3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ nl3 b;

        /* loaded from: classes5.dex */
        public class a implements mm3 {
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

            @Override // com.baidu.tieba.mm3
            public void onResult(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                    if (i == 0) {
                        b bVar = this.a;
                        bVar.b.d(bVar.a, new ew1(0));
                        return;
                    }
                    b bVar2 = this.a;
                    bVar2.b.d(bVar2.a, new ew1(10004, "user not logged in"));
                }
            }
        }

        public b(nl3 nl3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nl3Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.km3
        public void a(QuickLoginInfo quickLoginInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, quickLoginInfo) == null) {
                if (quickLoginInfo == null) {
                    this.b.d(this.a, new ew1(1001));
                    return;
                }
                boolean z = quickLoginInfo.supportQuickLogin;
                int i = quickLoginInfo.loginMode;
                if (z) {
                    nm3.e(d43.K().w(), i, new a(this));
                } else {
                    this.b.d(this.a, new ew1(10004, "user not logged in"));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements xi3<h93<j93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ nl3 b;

        public a(nl3 nl3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nl3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(h93<j93.e> h93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h93Var) == null) {
                if (c93.h(h93Var)) {
                    this.b.C(this.a);
                    return;
                }
                int b = h93Var.b();
                c93.f(b);
                this.b.d(this.a, new ew1(b, c93.f(b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements xi3<h93<j93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ nl3 b;

        public c(nl3 nl3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nl3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(h93<j93.e> h93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h93Var) == null) {
                if (c93.h(h93Var)) {
                    this.b.B(this.a);
                    return;
                }
                int b = h93Var.b();
                c93.f(b);
                this.b.d(this.a, new ew1(b, c93.f(b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements km3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ nl3 b;

        public d(nl3 nl3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nl3Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.km3
        public void a(QuickLoginInfo quickLoginInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, quickLoginInfo) == null) {
                if (quickLoginInfo != null) {
                    this.b.E(this.a, quickLoginInfo);
                } else {
                    this.b.D(this.a);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nl3(@NonNull fs1 fs1Var) {
        super(fs1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fs1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((fs1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            nm3.b(new d(this, str));
        }
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            nm3.b(new b(this, str));
        }
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            d(str, new ew1(10001, "internal error"));
        }
    }

    public final void E(String str, QuickLoginInfo quickLoginInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, quickLoginInfo) == null) {
            if (quickLoginInfo == null) {
                d(str, new ew1(1001));
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("supportQuickLogin", quickLoginInfo.supportQuickLogin);
                jSONObject.put("encryptPhoneNum", quickLoginInfo.encryptPhoneNum);
                jSONObject.put("serviceAgreement", quickLoginInfo.serviceAgreement);
                jSONObject.put("hasHistory", quickLoginInfo.hasHistory);
                d(str, new ew1(0, jSONObject));
            } catch (JSONException unused) {
                d(str, new ew1(1001));
            }
        }
    }

    public ew1 F(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            Pair<ew1, JSONObject> s = s(str);
            ew1 ew1Var = (ew1) s.first;
            if (ew1Var.isSuccess() && (obj = s.second) != null) {
                String optString = ((JSONObject) obj).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new ew1(1001, "cb is empty");
                }
                e43 b0 = e43.b0();
                if (b0 == null) {
                    return new ew1(1001);
                }
                b0.e0().g(getContext(), "scope_quick_login", new c(this, optString));
                return new ew1(0);
            }
            e12.c("QuickLoginApi", "parse fail");
            return ew1Var;
        }
        return (ew1) invokeL.objValue;
    }

    public ew1 G(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#quickLogin", false);
            Pair<ew1, JSONObject> s = s(str);
            ew1 ew1Var = (ew1) s.first;
            if (ew1Var.isSuccess() && (obj = s.second) != null) {
                String optString = ((JSONObject) obj).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new ew1(1001, "cb is empty");
                }
                e43 b0 = e43.b0();
                if (b0 == null) {
                    return new ew1(1001);
                }
                b0.e0().g(getContext(), "scope_quick_login", new a(this, optString));
                return ew1.f();
            }
            return ew1Var;
        }
        return (ew1) invokeL.objValue;
    }
}
