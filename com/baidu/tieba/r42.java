package com.baidu.tieba;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
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
/* loaded from: classes5.dex */
public class r42 extends ga2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends EventTargetImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @V8JavascriptField
        public ha2 env;

        /* renamed from: com.baidu.tieba.r42$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0401a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0401a(a aVar) {
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
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    gg3.a(lo2.U().getActivity());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ia2 ia2Var, String str) {
            super(ia2Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia2Var, str};
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
            ha2 ha2Var = new ha2();
            this.env = ha2Var;
            ha2Var.basePath = str;
        }

        @JavascriptInterface
        public void addMask() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                yz1.k("SwanAppV8DaemonEngine", "addMask");
                i02.b();
            }
        }

        @JavascriptInterface
        public String closeConnect(JsObject jsObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject)) == null) {
                if (r42.o) {
                    Log.d("SwanAppV8DaemonEngine", "closeConnect params = " + jsObject);
                }
                return k02.d(jsObject);
            }
            return (String) invokeL.objValue;
        }

        @JavascriptInterface
        public String connectDevTool(JsObject jsObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject)) == null) {
                if (r42.o) {
                    Log.d("SwanAppV8DaemonEngine", "connectDevTool params = " + jsObject);
                }
                return k02.e(jsObject);
            }
            return (String) invokeL.objValue;
        }

        @JavascriptInterface
        public boolean freeMaster() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                yz1.k("SwanAppV8DaemonEngine", "freeMaster");
                synchronized (ka2.p) {
                    try {
                        try {
                            ka2.p.notify();
                        } catch (IllegalMonitorStateException e) {
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
        public String getDevToolsResponse() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (r42.o) {
                    Log.d("SwanAppV8DaemonEngine", "getDevToolsResponse = " + ka2.q);
                }
                return ka2.q;
            }
            return (String) invokeV.objValue;
        }

        @JavascriptInterface
        public void reload() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                yz1.k("SwanAppV8DaemonEngine", "reload");
                sg3.a0(new RunnableC0401a(this));
            }
        }

        @JavascriptInterface
        public void removeMask() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                yz1.k("SwanAppV8DaemonEngine", "removeMask");
                i02.c();
            }
        }

        @JavascriptInterface
        public String sendMsgToDevTool(JsObject jsObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jsObject)) == null) {
                if (r42.o) {
                    Log.d("SwanAppV8DaemonEngine", "sendMsgToDevTool params = " + jsObject);
                }
                return k02.m(jsObject);
            }
            return (String) invokeL.objValue;
        }

        @JavascriptInterface
        public void setDevToolsResponse(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                if (r42.o) {
                    Log.d("SwanAppV8DaemonEngine", "setDevToolsResponse = " + str);
                }
                ka2.q = str;
            }
        }

        @JavascriptInterface
        public void shutdown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                yz1.k("SwanAppV8DaemonEngine", "shutdown");
                j02.k().r();
                lo2.U().exit();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948071577, "Lcom/baidu/tieba/r42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948071577, "Lcom/baidu/tieba/r42;");
                return;
            }
        }
        o = ij1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r42(@NonNull String str, @NonNull db2 db2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        super(str, db2Var, v8ThreadDelegatePolicy);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, db2Var, v8ThreadDelegatePolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (db2) objArr2[1], (V8ThreadDelegatePolicy) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.ga2
    @NonNull
    public EventTarget A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar = new a(this, this.b.getInitBasePath());
            aVar.env.config = ec3.b();
            return aVar;
        }
        return (EventTarget) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ia2, com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }
}
