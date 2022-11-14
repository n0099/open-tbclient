package com.baidu.tieba;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.g22;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
/* loaded from: classes4.dex */
public class k22 implements g22.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public g22.b a;
    public LocalServerSocket b;
    public i22 c;
    public String d;
    public boolean e;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, String> a;
        public String b;
        public String c;
        public String d;
        public boolean e;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new HashMap();
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a a;

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "" : (String) invokeV.objValue;
        }

        public abstract Map<String, String> b();

        public abstract String c();

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

        public final void d(PrintWriter printWriter, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, printWriter, str, str2) == null) {
                printWriter.append((CharSequence) str).append(": ").append((CharSequence) str2).append("\r\n");
            }
        }

        public void e(OutputStream outputStream) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, outputStream) == null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
                printWriter.append("HTTP/1.1").append(WebvttCueParser.CHAR_SPACE).append((CharSequence) c()).append(" \r\n");
                d(printWriter, "Date", simpleDateFormat.format(new Date()));
                printWriter.print("Content-Length: " + a().getBytes().length + "\r\n");
                Map<String, String> b = b();
                if (b != null && b.size() > 0) {
                    for (Map.Entry<String, String> entry : b.entrySet()) {
                        d(printWriter, entry.getKey(), entry.getValue());
                    }
                }
                printWriter.append("\r\n");
                printWriter.append((CharSequence) a());
                printWriter.flush();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947861118, "Lcom/baidu/tieba/k22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947861118, "Lcom/baidu/tieba/k22;");
                return;
            }
        }
        f = pk1.a;
    }

    @Override // com.baidu.tieba.g22.c
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e = false;
            LocalServerSocket localServerSocket = this.b;
            if (localServerSocket != null) {
                try {
                    localServerSocket.close();
                } catch (IOException e) {
                    f12.d("V8InspectorServer", "stop local server fail", e);
                }
                this.b = null;
            }
            i22 i22Var = this.c;
            if (i22Var != null) {
                i22Var.l();
                this.c = null;
            }
            this.a = null;
        }
    }

    public k22(String str, g22.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = str;
        this.a = bVar;
    }

    @Override // com.baidu.tieba.g22.c
    public void start() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.e) {
            return;
        }
        try {
            this.b = new LocalServerSocket(this.d);
            this.e = true;
            int i = 0;
            while (this.e) {
                LocalSocket accept = this.b.accept();
                i22 i22Var = new i22(accept.getInputStream(), accept.getOutputStream());
                this.c = i22Var;
                i22Var.o(this.a);
                ExecutorUtilsExt.postOnSerial(this.c, "V8InspectorServer");
                if (e03.H() && (i = i + 1) > 10) {
                    if (f) {
                        Log.e("V8InspectorServer", "v8 inspector handshake exceeding the maximum limit");
                        return;
                    }
                    return;
                }
            }
        } catch (IOException e) {
            f12.d("V8InspectorServer", "launch local server fail", e);
        }
    }
}
