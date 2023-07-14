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
/* loaded from: classes8.dex */
public class vd2 implements rd2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public ud2 a;
    public String b;
    public boolean c;
    public boolean d;

    /* loaded from: classes8.dex */
    public class a implements JsCodeCacheCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vd2 a;

        public a(vd2 vd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vd2Var;
        }

        @Override // com.baidu.searchbox.v8engine.JsCodeCacheCallback
        public void onJsCodeCacheFinished(JsCodeCacheResult jsCodeCacheResult) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jsCodeCacheResult) == null) {
                if (vd2.e) {
                    if (jsCodeCacheResult != null) {
                        str = jsCodeCacheResult.toString();
                    } else {
                        str = StringUtil.NULL_STRING;
                    }
                    Log.d("V8MasterAdapter", str);
                }
                if (jsCodeCacheResult != null && jsCodeCacheResult.isCacheUsed) {
                    if (!TextUtils.equals(jsCodeCacheResult.businessId, "appframe")) {
                        if (!TextUtils.equals(jsCodeCacheResult.businessId, "appjs")) {
                            return;
                        }
                        this.a.d = true;
                        return;
                    }
                    this.a.c = true;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements nj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ja2 a;
        public final /* synthetic */ vd2 b;

        public b(vd2 vd2Var, ja2 ja2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vd2Var, ja2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vd2Var;
            this.a = ja2Var;
        }

        @Override // com.baidu.tieba.nj2
        public void a(dj2 dj2Var) {
            ja2 ja2Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dj2Var) == null) && (ja2Var = this.a) != null) {
                ja2Var.a(this.b.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public c(vd2 vd2Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vd2Var, Integer.valueOf(i)};
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
                    v82.c("V8MasterAdapter", th.getMessage());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948236869, "Lcom/baidu/tieba/vd2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948236869, "Lcom/baidu/tieba/vd2;");
                return;
            }
        }
        e = fs1.a;
    }

    @Override // com.baidu.tieba.rd2
    public ta2 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a.i();
        }
        return (ta2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rd2
    public void destroy() {
        ud2 ud2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (ud2Var = this.a) != null) {
            ud2Var.g();
        }
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return na2.b(this.c, this.d);
        }
        return invokeV.intValue;
    }

    public vd2(Context context) {
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

    @Override // com.baidu.tieba.rd2
    public void attachActivity(Activity activity) {
        ud2 ud2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) && (ud2Var = this.a) != null) {
            ud2Var.d(activity);
        }
    }

    @Override // com.baidu.tieba.rd2
    public void b(ja2 ja2Var) {
        ud2 ud2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ja2Var) == null) && (ud2Var = this.a) != null) {
            ud2Var.l(new b(this, ja2Var));
        }
    }

    public ud2 h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return new ud2(str, "runtime/index.js");
        }
        return (ud2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.rd2
    @AnyThread
    public void o(int i) {
        ud2 ud2Var;
        dj2 i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && (ud2Var = this.a) != null && (i2 = ud2Var.i()) != null) {
            i2.runOnJSThread(new c(this, i));
        }
    }

    @Override // com.baidu.tieba.rd2
    public void C(ji2 ji2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, ji2Var) != null) || ji2Var == null) {
            return;
        }
        if (e) {
            Log.d("V8MasterAdapter", "pathList item: " + ji2Var.b);
        }
        this.a.j(na2.a("appjs", ji2Var.b));
    }

    @Override // com.baidu.tieba.rd2
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (this.a == null) {
                ud2 h = h(pi2.U().c0());
                this.a = h;
                this.b = str;
                h.k(new a(this));
            } else if (e) {
                Log.e("V8MasterAdapter", Log.getStackTraceString(new Exception("same instance loadUrl should not be call twice.")));
            }
        }
    }

    @Override // com.baidu.tieba.rd2
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ud2 ud2Var = this.a;
            if (ud2Var != null) {
                return ud2Var.h();
            }
            if (e) {
                Log.d("V8MasterAdapter", Log.getStackTraceString(new Exception("illegal state")));
                return "";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }
}
