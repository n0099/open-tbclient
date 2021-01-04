package com.baidu.turbonet.net;

import android.content.Context;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect;
import java.util.ArrayList;
import java.util.Iterator;
@JNINamespace
/* loaded from: classes5.dex */
public class NetworkChangeNotifier {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static NetworkChangeNotifier oKV;
    private final Context mContext;
    private NetworkChangeNotifierAutoDetect oKT;
    private int mCurrentConnectionType = 0;
    private double oKU = Double.POSITIVE_INFINITY;
    private int mMaxBandwidthConnectionType = this.mCurrentConnectionType;
    private final ArrayList<Long> mNativeChangeNotifiers = new ArrayList<>();
    private final com.baidu.turbonet.base.b<ConnectionTypeObserver> oKS = new com.baidu.turbonet.base.b<>();

    /* loaded from: classes5.dex */
    public interface ConnectionTypeObserver {
        void onConnectionTypeChanged(int i);
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
        if (oKV == null) {
            oKV = new NetworkChangeNotifier(context);
        }
        return oKV;
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.mCurrentConnectionType;
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        if (this.oKT == null) {
            return 0;
        }
        return this.oKT.getCurrentConnectionSubtype(this.oKT.getCurrentNetworkState());
    }

    @CalledByNative
    public double getCurrentMaxBandwidthInMbps() {
        return this.oKU;
    }

    @CalledByNative
    public int getCurrentDefaultNetId() {
        if (this.oKT == null) {
            return -1;
        }
        return this.oKT.getDefaultNetId();
    }

    @CalledByNative
    public int[] getCurrentNetworksAndTypes() {
        return this.oKT == null ? new int[0] : this.oKT.getNetworksAndTypes();
    }

    public static double Oc(int i) {
        return nativeGetMaxBandwidthForConnectionSubtype(i);
    }

    @CalledByNative
    public void addNativeObserver(long j) {
        this.mNativeChangeNotifiers.add(Long.valueOf(j));
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        this.mNativeChangeNotifiers.remove(Long.valueOf(j));
    }

    public static NetworkChangeNotifier ehL() {
        if ($assertionsDisabled || oKV != null) {
            return oKV;
        }
        throw new AssertionError();
    }

    public static void ehM() {
        ehL().a(true, (NetworkChangeNotifierAutoDetect.RegistrationPolicy) new RegistrationPolicyAlwaysRegister());
    }

    private void ehN() {
        if (this.oKT != null) {
            this.oKT.destroy();
            this.oKT = null;
        }
    }

    private void a(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (z) {
            if (this.oKT == null) {
                this.oKT = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifierAutoDetect.Observer() { // from class: com.baidu.turbonet.net.NetworkChangeNotifier.1
                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void onConnectionTypeChanged(int i) {
                        NetworkChangeNotifier.this.updateCurrentConnectionType(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void O(double d) {
                        NetworkChangeNotifier.this.M(d);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void dQ(int i, int i2) {
                        NetworkChangeNotifier.this.dP(i, i2);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Of(int i) {
                        NetworkChangeNotifier.this.Od(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Og(int i) {
                        NetworkChangeNotifier.this.Oe(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void r(int[] iArr) {
                        NetworkChangeNotifier.this.q(iArr);
                    }
                }, this.mContext, registrationPolicy);
                NetworkChangeNotifierAutoDetect.c currentNetworkState = this.oKT.getCurrentNetworkState();
                updateCurrentConnectionType(this.oKT.getCurrentConnectionType(currentNetworkState));
                M(this.oKT.getCurrentMaxBandwidthInMbps(currentNetworkState));
                return;
            }
            return;
        }
        ehN();
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        ehL().Af(z);
    }

    private void Af(boolean z) {
        if ((this.mCurrentConnectionType != 6) != z) {
            updateCurrentConnectionType(z ? 0 : 6);
            M(z ? Double.POSITIVE_INFINITY : 0.0d);
        }
    }

    @CalledByNative
    public static void fakeNetworkConnected(int i, int i2) {
        ehL().dP(i, i2);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(int i) {
        ehL().Od(i);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(int i) {
        ehL().Oe(i);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(int[] iArr) {
        ehL().q(iArr);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(int i, int i2) {
        ehL().dO(i2, i);
    }

    @CalledByNative
    public static void fakeMaxBandwidthChanged(double d) {
        ehL().N(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurrentConnectionType(int i) {
        this.mCurrentConnectionType = i;
        notifyObserversOfConnectionTypeChange(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(double d) {
        if (d != this.oKU || this.mCurrentConnectionType != this.mMaxBandwidthConnectionType) {
            this.oKU = d;
            this.mMaxBandwidthConnectionType = this.mCurrentConnectionType;
            N(d);
        }
    }

    void notifyObserversOfConnectionTypeChange(int i) {
        dO(i, getCurrentDefaultNetId());
    }

    private void dO(int i, int i2) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue(), i, i2);
        }
        Iterator<ConnectionTypeObserver> it2 = this.oKS.iterator();
        while (it2.hasNext()) {
            it2.next().onConnectionTypeChanged(i);
        }
    }

    void N(double d) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyMaxBandwidthChanged(it.next().longValue(), d);
        }
    }

    void dP(int i, int i2) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), i, i2);
        }
    }

    void Od(int i) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), i);
        }
    }

    void Oe(int i) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), i);
        }
    }

    void q(int[] iArr) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyPurgeActiveNetworkList(it.next().longValue(), iArr);
        }
    }
}
