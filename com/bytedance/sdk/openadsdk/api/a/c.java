package com.bytedance.sdk.openadsdk.api.a;

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
/* loaded from: classes7.dex */
public class c {

    /* loaded from: classes7.dex */
    public static final class a {
        public static final c a = new c();
    }

    public static c a() {
        return a.a;
    }

    private X509TrustManager b() throws IOException {
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

    public c() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x007a, code lost:
        if (r5 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007c, code lost:
        r5.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0089, code lost:
        if (r5 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008c, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(boolean z, String str, byte[] bArr) {
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            URL url = new URL(str);
            HttpsURLConnection.setDefaultSSLSocketFactory(a(b()));
            httpsURLConnection = (HttpsURLConnection) url.openConnection();
            try {
                try {
                    httpsURLConnection.setConnectTimeout(5000);
                    httpsURLConnection.setHostnameVerifier(com.bytedance.sdk.openadsdk.api.a.a.a);
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
                httpsURLConnection2 = httpsURLConnection;
                if (httpsURLConnection2 != null) {
                    try {
                        httpsURLConnection2.disconnect();
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
            if (httpsURLConnection2 != null) {
            }
            throw th;
        }
    }

    public static byte[] a(InputStream inputStream, int i2) throws IOException {
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

    private SSLSocketFactory a(X509TrustManager x509TrustManager) throws IOException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw new IOException("No System TLS", e2);
        }
    }
}
