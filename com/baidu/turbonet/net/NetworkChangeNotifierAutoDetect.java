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
/* loaded from: classes5.dex */
public class NetworkChangeNotifierAutoDetect extends BroadcastReceiver {
    public static final String TAG = NetworkChangeNotifierAutoDetect.class.getSimpleName();
    public static final int UNKNOWN_LINK_SPEED = -1;
    public int mConnectionType;
    public b mConnectivityManagerDelegate;
    public final Context mContext;
    public boolean mIgnoreNextBroadcast;
    public final NetworkConnectivityIntentFilter mIntentFilter;
    public int mMaxBandwidthConnectionType;
    public double mMaxBandwidthMbps;
    public final c mNetworkCallback;
    public final NetworkRequest mNetworkRequest;
    public final Observer mObserver;
    public boolean mRegistered;
    public final RegistrationPolicy mRegistrationPolicy;
    public boolean mShouldSignalObserver;
    public e mWifiManagerDelegate;
    public String mWifiSSID;
    public final Looper mLooper = Looper.myLooper();
    public final Handler mHandler = new Handler(this.mLooper);

    /* loaded from: classes5.dex */
    public static class NetworkConnectivityIntentFilter extends IntentFilter {
        public NetworkConnectivityIntentFilter(boolean z) {
            addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (z) {
                addAction("android.net.wifi.RSSI_CHANGED");
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface Observer {
        void a(double d2);

        void b(int i, int i2);

        void c(int i);

        void d(int[] iArr);

        void e(int i);

        void onConnectionTypeChanged(int i);
    }

    /* loaded from: classes5.dex */
    public static abstract class RegistrationPolicy {

        /* renamed from: a  reason: collision with root package name */
        public NetworkChangeNotifierAutoDetect f22447a;

        public abstract void a();

        public void b(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
            this.f22447a = networkChangeNotifierAutoDetect;
        }

        public final void c() {
            this.f22447a.register();
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NetworkChangeNotifierAutoDetect.this.mRegistered) {
                if (NetworkChangeNotifierAutoDetect.this.mIgnoreNextBroadcast) {
                    NetworkChangeNotifierAutoDetect.this.mIgnoreNextBroadcast = false;
                    return;
                }
                d currentNetworkState = NetworkChangeNotifierAutoDetect.this.getCurrentNetworkState();
                NetworkChangeNotifierAutoDetect.this.connectionTypeChanged(currentNetworkState);
                NetworkChangeNotifierAutoDetect.this.maxBandwidthChanged(currentNetworkState);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final ConnectivityManager f22449a;

        public b(Context context) {
            this.f22449a = (ConnectivityManager) context.getSystemService("connectivity");
        }

        @TargetApi(21)
        public Network[] a() {
            return this.f22449a.getAllNetworks();
        }

        @TargetApi(21)
        public int b() {
            Network[] allNetworksFiltered;
            NetworkInfo activeNetworkInfo = this.f22449a.getActiveNetworkInfo();
            int i = -1;
            if (activeNetworkInfo == null) {
                return -1;
            }
            for (Network network : NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(this, null)) {
                NetworkInfo d2 = d(network);
                if (d2 != null && (d2.getType() == activeNetworkInfo.getType() || d2.getType() == 17)) {
                    i = NetworkChangeNotifierAutoDetect.networkToNetId(network);
                }
            }
            return i;
        }

        @TargetApi(21)
        public NetworkCapabilities c(Network network) {
            return this.f22449a.getNetworkCapabilities(network);
        }

        public final NetworkInfo d(Network network) {
            try {
                try {
                    return this.f22449a.getNetworkInfo(network);
                } catch (NullPointerException unused) {
                    return null;
                }
            } catch (NullPointerException unused2) {
                return this.f22449a.getNetworkInfo(network);
            }
        }

        public d e() {
            return g(this.f22449a.getActiveNetworkInfo());
        }

        @TargetApi(21)
        public d f(Network network) {
            NetworkInfo d2 = d(network);
            if (d2 != null && d2.getType() == 17) {
                return e();
            }
            return g(d2);
        }

        public d g(NetworkInfo networkInfo) {
            if (networkInfo != null && networkInfo.isConnected()) {
                return new d(true, networkInfo.getType(), networkInfo.getSubtype());
            }
            return new d(false, -1, -1);
        }

        @TargetApi(21)
        public void h(NetworkRequest networkRequest, ConnectivityManager.NetworkCallback networkCallback) {
            this.f22449a.registerNetworkCallback(networkRequest, networkCallback);
        }

        @TargetApi(21)
        public void i(ConnectivityManager.NetworkCallback networkCallback) {
            this.f22449a.unregisterNetworkCallback(networkCallback);
        }

        @TargetApi(21)
        public boolean j(Network network) {
            try {
                network.getSocketFactory().createSocket().close();
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f22465a;

        /* renamed from: b  reason: collision with root package name */
        public final int f22466b;

        /* renamed from: c  reason: collision with root package name */
        public final int f22467c;

        public d(boolean z, int i, int i2) {
            this.f22465a = z;
            this.f22466b = i;
            this.f22467c = i2;
        }

        public int a() {
            return this.f22467c;
        }

        public int b() {
            return this.f22466b;
        }

        public boolean c() {
            return this.f22465a;
        }
    }

    /* loaded from: classes5.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final Context f22468a;

        /* renamed from: b  reason: collision with root package name */
        public final WifiManager f22469b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f22470c;

        public e(Context context) {
            this.f22468a = context;
            boolean z = context.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", this.f22468a.getPackageName()) == 0;
            this.f22470c = z;
            this.f22469b = z ? (WifiManager) this.f22468a.getSystemService("wifi") : null;
        }

        public boolean a() {
            return this.f22470c;
        }

        public int b() {
            WifiInfo c2;
            if (!this.f22470c || this.f22469b == null || (c2 = c()) == null) {
                return -1;
            }
            return c2.getLinkSpeed();
        }

        public final WifiInfo c() {
            try {
                try {
                    return this.f22469b.getConnectionInfo();
                } catch (NullPointerException unused) {
                    return null;
                }
            } catch (NullPointerException unused2) {
                return this.f22469b.getConnectionInfo();
            }
        }

        public String d() {
            WifiInfo wifiInfo;
            String ssid;
            Intent registerReceiver = this.f22468a.registerReceiver(null, new IntentFilter(McastConfig.ACTION_NETWORK_STATE_CHANGED));
            return (registerReceiver == null || (wifiInfo = (WifiInfo) registerReceiver.getParcelableExtra("wifiInfo")) == null || (ssid = wifiInfo.getSSID()) == null) ? "" : ssid;
        }
    }

    @TargetApi(21)
    public NetworkChangeNotifierAutoDetect(Observer observer, Context context, RegistrationPolicy registrationPolicy) {
        this.mObserver = observer;
        this.mContext = context.getApplicationContext();
        this.mConnectivityManagerDelegate = new b(context);
        this.mWifiManagerDelegate = new e(context);
        if (Build.VERSION.SDK_INT >= 21) {
            this.mNetworkCallback = new c(this, null);
            this.mNetworkRequest = new NetworkRequest.Builder().addCapability(12).removeCapability(15).build();
        } else {
            this.mNetworkCallback = null;
            this.mNetworkRequest = null;
        }
        d e2 = this.mConnectivityManagerDelegate.e();
        this.mConnectionType = getCurrentConnectionType(e2);
        this.mWifiSSID = getCurrentWifiSSID(e2);
        this.mMaxBandwidthMbps = getCurrentMaxBandwidthInMbps(e2);
        this.mMaxBandwidthConnectionType = this.mConnectionType;
        this.mIntentFilter = new NetworkConnectivityIntentFilter(this.mWifiManagerDelegate.a());
        this.mIgnoreNextBroadcast = false;
        this.mShouldSignalObserver = false;
        this.mRegistrationPolicy = registrationPolicy;
        registrationPolicy.b(this);
        this.mShouldSignalObserver = true;
    }

    private void assertOnThread() {
        if (!onThread()) {
            throw new IllegalStateException("Must be called on NetworkChangeNotifierAutoDetect thread.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectionTypeChanged(d dVar) {
        int currentConnectionType = getCurrentConnectionType(dVar);
        String currentWifiSSID = getCurrentWifiSSID(dVar);
        if (currentConnectionType == this.mConnectionType && currentWifiSSID.equals(this.mWifiSSID)) {
            return;
        }
        this.mConnectionType = currentConnectionType;
        this.mWifiSSID = currentWifiSSID;
        String str = TAG;
        Log.d(str, "Network connectivity changed, type is: " + this.mConnectionType);
        this.mObserver.onConnectionTypeChanged(currentConnectionType);
    }

    @TargetApi(21)
    public static Network[] getAllNetworksFiltered(b bVar, Network network) {
        NetworkCapabilities c2;
        Network[] a2 = bVar.a();
        int i = 0;
        for (Network network2 : a2) {
            if (!network2.equals(network) && (c2 = bVar.c(network2)) != null && c2.hasCapability(12)) {
                if (c2.hasTransport(4)) {
                    if (bVar.j(network2)) {
                        return new Network[]{network2};
                    }
                } else {
                    a2[i] = network2;
                    i++;
                }
            }
        }
        return (Network[]) Arrays.copyOf(a2, i);
    }

    private String getCurrentWifiSSID(d dVar) {
        return getCurrentConnectionType(dVar) != 2 ? "" : this.mWifiManagerDelegate.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maxBandwidthChanged(d dVar) {
        double currentMaxBandwidthInMbps = getCurrentMaxBandwidthInMbps(dVar);
        if (currentMaxBandwidthInMbps == this.mMaxBandwidthMbps && this.mConnectionType == this.mMaxBandwidthConnectionType) {
            return;
        }
        this.mMaxBandwidthMbps = currentMaxBandwidthInMbps;
        this.mMaxBandwidthConnectionType = this.mConnectionType;
        this.mObserver.a(currentMaxBandwidthInMbps);
    }

    @TargetApi(21)
    public static int networkToNetId(Network network) {
        return Integer.parseInt(network.toString());
    }

    private boolean onThread() {
        return this.mLooper == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnThread(Runnable runnable) {
        if (onThread()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }

    public void destroy() {
        assertOnThread();
        this.mRegistrationPolicy.a();
        unregister();
    }

    public int getCurrentConnectionSubtype(d dVar) {
        if (dVar.c()) {
            if (dVar.b() != 0) {
                return 0;
            }
            switch (dVar.a()) {
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
        }
        return 1;
    }

    public int getCurrentConnectionType(d dVar) {
        if (dVar.c()) {
            int b2 = dVar.b();
            if (b2 == 0) {
                switch (dVar.a()) {
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
            } else if (b2 != 1) {
                if (b2 != 6) {
                    if (b2 != 7) {
                        return b2 != 9 ? 0 : 1;
                    }
                    return 7;
                }
                return 5;
            } else {
                return 2;
            }
        }
        return 6;
    }

    public double getCurrentMaxBandwidthInMbps(d dVar) {
        int b2;
        return (getCurrentConnectionType(dVar) != 2 || (b2 = this.mWifiManagerDelegate.b()) == -1) ? NetworkChangeNotifier.f(getCurrentConnectionSubtype(dVar)) : b2;
    }

    public d getCurrentNetworkState() {
        return this.mConnectivityManagerDelegate.e();
    }

    public int getDefaultNetId() {
        if (Build.VERSION.SDK_INT < 21) {
            return -1;
        }
        return this.mConnectivityManagerDelegate.b();
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
            iArr[i2] = getCurrentConnectionType(this.mConnectivityManagerDelegate.f(network));
        }
        return iArr;
    }

    public RegistrationPolicy getRegistrationPolicy() {
        return this.mRegistrationPolicy;
    }

    public boolean isReceiverRegisteredForTesting() {
        return this.mRegistered;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        runOnThread(new a());
    }

    public void register() {
        assertOnThread();
        if (this.mRegistered) {
            return;
        }
        if (this.mShouldSignalObserver) {
            d currentNetworkState = getCurrentNetworkState();
            connectionTypeChanged(currentNetworkState);
            maxBandwidthChanged(currentNetworkState);
        }
        this.mIgnoreNextBroadcast = this.mContext.registerReceiver(this, this.mIntentFilter) != null;
        this.mRegistered = true;
        c cVar = this.mNetworkCallback;
        if (cVar != null) {
            cVar.d();
            this.mConnectivityManagerDelegate.h(this.mNetworkRequest, this.mNetworkCallback);
            if (this.mShouldSignalObserver) {
                Network[] allNetworksFiltered = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
                int[] iArr = new int[allNetworksFiltered.length];
                for (int i = 0; i < allNetworksFiltered.length; i++) {
                    iArr[i] = networkToNetId(allNetworksFiltered[i]);
                }
                this.mObserver.d(iArr);
            }
        }
    }

    public void setConnectivityManagerDelegateForTests(b bVar) {
        this.mConnectivityManagerDelegate = bVar;
    }

    public void setWifiManagerDelegateForTests(e eVar) {
        this.mWifiManagerDelegate = eVar;
    }

    public void unregister() {
        assertOnThread();
        if (this.mRegistered) {
            this.mContext.unregisterReceiver(this);
            this.mRegistered = false;
            c cVar = this.mNetworkCallback;
            if (cVar != null) {
                this.mConnectivityManagerDelegate.i(cVar);
            }
        }
    }

    @TargetApi(21)
    /* loaded from: classes5.dex */
    public class c extends ConnectivityManager.NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        public Network f22450a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f22452e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f22453f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ boolean f22454g;

            public a(int i, int i2, boolean z) {
                this.f22452e = i;
                this.f22453f = i2;
                this.f22454g = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetworkChangeNotifierAutoDetect.this.mObserver.b(this.f22452e, this.f22453f);
                if (this.f22454g) {
                    NetworkChangeNotifierAutoDetect.this.mObserver.onConnectionTypeChanged(this.f22453f);
                    NetworkChangeNotifierAutoDetect.this.mObserver.d(new int[]{this.f22452e});
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f22456e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f22457f;

            public b(int i, int i2) {
                this.f22456e = i;
                this.f22457f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetworkChangeNotifierAutoDetect.this.mObserver.b(this.f22456e, this.f22457f);
            }
        }

        /* renamed from: com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect$c$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0236c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f22459e;

            public RunnableC0236c(int i) {
                this.f22459e = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetworkChangeNotifierAutoDetect.this.mObserver.c(this.f22459e);
            }
        }

        /* loaded from: classes5.dex */
        public class d implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Network f22461e;

            public d(Network network) {
                this.f22461e = network;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetworkChangeNotifierAutoDetect.this.mObserver.e(NetworkChangeNotifierAutoDetect.networkToNetId(this.f22461e));
            }
        }

        /* loaded from: classes5.dex */
        public class e implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f22463e;

            public e(int i) {
                this.f22463e = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetworkChangeNotifierAutoDetect.this.mObserver.onConnectionTypeChanged(this.f22463e);
            }
        }

        public c() {
            this.f22450a = null;
        }

        public final boolean a(Network network, NetworkCapabilities networkCapabilities) {
            if (networkCapabilities == null) {
                networkCapabilities = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.c(network);
            }
            return networkCapabilities == null || (networkCapabilities.hasTransport(4) && !NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.j(network));
        }

        public final boolean b(Network network, NetworkCapabilities networkCapabilities) {
            return c(network) || a(network, networkCapabilities);
        }

        public final boolean c(Network network) {
            Network network2 = this.f22450a;
            return (network2 == null || network2.equals(network)) ? false : true;
        }

        public void d() {
            NetworkCapabilities c2;
            Network[] allNetworksFiltered = NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate, null);
            this.f22450a = null;
            if (allNetworksFiltered.length == 1 && (c2 = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.c(allNetworksFiltered[0])) != null && c2.hasTransport(4)) {
                this.f22450a = allNetworksFiltered[0];
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            NetworkCapabilities c2 = NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate.c(network);
            if (b(network, c2)) {
                return;
            }
            boolean hasTransport = c2.hasTransport(4);
            if (hasTransport) {
                this.f22450a = network;
            }
            int networkToNetId = NetworkChangeNotifierAutoDetect.networkToNetId(network);
            NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = NetworkChangeNotifierAutoDetect.this;
            NetworkChangeNotifierAutoDetect.this.runOnThread(new a(networkToNetId, networkChangeNotifierAutoDetect.getCurrentConnectionType(networkChangeNotifierAutoDetect.mConnectivityManagerDelegate.f(network)), hasTransport));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            if (b(network, networkCapabilities)) {
                return;
            }
            int networkToNetId = NetworkChangeNotifierAutoDetect.networkToNetId(network);
            NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = NetworkChangeNotifierAutoDetect.this;
            NetworkChangeNotifierAutoDetect.this.runOnThread(new b(networkToNetId, networkChangeNotifierAutoDetect.getCurrentConnectionType(networkChangeNotifierAutoDetect.mConnectivityManagerDelegate.f(network))));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i) {
            if (b(network, null)) {
                return;
            }
            NetworkChangeNotifierAutoDetect.this.runOnThread(new RunnableC0236c(NetworkChangeNotifierAutoDetect.networkToNetId(network)));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            if (c(network)) {
                return;
            }
            NetworkChangeNotifierAutoDetect.this.runOnThread(new d(network));
            if (this.f22450a != null) {
                this.f22450a = null;
                for (Network network2 : NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(NetworkChangeNotifierAutoDetect.this.mConnectivityManagerDelegate, network)) {
                    onAvailable(network2);
                }
                NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = NetworkChangeNotifierAutoDetect.this;
                NetworkChangeNotifierAutoDetect.this.runOnThread(new e(networkChangeNotifierAutoDetect.getCurrentConnectionType(networkChangeNotifierAutoDetect.mConnectivityManagerDelegate.e())));
            }
        }

        public /* synthetic */ c(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect, a aVar) {
            this();
        }
    }
}
