package com.bytedance.sdk.component.adnet.core;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.err.VAdError;
import com.bytedance.sdk.component.adnet.face.IHttpStack;
import com.bytedance.sdk.component.b.b.aa;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.ac;
import com.bytedance.sdk.component.b.b.s;
import com.bytedance.sdk.component.b.b.v;
import com.bytedance.sdk.component.b.b.w;
import com.bytedance.sdk.component.b.b.z;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes5.dex */
public class j implements IHttpStack {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final w f28118a;

    /* loaded from: classes5.dex */
    public static class a extends FilterInputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ac f28119a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ac acVar) {
            super(j.b(acVar));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((InputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28119a = acVar;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.close();
                try {
                    this.f28119a.close();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28118a = new w.a().a(10000L, TimeUnit.MILLISECONDS).b(10000L, TimeUnit.MILLISECONDS).c(10000L, TimeUnit.MILLISECONDS).a();
    }

    public static boolean a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.AD_TEXT_ID, null, i2, i3)) == null) ? (i2 == 4 || (100 <= i3 && i3 < 200) || i3 == 204 || i3 == 304) ? false : true : invokeII.booleanValue;
    }

    private String b(Request<?> request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, request)) == null) {
            if (request != null) {
                if (request.getUrl() != null) {
                    try {
                    } catch (Exception unused) {
                        return "";
                    }
                }
                return InetAddress.getByName(new URL(request.getUrl()).getHost()).getHostAddress();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    private z.a c(Request request) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, request)) == null) {
            if (request == null || request.getUrl() == null) {
                return null;
            }
            z.a aVar = new z.a();
            URL url = new URL(request.getUrl());
            String host = url.getHost();
            n nVar = com.bytedance.sdk.component.adnet.a.f27984a;
            String a2 = nVar != null ? nVar.a(host) : null;
            boolean z = false;
            if (!TextUtils.isEmpty(a2)) {
                try {
                    aVar.a(new URL(url.toString().replaceFirst(host, a2))).b("Host", host);
                    z = true;
                } catch (Exception unused) {
                }
            }
            if (!z) {
                aVar.a(url);
            }
            return aVar;
        }
        return (z.a) invokeL.objValue;
    }

    public static aa d(Request request) throws com.bytedance.sdk.component.adnet.err.a {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, request)) == null) {
            byte[] body = request.getBody();
            if (body == null) {
                if (request.getMethod() != 1) {
                    return null;
                }
                body = "".getBytes();
            }
            return aa.a(v.a(request.getBodyContentType()), body);
        }
        return (aa) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.face.IHttpStack
    public HttpResponse performRequest(Request<?> request, Map<String, String> map) throws IOException, VAdError {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048576, this, request, map)) != null) {
            return (HttpResponse) invokeLL.objValue;
        }
        long timeoutMs = request.getTimeoutMs();
        boolean z = true;
        w a2 = this.f28118a.y().a(timeoutMs, TimeUnit.MILLISECONDS).b(timeoutMs, TimeUnit.MILLISECONDS).c(timeoutMs, TimeUnit.MILLISECONDS).b(true).a(true).a();
        z.a c2 = c(request);
        if (c2 != null) {
            a(request);
            if (!TextUtils.isEmpty(request.getUserAgent())) {
                c2.b("User-Agent").b("User-Agent", request.getUserAgent());
            }
            Map<String, String> headers = request.getHeaders();
            if (headers != null) {
                for (String str : headers.keySet()) {
                    c2.b(str, headers.get(str));
                }
            }
            if (map != null) {
                for (String str2 : map.keySet()) {
                    c2.a(str2, map.get(str2));
                }
            }
            a(c2, request);
            ab b2 = a2.a(c2.d()).b();
            com.bytedance.sdk.component.b.b.a.c.k a3 = com.bytedance.sdk.component.b.b.a.c.k.a(b2);
            ac h2 = b2.h();
            try {
                int i2 = a3.f28351b;
                if (i2 != -1) {
                    if (!a(request.getMethod(), i2)) {
                        HttpResponse httpResponse = new HttpResponse(i2, a(b2.g()));
                        h2.close();
                        return httpResponse;
                    }
                    try {
                        return new HttpResponse(i2, a(b2.g()), (int) h2.b(), new a(h2));
                    } catch (Throwable th) {
                        th = th;
                        if (!z) {
                            h2.close();
                        }
                        throw th;
                    }
                }
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            } catch (Throwable th2) {
                th = th2;
                z = false;
            }
        } else {
            throw new IllegalArgumentException("request params maybe null");
        }
    }

    private void a(Request<?> request) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, request) == null) || request == null) {
            return;
        }
        request.setIpAddrStr(b(request));
    }

    public static List<Header> a(s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, sVar)) == null) {
            if (sVar == null) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList(sVar.a());
            int a2 = sVar.a();
            for (int i2 = 0; i2 < a2; i2++) {
                String a3 = sVar.a(i2);
                String b2 = sVar.b(i2);
                if (a3 != null) {
                    arrayList.add(new Header(a3, b2));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static InputStream b(ac acVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, acVar)) == null) {
            if (acVar == null) {
                return null;
            }
            return acVar.c();
        }
        return (InputStream) invokeL.objValue;
    }

    public static void a(z.a aVar, Request<?> request) throws IOException, com.bytedance.sdk.component.adnet.err.a {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, request) == null) {
            switch (request.getMethod()) {
                case -1:
                    byte[] postBody = request.getPostBody();
                    if (postBody != null) {
                        aVar.a(aa.a(v.a(request.getBodyContentType()), postBody));
                        return;
                    }
                    return;
                case 0:
                    aVar.a();
                    return;
                case 1:
                    aVar.a(d(request));
                    return;
                case 2:
                    aVar.c(d(request));
                    return;
                case 3:
                    aVar.c();
                    return;
                case 4:
                    aVar.b();
                    return;
                case 5:
                    aVar.a(HttpOptions.METHOD_NAME, (aa) null);
                    return;
                case 6:
                    aVar.a(HttpTrace.METHOD_NAME, (aa) null);
                    return;
                case 7:
                    aVar.d(d(request));
                    return;
                default:
                    throw new IllegalStateException("Unknown method type.");
            }
        }
    }
}
