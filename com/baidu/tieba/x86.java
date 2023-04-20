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
/* loaded from: classes6.dex */
public class x86 extends vm<n96, CardViewHolder<ia6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public r96 b;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n96 a;
        public final /* synthetic */ x86 b;

        public a(x86 x86Var, n96 n96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x86Var, n96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x86Var;
            this.a = n96Var;
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
    public x86(TbPageContext tbPageContext, r96 r96Var) {
        super(tbPageContext.getPageActivity(), n96.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, r96Var};
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
        this.b = r96Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: x */
    public CardViewHolder<ia6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            return new CardViewHolder<>(new ia6(this.a));
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public final void t(n96 n96Var, ia6 ia6Var) {
        b96 c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, n96Var, ia6Var) == null) && (c = n96Var.c()) != null && c.b() != null) {
            ia6Var.y(0);
            ia6Var.z(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0246));
            int i = c.b().certify_status;
            if (i == 0) {
                ia6Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f024a));
                ia6Var.x(0);
            } else if (1 == i) {
                ia6Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0249));
                ia6Var.x(4);
            } else if (2 == i) {
                ia6Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0247));
                ia6Var.x(4);
            } else if (3 == i) {
                ia6Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0248));
                ia6Var.x(0);
            }
            ia6Var.m(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void u(n96 n96Var) {
        AlaUserInfoData b;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, n96Var) == null) && n96Var != null && n96Var.c() != null && n96Var.c().b() != null && 1 != (i = (b = n96Var.c().b()).certify_status) && 2 != i) {
            Context context = this.mContext;
            String str = b.user_id;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterRealAuthenConfig(context, str, b.certify_status + "")));
            r96 r96Var = this.b;
            if (r96Var != null) {
                r96Var.a(1);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, n96 n96Var, CardViewHolder<ia6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, n96Var, cardViewHolder})) == null) {
            if (cardViewHolder.a() == null) {
                return null;
            }
            t(n96Var, cardViewHolder.a());
            cardViewHolder.a().h().setOnClickListener(new a(this, n96Var));
            return cardViewHolder.a().h();
        }
        return (View) invokeCommon.objValue;
    }
}
