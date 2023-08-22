package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class pi2 extends li2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public static final Object p;
    public static String q;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ni2, com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes7.dex */
    public static class a extends EventTargetImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ni2 a;
        public en2 b;
        @V8JavascriptField
        public mi2 env;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ni2 ni2Var, String str) {
            super(ni2Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ni2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((JSRuntime) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ni2Var;
            mi2 mi2Var = new mi2();
            this.env = mi2Var;
            mi2Var.basePath = str;
        }

        @JavascriptInterface
        @SuppressLint({"BDThrowableCheck"})
        public String getAPIs(int i) {
            InterceptResult invokeI;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (pi2.o) {
                    if (c73.p()) {
                        str = qn3.d(i, SchemeCollecter.CLASSIFY_SWAN_V8);
                    } else {
                        str = "";
                    }
                    d82.b("SwanAppV8Engine", "getAPIs res:" + str);
                    return str;
                }
                String d = qn3.d(i, SchemeCollecter.CLASSIFY_SWAN_V8);
                d82.b("SwanAppV8Engine", "getAPIs description:" + d);
                if (TextUtils.isEmpty(d)) {
                    if (!pi2.o) {
                        hn3.c(qn3.b(String.format("index: %d, desc: %s, isV8: %b", Integer.valueOf(i), d, Boolean.TRUE)));
                    } else {
                        qn3.i();
                        throw new RuntimeException(String.format("getAPIs cannot find index: %d, desc: %s", Integer.valueOf(i), d));
                    }
                } else {
                    hn3.d();
                }
                return d;
            }
            return (String) invokeI.objValue;
        }

        @JavascriptInterface
        public String getDevToolsResponse() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (pi2.o) {
                    Log.d("SwanAppV8Engine", "getDevToolsResponse = " + pi2.q);
                }
                return pi2.q;
            }
            return (String) invokeV.objValue;
        }

        @JavascriptInterface
        public String getEnvVariables() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return nv2.a(this.a);
            }
            return (String) invokeV.objValue;
        }

        @JavascriptInterface
        public en2 getFileSystemManager() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.b == null) {
                    this.b = new en2((li2) this.a);
                }
                return this.b;
            }
            return (en2) invokeV.objValue;
        }

        @JavascriptInterface
        public JSONObject getNACanIUseMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                JSONObject b = e23.b();
                d82.k("SwanAppV8Engine", "getNACanIUseMap - " + b.toString());
                return b;
            }
            return (JSONObject) invokeV.objValue;
        }

        @JavascriptInterface
        public boolean lockMaster() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                d82.k("SwanAppV8Engine", "lockMaster");
                synchronized (pi2.p) {
                    try {
                        try {
                            pi2.p.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        @JavascriptInterface
        public void setDevToolsResponse(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                if (pi2.o) {
                    Log.d("SwanAppV8Engine", "setDevToolsResponse = " + str);
                }
                pi2.q = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948062928, "Lcom/baidu/tieba/pi2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948062928, "Lcom/baidu/tieba/pi2;");
                return;
            }
        }
        o = nr1.a;
        p = new Object();
        q = "";
    }

    @Override // com.baidu.tieba.li2
    @NonNull
    public EventTarget z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = new a(this, this.b.getInitBasePath());
            aVar.env.config = jk3.b();
            return aVar;
        }
        return (EventTarget) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pi2(@NonNull String str, @NonNull ij2 ij2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        super(str, ij2Var, v8ThreadDelegatePolicy);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, ij2Var, v8ThreadDelegatePolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (ij2) objArr2[1], (V8ThreadDelegatePolicy) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
