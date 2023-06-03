package com.baidu.yunjiasu.tornadosdk;

import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.RouteInfo;
import android.os.Build;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.yunjiasu.tornadosdk.TornadoNetwork;
import com.fun.ad.sdk.FunAdSdk;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u0006\u0016\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rJ\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0019J\u001a\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000bJ\u0006\u0010'\u001a\u00020#J\u0006\u0010(\u001a\u00020#J\u0018\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\rH\u0002J\u0006\u0010-\u001a\u00020#J\u0010\u0010.\u001a\u00020#2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010/\u001a\u00020#2\u0006\u0010%\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u00060"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/TrdVpnNetwork;", "", "()V", "TAG", "", "cellCallback", "com/baidu/yunjiasu/tornadosdk/TrdVpnNetwork$cellCallback$1", "Lcom/baidu/yunjiasu/tornadosdk/TrdVpnNetwork$cellCallback$1;", "connectivityManager", "Landroid/net/ConnectivityManager;", "enablePingCMD", "", "ipVersion", "", "networkCell", "Landroid/net/Network;", "networkFirst", "networkVpn", "networkWifi", "vpnService", "Lcom/baidu/yunjiasu/tornadosdk/TrdVpnService;", "wifiCallback", "com/baidu/yunjiasu/tornadosdk/TrdVpnNetwork$wifiCallback$1", "Lcom/baidu/yunjiasu/tornadosdk/TrdVpnNetwork$wifiCallback$1;", "bindSocket", "", "fd", "getGateway", "Ljava/net/InetAddress;", "getNetworkForT2T", "netTypeT2T", "getTornadoNetData", "Lcom/baidu/yunjiasu/tornadosdk/TornadoNetData;", "network", "init", "", "vpn", FunAdSdk.PLATFORM_CM, "enableIPv6", "pingGateway", "register", "registerNetCallback", "cb", "Landroid/net/ConnectivityManager$NetworkCallback;", "cap", "unregister", "unregisterNetCallback", "updateStatus", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class TrdVpnNetwork {
    public static /* synthetic */ Interceptable $ic = null;
    public static final TrdVpnNetwork INSTANCE;
    public static final String TAG = "TrdVpnNetwork";
    public static final TrdVpnNetwork$cellCallback$1 cellCallback;
    public static ConnectivityManager connectivityManager;
    public static boolean enablePingCMD;
    public static int ipVersion;
    public static Network networkCell;
    public static Network networkFirst;
    public static Network networkVpn;
    public static Network networkWifi;
    public static TrdVpnService vpnService;
    public static final TrdVpnNetwork$wifiCallback$1 wifiCallback;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.yunjiasu.tornadosdk.TrdVpnNetwork$wifiCallback$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.yunjiasu.tornadosdk.TrdVpnNetwork$cellCallback$1] */
    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1207441686, "Lcom/baidu/yunjiasu/tornadosdk/TrdVpnNetwork;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1207441686, "Lcom/baidu/yunjiasu/tornadosdk/TrdVpnNetwork;");
                return;
            }
        }
        INSTANCE = new TrdVpnNetwork();
        ipVersion = 4;
        wifiCallback = new ConnectivityManager.NetworkCallback() { // from class: com.baidu.yunjiasu.tornadosdk.TrdVpnNetwork$wifiCallback$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                ConnectivityManager connectivityManager2;
                int i;
                Network networkFromAll;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, network) == null) {
                    Intrinsics.checkNotNullParameter(network, "network");
                    super.onAvailable(network);
                    LogTo.INSTANCE.i(TrdVpnNetwork.TAG, "onAvailable: WIFI");
                    do {
                        TornadoNetwork tornadoNetwork = TornadoNetwork.INSTANCE;
                        connectivityManager2 = TrdVpnNetwork.connectivityManager;
                        if (connectivityManager2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("connectivityManager");
                            connectivityManager2 = null;
                        }
                        i = TrdVpnNetwork.ipVersion;
                        networkFromAll = tornadoNetwork.getNetworkFromAll(connectivityManager2, 1, i, true);
                        if (networkFromAll == null) {
                            LogTo.INSTANCE.e(TrdVpnNetwork.TAG, "onAvailable: WIFI: Try again --");
                            TimeUnit.MILLISECONDS.sleep(50L);
                            continue;
                        }
                    } while (networkFromAll == null);
                    LogTo.INSTANCE.i(TrdVpnNetwork.TAG, "onAvailable: WIFI: OK");
                    TrdVpnNetwork trdVpnNetwork = TrdVpnNetwork.INSTANCE;
                    TrdVpnNetwork.networkWifi = networkFromAll;
                    TrdVpnNetwork.INSTANCE.pingGateway();
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, network) == null) {
                    Intrinsics.checkNotNullParameter(network, "network");
                    super.onLost(network);
                    LogTo.INSTANCE.e(TrdVpnNetwork.TAG, "onLost: WIFI");
                    TrdVpnNetwork trdVpnNetwork = TrdVpnNetwork.INSTANCE;
                    TrdVpnNetwork.networkWifi = null;
                    TrdVpnNetwork.INSTANCE.pingGateway();
                }
            }
        };
        cellCallback = new ConnectivityManager.NetworkCallback() { // from class: com.baidu.yunjiasu.tornadosdk.TrdVpnNetwork$cellCallback$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                ConnectivityManager connectivityManager2;
                int i;
                Network networkFromAll;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, network) == null) {
                    Intrinsics.checkNotNullParameter(network, "network");
                    super.onAvailable(network);
                    LogTo.INSTANCE.i(TrdVpnNetwork.TAG, "onAvailable: CELL");
                    do {
                        TornadoNetwork tornadoNetwork = TornadoNetwork.INSTANCE;
                        connectivityManager2 = TrdVpnNetwork.connectivityManager;
                        if (connectivityManager2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("connectivityManager");
                            connectivityManager2 = null;
                        }
                        i = TrdVpnNetwork.ipVersion;
                        networkFromAll = tornadoNetwork.getNetworkFromAll(connectivityManager2, 0, i, true);
                        if (networkFromAll == null) {
                            LogTo.INSTANCE.e(TrdVpnNetwork.TAG, "onAvailable: CELL: Try again --");
                            TimeUnit.MILLISECONDS.sleep(50L);
                            continue;
                        }
                    } while (networkFromAll == null);
                    LogTo.INSTANCE.i(TrdVpnNetwork.TAG, "onAvailable: CELL: OK");
                    TrdVpnNetwork trdVpnNetwork = TrdVpnNetwork.INSTANCE;
                    TrdVpnNetwork.networkCell = networkFromAll;
                    TrdVpnNetwork.INSTANCE.pingGateway();
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, network) == null) {
                    Intrinsics.checkNotNullParameter(network, "network");
                    super.onLost(network);
                    LogTo.INSTANCE.e(TrdVpnNetwork.TAG, "onLost: CELLULAR");
                    TrdVpnNetwork trdVpnNetwork = TrdVpnNetwork.INSTANCE;
                    TrdVpnNetwork.networkCell = null;
                    TrdVpnNetwork.INSTANCE.pingGateway();
                }
            }
        };
    }

    public final synchronized void pingGateway() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                Pinger.INSTANCE.get();
                if (!enablePingCMD) {
                    return;
                }
                InetAddress gateway = getGateway();
                if (gateway == null) {
                    LogTo.INSTANCE.e(TAG, "Not found gateway");
                    Pinger.INSTANCE.stop();
                } else {
                    Pinger.INSTANCE.run(gateway);
                }
            }
        }
    }

    public TrdVpnNetwork() {
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

    public final void register() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            registerNetCallback(wifiCallback, 1);
            registerNetCallback(cellCallback, 0);
        }
    }

    public final void unregister() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            unregisterNetCallback(wifiCallback);
            unregisterNetCallback(cellCallback);
        }
    }

    private final void unregisterNetCallback(ConnectivityManager.NetworkCallback networkCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, networkCallback) == null) {
            try {
                ConnectivityManager connectivityManager2 = connectivityManager;
                if (connectivityManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("connectivityManager");
                    connectivityManager2 = null;
                }
                connectivityManager2.unregisterNetworkCallback(networkCallback);
            } catch (Exception e) {
                LogTo.INSTANCE.e(TAG, Intrinsics.stringPlus("unregisterNetCallback(): Exception: ", e.getMessage()));
            }
        }
    }

    private final void updateStatus(ConnectivityManager connectivityManager2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, connectivityManager2) == null) {
            networkWifi = TornadoNetwork.INSTANCE.getNetworkFromAll(connectivityManager2, 1, ipVersion, true);
            networkCell = TornadoNetwork.INSTANCE.getNetworkFromAll(connectivityManager2, 0, ipVersion, true);
            networkFirst = TornadoNetwork.COMMON.INSTANCE.getFirstDefaultNetwork(connectivityManager2);
        }
    }

    private final InetAddress getGateway() {
        InterceptResult invokeV;
        RouteInfo routeInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            try {
                if (networkWifi != null) {
                    TornadoNetwork.COMMON common2 = TornadoNetwork.COMMON.INSTANCE;
                    ConnectivityManager connectivityManager2 = connectivityManager;
                    if (connectivityManager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("connectivityManager");
                        connectivityManager2 = null;
                    }
                    Network network = networkWifi;
                    Intrinsics.checkNotNull(network);
                    routeInfo = common2.getDefaultRouteOfNetwork(connectivityManager2, network, 4);
                } else if (networkCell != null) {
                    TornadoNetwork.COMMON common3 = TornadoNetwork.COMMON.INSTANCE;
                    ConnectivityManager connectivityManager3 = connectivityManager;
                    if (connectivityManager3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("connectivityManager");
                        connectivityManager3 = null;
                    }
                    Network network2 = networkCell;
                    Intrinsics.checkNotNull(network2);
                    routeInfo = common3.getDefaultRouteOfNetwork(connectivityManager3, network2, 4);
                } else {
                    routeInfo = null;
                }
                if (routeInfo == null) {
                    return null;
                }
                return routeInfo.getGateway();
            } catch (Exception e) {
                LogTo.INSTANCE.e(TAG, Intrinsics.stringPlus("getGateway() failed: Exception: ", e));
                return null;
            }
        }
        return (InetAddress) invokeV.objValue;
    }

    private final TornadoNetData getTornadoNetData(Network network, int i) {
        InterceptResult invokeLI;
        String interfaceName;
        InetAddress address;
        String hostAddress;
        InetAddress gateway;
        String hostAddress2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, this, network, i)) == null) {
            String str = "";
            int i2 = 32;
            TornadoNetData tornadoNetData = new TornadoNetData("", "", 32, "");
            if (network == null) {
                return tornadoNetData;
            }
            ConnectivityManager connectivityManager2 = connectivityManager;
            ConnectivityManager connectivityManager3 = null;
            if (connectivityManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("connectivityManager");
                connectivityManager2 = null;
            }
            LinkProperties linkProperties = connectivityManager2.getLinkProperties(network);
            TornadoNetwork.COMMON common2 = TornadoNetwork.COMMON.INSTANCE;
            ConnectivityManager connectivityManager4 = connectivityManager;
            if (connectivityManager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("connectivityManager");
                connectivityManager4 = null;
            }
            LinkAddress linkAddressByProperties = common2.getLinkAddressByProperties(connectivityManager4, network, i);
            TornadoNetwork.COMMON common3 = TornadoNetwork.COMMON.INSTANCE;
            ConnectivityManager connectivityManager5 = connectivityManager;
            if (connectivityManager5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("connectivityManager");
            } else {
                connectivityManager3 = connectivityManager5;
            }
            RouteInfo defaultRouteOfNetwork = common3.getDefaultRouteOfNetwork(connectivityManager3, network, i);
            if (linkProperties == null || (interfaceName = linkProperties.getInterfaceName()) == null) {
                interfaceName = "";
            }
            tornadoNetData.setName(interfaceName);
            if (linkAddressByProperties == null || (address = linkAddressByProperties.getAddress()) == null || (hostAddress = address.getHostAddress()) == null) {
                hostAddress = "";
            }
            tornadoNetData.setIp(hostAddress);
            if (linkAddressByProperties != null) {
                i2 = linkAddressByProperties.getPrefixLength();
            }
            tornadoNetData.setMask(i2);
            if (defaultRouteOfNetwork != null && (gateway = defaultRouteOfNetwork.getGateway()) != null && (hostAddress2 = gateway.getHostAddress()) != null) {
                str = hostAddress2;
            }
            tornadoNetData.setGateway(str);
            return tornadoNetData;
        }
        return (TornadoNetData) invokeLI.objValue;
    }

    private final void registerNetCallback(ConnectivityManager.NetworkCallback networkCallback, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, this, networkCallback, i) == null) {
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addTransportType(i);
            NetworkRequest build = builder.build();
            try {
                ConnectivityManager connectivityManager2 = connectivityManager;
                if (connectivityManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("connectivityManager");
                    connectivityManager2 = null;
                }
                connectivityManager2.registerNetworkCallback(build, networkCallback);
            } catch (Exception e) {
                LogTo.INSTANCE.e(TAG, Intrinsics.stringPlus("registerNetCallback(): Exception: ", e.getMessage()));
            }
        }
    }

    public final long bindSocket(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (networkCell == null) {
                LogTo.INSTANCE.e(TAG, "--- Not found cellular");
                return -1L;
            } else if (Build.VERSION.SDK_INT >= 23) {
                FileDescriptor fileDescriptor = new FileDescriptor();
                try {
                    Field declaredField = FileDescriptor.class.getDeclaredField("descriptor");
                    Intrinsics.checkNotNullExpressionValue(declaredField, "FileDescriptor::class.ja…claredField(\"descriptor\")");
                    declaredField.setAccessible(true);
                    declaredField.setInt(fileDescriptor, i);
                    Network network = networkCell;
                    if (network != null) {
                        network.bindSocket(fileDescriptor);
                        return 0L;
                    }
                    return 0L;
                } catch (Exception e) {
                    Log.e(TAG, Intrinsics.stringPlus("bindSocket(): Exception: ", e.getMessage()));
                    return -1L;
                }
            } else {
                return 0L;
            }
        }
        return invokeI.longValue;
    }

    public final String getNetworkForT2T(long j) {
        InterceptResult invokeJ;
        TornadoNetData tornadoNetData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (j == 1) {
                tornadoNetData = getTornadoNetData(networkWifi, ipVersion);
            } else if (j == 2) {
                tornadoNetData = getTornadoNetData(networkCell, ipVersion);
            } else if (j == 3) {
                tornadoNetData = getTornadoNetData(networkFirst, ipVersion);
            } else if (j == 4) {
                TornadoNetwork tornadoNetwork = TornadoNetwork.INSTANCE;
                ConnectivityManager connectivityManager2 = connectivityManager;
                if (connectivityManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("connectivityManager");
                    connectivityManager2 = null;
                }
                Network networkFromAll = tornadoNetwork.getNetworkFromAll(connectivityManager2, 4, ipVersion, true);
                networkVpn = networkFromAll;
                tornadoNetData = getTornadoNetData(networkFromAll, ipVersion);
            } else {
                tornadoNetData = new TornadoNetData("", "", 32, "");
            }
            return tornadoNetData.getName() + ',' + tornadoNetData.getIp() + ',' + tornadoNetData.getGateway() + ',' + tornadoNetData.getMask();
        }
        return (String) invokeJ.objValue;
    }

    public final void init(TrdVpnService vpn, ConnectivityManager cm, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{vpn, cm, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Intrinsics.checkNotNullParameter(vpn, "vpn");
            Intrinsics.checkNotNullParameter(cm, "cm");
            vpnService = vpn;
            connectivityManager = cm;
            if (z2) {
                ipVersion = 6;
            }
            updateStatus(cm);
            enablePingCMD = z;
            pingGateway();
        }
    }
}
