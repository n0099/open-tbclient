package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class l76 extends cj6<h66> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y56 i;
    public y56 j;
    public ViewGroup k;

    @Override // com.baidu.tieba.cj6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0953 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l76(TbPageContext<?> tbPageContext, ViewGroup viewGroup, int i, boolean z) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (z) {
            this.i = new n76(tbPageContext, i);
            this.j = new n76(tbPageContext, i);
            t();
            return;
        }
        this.i = new m76(tbPageContext, i);
        this.j = new m76(tbPageContext, i);
        o();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cj6
    /* renamed from: u */
    public void j(h66 h66Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, h66Var) == null) && h66Var != null) {
            this.i.a(h66Var.a);
            this.j.a(h66Var.b);
        }
    }

    @Override // com.baidu.tieba.cj6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.i.onChangeSkinType(tbPageContext, i);
            this.j.onChangeSkinType(tbPageContext, i);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k = (ViewGroup) i();
            View view2 = new View(c());
            this.k.setPadding(h().getResources().getDimensionPixelSize(R.dimen.tbds44), h().getResources().getDimensionPixelSize(R.dimen.tbds12), h().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
            this.k.addView(this.i.getView());
            this.k.addView(view2, new LinearLayout.LayoutParams(h().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
            this.k.addView(this.j.getView());
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.k = (ViewGroup) i();
            View view2 = new View(c());
            this.k.setPadding(h().getResources().getDimensionPixelSize(R.dimen.tbds34), h().getResources().getDimensionPixelSize(R.dimen.tbds21), h().getResources().getDimensionPixelSize(R.dimen.tbds34), 0);
            this.k.addView(this.i.getView());
            this.k.addView(view2, new LinearLayout.LayoutParams(h().getResources().getDimensionPixelSize(R.dimen.tbds20), -1));
            this.k.addView(this.j.getView());
        }
    }
}
