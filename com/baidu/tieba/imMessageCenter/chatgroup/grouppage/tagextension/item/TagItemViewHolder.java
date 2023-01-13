package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.tagextension.item;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.bm7;
import com.baidu.tieba.cx4;
import com.baidu.tieba.imMessageCenter.chatgroup.utility.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.jm7;
import com.baidu.tieba.km7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TagItemViewHolder extends BaseTagItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView c;
    public bm7 d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ km7 a;
        public final /* synthetic */ TagItemViewHolder b;

        public a(TagItemViewHolder tagItemViewHolder, km7 km7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tagItemViewHolder, km7Var};
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
            this.a = km7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.d != null) {
                this.a.a(this.b.getAdapterPosition(), true, this.b.d.b());
                this.b.d.e(true);
                this.b.l();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TagItemViewHolder(View view2, km7 km7Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, km7Var};
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
        view2.setOnClickListener(new a(this, km7Var));
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.f(i);
            l();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void d(jm7 jm7Var, Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, jm7Var, context, i) == null) {
            super.d(jm7Var, context, i);
            if (jm7Var instanceof bm7) {
                bm7 bm7Var = (bm7) jm7Var;
                this.d = bm7Var;
                this.c.setText(bm7Var.c());
                l();
            }
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.g();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            bm7 bm7Var = this.d;
            if (bm7Var != null && bm7Var.d()) {
                cx4 d = cx4.d(this.c);
                d.z(R.dimen.T_X08);
                d.v(R.color.CAM_X0304);
                d.A(R.string.F_X01);
                d.l(R.dimen.L_X02);
                d.k(R.color.CAM_X0302);
                d.n(R.string.J_X19);
            } else {
                cx4 d2 = cx4.d(this.c);
                d2.z(R.dimen.T_X08);
                d2.v(R.color.CAM_X0105);
                d2.A(R.string.F_X01);
                d2.l(R.dimen.L_X02);
                d2.k(R.color.CAM_X0111);
                d2.n(R.string.J_X19);
            }
            this.c.setMaxLines(1);
            this.c.setSingleLine();
        }
    }
}
