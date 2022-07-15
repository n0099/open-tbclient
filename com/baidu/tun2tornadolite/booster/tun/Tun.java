package com.baidu.tun2tornadolite.booster.tun;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.LogTo;
import com.baidu.tun2tornadolite.booster.sclient.SClient;
import com.baidu.tun2tornadolite.booster.sclient.SClientPacket;
import com.baidu.tun2tornadolite.booster.tun.ip.DirectIPHeader;
import com.baidu.tun2tornadolite.booster.tun.ip.DirectIPv4Header;
import com.baidu.tun2tornadolite.booster.tun.ip.DirectIPv6Header;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016J\u0011\u0010\u0018\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0016H\u0002J \u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0016H\u0002J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0011\u0010'\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0006\u0010(\u001a\u00020\u0007J\u0016\u0010)\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lcom/baidu/tun2tornadolite/booster/tun/Tun;", "", "()V", "descriptor", "Landroid/os/ParcelFileDescriptor;", "handleLoop", "Lkotlinx/coroutines/Deferred;", "", "getHandleLoop", "()Lkotlinx/coroutines/Deferred;", "setHandleLoop", "(Lkotlinx/coroutines/Deferred;)V", "headerBuf", "Ljava/nio/ByteBuffer;", "inited", "", "input", "Ljava/io/FileInputStream;", "looping", "output", "Ljava/io/FileOutputStream;", "tunfd", "", "init", "loop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processICMP", "buffer", "ipHeader", "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectIPHeader;", "processICMPv6", "processOther", CloudStabilityUBCUtils.KEY_LENGTH, "processPacket", "i", "", "processTcp", "packet", "processUdp", "start", IntentConfig.STOP, AlbumActivityConfig.FROM_WRITE, "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class Tun {
    public static /* synthetic */ Interceptable $ic;
    public static final Tun INSTANCE;
    public static ParcelFileDescriptor descriptor;
    public static Deferred<Unit> handleLoop;
    public static ByteBuffer headerBuf;
    public static boolean inited;
    public static FileInputStream input;
    public static boolean looping;
    public static FileOutputStream output;
    public static int tunfd;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-19671378, "Lcom/baidu/tun2tornadolite/booster/tun/Tun;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-19671378, "Lcom/baidu/tun2tornadolite/booster/tun/Tun;");
                return;
            }
        }
        INSTANCE = new Tun();
        ByteBuffer allocate = ByteBuffer.allocate(4);
        Intrinsics.checkNotNullExpressionValue(allocate, "allocate(4)");
        headerBuf = allocate;
    }

    public Tun() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loop(Continuation<? super Unit> continuation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, continuation)) == null) {
            Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new Tun$loop$2(null), continuation);
            return withContext == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
        }
        return invokeL.objValue;
    }

    private final void processICMP(ByteBuffer byteBuffer, DirectIPHeader directIPHeader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, byteBuffer, directIPHeader) == null) {
        }
    }

    private final void processICMPv6(ByteBuffer byteBuffer, DirectIPHeader directIPHeader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, this, byteBuffer, directIPHeader) == null) {
        }
    }

    private final void processOther(ByteBuffer byteBuffer, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, this, byteBuffer, i) == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processPacket(long j, ByteBuffer byteBuffer, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{Long.valueOf(j), byteBuffer, Integer.valueOf(i)}) == null) {
            try {
                int m1654constructorimpl = (UByte.m1654constructorimpl(byteBuffer.get(0)) & 255) >>> 4;
                if (m1654constructorimpl != 4) {
                    return;
                }
                DirectIPv4Header.Companion.getHeader().setPacketLength(i);
                DirectIPv4Header header = DirectIPv4Header.Companion.getHeader();
                int protocol = header.getProtocol();
                if (protocol == 1) {
                    processICMP(byteBuffer, header);
                } else if (protocol == 6) {
                    processTcp(byteBuffer, header);
                } else if (protocol == 17) {
                    processUdp(byteBuffer, header);
                } else if (protocol != 58) {
                    processOther(byteBuffer, i);
                } else {
                    processICMPv6(byteBuffer, header);
                }
                LogTo logTo = LogTo.INSTANCE;
                logTo.d("*****", "[TUN " + j + "] read data len:" + i + " ipVersion: " + m1654constructorimpl + " protocol: " + protocol);
            } catch (ErrnoException e) {
                looping = false;
                e.printStackTrace();
            } catch (InterruptedException e2) {
                looping = false;
                e2.printStackTrace();
            } catch (SecurityException e3) {
                looping = false;
                e3.printStackTrace();
            } catch (Throwable th) {
                looping = false;
                th.printStackTrace();
            }
        }
    }

    private final void processTcp(ByteBuffer byteBuffer, DirectIPHeader directIPHeader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, byteBuffer, directIPHeader) == null) {
            if (directIPHeader instanceof DirectIPv4Header) {
                SClientPacket sClientPacket = new SClientPacket(1, 0, 1, UInt.m1730constructorimpl(directIPHeader.getPacketLength()), null);
                sClientPacket.encodeHeader2Buffer(headerBuf);
                sClientPacket.writeBodyBuffer(byteBuffer);
                SClient.INSTANCE.write(sClientPacket);
                return;
            }
            boolean z = directIPHeader instanceof DirectIPv6Header;
        }
    }

    private final void processUdp(ByteBuffer byteBuffer, DirectIPHeader directIPHeader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, this, byteBuffer, directIPHeader) == null) {
            SClientPacket sClientPacket = new SClientPacket(1, 0, 1, UInt.m1730constructorimpl(directIPHeader.getPacketLength()), null);
            sClientPacket.encodeHeader2Buffer(headerBuf);
            sClientPacket.writeBodyBuffer(byteBuffer);
            SClient.INSTANCE.write(sClientPacket);
        }
    }

    public final Deferred<Unit> getHandleLoop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Deferred<Unit> deferred = handleLoop;
            if (deferred != null) {
                return deferred;
            }
            Intrinsics.throwUninitializedPropertyAccessException("handleLoop");
            return null;
        }
        return (Deferred) invokeV.objValue;
    }

    public final void init(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || inited) {
            return;
        }
        tunfd = i;
        ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(i);
        Intrinsics.checkNotNullExpressionValue(fromFd, "fromFd(tunfd)");
        descriptor = fromFd;
        ParcelFileDescriptor parcelFileDescriptor = descriptor;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        if (parcelFileDescriptor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descriptor");
            parcelFileDescriptor = null;
        }
        input = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
        ParcelFileDescriptor parcelFileDescriptor3 = descriptor;
        if (parcelFileDescriptor3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descriptor");
        } else {
            parcelFileDescriptor2 = parcelFileDescriptor3;
        }
        output = new FileOutputStream(parcelFileDescriptor2.getFileDescriptor());
        inited = true;
    }

    public final void setHandleLoop(Deferred<Unit> deferred) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, deferred) == null) {
            Intrinsics.checkNotNullParameter(deferred, "<set-?>");
            handleLoop = deferred;
        }
    }

    public final Object start(Continuation<? super Unit> continuation) {
        InterceptResult invokeL;
        Job launch$default;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, continuation)) == null) {
            if (inited) {
                launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getUnconfined()), null, null, new Tun$start$2(null), 3, null);
                return launch$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? launch$default : Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        return invokeL.objValue;
    }

    public final void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            looping = false;
        }
    }

    public final void write(ByteBuffer buffer, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, buffer, i) == null) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            if (inited) {
                FileOutputStream fileOutputStream = output;
                if (fileOutputStream == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("output");
                    fileOutputStream = null;
                }
                fileOutputStream.write(buffer.array(), 0, i);
            }
        }
    }
}
