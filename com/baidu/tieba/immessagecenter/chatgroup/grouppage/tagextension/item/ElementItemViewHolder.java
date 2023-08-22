package com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.fr8;
import com.baidu.tieba.gr8;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.jq8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ElementItemViewHolder extends BaseTagItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView c;
    public final ImageView d;
    public jq8 e;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gr8 a;
        public final /* synthetic */ ElementItemViewHolder b;

        public a(ElementItemViewHolder elementItemViewHolder, gr8 gr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {elementItemViewHolder, gr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = elementItemViewHolder;
            this.a = gr8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.e != null && this.a.a(this.b.getAdapterPosition(), this.b.e.l(), this.b.e.f())) {
                this.b.e.n(!this.b.e.l());
                this.b.o();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ElementItemViewHolder(View view2, gr8 gr8Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, gr8Var};
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
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923b3);
        this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0923b2);
        view2.setOnClickListener(new a(this, gr8Var));
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.i(i);
            o();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void g(fr8 fr8Var, Context context, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, fr8Var, context, i) == null) {
            super.g(fr8Var, context, i);
            if (fr8Var instanceof jq8) {
                jq8 jq8Var = (jq8) fr8Var;
                this.e = jq8Var;
                this.c.setText(jq8Var.b());
                ImageView imageView = this.d;
                if (jq8Var.j()) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
                o();
            }
        }
    }

    public final void o() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            EMManager.from(this.itemView).setCorner(R.string.deprecated_J_X19).setBackGroundSelectorColor(R.color.CAM_X0905);
            jq8 jq8Var = this.e;
            if (jq8Var != null && jq8Var.l()) {
                z = true;
            } else {
                z = false;
            }
            jq8 jq8Var2 = this.e;
            if (jq8Var2 != null && jq8Var2.j()) {
                if (z) {
                    WebPManager.setPureDrawable(this.d, R.drawable.obfuscated_res_0x7f080c00, R.color.CAM_X0304, null);
                } else {
                    WebPManager.setPureDrawable(this.d, R.drawable.obfuscated_res_0x7f080c01, R.color.CAM_X0304, null);
                }
            }
            EMManager.from(this.c).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0304).setTextStyle(R.string.F_X01);
            this.c.setMaxLines(1);
            this.c.setSingleLine();
        }
    }
}
