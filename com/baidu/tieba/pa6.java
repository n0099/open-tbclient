package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pa6 extends em6<z96> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oa6 i;
    public oa6 j;
    public LinearLayout k;
    public ViewGroup l;
    public View m;

    @Override // com.baidu.tieba.em6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d094a : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pa6(TbPageContext<?> tbPageContext, ViewGroup viewGroup, String str) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new oa6(tbPageContext, str);
        this.j = new oa6(tbPageContext, str);
        ViewGroup viewGroup2 = (ViewGroup) h();
        this.l = viewGroup2;
        this.k = (LinearLayout) viewGroup2.findViewById(R.id.obfuscated_res_0x7f091037);
        this.m = this.l.findViewById(R.id.obfuscated_res_0x7f09102d);
        View view2 = new View(getContext());
        this.k.setPadding(g().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, g().getResources().getDimensionPixelSize(R.dimen.tbds44), g().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.k.addView(this.i.h());
        this.k.addView(view2, new LinearLayout.LayoutParams(g().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.k.addView(this.j.h());
        j(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.em6
    /* renamed from: r */
    public void i(z96 z96Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, z96Var) == null) && z96Var != null) {
            this.i.i(z96Var.a);
            this.j.i(z96Var.b);
            if (z96Var.c) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
        }
    }

    public void s(ua6 ua6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ua6Var) == null) {
            this.i.l(ua6Var);
            this.j.l(ua6Var);
        }
    }

    @Override // com.baidu.tieba.em6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
            this.i.k(tbPageContext, i);
            this.j.k(tbPageContext, i);
            SkinManager.setBackgroundResource(this.m, R.color.CAM_X0204);
        }
    }
}
