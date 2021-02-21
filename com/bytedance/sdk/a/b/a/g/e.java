package com.bytedance.sdk.a.b.a.g;

import com.bytedance.sdk.a.b.a.i.f;
import com.bytedance.sdk.a.b.w;
import com.bytedance.sdk.a.b.z;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes6.dex */
public class e {
    private static final e prl = epE();
    private static final Logger pqY = Logger.getLogger(z.class.getName());

    public static e epH() {
        return prl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
        try {
            Object a2 = a(sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (a2 == null) {
                return null;
            }
            return (X509TrustManager) a(a2, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public void a(SSLSocket sSLSocket, String str, List<w> list) {
    }

    public void d(SSLSocket sSLSocket) {
    }

    public String c(SSLSocket sSLSocket) {
        return null;
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void a(int i, String str, Throwable th) {
        pqY.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public boolean b(String str) {
        return true;
    }

    public Object a(String str) {
        if (pqY.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str, (Throwable) obj);
    }

    public static List<String> a(List<w> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            w wVar = list.get(i);
            if (wVar != w.HTTP_1_0) {
                arrayList.add(wVar.toString());
            }
        }
        return arrayList;
    }

    public com.bytedance.sdk.a.b.a.i.c a(X509TrustManager x509TrustManager) {
        return new com.bytedance.sdk.a.b.a.i.a(b(x509TrustManager));
    }

    public com.bytedance.sdk.a.b.a.i.c b(SSLSocketFactory sSLSocketFactory) {
        X509TrustManager a2 = a(sSLSocketFactory);
        if (a2 == null) {
            throw new IllegalStateException("Unable to extract the trust manager on " + epH() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
        }
        return a(a2);
    }

    private static e epE() {
        e epE = a.epE();
        if (epE == null) {
            b epG = b.epG();
            if (epG == null) {
                e epE2 = c.epE();
                return epE2 == null ? new e() : epE2;
            }
            return epG;
        }
        return epE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] gF(List<w> list) {
        com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            w wVar = list.get(i);
            if (wVar != w.HTTP_1_0) {
                cVar.OB(wVar.toString().length());
                cVar.YM(wVar.toString());
            }
        }
        return cVar.q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(Object obj, Class<T> cls, String str) {
        Object a2;
        for (Class<?> cls2 = obj.getClass(); cls2 != Object.class; cls2 = cls2.getSuperclass()) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (obj2 == null || !cls.isInstance(obj2)) {
                    return null;
                }
                return cls.cast(obj2);
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (NoSuchFieldException e2) {
            }
        }
        if (str.equals("delegate") || (a2 = a(obj, Object.class, "delegate")) == null) {
            return null;
        }
        return (T) a(a2, cls, str);
    }

    public f b(X509TrustManager x509TrustManager) {
        return new com.bytedance.sdk.a.b.a.i.b(x509TrustManager.getAcceptedIssuers());
    }
}
