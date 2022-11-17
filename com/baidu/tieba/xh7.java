package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class xh7 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public TextView b;
    public TextView c;
    public ImageView d;
    public TextView e;
    public ImageView f;
    public TextView g;
    public int h;
    public int i;
    public int j;

    public xh7(Context context) {
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
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0492, (ViewGroup) null);
        this.a = viewGroup;
        this.b = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090635);
        this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091bef);
        this.d = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0914cf);
        this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0914d0);
        this.f = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0909d1);
        this.g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0909d2);
        this.d.setOnClickListener(this);
        this.f.setOnClickListener(this);
        c();
    }

    public ViewGroup a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
            SkinManager.setImageResource(this.d, R.drawable.img_lable_boy_n);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
            SkinManager.setImageResource(this.f, R.drawable.img_lable_girl_n);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0109);
        }
    }

    public void d(List<uh7> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && ListUtils.getCount(list) == 2) {
            this.h = list.get(0).a;
            this.i = list.get(1).a;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            boolean z = false;
            if (view2 == this.d) {
                z = true;
            } else {
                ImageView imageView = this.f;
            }
            if (z) {
                i = this.h;
            } else {
                i = this.i;
            }
            this.j = i;
            ImageView imageView2 = this.d;
            if (z) {
                i2 = R.drawable.img_lable_boy_s;
            } else {
                i2 = R.drawable.img_lable_boy_n;
            }
            SkinManager.setImageResource(imageView2, i2);
            TextView textView = this.e;
            int i5 = R.color.CAM_X0109;
            if (z) {
                i3 = R.color.CAM_X0302;
            } else {
                i3 = R.color.CAM_X0109;
            }
            SkinManager.setViewTextColor(textView, i3);
            ImageView imageView3 = this.f;
            if (z) {
                i4 = R.drawable.img_lable_girl_n;
            } else {
                i4 = R.drawable.img_lable_girl_s;
            }
            SkinManager.setImageResource(imageView3, i4);
            TextView textView2 = this.g;
            if (!z) {
                i5 = R.color.CAM_X0301;
            }
            SkinManager.setViewTextColor(textView2, i5);
        }
    }
}
