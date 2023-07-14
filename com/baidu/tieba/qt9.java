package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qt9 extends wo6<ns9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public TbImageView j;
    public TextView k;
    public TextView l;
    public ns9 m;

    @Override // com.baidu.tieba.wo6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01cc : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qt9(TbPageContext<?> tbPageContext) {
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
        View h = h();
        this.i = h;
        this.j = (TbImageView) h.findViewById(R.id.obfuscated_res_0x7f090608);
        this.k = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090606);
        this.l = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090607);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wo6
    /* renamed from: r */
    public void i(ns9 ns9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, ns9Var) != null) || ns9Var == null) {
            return;
        }
        this.m = ns9Var;
        String str = ns9Var.a;
        if (str != null) {
            this.j.N(str, 10, false);
        }
        this.k.setText(ns9Var.b);
        this.l.setText(ns9Var.c);
    }

    @Override // com.baidu.tieba.wo6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) != null) || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setBackgroundResource(this.i, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1);
        if (this.m.a == null) {
            SkinManager.setImageResource(this.j, R.drawable.icon_shen_mine);
        }
    }
}
