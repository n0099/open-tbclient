package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernRecommendLineHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ju5 extends qn<nu5, LiveTabConcernRecommendLineHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public xu5 b;
    public yu5 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ju5(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), nu5.d);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: s */
    public LiveTabConcernRecommendLineHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            xu5 xu5Var = new xu5(this.a, viewGroup);
            this.b = xu5Var;
            yu5 yu5Var = this.c;
            if (yu5Var != null) {
                xu5Var.s(yu5Var);
            }
            return new LiveTabConcernRecommendLineHolder(this.b);
        }
        return (LiveTabConcernRecommendLineHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, nu5 nu5Var, LiveTabConcernRecommendLineHolder liveTabConcernRecommendLineHolder) {
        InterceptResult invokeCommon;
        xu5 xu5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, nu5Var, liveTabConcernRecommendLineHolder})) == null) {
            if (liveTabConcernRecommendLineHolder == null || (xu5Var = liveTabConcernRecommendLineHolder.a) == null) {
                return null;
            }
            xu5Var.i(nu5Var);
            return liveTabConcernRecommendLineHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void u(yu5 yu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, yu5Var) == null) {
            this.c = yu5Var;
            xu5 xu5Var = this.b;
            if (xu5Var != null) {
                xu5Var.s(yu5Var);
            }
        }
    }
}
