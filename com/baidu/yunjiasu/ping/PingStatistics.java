package com.baidu.yunjiasu.ping;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.net.InetAddress;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003JY\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\b\u0010'\u001a\u00020(H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006)"}, d2 = {"Lcom/baidu/yunjiasu/ping/PingStatistics;", "", "Address", "Ljava/net/InetAddress;", "PacketsRecv", "", "PacketsSent", "PacketLoss", "", "MinRtt", "MaxRtt", "AvgRtt", "StdDevRtt", "(Ljava/net/InetAddress;JJFFFFF)V", "getAddress", "()Ljava/net/InetAddress;", "getAvgRtt", "()F", "getMaxRtt", "getMinRtt", "getPacketLoss", "getPacketsRecv", "()J", "getPacketsSent", "getStdDevRtt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", ImageViewerConfig.FROM_OTHER, TTDownloadField.TT_HASHCODE, "", "toString", "", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class PingStatistics {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final InetAddress Address;
    public final float AvgRtt;
    public final float MaxRtt;
    public final float MinRtt;
    public final float PacketLoss;
    public final long PacketsRecv;
    public final long PacketsSent;
    public final float StdDevRtt;

    public final InetAddress component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.Address : (InetAddress) invokeV.objValue;
    }

    public final long component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.PacketsRecv : invokeV.longValue;
    }

    public final long component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.PacketsSent : invokeV.longValue;
    }

    public final float component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.PacketLoss : invokeV.floatValue;
    }

    public final float component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.MinRtt : invokeV.floatValue;
    }

    public final float component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.MaxRtt : invokeV.floatValue;
    }

    public final float component7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.AvgRtt : invokeV.floatValue;
    }

    public final float component8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.StdDevRtt : invokeV.floatValue;
    }

    public final PingStatistics copy(InetAddress Address, long j, long j2, float f, float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Address, Long.valueOf(j), Long.valueOf(j2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            Intrinsics.checkNotNullParameter(Address, "Address");
            return new PingStatistics(Address, j, j2, f, f2, f3, f4, f5);
        }
        return (PingStatistics) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PingStatistics) {
                PingStatistics pingStatistics = (PingStatistics) obj;
                return Intrinsics.areEqual(this.Address, pingStatistics.Address) && this.PacketsRecv == pingStatistics.PacketsRecv && this.PacketsSent == pingStatistics.PacketsSent && Intrinsics.areEqual((Object) Float.valueOf(this.PacketLoss), (Object) Float.valueOf(pingStatistics.PacketLoss)) && Intrinsics.areEqual((Object) Float.valueOf(this.MinRtt), (Object) Float.valueOf(pingStatistics.MinRtt)) && Intrinsics.areEqual((Object) Float.valueOf(this.MaxRtt), (Object) Float.valueOf(pingStatistics.MaxRtt)) && Intrinsics.areEqual((Object) Float.valueOf(this.AvgRtt), (Object) Float.valueOf(pingStatistics.AvgRtt)) && Intrinsics.areEqual((Object) Float.valueOf(this.StdDevRtt), (Object) Float.valueOf(pingStatistics.StdDevRtt));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (((((((((((((this.Address.hashCode() * 31) + a.a(this.PacketsRecv)) * 31) + a.a(this.PacketsSent)) * 31) + Float.floatToIntBits(this.PacketLoss)) * 31) + Float.floatToIntBits(this.MinRtt)) * 31) + Float.floatToIntBits(this.MaxRtt)) * 31) + Float.floatToIntBits(this.AvgRtt)) * 31) + Float.floatToIntBits(this.StdDevRtt) : invokeV.intValue;
    }

    public PingStatistics(InetAddress Address, long j, long j2, float f, float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Address, Long.valueOf(j), Long.valueOf(j2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(Address, "Address");
        this.Address = Address;
        this.PacketsRecv = j;
        this.PacketsSent = j2;
        this.PacketLoss = f;
        this.MinRtt = f2;
        this.MaxRtt = f3;
        this.AvgRtt = f4;
        this.StdDevRtt = f5;
    }

    public final InetAddress getAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.Address;
        }
        return (InetAddress) invokeV.objValue;
    }

    public final float getAvgRtt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.AvgRtt;
        }
        return invokeV.floatValue;
    }

    public final float getMaxRtt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.MaxRtt;
        }
        return invokeV.floatValue;
    }

    public final float getMinRtt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.MinRtt;
        }
        return invokeV.floatValue;
    }

    public final float getPacketLoss() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.PacketLoss;
        }
        return invokeV.floatValue;
    }

    public final long getPacketsRecv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.PacketsRecv;
        }
        return invokeV.longValue;
    }

    public final long getPacketsSent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.PacketsSent;
        }
        return invokeV.longValue;
    }

    public final float getStdDevRtt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.StdDevRtt;
        }
        return invokeV.floatValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.String : 0x000b: INVOKE  (r1v3 java.lang.String A[REMOVE]) = 
      (wrap: java.net.InetAddress : 0x0009: IGET  (r1v2 java.net.InetAddress A[REMOVE]) = (r4v0 'this' com.baidu.yunjiasu.ping.PingStatistics A[IMMUTABLE_TYPE, THIS]) com.baidu.yunjiasu.ping.PingStatistics.Address java.net.InetAddress)
     type: VIRTUAL call: java.net.InetAddress.getHostAddress():java.lang.String)), (',' char), (wrap: long : 0x0017: IGET  (r2v1 long A[REMOVE]) = (r4v0 'this' com.baidu.yunjiasu.ping.PingStatistics A[IMMUTABLE_TYPE, THIS]) com.baidu.yunjiasu.ping.PingStatistics.PacketsRecv long), (',' char), (wrap: long : 0x001f: IGET  (r2v2 long A[REMOVE]) = (r4v0 'this' com.baidu.yunjiasu.ping.PingStatistics A[IMMUTABLE_TYPE, THIS]) com.baidu.yunjiasu.ping.PingStatistics.PacketsSent long), (',' char), (wrap: float : 0x0027: IGET  (r2v3 float A[REMOVE]) = (r4v0 'this' com.baidu.yunjiasu.ping.PingStatistics A[IMMUTABLE_TYPE, THIS]) com.baidu.yunjiasu.ping.PingStatistics.PacketLoss float), (',' char), (wrap: float : 0x002f: IGET  (r2v4 float A[REMOVE]) = (r4v0 'this' com.baidu.yunjiasu.ping.PingStatistics A[IMMUTABLE_TYPE, THIS]) com.baidu.yunjiasu.ping.PingStatistics.MinRtt float), (',' char), (wrap: float : 0x0037: IGET  (r2v5 float A[REMOVE]) = (r4v0 'this' com.baidu.yunjiasu.ping.PingStatistics A[IMMUTABLE_TYPE, THIS]) com.baidu.yunjiasu.ping.PingStatistics.MaxRtt float), (',' char), (wrap: float : 0x003f: IGET  (r2v6 float A[REMOVE]) = (r4v0 'this' com.baidu.yunjiasu.ping.PingStatistics A[IMMUTABLE_TYPE, THIS]) com.baidu.yunjiasu.ping.PingStatistics.AvgRtt float), (',' char), (wrap: float : 0x0047: IGET  (r1v5 float A[REMOVE]) = (r4v0 'this' com.baidu.yunjiasu.ping.PingStatistics A[IMMUTABLE_TYPE, THIS]) com.baidu.yunjiasu.ping.PingStatistics.StdDevRtt float)] */
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append((Object) this.Address.getHostAddress());
            sb.append(',');
            sb.append(this.PacketsRecv);
            sb.append(',');
            sb.append(this.PacketsSent);
            sb.append(',');
            sb.append(this.PacketLoss);
            sb.append(',');
            sb.append(this.MinRtt);
            sb.append(',');
            sb.append(this.MaxRtt);
            sb.append(',');
            sb.append(this.AvgRtt);
            sb.append(',');
            sb.append(this.StdDevRtt);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
