package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.gp2;
import com.baidu.tieba.iq1;
import com.baidu.tieba.ir2;
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
/* loaded from: classes9.dex */
public class x32 extends h83 {
    public static /* synthetic */ Interceptable $ic;
    public static Set<String> g;
    public static Set<String> h;
    public transient /* synthetic */ FieldHolder $fh;
    public z32 c;
    public ExecutorService d;
    public int e;
    public ir2.a f;

    /* loaded from: classes9.dex */
    public class a implements iq1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ x32 d;

        public a(x32 x32Var, UnitedSchemeEntity unitedSchemeEntity, Context context, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x32Var, unitedSchemeEntity, context, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = x32Var;
            this.a = unitedSchemeEntity;
            this.b = context;
            this.c = callbackHandler;
        }

        @Override // com.baidu.tieba.iq1.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    k32.c("DebuggerLaunchAction", "Authentication Success");
                    x32.h.add(this.d.o(this.b));
                    this.d.p(this.b, this.a, this.c);
                    return;
                }
                k32.c("DebuggerLaunchAction", "Authentication Fail : Not developer");
                this.a.result = UnitedSchemeUtility.wrapCallbackParams(401);
                this.d.v(this.b, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
            }
        }

        @Override // com.baidu.tieba.iq1.b
        public void b(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                k32.d("DebuggerLaunchAction", "onFail : Authentication exception :", exc);
                this.a.result = UnitedSchemeUtility.wrapCallbackParams(401);
                this.d.v(this.b, TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ x32 f;

        public b(x32 x32Var, Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x32Var, context, str, file, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = x32Var;
            this.a = context;
            this.b = str;
            this.c = file;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.f.w(this.a, this.b, this.c, this.d, this.e);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948249362, "Lcom/baidu/tieba/x32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948249362, "Lcom/baidu/tieba/x32;");
                return;
            }
        }
        h = new HashSet();
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            JSONArray jSONArray = this.c.b;
            if (jSONArray != null && jSONArray.length() > 0 && !TextUtils.isEmpty(this.c.c)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x32(h73 h73Var) {
        super(h73Var, "/swanAPI/debuggerlaunch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h73Var};
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

    @Override // com.baidu.tieba.h83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, k63Var)) == null) {
            boolean equals = TextUtils.equals(ye3.a().getString("enableSwitch", "1"), "1");
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo != null && optParamsAsJo.length() > 0 && equals) {
                z32 b2 = z32.b(optParamsAsJo);
                this.c = b2;
                if (b2 == null) {
                    if (h83.b) {
                        Log.e("DebuggerLaunchAction", "Remote Debug params is invalid");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else if (!u()) {
                    v(context, com.baidu.mobads.sdk.internal.ci.b);
                    return false;
                } else if (!SwanAppAllianceLoginHelper.d.f() && !t().contains(rp2.h0().h(context)) && !h.contains(o(context))) {
                    ym1.b(this.c.a, new a(this, unitedSchemeEntity, context, callbackHandler));
                    return true;
                } else {
                    p(context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
            }
            k32.c("DebuggerLaunchAction", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final String o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return rp2.h0().h(context) + this.c.a;
        }
        return (String) invokeL.objValue;
    }

    public final String q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler) == null) {
            a42.j(r());
            File b2 = gp2.f.b();
            if (b2.exists()) {
                b2.delete();
            }
            this.d = Executors.newFixedThreadPool(4);
            this.e = 0;
            for (int i = 0; i < this.c.b.length(); i++) {
                String a2 = this.c.a(i);
                if (TextUtils.isEmpty(a2)) {
                    int i2 = this.e + 1;
                    this.e = i2;
                    if (i2 >= this.c.b.length()) {
                        k32.c("DebuggerLaunchAction", "IPs are invalid");
                        v(context, com.baidu.mobads.sdk.internal.ci.b);
                    }
                } else {
                    this.d.execute(new b(this, context, a2, b2, unitedSchemeEntity, callbackHandler));
                }
            }
        }
    }

    public final ir2.a r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f == null && this.c != null) {
                this.f = (ir2.a) ((ir2.a) ((ir2.a) ((ir2.a) ((ir2.a) new ir2.a().w0(this.c.a)).B0(false)).S0(this.c.d)).L0("baiduboxapp://swan/" + this.c.a)).Q0("1");
            }
            return this.f;
        }
        return (ir2.a) invokeV.objValue;
    }

    public final Set<String> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (g == null) {
                g = new HashSet();
                try {
                    JSONArray jSONArray = new JSONArray(ye3.a().getString("authWlist", ""));
                    for (int i = 0; i < jSONArray.length(); i++) {
                        g.add(jSONArray.optString(i));
                    }
                } catch (JSONException unused) {
                    if (h83.b) {
                        Log.d("DebuggerLaunchAction", "Cloud White List is invalid");
                    }
                }
            }
            return g;
        }
        return (Set) invokeV.objValue;
    }

    public final String s(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode != 51509) {
                if (hashCode == 51512 && str.equals(com.baidu.mobads.sdk.internal.ci.b)) {
                    c = 1;
                }
                c = 65535;
            } else {
                if (str.equals(TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND)) {
                    c = 0;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    return "";
                }
                return "IPs are invalid " + str;
            }
            return "authorization fail " + str;
        }
        return (String) invokeL.objValue;
    }

    public final void v(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str) == null) {
            String string = ye3.a().getString("errorURL", "");
            if (TextUtils.isEmpty(string)) {
                c63.g(context, s(str)).G();
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(SchemeConfig.getSchemeHead());
            sb.append("://v1/easybrowse/open?url=");
            sb.append(q(string + "?" + str));
            SchemeRouter.invoke(context, sb.toString());
        }
    }

    public final void w(Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048585, this, context, str, file, unitedSchemeEntity, callbackHandler) == null) {
            ir2.a r = r();
            a42.l();
            a42.g().h("downloadstart");
            try {
                fd4 request = od4.g().getRequest();
                Response executeSync = request.url(str + "/app.zip").connectionTimeout(3000).build().executeSync();
                if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                    qm4.a(executeSync.body().byteStream(), file);
                    Intent h1 = ir2.h1(context, r);
                    h1.putExtra("remoteDebugUrl", str);
                    context.startActivity(h1);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.d != null) {
                        this.d.shutdownNow();
                        this.d = null;
                    }
                    a42.m(r);
                    a42.g().h("downloadsuccess");
                }
                if (executeSync != null) {
                    executeSync.close();
                }
            } catch (IOException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                int i = this.e + 1;
                this.e = i;
                if (i >= this.c.b.length()) {
                    k32.c("DebuggerLaunchAction", "IPs are invalid");
                    v(context, com.baidu.mobads.sdk.internal.ci.b);
                    a42.g().h("downloadfail");
                }
            }
        }
    }
}
