package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class kj7 extends kn<jj7, CardViewHolder<oj7>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public h56 b;
    public String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kj7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getContext(), bdUniqueId);
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

    @Override // com.baidu.tieba.kn
    public ho getOnAdapterItemClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return super.getOnAdapterItemClickListener();
        }
        return (ho) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: s */
    public CardViewHolder<oj7> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            oj7 oj7Var = new oj7(this.a, viewGroup);
            h56 h56Var = this.b;
            if (h56Var != null) {
                oj7Var.n(h56Var);
            }
            return new CardViewHolder<>(oj7Var);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.c = str;
        }
    }

    public void v(h56 h56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, h56Var) == null) {
            this.b = h56Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, jj7 jj7Var, CardViewHolder<oj7> cardViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, jj7Var, cardViewHolder})) == null) {
            if (jj7Var != null && cardViewHolder != null && cardViewHolder.a() != null) {
                cardViewHolder.a().x(this.c);
                oj7 a = cardViewHolder.a();
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                a.y(z);
                cardViewHolder.a().i(jj7Var);
                return cardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
