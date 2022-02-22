package com.baidu.yunjiasu.tornadosdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.http.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006%"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/TornadoNetSetting;", "", "proxyIP", "", "proxyPort", "consoleIP", "gateway", b.c.f32814b, "mask", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConsoleIP", "()Ljava/lang/String;", "setConsoleIP", "(Ljava/lang/String;)V", "getDns", "setDns", "getGateway", "setGateway", "getMask", "setMask", "getProxyIP", "setProxyIP", "getProxyPort", "setProxyPort", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", TTDownloadField.TT_HASHCODE, "", "toString", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class TornadoNetSetting {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String consoleIP;
    public String dns;
    public String gateway;
    public String mask;
    public String proxyIP;
    public String proxyPort;

    public TornadoNetSetting(String proxyIP, String proxyPort, String consoleIP, String gateway, String dns, String mask) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {proxyIP, proxyPort, consoleIP, gateway, dns, mask};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(proxyIP, "proxyIP");
        Intrinsics.checkNotNullParameter(proxyPort, "proxyPort");
        Intrinsics.checkNotNullParameter(consoleIP, "consoleIP");
        Intrinsics.checkNotNullParameter(gateway, "gateway");
        Intrinsics.checkNotNullParameter(dns, "dns");
        Intrinsics.checkNotNullParameter(mask, "mask");
        this.proxyIP = proxyIP;
        this.proxyPort = proxyPort;
        this.consoleIP = consoleIP;
        this.gateway = gateway;
        this.dns = dns;
        this.mask = mask;
    }

    public static /* synthetic */ TornadoNetSetting copy$default(TornadoNetSetting tornadoNetSetting, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = tornadoNetSetting.proxyIP;
        }
        if ((i2 & 2) != 0) {
            str2 = tornadoNetSetting.proxyPort;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = tornadoNetSetting.consoleIP;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = tornadoNetSetting.gateway;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = tornadoNetSetting.dns;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = tornadoNetSetting.mask;
        }
        return tornadoNetSetting.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.proxyIP : (String) invokeV.objValue;
    }

    public final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.proxyPort : (String) invokeV.objValue;
    }

    public final String component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.consoleIP : (String) invokeV.objValue;
    }

    public final String component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.gateway : (String) invokeV.objValue;
    }

    public final String component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.dns : (String) invokeV.objValue;
    }

    public final String component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mask : (String) invokeV.objValue;
    }

    public final TornadoNetSetting copy(String proxyIP, String proxyPort, String consoleIP, String gateway, String dns, String mask) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{proxyIP, proxyPort, consoleIP, gateway, dns, mask})) == null) {
            Intrinsics.checkNotNullParameter(proxyIP, "proxyIP");
            Intrinsics.checkNotNullParameter(proxyPort, "proxyPort");
            Intrinsics.checkNotNullParameter(consoleIP, "consoleIP");
            Intrinsics.checkNotNullParameter(gateway, "gateway");
            Intrinsics.checkNotNullParameter(dns, "dns");
            Intrinsics.checkNotNullParameter(mask, "mask");
            return new TornadoNetSetting(proxyIP, proxyPort, consoleIP, gateway, dns, mask);
        }
        return (TornadoNetSetting) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TornadoNetSetting) {
                TornadoNetSetting tornadoNetSetting = (TornadoNetSetting) obj;
                return Intrinsics.areEqual(this.proxyIP, tornadoNetSetting.proxyIP) && Intrinsics.areEqual(this.proxyPort, tornadoNetSetting.proxyPort) && Intrinsics.areEqual(this.consoleIP, tornadoNetSetting.consoleIP) && Intrinsics.areEqual(this.gateway, tornadoNetSetting.gateway) && Intrinsics.areEqual(this.dns, tornadoNetSetting.dns) && Intrinsics.areEqual(this.mask, tornadoNetSetting.mask);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final String getConsoleIP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.consoleIP : (String) invokeV.objValue;
    }

    public final String getDns() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.dns : (String) invokeV.objValue;
    }

    public final String getGateway() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.gateway : (String) invokeV.objValue;
    }

    public final String getMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mask : (String) invokeV.objValue;
    }

    public final String getProxyIP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.proxyIP : (String) invokeV.objValue;
    }

    public final String getProxyPort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.proxyPort : (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (((((((((this.proxyIP.hashCode() * 31) + this.proxyPort.hashCode()) * 31) + this.consoleIP.hashCode()) * 31) + this.gateway.hashCode()) * 31) + this.dns.hashCode()) * 31) + this.mask.hashCode() : invokeV.intValue;
    }

    public final void setConsoleIP(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.consoleIP = str;
        }
    }

    public final void setDns(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.dns = str;
        }
    }

    public final void setGateway(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.gateway = str;
        }
    }

    public final void setMask(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.mask = str;
        }
    }

    public final void setProxyIP(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.proxyIP = str;
        }
    }

    public final void setProxyPort(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.proxyPort = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return "TornadoNetSetting(proxyIP=" + this.proxyIP + ", proxyPort=" + this.proxyPort + ", consoleIP=" + this.consoleIP + ", gateway=" + this.gateway + ", dns=" + this.dns + ", mask=" + this.mask + ')';
        }
        return (String) invokeV.objValue;
    }
}
