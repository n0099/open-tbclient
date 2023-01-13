package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.tagextension.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.am7;
import com.baidu.tieba.cx4;
import com.baidu.tieba.imMessageCenter.chatgroup.utility.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.jm7;
import com.baidu.tieba.km7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ElementItemViewHolder extends BaseTagItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView c;
    public final ImageView d;
    public am7 e;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ km7 a;
        public final /* synthetic */ ElementItemViewHolder b;

        public a(ElementItemViewHolder elementItemViewHolder, km7 km7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {elementItemViewHolder, km7Var};
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
            this.a = km7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.e != null && this.a.a(this.b.getAdapterPosition(), this.b.e.i(), this.b.e.e())) {
                this.b.e.k(!this.b.e.i());
                this.b.l();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ElementItemViewHolder(View view2, km7 km7Var) {
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
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09213a);
        this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092139);
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
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, jm7Var, context, i) == null) {
            super.d(jm7Var, context, i);
            if (jm7Var instanceof am7) {
                am7 am7Var = (am7) jm7Var;
                this.e = am7Var;
                this.c.setText(am7Var.b());
                ImageView imageView = this.d;
                if (am7Var.h()) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
                l();
            }
        }
    }

    public final void l() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            cx4 d = cx4.d(this.itemView);
            d.n(R.string.J_X19);
            d.h(R.color.CAM_X0905);
            am7 am7Var = this.e;
            if (am7Var != null && am7Var.i()) {
                z = true;
            } else {
                z = false;
            }
            am7 am7Var2 = this.e;
            if (am7Var2 != null && am7Var2.h()) {
                if (z) {
                    WebPManager.setPureDrawable(this.d, R.drawable.obfuscated_res_0x7f080a51, R.color.CAM_X0304, null);
                } else {
                    WebPManager.setPureDrawable(this.d, R.drawable.obfuscated_res_0x7f080a52, R.color.CAM_X0304, null);
                }
            }
            cx4 d2 = cx4.d(this.c);
            d2.z(R.dimen.T_X08);
            d2.v(R.color.CAM_X0304);
            d2.A(R.string.F_X01);
            this.c.setMaxLines(1);
            this.c.setSingleLine();
        }
    }
}
