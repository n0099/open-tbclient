package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.l.a.e.b.o.k;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class f implements d.l.a.e.b.o.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f31008a;

    public f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31008a = new WeakReference<>(context);
    }

    @Nullable
    private HttpURLConnection a(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        InterceptResult invokeLL;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, list)) == null) {
            HttpURLConnection httpURLConnection3 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            } catch (Exception unused) {
            }
            try {
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setRequestProperty(BOSTokenRequest.ACCEPT, "*/*");
                httpURLConnection.setRequestProperty("connection", HTTP.CONN_KEEP_ALIVE);
                if (list != null && !list.isEmpty()) {
                    for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                        httpURLConnection.setRequestProperty(cVar.a(), cVar.b());
                    }
                }
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? a(httpURLConnection.getHeaderField("Location"), list) : httpURLConnection;
            } catch (Exception unused2) {
                httpURLConnection3 = httpURLConnection2;
                return httpURLConnection3;
            }
        }
        return (HttpURLConnection) invokeLL.objValue;
    }

    @Override // d.l.a.e.b.o.a
    public k downloadWithConnection(int i2, String str, List<com.ss.android.socialbase.downloader.model.c> list) throws IOException {
        InterceptResult invokeILL;
        int responseCode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, str, list)) == null) {
            HttpURLConnection a2 = a(str, list);
            if (a2 != null && (responseCode = a2.getResponseCode()) >= 200 && responseCode < 300) {
                Map<String, String> a3 = a(a2);
                InputStream inputStream = a2.getInputStream();
                String contentEncoding = a2.getContentEncoding();
                return new k(this, (TextUtils.isEmpty(contentEncoding) || !contentEncoding.contains(AsyncHttpClient.ENCODING_GZIP)) ? inputStream : new GZIPInputStream(inputStream), a3, responseCode, a2) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.a.f.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ InputStream f31009a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Map f31010b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ int f31011c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ HttpURLConnection f31012d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ f f31013e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r7, a3, Integer.valueOf(responseCode), a2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f31013e = this;
                        this.f31009a = r7;
                        this.f31010b = a3;
                        this.f31011c = responseCode;
                        this.f31012d = a2;
                    }

                    @Override // d.l.a.e.b.o.k
                    public InputStream a() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f31009a : (InputStream) invokeV.objValue;
                    }

                    @Override // d.l.a.e.b.o.i
                    public int b() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31011c : invokeV.intValue;
                    }

                    @Override // d.l.a.e.b.o.i
                    public void c() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        }
                    }

                    @Override // d.l.a.e.b.o.k
                    public void d() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                            try {
                                this.f31012d.disconnect();
                            } catch (Exception unused) {
                            }
                        }
                    }

                    @Override // d.l.a.e.b.o.i
                    public String a(String str2) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2)) == null) ? (String) this.f31010b.get(str2) : (String) invokeL.objValue;
                    }
                };
            }
            return null;
        }
        return (k) invokeILL.objValue;
    }

    private Map<String, String> a(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, httpURLConnection)) == null) {
            HashMap hashMap = new HashMap();
            int size = httpURLConnection.getHeaderFields().size();
            for (int i2 = 0; i2 < size; i2++) {
                hashMap.put(httpURLConnection.getHeaderFieldKey(i2), httpURLConnection.getHeaderField(i2));
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
