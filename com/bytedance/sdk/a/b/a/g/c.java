package com.bytedance.sdk.a.b.a.g;

import com.baidu.searchbox.websocket.WebSocketRequest;
import com.bytedance.sdk.a.b.w;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class c extends e {

    /* renamed from: a  reason: collision with root package name */
    private final Method f5938a;

    /* renamed from: b  reason: collision with root package name */
    private final Method f5939b;
    private final Method c;
    private final Class<?> d;
    private final Class<?> e;

    c(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f5938a = method;
        this.f5939b = method2;
        this.c = method3;
        this.d = cls;
        this.e = cls2;
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        try {
            this.f5938a.invoke(null, sSLSocket, Proxy.newProxyInstance(e.class.getClassLoader(), new Class[]{this.d, this.e}, new a(a(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.a.b.a.c.f("unable to set alpn", e);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void d(SSLSocket sSLSocket) {
        try {
            this.c.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.a.b.a.c.f("unable to remove alpn", e);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public String c(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f5939b.invoke(null, sSLSocket));
            if (aVar.f5940a || aVar.f5941b != null) {
                return aVar.f5940a ? null : aVar.f5941b;
            }
            e.epH().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
            return null;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.a.b.a.c.f("unable to get selected protocol", e);
        }
    }

    public static e epE() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new c(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            return null;
        }
    }

    /* loaded from: classes6.dex */
    private static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        boolean f5940a;

        /* renamed from: b  reason: collision with root package name */
        String f5941b;
        private final List<String> c;

        a(List<String> list) {
            this.c = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = com.bytedance.sdk.a.b.a.c.f5873b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f5940a = true;
                return null;
            } else if (name.equals(WebSocketRequest.PARAM_KEY_PROTOCOLS) && objArr.length == 0) {
                return this.c;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.c.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.f5941b = str;
                            return str;
                        }
                    }
                    String str2 = this.c.get(0);
                    this.f5941b = str2;
                    return str2;
                } else if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                    this.f5941b = (String) objArr[0];
                    return null;
                } else {
                    return method.invoke(this, objArr);
                }
            }
        }
    }
}
