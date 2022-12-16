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
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u0000 #2\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004RI\u0010\n\u001a\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t2\u0015\u0010\u0005\u001a\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fRI\u0010\u0013\u001a\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t2\u0015\u0010\u0005\u001a\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aRI\u0010\u001b\u001a\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t2\u0015\u0010\u0005\u001a\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eRI\u0010\u001f\u001a\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t2\u0015\u0010\u0005\u001a\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0010\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000e¨\u0006$"}, d2 = {"Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectUdpHeader;", "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectHeader;", "ipHeader", "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectIPHeader;", "(Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectIPHeader;)V", "<set-?>", "", "Lkotlin/ParameterName;", "name", "value", "checksum", "getChecksum", "()I", "setChecksum", "(I)V", "checksum$delegate", "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectHeader$Field;", "dataLength", "getDataLength", "destinationPort", "getDestinationPort", "setDestinationPort", "destinationPort$delegate", "headerLength", "getHeaderLength", "getIpHeader", "()Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectIPHeader;", "sourcePort", "getSourcePort", "setSourcePort", "sourcePort$delegate", "totalLength", "getTotalLength", "setTotalLength", "totalLength$delegate", "Companion", "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class DirectUdpHeader extends DirectHeader {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final int OFFSET_CHECKSUM = 6;
    public static final int OFFSET_DESTINATION_PORT = 2;
    public static final int OFFSET_LENGTH = 4;
    public static final int OFFSET_SOURCE_PORT = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final DirectHeader.Field checksum$delegate;
    public final int dataLength;
    public final DirectHeader.Field destinationPort$delegate;
    public final int headerLength;
    public final DirectIPHeader ipHeader;
    public final DirectHeader.Field sourcePort$delegate;
    public final DirectHeader.Field totalLength$delegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectUdpHeader$Companion;", "", "()V", "OFFSET_CHECKSUM", "", "OFFSET_DESTINATION_PORT", "OFFSET_LENGTH", "OFFSET_SOURCE_PORT", "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2065206690, "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectUdpHeader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2065206690, "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectUdpHeader;");
                return;
            }
        }
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(DirectUdpHeader.class, "sourcePort", "getSourcePort()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DirectUdpHeader.class, "destinationPort", "getDestinationPort()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DirectUdpHeader.class, "totalLength", "getTotalLength()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DirectUdpHeader.class, "checksum", "getChecksum()I", 0))};
        Companion = new Companion(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectUdpHeader(DirectIPHeader ipHeader) {
        super(ipHeader.getBuffer(), ipHeader.getHeaderLength());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ipHeader};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((byte[]) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(ipHeader, "ipHeader");
        this.ipHeader = ipHeader;
        this.sourcePort$delegate = int16$tun2tornadolite_release(0);
        this.destinationPort$delegate = int16$tun2tornadolite_release(2);
        this.totalLength$delegate = int16$tun2tornadolite_release(4);
        this.checksum$delegate = int16$tun2tornadolite_release(6);
        this.headerLength = 8;
        this.dataLength = this.ipHeader.getDataLength() - this.headerLength;
    }

    public final int getChecksum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ((Number) this.checksum$delegate.getValue(this, $$delegatedProperties[3])).intValue();
        }
        return invokeV.intValue;
    }

    public final int getDataLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.dataLength;
        }
        return invokeV.intValue;
    }

    public final int getDestinationPort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ((Number) this.destinationPort$delegate.getValue(this, $$delegatedProperties[1])).intValue();
        }
        return invokeV.intValue;
    }

    public final int getHeaderLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.headerLength;
        }
        return invokeV.intValue;
    }

    public final DirectIPHeader getIpHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.ipHeader;
        }
        return (DirectIPHeader) invokeV.objValue;
    }

    public final int getSourcePort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return ((Number) this.sourcePort$delegate.getValue(this, $$delegatedProperties[0])).intValue();
        }
        return invokeV.intValue;
    }

    public final int getTotalLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return ((Number) this.totalLength$delegate.getValue(this, $$delegatedProperties[2])).intValue();
        }
        return invokeV.intValue;
    }

    public final void setChecksum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.checksum$delegate.setValue(this, $$delegatedProperties[3], Integer.valueOf(i));
        }
    }

    public final void setDestinationPort(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.destinationPort$delegate.setValue(this, $$delegatedProperties[1], Integer.valueOf(i));
        }
    }

    public final void setSourcePort(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.sourcePort$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i));
        }
    }

    public final void setTotalLength(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.totalLength$delegate.setValue(this, $$delegatedProperties[2], Integer.valueOf(i));
        }
    }
}
