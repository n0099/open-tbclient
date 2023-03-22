package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaPersonCenterRealAuthenConfig;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class q76 extends tm<g86, CardViewHolder<b96>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public k86 b;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g86 a;
        public final /* synthetic */ q76 b;

        public a(q76 q76Var, g86 g86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q76Var, g86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q76Var;
            this.a = g86Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.u(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q76(TbPageContext tbPageContext, k86 k86Var) {
        super(tbPageContext.getPageActivity(), g86.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, k86Var};
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
        this.b = k86Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: x */
    public CardViewHolder<b96> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            return new CardViewHolder<>(new b96(this.a));
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public final void t(g86 g86Var, b96 b96Var) {
        u76 c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, g86Var, b96Var) == null) && (c = g86Var.c()) != null && c.b() != null) {
            b96Var.y(0);
            b96Var.z(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0246));
            int i = c.b().certify_status;
            if (i == 0) {
                b96Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f024a));
                b96Var.x(0);
            } else if (1 == i) {
                b96Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0249));
                b96Var.x(4);
            } else if (2 == i) {
                b96Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0247));
                b96Var.x(4);
            } else if (3 == i) {
                b96Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0248));
                b96Var.x(0);
            }
            b96Var.m(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void u(g86 g86Var) {
        AlaUserInfoData b;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, g86Var) == null) && g86Var != null && g86Var.c() != null && g86Var.c().b() != null && 1 != (i = (b = g86Var.c().b()).certify_status) && 2 != i) {
            Context context = this.mContext;
            String str = b.user_id;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterRealAuthenConfig(context, str, b.certify_status + "")));
            k86 k86Var = this.b;
            if (k86Var != null) {
                k86Var.a(1);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, g86 g86Var, CardViewHolder<b96> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, g86Var, cardViewHolder})) == null) {
            if (cardViewHolder.a() == null) {
                return null;
            }
            t(g86Var, cardViewHolder.a());
            cardViewHolder.a().h().setOnClickListener(new a(this, g86Var));
            return cardViewHolder.a().h();
        }
        return (View) invokeCommon.objValue;
    }
}
