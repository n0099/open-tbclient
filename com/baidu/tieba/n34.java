package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.launched.LaunchedTaskSpeedStats;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.f24;
import com.baidu.tieba.lo2;
import com.baidu.tieba.mq2;
import com.baidu.tieba.nq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes7.dex */
public class n34 extends UnitedSchemeBaseInterceptor {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final Set<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "aigames_launch_interceptor" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements lo2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ nq2 b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ n34 e;

        @Override // com.baidu.tieba.lo2.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        /* renamed from: com.baidu.tieba.n34$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0392a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0392a(a aVar) {
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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    h53.g(this.a.a, "小游戏包下载成功").G();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements jo2 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
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

            @Override // com.baidu.tieba.jo2
            public void a(int i, io2 io2Var) {
                j54 j54Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, io2Var) == null) {
                    f24.c cVar = (f24.c) io2Var;
                    if (i == 0 && cVar != null && (j54Var = cVar.c) != null) {
                        this.a.b.R0(j54Var.b);
                        a aVar = this.a;
                        Intent h1 = nq2.h1(aVar.a, aVar.b);
                        h1.setAction("com.baidu.searchbox.action.aiapps.LAUNCH");
                        h1.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                        this.a.a.startActivity(h1);
                        a aVar2 = this.a;
                        UnitedSchemeUtility.callCallback(aVar2.c, aVar2.d, UnitedSchemeUtility.wrapCallbackParams(0));
                    }
                }
            }
        }

        public a(n34 n34Var, Context context, nq2 nq2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n34Var, context, nq2Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = n34Var;
            this.a = context;
            this.b = nq2Var;
            this.c = callbackHandler;
            this.d = unitedSchemeEntity;
        }

        @Override // com.baidu.tieba.lo2.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (n34.a) {
                    Log.d("SwanGameLaunchAction", "onFailed");
                }
                ih3 ih3Var = new ih3();
                ih3Var.k(7L);
                ih3Var.i(9L);
                ih3Var.f("debug download pkg fail");
                mh3.a().f(ih3Var);
                jq2.e(this.a, ih3Var, 1, this.b.I());
                this.d.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            }
        }

        @Override // com.baidu.tieba.lo2.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (n34.a) {
                    Log.d("SwanGameLaunchAction", "onSuccess");
                }
                jj3.e0(new RunnableC0392a(this));
                this.b.b1("1.6.0");
                this.b.B0(true);
                mq2 d = this.e.d(this.b);
                if (d == null) {
                    return;
                }
                f24.c(d, new b(this));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947951514, "Lcom/baidu/tieba/n34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947951514, "Lcom/baidu/tieba/n34;");
                return;
            }
        }
        a = am1.a;
        HashSet hashSet = new HashSet();
        b = hashSet;
        hashSet.add("_baiduboxapp");
    }

    public n34() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @SuppressLint({"BDOfflineUrl"})
    public final mq2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            mq2.a aVar = new mq2.a();
            aVar.D1("小程序测试");
            aVar.w0("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
            aVar.P0(Color.parseColor("#FF308EF0"));
            aVar.J0("1230000000000000");
            aVar.A1("小程序简介");
            aVar.G1("测试服务类目");
            aVar.H1("测试主体信息");
            aVar.C1("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
            aVar.J1("1.0");
            aVar.E1("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
            return aVar;
        }
        return (mq2) invokeV.objValue;
    }

    public final mq2 d(nq2 nq2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nq2Var)) == null) {
            if (nq2Var == null) {
                return null;
            }
            mq2 c = c();
            c.w0(nq2Var.I());
            c.J0(nq2Var.U());
            c.S0(nq2Var.f0());
            c.B0(nq2Var.o0());
            c.z0(nq2Var.M());
            c.E0(nq2Var.t0());
            c.L0(nq2Var.X());
            c.Q0(nq2Var.d0());
            c.a1(nq2Var.k0());
            c.D0(nq2Var.P());
            c.b1(nq2Var.l0());
            c.J1("0");
            c.v0(nq2Var.H());
            return c;
        }
        return (mq2) invokeL.objValue;
    }

    public final String e(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uri)) == null) {
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments != null && !pathSegments.isEmpty()) {
                return pathSegments.get(0);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final String g(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, uri)) == null) {
            return hj3.i(uri.getQuery(), b);
        }
        return (String) invokeL.objValue;
    }

    public final String f(String str, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, uri)) == null) {
            String path = uri.getPath();
            if (TextUtils.isEmpty(path)) {
                return null;
            }
            String substring = path.substring(str.length() + 1);
            if (substring.endsWith(File.separator)) {
                return substring.substring(0, substring.length() - 1);
            }
            return substring;
        }
        return (String) invokeLL.objValue;
    }

    public final void h(nq2 nq2Var, String str, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, nq2Var, str, context, unitedSchemeEntity, callbackHandler) == null) {
            lo2.d dVar = new lo2.d();
            nq2Var.I();
            dVar.a = str;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                return;
            }
            f24.h(dVar, new a(this, applicationContext, nq2Var, callbackHandler, unitedSchemeEntity));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x019e  */
    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        String str;
        String param;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            Uri uri = unitedSchemeEntity.getUri();
            if (uri == null || !TextUtils.equals(uri.getHost(), SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                return false;
            }
            if (unitedSchemeEntity.isOnlyVerify()) {
                return true;
            }
            String e = e(uri);
            if (a) {
                Log.d("SwanGameLaunchAction", "mAppId: " + e);
            }
            if (TextUtils.isEmpty(e)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                ih3 ih3Var = new ih3();
                ih3Var.k(1L);
                ih3Var.i(1L);
                ih3Var.f("appId is empty");
                mh3.a().f(ih3Var);
                qc3 qc3Var = new qc3();
                qc3Var.q(ic3.n(1));
                qc3Var.p(ih3Var);
                qc3Var.l("scheme", uri.toString());
                ic3.R(qc3Var);
                return true;
            }
            String f = f(e, uri);
            if (a) {
                Log.d("SwanGameLaunchAction", "pagePath: " + f);
            }
            String g = g(uri);
            if (a) {
                Log.d("SwanGameLaunchAction", "query: " + g);
            }
            nq2.a aVar = (nq2.a) ((nq2.a) ((nq2.a) ((nq2.a) new nq2.a().w0(e)).L0(uri.toString())).v0(1)).H0(false);
            if (!TextUtils.isEmpty(f)) {
                aVar.S0(f + "?" + g);
            }
            String param2 = unitedSchemeEntity.getParam("_baiduboxapp");
            if (!TextUtils.isEmpty(param2)) {
                try {
                    JSONObject jSONObject = new JSONObject(param2);
                    aVar.J0(jSONObject.optString("from"));
                    aVar.Q0(jSONObject.optString("notinhis"));
                    aVar.s0("srcAppId", jSONObject.optString("srcAppId"));
                    if (!jSONObject.isNull(PrefetchEvent.EVENT_DATA_EXTRA_DATA)) {
                        aVar.s0(PrefetchEvent.EVENT_DATA_EXTRA_DATA, jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA));
                    }
                    str = jSONObject.optString("navi");
                    try {
                        JSONObject b2 = rl4.b(aVar.U(), jSONObject.optJSONObject("ubc"));
                        if (b2 != null) {
                            aVar.s0("ubc", b2.toString());
                        }
                        String optString = jSONObject.optString("veloce");
                        if (!TextUtils.isEmpty(optString)) {
                            long optLong = new JSONObject(optString).optLong(LaunchedTaskSpeedStats.KEY_START_TIME);
                            if (optLong > 0) {
                                aVar.x("veloce_start_time", optLong);
                            }
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        if (a) {
                            Log.d("SwanGameLaunchAction", "getLaunchFrom failed: " + Log.getStackTraceString(e));
                        }
                        if (a) {
                        }
                        param = unitedSchemeEntity.getParam("downloadUrl");
                        if (!o13.x()) {
                        }
                        aVar.H0(true);
                        h(aVar, param, context, unitedSchemeEntity, callbackHandler);
                        return true;
                    }
                } catch (JSONException e3) {
                    e = e3;
                    str = null;
                }
            } else {
                str = null;
            }
            if (a) {
                Log.d("SwanGameLaunchAction", "launchParams: " + aVar);
            }
            param = unitedSchemeEntity.getParam("downloadUrl");
            if ((!o13.x() || a) && !TextUtils.isEmpty(param)) {
                aVar.H0(true);
                h(aVar, param, context, unitedSchemeEntity, callbackHandler);
                return true;
            }
            SwanLauncher.j().n(aVar, null);
            fq2.n(str, e, callbackHandler, unitedSchemeEntity, null);
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
