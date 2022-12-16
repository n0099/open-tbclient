package com.baidu.tun2tornadolite.booster.tun.ip;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.tun.ip.DirectHeader;
import com.baidu.webkit.sdk.WebChromeClient;
import com.yy.gslbsdk.db.ProbeTB;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u0000 $2\u00020\u0001:\u0001$B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006RI\u0010\u000b\u001a\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n2\u0015\u0010\u0007\u001a\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rRI\u0010\u0014\u001a\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n2\u0015\u0010\u0007\u001a\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fRI\u0010\u0018\u001a\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n2\u0015\u0010\u0007\u001a\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fRI\u0010\u001c\u001a\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n2\u0015\u0010\u0007\u001a\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fRI\u0010 \u001a\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n2\u0015\u0010\u0007\u001a\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0011\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000f¨\u0006%"}, d2 = {"Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectIPv4Header;", "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectIPHeader;", "buffer", "", "packetLength", "", "([BI)V", "<set-?>", "Lkotlin/ParameterName;", "name", "value", "checksum", "getChecksum", "()I", "setChecksum", "(I)V", "checksum$delegate", "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectHeader$Field;", "dataLength", "getDataLength", "headerLength", "getHeaderLength", "setHeaderLength", "headerLength$delegate", ProbeTB.PROTOCOL, "getProtocol", "setProtocol", "protocol$delegate", "totalLength", "getTotalLength", "setTotalLength", "totalLength$delegate", "version", WebChromeClient.MSG_METHOD_GETVERSION, "setVersion", "version$delegate", "Companion", "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class DirectIPv4Header extends DirectIPHeader {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final int OFFSET_CHECKSUM = 10;
    public static final int OFFSET_DESTINATION_ADDRESS = 16;
    public static final int OFFSET_PROTOCOL = 9;
    public static final int OFFSET_SOURCE_ADDRESS = 12;
    public static final int OFFSET_TOTAL_LENGTH = 2;
    public static final int OFFSET_VERSION_IHL = 0;
    public static final int VPN_MTU = 1500;
    public static final ByteBuffer buffer;
    public static final DirectIPv4Header header;
    public transient /* synthetic */ FieldHolder $fh;
    public final DirectHeader.Field checksum$delegate;
    public final DirectHeader.Field headerLength$delegate;
    public final DirectHeader.Field protocol$delegate;
    public final DirectHeader.Field totalLength$delegate;
    public final DirectHeader.Field version$delegate;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectIPv4Header$Companion;", "", "()V", "OFFSET_CHECKSUM", "", "OFFSET_DESTINATION_ADDRESS", "OFFSET_PROTOCOL", "OFFSET_SOURCE_ADDRESS", "OFFSET_TOTAL_LENGTH", "OFFSET_VERSION_IHL", "VPN_MTU", "buffer", "Ljava/nio/ByteBuffer;", "getBuffer", "()Ljava/nio/ByteBuffer;", "header", "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectIPv4Header;", "getHeader", "()Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectIPv4Header;", "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final ByteBuffer getBuffer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return (ByteBuffer) invokeV.objValue;
            }
            return DirectIPv4Header.buffer;
        }

        public final DirectIPv4Header getHeader() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return (DirectIPv4Header) invokeV.objValue;
            }
            return DirectIPv4Header.header;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1814594008, "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectIPv4Header;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1814594008, "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectIPv4Header;");
                return;
            }
        }
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(DirectIPv4Header.class, "version", "getVersion()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DirectIPv4Header.class, "headerLength", "getHeaderLength()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DirectIPv4Header.class, ProbeTB.PROTOCOL, "getProtocol()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DirectIPv4Header.class, "checksum", "getChecksum()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DirectIPv4Header.class, "totalLength", "getTotalLength()I", 0))};
        Companion = new Companion(null);
        ByteBuffer allocate = ByteBuffer.allocate(1500);
        Intrinsics.checkNotNullExpressionValue(allocate, "allocate(VPN_MTU)");
        buffer = allocate;
        byte[] array = allocate.array();
        Intrinsics.checkNotNullExpressionValue(array, "buffer.array()");
        header = new DirectIPv4Header(array, 1500);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectIPv4Header(byte[] buffer2, int i) {
        super(buffer2, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {buffer2, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((byte[]) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(buffer2, "buffer");
        this.version$delegate = int4Left$tun2tornadolite_release(0);
        this.headerLength$delegate = field$tun2tornadolite_release(0, new DirectIPv4Header$headerLength$2(buffer2), new DirectIPv4Header$headerLength$3(buffer2));
        this.protocol$delegate = int8$tun2tornadolite_release(9);
        this.checksum$delegate = int16$tun2tornadolite_release(10);
        this.totalLength$delegate = int16$tun2tornadolite_release(2);
    }

    public final int getChecksum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ((Number) this.checksum$delegate.getValue(this, $$delegatedProperties[3])).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tun2tornadolite.booster.tun.ip.DirectIPHeader
    public int getDataLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return getPacketLength() - getHeaderLength();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tun2tornadolite.booster.tun.ip.DirectIPHeader
    public int getHeaderLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ((Number) this.headerLength$delegate.getValue(this, $$delegatedProperties[1])).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tun2tornadolite.booster.tun.ip.DirectIPHeader
    public int getProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return ((Number) this.protocol$delegate.getValue(this, $$delegatedProperties[2])).intValue();
        }
        return invokeV.intValue;
    }

    public final int getTotalLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ((Number) this.totalLength$delegate.getValue(this, $$delegatedProperties[4])).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tun2tornadolite.booster.tun.ip.DirectIPHeader
    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return ((Number) this.version$delegate.getValue(this, $$delegatedProperties[0])).intValue();
        }
        return invokeV.intValue;
    }

    public final void setChecksum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.checksum$delegate.setValue(this, $$delegatedProperties[3], Integer.valueOf(i));
        }
    }

    public void setHeaderLength(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.headerLength$delegate.setValue(this, $$delegatedProperties[1], Integer.valueOf(i));
        }
    }

    public void setProtocol(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.protocol$delegate.setValue(this, $$delegatedProperties[2], Integer.valueOf(i));
        }
    }

    public final void setTotalLength(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.totalLength$delegate.setValue(this, $$delegatedProperties[4], Integer.valueOf(i));
        }
    }

    @Override // com.baidu.tun2tornadolite.booster.tun.ip.DirectIPHeader
    public void setVersion(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.version$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i));
        }
    }
}
