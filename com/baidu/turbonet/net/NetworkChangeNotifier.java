package com.baidu.turbonet.net;

import android.content.Context;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect;
import d.b.k0.a.b;
import java.util.ArrayList;
import java.util.Iterator;
@JNINamespace
/* loaded from: classes5.dex */
public class NetworkChangeNotifier {

    /* renamed from: h  reason: collision with root package name */
    public static NetworkChangeNotifier f22446h;

    /* renamed from: a  reason: collision with root package name */
    public final Context f22447a;

    /* renamed from: d  reason: collision with root package name */
    public NetworkChangeNotifierAutoDetect f22450d;

    /* renamed from: e  reason: collision with root package name */
    public int f22451e = 0;

    /* renamed from: f  reason: collision with root package name */
    public double f22452f = Double.POSITIVE_INFINITY;

    /* renamed from: g  reason: collision with root package name */
    public int f22453g = 0;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<Long> f22448b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final b<ConnectionTypeObserver> f22449c = new b<>();

    /* loaded from: classes5.dex */
    public interface ConnectionTypeObserver {
        void onConnectionTypeChanged(int i);
    }

    /* loaded from: classes5.dex */
    public class a implements NetworkChangeNotifierAutoDetect.Observer {
        public a() {
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void a(double d2) {
            NetworkChangeNotifier.this.q(d2);
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void b(int i, int i2) {
            NetworkChangeNotifier.this.j(i, i2);
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void c(int i) {
            NetworkChangeNotifier.this.l(i);
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void d(int[] iArr) {
            NetworkChangeNotifier.this.m(iArr);
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void e(int i) {
            NetworkChangeNotifier.this.k(i);
        }

        @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
        public void onConnectionTypeChanged(int i) {
            NetworkChangeNotifier.this.p(i);
        }
    }

    public NetworkChangeNotifier(Context context) {
        this.f22447a = context.getApplicationContext();
    }

    public static NetworkChangeNotifier e() {
        return f22446h;
    }

    public static double f(int i) {
        return nativeGetMaxBandwidthForConnectionSubtype(i);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(int i, int i2) {
        e().h(i2, i);
    }

    @CalledByNative
    public static void fakeMaxBandwidthChanged(double d2) {
        e().i(d2);
    }

    @CalledByNative
    public static void fakeNetworkConnected(int i, int i2) {
        e().j(i, i2);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(int i) {
        e().k(i);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(int i) {
        e().l(i);
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
        if (f22446h == null) {
            f22446h = new NetworkChangeNotifier(context);
        }
        return f22446h;
    }

    public static void n() {
        e().o(true, new RegistrationPolicyAlwaysRegister());
    }

    public static native double nativeGetMaxBandwidthForConnectionSubtype(int i);

    @NativeClassQualifiedName
    private native void nativeNotifyConnectionTypeChanged(long j, int i, int i2);

    @NativeClassQualifiedName
    private native void nativeNotifyMaxBandwidthChanged(long j, double d2);

    @NativeClassQualifiedName
    private native void nativeNotifyOfNetworkConnect(long j, int i, int i2);

    @NativeClassQualifiedName
    private native void nativeNotifyOfNetworkDisconnect(long j, int i);

    @NativeClassQualifiedName
    private native void nativeNotifyOfNetworkSoonToDisconnect(long j, int i);

    @NativeClassQualifiedName
    private native void nativeNotifyPurgeActiveNetworkList(long j, int[] iArr);

    @CalledByNative
    public void addNativeObserver(long j) {
        this.f22448b.add(Long.valueOf(j));
    }

    public final void c() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f22450d;
        if (networkChangeNotifierAutoDetect != null) {
            networkChangeNotifierAutoDetect.destroy();
            this.f22450d = null;
        }
    }

    public final void d(boolean z) {
        if ((this.f22451e != 6) != z) {
            p(z ? 0 : 6);
            q(z ? Double.POSITIVE_INFINITY : 0.0d);
        }
    }

    public void g(int i) {
        h(i, getCurrentDefaultNetId());
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f22450d;
        if (networkChangeNotifierAutoDetect == null) {
            return 0;
        }
        return networkChangeNotifierAutoDetect.getCurrentConnectionSubtype(networkChangeNotifierAutoDetect.getCurrentNetworkState());
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.f22451e;
    }

    @CalledByNative
    public int getCurrentDefaultNetId() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f22450d;
        if (networkChangeNotifierAutoDetect == null) {
            return -1;
        }
        return networkChangeNotifierAutoDetect.getDefaultNetId();
    }

    @CalledByNative
    public double getCurrentMaxBandwidthInMbps() {
        return this.f22452f;
    }

    @CalledByNative
    public int[] getCurrentNetworksAndTypes() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f22450d;
        return networkChangeNotifierAutoDetect == null ? new int[0] : networkChangeNotifierAutoDetect.getNetworksAndTypes();
    }

    public final void h(int i, int i2) {
        Iterator<Long> it = this.f22448b.iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue(), i, i2);
        }
        Iterator<ConnectionTypeObserver> it2 = this.f22449c.iterator();
        while (it2.hasNext()) {
            it2.next().onConnectionTypeChanged(i);
        }
    }

    public void i(double d2) {
        Iterator<Long> it = this.f22448b.iterator();
        while (it.hasNext()) {
            nativeNotifyMaxBandwidthChanged(it.next().longValue(), d2);
        }
    }

    public void j(int i, int i2) {
        Iterator<Long> it = this.f22448b.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), i, i2);
        }
    }

    public void k(int i) {
        Iterator<Long> it = this.f22448b.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), i);
        }
    }

    public void l(int i) {
        Iterator<Long> it = this.f22448b.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), i);
        }
    }

    public void m(int[] iArr) {
        Iterator<Long> it = this.f22448b.iterator();
        while (it.hasNext()) {
            nativeNotifyPurgeActiveNetworkList(it.next().longValue(), iArr);
        }
    }

    public final void o(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (z) {
            if (this.f22450d == null) {
                NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = new NetworkChangeNotifierAutoDetect(new a(), this.f22447a, registrationPolicy);
                this.f22450d = networkChangeNotifierAutoDetect;
                NetworkChangeNotifierAutoDetect.d currentNetworkState = networkChangeNotifierAutoDetect.getCurrentNetworkState();
                p(this.f22450d.getCurrentConnectionType(currentNetworkState));
                q(this.f22450d.getCurrentMaxBandwidthInMbps(currentNetworkState));
                return;
            }
            return;
        }
        c();
    }

    public final void p(int i) {
        this.f22451e = i;
        g(i);
    }

    public final void q(double d2) {
        if (d2 == this.f22452f && this.f22451e == this.f22453g) {
            return;
        }
        this.f22452f = d2;
        this.f22453g = this.f22451e;
        i(d2);
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        this.f22448b.remove(Long.valueOf(j));
    }
}
