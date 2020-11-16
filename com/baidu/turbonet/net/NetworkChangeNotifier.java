package com.baidu.turbonet.net;

import android.content.Context;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect;
import java.util.ArrayList;
import java.util.Iterator;
@JNINamespace
/* loaded from: classes12.dex */
public class NetworkChangeNotifier {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static NetworkChangeNotifier opf;
    private final Context mContext;
    private NetworkChangeNotifierAutoDetect opc;
    private int opd = 0;
    private double ope = Double.POSITIVE_INFINITY;
    private int mMaxBandwidthConnectionType = this.opd;
    private final ArrayList<Long> opa = new ArrayList<>();
    private final com.baidu.turbonet.base.b<ConnectionTypeObserver> opb = new com.baidu.turbonet.base.b<>();

    /* loaded from: classes12.dex */
    public interface ConnectionTypeObserver {
        void Nw(int i);
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
        if (opf == null) {
            opf = new NetworkChangeNotifier(context);
        }
        return opf;
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.opd;
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        if (this.opc == null) {
            return 0;
        }
        return this.opc.getCurrentConnectionSubtype(this.opc.getCurrentNetworkState());
    }

    @CalledByNative
    public double getCurrentMaxBandwidthInMbps() {
        return this.ope;
    }

    @CalledByNative
    public int getCurrentDefaultNetId() {
        if (this.opc == null) {
            return -1;
        }
        return this.opc.getDefaultNetId();
    }

    @CalledByNative
    public int[] getCurrentNetworksAndTypes() {
        return this.opc == null ? new int[0] : this.opc.getNetworksAndTypes();
    }

    public static double Nr(int i) {
        return nativeGetMaxBandwidthForConnectionSubtype(i);
    }

    @CalledByNative
    public void addNativeObserver(long j) {
        this.opa.add(Long.valueOf(j));
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        this.opa.remove(Long.valueOf(j));
    }

    public static NetworkChangeNotifier ebQ() {
        if ($assertionsDisabled || opf != null) {
            return opf;
        }
        throw new AssertionError();
    }

    public static void ebR() {
        ebQ().a(true, (NetworkChangeNotifierAutoDetect.RegistrationPolicy) new RegistrationPolicyAlwaysRegister());
    }

    private void ebS() {
        if (this.opc != null) {
            this.opc.destroy();
            this.opc = null;
        }
    }

    private void a(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (z) {
            if (this.opc == null) {
                this.opc = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifierAutoDetect.Observer() { // from class: com.baidu.turbonet.net.NetworkChangeNotifier.1
                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Nw(int i) {
                        NetworkChangeNotifier.this.Ns(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void N(double d) {
                        NetworkChangeNotifier.this.L(d);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void dN(int i, int i2) {
                        NetworkChangeNotifier.this.dM(i, i2);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Nx(int i) {
                        NetworkChangeNotifier.this.Nu(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Ny(int i) {
                        NetworkChangeNotifier.this.Nv(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void q(int[] iArr) {
                        NetworkChangeNotifier.this.p(iArr);
                    }
                }, this.mContext, registrationPolicy);
                NetworkChangeNotifierAutoDetect.c currentNetworkState = this.opc.getCurrentNetworkState();
                Ns(this.opc.getCurrentConnectionType(currentNetworkState));
                L(this.opc.getCurrentMaxBandwidthInMbps(currentNetworkState));
                return;
            }
            return;
        }
        ebS();
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        ebQ().zA(z);
    }

    private void zA(boolean z) {
        if ((this.opd != 6) != z) {
            Ns(z ? 0 : 6);
            L(z ? Double.POSITIVE_INFINITY : 0.0d);
        }
    }

    @CalledByNative
    public static void fakeNetworkConnected(int i, int i2) {
        ebQ().dM(i, i2);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(int i) {
        ebQ().Nu(i);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(int i) {
        ebQ().Nv(i);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(int[] iArr) {
        ebQ().p(iArr);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(int i, int i2) {
        ebQ().dL(i2, i);
    }

    @CalledByNative
    public static void fakeMaxBandwidthChanged(double d) {
        ebQ().M(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ns(int i) {
        this.opd = i;
        Nt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(double d) {
        if (d != this.ope || this.opd != this.mMaxBandwidthConnectionType) {
            this.ope = d;
            this.mMaxBandwidthConnectionType = this.opd;
            M(d);
        }
    }

    void Nt(int i) {
        dL(i, getCurrentDefaultNetId());
    }

    private void dL(int i, int i2) {
        Iterator<Long> it = this.opa.iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue(), i, i2);
        }
        Iterator<ConnectionTypeObserver> it2 = this.opb.iterator();
        while (it2.hasNext()) {
            it2.next().Nw(i);
        }
    }

    void M(double d) {
        Iterator<Long> it = this.opa.iterator();
        while (it.hasNext()) {
            nativeNotifyMaxBandwidthChanged(it.next().longValue(), d);
        }
    }

    void dM(int i, int i2) {
        Iterator<Long> it = this.opa.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), i, i2);
        }
    }

    void Nu(int i) {
        Iterator<Long> it = this.opa.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), i);
        }
    }

    void Nv(int i) {
        Iterator<Long> it = this.opa.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), i);
        }
    }

    void p(int[] iArr) {
        Iterator<Long> it = this.opa.iterator();
        while (it.hasNext()) {
            nativeNotifyPurgeActiveNetworkList(it.next().longValue(), iArr);
        }
    }
}
