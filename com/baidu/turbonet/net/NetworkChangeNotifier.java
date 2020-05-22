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
    private static NetworkChangeNotifier mea;
    private final Context mContext;
    private NetworkChangeNotifierAutoDetect mdX;
    private int mdY = 0;
    private double mdZ = Double.POSITIVE_INFINITY;
    private int mMaxBandwidthConnectionType = this.mdY;
    private final ArrayList<Long> mdV = new ArrayList<>();
    private final com.baidu.turbonet.base.b<ConnectionTypeObserver> mdW = new com.baidu.turbonet.base.b<>();

    /* loaded from: classes.dex */
    public interface ConnectionTypeObserver {
        void Gj(int i);
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
        if (mea == null) {
            mea = new NetworkChangeNotifier(context);
        }
        return mea;
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.mdY;
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        if (this.mdX == null) {
            return 0;
        }
        return this.mdX.getCurrentConnectionSubtype(this.mdX.getCurrentNetworkState());
    }

    @CalledByNative
    public double getCurrentMaxBandwidthInMbps() {
        return this.mdZ;
    }

    @CalledByNative
    public int getCurrentDefaultNetId() {
        if (this.mdX == null) {
            return -1;
        }
        return this.mdX.getDefaultNetId();
    }

    @CalledByNative
    public int[] getCurrentNetworksAndTypes() {
        return this.mdX == null ? new int[0] : this.mdX.getNetworksAndTypes();
    }

    public static double Ge(int i) {
        return nativeGetMaxBandwidthForConnectionSubtype(i);
    }

    @CalledByNative
    public void addNativeObserver(long j) {
        this.mdV.add(Long.valueOf(j));
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        this.mdV.remove(Long.valueOf(j));
    }

    public static NetworkChangeNotifier dqA() {
        if ($assertionsDisabled || mea != null) {
            return mea;
        }
        throw new AssertionError();
    }

    public static void dqB() {
        dqA().a(true, (NetworkChangeNotifierAutoDetect.RegistrationPolicy) new RegistrationPolicyAlwaysRegister());
    }

    private void dqC() {
        if (this.mdX != null) {
            this.mdX.destroy();
            this.mdX = null;
        }
    }

    private void a(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (z) {
            if (this.mdX == null) {
                this.mdX = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifierAutoDetect.Observer() { // from class: com.baidu.turbonet.net.NetworkChangeNotifier.1
                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Gj(int i) {
                        NetworkChangeNotifier.this.Gf(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void C(double d) {
                        NetworkChangeNotifier.this.A(d);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void di(int i, int i2) {
                        NetworkChangeNotifier.this.dh(i, i2);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Gk(int i) {
                        NetworkChangeNotifier.this.Gh(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Gl(int i) {
                        NetworkChangeNotifier.this.Gi(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void l(int[] iArr) {
                        NetworkChangeNotifier.this.k(iArr);
                    }
                }, this.mContext, registrationPolicy);
                NetworkChangeNotifierAutoDetect.c currentNetworkState = this.mdX.getCurrentNetworkState();
                Gf(this.mdX.getCurrentConnectionType(currentNetworkState));
                A(this.mdX.getCurrentMaxBandwidthInMbps(currentNetworkState));
                return;
            }
            return;
        }
        dqC();
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        dqA().vH(z);
    }

    private void vH(boolean z) {
        if ((this.mdY != 6) != z) {
            Gf(z ? 0 : 6);
            A(z ? Double.POSITIVE_INFINITY : 0.0d);
        }
    }

    @CalledByNative
    public static void fakeNetworkConnected(int i, int i2) {
        dqA().dh(i, i2);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(int i) {
        dqA().Gh(i);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(int i) {
        dqA().Gi(i);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(int[] iArr) {
        dqA().k(iArr);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(int i, int i2) {
        dqA().dg(i2, i);
    }

    @CalledByNative
    public static void fakeMaxBandwidthChanged(double d) {
        dqA().B(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gf(int i) {
        this.mdY = i;
        Gg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(double d) {
        if (d != this.mdZ || this.mdY != this.mMaxBandwidthConnectionType) {
            this.mdZ = d;
            this.mMaxBandwidthConnectionType = this.mdY;
            B(d);
        }
    }

    void Gg(int i) {
        dg(i, getCurrentDefaultNetId());
    }

    private void dg(int i, int i2) {
        Iterator<Long> it = this.mdV.iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue(), i, i2);
        }
        Iterator<ConnectionTypeObserver> it2 = this.mdW.iterator();
        while (it2.hasNext()) {
            it2.next().Gj(i);
        }
    }

    void B(double d) {
        Iterator<Long> it = this.mdV.iterator();
        while (it.hasNext()) {
            nativeNotifyMaxBandwidthChanged(it.next().longValue(), d);
        }
    }

    void dh(int i, int i2) {
        Iterator<Long> it = this.mdV.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), i, i2);
        }
    }

    void Gh(int i) {
        Iterator<Long> it = this.mdV.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), i);
        }
    }

    void Gi(int i) {
        Iterator<Long> it = this.mdV.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), i);
        }
    }

    void k(int[] iArr) {
        Iterator<Long> it = this.mdV.iterator();
        while (it.hasNext()) {
            nativeNotifyPurgeActiveNetworkList(it.next().longValue(), iArr);
        }
    }
}
