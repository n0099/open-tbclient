package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wf6 extends mn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context b;
    public View c;
    public ImageView d;
    public TextView e;
    public View f;
    public View g;
    public View.OnClickListener h;

    public wf6(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = context;
    }

    public void f(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.h = onClickListener;
        }
    }

    @Override // com.baidu.tieba.mn
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d00fa, (ViewGroup) null);
            this.c = inflate;
            this.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0901f0);
            this.d = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0901ef);
            this.f = this.c.findViewById(R.id.obfuscated_res_0x7f0901f1);
            this.g = this.c.findViewById(R.id.obfuscated_res_0x7f0901ee);
            e(TbadkCoreApplication.getInst().getSkinType());
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mn
    public void d() {
        View.OnClickListener onClickListener;
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (onClickListener = this.h) != null && (view2 = this.c) != null) {
            onClickListener.onClick(view2);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            View view2 = this.c;
            if (view2 != null) {
                SkinManager.setBackgroundResource(view2, R.drawable.addresslist_item_bg);
            }
            TextView textView = this.e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0304);
            }
            ImageView imageView = this.d;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.icon_inf_arrowblue_n);
            }
            View view3 = this.f;
            if (view3 != null) {
                SkinManager.setBackgroundResource(view3, R.color.CAM_X0204);
            }
            View view4 = this.g;
            if (view4 != null) {
                SkinManager.setBackgroundResource(view4, R.color.CAM_X0204);
            }
        }
    }
}
