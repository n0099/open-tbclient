package com.baidu.turbonet.net;

import android.content.Context;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect;
import java.util.ArrayList;
import java.util.Iterator;
@JNINamespace
/* loaded from: classes19.dex */
public class NetworkChangeNotifier {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static NetworkChangeNotifier mJn;
    private final Context mContext;
    private NetworkChangeNotifierAutoDetect mJk;
    private int mJl = 0;
    private double mJm = Double.POSITIVE_INFINITY;
    private int mMaxBandwidthConnectionType = this.mJl;
    private final ArrayList<Long> mJi = new ArrayList<>();
    private final com.baidu.turbonet.base.b<ConnectionTypeObserver> mJj = new com.baidu.turbonet.base.b<>();

    /* loaded from: classes19.dex */
    public interface ConnectionTypeObserver {
        void HN(int i);
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
        if (mJn == null) {
            mJn = new NetworkChangeNotifier(context);
        }
        return mJn;
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.mJl;
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        if (this.mJk == null) {
            return 0;
        }
        return this.mJk.getCurrentConnectionSubtype(this.mJk.getCurrentNetworkState());
    }

    @CalledByNative
    public double getCurrentMaxBandwidthInMbps() {
        return this.mJm;
    }

    @CalledByNative
    public int getCurrentDefaultNetId() {
        if (this.mJk == null) {
            return -1;
        }
        return this.mJk.getDefaultNetId();
    }

    @CalledByNative
    public int[] getCurrentNetworksAndTypes() {
        return this.mJk == null ? new int[0] : this.mJk.getNetworksAndTypes();
    }

    public static double HI(int i) {
        return nativeGetMaxBandwidthForConnectionSubtype(i);
    }

    @CalledByNative
    public void addNativeObserver(long j) {
        this.mJi.add(Long.valueOf(j));
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        this.mJi.remove(Long.valueOf(j));
    }

    public static NetworkChangeNotifier dyL() {
        if ($assertionsDisabled || mJn != null) {
            return mJn;
        }
        throw new AssertionError();
    }

    public static void dyM() {
        dyL().a(true, (NetworkChangeNotifierAutoDetect.RegistrationPolicy) new RegistrationPolicyAlwaysRegister());
    }

    private void dyN() {
        if (this.mJk != null) {
            this.mJk.destroy();
            this.mJk = null;
        }
    }

    private void a(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (z) {
            if (this.mJk == null) {
                this.mJk = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifierAutoDetect.Observer() { // from class: com.baidu.turbonet.net.NetworkChangeNotifier.1
                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void HN(int i) {
                        NetworkChangeNotifier.this.HJ(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void D(double d) {
                        NetworkChangeNotifier.this.B(d);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void dt(int i, int i2) {
                        NetworkChangeNotifier.this.ds(i, i2);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void HO(int i) {
                        NetworkChangeNotifier.this.HL(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void HP(int i) {
                        NetworkChangeNotifier.this.HM(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void l(int[] iArr) {
                        NetworkChangeNotifier.this.k(iArr);
                    }
                }, this.mContext, registrationPolicy);
                NetworkChangeNotifierAutoDetect.c currentNetworkState = this.mJk.getCurrentNetworkState();
                HJ(this.mJk.getCurrentConnectionType(currentNetworkState));
                B(this.mJk.getCurrentMaxBandwidthInMbps(currentNetworkState));
                return;
            }
            return;
        }
        dyN();
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        dyL().wK(z);
    }

    private void wK(boolean z) {
        if ((this.mJl != 6) != z) {
            HJ(z ? 0 : 6);
            B(z ? Double.POSITIVE_INFINITY : 0.0d);
        }
    }

    @CalledByNative
    public static void fakeNetworkConnected(int i, int i2) {
        dyL().ds(i, i2);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(int i) {
        dyL().HL(i);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(int i) {
        dyL().HM(i);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(int[] iArr) {
        dyL().k(iArr);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(int i, int i2) {
        dyL().dr(i2, i);
    }

    @CalledByNative
    public static void fakeMaxBandwidthChanged(double d) {
        dyL().C(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HJ(int i) {
        this.mJl = i;
        HK(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(double d) {
        if (d != this.mJm || this.mJl != this.mMaxBandwidthConnectionType) {
            this.mJm = d;
            this.mMaxBandwidthConnectionType = this.mJl;
            C(d);
        }
    }

    void HK(int i) {
        dr(i, getCurrentDefaultNetId());
    }

    private void dr(int i, int i2) {
        Iterator<Long> it = this.mJi.iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue(), i, i2);
        }
        Iterator<ConnectionTypeObserver> it2 = this.mJj.iterator();
        while (it2.hasNext()) {
            it2.next().HN(i);
        }
    }

    void C(double d) {
        Iterator<Long> it = this.mJi.iterator();
        while (it.hasNext()) {
            nativeNotifyMaxBandwidthChanged(it.next().longValue(), d);
        }
    }

    void ds(int i, int i2) {
        Iterator<Long> it = this.mJi.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), i, i2);
        }
    }

    void HL(int i) {
        Iterator<Long> it = this.mJi.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), i);
        }
    }

    void HM(int i) {
        Iterator<Long> it = this.mJi.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), i);
        }
    }

    void k(int[] iArr) {
        Iterator<Long> it = this.mJi.iterator();
        while (it.hasNext()) {
            nativeNotifyPurgeActiveNetworkList(it.next().longValue(), iArr);
        }
    }
}
