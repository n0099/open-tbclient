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
/* loaded from: classes4.dex */
public class a extends e {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f6226a;
    private final d<Socket> pkT;
    private final d<Socket> pkU;
    private final d<Socket> pkV;
    private final d<Socket> pkW;
    private final c pkX = c.eqY();

    a(Class<?> cls, d<Socket> dVar, d<Socket> dVar2, d<Socket> dVar3, d<Socket> dVar4) {
        this.f6226a = cls;
        this.pkT = dVar;
        this.pkU = dVar2;
        this.pkV = dVar3;
        this.pkW = dVar4;
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
        Object a3 = a(sSLSocketFactory, this.f6226a, "sslParameters");
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
            this.pkT.c(sSLSocket, true);
            this.pkU.c(sSLSocket, str);
        }
        if (this.pkW != null && this.pkW.a((d<Socket>) sSLSocket)) {
            this.pkW.e(sSLSocket, gH(list));
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public String c(SSLSocket sSLSocket) {
        if (this.pkV != null && this.pkV.a((d<Socket>) sSLSocket)) {
            byte[] bArr = (byte[]) this.pkV.e(sSLSocket, new Object[0]);
            return bArr != null ? new String(bArr, com.bytedance.sdk.a.b.a.c.pjm) : null;
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
        return this.pkX.a(str);
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(String str, Object obj) {
        if (!this.pkX.a(obj)) {
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
            return new C0969a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception e) {
            return super.a(x509TrustManager);
        }
    }

    public static e eqX() {
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
    /* loaded from: classes4.dex */
    static final class C0969a extends com.bytedance.sdk.a.b.a.i.c {

        /* renamed from: a  reason: collision with root package name */
        private final Object f6227a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f6228b;

        C0969a(Object obj, Method method) {
            this.f6227a = obj;
            this.f6228b = method;
        }

        @Override // com.bytedance.sdk.a.b.a.i.c
        public List<Certificate> u(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f6228b.invoke(this.f6227a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), RSAUtil.ALGORITHM_RSA, str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0969a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* loaded from: classes4.dex */
    static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final Method f6231a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f6232b;
        private final Method c;

        c(Method method, Method method2, Method method3) {
            this.f6231a = method;
            this.f6232b = method2;
            this.c = method3;
        }

        Object a(String str) {
            if (this.f6231a != null) {
                try {
                    Object invoke = this.f6231a.invoke(null, new Object[0]);
                    this.f6232b.invoke(invoke, str);
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

        static c eqY() {
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

    /* loaded from: classes4.dex */
    static final class b implements f {

        /* renamed from: a  reason: collision with root package name */
        private final X509TrustManager f6229a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f6230b;

        b(X509TrustManager x509TrustManager, Method method) {
            this.f6230b = method;
            this.f6229a = x509TrustManager;
        }

        @Override // com.bytedance.sdk.a.b.a.i.f
        public X509Certificate b(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f6230b.invoke(this.f6229a, x509Certificate);
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
                return this.f6229a.equals(bVar.f6229a) && this.f6230b.equals(bVar.f6230b);
            }
            return false;
        }

        public int hashCode() {
            return this.f6229a.hashCode() + (this.f6230b.hashCode() * 31);
        }
    }
}
