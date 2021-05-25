package com.baidu.turbonet.net;

import android.content.Context;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect;
import d.a.o0.a.b;
import java.util.ArrayList;
import java.util.Iterator;
@JNINamespace
/* loaded from: classes5.dex */
public class NetworkChangeNotifier {

    /* renamed from: h  reason: collision with root package name */
    public static NetworkChangeNotifier f22316h;

    /* renamed from: a  reason: collision with root package name */
    public final Context f22317a;

    /* renamed from: d  reason: collision with root package name */
    public NetworkChangeNotifierAutoDetect f22320d;

    /* renamed from: e  reason: collision with root package name */
    public int f22321e = 0;

    /* renamed from: f  reason: collision with root package name */
    public double f22322f = Double.POSITIVE_INFINITY;

    /* renamed from: g  reason: collision with root package name */
    public int f22323g = 0;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<Long> f22318b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final b<ConnectionTypeObserver> f22319c = new b<>();

    /* loaded from: classes5.dex */
    public interface ConnectionTypeObserver {
        void a(int i2);
    }

    /* loaded from: classes5.dex */
    public class a implements NetworkChangeNotifierAutoDetect.Observer {
        public a() {
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void a(int i2) {
            NetworkChangeNotifier.this.p(i2);
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void b(double d2) {
            NetworkChangeNotifier.this.q(d2);
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void c(int i2) {
            NetworkChangeNotifier.this.l(i2);
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void d(int i2) {
            NetworkChangeNotifier.this.k(i2);
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void e(int i2, int i3) {
            NetworkChangeNotifier.this.j(i2, i3);
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void f(int[] iArr) {
            NetworkChangeNotifier.this.m(iArr);
        }
    }

    public NetworkChangeNotifier(Context context) {
        this.f22317a = context.getApplicationContext();
    }

    public static NetworkChangeNotifier e() {
        return f22316h;
    }

    public static double f(int i2) {
        return nativeGetMaxBandwidthForConnectionSubtype(i2);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(int i2, int i3) {
        e().h(i3, i2);
    }

    @CalledByNative
    public static void fakeMaxBandwidthChanged(double d2) {
        e().i(d2);
    }

    @CalledByNative
    public static void fakeNetworkConnected(int i2, int i3) {
        e().j(i2, i3);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(int i2) {
        e().k(i2);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(int i2) {
        e().l(i2);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(int[] iArr) {
        e().m(iArr);
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        e().d(z);
    }

    @CalledByNative
    public static NetworkChangeNotifier init(Context context) {
        if (f22316h == null) {
            f22316h = new NetworkChangeNotifier(context);
        }
        return f22316h;
    }

    public static void n() {
        e().o(true, new RegistrationPolicyAlwaysRegister());
    }

    public static native double nativeGetMaxBandwidthForConnectionSubtype(int i2);

    @NativeClassQualifiedName
    private native void nativeNotifyConnectionTypeChanged(long j, int i2, int i3);

    @NativeClassQualifiedName
    private native void nativeNotifyMaxBandwidthChanged(long j, double d2);

    @NativeClassQualifiedName
    private native void nativeNotifyOfNetworkConnect(long j, int i2, int i3);

    @NativeClassQualifiedName
    private native void nativeNotifyOfNetworkDisconnect(long j, int i2);

    @NativeClassQualifiedName
    private native void nativeNotifyOfNetworkSoonToDisconnect(long j, int i2);

    @NativeClassQualifiedName
    private native void nativeNotifyPurgeActiveNetworkList(long j, int[] iArr);

    @CalledByNative
    public void addNativeObserver(long j) {
        this.f22318b.add(Long.valueOf(j));
    }

    public final void c() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f22320d;
        if (networkChangeNotifierAutoDetect != null) {
            networkChangeNotifierAutoDetect.destroy();
            this.f22320d = null;
        }
    }

    public final void d(boolean z) {
        if ((this.f22321e != 6) != z) {
            p(z ? 0 : 6);
            q(z ? Double.POSITIVE_INFINITY : 0.0d);
        }
    }

    public void g(int i2) {
        h(i2, getCurrentDefaultNetId());
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f22320d;
        if (networkChangeNotifierAutoDetect == null) {
            return 0;
        }
        return networkChangeNotifierAutoDetect.getCurrentConnectionSubtype(networkChangeNotifierAutoDetect.getCurrentNetworkState());
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.f22321e;
    }

    @CalledByNative
    public int getCurrentDefaultNetId() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f22320d;
        if (networkChangeNotifierAutoDetect == null) {
            return -1;
        }
        return networkChangeNotifierAutoDetect.getDefaultNetId();
    }

    @CalledByNative
    public double getCurrentMaxBandwidthInMbps() {
        return this.f22322f;
    }

    @CalledByNative
    public int[] getCurrentNetworksAndTypes() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f22320d;
        return networkChangeNotifierAutoDetect == null ? new int[0] : networkChangeNotifierAutoDetect.getNetworksAndTypes();
    }

    public final void h(int i2, int i3) {
        Iterator<Long> it = this.f22318b.iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue(), i2, i3);
        }
        Iterator<ConnectionTypeObserver> it2 = this.f22319c.iterator();
        while (it2.hasNext()) {
            it2.next().a(i2);
        }
    }

    public void i(double d2) {
        Iterator<Long> it = this.f22318b.iterator();
        while (it.hasNext()) {
            nativeNotifyMaxBandwidthChanged(it.next().longValue(), d2);
        }
    }

    public void j(int i2, int i3) {
        Iterator<Long> it = this.f22318b.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), i2, i3);
        }
    }

    public void k(int i2) {
        Iterator<Long> it = this.f22318b.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), i2);
        }
    }

    public void l(int i2) {
        Iterator<Long> it = this.f22318b.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), i2);
        }
    }

    public void m(int[] iArr) {
        Iterator<Long> it = this.f22318b.iterator();
        while (it.hasNext()) {
            nativeNotifyPurgeActiveNetworkList(it.next().longValue(), iArr);
        }
    }

    public final void o(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (z) {
            if (this.f22320d == null) {
                NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = new NetworkChangeNotifierAutoDetect(new a(), this.f22317a, registrationPolicy);
                this.f22320d = networkChangeNotifierAutoDetect;
                NetworkChangeNotifierAutoDetect.d currentNetworkState = networkChangeNotifierAutoDetect.getCurrentNetworkState();
                p(this.f22320d.getCurrentConnectionType(currentNetworkState));
                q(this.f22320d.getCurrentMaxBandwidthInMbps(currentNetworkState));
                return;
            }
            return;
        }
        c();
    }

    public final void p(int i2) {
        this.f22321e = i2;
        g(i2);
    }

    public final void q(double d2) {
        if (d2 == this.f22322f && this.f22321e == this.f22323g) {
            return;
        }
        this.f22322f = d2;
        this.f22323g = this.f22321e;
        i(d2);
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        this.f22318b.remove(Long.valueOf(j));
    }
}
