package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.s07;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class xm6 implements s07.q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xm6() {
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

    @Override // com.baidu.tieba.s07.q
    public void a(s07.r holder, g27 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, holder, state) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(state, "state");
            holder.j(state);
        }
    }

    @Override // com.baidu.tieba.s07.q
    public s07.r b(Context context, ViewGroup rootView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, rootView)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            if (context instanceof TbadkCoreApplication) {
                TbadkCoreApplication tbadkCoreApplication = (TbadkCoreApplication) context;
                if ((tbadkCoreApplication.getCurrentActivity() instanceof Context) && (context = tbadkCoreApplication.getCurrentActivity()) == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
                }
            }
            return new wm6(context, rootView);
        }
        return (s07.r) invokeLL.objValue;
    }
}
