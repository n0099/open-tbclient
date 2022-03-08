package com.baidu.tun2tornadolite.booster.sclient;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.LogTo;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
import com.baidu.tun2tornadolite.booster.tun.Tun;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.net.Socket;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.baidu.tun2tornadolite.booster.sclient.SClient$loop$2", f = "SClient.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class SClient$loop$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SClient$loop$2(Continuation<? super SClient$loop$2> continuation) {
        super(2, continuation);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {continuation};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (Continuation) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, continuation)) == null) ? new SClient$loop$2(continuation) : (Continuation) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, coroutineScope, continuation)) == null) ? ((SClient$loop$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : invokeLL.objValue;
    }

    /* JADX WARN: Incorrect condition in loop: B:9:0x002d */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        InterceptResult invokeL;
        Socket socket;
        Socket socket2;
        boolean z;
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        ByteBuffer byteBuffer3;
        ByteBuffer byteBuffer4;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    socket2 = SClient.socket;
                    Intrinsics.checkNotNull(socket2);
                    DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(socket2.getInputStream()));
                    byte[] bArr = new byte[4];
                    long j2 = 0;
                    while (z) {
                        try {
                            bArr[0] = dataInputStream.readByte();
                            bArr[1] = dataInputStream.readByte();
                            bArr[2] = dataInputStream.readByte();
                            bArr[3] = dataInputStream.readByte();
                            SClientPacket createPacketByHeader = SClientPacket.Companion.createPacketByHeader(bArr);
                            byteBuffer = SClient.headerBuffer;
                            createPacketByHeader.encodeHeader2Buffer(byteBuffer);
                            byteBuffer2 = SClient.bodyBuffer;
                            byteBuffer2.clear();
                            int m91getBodyLengthpVg5ArA = createPacketByHeader.m91getBodyLengthpVg5ArA();
                            int i2 = 0;
                            int i3 = 0;
                            int i4 = 0;
                            while (true) {
                                if (i2 >= createPacketByHeader.m91getBodyLengthpVg5ArA()) {
                                    break;
                                }
                                byteBuffer4 = SClient.bodyBuffer;
                                int read = dataInputStream.read(byteBuffer4.array(), i3, m91getBodyLengthpVg5ArA);
                                if (read < 0) {
                                    SClient sClient = SClient.INSTANCE;
                                    SClient.looping = false;
                                    break;
                                }
                                i2 += read;
                                i3 += read;
                                m91getBodyLengthpVg5ArA -= read;
                                LogTo logTo = LogTo.INSTANCE;
                                StringBuilder sb = new StringBuilder();
                                sb.append("[Socket ");
                                sb.append(i4);
                                sb.append("] read socket len:");
                                sb.append(read);
                                sb.append(" mustLen:");
                                sb.append(i2);
                                sb.append(" offset:");
                                sb.append(i3);
                                sb.append(" left:");
                                sb.append(m91getBodyLengthpVg5ArA);
                                sb.append(" all:");
                                sb.append(createPacketByHeader.m91getBodyLengthpVg5ArA());
                                sb.append(" from:");
                                str = SClient.address;
                                sb.append((Object) str);
                                logTo.d("*****", sb.toString());
                                if (m91getBodyLengthpVg5ArA == 0) {
                                    break;
                                }
                                i4++;
                            }
                            byteBuffer3 = SClient.bodyBuffer;
                            createPacketByHeader.writeBodyBuffer(byteBuffer3);
                            SClient.INSTANCE.processPacket(j2, createPacketByHeader);
                            j2++;
                        } catch (EOFException e2) {
                            SClient sClient2 = SClient.INSTANCE;
                            SClient.looping = false;
                            TornadoLiteRuntime.INSTANCE.onEvent$tun2tornadolite_release(41L, "服务器断开连接");
                            e2.printStackTrace();
                        } catch (Exception e3) {
                            SClient sClient3 = SClient.INSTANCE;
                            SClient.looping = false;
                            e3.printStackTrace();
                        }
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                    SClient sClient4 = SClient.INSTANCE;
                    SClient.looping = false;
                }
                socket = SClient.socket;
                if (socket != null) {
                    socket.close();
                }
                Tun.INSTANCE.stop();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return invokeL.objValue;
    }
}
