package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.gamecenter.appmanager.install.InstallPluginDelegateActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p34 extends ActivityDelegation {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public JSONObject b;
    public d c;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
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
        }

        public /* synthetic */ b(String str, String str2, a aVar) {
            this(str, str2);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y24.n().t(this.b);
                y24.n().l(this.a);
                y24.n().k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public JSONObject a;
        public JSONObject b;
        public r34 c;
        public Activity d;

        public c(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull r34 r34Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, jSONObject2, r34Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject;
            this.b = jSONObject2;
            this.c = r34Var;
            this.d = activity;
        }

        public /* synthetic */ c(JSONObject jSONObject, JSONObject jSONObject2, r34 r34Var, Activity activity, a aVar) {
            this(jSONObject, jSONObject2, r34Var, activity);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y24.n().G(this.b);
                a44.a(this.a.optString("packageName"), "installApp", null, null, new y34(this.b));
                p34.f(this.d, this.a, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements r34 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ p34 c;

        public d(p34 p34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = p34Var;
        }

        @Override // com.baidu.tieba.r34
        public void setFilePath(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.b = str;
            }
        }

        @Override // com.baidu.tieba.r34
        public void setPackageName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a = str;
            }
        }

        @Override // com.baidu.tieba.s34
        public void a(u34 u34Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u34Var) == null) {
                if (p34.d) {
                    Log.d("InstallAppDelegation", "onResult mPackageName:" + this.a);
                }
                this.c.setResult(u34Var);
                b34.d.execute(new b(this.b, this.a, null));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948011096, "Lcom/baidu/tieba/p34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948011096, "Lcom/baidu/tieba/p34;");
                return;
            }
        }
        d = js1.a;
    }

    public p34() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new d(this);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.c != null) {
                y24.n().B(this.a, this.c);
                this.c = null;
            }
            this.c = null;
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAgentDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (d) {
                Log.d("InstallAppDelegation", "onAgentDestroy mPackageName:" + this.a);
            }
            g();
        }
    }

    public static void f(Activity activity, @NonNull JSONObject jSONObject, @NonNull r34 r34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, activity, jSONObject, r34Var) == null) {
            String optString = jSONObject.optString("url");
            boolean optBoolean = jSONObject.optBoolean("baiduAppDownload");
            String optString2 = jSONObject.optString("packageName");
            if (y24.n().y(optString) == null && optBoolean) {
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    q84.c().d(optString, optString2);
                    return;
                }
                return;
            }
            y24.n().r(activity, optString, optString2, r34Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(u34 u34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, u34Var) == null) {
            if (u34Var != null) {
                this.mResult.putString("functionType", u34Var.a());
                this.mResult.putString("resultData", u34Var.b());
                this.mResult.putInt("resultStatus", u34Var.c());
                if (!u34Var.d()) {
                    a44.a(this.a, "installApp", "fail", String.valueOf(u34Var.c()), new y34(this.b));
                }
            }
            g();
            finish();
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (d) {
                Log.d("InstallAppDelegation", "onExec mParams" + this.mParams);
            }
            this.b = zo3.d(this.mParams.getString("ubc_params", ""));
            JSONObject d2 = zo3.d(this.mParams.getString("data", ""));
            String optString = d2.optString("packageName");
            this.a = optString;
            this.mResult.putString("packageName", optString);
            b34.d.execute(new c(d2, this.b, this.c, getAgent(), null));
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (d) {
                Log.d("InstallAppDelegation", "onSelfFinish mPackageName:" + this.a);
            }
            int i = 31003;
            if (getAgent() instanceof InstallPluginDelegateActivity) {
                i = ((InstallPluginDelegateActivity) getAgent()).a();
            }
            a44.a(this.a, "installApp", "fail", String.valueOf(i), new y34(this.b));
            g();
        }
    }
}
