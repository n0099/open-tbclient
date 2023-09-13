package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.c67;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class is6 implements c67.q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public is6() {
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

    @Override // com.baidu.tieba.c67.q
    public c67.r a(Context context, ViewGroup rootView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, rootView)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            if (context instanceof TbadkCoreApplication) {
                TbadkCoreApplication tbadkCoreApplication = (TbadkCoreApplication) context;
                if ((tbadkCoreApplication.getCurrentActivity() instanceof Context) && (context = tbadkCoreApplication.getCurrentActivity()) == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
                }
            }
            return new hs6(context, rootView);
        }
        return (c67.r) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.c67.q
    public void update(c67.r holder, q77 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, holder, state) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(state, "state");
            holder.update(state);
        }
    }
}
