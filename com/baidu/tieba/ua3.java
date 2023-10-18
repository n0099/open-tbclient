package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ua3 extends ab3<e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final String[] m;
    public final Context n;
    public boolean o;
    public boolean p;
    public boolean q;
    public pa3 r;
    public final String s;
    public final boolean t;
    public boolean u;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b extends oa3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ua3 c;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ pa3 b;
            public final /* synthetic */ b c;

            /* renamed from: com.baidu.tieba.ua3$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C0482a implements ka3 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0482a(a aVar) {
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

                @Override // com.baidu.tieba.ka3
                public void onResult(boolean z) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                        ua3 ua3Var = this.a.c.c;
                        ua3Var.p = z;
                        ua3Var.u = !z;
                        this.a.c.d();
                    }
                }
            }

            public a(b bVar, Activity activity, pa3 pa3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, activity, pa3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = activity;
                this.b = pa3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.isFinishing()) {
                    return;
                }
                na3.u(this.a, this.c.c.N(), this.b, null, new C0482a(this));
            }
        }

        public b(ua3 ua3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ua3Var;
        }

        @Override // com.baidu.tieba.oa3
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ua3 ua3Var = this.c;
                pa3 pa3Var = ua3Var.r;
                if (pa3Var == null) {
                    na3.k("Illegal ScopeInfo", Boolean.TRUE);
                    this.c.e(new OAuthException(10001));
                    ic3.r(10001, null);
                    return true;
                } else if (pa3Var.d) {
                    ua3Var.e(new OAuthException(10005));
                    ic3.r(10005, pa3Var);
                    return true;
                } else if (ua3Var.t || !ua3Var.p) {
                    return true;
                } else {
                    if (!ua3Var.o && pa3Var.j < 0) {
                        ua3Var.s(new e(false, null));
                        this.c.e(new OAuthException(10005));
                        return true;
                    } else if (pa3Var.j > 0) {
                        this.c.s(new e(true, null));
                        this.c.d();
                        return true;
                    } else if (this.c.N().o0()) {
                        na3.k("this operation does not supported when app is invisible.", Boolean.TRUE);
                        this.c.e(new OAuthException(10005));
                        return true;
                    } else {
                        Activity Z = this.c.Z();
                        if (Z == null) {
                            na3.k("login error context is not activity.", Boolean.TRUE);
                            this.c.e(new OAuthException(10005));
                            return true;
                        }
                        na3.l(new a(this, Z, pa3Var));
                        return false;
                    }
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c extends oa3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ua3 c;

        /* loaded from: classes8.dex */
        public class a implements ik3<pa3> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
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

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ik3
            /* renamed from: b */
            public void a(pa3 pa3Var) {
                Object obj;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pa3Var) == null) {
                    if (ma3.f) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("ListPreparation result: ");
                        if (pa3Var == null) {
                            obj = StringUtil.NULL_STRING;
                        } else {
                            obj = pa3Var;
                        }
                        sb.append(obj);
                        Log.i("aiapps-oauth", sb.toString());
                    }
                    c cVar = this.a;
                    cVar.c.r = pa3Var;
                    if (pa3Var == null) {
                        cVar.e(new Exception("no such scope"));
                        return;
                    }
                    if (pa3Var.e()) {
                        ua3 ua3Var = this.a.c;
                        if (!ua3Var.q) {
                            ua3Var.i(new d(ua3Var, null));
                            this.a.d();
                        }
                    }
                    ua3 ua3Var2 = this.a.c;
                    ua3Var2.i(new b(ua3Var2));
                    this.a.d();
                }
            }
        }

        public c(ua3 ua3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ua3Var;
        }

        public /* synthetic */ c(ua3 ua3Var, a aVar) {
            this(ua3Var);
        }

        @Override // com.baidu.tieba.oa3
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String[] strArr = this.c.m;
                if (strArr != null && strArr.length <= 1) {
                    nx2.i(strArr[0], new a(this));
                    return false;
                }
                d();
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d extends oa3 implements cm1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ua3 c;

        public d(ua3 ua3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ua3Var;
        }

        public /* synthetic */ d(ua3 ua3Var, a aVar) {
            this(ua3Var);
        }

        @Override // com.baidu.tieba.oa3
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ua3 ua3Var = this.c;
                ua3Var.q = true;
                if (ua3Var.N().N().e(this.c.n)) {
                    na3.k("LoginPreparation: isLogin true", Boolean.FALSE);
                    ua3 ua3Var2 = this.c;
                    ua3Var2.i(new c(ua3Var2, null));
                    return true;
                }
                p53 N = this.c.N();
                if (N.o0()) {
                    na3.k("this operation does not supported when app is invisible.", Boolean.TRUE);
                    e(new OAuthException(10004));
                    return true;
                }
                Activity Z = this.c.Z();
                if (Z == null) {
                    na3.k("login error context is not activity.", Boolean.TRUE);
                    e(new OAuthException(10004));
                    return true;
                }
                if (!o53.K().q().N().e(Z)) {
                    ic3.T(this.c.l, "passLogin");
                }
                N.N().f(Z, null, this);
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.cm1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                na3.k("onResult :: " + i, Boolean.FALSE);
                if (i != -2) {
                    if (i != 0) {
                        na3.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                        e(new OAuthException(10004));
                        return;
                    }
                    na3.k("Login Preparation ok, is already login", Boolean.FALSE);
                    ua3 ua3Var = this.c;
                    ua3Var.i(new c(ua3Var, null));
                    d();
                    return;
                }
                na3.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                e(new OAuthException(10004));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final boolean b;

        public e(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str == null ? "" : str;
            this.b = z;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return String.format("Result(%b):%s", Boolean.valueOf(this.b), this.a);
            }
            return (String) invokeV.objValue;
        }
    }

    public ua3(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Boolean.valueOf(z2), strArr, str, Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = false;
        this.u = false;
        this.n = context;
        this.o = z;
        this.m = strArr == null ? new String[0] : strArr;
        this.s = str;
        this.p = z2;
        this.t = z3;
    }

    @Override // com.baidu.tieba.ab3
    public HttpRequest x(ab3 ab3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ab3Var)) == null) {
            return wo2.o().F(this.n, ab3Var.C());
        }
        return (HttpRequest) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ab3
    public SwanInterfaceType A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return SwanInterfaceType.AUTHORIZE;
        }
        return (SwanInterfaceType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ab3
    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.J();
            if (this.u) {
                e(new OAuthException(10003));
                this.u = false;
            }
            if (TextUtils.isEmpty(this.s)) {
                nx2.f();
            }
        }
    }

    public Activity Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Context context = this.n;
            if (context instanceof Activity) {
                return (Activity) context;
            }
            p53 c0 = p53.c0();
            if (c0 == null) {
                return null;
            }
            return c0.w();
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ma3
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            i(new c(this, null));
            return super.l();
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ma3
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: a0 */
    public e n(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            JSONObject c2 = na3.c(jSONObject);
            int optInt = c2.optInt("errno", 10001);
            if (optInt != 0) {
                if (11001 == optInt) {
                    na3.m(c2);
                    na3.t("Authorize", c2.toString());
                }
                if (ma3.f) {
                    throw new JSONException("Illegal errno=" + optInt + " errms=" + c2.optString("errms"));
                }
            }
            JSONObject jSONObject2 = c2.getJSONObject("data");
            String str = "";
            if (jSONObject2 != null) {
                str = jSONObject2.optString("code", "");
            }
            return new e(this.p, str);
        }
        return (e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ma3
    public boolean k() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", N().P());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(GameGuideConfigInfo.KEY_APP_KEY, N().P());
                jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                jSONObject2.put("host_key_hash", na3.g());
                String l = wo2.o().l();
                if (!TextUtils.isEmpty(l)) {
                    jSONObject2.put("host_api_key", l);
                }
                jSONObject.put("open", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                for (String str : this.m) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("permit", Boolean.toString(this.p));
                    jSONObject3.put(str, jSONObject4);
                }
                jSONObject.put("accredits", jSONObject3);
                if (!TextUtils.isEmpty(this.s)) {
                    jSONObject.put("provider_appkey", this.s);
                }
            } catch (JSONException e2) {
                if (ma3.f) {
                    e2.printStackTrace();
                }
            }
            w("data", jSONObject.toString());
            return true;
        }
        return invokeV.booleanValue;
    }
}
