package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.websocket.IWebSocketListener;
import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements IWebSocketListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JsFunction a;
        public final /* synthetic */ JsFunction b;
        public final /* synthetic */ JsFunction c;
        public final /* synthetic */ JsFunction d;

        public a(JsFunction jsFunction, JsFunction jsFunction2, JsFunction jsFunction3, JsFunction jsFunction4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jsFunction, jsFunction2, jsFunction3, jsFunction4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jsFunction;
            this.b = jsFunction2;
            this.c = jsFunction3;
            this.d = jsFunction4;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            String jSONObject2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (jSONObject == null) {
                    jSONObject2 = "";
                } else {
                    jSONObject2 = jSONObject.toString();
                }
                if (p82.a) {
                    Log.d("WebSocketHelper", "onClose - " + jSONObject2);
                }
                JsFunction jsFunction = this.c;
                if (jsFunction != null) {
                    jsFunction.call(jSONObject2);
                }
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onError(Throwable th, JSONObject jSONObject) {
            String jSONObject2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, jSONObject) == null) {
                if (jSONObject == null) {
                    jSONObject2 = "";
                } else {
                    jSONObject2 = jSONObject.toString();
                }
                if (p82.a) {
                    Log.d("WebSocketHelper", "onError throwable - " + th);
                    Log.d("WebSocketHelper", "onError jsonObject - " + jSONObject2);
                }
                JsFunction jsFunction = this.d;
                if (jsFunction != null) {
                    jsFunction.call(p82.g(th));
                }
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            JsFunction jsFunction;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (jsFunction = this.b) != null) {
                jsFunction.call(p82.h(str));
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map<String, String> map) {
            JsFunction jsFunction;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, map) == null) && (jsFunction = this.a) != null) {
                jsFunction.call();
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(ByteBuffer byteBuffer) {
            JsFunction jsFunction;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, byteBuffer) == null) && (jsFunction = this.b) != null) {
                jsFunction.call(p82.h(byteBuffer));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948015839, "Lcom/baidu/tieba/p82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948015839, "Lcom/baidu/tieba/p82;");
                return;
            }
        }
        a = nr1.a;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            return i(202, str, null);
        }
        return (String) invokeL.objValue;
    }

    public static String d(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jsObject)) == null) {
            if (jsObject == null) {
                return f("params is null");
            }
            k32 F = k32.F(jsObject);
            if (F == null) {
                return f("paramsMap is null");
            }
            String B = F.B("taskId");
            int q = F.q("code");
            String B2 = F.B("reason");
            if (TextUtils.isEmpty(B)) {
                return f("taskId is empty");
            }
            try {
                WebSocketManager.INSTANCE.close(B, q, B2);
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            return i(0, "close success", null);
        }
        return (String) invokeL.objValue;
    }

    public static String g(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (obj != null) {
                try {
                    jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, String.valueOf(obj));
                } catch (Exception e) {
                    if (a) {
                        e.printStackTrace();
                    }
                }
            }
            String jSONObject2 = jSONObject.toString();
            if (a) {
                Log.d("WebSocketHelper", "getOnErrorParam - " + jSONObject2);
            }
            return jSONObject2;
        }
        return (String) invokeL.objValue;
    }

    public static String m(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, jsObject)) == null) {
            if (jsObject == null) {
                return f("params is null");
            }
            k32 F = k32.F(jsObject);
            if (F == null) {
                return f("paramsMap is null");
            }
            String B = F.B("taskId");
            String B2 = F.B("data");
            if (TextUtils.isEmpty(B)) {
                return f("taskId is empty");
            }
            try {
                WebSocketManager.INSTANCE.send(B, B2);
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            return i(0, "send success", null);
        }
        return (String) invokeL.objValue;
    }

    public static String e(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, jsObject)) == null) {
            if (jsObject == null) {
                return f("params is null");
            }
            k32 F = k32.F(jsObject);
            if (F == null) {
                return f("paramsMap is null");
            }
            String B = F.B("url");
            if (TextUtils.isEmpty(B)) {
                return f("url is null");
            }
            k32 w = F.w("header");
            String[] D = F.D(WebSocketRequest.PARAM_KEY_PROTOCOLS);
            WebSocketRequest.Builder builder = new WebSocketRequest.Builder();
            builder.setUrl(B);
            builder.setHeaders(k(w));
            if (D != null && D.length > 0) {
                builder.setProtocols(Arrays.asList(D));
            }
            WebSocketTask connect = WebSocketManager.INSTANCE.connect(builder.build(), l(F));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("taskId", connect.getTaskId());
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            return i(0, "connect success", jSONObject);
        }
        return (String) invokeL.objValue;
    }

    public static String h(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, obj)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (obj instanceof String) {
                    jSONObject.put("dataType", EMABTest.TYPE_STRING);
                    jSONObject.put("data", obj);
                } else if (obj instanceof ByteBuffer) {
                    jSONObject.put("dataType", "arrayBuffer");
                    ByteBuffer byteBuffer = (ByteBuffer) obj;
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    jSONObject.put("data", Base64.encodeToString(bArr, 2));
                }
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            String jSONObject2 = jSONObject.toString();
            if (a) {
                Log.d("WebSocketHelper", "getOnMessageParam - " + jSONObject2);
            }
            return jSONObject2;
        }
        return (String) invokeL.objValue;
    }

    public static String i(int i, String str, JSONObject jSONObject) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65545, null, i, str, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("reason", i);
                jSONObject2.put("message", str);
                if (jSONObject != null) {
                    jSONObject2.put("data", jSONObject);
                }
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            String jSONObject3 = jSONObject2.toString();
            if (a) {
                Log.d("WebSocketHelper", "getResultMsg - " + jSONObject3);
            }
            return jSONObject3;
        }
        return (String) invokeILL.objValue;
    }

    public static JsFunction j(@NonNull k32 k32Var, @NonNull String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65546, null, k32Var, str, z)) == null) {
            JsFunction u = k32Var.u(str);
            if (u != null) {
                u.setReleaseMode(z);
            }
            return u;
        }
        return (JsFunction) invokeLLZ.objValue;
    }

    public static Map<String, String> k(k32 k32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, k32Var)) == null) {
            HashMap hashMap = new HashMap();
            if (k32Var != null) {
                for (String str : k32Var.j()) {
                    hashMap.put(str, k32Var.B(str));
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static IWebSocketListener l(@NonNull k32 k32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, k32Var)) == null) {
            return new a(j(k32Var, "onOpen", true), j(k32Var, "onMessage", false), j(k32Var, "onClose", true), j(k32Var, GameAssistConstKt.TYPE_CALLBACK_ERROR, false));
        }
        return (IWebSocketListener) invokeL.objValue;
    }
}
