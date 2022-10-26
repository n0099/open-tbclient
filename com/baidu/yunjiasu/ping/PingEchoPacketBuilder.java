package com.baidu.yunjiasu.ping;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\nR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/yunjiasu/ping/PingEchoPacketBuilder;", "", "mType", "", "payload", "", "(B[B)V", "mAutoIdentifier", "", "mIdentifier", "", "mPayload", "mSequenceNumber", "build", "Ljava/nio/ByteBuffer;", "setAutoIdentifier", "", "value", "setIdentifier", "identifier", "setSequenceNumber", "sequenceNumber", "Companion", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class PingEchoPacketBuilder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte CODE = 0;
    public static final Companion Companion;
    public static final int MAX_PAYLOAD = 65507;
    public static final byte TYPE_ICMP_V4 = 8;
    public static final byte TYPE_ICMP_V6 = Byte.MIN_VALUE;
    public static final AtomicInteger sSequence;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAutoIdentifier;
    public short mIdentifier;
    public final byte[] mPayload;
    public short mSequenceNumber;
    public final byte mType;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/yunjiasu/ping/PingEchoPacketBuilder$Companion;", "", "()V", "CODE", "", "MAX_PAYLOAD", "", "TYPE_ICMP_V4", "TYPE_ICMP_V6", "sSequence", "Ljava/util/concurrent/atomic/AtomicInteger;", "checksum", "", "data", "", "end", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes6.dex */
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

        public final short checksum(byte[] data, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, data, i)) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3 += 2) {
                    int i4 = i2 + ((data[i3] & 255) << 8);
                    i2 = (i4 >> 16) + (65535 & i4);
                }
                for (int i5 = 1; i5 < i; i5 += 2) {
                    int i6 = i2 + (data[i5] & 255);
                    i2 = (i6 >> 16) + (i6 & 65535);
                }
                return (short) (((i2 & 65535) + (i2 >> 16)) ^ 65535);
            }
            return invokeLI.shortValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-19759251, "Lcom/baidu/yunjiasu/ping/PingEchoPacketBuilder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-19759251, "Lcom/baidu/yunjiasu/ping/PingEchoPacketBuilder;");
                return;
            }
        }
        Companion = new Companion(null);
        sSequence = new AtomicInteger(0);
    }

    public PingEchoPacketBuilder(byte b, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Byte.valueOf(b), bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mType = b;
        this.mIdentifier = (short) 3515;
        this.mAutoIdentifier = true;
        if (bArr == null) {
            bArr = new byte[0];
        } else if (bArr.length > 65507) {
            throw new IllegalArgumentException("Payload limited to 65507");
        }
        this.mPayload = bArr;
    }

    public final ByteBuffer build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mAutoIdentifier) {
                this.mIdentifier = (short) sSequence.getAndIncrement();
            }
            int length = this.mPayload.length + 8;
            byte[] bArr = new byte[length];
            ByteBuffer byteBuffer = ByteBuffer.wrap(bArr);
            byteBuffer.put(this.mType);
            byteBuffer.put((byte) 0);
            int position = byteBuffer.position();
            byteBuffer.position(position + 2);
            byteBuffer.putShort(this.mIdentifier);
            byteBuffer.putShort(this.mSequenceNumber);
            byteBuffer.put(this.mPayload);
            byteBuffer.putShort(position, Companion.checksum(bArr, length));
            byteBuffer.flip();
            Intrinsics.checkNotNullExpressionValue(byteBuffer, "byteBuffer");
            return byteBuffer;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    public final void setAutoIdentifier(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.mAutoIdentifier = z;
        }
    }

    public final void setIdentifier(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Short.valueOf(s)}) == null) {
            this.mAutoIdentifier = false;
            this.mIdentifier = s;
        }
    }

    public final void setSequenceNumber(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Short.valueOf(s)}) == null) {
            this.mSequenceNumber = s;
        }
    }
}
