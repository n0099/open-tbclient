package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tieba.yt1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class im3 extends ya3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public transient /* synthetic */ FieldHolder $fh;
    public String s;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class c extends oa3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ im3 c;

        /* loaded from: classes6.dex */
        public class a implements ik3<Bundle> {
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
            public void a(Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                    if (bundle == null) {
                        na3.k("null stoken", Boolean.TRUE);
                        this.a.e(new OAuthException(10001));
                        return;
                    }
                    String string = bundle.getString(BdZeusUtil.URL_KEY_MACHINE, "");
                    if (TextUtils.isEmpty(string)) {
                        na3.k("empty stoken", Boolean.TRUE);
                        this.a.e(new OAuthException(10001));
                        return;
                    }
                    this.a.c.s = string;
                    this.a.d();
                }
            }
        }

        public c(im3 im3Var) {
            yt1.d dVar;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = im3Var;
            if (im3Var.o != null && (dVar = im3Var.n) != null && dVar.a) {
                long j = dVar.b;
                if (im3.t) {
                    Log.d("LoginRequest", "send timeout " + j + "ms msg");
                }
                im3Var.o.sendEmptyMessageDelayed(1, j < 0 ? 0L : j);
            }
        }

        public /* synthetic */ c(im3 im3Var, a aVar) {
            this(im3Var);
        }

        @Override // com.baidu.tieba.oa3
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ql3.t(this.c.m, new a(this), BdZeusUtil.URL_KEY_MACHINE);
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends oa3 implements cm1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ im3 c;

        public b(im3 im3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = im3Var;
        }

        public /* synthetic */ b(im3 im3Var, a aVar) {
            this(im3Var);
        }

        @Override // com.baidu.tieba.oa3
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                boolean e = wo2.h0().e(this.c.m);
                if (im3.t) {
                    Log.d("LoginRequest", "LoginPreparation isLogin : " + e + " call stack:" + Log.getStackTraceString(new Exception()));
                }
                if (e) {
                    im3 im3Var = this.c;
                    im3Var.i(new c(im3Var, null));
                    return true;
                }
                this.c.N().N().f(this.c.m, this.c.p, this);
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
                    im3 im3Var = this.c;
                    im3Var.i(new c(im3Var, null));
                    d();
                    return;
                }
                na3.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                e(new OAuthException(10004));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947858266, "Lcom/baidu/tieba/im3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947858266, "Lcom/baidu/tieba/im3;");
                return;
            }
        }
        t = am1.a;
    }

    @Override // com.baidu.tieba.ya3
    @NonNull
    public oa3 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new b(this, null);
        }
        return (oa3) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public im3(Activity activity, yt1.d dVar, Bundle bundle) {
        super(activity, dVar, bundle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, dVar, bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Activity) objArr2[0], (yt1.d) objArr2[1], (Bundle) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        y();
        z();
    }

    @Override // com.baidu.tieba.ya3, com.baidu.tieba.ma3
    public boolean k() {
        InterceptResult invokeV;
        Object obj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                boolean isEmpty = TextUtils.isEmpty(this.q);
                if (isEmpty) {
                    obj = N().P();
                } else {
                    obj = this.q;
                }
                jSONObject.put("ma_id", obj);
                JSONObject jSONObject2 = new JSONObject();
                if (isEmpty) {
                    str = N().P();
                } else {
                    str = this.q;
                }
                jSONObject2.put(GameGuideConfigInfo.KEY_APP_KEY, str);
                jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                jSONObject2.put("host_key_hash", na3.g());
                jSONObject2.put("stoken", this.s);
                String l = wo2.o().l();
                if (!TextUtils.isEmpty(l)) {
                    jSONObject2.put("host_api_key", l);
                }
                jSONObject.put("open", jSONObject2);
            } catch (JSONException e) {
                if (t) {
                    e.printStackTrace();
                }
            }
            w("data", jSONObject.toString());
            return true;
        }
        return invokeV.booleanValue;
    }
}
