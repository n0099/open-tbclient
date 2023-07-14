package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ut9 extends wo6<ss9> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public as9 j;
    public View k;
    public TextView l;
    public TextView m;
    public ImageView n;

    @Override // com.baidu.tieba.wo6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01d2 : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ut9(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        r(h());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wo6
    /* renamed from: s */
    public void i(ss9 ss9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ss9Var) == null) {
            if (ss9Var == null) {
                this.i.setVisibility(8);
                return;
            }
            if (this.i.getVisibility() != 0) {
                this.i.setVisibility(0);
            }
            View view2 = this.k;
            if (view2 != null) {
                if (ss9Var.a) {
                    view2.setVisibility(8);
                } else {
                    view2.setVisibility(0);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        as9 as9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && view2 != null && (as9Var = this.j) != null && view2 == this.l) {
            as9Var.a();
        }
    }

    public void t(as9 as9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, as9Var) == null) {
            this.j = as9Var;
        }
    }

    @Override // com.baidu.tieba.wo6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(this.i, R.color.CAM_X0201);
                SkinManager.setBackgroundResource(this.k, R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0109, 1);
                SkinManager.setImageResource(this.n, R.drawable.pic_pop_key);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0304, 1);
            }
            this.a = i;
        }
    }

    public final void r(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f090614);
            this.k = view2.findViewById(R.id.obfuscated_res_0x7f0925d4);
            this.n = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091649);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919b7);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905d7);
            this.l.setOnClickListener(this);
        }
    }
}
