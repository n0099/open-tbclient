package com.baidu.tun2tornadolite.booster.sclient;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.UStringsKt;
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B(\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tJ\u0006\u0010\u0015\u001a\u00020\tJ\u0006\u0010\u0016\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u000e\u001a\u00020\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u000f\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Lcom/baidu/tun2tornadolite/booster/sclient/SClientPacket;", "", "version", "Lkotlin/UInt;", GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED, "command", "bodyLength", "(IIIILkotlin/jvm/internal/DefaultConstructorMarker;)V", TtmlNode.TAG_BODY, "Ljava/nio/ByteBuffer;", "getBodyLength-pVg5ArA", "()I", "I", "getCommand-pVg5ArA", "header", "headerBuf", "getReserved-pVg5ArA", "getVersion-pVg5ArA", "encodeHeader2Buffer", "", "buf", "getBody", "getHeader", "writeBodyBuffer", "Companion", "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class SClientPacket {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CMD_EVENT = 2;
    public static final int CMD_HAND_SHAKE = 0;
    public static final int CMD_HEART_BEAT = 3;
    public static final int CMD_IP_PACKET = 1;
    public static final Companion Companion;
    public static final int RESERVED = 0;
    public static final int VERSION = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer body;
    public final int bodyLength;
    public final int command;
    public int header;
    public ByteBuffer headerBuf;
    public final int reserved;
    public final int version;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(792584324, "Lcom/baidu/tun2tornadolite/booster/sclient/SClientPacket;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(792584324, "Lcom/baidu/tun2tornadolite/booster/sclient/SClientPacket;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    public /* synthetic */ SClientPacket(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4);
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J!\u0010\u0014\u001a\u00020\f*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u0014\u001a\u00020\f*\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0007\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\b\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\t\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\n\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lcom/baidu/tun2tornadolite/booster/sclient/SClientPacket$Companion;", "", "()V", "CMD_EVENT", "Lkotlin/UInt;", "I", "CMD_HAND_SHAKE", "CMD_HEART_BEAT", "CMD_IP_PACKET", "RESERVED", "VERSION", "cmd2Str", "", "cmd", "cmd2Str-WZ4Q5Ns", "(I)Ljava/lang/String;", "createPacketByHeader", "Lcom/baidu/tun2tornadolite/booster/sclient/SClientPacket;", "header", "", "toBinary", "Lkotlin/UByte;", "len", "", "toBinary-0ky7B_Q", "(BI)Ljava/lang/String;", "toBinary-qim9Vi0", "(II)Ljava/lang/String;", "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: cmd2Str-WZ4Q5Ns  reason: not valid java name */
        public final String m63cmd2StrWZ4Q5Ns(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? i != 0 ? i != 1 ? i != 2 ? i != 3 ? HlsPlaylistParser.METHOD_NONE : "CMD_HEART_BEAT" : "CMD_EVENT" : "CMD_IP_PACKET" : "CMD_HAND_SHAKE" : (String) invokeI.objValue;
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

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('%' char), (r6v0 int), ('s' char)] */
        /* renamed from: toBinary-0ky7B_Q  reason: not valid java name */
        private final String m61toBinary0ky7B_Q(byte b, int i) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Byte.valueOf(b), Integer.valueOf(i)})) == null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                StringBuilder sb = new StringBuilder();
                sb.append('%');
                sb.append(i);
                sb.append('s');
                String format = String.format(sb.toString(), Arrays.copyOf(new Object[]{UStringsKt.m1970toStringLxnNnR4(b, 2)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                return new Regex(" ").replace(format, "0");
            }
            return (String) invokeCommon.objValue;
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('%' char), (r6v0 int), ('s' char)] */
        /* renamed from: toBinary-qim9Vi0  reason: not valid java name */
        private final String m62toBinaryqim9Vi0(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(65539, this, i, i2)) == null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                StringBuilder sb = new StringBuilder();
                sb.append('%');
                sb.append(i2);
                sb.append('s');
                String format = String.format(sb.toString(), Arrays.copyOf(new Object[]{UStringsKt.m1971toStringV7xB4Y4(i, 2)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                return new Regex(" ").replace(format, "0");
            }
            return (String) invokeII.objValue;
        }

        public final SClientPacket createPacketByHeader(byte[] header) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, header)) == null) {
                Intrinsics.checkNotNullParameter(header, "header");
                return new SClientPacket(UInt.m792constructorimpl((UByte.m716constructorimpl(header[0]) & 255) >> 4), UInt.m792constructorimpl(UByte.m716constructorimpl(header[0]) & 255 & 15), UInt.m792constructorimpl(UByte.m716constructorimpl(header[1]) & 255), UInt.m792constructorimpl(UInt.m792constructorimpl(UByte.m716constructorimpl(header[3]) & 255) | UInt.m792constructorimpl(UInt.m792constructorimpl(UByte.m716constructorimpl(header[2]) & 255) << 8)), null);
            }
            return (SClientPacket) invokeL.objValue;
        }
    }

    public SClientPacket(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.version = i;
        this.reserved = i2;
        this.command = i3;
        this.bodyLength = i4;
    }

    public final void encodeHeader2Buffer(ByteBuffer buf) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, buf) == null) {
            Intrinsics.checkNotNullParameter(buf, "buf");
            int m792constructorimpl = UInt.m792constructorimpl(UInt.m792constructorimpl(m60getVersionpVg5ArA() & 15) << 28);
            this.header = m792constructorimpl;
            int m792constructorimpl2 = UInt.m792constructorimpl(m792constructorimpl | UInt.m792constructorimpl(UInt.m792constructorimpl(m59getReservedpVg5ArA() & 15) << 24));
            this.header = m792constructorimpl2;
            int m792constructorimpl3 = UInt.m792constructorimpl(m792constructorimpl2 | UInt.m792constructorimpl(UInt.m792constructorimpl(m58getCommandpVg5ArA() & 255) << 16));
            this.header = m792constructorimpl3;
            this.header = UInt.m792constructorimpl(m792constructorimpl3 | UInt.m792constructorimpl(UInt.m792constructorimpl(m57getBodyLengthpVg5ArA() & 65535) << 0));
            this.headerBuf = buf;
            ByteBuffer byteBuffer = null;
            if (buf == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerBuf");
                buf = null;
            }
            buf.clear();
            ByteBuffer byteBuffer2 = this.headerBuf;
            if (byteBuffer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerBuf");
                byteBuffer2 = null;
            }
            byteBuffer2.put((byte) UInt.m792constructorimpl(UInt.m792constructorimpl(this.header >>> 24) & 255));
            ByteBuffer byteBuffer3 = this.headerBuf;
            if (byteBuffer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerBuf");
                byteBuffer3 = null;
            }
            byteBuffer3.put((byte) UInt.m792constructorimpl(UInt.m792constructorimpl(this.header >>> 16) & 255));
            ByteBuffer byteBuffer4 = this.headerBuf;
            if (byteBuffer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerBuf");
                byteBuffer4 = null;
            }
            byteBuffer4.put((byte) UInt.m792constructorimpl(UInt.m792constructorimpl(this.header >>> 8) & 255));
            ByteBuffer byteBuffer5 = this.headerBuf;
            if (byteBuffer5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerBuf");
            } else {
                byteBuffer = byteBuffer5;
            }
            byteBuffer.put((byte) UInt.m792constructorimpl(UInt.m792constructorimpl(this.header >>> 0) & 255));
        }
    }

    public final ByteBuffer getBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ByteBuffer byteBuffer = this.body;
            if (byteBuffer == null) {
                Intrinsics.throwUninitializedPropertyAccessException(TtmlNode.TAG_BODY);
                return null;
            }
            return byteBuffer;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    /* renamed from: getBodyLength-pVg5ArA  reason: not valid java name */
    public final int m57getBodyLengthpVg5ArA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.bodyLength;
        }
        return invokeV.intValue;
    }

    /* renamed from: getCommand-pVg5ArA  reason: not valid java name */
    public final int m58getCommandpVg5ArA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.command;
        }
        return invokeV.intValue;
    }

    public final ByteBuffer getHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ByteBuffer byteBuffer = this.headerBuf;
            if (byteBuffer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerBuf");
                return null;
            }
            return byteBuffer;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    /* renamed from: getReserved-pVg5ArA  reason: not valid java name */
    public final int m59getReservedpVg5ArA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.reserved;
        }
        return invokeV.intValue;
    }

    /* renamed from: getVersion-pVg5ArA  reason: not valid java name */
    public final int m60getVersionpVg5ArA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.version;
        }
        return invokeV.intValue;
    }

    public final void writeBodyBuffer(ByteBuffer body) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, body) == null) {
            Intrinsics.checkNotNullParameter(body, "body");
            this.body = body;
        }
    }
}
