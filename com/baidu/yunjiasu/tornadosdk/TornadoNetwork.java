package com.baidu.yunjiasu.tornadosdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.RouteInfo;
import android.system.OsConstants;
import android.telephony.TelephonyManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.kuaishou.weapon.p0.am;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\u0006\u001e\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001;B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J(\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\tJ\u001e\u0010)\u001a\b\u0012\u0004\u0012\u00020%0*2\u0006\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0016H\u0002J\u0010\u0010+\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\tJ\u000e\u00100\u001a\u00020-2\u0006\u0010/\u001a\u00020\tJ\u0006\u00101\u001a\u00020\tJ\u0006\u00102\u001a\u00020\tJ\u0006\u00103\u001a\u00020-J\u0018\u00104\u001a\u00020-2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0016H\u0002J\u0006\u00108\u001a\u00020-J\u0010\u00109\u001a\u00020-2\u0006\u00105\u001a\u000206H\u0002J\u0010\u0010:\u001a\u00020-2\u0006\u0010&\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u001a\u0010 \u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010\r¨\u0006<"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/TornadoNetwork;", "", "()V", "TAG", "", "cellCallback", "com/baidu/yunjiasu/tornadosdk/TornadoNetwork$cellCallback$1", "Lcom/baidu/yunjiasu/tornadosdk/TornadoNetwork$cellCallback$1;", "cellNetworkStatus", "", "getCellNetworkStatus", "()Z", "setCellNetworkStatus", "(Z)V", "cellStatus", "getCellStatus", "setCellStatus", "connectivityManager", "Landroid/net/ConnectivityManager;", "context", "Landroid/content/Context;", "ipVersion", "", "getIpVersion", "()I", "setIpVersion", "(I)V", "mobileDataStatus", "simStatus", "wifiCallback", "com/baidu/yunjiasu/tornadosdk/TornadoNetwork$wifiCallback$1", "Lcom/baidu/yunjiasu/tornadosdk/TornadoNetwork$wifiCallback$1;", "wifiStatus", "getWifiStatus", "setWifiStatus", "getMobileDataStatus", "getNetworkFromAll", "Landroid/net/Network;", FunAdSdk.PLATFORM_CM, "transportType", "checkIP", "getNetworkListByType", "", "getSIMStatus", "init", "", "ctx", "enableIPv6", "initOnIPv6", "isCellActive", "isWifiActive", "register", "registerNetCallback", "cb", "Landroid/net/ConnectivityManager$NetworkCallback;", "cap", "unregister", "unregisterNetCallback", "updateStatus", "COMMON", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes9.dex */
public final class TornadoNetwork {
    public static /* synthetic */ Interceptable $ic = null;
    public static final TornadoNetwork INSTANCE;
    public static final String TAG = "TornadoNetwork";
    public static final TornadoNetwork$cellCallback$1 cellCallback;
    public static boolean cellNetworkStatus;
    public static boolean cellStatus;
    public static ConnectivityManager connectivityManager;
    public static Context context;
    public static int ipVersion;
    public static boolean mobileDataStatus;
    public static boolean simStatus;
    public static final TornadoNetwork$wifiCallback$1 wifiCallback;
    public static boolean wifiStatus;
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\rJ \u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u0011"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/TornadoNetwork$COMMON;", "", "()V", "getDefaultRouteOfNetwork", "Landroid/net/RouteInfo;", FunAdSdk.PLATFORM_CM, "Landroid/net/ConnectivityManager;", "network", "Landroid/net/Network;", "ipVersion", "", "getFirstDefaultNetwork", "getIPByName", "", "name", "getLinkAddressByProperties", "Landroid/net/LinkAddress;", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class COMMON {
        public static /* synthetic */ Interceptable $ic;
        public static final COMMON INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1357565408, "Lcom/baidu/yunjiasu/tornadosdk/TornadoNetwork$COMMON;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1357565408, "Lcom/baidu/yunjiasu/tornadosdk/TornadoNetwork$COMMON;");
                    return;
                }
            }
            INSTANCE = new COMMON();
        }

        public COMMON() {
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

        public final RouteInfo getDefaultRouteOfNetwork(ConnectivityManager cm, Network network, int i) {
            InterceptResult invokeLLI;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, cm, network, i)) == null) {
                Intrinsics.checkNotNullParameter(cm, "cm");
                Intrinsics.checkNotNullParameter(network, "network");
                LinkProperties linkProperties = cm.getLinkProperties(network);
                if (linkProperties != null) {
                    for (RouteInfo routeInfo : linkProperties.getRoutes()) {
                        if (routeInfo.isDefaultRoute()) {
                            InetAddress gateway = routeInfo.getGateway();
                            boolean z2 = false;
                            if (gateway == null || !gateway.isLinkLocalAddress()) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z) {
                                continue;
                            } else {
                                InetAddress gateway2 = routeInfo.getGateway();
                                if (gateway2 != null && gateway2.isLoopbackAddress()) {
                                    z2 = true;
                                }
                                if (z2) {
                                    continue;
                                } else if (i == 4 && (routeInfo.getGateway() instanceof Inet4Address)) {
                                    return routeInfo;
                                } else {
                                    if (i == 6 && (routeInfo.getGateway() instanceof Inet6Address)) {
                                        return routeInfo;
                                    }
                                    if (i == 6 && (routeInfo.getGateway() instanceof Inet4Address)) {
                                        return routeInfo;
                                    }
                                }
                            }
                        }
                    }
                    return null;
                }
                return null;
            }
            return (RouteInfo) invokeLLI.objValue;
        }

        public final Network getFirstDefaultNetwork(ConnectivityManager cm) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cm)) == null) {
                Intrinsics.checkNotNullParameter(cm, "cm");
                Network[] networks = cm.getAllNetworks();
                ArrayList<Network> arrayList = new ArrayList();
                Intrinsics.checkNotNullExpressionValue(networks, "networks");
                int length = networks.length;
                int i = 0;
                while (i < length) {
                    Network nw = networks[i];
                    i++;
                    Intrinsics.checkNotNullExpressionValue(nw, "nw");
                    if (getDefaultRouteOfNetwork(cm, nw, 4) != null) {
                        arrayList.add(nw);
                    }
                }
                if (arrayList.size() > 0) {
                    for (Network network : arrayList) {
                        if (getLinkAddressByProperties(cm, network, 4) != null) {
                            return network;
                        }
                    }
                    return (Network) arrayList.get(0);
                }
                return null;
            }
            return (Network) invokeL.objValue;
        }

        public final String getIPByName(String name) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, name)) == null) {
                Intrinsics.checkNotNullParameter(name, "name");
                NetworkInterface byName = NetworkInterface.getByName(name);
                if (byName == null) {
                    return null;
                }
                Enumeration<InetAddress> inetAddresses = byName.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (nextElement != null && !nextElement.isAnyLocalAddress() && !nextElement.isLinkLocalAddress() && !nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return ((Inet4Address) nextElement).getHostAddress();
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        public final LinkAddress getLinkAddressByProperties(ConnectivityManager cm, Network network, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048579, this, cm, network, i)) == null) {
                Intrinsics.checkNotNullParameter(cm, "cm");
                Intrinsics.checkNotNullParameter(network, "network");
                LinkProperties linkProperties = cm.getLinkProperties(network);
                if (linkProperties != null) {
                    for (LinkAddress linkAddress : linkProperties.getLinkAddresses()) {
                        if (!linkAddress.getAddress().isAnyLocalAddress() && !linkAddress.getAddress().isLinkLocalAddress() && !linkAddress.getAddress().isLoopbackAddress() && (linkAddress.getFlags() & OsConstants.IFA_F_TEMPORARY) == 0) {
                            String hostAddress = linkAddress.getAddress().getHostAddress();
                            Intrinsics.checkNotNullExpressionValue(hostAddress, "la.address.hostAddress");
                            if (StringsKt__StringsJVMKt.startsWith$default(hostAddress, "127.", false, 2, null)) {
                                continue;
                            } else {
                                String hostAddress2 = linkAddress.getAddress().getHostAddress();
                                Intrinsics.checkNotNullExpressionValue(hostAddress2, "la.address.hostAddress");
                                if (StringsKt__StringsJVMKt.startsWith$default(hostAddress2, "0.", false, 2, null)) {
                                    continue;
                                } else if (i == 4 && (linkAddress.getAddress() instanceof Inet4Address)) {
                                    return linkAddress;
                                } else {
                                    if (i == 6 && (linkAddress.getAddress() instanceof Inet6Address)) {
                                        return linkAddress;
                                    }
                                }
                            }
                        }
                    }
                }
                return null;
            }
            return (LinkAddress) invokeLLI.objValue;
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.yunjiasu.tornadosdk.TornadoNetwork$wifiCallback$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.yunjiasu.tornadosdk.TornadoNetwork$cellCallback$1] */
    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(979986407, "Lcom/baidu/yunjiasu/tornadosdk/TornadoNetwork;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(979986407, "Lcom/baidu/yunjiasu/tornadosdk/TornadoNetwork;");
                return;
            }
        }
        INSTANCE = new TornadoNetwork();
        ipVersion = 4;
        wifiCallback = new ConnectivityManager.NetworkCallback() { // from class: com.baidu.yunjiasu.tornadosdk.TornadoNetwork$wifiCallback$1
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
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, network) == null) {
                    Intrinsics.checkNotNullParameter(network, "network");
                    super.onAvailable(network);
                    LogTo.INSTANCE.i(TornadoNetwork.TAG, "onAvailable: WIFI");
                    TornadoNetwork.INSTANCE.setWifiStatus(true);
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, network) == null) {
                    Intrinsics.checkNotNullParameter(network, "network");
                    super.onLost(network);
                    LogTo.INSTANCE.i(TornadoNetwork.TAG, "onLost: WIFI");
                    TornadoNetwork.INSTANCE.setWifiStatus(false);
                }
            }
        };
        cellCallback = new ConnectivityManager.NetworkCallback() { // from class: com.baidu.yunjiasu.tornadosdk.TornadoNetwork$cellCallback$1
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
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, network) == null) {
                    Intrinsics.checkNotNullParameter(network, "network");
                    super.onAvailable(network);
                    LogTo.INSTANCE.i(TornadoNetwork.TAG, "onAvailable: CELL");
                    boolean z = true;
                    TornadoNetwork.INSTANCE.setCellStatus(true);
                    TornadoNetwork tornadoNetwork = TornadoNetwork.INSTANCE;
                    connectivityManager2 = TornadoNetwork.connectivityManager;
                    if (connectivityManager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("connectivityManager");
                        connectivityManager2 = null;
                    }
                    if (tornadoNetwork.getNetworkFromAll(connectivityManager2, 0, TornadoNetwork.INSTANCE.getIpVersion(), false) == null) {
                        z = false;
                    }
                    tornadoNetwork.setCellNetworkStatus(z);
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                ConnectivityManager connectivityManager2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, network) == null) {
                    Intrinsics.checkNotNullParameter(network, "network");
                    super.onLost(network);
                    LogTo.INSTANCE.i(TornadoNetwork.TAG, "onLost: CELL");
                    boolean z = true;
                    TornadoNetwork.INSTANCE.setCellStatus(true);
                    TornadoNetwork tornadoNetwork = TornadoNetwork.INSTANCE;
                    connectivityManager2 = TornadoNetwork.connectivityManager;
                    if (connectivityManager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("connectivityManager");
                        connectivityManager2 = null;
                    }
                    if (tornadoNetwork.getNetworkFromAll(connectivityManager2, 0, TornadoNetwork.INSTANCE.getIpVersion(), false) == null) {
                        z = false;
                    }
                    tornadoNetwork.setCellNetworkStatus(z);
                }
            }
        };
    }

    public TornadoNetwork() {
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

    public final boolean getCellNetworkStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return cellNetworkStatus;
        }
        return invokeV.booleanValue;
    }

    public final boolean getCellStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return cellStatus;
        }
        return invokeV.booleanValue;
    }

    public final int getIpVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ipVersion;
        }
        return invokeV.intValue;
    }

    public final boolean getWifiStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return wifiStatus;
        }
        return invokeV.booleanValue;
    }

    public final boolean isWifiActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return wifiStatus;
        }
        return invokeV.booleanValue;
    }

    public final void register() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            registerNetCallback(wifiCallback, 1);
            registerNetCallback(cellCallback, 0);
        }
    }

    public final void unregister() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            unregisterNetCallback(wifiCallback);
            unregisterNetCallback(cellCallback);
        }
    }

    private final boolean getMobileDataStatus(Context context2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context2)) == null) {
            Object systemService = context2.getSystemService("phone");
            if (systemService != null) {
                TelephonyManager telephonyManager = (TelephonyManager) systemService;
                try {
                    Method declaredMethod = telephonyManager.getClass().getDeclaredMethod("getDataEnabled", new Class[0]);
                    if (declaredMethod != null) {
                        Object invoke = declaredMethod.invoke(telephonyManager, new Object[0]);
                        if (invoke != null) {
                            return ((Boolean) invoke).booleanValue();
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                } catch (Exception e) {
                    LogTo.INSTANCE.e(TAG, Intrinsics.stringPlus("getMobileDataStatus(): Exception: ", e.getMessage()));
                }
                return false;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        }
        return invokeL.booleanValue;
    }

    private final List<Network> getNetworkListByType(ConnectivityManager connectivityManager2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, connectivityManager2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            Network[] networks = connectivityManager2.getAllNetworks();
            Intrinsics.checkNotNullExpressionValue(networks, "networks");
            int length = networks.length;
            int i2 = 0;
            while (i2 < length) {
                Network nw = networks[i2];
                i2++;
                NetworkCapabilities networkCapabilities = connectivityManager2.getNetworkCapabilities(nw);
                if (networkCapabilities != null && networkCapabilities.hasTransport(i)) {
                    Intrinsics.checkNotNullExpressionValue(nw, "nw");
                    arrayList.add(nw);
                }
            }
            return CollectionsKt___CollectionsKt.toList(arrayList);
        }
        return (List) invokeLI.objValue;
    }

    private final void registerNetCallback(ConnectivityManager.NetworkCallback networkCallback, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, this, networkCallback, i) == null) {
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

    private final boolean getSIMStatus(Context context2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, context2)) == null) {
            Object systemService = context2.getSystemService("phone");
            if (systemService != null) {
                if (((TelephonyManager) systemService).getSimState() == 5) {
                    return true;
                }
                return false;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        }
        return invokeL.booleanValue;
    }

    private final void unregisterNetCallback(ConnectivityManager.NetworkCallback networkCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, networkCallback) == null) {
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

    public final void initOnIPv6(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z && ipVersion == 6) {
                return;
            }
            if (!z && ipVersion == 4) {
                return;
            }
            if (z) {
                ipVersion = 6;
            }
            ConnectivityManager connectivityManager2 = connectivityManager;
            if (connectivityManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("connectivityManager");
                connectivityManager2 = null;
            }
            updateStatus(connectivityManager2);
        }
    }

    public final void setCellNetworkStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            cellNetworkStatus = z;
        }
    }

    public final void setCellStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            cellStatus = z;
        }
    }

    public final void setIpVersion(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            ipVersion = i;
        }
    }

    public final void setWifiStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            wifiStatus = z;
        }
    }

    private final void updateStatus(ConnectivityManager connectivityManager2) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, connectivityManager2) == null) {
            boolean z3 = true;
            if (getNetworkFromAll(connectivityManager2, 1, ipVersion, true) != null) {
                z = true;
            } else {
                z = false;
            }
            wifiStatus = z;
            if (getNetworkFromAll(connectivityManager2, 0, ipVersion, true) != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            cellStatus = z2;
            if (getNetworkFromAll(connectivityManager2, 0, ipVersion, false) == null) {
                z3 = false;
            }
            cellNetworkStatus = z3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Network getNetworkFromAll(ConnectivityManager cm, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{cm, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            Intrinsics.checkNotNullParameter(cm, "cm");
            Iterator<Network> it = getNetworkListByType(cm, i).iterator();
            while (it.hasNext()) {
                Network next = it.next();
                LinkProperties linkProperties = cm.getLinkProperties(next);
                if (i != 4 && linkProperties != null && linkProperties.getInterfaceName() != null) {
                    String interfaceName = linkProperties.getInterfaceName();
                    Intrinsics.checkNotNull(interfaceName);
                    Intrinsics.checkNotNullExpressionValue(interfaceName, "lp.interfaceName!!");
                    if (StringsKt__StringsJVMKt.startsWith(interfaceName, am.a, true)) {
                        continue;
                    }
                }
                LinkAddress linkAddressByProperties = COMMON.INSTANCE.getLinkAddressByProperties(cm, next, i2);
                RouteInfo defaultRouteOfNetwork = COMMON.INSTANCE.getDefaultRouteOfNetwork(cm, next, i2);
                if (linkAddressByProperties != null && defaultRouteOfNetwork != null) {
                    return next;
                }
            }
            return null;
        }
        return (Network) invokeCommon.objValue;
    }

    public final void init(Context ctx, ConnectivityManager cm, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048581, this, ctx, cm, z) == null) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(cm, "cm");
            context = ctx;
            connectivityManager = cm;
            Context context2 = null;
            if (ctx == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                ctx = null;
            }
            simStatus = getSIMStatus(ctx);
            Context context3 = context;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
            } else {
                context2 = context3;
            }
            mobileDataStatus = getMobileDataStatus(context2);
            if (z) {
                ipVersion = 6;
            }
            updateStatus(cm);
        }
    }

    public final boolean isCellActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Context context2 = context;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context2 = null;
            }
            mobileDataStatus = getMobileDataStatus(context2);
            LogTo logTo = LogTo.INSTANCE;
            logTo.i(TAG, "sim=" + simStatus + ", mobileData=" + mobileDataStatus + ", {" + cellStatus + StringUtil.ARRAY_ELEMENT_SEPARATOR + cellNetworkStatus + '}');
            if (simStatus && mobileDataStatus && cellStatus) {
                return true;
            }
            if (simStatus && mobileDataStatus && cellNetworkStatus) {
                LogTo.INSTANCE.i(TAG, "CELLULAR: BUT_NO_IP");
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
