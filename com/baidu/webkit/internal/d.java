package com.baidu.webkit.internal;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.net.BdNetEngine;
import com.baidubce.http.Headers;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManagerFactory;
import org.apache.http.HttpHost;
import org.apache.http.cookie.SM;
import org.apache.http.protocol.HTTP;
/* loaded from: classes11.dex */
public final class d {
    private static final Uri c = Uri.parse("content://telephony/carriers/preferapn");
    private static boolean d = false;
    private static SSLContext e = null;
    private static b f = null;
    private static Object g = new Object();
    private static boolean h = false;
    private boolean i;
    private String j;
    private String k;
    private c l;
    private boolean p;
    private boolean t;
    private a m = null;
    public int a = -1;
    public int b = -1;
    private Map<String, String> n = new HashMap();
    private Map<String, String> o = new HashMap();
    private int q = 5;
    private int r = 0;
    private boolean s = false;

    /* loaded from: classes11.dex */
    public interface a {
    }

    /* loaded from: classes11.dex */
    public class b implements HostnameVerifier {
        public b() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* loaded from: classes11.dex */
    public interface c {
        boolean a();

        boolean a(int i);

        boolean a(byte[] bArr, int i);
    }

    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0160 A[Catch: SecurityException -> 0x0171, all -> 0x0193, TRY_LEAVE, TryCatch #8 {SecurityException -> 0x0171, all -> 0x0193, blocks: (B:48:0x0129, B:57:0x0143, B:59:0x0149, B:61:0x0156, B:75:0x017d, B:77:0x018a, B:84:0x019b, B:86:0x01a0, B:88:0x01a6, B:90:0x01b3, B:92:0x01bc, B:95:0x01ce, B:97:0x01d7, B:99:0x01e3, B:101:0x01f0, B:102:0x01f5, B:103:0x01fa, B:94:0x01c5, B:104:0x01ff, B:68:0x016d, B:63:0x0160), top: B:125:0x0129 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0196  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d(Context context, String str, c cVar) {
        NetworkInfo activeNetworkInfo;
        Cursor cursor;
        String str2;
        String str3;
        Cursor cursor2 = null;
        String str4 = null;
        this.l = null;
        this.t = false;
        this.k = str;
        this.l = cVar;
        if (str.startsWith("https")) {
            this.t = true;
        }
        String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("https_enable");
        if (GetCloudSettingsValue != null && GetCloudSettingsValue.equals("false")) {
            this.t = false;
        }
        if (!this.t && str.startsWith("https")) {
            this.k = HttpHost.DEFAULT_SCHEME_NAME;
            this.k += str.substring(5);
        }
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || activeNetworkInfo.getExtraInfo() == null) {
            return;
        }
        String lowerCase = activeNetworkInfo.getExtraInfo().toLowerCase();
        if (lowerCase != null) {
            if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                this.i = true;
                this.j = "10.0.0.172:80";
                return;
            } else if (lowerCase.startsWith("ctwap")) {
                this.i = true;
                this.j = "10.0.0.200:80";
            } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                this.i = false;
                return;
            }
        }
        try {
            if (Build.VERSION.SDK_INT <= 16) {
                cursor = context.getContentResolver().query(c, new String[]{IMConstants.MSG_ROW_ID, "apn", IMTrack.AckBuilder.PROXY_TYPE, "user"}, null, null, null);
                if (cursor == null) {
                    if (cursor != null) {
                        cursor.close();
                        return;
                    }
                    return;
                }
                try {
                    cursor.moveToFirst();
                    if (!cursor.isAfterLast()) {
                        try {
                            str3 = cursor.getString(1);
                            try {
                                str2 = cursor.getString(2);
                            } catch (Throwable th) {
                                th = th;
                                str2 = null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str2 = null;
                            str3 = null;
                        }
                        try {
                            str4 = cursor.getString(3);
                        } catch (Throwable th3) {
                            th = th3;
                            com.a.a.a.a.a.a.a.a(th);
                            if (str2 != null) {
                            }
                            if (str3 != null) {
                            }
                            this.i = false;
                            if (cursor != null) {
                            }
                            if (cursor == null) {
                            }
                        }
                        if (str2 != null || str2.length() <= 0) {
                            if (str3 != null || str3.length() <= 0) {
                                this.i = false;
                            } else {
                                String upperCase = str3.toUpperCase();
                                if (upperCase.equals("CMWAP") || upperCase.equals("UNIWAP") || upperCase.equals("3GWAP")) {
                                    this.i = true;
                                    this.j = "10.0.0.172:80";
                                } else if (upperCase.equals("CTWAP")) {
                                    this.i = true;
                                    this.j = "10.0.0.200:80";
                                } else if (str4 == null) {
                                    this.i = false;
                                } else if (str4.toUpperCase().startsWith("CMWAP")) {
                                    this.i = true;
                                } else {
                                    this.i = false;
                                }
                            }
                        } else if (BdNetEngine.URI_PROXY_CMWAP.equals(str2.trim())) {
                            this.i = true;
                            this.j = "10.0.0.172:80";
                        } else if (BdNetEngine.URI_PROXY_CTWAP.equals(str2.trim())) {
                            this.i = true;
                            this.j = "10.0.0.200:80";
                        } else {
                            this.i = false;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (SecurityException e2) {
                    e = e2;
                    cursor2 = cursor;
                    try {
                        com.a.a.a.a.a.a.a.a(e);
                        if (cursor2 != null) {
                            cursor2.close();
                            return;
                        }
                        return;
                    } catch (Throwable th4) {
                        th = th4;
                        cursor = cursor2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    if (cursor != null) {
                    }
                    throw th;
                }
            } else {
                cursor = null;
            }
            if (cursor == null) {
                cursor.close();
            }
        } catch (SecurityException e3) {
            e = e3;
        } catch (Throwable th6) {
            th = th6;
            cursor = null;
        }
    }

    private static HttpURLConnection a(URL url) throws IOException {
        if (!WebSettingsGlobalBlink.getCronetEnable()) {
            WebSettingsGlobalBlink.kernelLog("HttpUtils", "openConnection use system " + url);
            return (HttpURLConnection) url.openConnection();
        }
        WebSettingsGlobalBlink.kernelLog("HttpUtils", "openConnection1 " + url);
        synchronized (g) {
            WebSettingsGlobalBlink.kernelLog("HttpUtils", "openConnection2 " + url);
            if (!WebSettingsGlobalBlink.getChromiunNetInit() && !h) {
                h = true;
                int i = 0;
                while (i < 10000) {
                    try {
                        WebSettingsGlobalBlink.kernelLog("HttpUtils", "openConnection waited " + i);
                        if (WebSettingsGlobalBlink.getChromiunNetInit()) {
                            break;
                        }
                        i += 1000;
                        Thread.sleep(1000L);
                    } catch (InterruptedException e2) {
                        com.a.a.a.a.a.a.a.a(e2);
                    }
                }
            }
        }
        return (HttpURLConnection) url.openConnection();
    }

    public static boolean a(int i) {
        return i == 301 || i == 302 || i == 303 || i == 307;
    }

    private static boolean a(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.connect();
            return true;
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
            return false;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private boolean a(java.net.HttpURLConnection r10, int r11) {
        /*
            r9 = this;
            r2 = 0
            r0 = 1
            r1 = 0
            r3 = 200(0xc8, float:2.8E-43)
            if (r11 == r3) goto Lc
            r3 = 206(0xce, float:2.89E-43)
            if (r11 == r3) goto Lc
        Lb:
            return r1
        Lc:
            java.lang.String r3 = "Content-Encoding"
            java.lang.String r3 = r10.getHeaderField(r3)     // Catch: java.lang.Throwable -> L59
            if (r3 == 0) goto L9f
            java.lang.String r4 = "gzip"
            int r3 = r3.indexOf(r4)     // Catch: java.lang.Throwable -> L59
            if (r3 < 0) goto L9f
            r4 = r0
        L1f:
            java.io.InputStream r3 = r10.getInputStream()     // Catch: java.lang.Throwable -> L59
            if (r4 == 0) goto L41
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L93
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L93
            r2 = r4
        L2b:
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L98
        L2f:
            int r6 = r4.read(r5)     // Catch: java.lang.Throwable -> L98
            r7 = -1
            if (r6 == r7) goto L43
            com.baidu.webkit.internal.d$c r7 = r9.l     // Catch: java.lang.Throwable -> L98
            if (r7 == 0) goto L2f
            com.baidu.webkit.internal.d$c r0 = r9.l     // Catch: java.lang.Throwable -> L98
            boolean r0 = r0.a(r5, r6)     // Catch: java.lang.Throwable -> L98
            goto L2f
        L41:
            r4 = r3
            goto L2b
        L43:
            if (r2 == 0) goto L48
            r2.close()     // Catch: java.lang.Throwable -> L4f
        L48:
            if (r3 == 0) goto L4d
            r3.close()     // Catch: java.lang.Throwable -> L54
        L4d:
            r1 = r0
            goto Lb
        L4f:
            r1 = move-exception
            com.a.a.a.a.a.a.a.a(r1)
            goto L48
        L54:
            r1 = move-exception
            com.a.a.a.a.a.a.a.a(r1)
            goto L4d
        L59:
            r0 = move-exception
            r3 = r2
        L5b:
            com.a.a.a.a.a.a.a.a(r0)     // Catch: java.lang.Throwable -> L8e
            if (r3 == 0) goto L63
            r3.close()     // Catch: java.lang.Throwable -> L6a
        L63:
            if (r2 == 0) goto L9d
            r2.close()     // Catch: java.lang.Throwable -> L6f
            r0 = r1
            goto L4d
        L6a:
            r0 = move-exception
            com.a.a.a.a.a.a.a.a(r0)
            goto L63
        L6f:
            r0 = move-exception
            com.a.a.a.a.a.a.a.a(r0)
            r0 = r1
            goto L4d
        L75:
            r0 = move-exception
            r3 = r2
        L77:
            if (r2 == 0) goto L7c
            r2.close()     // Catch: java.lang.Throwable -> L82
        L7c:
            if (r3 == 0) goto L81
            r3.close()     // Catch: java.lang.Throwable -> L87
        L81:
            throw r0
        L82:
            r1 = move-exception
            com.a.a.a.a.a.a.a.a(r1)
            goto L7c
        L87:
            r1 = move-exception
            com.a.a.a.a.a.a.a.a(r1)
            goto L81
        L8c:
            r0 = move-exception
            goto L77
        L8e:
            r0 = move-exception
            r8 = r2
            r2 = r3
            r3 = r8
            goto L77
        L93:
            r0 = move-exception
            r8 = r3
            r3 = r2
            r2 = r8
            goto L5b
        L98:
            r0 = move-exception
            r8 = r3
            r3 = r2
            r2 = r8
            goto L5b
        L9d:
            r0 = r1
            goto L4d
        L9f:
            r4 = r1
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.webkit.internal.d.a(java.net.HttpURLConnection, int):boolean");
    }

    private HttpURLConnection b() {
        HttpsURLConnection httpsURLConnection;
        if (this.k == null) {
            return null;
        }
        try {
            if (this.t || !this.i || this.j == null) {
                if (this.t) {
                    synchronized (g) {
                        if (!d) {
                            f = new b();
                            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                            try {
                                Certificate generateCertificate = certificateFactory.generateCertificate(new ByteArrayInputStream("-----BEGIN CERTIFICATE-----\nMIICZTCCAc4CAQAwDQYJKoZIhvcNAQEEBQAwezELMAkGA1UEBhMCQ04xCzAJBgNV\nBAgTAkJKMQswCQYDVQQHEwJCSjELMAkGA1UEChMCQkQxCzAJBgNVBAsTAkJEMRYw\nFAYDVQQDEw13d3cuYmFpZHUuY29tMSAwHgYJKoZIhvcNAQkBFhFsaWJpbjAyQGJh\naWR1LmNvbTAeFw0xMjA1MTAwMjMzNTVaFw0xMjA2MDkwMjMzNTVaMHsxCzAJBgNV\nBAYTAkNOMQswCQYDVQQIEwJCSjELMAkGA1UEBxMCQkoxCzAJBgNVBAoTAkJEMQsw\nCQYDVQQLEwJCRDEWMBQGA1UEAxMNd3d3LmJhaWR1LmNvbTEgMB4GCSqGSIb3DQEJ\nARYRbGliaW4wMkBiYWlkdS5jb20wgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGB\nALckGzvn6jcMqYpXrZKuuCYlVJIgN2ETsnvjCtO1va5u3p0EL9CuR5BlHocJadzM\nhTI7rH/nao8mXRIcJ4Q6lOv5TAotcKUv7ri9YZ48smpE3+KXVB+Mjau05OfiYI2h\nqlYy56acRSgyp8Uj65PXL8+gae8Gx+6lq0XOKduolmmNAgMBAAEwDQYJKoZIhvcN\nAQEEBQADgYEAYGPEvv1fc4XySq+9+5jFi4TxlNy9vAWpHOjsmODM9gs5/9PQFG/c\nZc8Fz+T9IVRa8YI0mLuKlApGmvzHxwdWbtBU6AU8ifg1HBA/4VXweiq6fgRfaemd\njgW3PXjbd+OoZ0VI32TvrDErG83OYohQ5CAS2gKHfBXHJvKtmxUSdVE=\n-----END CERTIFICATE-----\n".getBytes()));
                                try {
                                    Certificate generateCertificate2 = certificateFactory.generateCertificate(new ByteArrayInputStream("-----BEGIN CERTIFICATE-----\nMIIGHjCCBQagAwIBAgIQOpJyaH8MB1ovmPVhhztdnzANBgkqhkiG9w0BAQsFADB+\nMQswCQYDVQQGEwJVUzEdMBsGA1UEChMUU3ltYW50ZWMgQ29ycG9yYXRpb24xHzAd\nBgNVBAsTFlN5bWFudGVjIFRydXN0IE5ldHdvcmsxLzAtBgNVBAMTJlN5bWFudGVj\nIENsYXNzIDMgU2VjdXJlIFNlcnZlciBDQSAtIEc0MB4XDTE2MTEyODAwMDAwMFoX\nDTE3MTEyOTIzNTk1OVowgaUxCzAJBgNVBAYTAkNOMRAwDgYDVQQIDAdiZWlqaW5n\nMRAwDgYDVQQHDAdiZWlqaW5nMTkwNwYDVQQKDDBCZWlKaW5nIEJhaWR1IE5ldGNv\nbSBTY2llbmNlIFRlY2hub2xvZ3kgQ28uLCBMdGQxGjAYBgNVBAsMEVN5c3RlbSBE\nZXBhcnRtZW50MRswGQYDVQQDDBJodHRwc2Rucy5iYWlkdS5jb20wggEiMA0GCSqG\nSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDDlHDBDS/0NI4U3lXXNBeXKrCZ4Qp+bGGO\n3n3o3UKRcrqRXMukRIJIimz5ywXS7Xp9u6iOFuQrbIl8s+4U1vim+Gk/fWC+zbFQ\n1IpKzxQ829n2wY+Wn4CTmTLb25uUYMIYHBGnmoGlYwHe+th8csH+AmiqcU/0qhnL\ncFicg4Kz+jDkw4e4DgzsYZl2VmwLwEO93ObVh+7NPQLaGYi824Txl7Lrlrz0Tp0+\n/Cvs6OqHZAZ9IM5H710LjUYg7zOW8NJUpx15txgSuN68fJENLF3evidpuVmEqh6z\nEPbFZv10AdGnT/SGE9bGOiZ9Dp9utis25SzZDj0A6Kj4EEnf6m/DAgMBAAGjggJu\nMIICajAdBgNVHREEFjAUghJodHRwc2Rucy5iYWlkdS5jb20wCQYDVR0TBAIwADAO\nBgNVHQ8BAf8EBAMCBaAwHQYDVR0lBBYwFAYIKwYBBQUHAwEGCCsGAQUFBwMCMGEG\nA1UdIARaMFgwVgYGZ4EMAQICMEwwIwYIKwYBBQUHAgEWF2h0dHBzOi8vZC5zeW1j\nYi5jb20vY3BzMCUGCCsGAQUFBwICMBkMF2h0dHBzOi8vZC5zeW1jYi5jb20vcnBh\nMB8GA1UdIwQYMBaAFF9gz2GQVd+EQxSKYCqy9Xr0QxjvMCsGA1UdHwQkMCIwIKAe\noByGGmh0dHA6Ly9zcy5zeW1jYi5jb20vc3MuY3JsMFcGCCsGAQUFBwEBBEswSTAf\nBggrBgEFBQcwAYYTaHR0cDovL3NzLnN5bWNkLmNvbTAmBggrBgEFBQcwAoYaaHR0\ncDovL3NzLnN5bWNiLmNvbS9zcy5jcnQwggEDBgorBgEEAdZ5AgQCBIH0BIHxAO8A\ndgDd6x0reg1PpiCLga2BaHB+Lo6dAdVciI09EcTNtuy+zAAAAVio/alhAAAEAwBH\nMEUCIHOx1xvjjYlBlICbAMjEvxjJjlWDbglXz80qo9843Lz2AiEA8/qhqzobAreN\nnlJAkpv2AdeffTdw+WVvSPizynYmaCIAdQDuS723dc5guuFCaR+r4Z5mow9+X7By\n2IMAxHuJeqj9ywAAAVio/amzAAAEAwBGMEQCICO5iGCU2t3tGs714Nzp8dhchzyM\n8r7QG/80nzTOkVbgAiBvxPJ/5vQrZXX+nr2ZeHhjCf8eN2W3g4pt/4hjNygOQzAN\nBgkqhkiG9w0BAQsFAAOCAQEAB6LQyLi2ESb5mXyPRoGnQrjjIzCQk0JkkCOUyuCI\nZB0PZh4u0mN+4YNeCRAWYZye9Aazee0DoP0qbdnAwSNBXYUVLrwf27UTk1XcQGMu\nbldFG1fpijPAx7pMAztPSitracd0lQAvSAyJojc9NCHDvVnjGqawVrwy3cUeNdrH\nsns8TnxcsZ0ykOOZTbrN+ReGc2F6AiHqNVOMua0AV+5oaI80GvGvejRlM62xxTn9\npKYPg6EG1VkbBPVm21xNcmdLbvm7V8gK7RSkSeaaYI8olvMr2HfA4uMMNm+vBmSu\nkFkOrzkxBpylfP6TF/szBTiC66gn+GVB1xAmbw795LHB7g==\n-----END CERTIFICATE-----\n".getBytes()));
                                    KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                                    keyStore.load(null, null);
                                    keyStore.setCertificateEntry("ca", generateCertificate);
                                    keyStore.setCertificateEntry("ca0", generateCertificate2);
                                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                                    trustManagerFactory.init(keyStore);
                                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                                    e = sSLContext;
                                    sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
                                    d = true;
                                    Log.d("HttpUtils", "mSslContextInit = true");
                                } catch (Throwable th) {
                                    com.a.a.a.a.a.a.a.a(th);
                                    return null;
                                }
                            } catch (Throwable th2) {
                                com.a.a.a.a.a.a.a.a(th2);
                                return null;
                            }
                        }
                    }
                    URL url = new URL(this.k);
                    if ((WebSettingsGlobalBlink.getCronetEnable() && WebSettingsGlobalBlink.getChromiunNetInit()) || this.k == null || !this.k.startsWith("https://180.76.76.112")) {
                        HttpURLConnection a2 = a(url);
                        a2.setReadTimeout(this.b);
                        httpsURLConnection = a2;
                    } else {
                        Log.e("cronet", " http_utils use self cert :" + url.getHost());
                        HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                        httpsURLConnection2.setReadTimeout(this.b);
                        httpsURLConnection2.setHostnameVerifier(f);
                        httpsURLConnection2.setSSLSocketFactory(e.getSocketFactory());
                        httpsURLConnection = httpsURLConnection2;
                    }
                } else {
                    Log.d("HttpUtils", "url not https");
                    httpsURLConnection = a(new URL(this.k));
                }
            } else if (this.j.startsWith(BdNetEngine.URI_PROXY_CTWAP)) {
                httpsURLConnection = a(new URL(this.k));
            } else {
                URL url2 = new URL(this.k);
                HttpURLConnection a3 = a(b(url2));
                if (url2.getPort() > 0) {
                    a3.setRequestProperty("X-Online-Host", url2.getHost() + ":" + url2.getPort());
                    httpsURLConnection = a3;
                } else {
                    a3.setRequestProperty("X-Online-Host", url2.getHost());
                    httpsURLConnection = a3;
                }
            }
            if (this.a > 0) {
                httpsURLConnection.setConnectTimeout(this.a);
            }
            if (this.b > 0) {
                httpsURLConnection.setReadTimeout(this.b);
            }
            httpsURLConnection.setInstanceFollowRedirects(this.p);
            httpsURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_CLOSE);
            b(httpsURLConnection);
            return httpsURLConnection;
        } catch (Throwable th3) {
            com.a.a.a.a.a.a.a.a(th3);
            return null;
        }
    }

    private static URL b(URL url) {
        try {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("http://");
                stringBuffer.append("10.0.0.172:80");
                String file = url.getFile();
                if (!TextUtils.isEmpty(file)) {
                    stringBuffer.append(file);
                }
                String ref = url.getRef();
                if (!TextUtils.isEmpty(ref)) {
                    stringBuffer.append("#");
                    stringBuffer.append(ref);
                }
                return new URL(stringBuffer.toString());
            } catch (Exception e2) {
                com.a.a.a.a.a.a.a.a(e2);
                if (0 == 0) {
                    try {
                        return new URL("http://10.0.0.172");
                    } catch (Exception e3) {
                        return url;
                    }
                }
                return null;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                try {
                    new URL("http://10.0.0.172");
                } catch (Exception e4) {
                }
            }
            throw th;
        }
    }

    private void b(HttpURLConnection httpURLConnection) {
        if (this.n != null && this.n.size() > 0) {
            for (Map.Entry<String, String> entry : this.n.entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if (this.o == null || this.o.size() <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry2 : this.o.entrySet()) {
            sb.append(entry2.getKey().trim());
            sb.append(ETAG.EQUAL);
            sb.append(entry2.getValue().trim());
            sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
            httpURLConnection.addRequestProperty(SM.COOKIE, sb.toString());
        }
    }

    private boolean b(HttpURLConnection httpURLConnection, int i) {
        String headerField;
        boolean z = false;
        if (!a(i) || this.r >= this.q || (headerField = httpURLConnection.getHeaderField(Headers.LOCATION)) == null) {
            z = true;
        } else {
            String headerField2 = httpURLConnection.getHeaderField(SM.SET_COOKIE);
            if (headerField2 != null) {
                try {
                    String[] split = headerField2.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                    for (String str : split) {
                        String[] split2 = str.split(ETAG.EQUAL);
                        if (split2.length >= 2) {
                            this.o.put(split2[0], split2[1]);
                        }
                    }
                } catch (Exception e2) {
                    com.a.a.a.a.a.a.a.a(e2);
                }
            }
            try {
                this.k = new URI(this.k).resolve(new URI(headerField)).toString();
                this.s = true;
            } catch (URISyntaxException e3) {
                com.a.a.a.a.a.a.a.a(e3);
                z = true;
            }
            this.r++;
        }
        if (!z || this.l == null) {
            return z;
        }
        httpURLConnection.getHeaderFields();
        return true;
    }

    public final void a(String str, String str2) {
        if (this.n == null || str2 == null) {
            return;
        }
        this.n.put(str, str2);
    }

    public final boolean a() {
        HttpURLConnection b2;
        if (this.k == null) {
            return false;
        }
        boolean z = false;
        do {
            this.s = false;
            b2 = b();
            if (b2 != null && (z = a(b2))) {
                try {
                    int responseCode = b2.getResponseCode();
                    z = this.l != null ? this.l.a(responseCode) : true;
                    if (z && (z = b(b2, responseCode))) {
                        z = a(b2, responseCode);
                    }
                } catch (Throwable th) {
                    com.a.a.a.a.a.a.a.a(th);
                }
            }
        } while (this.s);
        if (b2 != null) {
            try {
                b2.disconnect();
            } catch (Exception e2) {
                com.a.a.a.a.a.a.a.a(e2);
            }
        }
        if (this.l != null) {
            this.l.a();
        }
        return z;
    }
}
