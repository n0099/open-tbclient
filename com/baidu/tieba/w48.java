package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class w48 extends ln<d68, CardViewHolder<dp6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public dp6 b;
    public BdUniqueId c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w48(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), f68.f);
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
        dp6 dp6Var = new dp6(tbPageContext);
        this.b = dp6Var;
        dp6Var.I("c10714", "c10739", "c10712", "c10738");
        this.b.setFrom("home");
    }

    public void s(int i) {
        dp6 dp6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (dp6Var = this.b) != null) {
            dp6Var.j(this.a, i);
        }
    }

    public void x(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.c = bdUniqueId;
            dp6 dp6Var = this.b;
            if (dp6Var != null) {
                dp6Var.H(bdUniqueId);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: t */
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            if (this.b == null) {
                dp6 dp6Var = new dp6(this.a);
                this.b = dp6Var;
                dp6Var.H(this.c);
                this.b.I("c10714", "c10739", "c10712", "c10738");
            }
            return new CardViewHolder(this.b);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, d68 d68Var, CardViewHolder cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, d68Var, cardViewHolder})) == null) {
            if (cardViewHolder.b() == null) {
                return null;
            }
            cardViewHolder.b().i(d68Var);
            np6.b().a(new StatisticItem("c10714").param(TiebaStatic.Params.OBJ_PARAM3, gp6.e()));
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
