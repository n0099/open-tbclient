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
public class t64 extends WebSocketEventTarget {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public s64 d;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-449809670, "Lcom/baidu/tieba/t64$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-449809670, "Lcom/baidu/tieba/t64$a;");
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
    public t64(s64 s64Var, ef2 ef2Var) {
        super(ef2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s64Var, ef2Var};
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
        this.d = s64Var;
    }

    public final boolean C(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (t33.q()) {
                return true;
            }
            if (!str.startsWith("wss://") || l83.c("socket", str, str2) != 0) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void A(b02 b02Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, b02Var, str) == null) {
            String format = String.format("%s:ok", str);
            if (WebSocketEventTarget.b) {
                Log.i("WebSocket", format);
            }
            ga4.call(b02Var, true, new w64(format));
        }
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onError(Throwable th, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th, jSONObject) == null) {
            super.onError(th, jSONObject);
            if (this.d != null && jSONObject != null) {
                this.d.c(jSONObject.optString("taskID"));
            }
        }
    }

    public t64 B(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject)) == null) {
            b02 D = D(jsObject);
            this.c = String.format(Locale.CHINA, "WebSocketTask-%d", Long.valueOf(System.currentTimeMillis()));
            int type = D.getType("url");
            if (type != 7) {
                z(D, "connectSocket", String.format("parameter error: parameter.url should be %s instead of %s", e94.f(7), e94.f(type)));
                return this;
            }
            String B = D.B("url");
            String B2 = D.B("__plugin__");
            if (!this.d.a()) {
                z(D, "connectSocket", "up to max connect count");
                return this;
            } else if (!C(B, B2)) {
                z(D, "connectSocket", String.format("invalid url \"%s\"", B));
                return this;
            } else {
                WebSocketRequest y = y(B, D);
                E(jsObject);
                try {
                    WebSocketTask connect = WebSocketManager.INSTANCE.connect(y, this);
                    this.c = connect.getTaskId();
                    this.d.b(connect);
                    ga4.call(D, true, new x64(this.c, String.format("%s:ok", "connectSocket")));
                    return this;
                } catch (Exception e) {
                    z(D, "connectSocket", e.getMessage());
                    return this;
                }
            }
        }
        return (t64) invokeL.objValue;
    }

    @NonNull
    public final b02 D(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jsObject)) == null) {
            b02 F = b02.F(jsObject);
            if (F == null) {
                return new b02();
            }
            return F;
        }
        return (b02) invokeL.objValue;
    }

    public final void E(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) && jsObject != null) {
            jsObject.release();
        }
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onClose(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            super.onClose(jSONObject);
            if (this.d != null && jSONObject != null) {
                this.d.c(jSONObject.optString("taskID"));
            }
        }
    }

    @JavascriptInterface
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            close(null);
        }
    }

    @JavascriptInterface
    public void close(JsObject jsObject) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) {
            b02 D = D(jsObject);
            if (this.a == WebSocketEventTarget.SocketTaskState.CLOSE) {
                z(D, "SocketTask.close", "SocketTask.readyState is CLOSED");
                return;
            }
            int r = D.r("code", 1000);
            String B = D.B("reason");
            if (r != 1000 && (r < 3000 || r > 4999)) {
                z = false;
            } else {
                z = true;
            }
            try {
                if (!z) {
                    z(D, "SocketTask.close", u64.a);
                    return;
                }
                try {
                    WebSocketManager.INSTANCE.close(this.c, r, B);
                    A(D, "SocketTask.close");
                } catch (Exception e) {
                    z(D, "SocketTask.close", e.getMessage());
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
        if (interceptable == null || interceptable.invokeL(1048585, this, jsObject) == null) {
            b02 D = D(jsObject);
            int i = a.a[this.a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    int type = D.getType("data");
                    String str = null;
                    if (type != 7) {
                        if (type != 10) {
                            z(D, "SocketTask.send", "invalid data type");
                            return;
                        }
                        jsArrayBuffer = D.t("data", null);
                    } else {
                        str = D.C("data", null);
                        jsArrayBuffer = null;
                    }
                    if (str == null && jsArrayBuffer == null) {
                        z(D, "SocketTask.send", "invalid data type");
                        return;
                    }
                    try {
                        if (str != null) {
                            WebSocketManager.INSTANCE.send(this.c, str);
                        } else if (jsArrayBuffer != null) {
                            WebSocketManager.INSTANCE.send(this.c, ByteBuffer.wrap(jsArrayBuffer.buffer()));
                        }
                        A(D, "SocketTask.send");
                        return;
                    } catch (Exception e) {
                        z(D, "SocketTask.send", e.getMessage());
                        return;
                    }
                }
                z(D, "SocketTask.send", "SocketTask.readyState is CLOSED");
                return;
            }
            z(D, "SocketTask.send", "SocketTask.readyState is not OPEN");
        }
    }

    public final WebSocketRequest y(String str, @NonNull b02 b02Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, b02Var)) == null) {
            WebSocketRequest.Builder builder = new WebSocketRequest.Builder();
            builder.setUrl(str);
            builder.setMethod(b02Var.B("method"));
            b02 w = b02Var.w("header");
            if (w != null) {
                for (String str2 : w.j()) {
                    if (!TextUtils.isEmpty(str2) && !wy2.d.contains(str2.toUpperCase(Locale.US))) {
                        builder.addHeader(str2, w.H(str2));
                    }
                }
            }
            String[] D = b02Var.D(WebSocketRequest.PARAM_KEY_PROTOCOLS);
            ArrayList arrayList = new ArrayList();
            if (D != null && D.length != 0) {
                arrayList.addAll(Arrays.asList(D));
            } else {
                arrayList.add("");
            }
            builder.setProtocols(arrayList);
            builder.setConnectionLostTimeout(0);
            return builder.build();
        }
        return (WebSocketRequest) invokeLL.objValue;
    }

    public final void z(b02 b02Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, b02Var, str, str2) == null) {
            String format = String.format("%s:fail %s", str, str2);
            if (WebSocketEventTarget.b) {
                Log.i("WebSocket", format);
            }
            ga4.call(b02Var, false, new w64(format));
        }
    }
}
