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
/* loaded from: classes8.dex */
public class x24 extends ActivityDelegation {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public JSONObject b;
    public d c;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
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
                g24.n().t(this.b);
                g24.n().l(this.a);
                g24.n().k();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public JSONObject a;
        public JSONObject b;
        public z24 c;
        public Activity d;

        public c(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull z24 z24Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, jSONObject2, z24Var, activity};
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
            this.c = z24Var;
            this.d = activity;
        }

        public /* synthetic */ c(JSONObject jSONObject, JSONObject jSONObject2, z24 z24Var, Activity activity, a aVar) {
            this(jSONObject, jSONObject2, z24Var, activity);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g24.n().G(this.b);
                i34.a(this.a.optString("packageName"), "installApp", null, null, new g34(this.b));
                x24.f(this.d, this.a, this.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements z24 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ x24 c;

        public d(x24 x24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = x24Var;
        }

        @Override // com.baidu.tieba.z24
        public void setFilePath(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.b = str;
            }
        }

        @Override // com.baidu.tieba.z24
        public void setPackageName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a = str;
            }
        }

        @Override // com.baidu.tieba.a34
        public void a(c34 c34Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c34Var) == null) {
                if (x24.d) {
                    Log.d("InstallAppDelegation", "onResult mPackageName:" + this.a);
                }
                this.c.setResult(c34Var);
                j24.d.execute(new b(this.b, this.a, null));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948248463, "Lcom/baidu/tieba/x24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948248463, "Lcom/baidu/tieba/x24;");
                return;
            }
        }
        d = rr1.a;
    }

    public x24() {
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
                g24.n().B(this.a, this.c);
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

    public static void f(Activity activity, @NonNull JSONObject jSONObject, @NonNull z24 z24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, activity, jSONObject, z24Var) == null) {
            String optString = jSONObject.optString("url");
            boolean optBoolean = jSONObject.optBoolean("baiduAppDownload");
            String optString2 = jSONObject.optString("packageName");
            if (g24.n().y(optString) == null && optBoolean) {
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    y74.c().d(optString, optString2);
                    return;
                }
                return;
            }
            g24.n().r(activity, optString, optString2, z24Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(c34 c34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, c34Var) == null) {
            if (c34Var != null) {
                this.mResult.putString("functionType", c34Var.a());
                this.mResult.putString("resultData", c34Var.b());
                this.mResult.putInt("resultStatus", c34Var.c());
                if (!c34Var.d()) {
                    i34.a(this.a, "installApp", "fail", String.valueOf(c34Var.c()), new g34(this.b));
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
            this.b = ho3.d(this.mParams.getString("ubc_params", ""));
            JSONObject d2 = ho3.d(this.mParams.getString("data", ""));
            String optString = d2.optString("packageName");
            this.a = optString;
            this.mResult.putString("packageName", optString);
            j24.d.execute(new c(d2, this.b, this.c, getAgent(), null));
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
            i34.a(this.a, "installApp", "fail", String.valueOf(i), new g34(this.b));
            g();
        }
    }
}
