package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.launched.LaunchedTaskSpeedStats;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.tieba.ss2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes6.dex */
public class vb3 extends UnitedSchemeBaseInterceptor {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final Set<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "aiapps_launch_interceptor" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements jf4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Uri b;
        public final /* synthetic */ String c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ vb3 e;

        public a(vb3 vb3Var, String str, Uri uri, String str2, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vb3Var, str, uri, str2, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = vb3Var;
            this.a = str;
            this.b = uri;
            this.c = str2;
            this.d = unitedSchemeEntity;
        }

        @Override // com.baidu.tieba.jf4
        public void a(@Nullable Map<String, String> map) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, map) != null) || map == null) {
                return;
            }
            this.e.e(this.b, map.get(this.a), this.c, this.d);
        }

        @Override // com.baidu.tieba.jf4
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) && vb3.a) {
                Log.e("SwanLaunchInterceptor", "getOpenBundleId", exc);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948234978, "Lcom/baidu/tieba/vb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948234978, "Lcom/baidu/tieba/vb3;");
                return;
            }
        }
        a = eo1.a;
        HashSet hashSet = new HashSet();
        b = hashSet;
        hashSet.add("_baiduboxapp");
        b.add(WebChromeClient.KEY_ARG_CALLBACK);
        b.add("upgrade");
        b.add("_naExtParams");
    }

    public vb3() {
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

    public final String c(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uri)) == null) {
            if (uri == null) {
                return "";
            }
            HashSet hashSet = new HashSet();
            hashSet.add("_naExtParams");
            return ml3.m(uri, hashSet);
        }
        return (String) invokeL.objValue;
    }

    public final String d(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri)) == null) {
            return ml3.i(uri.getEncodedQuery(), b);
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x025d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(Uri uri, String str, String str2, UnitedSchemeEntity unitedSchemeEntity) {
        String str3;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, uri, str, str2, unitedSchemeEntity) == null) {
            String d = d(uri);
            if (a) {
                Log.d("SwanLaunchInterceptor", "query: " + d);
            }
            String n = ml3.n(str, uri, true);
            if (a) {
                Log.d("SwanLaunchInterceptor", "pagePath: " + n);
            }
            String h = SwanLauncher.h();
            t73.K().q().W().J0(h);
            String uri2 = uri.toString();
            String queryParameter = uri.getQueryParameter("_naExtParams");
            if (!TextUtils.isEmpty(queryParameter)) {
                uri2 = c(uri);
            }
            ss2.a aVar = (ss2.a) ((ss2.a) ((ss2.a) new ss2.a().v0(str)).K0(uri2)).J0(h);
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d)) {
                aVar.R0(n + "?" + d);
            } else if (!TextUtils.isEmpty(n)) {
                aVar.R0(n);
            }
            if (TextUtils.isEmpty(str2)) {
                str3 = "_naExtParams";
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    if (a) {
                        j = System.nanoTime();
                    } else {
                        j = 0;
                    }
                    sd3.h(jSONObject, str);
                    if (a) {
                        Log.d("SwanLaunchInterceptor", "SwanAppStabilityConfig#parseConfig 耗时(ns): " + (System.nanoTime() - j));
                    }
                    aVar.I0(jSONObject.optString("from"));
                    aVar.P0(jSONObject.optString("notinhis"));
                    aVar.X0(jSONObject.optString("subscribeWithoutClick"));
                    JSONObject optJSONObject = jSONObject.optJSONObject("ext");
                    aVar.r0("srcAppId", jSONObject.optString("srcAppId"));
                    if (u73.b0() == null) {
                        str3 = "_naExtParams";
                    } else {
                        String O = u73.b0().O();
                        aVar.r0("srcAppKey", O);
                        int type = u73.b0().W().getType();
                        str3 = "_naExtParams";
                        try {
                            aVar.q0("srcPkgType", type);
                            if (a) {
                                Log.d("SwanLaunchInterceptor", "srcAppKey = " + O + "  ,srcPkgType = " + type);
                            }
                        } catch (JSONException e) {
                            e = e;
                            if (a) {
                                Log.d("SwanLaunchInterceptor", "getLaunchFrom failed: " + Log.getStackTraceString(e));
                            }
                            aVar.z("tool_ip", unitedSchemeEntity.getParam("tip"));
                            aVar.z("tool_port", unitedSchemeEntity.getParam("tport"));
                            aVar.z("projectId", unitedSchemeEntity.getParam("projectId"));
                            aVar.z("fromHost", unitedSchemeEntity.getParam("fromHost"));
                            aVar.z("spuId", unitedSchemeEntity.getParam("spuId"));
                            aVar.z("contentId", unitedSchemeEntity.getParam("contentId"));
                            Bundle bundle = null;
                            if (!TextUtils.isEmpty(queryParameter)) {
                            }
                            if (a) {
                            }
                            SwanLauncher.j().n(aVar, bundle);
                        }
                    }
                    if (!jSONObject.isNull(PrefetchEvent.EVENT_DATA_EXTRA_DATA)) {
                        aVar.r0(PrefetchEvent.EVENT_DATA_EXTRA_DATA, jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA));
                    }
                    aVar.r0("srcAppPage", jSONObject.optString("srcAppPage"));
                    JSONObject b2 = xn4.b(aVar.T(), jSONObject.optJSONObject(UBCCloudControlProcessor.UBC_KEY));
                    if (b2 != null) {
                        aVar.r0(UBCCloudControlProcessor.UBC_KEY, b2.toString());
                    }
                    if (optJSONObject != null) {
                        aVar.y0(optJSONObject.optString("clkid"));
                        aVar.r0("aiapp_abtest_info", optJSONObject.optString("aiapp_abtest_info"));
                        aVar.r0(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, optJSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT));
                        aVar.q0("click_time", optJSONObject.optLong("click", -1L));
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
                    str3 = "_naExtParams";
                }
            }
            aVar.z("tool_ip", unitedSchemeEntity.getParam("tip"));
            aVar.z("tool_port", unitedSchemeEntity.getParam("tport"));
            aVar.z("projectId", unitedSchemeEntity.getParam("projectId"));
            aVar.z("fromHost", unitedSchemeEntity.getParam("fromHost"));
            aVar.z("spuId", unitedSchemeEntity.getParam("spuId"));
            aVar.z("contentId", unitedSchemeEntity.getParam("contentId"));
            Bundle bundle2 = null;
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle2 = new Bundle();
                bundle2.putString(str3, queryParameter);
            }
            if (a) {
                Log.d("SwanLaunchInterceptor", "launchParams: " + aVar + " \n_naExtParmas: " + queryParameter);
            }
            SwanLauncher.j().n(aVar, bundle2);
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            Uri uri = unitedSchemeEntity.getUri();
            if (uri == null || !TextUtils.equals(uri.getHost(), "swan")) {
                return false;
            }
            if (unitedSchemeEntity.isOnlyVerify()) {
                return true;
            }
            String j = ml3.j(uri);
            if (a) {
                Log.d("SwanLaunchInterceptor", "mAppId: " + j);
            }
            if (TextUtils.isEmpty(j)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                nj3 nj3Var = new nj3();
                nj3Var.k(1L);
                nj3Var.i(1L);
                nj3Var.f("appId is empty");
                rj3.a().f(nj3Var);
                ve3 ve3Var = new ve3();
                ve3Var.q(ne3.n(0));
                ve3Var.p(nj3Var);
                ve3Var.l("scheme", uri.toString());
                ne3.R(ve3Var);
                z03.k(nj3Var);
                return true;
            }
            jn4.f().b(5000);
            String uri2 = uri.toString();
            u42.i("SwanLaunchInterceptor", "launch scheme = " + uri2);
            String param = unitedSchemeEntity.getParam("_baiduboxapp");
            String str = null;
            if (!TextUtils.isEmpty(param)) {
                try {
                    str = new JSONObject(param).optString("navi");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            String str2 = str;
            if (jk4.e().g(!ol3.G()) && TextUtils.equals(str2, "naviTo")) {
                if (!PMSConstants.a(ff4.b())) {
                    u42.c("SwanLaunchInterceptor", "STOP :: Not Support BDTLS");
                    return false;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(j);
                ef4.e(arrayList, t73.K().q().O(), new a(this, j, uri, param, unitedSchemeEntity));
            } else {
                e(uri, j, param, unitedSchemeEntity);
            }
            ks2.n(str2, j, callbackHandler, unitedSchemeEntity, unitedSchemeEntity.getParam("cb"));
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
