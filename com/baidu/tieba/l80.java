package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.transmit.DnsTransmitter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dns;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes5.dex */
public class l80 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l80 b;
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient a;

    /* loaded from: classes5.dex */
    public interface b {
        Map<String, String> getHeaders();

        String getHost();

        String getMediaType();

        String getMethod();

        byte[] getRequestParameter();
    }

    /* loaded from: classes5.dex */
    public interface d {
        void onFailure(int i, String str);

        void onSuccess(byte[] bArr);
    }

    /* loaded from: classes5.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(l80 l80Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l80Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                String str = "HttpRequest error :" + iOException.toString();
                if (iOException instanceof SocketException) {
                    str = "HttpRequest SocketException :" + iOException.toString();
                }
                l80.b(this.a, 10003, str);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(@NonNull Call call, @NonNull Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    if (response.code() != 200) {
                        l80.b(this.a, response.code(), response.message());
                    } else if (response.body() == null) {
                        l80.b(this.a, 10004, "response body empty");
                    } else {
                        byte[] bytes = response.body().bytes();
                        q80.b("HttpExecutor", "onSuccess errorCode ：" + response.code() + ", errorMsg :" + new String(bytes));
                        this.a.onSuccess(bytes);
                    }
                } catch (IOException e) {
                    d dVar = this.a;
                    l80.b(dVar, 10001, "parse response exception ：" + e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Dns {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(l80 l80Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l80Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // okhttp3.Dns
        public List<InetAddress> lookup(String str) throws UnknownHostException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                q80.b("HttpExecutor", "LCPHttpDns lookup  hostName is " + str);
                if (!TextUtils.isEmpty(str) && str.contains(DnsTransmitter.IDC_HOST)) {
                    InetAddress[] allByName = InetAddress.getAllByName(DnsTransmitter.BGP_IP);
                    q80.b("HttpExecutor", "LCPHttpDns lookup  hostName direct ip");
                    return Arrays.asList(allByName);
                }
                q80.b("HttpExecutor", "LCPHttpDns lookup  hostName is by System");
                return Dns.SYSTEM.lookup(str);
            }
            return (List) invokeL.objValue;
        }
    }

    public l80() {
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
        this.a = new OkHttpClient.Builder().connectTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).build();
    }

    public static void b(@NonNull d dVar, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, dVar, i, str) == null) {
            dVar.onFailure(i, str);
            q80.b("HttpExecutor", "failedResponse errorCode ：" + i + ", errorMsg :" + str);
        }
    }

    public static Headers c(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, map)) == null) {
            try {
                Headers.Builder builder = new Headers.Builder();
                if (map != null && map.size() > 0) {
                    for (String str : map.keySet()) {
                        String str2 = str.toString();
                        builder.add(str2, map.get(str2));
                    }
                }
                return builder.build();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Headers) invokeL.objValue;
    }

    public static l80 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (b == null) {
                synchronized (l80.class) {
                    if (b == null) {
                        b = new l80();
                    }
                }
            }
            return b;
        }
        return (l80) invokeV.objValue;
    }

    public void e(@NonNull b bVar, @NonNull d dVar) {
        Request build;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, dVar) == null) {
            try {
                String host = bVar.getHost();
                byte[] requestParameter = bVar.getRequestParameter();
                if (requestParameter != null && requestParameter.length > 0) {
                    if (bVar.getMethod().equals("POST")) {
                        build = new Request.Builder().url(host).post(RequestBody.create(MediaType.parse(bVar.getMediaType()), requestParameter)).build();
                    } else {
                        if (requestParameter != null && requestParameter.length > 0) {
                            host = host + "?" + new String(requestParameter);
                        }
                        build = new Request.Builder().url(host).build();
                    }
                    Map<String, String> headers = bVar.getHeaders();
                    Headers c2 = c(headers);
                    OkHttpClient okHttpClient = this.a;
                    if (headers != null && c2 != null) {
                        build = build.newBuilder().headers(c2).build();
                        String str = headers.get("Host");
                        if (!TextUtils.isEmpty(str) && str.contains(DnsTransmitter.IDC_HOST)) {
                            okHttpClient = this.a.newBuilder().dns(new c(this)).build();
                        }
                    }
                    q80.a("HttpExecutor", "request url :" + host + " , method :" + bVar.getMethod() + " , body :" + new String(bVar.getRequestParameter()));
                    okHttpClient.newCall(build).enqueue(new a(this, dVar));
                    return;
                }
                b(dVar, 10000, "request args exception");
            } catch (Exception e) {
                b(dVar, 10004, "request exception :" + e);
            }
        }
    }
}
