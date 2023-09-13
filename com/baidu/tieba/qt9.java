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
/* loaded from: classes7.dex */
public class qt9 extends pm<nu9, CardViewHolder<xu9>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public xu9 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qt9(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
    public CardViewHolder<xu9> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.b = new xu9(this.a);
            return new CardViewHolder<>(this.b);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public void u(boolean z) {
        xu9 xu9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (xu9Var = this.b) != null) {
            xu9Var.x(z);
        }
    }

    public void onPause() {
        xu9 xu9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (xu9Var = this.b) != null) {
            xu9Var.u();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, nu9 nu9Var, CardViewHolder<xu9> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, nu9Var, cardViewHolder})) == null) {
            cardViewHolder.a().i(nu9Var);
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
