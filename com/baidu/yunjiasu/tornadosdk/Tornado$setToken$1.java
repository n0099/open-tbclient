package com.baidu.yunjiasu.tornadosdk;

import com.alipay.sdk.sys.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.yunjiasu.tornadosdk.backend.Backend;
import com.baidu.yunjiasu.tornadosdk.backend.SClientConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.baidu.yunjiasu.tornadosdk.Tornado$setToken$1", f = "Tornado.kt", i = {0}, l = {141}, m = "invokeSuspend", n = {"start"}, s = {"J$0"})
/* loaded from: classes3.dex */
public final class Tornado$setToken$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ TornadoTokenCallback $cb;
    public transient /* synthetic */ FieldHolder $fh;
    public long J$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Tornado$setToken$1(TornadoTokenCallback tornadoTokenCallback, Continuation<? super Tornado$setToken$1> continuation) {
        super(2, continuation);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tornadoTokenCallback, continuation};
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
        this.$cb = tornadoTokenCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, continuation)) == null) ? new Tornado$setToken$1(this.$cb, continuation) : (Continuation) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, coroutineScope, continuation)) == null) ? ((Tornado$setToken$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : invokeLL.objValue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        InterceptResult invokeL;
        TornadoSetting tornadoSetting;
        TornadoSetting tornadoSetting2;
        TornadoSetting tornadoSetting3;
        TornadoSetting tornadoSetting4;
        long j2;
        TornadoSetting tornadoSetting5;
        TornadoSetting tornadoSetting6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            TornadoSetting tornadoSetting7 = null;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Backend backend = Backend.INSTANCE;
                    tornadoSetting = Tornado.setting;
                    if (tornadoSetting == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(a.s);
                        tornadoSetting = null;
                    }
                    String authChannel = tornadoSetting.getAuthChannel();
                    tornadoSetting2 = Tornado.setting;
                    if (tornadoSetting2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(a.s);
                        tornadoSetting2 = null;
                    }
                    String authCUID = tornadoSetting2.getAuthCUID();
                    tornadoSetting3 = Tornado.setting;
                    if (tornadoSetting3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(a.s);
                        tornadoSetting3 = null;
                    }
                    String authToken = tornadoSetting3.getAuthToken();
                    tornadoSetting4 = Tornado.setting;
                    if (tornadoSetting4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(a.s);
                        tornadoSetting4 = null;
                    }
                    backend.create(authChannel, "android", authCUID, authToken, tornadoSetting4.getClientVersion(), TornadoRuntime.INSTANCE.getSdkVersion());
                    long currentTimeMillis = System.currentTimeMillis();
                    Backend backend2 = Backend.INSTANCE;
                    this.J$0 = currentTimeMillis;
                    this.label = 1;
                    obj = backend2.getSClientConfig(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j2 = currentTimeMillis;
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    j2 = this.J$0;
                    ResultKt.throwOnFailure(obj);
                }
                SClientConfig sClientConfig = (SClientConfig) obj;
                if (sClientConfig != null) {
                    TornadoTokenCallback tornadoTokenCallback = this.$cb;
                    if (sClientConfig.getErrors().getCode() == 0) {
                        tornadoSetting5 = Tornado.setting;
                        if (tornadoSetting5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(a.s);
                            tornadoSetting5 = null;
                        }
                        Object[] array = sClientConfig.getResult().getNew_sclients().toArray(new String[0]);
                        if (array != null) {
                            tornadoSetting5.setSClientList((String[]) array);
                            LogTo logTo = LogTo.INSTANCE;
                            tornadoSetting6 = Tornado.setting;
                            if (tornadoSetting6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(a.s);
                            } else {
                                tornadoSetting7 = tornadoSetting6;
                            }
                            logTo.d("*****", Intrinsics.stringPlus("nodes:", ArraysKt___ArraysKt.toList(tornadoSetting7.getSClientList())));
                            tornadoTokenCallback.onResult(true, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    } else {
                        tornadoTokenCallback.onResult(false, String.valueOf(sClientConfig.getErrors()));
                    }
                }
                LogTo.INSTANCE.d("*****", Intrinsics.stringPlus("fetch sclient node: ", Boxing.boxLong(System.currentTimeMillis() - j2)));
            } catch (Exception e2) {
                e2.printStackTrace();
                this.$cb.onResult(false, String.valueOf(e2.getMessage()));
            }
            return Unit.INSTANCE;
        }
        return invokeL.objValue;
    }
}
