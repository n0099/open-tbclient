package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jf6 extends om<zf6, CardViewHolder<xg6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public TextView b;
    public String c;
    public String d;

    public final void z(qf6 qf6Var, xg6 xg6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, qf6Var, xg6Var) != null) || qf6Var == null || xg6Var == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jf6 a;

        public a(jf6 jf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jf6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.u();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jf6(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), zf6.b);
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
    @Override // com.baidu.tieba.om
    /* renamed from: x */
    public CardViewHolder<xg6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            return new CardViewHolder<>(new xg6(this.a));
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public final void A(TextView textView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048576, this, textView, str, z) == null) && textView != null && this.a != null) {
            if (z) {
                textView.setText("");
                Drawable drawable = this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0801fd);
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

    public final void t(zf6 zf6Var, xg6 xg6Var) {
        qf6 c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, zf6Var, xg6Var) == null) && (c = zf6Var.c()) != null && xg6Var != null) {
            this.b = xg6Var.r();
            this.c = c.b().user_id;
            z(c, xg6Var);
            xg6Var.y(8);
            xg6Var.z(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0270));
            xg6Var.j(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            AlaSharedPrefHelper.getInstance().putBoolean(AlaSharedPrefConfig.ALA_MY_LIVE_PRIVILEGE_HAS_ENTERED, true);
            A(this.b, this.d, false);
            StatisticItem statisticItem = new StatisticItem("c13333");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            String string = SharedPrefHelper.getInstance().getString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
            if (string == null) {
                return;
            }
            if (string.endsWith("/")) {
                string = string.substring(0, string.length() - 1);
            }
            String str = this.c;
            StringBuilder sb = new StringBuilder();
            sb.append("id=");
            sb.append(str);
            if (!string.contains("?")) {
                sb.insert(0, "?");
            } else {
                sb.insert(0, "&");
            }
            sb.insert(0, string);
            BrowserHelper.startWebActivity(this.a.getPageActivity(), sb.toString());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, zf6 zf6Var, CardViewHolder<xg6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zf6Var, cardViewHolder})) == null) {
            if (cardViewHolder.b() == null) {
                return null;
            }
            t(zf6Var, cardViewHolder.b());
            cardViewHolder.b().h().setOnClickListener(new a(this));
            return cardViewHolder.b().h();
        }
        return (View) invokeCommon.objValue;
    }
}
