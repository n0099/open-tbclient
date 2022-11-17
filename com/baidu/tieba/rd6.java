package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class rd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public View b;
    public ViewGroup c;
    public ImageView d;
    public TextView e;
    public TextView f;

    public rd6(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0677, (ViewGroup) null);
        this.b = inflate;
        this.c = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f090fd5);
        this.d = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090eba);
        this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090da6);
        this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090da7);
        this.e.setText(R.string.obfuscated_res_0x7f0f0cb0);
        this.f.setText(R.string.obfuscated_res_0x7f0f0cb1);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setImageResource(this.d, R.drawable.cp_mask_attention_a);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0109);
            TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0206).tlRadius(yi.g(this.a.getPageActivity(), R.dimen.tbds21)).trRadius(yi.g(this.a.getPageActivity(), R.dimen.tbds21)).blRadius(yi.g(this.a.getPageActivity(), R.dimen.tbds21)).brRadius(yi.g(this.a.getPageActivity(), R.dimen.tbds21)).into(this.c);
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }
}
