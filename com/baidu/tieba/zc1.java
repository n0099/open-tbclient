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
/* loaded from: classes9.dex */
public class zc1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "https://etrade.baidu.com/sgw/common/pingd/trace";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948355041, "Lcom/baidu/tieba/zc1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948355041, "Lcom/baidu/tieba/zc1;");
                return;
            }
        }
        if (zb1.a() != 1) {
            a = "http://sandbox.y.nuomi.com/c/uniongw/o/common/pingd/trace";
        }
    }

    public zc1() {
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

    public void a(ub1 ub1Var, tb1 tb1Var, sb1 sb1Var) {
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, ub1Var, tb1Var, sb1Var) == null) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(a).openConnection();
                for (Map.Entry<String, String> entry : ub1Var.c().entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry2 : tb1Var.c().entrySet()) {
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
                    if (sb1Var != null) {
                        if (responseCode >= 200 && responseCode <= 299) {
                            sb1Var.c(null);
                        } else {
                            sb1Var.a(null, 119501, null);
                        }
                    }
                    id1.a(dataOutputStream);
                } catch (Throwable unused) {
                    if (sb1Var != null) {
                        try {
                            sb1Var.a(null, 119501, null);
                        } catch (Throwable th) {
                            id1.a(dataOutputStream);
                            throw th;
                        }
                    }
                    id1.a(dataOutputStream);
                }
            } catch (Throwable unused2) {
                dataOutputStream = null;
            }
        }
    }
}
