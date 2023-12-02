package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
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
public class o96 extends nl6<e96> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n96 i;
    public n96 j;
    public n96 k;
    public ViewGroup l;

    @Override // com.baidu.tieba.nl6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d098e : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o96(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
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
        this.i = new n96(tbPageContext);
        this.j = new n96(tbPageContext);
        this.k = new n96(tbPageContext);
        this.l = (ViewGroup) i();
        new View(c());
        this.l.setPadding(h().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, h().getResources().getDimensionPixelSize(R.dimen.tbds44), 0);
        this.l.addView(this.i.e());
        this.l.addView(this.j.e());
        this.l.addView(this.k.e());
        k(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nl6
    /* renamed from: p */
    public void j(e96 e96Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, e96Var) == null) && e96Var != null) {
            this.i.f(e96Var.a);
            this.j.f(e96Var.b);
            this.k.f(e96Var.c);
        }
    }

    public void r(p96 p96Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, p96Var) == null) {
            this.i.h(p96Var);
            this.j.h(p96Var);
            this.k.h(p96Var);
        }
    }

    @Override // com.baidu.tieba.nl6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
            this.i.g(tbPageContext, i);
            this.j.g(tbPageContext, i);
            this.k.g(tbPageContext, i);
        }
    }
}
