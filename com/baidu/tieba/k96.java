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
/* loaded from: classes6.dex */
public class k96 extends nl6<u86> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j96 i;
    public j96 j;
    public LinearLayout k;
    public ViewGroup l;
    public View m;

    @Override // com.baidu.tieba.nl6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0989 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k96(TbPageContext<?> tbPageContext, ViewGroup viewGroup, String str) {
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
        this.i = new j96(tbPageContext, str);
        this.j = new j96(tbPageContext, str);
        ViewGroup viewGroup2 = (ViewGroup) i();
        this.l = viewGroup2;
        this.k = (LinearLayout) viewGroup2.findViewById(R.id.obfuscated_res_0x7f0910b4);
        this.m = this.l.findViewById(R.id.obfuscated_res_0x7f0910aa);
        View view2 = new View(c());
        this.k.setPadding(h().getResources().getDimensionPixelSize(R.dimen.tbds44), 0, h().getResources().getDimensionPixelSize(R.dimen.tbds44), h().getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.k.addView(this.i.h());
        this.k.addView(view2, new LinearLayout.LayoutParams(h().getResources().getDimensionPixelSize(R.dimen.tbds12), -1));
        this.k.addView(this.j.h());
        k(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nl6
    /* renamed from: p */
    public void j(u86 u86Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, u86Var) == null) && u86Var != null) {
            this.i.i(u86Var.a);
            this.j.i(u86Var.b);
            if (u86Var.c) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
        }
    }

    public void r(p96 p96Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, p96Var) == null) {
            this.i.l(p96Var);
            this.j.l(p96Var);
        }
    }

    @Override // com.baidu.tieba.nl6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
            this.i.k(tbPageContext, i);
            this.j.k(tbPageContext, i);
            SkinManager.setBackgroundResource(this.m, R.color.CAM_X0204);
        }
    }
}
