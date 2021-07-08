package com.baidu.wallet.base.statistics;

import android.content.Context;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
/* loaded from: classes5.dex */
public class SyncHttpImpl implements com.baidu.apollon.statistics.SyncHttpImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SyncHttpImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static InputStream a(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, httpURLConnection)) == null) {
            try {
                return httpURLConnection.getInputStream();
            } catch (IOException unused) {
                return httpURLConnection.getErrorStream();
            }
        }
        return (InputStream) invokeL.objValue;
    }

    @Override // com.baidu.apollon.statistics.SyncHttpImpl
    public boolean send(Context context, int i2, String str, Map<String, String> map) {
        InterceptResult invokeLILL;
        Throwable th;
        OutputStream outputStream;
        OutputStream outputStream2;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048576, this, context, i2, str, map)) == null) {
            HttpURLConnection httpURLConnection2 = null;
            OutputStream outputStream3 = null;
            HttpURLConnection httpURLConnection3 = null;
            boolean z = false;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (Exception unused) {
                outputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
            }
            try {
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoOutput(1 == i2);
                if (1 == i2) {
                    httpURLConnection.setRequestMethod("POST");
                } else if (i2 == 0) {
                    httpURLConnection.setRequestMethod("GET");
                } else {
                    throw new Exception("not support http method:" + i2);
                }
                httpURLConnection.setRequestProperty("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                String a2 = a(map);
                httpURLConnection.setFixedLengthStreamingMode(a2.length());
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.connect();
                if (a2.length() > 0) {
                    outputStream3 = httpURLConnection.getOutputStream();
                    outputStream3.write(a2.getBytes());
                    outputStream3.flush();
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (200 <= responseCode && 300 > responseCode) {
                    z = true;
                }
                if (httpURLConnection != null) {
                    InputStream a3 = a(httpURLConnection);
                    if (a3 != null) {
                        try {
                            a3.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    httpURLConnection.disconnect();
                }
            } catch (Exception unused2) {
                outputStream2 = null;
                httpURLConnection3 = httpURLConnection;
                if (httpURLConnection3 != null) {
                    InputStream a4 = a(httpURLConnection3);
                    if (a4 != null) {
                        try {
                            a4.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    httpURLConnection3.disconnect();
                }
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                return z;
            } catch (Throwable th3) {
                outputStream = null;
                httpURLConnection2 = httpURLConnection;
                th = th3;
                if (httpURLConnection2 != null) {
                    InputStream a5 = a(httpURLConnection2);
                    if (a5 != null) {
                        try {
                            a5.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    httpURLConnection2.disconnect();
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
            if (outputStream3 != null) {
                outputStream3.close();
            }
            return z;
        }
        return invokeLILL.booleanValue;
    }

    private String a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, map)) == null) {
            StringBuilder sb = new StringBuilder();
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String encode = URLEncoder.encode(entry.getKey());
                    String encode2 = URLEncoder.encode(entry.getValue());
                    sb.append(encode);
                    sb.append("=");
                    sb.append(encode2);
                    sb.append("&");
                }
            }
            return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
        }
        return (String) invokeL.objValue;
    }
}
