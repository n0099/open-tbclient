package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.view.TbImageAutoSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class y19 implements g29 {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static int B;
    public static int C;
    public static int D;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;
    public RelativeLayout b;
    public NavigationBar c;
    public ImageView d;
    public RelativeLayout e;
    public View f;
    public LinearLayout g;
    public TextView h;
    public TextView i;
    public ImageView j;
    public RecyclerView k;
    public View l;
    public View m;
    public View n;
    public TextView o;
    public LinearLayout p;
    public ImageView q;
    public EMTextView r;
    public LinearLayout s;
    public ImageView t;
    public EMTextView u;
    public RelativeLayout v;
    public RelativeLayout w;
    public RelativeLayout x;
    public TbImageAutoSwitch y;
    public HeadImageView z;

    @Override // com.baidu.tieba.g29
    public void d(@NonNull String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, str, j) == null) {
        }
    }

    @Override // com.baidu.tieba.g29
    public TextView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g29
    public LinearLayout u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return null;
        }
        return (LinearLayout) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948277448, "Lcom/baidu/tieba/y19;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948277448, "Lcom/baidu/tieba/y19;");
                return;
            }
        }
        A = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds600);
        B = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds56);
        C = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2);
        D = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds20);
    }

    public y19() {
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

    @Override // com.baidu.tieba.g29
    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g29
    public LinearLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g29
    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g29
    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g29
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return D;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.g29
    public HeadImageView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.z;
        }
        return (HeadImageView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g29
    @NonNull
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return C;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.g29
    @NonNull
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return B;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.g29
    public LinearLayout k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.s;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g29
    public LinearLayout l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.p;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g29
    public RelativeLayout m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.w;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g29
    @Nullable
    public RecyclerView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.k;
        }
        return (RecyclerView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g29
    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return A;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.g29
    public RelativeLayout p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.e;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g29
    public RelativeLayout r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.v;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g29
    public TbImageAutoSwitch s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.y;
        }
        return (TbImageAutoSwitch) invokeV.objValue;
    }

    public static y19 v(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            GreyUtil.grey(view2);
            y19 y19Var = new y19();
            y19Var.a = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090f07);
            y19Var.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090f27);
            y19Var.e = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090f0a);
            y19Var.f = view2.findViewById(R.id.obfuscated_res_0x7f090f66);
            y19Var.c = (NavigationBar) view2.findViewById(R.id.obfuscated_res_0x7f090f19);
            y19Var.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f0c);
            y19Var.v = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a5d);
            y19Var.w = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a68);
            y19Var.l = view2.findViewById(R.id.obfuscated_res_0x7f090f28);
            y19Var.j = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f24);
            y19Var.m = view2.findViewById(R.id.obfuscated_res_0x7f09121b);
            y19Var.n = view2.findViewById(R.id.obfuscated_res_0x7f09160b);
            y19Var.k = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090f09);
            y19Var.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f16);
            y19Var.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090f01);
            y19Var.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cea);
            y19Var.p = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09085b);
            y19Var.q = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09085d);
            y19Var.r = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f09085c);
            y19Var.s = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09178e);
            y19Var.t = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091790);
            y19Var.u = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f09178f);
            y19Var.x = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0907d2);
            y19Var.y = (TbImageAutoSwitch) view2.findViewById(R.id.obfuscated_res_0x7f0907d3);
            y19Var.z = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0907d7);
            w(y19Var);
            return y19Var;
        }
        return (y19) invokeL.objValue;
    }

    @Override // com.baidu.tieba.g29
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            EMManager.from(this.a).setCorner(R.string.deprecated_J_X18);
            EMManager.from(this.l).setCardType(0).setCorner(R.string.J_X03).setBackGroundColor(R.color.CAM_X0618);
            EMManager.from(this.m).setCorner(R.string.deprecated_J_X18).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.h).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X04).setTextStyle(R.string.F_X02);
            EMManager.from(this.i).setTextColor(R.color.CAM_X0102).setTextSize(R.dimen.T_X12).setTextStyle(R.string.F_X01);
            EMManager.from(this.b).setCorner(R.string.deprecated_J_X18);
            SkinManager.setBackgroundResource(this.j, R.drawable.obfuscated_res_0x7f080731);
            EMManager.from(this.e).setCorner(R.string.deprecated_J_X18);
            EMManager.from(this.o).setTextSize(R.dimen.T_X07).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.r).setTextSize(R.dimen.T_X12).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.u).setTextSize(R.dimen.T_X12).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.q, R.drawable.obfuscated_res_0x7f08056e, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
            WebPManager.setPureDrawable(this.t, R.drawable.obfuscated_res_0x7f080fc6, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
            if (this.d != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.d, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public static void w(y19 y19Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, y19Var) == null) {
            if (y19Var.f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) y19Var.f.getLayoutParams();
                marginLayoutParams.setMargins(0, 0, 0, -UtilHelper.getDimenPixelSize(R.dimen.tbds43));
                y19Var.f.setLayoutParams(marginLayoutParams);
            }
            if (UbsABTestHelper.isNewFrs()) {
                y19Var.c.setVisibility(0);
                y19Var.d = (ImageView) y19Var.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
                y19Var.l.setVisibility(8);
                if (y19Var.b.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) y19Var.b.getLayoutParams();
                    marginLayoutParams2.setMargins(0, 0, 0, 0);
                    y19Var.b.setLayoutParams(marginLayoutParams2);
                    return;
                }
                return;
            }
            y19Var.c.setVisibility(8);
            y19Var.l.setVisibility(0);
            if (y19Var.b.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) y19Var.b.getLayoutParams();
                marginLayoutParams3.setMargins(0, UtilHelper.getDimenPixelSize(R.dimen.tbds50), 0, 0);
                y19Var.b.setLayoutParams(marginLayoutParams3);
            }
        }
    }

    @Override // com.baidu.tieba.g29
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.n.getLayoutParams().height = i;
        }
    }

    @Override // com.baidu.tieba.g29
    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.m.getLayoutParams().height = i;
        }
    }
}
