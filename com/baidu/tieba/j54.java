package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.games.network.websocket.WebSocketEventTarget;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j54 extends WebSocketEventTarget {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public i54 d;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-737024701, "Lcom/baidu/tieba/j54$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-737024701, "Lcom/baidu/tieba/j54$a;");
                    return;
                }
            }
            int[] iArr = new int[WebSocketEventTarget.SocketTaskState.values().length];
            a = iArr;
            try {
                iArr[WebSocketEventTarget.SocketTaskState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[WebSocketEventTarget.SocketTaskState.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j54(i54 i54Var, ud2 ud2Var) {
        super(ud2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i54Var, ud2Var};
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
        this.d = i54Var;
    }

    public final boolean B(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (j23.q()) {
                return true;
            }
            if (!str.startsWith("wss://") || b73.c(Logger.SOCKET_TYPE, str, str2) != 0) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public j54 A(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jsObject)) == null) {
            sy1 C = C(jsObject);
            this.c = String.format(Locale.CHINA, "WebSocketTask-%d", Long.valueOf(System.currentTimeMillis()));
            int i = C.i("url");
            if (i != 7) {
                y(C, "connectSocket", String.format("parameter error: parameter.url should be %s instead of %s", u74.f(7), u74.f(i)));
                return this;
            }
            String C2 = C.C("url");
            String C3 = C.C("__plugin__");
            if (!this.d.a()) {
                y(C, "connectSocket", "up to max connect count");
                return this;
            } else if (!B(C2, C3)) {
                y(C, "connectSocket", String.format("invalid url \"%s\"", C2));
                return this;
            } else {
                WebSocketRequest x = x(C2, C);
                D(jsObject);
                try {
                    WebSocketTask connect = WebSocketManager.INSTANCE.connect(x, this);
                    this.c = connect.getTaskId();
                    this.d.b(connect);
                    w84.a(C, true, new n54(this.c, String.format("%s:ok", "connectSocket")));
                    return this;
                } catch (Exception e) {
                    y(C, "connectSocket", e.getMessage());
                    return this;
                }
            }
        }
        return (j54) invokeL.objValue;
    }

    @NonNull
    public final sy1 C(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject)) == null) {
            sy1 G = sy1.G(jsObject);
            if (G == null) {
                return new sy1();
            }
            return G;
        }
        return (sy1) invokeL.objValue;
    }

    public final void D(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) && jsObject != null) {
            jsObject.release();
        }
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onClose(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            super.onClose(jSONObject);
            if (this.d != null && jSONObject != null) {
                this.d.c(jSONObject.optString("taskID"));
            }
        }
    }

    @JavascriptInterface
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            close(null);
        }
    }

    @JavascriptInterface
    public void close(JsObject jsObject) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jsObject) == null) {
            sy1 C = C(jsObject);
            if (this.a == WebSocketEventTarget.SocketTaskState.CLOSE) {
                y(C, "SocketTask.close", "SocketTask.readyState is CLOSED");
                return;
            }
            int s = C.s("code", 1000);
            String C2 = C.C("reason");
            if (s != 1000 && (s < 3000 || s > 4999)) {
                z = false;
            } else {
                z = true;
            }
            try {
                if (!z) {
                    y(C, "SocketTask.close", k54.a);
                    return;
                }
                try {
                    WebSocketManager.INSTANCE.close(this.c, s, C2);
                    z(C, "SocketTask.close");
                } catch (Exception e) {
                    y(C, "SocketTask.close", e.getMessage());
                }
            } finally {
                this.d.c(this.c);
            }
        }
    }

    @JavascriptInterface
    public void send(JsObject jsObject) {
        JsArrayBuffer jsArrayBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) {
            sy1 C = C(jsObject);
            int i = a.a[this.a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    int i2 = C.i("data");
                    String str = null;
                    if (i2 != 7) {
                        if (i2 != 10) {
                            y(C, "SocketTask.send", "invalid data type");
                            return;
                        }
                        jsArrayBuffer = C.u("data", null);
                    } else {
                        str = C.D("data", null);
                        jsArrayBuffer = null;
                    }
                    if (str == null && jsArrayBuffer == null) {
                        y(C, "SocketTask.send", "invalid data type");
                        return;
                    }
                    try {
                        if (str != null) {
                            WebSocketManager.INSTANCE.send(this.c, str);
                        } else if (jsArrayBuffer != null) {
                            WebSocketManager.INSTANCE.send(this.c, ByteBuffer.wrap(jsArrayBuffer.buffer()));
                        }
                        z(C, "SocketTask.send");
                        return;
                    } catch (Exception e) {
                        y(C, "SocketTask.send", e.getMessage());
                        return;
                    }
                }
                y(C, "SocketTask.send", "SocketTask.readyState is CLOSED");
                return;
            }
            y(C, "SocketTask.send", "SocketTask.readyState is not OPEN");
        }
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onError(Throwable th, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, th, jSONObject) == null) {
            super.onError(th, jSONObject);
            if (this.d != null && jSONObject != null) {
                this.d.c(jSONObject.optString("taskID"));
            }
        }
    }

    public final void z(sy1 sy1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, sy1Var, str) == null) {
            String format = String.format("%s:ok", str);
            if (WebSocketEventTarget.b) {
                Log.i("WebSocket", format);
            }
            w84.a(sy1Var, true, new m54(format));
        }
    }

    public final WebSocketRequest x(String str, @NonNull sy1 sy1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, sy1Var)) == null) {
            WebSocketRequest.Builder builder = new WebSocketRequest.Builder();
            builder.setUrl(str);
            builder.setMethod(sy1Var.C("method"));
            sy1 x = sy1Var.x("header");
            if (x != null) {
                for (String str2 : x.k()) {
                    if (!TextUtils.isEmpty(str2) && !mx2.d.contains(str2.toUpperCase(Locale.US))) {
                        builder.addHeader(str2, x.I(str2));
                    }
                }
            }
            String[] E = sy1Var.E(WebSocketRequest.PARAM_KEY_PROTOCOLS);
            ArrayList arrayList = new ArrayList();
            if (E != null && E.length != 0) {
                arrayList.addAll(Arrays.asList(E));
            } else {
                arrayList.add("");
            }
            builder.setProtocols(arrayList);
            builder.setConnectionLostTimeout(0);
            return builder.build();
        }
        return (WebSocketRequest) invokeLL.objValue;
    }

    public final void y(sy1 sy1Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, sy1Var, str, str2) == null) {
            String format = String.format("%s:fail %s", str, str2);
            if (WebSocketEventTarget.b) {
                Log.i("WebSocket", format);
            }
            w84.a(sy1Var, false, new m54(format));
        }
    }
}
