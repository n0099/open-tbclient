package com.baidu.tun2tornadolite.booster;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.data.SClientConfig;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
import com.baidu.tun2tornadolite.booster.sclient.SClient;
import java.util.List;
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
@DebugMetadata(c = "com.baidu.tun2tornadolite.booster.Engine$prepare$1", f = "Engine.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes9.dex */
public final class Engine$prepare$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ List<String> $sClientList;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Engine$prepare$1(List<String> list, Continuation<? super Engine$prepare$1> continuation) {
        super(2, continuation);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, continuation};
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
        this.$sClientList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, continuation)) == null) ? new Engine$prepare$1(this.$sClientList, continuation) : (Continuation) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, coroutineScope, continuation)) == null) ? ((Engine$prepare$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : invokeLL.objValue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        InterceptResult invokeL;
        SClientConfig sClientConfig;
        SClientConfig sClientConfig2;
        SClientConfig sClientConfig3;
        SClientConfig sClientConfig4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                if (this.$sClientList.isEmpty()) {
                    TornadoLiteRuntime.INSTANCE.onEvent$tun2tornadolite_release(1L, "SClient node 列表为空");
                    TornadoLiteRuntime.INSTANCE.onEvent$tun2tornadolite_release(22L);
                    return Boxing.boxBoolean(false);
                }
                TornadoLiteRuntime.INSTANCE.setStatus(TornadoLiteRuntime.STATE_STARTING);
                sClientConfig = Engine.sClientConfig;
                sClientConfig.getSclients().clear();
                if (TornadoLiteRuntime.INSTANCE.getDebug()) {
                    sClientConfig4 = Engine.sClientConfig;
                    sClientConfig4.getSclients().add("220.170.184.3:443");
                } else {
                    sClientConfig2 = Engine.sClientConfig;
                    sClientConfig2.getSclients().addAll(this.$sClientList);
                }
                SClient sClient = SClient.INSTANCE;
                sClientConfig3 = Engine.sClientConfig;
                this.label = 1;
                obj = sClient.prepare(sClientConfig3, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            boolean booleanValue = ((Boolean) obj).booleanValue();
            if (!booleanValue) {
                TornadoLiteRuntime.INSTANCE.onEvent$tun2tornadolite_release(31L);
            }
            return Boxing.boxBoolean(booleanValue);
        }
        return invokeL.objValue;
    }
}
