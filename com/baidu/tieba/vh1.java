package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
/* loaded from: classes8.dex */
public class vh1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "https://etrade.baidu.com/sgw/common/pingd/trace";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948240682, "Lcom/baidu/tieba/vh1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948240682, "Lcom/baidu/tieba/vh1;");
                return;
            }
        }
        if (vg1.a() != 1) {
            a = "http://sandbox.y.nuomi.com/c/uniongw/o/common/pingd/trace";
        }
    }

    public vh1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void a(qg1 qg1Var, pg1 pg1Var, og1 og1Var) {
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, qg1Var, pg1Var, og1Var) == null) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(a).openConnection();
                for (Map.Entry<String, String> entry : qg1Var.c().entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry2 : pg1Var.c().entrySet()) {
                    String encode = URLEncoder.encode(entry2.getValue(), "utf-8");
                    sb.append(entry2.getKey());
                    sb.append("=");
                    sb.append(encode);
                    sb.append("&");
                }
                byte[] bytes = sb.toString().getBytes();
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                httpURLConnection.connect();
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream.write(bytes);
                    dataOutputStream.flush();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (og1Var != null) {
                        if (responseCode >= 200 && responseCode <= 299) {
                            og1Var.c(null);
                        } else {
                            og1Var.a(null, 119501, null);
                        }
                    }
                    ei1.a(dataOutputStream);
                } catch (Throwable unused) {
                    if (og1Var != null) {
                        try {
                            og1Var.a(null, 119501, null);
                        } catch (Throwable th) {
                            ei1.a(dataOutputStream);
                            throw th;
                        }
                    }
                    ei1.a(dataOutputStream);
                }
            } catch (Throwable unused2) {
                dataOutputStream = null;
            }
        }
    }
}
