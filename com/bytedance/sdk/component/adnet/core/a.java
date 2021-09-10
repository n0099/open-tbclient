package com.bytedance.sdk.component.adnet.core;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.err.VAdError;
import com.bytedance.sdk.component.adnet.face.IHttpStack;
import com.bytedance.sdk.component.adnet.face.a;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
/* loaded from: classes9.dex */
public class a implements com.bytedance.sdk.component.adnet.face.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f64283a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final IHttpStack f64284b;

    /* renamed from: c  reason: collision with root package name */
    public final b f64285c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(8116304, "Lcom/bytedance/sdk/component/adnet/core/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(8116304, "Lcom/bytedance/sdk/component/adnet/core/a;");
                return;
            }
        }
        f64283a = o.f64360a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(IHttpStack iHttpStack) {
        this(iHttpStack, new b(4096));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iHttpStack};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((IHttpStack) objArr2[0], (b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c6, code lost:
        throw new java.io.IOException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0154, code lost:
        throw new com.bytedance.sdk.component.adnet.err.f(r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:145:0x017d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ee A[Catch: all -> 0x00e5, TRY_ENTER, TryCatch #4 {all -> 0x00e5, blocks: (B:6:0x0011, B:61:0x00ee, B:63:0x010a, B:73:0x012a, B:74:0x012f, B:79:0x0138, B:81:0x013e, B:82:0x0149, B:83:0x014e, B:84:0x014f, B:85:0x0154, B:86:0x0155, B:87:0x0160, B:93:0x017d, B:94:0x0184, B:96:0x0186, B:97:0x01a0, B:98:0x01a1), top: B:122:0x0011 }] */
    @Override // com.bytedance.sdk.component.adnet.face.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public i a(Request<?> request) throws VAdError {
        InterceptResult invokeL;
        List<Header> list;
        byte[] bArr;
        HttpResponse performRequest;
        byte[] a2;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, request)) != null) {
            return (i) invokeL.objValue;
        }
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            List<Header> emptyList = Collections.emptyList();
            HttpResponse httpResponse = null;
            try {
                try {
                    performRequest = this.f64284b.performRequest(request, a(request.getCacheEntry()));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (MalformedURLException e2) {
                e = e2;
            } catch (SocketTimeoutException unused) {
            } catch (IOException e3) {
                e = e3;
                list = emptyList;
                bArr = null;
            }
            try {
                try {
                    int statusCode = performRequest.getStatusCode();
                    List<Header> headers = performRequest.getHeaders();
                    if (statusCode == 304) {
                        try {
                            a.C1882a cacheEntry = request.getCacheEntry();
                            if (cacheEntry == null) {
                                i iVar = new i(304, (byte[]) null, true, SystemClock.elapsedRealtime() - elapsedRealtime, headers);
                                if (performRequest != null) {
                                    try {
                                        if (performRequest.getContent() != null) {
                                            performRequest.getContent().close();
                                        }
                                    } catch (Throwable unused2) {
                                    }
                                }
                                return iVar;
                            }
                            i iVar2 = new i(304, cacheEntry.f64384b, true, SystemClock.elapsedRealtime() - elapsedRealtime, a(headers, cacheEntry));
                            if (performRequest != null) {
                                try {
                                    if (performRequest.getContent() != null) {
                                        performRequest.getContent().close();
                                    }
                                } catch (Throwable unused3) {
                                }
                            }
                            return iVar2;
                        } catch (IOException e4) {
                            e = e4;
                            bArr = null;
                            httpResponse = performRequest;
                            list = headers;
                        }
                    } else {
                        try {
                            a2 = a(request, performRequest);
                            try {
                                aVar = this;
                                aVar.a(SystemClock.elapsedRealtime() - elapsedRealtime, request, a2, statusCode);
                            } catch (IOException e5) {
                                e = e5;
                                aVar = headers;
                            }
                        } catch (IOException e6) {
                            e = e6;
                            emptyList = headers;
                            list = emptyList;
                            bArr = null;
                            httpResponse = performRequest;
                            if (httpResponse != null) {
                            }
                        }
                        try {
                            if (statusCode < 200 || statusCode > 299) {
                                break;
                            }
                            i iVar3 = new i(statusCode, a2, false, SystemClock.elapsedRealtime() - elapsedRealtime, headers);
                            if (performRequest != null) {
                                try {
                                    if (performRequest.getContent() != null) {
                                        performRequest.getContent().close();
                                    }
                                } catch (Throwable unused4) {
                                }
                            }
                            return iVar3;
                        } catch (IOException e7) {
                            e = e7;
                            list = aVar;
                            httpResponse = performRequest;
                            bArr = a2;
                            if (httpResponse != null) {
                            }
                        }
                    }
                } catch (IOException e8) {
                    e = e8;
                }
            } catch (MalformedURLException e9) {
                e = e9;
                throw new RuntimeException("Bad URL " + request.getUrl(), e);
            } catch (SocketTimeoutException unused5) {
                httpResponse = performRequest;
                a("socket", request, new com.bytedance.sdk.component.adnet.err.g(602));
                if (httpResponse != null && httpResponse.getContent() != null) {
                    httpResponse.getContent().close();
                }
            } catch (Throwable th2) {
                th = th2;
                httpResponse = performRequest;
                if (httpResponse != null) {
                    try {
                        if (httpResponse.getContent() != null) {
                            httpResponse.getContent().close();
                        }
                    } catch (Throwable unused6) {
                    }
                }
                throw th;
            }
            if (httpResponse != null) {
                int statusCode2 = httpResponse.getStatusCode();
                o.c("Unexpected response code %d for %s", Integer.valueOf(statusCode2), request.getUrl());
                if (bArr != null) {
                    i iVar4 = new i(statusCode2, bArr, false, SystemClock.elapsedRealtime() - elapsedRealtime, list);
                    if (statusCode2 != 401 && statusCode2 != 403) {
                        if (statusCode2 >= 400 && statusCode2 <= 499) {
                            throw new com.bytedance.sdk.component.adnet.err.b(iVar4);
                        }
                        if (statusCode2 < 500 || statusCode2 > 599) {
                            break;
                        } else if (request.shouldRetryServerErrors()) {
                            a("server", request, new com.bytedance.sdk.component.adnet.err.f(iVar4));
                        } else {
                            throw new com.bytedance.sdk.component.adnet.err.f(iVar4);
                        }
                    }
                    a("auth", request, new com.bytedance.sdk.component.adnet.err.a(iVar4));
                } else {
                    a("network", request, new com.bytedance.sdk.component.adnet.err.c(603));
                }
                if (httpResponse != null) {
                    try {
                        if (httpResponse.getContent() != null) {
                            httpResponse.getContent().close();
                        }
                    } catch (Throwable unused7) {
                    }
                }
            } else {
                throw new com.bytedance.sdk.component.adnet.err.d(e, 601);
            }
        }
    }

    public a(IHttpStack iHttpStack, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iHttpStack, bVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f64284b = iHttpStack;
        this.f64285c = bVar;
    }

    private void a(long j2, Request<?> request, byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Long.valueOf(j2), request, bArr, Integer.valueOf(i2)}) == null) {
            if (f64283a || j2 > 3000) {
                Object[] objArr = new Object[5];
                objArr[0] = request;
                objArr[1] = Long.valueOf(j2);
                objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : StringUtil.NULL_STRING;
                objArr[3] = Integer.valueOf(i2);
                objArr[4] = Integer.valueOf(request.getRetryPolicy().b());
                o.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
            }
        }
    }

    public static void a(String str, Request<?> request, VAdError vAdError) throws VAdError {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, request, vAdError) == null) {
            com.bytedance.sdk.component.adnet.face.d retryPolicy = request.getRetryPolicy();
            int timeoutMs = request.getTimeoutMs();
            try {
                retryPolicy.a(vAdError);
                request.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(timeoutMs)));
            } catch (VAdError e2) {
                request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(timeoutMs)));
                throw e2;
            }
        }
    }

    private Map<String, String> a(a.C1882a c1882a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, c1882a)) == null) {
            if (c1882a == null) {
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            String str = c1882a.f64385c;
            if (str != null) {
                hashMap.put("If-None-Match", str);
            }
            long j2 = c1882a.f64387e;
            if (j2 > 0) {
                hashMap.put("If-Modified-Since", com.bytedance.sdk.component.adnet.d.b.a(j2));
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public byte[] a(Request<?> request, HttpResponse httpResponse) throws IOException, com.bytedance.sdk.component.adnet.err.f {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, httpResponse)) == null) {
            if (request instanceof com.bytedance.sdk.component.adnet.b.a) {
                return ((com.bytedance.sdk.component.adnet.b.a) request).a(httpResponse);
            }
            InputStream content = httpResponse.getContent();
            return content != null ? a(content, httpResponse.getContentLength()) : new byte[0];
        }
        return (byte[]) invokeLL.objValue;
    }

    private byte[] a(InputStream inputStream, int i2) throws IOException, com.bytedance.sdk.component.adnet.err.f {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, this, inputStream, i2)) == null) {
            c cVar = new c(this.f64285c, i2);
            try {
                if (inputStream != null) {
                    byte[] a2 = this.f64285c.a(1024);
                    while (true) {
                        int read = inputStream.read(a2);
                        if (read == -1) {
                            break;
                        }
                        cVar.write(a2, 0, read);
                    }
                    byte[] byteArray = cVar.toByteArray();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                            o.a("Error occurred when closing InputStream", new Object[0]);
                        }
                    }
                    this.f64285c.a(a2);
                    cVar.close();
                    return byteArray;
                }
                throw new com.bytedance.sdk.component.adnet.err.f(606);
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                        o.a("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.f64285c.a((byte[]) null);
                cVar.close();
                throw th;
            }
        }
        return (byte[]) invokeLI.objValue;
    }

    public static List<Header> a(List<Header> list, a.C1882a c1882a) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, list, c1882a)) == null) {
            ArrayList arrayList = new ArrayList();
            TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
            if (list != null && !list.isEmpty()) {
                for (Header header : list) {
                    treeSet.add(header.getName());
                    arrayList.add(header);
                }
            }
            if (c1882a != null) {
                List<Header> list2 = c1882a.f64391i;
                if (list2 != null) {
                    if (!list2.isEmpty()) {
                        for (Header header2 : c1882a.f64391i) {
                            if (!treeSet.contains(header2.getName())) {
                                arrayList.add(header2);
                            }
                        }
                    }
                } else if (!c1882a.f64390h.isEmpty()) {
                    for (Map.Entry<String, String> entry : c1882a.f64390h.entrySet()) {
                        if (!treeSet.contains(entry.getKey())) {
                            arrayList.add(new Header(entry.getKey(), entry.getValue()));
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
