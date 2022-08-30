package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.ConnectManager;
import com.baidu.searchbox.network.outback.core.Headers;
import com.baidu.searchbox.network.outback.core.HttpHeaders;
import com.baidu.searchbox.network.outback.core.MediaType;
import com.baidu.searchbox.network.outback.core.Protocol;
import com.baidu.searchbox.network.outback.core.RealResponseBody;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.searchbox.network.outback.core.ResponseBody;
import com.baidu.searchbox.network.outback.core.StatusLine;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
import com.baidu.tieba.i50;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.ProbeTB;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class u50 implements i50 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n50 a;
    public long b;

    public u50() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.i50
    public Response a(i50.a aVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            this.a = aVar.connection();
            return i(aVar.request());
        }
        return (Response) invokeL.objValue;
    }

    public final String b(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response)) == null) {
            Headers headers = response.headers();
            StringBuilder sb = new StringBuilder();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                sb.append(headers.name(i));
                sb.append(":");
                sb.append(headers.value(i));
                sb.append(ParamableElem.DIVIDE_PARAM);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public final ResponseBody c(String str, long j) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j)) == null) {
            if (j > 16384) {
                this.a.disconnect();
                return ResponseBody.create(str != null ? MediaType.parse(str) : null, new byte[0]);
            }
            InputStream q = this.a.q();
            if (q == null) {
                this.a.disconnect();
                return ResponseBody.create(str != null ? MediaType.parse(str) : null, new byte[0]);
            }
            return ResponseBody.create(str != null ? MediaType.parse(str) : null, h(q));
        }
        return (ResponseBody) invokeLJ.objValue;
    }

    public ResponseBody d(Response response, Headers headers) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, response, headers)) == null) {
            String str = headers.get("Content-Type");
            long contentLength = HttpHeaders.contentLength(headers);
            if (response.code() >= 400) {
                return c(str, contentLength);
            }
            if (!HttpHeaders.hasBody(response)) {
                InputStream inputStream = this.a.getInputStream();
                if (inputStream != null) {
                    inputStream.read();
                }
                return ResponseBody.create(str != null ? MediaType.parse(str) : null, new byte[0]);
            }
            InputStream inputStream2 = this.a.getInputStream();
            if (inputStream2 == null) {
                return ResponseBody.create(str != null ? MediaType.parse(str) : null, new byte[0]);
            }
            return new RealResponseBody(str, contentLength, inputStream2);
        }
        return (ResponseBody) invokeLL.objValue;
    }

    public final void e(Request request, Response.Builder builder, Headers headers) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, request, builder, headers) == null) {
            try {
                Long.parseLong(headers.get("request_start"));
                long parseLong = Long.parseLong(headers.get("dns_start"));
                long parseLong2 = Long.parseLong(headers.get("dns_end"));
                Long.parseLong(headers.get("connect_start"));
                Long.parseLong(headers.get("ssl_start"));
                Long.parseLong(headers.get("ssl_end"));
                long parseLong3 = Long.parseLong(headers.get("connect_end"));
                long parseLong4 = Long.parseLong(headers.get("send_start"));
                Long.parseLong(headers.get("send_end"));
                long parseLong5 = Long.parseLong(headers.get("receive_headers_start"));
                Long.parseLong(headers.get("receive_headers_end"));
                try {
                    NetworkStatRecord networkStatRecord = request.getNetworkStatRecord();
                    networkStatRecord.dnsStartTs = parseLong;
                    networkStatRecord.dnsEndTs = parseLong2;
                    networkStatRecord.dnsTs = networkStatRecord.getDnsTime();
                    networkStatRecord.sendHeaderTs = parseLong4;
                    networkStatRecord.receiveHeaderTs = parseLong5;
                    networkStatRecord.connTs = parseLong3;
                    networkStatRecord.isConnReused = TextUtils.equals(headers.get("socket-reused"), "1");
                } catch (Exception unused) {
                }
                builder.cached(TextUtils.equals(headers.get("cached"), "1"));
                builder.isConnReused(TextUtils.equals(headers.get("socket-reused"), "1"));
                String str = headers.get(ProbeTB.PROTOCOL);
                if (str != null) {
                    builder.protocol(Protocol.get(str));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final Response f(Request request, Map<String, List<String>> map) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, request, map)) == null) {
            Response.Builder builder = new Response.Builder();
            builder.request(request);
            int u = this.a.u();
            builder.netEngine(u);
            try {
                this.b = System.currentTimeMillis();
                int code = this.a.getCode();
                builder.sentRequestAtMillis(this.b).code(code).message(this.a.getMessage());
                Headers.Builder builder2 = new Headers.Builder();
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    if (u == 4 && entry.getKey() == null) {
                        g(request, builder, entry.getValue().get(0));
                    }
                    if (entry.getKey() != null) {
                        builder2.namesAndValues.add(entry.getKey());
                        builder2.namesAndValues.add(TextUtils.join("; ", entry.getValue()));
                    }
                }
                Headers build = builder2.build();
                builder.headers(build);
                builder.body(d(builder.build(), build));
                NetworkStatRecord networkStatRecord = request.getNetworkStatRecord();
                networkStatRecord.statusCode = code;
                networkStatRecord.netEngine = u;
                String str = build.get("X-Bfe-Svbbrers");
                if (!Util.isTextEmpty(str)) {
                    networkStatRecord.clientIP = str;
                } else {
                    networkStatRecord.clientIP = ConnectManager.getClientIP();
                }
                if (u == 5) {
                    e(request, builder, build);
                }
                long currentTimeMillis = System.currentTimeMillis();
                networkStatRecord.responseTs = currentTimeMillis;
                builder.headers(build).receivedResponseAtMillis(currentTimeMillis);
                builder.statRecord(networkStatRecord);
                Response build2 = builder.build();
                if (build2.isRedirect()) {
                    String header = build2.header(com.baidubce.http.Headers.LOCATION);
                    if (!Util.isTextEmpty(header)) {
                        build2.getStatRecord().url = header;
                    }
                }
                String b = code >= 400 ? b(build2) : "";
                if (!Util.isTextEmpty(b)) {
                    build2.getStatRecord().errheaders = b;
                }
                return build2;
            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        }
        return (Response) invokeLL.objValue;
    }

    public final void g(Request request, Response.Builder builder, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, request, builder, str) == null) {
            Protocol protocol = StatusLine.parse(str).protocol;
            builder.protocol(protocol);
            request.getNetworkStatRecord().protocol = protocol == null ? "unknown" : protocol.toString();
        }
    }

    public final byte[] h(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, inputStream)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return byteArray == null ? new byte[0] : byteArray;
            } finally {
                Util.closeQuietly(inputStream);
                Util.closeQuietly(byteArrayOutputStream);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public final Response i(Request request) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, request)) == null) {
            try {
                return f(request, this.a.getHeaders());
            } catch (IOException e) {
                throw e;
            }
        }
        return (Response) invokeL.objValue;
    }
}
