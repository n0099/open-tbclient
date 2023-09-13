package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class l28 extends ax<a28> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public k28 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l28(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        Object obj = TbadkCoreApplication.getInst().getPersonalizeViewData().t;
        if (obj instanceof k28) {
            k28 k28Var = (k28) obj;
            if (k28Var.h().getParent() == null) {
                this.f = k28Var;
                return;
            }
        }
        this.f = new k28(tbPageContext.getPageActivity());
    }

    @Override // com.baidu.tieba.ax
    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f.h();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ax
    public void p(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.f.m(bdUniqueId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ux
    /* renamed from: s */
    public void onBindDataToView(a28 a28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, a28Var) == null) {
            this.f.l(a28Var);
        }
    }

    @Override // com.baidu.tieba.vx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.f.onChangeSkinType(tbPageContext, i);
        }
    }
}
