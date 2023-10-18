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
/* loaded from: classes9.dex */
public class zl8 implements sl8 {
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
    public zl8 n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948363907, "Lcom/baidu/tieba/zl8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948363907, "Lcom/baidu/tieba/zl8;");
                return;
            }
        }
        o = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.L_X01);
        p = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds642);
    }

    public zl8() {
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

    @Override // com.baidu.tieba.sl8
    public HeadImageView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.n.d;
        }
        return (HeadImageView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sl8
    public TextView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.n.k;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sl8
    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.n.i;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sl8
    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.n.l;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sl8
    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n.h;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sl8
    public FrameLayout g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.n.c;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sl8
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return p;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.sl8
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.n.i.setMaxLines(1);
            this.n.i.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public static zl8 k(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            zl8 zl8Var = new zl8();
            zl8Var.c = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09182f);
            zl8Var.a = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09182d);
            zl8Var.b = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09182c);
            zl8Var.d = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091829);
            zl8Var.e = (TbCornersImageView) view2.findViewById(R.id.obfuscated_res_0x7f091834);
            zl8Var.f = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f09182b);
            zl8Var.g = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091828);
            zl8Var.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091830);
            zl8Var.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09182e);
            zl8Var.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091831);
            zl8Var.m = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091832);
            zl8Var.j = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09182a);
            zl8Var.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091827);
            zl8Var.n = zl8Var;
            return zl8Var;
        }
        return (zl8) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sl8
    public void a(@NonNull nm8 nm8Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, nm8Var) == null) && nm8Var.a() != null && nm8Var.a().getUnreadNum() > 0) {
            if (nm8Var.a().getUnreadNum() < 10) {
                i = R.drawable.icon_news_gray_dot_one_number;
            } else if (nm8Var.a().getUnreadNum() < 100) {
                i = R.drawable.icon_news_gray_dot_two_number;
            } else {
                i = R.drawable.icon_news_gray_dot_three_number;
            }
            this.l.setBackgroundResource(i);
        }
    }

    public void l(@NonNull nm8 nm8Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, nm8Var) == null) && nm8Var.a() != null && nm8Var.a().getUnreadNum() > 0) {
            if (nm8Var.a().getUnreadNum() < 10) {
                i = R.drawable.icon_news_gray_dot_one_number_2;
            } else if (nm8Var.a().getUnreadNum() < 100) {
                i = R.drawable.icon_news_gray_dot_two_number_2;
            } else {
                i = R.drawable.icon_news_gray_dot_three_number_2;
            }
            this.l.setBackgroundResource(i);
        }
    }

    @Override // com.baidu.tieba.sl8
    public void h(@NonNull nm8 nm8Var) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, nm8Var) == null) {
            EMManager.from(this.n.h).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0105);
            if (nm8Var.a() != null && nm8Var.a().isLocationScrolled()) {
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
                a(nm8Var);
            } else {
                l(nm8Var);
            }
        }
    }
}
