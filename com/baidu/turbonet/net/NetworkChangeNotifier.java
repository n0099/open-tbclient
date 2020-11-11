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
    private static NetworkChangeNotifier onC;
    private final Context mContext;
    private NetworkChangeNotifierAutoDetect onz;
    private int onA = 0;
    private double onB = Double.POSITIVE_INFINITY;
    private int mMaxBandwidthConnectionType = this.onA;
    private final ArrayList<Long> onx = new ArrayList<>();
    private final com.baidu.turbonet.base.b<ConnectionTypeObserver> ony = new com.baidu.turbonet.base.b<>();

    /* loaded from: classes17.dex */
    public interface ConnectionTypeObserver {
        void MT(int i);
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
        if (onC == null) {
            onC = new NetworkChangeNotifier(context);
        }
        return onC;
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.onA;
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        if (this.onz == null) {
            return 0;
        }
        return this.onz.getCurrentConnectionSubtype(this.onz.getCurrentNetworkState());
    }

    @CalledByNative
    public double getCurrentMaxBandwidthInMbps() {
        return this.onB;
    }

    @CalledByNative
    public int getCurrentDefaultNetId() {
        if (this.onz == null) {
            return -1;
        }
        return this.onz.getDefaultNetId();
    }

    @CalledByNative
    public int[] getCurrentNetworksAndTypes() {
        return this.onz == null ? new int[0] : this.onz.getNetworksAndTypes();
    }

    public static double MO(int i) {
        return nativeGetMaxBandwidthForConnectionSubtype(i);
    }

    @CalledByNative
    public void addNativeObserver(long j) {
        this.onx.add(Long.valueOf(j));
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        this.onx.remove(Long.valueOf(j));
    }

    public static NetworkChangeNotifier ebR() {
        if ($assertionsDisabled || onC != null) {
            return onC;
        }
        throw new AssertionError();
    }

    public static void ebS() {
        ebR().a(true, (NetworkChangeNotifierAutoDetect.RegistrationPolicy) new RegistrationPolicyAlwaysRegister());
    }

    private void ebT() {
        if (this.onz != null) {
            this.onz.destroy();
            this.onz = null;
        }
    }

    private void a(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (z) {
            if (this.onz == null) {
                this.onz = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifierAutoDetect.Observer() { // from class: com.baidu.turbonet.net.NetworkChangeNotifier.1
                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void MT(int i) {
                        NetworkChangeNotifier.this.MP(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void N(double d) {
                        NetworkChangeNotifier.this.L(d);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void dM(int i, int i2) {
                        NetworkChangeNotifier.this.dL(i, i2);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void MU(int i) {
                        NetworkChangeNotifier.this.MR(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void MV(int i) {
                        NetworkChangeNotifier.this.MS(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void n(int[] iArr) {
                        NetworkChangeNotifier.this.m(iArr);
                    }
                }, this.mContext, registrationPolicy);
                NetworkChangeNotifierAutoDetect.c currentNetworkState = this.onz.getCurrentNetworkState();
                MP(this.onz.getCurrentConnectionType(currentNetworkState));
                L(this.onz.getCurrentMaxBandwidthInMbps(currentNetworkState));
                return;
            }
            return;
        }
        ebT();
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        ebR().zt(z);
    }

    private void zt(boolean z) {
        if ((this.onA != 6) != z) {
            MP(z ? 0 : 6);
            L(z ? Double.POSITIVE_INFINITY : 0.0d);
        }
    }

    @CalledByNative
    public static void fakeNetworkConnected(int i, int i2) {
        ebR().dL(i, i2);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(int i) {
        ebR().MR(i);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(int i) {
        ebR().MS(i);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(int[] iArr) {
        ebR().m(iArr);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(int i, int i2) {
        ebR().dK(i2, i);
    }

    @CalledByNative
    public static void fakeMaxBandwidthChanged(double d) {
        ebR().M(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MP(int i) {
        this.onA = i;
        MQ(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(double d) {
        if (d != this.onB || this.onA != this.mMaxBandwidthConnectionType) {
            this.onB = d;
            this.mMaxBandwidthConnectionType = this.onA;
            M(d);
        }
    }

    void MQ(int i) {
        dK(i, getCurrentDefaultNetId());
    }

    private void dK(int i, int i2) {
        Iterator<Long> it = this.onx.iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue(), i, i2);
        }
        Iterator<ConnectionTypeObserver> it2 = this.ony.iterator();
        while (it2.hasNext()) {
            it2.next().MT(i);
        }
    }

    void M(double d) {
        Iterator<Long> it = this.onx.iterator();
        while (it.hasNext()) {
            nativeNotifyMaxBandwidthChanged(it.next().longValue(), d);
        }
    }

    void dL(int i, int i2) {
        Iterator<Long> it = this.onx.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), i, i2);
        }
    }

    void MR(int i) {
        Iterator<Long> it = this.onx.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), i);
        }
    }

    void MS(int i) {
        Iterator<Long> it = this.onx.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), i);
        }
    }

    void m(int[] iArr) {
        Iterator<Long> it = this.onx.iterator();
        while (it.hasNext()) {
            nativeNotifyPurgeActiveNetworkList(it.next().longValue(), iArr);
        }
    }
}
