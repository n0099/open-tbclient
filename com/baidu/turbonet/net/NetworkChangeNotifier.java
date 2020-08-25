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
    private static NetworkChangeNotifier nci;
    private final Context mContext;
    private NetworkChangeNotifierAutoDetect ncf;
    private int ncg = 0;
    private double nch = Double.POSITIVE_INFINITY;
    private int mMaxBandwidthConnectionType = this.ncg;
    private final ArrayList<Long> ncd = new ArrayList<>();
    private final com.baidu.turbonet.base.b<ConnectionTypeObserver> nce = new com.baidu.turbonet.base.b<>();

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
        if (nci == null) {
            nci = new NetworkChangeNotifier(context);
        }
        return nci;
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.ncg;
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        if (this.ncf == null) {
            return 0;
        }
        return this.ncf.getCurrentConnectionSubtype(this.ncf.getCurrentNetworkState());
    }

    @CalledByNative
    public double getCurrentMaxBandwidthInMbps() {
        return this.nch;
    }

    @CalledByNative
    public int getCurrentDefaultNetId() {
        if (this.ncf == null) {
            return -1;
        }
        return this.ncf.getDefaultNetId();
    }

    @CalledByNative
    public int[] getCurrentNetworksAndTypes() {
        return this.ncf == null ? new int[0] : this.ncf.getNetworksAndTypes();
    }

    public static double Ki(int i) {
        return nativeGetMaxBandwidthForConnectionSubtype(i);
    }

    @CalledByNative
    public void addNativeObserver(long j) {
        this.ncd.add(Long.valueOf(j));
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        this.ncd.remove(Long.valueOf(j));
    }

    public static NetworkChangeNotifier dKy() {
        if ($assertionsDisabled || nci != null) {
            return nci;
        }
        throw new AssertionError();
    }

    public static void dKz() {
        dKy().a(true, (NetworkChangeNotifierAutoDetect.RegistrationPolicy) new RegistrationPolicyAlwaysRegister());
    }

    private void dKA() {
        if (this.ncf != null) {
            this.ncf.destroy();
            this.ncf = null;
        }
    }

    private void a(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (z) {
            if (this.ncf == null) {
                this.ncf = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifierAutoDetect.Observer() { // from class: com.baidu.turbonet.net.NetworkChangeNotifier.1
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
                NetworkChangeNotifierAutoDetect.c currentNetworkState = this.ncf.getCurrentNetworkState();
                Kj(this.ncf.getCurrentConnectionType(currentNetworkState));
                H(this.ncf.getCurrentMaxBandwidthInMbps(currentNetworkState));
                return;
            }
            return;
        }
        dKA();
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        dKy().xA(z);
    }

    private void xA(boolean z) {
        if ((this.ncg != 6) != z) {
            Kj(z ? 0 : 6);
            H(z ? Double.POSITIVE_INFINITY : 0.0d);
        }
    }

    @CalledByNative
    public static void fakeNetworkConnected(int i, int i2) {
        dKy().dA(i, i2);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(int i) {
        dKy().Kl(i);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(int i) {
        dKy().Km(i);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(int[] iArr) {
        dKy().l(iArr);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(int i, int i2) {
        dKy().dz(i2, i);
    }

    @CalledByNative
    public static void fakeMaxBandwidthChanged(double d) {
        dKy().I(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kj(int i) {
        this.ncg = i;
        Kk(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(double d) {
        if (d != this.nch || this.ncg != this.mMaxBandwidthConnectionType) {
            this.nch = d;
            this.mMaxBandwidthConnectionType = this.ncg;
            I(d);
        }
    }

    void Kk(int i) {
        dz(i, getCurrentDefaultNetId());
    }

    private void dz(int i, int i2) {
        Iterator<Long> it = this.ncd.iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue(), i, i2);
        }
        Iterator<ConnectionTypeObserver> it2 = this.nce.iterator();
        while (it2.hasNext()) {
            it2.next().Kn(i);
        }
    }

    void I(double d) {
        Iterator<Long> it = this.ncd.iterator();
        while (it.hasNext()) {
            nativeNotifyMaxBandwidthChanged(it.next().longValue(), d);
        }
    }

    void dA(int i, int i2) {
        Iterator<Long> it = this.ncd.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), i, i2);
        }
    }

    void Kl(int i) {
        Iterator<Long> it = this.ncd.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), i);
        }
    }

    void Km(int i) {
        Iterator<Long> it = this.ncd.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), i);
        }
    }

    void l(int[] iArr) {
        Iterator<Long> it = this.ncd.iterator();
        while (it.hasNext()) {
            nativeNotifyPurgeActiveNetworkList(it.next().longValue(), iArr);
        }
    }
}
