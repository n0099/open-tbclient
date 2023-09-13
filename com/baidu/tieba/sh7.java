package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class sh7 extends no6<nh7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BarImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public int m;
    public nh7 n;
    public View.OnClickListener o;

    @Override // com.baidu.tieba.no6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d031b : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sh7(TbPageContext<?> tbPageContext) {
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
        this.m = 3;
        this.i = (BarImageView) h().findViewById(R.id.forum_avatar);
        this.j = (TextView) h().findViewById(R.id.forum_name);
        this.k = (TextView) h().findViewById(R.id.obfuscated_res_0x7f090bb6);
        this.l = (TextView) h().findViewById(R.id.obfuscated_res_0x7f090c28);
        h().setOnClickListener(this);
        j(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.no6
    /* renamed from: r */
    public void i(nh7 nh7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, nh7Var) != null) || nh7Var == null) {
            return;
        }
        this.n = nh7Var;
        this.i.startLoad(nh7Var.c(), 10, false);
        this.j.setText(s(nh7Var.f(), nh7Var.i()));
        this.k.setText(String.format(this.b.getString(R.string.obfuscated_res_0x7f0f04b8), nh7Var.d()));
        this.l.setText(String.format(this.b.getString(R.string.obfuscated_res_0x7f0f1327), nh7Var.h()));
        j(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, view2) != null) || this.n == null) {
            return;
        }
        TiebaStatic.log("c12261");
        lh7.d(this.n.i());
        view2.setTag(this.n);
        View.OnClickListener onClickListener = this.o;
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
    }

    public void t(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    @Override // com.baidu.tieba.no6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) != null) || this.m == i) {
            return;
        }
        SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
        SkinManager.setBackgroundResource(h(), R.drawable.square_search_item_bg);
        this.m = i;
    }

    public SpannableStringBuilder s(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                String trim = str2.trim();
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                int indexOf = str.indexOf(trim);
                if (indexOf != -1) {
                    spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, trim.length() + indexOf, 33);
                }
                return spannableStringBuilder;
            }
            return null;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }
}
