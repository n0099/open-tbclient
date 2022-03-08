package com.baidu.tun2tornadolite.booster.sclient;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.baidu.tun2tornadolite.booster.sclient.SClient", f = "SClient.kt", i = {0}, l = {456}, m = "sendHandShake", n = {"this"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class SClient$sendHandShake$1 extends ContinuationImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SClient$sendHandShake$1(SClient sClient, Continuation<? super SClient$sendHandShake$1> continuation) {
        super(continuation);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sClient, continuation};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Continuation) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = sClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        InterceptResult invokeL;
        Object sendHandShake;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            sendHandShake = this.this$0.sendHandShake(this);
            return sendHandShake;
        }
        return invokeL.objValue;
    }
}
