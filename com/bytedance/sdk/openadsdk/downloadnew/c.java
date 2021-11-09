package com.bytedance.sdk.openadsdk.downloadnew;

import android.text.TextUtils;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.apache.http.protocol.HTTP;
/* loaded from: classes11.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public InputStream f61700a;

        /* renamed from: b  reason: collision with root package name */
        public Map<String, String> f61701b;

        /* renamed from: c  reason: collision with root package name */
        public int f61702c;

        /* renamed from: d  reason: collision with root package name */
        public HttpURLConnection f61703d;

        public a(InputStream inputStream, Map<String, String> map, int i2, HttpURLConnection httpURLConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream, map, Integer.valueOf(i2), httpURLConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61700a = inputStream;
            this.f61701b = map;
            this.f61702c = i2;
            this.f61703d = httpURLConnection;
        }
    }

    public static HttpURLConnection a(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, map)) == null) {
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
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? a(httpURLConnection.getHeaderField("Location"), map) : httpURLConnection;
            } catch (Exception unused2) {
                httpURLConnection3 = httpURLConnection2;
                return httpURLConnection3;
            }
        }
        return (HttpURLConnection) invokeLL.objValue;
    }

    public static Map<String, String> a(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, httpURLConnection)) == null) {
            HashMap hashMap = new HashMap();
            int size = httpURLConnection.getHeaderFields().size();
            for (int i2 = 0; i2 < size; i2++) {
                hashMap.put(httpURLConnection.getHeaderFieldKey(i2), httpURLConnection.getHeaderField(i2));
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static a a(String str, List<com.ss.android.socialbase.downloader.model.c> list) throws IOException {
        InterceptResult invokeLL;
        int responseCode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, list)) == null) {
            HashMap hashMap = new HashMap();
            if (list != null && !list.isEmpty()) {
                for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                    hashMap.put(cVar.a(), cVar.b());
                }
            }
            HttpURLConnection a2 = a(str, hashMap);
            if (a2 != null && (responseCode = a2.getResponseCode()) >= 200 && responseCode < 300) {
                Map<String, String> a3 = a(a2);
                InputStream inputStream = a2.getInputStream();
                String contentEncoding = a2.getContentEncoding();
                if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.contains(AsyncHttpClient.ENCODING_GZIP)) {
                    inputStream = new GZIPInputStream(inputStream);
                }
                return new a(inputStream, a3, responseCode, a2);
            }
            return null;
        }
        return (a) invokeLL.objValue;
    }
}
