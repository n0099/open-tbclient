package com.baidu.yunjiasu.tornadosdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u001d\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\u001b\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\u001a\u0010$\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R\u001a\u0010'\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\b¨\u0006*"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/TrdVpnConfig;", "", "()V", "ADDRPrefixLength", "", "getADDRPrefixLength", "()I", "setADDRPrefixLength", "(I)V", "ADDRPrefixLength6", "getADDRPrefixLength6", "setADDRPrefixLength6", "Addr", "", "getAddr", "()Ljava/lang/String;", "setAddr", "(Ljava/lang/String;)V", "Addr6", "getAddr6", "setAddr6", "DnsServer1", "getDnsServer1", "setDnsServer1", "DnsServer2", "getDnsServer2", "setDnsServer2", "DnsServer6", "getDnsServer6", "setDnsServer6", "Mtu", "getMtu", "setMtu", SsManifestParser.StreamIndexParser.KEY_NAME, "getName", "setName", "Route", "getRoute", "setRoute", "RoutePrefixLength", "getRoutePrefixLength", "setRoutePrefixLength", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class TrdVpnConfig {
    public static /* synthetic */ Interceptable $ic;
    public static int ADDRPrefixLength;
    public static int ADDRPrefixLength6;
    public static String Addr;
    public static String Addr6;
    public static String DnsServer1;
    public static String DnsServer2;
    public static String DnsServer6;
    public static final TrdVpnConfig INSTANCE;
    public static int Mtu;
    public static String Name;
    public static String Route;
    public static int RoutePrefixLength;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1823249712, "Lcom/baidu/yunjiasu/tornadosdk/TrdVpnConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1823249712, "Lcom/baidu/yunjiasu/tornadosdk/TrdVpnConfig;");
                return;
            }
        }
        INSTANCE = new TrdVpnConfig();
        Name = Tornado.TAG;
        Mtu = 1500;
        Addr = "10.233.233.233";
        ADDRPrefixLength = 30;
        DnsServer1 = "9.9.9.9";
        DnsServer2 = "6.6.6.6";
        Route = "0.0.0.0";
        DnsServer6 = "2400:da00:c0bb:1001::8888";
        Addr6 = "2400::A:A:A:00AA";
        ADDRPrefixLength6 = 64;
    }

    public TrdVpnConfig() {
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

    public final int getADDRPrefixLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ADDRPrefixLength : invokeV.intValue;
    }

    public final int getADDRPrefixLength6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ADDRPrefixLength6 : invokeV.intValue;
    }

    public final String getAddr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Addr : (String) invokeV.objValue;
    }

    public final String getAddr6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Addr6 : (String) invokeV.objValue;
    }

    public final String getDnsServer1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? DnsServer1 : (String) invokeV.objValue;
    }

    public final String getDnsServer2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? DnsServer2 : (String) invokeV.objValue;
    }

    public final String getDnsServer6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? DnsServer6 : (String) invokeV.objValue;
    }

    public final int getMtu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Mtu : invokeV.intValue;
    }

    public final String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Name : (String) invokeV.objValue;
    }

    public final String getRoute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Route : (String) invokeV.objValue;
    }

    public final int getRoutePrefixLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? RoutePrefixLength : invokeV.intValue;
    }

    public final void setADDRPrefixLength(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            ADDRPrefixLength = i;
        }
    }

    public final void setADDRPrefixLength6(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            ADDRPrefixLength6 = i;
        }
    }

    public final void setAddr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            Addr = str;
        }
    }

    public final void setAddr6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            Addr6 = str;
        }
    }

    public final void setDnsServer1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            DnsServer1 = str;
        }
    }

    public final void setDnsServer2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            DnsServer2 = str;
        }
    }

    public final void setDnsServer6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            DnsServer6 = str;
        }
    }

    public final void setMtu(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            Mtu = i;
        }
    }

    public final void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            Name = str;
        }
    }

    public final void setRoute(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            Route = str;
        }
    }

    public final void setRoutePrefixLength(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            RoutePrefixLength = i;
        }
    }
}
