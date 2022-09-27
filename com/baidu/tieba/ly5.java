package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ly5 extends qn<bz5, CardViewHolder<zz5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public TextView b;
    public String c;
    public String d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ly5 a;

        public a(ly5 ly5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ly5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ly5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.u();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ly5(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), bz5.b);
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

    public final void t(bz5 bz5Var, zz5 zz5Var) {
        sy5 c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bz5Var, zz5Var) == null) || (c = bz5Var.c()) == null || zz5Var == null) {
            return;
        }
        this.b = zz5Var.r();
        this.c = c.b().user_id;
        x(c, zz5Var);
        zz5Var.w(8);
        zz5Var.x(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0242));
        zz5Var.j(this.a, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AlaSharedPrefHelper.getInstance().putBoolean(AlaSharedPrefConfig.ALA_MY_LIVE_PRIVILEGE_HAS_ENTERED, true);
            y(this.b, this.d, false);
            StatisticItem statisticItem = new StatisticItem("c13333");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            String q = ox4.k().q("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
            if (q == null) {
                return;
            }
            if (q.endsWith("/")) {
                q = q.substring(0, q.length() - 1);
            }
            String str = this.c;
            StringBuilder sb = new StringBuilder();
            sb.append("id=");
            sb.append(str);
            if (!q.contains("?")) {
                sb.insert(0, "?");
            } else {
                sb.insert(0, "&");
            }
            sb.insert(0, q);
            yo4.o(this.a.getPageActivity(), sb.toString());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: v */
    public CardViewHolder<zz5> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new CardViewHolder<>(new zz5(this.a)) : (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: w */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bz5 bz5Var, CardViewHolder<zz5> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bz5Var, cardViewHolder})) == null) {
            if (cardViewHolder.a() == null) {
                return null;
            }
            t(bz5Var, cardViewHolder.a());
            cardViewHolder.a().h().setOnClickListener(new a(this));
            return cardViewHolder.a().h();
        }
        return (View) invokeCommon.objValue;
    }

    public final void x(sy5 sy5Var, zz5 zz5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, sy5Var, zz5Var) != null) || sy5Var == null || zz5Var == null) {
        }
    }

    public final void y(TextView textView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048583, this, textView, str, z) == null) || textView == null || this.a == null) {
            return;
        }
        if (z) {
            textView.setText("");
            Drawable drawable = this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0801e2);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            textView.setCompoundDrawables(null, null, drawable, null);
            return;
        }
        if (str != null) {
            textView.setText(str);
        } else {
            textView.setText("");
        }
        textView.setCompoundDrawables(null, null, null, null);
    }
}
