package com.baidu.tun2tornadolite.booster.sclient;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.LogTo;
import com.baidu.tun2tornadolite.booster.Utils;
import com.baidu.tun2tornadolite.booster.data.SClientConfig;
import com.baidu.tun2tornadolite.booster.sclient.SClient;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.ar.core.InstallActivity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/baidu/tun2tornadolite/booster/sclient/SClient$ConnectResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.baidu.tun2tornadolite.booster.sclient.SClient$selectSClient$2", f = "SClient.kt", i = {}, l = {InstallActivity.BOX_SIZE_DP}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class SClient$selectSClient$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SClient.ConnectResult>, Object> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ SClientConfig $config;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ long $timeout;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SClient$selectSClient$2(SClientConfig sClientConfig, long j, Continuation<? super SClient$selectSClient$2> continuation) {
        super(2, continuation);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sClientConfig, Long.valueOf(j), continuation};
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
        this.$timeout = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, continuation)) == null) {
            SClient$selectSClient$2 sClient$selectSClient$2 = new SClient$selectSClient$2(this.$config, this.$timeout, continuation);
            sClient$selectSClient$2.L$0 = obj;
            return sClient$selectSClient$2;
        }
        return (Continuation) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SClient.ConnectResult> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, coroutineScope, continuation)) == null) ? ((SClient$selectSClient$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : invokeLL.objValue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        InterceptResult invokeL;
        Deferred async$default;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                ArrayList arrayList = new ArrayList();
                ArrayList<String> sclients = this.$config.getSclients();
                long j = this.$timeout;
                for (String str : sclients) {
                    async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new SClient$selectSClient$2$1$1(str, j, null), 3, null);
                    arrayList.add(async$default);
                }
                LogTo logTo = LogTo.INSTANCE;
                logTo.d("*****", "[Select SClient] nodes:" + arrayList.size() + WebvttCueParser.CHAR_SPACE + CollectionsKt___CollectionsKt.toList(this.$config.getSclients()));
                Utils utils = Utils.INSTANCE;
                this.label = 1;
                obj = utils.amb(arrayList, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            SClient.ConnectResult connectResult = (SClient.ConnectResult) obj;
            LogTo logTo2 = LogTo.INSTANCE;
            logTo2.d("*****", "[Select SClient] address: " + connectResult.getAddress() + " cost: " + connectResult.getConnectTime());
            return connectResult;
        }
        return invokeL.objValue;
    }
}
