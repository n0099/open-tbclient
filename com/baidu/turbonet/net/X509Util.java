package com.baidu.turbonet.net;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.turbonet.base.ContextUtils;
import com.baidu.turbonet.base.annotations.JNINamespace;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
@JNINamespace
/* loaded from: classes5.dex */
public class X509Util {

    /* renamed from: a  reason: collision with root package name */
    public static CertificateFactory f22565a = null;

    /* renamed from: b  reason: collision with root package name */
    public static d f22566b = null;

    /* renamed from: c  reason: collision with root package name */
    public static b f22567c = null;

    /* renamed from: d  reason: collision with root package name */
    public static d f22568d = null;

    /* renamed from: e  reason: collision with root package name */
    public static KeyStore f22569e = null;

    /* renamed from: f  reason: collision with root package name */
    public static KeyStore f22570f = null;

    /* renamed from: g  reason: collision with root package name */
    public static File f22571g = null;

    /* renamed from: h  reason: collision with root package name */
    public static Set<Pair<X500Principal, PublicKey>> f22572h = null;
    public static boolean i = false;
    public static boolean k = false;
    public static final Object j = new Object();
    public static final char[] l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* loaded from: classes5.dex */
    public static final class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.security.STORAGE_CHANGED")) {
                try {
                    X509Util.k();
                } catch (KeyStoreException e2) {
                    Log.e("X509Util", "Unable to reload the default TrustManager", e2);
                } catch (NoSuchAlgorithmException e3) {
                    Log.e("X509Util", "Unable to reload the default TrustManager", e3);
                } catch (CertificateException e4) {
                    Log.e("X509Util", "Unable to reload the default TrustManager", e4);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements d {

        /* renamed from: a  reason: collision with root package name */
        public final X509TrustManager f22573a;

        public c(X509TrustManager x509TrustManager) {
            this.f22573a = x509TrustManager;
        }

        @Override // com.baidu.turbonet.net.X509Util.d
        public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
            this.f22573a.checkServerTrusted(x509CertificateArr, str);
            return Collections.emptyList();
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException;
    }

    /* loaded from: classes5.dex */
    public static final class e implements d {

        /* renamed from: a  reason: collision with root package name */
        public final X509TrustManagerExtensions f22574a;

        @SuppressLint({"NewApi"})
        public e(X509TrustManager x509TrustManager) {
            this.f22574a = new X509TrustManagerExtensions(x509TrustManager);
        }

        @Override // com.baidu.turbonet.net.X509Util.d
        public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
            return this.f22574a.checkServerTrusted(x509CertificateArr, str, str2);
        }
    }

    public static void b(byte[] bArr) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        f();
        X509Certificate d2 = d(bArr);
        synchronized (j) {
            KeyStore keyStore = f22569e;
            keyStore.setCertificateEntry("root_cert_" + Integer.toString(f22569e.size()), d2);
            l();
        }
    }

    public static void c() throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        f();
        synchronized (j) {
            try {
                f22569e.load(null);
                l();
            } catch (IOException unused) {
            }
        }
    }

    public static X509Certificate d(byte[] bArr) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        f();
        return (X509Certificate) f22565a.generateCertificate(new ByteArrayInputStream(bArr));
    }

    public static d e(KeyStore keyStore) throws KeyStoreException, NoSuchAlgorithmException {
        TrustManager[] trustManagers;
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
            if (trustManager instanceof X509TrustManager) {
                try {
                    if (Build.VERSION.SDK_INT >= 17) {
                        return new e((X509TrustManager) trustManager);
                    }
                    return new c((X509TrustManager) trustManager);
                } catch (IllegalArgumentException e2) {
                    Log.e("X509Util", "Error creating trust manager (" + trustManager.getClass().getName() + "): " + e2);
                }
            }
        }
        Log.e("X509Util", "Could not find suitable trust manager");
        return null;
    }

    public static void f() throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        synchronized (j) {
            g();
        }
    }

    public static void g() throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        if (f22565a == null) {
            f22565a = CertificateFactory.getInstance("X.509");
        }
        if (f22566b == null) {
            f22566b = e(null);
        }
        if (!i) {
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
                f22570f = keyStore;
                try {
                    keyStore.load(null);
                } catch (IOException unused) {
                }
                f22571g = new File(System.getenv("ANDROID_ROOT") + "/etc/security/cacerts");
            } catch (KeyStoreException unused2) {
            }
            if (!k) {
                nativeRecordCertVerifyCapabilitiesHistogram(f22570f != null);
            }
            i = true;
        }
        if (f22572h == null) {
            f22572h = new HashSet();
        }
        if (f22569e == null) {
            KeyStore keyStore2 = KeyStore.getInstance(KeyStore.getDefaultType());
            f22569e = keyStore2;
            try {
                keyStore2.load(null);
            } catch (IOException unused3) {
            }
        }
        if (f22568d == null) {
            f22568d = e(f22569e);
        }
        if (k || f22567c != null) {
            return;
        }
        f22567c = new b();
        ContextUtils.a().registerReceiver(f22567c, new IntentFilter("android.security.STORAGE_CHANGED"));
    }

    public static String h(X500Principal x500Principal) throws NoSuchAlgorithmException {
        byte[] digest = MessageDigest.getInstance("MD5").digest(x500Principal.getEncoded());
        char[] cArr = new char[8];
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i2 * 2;
            char[] cArr2 = l;
            int i4 = 3 - i2;
            cArr[i3] = cArr2[(digest[i4] >> 4) & 15];
            cArr[i3 + 1] = cArr2[digest[i4] & 15];
        }
        return new String(cArr);
    }

    public static boolean i(X509Certificate x509Certificate) throws NoSuchAlgorithmException, KeyStoreException {
        if (f22570f == null) {
            return false;
        }
        Pair<X500Principal, PublicKey> pair = new Pair<>(x509Certificate.getSubjectX500Principal(), x509Certificate.getPublicKey());
        if (f22572h.contains(pair)) {
            return true;
        }
        String h2 = h(x509Certificate.getSubjectX500Principal());
        int i2 = 0;
        while (true) {
            String str = h2 + IStringUtil.EXTENSION_SEPARATOR + i2;
            if (!new File(f22571g, str).exists()) {
                return false;
            }
            Certificate certificate = f22570f.getCertificate("system:" + str);
            if (certificate != null) {
                if (!(certificate instanceof X509Certificate)) {
                    Log.e("X509Util", "Anchor " + str + " not an X509Certificate: " + certificate.getClass().getName());
                } else {
                    X509Certificate x509Certificate2 = (X509Certificate) certificate;
                    if (x509Certificate.getSubjectX500Principal().equals(x509Certificate2.getSubjectX500Principal()) && x509Certificate.getPublicKey().equals(x509Certificate2.getPublicKey())) {
                        f22572h.add(pair);
                        return true;
                    }
                }
            }
            i2++;
        }
    }

    public static boolean j(Throwable th) {
        while (th != null) {
            if (th instanceof CertificateNotYetValidException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static void k() throws KeyStoreException, NoSuchAlgorithmException, CertificateException {
        synchronized (j) {
            f22566b = null;
            f22572h = null;
            g();
        }
        nativeNotifyKeyChainChanged();
    }

    public static void l() throws KeyStoreException, NoSuchAlgorithmException {
        f22568d = e(f22569e);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m(X509Certificate x509Certificate) throws CertificateException {
        List<String> extendedKeyUsage;
        try {
            extendedKeyUsage = x509Certificate.getExtendedKeyUsage();
        } catch (NullPointerException unused) {
        }
        if (extendedKeyUsage == null) {
            return true;
        }
        for (String str : extendedKeyUsage) {
            if (str.equals("1.3.6.1.5.5.7.3.1") || str.equals("2.5.29.37.0") || str.equals("2.16.840.1.113730.4.1") || str.equals("1.3.6.1.4.1.311.10.3.3")) {
                return true;
            }
            while (r4.hasNext()) {
            }
        }
        return false;
    }

    public static AndroidCertVerifyResult n(byte[][] bArr, String str, String str2, int i2) throws KeyStoreException, NoSuchAlgorithmException {
        List<X509Certificate> emptyList;
        boolean z;
        if (bArr != null && bArr.length != 0 && bArr[0] != null) {
            try {
                f();
                X509Certificate[] x509CertificateArr = new X509Certificate[bArr.length];
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    try {
                        x509CertificateArr[i3] = d(bArr[i3]);
                    } catch (CertificateException unused) {
                        return new AndroidCertVerifyResult(-5);
                    }
                }
                try {
                    if (!m(x509CertificateArr[0])) {
                        return new AndroidCertVerifyResult(-6);
                    }
                    synchronized (j) {
                        if (f22566b == null) {
                            return new AndroidCertVerifyResult(-1);
                        }
                        try {
                            emptyList = f22566b.checkServerTrusted(x509CertificateArr, str, str2);
                        } catch (CertificateException e2) {
                            try {
                                emptyList = f22568d.checkServerTrusted(x509CertificateArr, str, str2);
                            } catch (CertificateException unused2) {
                                Log.i("X509Util", "Failed to validate the certificate chain, error: " + e2.getMessage());
                                if (j(e2)) {
                                    emptyList = Collections.emptyList();
                                    z = true;
                                } else {
                                    return new AndroidCertVerifyResult(-2);
                                }
                            }
                        }
                        z = false;
                        if (z) {
                            try {
                                Date date = new Date(System.currentTimeMillis() + (i2 * 1000));
                                Log.d("X509Util", "recheck cert date,serverDatre = " + date.toString());
                                x509CertificateArr[0].checkValidity(date);
                            } catch (CertificateExpiredException unused3) {
                                return new AndroidCertVerifyResult(-3);
                            } catch (CertificateNotYetValidException unused4) {
                                return new AndroidCertVerifyResult(-4);
                            }
                        }
                        return new AndroidCertVerifyResult(0, emptyList.size() > 0 ? i(emptyList.get(emptyList.size() - 1)) : false, emptyList);
                    }
                } catch (CertificateException unused5) {
                    return new AndroidCertVerifyResult(-1);
                }
            } catch (CertificateException unused6) {
                return new AndroidCertVerifyResult(-1);
            }
        }
        throw new IllegalArgumentException("Expected non-null and non-empty certificate chain passed as |certChain|. |certChain|=" + Arrays.deepToString(bArr));
    }

    public static native void nativeNotifyKeyChainChanged();

    public static native void nativeRecordCertVerifyCapabilitiesHistogram(boolean z);
}
