package com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.cx7;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.ElementFileItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder;
import com.baidu.tieba.n15;
import com.baidu.tieba.sx7;
import com.baidu.tieba.tx7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ElementFileItemViewHolder extends BaseTagItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView c;
    public final ImageView d;
    public cx7 e;
    public Context f;

    public static /* synthetic */ void l(View view2) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ElementFileItemViewHolder(@NonNull View view2, @Nullable tx7 tx7Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, tx7Var};
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
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09222a);
        this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092229);
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.xw7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                    ElementFileItemViewHolder.l(view3);
                }
            }
        });
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void f(sx7 sx7Var, Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, sx7Var, context, i) == null) {
            super.f(sx7Var, context, i);
            this.f = context;
            if (sx7Var instanceof cx7) {
                cx7 cx7Var = (cx7) sx7Var;
                this.e = cx7Var;
                this.c.setText(cx7Var.b());
                this.d.setVisibility(8);
                m();
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.h(i);
            m();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            n15 d = n15.d(this.itemView);
            d.o(R.string.J_X19);
            d.i(R.color.CAM_X0905);
            n15 d2 = n15.d(this.c);
            d2.A(R.dimen.T_X08);
            d2.w(R.color.CAM_X0304);
            d2.B(R.string.F_X01);
        }
    }
}
