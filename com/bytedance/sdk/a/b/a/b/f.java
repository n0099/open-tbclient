package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.b.h;
import com.bytedance.sdk.a.b.s;
import com.bytedance.sdk.a.b.t;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
/* loaded from: classes4.dex */
public final class f {
    private int f;
    private final com.bytedance.sdk.a.b.a piU;
    private final d piV;
    private final h piW;
    private final t piX;
    private List<Proxy> e = Collections.emptyList();
    private List<InetSocketAddress> g = Collections.emptyList();
    private final List<com.bytedance.sdk.a.b.d> h = new ArrayList();

    public f(com.bytedance.sdk.a.b.a aVar, d dVar, h hVar, t tVar) {
        this.piU = aVar;
        this.piV = dVar;
        this.piW = hVar;
        this.piX = tVar;
        a(aVar.eql(), aVar.eqq());
    }

    public boolean a() {
        return c() || !this.h.isEmpty();
    }

    public a eqB() throws IOException {
        if (!a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (c()) {
            Proxy eqC = eqC();
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                com.bytedance.sdk.a.b.d dVar = new com.bytedance.sdk.a.b.d(this.piU, eqC, this.g.get(i));
                if (this.piV.c(dVar)) {
                    this.h.add(dVar);
                } else {
                    arrayList.add(dVar);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.h);
            this.h.clear();
        }
        return new a(arrayList);
    }

    public void a(com.bytedance.sdk.a.b.d dVar, IOException iOException) {
        if (dVar.ero().type() != Proxy.Type.DIRECT && this.piU.eqp() != null) {
            this.piU.eqp().connectFailed(this.piU.eql().erz(), dVar.ero().address(), iOException);
        }
        this.piV.a(dVar);
    }

    private void a(s sVar, Proxy proxy) {
        List<Proxy> P;
        if (proxy != null) {
            this.e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.piU.eqp().select(sVar.erz());
            if (select != null && !select.isEmpty()) {
                P = com.bytedance.sdk.a.b.a.c.a(select);
            } else {
                P = com.bytedance.sdk.a.b.a.c.P(Proxy.NO_PROXY);
            }
            this.e = P;
        }
        this.f = 0;
    }

    private boolean c() {
        return this.f < this.e.size();
    }

    private Proxy eqC() throws IOException {
        if (!c()) {
            throw new SocketException("No route to " + this.piU.eql().f() + "; exhausted proxy configurations: " + this.e);
        }
        List<Proxy> list = this.e;
        int i = this.f;
        this.f = i + 1;
        Proxy proxy = list.get(i);
        a(proxy);
        return proxy;
    }

    private void a(Proxy proxy) throws IOException {
        String f;
        int g;
        this.g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            f = this.piU.eql().f();
            g = this.piU.eql().g();
        } else {
            SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
            f = a(inetSocketAddress);
            g = inetSocketAddress.getPort();
        }
        if (g < 1 || g > 65535) {
            throw new SocketException("No route to " + f + ":" + g + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.g.add(InetSocketAddress.createUnresolved(f, g));
            return;
        }
        this.piX.a(this.piW, f);
        List<InetAddress> a2 = this.piU.eqm().a(f);
        if (a2.isEmpty()) {
            throw new UnknownHostException(this.piU.eqm() + " returned no addresses for " + f);
        }
        this.piX.a(this.piW, f, a2);
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            this.g.add(new InetSocketAddress(a2.get(i), g));
        }
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<com.bytedance.sdk.a.b.d> f6167a;

        /* renamed from: b  reason: collision with root package name */
        private int f6168b = 0;

        a(List<com.bytedance.sdk.a.b.d> list) {
            this.f6167a = list;
        }

        public boolean a() {
            return this.f6168b < this.f6167a.size();
        }

        public com.bytedance.sdk.a.b.d eqD() {
            if (!a()) {
                throw new NoSuchElementException();
            }
            List<com.bytedance.sdk.a.b.d> list = this.f6167a;
            int i = this.f6168b;
            this.f6168b = i + 1;
            return list.get(i);
        }

        public List<com.bytedance.sdk.a.b.d> c() {
            return new ArrayList(this.f6167a);
        }
    }
}
