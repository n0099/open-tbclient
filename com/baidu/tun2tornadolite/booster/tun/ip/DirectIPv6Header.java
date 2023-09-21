package com.baidu.tun2tornadolite.booster.tun.ip;

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
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000  2\u00020\u0001:\u0001 B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000RI\u0010\f\u001a\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b2\u0015\u0010\b\u001a\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000RI\u0010\u0016\u001a\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b2\u0015\u0010\b\u001a\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u0014\u0010\u001a\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000eRI\u0010\u001c\u001a\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b2\u0015\u0010\b\u001a\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010¨\u0006!"}, d2 = {"Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectIPv6Header;", "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectIPHeader;", "buffer", "", "packetLength", "", "([BI)V", "_protocol", "<set-?>", "Lkotlin/ParameterName;", "name", "value", "dataLength", "getDataLength", "()I", "setDataLength", "(I)V", "dataLength$delegate", "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectHeader$Field;", "headerLength", "getHeaderLength", "headerOffset", "nextHeader", "getNextHeader", "setNextHeader", "nextHeader$delegate", ProbeTB.PROTOCOL, "getProtocol", "version", WebChromeClient.MSG_METHOD_GETVERSION, "setVersion", "version$delegate", "Companion", "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class DirectIPv6Header extends DirectIPHeader {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final int OFFSET_DESTINATION_ADDRESS = 24;
    public static final int OFFSET_HEADER = 40;
    public static final int OFFSET_NEXT_HEADER = 6;
    public static final int OFFSET_PAYLOAD_LENGTH = 4;
    public static final int OFFSET_SOURCE_ADDRESS = 8;
    public static final int OFFSET_VERSION = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int _protocol;
    public final DirectHeader.Field dataLength$delegate;
    public int headerOffset;
    public final DirectHeader.Field nextHeader$delegate;
    public final DirectHeader.Field version$delegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectIPv6Header$Companion;", "", "()V", "OFFSET_DESTINATION_ADDRESS", "", "OFFSET_HEADER", "OFFSET_NEXT_HEADER", "OFFSET_PAYLOAD_LENGTH", "OFFSET_SOURCE_ADDRESS", "OFFSET_VERSION", "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes9.dex */
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1005247382, "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectIPv6Header;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1005247382, "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectIPv6Header;");
                return;
            }
        }
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(DirectIPv6Header.class, "version", "getVersion()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DirectIPv6Header.class, "dataLength", "getDataLength()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DirectIPv6Header.class, "nextHeader", "getNextHeader()I", 0))};
        Companion = new Companion(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectIPv6Header(byte[] buffer, int i) {
        super(buffer, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {buffer, Integer.valueOf(i)};
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
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.version$delegate = int4Left$tun2tornadolite_release(0);
        this.dataLength$delegate = int16$tun2tornadolite_release(4);
        this.nextHeader$delegate = int8$tun2tornadolite_release(6);
    }

    @Override // com.baidu.tun2tornadolite.booster.tun.ip.DirectIPHeader
    public int getDataLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ((Number) this.dataLength$delegate.getValue(this, $$delegatedProperties[1])).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tun2tornadolite.booster.tun.ip.DirectIPHeader
    public int getHeaderLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            getProtocol();
            return this.headerOffset;
        }
        return invokeV.intValue;
    }

    public final int getNextHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ((Number) this.nextHeader$delegate.getValue(this, $$delegatedProperties[2])).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tun2tornadolite.booster.tun.ip.DirectIPHeader
    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ((Number) this.version$delegate.getValue(this, $$delegatedProperties[0])).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tun2tornadolite.booster.tun.ip.DirectIPHeader
    public int getProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.headerOffset != 0) {
                return this._protocol;
            }
            this.headerOffset = 40;
            int nextHeader = getNextHeader();
            int packetLength = (getPacketLength() - getOffset()) - getDataLength();
            while (this.headerOffset < packetLength && nextHeader != 58 && nextHeader != 6 && nextHeader != 17) {
                nextHeader = UByte.m870constructorimpl(getBuffer()[this.headerOffset]) & 255;
                this.headerOffset += (UByte.m870constructorimpl(getBuffer()[this.headerOffset + 1]) & 255) + 2;
            }
            this._protocol = nextHeader;
            return nextHeader;
        }
        return invokeV.intValue;
    }

    public void setDataLength(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.dataLength$delegate.setValue(this, $$delegatedProperties[1], Integer.valueOf(i));
        }
    }

    public final void setNextHeader(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.nextHeader$delegate.setValue(this, $$delegatedProperties[2], Integer.valueOf(i));
        }
    }

    @Override // com.baidu.tun2tornadolite.booster.tun.ip.DirectIPHeader
    public void setVersion(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.version$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i));
        }
    }
}
