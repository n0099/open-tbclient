package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class jp6 extends jn<q86, CardViewHolder<b36>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public b36 b;
    public String c;
    public String d;
    public z36 e;

    /* loaded from: classes4.dex */
    public class a extends z36<q86> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jp6 b;

        public a(jp6 jp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jp6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z36
        /* renamed from: d */
        public void a(View view2, q86 q86Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, q86Var) == null) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 2).param("fid", this.b.c));
                this.b.u(view2, q86Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jp6(TbPageContext tbPageContext, String str, String str2) {
        super(tbPageContext.getPageActivity(), q86.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, str2};
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
        this.c = str;
        this.d = str2;
        this.a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: v */
    public CardViewHolder<b36> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.b = new b36(this.a, this.c, this.d);
            return new CardViewHolder<>(this.b);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public void x(z36 z36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, z36Var) == null) {
            this.e = z36Var;
        }
    }

    public final void u(View view2, q86 q86Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, q86Var) == null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.a.getPageActivity()).createFromThreadCfg(q86Var.getThreadData(), null, k36.g(), 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(q86Var.getThreadData().getFid()));
            createFromThreadCfg.setForumName(q86Var.getThreadData().getForum_name());
            createFromThreadCfg.setStartFrom(0);
            k36.a(q86Var.getThreadData().getTid());
            this.a.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
            z36 z36Var = this.e;
            if (z36Var != null) {
                z36Var.a(view2, q86Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: w */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, q86 q86Var, CardViewHolder<b36> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, q86Var, cardViewHolder})) == null) {
            if (cardViewHolder.a() == null) {
                return null;
            }
            cardViewHolder.a().l(q86Var);
            cardViewHolder.a().m(this.a, TbadkCoreApplication.getInst().getSkinType());
            cardViewHolder.a().n(new a(this));
            return cardViewHolder.a().k();
        }
        return (View) invokeCommon.objValue;
    }
}
