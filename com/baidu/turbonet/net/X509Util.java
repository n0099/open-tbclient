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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static CertificateFactory f23140a;

    /* renamed from: b  reason: collision with root package name */
    public static d f23141b;

    /* renamed from: c  reason: collision with root package name */
    public static b f23142c;

    /* renamed from: d  reason: collision with root package name */
    public static d f23143d;

    /* renamed from: e  reason: collision with root package name */
    public static KeyStore f23144e;

    /* renamed from: f  reason: collision with root package name */
    public static KeyStore f23145f;

    /* renamed from: g  reason: collision with root package name */
    public static File f23146g;

    /* renamed from: h  reason: collision with root package name */
    public static Set<Pair<X500Principal, PublicKey>> f23147h;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f23148i;
    public static final Object j;
    public static boolean k;
    public static final char[] l;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static final class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent.getAction().equals("android.security.STORAGE_CHANGED")) {
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

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final X509TrustManager f23149a;

        public c(X509TrustManager x509TrustManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x509TrustManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23149a = x509TrustManager;
        }

        @Override // com.baidu.turbonet.net.X509Util.d
        public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, x509CertificateArr, str, str2)) == null) {
                this.f23149a.checkServerTrusted(x509CertificateArr, str);
                return Collections.emptyList();
            }
            return (List) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException;
    }

    /* loaded from: classes5.dex */
    public static final class e implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final X509TrustManagerExtensions f23150a;

        @SuppressLint({"NewApi"})
        public e(X509TrustManager x509TrustManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x509TrustManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23150a = new X509TrustManagerExtensions(x509TrustManager);
        }

        @Override // com.baidu.turbonet.net.X509Util.d
        public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, x509CertificateArr, str, str2)) == null) ? this.f23150a.checkServerTrusted(x509CertificateArr, str, str2) : (List) invokeLLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1511302591, "Lcom/baidu/turbonet/net/X509Util;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1511302591, "Lcom/baidu/turbonet/net/X509Util;");
                return;
            }
        }
        j = new Object();
        l = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public X509Util() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void b(byte[] bArr) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bArr) == null) {
            f();
            X509Certificate d2 = d(bArr);
            synchronized (j) {
                KeyStore keyStore = f23144e;
                keyStore.setCertificateEntry("root_cert_" + Integer.toString(f23144e.size()), d2);
                l();
            }
        }
    }

    public static void c() throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, null) == null) {
            f();
            synchronized (j) {
                try {
                    f23144e.load(null);
                    l();
                } catch (IOException unused) {
                }
            }
        }
    }

    public static X509Certificate d(byte[] bArr) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) {
            f();
            return (X509Certificate) f23140a.generateCertificate(new ByteArrayInputStream(bArr));
        }
        return (X509Certificate) invokeL.objValue;
    }

    public static d e(KeyStore keyStore) throws KeyStoreException, NoSuchAlgorithmException {
        InterceptResult invokeL;
        TrustManager[] trustManagers;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, keyStore)) == null) {
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
        return (d) invokeL.objValue;
    }

    public static void f() throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            synchronized (j) {
                g();
            }
        }
    }

    public static void g() throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            if (f23140a == null) {
                f23140a = CertificateFactory.getInstance("X.509");
            }
            if (f23141b == null) {
                f23141b = e(null);
            }
            if (!f23148i) {
                try {
                    KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
                    f23145f = keyStore;
                    try {
                        keyStore.load(null);
                    } catch (IOException unused) {
                    }
                    f23146g = new File(System.getenv("ANDROID_ROOT") + "/etc/security/cacerts");
                } catch (KeyStoreException unused2) {
                }
                if (!k) {
                    nativeRecordCertVerifyCapabilitiesHistogram(f23145f != null);
                }
                f23148i = true;
            }
            if (f23147h == null) {
                f23147h = new HashSet();
            }
            if (f23144e == null) {
                KeyStore keyStore2 = KeyStore.getInstance(KeyStore.getDefaultType());
                f23144e = keyStore2;
                try {
                    keyStore2.load(null);
                } catch (IOException unused3) {
                }
            }
            if (f23143d == null) {
                f23143d = e(f23144e);
            }
            if (k || f23142c != null) {
                return;
            }
            f23142c = new b(null);
            ContextUtils.a().registerReceiver(f23142c, new IntentFilter("android.security.STORAGE_CHANGED"));
        }
    }

    public static String h(X500Principal x500Principal) throws NoSuchAlgorithmException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, x500Principal)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static boolean i(X509Certificate x509Certificate) throws NoSuchAlgorithmException, KeyStoreException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65546, null, x509Certificate)) != null) {
            return invokeL.booleanValue;
        }
        if (f23145f == null) {
            return false;
        }
        Pair<X500Principal, PublicKey> pair = new Pair<>(x509Certificate.getSubjectX500Principal(), x509Certificate.getPublicKey());
        if (f23147h.contains(pair)) {
            return true;
        }
        String h2 = h(x509Certificate.getSubjectX500Principal());
        int i2 = 0;
        while (true) {
            String str = h2 + IStringUtil.EXTENSION_SEPARATOR + i2;
            if (!new File(f23146g, str).exists()) {
                return false;
            }
            Certificate certificate = f23145f.getCertificate("system:" + str);
            if (certificate != null) {
                if (!(certificate instanceof X509Certificate)) {
                    Log.e("X509Util", "Anchor " + str + " not an X509Certificate: " + certificate.getClass().getName());
                } else {
                    X509Certificate x509Certificate2 = (X509Certificate) certificate;
                    if (x509Certificate.getSubjectX500Principal().equals(x509Certificate2.getSubjectX500Principal()) && x509Certificate.getPublicKey().equals(x509Certificate2.getPublicKey())) {
                        f23147h.add(pair);
                        return true;
                    }
                }
            }
            i2++;
        }
    }

    public static boolean j(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, th)) == null) {
            while (th != null) {
                if (th instanceof CertificateNotYetValidException) {
                    return true;
                }
                th = th.getCause();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void k() throws KeyStoreException, NoSuchAlgorithmException, CertificateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            synchronized (j) {
                f23141b = null;
                f23147h = null;
                g();
            }
            nativeNotifyKeyChainChanged();
        }
    }

    public static void l() throws KeyStoreException, NoSuchAlgorithmException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            f23143d = e(f23144e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m(X509Certificate x509Certificate) throws CertificateException {
        InterceptResult invokeL;
        List<String> extendedKeyUsage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, x509Certificate)) == null) {
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
        return invokeL.booleanValue;
    }

    public static AndroidCertVerifyResult n(byte[][] bArr, String str, String str2, int i2) throws KeyStoreException, NoSuchAlgorithmException {
        InterceptResult invokeLLLI;
        List<X509Certificate> emptyList;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65551, null, bArr, str, str2, i2)) == null) {
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
                            if (f23141b == null) {
                                return new AndroidCertVerifyResult(-1);
                            }
                            try {
                                emptyList = f23141b.checkServerTrusted(x509CertificateArr, str, str2);
                            } catch (CertificateException e2) {
                                try {
                                    emptyList = f23143d.checkServerTrusted(x509CertificateArr, str, str2);
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
        return (AndroidCertVerifyResult) invokeLLLI.objValue;
    }

    public static native void nativeNotifyKeyChainChanged();

    public static native void nativeRecordCertVerifyCapabilitiesHistogram(boolean z);
}
