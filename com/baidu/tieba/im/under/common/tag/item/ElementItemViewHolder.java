package com.baidu.tieba.im.under.common.tag.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.cq8;
import com.baidu.tieba.dq8;
import com.baidu.tieba.hq8;
import com.baidu.tieba.im.base.core.tag.core.BaseTagItemViewHolder;
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
    public hq8 e;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq8 a;
        public final /* synthetic */ ElementItemViewHolder b;

        public a(ElementItemViewHolder elementItemViewHolder, dq8 dq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {elementItemViewHolder, dq8Var};
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
            this.a = dq8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.e != null && this.a.a(this.b.getAdapterPosition(), this.b.e.l(), this.b.e.f())) {
                this.b.e.n(!this.b.e.l());
                this.b.p();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ElementItemViewHolder(View view2, dq8 dq8Var) {
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
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924a3);
        this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0924a2);
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
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, cq8Var, context, i) == null) {
            super.f(cq8Var, context, i);
            if (cq8Var instanceof hq8) {
                hq8 hq8Var = (hq8) cq8Var;
                this.e = hq8Var;
                this.c.setText(hq8Var.b());
                ImageView imageView = this.d;
                if (hq8Var.j()) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
                p();
            }
        }
    }

    public final void p() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            EMManager.from(this.itemView).setCorner(R.string.deprecated_J_X19).setBackGroundSelectorColor(R.color.CAM_X0905);
            hq8 hq8Var = this.e;
            if (hq8Var != null && hq8Var.l()) {
                z = true;
            } else {
                z = false;
            }
            hq8 hq8Var2 = this.e;
            if (hq8Var2 != null && hq8Var2.j()) {
                if (z) {
                    WebPManager.setPureDrawable(this.d, R.drawable.obfuscated_res_0x7f080c2d, R.color.CAM_X0304, null);
                } else {
                    WebPManager.setPureDrawable(this.d, R.drawable.obfuscated_res_0x7f080c2e, R.color.CAM_X0304, null);
                }
            }
            EMManager.from(this.c).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0304).setTextStyle(R.string.F_X01);
            this.c.setMaxLines(1);
            this.c.setSingleLine();
        }
    }
}
