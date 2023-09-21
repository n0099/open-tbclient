package com.baidu.tieba;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tracker.core.monitors.PageTraceMonitor;
import com.baidu.tieba.xra;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class tra<R extends xra> extends PageTraceMonitor<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Fragment e;
    public final Function1<R, ora> f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tra(Fragment fragment, R thisRef, Function1<? super R, ora> traceHolderFactory) {
        super(thisRef);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragment, thisRef, traceHolderFactory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((xra) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(traceHolderFactory, "traceHolderFactory");
        this.e = fragment;
        this.f = traceHolderFactory;
    }

    @Override // com.baidu.tieba.ura
    public ora c(R thisRef) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, thisRef)) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            return this.f.invoke(thisRef);
        }
        return (ora) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tracker.core.monitors.PageTraceMonitor
    public Lifecycle h(R thisRef) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, thisRef)) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            try {
                Lifecycle lifecycle = this.e.getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle, "fragment.lifecycle");
                return lifecycle;
            } catch (IllegalStateException e) {
                throw new IllegalStateException("Fragment doesn 't have view associated with it or the view has been destroyed!", e);
            }
        }
        return (Lifecycle) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tracker.core.monitors.PageTraceMonitor
    public void j(Pair<String, String>... params) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            wra.a(this.e, (Pair[]) Arrays.copyOf(params, params.length));
        }
    }

    @Override // com.baidu.tieba.tracker.core.monitors.PageTraceMonitor
    public String i(R thisRef) {
        InterceptResult invokeL;
        xra xraVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, thisRef)) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            Fragment parentFragment = this.e.getParentFragment();
            if (parentFragment != null) {
                if (parentFragment instanceof xra) {
                    xraVar = (xra) parentFragment;
                } else {
                    xraVar = null;
                }
                if (xraVar != null) {
                    return xraVar.V1();
                }
            }
            return thisRef.V1();
        }
        return (String) invokeL.objValue;
    }
}
