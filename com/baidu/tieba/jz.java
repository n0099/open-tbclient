package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.SmartAppBottomLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jz extends ey {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SmartAppBottomLayout h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jz(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new SmartAppBottomLayout(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ry
    /* renamed from: A */
    public void b(t15 t15Var) {
        SmartAppBottomLayout smartAppBottomLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, t15Var) == null) && (smartAppBottomLayout = this.h) != null) {
            smartAppBottomLayout.b(t15Var);
        }
    }

    @Override // com.baidu.tieba.xx
    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sy
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        SmartAppBottomLayout smartAppBottomLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) && (smartAppBottomLayout = this.h) != null) {
            smartAppBottomLayout.d();
        }
    }
}
