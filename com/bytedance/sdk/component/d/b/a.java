package com.bytedance.sdk.component.d.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class a implements com.bytedance.sdk.component.d.c<byte[]> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x005a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x005c */
    /* JADX DEBUG: Multi-variable search result rejected for r6v3, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r6v4, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r6v9, resolved type: java.io.ByteArrayOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7 */
    @Override // com.bytedance.sdk.component.d.c
    public d<byte[]> a(c cVar) {
        InterceptResult invokeL;
        Closeable closeable;
        InputStream inputStream;
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream;
        String message;
        Closeable closeable2;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            int i2 = 0;
            InputStream inputStream2 = null;
            Map<String, String> map = null;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(cVar.a()).openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.connect();
                    inputStream = httpURLConnection.getInputStream();
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    byte[] bArr2 = new byte[1024];
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = inputStream.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        } catch (MalformedURLException e2) {
                            e = e2;
                            bArr = null;
                        } catch (IOException e3) {
                            e = e3;
                            bArr = null;
                        }
                    }
                    i2 = 200;
                    bArr = byteArrayOutputStream.toByteArray();
                    try {
                        map = cVar.b() ? a(httpURLConnection) : null;
                        com.bytedance.sdk.component.d.c.c.a.a(inputStream);
                        com.bytedance.sdk.component.d.c.c.a.a(byteArrayOutputStream);
                        message = "success";
                    } catch (MalformedURLException e4) {
                        e = e4;
                        com.bytedance.sdk.component.d.c.c.a("InternalHttpClient", "MalformedURLException:" + e.getMessage());
                        message = e.getMessage();
                        closeable2 = byteArrayOutputStream;
                        com.bytedance.sdk.component.d.c.c.a.a(inputStream);
                        com.bytedance.sdk.component.d.c.c.a.a(closeable2);
                        return new d<>(i2, bArr, message, map);
                    } catch (IOException e5) {
                        e = e5;
                        com.bytedance.sdk.component.d.c.c.a("InternalHttpClient", "IOException:" + e.getMessage());
                        message = e.getMessage();
                        closeable2 = byteArrayOutputStream;
                        com.bytedance.sdk.component.d.c.c.a.a(inputStream);
                        com.bytedance.sdk.component.d.c.c.a.a(closeable2);
                        return new d<>(i2, bArr, message, map);
                    }
                } catch (MalformedURLException e6) {
                    e = e6;
                    bArr = null;
                    byteArrayOutputStream = bArr;
                    com.bytedance.sdk.component.d.c.c.a("InternalHttpClient", "MalformedURLException:" + e.getMessage());
                    message = e.getMessage();
                    closeable2 = byteArrayOutputStream;
                    com.bytedance.sdk.component.d.c.c.a.a(inputStream);
                    com.bytedance.sdk.component.d.c.c.a.a(closeable2);
                    return new d<>(i2, bArr, message, map);
                } catch (IOException e7) {
                    e = e7;
                    bArr = null;
                    byteArrayOutputStream = bArr;
                    com.bytedance.sdk.component.d.c.c.a("InternalHttpClient", "IOException:" + e.getMessage());
                    message = e.getMessage();
                    closeable2 = byteArrayOutputStream;
                    com.bytedance.sdk.component.d.c.c.a.a(inputStream);
                    com.bytedance.sdk.component.d.c.c.a.a(closeable2);
                    return new d<>(i2, bArr, message, map);
                } catch (Throwable th2) {
                    th = th2;
                    closeable = null;
                    inputStream2 = inputStream;
                    com.bytedance.sdk.component.d.c.c.a.a(inputStream2);
                    com.bytedance.sdk.component.d.c.c.a.a(closeable);
                    throw th;
                }
            } catch (MalformedURLException e8) {
                e = e8;
                inputStream = null;
                bArr = null;
            } catch (IOException e9) {
                e = e9;
                inputStream = null;
                bArr = null;
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
                com.bytedance.sdk.component.d.c.c.a.a(inputStream2);
                com.bytedance.sdk.component.d.c.c.a.a(closeable);
                throw th;
            }
            return new d<>(i2, bArr, message, map);
        }
        return (d) invokeL.objValue;
    }

    private Map<String, String> a(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, httpURLConnection)) == null) {
            HashMap hashMap = new HashMap();
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            for (String str : headerFields.keySet()) {
                List<String> list = headerFields.get(str);
                if (list != null && list.size() > 0) {
                    hashMap.put(str, list.get(0));
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
