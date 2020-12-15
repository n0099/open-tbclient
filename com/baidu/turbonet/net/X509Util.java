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
/* loaded from: classes14.dex */
public class X509Util {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final char[] HEX_DIGITS;
    private static KeyStore oFA;
    private static KeyStore oFB;
    private static File oFC;
    private static Set<Pair<X500Principal, PublicKey>> oFD;
    private static boolean oFE;
    private static boolean oFF;
    private static CertificateFactory oFw;
    private static c oFx;
    private static a oFy;
    private static c oFz;
    private static final Object sLock;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public interface c {
        List<X509Certificate> a(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException;
    }

    private static native void nativeNotifyKeyChainChanged();

    private static native void nativeRecordCertVerifyCapabilitiesHistogram(boolean z);

    static {
        $assertionsDisabled = !X509Util.class.desiredAssertionStatus();
        sLock = new Object();
        oFF = false;
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static final class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.security.STORAGE_CHANGED")) {
                try {
                    X509Util.ein();
                } catch (KeyStoreException e) {
                    Log.e("X509Util", "Unable to reload the default TrustManager", e);
                } catch (NoSuchAlgorithmException e2) {
                    Log.e("X509Util", "Unable to reload the default TrustManager", e2);
                } catch (CertificateException e3) {
                    Log.e("X509Util", "Unable to reload the default TrustManager", e3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static final class b implements c {
        private final X509TrustManager oFG;

        public b(X509TrustManager x509TrustManager) {
            this.oFG = x509TrustManager;
        }

        @Override // com.baidu.turbonet.net.X509Util.c
        public List<X509Certificate> a(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
            this.oFG.checkServerTrusted(x509CertificateArr, str);
            return Collections.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static final class d implements c {
        private final X509TrustManagerExtensions oFH;

        @SuppressLint({"NewApi"})
        public d(X509TrustManager x509TrustManager) {
            this.oFH = new X509TrustManagerExtensions(x509TrustManager);
        }

        @Override // com.baidu.turbonet.net.X509Util.c
        public List<X509Certificate> a(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
            return this.oFH.checkServerTrusted(x509CertificateArr, str, str2);
        }
    }

    private static void ensureInitialized() throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        synchronized (sLock) {
            eil();
        }
    }

    private static void eil() throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        if (!$assertionsDisabled && !Thread.holdsLock(sLock)) {
            throw new AssertionError();
        }
        if (oFw == null) {
            oFw = CertificateFactory.getInstance("X.509");
        }
        if (oFx == null) {
            oFx = b((KeyStore) null);
        }
        if (!oFE) {
            try {
                oFB = KeyStore.getInstance("AndroidCAStore");
                try {
                    oFB.load(null);
                } catch (IOException e) {
                }
                oFC = new File(System.getenv("ANDROID_ROOT") + "/etc/security/cacerts");
            } catch (KeyStoreException e2) {
            }
            if (!oFF) {
                nativeRecordCertVerifyCapabilitiesHistogram(oFB != null);
            }
            oFE = true;
        }
        if (oFD == null) {
            oFD = new HashSet();
        }
        if (oFA == null) {
            oFA = KeyStore.getInstance(KeyStore.getDefaultType());
            try {
                oFA.load(null);
            } catch (IOException e3) {
            }
        }
        if (oFz == null) {
            oFz = b(oFA);
        }
        if (!oFF && oFy == null) {
            oFy = new a();
            ContextUtils.getApplicationContext().registerReceiver(oFy, new IntentFilter("android.security.STORAGE_CHANGED"));
        }
    }

    private static c b(KeyStore keyStore) throws KeyStoreException, NoSuchAlgorithmException {
        TrustManager[] trustManagers;
        c bVar;
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
            if (trustManager instanceof X509TrustManager) {
                try {
                    if (Build.VERSION.SDK_INT >= 17) {
                        bVar = new d((X509TrustManager) trustManager);
                    } else {
                        bVar = new b((X509TrustManager) trustManager);
                    }
                    return bVar;
                } catch (IllegalArgumentException e) {
                    Log.e("X509Util", "Error creating trust manager (" + trustManager.getClass().getName() + "): " + e);
                }
            }
        }
        Log.e("X509Util", "Could not find suitable trust manager");
        return null;
    }

    private static void eim() throws KeyStoreException, NoSuchAlgorithmException {
        if (!$assertionsDisabled && !Thread.holdsLock(sLock)) {
            throw new AssertionError();
        }
        oFz = b(oFA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ein() throws KeyStoreException, NoSuchAlgorithmException, CertificateException {
        synchronized (sLock) {
            oFx = null;
            oFD = null;
            eil();
        }
        nativeNotifyKeyChainChanged();
    }

    public static X509Certificate am(byte[] bArr) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        ensureInitialized();
        return (X509Certificate) oFw.generateCertificate(new ByteArrayInputStream(bArr));
    }

    public static void addTestRootCertificate(byte[] bArr) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        ensureInitialized();
        X509Certificate am = am(bArr);
        synchronized (sLock) {
            oFA.setCertificateEntry("root_cert_" + Integer.toString(oFA.size()), am);
            eim();
        }
    }

    public static void clearTestRootCertificates() throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        ensureInitialized();
        synchronized (sLock) {
            try {
                oFA.load(null);
                eim();
            } catch (IOException e) {
            }
        }
    }

    private static String a(X500Principal x500Principal) throws NoSuchAlgorithmException {
        byte[] digest = MessageDigest.getInstance("MD5").digest(x500Principal.getEncoded());
        char[] cArr = new char[8];
        for (int i = 0; i < 4; i++) {
            cArr[i * 2] = HEX_DIGITS[(digest[3 - i] >> 4) & 15];
            cArr[(i * 2) + 1] = HEX_DIGITS[digest[3 - i] & 15];
        }
        return new String(cArr);
    }

    private static boolean b(X509Certificate x509Certificate) throws NoSuchAlgorithmException, KeyStoreException {
        if (!$assertionsDisabled && !Thread.holdsLock(sLock)) {
            throw new AssertionError();
        }
        if (oFB == null) {
            return false;
        }
        Pair<X500Principal, PublicKey> pair = new Pair<>(x509Certificate.getSubjectX500Principal(), x509Certificate.getPublicKey());
        if (oFD.contains(pair)) {
            return true;
        }
        String a2 = a(x509Certificate.getSubjectX500Principal());
        int i = 0;
        while (true) {
            String str = a2 + '.' + i;
            if (!new File(oFC, str).exists()) {
                return false;
            }
            Certificate certificate = oFB.getCertificate("system:" + str);
            if (certificate != null) {
                if (!(certificate instanceof X509Certificate)) {
                    Log.e("X509Util", "Anchor " + str + " not an X509Certificate: " + certificate.getClass().getName());
                } else {
                    X509Certificate x509Certificate2 = (X509Certificate) certificate;
                    if (x509Certificate.getSubjectX500Principal().equals(x509Certificate2.getSubjectX500Principal()) && x509Certificate.getPublicKey().equals(x509Certificate2.getPublicKey())) {
                        oFD.add(pair);
                        return true;
                    }
                }
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static boolean c(X509Certificate x509Certificate) throws CertificateException {
        try {
            List<String> extendedKeyUsage = x509Certificate.getExtendedKeyUsage();
            if (extendedKeyUsage == null) {
                return true;
            }
            for (String str : extendedKeyUsage) {
                if (str.equals("1.3.6.1.5.5.7.3.1") || str.equals("2.5.29.37.0") || str.equals("2.16.840.1.113730.4.1") || str.equals("1.3.6.1.4.1.311.10.3.3")) {
                    return true;
                }
                while (r3.hasNext()) {
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    private static boolean t(Throwable th) {
        while (th != null) {
            if (th instanceof CertificateNotYetValidException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2, int i) throws KeyStoreException, NoSuchAlgorithmException {
        boolean z;
        List<X509Certificate> emptyList;
        if (bArr == null || bArr.length == 0 || bArr[0] == null) {
            throw new IllegalArgumentException("Expected non-null and non-empty certificate chain passed as |certChain|. |certChain|=" + Arrays.deepToString(bArr));
        }
        try {
            ensureInitialized();
            X509Certificate[] x509CertificateArr = new X509Certificate[bArr.length];
            for (int i2 = 0; i2 < bArr.length; i2++) {
                try {
                    x509CertificateArr[i2] = am(bArr[i2]);
                } catch (CertificateException e) {
                    return new AndroidCertVerifyResult(-5);
                }
            }
            try {
                if (!c(x509CertificateArr[0])) {
                    return new AndroidCertVerifyResult(-6);
                }
                synchronized (sLock) {
                    if (oFx == null) {
                        return new AndroidCertVerifyResult(-1);
                    }
                    try {
                        emptyList = oFx.a(x509CertificateArr, str, str2);
                        z = false;
                    } catch (CertificateException e2) {
                        try {
                            emptyList = oFz.a(x509CertificateArr, str, str2);
                            z = false;
                        } catch (CertificateException e3) {
                            Log.i("X509Util", "Failed to validate the certificate chain, error: " + e2.getMessage());
                            if (t(e2)) {
                                z = true;
                                emptyList = Collections.emptyList();
                            } else {
                                return new AndroidCertVerifyResult(-2);
                            }
                        }
                    }
                    if (z) {
                        try {
                            try {
                                Date date = new Date((i * 1000) + System.currentTimeMillis());
                                Log.d("X509Util", "recheck cert date,serverDatre = " + date.toString());
                                x509CertificateArr[0].checkValidity(date);
                            } catch (CertificateExpiredException e4) {
                                return new AndroidCertVerifyResult(-3);
                            }
                        } catch (CertificateNotYetValidException e5) {
                            return new AndroidCertVerifyResult(-4);
                        }
                    }
                    return new AndroidCertVerifyResult(0, emptyList.size() > 0 ? b(emptyList.get(emptyList.size() - 1)) : false, emptyList);
                }
            } catch (CertificateException e6) {
                return new AndroidCertVerifyResult(-1);
            }
        } catch (CertificateException e7) {
            return new AndroidCertVerifyResult(-1);
        }
    }
}
