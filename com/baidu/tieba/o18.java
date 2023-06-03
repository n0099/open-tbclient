package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.ala.secondfloor.AlaRecommendLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o18 extends ux<f15> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaRecommendLayout f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o18(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
        this.g = 3;
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().b instanceof AlaRecommendLayout) && TbadkCoreApplication.getInst().getPersonalizeViewData().b.getParent() == null) {
            this.f = (AlaRecommendLayout) TbadkCoreApplication.getInst().getPersonalizeViewData().b;
        } else {
            this.f = new AlaRecommendLayout(tbPageContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.ux
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.py
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.g != i) {
                this.f.d(i);
                q(this.f, 3);
            }
            this.g = i;
        }
    }

    public io6 s(f15 f15Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, f15Var)) == null) {
            if (f15Var instanceof u08) {
                u08 u08Var = (u08) f15Var;
                return new io6(u08Var.getType(), u08Var.c(), "recommend");
            } else if (f15Var instanceof aw7) {
                aw7 aw7Var = (aw7) f15Var;
                return new io6(aw7Var.getType(), aw7Var.c(), ImageViewerConfig.FROM_CONCERN);
            } else {
                return new io6();
            }
        }
        return (io6) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.oy
    /* renamed from: t */
    public void a(f15 f15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, f15Var) == null) {
            io6 s = s(f15Var);
            if (s != null && !ListUtils.isEmpty(s.c())) {
                this.f.setData(s);
                this.f.d(TbadkCoreApplication.getInst().getSkinType());
                this.f.setVisibility(0);
                return;
            }
            this.f.setVisibility(8);
        }
    }
}
