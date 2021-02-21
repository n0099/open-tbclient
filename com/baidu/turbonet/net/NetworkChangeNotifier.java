package com.baidu.turbonet.net;

import android.content.Context;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect;
import java.util.ArrayList;
import java.util.Iterator;
@JNINamespace
/* loaded from: classes6.dex */
public class NetworkChangeNotifier {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static NetworkChangeNotifier oQZ;
    private final Context mContext;
    private NetworkChangeNotifierAutoDetect oQX;
    private int mCurrentConnectionType = 0;
    private double oQY = Double.POSITIVE_INFINITY;
    private int mMaxBandwidthConnectionType = this.mCurrentConnectionType;
    private final ArrayList<Long> mNativeChangeNotifiers = new ArrayList<>();
    private final com.baidu.turbonet.base.b<ConnectionTypeObserver> oQW = new com.baidu.turbonet.base.b<>();

    /* loaded from: classes6.dex */
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
        if (oQZ == null) {
            oQZ = new NetworkChangeNotifier(context);
        }
        return oQZ;
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.mCurrentConnectionType;
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        if (this.oQX == null) {
            return 0;
        }
        return this.oQX.getCurrentConnectionSubtype(this.oQX.getCurrentNetworkState());
    }

    @CalledByNative
    public double getCurrentMaxBandwidthInMbps() {
        return this.oQY;
    }

    @CalledByNative
    public int getCurrentDefaultNetId() {
        if (this.oQX == null) {
            return -1;
        }
        return this.oQX.getDefaultNetId();
    }

    @CalledByNative
    public int[] getCurrentNetworksAndTypes() {
        return this.oQX == null ? new int[0] : this.oQX.getNetworksAndTypes();
    }

    public static double MS(int i) {
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

    public static NetworkChangeNotifier egu() {
        if ($assertionsDisabled || oQZ != null) {
            return oQZ;
        }
        throw new AssertionError();
    }

    public static void egv() {
        egu().a(true, (NetworkChangeNotifierAutoDetect.RegistrationPolicy) new RegistrationPolicyAlwaysRegister());
    }

    private void egw() {
        if (this.oQX != null) {
            this.oQX.destroy();
            this.oQX = null;
        }
    }

    private void a(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (z) {
            if (this.oQX == null) {
                this.oQX = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifierAutoDetect.Observer() { // from class: com.baidu.turbonet.net.NetworkChangeNotifier.1
                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void onConnectionTypeChanged(int i) {
                        NetworkChangeNotifier.this.updateCurrentConnectionType(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void I(double d) {
                        NetworkChangeNotifier.this.G(d);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void dO(int i, int i2) {
                        NetworkChangeNotifier.this.dN(i, i2);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void MV(int i) {
                        NetworkChangeNotifier.this.MT(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void MW(int i) {
                        NetworkChangeNotifier.this.MU(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void r(int[] iArr) {
                        NetworkChangeNotifier.this.q(iArr);
                    }
                }, this.mContext, registrationPolicy);
                NetworkChangeNotifierAutoDetect.c currentNetworkState = this.oQX.getCurrentNetworkState();
                updateCurrentConnectionType(this.oQX.getCurrentConnectionType(currentNetworkState));
                G(this.oQX.getCurrentMaxBandwidthInMbps(currentNetworkState));
                return;
            }
            return;
        }
        egw();
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        egu().Au(z);
    }

    private void Au(boolean z) {
        if ((this.mCurrentConnectionType != 6) != z) {
            updateCurrentConnectionType(z ? 0 : 6);
            G(z ? Double.POSITIVE_INFINITY : 0.0d);
        }
    }

    @CalledByNative
    public static void fakeNetworkConnected(int i, int i2) {
        egu().dN(i, i2);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(int i) {
        egu().MT(i);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(int i) {
        egu().MU(i);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(int[] iArr) {
        egu().q(iArr);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(int i, int i2) {
        egu().dM(i2, i);
    }

    @CalledByNative
    public static void fakeMaxBandwidthChanged(double d) {
        egu().H(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurrentConnectionType(int i) {
        this.mCurrentConnectionType = i;
        notifyObserversOfConnectionTypeChange(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(double d) {
        if (d != this.oQY || this.mCurrentConnectionType != this.mMaxBandwidthConnectionType) {
            this.oQY = d;
            this.mMaxBandwidthConnectionType = this.mCurrentConnectionType;
            H(d);
        }
    }

    void notifyObserversOfConnectionTypeChange(int i) {
        dM(i, getCurrentDefaultNetId());
    }

    private void dM(int i, int i2) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue(), i, i2);
        }
        Iterator<ConnectionTypeObserver> it2 = this.oQW.iterator();
        while (it2.hasNext()) {
            it2.next().onConnectionTypeChanged(i);
        }
    }

    void H(double d) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyMaxBandwidthChanged(it.next().longValue(), d);
        }
    }

    void dN(int i, int i2) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), i, i2);
        }
    }

    void MT(int i) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), i);
        }
    }

    void MU(int i) {
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
