package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tieba.ah3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ks3 extends ah3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String v;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b extends ug3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ks3 c;

        /* loaded from: classes6.dex */
        public class a implements oq3<vg3> {
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

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.oq3
            /* renamed from: b */
            public void a(vg3 vg3Var) {
                Object obj;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vg3Var) == null) {
                    if (sg3.f) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("ListPreparation result: ");
                        if (vg3Var == null) {
                            obj = StringUtil.NULL_STRING;
                        } else {
                            obj = vg3Var;
                        }
                        sb.append(obj);
                        Log.i("aiapps-oauth", sb.toString());
                    }
                    this.a.c.r = vg3Var;
                    if (vg3Var == null) {
                        this.a.e(new Exception("no such scope"));
                        return;
                    }
                    if (vg3Var.e() && !this.a.c.q) {
                        ks3 ks3Var = this.a.c;
                        ks3Var.h(new c(ks3Var, null));
                    } else {
                        ks3 ks3Var2 = this.a.c;
                        ks3Var2.h(new ah3.b(ks3Var2));
                    }
                    this.a.d();
                }
            }
        }

        public b(ks3 ks3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ks3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ks3Var;
        }

        public /* synthetic */ b(ks3 ks3Var, a aVar) {
            this(ks3Var);
        }

        @Override // com.baidu.tieba.ug3
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!TextUtils.isEmpty(this.c.s)) {
                    d();
                    return false;
                } else if (this.c.m.length > 1) {
                    d();
                    return false;
                } else {
                    t33.i(this.c.m[0], new a(this));
                    return false;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d extends ug3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ks3 c;

        /* loaded from: classes6.dex */
        public class a implements oq3<Bundle> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
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

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.oq3
            /* renamed from: b */
            public void a(Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                    if (bundle == null) {
                        this.a.e(new OAuthException("null stoken", 10001));
                        return;
                    }
                    String string = bundle.getString(BdZeusUtil.URL_KEY_MACHINE, "");
                    if (TextUtils.isEmpty(string)) {
                        this.a.e(new OAuthException("empty stoken", 10001));
                        return;
                    }
                    this.a.c.v = string;
                    ks3 ks3Var = this.a.c;
                    ks3Var.h(new b(ks3Var, null));
                    this.a.d();
                }
            }
        }

        public d(ks3 ks3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ks3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ks3Var;
        }

        public /* synthetic */ d(ks3 ks3Var, a aVar) {
            this(ks3Var);
        }

        @Override // com.baidu.tieba.ug3
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                wr3.t(this.c.n, new a(this), BdZeusUtil.URL_KEY_MACHINE);
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends ug3 implements hs1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ks3 c;

        public c(ks3 ks3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ks3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ks3Var;
        }

        public /* synthetic */ c(ks3 ks3Var, a aVar) {
            this(ks3Var);
        }

        @Override // com.baidu.tieba.ug3
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.c.q = true;
                if (this.c.M().N().e(this.c.n)) {
                    tg3.k("LoginPreparation: isLogin true", Boolean.FALSE);
                    ks3 ks3Var = this.c;
                    ks3Var.h(new d(ks3Var, null));
                    return true;
                }
                vb3 M = this.c.M();
                if (M.n0()) {
                    tg3.k("this operation does not supported when app is invisible.", Boolean.TRUE);
                    e(new OAuthException(10004));
                    return true;
                } else if (!(this.c.n instanceof Activity)) {
                    tg3.k("login error context is not activity.", Boolean.TRUE);
                    e(new OAuthException(10004));
                    return true;
                } else {
                    M.N().f((Activity) this.c.n, null, this);
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.hs1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                tg3.k("onResult :: " + i, Boolean.FALSE);
                if (i != -2) {
                    if (i != 0) {
                        tg3.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                        e(new OAuthException(10004));
                        return;
                    }
                    tg3.k("Login Preparation ok, is already login", Boolean.FALSE);
                    ks3 ks3Var = this.c;
                    ks3Var.h(new d(ks3Var, null));
                    d();
                    return;
                }
                tg3.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                e(new OAuthException(10004));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ks3(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        super(context, z, z2, strArr, str, z3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Boolean.valueOf(z2), strArr, str, Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue(), (String[]) objArr2[3], (String) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (z2) {
            y();
        }
    }

    @Override // com.baidu.tieba.ah3, com.baidu.tieba.gh3
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.I();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ah3, com.baidu.tieba.sg3
    /* renamed from: Z */
    public ah3.e m(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            Context context = this.n;
            if (context instanceof Activity) {
                wr3.D((Activity) context, jSONObject);
            } else if (sg3.f) {
                Log.d("SearchBoxAuthorize", Log.getStackTraceString(new Exception("context is not activity.")));
            }
            return super.m(jSONObject);
        }
        return (ah3.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ah3, com.baidu.tieba.sg3
    public boolean j() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", M().O());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(GameGuideConfigInfo.KEY_APP_KEY, M().O());
                jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                jSONObject2.put("host_key_hash", tg3.g());
                jSONObject2.put("stoken", this.v);
                String l = cv2.o().l();
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
            } catch (JSONException e) {
                e.printStackTrace();
            }
            v("data", jSONObject.toString());
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ah3, com.baidu.tieba.sg3
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (M().N().e(this.n)) {
                h(new d(this, null));
                return true;
            }
            h(new b(this, null));
            return true;
        }
        return invokeV.booleanValue;
    }
}
