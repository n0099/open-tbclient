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
public class zf6 extends kn<pg6, CardViewHolder<kh6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public tg6 b;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pg6 a;
        public final /* synthetic */ zf6 b;

        public a(zf6 zf6Var, pg6 pg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf6Var, pg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zf6Var;
            this.a = pg6Var;
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
    public zf6(TbPageContext tbPageContext, tg6 tg6Var) {
        super(tbPageContext.getPageActivity(), pg6.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, tg6Var};
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
        this.b = tg6Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: x */
    public CardViewHolder<kh6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            return new CardViewHolder<>(new kh6(this.a));
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public final void t(pg6 pg6Var, kh6 kh6Var) {
        dg6 c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pg6Var, kh6Var) == null) && (c = pg6Var.c()) != null && c.b() != null) {
            kh6Var.y(0);
            kh6Var.z(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0270));
            int i = c.b().certify_status;
            if (i == 0) {
                kh6Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0274));
                kh6Var.x(0);
            } else if (1 == i) {
                kh6Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0273));
                kh6Var.x(4);
            } else if (2 == i) {
                kh6Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0271));
                kh6Var.x(4);
            } else if (3 == i) {
                kh6Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0272));
                kh6Var.x(0);
            }
            kh6Var.j(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void u(pg6 pg6Var) {
        AlaUserInfoData b;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, pg6Var) == null) && pg6Var != null && pg6Var.c() != null && pg6Var.c().b() != null && 1 != (i = (b = pg6Var.c().b()).certify_status) && 2 != i) {
            Context context = this.mContext;
            String str = b.user_id;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterRealAuthenConfig(context, str, b.certify_status + "")));
            tg6 tg6Var = this.b;
            if (tg6Var != null) {
                tg6Var.a(1);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, pg6 pg6Var, CardViewHolder<kh6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, pg6Var, cardViewHolder})) == null) {
            if (cardViewHolder.a() == null) {
                return null;
            }
            t(pg6Var, cardViewHolder.a());
            cardViewHolder.a().h().setOnClickListener(new a(this, pg6Var));
            return cardViewHolder.a().h();
        }
        return (View) invokeCommon.objValue;
    }
}
