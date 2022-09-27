package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.tieba.in1;
import com.baidu.tieba.jo2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class r02 extends i53 {
    public static /* synthetic */ Interceptable $ic;
    public static Set<String> f;
    public static final Set<String> g;
    public transient /* synthetic */ FieldHolder $fh;
    public ExecutorService c;
    public int d;
    public t02 e;

    /* loaded from: classes5.dex */
    public class a implements in1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ r02 d;

        public a(r02 r02Var, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r02Var, context, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = r02Var;
            this.a = context;
            this.b = unitedSchemeEntity;
            this.c = callbackHandler;
        }

        @Override // com.baidu.tieba.in1.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    l02.c("LocalDebugAction", "Authentication Success");
                    r02.g.add(this.d.o(this.a));
                    this.d.p(this.a, this.b, this.c);
                    return;
                }
                l02.c("LocalDebugAction", "Authentication Fail : Not developer");
                this.d.w(this.a, this.b, 401);
            }
        }

        @Override // com.baidu.tieba.in1.b
        public void b(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                l02.d("LocalDebugAction", "onFail : Authentication exception :", exc);
                this.d.w(this.a, this.b, 401);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ r02 f;

        public b(r02 r02Var, Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r02Var, context, str, file, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = r02Var;
            this.a = context;
            this.b = str;
            this.c = file;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.x(this.a, this.b, this.c, this.d, this.e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948067733, "Lcom/baidu/tieba/r02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948067733, "Lcom/baidu/tieba/r02;");
                return;
            }
        }
        g = new HashSet();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r02(i43 i43Var) {
        super(i43Var, "/swanAPI/localdebuglaunch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i43Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.i53
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, l33Var)) == null) {
            if (!t()) {
                l02.c("LocalDebugAction", "switch is off");
                w(context, unitedSchemeEntity, 1003);
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                this.e = t02.c(optParamsAsJo);
                if (qc3.e(0).swanCoreVersionCode < this.e.h) {
                    l02.c("LocalDebugAction", "swan js version is low");
                    w(context, unitedSchemeEntity, 1002);
                    return false;
                } else if (!u()) {
                    l02.c("LocalDebugAction", "debug model invalid");
                    w(context, unitedSchemeEntity, 202);
                    return false;
                } else if (!SwanAppAllianceLoginHelper.d.f() && !s().contains(sm2.h0().h(context)) && !g.contains(o(context))) {
                    yj1.b(this.e.b, new a(this, context, unitedSchemeEntity, callbackHandler));
                    return true;
                } else {
                    p(context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
            }
            l02.c("LocalDebugAction", "param is null");
            w(context, unitedSchemeEntity, 202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final String o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return sm2.h0().h(context) + this.e.b;
        }
        return (String) invokeL.objValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler) == null) {
            File b2 = s02.b();
            if (b2.exists()) {
                boolean L = pj4.L(b2);
                l02.i("LocalDebugAction", "debug bundle delete: " + L);
            }
            if (s02.g()) {
                boolean L2 = pj4.L(s02.d());
                l02.i("LocalDebugAction", "unzip folder delete: " + L2);
            }
            this.c = Executors.newFixedThreadPool(4);
            this.d = 0;
            u02.e().f("downloadstart");
            for (int i = 0; i < this.e.c.length(); i++) {
                String a2 = this.e.a(i);
                if (TextUtils.isEmpty(a2)) {
                    int i2 = this.d + 1;
                    this.d = i2;
                    if (i2 >= this.e.c.length()) {
                        l02.c("LocalDebugAction", "IPs are invalid");
                        w(context, unitedSchemeEntity, 202);
                        u02.e().f("downloadfail");
                    }
                } else {
                    this.c.execute(new b(this, context, a2, b2, unitedSchemeEntity, callbackHandler));
                }
            }
        }
    }

    public final void q() {
        l33 b0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (b0 = l33.b0()) == null) {
            return;
        }
        uf3.j(b0.w());
        System.exit(0);
    }

    public final String r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                if (i53.b) {
                    Log.e("LocalDebugAction", "url encode fail", e);
                    return str;
                }
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public final Set<String> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (f == null) {
                f = new HashSet();
                ua4 b2 = wa4.b();
                String string = b2 != null ? b2.i().getString("auth_white_list", "") : "";
                JSONArray jSONArray = null;
                try {
                    jSONArray = new JSONArray(string);
                } catch (JSONException unused) {
                    if (i53.b) {
                        Log.d("LocalDebugAction", "JSONException: parse cloud white list");
                    }
                }
                if (jSONArray != null) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        f.add(jSONArray.optString(i));
                    }
                }
            }
            return f;
        }
        return (Set) invokeV.objValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ua4 b2 = wa4.b();
            return TextUtils.equals(b2 != null ? b2.i().getString("enable_local_debug_switch", "1") : "1", "1");
        }
        return invokeV.booleanValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (TextUtils.isEmpty(this.e.a) || TextUtils.isEmpty(this.e.b) || (jSONArray = this.e.c) == null || jSONArray.length() <= 0 || TextUtils.isEmpty(this.e.d)) ? false : true : invokeV.booleanValue;
    }

    public final jo2.a v(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, unitedSchemeEntity)) == null) {
            String uri = (unitedSchemeEntity == null || unitedSchemeEntity.getUri() == null) ? "" : unitedSchemeEntity.getUri().toString();
            l02.i("LocalDebugAction", "local debug scheme = " + uri);
            return (jo2.a) ((jo2.a) ((jo2.a) ((jo2.a) ((jo2.a) ((jo2.a) ((jo2.a) new jo2.a().v0(this.e.b)).A0(false)).L0(true)).M0(this.e.e)).N0(this.e.f)).K0(uri)).P0(this.e.g);
        }
        return (jo2.a) invokeL.objValue;
    }

    public final void w(Context context, UnitedSchemeEntity unitedSchemeEntity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048585, this, context, unitedSchemeEntity, i) == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(i);
            ua4 b2 = wa4.b();
            String string = b2 != null ? b2.i().getString("error_url", "") : "";
            if (TextUtils.isEmpty(string)) {
                d33.g(context, "IPs are invalid ：" + i).G();
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(SchemeConfig.getSchemeHead());
            sb.append("://v1/easybrowse/open?url=");
            sb.append(r(string + "?" + i));
            SchemeRouter.invoke(context, sb.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c4, code lost:
        if (r6 >= r4.e.c.length()) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x(Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048586, this, context, str, file, unitedSchemeEntity, callbackHandler) == null) {
            try {
                Response executeSync = pa4.g().getRequest().url(this.e.b(str)).connectionTimeout(3000).build().executeSync();
                if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                    boolean a2 = sj4.a(executeSync.body().byteStream(), file);
                    l02.i("LocalDebugAction", "save debug bundle: " + a2);
                    u02.e().f("downloadsuccess");
                    this.e.e = str;
                    context.startActivity(jo2.g1(context, v(unitedSchemeEntity)));
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.c != null) {
                        this.c.shutdownNow();
                        this.c = null;
                    }
                    if (!ProcessUtils.isMainProcess()) {
                        if (i53.b) {
                            Log.d("LocalDebugAction", "Suicide for reload.");
                        }
                        q();
                    }
                }
                if (executeSync != null) {
                    executeSync.close();
                }
            } catch (IOException unused) {
                synchronized (this) {
                    if (this.e.c != null) {
                        int i = this.d + 1;
                        this.d = i;
                    }
                    l02.c("LocalDebugAction", "Host IPs are invalid");
                    w(context, unitedSchemeEntity, 1001);
                    u02.e().f("downloadfail");
                }
            }
        }
    }
}
