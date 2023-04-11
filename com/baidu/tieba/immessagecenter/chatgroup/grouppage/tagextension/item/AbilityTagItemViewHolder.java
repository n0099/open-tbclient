package com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.a58;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.k78;
import com.baidu.tieba.ne8;
import com.baidu.tieba.q25;
import com.baidu.tieba.q78;
import com.baidu.tieba.u68;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class AbilityTagItemViewHolder extends BaseTagItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView c;
    public final TbImageView d;
    public final View e;
    public u68 f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a58 a;
        public final /* synthetic */ AbilityTagItemViewHolder b;

        public a(AbilityTagItemViewHolder abilityTagItemViewHolder, a58 a58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abilityTagItemViewHolder, a58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = abilityTagItemViewHolder;
            this.a = a58Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.f != null) {
                this.a.c(this.b.f.b(), this.b.f.c());
                k78.c("c15210", 2, this.b.f.b(), this.b.f.c());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityTagItemViewHolder(@NonNull View view2, @Nullable a58 a58Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, a58Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f090025);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090026);
        this.d = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090027);
        this.e.setOnClickListener(new a(this, a58Var));
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.h(i);
            n(i);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void f(@NonNull q78 q78Var, Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, q78Var, context, i) == null) {
            super.f(q78Var, context, i);
            if (q78Var instanceof u68) {
                u68 u68Var = (u68) q78Var;
                this.f = u68Var;
                if (u68Var.b() != null && this.f.b().getStyleConf() != null) {
                    this.c.setText(this.f.b().getStyleConf().getContent());
                }
                n(TbadkCoreApplication.getInst().getSkinType());
                k78.c("c15210", 1, this.f.b(), this.f.c());
            }
        }
    }

    public AbilityItem.Style m(@NonNull AbilityItem.StyleConf styleConf, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, styleConf, i)) == null) {
            if (4 == i) {
                return styleConf.getDark();
            }
            return styleConf.getDay();
        }
        return (AbilityItem.Style) invokeLI.objValue;
    }

    public final void n(int i) {
        u68 u68Var;
        AbilityItem.StyleConf styleConf;
        AbilityItem.Style m;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || (u68Var = this.f) == null || u68Var.b() == null || this.f.b().getStyleConf() == null || (m = m((styleConf = this.f.b().getStyleConf()), i)) == null) {
            return;
        }
        if (TextUtils.isEmpty(styleConf.getContent()) && !TextUtils.isEmpty(m.getIcon())) {
            this.d.setVisibility(0);
            this.c.setVisibility(8);
            this.e.setBackground(null);
            this.d.N(m.getIcon(), 45, false);
            return;
        }
        this.d.setVisibility(8);
        this.c.setVisibility(0);
        if (!ne8.a(ne8.b(m.getContentColor()))) {
            this.c.setTextColor(ne8.b(m.getContentColor()));
        } else {
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0302);
        }
        if (!ne8.a(ne8.b(m.getBackgroundColor()))) {
            q25.d(this.e).g(m.getBackgroundColor());
        } else {
            q25.d(this.e).f(R.color.CAM_X0905);
        }
        q25 d = q25.d(this.c);
        d.B(R.dimen.T_X08);
        d.C(R.string.F_X01);
        q25.d(this.e).o(R.string.J_X19);
    }
}
