package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.qw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class j03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements n92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ k03 b;
        public final /* synthetic */ Bundle c;

        public a(Context context, k03 k03Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, k03Var, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = k03Var;
            this.c = bundle;
        }

        @Override // com.baidu.tieba.n92
        public void onFail() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && j03.a) {
                Log.d("SwanAppPreloadHelper", "SwanSailor：updateFail");
            }
        }

        @Override // com.baidu.tieba.n92
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (j03.a) {
                    Log.d("SwanAppPreloadHelper", "SwanSailor updateSuccess");
                }
                j03.i(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements n22 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ k03 b;
        public final /* synthetic */ Bundle c;

        public b(Context context, k03 k03Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, k03Var, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = k03Var;
            this.c = bundle;
        }

        @Override // com.baidu.tieba.n22
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = j03.c = true;
                j03.h(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements ei3<Exception> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ k03 b;
        public final /* synthetic */ Bundle c;

        public c(Context context, k03 k03Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, k03Var, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = k03Var;
            this.c = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                j03.g(this.a, this.b, this.c);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947829436, "Lcom/baidu/tieba/j03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947829436, "Lcom/baidu/tieba/j03;");
                return;
            }
        }
        a = vj1.a;
        c = false;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("master", fa2.U().k0());
                jSONObject.put("slave", fa2.U().n0());
            } catch (JSONException e) {
                if (a) {
                    throw new RuntimeException(e);
                }
            }
            String jSONObject2 = jSONObject.toString();
            if (a) {
                Log.d("SwanAppPreloadHelper", "createPreloadStatus -- preloadStatus : " + jSONObject2);
            }
            return TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2;
        }
        return (String) invokeV.objValue;
    }

    public static void g(Context context, k03 k03Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, context, k03Var, bundle) == null) {
            boolean t = sm2.g0() != null ? sm2.g0().t() : false;
            boolean isMainProcess = ProcessUtils.isMainProcess();
            String str = isMainProcess ? "main" : "aiapp";
            long currentTimeMillis = System.currentTimeMillis();
            if (t) {
                if (isMainProcess && TextUtils.isEmpty(b)) {
                    try {
                        b = new WebView(context).getSettings().getUserAgentString();
                    } catch (Exception e) {
                        b = "exception::" + e.toString();
                        if (a) {
                            e.printStackTrace();
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", currentTimeMillis);
                    jSONObject.put("process", k03Var.b.index);
                    jSONObject.put("ua", b);
                } catch (JSONException e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                }
                qw2.d dVar = new qw2.d("812");
                dVar.g("swan");
                dVar.i("launch");
                dVar.h(str);
                dVar.e(jSONObject);
                qw2.onEvent(dVar);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (t) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("time", currentTimeMillis2);
                    jSONObject2.put("process", k03Var.b.index);
                    jSONObject2.put("cost", currentTimeMillis2 - currentTimeMillis);
                } catch (JSONException e3) {
                    if (a) {
                        e3.printStackTrace();
                    }
                }
                qw2.d dVar2 = new qw2.d("812");
                dVar2.g("swan");
                dVar2.i("swan_updated");
                dVar2.h(str);
                dVar2.e(jSONObject2);
                qw2.onEvent(dVar2);
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (qc3.j()) {
                sc3.e();
            }
            bundle.putParcelable("bundle_key_swan_core", qc3.e(0));
            bundle.putParcelable("bundle_key_extension_core", ud2.c(0));
            bundle.putInt("bundle_key_preload_switch", sm2.g().a());
            bundle.putLong("bundle_key_preload_launch_time", currentTimeMillis);
            bundle.putBoolean("bundle_key_v8_ab", sm2.g0().x());
            bundle.putLong("bundle_key_preload_swan_updated_time", currentTimeMillis2);
            bundle.putString("bundle_key_preload_src", str);
            bundle.putInt("bundle_key_process", k03Var.b.index);
            bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
            k03Var.n0(context, bundle);
        }
    }

    public static void h(Context context, k03 k03Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, context, k03Var, bundle) == null) {
            SwanLauncher.j().l(new c(context, k03Var, bundle));
        }
    }

    public static void i(Context context, k03 k03Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, context, k03Var, bundle) == null) {
            if (p92.a()) {
                h(context, k03Var, bundle);
            } else if (c) {
                h(context, k03Var, bundle);
            } else {
                bq1.a().b().a().b(new b(context, k03Var, bundle));
            }
        }
    }

    public static void j(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, bundle) == null) {
            bundle.putBoolean("bundle_key_v8_ab", sm2.g0().x());
        }
    }

    public static void k(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, context, bundle) == null) {
            Intent intent = new Intent(context, SwanAppMessengerService.class);
            intent.setAction(SwanAppMessengerService.ACTION_PRELOAD_NEXT);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            try {
                context.startService(intent);
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void l(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, bundle) == null) {
            m(context, m03.k().f(), bundle);
        }
    }

    public static void m(Context context, k03 k03Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, context, k03Var, bundle) == null) {
            if (a) {
                m03 k = m03.k();
                k.u("b4 tryPreload client=" + k03Var);
            }
            if (!ProcessUtils.isMainProcess() || k03Var == null || !k03Var.b.isSwanAppProcess() || k03Var.E()) {
                return;
            }
            String string = bundle == null ? "" : bundle.getString("bundle_key_preload_preload_scene");
            if (TextUtils.isEmpty(string)) {
                string = "0";
            }
            if (a) {
                Log.d("SwanAppPreloadHelper", "SwanSailor：preloadScene:" + string);
            }
            if (sm2.w0().c()) {
                i(context, k03Var, bundle);
                return;
            }
            p92 p92Var = new p92();
            p92Var.a = TextUtils.equals(string, "0") ? "by_host_launch" : "by_preload";
            sm2.w0().b(p92Var, new a(context, k03Var, bundle));
        }
    }

    public static void n(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, bundle) == null) {
            hn1 g0 = sm2.g0();
            if (!kz2.Y()) {
                g0.getSwitch("swan_preload_keep_alive", true);
            }
            l(context, bundle);
        }
    }
}
