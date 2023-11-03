package com.baidu.tieba;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qza;
import com.baidu.tieba.tracker.core.monitors.PageTraceMonitor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class lza<R extends qza> extends PageTraceMonitor<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Fragment f;
    public final Function1<R, dza> g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lza(Fragment fragment, R thisRef, gza traceType, Function1<? super R, dza> traceHolderFactory) {
        super(thisRef, traceType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragment, thisRef, traceType, traceHolderFactory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((qza) objArr2[0], (gza) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(traceType, "traceType");
        Intrinsics.checkNotNullParameter(traceHolderFactory, "traceHolderFactory");
        this.f = fragment;
        this.g = traceHolderFactory;
    }

    @Override // com.baidu.tieba.mza
    public dza c(R thisRef) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, thisRef)) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            return this.g.invoke(thisRef);
        }
        return (dza) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tracker.core.monitors.PageTraceMonitor
    public Lifecycle h(R thisRef) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, thisRef)) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            try {
                Lifecycle lifecycle = this.f.getLifecycle();
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
            pza.a(this.f, (Pair[]) Arrays.copyOf(params, params.length));
        }
    }

    @Override // com.baidu.tieba.tracker.core.monitors.PageTraceMonitor
    public String i(R thisRef) {
        InterceptResult invokeL;
        qza qzaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, thisRef)) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            Fragment parentFragment = this.f.getParentFragment();
            if (parentFragment != null) {
                if (parentFragment instanceof qza) {
                    qzaVar = (qza) parentFragment;
                } else {
                    qzaVar = null;
                }
                if (qzaVar != null) {
                    return qzaVar.n2();
                }
            }
            return thisRef.n2();
        }
        return (String) invokeL.objValue;
    }
}
