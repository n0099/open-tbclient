package com.baidu.tieba.im.under.common.tag.item;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tieba.R;
import com.baidu.tieba.cq8;
import com.baidu.tieba.dq8;
import com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.vy8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class TagItemViewHolder extends BaseTagItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView c;
    public vy8 d;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq8 a;
        public final /* synthetic */ TagItemViewHolder b;

        public a(TagItemViewHolder tagItemViewHolder, dq8 dq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tagItemViewHolder, dq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tagItemViewHolder;
            this.a = dq8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.d != null) {
                this.a.a(this.b.getAdapterPosition(), true, this.b.d.b());
                this.b.d.e(true);
                this.b.p();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TagItemViewHolder(View view2, dq8 dq8Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, dq8Var};
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
        this.c = (TextView) view2;
        view2.setOnClickListener(new a(this, dq8Var));
    }

    @Override // com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.h(i);
            p();
        }
    }

    @Override // com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder
    public void f(cq8 cq8Var, Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, cq8Var, context, i) == null) {
            super.f(cq8Var, context, i);
            if (cq8Var instanceof vy8) {
                vy8 vy8Var = (vy8) cq8Var;
                this.d = vy8Var;
                this.c.setText(vy8Var.c());
                p();
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.i();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            vy8 vy8Var = this.d;
            if (vy8Var != null && vy8Var.d()) {
                EMManager.from(this.c).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0304).setTextStyle(R.string.F_X01).setBorderWidth(R.dimen.L_X02).setBorderColor(R.color.CAM_X0302).setCorner(R.string.deprecated_J_X19);
            } else {
                EMManager.from(this.c).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0105).setTextStyle(R.string.F_X01).setBorderWidth(R.dimen.L_X02).setBorderColor(R.color.CAM_X0111).setCorner(R.string.deprecated_J_X19);
            }
            this.c.setMaxLines(1);
            this.c.setSingleLine();
        }
    }
}
