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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
public class pm8 implements im8 {
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
    public pm8 n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948066958, "Lcom/baidu/tieba/pm8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948066958, "Lcom/baidu/tieba/pm8;");
                return;
            }
        }
        o = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.L_X01);
        p = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds642);
    }

    public pm8() {
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

    @Override // com.baidu.tieba.im8
    public HeadImageView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.n.d;
        }
        return (HeadImageView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im8
    public TextView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.n.k;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im8
    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.n.i;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im8
    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.n.l;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im8
    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n.h;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im8
    public FrameLayout g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.n.c;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im8
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return p;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.im8
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.n.i.setMaxLines(1);
            this.n.i.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public static pm8 k(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            pm8 pm8Var = new pm8();
            pm8Var.c = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091825);
            pm8Var.a = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091823);
            pm8Var.b = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091822);
            pm8Var.d = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f09181f);
            pm8Var.e = (TbCornersImageView) view2.findViewById(R.id.obfuscated_res_0x7f09182a);
            pm8Var.f = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f091821);
            pm8Var.g = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09181e);
            pm8Var.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091826);
            pm8Var.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091824);
            pm8Var.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091827);
            pm8Var.m = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091828);
            pm8Var.j = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091820);
            pm8Var.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09181d);
            pm8Var.n = pm8Var;
            return pm8Var;
        }
        return (pm8) invokeL.objValue;
    }

    @Override // com.baidu.tieba.im8
    public void a(@NonNull dn8 dn8Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, dn8Var) == null) && dn8Var.a() != null && dn8Var.a().getUnreadNum() > 0) {
            if (dn8Var.a().getUnreadNum() < 10) {
                i = R.drawable.icon_news_gray_dot_one_number;
            } else if (dn8Var.a().getUnreadNum() < 100) {
                i = R.drawable.icon_news_gray_dot_two_number;
            } else {
                i = R.drawable.icon_news_gray_dot_three_number;
            }
            this.l.setBackgroundResource(i);
        }
    }

    public void l(@NonNull dn8 dn8Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, dn8Var) == null) && dn8Var.a() != null && dn8Var.a().getUnreadNum() > 0) {
            if (dn8Var.a().getUnreadNum() < 10) {
                i = R.drawable.icon_news_gray_dot_one_number_2;
            } else if (dn8Var.a().getUnreadNum() < 100) {
                i = R.drawable.icon_news_gray_dot_two_number_2;
            } else {
                i = R.drawable.icon_news_gray_dot_three_number_2;
            }
            this.l.setBackgroundResource(i);
        }
    }

    @Override // com.baidu.tieba.im8
    public void h(@NonNull dn8 dn8Var) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dn8Var) == null) {
            EMManager.from(this.n.h).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0105);
            if (dn8Var.a() != null && dn8Var.a().isLocationScrolled()) {
                i = R.color.CAM_X0313;
                i2 = R.string.A_X03;
            } else {
                i = R.color.CAM_X0201;
                i2 = R.string.A_X06;
            }
            EMManager.from(this.n.a).setAlpha(i2).setBackGroundColor(i);
            EMManager.from(this.n.c).setBackGroundColor(i);
            EMManager.from(this.n.i).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            this.n.d.setIsRound(true);
            this.n.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.n.d.setPlaceHolder(1);
            this.n.d.setBorderWidth(o);
            this.n.d.setBorderColor(SkinManager.getColor(R.color.CAM_X0213));
            this.n.d.setDrawBorder(false);
            EMManager.from(this.n.k).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0301);
            EMManager.from(this.n.l).setTextSize(R.dimen.T_X10).setTextColor(R.color.CAM_X0101);
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                a(dn8Var);
            } else {
                l(dn8Var);
            }
        }
    }
}
