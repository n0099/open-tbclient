package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbCornersImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nj8 implements oj8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;
    public FrameLayout b;
    public FrameLayout c;
    public HeadImageView d;
    public TbCornersImageView e;
    public BarImageView f;
    public RelativeLayout g;
    public TextView h;
    public TextView i;
    public TextView j;
    public LinearLayout k;
    public TextView l;
    public nj8 m;

    @Override // com.baidu.tieba.oj8
    public void a(@NonNull jk8 jk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jk8Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948004493, "Lcom/baidu/tieba/nj8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948004493, "Lcom/baidu/tieba/nj8;");
                return;
            }
        }
        n = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds4);
        o = yi.g(TbadkApplication.getInst(), R.dimen.tbds450);
    }

    public nj8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.oj8
    public HeadImageView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.m.d;
        }
        return (HeadImageView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oj8
    public TextView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.m.l;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oj8
    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.m.i;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oj8
    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.m.j;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oj8
    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.m.h;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oj8
    public FrameLayout g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.m.c;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oj8
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return o;
        }
        return invokeV.intValue;
    }

    public static nj8 k(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            nj8 nj8Var = new nj8();
            nj8Var.c = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e86);
            nj8Var.a = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e82);
            nj8Var.b = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090ea7);
            nj8Var.d = (HeadImageView) view2.findViewById(R.id.chat_head);
            nj8Var.e = (TbCornersImageView) view2.findViewById(R.id.svg_head);
            nj8Var.f = (BarImageView) view2.findViewById(R.id.forum_head);
            nj8Var.g = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e73);
            nj8Var.h = (TextView) view2.findViewById(R.id.chat_name);
            nj8Var.i = (TextView) view2.findViewById(R.id.last_chat_content);
            nj8Var.j = (TextView) view2.findViewById(R.id.new_message);
            nj8Var.k = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e75);
            nj8Var.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906ab);
            nj8Var.m = nj8Var;
            return nj8Var;
        }
        return (nj8) invokeL.objValue;
    }

    @Override // com.baidu.tieba.oj8
    public void h(@NonNull jk8 jk8Var) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jk8Var) == null) {
            d85 d = d85.d(this.m.h);
            d.C(R.dimen.T_X07);
            d.D(R.string.F_X01);
            d.x(R.color.CAM_X0105);
            if (jk8Var.a() != null && jk8Var.a().isLocationScrolled()) {
                i = R.color.CAM_X0313;
                i2 = R.string.A_X03;
            } else {
                i = R.color.CAM_X0201;
                i2 = R.string.A_X06;
            }
            d85 d2 = d85.d(this.m.a);
            d2.o(R.string.J_X06);
            d2.e(i2);
            d2.f(i);
            d85 d3 = d85.d(this.m.j);
            d3.C(R.dimen.T_X10);
            d3.D(R.string.F_X01);
            d3.x(R.color.CAM_X0108);
            d85 d4 = d85.d(this.m.i);
            d4.x(R.color.CAM_X0108);
            d4.C(R.dimen.T_X08);
            this.m.d.setBorderWidth(n);
            this.m.d.setBorderColor(SkinManager.getColor(R.color.CAM_X0211));
            this.m.d.setIsRound(true);
            this.m.d.setDrawBorder(true);
            this.m.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.m.d.setPlaceHolder(1);
            this.m.d.setDrawBorder(true);
            d85 d5 = d85.d(this.m.l);
            d5.C(R.dimen.T_X08);
            d5.D(R.string.F_X01);
            d5.x(R.color.CAM_X0301);
        }
    }

    @Override // com.baidu.tieba.oj8
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.m.i.setMaxLines(1);
            this.m.i.setEllipsize(TextUtils.TruncateAt.END);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, R.id.chat_name);
            layoutParams.topMargin = yi.g(TbadkApplication.getInst(), R.dimen.M_H_X001);
            layoutParams.bottomMargin = yi.g(TbadkApplication.getInst(), R.dimen.M_H_X001);
            layoutParams.rightMargin = yi.g(TbadkApplication.getInst(), R.dimen.tbds162);
            this.m.k.setLayoutParams(layoutParams);
        }
    }
}
