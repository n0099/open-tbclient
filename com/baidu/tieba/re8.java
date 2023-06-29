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
public class re8 implements se8 {
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
    public re8 m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948118852, "Lcom/baidu/tieba/re8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948118852, "Lcom/baidu/tieba/re8;");
                return;
            }
        }
        n = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds4);
        o = xi.g(TbadkApplication.getInst(), R.dimen.tbds450);
    }

    public re8() {
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

    @Override // com.baidu.tieba.se8
    public HeadImageView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.m.d;
        }
        return (HeadImageView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.se8
    public TextView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.m.l;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.se8
    public TextView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.m.i;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.se8
    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.m.j;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.se8
    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.m.h;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.se8
    public FrameLayout f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.m.c;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.se8
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return o;
        }
        return invokeV.intValue;
    }

    public static re8 j(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            re8 re8Var = new re8();
            re8Var.c = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e77);
            re8Var.a = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e73);
            re8Var.b = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e98);
            re8Var.d = (HeadImageView) view2.findViewById(R.id.chat_head);
            re8Var.e = (TbCornersImageView) view2.findViewById(R.id.svg_head);
            re8Var.f = (BarImageView) view2.findViewById(R.id.forum_head);
            re8Var.g = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e65);
            re8Var.h = (TextView) view2.findViewById(R.id.chat_name);
            re8Var.i = (TextView) view2.findViewById(R.id.last_chat_content);
            re8Var.j = (TextView) view2.findViewById(R.id.new_message);
            re8Var.k = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e67);
            re8Var.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906a9);
            re8Var.m = re8Var;
            return re8Var;
        }
        return (re8) invokeL.objValue;
    }

    @Override // com.baidu.tieba.se8
    public void g(@NonNull kf8 kf8Var) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, kf8Var) == null) {
            s75 d = s75.d(this.m.h);
            d.C(R.dimen.T_X07);
            d.D(R.string.F_X01);
            d.x(R.color.CAM_X0105);
            if (kf8Var.a() != null && kf8Var.a().isLocationScrolled()) {
                i = R.color.CAM_X0313;
                i2 = R.string.A_X03;
            } else {
                i = R.color.CAM_X0201;
                i2 = R.string.A_X06;
            }
            s75 d2 = s75.d(this.m.a);
            d2.o(R.string.J_X06);
            d2.e(i2);
            d2.f(i);
            s75 d3 = s75.d(this.m.j);
            d3.C(R.dimen.T_X10);
            d3.D(R.string.F_X01);
            d3.x(R.color.CAM_X0108);
            s75 d4 = s75.d(this.m.i);
            d4.x(R.color.CAM_X0108);
            d4.C(R.dimen.T_X08);
            this.m.d.setBorderWidth(n);
            this.m.d.setBorderColor(SkinManager.getColor(R.color.CAM_X0211));
            this.m.d.setIsRound(true);
            this.m.d.setDrawBorder(true);
            this.m.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.m.d.setPlaceHolder(1);
            this.m.d.setDrawBorder(true);
            s75 d5 = s75.d(this.m.l);
            d5.C(R.dimen.T_X08);
            d5.D(R.string.F_X01);
            d5.x(R.color.CAM_X0301);
        }
    }

    @Override // com.baidu.tieba.se8
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.m.i.setMaxLines(1);
            this.m.i.setEllipsize(TextUtils.TruncateAt.END);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, R.id.chat_name);
            layoutParams.topMargin = xi.g(TbadkApplication.getInst(), R.dimen.M_H_X001);
            layoutParams.bottomMargin = xi.g(TbadkApplication.getInst(), R.dimen.M_H_X001);
            layoutParams.rightMargin = xi.g(TbadkApplication.getInst(), R.dimen.tbds162);
            this.m.k.setLayoutParams(layoutParams);
        }
    }
}
