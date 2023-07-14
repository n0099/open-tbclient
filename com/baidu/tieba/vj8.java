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
/* loaded from: classes8.dex */
public class vj8 implements oj8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int o;
    public static final int p;
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
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public LinearLayout m;
    public vj8 n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948242821, "Lcom/baidu/tieba/vj8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948242821, "Lcom/baidu/tieba/vj8;");
                return;
            }
        }
        o = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.L_X01);
        p = yi.g(TbadkApplication.getInst(), R.dimen.tbds642);
    }

    public vj8() {
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
            return this.n.d;
        }
        return (HeadImageView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oj8
    public TextView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.n.k;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oj8
    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.n.i;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oj8
    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.n.l;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oj8
    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n.h;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oj8
    public FrameLayout g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.n.c;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oj8
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return p;
        }
        return invokeV.intValue;
    }

    public static vj8 k(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            vj8 vj8Var = new vj8();
            vj8Var.c = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917d9);
            vj8Var.a = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917d7);
            vj8Var.b = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917d6);
            vj8Var.d = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917d3);
            vj8Var.e = (TbCornersImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917de);
            vj8Var.f = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917d5);
            vj8Var.g = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917d2);
            vj8Var.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917da);
            vj8Var.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917d8);
            vj8Var.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917db);
            vj8Var.m = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917dc);
            vj8Var.j = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917d4);
            vj8Var.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917d1);
            vj8Var.n = vj8Var;
            return vj8Var;
        }
        return (vj8) invokeL.objValue;
    }

    @Override // com.baidu.tieba.oj8
    public void a(@NonNull jk8 jk8Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jk8Var) == null) && jk8Var.a() != null && jk8Var.a().getUnreadNum() > 0) {
            if (jk8Var.a().getUnreadNum() < 10) {
                i = R.drawable.icon_news_gray_dot_one_number;
            } else if (jk8Var.a().getUnreadNum() < 100) {
                i = R.drawable.icon_news_gray_dot_two_number;
            } else {
                i = R.drawable.icon_news_gray_dot_three_number;
            }
            this.l.setBackgroundResource(i);
        }
    }

    public void l(@NonNull jk8 jk8Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jk8Var) == null) && jk8Var.a() != null && jk8Var.a().getUnreadNum() > 0) {
            if (jk8Var.a().getUnreadNum() < 10) {
                i = R.drawable.icon_news_gray_dot_one_number_2;
            } else if (jk8Var.a().getUnreadNum() < 100) {
                i = R.drawable.icon_news_gray_dot_two_number_2;
            } else {
                i = R.drawable.icon_news_gray_dot_three_number_2;
            }
            this.l.setBackgroundResource(i);
        }
    }

    @Override // com.baidu.tieba.oj8
    public void h(@NonNull jk8 jk8Var) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jk8Var) == null) {
            d85 d = d85.d(this.n.h);
            d.C(R.dimen.T_X05);
            d.D(R.string.F_X01);
            d.x(R.color.CAM_X0105);
            if (jk8Var.a() != null && jk8Var.a().isLocationScrolled()) {
                i = R.color.CAM_X0313;
                i2 = R.string.A_X03;
            } else {
                i = R.color.CAM_X0201;
                i2 = R.string.A_X06;
            }
            d85 d2 = d85.d(this.n.a);
            d2.e(i2);
            d2.f(i);
            d85.d(this.n.c).f(i);
            d85 d3 = d85.d(this.n.i);
            d3.x(R.color.CAM_X0109);
            d3.C(R.dimen.tbds36);
            d3.D(R.string.F_X01);
            this.n.d.setIsRound(true);
            this.n.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.n.d.setPlaceHolder(1);
            this.n.d.setBorderWidth(o);
            this.n.d.setBorderColor(SkinManager.getColor(R.color.CAM_X0213));
            this.n.d.setDrawBorder(true);
            this.n.d.setDrawBorder(true);
            d85 d4 = d85.d(this.n.k);
            d4.C(R.dimen.tbds36);
            d4.D(R.string.F_X01);
            d4.x(R.color.CAM_X0301);
            d85 d5 = d85.d(this.n.l);
            d5.C(R.dimen.T_X10);
            d5.x(R.color.CAM_X0101);
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                a(jk8Var);
            } else {
                l(jk8Var);
            }
        }
    }

    @Override // com.baidu.tieba.oj8
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.n.i.setMaxLines(1);
            this.n.i.setEllipsize(TextUtils.TruncateAt.END);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f0917da);
            layoutParams.topMargin = yi.g(TbadkApplication.getInst(), R.dimen.tbds15);
            layoutParams.bottomMargin = yi.g(TbadkApplication.getInst(), R.dimen.M_H_X004);
            layoutParams.rightMargin = yi.g(TbadkApplication.getInst(), R.dimen.tbds39);
            this.n.j.setLayoutParams(layoutParams);
        }
    }
}
