package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class oi6 extends wo6<gh6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public TextView j;
    public TextView k;
    public HeadImageView l;
    public HeadImageView m;
    public HeadImageView n;
    public ImageView o;

    @Override // com.baidu.tieba.wo6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d010b : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wo6
    /* renamed from: t */
    public void i(gh6 gh6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gh6Var) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oi6(TbPageContext<?> tbPageContext) {
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
        s(h());
    }

    public void u(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && (textView = this.k) != null) {
            textView.setText(str);
        }
    }

    public void x(int i) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (imageView = this.o) != null) {
            imageView.setVisibility(i);
        }
    }

    public void y(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && (view2 = this.i) != null) {
            view2.setVisibility(i);
        }
    }

    public void z(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && (textView = this.j) != null) {
            textView.setText(str);
        }
    }

    @Override // com.baidu.tieba.wo6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (i == 1) {
                this.o.setAlpha(0.7f);
            } else {
                this.o.setAlpha(1);
            }
            this.i.setBackgroundColor(SkinManager.getColor(i, (int) R.color.CAM_X0204));
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
        }
    }

    public TextView r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TextView textView = this.k;
            if (textView != null) {
                return textView;
            }
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final void s(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f09021e);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09021f);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09021d);
            this.o = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090219);
            this.l = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f09021a);
            this.m = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f09021b);
            this.n = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f09021c);
        }
    }
}
