package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wa6 extends lh<mb6, CardViewHolder<kc6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wa6(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), mb6.b);
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
    @Override // com.baidu.tieba.lh
    /* renamed from: t */
    public CardViewHolder<kc6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            return new CardViewHolder<>(new kc6(this.a));
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public final void s(mb6 mb6Var, kc6 kc6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, mb6Var, kc6Var) == null) {
            bb6 c = mb6Var.c();
            if (c != null && c.a() != null && !TextUtils.isEmpty(c.a().a())) {
                kc6Var.u(c.a().a());
                kc6Var.k(this.a, TbadkCoreApplication.getInst().getSkinType());
                notifyDataSetChanged();
                return;
            }
            kc6Var.n(8);
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, mb6 mb6Var, CardViewHolder<kc6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mb6Var, cardViewHolder})) == null) {
            if (cardViewHolder.a() == null) {
                return null;
            }
            s(mb6Var, cardViewHolder.a());
            return cardViewHolder.a().i();
        }
        return (View) invokeCommon.objValue;
    }
}
