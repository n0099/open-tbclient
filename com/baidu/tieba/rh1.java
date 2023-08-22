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
/* loaded from: classes7.dex */
public class rh1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "https://etrade.baidu.com/sgw/common/pingd/trace";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948121518, "Lcom/baidu/tieba/rh1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948121518, "Lcom/baidu/tieba/rh1;");
                return;
            }
        }
        if (rg1.a() != 1) {
            a = "http://sandbox.y.nuomi.com/c/uniongw/o/common/pingd/trace";
        }
    }

    public rh1() {
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

    public void a(mg1 mg1Var, lg1 lg1Var, kg1 kg1Var) {
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, mg1Var, lg1Var, kg1Var) == null) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(a).openConnection();
                for (Map.Entry<String, String> entry : mg1Var.c().entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry2 : lg1Var.c().entrySet()) {
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
                    if (kg1Var != null) {
                        if (responseCode >= 200 && responseCode <= 299) {
                            kg1Var.c(null);
                        } else {
                            kg1Var.a(null, 119501, null);
                        }
                    }
                    ai1.a(dataOutputStream);
                } catch (Throwable unused) {
                    if (kg1Var != null) {
                        try {
                            kg1Var.a(null, 119501, null);
                        } catch (Throwable th) {
                            ai1.a(dataOutputStream);
                            throw th;
                        }
                    }
                    ai1.a(dataOutputStream);
                }
            } catch (Throwable unused2) {
                dataOutputStream = null;
            }
        }
    }
}
