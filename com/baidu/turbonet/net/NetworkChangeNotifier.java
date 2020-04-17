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
    private static NetworkChangeNotifier lKH;
    private NetworkChangeNotifierAutoDetect lKE;
    private final Context mContext;
    private int lKF = 0;
    private double lKG = Double.POSITIVE_INFINITY;
    private int mMaxBandwidthConnectionType = this.lKF;
    private final ArrayList<Long> lKC = new ArrayList<>();
    private final com.baidu.turbonet.base.b<ConnectionTypeObserver> lKD = new com.baidu.turbonet.base.b<>();

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
        if (lKH == null) {
            lKH = new NetworkChangeNotifier(context);
        }
        return lKH;
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.lKF;
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        if (this.lKE == null) {
            return 0;
        }
        return this.lKE.getCurrentConnectionSubtype(this.lKE.getCurrentNetworkState());
    }

    @CalledByNative
    public double getCurrentMaxBandwidthInMbps() {
        return this.lKG;
    }

    @CalledByNative
    public int getCurrentDefaultNetId() {
        if (this.lKE == null) {
            return -1;
        }
        return this.lKE.getDefaultNetId();
    }

    @CalledByNative
    public int[] getCurrentNetworksAndTypes() {
        return this.lKE == null ? new int[0] : this.lKE.getNetworksAndTypes();
    }

    public static double Fr(int i) {
        return nativeGetMaxBandwidthForConnectionSubtype(i);
    }

    @CalledByNative
    public void addNativeObserver(long j) {
        this.lKC.add(Long.valueOf(j));
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        this.lKC.remove(Long.valueOf(j));
    }

    public static NetworkChangeNotifier djm() {
        if ($assertionsDisabled || lKH != null) {
            return lKH;
        }
        throw new AssertionError();
    }

    public static void djn() {
        djm().a(true, (NetworkChangeNotifierAutoDetect.RegistrationPolicy) new RegistrationPolicyAlwaysRegister());
    }

    private void djo() {
        if (this.lKE != null) {
            this.lKE.destroy();
            this.lKE = null;
        }
    }

    private void a(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (z) {
            if (this.lKE == null) {
                this.lKE = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifierAutoDetect.Observer() { // from class: com.baidu.turbonet.net.NetworkChangeNotifier.1
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
                NetworkChangeNotifierAutoDetect.c currentNetworkState = this.lKE.getCurrentNetworkState();
                Fs(this.lKE.getCurrentConnectionType(currentNetworkState));
                z(this.lKE.getCurrentMaxBandwidthInMbps(currentNetworkState));
                return;
            }
            return;
        }
        djo();
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        djm().vj(z);
    }

    private void vj(boolean z) {
        if ((this.lKF != 6) != z) {
            Fs(z ? 0 : 6);
            z(z ? Double.POSITIVE_INFINITY : 0.0d);
        }
    }

    @CalledByNative
    public static void fakeNetworkConnected(int i, int i2) {
        djm().dc(i, i2);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(int i) {
        djm().Fu(i);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(int i) {
        djm().Fv(i);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(int[] iArr) {
        djm().k(iArr);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(int i, int i2) {
        djm().db(i2, i);
    }

    @CalledByNative
    public static void fakeMaxBandwidthChanged(double d) {
        djm().A(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fs(int i) {
        this.lKF = i;
        Ft(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(double d) {
        if (d != this.lKG || this.lKF != this.mMaxBandwidthConnectionType) {
            this.lKG = d;
            this.mMaxBandwidthConnectionType = this.lKF;
            A(d);
        }
    }

    void Ft(int i) {
        db(i, getCurrentDefaultNetId());
    }

    private void db(int i, int i2) {
        Iterator<Long> it = this.lKC.iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue(), i, i2);
        }
        Iterator<ConnectionTypeObserver> it2 = this.lKD.iterator();
        while (it2.hasNext()) {
            it2.next().Fw(i);
        }
    }

    void A(double d) {
        Iterator<Long> it = this.lKC.iterator();
        while (it.hasNext()) {
            nativeNotifyMaxBandwidthChanged(it.next().longValue(), d);
        }
    }

    void dc(int i, int i2) {
        Iterator<Long> it = this.lKC.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), i, i2);
        }
    }

    void Fu(int i) {
        Iterator<Long> it = this.lKC.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), i);
        }
    }

    void Fv(int i) {
        Iterator<Long> it = this.lKC.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), i);
        }
    }

    void k(int[] iArr) {
        Iterator<Long> it = this.lKC.iterator();
        while (it.hasNext()) {
            nativeNotifyPurgeActiveNetworkList(it.next().longValue(), iArr);
        }
    }
}
