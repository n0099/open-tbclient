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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.mcast.McastConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class NetworkChangeNotifierAutoDetect extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG;
    public static final int UNKNOWN_LINK_SPEED = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mConnectionType;
    public b mConnectivityManagerDelegate;
    public final Context mContext;
    public final Handler mHandler;
    public boolean mIgnoreNextBroadcast;
    public final NetworkConnectivityIntentFilter mIntentFilter;
    public final Looper mLooper;
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

    /* loaded from: classes7.dex */
    public static class NetworkConnectivityIntentFilter extends IntentFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public NetworkConnectivityIntentFilter(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (z) {
                addAction("android.net.wifi.RSSI_CHANGED");
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface Observer {
        void a(int i2);

        void b(double d2);

        void c(int i2);

        void d(int i2);

        void e(int i2, int i3);

        void f(int[] iArr);
    }

    /* loaded from: classes7.dex */
    public static abstract class RegistrationPolicy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetworkChangeNotifierAutoDetect f59017a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(961941582, "Lcom/baidu/turbonet/net/NetworkChangeNotifierAutoDetect$RegistrationPolicy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(961941582, "Lcom/baidu/turbonet/net/NetworkChangeNotifierAutoDetect$RegistrationPolicy;");
                }
            }
        }

        public RegistrationPolicy() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public abstract void a();

        public void b(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkChangeNotifierAutoDetect) == null) {
                this.f59017a = networkChangeNotifierAutoDetect;
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f59017a.register();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NetworkChangeNotifierAutoDetect f59018e;

        public a(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {networkChangeNotifierAutoDetect};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59018e = networkChangeNotifierAutoDetect;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f59018e.mRegistered) {
                if (this.f59018e.mIgnoreNextBroadcast) {
                    this.f59018e.mIgnoreNextBroadcast = false;
                    return;
                }
                d currentNetworkState = this.f59018e.getCurrentNetworkState();
                this.f59018e.connectionTypeChanged(currentNetworkState);
                this.f59018e.maxBandwidthChanged(currentNetworkState);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ConnectivityManager f59019a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1561482693, "Lcom/baidu/turbonet/net/NetworkChangeNotifierAutoDetect$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1561482693, "Lcom/baidu/turbonet/net/NetworkChangeNotifierAutoDetect$b;");
                }
            }
        }

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f59019a = (ConnectivityManager) context.getSystemService("connectivity");
        }

        @TargetApi(21)
        public Network[] a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59019a.getAllNetworks() : (Network[]) invokeV.objValue;
        }

        @TargetApi(21)
        public int b() {
            InterceptResult invokeV;
            Network[] allNetworksFiltered;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                NetworkInfo activeNetworkInfo = this.f59019a.getActiveNetworkInfo();
                int i2 = -1;
                if (activeNetworkInfo == null) {
                    return -1;
                }
                for (Network network : NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(this, null)) {
                    NetworkInfo d2 = d(network);
                    if (d2 != null && (d2.getType() == activeNetworkInfo.getType() || d2.getType() == 17)) {
                        i2 = NetworkChangeNotifierAutoDetect.networkToNetId(network);
                    }
                }
                return i2;
            }
            return invokeV.intValue;
        }

        @TargetApi(21)
        public NetworkCapabilities c(Network network) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, network)) == null) ? this.f59019a.getNetworkCapabilities(network) : (NetworkCapabilities) invokeL.objValue;
        }

        public final NetworkInfo d(Network network) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, network)) == null) {
                try {
                    try {
                        return this.f59019a.getNetworkInfo(network);
                    } catch (NullPointerException unused) {
                        return this.f59019a.getNetworkInfo(network);
                    }
                } catch (NullPointerException unused2) {
                    return null;
                }
            }
            return (NetworkInfo) invokeL.objValue;
        }

        public d e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? g(this.f59019a.getActiveNetworkInfo()) : (d) invokeV.objValue;
        }

        @TargetApi(21)
        public d f(Network network) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, network)) == null) {
                NetworkInfo d2 = d(network);
                if (d2 != null && d2.getType() == 17) {
                    return e();
                }
                return g(d2);
            }
            return (d) invokeL.objValue;
        }

        public d g(NetworkInfo networkInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, networkInfo)) == null) {
                if (networkInfo != null && networkInfo.isConnected()) {
                    return new d(true, networkInfo.getType(), networkInfo.getSubtype());
                }
                return new d(false, -1, -1);
            }
            return (d) invokeL.objValue;
        }

        @TargetApi(21)
        public void h(NetworkRequest networkRequest, ConnectivityManager.NetworkCallback networkCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, networkRequest, networkCallback) == null) {
                this.f59019a.registerNetworkCallback(networkRequest, networkCallback);
            }
        }

        @TargetApi(21)
        public void i(ConnectivityManager.NetworkCallback networkCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, networkCallback) == null) {
                this.f59019a.unregisterNetworkCallback(networkCallback);
            }
        }

        @TargetApi(21)
        public boolean j(Network network) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, network)) == null) {
                try {
                    network.getSocketFactory().createSocket().close();
                    return true;
                } catch (IOException unused) {
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f59035a;

        /* renamed from: b  reason: collision with root package name */
        public final int f59036b;

        /* renamed from: c  reason: collision with root package name */
        public final int f59037c;

        public d(boolean z, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59035a = z;
            this.f59036b = i2;
            this.f59037c = i3;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59037c : invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59036b : invokeV.intValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59035a : invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Context f59038a;

        /* renamed from: b  reason: collision with root package name */
        public final WifiManager f59039b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f59040c;

        public e(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59038a = context;
            boolean z = context.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", this.f59038a.getPackageName()) == 0;
            this.f59040c = z;
            this.f59039b = z ? (WifiManager) this.f59038a.getSystemService("wifi") : null;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59040c : invokeV.booleanValue;
        }

        public int b() {
            InterceptResult invokeV;
            WifiInfo c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (!this.f59040c || this.f59039b == null || (c2 = c()) == null) {
                    return -1;
                }
                return c2.getLinkSpeed();
            }
            return invokeV.intValue;
        }

        public final WifiInfo c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                try {
                    try {
                        return this.f59039b.getConnectionInfo();
                    } catch (NullPointerException unused) {
                        return this.f59039b.getConnectionInfo();
                    }
                } catch (NullPointerException unused2) {
                    return null;
                }
            }
            return (WifiInfo) invokeV.objValue;
        }

        public String d() {
            InterceptResult invokeV;
            WifiInfo wifiInfo;
            String ssid;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Intent registerReceiver = this.f59038a.registerReceiver(null, new IntentFilter(McastConfig.ACTION_NETWORK_STATE_CHANGED));
                return (registerReceiver == null || (wifiInfo = (WifiInfo) registerReceiver.getParcelableExtra("wifiInfo")) == null || (ssid = wifiInfo.getSSID()) == null) ? "" : ssid;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1084407481, "Lcom/baidu/turbonet/net/NetworkChangeNotifierAutoDetect;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1084407481, "Lcom/baidu/turbonet/net/NetworkChangeNotifierAutoDetect;");
                return;
            }
        }
        TAG = NetworkChangeNotifierAutoDetect.class.getSimpleName();
    }

    @TargetApi(21)
    public NetworkChangeNotifierAutoDetect(Observer observer, Context context, RegistrationPolicy registrationPolicy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observer, context, registrationPolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLooper = Looper.myLooper();
        this.mHandler = new Handler(this.mLooper);
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, this) == null) && !onThread()) {
            throw new IllegalStateException("Must be called on NetworkChangeNotifierAutoDetect thread.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectionTypeChanged(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, dVar) == null) {
            int currentConnectionType = getCurrentConnectionType(dVar);
            String currentWifiSSID = getCurrentWifiSSID(dVar);
            if (currentConnectionType == this.mConnectionType && currentWifiSSID.equals(this.mWifiSSID)) {
                return;
            }
            this.mConnectionType = currentConnectionType;
            this.mWifiSSID = currentWifiSSID;
            String str = "Network connectivity changed, type is: " + this.mConnectionType;
            this.mObserver.a(currentConnectionType);
        }
    }

    @TargetApi(21)
    public static Network[] getAllNetworksFiltered(b bVar, Network network) {
        InterceptResult invokeLL;
        NetworkCapabilities c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, bVar, network)) == null) {
            Network[] a2 = bVar.a();
            int i2 = 0;
            for (Network network2 : a2) {
                if (!network2.equals(network) && (c2 = bVar.c(network2)) != null && c2.hasCapability(12)) {
                    if (c2.hasTransport(4)) {
                        if (bVar.j(network2)) {
                            return new Network[]{network2};
                        }
                    } else {
                        a2[i2] = network2;
                        i2++;
                    }
                }
            }
            return (Network[]) Arrays.copyOf(a2, i2);
        }
        return (Network[]) invokeLL.objValue;
    }

    private String getCurrentWifiSSID(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, this, dVar)) == null) ? getCurrentConnectionType(dVar) != 2 ? "" : this.mWifiManagerDelegate.d() : (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maxBandwidthChanged(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, dVar) == null) {
            double currentMaxBandwidthInMbps = getCurrentMaxBandwidthInMbps(dVar);
            if (currentMaxBandwidthInMbps == this.mMaxBandwidthMbps && this.mConnectionType == this.mMaxBandwidthConnectionType) {
                return;
            }
            this.mMaxBandwidthMbps = currentMaxBandwidthInMbps;
            this.mMaxBandwidthConnectionType = this.mConnectionType;
            this.mObserver.b(currentMaxBandwidthInMbps);
        }
    }

    @TargetApi(21)
    public static int networkToNetId(Network network) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, network)) == null) ? Integer.parseInt(network.toString()) : invokeL.intValue;
    }

    private boolean onThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) ? this.mLooper == Looper.myLooper() : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, runnable) == null) {
            if (onThread()) {
                runnable.run();
            } else {
                this.mHandler.post(runnable);
            }
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            assertOnThread();
            this.mRegistrationPolicy.a();
            unregister();
        }
    }

    public int getCurrentConnectionSubtype(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar)) == null) {
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
        return invokeL.intValue;
    }

    public int getCurrentConnectionType(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
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
        return invokeL.intValue;
    }

    public double getCurrentMaxBandwidthInMbps(d dVar) {
        InterceptResult invokeL;
        int b2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dVar)) == null) ? (getCurrentConnectionType(dVar) != 2 || (b2 = this.mWifiManagerDelegate.b()) == -1) ? NetworkChangeNotifier.f(getCurrentConnectionSubtype(dVar)) : b2 : invokeL.doubleValue;
    }

    public d getCurrentNetworkState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mConnectivityManagerDelegate.e() : (d) invokeV.objValue;
    }

    public int getDefaultNetId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                return -1;
            }
            return this.mConnectivityManagerDelegate.b();
        }
        return invokeV.intValue;
    }

    public int[] getNetworksAndTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                return new int[0];
            }
            Network[] allNetworksFiltered = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
            int[] iArr = new int[allNetworksFiltered.length * 2];
            int i2 = 0;
            for (Network network : allNetworksFiltered) {
                int i3 = i2 + 1;
                iArr[i2] = networkToNetId(network);
                i2 = i3 + 1;
                iArr[i3] = getCurrentConnectionType(this.mConnectivityManagerDelegate.f(network));
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public RegistrationPolicy getRegistrationPolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mRegistrationPolicy : (RegistrationPolicy) invokeV.objValue;
    }

    public boolean isReceiverRegisteredForTesting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mRegistered : invokeV.booleanValue;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, intent) == null) {
            runOnThread(new a(this));
        }
    }

    public void register() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
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
                    for (int i2 = 0; i2 < allNetworksFiltered.length; i2++) {
                        iArr[i2] = networkToNetId(allNetworksFiltered[i2]);
                    }
                    this.mObserver.f(iArr);
                }
            }
        }
    }

    public void setConnectivityManagerDelegateForTests(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.mConnectivityManagerDelegate = bVar;
        }
    }

    public void setWifiManagerDelegateForTests(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) {
            this.mWifiManagerDelegate = eVar;
        }
    }

    public void unregister() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
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
    }

    @TargetApi(21)
    /* loaded from: classes7.dex */
    public class c extends ConnectivityManager.NetworkCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Network f59020a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NetworkChangeNotifierAutoDetect f59021b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f59022e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f59023f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ boolean f59024g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ c f59025h;

            public a(c cVar, int i2, int i3, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59025h = cVar;
                this.f59022e = i2;
                this.f59023f = i3;
                this.f59024g = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f59025h.f59021b.mObserver.e(this.f59022e, this.f59023f);
                    if (this.f59024g) {
                        this.f59025h.f59021b.mObserver.a(this.f59023f);
                        this.f59025h.f59021b.mObserver.f(new int[]{this.f59022e});
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f59026e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f59027f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c f59028g;

            public b(c cVar, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59028g = cVar;
                this.f59026e = i2;
                this.f59027f = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f59028g.f59021b.mObserver.e(this.f59026e, this.f59027f);
                }
            }
        }

        /* renamed from: com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect$c$c  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1807c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f59029e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f59030f;

            public RunnableC1807c(c cVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59030f = cVar;
                this.f59029e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f59030f.f59021b.mObserver.c(this.f59029e);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Network f59031e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f59032f;

            public d(c cVar, Network network) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, network};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59032f = cVar;
                this.f59031e = network;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f59032f.f59021b.mObserver.d(NetworkChangeNotifierAutoDetect.networkToNetId(this.f59031e));
                }
            }
        }

        /* loaded from: classes7.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f59033e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f59034f;

            public e(c cVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59034f = cVar;
                this.f59033e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f59034f.f59021b.mObserver.a(this.f59033e);
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1561482662, "Lcom/baidu/turbonet/net/NetworkChangeNotifierAutoDetect$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1561482662, "Lcom/baidu/turbonet/net/NetworkChangeNotifierAutoDetect$c;");
                }
            }
        }

        public c(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {networkChangeNotifierAutoDetect};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f59021b = networkChangeNotifierAutoDetect;
            this.f59020a = null;
        }

        public final boolean a(Network network, NetworkCapabilities networkCapabilities) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, network, networkCapabilities)) == null) {
                if (networkCapabilities == null) {
                    networkCapabilities = this.f59021b.mConnectivityManagerDelegate.c(network);
                }
                return networkCapabilities == null || (networkCapabilities.hasTransport(4) && !this.f59021b.mConnectivityManagerDelegate.j(network));
            }
            return invokeLL.booleanValue;
        }

        public final boolean b(Network network, NetworkCapabilities networkCapabilities) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, network, networkCapabilities)) == null) ? c(network) || a(network, networkCapabilities) : invokeLL.booleanValue;
        }

        public final boolean c(Network network) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, network)) == null) {
                Network network2 = this.f59020a;
                return (network2 == null || network2.equals(network)) ? false : true;
            }
            return invokeL.booleanValue;
        }

        public void d() {
            NetworkCapabilities c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                Network[] allNetworksFiltered = NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(this.f59021b.mConnectivityManagerDelegate, null);
                this.f59020a = null;
                if (allNetworksFiltered.length == 1 && (c2 = this.f59021b.mConnectivityManagerDelegate.c(allNetworksFiltered[0])) != null && c2.hasTransport(4)) {
                    this.f59020a = allNetworksFiltered[0];
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, network) == null) {
                NetworkCapabilities c2 = this.f59021b.mConnectivityManagerDelegate.c(network);
                if (b(network, c2)) {
                    return;
                }
                boolean hasTransport = c2.hasTransport(4);
                if (hasTransport) {
                    this.f59020a = network;
                }
                int networkToNetId = NetworkChangeNotifierAutoDetect.networkToNetId(network);
                NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f59021b;
                this.f59021b.runOnThread(new a(this, networkToNetId, networkChangeNotifierAutoDetect.getCurrentConnectionType(networkChangeNotifierAutoDetect.mConnectivityManagerDelegate.f(network)), hasTransport));
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048581, this, network, networkCapabilities) == null) || b(network, networkCapabilities)) {
                return;
            }
            int networkToNetId = NetworkChangeNotifierAutoDetect.networkToNetId(network);
            NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f59021b;
            this.f59021b.runOnThread(new b(this, networkToNetId, networkChangeNotifierAutoDetect.getCurrentConnectionType(networkChangeNotifierAutoDetect.mConnectivityManagerDelegate.f(network))));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048582, this, network, i2) == null) || b(network, null)) {
                return;
            }
            this.f59021b.runOnThread(new RunnableC1807c(this, NetworkChangeNotifierAutoDetect.networkToNetId(network)));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, network) == null) || c(network)) {
                return;
            }
            this.f59021b.runOnThread(new d(this, network));
            if (this.f59020a != null) {
                this.f59020a = null;
                for (Network network2 : NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(this.f59021b.mConnectivityManagerDelegate, network)) {
                    onAvailable(network2);
                }
                NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.f59021b;
                this.f59021b.runOnThread(new e(this, networkChangeNotifierAutoDetect.getCurrentConnectionType(networkChangeNotifierAutoDetect.mConnectivityManagerDelegate.e())));
            }
        }

        public /* synthetic */ c(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect, a aVar) {
            this(networkChangeNotifierAutoDetect);
        }
    }
}
