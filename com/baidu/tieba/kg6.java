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
public class kg6 extends pm<ah6, CardViewHolder<vh6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public eh6 b;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah6 a;
        public final /* synthetic */ kg6 b;

        public a(kg6 kg6Var, ah6 ah6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg6Var, ah6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kg6Var;
            this.a = ah6Var;
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
    public kg6(TbPageContext tbPageContext, eh6 eh6Var) {
        super(tbPageContext.getPageActivity(), ah6.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, eh6Var};
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
        this.b = eh6Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: x */
    public CardViewHolder<vh6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            return new CardViewHolder<>(new vh6(this.a));
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public final void t(ah6 ah6Var, vh6 vh6Var) {
        og6 c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ah6Var, vh6Var) == null) && (c = ah6Var.c()) != null && c.b() != null) {
            vh6Var.y(0);
            vh6Var.z(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0271));
            int i = c.b().certify_status;
            if (i == 0) {
                vh6Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0275));
                vh6Var.x(0);
            } else if (1 == i) {
                vh6Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0274));
                vh6Var.x(4);
            } else if (2 == i) {
                vh6Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0272));
                vh6Var.x(4);
            } else if (3 == i) {
                vh6Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0273));
                vh6Var.x(0);
            }
            vh6Var.j(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void u(ah6 ah6Var) {
        AlaUserInfoData b;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ah6Var) == null) && ah6Var != null && ah6Var.c() != null && ah6Var.c().b() != null && 1 != (i = (b = ah6Var.c().b()).certify_status) && 2 != i) {
            Context context = this.mContext;
            String str = b.user_id;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterRealAuthenConfig(context, str, b.certify_status + "")));
            eh6 eh6Var = this.b;
            if (eh6Var != null) {
                eh6Var.a(1);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ah6 ah6Var, CardViewHolder<vh6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ah6Var, cardViewHolder})) == null) {
            if (cardViewHolder.a() == null) {
                return null;
            }
            t(ah6Var, cardViewHolder.a());
            cardViewHolder.a().h().setOnClickListener(new a(this, ah6Var));
            return cardViewHolder.a().h();
        }
        return (View) invokeCommon.objValue;
    }
}
