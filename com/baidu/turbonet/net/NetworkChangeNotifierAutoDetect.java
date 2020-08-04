package com.baidu.turbonet.net;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.android.imsdk.mcast.McastConfig;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes19.dex */
public class NetworkChangeNotifierAutoDetect extends BroadcastReceiver {
    private static final String TAG = NetworkChangeNotifierAutoDetect.class.getSimpleName();
    private static final int UNKNOWN_LINK_SPEED = -1;
    private int mConnectionType;
    private a mConnectivityManagerDelegate;
    private final Context mContext;
    private boolean mIgnoreNextBroadcast;
    private final NetworkConnectivityIntentFilter mIntentFilter;
    private int mMaxBandwidthConnectionType;
    private double mMaxBandwidthMbps;
    private final b mNetworkCallback;
    private final NetworkRequest mNetworkRequest;
    private final Observer mObserver;
    private boolean mRegistered;
    private final RegistrationPolicy mRegistrationPolicy;
    private boolean mShouldSignalObserver;
    private d mWifiManagerDelegate;
    private String mWifiSSID;
    private final Looper mLooper = Looper.myLooper();
    private final Handler mHandler = new Handler(this.mLooper);

    /* loaded from: classes19.dex */
    public interface Observer {
        void D(double d);

        void HN(int i);

        void HO(int i);

        void HP(int i);

        void dt(int i, int i2);

        void l(int[] iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public static class c {
        private final boolean mJx;
        private final int mJy;
        private final int mType;

        public c(boolean z, int i, int i2) {
            this.mJx = z;
            this.mType = i;
            this.mJy = i2;
        }

        public boolean isConnected() {
            return this.mJx;
        }

        public int getNetworkType() {
            return this.mType;
        }

        public int dyR() {
            return this.mJy;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public static class a {
        static final /* synthetic */ boolean $assertionsDisabled;
        private final ConnectivityManager mConnectivityManager;

        static {
            $assertionsDisabled = !NetworkChangeNotifierAutoDetect.class.desiredAssertionStatus();
        }

        a(Context context) {
            this.mConnectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        }

        a() {
            this.mConnectivityManager = null;
        }

        c dyO() {
            return a(this.mConnectivityManager.getActiveNetworkInfo());
        }

        private NetworkInfo a(Network network) {
            try {
                return this.mConnectivityManager.getNetworkInfo(network);
            } catch (NullPointerException e) {
                try {
                    return this.mConnectivityManager.getNetworkInfo(network);
                } catch (NullPointerException e2) {
                    return null;
                }
            }
        }

        @TargetApi(21)
        c b(Network network) {
            NetworkInfo a = a(network);
            return (a == null || a.getType() != 17) ? a(a) : dyO();
        }

        c a(NetworkInfo networkInfo) {
            return (networkInfo == null || !networkInfo.isConnected()) ? new c(false, -1, -1) : new c(true, networkInfo.getType(), networkInfo.getSubtype());
        }

        @TargetApi(21)
        protected Network[] dyP() {
            return this.mConnectivityManager.getAllNetworks();
        }

        @TargetApi(21)
        protected boolean c(Network network) {
            try {
                network.getSocketFactory().createSocket().close();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        @TargetApi(21)
        protected NetworkCapabilities d(Network network) {
            return this.mConnectivityManager.getNetworkCapabilities(network);
        }

        @TargetApi(21)
        void a(NetworkRequest networkRequest, ConnectivityManager.NetworkCallback networkCallback) {
            this.mConnectivityManager.registerNetworkCallback(networkRequest, networkCallback);
        }

        @TargetApi(21)
        void a(ConnectivityManager.NetworkCallback networkCallback) {
            this.mConnectivityManager.unregisterNetworkCallback(networkCallback);
        }

        @TargetApi(21)
        int getDefaultNetId() {
            Network[] allNetworksFiltered;
            NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return -1;
            }
            int i = -1;
            for (Network network : NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(this, null)) {
                NetworkInfo a = a(network);
                if (a != null && (a.getType() == activeNetworkInfo.getType() || a.getType() == 17)) {
                    if (!$assertionsDisabled && i != -1) {
                        throw new AssertionError();
                    }
                    i = NetworkChangeNotifierAutoDetect.networkToNetId(network);
                }
            }
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public static class d {
        private final Context mContext;
        private final WifiManager mJA;
        private final boolean mJB;

        d(Context context) {
            this.mContext = context;
            this.mJB = this.mContext.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", this.mContext.getPackageName()) == 0;
            this.mJA = this.mJB ? (WifiManager) this.mContext.getSystemService("wifi") : null;
        }

        d() {
            this.mContext = null;
            this.mJA = null;
            this.mJB = false;
        }

        String getWifiSSID() {
            WifiInfo wifiInfo;
            String ssid;
            Intent registerReceiver = this.mContext.registerReceiver(null, new IntentFilter(McastConfig.ACTION_NETWORK_STATE_CHANGED));
            return (registerReceiver == null || (wifiInfo = (WifiInfo) registerReceiver.getParcelableExtra("wifiInfo")) == null || (ssid = wifiInfo.getSSID()) == null) ? "" : ssid;
        }

        private WifiInfo dyS() {
            try {
                return this.mJA.getConnectionInfo();
            } catch (NullPointerException e) {
                try {
                    return this.mJA.getConnectionInfo();
                } catch (NullPointerException e2) {
                    return null;
                }
            }
        }

        int dyT() {
            WifiInfo dyS;
            if (!this.mJB || this.mJA == null || (dyS = dyS()) == null) {
                return -1;
            }
            return dyS.getLinkSpeed();
        }

        boolean dyU() {
            return this.mJB;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(21)
    /* loaded from: classes19.dex */
    public class b extends ConnectivityManager.NetworkCallback {
        static final /* synthetic */ boolean $assertionsDisabled;
        private Network mJq;

        static {
            $assertionsDisabled = !NetworkChangeNotifierAutoDetect.class.desiredAssertionStatus();
        }

        private b() {
            this.mJq = null;
        }

        void dyQ() {
            NetworkCapabilities d;
            Network[] allNetworksFiltered = NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate, null);
            this.mJq = null;
            if (allNetworksFiltered.length == 1 && (d = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.d(allNetworksFiltered[0])) != null && d.hasTransport(4)) {
                this.mJq = allNetworksFiltered[0];
            }
        }

        private boolean e(Network network) {
            return (this.mJq == null || this.mJq.equals(network)) ? false : true;
        }

        private boolean a(Network network, NetworkCapabilities networkCapabilities) {
            if (networkCapabilities == null) {
                networkCapabilities = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.d(network);
            }
            return networkCapabilities == null || (networkCapabilities.hasTransport(4) && !NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.c(network));
        }

        private boolean b(Network network, NetworkCapabilities networkCapabilities) {
            return e(network) || a(network, networkCapabilities);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            NetworkCapabilities d = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.d(network);
            if (!b(network, d)) {
                final boolean hasTransport = d.hasTransport(4);
                if (hasTransport) {
                    this.mJq = network;
                }
                final int networkToNetId = NetworkChangeNotifierAutoDetect.networkToNetId(network);
                final int currentConnectionType = NetworkChangeNotifierAutoDetect.this.getCurrentConnectionType(NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.b(network));
                NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NetworkChangeNotifierAutoDetect.this.mObserver.dt(networkToNetId, currentConnectionType);
                        if (hasTransport) {
                            NetworkChangeNotifierAutoDetect.this.mObserver.HN(currentConnectionType);
                            NetworkChangeNotifierAutoDetect.this.mObserver.l(new int[]{networkToNetId});
                        }
                    }
                });
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            if (!b(network, networkCapabilities)) {
                final int networkToNetId = NetworkChangeNotifierAutoDetect.networkToNetId(network);
                final int currentConnectionType = NetworkChangeNotifierAutoDetect.this.getCurrentConnectionType(NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.b(network));
                NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        NetworkChangeNotifierAutoDetect.this.mObserver.dt(networkToNetId, currentConnectionType);
                    }
                });
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i) {
            if (!b(network, null)) {
                final int networkToNetId = NetworkChangeNotifierAutoDetect.networkToNetId(network);
                NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        NetworkChangeNotifierAutoDetect.this.mObserver.HO(networkToNetId);
                    }
                });
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(final Network network) {
            if (!e(network)) {
                NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        NetworkChangeNotifierAutoDetect.this.mObserver.HP(NetworkChangeNotifierAutoDetect.networkToNetId(network));
                    }
                });
                if (this.mJq != null) {
                    if (!$assertionsDisabled && !network.equals(this.mJq)) {
                        throw new AssertionError();
                    }
                    this.mJq = null;
                    for (Network network2 : NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate, network)) {
                        onAvailable(network2);
                    }
                    final int currentConnectionType = NetworkChangeNotifierAutoDetect.this.getCurrentConnectionType(NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.dyO());
                    NetworkChangeNotifierAutoDetect.this.runOnThread(new Runnable() { // from class: com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.b.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NetworkChangeNotifierAutoDetect.this.mObserver.HN(currentConnectionType);
                        }
                    });
                }
            }
        }
    }

    /* loaded from: classes19.dex */
    public static abstract class RegistrationPolicy {
        static final /* synthetic */ boolean $assertionsDisabled;
        private NetworkChangeNotifierAutoDetect mJz;

        protected abstract void destroy();

        static {
            $assertionsDisabled = !NetworkChangeNotifierAutoDetect.class.desiredAssertionStatus();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void register() {
            if (!$assertionsDisabled && this.mJz == null) {
                throw new AssertionError();
            }
            this.mJz.register();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void a(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
            this.mJz = networkChangeNotifierAutoDetect;
        }
    }

    @TargetApi(21)
    public NetworkChangeNotifierAutoDetect(Observer observer, Context context, RegistrationPolicy registrationPolicy) {
        this.mObserver = observer;
        this.mContext = context.getApplicationContext();
        this.mConnectivityManagerDelegate = new a(context);
        this.mWifiManagerDelegate = new d(context);
        if (Build.VERSION.SDK_INT >= 21) {
            this.mNetworkCallback = new b();
            this.mNetworkRequest = new NetworkRequest.Builder().addCapability(12).removeCapability(15).build();
        } else {
            this.mNetworkCallback = null;
            this.mNetworkRequest = null;
        }
        c dyO = this.mConnectivityManagerDelegate.dyO();
        this.mConnectionType = getCurrentConnectionType(dyO);
        this.mWifiSSID = getCurrentWifiSSID(dyO);
        this.mMaxBandwidthMbps = getCurrentMaxBandwidthInMbps(dyO);
        this.mMaxBandwidthConnectionType = this.mConnectionType;
        this.mIntentFilter = new NetworkConnectivityIntentFilter(this.mWifiManagerDelegate.dyU());
        this.mIgnoreNextBroadcast = false;
        this.mShouldSignalObserver = false;
        this.mRegistrationPolicy = registrationPolicy;
        this.mRegistrationPolicy.a(this);
        this.mShouldSignalObserver = true;
    }

    private boolean onThread() {
        return this.mLooper == Looper.myLooper();
    }

    private void assertOnThread() {
        if (!onThread()) {
            throw new IllegalStateException("Must be called on NetworkChangeNotifierAutoDetect thread.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnThread(Runnable runnable) {
        if (onThread()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }

    void setConnectivityManagerDelegateForTests(a aVar) {
        this.mConnectivityManagerDelegate = aVar;
    }

    void setWifiManagerDelegateForTests(d dVar) {
        this.mWifiManagerDelegate = dVar;
    }

    RegistrationPolicy getRegistrationPolicy() {
        return this.mRegistrationPolicy;
    }

    boolean isReceiverRegisteredForTesting() {
        return this.mRegistered;
    }

    public void destroy() {
        assertOnThread();
        this.mRegistrationPolicy.destroy();
        unregister();
    }

    public void register() {
        assertOnThread();
        if (!this.mRegistered) {
            if (this.mShouldSignalObserver) {
                c currentNetworkState = getCurrentNetworkState();
                connectionTypeChanged(currentNetworkState);
                maxBandwidthChanged(currentNetworkState);
            }
            this.mIgnoreNextBroadcast = this.mContext.registerReceiver(this, this.mIntentFilter) != null;
            this.mRegistered = true;
            if (this.mNetworkCallback != null) {
                this.mNetworkCallback.dyQ();
                this.mConnectivityManagerDelegate.a(this.mNetworkRequest, this.mNetworkCallback);
                if (this.mShouldSignalObserver) {
                    Network[] allNetworksFiltered = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
                    int[] iArr = new int[allNetworksFiltered.length];
                    for (int i = 0; i < allNetworksFiltered.length; i++) {
                        iArr[i] = networkToNetId(allNetworksFiltered[i]);
                    }
                    this.mObserver.l(iArr);
                }
            }
        }
    }

    public void unregister() {
        assertOnThread();
        if (this.mRegistered) {
            this.mContext.unregisterReceiver(this);
            this.mRegistered = false;
            if (this.mNetworkCallback != null) {
                this.mConnectivityManagerDelegate.a(this.mNetworkCallback);
            }
        }
    }

    public c getCurrentNetworkState() {
        return this.mConnectivityManagerDelegate.dyO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(21)
    public static Network[] getAllNetworksFiltered(a aVar, Network network) {
        NetworkCapabilities d2;
        Network[] dyP = aVar.dyP();
        int i = 0;
        for (Network network2 : dyP) {
            if (!network2.equals(network) && (d2 = aVar.d(network2)) != null && d2.hasCapability(12)) {
                if (d2.hasTransport(4)) {
                    if (aVar.c(network2)) {
                        return new Network[]{network2};
                    }
                } else {
                    dyP[i] = network2;
                    i++;
                }
            }
        }
        return (Network[]) Arrays.copyOf(dyP, i);
    }

    public int[] getNetworksAndTypes() {
        if (Build.VERSION.SDK_INT < 21) {
            return new int[0];
        }
        Network[] allNetworksFiltered = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
        int[] iArr = new int[allNetworksFiltered.length * 2];
        int i = 0;
        for (Network network : allNetworksFiltered) {
            int i2 = i + 1;
            iArr[i] = networkToNetId(network);
            i = i2 + 1;
            iArr[i2] = getCurrentConnectionType(this.mConnectivityManagerDelegate.b(network));
        }
        return iArr;
    }

    public int getDefaultNetId() {
        if (Build.VERSION.SDK_INT < 21) {
            return -1;
        }
        return this.mConnectivityManagerDelegate.getDefaultNetId();
    }

    public int getCurrentConnectionType(c cVar) {
        if (!cVar.isConnected()) {
            return 6;
        }
        switch (cVar.getNetworkType()) {
            case 0:
                switch (cVar.dyR()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 3;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 4;
                    case 13:
                        return 5;
                    default:
                        return 0;
                }
            case 1:
                return 2;
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            default:
                return 0;
            case 6:
                return 5;
            case 7:
                return 7;
            case 9:
                return 1;
        }
    }

    public int getCurrentConnectionSubtype(c cVar) {
        if (!cVar.isConnected()) {
            return 1;
        }
        switch (cVar.getNetworkType()) {
            case 0:
                switch (cVar.dyR()) {
                    case 1:
                        return 7;
                    case 2:
                        return 8;
                    case 3:
                        return 9;
                    case 4:
                        return 5;
                    case 5:
                        return 10;
                    case 6:
                        return 11;
                    case 7:
                        return 6;
                    case 8:
                        return 14;
                    case 9:
                        return 15;
                    case 10:
                        return 12;
                    case 11:
                        return 4;
                    case 12:
                        return 13;
                    case 13:
                        return 18;
                    case 14:
                        return 16;
                    case 15:
                        return 17;
                    default:
                        return 0;
                }
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            default:
                return 0;
        }
    }

    public double getCurrentMaxBandwidthInMbps(c cVar) {
        int dyT;
        if (getCurrentConnectionType(cVar) == 2 && (dyT = this.mWifiManagerDelegate.dyT()) != -1) {
            return dyT;
        }
        return NetworkChangeNotifier.HI(getCurrentConnectionSubtype(cVar));
    }

    private String getCurrentWifiSSID(c cVar) {
        return getCurrentConnectionType(cVar) != 2 ? "" : this.mWifiManagerDelegate.getWifiSSID();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        runOnThread(new Runnable() { // from class: com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect.1
            @Override // java.lang.Runnable
            public void run() {
                if (NetworkChangeNotifierAutoDetect.this.mRegistered) {
                    if (NetworkChangeNotifierAutoDetect.this.mIgnoreNextBroadcast) {
                        NetworkChangeNotifierAutoDetect.this.mIgnoreNextBroadcast = false;
                        return;
                    }
                    c currentNetworkState = NetworkChangeNotifierAutoDetect.this.getCurrentNetworkState();
                    NetworkChangeNotifierAutoDetect.this.connectionTypeChanged(currentNetworkState);
                    NetworkChangeNotifierAutoDetect.this.maxBandwidthChanged(currentNetworkState);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectionTypeChanged(c cVar) {
        int currentConnectionType = getCurrentConnectionType(cVar);
        String currentWifiSSID = getCurrentWifiSSID(cVar);
        if (currentConnectionType != this.mConnectionType || !currentWifiSSID.equals(this.mWifiSSID)) {
            this.mConnectionType = currentConnectionType;
            this.mWifiSSID = currentWifiSSID;
            Log.d(TAG, "Network connectivity changed, type is: " + this.mConnectionType);
            this.mObserver.HN(currentConnectionType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maxBandwidthChanged(c cVar) {
        double currentMaxBandwidthInMbps = getCurrentMaxBandwidthInMbps(cVar);
        if (currentMaxBandwidthInMbps != this.mMaxBandwidthMbps || this.mConnectionType != this.mMaxBandwidthConnectionType) {
            this.mMaxBandwidthMbps = currentMaxBandwidthInMbps;
            this.mMaxBandwidthConnectionType = this.mConnectionType;
            this.mObserver.D(currentMaxBandwidthInMbps);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public static class NetworkConnectivityIntentFilter extends IntentFilter {
        NetworkConnectivityIntentFilter(boolean z) {
            addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (z) {
                addAction("android.net.wifi.RSSI_CHANGED");
            }
        }
    }

    @TargetApi(21)
    static int networkToNetId(Network network) {
        return Integer.parseInt(network.toString());
    }
}
