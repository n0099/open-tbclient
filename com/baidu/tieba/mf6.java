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
/* loaded from: classes7.dex */
public class mf6 extends om<cg6, CardViewHolder<xg6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public gg6 b;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cg6 a;
        public final /* synthetic */ mf6 b;

        public a(mf6 mf6Var, cg6 cg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf6Var, cg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mf6Var;
            this.a = cg6Var;
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
    public mf6(TbPageContext tbPageContext, gg6 gg6Var) {
        super(tbPageContext.getPageActivity(), cg6.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, gg6Var};
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
        this.b = gg6Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: x */
    public CardViewHolder<xg6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            return new CardViewHolder<>(new xg6(this.a));
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public final void t(cg6 cg6Var, xg6 xg6Var) {
        qf6 c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cg6Var, xg6Var) == null) && (c = cg6Var.c()) != null && c.b() != null) {
            xg6Var.y(0);
            xg6Var.z(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0271));
            int i = c.b().certify_status;
            if (i == 0) {
                xg6Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0275));
                xg6Var.x(0);
            } else if (1 == i) {
                xg6Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0274));
                xg6Var.x(4);
            } else if (2 == i) {
                xg6Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0272));
                xg6Var.x(4);
            } else if (3 == i) {
                xg6Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0273));
                xg6Var.x(0);
            }
            xg6Var.j(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void u(cg6 cg6Var) {
        AlaUserInfoData b;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, cg6Var) == null) && cg6Var != null && cg6Var.c() != null && cg6Var.c().b() != null && 1 != (i = (b = cg6Var.c().b()).certify_status) && 2 != i) {
            Context context = this.mContext;
            String str = b.user_id;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterRealAuthenConfig(context, str, b.certify_status + "")));
            gg6 gg6Var = this.b;
            if (gg6Var != null) {
                gg6Var.a(1);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, cg6 cg6Var, CardViewHolder<xg6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, cg6Var, cardViewHolder})) == null) {
            if (cardViewHolder.b() == null) {
                return null;
            }
            t(cg6Var, cardViewHolder.b());
            cardViewHolder.b().h().setOnClickListener(new a(this, cg6Var));
            return cardViewHolder.b().h();
        }
        return (View) invokeCommon.objValue;
    }
}
