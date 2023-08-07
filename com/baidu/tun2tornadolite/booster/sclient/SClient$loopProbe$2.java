package com.baidu.tun2tornadolite.booster.sclient;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.AndroidOperationInterface;
import com.baidu.tun2tornadolite.booster.LogTo;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.baidu.tun2tornadolite.booster.sclient.SClient$loopProbe$2", f = "SClient.kt", i = {0, 0, 0, 0}, l = {409}, m = "invokeSuspend", n = {"cache", "handleData", "size", "index"}, s = {"L$0", "L$1", "I$0", "J$0"})
/* loaded from: classes9.dex */
public final class SClient$loopProbe$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int I$0;
    public long J$0;
    public Object L$0;
    public Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SClient$loopProbe$2(Continuation<? super SClient$loopProbe$2> continuation) {
        super(2, continuation);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {continuation};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, continuation)) == null) ? new SClient$loopProbe$2(continuation) : (Continuation) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, coroutineScope, continuation)) == null) ? ((SClient$loopProbe$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : invokeLL.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:(1:20)|21|(3:23|(3:24|(1:26)|(1:29)(1:28))|30)|31|(1:33)(4:49|50|51|52)|34|35|36|37|38|(1:40)|10|11|12|(2:14|(1:16)(2:18|19))(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(4:49|50|51|52) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0152, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0153, code lost:
        r1 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0155, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0156, code lost:
        r1 = r15;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x014b -> B:47:0x014e). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x015c -> B:55:0x0165). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        InterceptResult invokeL;
        AndroidOperationInterface androidOperationInterface;
        String str;
        Function1<UByte, Long> function1;
        SClient$loopProbe$2 sClient$loopProbe$2;
        long j;
        Integer[] numArr;
        int i;
        DatagramSocket datagramSocket;
        Throwable th;
        Object obj2;
        boolean z;
        Object obj3;
        DatagramSocket datagramSocket2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            long j2 = 0;
            int i3 = 0;
            if (i2 != 0) {
                if (i2 == 1) {
                    j = this.J$0;
                    i = this.I$0;
                    function1 = (Function1) this.L$1;
                    numArr = (Integer[]) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        sClient$loopProbe$2 = this;
                        obj2 = coroutine_suspended;
                    } catch (Throwable th2) {
                        th = th2;
                        sClient$loopProbe$2 = this;
                        obj2 = coroutine_suspended;
                        SClient sClient = SClient.INSTANCE;
                        SClient.looping = false;
                        th.printStackTrace();
                        coroutine_suspended = obj2;
                        j2 = 0;
                        i3 = 0;
                        z = SClient.looping;
                        if (z) {
                        }
                    }
                    j++;
                    coroutine_suspended = obj2;
                    j2 = 0;
                    i3 = 0;
                    z = SClient.looping;
                    if (z) {
                        try {
                        } catch (Throwable th3) {
                            th = th3;
                            obj2 = coroutine_suspended;
                            SClient sClient2 = SClient.INSTANCE;
                            SClient.looping = false;
                            th.printStackTrace();
                            coroutine_suspended = obj2;
                            j2 = 0;
                            i3 = 0;
                            z = SClient.looping;
                            if (z) {
                            }
                        }
                        ArraysKt___ArraysJvmKt.fill(numArr, Boxing.boxInt(i3), i3, i - 1);
                        long j3 = j2;
                        if (i > 0) {
                            int i4 = 0;
                            while (true) {
                                int i5 = i4 + 1;
                                long longValue = function1.invoke(UByte.m859boximpl(UByte.m865constructorimpl((byte) i4))).longValue();
                                if (longValue != j2) {
                                    j3 += longValue;
                                }
                                if (i5 >= i) {
                                    break;
                                }
                                i4 = i5;
                            }
                        }
                        int sumOfInt = ArraysKt___ArraysKt.sumOfInt(numArr);
                        if (sumOfInt == 0) {
                            TornadoLiteRuntime.INSTANCE.setLossRateFromMClientToSClient$tun2tornadolite_release(100);
                            TornadoLiteRuntime.INSTANCE.setLatencyFromMClientToSClient$tun2tornadolite_release(1000);
                            obj3 = coroutine_suspended;
                        } else {
                            obj3 = coroutine_suspended;
                            TornadoLiteRuntime.INSTANCE.setLossRateFromMClientToSClient$tun2tornadolite_release((int) (((1000 - (sumOfInt * 100)) / 1000.0d) * 100));
                            TornadoLiteRuntime.INSTANCE.setLatencyFromMClientToSClient$tun2tornadolite_release((int) (((float) j3) / sumOfInt));
                        }
                        LogTo.INSTANCE.d("*****", "[Probe " + j + "] packets:" + sumOfInt + WebvttCueParser.CHAR_SLASH + i + " loss:" + TornadoLiteRuntime.INSTANCE.getLossRateFromMClientToSClient() + " latency:" + TornadoLiteRuntime.INSTANCE.getLatencyFromMClientToSClient());
                        sClient$loopProbe$2.L$0 = numArr;
                        sClient$loopProbe$2.L$1 = function1;
                        sClient$loopProbe$2.I$0 = i;
                        sClient$loopProbe$2.J$0 = j;
                        sClient$loopProbe$2.label = 1;
                        obj2 = obj3;
                        if (DelayKt.delay(5000L, sClient$loopProbe$2) == obj2) {
                            return obj2;
                        }
                        j++;
                        coroutine_suspended = obj2;
                        j2 = 0;
                        i3 = 0;
                        z = SClient.looping;
                        if (z) {
                            datagramSocket2 = SClient.udpSocket;
                            if (datagramSocket2 == null) {
                                return null;
                            }
                            datagramSocket2.close();
                            return Unit.INSTANCE;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                androidOperationInterface = SClient.ai;
                if (androidOperationInterface != null) {
                    datagramSocket = SClient.udpSocket;
                    Intrinsics.checkNotNull(datagramSocket);
                    Boxing.boxBoolean(androidOperationInterface.protect(datagramSocket));
                }
                str = SClient.address;
                Intrinsics.checkNotNull(str);
                final InetSocketAddress inetSocketAddress = new InetSocketAddress((String) StringsKt__StringsKt.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null).get(0), 8018);
                final byte[] bArr = new byte[1];
                final Integer[] numArr2 = new Integer[10];
                for (int i6 = 0; i6 < 10; i6++) {
                    numArr2[i6] = Boxing.boxInt(0);
                }
                function1 = new Function1<UByte, Long>(bArr, inetSocketAddress, numArr2, 10) { // from class: com.baidu.tun2tornadolite.booster.sclient.SClient$loopProbe$2$handleData$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ InetSocketAddress $address;
                    public final /* synthetic */ byte[] $buf;
                    public final /* synthetic */ Integer[] $cache;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ int $size;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {bArr, inetSocketAddress, numArr2, Integer.valueOf(r10)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i7 = newInitContext.flag;
                            if ((i7 & 1) != 0) {
                                int i8 = i7 & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$buf = bArr;
                        this.$address = inetSocketAddress;
                        this.$cache = numArr2;
                        this.$size = r10;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Long invoke(UByte uByte) {
                        return m144invoke7apg3OU(uByte.m914unboximpl());
                    }

                    /* renamed from: invoke-7apg3OU  reason: not valid java name */
                    public final Long m144invoke7apg3OU(byte b) {
                        InterceptResult invokeB;
                        long j4;
                        DatagramSocket datagramSocket3;
                        DatagramSocket datagramSocket4;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeB = interceptable2.invokeB(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b)) == null) {
                            try {
                                this.$buf[0] = b;
                                DatagramPacket datagramPacket = new DatagramPacket(this.$buf, this.$buf.length, this.$address);
                                datagramSocket3 = SClient.udpSocket;
                                Intrinsics.checkNotNull(datagramSocket3);
                                datagramSocket3.send(datagramPacket);
                                DatagramPacket datagramPacket2 = new DatagramPacket(this.$buf, this.$buf.length, this.$address);
                                long currentTimeMillis = System.currentTimeMillis();
                                datagramSocket4 = SClient.udpSocket;
                                Intrinsics.checkNotNull(datagramSocket4);
                                datagramSocket4.receive(datagramPacket2);
                                j4 = System.currentTimeMillis() - currentTimeMillis;
                                this.$cache[UByte.m865constructorimpl(this.$buf[0]) & 255] = 1;
                                LogTo logTo = LogTo.INSTANCE;
                                logTo.d("*****", "[Probe time] " + ((Object) UByte.m908toStringimpl(b)) + WebvttCueParser.CHAR_SLASH + this.$size + " packet time:" + j4);
                            } catch (Exception unused) {
                                j4 = -1;
                                LogTo logTo2 = LogTo.INSTANCE;
                                logTo2.d("*****", "[Probe timeout] " + ((Object) UByte.m908toStringimpl(b)) + WebvttCueParser.CHAR_SLASH + this.$size + " packet timeout");
                            }
                            return Long.valueOf(j4);
                        }
                        return (Long) invokeB.objValue;
                    }
                };
                sClient$loopProbe$2 = this;
                j = 0;
                numArr = numArr2;
                i = 10;
                z = SClient.looping;
                if (z) {
                }
            }
        } else {
            return invokeL.objValue;
        }
    }
}
