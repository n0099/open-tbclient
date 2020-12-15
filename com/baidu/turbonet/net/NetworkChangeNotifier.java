package com.baidu.turbonet.net;

import android.content.Context;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect;
import java.util.ArrayList;
import java.util.Iterator;
@JNINamespace
/* loaded from: classes14.dex */
public class NetworkChangeNotifier {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static NetworkChangeNotifier oEf;
    private final Context mContext;
    private NetworkChangeNotifierAutoDetect oEc;
    private int oEd = 0;
    private double oEe = Double.POSITIVE_INFINITY;
    private int mMaxBandwidthConnectionType = this.oEd;
    private final ArrayList<Long> oEa = new ArrayList<>();
    private final com.baidu.turbonet.base.b<ConnectionTypeObserver> oEb = new com.baidu.turbonet.base.b<>();

    /* loaded from: classes14.dex */
    public interface ConnectionTypeObserver {
        void Oo(int i);
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
        if (oEf == null) {
            oEf = new NetworkChangeNotifier(context);
        }
        return oEf;
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.oEd;
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        if (this.oEc == null) {
            return 0;
        }
        return this.oEc.getCurrentConnectionSubtype(this.oEc.getCurrentNetworkState());
    }

    @CalledByNative
    public double getCurrentMaxBandwidthInMbps() {
        return this.oEe;
    }

    @CalledByNative
    public int getCurrentDefaultNetId() {
        if (this.oEc == null) {
            return -1;
        }
        return this.oEc.getDefaultNetId();
    }

    @CalledByNative
    public int[] getCurrentNetworksAndTypes() {
        return this.oEc == null ? new int[0] : this.oEc.getNetworksAndTypes();
    }

    public static double Oj(int i) {
        return nativeGetMaxBandwidthForConnectionSubtype(i);
    }

    @CalledByNative
    public void addNativeObserver(long j) {
        this.oEa.add(Long.valueOf(j));
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        this.oEa.remove(Long.valueOf(j));
    }

    public static NetworkChangeNotifier ehw() {
        if ($assertionsDisabled || oEf != null) {
            return oEf;
        }
        throw new AssertionError();
    }

    public static void ehx() {
        ehw().a(true, (NetworkChangeNotifierAutoDetect.RegistrationPolicy) new RegistrationPolicyAlwaysRegister());
    }

    private void ehy() {
        if (this.oEc != null) {
            this.oEc.destroy();
            this.oEc = null;
        }
    }

    private void a(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (z) {
            if (this.oEc == null) {
                this.oEc = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifierAutoDetect.Observer() { // from class: com.baidu.turbonet.net.NetworkChangeNotifier.1
                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Oo(int i) {
                        NetworkChangeNotifier.this.Ok(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void P(double d) {
                        NetworkChangeNotifier.this.N(d);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void dS(int i, int i2) {
                        NetworkChangeNotifier.this.dR(i, i2);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Op(int i) {
                        NetworkChangeNotifier.this.Om(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void Oq(int i) {
                        NetworkChangeNotifier.this.On(i);
                    }

                    @Override // com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.Observer
                    public void q(int[] iArr) {
                        NetworkChangeNotifier.this.p(iArr);
                    }
                }, this.mContext, registrationPolicy);
                NetworkChangeNotifierAutoDetect.c currentNetworkState = this.oEc.getCurrentNetworkState();
                Ok(this.oEc.getCurrentConnectionType(currentNetworkState));
                N(this.oEc.getCurrentMaxBandwidthInMbps(currentNetworkState));
                return;
            }
            return;
        }
        ehy();
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        ehw().Ae(z);
    }

    private void Ae(boolean z) {
        if ((this.oEd != 6) != z) {
            Ok(z ? 0 : 6);
            N(z ? Double.POSITIVE_INFINITY : 0.0d);
        }
    }

    @CalledByNative
    public static void fakeNetworkConnected(int i, int i2) {
        ehw().dR(i, i2);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(int i) {
        ehw().Om(i);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(int i) {
        ehw().On(i);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(int[] iArr) {
        ehw().p(iArr);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(int i, int i2) {
        ehw().dQ(i2, i);
    }

    @CalledByNative
    public static void fakeMaxBandwidthChanged(double d) {
        ehw().O(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ok(int i) {
        this.oEd = i;
        Ol(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(double d) {
        if (d != this.oEe || this.oEd != this.mMaxBandwidthConnectionType) {
            this.oEe = d;
            this.mMaxBandwidthConnectionType = this.oEd;
            O(d);
        }
    }

    void Ol(int i) {
        dQ(i, getCurrentDefaultNetId());
    }

    private void dQ(int i, int i2) {
        Iterator<Long> it = this.oEa.iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue(), i, i2);
        }
        Iterator<ConnectionTypeObserver> it2 = this.oEb.iterator();
        while (it2.hasNext()) {
            it2.next().Oo(i);
        }
    }

    void O(double d) {
        Iterator<Long> it = this.oEa.iterator();
        while (it.hasNext()) {
            nativeNotifyMaxBandwidthChanged(it.next().longValue(), d);
        }
    }

    void dR(int i, int i2) {
        Iterator<Long> it = this.oEa.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), i, i2);
        }
    }

    void Om(int i) {
        Iterator<Long> it = this.oEa.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), i);
        }
    }

    void On(int i) {
        Iterator<Long> it = this.oEa.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), i);
        }
    }

    void p(int[] iArr) {
        Iterator<Long> it = this.oEa.iterator();
        while (it.hasNext()) {
            nativeNotifyPurgeActiveNetworkList(it.next().longValue(), iArr);
        }
    }
}
