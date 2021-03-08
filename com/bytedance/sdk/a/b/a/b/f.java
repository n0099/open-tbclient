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
/* loaded from: classes6.dex */
public final class f {
    private int f;
    private final com.bytedance.sdk.a.b.a prn;
    private final d pro;
    private final h prp;
    private final t prq;
    private List<Proxy> e = Collections.emptyList();
    private List<InetSocketAddress> g = Collections.emptyList();
    private final List<com.bytedance.sdk.a.b.d> h = new ArrayList();

    public f(com.bytedance.sdk.a.b.a aVar, d dVar, h hVar, t tVar) {
        this.prn = aVar;
        this.pro = dVar;
        this.prp = hVar;
        this.prq = tVar;
        a(aVar.eoY(), aVar.epd());
    }

    public boolean a() {
        return c() || !this.h.isEmpty();
    }

    public a epo() throws IOException {
        if (!a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (c()) {
            Proxy epp = epp();
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                com.bytedance.sdk.a.b.d dVar = new com.bytedance.sdk.a.b.d(this.prn, epp, this.g.get(i));
                if (this.pro.c(dVar)) {
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
        if (dVar.eqb().type() != Proxy.Type.DIRECT && this.prn.epc() != null) {
            this.prn.epc().connectFailed(this.prn.eoY().eql(), dVar.eqb().address(), iOException);
        }
        this.pro.a(dVar);
    }

    private void a(s sVar, Proxy proxy) {
        List<Proxy> O;
        if (proxy != null) {
            this.e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.prn.epc().select(sVar.eql());
            if (select != null && !select.isEmpty()) {
                O = com.bytedance.sdk.a.b.a.c.a(select);
            } else {
                O = com.bytedance.sdk.a.b.a.c.O(Proxy.NO_PROXY);
            }
            this.e = O;
        }
        this.f = 0;
    }

    private boolean c() {
        return this.f < this.e.size();
    }

    private Proxy epp() throws IOException {
        if (!c()) {
            throw new SocketException("No route to " + this.prn.eoY().f() + "; exhausted proxy configurations: " + this.e);
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
            f = this.prn.eoY().f();
            g = this.prn.eoY().g();
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
        this.prq.a(this.prp, f);
        List<InetAddress> a2 = this.prn.eoZ().a(f);
        if (a2.isEmpty()) {
            throw new UnknownHostException(this.prn.eoZ() + " returned no addresses for " + f);
        }
        this.prq.a(this.prp, f, a2);
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            this.g.add(new InetSocketAddress(a2.get(i), g));
        }
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<com.bytedance.sdk.a.b.d> f3954a;
        private int b = 0;

        a(List<com.bytedance.sdk.a.b.d> list) {
            this.f3954a = list;
        }

        public boolean a() {
            return this.b < this.f3954a.size();
        }

        public com.bytedance.sdk.a.b.d epq() {
            if (!a()) {
                throw new NoSuchElementException();
            }
            List<com.bytedance.sdk.a.b.d> list = this.f3954a;
            int i = this.b;
            this.b = i + 1;
            return list.get(i);
        }

        public List<com.bytedance.sdk.a.b.d> c() {
            return new ArrayList(this.f3954a);
        }
    }
}
