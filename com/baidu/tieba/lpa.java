package com.baidu.tieba;

import androidx.annotation.MainThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qpa;
import com.baidu.tieba.tracker.core.data.AbsEventNode;
import com.baidu.tieba.tracker.core.data.TraceEventNode;
import com.baidu.tieba.tracker.core.data.TraceType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class lpa<R extends qpa> extends npa<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Function1<R, hpa> e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lpa(R obj, Function1<? super R, hpa> traceHolderFactory) {
        super(obj);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, traceHolderFactory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((qpa) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(traceHolderFactory, "traceHolderFactory");
        this.e = traceHolderFactory;
    }

    @Override // com.baidu.tieba.npa
    @MainThread
    public AbsEventNode a(R thisRef) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, thisRef)) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            return new TraceEventNode(thisRef.getFrom(), thisRef.getScene(), TraceType.SendMsg, null, 8, null);
        }
        return (AbsEventNode) invokeL.objValue;
    }

    @Override // com.baidu.tieba.npa
    public hpa c(R thisRef) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, thisRef)) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            return this.e.invoke(thisRef);
        }
        return (hpa) invokeL.objValue;
    }
}
