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
    private static NetworkChangeNotifier mAZ;
    private NetworkChangeNotifierAutoDetect mAW;
    private final Context mContext;
    private int mAX = 0;
    private double mAY = Double.POSITIVE_INFINITY;
    private int mMaxBandwidthConnectionType = this.mAX;
    private final ArrayList<Long> mAU = new ArrayList<>();
    private final com.baidu.turbonet.base.b<ConnectionTypeObserver> mAV = new com.baidu.turbonet.base.b<>();

    /* loaded from: classes.dex */
    public interface ConnectionTypeObserver {
        void Hs(int i);
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
        if (mAZ == null) {
            mAZ = new NetworkChangeNotifier(context);
        }
        return mAZ;
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.mAX;
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        if (this.mAW == null) {
            return 0;
        }
        return this.mAW.getCurrentConnectionSubtype(this.mAW.getCurrentNetworkState());
    }

    @CalledByNative
    public double getCurrentMaxBandwidthInMbps() {
        return this.mAY;
    }

    @CalledByNative
    public int getCurrentDefaultNetId() {
        if (this.mAW == null) {
            return -1;
        }
        return this.mAW.getDefaultNetId();
    }

    @CalledByNative
    public int[] getCurrentNetworksAndTypes() {
        return this.mAW == null ? new int[0] : this.mAW.getNetworksAndTypes();
    }

    public static double Hn(int i) {
        return nativeGetMaxBandwidthForConnectionSubtype(i);
    }

    @CalledByNative
    public void addNativeObserver(long j) {
        this.mAU.add(Long.valueOf(j));
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        this.mAU.remove(Long.valueOf(j));
    }

    public static NetworkChangeNotifier dvt() {
        if ($assertionsDisabled || mAZ != null) {
            return mAZ;
        }
        throw new AssertionError();
    }

    public static void dvu() {
        dvt().a(true, (NetworkChangeNotifierAutoDetect.RegistrationPolicy) new RegistrationPolicyAlwaysRegister());
    }

    private void dvv() {
        if (this.mAW != null) {
            this.mAW.destroy();
            this.mAW = null;
        }
    }

    private void a(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (z) {
            if (this.mAW == null) {
                this.mAW = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifierAutoDetect.Observer() { // from class: com.baidu.turbonet.net.NetworkChangeNotifier.1
                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Hs(int i) {
                        NetworkChangeNotifier.this.Ho(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void D(double d) {
                        NetworkChangeNotifier.this.B(d);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void dr(int i, int i2) {
                        NetworkChangeNotifier.this.dq(i, i2);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Ht(int i) {
                        NetworkChangeNotifier.this.Hq(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Hu(int i) {
                        NetworkChangeNotifier.this.Hr(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void l(int[] iArr) {
                        NetworkChangeNotifier.this.k(iArr);
                    }
                }, this.mContext, registrationPolicy);
                NetworkChangeNotifierAutoDetect.c currentNetworkState = this.mAW.getCurrentNetworkState();
                Ho(this.mAW.getCurrentConnectionType(currentNetworkState));
                B(this.mAW.getCurrentMaxBandwidthInMbps(currentNetworkState));
                return;
            }
            return;
        }
        dvv();
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        dvt().wf(z);
    }

    private void wf(boolean z) {
        if ((this.mAX != 6) != z) {
            Ho(z ? 0 : 6);
            B(z ? Double.POSITIVE_INFINITY : 0.0d);
        }
    }

    @CalledByNative
    public static void fakeNetworkConnected(int i, int i2) {
        dvt().dq(i, i2);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(int i) {
        dvt().Hq(i);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(int i) {
        dvt().Hr(i);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(int[] iArr) {
        dvt().k(iArr);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(int i, int i2) {
        dvt().dp(i2, i);
    }

    @CalledByNative
    public static void fakeMaxBandwidthChanged(double d) {
        dvt().C(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ho(int i) {
        this.mAX = i;
        Hp(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(double d) {
        if (d != this.mAY || this.mAX != this.mMaxBandwidthConnectionType) {
            this.mAY = d;
            this.mMaxBandwidthConnectionType = this.mAX;
            C(d);
        }
    }

    void Hp(int i) {
        dp(i, getCurrentDefaultNetId());
    }

    private void dp(int i, int i2) {
        Iterator<Long> it = this.mAU.iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue(), i, i2);
        }
        Iterator<ConnectionTypeObserver> it2 = this.mAV.iterator();
        while (it2.hasNext()) {
            it2.next().Hs(i);
        }
    }

    void C(double d) {
        Iterator<Long> it = this.mAU.iterator();
        while (it.hasNext()) {
            nativeNotifyMaxBandwidthChanged(it.next().longValue(), d);
        }
    }

    void dq(int i, int i2) {
        Iterator<Long> it = this.mAU.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), i, i2);
        }
    }

    void Hq(int i) {
        Iterator<Long> it = this.mAU.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), i);
        }
    }

    void Hr(int i) {
        Iterator<Long> it = this.mAU.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), i);
        }
    }

    void k(int[] iArr) {
        Iterator<Long> it = this.mAU.iterator();
        while (it.hasNext()) {
            nativeNotifyPurgeActiveNetworkList(it.next().longValue(), iArr);
        }
    }
}
