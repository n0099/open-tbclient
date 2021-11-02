package com.bytedance.sdk.openadsdk.api.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes11.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.bytedance.sdk.openadsdk.api.a.c$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f61591a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(504412083, "Lcom/bytedance/sdk/openadsdk/api/a/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(504412083, "Lcom/bytedance/sdk/openadsdk/api/a/c$a;");
                    return;
                }
            }
            f61591a = new c(null);
        }
    }

    public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f61591a : (c) invokeV.objValue;
    }

    private X509TrustManager b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                    return (X509TrustManager) trustManagers[0];
                }
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            } catch (GeneralSecurityException e2) {
                throw new IOException("No System TLS", e2);
            }
        }
        return (X509TrustManager) invokeV.objValue;
    }

    public c() {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0086 */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007e, code lost:
        if (r6 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0080, code lost:
        r6.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008d, code lost:
        if (r6 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0090, code lost:
        return null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(boolean z, String str, byte[] bArr) {
        InterceptResult invokeCommon;
        HttpsURLConnection httpsURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, bArr})) != null) {
            return (String) invokeCommon.objValue;
        }
        ?? r0 = 0;
        try {
            try {
                URL url = new URL(str);
                HttpsURLConnection.setDefaultSSLSocketFactory(a(b()));
                httpsURLConnection = (HttpsURLConnection) url.openConnection();
                try {
                    httpsURLConnection.setConnectTimeout(5000);
                    httpsURLConnection.setHostnameVerifier(com.bytedance.sdk.openadsdk.api.a.a.f61582a);
                    if (z && bArr != null && bArr.length != 0) {
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.setFixedLengthStreamingMode(bArr.length);
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpsURLConnection.getOutputStream());
                        bufferedOutputStream.write(bArr);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        httpsURLConnection.setRequestMethod("POST");
                    } else {
                        httpsURLConnection.setRequestMethod("GET");
                    }
                    int responseCode = httpsURLConnection.getResponseCode();
                    if (responseCode >= 200 && responseCode < 300) {
                        String str2 = new String(a(httpsURLConnection.getInputStream(), 1024), a(httpsURLConnection.getHeaderField("Content-Type"), "utf-8"));
                        if (httpsURLConnection != null) {
                            try {
                                httpsURLConnection.disconnect();
                            } catch (Exception unused) {
                            }
                        }
                        return str2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                th = th;
                r0 = str;
                if (r0 != 0) {
                    try {
                        r0.disconnect();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            httpsURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            if (r0 != 0) {
            }
            throw th;
        }
    }

    public static byte[] a(InputStream inputStream, int i2) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, inputStream, i2)) != null) {
            return (byte[]) invokeLI.objValue;
        }
        if (inputStream == null) {
            return null;
        }
        if (i2 < 1) {
            i2 = 1;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[i2];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (str != null) {
                String[] split = str.split(";", 0);
                for (int i2 = 1; i2 < split.length; i2++) {
                    String[] split2 = split[i2].trim().split("=", 0);
                    if (split2.length == 2 && split2[0].equals("charset")) {
                        return split2[1];
                    }
                }
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    private SSLSocketFactory a(X509TrustManager x509TrustManager) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, x509TrustManager)) == null) {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
                return sSLContext.getSocketFactory();
            } catch (GeneralSecurityException e2) {
                throw new IOException("No System TLS", e2);
            }
        }
        return (SSLSocketFactory) invokeL.objValue;
    }
}
