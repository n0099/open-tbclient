package com.baidu.tieba;

import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMPushUploadConstants;
import com.baidu.swan.facade.requred.openstat.imupload.log.model.Bimlog$LogRequest;
import com.baidu.swan.facade.requred.openstat.imupload.log.model.Bimlog$LogResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public class qn3 {
    public static /* synthetic */ Interceptable $ic;
    public static qn3 b;
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient a;

    /* loaded from: classes5.dex */
    public class a implements Interceptor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.qn3$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0388a extends RequestBody {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RequestBody a;

            public C0388a(a aVar, RequestBody requestBody) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, requestBody};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = requestBody;
            }

            @Override // okhttp3.RequestBody
            public long contentLength() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return -1L;
                }
                return invokeV.longValue;
            }

            @Override // okhttp3.RequestBody
            public MediaType contentType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.contentType() : (MediaType) invokeV.objValue;
            }

            @Override // okhttp3.RequestBody
            public void writeTo(@NonNull BufferedSink bufferedSink) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bufferedSink) == null) {
                    BufferedSink buffer = Okio.buffer(new GzipSink(bufferedSink));
                    try {
                        this.a.writeTo(buffer);
                        buffer.close();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        public a(qn3 qn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final RequestBody a(RequestBody requestBody) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, requestBody)) == null) ? new C0388a(this, requestBody) : (RequestBody) invokeL.objValue;
        }

        @Override // okhttp3.Interceptor
        public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chain)) == null) {
                Request request = chain.request();
                if (request.body() != null && request.header("Content-Encoding") == null) {
                    return chain.proceed(request.newBuilder().header("Content-Encoding", "gzip").method(request.method(), a(request.body())).build());
                }
                return chain.proceed(request);
            }
            return (Response) invokeL.objValue;
        }
    }

    public qn3() {
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
        this.a = c();
    }

    public static qn3 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                b = new qn3();
            }
            return b;
        }
        return (qn3) invokeV.objValue;
    }

    @NonNull
    public final RequestBody a(@NonNull byte[] bArr, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, str)) == null) ? RequestBody.create(MediaType.parse("application/proto"), b(bArr, str)) : (RequestBody) invokeLL.objValue;
    }

    @NonNull
    public final byte[] b(@NonNull byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, str)) == null) {
            Bimlog$LogRequest.AuthInfo.b newBuilder = Bimlog$LogRequest.AuthInfo.newBuilder();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            newBuilder.u(str);
            Bimlog$LogRequest.AuthInfo build = newBuilder.build();
            long currentTimeMillis = System.currentTimeMillis();
            Bimlog$LogRequest.b newBuilder2 = Bimlog$LogRequest.newBuilder();
            newBuilder2.A(1L);
            newBuilder2.y("smart_app");
            newBuilder2.v(build);
            newBuilder2.x(currentTimeMillis);
            newBuilder2.z(pn3.b("smart_app", currentTimeMillis));
            newBuilder2.w(ByteString.copyFrom(bArr));
            return newBuilder2.build().toByteArray();
        }
        return (byte[]) invokeLL.objValue;
    }

    @NonNull
    public final OkHttpClient c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new OkHttpClient.Builder().protocols(Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1)).pingInterval(1000L, TimeUnit.MILLISECONDS).addInterceptor(new a(this)).connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).connectionPool(new ConnectionPool()).build() : (OkHttpClient) invokeV.objValue;
    }

    @NonNull
    public final Request e(@NonNull Map<String, String> map, @NonNull byte[] bArr, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, map, bArr, str, str2)) == null) {
            ArrayMap arrayMap = new ArrayMap();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayMap.put("ls-" + entry.getKey(), h(entry.getValue()));
            }
            arrayMap.put(IMPushUploadConstants.BIM_LOG_ID, h(str2));
            return new Request.Builder().addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE).addHeader("Content-Type", "application/proto").headers(Headers.of(arrayMap)).url("https://pimlog.baidu.com/LogService/Log").post(a(bArr, str)).build();
        }
        return (Request) invokeLLLL.objValue;
    }

    @NonNull
    public final String[] f(@NonNull byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bArr)) == null) {
            try {
                Bimlog$LogResponse parseFrom = Bimlog$LogResponse.parseFrom(bArr);
                if (this.a.pingIntervalMillis() != parseFrom.getPingIntervalMs()) {
                    this.a.newBuilder().pingInterval(parseFrom.getPingIntervalMs(), TimeUnit.MILLISECONDS);
                    this.a = this.a.newBuilder().pingInterval(parseFrom.getPingIntervalMs(), TimeUnit.MILLISECONDS).build();
                }
                return new String[]{String.valueOf(parseFrom.getErrorCode()), parseFrom.getErrorMsg()};
            } catch (InvalidProtocolBufferException unused) {
                return new String[]{String.valueOf(-1), "parseResponse exception"};
            }
        }
        return (String[]) invokeL.objValue;
    }

    public void g(@NonNull Map<String, String> map, @NonNull byte[] bArr, String str, rn3 rn3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048581, this, map, bArr, str, rn3Var) == null) || rn3Var == null) {
            return;
        }
        Request e = e(map, bArr, str, "" + ((int) ((Math.random() * 100000.0d) + 10000.0d)));
        if (this.a == null) {
            this.a = c();
        }
        try {
            Response execute = this.a.newCall(e).execute();
            try {
                if (execute.body() != null) {
                    String[] f = f(execute.body().bytes());
                    rn3Var.a = Integer.valueOf(f[0]).intValue();
                    rn3Var.b = f[1];
                }
            } catch (IOException unused) {
            }
        } catch (IOException e2) {
            String str2 = "Request error :" + e2.toString();
            if (e2 instanceof SocketException) {
                str2 = "Request SocketException :" + e2.toString();
            }
            rn3Var.a = -1;
            rn3Var.b = str2;
        }
    }

    public final String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                    sb.append(charAt);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
