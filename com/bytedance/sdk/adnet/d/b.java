package com.bytedance.sdk.adnet.d;

import android.util.Log;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
@Deprecated
/* loaded from: classes4.dex */
public class b {
    @Deprecated
    public static void a() {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() { // from class: com.bytedance.sdk.adnet.d.b.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            });
            HttpsURLConnection.setDefaultSSLSocketFactory(new h());
        } catch (Throwable th) {
            Log.e("HTTPSTrustManager", "allowAllSSL error: ", th);
        }
    }
}
