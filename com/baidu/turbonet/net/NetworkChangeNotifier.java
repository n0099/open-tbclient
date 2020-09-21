package com.baidu.turbonet.net;

import android.content.Context;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect;
import java.util.ArrayList;
import java.util.Iterator;
@JNINamespace
/* loaded from: classes15.dex */
public class NetworkChangeNotifier {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static NetworkChangeNotifier nmz;
    private final Context mContext;
    private NetworkChangeNotifierAutoDetect nmw;
    private int nmx = 0;
    private double nmy = Double.POSITIVE_INFINITY;
    private int mMaxBandwidthConnectionType = this.nmx;
    private final ArrayList<Long> nmu = new ArrayList<>();
    private final com.baidu.turbonet.base.b<ConnectionTypeObserver> nmv = new com.baidu.turbonet.base.b<>();

    /* loaded from: classes15.dex */
    public interface ConnectionTypeObserver {
        void KS(int i);
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
        if (nmz == null) {
            nmz = new NetworkChangeNotifier(context);
        }
        return nmz;
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.nmx;
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        if (this.nmw == null) {
            return 0;
        }
        return this.nmw.getCurrentConnectionSubtype(this.nmw.getCurrentNetworkState());
    }

    @CalledByNative
    public double getCurrentMaxBandwidthInMbps() {
        return this.nmy;
    }

    @CalledByNative
    public int getCurrentDefaultNetId() {
        if (this.nmw == null) {
            return -1;
        }
        return this.nmw.getDefaultNetId();
    }

    @CalledByNative
    public int[] getCurrentNetworksAndTypes() {
        return this.nmw == null ? new int[0] : this.nmw.getNetworksAndTypes();
    }

    public static double KN(int i) {
        return nativeGetMaxBandwidthForConnectionSubtype(i);
    }

    @CalledByNative
    public void addNativeObserver(long j) {
        this.nmu.add(Long.valueOf(j));
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        this.nmu.remove(Long.valueOf(j));
    }

    public static NetworkChangeNotifier dOF() {
        if ($assertionsDisabled || nmz != null) {
            return nmz;
        }
        throw new AssertionError();
    }

    public static void dOG() {
        dOF().a(true, (NetworkChangeNotifierAutoDetect.RegistrationPolicy) new RegistrationPolicyAlwaysRegister());
    }

    private void dOH() {
        if (this.nmw != null) {
            this.nmw.destroy();
            this.nmw = null;
        }
    }

    private void a(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (z) {
            if (this.nmw == null) {
                this.nmw = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifierAutoDetect.Observer() { // from class: com.baidu.turbonet.net.NetworkChangeNotifier.1
                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void KS(int i) {
                        NetworkChangeNotifier.this.KO(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void J(double d) {
                        NetworkChangeNotifier.this.H(d);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void dF(int i, int i2) {
                        NetworkChangeNotifier.this.dE(i, i2);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void KT(int i) {
                        NetworkChangeNotifier.this.KQ(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void KU(int i) {
                        NetworkChangeNotifier.this.KR(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void m(int[] iArr) {
                        NetworkChangeNotifier.this.l(iArr);
                    }
                }, this.mContext, registrationPolicy);
                NetworkChangeNotifierAutoDetect.c currentNetworkState = this.nmw.getCurrentNetworkState();
                KO(this.nmw.getCurrentConnectionType(currentNetworkState));
                H(this.nmw.getCurrentMaxBandwidthInMbps(currentNetworkState));
                return;
            }
            return;
        }
        dOH();
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        dOF().xL(z);
    }

    private void xL(boolean z) {
        if ((this.nmx != 6) != z) {
            KO(z ? 0 : 6);
            H(z ? Double.POSITIVE_INFINITY : 0.0d);
        }
    }

    @CalledByNative
    public static void fakeNetworkConnected(int i, int i2) {
        dOF().dE(i, i2);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(int i) {
        dOF().KQ(i);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(int i) {
        dOF().KR(i);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(int[] iArr) {
        dOF().l(iArr);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(int i, int i2) {
        dOF().dD(i2, i);
    }

    @CalledByNative
    public static void fakeMaxBandwidthChanged(double d) {
        dOF().I(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KO(int i) {
        this.nmx = i;
        KP(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(double d) {
        if (d != this.nmy || this.nmx != this.mMaxBandwidthConnectionType) {
            this.nmy = d;
            this.mMaxBandwidthConnectionType = this.nmx;
            I(d);
        }
    }

    void KP(int i) {
        dD(i, getCurrentDefaultNetId());
    }

    private void dD(int i, int i2) {
        Iterator<Long> it = this.nmu.iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue(), i, i2);
        }
        Iterator<ConnectionTypeObserver> it2 = this.nmv.iterator();
        while (it2.hasNext()) {
            it2.next().KS(i);
        }
    }

    void I(double d) {
        Iterator<Long> it = this.nmu.iterator();
        while (it.hasNext()) {
            nativeNotifyMaxBandwidthChanged(it.next().longValue(), d);
        }
    }

    void dE(int i, int i2) {
        Iterator<Long> it = this.nmu.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), i, i2);
        }
    }

    void KQ(int i) {
        Iterator<Long> it = this.nmu.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), i);
        }
    }

    void KR(int i) {
        Iterator<Long> it = this.nmu.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), i);
        }
    }

    void l(int[] iArr) {
        Iterator<Long> it = this.nmu.iterator();
        while (it.hasNext()) {
            nativeNotifyPurgeActiveNetworkList(it.next().longValue(), iArr);
        }
    }
}
