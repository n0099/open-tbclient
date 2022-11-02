package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class yb8 extends z26<ra8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public TbImageView j;
    public TextView k;
    public ImageView l;
    public ra8 m;

    @Override // com.baidu.tieba.z26
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d073a : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yb8(TbPageContext<?> tbPageContext) {
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
        View k = k();
        this.i = k;
        this.j = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f091a69);
        this.k = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091a68);
        this.l = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f091a6a);
        this.i.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.z26
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) != null) || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
        SkinManager.setImageResource(this.l, R.drawable.obfuscated_res_0x7f08090f, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && this.i == view2) {
            MessageManager messageManager = MessageManager.getInstance();
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.c);
            ra8 ra8Var = this.m;
            messageManager.sendMessage(new CustomMessage(2004001, pbActivityConfig.createNormalCfg(ra8Var.c, ra8Var.d, "person_page")));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.z26
    /* renamed from: r */
    public void l(ra8 ra8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, ra8Var) != null) || ra8Var == null) {
            return;
        }
        this.m = ra8Var;
        this.j.K(ra8Var.a, 10, false);
        this.k.setText(ra8Var.b);
        m(this.b, TbadkCoreApplication.getInst().getSkinType());
    }
}
