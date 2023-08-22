package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class sb6 extends ln6<jb6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView i;
    public TextView j;
    public TbImageView k;
    public TbImageView l;
    public View m;
    public jb6 n;

    @Override // com.baidu.tieba.ln6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0955 : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sb6(TbPageContext tbPageContext, ViewGroup viewGroup) {
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
        this.m = h();
        this.i = (TextView) h().findViewById(R.id.obfuscated_res_0x7f091041);
        this.j = (TextView) h().findViewById(R.id.obfuscated_res_0x7f091040);
        this.k = (TbImageView) h().findViewById(R.id.obfuscated_res_0x7f09103f);
        TbImageView tbImageView = (TbImageView) h().findViewById(R.id.obfuscated_res_0x7f09103e);
        this.l = tbImageView;
        tbImageView.setAutoChangeStyle(true);
        this.l.setDefaultResource(17170445);
        this.l.setDefaultBgResource(17170445);
        this.k.setOnClickListener(this);
        this.j.setOnClickListener(this);
        j(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && e() != null) {
            e().a(view2, this.n);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln6
    /* renamed from: r */
    public void i(jb6 jb6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jb6Var) == null) {
            this.n = jb6Var;
        }
    }

    @Override // com.baidu.tieba.ln6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundResource(this.m, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0101);
            SkinManager.setImageResource(this.k, R.drawable.icon_tab_live_close_n);
            SkinManager.setBackgroundResource(this.j, R.drawable.tab_sub_notification_btn_bg_selecor);
            SkinManager.setImageResource(this.l, R.drawable.obfuscated_res_0x7f080352);
        }
    }
}
