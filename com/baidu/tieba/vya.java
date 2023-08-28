package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vya extends uya {
    public static /* synthetic */ Interceptable $ic;
    public static int g;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vya(BdPageContext bdPageContext) {
        super(bdPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        g = bdPageContext.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07041c);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0107);
            this.c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
            this.d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
            this.f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
            this.e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
            this.c.setCompoundDrawablePadding(g);
            this.d.setCompoundDrawablePadding(g);
            this.f.setCompoundDrawablePadding(g);
            this.e.setCompoundDrawablePadding(g);
        }
    }

    @Override // com.baidu.tieba.uya
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0802, (ViewGroup) null);
            this.b = inflate;
            this.c = (TextView) inflate.findViewById(R.id.rotate_left);
            this.d = (TextView) this.b.findViewById(R.id.rotate_right);
            this.e = (TextView) this.b.findViewById(R.id.rotate_left_right);
            this.f = (TextView) this.b.findViewById(R.id.rotate_up_down);
        }
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.c.setTag(0);
            this.d.setTag(1);
            this.e.setTag(2);
            this.f.setTag(3);
            this.c.setOnClickListener(onClickListener);
            this.d.setOnClickListener(onClickListener);
            this.e.setOnClickListener(onClickListener);
            this.f.setOnClickListener(onClickListener);
        }
    }
}
