package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class m48 extends qn<h58, CardViewHolder<z58>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public z58 b;
    public n36 c;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m48 a;

        public a(m48 m48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m48Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                try {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 4) {
                        str = "&skin=dart";
                    } else if (skinType == 1) {
                        str = "&skin=night";
                    } else {
                        str = "";
                    }
                    UrlManager.getInstance().dealOneLink(this.a.a, new String[]{"https://tieba.baidu.com/mo/q/hybrid-main-service/virtualAvatar?customfullscreen=1&nonavigationbar=1" + str + "&from=3"});
                } catch (Exception e) {
                    BdLog.e("openPageByUrl fail:" + e.toString());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m48(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
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

    public void t() {
        n36 n36Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (n36Var = this.c) == null) {
            return;
        }
        n36Var.E();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: u */
    public CardViewHolder<z58> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.b = new z58(this.a);
            return new CardViewHolder<>(this.b);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: v */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, h58 h58Var, CardViewHolder<z58> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, h58Var, cardViewHolder})) == null) {
            cardViewHolder.a().i(h58Var);
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void w() {
        z58 z58Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (z58Var = this.b) == null || z58Var.y() == null || this.b.y().getVisibility() != 0 || s38.a().b() == 1) {
            return;
        }
        n36 n36Var = this.c;
        if (n36Var == null) {
            this.c = new n36(this.a, this.b.y());
        } else {
            n36Var.E();
        }
        String string = this.a.getString(R.string.obfuscated_res_0x7f0f0e85);
        this.c.R(R.drawable.obfuscated_res_0x7f0802f1);
        this.c.G(2);
        this.c.J(48);
        this.c.S(true);
        this.c.U(ej.f(this.a.getPageActivity(), R.dimen.tbds0));
        this.c.T(ej.f(this.a.getPageActivity(), R.dimen.tbds22));
        this.c.P(R.color.CAM_X0101);
        this.c.Q(R.dimen.T_X09);
        this.c.O(1);
        this.c.K(true);
        this.c.H(new a(this));
        this.c.W(string);
    }
}
