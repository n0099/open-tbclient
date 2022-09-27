package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class n16 extends i16<d76> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public View n;
    public View o;
    public String p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n16(TbPageContext<?> tbPageContext) {
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

    @Override // com.baidu.tieba.i16
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d018b : invokeV.intValue;
    }

    @Override // com.baidu.tieba.i16
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundResource(h(), R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.n, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.o, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (view2 == this.j || view2 == this.k || view2 == this.l || view2 == this.m) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 8).param("fid", this.p));
                UrlManager.getInstance().dealOneLink((TbPageContext) w9.a(this.b.getPageActivity()), new String[]{(String) view2.getTag()}, true);
            }
        }
    }

    public final void r(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09050a);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09050b);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09050c);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09050d);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09050e);
            this.j.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.n = view2.findViewById(R.id.obfuscated_res_0x7f09080d);
            this.o = view2.findViewById(R.id.obfuscated_res_0x7f09080e);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i16
    /* renamed from: s */
    public void i(d76 d76Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, d76Var) == null) || d76Var == null || d76Var.c() == null) {
            return;
        }
        if (!TextUtils.isEmpty(d76Var.c().title)) {
            this.i.setText(d76Var.c().title);
        }
        this.j.setVisibility(8);
        this.k.setVisibility(8);
        this.l.setVisibility(8);
        this.m.setVisibility(8);
        if (d76Var.c().sub_nodes.size() >= 1) {
            this.j.setVisibility(0);
            this.j.setTag(d76Var.c().sub_nodes.get(0).url);
            this.j.setText(d76Var.c().sub_nodes.get(0).title);
        }
        if (d76Var.c().sub_nodes.size() >= 2) {
            this.k.setVisibility(0);
            this.k.setTag(d76Var.c().sub_nodes.get(1).url);
            this.k.setText(d76Var.c().sub_nodes.get(1).title);
        }
        if (d76Var.c().sub_nodes.size() >= 3) {
            this.l.setVisibility(0);
            this.l.setTag(d76Var.c().sub_nodes.get(2).url);
            this.l.setText(d76Var.c().sub_nodes.get(2).title);
        }
        if (d76Var.c().sub_nodes.size() >= 4) {
            this.m.setVisibility(0);
            this.m.setTag(d76Var.c().sub_nodes.get(3).url);
            this.m.setText(d76Var.c().sub_nodes.get(3).title);
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.p = str;
        }
    }
}
