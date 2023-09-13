package com.baidu.tieba.immessagecenter.arch.base;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.tieba.zk8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002Jf\u0010\u0003\u001a\u00020\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u00040\n2$\b\u0002\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fø\u0001\u0000¢\u0006\u0002\u0010\u000fJE\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00050\b\"\b\b\u0000\u0010\u0005*\u00020\u00012\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/baidu/tieba/immessagecenter/arch/base/BaseRepository;", "", "()V", "asyncRequest", "", ExifInterface.GPS_DIRECTION_TRUE, "request", "Lkotlin/Function0;", "Lcom/baidu/tieba/immessagecenter/arch/base/BaseData;", "successCallback", "Lkotlin/Function1;", "failCallback", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "syncRequest", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public class BaseRepository {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BaseRepository() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object a(Function1<? super Continuation<? super zk8<T>>, ? extends Object> function1, Continuation<? super zk8<T>> continuation) {
        InterceptResult invokeLL;
        BaseRepository$syncRequest$1 baseRepository$syncRequest$1;
        int i;
        zk8 zk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, function1, continuation)) == null) {
            if (continuation instanceof BaseRepository$syncRequest$1) {
                baseRepository$syncRequest$1 = (BaseRepository$syncRequest$1) continuation;
                int i2 = baseRepository$syncRequest$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    baseRepository$syncRequest$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = baseRepository$syncRequest$1.result;
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = baseRepository$syncRequest$1.label;
                    if (i == 0) {
                        if (i == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        baseRepository$syncRequest$1.label = 1;
                        obj = function1.invoke(baseRepository$syncRequest$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    zk8Var = (zk8) obj;
                    if (zk8Var.a() != 0) {
                        zk8Var.e(ReqState.Success);
                    } else {
                        zk8Var.e(ReqState.Error);
                    }
                    return zk8Var;
                }
            }
            baseRepository$syncRequest$1 = new BaseRepository$syncRequest$1(this, continuation);
            Object obj2 = baseRepository$syncRequest$1.result;
            Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = baseRepository$syncRequest$1.label;
            if (i == 0) {
            }
            zk8Var = (zk8) obj2;
            if (zk8Var.a() != 0) {
            }
            return zk8Var;
        }
        return invokeLL.objValue;
    }
}
