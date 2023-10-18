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
/* loaded from: classes8.dex */
public class xa6 extends lh<nb6, CardViewHolder<ic6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public rb6 b;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nb6 a;
        public final /* synthetic */ xa6 b;

        public a(xa6 xa6Var, nb6 nb6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa6Var, nb6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xa6Var;
            this.a = nb6Var;
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
    public xa6(TbPageContext tbPageContext, rb6 rb6Var) {
        super(tbPageContext.getPageActivity(), nb6.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, rb6Var};
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
        this.b = rb6Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: x */
    public CardViewHolder<ic6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            return new CardViewHolder<>(new ic6(this.a));
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public final void t(nb6 nb6Var, ic6 ic6Var) {
        bb6 c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, nb6Var, ic6Var) == null) && (c = nb6Var.c()) != null && c.b() != null) {
            ic6Var.z(0);
            ic6Var.A(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0273));
            int i = c.b().certify_status;
            if (i == 0) {
                ic6Var.x(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0277));
                ic6Var.y(0);
            } else if (1 == i) {
                ic6Var.x(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0276));
                ic6Var.y(4);
            } else if (2 == i) {
                ic6Var.x(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0274));
                ic6Var.y(4);
            } else if (3 == i) {
                ic6Var.x(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0275));
                ic6Var.y(0);
            }
            ic6Var.k(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void u(nb6 nb6Var) {
        AlaUserInfoData b;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, nb6Var) == null) && nb6Var != null && nb6Var.c() != null && nb6Var.c().b() != null && 1 != (i = (b = nb6Var.c().b()).certify_status) && 2 != i) {
            Context context = this.mContext;
            String str = b.user_id;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterRealAuthenConfig(context, str, b.certify_status + "")));
            rb6 rb6Var = this.b;
            if (rb6Var != null) {
                rb6Var.a(1);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, nb6 nb6Var, CardViewHolder<ic6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, nb6Var, cardViewHolder})) == null) {
            if (cardViewHolder.a() == null) {
                return null;
            }
            t(nb6Var, cardViewHolder.a());
            cardViewHolder.a().i().setOnClickListener(new a(this, nb6Var));
            return cardViewHolder.a().i();
        }
        return (View) invokeCommon.objValue;
    }
}
