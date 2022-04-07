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
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004RI\u0010\n\u001a\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t2\u0015\u0010\u0005\u001a\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eRI\u0010\u0011\u001a\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t2\u0015\u0010\u0005\u001a\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016RI\u0010\u0017\u001a\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t2\u0015\u0010\u0005\u001a\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectICMPHeader;", "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectHeader;", "ipHeader", "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectIPHeader;", "(Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectIPHeader;)V", "<set-?>", "", "Lkotlin/ParameterName;", "name", "value", "checksum", "getChecksum", "()I", "setChecksum", "(I)V", "checksum$delegate", "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectHeader$Field;", "code", "getCode", "setCode", "code$delegate", "getIpHeader", "()Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectIPHeader;", "type", "getType", "setType", "type$delegate", "Companion", "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class DirectICMPHeader extends DirectHeader {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final int OFFSET_CHECKSUM = 2;
    public static final int OFFSET_CODE = 1;
    public static final int OFFSET_TYPE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final DirectHeader.Field checksum$delegate;
    public final DirectHeader.Field code$delegate;
    public final DirectIPHeader ipHeader;
    public final DirectHeader.Field type$delegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectICMPHeader$Companion;", "", "()V", "OFFSET_CHECKSUM", "", "OFFSET_CODE", "OFFSET_TYPE", "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1575426944, "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectICMPHeader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1575426944, "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectICMPHeader;");
                return;
            }
        }
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(DirectICMPHeader.class, "type", "getType()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DirectICMPHeader.class, "code", "getCode()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DirectICMPHeader.class, "checksum", "getChecksum()I", 0))};
        Companion = new Companion(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectICMPHeader(DirectIPHeader ipHeader) {
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
        this.type$delegate = int8$tun2tornadolite_release(0);
        this.code$delegate = int8$tun2tornadolite_release(1);
        this.checksum$delegate = int16$tun2tornadolite_release(2);
    }

    public final int getChecksum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ((Number) this.checksum$delegate.getValue(this, $$delegatedProperties[2])).intValue() : invokeV.intValue;
    }

    public final int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ((Number) this.code$delegate.getValue(this, $$delegatedProperties[1])).intValue() : invokeV.intValue;
    }

    public final DirectIPHeader getIpHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.ipHeader : (DirectIPHeader) invokeV.objValue;
    }

    public final int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ((Number) this.type$delegate.getValue(this, $$delegatedProperties[0])).intValue() : invokeV.intValue;
    }

    public final void setChecksum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.checksum$delegate.setValue(this, $$delegatedProperties[2], Integer.valueOf(i));
        }
    }

    public final void setCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.code$delegate.setValue(this, $$delegatedProperties[1], Integer.valueOf(i));
        }
    }

    public final void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.type$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i));
        }
    }
}
