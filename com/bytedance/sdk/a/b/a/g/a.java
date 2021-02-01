package com.bytedance.sdk.a.b.a.g;

import android.os.Build;
import android.util.Log;
import com.baidu.android.common.security.RSAUtil;
import com.bytedance.sdk.a.b.a.i.f;
import com.bytedance.sdk.a.b.w;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class a extends e {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f5929a;
    private final d<Socket> pqG;
    private final d<Socket> pqH;
    private final d<Socket> pqI;
    private final d<Socket> pqJ;
    private final c pqK = c.epx();

    a(Class<?> cls, d<Socket> dVar, d<Socket> dVar2, d<Socket> dVar3, d<Socket> dVar4) {
        this.f5929a = cls;
        this.pqG = dVar;
        this.pqH = dVar2;
        this.pqI = dVar3;
        this.pqJ = dVar4;
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!com.bytedance.sdk.a.b.a.c.a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e2);
                throw iOException;
            }
            throw e2;
        } catch (SecurityException e3) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e3);
            throw iOException2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.a.b.a.g.e
    public X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
        Object a2;
        Object a3 = a(sSLSocketFactory, this.f5929a, "sslParameters");
        if (a3 == null) {
            try {
                a2 = a(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException e) {
                return super.a(sSLSocketFactory);
            }
        } else {
            a2 = a3;
        }
        X509TrustManager x509TrustManager = (X509TrustManager) a(a2, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (X509TrustManager) a(a2, X509TrustManager.class, "trustManager");
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        if (str != null) {
            this.pqG.c(sSLSocket, true);
            this.pqH.c(sSLSocket, str);
        }
        if (this.pqJ != null && this.pqJ.a((d<Socket>) sSLSocket)) {
            this.pqJ.e(sSLSocket, gF(list));
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public String c(SSLSocket sSLSocket) {
        if (this.pqI != null && this.pqI.a((d<Socket>) sSLSocket)) {
            byte[] bArr = (byte[]) this.pqI.e(sSLSocket, new Object[0]);
            return bArr != null ? new String(bArr, com.bytedance.sdk.a.b.a.c.poY) : null;
        }
        return null;
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(int i, String str, Throwable th) {
        int min;
        int i2 = i == 5 ? 5 : 3;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public Object a(String str) {
        return this.pqK.a(str);
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(String str, Object obj) {
        if (!this.pqK.a(obj)) {
            a(5, str, (Throwable) null);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public boolean b(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return a(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException e) {
            return super.b(str);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw com.bytedance.sdk.a.b.a.c.f("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e3) {
            e = e3;
            throw com.bytedance.sdk.a.b.a.c.f("unable to determine cleartext support", e);
        } catch (NoSuchMethodException e4) {
            return super.b(str);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw com.bytedance.sdk.a.b.a.c.f("unable to determine cleartext support", e);
        }
    }

    private boolean a(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException e) {
            return b(str, cls, obj);
        }
    }

    private boolean b(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException e) {
            return super.b(str);
        }
    }

    private static boolean c() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public com.bytedance.sdk.a.b.a.i.c a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0994a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception e) {
            return super.a(x509TrustManager);
        }
    }

    public static e epw() {
        Class<?> cls;
        d dVar;
        d dVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException e) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            d dVar3 = new d(null, "setUseSessionTickets", Boolean.TYPE);
            d dVar4 = new d(null, "setHostname", String.class);
            if (c()) {
                dVar2 = new d(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                dVar = new d(null, "setAlpnProtocols", byte[].class);
            } else {
                dVar = null;
                dVar2 = null;
            }
            return new a(cls, dVar3, dVar4, dVar2, dVar);
        } catch (ClassNotFoundException e2) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public f b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException e) {
            return super.b(x509TrustManager);
        }
    }

    /* renamed from: com.bytedance.sdk.a.b.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C0994a extends com.bytedance.sdk.a.b.a.i.c {

        /* renamed from: a  reason: collision with root package name */
        private final Object f5930a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f5931b;

        C0994a(Object obj, Method method) {
            this.f5930a = obj;
            this.f5931b = method;
        }

        @Override // com.bytedance.sdk.a.b.a.i.c
        public List<Certificate> s(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f5931b.invoke(this.f5930a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), RSAUtil.ALGORITHM_RSA, str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0994a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* loaded from: classes6.dex */
    static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final Method f5934a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f5935b;
        private final Method c;

        c(Method method, Method method2, Method method3) {
            this.f5934a = method;
            this.f5935b = method2;
            this.c = method3;
        }

        Object a(String str) {
            if (this.f5934a != null) {
                try {
                    Object invoke = this.f5934a.invoke(null, new Object[0]);
                    this.f5935b.invoke(invoke, str);
                    return invoke;
                } catch (Exception e) {
                }
            }
            return null;
        }

        boolean a(Object obj) {
            if (obj != null) {
                try {
                    this.c.invoke(obj, new Object[0]);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
            return false;
        }

        static c epx() {
            Method method;
            Method method2;
            Method method3;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                method3 = cls.getMethod("get", new Class[0]);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
            } catch (Exception e) {
                method = null;
                method2 = null;
                method3 = null;
            }
            return new c(method3, method2, method);
        }
    }

    /* loaded from: classes6.dex */
    static final class b implements f {

        /* renamed from: a  reason: collision with root package name */
        private final X509TrustManager f5932a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f5933b;

        b(X509TrustManager x509TrustManager, Method method) {
            this.f5933b = method;
            this.f5932a = x509TrustManager;
        }

        @Override // com.bytedance.sdk.a.b.a.i.f
        public X509Certificate b(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f5933b.invoke(this.f5932a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e) {
                throw com.bytedance.sdk.a.b.a.c.f("unable to get issues and signature", e);
            } catch (InvocationTargetException e2) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.f5932a.equals(bVar.f5932a) && this.f5933b.equals(bVar.f5933b);
            }
            return false;
        }

        public int hashCode() {
            return this.f5932a.hashCode() + (this.f5933b.hashCode() * 31);
        }
    }
}
