package com.baidu.tun2tornadolite.booster;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.AndroidOperationInterface;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
import com.baidu.tun2tornadolite.booster.sclient.SClient;
import com.baidu.tun2tornadolite.booster.tun.Tun;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.baidu.tun2tornadolite.booster.Engine$start$1", f = "Engine.kt", i = {}, l = {57, 65, 70}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes9.dex */
public final class Engine$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ String $gameID;
    public final /* synthetic */ String $gamePackageName;
    public final /* synthetic */ String $region;
    public final /* synthetic */ int $tunfd;
    public int label;
    public final /* synthetic */ Engine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Engine$start$1(Engine engine, int i, String str, String str2, String str3, Continuation<? super Engine$start$1> continuation) {
        super(2, continuation);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {engine, Integer.valueOf(i), str, str2, str3, continuation};
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
        this.this$0 = engine;
        this.$tunfd = i;
        this.$region = str;
        this.$gameID = str2;
        this.$gamePackageName = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, continuation)) == null) ? new Engine$start$1(this.this$0, this.$tunfd, this.$region, this.$gameID, this.$gamePackageName, continuation) : (Continuation) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, coroutineScope, continuation)) == null) ? ((Engine$start$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b2 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            ResultKt.throwOnFailure(obj);
                            TornadoLiteRuntime.INSTANCE.onEvent$tun2tornadolite_release(31L);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    arrayList = new ArrayList(3);
                    arrayList.add(SClient.INSTANCE.getHandleLoop());
                    arrayList.add(SClient.INSTANCE.getProbeLoop());
                    arrayList.add(Tun.INSTANCE.getHandleLoop());
                    this.label = 3;
                    if (AwaitKt.awaitAll(arrayList, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    TornadoLiteRuntime.INSTANCE.onEvent$tun2tornadolite_release(31L);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                Engine.tunfd = this.$tunfd;
                TornadoLiteRuntime.INSTANCE.setRegion$tun2tornadolite_release(this.$region);
                TornadoLiteRuntime.INSTANCE.setGameID$tun2tornadolite_release(this.$gameID);
                TornadoLiteRuntime.INSTANCE.setGamePackageName$tun2tornadolite_release(this.$gamePackageName);
                SClient sClient = SClient.INSTANCE;
                AndroidOperationInterface ai = Engine.INSTANCE.getAi();
                Intrinsics.checkNotNull(ai);
                sClient.init(ai);
                Tun.INSTANCE.init(this.$tunfd);
                SClient sClient2 = SClient.INSTANCE;
                this.label = 1;
                obj = sClient2.start(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (((Boolean) obj).booleanValue()) {
                TornadoLiteRuntime.INSTANCE.setStatus("RUNNING");
                TornadoLiteRuntime.INSTANCE.setStartTime$tun2tornadolite_release(System.currentTimeMillis());
                Tun tun = Tun.INSTANCE;
                this.label = 2;
                if (tun.start(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                arrayList = new ArrayList(3);
                arrayList.add(SClient.INSTANCE.getHandleLoop());
                arrayList.add(SClient.INSTANCE.getProbeLoop());
                arrayList.add(Tun.INSTANCE.getHandleLoop());
                this.label = 3;
                if (AwaitKt.awaitAll(arrayList, this) == coroutine_suspended) {
                }
                TornadoLiteRuntime.INSTANCE.onEvent$tun2tornadolite_release(31L);
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        return invokeL.objValue;
    }
}
