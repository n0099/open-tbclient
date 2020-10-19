package com.baidu.turbonet.net;

import android.content.Context;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect;
import java.util.ArrayList;
import java.util.Iterator;
@JNINamespace
/* loaded from: classes17.dex */
public class NetworkChangeNotifier {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static NetworkChangeNotifier nBW;
    private final Context mContext;
    private NetworkChangeNotifierAutoDetect nBT;
    private int nBU = 0;
    private double nBV = Double.POSITIVE_INFINITY;
    private int mMaxBandwidthConnectionType = this.nBU;
    private final ArrayList<Long> nBR = new ArrayList<>();
    private final com.baidu.turbonet.base.b<ConnectionTypeObserver> nBS = new com.baidu.turbonet.base.b<>();

    /* loaded from: classes17.dex */
    public interface ConnectionTypeObserver {
        void Ly(int i);
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
        if (nBW == null) {
            nBW = new NetworkChangeNotifier(context);
        }
        return nBW;
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.nBU;
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        if (this.nBT == null) {
            return 0;
        }
        return this.nBT.getCurrentConnectionSubtype(this.nBT.getCurrentNetworkState());
    }

    @CalledByNative
    public double getCurrentMaxBandwidthInMbps() {
        return this.nBV;
    }

    @CalledByNative
    public int getCurrentDefaultNetId() {
        if (this.nBT == null) {
            return -1;
        }
        return this.nBT.getDefaultNetId();
    }

    @CalledByNative
    public int[] getCurrentNetworksAndTypes() {
        return this.nBT == null ? new int[0] : this.nBT.getNetworksAndTypes();
    }

    public static double Lt(int i) {
        return nativeGetMaxBandwidthForConnectionSubtype(i);
    }

    @CalledByNative
    public void addNativeObserver(long j) {
        this.nBR.add(Long.valueOf(j));
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        this.nBR.remove(Long.valueOf(j));
    }

    public static NetworkChangeNotifier dSr() {
        if ($assertionsDisabled || nBW != null) {
            return nBW;
        }
        throw new AssertionError();
    }

    public static void dSs() {
        dSr().a(true, (NetworkChangeNotifierAutoDetect.RegistrationPolicy) new RegistrationPolicyAlwaysRegister());
    }

    private void dSt() {
        if (this.nBT != null) {
            this.nBT.destroy();
            this.nBT = null;
        }
    }

    private void a(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (z) {
            if (this.nBT == null) {
                this.nBT = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifierAutoDetect.Observer() { // from class: com.baidu.turbonet.net.NetworkChangeNotifier.1
                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Ly(int i) {
                        NetworkChangeNotifier.this.Lu(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void M(double d) {
                        NetworkChangeNotifier.this.K(d);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void dF(int i, int i2) {
                        NetworkChangeNotifier.this.dE(i, i2);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Lz(int i) {
                        NetworkChangeNotifier.this.Lw(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void LA(int i) {
                        NetworkChangeNotifier.this.Lx(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void l(int[] iArr) {
                        NetworkChangeNotifier.this.k(iArr);
                    }
                }, this.mContext, registrationPolicy);
                NetworkChangeNotifierAutoDetect.c currentNetworkState = this.nBT.getCurrentNetworkState();
                Lu(this.nBT.getCurrentConnectionType(currentNetworkState));
                K(this.nBT.getCurrentMaxBandwidthInMbps(currentNetworkState));
                return;
            }
            return;
        }
        dSt();
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        dSr().ys(z);
    }

    private void ys(boolean z) {
        if ((this.nBU != 6) != z) {
            Lu(z ? 0 : 6);
            K(z ? Double.POSITIVE_INFINITY : 0.0d);
        }
    }

    @CalledByNative
    public static void fakeNetworkConnected(int i, int i2) {
        dSr().dE(i, i2);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(int i) {
        dSr().Lw(i);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(int i) {
        dSr().Lx(i);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(int[] iArr) {
        dSr().k(iArr);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(int i, int i2) {
        dSr().dD(i2, i);
    }

    @CalledByNative
    public static void fakeMaxBandwidthChanged(double d) {
        dSr().L(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lu(int i) {
        this.nBU = i;
        Lv(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(double d) {
        if (d != this.nBV || this.nBU != this.mMaxBandwidthConnectionType) {
            this.nBV = d;
            this.mMaxBandwidthConnectionType = this.nBU;
            L(d);
        }
    }

    void Lv(int i) {
        dD(i, getCurrentDefaultNetId());
    }

    private void dD(int i, int i2) {
        Iterator<Long> it = this.nBR.iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue(), i, i2);
        }
        Iterator<ConnectionTypeObserver> it2 = this.nBS.iterator();
        while (it2.hasNext()) {
            it2.next().Ly(i);
        }
    }

    void L(double d) {
        Iterator<Long> it = this.nBR.iterator();
        while (it.hasNext()) {
            nativeNotifyMaxBandwidthChanged(it.next().longValue(), d);
        }
    }

    void dE(int i, int i2) {
        Iterator<Long> it = this.nBR.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), i, i2);
        }
    }

    void Lw(int i) {
        Iterator<Long> it = this.nBR.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), i);
        }
    }

    void Lx(int i) {
        Iterator<Long> it = this.nBR.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), i);
        }
    }

    void k(int[] iArr) {
        Iterator<Long> it = this.nBR.iterator();
        while (it.hasNext()) {
            nativeNotifyPurgeActiveNetworkList(it.next().longValue(), iArr);
        }
    }
}
