package com.baidu.turbonet.net;

import android.content.Context;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect;
import java.util.ArrayList;
import java.util.Iterator;
@JNINamespace
/* loaded from: classes.dex */
public class NetworkChangeNotifier {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static NetworkChangeNotifier lKL;
    private NetworkChangeNotifierAutoDetect lKI;
    private final Context mContext;
    private int lKJ = 0;
    private double lKK = Double.POSITIVE_INFINITY;
    private int mMaxBandwidthConnectionType = this.lKJ;
    private final ArrayList<Long> lKG = new ArrayList<>();
    private final com.baidu.turbonet.base.b<ConnectionTypeObserver> lKH = new com.baidu.turbonet.base.b<>();

    /* loaded from: classes.dex */
    public interface ConnectionTypeObserver {
        void Fw(int i);
    }

    private static native double nativeGetMaxBandwidthForConnectionSubtype(int i);

    @NativeClassQualifiedName
    private native void nativeNotifyConnectionTypeChanged(long j, int i, int i2);

    @NativeClassQualifiedName
    private native void nativeNotifyMaxBandwidthChanged(long j, double d);

    @NativeClassQualifiedName
    private native void nativeNotifyOfNetworkConnect(long j, int i, int i2);

    @NativeClassQualifiedName
    private native void nativeNotifyOfNetworkDisconnect(long j, int i);

    @NativeClassQualifiedName
    private native void nativeNotifyOfNetworkSoonToDisconnect(long j, int i);

    @NativeClassQualifiedName
    private native void nativeNotifyPurgeActiveNetworkList(long j, int[] iArr);

    static {
        $assertionsDisabled = !NetworkChangeNotifier.class.desiredAssertionStatus();
    }

    protected NetworkChangeNotifier(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @CalledByNative
    public static NetworkChangeNotifier init(Context context) {
        if (lKL == null) {
            lKL = new NetworkChangeNotifier(context);
        }
        return lKL;
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.lKJ;
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        if (this.lKI == null) {
            return 0;
        }
        return this.lKI.getCurrentConnectionSubtype(this.lKI.getCurrentNetworkState());
    }

    @CalledByNative
    public double getCurrentMaxBandwidthInMbps() {
        return this.lKK;
    }

    @CalledByNative
    public int getCurrentDefaultNetId() {
        if (this.lKI == null) {
            return -1;
        }
        return this.lKI.getDefaultNetId();
    }

    @CalledByNative
    public int[] getCurrentNetworksAndTypes() {
        return this.lKI == null ? new int[0] : this.lKI.getNetworksAndTypes();
    }

    public static double Fr(int i) {
        return nativeGetMaxBandwidthForConnectionSubtype(i);
    }

    @CalledByNative
    public void addNativeObserver(long j) {
        this.lKG.add(Long.valueOf(j));
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        this.lKG.remove(Long.valueOf(j));
    }

    public static NetworkChangeNotifier djk() {
        if ($assertionsDisabled || lKL != null) {
            return lKL;
        }
        throw new AssertionError();
    }

    public static void djl() {
        djk().a(true, (NetworkChangeNotifierAutoDetect.RegistrationPolicy) new RegistrationPolicyAlwaysRegister());
    }

    private void djm() {
        if (this.lKI != null) {
            this.lKI.destroy();
            this.lKI = null;
        }
    }

    private void a(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (z) {
            if (this.lKI == null) {
                this.lKI = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifierAutoDetect.Observer() { // from class: com.baidu.turbonet.net.NetworkChangeNotifier.1
                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Fw(int i) {
                        NetworkChangeNotifier.this.Fs(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void B(double d) {
                        NetworkChangeNotifier.this.z(d);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void dd(int i, int i2) {
                        NetworkChangeNotifier.this.dc(i, i2);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Fx(int i) {
                        NetworkChangeNotifier.this.Fu(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Fy(int i) {
                        NetworkChangeNotifier.this.Fv(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void l(int[] iArr) {
                        NetworkChangeNotifier.this.k(iArr);
                    }
                }, this.mContext, registrationPolicy);
                NetworkChangeNotifierAutoDetect.c currentNetworkState = this.lKI.getCurrentNetworkState();
                Fs(this.lKI.getCurrentConnectionType(currentNetworkState));
                z(this.lKI.getCurrentMaxBandwidthInMbps(currentNetworkState));
                return;
            }
            return;
        }
        djm();
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        djk().vj(z);
    }

    private void vj(boolean z) {
        if ((this.lKJ != 6) != z) {
            Fs(z ? 0 : 6);
            z(z ? Double.POSITIVE_INFINITY : 0.0d);
        }
    }

    @CalledByNative
    public static void fakeNetworkConnected(int i, int i2) {
        djk().dc(i, i2);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(int i) {
        djk().Fu(i);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(int i) {
        djk().Fv(i);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(int[] iArr) {
        djk().k(iArr);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(int i, int i2) {
        djk().db(i2, i);
    }

    @CalledByNative
    public static void fakeMaxBandwidthChanged(double d) {
        djk().A(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fs(int i) {
        this.lKJ = i;
        Ft(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(double d) {
        if (d != this.lKK || this.lKJ != this.mMaxBandwidthConnectionType) {
            this.lKK = d;
            this.mMaxBandwidthConnectionType = this.lKJ;
            A(d);
        }
    }

    void Ft(int i) {
        db(i, getCurrentDefaultNetId());
    }

    private void db(int i, int i2) {
        Iterator<Long> it = this.lKG.iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue(), i, i2);
        }
        Iterator<ConnectionTypeObserver> it2 = this.lKH.iterator();
        while (it2.hasNext()) {
            it2.next().Fw(i);
        }
    }

    void A(double d) {
        Iterator<Long> it = this.lKG.iterator();
        while (it.hasNext()) {
            nativeNotifyMaxBandwidthChanged(it.next().longValue(), d);
        }
    }

    void dc(int i, int i2) {
        Iterator<Long> it = this.lKG.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), i, i2);
        }
    }

    void Fu(int i) {
        Iterator<Long> it = this.lKG.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), i);
        }
    }

    void Fv(int i) {
        Iterator<Long> it = this.lKG.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), i);
        }
    }

    void k(int[] iArr) {
        Iterator<Long> it = this.lKG.iterator();
        while (it.hasNext()) {
            nativeNotifyPurgeActiveNetworkList(it.next().longValue(), iArr);
        }
    }
}
