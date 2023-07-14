package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class xt8 extends pi8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity e;
    public View f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xt8(BaseFragmentActivity context) {
        super(R.layout.obfuscated_res_0x7f0d0637);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = context;
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = j(R.id.obfuscated_res_0x7f0908f9);
        }
    }

    public final BaseFragmentActivity getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (BaseFragmentActivity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oi8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            View view2 = this.f;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDividerLineView");
                view2 = null;
            }
            d85.d(view2).f(R.color.CAM_X0111);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            View view2 = this.f;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDividerLineView");
                view2 = null;
            }
            d85.d(view2).f(R.color.CAM_X0111);
        }
    }
}
