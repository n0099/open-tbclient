package com.baidu.tun2tornadolite.booster.sclient;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.LogTo;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lkotlin/UByte;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class SClient$loopProbe$2$handleData$1 extends Lambda implements Function1<UByte, Long> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ InetSocketAddress $address;
    public final /* synthetic */ byte[] $buf;
    public final /* synthetic */ Integer[] $cache;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int $size;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SClient$loopProbe$2$handleData$1(byte[] bArr, InetSocketAddress inetSocketAddress, Integer[] numArr, int i2) {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, inetSocketAddress, numArr, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.$buf = bArr;
        this.$address = inetSocketAddress;
        this.$cache = numArr;
        this.$size = i2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(UByte uByte) {
        return m90invoke7apg3OU(uByte.m780unboximpl());
    }

    /* renamed from: invoke-7apg3OU  reason: not valid java name */
    public final Long m90invoke7apg3OU(byte b2) {
        InterceptResult invokeB;
        long j2;
        DatagramSocket datagramSocket;
        DatagramSocket datagramSocket2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2)) == null) {
            try {
                this.$buf[0] = b2;
                DatagramPacket datagramPacket = new DatagramPacket(this.$buf, this.$buf.length, this.$address);
                datagramSocket = SClient.udpSocket;
                Intrinsics.checkNotNull(datagramSocket);
                datagramSocket.send(datagramPacket);
                DatagramPacket datagramPacket2 = new DatagramPacket(this.$buf, this.$buf.length, this.$address);
                long currentTimeMillis = System.currentTimeMillis();
                datagramSocket2 = SClient.udpSocket;
                Intrinsics.checkNotNull(datagramSocket2);
                datagramSocket2.receive(datagramPacket2);
                j2 = System.currentTimeMillis() - currentTimeMillis;
                this.$cache[UByte.m731constructorimpl(this.$buf[0]) & 255] = 1;
                LogTo logTo = LogTo.INSTANCE;
                logTo.d("*****", "[Probe time] " + ((Object) UByte.m774toStringimpl(b2)) + WebvttCueParser.CHAR_SLASH + this.$size + " packet time:" + j2);
            } catch (Exception unused) {
                j2 = -1;
                LogTo logTo2 = LogTo.INSTANCE;
                logTo2.d("*****", "[Probe timeout] " + ((Object) UByte.m774toStringimpl(b2)) + WebvttCueParser.CHAR_SLASH + this.$size + " packet timeout");
            }
            return Long.valueOf(j2);
        }
        return (Long) invokeB.objValue;
    }
}
