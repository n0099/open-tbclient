package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.swan.gamecenter.appmanager.install.InstallPluginDelegateActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class nu3 extends rv3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public static ExecutorService d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ pg2 c;

        public a(nu3 nu3Var, String str, String str2, pg2 pg2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu3Var, str, str2, pg2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = pg2Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                if (nu3.c) {
                    Log.d("appManagerAction", "InstallAppDelegation onDelegateCallBack isOk:" + delegateResult.isOk() + ",packageName：" + this.a + ",result:" + delegateResult.mResult);
                }
                String string = delegateResult.mResult.getString("packageName");
                if (!TextUtils.isEmpty(this.a) && !TextUtils.equals(this.a, string)) {
                    if (av3.h(AppRuntime.getAppContext(), this.a)) {
                        if (!TextUtils.isEmpty(this.b)) {
                            mv3.a(this.a, this.b, "success", "", null);
                        }
                        this.c.a(new JSONObject());
                        return;
                    }
                    if (!TextUtils.isEmpty(this.b)) {
                        mv3.a(this.a, this.b, com.baidu.pass.biometrics.face.liveness.b.a.g0, "", null);
                    }
                    this.c.onFail(31003, "apk install cancel");
                } else if (!delegateResult.isOk()) {
                    if (!TextUtils.isEmpty(this.b)) {
                        mv3.a(this.a, this.b, com.baidu.pass.biometrics.face.liveness.b.a.g0, "", null);
                    }
                    this.c.onFail(31003, "apk install cancel");
                } else {
                    ku3.n().t(this.a);
                    nu3.g(delegateResult.mResult, this.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends sz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String c;
        public String d;
        public pg2 e;

        public b(String str, String str2, pg2 pg2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, pg2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = str;
            this.c = str2;
            this.e = pg2Var;
        }

        @Override // com.baidu.tieba.qz2
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0L;
            }
            return invokeV.longValue;
        }

        @Override // com.baidu.tieba.qz2
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void e() {
            pg2 pg2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (pg2Var = this.e) == null) {
                return;
            }
            pg2Var.onFail(31018, "download process is killed");
            nu3.e(this.d, this.c, 31018);
            this.e = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sz2, com.baidu.tieba.qz2
        public void onEvent(@NonNull oz2 oz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, oz2Var) == null) {
                Bundle a = oz2Var.a();
                pg2 pg2Var = this.e;
                if (pg2Var == null) {
                    return;
                }
                if (a != null) {
                    nu3.g(a, pg2Var);
                } else {
                    pg2Var.onFail(1001, "");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<b> a;

        public c(b bVar) {
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
            this.a = new WeakReference<>(bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (nu3.c) {
                    Log.d("appManagerAction", "onConnectionDown");
                }
                if (this.a.get() != null) {
                    this.a.get().e();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948014909, "Lcom/baidu/tieba/nu3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948014909, "Lcom/baidu/tieba/nu3;");
                return;
            }
        }
        c = vj1.a;
        d = Executors.newSingleThreadExecutor();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nu3() {
        super("appDownloadManager");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void e(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65541, null, str, str2, i) == null) {
            mv3.a(str, str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(i), null);
        }
    }

    public static void g(@NonNull Bundle bundle, @NonNull pg2 pg2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, bundle, pg2Var) == null) {
            String string = bundle.getString("functionType");
            if (string == null) {
                pg2Var.onFail(1001, "");
                return;
            }
            String string2 = bundle.getString("resultData", "");
            int i = bundle.getInt("resultStatus", 1001);
            if (c) {
                Log.d("appManagerAction", "handleResult:function = " + string + ",result = " + string2);
            }
            char c2 = 65535;
            int hashCode = string.hashCode();
            if (hashCode != -1013362275) {
                if (hashCode == -530890460 && string.equals("onSuccess")) {
                    c2 = 0;
                }
            } else if (string.equals("onFail")) {
                c2 = 1;
            }
            if (c2 == 0) {
                pg2Var.a(lg3.d(string2));
            } else if (c2 != 1) {
            } else {
                pg2Var.onFail(i, string2);
            }
        }
    }

    @Override // com.baidu.tieba.rv3
    public lv1 a(@NonNull JSONObject jSONObject, @NonNull pg2 pg2Var) {
        InterceptResult invokeLL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, pg2Var)) == null) {
            if (c) {
                Log.d("appManagerAction", "handle: " + jSONObject);
            }
            String optString = jSONObject.optString(AppDownloadNetworkStateReceiver.KEY_OPERATION);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                str = optJSONObject.optString("packageName");
                str2 = optJSONObject.optString("installSource");
            } else {
                str = null;
                str2 = null;
            }
            Bundle bundle = new Bundle();
            bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, optString);
            bundle.putString("data", optJSONObject == null ? "" : optJSONObject.toString());
            bundle.putString("ubc_params", new kv3().a());
            if (TextUtils.equals(optString, "installApp")) {
                if (!TextUtils.isEmpty(str2)) {
                    mv3.a(str, str2, "start", "", null);
                }
                f(bundle, str, str2, pg2Var);
                return null;
            }
            g03 y = k33.K().y();
            if (y != null) {
                b bVar = new b(str, optString, pg2Var);
                y.X(bundle, yu3.class, bVar);
                y.V(new c(bVar));
            }
            return null;
        }
        return (lv1) invokeLL.objValue;
    }

    public final void f(@NonNull Bundle bundle, @Nullable String str, String str2, @NonNull pg2 pg2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, str, str2, pg2Var) == null) {
            SwanAppActivity w = k33.K().w();
            if (w == null) {
                pg2Var.onFail(1001, "");
            } else if (av3.h(AppRuntime.getAppContext(), str)) {
                pg2Var.a(new JSONObject());
            } else {
                if (c) {
                    Log.d("appManagerAction", "InstallAppDelegation handleInstall");
                }
                DelegateUtils.callOnMainWithActivity(w, InstallPluginDelegateActivity.class, bv3.class, bundle, new a(this, str, str2, pg2Var));
            }
        }
    }
}
