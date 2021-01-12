package com.baidu.turbonet.net;

import android.content.Context;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect;
import java.util.ArrayList;
import java.util.Iterator;
@JNINamespace
/* loaded from: classes4.dex */
public class NetworkChangeNotifier {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static NetworkChangeNotifier oGq;
    private final Context mContext;
    private NetworkChangeNotifierAutoDetect oGo;
    private int mCurrentConnectionType = 0;
    private double oGp = Double.POSITIVE_INFINITY;
    private int mMaxBandwidthConnectionType = this.mCurrentConnectionType;
    private final ArrayList<Long> mNativeChangeNotifiers = new ArrayList<>();
    private final com.baidu.turbonet.base.b<ConnectionTypeObserver> oGn = new com.baidu.turbonet.base.b<>();

    /* loaded from: classes4.dex */
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
        if (oGq == null) {
            oGq = new NetworkChangeNotifier(context);
        }
        return oGq;
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.mCurrentConnectionType;
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        if (this.oGo == null) {
            return 0;
        }
        return this.oGo.getCurrentConnectionSubtype(this.oGo.getCurrentNetworkState());
    }

    @CalledByNative
    public double getCurrentMaxBandwidthInMbps() {
        return this.oGp;
    }

    @CalledByNative
    public int getCurrentDefaultNetId() {
        if (this.oGo == null) {
            return -1;
        }
        return this.oGo.getDefaultNetId();
    }

    @CalledByNative
    public int[] getCurrentNetworksAndTypes() {
        return this.oGo == null ? new int[0] : this.oGo.getNetworksAndTypes();
    }

    public static double Mv(int i) {
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

    public static NetworkChangeNotifier edU() {
        if ($assertionsDisabled || oGq != null) {
            return oGq;
        }
        throw new AssertionError();
    }

    public static void edV() {
        edU().a(true, (NetworkChangeNotifierAutoDetect.RegistrationPolicy) new RegistrationPolicyAlwaysRegister());
    }

    private void edW() {
        if (this.oGo != null) {
            this.oGo.destroy();
            this.oGo = null;
        }
    }

    private void a(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (z) {
            if (this.oGo == null) {
                this.oGo = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifierAutoDetect.Observer() { // from class: com.baidu.turbonet.net.NetworkChangeNotifier.1
                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void onConnectionTypeChanged(int i) {
                        NetworkChangeNotifier.this.updateCurrentConnectionType(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void I(double d) {
                        NetworkChangeNotifier.this.G(d);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void dQ(int i, int i2) {
                        NetworkChangeNotifier.this.dP(i, i2);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void My(int i) {
                        NetworkChangeNotifier.this.Mw(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Mz(int i) {
                        NetworkChangeNotifier.this.Mx(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void r(int[] iArr) {
                        NetworkChangeNotifier.this.q(iArr);
                    }
                }, this.mContext, registrationPolicy);
                NetworkChangeNotifierAutoDetect.c currentNetworkState = this.oGo.getCurrentNetworkState();
                updateCurrentConnectionType(this.oGo.getCurrentConnectionType(currentNetworkState));
                G(this.oGo.getCurrentMaxBandwidthInMbps(currentNetworkState));
                return;
            }
            return;
        }
        edW();
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        edU().Ab(z);
    }

    private void Ab(boolean z) {
        if ((this.mCurrentConnectionType != 6) != z) {
            updateCurrentConnectionType(z ? 0 : 6);
            G(z ? Double.POSITIVE_INFINITY : 0.0d);
        }
    }

    @CalledByNative
    public static void fakeNetworkConnected(int i, int i2) {
        edU().dP(i, i2);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(int i) {
        edU().Mw(i);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(int i) {
        edU().Mx(i);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(int[] iArr) {
        edU().q(iArr);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(int i, int i2) {
        edU().dO(i2, i);
    }

    @CalledByNative
    public static void fakeMaxBandwidthChanged(double d) {
        edU().H(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurrentConnectionType(int i) {
        this.mCurrentConnectionType = i;
        notifyObserversOfConnectionTypeChange(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(double d) {
        if (d != this.oGp || this.mCurrentConnectionType != this.mMaxBandwidthConnectionType) {
            this.oGp = d;
            this.mMaxBandwidthConnectionType = this.mCurrentConnectionType;
            H(d);
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
        Iterator<ConnectionTypeObserver> it2 = this.oGn.iterator();
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

    void dP(int i, int i2) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), i, i2);
        }
    }

    void Mw(int i) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), i);
        }
    }

    void Mx(int i) {
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
