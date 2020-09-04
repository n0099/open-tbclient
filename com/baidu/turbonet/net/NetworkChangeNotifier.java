package com.baidu.turbonet.net;

import android.content.Context;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect;
import java.util.ArrayList;
import java.util.Iterator;
@JNINamespace
/* loaded from: classes10.dex */
public class NetworkChangeNotifier {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static NetworkChangeNotifier ncA;
    private final Context mContext;
    private NetworkChangeNotifierAutoDetect ncx;
    private int ncy = 0;
    private double ncz = Double.POSITIVE_INFINITY;
    private int mMaxBandwidthConnectionType = this.ncy;
    private final ArrayList<Long> ncv = new ArrayList<>();
    private final com.baidu.turbonet.base.b<ConnectionTypeObserver> ncw = new com.baidu.turbonet.base.b<>();

    /* loaded from: classes10.dex */
    public interface ConnectionTypeObserver {
        void Kn(int i);
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
        if (ncA == null) {
            ncA = new NetworkChangeNotifier(context);
        }
        return ncA;
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.ncy;
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        if (this.ncx == null) {
            return 0;
        }
        return this.ncx.getCurrentConnectionSubtype(this.ncx.getCurrentNetworkState());
    }

    @CalledByNative
    public double getCurrentMaxBandwidthInMbps() {
        return this.ncz;
    }

    @CalledByNative
    public int getCurrentDefaultNetId() {
        if (this.ncx == null) {
            return -1;
        }
        return this.ncx.getDefaultNetId();
    }

    @CalledByNative
    public int[] getCurrentNetworksAndTypes() {
        return this.ncx == null ? new int[0] : this.ncx.getNetworksAndTypes();
    }

    public static double Ki(int i) {
        return nativeGetMaxBandwidthForConnectionSubtype(i);
    }

    @CalledByNative
    public void addNativeObserver(long j) {
        this.ncv.add(Long.valueOf(j));
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        this.ncv.remove(Long.valueOf(j));
    }

    public static NetworkChangeNotifier dKH() {
        if ($assertionsDisabled || ncA != null) {
            return ncA;
        }
        throw new AssertionError();
    }

    public static void dKI() {
        dKH().a(true, (NetworkChangeNotifierAutoDetect.RegistrationPolicy) new RegistrationPolicyAlwaysRegister());
    }

    private void dKJ() {
        if (this.ncx != null) {
            this.ncx.destroy();
            this.ncx = null;
        }
    }

    private void a(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (z) {
            if (this.ncx == null) {
                this.ncx = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifierAutoDetect.Observer() { // from class: com.baidu.turbonet.net.NetworkChangeNotifier.1
                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Kn(int i) {
                        NetworkChangeNotifier.this.Kj(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void J(double d) {
                        NetworkChangeNotifier.this.H(d);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void dB(int i, int i2) {
                        NetworkChangeNotifier.this.dA(i, i2);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Ko(int i) {
                        NetworkChangeNotifier.this.Kl(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Kp(int i) {
                        NetworkChangeNotifier.this.Km(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void m(int[] iArr) {
                        NetworkChangeNotifier.this.l(iArr);
                    }
                }, this.mContext, registrationPolicy);
                NetworkChangeNotifierAutoDetect.c currentNetworkState = this.ncx.getCurrentNetworkState();
                Kj(this.ncx.getCurrentConnectionType(currentNetworkState));
                H(this.ncx.getCurrentMaxBandwidthInMbps(currentNetworkState));
                return;
            }
            return;
        }
        dKJ();
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        dKH().xC(z);
    }

    private void xC(boolean z) {
        if ((this.ncy != 6) != z) {
            Kj(z ? 0 : 6);
            H(z ? Double.POSITIVE_INFINITY : 0.0d);
        }
    }

    @CalledByNative
    public static void fakeNetworkConnected(int i, int i2) {
        dKH().dA(i, i2);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(int i) {
        dKH().Kl(i);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(int i) {
        dKH().Km(i);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(int[] iArr) {
        dKH().l(iArr);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(int i, int i2) {
        dKH().dz(i2, i);
    }

    @CalledByNative
    public static void fakeMaxBandwidthChanged(double d) {
        dKH().I(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kj(int i) {
        this.ncy = i;
        Kk(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(double d) {
        if (d != this.ncz || this.ncy != this.mMaxBandwidthConnectionType) {
            this.ncz = d;
            this.mMaxBandwidthConnectionType = this.ncy;
            I(d);
        }
    }

    void Kk(int i) {
        dz(i, getCurrentDefaultNetId());
    }

    private void dz(int i, int i2) {
        Iterator<Long> it = this.ncv.iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue(), i, i2);
        }
        Iterator<ConnectionTypeObserver> it2 = this.ncw.iterator();
        while (it2.hasNext()) {
            it2.next().Kn(i);
        }
    }

    void I(double d) {
        Iterator<Long> it = this.ncv.iterator();
        while (it.hasNext()) {
            nativeNotifyMaxBandwidthChanged(it.next().longValue(), d);
        }
    }

    void dA(int i, int i2) {
        Iterator<Long> it = this.ncv.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), i, i2);
        }
    }

    void Kl(int i) {
        Iterator<Long> it = this.ncv.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), i);
        }
    }

    void Km(int i) {
        Iterator<Long> it = this.ncv.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), i);
        }
    }

    void l(int[] iArr) {
        Iterator<Long> it = this.ncv.iterator();
        while (it.hasNext()) {
            nativeNotifyPurgeActiveNetworkList(it.next().longValue(), iArr);
        }
    }
}
