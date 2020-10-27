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
    private static NetworkChangeNotifier oex;
    private final Context mContext;
    private NetworkChangeNotifierAutoDetect oeu;
    private int oev = 0;
    private double oew = Double.POSITIVE_INFINITY;
    private int mMaxBandwidthConnectionType = this.oev;
    private final ArrayList<Long> oes = new ArrayList<>();
    private final com.baidu.turbonet.base.b<ConnectionTypeObserver> oet = new com.baidu.turbonet.base.b<>();

    /* loaded from: classes17.dex */
    public interface ConnectionTypeObserver {
        void MA(int i);
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
        if (oex == null) {
            oex = new NetworkChangeNotifier(context);
        }
        return oex;
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.oev;
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        if (this.oeu == null) {
            return 0;
        }
        return this.oeu.getCurrentConnectionSubtype(this.oeu.getCurrentNetworkState());
    }

    @CalledByNative
    public double getCurrentMaxBandwidthInMbps() {
        return this.oew;
    }

    @CalledByNative
    public int getCurrentDefaultNetId() {
        if (this.oeu == null) {
            return -1;
        }
        return this.oeu.getDefaultNetId();
    }

    @CalledByNative
    public int[] getCurrentNetworksAndTypes() {
        return this.oeu == null ? new int[0] : this.oeu.getNetworksAndTypes();
    }

    public static double Mv(int i) {
        return nativeGetMaxBandwidthForConnectionSubtype(i);
    }

    @CalledByNative
    public void addNativeObserver(long j) {
        this.oes.add(Long.valueOf(j));
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        this.oes.remove(Long.valueOf(j));
    }

    public static NetworkChangeNotifier dYj() {
        if ($assertionsDisabled || oex != null) {
            return oex;
        }
        throw new AssertionError();
    }

    public static void dYk() {
        dYj().a(true, (NetworkChangeNotifierAutoDetect.RegistrationPolicy) new RegistrationPolicyAlwaysRegister());
    }

    private void dYl() {
        if (this.oeu != null) {
            this.oeu.destroy();
            this.oeu = null;
        }
    }

    private void a(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (z) {
            if (this.oeu == null) {
                this.oeu = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifierAutoDetect.Observer() { // from class: com.baidu.turbonet.net.NetworkChangeNotifier.1
                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void MA(int i) {
                        NetworkChangeNotifier.this.Mw(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void N(double d) {
                        NetworkChangeNotifier.this.L(d);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void dJ(int i, int i2) {
                        NetworkChangeNotifier.this.dI(i, i2);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void MB(int i) {
                        NetworkChangeNotifier.this.My(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void MC(int i) {
                        NetworkChangeNotifier.this.Mz(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void l(int[] iArr) {
                        NetworkChangeNotifier.this.k(iArr);
                    }
                }, this.mContext, registrationPolicy);
                NetworkChangeNotifierAutoDetect.c currentNetworkState = this.oeu.getCurrentNetworkState();
                Mw(this.oeu.getCurrentConnectionType(currentNetworkState));
                L(this.oeu.getCurrentMaxBandwidthInMbps(currentNetworkState));
                return;
            }
            return;
        }
        dYl();
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        dYj().zi(z);
    }

    private void zi(boolean z) {
        if ((this.oev != 6) != z) {
            Mw(z ? 0 : 6);
            L(z ? Double.POSITIVE_INFINITY : 0.0d);
        }
    }

    @CalledByNative
    public static void fakeNetworkConnected(int i, int i2) {
        dYj().dI(i, i2);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(int i) {
        dYj().My(i);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(int i) {
        dYj().Mz(i);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(int[] iArr) {
        dYj().k(iArr);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(int i, int i2) {
        dYj().dH(i2, i);
    }

    @CalledByNative
    public static void fakeMaxBandwidthChanged(double d) {
        dYj().M(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mw(int i) {
        this.oev = i;
        Mx(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(double d) {
        if (d != this.oew || this.oev != this.mMaxBandwidthConnectionType) {
            this.oew = d;
            this.mMaxBandwidthConnectionType = this.oev;
            M(d);
        }
    }

    void Mx(int i) {
        dH(i, getCurrentDefaultNetId());
    }

    private void dH(int i, int i2) {
        Iterator<Long> it = this.oes.iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue(), i, i2);
        }
        Iterator<ConnectionTypeObserver> it2 = this.oet.iterator();
        while (it2.hasNext()) {
            it2.next().MA(i);
        }
    }

    void M(double d) {
        Iterator<Long> it = this.oes.iterator();
        while (it.hasNext()) {
            nativeNotifyMaxBandwidthChanged(it.next().longValue(), d);
        }
    }

    void dI(int i, int i2) {
        Iterator<Long> it = this.oes.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), i, i2);
        }
    }

    void My(int i) {
        Iterator<Long> it = this.oes.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), i);
        }
    }

    void Mz(int i) {
        Iterator<Long> it = this.oes.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), i);
        }
    }

    void k(int[] iArr) {
        Iterator<Long> it = this.oes.iterator();
        while (it.hasNext()) {
            nativeNotifyPurgeActiveNetworkList(it.next().longValue(), iArr);
        }
    }
}
