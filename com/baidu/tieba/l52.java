package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsCodeCacheCallback;
import com.baidu.searchbox.v8engine.JsCodeCacheResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class l52 implements h52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public k52 a;
    public String b;
    public boolean c;
    public boolean d;

    /* loaded from: classes4.dex */
    public class a implements JsCodeCacheCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l52 a;

        public a(l52 l52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l52Var;
        }

        @Override // com.baidu.searchbox.v8engine.JsCodeCacheCallback
        public void onJsCodeCacheFinished(JsCodeCacheResult jsCodeCacheResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jsCodeCacheResult) == null) {
                if (l52.e) {
                    Log.d("V8MasterAdapter", jsCodeCacheResult != null ? jsCodeCacheResult.toString() : StringUtil.NULL_STRING);
                }
                if (jsCodeCacheResult == null || !jsCodeCacheResult.isCacheUsed) {
                    return;
                }
                if (TextUtils.equals(jsCodeCacheResult.businessId, "appframe")) {
                    this.a.c = true;
                } else if (TextUtils.equals(jsCodeCacheResult.businessId, "appjs")) {
                    this.a.d = true;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements db2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z12 a;
        public final /* synthetic */ l52 b;

        public b(l52 l52Var, z12 z12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l52Var, z12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l52Var;
            this.a = z12Var;
        }

        @Override // com.baidu.tieba.db2
        public void a(ta2 ta2Var) {
            z12 z12Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ta2Var) == null) || (z12Var = this.a) == null) {
                return;
            }
            z12Var.a(this.b.b);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public c(l52 l52Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l52Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Process.setThreadPriority(this.a);
                } catch (Throwable th) {
                    l02.c("V8MasterAdapter", th.getMessage());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947893792, "Lcom/baidu/tieba/l52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947893792, "Lcom/baidu/tieba/l52;");
                return;
            }
        }
        e = vj1.a;
    }

    public l52(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.h52
    public void D(z92 z92Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, z92Var) == null) || z92Var == null) {
            return;
        }
        if (e) {
            Log.d("V8MasterAdapter", "pathList item: " + z92Var.b);
        }
        this.a.j(d22.a("appjs", z92Var.b));
    }

    @Override // com.baidu.tieba.h52
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            k52 k52Var = this.a;
            if (k52Var != null) {
                return k52Var.h();
            }
            if (e) {
                Log.d("V8MasterAdapter", Log.getStackTraceString(new Exception("illegal state")));
                return "";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h52
    public void attachActivity(Activity activity) {
        k52 k52Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) || (k52Var = this.a) == null) {
            return;
        }
        k52Var.d(activity);
    }

    @Override // com.baidu.tieba.h52
    public void b(z12 z12Var) {
        k52 k52Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, z12Var) == null) || (k52Var = this.a) == null) {
            return;
        }
        k52Var.l(new b(this, z12Var));
    }

    @Override // com.baidu.tieba.h52
    public void destroy() {
        k52 k52Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (k52Var = this.a) == null) {
            return;
        }
        k52Var.g();
    }

    @Override // com.baidu.tieba.h52
    public j22 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.i() : (j22) invokeV.objValue;
    }

    public k52 h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? new k52(str, "runtime/index.js") : (k52) invokeL.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? d22.b(this.c, this.d) : invokeV.intValue;
    }

    @Override // com.baidu.tieba.h52
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (this.a == null) {
                k52 h = h(fa2.U().c0());
                this.a = h;
                this.b = str;
                h.k(new a(this));
            } else if (e) {
                Log.e("V8MasterAdapter", Log.getStackTraceString(new Exception("same instance loadUrl should not be call twice.")));
            }
        }
    }

    @Override // com.baidu.tieba.h52
    @AnyThread
    public void p(int i) {
        k52 k52Var;
        ta2 i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || (k52Var = this.a) == null || (i2 = k52Var.i()) == null) {
            return;
        }
        i2.runOnJSThread(new c(this, i));
    }
}
