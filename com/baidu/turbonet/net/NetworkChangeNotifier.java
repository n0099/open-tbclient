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
    private static NetworkChangeNotifier mfk;
    private final Context mContext;
    private NetworkChangeNotifierAutoDetect mfh;
    private int mfi = 0;
    private double mfj = Double.POSITIVE_INFINITY;
    private int mMaxBandwidthConnectionType = this.mfi;
    private final ArrayList<Long> mff = new ArrayList<>();
    private final com.baidu.turbonet.base.b<ConnectionTypeObserver> mfg = new com.baidu.turbonet.base.b<>();

    /* loaded from: classes.dex */
    public interface ConnectionTypeObserver {
        void Gl(int i);
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
        if (mfk == null) {
            mfk = new NetworkChangeNotifier(context);
        }
        return mfk;
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.mfi;
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        if (this.mfh == null) {
            return 0;
        }
        return this.mfh.getCurrentConnectionSubtype(this.mfh.getCurrentNetworkState());
    }

    @CalledByNative
    public double getCurrentMaxBandwidthInMbps() {
        return this.mfj;
    }

    @CalledByNative
    public int getCurrentDefaultNetId() {
        if (this.mfh == null) {
            return -1;
        }
        return this.mfh.getDefaultNetId();
    }

    @CalledByNative
    public int[] getCurrentNetworksAndTypes() {
        return this.mfh == null ? new int[0] : this.mfh.getNetworksAndTypes();
    }

    public static double Gg(int i) {
        return nativeGetMaxBandwidthForConnectionSubtype(i);
    }

    @CalledByNative
    public void addNativeObserver(long j) {
        this.mff.add(Long.valueOf(j));
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        this.mff.remove(Long.valueOf(j));
    }

    public static NetworkChangeNotifier dqO() {
        if ($assertionsDisabled || mfk != null) {
            return mfk;
        }
        throw new AssertionError();
    }

    public static void dqP() {
        dqO().a(true, (NetworkChangeNotifierAutoDetect.RegistrationPolicy) new RegistrationPolicyAlwaysRegister());
    }

    private void dqQ() {
        if (this.mfh != null) {
            this.mfh.destroy();
            this.mfh = null;
        }
    }

    private void a(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (z) {
            if (this.mfh == null) {
                this.mfh = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifierAutoDetect.Observer() { // from class: com.baidu.turbonet.net.NetworkChangeNotifier.1
                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Gl(int i) {
                        NetworkChangeNotifier.this.Gh(i);
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
                    public void Gm(int i) {
                        NetworkChangeNotifier.this.Gj(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Gn(int i) {
                        NetworkChangeNotifier.this.Gk(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void l(int[] iArr) {
                        NetworkChangeNotifier.this.k(iArr);
                    }
                }, this.mContext, registrationPolicy);
                NetworkChangeNotifierAutoDetect.c currentNetworkState = this.mfh.getCurrentNetworkState();
                Gh(this.mfh.getCurrentConnectionType(currentNetworkState));
                A(this.mfh.getCurrentMaxBandwidthInMbps(currentNetworkState));
                return;
            }
            return;
        }
        dqQ();
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        dqO().vJ(z);
    }

    private void vJ(boolean z) {
        if ((this.mfi != 6) != z) {
            Gh(z ? 0 : 6);
            A(z ? Double.POSITIVE_INFINITY : 0.0d);
        }
    }

    @CalledByNative
    public static void fakeNetworkConnected(int i, int i2) {
        dqO().dh(i, i2);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(int i) {
        dqO().Gj(i);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(int i) {
        dqO().Gk(i);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(int[] iArr) {
        dqO().k(iArr);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(int i, int i2) {
        dqO().dg(i2, i);
    }

    @CalledByNative
    public static void fakeMaxBandwidthChanged(double d) {
        dqO().B(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gh(int i) {
        this.mfi = i;
        Gi(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(double d) {
        if (d != this.mfj || this.mfi != this.mMaxBandwidthConnectionType) {
            this.mfj = d;
            this.mMaxBandwidthConnectionType = this.mfi;
            B(d);
        }
    }

    void Gi(int i) {
        dg(i, getCurrentDefaultNetId());
    }

    private void dg(int i, int i2) {
        Iterator<Long> it = this.mff.iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue(), i, i2);
        }
        Iterator<ConnectionTypeObserver> it2 = this.mfg.iterator();
        while (it2.hasNext()) {
            it2.next().Gl(i);
        }
    }

    void B(double d) {
        Iterator<Long> it = this.mff.iterator();
        while (it.hasNext()) {
            nativeNotifyMaxBandwidthChanged(it.next().longValue(), d);
        }
    }

    void dh(int i, int i2) {
        Iterator<Long> it = this.mff.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), i, i2);
        }
    }

    void Gj(int i) {
        Iterator<Long> it = this.mff.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), i);
        }
    }

    void Gk(int i) {
        Iterator<Long> it = this.mff.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), i);
        }
    }

    void k(int[] iArr) {
        Iterator<Long> it = this.mff.iterator();
        while (it.hasNext()) {
            nativeNotifyPurgeActiveNetworkList(it.next().longValue(), iArr);
        }
    }
}
