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
import com.kuaishou.weapon.p0.h;
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
    public c mNetworkCallback;
    public NetworkRequest mNetworkRequest;
    public final Observer mObserver;
    public boolean mRegistered;
    public final RegistrationPolicy mRegistrationPolicy;
    public boolean mShouldSignalObserver;
    public e mWifiManagerDelegate;
    public String mWifiSSID;

    /* loaded from: classes7.dex */
    public interface Observer {
        void a(int i);

        void b(double d);

        void c(int i);

        void d(int i);

        void e(int i, int i2);

        void f(int[] iArr);
    }

    @TargetApi(21)
    /* loaded from: classes7.dex */
    public class c extends ConnectivityManager.NetworkCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Network a;
        public final /* synthetic */ NetworkChangeNotifierAutoDetect b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ boolean c;
            public final /* synthetic */ c d;

            public a(c cVar, int i, int i2, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = cVar;
                this.a = i;
                this.b = i2;
                this.c = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.d.b.mObserver.e(this.a, this.b);
                    if (this.c) {
                        this.d.b.mObserver.a(this.b);
                        this.d.b.mObserver.f(new int[]{this.a});
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ c c;

            public b(c cVar, int i, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Integer.valueOf(i), Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = cVar;
                this.a = i;
                this.b = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.c.b.mObserver.e(this.a, this.b);
                }
            }
        }

        /* renamed from: com.baidu.turbonet.net.NetworkChangeNotifierAutoDetect$c$c  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0504c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ c b;

            public RunnableC0504c(c cVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.b.mObserver.c(this.a);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Network a;
            public final /* synthetic */ c b;

            public d(c cVar, Network network) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, network};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = network;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.b.mObserver.d(NetworkChangeNotifierAutoDetect.networkToNetId(this.a));
                }
            }
        }

        /* loaded from: classes7.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ c b;

            public e(c cVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.b.mObserver.a(this.a);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.b = networkChangeNotifierAutoDetect;
            this.a = null;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, network) == null) {
                NetworkCapabilities c = this.b.mConnectivityManagerDelegate.c(network);
                if (b(network, c)) {
                    return;
                }
                boolean hasTransport = c.hasTransport(4);
                if (hasTransport) {
                    this.a = network;
                }
                int networkToNetId = NetworkChangeNotifierAutoDetect.networkToNetId(network);
                NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.b;
                this.b.runOnThread(new a(this, networkToNetId, networkChangeNotifierAutoDetect.getCurrentConnectionType(networkChangeNotifierAutoDetect.mConnectivityManagerDelegate.f(network)), hasTransport));
            }
        }

        public /* synthetic */ c(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect, a aVar) {
            this(networkChangeNotifierAutoDetect);
        }

        public final boolean b(Network network, NetworkCapabilities networkCapabilities) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, network, networkCapabilities)) == null) {
                if (!c(network) && !a(network, networkCapabilities)) {
                    return false;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048582, this, network, i) != null) || b(network, null)) {
                return;
            }
            this.b.runOnThread(new RunnableC0504c(this, NetworkChangeNotifierAutoDetect.networkToNetId(network)));
        }

        public final boolean a(Network network, NetworkCapabilities networkCapabilities) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, network, networkCapabilities)) == null) {
                if (networkCapabilities == null) {
                    networkCapabilities = this.b.mConnectivityManagerDelegate.c(network);
                }
                if (networkCapabilities != null && (!networkCapabilities.hasTransport(4) || this.b.mConnectivityManagerDelegate.j(network))) {
                    return false;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048581, this, network, networkCapabilities) != null) || b(network, networkCapabilities)) {
                return;
            }
            int networkToNetId = NetworkChangeNotifierAutoDetect.networkToNetId(network);
            NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.b;
            this.b.runOnThread(new b(this, networkToNetId, networkChangeNotifierAutoDetect.getCurrentConnectionType(networkChangeNotifierAutoDetect.mConnectivityManagerDelegate.f(network))));
        }

        public final boolean c(Network network) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, network)) == null) {
                Network network2 = this.a;
                if (network2 != null && !network2.equals(network)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void d() {
            NetworkCapabilities c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                Network[] allNetworksFiltered = NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(this.b.mConnectivityManagerDelegate, null);
                this.a = null;
                if (allNetworksFiltered.length == 1 && (c = this.b.mConnectivityManagerDelegate.c(allNetworksFiltered[0])) != null && c.hasTransport(4)) {
                    this.a = allNetworksFiltered[0];
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, network) == null) && !c(network)) {
                this.b.runOnThread(new d(this, network));
                if (this.a != null) {
                    this.a = null;
                    for (Network network2 : NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(this.b.mConnectivityManagerDelegate, network)) {
                        onAvailable(network2);
                    }
                    NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.b;
                    this.b.runOnThread(new e(this, networkChangeNotifierAutoDetect.getCurrentConnectionType(networkChangeNotifierAutoDetect.mConnectivityManagerDelegate.e())));
                }
            }
        }
    }

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
    public static abstract class RegistrationPolicy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetworkChangeNotifierAutoDetect a;

        public abstract void a();

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.register();
            }
        }

        public void b(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkChangeNotifierAutoDetect) == null) {
                this.a = networkChangeNotifierAutoDetect;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NetworkChangeNotifierAutoDetect a;

        public a(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {networkChangeNotifierAutoDetect};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = networkChangeNotifierAutoDetect;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.mRegistered) {
                return;
            }
            if (!this.a.mIgnoreNextBroadcast) {
                d currentNetworkState = this.a.getCurrentNetworkState();
                this.a.connectionTypeChanged(currentNetworkState);
                this.a.maxBandwidthChanged(currentNetworkState);
                return;
            }
            this.a.mIgnoreNextBroadcast = false;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ConnectivityManager a;

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

        @TargetApi(21)
        public Network[] a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.getAllNetworks();
            }
            return (Network[]) invokeV.objValue;
        }

        public d e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return g(this.a.getActiveNetworkInfo());
            }
            return (d) invokeV.objValue;
        }

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = (ConnectivityManager) context.getSystemService("connectivity");
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
        public int b() {
            InterceptResult invokeV;
            Network[] allNetworksFiltered;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                NetworkInfo activeNetworkInfo = this.a.getActiveNetworkInfo();
                int i = -1;
                if (activeNetworkInfo != null) {
                    for (Network network : NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(this, null)) {
                        NetworkInfo d = d(network);
                        if (d != null && (d.getType() == activeNetworkInfo.getType() || d.getType() == 17)) {
                            i = NetworkChangeNotifierAutoDetect.networkToNetId(network);
                        }
                    }
                    return i;
                }
                return -1;
            }
            return invokeV.intValue;
        }

        @TargetApi(21)
        public NetworkCapabilities c(Network network) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, network)) == null) {
                return this.a.getNetworkCapabilities(network);
            }
            return (NetworkCapabilities) invokeL.objValue;
        }

        public final NetworkInfo d(Network network) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, network)) == null) {
                try {
                    try {
                        return this.a.getNetworkInfo(network);
                    } catch (NullPointerException unused) {
                        return this.a.getNetworkInfo(network);
                    }
                } catch (NullPointerException unused2) {
                    return null;
                }
            }
            return (NetworkInfo) invokeL.objValue;
        }

        @TargetApi(21)
        public d f(Network network) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, network)) == null) {
                NetworkInfo d = d(network);
                if (d != null && d.getType() == 17) {
                    return e();
                }
                return g(d);
            }
            return (d) invokeL.objValue;
        }

        @TargetApi(21)
        public void i(ConnectivityManager.NetworkCallback networkCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, networkCallback) == null) {
                this.a.unregisterNetworkCallback(networkCallback);
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

        @TargetApi(21)
        public void h(NetworkRequest networkRequest, ConnectivityManager.NetworkCallback networkCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, networkRequest, networkCallback) == null) {
                this.a.registerNetworkCallback(networkRequest, networkCallback);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;
        public final int b;
        public final int c;

        public d(boolean z, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = i;
            this.c = i2;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.c;
            }
            return invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return invokeV.intValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;
        public final WifiManager b;
        public final boolean c;

        public e(Context context) {
            boolean z;
            WifiManager wifiManager;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            if (context.getPackageManager().checkPermission(h.d, this.a.getPackageName()) == 0) {
                z = true;
            } else {
                z = false;
            }
            this.c = z;
            if (z) {
                wifiManager = (WifiManager) this.a.getSystemService("wifi");
            } else {
                wifiManager = null;
            }
            this.b = wifiManager;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.c;
            }
            return invokeV.booleanValue;
        }

        public int b() {
            InterceptResult invokeV;
            WifiInfo c;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (!this.c || this.b == null || (c = c()) == null) {
                    return -1;
                }
                return c.getLinkSpeed();
            }
            return invokeV.intValue;
        }

        public final WifiInfo c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                try {
                    try {
                        return this.b.getConnectionInfo();
                    } catch (NullPointerException unused) {
                        return this.b.getConnectionInfo();
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
                Intent registerReceiver = this.a.registerReceiver(null, new IntentFilter(McastConfig.ACTION_NETWORK_STATE_CHANGED));
                if (registerReceiver != null && (wifiInfo = (WifiInfo) registerReceiver.getParcelableExtra("wifiInfo")) != null && (ssid = wifiInfo.getSSID()) != null) {
                    return ssid;
                }
                return "";
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

    private void assertOnThread() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65547, this) != null) || onThread()) {
            return;
        }
        throw new IllegalStateException("Must be called on NetworkChangeNotifierAutoDetect thread.");
    }

    private boolean onThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            if (this.mLooper == Looper.myLooper()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            assertOnThread();
            this.mRegistrationPolicy.a();
            unregister();
        }
    }

    public d getCurrentNetworkState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mConnectivityManagerDelegate.e();
        }
        return (d) invokeV.objValue;
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

    public RegistrationPolicy getRegistrationPolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mRegistrationPolicy;
        }
        return (RegistrationPolicy) invokeV.objValue;
    }

    public boolean isReceiverRegisteredForTesting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mRegistered;
        }
        return invokeV.booleanValue;
    }

    public void unregister() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            assertOnThread();
            if (!this.mRegistered) {
                return;
            }
            this.mContext.unregisterReceiver(this);
            this.mRegistered = false;
            c cVar = this.mNetworkCallback;
            if (cVar != null) {
                this.mConnectivityManagerDelegate.i(cVar);
            }
        }
    }

    @TargetApi(21)
    public NetworkChangeNotifierAutoDetect(Observer observer, Context context, RegistrationPolicy registrationPolicy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observer, context, registrationPolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, intent) == null) {
            runOnThread(new a(this));
        }
    }

    private String getCurrentWifiSSID(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, dVar)) == null) {
            if (getCurrentConnectionType(dVar) != 2) {
                return "";
            }
            return this.mWifiManagerDelegate.d();
        }
        return (String) invokeL.objValue;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, network)) == null) {
            return Integer.parseInt(network.toString());
        }
        return invokeL.intValue;
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

    public double getCurrentMaxBandwidthInMbps(d dVar) {
        InterceptResult invokeL;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dVar)) == null) {
            if (getCurrentConnectionType(dVar) == 2 && (b2 = this.mWifiManagerDelegate.b()) != -1) {
                return b2;
            }
            return NetworkChangeNotifier.f(getCurrentConnectionSubtype(dVar));
        }
        return invokeL.doubleValue;
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
            String str = TAG;
            Log.d(str, "Network connectivity changed, type is: " + this.mConnectionType);
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
        return (Network[]) invokeLL.objValue;
    }

    public int getCurrentConnectionSubtype(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar)) == null) {
            if (!dVar.c()) {
                return 1;
            }
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
        return invokeL.intValue;
    }

    public int getCurrentConnectionType(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
            if (!dVar.c()) {
                return 6;
            }
            int b2 = dVar.b();
            if (b2 != 0) {
                if (b2 != 1) {
                    if (b2 == 6) {
                        return 5;
                    }
                    if (b2 == 7) {
                        return 7;
                    }
                    if (b2 != 9) {
                        return 0;
                    }
                    return 1;
                }
                return 2;
            }
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
        }
        return invokeL.intValue;
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
            int i = 0;
            for (Network network : allNetworksFiltered) {
                int i2 = i + 1;
                iArr[i] = networkToNetId(network);
                i = i2 + 1;
                iArr[i2] = getCurrentConnectionType(this.mConnectivityManagerDelegate.f(network));
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public void register() {
        boolean z;
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
            boolean z2 = true;
            if (this.mContext.registerReceiver(this, this.mIntentFilter) != null) {
                z = true;
            } else {
                z = false;
            }
            this.mIgnoreNextBroadcast = z;
            this.mRegistered = true;
            c cVar = this.mNetworkCallback;
            if (cVar != null) {
                cVar.d();
                try {
                    this.mConnectivityManagerDelegate.h(this.mNetworkRequest, this.mNetworkCallback);
                    z2 = false;
                } catch (IllegalArgumentException unused) {
                    this.mNetworkCallback = null;
                } catch (SecurityException unused2) {
                    this.mNetworkCallback = null;
                } catch (RuntimeException unused3) {
                    this.mNetworkCallback = null;
                }
                if (!z2 && this.mShouldSignalObserver) {
                    Network[] allNetworksFiltered = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
                    int[] iArr = new int[allNetworksFiltered.length];
                    for (int i = 0; i < allNetworksFiltered.length; i++) {
                        iArr[i] = networkToNetId(allNetworksFiltered[i]);
                    }
                    this.mObserver.f(iArr);
                }
            }
        }
    }
}
