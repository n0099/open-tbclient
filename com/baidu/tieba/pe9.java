package com.baidu.tieba;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.personCenter.view.PersonOftenFuncItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class pe9 extends in6<xd9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout i;
    public LinearLayout j;
    public TextView k;
    public PersonOftenFuncItemView l;
    public PersonOftenFuncItemView m;

    @Override // com.baidu.tieba.in6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0798 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pe9(TbPageContext<?> tbPageContext) {
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
        int g = vi.g(this.c, R.dimen.M_W_X003);
        h.setPadding(g, 0, g, 0);
        this.i = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f09193d);
        this.k = (TextView) h.findViewById(R.id.obfuscated_res_0x7f091b0b);
        this.j = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f091b0c);
        j(g(), this.a);
    }

    @Override // com.baidu.tieba.in6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(h(), R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0205);
            o75 d = o75.d(this.i);
            d.o(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            o75 d2 = o75.d(this.k);
            d2.o(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            o75 d3 = o75.d(this.j);
            d3.o(R.string.J_X06);
            d3.f(R.color.CAM_X0205);
            int childCount = this.j.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.j.getChildAt(i2);
                if (childAt instanceof LinearLayout) {
                    int i3 = 0;
                    while (true) {
                        LinearLayout linearLayout = (LinearLayout) childAt;
                        if (i3 < linearLayout.getChildCount()) {
                            View childAt2 = linearLayout.getChildAt(i3);
                            if (childAt2 instanceof PersonOftenFuncItemView) {
                                PersonOftenFuncItemView personOftenFuncItemView = (PersonOftenFuncItemView) childAt2;
                                SkinManager.setBackgroundColor(personOftenFuncItemView, R.color.CAM_X0205);
                                SkinManager.setViewTextColor(personOftenFuncItemView.b, (int) R.color.CAM_X0105);
                            }
                            i3++;
                        }
                    }
                }
            }
        }
    }

    public void onScroll() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PersonOftenFuncItemView personOftenFuncItemView = this.l;
            boolean z2 = true;
            if (personOftenFuncItemView != null) {
                if (!personOftenFuncItemView.d && !TbSingleton.getInstance().isMyTabClicked()) {
                    z = false;
                } else {
                    z = true;
                }
                personOftenFuncItemView.d = z;
                this.l.d();
            }
            PersonOftenFuncItemView personOftenFuncItemView2 = this.m;
            if (personOftenFuncItemView2 != null) {
                if (!personOftenFuncItemView2.d && !TbSingleton.getInstance().isMyTabClicked()) {
                    z2 = false;
                }
                personOftenFuncItemView2.d = z2;
                this.m.d();
            }
            TbSingleton.getInstance().setMyTabClicked(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in6
    /* renamed from: r */
    public void i(xd9 xd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xd9Var) == null) {
            if (xd9Var != null && xd9Var.c() != null && !ListUtils.isEmpty(xd9Var.c())) {
                this.j.removeAllViews();
                List<ud9> c = xd9Var.c();
                LinearLayout linearLayout = new LinearLayout(getContext());
                int i = 0;
                for (ud9 ud9Var : c) {
                    i++;
                    if (i % 4 == 1) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams.bottomMargin = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);
                        LinearLayout linearLayout2 = new LinearLayout(getContext());
                        linearLayout2.setOrientation(0);
                        linearLayout2.setLayoutParams(layoutParams);
                        this.j.addView(linearLayout2);
                        linearLayout = linearLayout2;
                    }
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                    PersonOftenFuncItemView personOftenFuncItemView = new PersonOftenFuncItemView(getContext());
                    personOftenFuncItemView.a(ud9Var);
                    personOftenFuncItemView.setLayoutParams(layoutParams2);
                    linearLayout.addView(personOftenFuncItemView);
                    int i2 = ud9Var.a;
                    if (i2 == 59) {
                        this.l = personOftenFuncItemView;
                    } else if (i2 == 63) {
                        this.m = personOftenFuncItemView;
                    }
                }
                if (c.size() != 0 && c.size() % 4 != 0) {
                    for (int i3 = 0; i3 < 4 - (c.size() % 4); i3++) {
                        PersonOftenFuncItemView personOftenFuncItemView2 = new PersonOftenFuncItemView(getContext());
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
                        layoutParams3.weight = 1.0f;
                        personOftenFuncItemView2.setLayoutParams(layoutParams3);
                        linearLayout.addView(personOftenFuncItemView2);
                    }
                }
                j(g(), this.a);
                return;
            }
            q(8);
        }
    }
}
