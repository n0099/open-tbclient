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
import com.baidu.tieba.o74;
import com.baidu.tieba.ut2;
import com.baidu.tieba.vv2;
import com.baidu.tieba.wv2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes8.dex */
public class w84 extends UnitedSchemeBaseInterceptor {
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

    /* loaded from: classes8.dex */
    public class a implements ut2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ wv2 b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ w84 e;

        @Override // com.baidu.tieba.ut2.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        /* renamed from: com.baidu.tieba.w84$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0516a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0516a(a aVar) {
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
                    qa3.g(this.a.a, "小游戏包下载成功").G();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements st2 {
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

            @Override // com.baidu.tieba.st2
            public void a(int i, rt2 rt2Var) {
                sa4 sa4Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, rt2Var) == null) {
                    o74.c cVar = (o74.c) rt2Var;
                    if (i == 0 && cVar != null && (sa4Var = cVar.c) != null) {
                        this.a.b.Q0(sa4Var.b);
                        a aVar = this.a;
                        Intent g1 = wv2.g1(aVar.a, aVar.b);
                        g1.setAction("com.baidu.searchbox.action.aiapps.LAUNCH");
                        g1.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                        this.a.a.startActivity(g1);
                        a aVar2 = this.a;
                        UnitedSchemeUtility.callCallback(aVar2.c, aVar2.d, UnitedSchemeUtility.wrapCallbackParams(0));
                    }
                }
            }
        }

        public a(w84 w84Var, Context context, wv2 wv2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w84Var, context, wv2Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = w84Var;
            this.a = context;
            this.b = wv2Var;
            this.c = callbackHandler;
            this.d = unitedSchemeEntity;
        }

        @Override // com.baidu.tieba.ut2.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (w84.a) {
                    Log.d("SwanGameLaunchAction", "onFailed");
                }
                rm3 rm3Var = new rm3();
                rm3Var.k(7L);
                rm3Var.i(9L);
                rm3Var.f("debug download pkg fail");
                vm3.a().f(rm3Var);
                sv2.e(this.a, rm3Var, 1, this.b.H());
                this.d.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            }
        }

        @Override // com.baidu.tieba.ut2.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (w84.a) {
                    Log.d("SwanGameLaunchAction", "onSuccess");
                }
                so3.e0(new RunnableC0516a(this));
                this.b.a1("1.6.0");
                this.b.A0(true);
                vv2 d = this.e.d(this.b);
                if (d == null) {
                    return;
                }
                o74.c(d, new b(this));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948224438, "Lcom/baidu/tieba/w84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948224438, "Lcom/baidu/tieba/w84;");
                return;
            }
        }
        a = ir1.a;
        HashSet hashSet = new HashSet();
        b = hashSet;
        hashSet.add("_baiduboxapp");
    }

    public w84() {
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
    public final vv2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            vv2.a aVar = new vv2.a();
            aVar.B1("小程序测试");
            aVar.v0("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
            aVar.O0(Color.parseColor("#FF308EF0"));
            aVar.I0("1230000000000000");
            aVar.y1("小程序简介");
            aVar.E1("测试服务类目");
            aVar.F1("测试主体信息");
            aVar.A1("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
            aVar.H1("1.0");
            aVar.C1("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
            return aVar;
        }
        return (vv2) invokeV.objValue;
    }

    public final vv2 d(wv2 wv2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wv2Var)) == null) {
            if (wv2Var == null) {
                return null;
            }
            vv2 c = c();
            c.v0(wv2Var.H());
            c.I0(wv2Var.T());
            c.R0(wv2Var.e0());
            c.A0(wv2Var.n0());
            c.y0(wv2Var.L());
            c.D0(wv2Var.s0());
            c.K0(wv2Var.W());
            c.P0(wv2Var.c0());
            c.Z0(wv2Var.j0());
            c.C0(wv2Var.O());
            c.a1(wv2Var.k0());
            c.H1("0");
            c.u0(wv2Var.G());
            return c;
        }
        return (vv2) invokeL.objValue;
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
            return qo3.i(uri.getQuery(), b);
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

    public final void h(wv2 wv2Var, String str, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, wv2Var, str, context, unitedSchemeEntity, callbackHandler) == null) {
            ut2.d dVar = new ut2.d();
            wv2Var.H();
            dVar.a = str;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                return;
            }
            o74.h(dVar, new a(this, applicationContext, wv2Var, callbackHandler, unitedSchemeEntity));
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
                rm3 rm3Var = new rm3();
                rm3Var.k(1L);
                rm3Var.i(1L);
                rm3Var.f("appId is empty");
                vm3.a().f(rm3Var);
                zh3 zh3Var = new zh3();
                zh3Var.q(rh3.n(1));
                zh3Var.p(rm3Var);
                zh3Var.l("scheme", uri.toString());
                rh3.R(zh3Var);
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
            wv2.a aVar = (wv2.a) ((wv2.a) ((wv2.a) ((wv2.a) new wv2.a().v0(e)).K0(uri.toString())).u0(1)).G0(false);
            if (!TextUtils.isEmpty(f)) {
                aVar.R0(f + "?" + g);
            }
            String param2 = unitedSchemeEntity.getParam("_baiduboxapp");
            if (!TextUtils.isEmpty(param2)) {
                try {
                    JSONObject jSONObject = new JSONObject(param2);
                    aVar.I0(jSONObject.optString("from"));
                    aVar.P0(jSONObject.optString("notinhis"));
                    aVar.r0("srcAppId", jSONObject.optString("srcAppId"));
                    if (!jSONObject.isNull(PrefetchEvent.EVENT_DATA_EXTRA_DATA)) {
                        aVar.r0(PrefetchEvent.EVENT_DATA_EXTRA_DATA, jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA));
                    }
                    str = jSONObject.optString("navi");
                    try {
                        JSONObject b2 = br4.b(aVar.T(), jSONObject.optJSONObject("ubc"));
                        if (b2 != null) {
                            aVar.r0("ubc", b2.toString());
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
                        param = unitedSchemeEntity.getParam(TTDownloadField.TT_DOWNLOAD_URL);
                        if (!x63.x()) {
                        }
                        aVar.G0(true);
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
            param = unitedSchemeEntity.getParam(TTDownloadField.TT_DOWNLOAD_URL);
            if ((!x63.x() || a) && !TextUtils.isEmpty(param)) {
                aVar.G0(true);
                h(aVar, param, context, unitedSchemeEntity, callbackHandler);
                return true;
            }
            SwanLauncher.j().n(aVar, null);
            ov2.n(str, e, callbackHandler, unitedSchemeEntity, null);
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
