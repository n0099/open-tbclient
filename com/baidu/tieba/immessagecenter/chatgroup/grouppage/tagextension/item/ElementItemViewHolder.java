package com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.s75;
import com.baidu.tieba.vj8;
import com.baidu.tieba.wj8;
import com.baidu.tieba.zi8;
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
    public zi8 e;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wj8 a;
        public final /* synthetic */ ElementItemViewHolder b;

        public a(ElementItemViewHolder elementItemViewHolder, wj8 wj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {elementItemViewHolder, wj8Var};
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
            this.a = wj8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.e != null && this.a.a(this.b.getAdapterPosition(), this.b.e.l(), this.b.e.f())) {
                this.b.e.n(!this.b.e.l());
                this.b.n();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ElementItemViewHolder(View view2, wj8 wj8Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, wj8Var};
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
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092333);
        this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092332);
        view2.setOnClickListener(new a(this, wj8Var));
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.h(i);
            n();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void f(vj8 vj8Var, Context context, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, vj8Var, context, i) == null) {
            super.f(vj8Var, context, i);
            if (vj8Var instanceof zi8) {
                zi8 zi8Var = (zi8) vj8Var;
                this.e = zi8Var;
                this.c.setText(zi8Var.b());
                ImageView imageView = this.d;
                if (zi8Var.j()) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
                n();
            }
        }
    }

    public final void n() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            s75 d = s75.d(this.itemView);
            d.o(R.string.deprecated_J_X19);
            d.i(R.color.CAM_X0905);
            zi8 zi8Var = this.e;
            if (zi8Var != null && zi8Var.l()) {
                z = true;
            } else {
                z = false;
            }
            zi8 zi8Var2 = this.e;
            if (zi8Var2 != null && zi8Var2.j()) {
                if (z) {
                    WebPManager.setPureDrawable(this.d, R.drawable.obfuscated_res_0x7f080be2, R.color.CAM_X0304, null);
                } else {
                    WebPManager.setPureDrawable(this.d, R.drawable.obfuscated_res_0x7f080be3, R.color.CAM_X0304, null);
                }
            }
            s75 d2 = s75.d(this.c);
            d2.C(R.dimen.T_X08);
            d2.x(R.color.CAM_X0304);
            d2.D(R.string.F_X01);
            this.c.setMaxLines(1);
            this.c.setSingleLine();
        }
    }
}
