package com.baidu.tun2tornadolite.booster.sclient;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.LogTo;
import com.baidu.tun2tornadolite.booster.data.SClientConfig;
import com.baidu.tun2tornadolite.booster.sclient.SClient;
import java.net.DatagramSocket;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.baidu.tun2tornadolite.booster.sclient.SClient$prepare$ok$1", f = "SClient.kt", i = {1}, l = {63, 66}, m = "invokeSuspend", n = {"ok"}, s = {"I$0"})
/* loaded from: classes6.dex */
public final class SClient$prepare$ok$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ SClientConfig $config;
    public transient /* synthetic */ FieldHolder $fh;
    public int I$0;
    public int label;
    public final /* synthetic */ SClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SClient$prepare$ok$1(SClientConfig sClientConfig, SClient sClient, Continuation<? super SClient$prepare$ok$1> continuation) {
        super(2, continuation);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sClientConfig, sClient, continuation};
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
        this.$config = sClientConfig;
        this.this$0 = sClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, continuation)) == null) ? new SClient$prepare$ok$1(this.$config, this.this$0, continuation) : (Continuation) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, coroutineScope, continuation)) == null) ? ((SClient$prepare$ok$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c8  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        InterceptResult invokeL;
        int i;
        boolean z;
        SClient.ConnectResult connectResult;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            try {
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                z = SClient.inited;
                if (z) {
                    return Boxing.boxBoolean(false);
                }
                SClient sClient = SClient.INSTANCE;
                SClientConfig sClientConfig = this.$config;
                this.label = 1;
                obj = sClient.selectSClient(sClientConfig, 1000L, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$0;
                ResultKt.throwOnFailure(obj);
                connectResult = (SClient.ConnectResult) obj;
                LogTo logTo = LogTo.INSTANCE;
                logTo.d("*****", "[Connect SClient] address: " + connectResult.getAddress() + " cost: " + connectResult.getConnectTime());
                if (connectResult.getStatus() == 0 && connectResult.getSocket() != null) {
                    SClient.socket = connectResult.getSocket();
                    SClient.address = connectResult.getAddress();
                    DatagramSocket datagramSocket = new DatagramSocket();
                    datagramSocket.setSoTimeout(1000);
                    datagramSocket.setSendBufferSize(1);
                    datagramSocket.setReceiveBufferSize(1);
                    SClient.udpSocket = datagramSocket;
                    SClient.INSTANCE.openWriteChannel();
                    SClient sClient2 = SClient.INSTANCE;
                    SClient.looping = true;
                    i = 1;
                }
                return Boxing.boxBoolean(i != 0);
            } else {
                ResultKt.throwOnFailure(obj);
            }
            SClient.ConnectResult connectResult2 = (SClient.ConnectResult) obj;
            if (connectResult2.getStatus() == 0) {
                SClient sClient3 = SClient.INSTANCE;
                String address = connectResult2.getAddress();
                this.I$0 = 0;
                this.label = 2;
                obj = sClient3.connectSClient(address, 1000L, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = 0;
                connectResult = (SClient.ConnectResult) obj;
                LogTo logTo2 = LogTo.INSTANCE;
                logTo2.d("*****", "[Connect SClient] address: " + connectResult.getAddress() + " cost: " + connectResult.getConnectTime());
                if (connectResult.getStatus() == 0) {
                    SClient.socket = connectResult.getSocket();
                    SClient.address = connectResult.getAddress();
                    DatagramSocket datagramSocket2 = new DatagramSocket();
                    datagramSocket2.setSoTimeout(1000);
                    datagramSocket2.setSendBufferSize(1);
                    datagramSocket2.setReceiveBufferSize(1);
                    SClient.udpSocket = datagramSocket2;
                    SClient.INSTANCE.openWriteChannel();
                    SClient sClient22 = SClient.INSTANCE;
                    SClient.looping = true;
                    i = 1;
                }
                return Boxing.boxBoolean(i != 0);
            }
            i = 0;
            return Boxing.boxBoolean(i != 0);
        }
        return invokeL.objValue;
    }
}
