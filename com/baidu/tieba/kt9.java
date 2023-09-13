package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kt9 extends pm<gu9, CardViewHolder<zu9>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public mp6<gu9> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kt9(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
    @Override // com.baidu.tieba.pm
    /* renamed from: s */
    public CardViewHolder<zu9> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            zu9 zu9Var = new zu9(this.a);
            zu9Var.k(this.b);
            return new CardViewHolder<>(zu9Var);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public void u(mp6<gu9> mp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mp6Var) == null) {
            this.b = mp6Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, gu9 gu9Var, CardViewHolder<zu9> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, gu9Var, cardViewHolder})) == null) {
            cardViewHolder.a().i(gu9Var);
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
