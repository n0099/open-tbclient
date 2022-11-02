package com.baidu.tun2tornadolite.booster.tun;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.sclient.SClient;
import com.baidu.tun2tornadolite.booster.tun.ip.DirectIPv4Header;
import java.io.FileInputStream;
import java.io.IOException;
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
@DebugMetadata(c = "com.baidu.tun2tornadolite.booster.tun.Tun$loop$2", f = "Tun.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class Tun$loop$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Tun$loop$2(Continuation<? super Tun$loop$2> continuation) {
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, continuation)) == null) ? new Tun$loop$2(continuation) : (Continuation) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, coroutineScope, continuation)) == null) ? ((Tun$loop$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : invokeLL.objValue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        InterceptResult invokeL;
        boolean z;
        FileInputStream fileInputStream;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                z = Tun.inited;
                if (!z) {
                    return Unit.INSTANCE;
                }
                long j = 0;
                Tun tun = Tun.INSTANCE;
                Tun.looping = true;
                do {
                    try {
                        DirectIPv4Header.Companion.getBuffer().clear();
                        fileInputStream = Tun.input;
                        if (fileInputStream == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("input");
                            fileInputStream = null;
                        }
                        int read = fileInputStream.read(DirectIPv4Header.Companion.getBuffer().array(), 0, 1500);
                        if (read >= 20) {
                            Tun.INSTANCE.processPacket(j, DirectIPv4Header.Companion.getBuffer(), read);
                            j++;
                        }
                        z2 = Tun.looping;
                    } catch (IOException e) {
                        e.printStackTrace();
                        Tun tun2 = Tun.INSTANCE;
                        Tun.looping = false;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        Tun tun3 = Tun.INSTANCE;
                        Tun.looping = false;
                    }
                } while (z2);
                SClient.INSTANCE.stop();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return invokeL.objValue;
    }
}
