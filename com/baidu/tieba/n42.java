package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import com.baidu.tieba.l42;
import com.baidu.tieba.p42;
import com.baidu.tieba.r42;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.common.StringUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class n42 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public static int i;
    public transient /* synthetic */ FieldHolder $fh;
    public InputStream a;
    public OutputStream b;
    public r42 c;
    public LinkedBlockingQueue<String> d;
    public InspectorNativeClient e;
    public sd2 f;
    public l42.b g;

    /* loaded from: classes7.dex */
    public class a implements r42.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n42 a;

        /* renamed from: com.baidu.tieba.n42$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0400a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0400a(a aVar) {
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
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    String str = (String) this.a.a.d.poll();
                    while (str != null) {
                        this.a.a.e.dispatchProtocolMessage(str);
                        this.a.d(str);
                        str = (String) this.a.a.d.poll();
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
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
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.g.onConnected();
                    this.a.a.g = null;
                    int unused = n42.i = 2;
                }
            }
        }

        public a(n42 n42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n42Var;
        }

        @Override // com.baidu.tieba.r42.a
        public void a(WebSocketFrame webSocketFrame) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, webSocketFrame) == null) {
                this.a.d.offer(webSocketFrame.g());
                this.a.f.postOnJSThread(new RunnableC0400a(this));
            }
        }

        @Override // com.baidu.tieba.r42.a
        public void b(IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException) == null) {
                k32.d("ClientHandler", "V8 inspector exception", iOException);
                this.a.l();
            }
        }

        public final void d(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && !TextUtils.isEmpty(str) && this.a.g != null && n42.i != 2) {
                try {
                    if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                        j63 K = j63.K();
                        SwanAppActivity w = j63.K().w();
                        if (K.E() && w != null) {
                            w.runOnUiThread(new b(this));
                        }
                    }
                } catch (JSONException e) {
                    if (n42.h) {
                        Log.e("ClientHandler", "message is not a Json object", e);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.r42.a
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                k32.i("ClientHandler", "V8 inspector closed");
                this.a.l();
            }
        }

        @Override // com.baidu.tieba.r42.a
        public void onOpen() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                k32.i("ClientHandler", "V8 inspector opened");
                g82 X = ed2.V().X();
                if (X instanceof k82) {
                    this.a.f = (sd2) X.e();
                }
                if (this.a.f == null) {
                    k32.i("ClientHandler", "inner error, V8 mEngine is null");
                    this.a.l();
                    return;
                }
                if (this.a.e != null) {
                    this.a.e.destroy();
                }
                n42 n42Var = this.a;
                n42Var.e = n42Var.f.p0(new b(this.a));
                int unused = n42.i = 1;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends InspectorNativeChannel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n42 a;

        public b(n42 n42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n42Var;
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                try {
                    this.a.c.j(new WebSocketFrame(WebSocketFrame.OpCode.Text, true, str));
                } catch (Exception unused) {
                    if (n42.h) {
                        Log.d("ClientHandler", "V8 send message fail, try to check if websocket has opened");
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public String awaitMessage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (n42.h) {
                    Log.d("ClientHandler", "getInspectorMessage");
                }
                try {
                    return (String) this.a.d.take();
                } catch (InterruptedException e) {
                    if (n42.h) {
                        Log.e("ClientHandler", "awaitMessage on Debugger", e);
                        return "";
                    }
                    return "";
                }
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947952413, "Lcom/baidu/tieba/n42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947952413, "Lcom/baidu/tieba/n42;");
                return;
            }
        }
        h = vm1.a;
    }

    public n42(InputStream inputStream, OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, outputStream};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new LinkedBlockingQueue<>();
        this.a = inputStream;
        this.b = outputStream;
    }

    public static String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            try {
                return URLDecoder.decode(str, StringUtils.UTF8);
            } catch (UnsupportedEncodingException unused) {
                if (h) {
                    Log.d("ClientHandler", "Encoding not supported, ignored");
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public void o(l42.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) && i == 0) {
            this.g = bVar;
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinkedBlockingQueue<String> linkedBlockingQueue = this.d;
            if (linkedBlockingQueue != null) {
                linkedBlockingQueue.clear();
                this.d = null;
            }
            InspectorNativeClient inspectorNativeClient = this.e;
            if (inspectorNativeClient != null) {
                inspectorNativeClient.destroy();
                this.e = null;
            }
            InputStream inputStream = this.a;
            if (inputStream != null) {
                nm4.d(inputStream);
                this.a = null;
            }
            OutputStream outputStream = this.b;
            if (outputStream != null) {
                nm4.d(outputStream);
                this.b = null;
            }
            this.c = null;
            this.f = null;
            i = 3;
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void m(BufferedReader bufferedReader, p42.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bufferedReader, aVar) == null) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                if (stringTokenizer.hasMoreTokens()) {
                    aVar.b = stringTokenizer.nextToken();
                    if (stringTokenizer.hasMoreTokens()) {
                        aVar.c = n(stringTokenizer.nextToken());
                        if (stringTokenizer.hasMoreTokens()) {
                            aVar.d = stringTokenizer.nextToken();
                        } else {
                            aVar.d = "HTTP/1.1";
                            if (h) {
                                Log.d("ClientHandler", "no protocol version specified, Assuming HTTP/1.1.");
                            }
                        }
                        String readLine2 = bufferedReader.readLine();
                        while (readLine2 != null && !readLine2.trim().isEmpty()) {
                            if (h) {
                                Log.d("ClientHandler", "Http header :" + readLine2);
                            }
                            int indexOf = readLine2.indexOf(58);
                            if (indexOf >= 0) {
                                aVar.a.put(readLine2.substring(0, indexOf).trim().toLowerCase(), readLine2.substring(indexOf + 1).trim());
                            }
                            readLine2 = bufferedReader.readLine();
                        }
                        return;
                    }
                    throw new RuntimeException("BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                }
                throw new RuntimeException("BAD REQUEST: Syntax error. Usage: GET /example/file.html");
            } catch (IOException e) {
                if (h) {
                    Log.e("ClientHandler", "Decode header exception", e);
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.a));
                    p42.a aVar = new p42.a();
                    m(bufferedReader, aVar);
                    q42.a(aVar).e(this.b);
                    if (aVar.e) {
                        if (i != 0 && i != 3) {
                            c63.f(rp2.c(), R.string.obfuscated_res_0x7f0f0171).G();
                            return;
                        }
                        r42 r42Var = new r42();
                        this.c = r42Var;
                        r42Var.k(new a(this));
                        this.c.h(this.a, this.b);
                    }
                } catch (RuntimeException e) {
                    if (h) {
                        Log.e("ClientHandler", "Request parse fail", e);
                    }
                }
            } finally {
                nm4.d(this.a);
                nm4.d(this.b);
            }
        }
    }
}
