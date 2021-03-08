package com.bytedance.sdk.a.b.a.g;

import com.bytedance.sdk.a.b.a.i.f;
import com.bytedance.sdk.a.b.w;
import com.bytedance.sdk.a.b.z;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes6.dex */
public class e {
    private static final e ptq = epL();
    private static final Logger ptd = Logger.getLogger(z.class.getName());

    public static e epO() {
        return ptq;
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
        ptd.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public boolean b(String str) {
        return true;
    }

    public Object a(String str) {
        if (ptd.isLoggable(Level.FINE)) {
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

    private static e epL() {
        e epL = a.epL();
        if (epL == null) {
            b epN = b.epN();
            if (epN == null) {
                e epL2 = c.epL();
                return epL2 == null ? new e() : epL2;
            }
            return epN;
        }
        return epL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] gF(List<w> list) {
        com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            w wVar = list.get(i);
            if (wVar != w.HTTP_1_0) {
                cVar.OF(wVar.toString().length());
                cVar.YT(wVar.toString());
            }
        }
        return cVar.q();
    }

    public f b(X509TrustManager x509TrustManager) {
        return new com.bytedance.sdk.a.b.a.i.b(x509TrustManager.getAcceptedIssuers());
    }
}
