package com.baidu.tun2tornadolite.booster;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.SelectBuilderImpl;
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00070\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/baidu/tun2tornadolite/booster/Utils;", "", "()V", "amb", "T", "jobs", "", "Lkotlinx/coroutines/Deferred;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class Utils {
    public static /* synthetic */ Interceptable $ic;
    public static final Utils INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(617606472, "Lcom/baidu/tun2tornadolite/booster/Utils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(617606472, "Lcom/baidu/tun2tornadolite/booster/Utils;");
                return;
            }
        }
        INSTANCE = new Utils();
    }

    public Utils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* renamed from: amb$lambda-1$cancelAll  reason: not valid java name */
    public static final <T> void m89amb$lambda1$cancelAll(List<? extends Deferred<? extends T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, list) == null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Job.DefaultImpls.cancel$default((Job) ((Deferred) it.next()), (CancellationException) null, 1, (Object) null);
            }
        }
    }

    public final <T> Object amb(List<? extends Deferred<? extends T>> list, Continuation<? super T> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, list, continuation)) == null) {
            SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(continuation);
            try {
                for (Deferred<? extends T> deferred : list) {
                    selectBuilderImpl.invoke(deferred.getOnAwait(), new Utils$amb$2$1(list, null));
                }
            } catch (Throwable th) {
                selectBuilderImpl.handleBuilderException(th);
            }
            Object result = selectBuilderImpl.getResult();
            if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return invokeLL.objValue;
    }
}
