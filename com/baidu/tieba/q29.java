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
public class q29 implements j29 {
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
    public TextView g;
    public TextView h;
    public LinearLayout i;
    public TextView j;
    public TextView k;
    public LinearLayout l;
    public q29 m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948040081, "Lcom/baidu/tieba/q29;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948040081, "Lcom/baidu/tieba/q29;");
                return;
            }
        }
        n = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.L_X01);
        o = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds642);
    }

    public q29() {
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

    @Override // com.baidu.tieba.j29
    public HeadImageView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.m.d;
        }
        return (HeadImageView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j29
    public TextView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.m.j;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j29
    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.m.h;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j29
    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.m.k;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j29
    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.m.g;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j29
    public FrameLayout g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.m.c;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j29
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return o;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.j29
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.m.h.setMaxLines(1);
            this.m.h.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public static q29 k(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            q29 q29Var = new q29();
            q29Var.c = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0918e4);
            q29Var.a = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0918e2);
            q29Var.b = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0918e1);
            q29Var.d = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0918de);
            q29Var.e = (TbCornersImageView) view2.findViewById(R.id.obfuscated_res_0x7f0918e9);
            q29Var.f = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f0918e0);
            q29Var.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0918e5);
            q29Var.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0918e3);
            q29Var.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0918e6);
            q29Var.l = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0918e7);
            q29Var.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0918df);
            q29Var.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0918dc);
            q29Var.m = q29Var;
            return q29Var;
        }
        return (q29) invokeL.objValue;
    }

    @Override // com.baidu.tieba.j29
    public void a(@NonNull e39 e39Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, e39Var) == null) && e39Var.a() != null && e39Var.a().getUnreadNum() > 0) {
            if (e39Var.a().getUnreadNum() < 10) {
                i = R.drawable.icon_news_gray_dot_one_number;
            } else if (e39Var.a().getUnreadNum() < 100) {
                i = R.drawable.icon_news_gray_dot_two_number;
            } else {
                i = R.drawable.icon_news_gray_dot_three_number;
            }
            this.k.setBackgroundResource(i);
        }
    }

    public void l(@NonNull e39 e39Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, e39Var) == null) && e39Var.a() != null && e39Var.a().getUnreadNum() > 0) {
            if (e39Var.a().getUnreadNum() < 10) {
                i = R.drawable.icon_news_gray_dot_one_number_2;
            } else if (e39Var.a().getUnreadNum() < 100) {
                i = R.drawable.icon_news_gray_dot_two_number_2;
            } else {
                i = R.drawable.icon_news_gray_dot_three_number_2;
            }
            this.k.setBackgroundResource(i);
        }
    }

    @Override // com.baidu.tieba.j29
    public void h(@NonNull e39 e39Var) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, e39Var) == null) {
            EMManager.from(this.m.g).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0105);
            if (e39Var.a() != null && e39Var.a().isLocationScrolled()) {
                i = R.color.CAM_X0313;
                i2 = R.string.A_X03;
            } else {
                i = R.color.CAM_X0201;
                i2 = R.string.A_X06;
            }
            EMManager.from(this.m.a).setAlpha(i2).setBackGroundColor(i);
            EMManager.from(this.m.c).setBackGroundColor(i);
            EMManager.from(this.m.h).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            this.m.d.setIsRound(true);
            this.m.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.m.d.setPlaceHolder(1);
            this.m.d.setBorderWidth(n);
            this.m.d.setBorderColor(SkinManager.getColor(R.color.CAM_X0213));
            this.m.d.setDrawBorder(false);
            EMManager.from(this.m.j).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0301);
            EMManager.from(this.m.k).setTextSize(R.dimen.T_X10).setTextColor(R.color.CAM_X0101);
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                a(e39Var);
            } else {
                l(e39Var);
            }
        }
    }
}
