package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tieba.pz1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qg3 extends sg3<d> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity m;
    public pz1.d n;
    public c o;
    public Bundle p;
    public String q;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends gg3 implements tr1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qg3 c;

        public b(qg3 qg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qg3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qg3Var;
        }

        public /* synthetic */ b(qg3 qg3Var, a aVar) {
            this(qg3Var);
        }

        @Override // com.baidu.tieba.gg3
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ur1 N = this.c.M().N();
                boolean e = N.e(this.c.m);
                if (qg3.r) {
                    Log.d("LoginRequest", "LoginPreparation isLogin : " + e + " call stack:" + Log.getStackTraceString(new Exception()));
                }
                if (!e) {
                    ai3.T(this.c.l, "passLogin");
                    qg3 qg3Var = this.c;
                    N.f(qg3Var.m, qg3Var.p, this);
                }
                return e;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.tr1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                fg3.k("onResult :: " + i, Boolean.FALSE);
                if (i != -2) {
                    if (i != 0) {
                        fg3.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                        e(new OAuthException(10004));
                        return;
                    }
                    fg3.k("Login Preparation ok, is already login", Boolean.FALSE);
                    d();
                    return;
                }
                fg3.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                e(new OAuthException(10004));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<qg3> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Looper looper, qg3 qg3Var) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper, qg3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(qg3Var);
        }

        public /* synthetic */ c(Looper looper, qg3 qg3Var, a aVar) {
            this(looper, qg3Var);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            qg3 qg3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (qg3Var = this.a.get()) != null && message.what == 1) {
                if (qg3.r) {
                    Log.d("LoginRequest", "handleMessage: timeout");
                }
                fg3.k("request timeout", Boolean.TRUE);
                qg3Var.d(new OAuthException(10002));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        public d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
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
        }

        public /* synthetic */ d(String str, a aVar) {
            this(str);
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return String.format("Result code(%s)", this.a);
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948090828, "Lcom/baidu/tieba/qg3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948090828, "Lcom/baidu/tieba/qg3;");
                return;
            }
        }
        r = rr1.a;
    }

    @NonNull
    public gg3 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new b(this, null);
        }
        return (gg3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.eg3
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            h(Q());
            return super.k();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.sg3
    public SwanInterfaceType z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return SwanInterfaceType.LOGIN;
        }
        return (SwanInterfaceType) invokeV.objValue;
    }

    public qg3(Activity activity, pz1.d dVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, dVar, bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = activity;
        this.n = dVar;
        this.o = new c(Looper.getMainLooper(), this, null);
        if (bundle != null && bundle.containsKey("__plugin__")) {
            this.q = bundle.getString("__plugin__");
            bundle.remove("__plugin__");
            h82.k("LoginRequest", "Info: Remove previous account.");
        }
        this.p = bundle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.eg3
    /* renamed from: R */
    public d m(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            JSONObject c2 = fg3.c(jSONObject);
            int optInt = c2.optInt("errno", 10001);
            if (optInt != 0) {
                if (11001 == optInt) {
                    fg3.m(c2);
                    fg3.t("LoginRequest", c2.toString());
                }
                if (r) {
                    throw new OAuthException(c2.optString("errmsg"), optInt);
                }
            }
            JSONObject jSONObject2 = c2.getJSONObject("data");
            String str = "";
            if (jSONObject2 != null) {
                str = jSONObject2.optString("code", "");
            }
            return new d(str, null);
        }
        return (d) invokeL.objValue;
    }

    @Override // com.baidu.tieba.eg3
    public void d(@Nullable Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            super.d(exc);
            if (r) {
                Log.d("LoginRequest", "finish: remove timeout msg");
            }
            this.o.removeMessages(1);
        }
    }

    @Override // com.baidu.tieba.sg3
    public HttpRequest w(sg3 sg3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, sg3Var)) == null) {
            return ou2.o().s(this.m, sg3Var.B());
        }
        return (HttpRequest) invokeL.objValue;
    }

    @Override // com.baidu.tieba.eg3
    public boolean j() {
        InterceptResult invokeV;
        Object obj;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                boolean isEmpty = TextUtils.isEmpty(this.q);
                if (isEmpty) {
                    obj = M().O();
                } else {
                    obj = this.q;
                }
                jSONObject.put("ma_id", obj);
                JSONObject jSONObject2 = new JSONObject();
                if (isEmpty) {
                    str = M().O();
                } else {
                    str = this.q;
                }
                jSONObject2.put(GameGuideConfigInfo.KEY_APP_KEY, str);
                jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                jSONObject2.put("host_key_hash", fg3.g());
                String l = ou2.o().l();
                if (!TextUtils.isEmpty(l)) {
                    jSONObject2.put("host_api_key", l);
                }
                jSONObject.put("open", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            v("data", jSONObject.toString());
            return true;
        }
        return invokeV.booleanValue;
    }
}
